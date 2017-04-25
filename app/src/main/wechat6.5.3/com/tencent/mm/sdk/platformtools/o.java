package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class o {
    public static boolean JY(String str) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.ImgUtil", "isImgFile, invalid argument");
            return false;
        } else if (str.length() < 3 || !new File(str).exists()) {
            return false;
        } else {
            Options options = new Options();
            options.inJustDecodeBounds = false;
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options, decodeResultLogger, 0, new int[0]);
            if (decodeFile != null) {
                v.i("MicroMsg.ImgUtil", "bitmap recycle %s", decodeFile);
                decodeFile.recycle();
            }
            if (options.outWidth <= 0 || options.outHeight <= 0 || decodeResultLogger.getDecodeResult() != 0) {
                return false;
            }
            return true;
        }
    }

    public static boolean a(String str, DecodeResultLogger decodeResultLogger) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.ImgUtil", "isImgFile, invalid argument");
            decodeResultLogger.setDecodeResult(MMBitmapFactory.ERROR_IO_FAILED);
            return false;
        } else if (str.length() < 3) {
            decodeResultLogger.setDecodeResult(MMBitmapFactory.ERROR_IO_FAILED);
            return false;
        } else if (new File(str).exists()) {
            Options options = new Options();
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options, decodeResultLogger, 0, new int[0]);
            if (decodeFile != null) {
                v.i("MicroMsg.ImgUtil", "bitmap recycle %s", decodeFile);
                decodeFile.recycle();
            }
            if (options.outWidth <= 0 || options.outHeight <= 0 || decodeResultLogger.getDecodeResult() != 0) {
                return false;
            }
            return true;
        } else {
            decodeResultLogger.setDecodeResult(MMBitmapFactory.ERROR_IO_FAILED);
            return false;
        }
    }

    public static boolean be(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        String str = SQLiteDatabase.KeyEmpty;
        int i = 0;
        while (i < 6) {
            try {
                str = str + ((char) byteArrayInputStream.read());
                i++;
            } catch (IOException e) {
                return false;
            }
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException e2) {
        }
        if (str.startsWith("GIF")) {
            return true;
        }
        return false;
    }

    public static boolean JZ(String str) {
        InputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[6];
                String str2 = SQLiteDatabase.KeyEmpty;
                fileInputStream.read(bArr);
                String str3 = str2;
                for (int i = 0; i < 6; i++) {
                    str3 = str3 + ((char) bArr[i]);
                }
                if (str3.startsWith("GIF")) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                    }
                    return true;
                }
                try {
                    fileInputStream.close();
                    return false;
                } catch (IOException e2) {
                    return false;
                }
            } catch (Exception e3) {
                if (fileInputStream != null) {
                    return false;
                }
                try {
                    fileInputStream.close();
                    return false;
                } catch (IOException e4) {
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            fileInputStream = null;
            if (fileInputStream != null) {
                return false;
            }
            fileInputStream.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public static boolean bf(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return false;
        }
        if (bArr[1] == (byte) 80 && bArr[2] == (byte) 78 && bArr[3] == (byte) 71) {
            return true;
        }
        if (bArr[0] == (byte) 71 && bArr[1] == (byte) 73 && bArr[2] == (byte) 70) {
            return true;
        }
        if (bArr[6] == (byte) 74 && bArr[7] == (byte) 70 && bArr[8] == (byte) 73 && bArr[9] == (byte) 70) {
            return true;
        }
        return false;
    }
}
