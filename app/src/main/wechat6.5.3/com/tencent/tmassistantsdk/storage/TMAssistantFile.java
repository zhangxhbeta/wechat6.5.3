package com.tencent.tmassistantsdk.storage;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidParameterException;

public class TMAssistantFile {
    protected static final int DataBufferMaxLen = 16384;
    protected static final String TAG = "TMAssistantFile";
    protected int mDataBufferDataLen = 0;
    protected long mFileDataLen = 0;
    protected FileOutputStream mFileOutputStream = null;
    protected String mFinalFileName = null;
    protected String mTempFileName = null;
    protected byte[] mWriteDataBuffer = null;

    public TMAssistantFile(String str, String str2) {
        this.mTempFileName = str;
        this.mFinalFileName = str2;
        this.mFileDataLen = length();
    }

    public void deleteTempFile() {
        String tmpFilePath = getTmpFilePath(this.mTempFileName);
        TMLog.i(TAG, "deleteFile 1 tmpFilePathString: " + tmpFilePath);
        if (!TextUtils.isEmpty(tmpFilePath)) {
            File file = new File(tmpFilePath);
            TMLog.i(TAG, "deleteFile 2 file: " + file);
            if (file.exists()) {
                TMLog.i(TAG, "deleteFile result:" + file.delete() + ",filename:" + tmpFilePath);
                return;
            }
            TMLog.i(TAG, "deleteFile 3");
        }
    }

    public long length() {
        String saveFilePath = getSaveFilePath(this.mFinalFileName);
        if (saveFilePath == null) {
            return 0;
        }
        File file = new File(saveFilePath);
        if (file.exists()) {
            this.mFileDataLen = file.length();
        } else {
            saveFilePath = getTmpFilePath(this.mTempFileName);
            if (saveFilePath != null) {
                file = new File(saveFilePath);
                if (file.exists()) {
                    this.mFileDataLen = file.length();
                } else {
                    this.mFileDataLen = 0;
                }
            }
        }
        return this.mFileDataLen;
    }

    void ensureFilePath(String str) {
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            throw new InvalidParameterException("fileFullPath is null or the filename.size is zero.");
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf == -1 || str.length() == 1) {
            throw new InvalidParameterException("fileFullPath is not a valid full path. fileName: " + str);
        }
        if (lastIndexOf > 0) {
            str = str.substring(0, lastIndexOf);
        }
        File file = new File(str);
        if (!file.exists()) {
            z = file.mkdirs();
        }
        if (!z) {
            throw new IOException("Failed to create directory. dir: " + str);
        }
    }

    public synchronized boolean write(byte[] bArr, int i, int i2, long j, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (this.mFileOutputStream == null) {
                String tmpFilePath = getTmpFilePath(this.mTempFileName);
                if (tmpFilePath != null) {
                    try {
                        ensureFilePath(tmpFilePath);
                        this.mFileOutputStream = new FileOutputStream(tmpFilePath, true);
                    } catch (Throwable e) {
                        v.a(TAG, e, "", new Object[0]);
                        TMLog.w(TAG, "write failed" + e);
                    }
                } else {
                    TMLog.w(TAG, "write failed tmpFilePathString is null");
                }
            }
            if (this.mWriteDataBuffer == null) {
                this.mWriteDataBuffer = new byte[DataBufferMaxLen];
                this.mDataBufferDataLen = 0;
            }
            z2 = writeData(this.mFileOutputStream, bArr, i, i2, j);
            if (z2) {
                z2 = (z && flush()) ? moveFileFromTmpToSavaPath(getTmpFilePath(this.mTempFileName), getSaveFilePath(this.mFinalFileName)) : true;
            }
        }
        return z2;
    }

    public synchronized boolean flush() {
        boolean z = false;
        synchronized (this) {
            if (this.mFileOutputStream != null && this.mDataBufferDataLen > 0) {
                try {
                    this.mFileOutputStream.write(this.mWriteDataBuffer, 0, this.mDataBufferDataLen);
                    this.mDataBufferDataLen = 0;
                    z = true;
                } catch (Throwable e) {
                    v.a(TAG, e, "", new Object[0]);
                    TMLog.w(TAG, "flush failed " + e);
                }
            }
        }
        return z;
    }

    public synchronized void close() {
        flush();
        try {
            if (this.mFileOutputStream != null) {
                this.mFileOutputStream.close();
            }
        } catch (Throwable e) {
            v.a(TAG, e, "", new Object[0]);
        }
        this.mFileOutputStream = null;
        this.mWriteDataBuffer = null;
        this.mFileDataLen = 0;
    }

    public static String getSaveFilePath(String str) {
        if (str == null) {
            return null;
        }
        String savePathRootDir = getSavePathRootDir();
        if (savePathRootDir != null) {
            return savePathRootDir + File.separator + str;
        }
        return null;
    }

    public String getTmpFilePath(String str) {
        if (str == null) {
            return null;
        }
        String savePathRootDir = getSavePathRootDir();
        if (savePathRootDir != null) {
            return savePathRootDir + "/.tmp/" + str + ".tmp";
        }
        return null;
    }

    public static String getSavePathRootDir() {
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            return null;
        }
        if (isSDCardExistAndCanWrite()) {
            return Environment.getExternalStorageDirectory().getAbsolutePath() + ("/tencent/TMAssistantSDK/Download/" + context.getPackageName());
        }
        return context.getFilesDir().getAbsolutePath() + "/TMAssistantSDK/Download";
    }

    public void moveFileToSavaPath() {
        moveFileFromTmpToSavaPath(getTmpFilePath(this.mTempFileName), getSaveFilePath(this.mFinalFileName));
    }

    public static boolean isSDCardExistAndCanWrite() {
        return "mounted".equals(Environment.getExternalStorageState()) && Environment.getExternalStorageDirectory().canWrite();
    }

    private boolean writeData(FileOutputStream fileOutputStream, byte[] bArr, int i, int i2, long j) {
        if (fileOutputStream == null || bArr == null) {
            return false;
        }
        if (j != this.mFileDataLen) {
            TMLog.i(TAG, "writeData0 failed,filelen:" + this.mFileDataLen + ",offset:" + j + ",filename:" + this.mTempFileName);
            return false;
        }
        if (i2 >= DataBufferMaxLen) {
            try {
                if (this.mDataBufferDataLen > 0) {
                    fileOutputStream.write(this.mWriteDataBuffer, 0, this.mDataBufferDataLen);
                    this.mDataBufferDataLen = 0;
                }
                fileOutputStream.write(bArr, i, i2);
                this.mFileDataLen += (long) i2;
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[0]);
                TMLog.w(TAG, "writeData1 failed " + e);
                return false;
            }
        }
        if (this.mDataBufferDataLen + i2 > DataBufferMaxLen && this.mDataBufferDataLen > 0) {
            try {
                fileOutputStream.write(this.mWriteDataBuffer, 0, this.mDataBufferDataLen);
                this.mDataBufferDataLen = 0;
            } catch (Throwable e2) {
                v.a(TAG, e2, "", new Object[0]);
                TMLog.w(TAG, "writeData2 failed " + e2);
                return false;
            }
        }
        System.arraycopy(bArr, i, this.mWriteDataBuffer, this.mDataBufferDataLen, i2);
        this.mDataBufferDataLen += i2;
        this.mFileDataLen += (long) i2;
        return true;
    }

    private boolean moveFileFromTmpToSavaPath(String str, String str2) {
        if (!(str == null || str2 == null)) {
            File file = new File(str);
            if (file.exists()) {
                boolean renameTo = file.renameTo(new File(str2));
                if (!renameTo) {
                    return renameTo;
                }
                GlobalUtil.updateFilePathAuthorized(str2);
                return renameTo;
            }
        }
        TMLog.w(TAG, "moveFileFromTmpToSavaPath failed ");
        return false;
    }
}
