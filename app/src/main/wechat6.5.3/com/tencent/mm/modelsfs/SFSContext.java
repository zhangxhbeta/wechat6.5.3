package com.tencent.mm.modelsfs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class SFSContext {
    public long mNativePtr;

    public static class Builder implements Parcelable {
        public static final Creator<Builder> CREATOR = new Creator<Builder>() {
            public final Builder createFromParcel(Parcel parcel) {
                return new Builder(parcel);
            }

            public final Builder[] newArray(int i) {
                return new Builder[i];
            }
        };
        HashMap<Integer, Object> mConf;
        String mName;

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setIndexDBPath(String str) {
            this.mConf.put(Integer.valueOf(1), str);
            return this;
        }

        public Builder setBlockFilePrefix(String str) {
            this.mConf.put(Integer.valueOf(2), str);
            return this;
        }

        public Builder setOverflowPrefix(String str) {
            this.mConf.put(Integer.valueOf(3), str);
            return this;
        }

        public Builder setIOMode(int i) {
            this.mConf.put(Integer.valueOf(9), Integer.valueOf(i));
            return this;
        }

        public Builder setBlockSizeArray(int[] iArr) {
            this.mConf.put(Integer.valueOf(5), iArr);
            return this;
        }

        public Builder setBlockFileMaxSize(int i) {
            this.mConf.put(Integer.valueOf(4), Integer.valueOf(i));
            return this;
        }

        public Builder setConnectionPool(int i) {
            this.mConf.put(Integer.valueOf(7), Integer.valueOf(i));
            return this;
        }

        public Builder setMaxConcurrentIO(int i) {
            this.mConf.put(Integer.valueOf(10), Integer.valueOf(i));
            return this;
        }

        public Builder setSyncMode(int i) {
            this.mConf.put(Integer.valueOf(11), Integer.valueOf(i));
            return this;
        }

        public Builder setStoragePath(String str) {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            this.mConf.put(Integer.valueOf(2), str + "/%s.block");
            this.mConf.put(Integer.valueOf(3), str + "/%s/");
            return this;
        }

        public Builder setDBDirectory(String str) {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            this.mConf.put(Integer.valueOf(1), str + "/%s.index");
            return this;
        }

        public Builder() {
            this.mName = null;
            this.mConf = new HashMap();
        }

        public SFSContext create() {
            return new SFSContext();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mName);
            Object[] objArr = new Object[12];
            for (Entry entry : this.mConf.entrySet()) {
                int intValue = ((Integer) entry.getKey()).intValue();
                if (intValue < 12 && intValue >= 0) {
                    objArr[intValue] = entry.getValue();
                }
            }
            parcel.writeArray(objArr);
        }

        private Builder(Parcel parcel) {
            this.mName = parcel.readString();
            this.mConf = new HashMap();
            Object[] readArray = parcel.readArray(Builder.class.getClassLoader());
            if (readArray != null) {
                for (int i = 0; i < readArray.length; i++) {
                    if (readArray[i] != null) {
                        this.mConf.put(Integer.valueOf(i), readArray[i]);
                    }
                }
            }
        }
    }

    public static class FileEntry {
        public String name;
        public long size;
        public long timestamp;
    }

    public static class Statistics implements Serializable {
        private static final long serialVersionUID = 1;
        public BlockFile[] blockFiles;
        public long blockSizeEmpty;
        public long blockSizeUsed;
        public BlockType[] blockTypes;
        public long overflowActualSize;
        public long totalActualSize;

        public static class BlockFile implements Serializable {
            private static final long serialVersionUID = 1;
            public int blockCount;
            public boolean deleted;
            public int emptyCount;
            public long fileSize;
            public long timestamp;
        }

        public static class BlockType implements Serializable {
            private static final long serialVersionUID = 1;
            public long actualSize;
            public int blockSize;
            public int emptyCount;
            public int usedCount;
        }

        public String toString() {
            int i = 0;
            StringBuilder stringBuilder = new StringBuilder(4096);
            stringBuilder.append("Total:\n\tActualSize: ").append(this.totalActualSize).append('\n').append("\tUsedBlockSize: ").append(this.blockSizeUsed).append('\n').append("\tEmptyBlockSize: ").append(this.blockSizeEmpty).append('\n').append("\tOverflowSize: ").append(this.overflowActualSize).append('\n');
            for (BlockType blockType : this.blockTypes) {
                stringBuilder.append("BlockType: ").append(blockType.blockSize).append('\n').append("\tUsedCount: ").append(blockType.usedCount).append('\n').append("\tEmptyCount: ").append(blockType.emptyCount).append('\n').append("\tActualSize: ").append(blockType.actualSize).append('\n');
            }
            while (i < this.blockFiles.length) {
                BlockFile blockFile = this.blockFiles[i];
                stringBuilder.append("BlockFile: ").append(i).append('\n').append("\tFileSize: ").append(blockFile.fileSize).append('\n').append("\tUsedBlockCount: ").append(blockFile.blockCount).append('\n').append("\tEmptyBlockCount: ").append(blockFile.emptyCount).append('\n').append("\tTimestamp: ").append(blockFile.timestamp).append('\n').append("\tDeleted: ").append(blockFile.deleted).append('\n');
                i++;
            }
            return stringBuilder.toString();
        }
    }

    static native int nativeClear(long j);

    static native String nativeErrorMessage();

    static native boolean nativeExists(long j, String str);

    private static native long nativeInit(String str);

    private static native int nativeList(long j, String str, List<FileEntry> list);

    private static native long nativeOpenRead(long j, String str);

    private static native long nativeOpenWrite(long j, String str);

    private static native void nativeRelease(long j);

    private static native void nativeSetIntArrayConf(int i, int[] iArr);

    private static native void nativeSetIntConf(int i, int i2);

    private static native void nativeSetStringConf(int i, String str);

    private static native FileEntry nativeStat(long j, String str);

    static native Statistics nativeStatistics(long j);

    private static native boolean nativeUnlink(long j, String str);

    private SFSContext(Builder builder) {
        for (Entry entry : builder.mConf.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            Object value = entry.getValue();
            if (value instanceof Integer) {
                nativeSetIntConf(intValue, ((Integer) value).intValue());
            } else if (value instanceof String) {
                nativeSetStringConf(intValue, (String) value);
            } else if (value instanceof int[]) {
                nativeSetIntArrayConf(intValue, (int[]) value);
            }
        }
        long nativeInit = nativeInit(builder.mName);
        if (nativeInit == 0) {
            throw new RuntimeException(nativeErrorMessage());
        }
        this.mNativePtr = nativeInit;
    }

    public final void release() {
        nativeRelease(this.mNativePtr);
        this.mNativePtr = 0;
    }

    public final InputStream openRead(String str) {
        if (this.mNativePtr == 0) {
            throw new IllegalArgumentException("Reuse already released SFSContext.");
        }
        long jY;
        if (f.jW(str)) {
            jY = f.jY(str);
            str = f.jX(str);
        } else {
            jY = 0;
        }
        long nativeOpenRead = nativeOpenRead(this.mNativePtr, str);
        if (nativeOpenRead == 0) {
            throw new FileNotFoundException(str + ": " + nativeErrorMessage());
        } else if (jY != 0) {
            return new d(nativeOpenRead, jY);
        } else {
            return new SFSInputStream(nativeOpenRead);
        }
    }

    public final OutputStream Z(String str, String str2) {
        if (this.mNativePtr == 0) {
            throw new IllegalArgumentException("Reuse already released SFSContext.");
        }
        long nativeOpenWrite = nativeOpenWrite(this.mNativePtr, str);
        if (nativeOpenWrite == 0) {
            throw new IOException(str + ": " + nativeErrorMessage());
        } else if (TextUtils.isEmpty(str2)) {
            return new SFSOutputStream(nativeOpenWrite);
        } else {
            return new e(nativeOpenWrite, str2);
        }
    }

    public final List<FileEntry> ka(String str) {
        if (this.mNativePtr == 0) {
            throw new IllegalArgumentException("Reuse already released SFSContext.");
        }
        List<FileEntry> arrayList = new ArrayList();
        if (nativeList(this.mNativePtr, str, arrayList) == 0) {
            return arrayList;
        }
        throw new IOException(nativeErrorMessage());
    }

    public final FileEntry kb(String str) {
        if (this.mNativePtr == 0) {
            throw new IllegalArgumentException("Reuse already released SFSContext.");
        }
        if (f.jW(str)) {
            f.jY(str);
            str = f.jX(str);
        }
        return nativeStat(this.mNativePtr, str);
    }

    public final boolean hc(String str) {
        if (this.mNativePtr == 0) {
            throw new IllegalArgumentException("Reuse already released SFSContext.");
        }
        if (f.jW(str)) {
            f.jY(str);
            str = f.jX(str);
        }
        return nativeUnlink(this.mNativePtr, str);
    }

    protected void finalize() {
        if (this.mNativePtr != 0) {
            release();
        }
        super.finalize();
    }
}
