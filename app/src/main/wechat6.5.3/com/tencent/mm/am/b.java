package com.tencent.mm.am;

import android.graphics.Bitmap;
import com.tencent.mm.a.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.v;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public final class b {
    public static String ju(String str) {
        ak.yW();
        String wP = c.wP();
        ak.yW();
        return h.e(wP, c.wQ(), "qr_", g.m(str.getBytes()), ".png");
    }

    public static int k(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Throwable e;
        try {
            fileOutputStream = new FileOutputStream(ju(str));
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                    return 0;
                } catch (Exception e2) {
                    return 0;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    v.a("MicroMsg.QRCodeStorage", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                    return -1;
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
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
            v.a("MicroMsg.QRCodeStorage", e, "", new Object[0]);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return -1;
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e;
        }
    }

    public static byte[] jv(String str) {
        Throwable e;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(ju(str), "r");
            try {
                byte[] bArr = new byte[((int) randomAccessFile.length())];
                randomAccessFile.read(bArr);
                try {
                    randomAccessFile.close();
                    return bArr;
                } catch (Exception e2) {
                    return bArr;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    v.a("MicroMsg.QRCodeStorage", e, "", new Object[0]);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e4) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            v.a("MicroMsg.QRCodeStorage", e, "", new Object[0]);
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw e;
        }
    }

    public static Bitmap HU() {
        ak.yW();
        int f = be.f((Integer) c.vf().get(66561, null));
        byte[] jv = jv(k.xF());
        if (jv == null || f == 0) {
            return null;
        }
        return d.bc(jv);
    }
}
