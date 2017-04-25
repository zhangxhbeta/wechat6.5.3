package com.tencent.mm.loader.stub;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.FileInputStream;

public final class d {
    public static String p(Context context, int i) {
        Throwable e;
        if (context == null || i <= 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i && runningAppProcessInfo.processName != null && !runningAppProcessInfo.processName.equals(SQLiteDatabase.KeyEmpty)) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Throwable e2) {
            v.a("MicroMsg.Util", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        byte[] bArr = new byte[FileUtils.S_IWUSR];
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("/proc/" + i + "/cmdline");
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    int i2 = 0;
                    while (i2 < read) {
                        if (bArr[i2] > Byte.MIN_VALUE || bArr[i2] <= (byte) 0) {
                            read = i2;
                            break;
                        }
                        i2++;
                    }
                    String str = new String(bArr, 0, read);
                    try {
                        fileInputStream.close();
                        return str;
                    } catch (Exception e3) {
                        return str;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                }
                return SQLiteDatabase.KeyEmpty;
            } catch (Exception e5) {
                e2 = e5;
                try {
                    v.a("MicroMsg.Util", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    return SQLiteDatabase.KeyEmpty;
                } catch (Throwable th) {
                    e2 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    throw e2;
                }
            }
        } catch (Exception e8) {
            e2 = e8;
            fileInputStream = null;
            v.a("MicroMsg.Util", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return SQLiteDatabase.KeyEmpty;
        } catch (Throwable th2) {
            e2 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e2;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String e(java.io.InputStream r6) {
        /*
        r5 = 0;
        r0 = new java.io.BufferedReader;
        r1 = new java.io.InputStreamReader;
        r1.<init>(r6);
        r0.<init>(r1);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
    L_0x0010:
        r2 = r0.readLine();	 Catch:{ IOException -> 0x002e }
        if (r2 == 0) goto L_0x0043;
    L_0x0016:
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x002e }
        r3.<init>();	 Catch:{ IOException -> 0x002e }
        r2 = r3.append(r2);	 Catch:{ IOException -> 0x002e }
        r3 = "\n";
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x002e }
        r2 = r2.toString();	 Catch:{ IOException -> 0x002e }
        r1.append(r2);	 Catch:{ IOException -> 0x002e }
        goto L_0x0010;
    L_0x002e:
        r0 = move-exception;
        r2 = "MicroMsg.Util";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0061 }
        com.tencent.mm.sdk.platformtools.v.a(r2, r0, r3, r4);	 Catch:{ all -> 0x0061 }
        r6.close();	 Catch:{ IOException -> 0x0054 }
    L_0x003e:
        r0 = r1.toString();
        return r0;
    L_0x0043:
        r6.close();	 Catch:{ IOException -> 0x0047 }
        goto L_0x003e;
    L_0x0047:
        r0 = move-exception;
        r2 = "MicroMsg.Util";
        r3 = "";
        r4 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r2, r0, r3, r4);
        goto L_0x003e;
    L_0x0054:
        r0 = move-exception;
        r2 = "MicroMsg.Util";
        r3 = "";
        r4 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r2, r0, r3, r4);
        goto L_0x003e;
    L_0x0061:
        r0 = move-exception;
        r6.close();	 Catch:{ IOException -> 0x0066 }
    L_0x0065:
        throw r0;
    L_0x0066:
        r1 = move-exception;
        r2 = "MicroMsg.Util";
        r3 = "";
        r4 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.loader.stub.d.e(java.io.InputStream):java.lang.String");
    }
}
