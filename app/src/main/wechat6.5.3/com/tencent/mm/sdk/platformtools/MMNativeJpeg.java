package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class MMNativeJpeg {
    public static final int FAKE_PARTIAL_PROGRESSIVE_QUALITY = 25;
    public static final String TAG = "MMJPEG.JAVA";

    private static String exception2String(Throwable th) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void Destroy() {
    }

    private static boolean checkAndroidVersion() {
        if (VERSION.SDK_INT >= 11) {
            return true;
        }
        v.i(TAG, "early version before android 3.0  unsupported.");
        return false;
    }

    private static boolean checkFileExist(String str) {
        boolean z = false;
        try {
            z = new File(str).exists();
        } catch (Throwable e) {
            v.e(TAG, "checkfileexist. exception:%s", exception2String(e));
        }
        return z;
    }

    public static int queryQuality(String str) {
        if (!checkAndroidVersion() || !checkFileExist(str)) {
            return 0;
        }
        try {
            int queryQuality = mmjpeg.queryQuality(str);
            v.i(TAG, "after query quality:%d", Integer.valueOf(queryQuality));
            if (queryQuality < 10000 && queryQuality >= 24) {
                return queryQuality;
            }
            if (1 == mmjpeg.isProgressiveFile(str)) {
                return 25;
            }
            v.w(TAG, "invalid jpeg file or too small quality.");
            return 0;
        } catch (Throwable e) {
            v.e(TAG, "queryQuality failed. exception:%s", exception2String(e));
            return 0;
        } catch (Throwable e2) {
            v.a("MicroMsg.Crash", e2, "May cause dvmFindCatchBlock crash!", new Object[0]);
            throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2));
        } catch (Error e3) {
            v.e(TAG, "queryQuality error. java.lang.UnsatisfiedLinkError: queryQuality, %s", e3.toString());
            return 0;
        }
    }

    public static boolean isProgressive(String str) {
        v.v(TAG, "isProgressive:%s", str);
        if (!checkAndroidVersion() || !checkFileExist(str)) {
            return false;
        }
        v.d(TAG, "check progressive for file:%s", str);
        try {
            int isProgressiveFile = mmjpeg.isProgressiveFile(str);
            if (1 == isProgressiveFile || isProgressiveFile == 0) {
                v.i(TAG, "file:%s progressive:%d", str, Integer.valueOf(isProgressiveFile));
                if (isProgressiveFile == 1) {
                    return true;
                }
                return false;
            }
            v.e(TAG, "check failed. error:%d", Integer.valueOf(isProgressiveFile));
            return false;
        } catch (Throwable e) {
            v.e(TAG, "isProgressive exception:%s", exception2String(e));
            return false;
        }
    }

    public static boolean convertToProgressive(String str, int i) {
        if (!checkAndroidVersion()) {
            return false;
        }
        try {
            String str2 = str + ".prog.dat";
            v.d(TAG, "convert %s to %s use progressive.quality:%d", str, str2, Integer.valueOf(i));
            if (mmjpeg.convertToProgressive(str, str2) != 0) {
                v.e(TAG, "convert failed. error:%d", Integer.valueOf(mmjpeg.convertToProgressive(str, str2)));
                return false;
            }
            v.i(TAG, "convert ret:%b", Boolean.valueOf(j.n(str2, str, true)));
            return j.n(str2, str, true);
        } catch (Throwable e) {
            v.e(TAG, "convertToProgressive exception:%s", exception2String(e));
            return false;
        }
    }

    public static Bitmap decodeAsBitmap(String str) {
        v.v(TAG, "decodeAsBitmap:%s", str);
        try {
            JpegParams queryParams = mmjpeg.queryParams(str);
            if (queryParams == null) {
                v.e(TAG, "can't query jpeg parames.");
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(queryParams.Width, queryParams.Height, Config.ARGB_8888);
            if (mmjpeg.decodeToBitmap(str, createBitmap)) {
                v.i(TAG, "decode bitmap successed.");
                return createBitmap;
            }
            v.e(TAG, "can't decode to bmp.");
            return null;
        } catch (Throwable e) {
            v.e(TAG, "decodeAsBitmap exception:%s", exception2String(e));
            return null;
        } catch (OutOfMemoryError e2) {
            v.e(TAG, "decodeAsBitmap OOM:%s", str);
            return null;
        }
    }

    public static boolean Convert2Baseline(String str, int i) {
        Throwable e;
        if (isProgressive(str)) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2;
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                if (decodeFile == null) {
                    v.i(TAG, "c2b:use mmjpeg to decode.");
                    decodeFile = decodeAsBitmap(str);
                }
                if (decodeFile != null) {
                    String str2 = str + ".base";
                    CompressFormat compressFormat = CompressFormat.JPEG;
                    fileOutputStream2 = new FileOutputStream(str2);
                    try {
                        if (decodeFile.compress(compressFormat, i, fileOutputStream2)) {
                            v.i(TAG, "c2b: convert baseline %s ok.", str2);
                            boolean n = j.n(str2, str, true);
                            try {
                                fileOutputStream2.close();
                                return n;
                            } catch (Exception e2) {
                                return n;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream = fileOutputStream2;
                        try {
                            v.e(TAG, "c2b:exception:%s", exception2String(e));
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e4) {
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            e = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e5) {
                                }
                            }
                            throw e;
                        }
                    } catch (OutOfMemoryError e6) {
                        fileOutputStream = fileOutputStream2;
                        v.e(TAG, "c2b: oom");
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e7) {
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        e = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw e;
                    }
                }
                fileOutputStream2 = null;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e8) {
                    }
                }
            } catch (Exception e9) {
                e = e9;
                v.e(TAG, "c2b:exception:%s", exception2String(e));
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return false;
            } catch (OutOfMemoryError e10) {
                v.e(TAG, "c2b: oom");
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return false;
            }
            return false;
        }
        v.e(TAG, "c2b: not progressive file.%s", str);
        return true;
    }

    public static boolean IsJpegFile(String str) {
        try {
            if (mmjpeg.queryParams(str) != null) {
                return true;
            }
            v.e(TAG, "IsJpegFile : can't query jpeg parames.");
            return false;
        } catch (Throwable e) {
            v.e(TAG, "IsJpegFile exception:%s", exception2String(e));
            return false;
        }
    }
}
