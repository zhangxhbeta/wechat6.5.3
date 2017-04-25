package com.tencent.mm.a;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;

public final class q {
    public static byte[] k(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable e;
        Deflater deflater = new Deflater();
        deflater.reset();
        deflater.setInput(bArr);
        deflater.finish();
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            try {
                byte[] bArr2 = new byte[1024];
                while (!deflater.finished()) {
                    byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
                }
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable e2) {
                    v.a("MicroMsg.Zlib", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    v.a("MicroMsg.Zlib", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e22) {
                            v.a("MicroMsg.Zlib", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                    deflater.end();
                    return bArr;
                } catch (Throwable th) {
                    e22 = th;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e4) {
                            v.a("MicroMsg.Zlib", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                    throw e22;
                }
            } catch (OutOfMemoryError e5) {
                throw new OutOfMemoryError("crash upload data length:" + bArr.length);
            }
        } catch (Exception e6) {
            e22 = e6;
            byteArrayOutputStream = null;
            v.a("MicroMsg.Zlib", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            deflater.end();
            return bArr;
        } catch (OutOfMemoryError e7) {
            byteArrayOutputStream = null;
            throw new OutOfMemoryError("crash upload data length:" + bArr.length);
        } catch (Throwable th2) {
            e22 = th2;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw e22;
        }
        deflater.end();
        return bArr;
    }

    @Deprecated
    public static byte[] p(byte[] bArr) {
        try {
            bArr = q(bArr);
        } catch (Throwable e) {
            v.a("MicroMsg.Zlib", e, "decompress failed", new Object[0]);
        }
        return bArr;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] q(byte[] r7) {
        /*
        r6 = 0;
        r1 = new java.util.zip.Inflater;
        r1.<init>();
        r1.reset();
        r1.setInput(r7);
        r0 = 0;
        r2 = new java.io.ByteArrayOutputStream;
        r3 = r7.length;
        r2.<init>(r3);
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3 = new byte[r3];	 Catch:{ Exception -> 0x0026 }
    L_0x0017:
        r4 = r1.finished();	 Catch:{ Exception -> 0x0026 }
        if (r4 != 0) goto L_0x0041;
    L_0x001d:
        r4 = r1.inflate(r3);	 Catch:{ Exception -> 0x0026 }
        r5 = 0;
        r2.write(r3, r5, r4);	 Catch:{ Exception -> 0x0026 }
        goto L_0x0017;
    L_0x0026:
        r0 = move-exception;
        r3 = "MicroMsg.Zlib";
        r4 = "exception when loop read byte";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0063 }
        com.tencent.mm.sdk.platformtools.v.a(r3, r0, r4, r5);	 Catch:{ all -> 0x0063 }
        r2.close();	 Catch:{ IOException -> 0x0056 }
    L_0x0036:
        r1.end();
        if (r0 == 0) goto L_0x0075;
    L_0x003b:
        r1 = new java.lang.Exception;
        r1.<init>(r0);
        throw r1;
    L_0x0041:
        r7 = r2.toByteArray();	 Catch:{ Exception -> 0x0026 }
        r2.close();	 Catch:{ IOException -> 0x0049 }
        goto L_0x0036;
    L_0x0049:
        r2 = move-exception;
        r3 = "MicroMsg.Zlib";
        r4 = "";
        r5 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0036;
    L_0x0056:
        r2 = move-exception;
        r3 = "MicroMsg.Zlib";
        r4 = "";
        r5 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0036;
    L_0x0063:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x0068 }
    L_0x0067:
        throw r0;
    L_0x0068:
        r1 = move-exception;
        r2 = "MicroMsg.Zlib";
        r3 = "";
        r4 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
        goto L_0x0067;
    L_0x0075:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.a.q.q(byte[]):byte[]");
    }
}
