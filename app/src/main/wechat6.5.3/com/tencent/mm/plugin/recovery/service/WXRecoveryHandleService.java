package com.tencent.mm.plugin.recovery.service;

import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.bc.d;
import com.tencent.mm.plugin.recovery.a.a;
import com.tencent.mm.plugin.recovery.a.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.recovery.b;
import com.tencent.recovery.model.RecoveryHandleInfo;
import com.tencent.recovery.service.RecoveryExceptionHandleService;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import org.json.JSONObject;

public class WXRecoveryHandleService extends RecoveryExceptionHandleService {
    private d irf;

    public void onCreate() {
        super.onCreate();
        this.irf = new d();
        this.irf.open();
        b.a(this.irf);
    }

    public void onDestroy() {
        this.irf.close();
        super.onDestroy();
        int myPid = Process.myPid();
        b.yH(13);
        Process.killProcess(myPid);
    }

    protected final boolean a(Context context, int i, RecoveryHandleInfo recoveryHandleInfo) {
        FileOutputStream fileOutputStream;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        boolean z = true;
        boolean z2 = false;
        c aJX = c.aJX();
        aJX.aJY();
        aJX.yB("KeyTotalCount");
        this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "recoveryConfigUrl %s", recoveryHandleInfo.pud);
        String a = a((Context) this, r2, aJX);
        if (a != null) {
            JSONObject jSONObject;
            this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "recoveryConfigStr is %s", a);
            try {
                jSONObject = new JSONObject(a);
            } catch (Exception e) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                int i2;
                int optInt = jSONObject.optInt("abTestBaseNumber", -1);
                int optInt2 = jSONObject.optInt("abTestReminder", -1);
                String optString = jSONObject.optString("patchPackageUrl", "");
                String optString2 = jSONObject.optString("patchPackageMd5", "");
                if (i % optInt == optInt2) {
                    i2 = 1;
                } else {
                    boolean z3 = false;
                }
                if (i2 != 0) {
                    this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "patchPackageUrl=%s", optString);
                    byte[] a2 = a(this, optString, optString2, aJX);
                    if (a2 != null) {
                        String str = context.getCacheDir() + "/recovery.patch";
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                        try {
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                fileOutputStream.write(a2);
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e2) {
                                }
                            } catch (Exception e3) {
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e4) {
                                    }
                                }
                                if (file.exists()) {
                                    this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "start to patch file", new Object[0]);
                                    a.a(MMApplicationLike.getTinkerApplicationLike());
                                    i2 = a.am(context, str);
                                    if (i2 != 0) {
                                        aJX.yB("KeyPatchStartFailCount[" + i2 + "]");
                                        this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "patch fail tinkerPatchCode=%d", Integer.valueOf(i2));
                                    } else {
                                        aJX.yB("KeyPatchStartSuccessCount");
                                        this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "start patch file", new Object[0]);
                                    }
                                    z2 = z;
                                    if (c.a(this, i, aJX)) {
                                        aJX.aJZ();
                                    } else {
                                        c.aKa();
                                    }
                                    return z2;
                                }
                                aJX.yB("KeyCheckPatchMd5FailCount");
                                this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "patch file save fail", new Object[0]);
                                if (c.a(this, i, aJX)) {
                                    c.aKa();
                                } else {
                                    aJX.aJZ();
                                }
                                return z2;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream2 = fileOutputStream;
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e6) {
                            fileOutputStream = null;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (file.exists()) {
                                aJX.yB("KeyCheckPatchMd5FailCount");
                                this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "patch file save fail", new Object[0]);
                                if (c.a(this, i, aJX)) {
                                    aJX.aJZ();
                                } else {
                                    c.aKa();
                                }
                                return z2;
                            }
                            this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "start to patch file", new Object[0]);
                            a.a(MMApplicationLike.getTinkerApplicationLike());
                            i2 = a.am(context, str);
                            if (i2 != 0) {
                                aJX.yB("KeyPatchStartSuccessCount");
                                this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "start patch file", new Object[0]);
                            } else {
                                aJX.yB("KeyPatchStartFailCount[" + i2 + "]");
                                this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "patch fail tinkerPatchCode=%d", Integer.valueOf(i2));
                            }
                            z2 = z;
                            if (c.a(this, i, aJX)) {
                                c.aKa();
                            } else {
                                aJX.aJZ();
                            }
                            return z2;
                        } catch (Throwable th3) {
                            th = th3;
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            throw th;
                        }
                        if (file.exists()) {
                            this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "start to patch file", new Object[0]);
                            a.a(MMApplicationLike.getTinkerApplicationLike());
                            i2 = a.am(context, str);
                            if (i2 != 0) {
                                aJX.yB("KeyPatchStartFailCount[" + i2 + "]");
                                this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "patch fail tinkerPatchCode=%d", Integer.valueOf(i2));
                            } else {
                                aJX.yB("KeyPatchStartSuccessCount");
                                this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "start patch file", new Object[0]);
                            }
                        } else {
                            aJX.yB("KeyCheckPatchMd5FailCount");
                            this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "patch file save fail", new Object[0]);
                        }
                    } else {
                        this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "get patch data fail", new Object[0]);
                    }
                } else {
                    this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "no need recovery", new Object[0]);
                    aJX.yB("KeyPatchNoNeedCount");
                }
            } else {
                this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "parse config fail", new Object[0]);
                aJX.yB("KeyConfigParseFailCount");
                z = false;
            }
            z2 = z;
        } else {
            this.irf.i("MicroMsg.Recovery.WXRecoveryHandleService", "recoveryConfigStr is null", new Object[0]);
        }
        if (c.a(this, i, aJX)) {
            c.aKa();
        } else {
            aJX.aJZ();
        }
        return z2;
    }

    private static java.lang.String a(android.content.Context r10, java.lang.String r11, com.tencent.mm.plugin.recovery.a.c r12) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.mm.plugin.recovery.service.WXRecoveryHandleService.a(android.content.Context, java.lang.String, com.tencent.mm.plugin.recovery.a.c):java.lang.String. bs: [B:47:0x00cd, B:52:0x00db]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = 0;
        r1 = 0;
        r0 = "file://";
        r0 = r11.startsWith(r0);
        if (r0 == 0) goto L_0x0075;
    L_0x000b:
        r0 = "file://";
        r2 = "";
        r0 = r11.replace(r0, r2);
        r2 = new java.io.File;
        r2.<init>(r0);
        r0 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0060, all -> 0x006c }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0060, all -> 0x006c }
        r4 = com.tencent.mm.loader.stub.b.d(r0);	 Catch:{ Exception -> 0x01bf, all -> 0x01b9 }
        r0.close();	 Catch:{ IOException -> 0x018d }
    L_0x0026:
        if (r4 == 0) goto L_0x018a;
    L_0x0028:
        r0 = com.tencent.mm.a.g.m(r4);	 Catch:{ Exception -> 0x0160 }
        r2 = "MicroMsg.Recovery.WXRecoveryHandleService";	 Catch:{ Exception -> 0x0160 }
        r3 = "config data md5=%s";	 Catch:{ Exception -> 0x0160 }
        r5 = 1;	 Catch:{ Exception -> 0x0160 }
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0160 }
        r6 = 0;	 Catch:{ Exception -> 0x0160 }
        r5[r6] = r0;	 Catch:{ Exception -> 0x0160 }
        com.tencent.recovery.c.b.i(r2, r3, r5);	 Catch:{ Exception -> 0x0160 }
        r2 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC0oMW80k4h7zmBbHGhzQzs5Jv1uy5j0JVUG//dWHeu0q6PF/xCU97h/e6h2Q9SXLu0M4TTd89QMXbab9MMUXrxqIqVjzm92A4WyNbAElAwhE9AGO16ryYn+tNzDfmwyjVz6dwLzZbNjjH7akYZRopJYqo17kKn+xrnqM+GRKMOJQIDAQAB";	 Catch:{ Exception -> 0x0160 }
        r2 = com.tencent.mm.bc.b.e(r4, r2);	 Catch:{ Exception -> 0x0160 }
        if (r2 != 0) goto L_0x0146;	 Catch:{ Exception -> 0x0160 }
    L_0x0044:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0160 }
        r3 = "KeyConfigDecryptFail[";	 Catch:{ Exception -> 0x0160 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0160 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0160 }
        r2 = "]";	 Catch:{ Exception -> 0x0160 }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x0160 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0160 }
        r12.yB(r0);	 Catch:{ Exception -> 0x0160 }
        r0 = r1;
    L_0x005f:
        return r0;
    L_0x0060:
        r0 = move-exception;
        r0 = r1;
    L_0x0062:
        if (r0 == 0) goto L_0x0073;
    L_0x0064:
        r0.close();	 Catch:{ IOException -> 0x0069 }
        r4 = r1;
        goto L_0x0026;
    L_0x0069:
        r0 = move-exception;
        r4 = r1;
        goto L_0x0026;
    L_0x006c:
        r0 = move-exception;
    L_0x006d:
        if (r1 == 0) goto L_0x0072;
    L_0x006f:
        r1.close();	 Catch:{ IOException -> 0x0190 }
    L_0x0072:
        throw r0;
    L_0x0073:
        r4 = r1;
        goto L_0x0026;
    L_0x0075:
        r0 = com.tencent.mm.bc.b.JH(r11);
        r2 = new java.net.URL;	 Catch:{ Exception -> 0x01a4, all -> 0x019a }
        r2.<init>(r0);	 Catch:{ Exception -> 0x01a4, all -> 0x019a }
        r0 = r2.openConnection();	 Catch:{ Exception -> 0x01a4, all -> 0x019a }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x01a4, all -> 0x019a }
        r2 = "GET";	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
        r0.setRequestMethod(r2);	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
        r0.setConnectTimeout(r2);	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
        r2 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
        r0.setReadTimeout(r2);	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
        r0.connect();	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
        r2 = r0.getResponseCode();	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
        if (r2 == r3) goto L_0x00c7;	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
    L_0x009f:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
        r4 = "KeyConfigHttpCode[";	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
        r3.<init>(r4);	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
        r2 = r3.append(r2);	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
        r3 = "]";	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
        r2 = r2.toString();	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
        r12.yB(r2);	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
        r3 = r1;
        r4 = r1;
    L_0x00bb:
        if (r3 == 0) goto L_0x00c0;
    L_0x00bd:
        r3.close();	 Catch:{ IOException -> 0x0193 }
    L_0x00c0:
        if (r0 == 0) goto L_0x0026;
    L_0x00c2:
        r0.disconnect();
        goto L_0x0026;
    L_0x00c7:
        r3 = r0.getInputStream();	 Catch:{ Exception -> 0x01aa, all -> 0x019d }
        if (r3 != 0) goto L_0x00d5;
    L_0x00cd:
        r2 = "KeyConfigHttpInputStreamIsNull";	 Catch:{ Exception -> 0x01b1, all -> 0x0136 }
        r12.yB(r2);	 Catch:{ Exception -> 0x01b1, all -> 0x0136 }
        r4 = r1;	 Catch:{ Exception -> 0x01b1, all -> 0x0136 }
        goto L_0x00bb;	 Catch:{ Exception -> 0x01b1, all -> 0x0136 }
    L_0x00d5:
        r4 = d(r3);	 Catch:{ Exception -> 0x01b1, all -> 0x0136 }
        if (r4 != 0) goto L_0x012c;
    L_0x00db:
        r2 = "KeyConfigHttpInputStreamReadDataIsNull";	 Catch:{ Exception -> 0x00e2, all -> 0x0136 }
        r12.yB(r2);	 Catch:{ Exception -> 0x00e2, all -> 0x0136 }
        goto L_0x00bb;
    L_0x00e2:
        r2 = move-exception;
        r9 = r2;
        r2 = r3;
        r3 = r0;
        r0 = r9;
    L_0x00e7:
        r5 = "MicroMsg.Recovery.WXRecoveryHandleService";	 Catch:{ all -> 0x01a1 }
        r6 = "getConfigData";	 Catch:{ all -> 0x01a1 }
        r7 = 0;	 Catch:{ all -> 0x01a1 }
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x01a1 }
        com.tencent.recovery.c.b.a(r5, r0, r6, r7);	 Catch:{ all -> 0x01a1 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01a1 }
        r6 = "Config HttpInputStream Exception: [";	 Catch:{ all -> 0x01a1 }
        r5.<init>(r6);	 Catch:{ all -> 0x01a1 }
        r6 = hH(r10);	 Catch:{ all -> 0x01a1 }
        r5 = r5.append(r6);	 Catch:{ all -> 0x01a1 }
        r6 = "][";	 Catch:{ all -> 0x01a1 }
        r5 = r5.append(r6);	 Catch:{ all -> 0x01a1 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x01a1 }
        r0 = r5.append(r0);	 Catch:{ all -> 0x01a1 }
        r5 = "]";	 Catch:{ all -> 0x01a1 }
        r0 = r0.append(r5);	 Catch:{ all -> 0x01a1 }
        r0 = r0.toString();	 Catch:{ all -> 0x01a1 }
        r12.yB(r0);	 Catch:{ all -> 0x01a1 }
        if (r2 == 0) goto L_0x0125;
    L_0x0122:
        r2.close();	 Catch:{ IOException -> 0x0196 }
    L_0x0125:
        if (r3 == 0) goto L_0x0026;
    L_0x0127:
        r3.disconnect();
        goto L_0x0026;
    L_0x012c:
        r2 = r4.length;	 Catch:{ Exception -> 0x00e2, all -> 0x0136 }
        if (r2 != 0) goto L_0x00bb;	 Catch:{ Exception -> 0x00e2, all -> 0x0136 }
    L_0x012f:
        r2 = "KeyConfigHttpInputStreamReadDataLengthZero";	 Catch:{ Exception -> 0x00e2, all -> 0x0136 }
        r12.yB(r2);	 Catch:{ Exception -> 0x00e2, all -> 0x0136 }
        goto L_0x00bb;
    L_0x0136:
        r1 = move-exception;
        r9 = r1;
        r1 = r3;
        r3 = r0;
        r0 = r9;
    L_0x013b:
        if (r1 == 0) goto L_0x0140;
    L_0x013d:
        r1.close();	 Catch:{ IOException -> 0x0198 }
    L_0x0140:
        if (r3 == 0) goto L_0x0145;
    L_0x0142:
        r3.disconnect();
    L_0x0145:
        throw r0;
    L_0x0146:
        r0 = "MicroMsg.Recovery.WXRecoveryHandleService";	 Catch:{ Exception -> 0x0160 }
        r3 = "config data decrypt md5=%s";	 Catch:{ Exception -> 0x0160 }
        r4 = 1;	 Catch:{ Exception -> 0x0160 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0160 }
        r5 = 0;	 Catch:{ Exception -> 0x0160 }
        r6 = com.tencent.mm.a.g.m(r2);	 Catch:{ Exception -> 0x0160 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0160 }
        com.tencent.recovery.c.b.i(r0, r3, r4);	 Catch:{ Exception -> 0x0160 }
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x0160 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0160 }
        goto L_0x005f;
    L_0x0160:
        r0 = move-exception;
        r2 = "MicroMsg.Recovery.WXRecoveryHandleService";
        r3 = "getConfigData";
        r4 = new java.lang.Object[r8];
        com.tencent.recovery.c.b.a(r2, r0, r3, r4);
        r2 = new java.lang.StringBuilder;
        r3 = "Config Decrypt Exception: [";
        r2.<init>(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r2 = "]";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r12.yB(r0);
    L_0x018a:
        r0 = r1;
        goto L_0x005f;
    L_0x018d:
        r0 = move-exception;
        goto L_0x0026;
    L_0x0190:
        r1 = move-exception;
        goto L_0x0072;
    L_0x0193:
        r2 = move-exception;
        goto L_0x00c0;
    L_0x0196:
        r0 = move-exception;
        goto L_0x0125;
    L_0x0198:
        r1 = move-exception;
        goto L_0x0140;
    L_0x019a:
        r0 = move-exception;
        r3 = r1;
        goto L_0x013b;
    L_0x019d:
        r2 = move-exception;
        r3 = r0;
        r0 = r2;
        goto L_0x013b;
    L_0x01a1:
        r0 = move-exception;
        r1 = r2;
        goto L_0x013b;
    L_0x01a4:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
        r4 = r1;
        goto L_0x00e7;
    L_0x01aa:
        r2 = move-exception;
        r3 = r0;
        r4 = r1;
        r0 = r2;
        r2 = r1;
        goto L_0x00e7;
    L_0x01b1:
        r2 = move-exception;
        r4 = r1;
        r9 = r3;
        r3 = r0;
        r0 = r2;
        r2 = r9;
        goto L_0x00e7;
    L_0x01b9:
        r1 = move-exception;
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x006d;
    L_0x01bf:
        r2 = move-exception;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recovery.service.WXRecoveryHandleService.a(android.content.Context, java.lang.String, com.tencent.mm.plugin.recovery.a.c):java.lang.String");
    }

    private static byte[] a(android.content.Context r8, java.lang.String r9, java.lang.String r10, com.tencent.mm.plugin.recovery.a.c r11) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.mm.plugin.recovery.service.WXRecoveryHandleService.a(android.content.Context, java.lang.String, java.lang.String, com.tencent.mm.plugin.recovery.a.c):byte[]. bs: [B:41:0x0092, B:57:0x00ea]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r1 = 0;
        r0 = "file://";
        r0 = r9.startsWith(r0);
        if (r0 == 0) goto L_0x003b;
    L_0x000a:
        r0 = "file://";
        r2 = "";
        r0 = r9.replace(r0, r2);
        r3 = new java.io.File;
        r3.<init>(r0);
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0026, all -> 0x0032 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0026, all -> 0x0032 }
        r0 = d(r2);	 Catch:{ Exception -> 0x0150, all -> 0x014c }
        r2.close();	 Catch:{ IOException -> 0x0122 }
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = move-exception;
        r0 = r1;
    L_0x0028:
        if (r0 == 0) goto L_0x0039;
    L_0x002a:
        r0.close();	 Catch:{ IOException -> 0x002f }
        r0 = r1;
        goto L_0x0025;
    L_0x002f:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0025;
    L_0x0032:
        r0 = move-exception;
    L_0x0033:
        if (r1 == 0) goto L_0x0038;
    L_0x0035:
        r1.close();	 Catch:{ IOException -> 0x0125 }
    L_0x0038:
        throw r0;
    L_0x0039:
        r0 = r1;
        goto L_0x0025;
    L_0x003b:
        r0 = com.tencent.mm.bc.b.JH(r9);
        r2 = new java.net.URL;	 Catch:{ Exception -> 0x013c, all -> 0x0115 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x013c, all -> 0x0115 }
        r0 = r2.openConnection();	 Catch:{ Exception -> 0x013c, all -> 0x0115 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x013c, all -> 0x0115 }
        r2 = "GET";	 Catch:{ Exception -> 0x0144, all -> 0x012f }
        r0.setRequestMethod(r2);	 Catch:{ Exception -> 0x0144, all -> 0x012f }
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ Exception -> 0x0144, all -> 0x012f }
        r0.setConnectTimeout(r2);	 Catch:{ Exception -> 0x0144, all -> 0x012f }
        r2 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;	 Catch:{ Exception -> 0x0144, all -> 0x012f }
        r0.setReadTimeout(r2);	 Catch:{ Exception -> 0x0144, all -> 0x012f }
        r0.connect();	 Catch:{ Exception -> 0x0144, all -> 0x012f }
        r2 = r0.getResponseCode();	 Catch:{ Exception -> 0x0144, all -> 0x012f }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x0144, all -> 0x012f }
        if (r2 == r3) goto L_0x008c;	 Catch:{ Exception -> 0x0144, all -> 0x012f }
    L_0x0065:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0144, all -> 0x012f }
        r4 = "KeyPatchHttpCode[";	 Catch:{ Exception -> 0x0144, all -> 0x012f }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0144, all -> 0x012f }
        r2 = r3.append(r2);	 Catch:{ Exception -> 0x0144, all -> 0x012f }
        r3 = "]";	 Catch:{ Exception -> 0x0144, all -> 0x012f }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0144, all -> 0x012f }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0144, all -> 0x012f }
        r11.yB(r2);	 Catch:{ Exception -> 0x0144, all -> 0x012f }
        r3 = r1;
    L_0x0080:
        if (r3 == 0) goto L_0x0085;
    L_0x0082:
        r3.close();	 Catch:{ IOException -> 0x0128 }
    L_0x0085:
        if (r0 == 0) goto L_0x0154;
    L_0x0087:
        r0.disconnect();
        r0 = r1;
        goto L_0x0025;
    L_0x008c:
        r3 = r0.getInputStream();	 Catch:{ Exception -> 0x0144, all -> 0x012f }
        if (r3 != 0) goto L_0x00e4;
    L_0x0092:
        r2 = "KeyPatchHttpInputStreamIsNull";	 Catch:{ Exception -> 0x0099, all -> 0x0133 }
        r11.yB(r2);	 Catch:{ Exception -> 0x0099, all -> 0x0133 }
        goto L_0x0080;
    L_0x0099:
        r2 = move-exception;
        r7 = r2;
        r2 = r3;
        r3 = r0;
        r0 = r1;
        r1 = r7;
    L_0x009f:
        r4 = "MicroMsg.Recovery.WXRecoveryHandleService";	 Catch:{ all -> 0x0139 }
        r5 = "getPatchDataFromHttp";	 Catch:{ all -> 0x0139 }
        r6 = 0;	 Catch:{ all -> 0x0139 }
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0139 }
        com.tencent.recovery.c.b.a(r4, r1, r5, r6);	 Catch:{ all -> 0x0139 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0139 }
        r5 = "Patch HttpInputStream Exception: [";	 Catch:{ all -> 0x0139 }
        r4.<init>(r5);	 Catch:{ all -> 0x0139 }
        r5 = hH(r8);	 Catch:{ all -> 0x0139 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0139 }
        r5 = "][";	 Catch:{ all -> 0x0139 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0139 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0139 }
        r1 = r4.append(r1);	 Catch:{ all -> 0x0139 }
        r4 = "]";	 Catch:{ all -> 0x0139 }
        r1 = r1.append(r4);	 Catch:{ all -> 0x0139 }
        r1 = r1.toString();	 Catch:{ all -> 0x0139 }
        r11.yB(r1);	 Catch:{ all -> 0x0139 }
        if (r2 == 0) goto L_0x00dd;
    L_0x00da:
        r2.close();	 Catch:{ IOException -> 0x012b }
    L_0x00dd:
        if (r3 == 0) goto L_0x0025;
    L_0x00df:
        r3.disconnect();
        goto L_0x0025;
    L_0x00e4:
        r2 = com.tencent.mm.loader.stub.b.d(r3);	 Catch:{ Exception -> 0x0099, all -> 0x0133 }
        if (r2 != 0) goto L_0x00f2;
    L_0x00ea:
        r1 = "KeyPatchHttpInputStreamReadDataIsNull";	 Catch:{ Exception -> 0x010f, all -> 0x0133 }
        r11.yB(r1);	 Catch:{ Exception -> 0x010f, all -> 0x0133 }
        r1 = r2;	 Catch:{ Exception -> 0x010f, all -> 0x0133 }
        goto L_0x0080;	 Catch:{ Exception -> 0x010f, all -> 0x0133 }
    L_0x00f2:
        r4 = r2.length;	 Catch:{ Exception -> 0x010f, all -> 0x0133 }
        if (r4 != 0) goto L_0x00fd;	 Catch:{ Exception -> 0x010f, all -> 0x0133 }
    L_0x00f5:
        r1 = "KeyPatchHttpInputStreamReadDataLengthZero";	 Catch:{ Exception -> 0x010f, all -> 0x0133 }
        r11.yB(r1);	 Catch:{ Exception -> 0x010f, all -> 0x0133 }
        r1 = r2;	 Catch:{ Exception -> 0x010f, all -> 0x0133 }
        goto L_0x0080;	 Catch:{ Exception -> 0x010f, all -> 0x0133 }
    L_0x00fd:
        r4 = com.tencent.mm.a.g.m(r2);	 Catch:{ Exception -> 0x010f, all -> 0x0133 }
        r4 = r4.equals(r10);	 Catch:{ Exception -> 0x010f, all -> 0x0133 }
        if (r4 != 0) goto L_0x0157;	 Catch:{ Exception -> 0x010f, all -> 0x0133 }
    L_0x0107:
        r4 = "KeyPatchCheckMd5Fail";	 Catch:{ Exception -> 0x010f, all -> 0x0133 }
        r11.yB(r4);	 Catch:{ Exception -> 0x010f, all -> 0x0133 }
        goto L_0x0080;
    L_0x010f:
        r1 = move-exception;
        r7 = r3;
        r3 = r0;
        r0 = r2;
        r2 = r7;
        goto L_0x009f;
    L_0x0115:
        r0 = move-exception;
        r3 = r1;
    L_0x0117:
        if (r1 == 0) goto L_0x011c;
    L_0x0119:
        r1.close();	 Catch:{ IOException -> 0x012d }
    L_0x011c:
        if (r3 == 0) goto L_0x0121;
    L_0x011e:
        r3.disconnect();
    L_0x0121:
        throw r0;
    L_0x0122:
        r1 = move-exception;
        goto L_0x0025;
    L_0x0125:
        r1 = move-exception;
        goto L_0x0038;
    L_0x0128:
        r2 = move-exception;
        goto L_0x0085;
    L_0x012b:
        r1 = move-exception;
        goto L_0x00dd;
    L_0x012d:
        r1 = move-exception;
        goto L_0x011c;
    L_0x012f:
        r2 = move-exception;
        r3 = r0;
        r0 = r2;
        goto L_0x0117;
    L_0x0133:
        r1 = move-exception;
        r7 = r1;
        r1 = r3;
        r3 = r0;
        r0 = r7;
        goto L_0x0117;
    L_0x0139:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0117;
    L_0x013c:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
        r7 = r0;
        r0 = r1;
        r1 = r7;
        goto L_0x009f;
    L_0x0144:
        r2 = move-exception;
        r3 = r0;
        r0 = r1;
        r7 = r2;
        r2 = r1;
        r1 = r7;
        goto L_0x009f;
    L_0x014c:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0033;
    L_0x0150:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0028;
    L_0x0154:
        r0 = r1;
        goto L_0x0025;
    L_0x0157:
        r1 = r2;
        goto L_0x0080;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recovery.service.WXRecoveryHandleService.a(android.content.Context, java.lang.String, java.lang.String, com.tencent.mm.plugin.recovery.a.c):byte[]");
    }

    private static boolean bRR() {
        try {
            InetAddress byName = InetAddress.getByName("dldir1.qq.com");
            if (byName == null || byName.getHostAddress() == null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private static boolean bRS() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://www.qq.com").openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(Constants.THREAD_BITSET_SIZE);
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private static String hH(Context context) {
        String dO;
        if (ak.isConnected(context)) {
            dO = ak.dO(context);
        } else {
            dO = "NON_NETWORK";
        }
        return dO + "-" + bRR() + "-" + bRS() + "-" + ((PowerManager) context.getSystemService("power")).isScreenOn();
    }

    private static byte[] d(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
