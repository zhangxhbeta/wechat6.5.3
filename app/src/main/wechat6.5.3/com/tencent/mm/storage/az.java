package com.tencent.mm.storage;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;

public final class az extends g {
    private r nwE = null;

    public az(r rVar) {
        this.nwE = rVar;
    }

    public final void bxg() {
        int i;
        String str = (String) this.nwE.get(77825, null);
        v.i("MicroMsg.ServerConfigInfoStorage", "hy: readConfig xml " + str);
        if (!be.kS(str)) {
            super.Lf(str);
        }
        if (be.kS(str)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            str = t.cng + "deviceconfig.cfg";
            if (e.aR(str)) {
                byte[] d = e.d(str, 0, -1);
                if (be.bl(d)) {
                    i = -2;
                } else {
                    String str2 = new String(d, Charset.defaultCharset());
                    if (be.kS(str2)) {
                        i = -3;
                    } else {
                        v.i("MicroMsg.ServerConfigInfoStorage", "hy: read from file: %s", str2);
                        Nt(str2);
                        i = 0;
                    }
                }
            } else {
                i = -1;
            }
        } else {
            v.i("MicroMsg.ServerConfigInfoStorage", "hy: got conf from db");
            i = 0;
        }
        v.i("MicroMsg.ServerConfigInfoStorage", "hy: read from local retcode: %d", Integer.valueOf(i));
    }

    public final String bxh() {
        String str = (String) this.nwE.get(77825, null);
        v.d("MicroMsg.ServerConfigInfoStorage", "getInfoByKey xml " + str + " key 77825");
        return str;
    }

    public final int Nt(String str) {
        v.d("MicroMsg.ServerConfigInfoStorage", "dkconf info:[%s] ", str);
        this.nwE.set(77825, str);
        Nv(str);
        super.Lf(str);
        return 0;
    }

    public static String bxi() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object obj = Build.FINGERPRINT;
        if (obj != null) {
            obj = obj.replace("/", ":");
        }
        linkedHashMap.put("fingerprint", obj);
        linkedHashMap.put("manufacturer", Build.MANUFACTURER);
        linkedHashMap.put("device", Build.DEVICE);
        linkedHashMap.put("model", Build.MODEL);
        linkedHashMap.put("product", Build.PRODUCT);
        linkedHashMap.put("board", Build.BOARD);
        linkedHashMap.put("release", VERSION.RELEASE);
        linkedHashMap.put("codename", VERSION.CODENAME);
        linkedHashMap.put("incremental", VERSION.INCREMENTAL);
        linkedHashMap.put("display", Build.DISPLAY);
        String a = be.a(linkedHashMap);
        v.d("MicroMsg.ServerConfigInfoStorage", "getLocalFingerprint  " + a);
        return a;
    }

    public static String bxj() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<deviceinfo>");
        stringBuffer.append("<MANUFACTURER name=\"");
        stringBuffer.append(Build.MANUFACTURER);
        stringBuffer.append("\">");
        stringBuffer.append("<MODEL name=\"");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("\">");
        stringBuffer.append("<VERSION_RELEASE name=\"");
        stringBuffer.append(VERSION.RELEASE);
        stringBuffer.append("\">");
        stringBuffer.append("<VERSION_INCREMENTAL name=\"");
        stringBuffer.append(VERSION.INCREMENTAL);
        stringBuffer.append("\">");
        stringBuffer.append("<DISPLAY name=\"");
        stringBuffer.append(Build.DISPLAY);
        stringBuffer.append("\">");
        stringBuffer.append("</DISPLAY></VERSION_INCREMENTAL></VERSION_RELEASE></MODEL></MANUFACTURER></deviceinfo>");
        v.d("MicroMsg.ServerConfigInfoStorage", "getFingerprint  " + stringBuffer.toString());
        return stringBuffer.toString();
    }

    public static boolean Nu(String str) {
        if (be.kS(str)) {
            return false;
        }
        try {
            if (bf.q(str, "deviceinfoconfig") == null || !com.tencent.mm.kernel.g.uz()) {
                return false;
            }
            com.tencent.mm.kernel.g.vx();
            com.tencent.mm.kernel.g.vw().vg().Nt(str);
            return true;
        } catch (Throwable e) {
            v.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", be.e(e));
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean Nv(java.lang.String r9) {
        /*
        r0 = 1;
        r4 = 0;
        r1 = new java.io.File;
        r2 = com.tencent.mm.storage.t.cng;
        r1.<init>(r2);
        r2 = r1.exists();
        if (r2 != 0) goto L_0x0012;
    L_0x000f:
        r1.mkdirs();
    L_0x0012:
        r3 = 0;
        r1 = "MicroMsg.ServerConfigInfoStorage";
        r2 = "writeConfigToLocalFile, path: %s, info:%s";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0073 }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0073 }
        r7.<init>();	 Catch:{ Exception -> 0x0073 }
        r8 = com.tencent.mm.storage.t.cng;	 Catch:{ Exception -> 0x0073 }
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x0073 }
        r8 = "deviceconfig.cfg";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x0073 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x0073 }
        r5[r6] = r7;	 Catch:{ Exception -> 0x0073 }
        r6 = 1;
        r5[r6] = r9;	 Catch:{ Exception -> 0x0073 }
        com.tencent.mm.sdk.platformtools.v.i(r1, r2, r5);	 Catch:{ Exception -> 0x0073 }
        r2 = new java.io.FileWriter;	 Catch:{ Exception -> 0x0073 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0073 }
        r1.<init>();	 Catch:{ Exception -> 0x0073 }
        r5 = com.tencent.mm.storage.t.cng;	 Catch:{ Exception -> 0x0073 }
        r1 = r1.append(r5);	 Catch:{ Exception -> 0x0073 }
        r5 = "deviceconfig.cfg";
        r1 = r1.append(r5);	 Catch:{ Exception -> 0x0073 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0073 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x0073 }
        r2.write(r9);	 Catch:{ Exception -> 0x00c1, all -> 0x00be }
        r2.close();	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        r2.close();	 Catch:{ IOException -> 0x0060 }
    L_0x005f:
        return r0;
    L_0x0060:
        r1 = move-exception;
        r2 = "MicroMsg.ServerConfigInfoStorage";
        r3 = "exception:%s";
        r5 = new java.lang.Object[r0];
        r1 = com.tencent.mm.sdk.platformtools.be.e(r1);
        r5[r4] = r1;
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r5);
        goto L_0x005f;
    L_0x0073:
        r1 = move-exception;
        r2 = r1;
        r1 = r4;
    L_0x0076:
        r5 = "MicroMsg.ServerConfigInfoStorage";
        r6 = "exception:%s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x00a4 }
        r8 = 0;
        r2 = com.tencent.mm.sdk.platformtools.be.e(r2);	 Catch:{ all -> 0x00a4 }
        r7[r8] = r2;	 Catch:{ all -> 0x00a4 }
        com.tencent.mm.sdk.platformtools.v.e(r5, r6, r7);	 Catch:{ all -> 0x00a4 }
        if (r3 == 0) goto L_0x00cb;
    L_0x008b:
        r3.close();	 Catch:{ IOException -> 0x0090 }
        r0 = r1;
        goto L_0x005f;
    L_0x0090:
        r2 = move-exception;
        r3 = "MicroMsg.ServerConfigInfoStorage";
        r5 = "exception:%s";
        r0 = new java.lang.Object[r0];
        r2 = com.tencent.mm.sdk.platformtools.be.e(r2);
        r0[r4] = r2;
        com.tencent.mm.sdk.platformtools.v.e(r3, r5, r0);
        r0 = r1;
        goto L_0x005f;
    L_0x00a4:
        r1 = move-exception;
    L_0x00a5:
        if (r3 == 0) goto L_0x00aa;
    L_0x00a7:
        r3.close();	 Catch:{ IOException -> 0x00ab }
    L_0x00aa:
        throw r1;
    L_0x00ab:
        r2 = move-exception;
        r3 = "MicroMsg.ServerConfigInfoStorage";
        r5 = "exception:%s";
        r0 = new java.lang.Object[r0];
        r2 = com.tencent.mm.sdk.platformtools.be.e(r2);
        r0[r4] = r2;
        com.tencent.mm.sdk.platformtools.v.e(r3, r5, r0);
        goto L_0x00aa;
    L_0x00be:
        r1 = move-exception;
        r3 = r2;
        goto L_0x00a5;
    L_0x00c1:
        r1 = move-exception;
        r3 = r2;
        r2 = r1;
        r1 = r4;
        goto L_0x0076;
    L_0x00c6:
        r1 = move-exception;
        r3 = r2;
        r2 = r1;
        r1 = r0;
        goto L_0x0076;
    L_0x00cb:
        r0 = r1;
        goto L_0x005f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.az.Nv(java.lang.String):boolean");
    }
}
