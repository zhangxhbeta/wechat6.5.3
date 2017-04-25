package com.tencent.mm.plugin.report.service;

import android.content.Context;
import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public final class e {
    private static String filePath = (getAppFilePath() + "/kvcomm/exception/");
    private static Byte itV = new Byte((byte) 0);

    static {
        if (!com.tencent.mm.a.e.aR(filePath)) {
            com.tencent.mm.a.e.aU(filePath);
        }
    }

    private static String getAppFilePath() {
        String str = null;
        Context context = aa.getContext();
        if (context != null) {
            try {
                File filesDir = context.getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.createNewFile();
                }
                str = filesDir.toString();
            } catch (Exception e) {
                v.e("MicroMsg.ReportManagerKvCheck", e.getMessage());
            }
        }
        return str;
    }

    public static void aKA() {
        if (com.tencent.mm.a.e.aR(filePath)) {
            File[] listFiles = new File(filePath).listFiles();
            if (listFiles == null) {
                v.e("MicroMsg.ReportManagerKvCheck", "list file fail, filePath:" + filePath);
                return;
            }
            synchronized (itV) {
                for (File file : listFiles) {
                    if (file == null) {
                        v.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, file is null");
                    } else {
                        String absolutePath = file.getAbsolutePath();
                        int i = 0;
                        int aQ = com.tencent.mm.a.e.aQ(absolutePath);
                        v.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filename:" + file.getAbsolutePath() + ", filelenth:" + aQ);
                        while (i < aQ) {
                            byte[] c = com.tencent.mm.a.e.c(absolutePath, i, 4);
                            if (c == null) {
                                v.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_len fail. delete file:" + absolutePath);
                                break;
                            }
                            i += 4;
                            int aA = aA(c);
                            byte[] c2 = com.tencent.mm.a.e.c(absolutePath, i, aA);
                            if (c2 == null) {
                                v.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_data fail. delete file:" + absolutePath);
                                break;
                            }
                            int i2 = i + aA;
                            boolean z;
                            if (!absolutePath.contains(".statictis")) {
                                b bVar;
                                if (!absolutePath.contains(".monitor")) {
                                    if (!absolutePath.contains(".group_monitor")) {
                                        v.e("MicroMsg.ReportManagerKvCheck", "invalid filename:" + absolutePath);
                                        break;
                                    }
                                    a aVar = new a();
                                    try {
                                        aVar.az(c2);
                                        ArrayList arrayList = new ArrayList();
                                        z = false;
                                        Iterator it = aVar.itG.iterator();
                                        while (it.hasNext()) {
                                            bVar = (b) it.next();
                                            IDKey iDKey = new IDKey(bVar.aRI, bVar.itH, bVar.itI);
                                            boolean z2 = bVar.itJ;
                                            arrayList.add(iDKey);
                                            v.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, idkeyGroupStat, id:" + bVar.aRI + ", key:" + bVar.itH + ", value:" + bVar.itI + ", isImportant" + z2);
                                            z = z2;
                                        }
                                        g gVar = g.iuh;
                                        g.d(arrayList, z);
                                    } catch (IOException e) {
                                        v.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + e.getMessage());
                                        i = i2;
                                    }
                                } else {
                                    bVar = new b();
                                    try {
                                        bVar.az(c2);
                                        long j = (long) bVar.aRI;
                                        long j2 = (long) bVar.itH;
                                        long j3 = (long) bVar.itI;
                                        boolean z3 = bVar.itJ;
                                        v.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportidkey, id:" + j + ", key:" + j2 + ", value:" + j3 + ", isImportant" + z3);
                                        g.iuh.a(j, j2, j3, z3);
                                    } catch (IOException e2) {
                                        v.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + e2.getMessage());
                                        i = i2;
                                    }
                                }
                            } else {
                                c cVar = new c();
                                try {
                                    cVar.az(c2);
                                    aA = cVar.itQ;
                                    String str = cVar.itR;
                                    boolean z4 = cVar.itJ;
                                    z = cVar.itS;
                                    v.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportkvcomm, logid:" + aA + ", value:" + str + ", isReportNow:" + z + ", isImportant" + z4);
                                    g.iuh.a(aA, str, z, z4);
                                } catch (IOException e22) {
                                    v.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(kvcomm), IOException:" + e22.getMessage());
                                    i = i2;
                                }
                            }
                            v.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, curLen:" + i2);
                            i = i2;
                        }
                        v.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, read to end, deletefile:" + absolutePath);
                        b.deleteFile(absolutePath);
                    }
                }
            }
            return;
        }
        v.w("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filepath:" + filePath + " not exist.");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(int r5, java.lang.String r6, boolean r7, boolean r8) {
        /*
        r0 = filePath;
        r0 = com.tencent.mm.a.e.aR(r0);
        if (r0 != 0) goto L_0x004d;
    L_0x0008:
        r0 = "MicroMsg.ReportManagerKvCheck";
        r1 = new java.lang.StringBuilder;
        r2 = "saveKVcommData, filepath:";
        r1.<init>(r2);
        r2 = filePath;
        r1 = r1.append(r2);
        r2 = " not exist , logId:";
        r1 = r1.append(r2);
        r1 = r1.append(r5);
        r2 = ", val:";
        r1 = r1.append(r2);
        r1 = r1.append(r6);
        r2 = ", isImportant:";
        r1 = r1.append(r2);
        r1 = r1.append(r8);
        r2 = ", reportnow:";
        r1 = r1.append(r2);
        r1 = r1.append(r7);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
    L_0x004c:
        return;
    L_0x004d:
        r0 = "MicroMsg.ReportManagerKvCheck";
        r1 = new java.lang.StringBuilder;
        r2 = "saveKVcommData, logId:";
        r1.<init>(r2);
        r1 = r1.append(r5);
        r2 = ", val:";
        r1 = r1.append(r2);
        r1 = r1.append(r6);
        r2 = ", isImportant:";
        r1 = r1.append(r2);
        r1 = r1.append(r8);
        r2 = ", reportnow:";
        r1 = r1.append(r2);
        r1 = r1.append(r7);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        r0 = aKB();
        r1 = "MM";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x00d5;
    L_0x0091:
        r1 = "MicroMsg.ReportManagerKvCheck";
        r2 = new java.lang.StringBuilder;
        r3 = "error path, invalid processname:";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r2 = ", logId:";
        r0 = r0.append(r2);
        r0 = r0.append(r5);
        r2 = ", val:";
        r0 = r0.append(r2);
        r0 = r0.append(r6);
        r2 = ", isImportant:";
        r0 = r0.append(r2);
        r0 = r0.append(r8);
        r2 = ", reportnow:";
        r0 = r0.append(r2);
        r0 = r0.append(r7);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.v.e(r1, r0);
        goto L_0x004c;
    L_0x00d5:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = filePath;
        r1 = r1.append(r2);
        r0 = r1.append(r0);
        r1 = ".statictis";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r1 = new com.tencent.mm.plugin.report.service.c;
        r1.<init>();
        r1.itQ = r5;
        r1.itR = r6;
        r1.itJ = r8;
        r1.itS = r7;
        r1 = r1.toByteArray();	 Catch:{ IOException -> 0x010d }
        if (r1 != 0) goto L_0x012a;
    L_0x0102:
        r0 = "MicroMsg.ReportManagerKvCheck";
        r1 = "saveKVcommData, null == temp.";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        goto L_0x004c;
    L_0x010d:
        r0 = move-exception;
        r1 = "MicroMsg.ReportManagerKvCheck";
        r2 = new java.lang.StringBuilder;
        r3 = "saveIDKeyData, IOException, detail:";
        r2.<init>(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.v.e(r1, r0);
        goto L_0x004c;
    L_0x012a:
        r2 = itV;
        monitor-enter(r2);
        r3 = r1.length;	 Catch:{ all -> 0x0158 }
        r3 = oQ(r3);	 Catch:{ all -> 0x0158 }
        r3 = com.tencent.mm.a.e.e(r0, r3);	 Catch:{ all -> 0x0158 }
        if (r3 == 0) goto L_0x015b;
    L_0x0138:
        r1 = "MicroMsg.ReportManagerKvCheck";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0158 }
        r4 = "saveKVcommData, write obj_len to file:";
        r3.<init>(r4);	 Catch:{ all -> 0x0158 }
        r0 = r3.append(r0);	 Catch:{ all -> 0x0158 }
        r3 = " fail.";
        r0 = r0.append(r3);	 Catch:{ all -> 0x0158 }
        r0 = r0.toString();	 Catch:{ all -> 0x0158 }
        com.tencent.mm.sdk.platformtools.v.e(r1, r0);	 Catch:{ all -> 0x0158 }
        monitor-exit(r2);	 Catch:{ all -> 0x0158 }
        goto L_0x004c;
    L_0x0158:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0158 }
        throw r0;
    L_0x015b:
        r1 = com.tencent.mm.a.e.e(r0, r1);	 Catch:{ all -> 0x0158 }
        if (r1 == 0) goto L_0x017e;
    L_0x0161:
        r1 = "MicroMsg.ReportManagerKvCheck";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0158 }
        r4 = "saveKVcommData, write object to file:";
        r3.<init>(r4);	 Catch:{ all -> 0x0158 }
        r0 = r3.append(r0);	 Catch:{ all -> 0x0158 }
        r3 = " fail.";
        r0 = r0.append(r3);	 Catch:{ all -> 0x0158 }
        r0 = r0.toString();	 Catch:{ all -> 0x0158 }
        com.tencent.mm.sdk.platformtools.v.e(r1, r0);	 Catch:{ all -> 0x0158 }
    L_0x017e:
        monitor-exit(r2);	 Catch:{ all -> 0x0158 }
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.report.service.e.b(int, java.lang.String, boolean, boolean):void");
    }

    public static void e(int i, int i2, int i3, boolean z) {
        v.i("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, id:" + i + ", key:" + i2 + ", value:" + i3 + ", isImportant:" + z);
        if (com.tencent.mm.a.e.aR(filePath)) {
            String aKB = aKB();
            if ("MM".equals(aKB)) {
                v.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:" + aKB + ", id:" + i + ", key:" + i2 + ", val:" + i3 + ", isImportant:" + z);
                return;
            }
            aKB = filePath + aKB + ".monitor";
            b bVar = new b();
            bVar.aRI = i;
            bVar.itH = i2;
            bVar.itI = i3;
            bVar.itJ = z;
            try {
                byte[] toByteArray = bVar.toByteArray();
                if (toByteArray == null) {
                    v.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, null == temp.");
                    return;
                }
                synchronized (itV) {
                    if (com.tencent.mm.a.e.e(aKB, oQ(toByteArray.length)) != 0) {
                        v.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write obj_len to file:" + aKB + " fail.");
                        return;
                    }
                    if (com.tencent.mm.a.e.e(aKB, toByteArray) != 0) {
                        v.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write object to file:" + aKB + " fail.");
                    }
                    v.d("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, fileLength:" + com.tencent.mm.a.e.aQ(aKB));
                    return;
                }
            } catch (IOException e) {
                v.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + e.getMessage());
                return;
            }
        }
        v.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, filepath:" + filePath + " not exist , Id:" + i + ", key:" + i2 + ", value:" + i3 + ", isImportant:" + z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(java.util.ArrayList<com.tencent.mars.smc.SmcLogic.IDKey> r8, boolean r9) {
        /*
        r1 = r8.iterator();
    L_0x0004:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0054;
    L_0x000a:
        r0 = r1.next();
        r0 = (com.tencent.mars.smc.SmcLogic.IDKey) r0;
        r2 = "MicroMsg.ReportManagerKvCheck";
        r3 = new java.lang.StringBuilder;
        r4 = "saveGroupIDKeyData, id:";
        r3.<init>(r4);
        r4 = r0.GetID();
        r3 = r3.append(r4);
        r4 = ", key:";
        r3 = r3.append(r4);
        r4 = r0.GetKey();
        r3 = r3.append(r4);
        r4 = ", value:";
        r3 = r3.append(r4);
        r4 = r0.GetValue();
        r0 = r3.append(r4);
        r3 = ", isImportant:";
        r0 = r0.append(r3);
        r0 = r0.append(r9);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.v.i(r2, r0);
        goto L_0x0004;
    L_0x0054:
        r0 = filePath;
        r0 = com.tencent.mm.a.e.aR(r0);
        if (r0 != 0) goto L_0x007c;
    L_0x005c:
        r0 = "MicroMsg.ReportManagerKvCheck";
        r1 = new java.lang.StringBuilder;
        r2 = "saveGroupIDKeyData, filepath:";
        r1.<init>(r2);
        r2 = filePath;
        r1 = r1.append(r2);
        r2 = " not exist ";
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
    L_0x007b:
        return;
    L_0x007c:
        r0 = aKB();
        r1 = "MM";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x00a0;
    L_0x0089:
        r1 = "MicroMsg.ReportManagerKvCheck";
        r2 = new java.lang.StringBuilder;
        r3 = "error path, current processname:";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.v.e(r1, r0);
        goto L_0x007b;
    L_0x00a0:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = filePath;
        r1 = r1.append(r2);
        r0 = r1.append(r0);
        r1 = ".group_monitor";
        r0 = r0.append(r1);
        r1 = r0.toString();
        r2 = new com.tencent.mm.plugin.report.service.a;
        r2.<init>();
        r0 = r8.size();
        r2.eet = r0;
        r3 = r8.iterator();
    L_0x00c9:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x00f7;
    L_0x00cf:
        r0 = r3.next();
        r0 = (com.tencent.mars.smc.SmcLogic.IDKey) r0;
        r4 = new com.tencent.mm.plugin.report.service.b;
        r4.<init>();
        r6 = r0.GetID();
        r5 = (int) r6;
        r4.aRI = r5;
        r6 = r0.GetKey();
        r5 = (int) r6;
        r4.itH = r5;
        r6 = r0.GetValue();
        r0 = (int) r6;
        r4.itI = r0;
        r4.itJ = r9;
        r0 = r2.itG;
        r0.add(r4);
        goto L_0x00c9;
    L_0x00f7:
        r0 = r2.toByteArray();	 Catch:{ IOException -> 0x0108 }
        if (r0 != 0) goto L_0x0125;
    L_0x00fd:
        r0 = "MicroMsg.ReportManagerKvCheck";
        r1 = "saveGroupIDKeyData, null == temp.";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        goto L_0x007b;
    L_0x0108:
        r0 = move-exception;
        r1 = "MicroMsg.ReportManagerKvCheck";
        r2 = new java.lang.StringBuilder;
        r3 = "saveGroupIDKeyData, IOException, detail:";
        r2.<init>(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.v.e(r1, r0);
        goto L_0x007b;
    L_0x0125:
        r2 = itV;
        monitor-enter(r2);
        r3 = r0.length;	 Catch:{ all -> 0x0153 }
        r3 = oQ(r3);	 Catch:{ all -> 0x0153 }
        r3 = com.tencent.mm.a.e.e(r1, r3);	 Catch:{ all -> 0x0153 }
        if (r3 == 0) goto L_0x0156;
    L_0x0133:
        r0 = "MicroMsg.ReportManagerKvCheck";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0153 }
        r4 = "saveGroupIDKeyData, write obj_len to file:";
        r3.<init>(r4);	 Catch:{ all -> 0x0153 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0153 }
        r3 = " fail.";
        r1 = r1.append(r3);	 Catch:{ all -> 0x0153 }
        r1 = r1.toString();	 Catch:{ all -> 0x0153 }
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);	 Catch:{ all -> 0x0153 }
        monitor-exit(r2);	 Catch:{ all -> 0x0153 }
        goto L_0x007b;
    L_0x0153:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0153 }
        throw r0;
    L_0x0156:
        r0 = com.tencent.mm.a.e.e(r1, r0);	 Catch:{ all -> 0x0153 }
        if (r0 == 0) goto L_0x0179;
    L_0x015c:
        r0 = "MicroMsg.ReportManagerKvCheck";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0153 }
        r4 = "saveGroupIDKeyData, write object to file:";
        r3.<init>(r4);	 Catch:{ all -> 0x0153 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0153 }
        r3 = " fail.";
        r1 = r1.append(r3);	 Catch:{ all -> 0x0153 }
        r1 = r1.toString();	 Catch:{ all -> 0x0153 }
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);	 Catch:{ all -> 0x0153 }
    L_0x0179:
        monitor-exit(r2);	 Catch:{ all -> 0x0153 }
        goto L_0x007b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.report.service.e.c(java.util.ArrayList, boolean):void");
    }

    private static String aKB() {
        String processName = aa.getProcessName();
        if (processName == null || processName.length() == 0) {
            return "MM";
        }
        String[] split = processName.split(":");
        if (split.length <= 1) {
            return "MM";
        }
        return split[1];
    }

    private static byte[] oQ(int i) {
        return new byte[]{(byte) ((i >> 24) & WebView.NORMAL_MODE_ALPHA), (byte) ((i >> 16) & WebView.NORMAL_MODE_ALPHA), (byte) ((i >> 8) & WebView.NORMAL_MODE_ALPHA), (byte) (i & WebView.NORMAL_MODE_ALPHA)};
    }

    private static int aA(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (i < 4) {
            i2 += (bArr[i] & WebView.NORMAL_MODE_ALPHA) << ((3 - i) * 8);
            i++;
        }
        return i2;
    }
}
