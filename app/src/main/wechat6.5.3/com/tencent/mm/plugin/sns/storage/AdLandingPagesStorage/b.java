package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.os.AsyncTask;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class b extends AsyncTask<String, Void, String> {
    private static Set<String> jAS = Collections.synchronizedSet(new HashSet());
    private String filePath;
    private a jAT;
    private boolean jAy;
    private int jAz;
    private int scene;

    public interface a {
        void aRx();

        void aTV();

        void aUi();
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return u((String[]) objArr);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        if (((String) obj) == null) {
            this.jAT.aUi();
        } else {
            this.jAT.aTV();
        }
    }

    public b(String str, boolean z, int i, int i2, a aVar) {
        this.filePath = str;
        this.jAy = z;
        this.jAz = i;
        this.scene = i2;
        this.jAT = aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String u(java.lang.String... r14) {
        /*
        r13 = this;
        r0 = r13.filePath;
        r0 = com.tencent.mm.modelsfs.FileOp.aR(r0);
        if (r0 == 0) goto L_0x000a;
    L_0x0008:
        r0 = 0;
    L_0x0009:
        return r0;
    L_0x000a:
        r0 = jAS;
        r1 = 0;
        r1 = r14[r1];
        r0 = r0.contains(r1);
        if (r0 == 0) goto L_0x0019;
    L_0x0015:
        r0 = "downloading";
        goto L_0x0009;
    L_0x0019:
        r8 = com.tencent.mm.sdk.platformtools.be.Ni();
        r4 = 0;
        r5 = 0;
        r0 = jAS;
        r1 = 0;
        r1 = r14[r1];
        r0.add(r1);
        r0 = r13.filePath;
        r1 = 0;
        r2 = r13.filePath;
        r3 = "/";
        r2 = r2.lastIndexOf(r3);
        r0 = r0.substring(r1, r2);
        com.tencent.mm.modelsfs.FileOp.jS(r0);
        r3 = 0;
        r2 = 0;
        r1 = 0;
        r0 = r13.jAT;
        r0.aRx();
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x0433, all -> 0x0574 }
        r6 = 0;
        r6 = r14[r6];	 Catch:{ Exception -> 0x0433, all -> 0x0574 }
        r0.<init>(r6);	 Catch:{ Exception -> 0x0433, all -> 0x0574 }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x0433, all -> 0x0574 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0433, all -> 0x0574 }
        r0.connect();	 Catch:{ Exception -> 0x06d6, all -> 0x06ae }
        r6 = r0.getResponseCode();	 Catch:{ Exception -> 0x06d6, all -> 0x06ae }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r6 == r1) goto L_0x01a5;
    L_0x005b:
        r1 = r13.jAT;	 Catch:{ Exception -> 0x06df, all -> 0x06b2 }
        r1.aTV();	 Catch:{ Exception -> 0x06df, all -> 0x06b2 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x06df, all -> 0x06b2 }
        r4 = "Server returned HTTP ";
        r1.<init>(r4);	 Catch:{ Exception -> 0x06df, all -> 0x06b2 }
        r4 = r0.getResponseCode();	 Catch:{ Exception -> 0x06df, all -> 0x06b2 }
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x06df, all -> 0x06b2 }
        r4 = " ";
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x06df, all -> 0x06b2 }
        r4 = r0.getResponseMessage();	 Catch:{ Exception -> 0x06df, all -> 0x06b2 }
        r1 = r1.append(r4);	 Catch:{ Exception -> 0x06df, all -> 0x06b2 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x06df, all -> 0x06b2 }
        if (r0 == 0) goto L_0x0088;
    L_0x0085:
        r0.disconnect();
    L_0x0088:
        r0 = jAS;
        r2 = 0;
        r2 = r14[r2];
        r0.remove(r2);
        r0 = 0;
        r0 = r14[r0];
        r0 = com.tencent.smtt.utils.h.aX(r0);
        r2 = r13.aTm();
        r4 = com.tencent.mm.sdk.platformtools.be.ay(r8);
        r3 = (int) r4;
        r4 = new com.tencent.mm.modelsns.c;
        r4.<init>();
        r5 = "20UrlMd5";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r7.append(r0);
        r7 = ",";
        r0 = r0.append(r7);
        r0 = r0.toString();
        r4.n(r5, r0);
        r0 = "21MediaType";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r2 = r5.append(r2);
        r5 = ",";
        r2 = r2.append(r5);
        r2 = r2.toString();
        r4.n(r0, r2);
        r2 = "22IsPreload";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = r13.jAy;
        if (r0 == 0) goto L_0x01a2;
    L_0x00e5:
        r0 = 1;
    L_0x00e6:
        r0 = r5.append(r0);
        r5 = ",";
        r0 = r0.append(r5);
        r0 = r0.toString();
        r4.n(r2, r0);
        r0 = "23CostTime";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r3);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "24RetCode";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r6);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "25Scene";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r13.scene;
        r2 = r2.append(r3);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "26Size";
        r2 = new java.lang.StringBuilder;
        r3 = "0,";
        r2.<init>(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "27StartDownloadTime";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r8 / r6;
        r2 = r2.append(r6);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "MicroMsg.AdLandingPageDownloadFileTask";
        r2 = new java.lang.StringBuilder;
        r3 = "report logbuffer MM_KVSTAT_AdDownload(13572): ";
        r2.<init>(r3);
        r3 = r4.JH();
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);
        r0 = com.tencent.mm.plugin.report.service.g.iuh;
        r2 = 13572; // 0x3504 float:1.9018E-41 double:6.7055E-320;
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r5 = 0;
        r3[r5] = r4;
        r0.h(r2, r3);
        r0 = r1;
        goto L_0x0009;
    L_0x01a2:
        r0 = 0;
        goto L_0x00e6;
    L_0x01a5:
        r0.getContentLength();	 Catch:{ Exception -> 0x06df, all -> 0x06b2 }
        r4 = r0.getInputStream();	 Catch:{ Exception -> 0x06df, all -> 0x06b2 }
        r3 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x06e7, all -> 0x06b5 }
        r1 = r13.filePath;	 Catch:{ Exception -> 0x06e7, all -> 0x06b5 }
        r3.<init>(r1);	 Catch:{ Exception -> 0x06e7, all -> 0x06b5 }
        r1 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r1 = new byte[r1];	 Catch:{ Exception -> 0x06ee, all -> 0x06b9 }
        r2 = r5;
    L_0x01b8:
        r5 = r4.read(r1);	 Catch:{ Exception -> 0x06f4, all -> 0x06be }
        r7 = -1;
        if (r5 == r7) goto L_0x0301;
    L_0x01bf:
        r7 = r13.isCancelled();	 Catch:{ Exception -> 0x06f4, all -> 0x06be }
        if (r7 == 0) goto L_0x02fa;
    L_0x01c5:
        r4.close();	 Catch:{ Exception -> 0x06f4, all -> 0x06be }
        r3.close();	 Catch:{ IOException -> 0x06fe }
        if (r4 == 0) goto L_0x01d0;
    L_0x01cd:
        r4.close();	 Catch:{ IOException -> 0x06fe }
    L_0x01d0:
        if (r0 == 0) goto L_0x01d5;
    L_0x01d2:
        r0.disconnect();
    L_0x01d5:
        r0 = jAS;
        r1 = 0;
        r1 = r14[r1];
        r0.remove(r1);
        r0 = 0;
        r0 = r14[r0];
        r0 = com.tencent.smtt.utils.h.aX(r0);
        r1 = r13.aTm();
        r4 = com.tencent.mm.sdk.platformtools.be.ay(r8);
        r3 = (int) r4;
        r4 = new com.tencent.mm.modelsns.c;
        r4.<init>();
        r5 = "20UrlMd5";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r7.append(r0);
        r7 = ",";
        r0 = r0.append(r7);
        r0 = r0.toString();
        r4.n(r5, r0);
        r0 = "21MediaType";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r1 = r5.append(r1);
        r5 = ",";
        r1 = r1.append(r5);
        r1 = r1.toString();
        r4.n(r0, r1);
        r1 = "22IsPreload";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = r13.jAy;
        if (r0 == 0) goto L_0x02f7;
    L_0x0232:
        r0 = 1;
    L_0x0233:
        r0 = r5.append(r0);
        r5 = ",";
        r0 = r0.append(r5);
        r0 = r0.toString();
        r4.n(r1, r0);
        r0 = "23CostTime";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r3);
        r3 = ",";
        r1 = r1.append(r3);
        r1 = r1.toString();
        r4.n(r0, r1);
        r0 = "24RetCode";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r3 = ",";
        r1 = r1.append(r3);
        r1 = r1.toString();
        r4.n(r0, r1);
        r0 = "25Scene";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = r13.scene;
        r1 = r1.append(r3);
        r3 = ",";
        r1 = r1.append(r3);
        r1 = r1.toString();
        r4.n(r0, r1);
        r0 = "26Size";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r2);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r4.n(r0, r1);
        r0 = "27StartDownloadTime";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r8 / r2;
        r1 = r1.append(r2);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r4.n(r0, r1);
        r0 = "MicroMsg.AdLandingPageDownloadFileTask";
        r1 = new java.lang.StringBuilder;
        r2 = "report logbuffer MM_KVSTAT_AdDownload(13572): ";
        r1.<init>(r2);
        r2 = r4.JH();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        r0 = com.tencent.mm.plugin.report.service.g.iuh;
        r1 = 13572; // 0x3504 float:1.9018E-41 double:6.7055E-320;
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r2[r3] = r4;
        r0.h(r1, r2);
        r0 = 0;
        goto L_0x0009;
    L_0x02f7:
        r0 = 0;
        goto L_0x0233;
    L_0x02fa:
        r7 = 0;
        r3.write(r1, r7, r5);	 Catch:{ Exception -> 0x06f4, all -> 0x06be }
        r2 = r2 + r5;
        goto L_0x01b8;
    L_0x0301:
        r3.close();	 Catch:{ IOException -> 0x06fb }
        if (r4 == 0) goto L_0x0309;
    L_0x0306:
        r4.close();	 Catch:{ IOException -> 0x06fb }
    L_0x0309:
        if (r0 == 0) goto L_0x030e;
    L_0x030b:
        r0.disconnect();
    L_0x030e:
        r0 = jAS;
        r1 = 0;
        r1 = r14[r1];
        r0.remove(r1);
        r0 = 0;
        r0 = r14[r0];
        r0 = com.tencent.smtt.utils.h.aX(r0);
        r1 = r13.aTm();
        r4 = com.tencent.mm.sdk.platformtools.be.ay(r8);
        r3 = (int) r4;
        r4 = new com.tencent.mm.modelsns.c;
        r4.<init>();
        r5 = "20UrlMd5";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r7.append(r0);
        r7 = ",";
        r0 = r0.append(r7);
        r0 = r0.toString();
        r4.n(r5, r0);
        r0 = "21MediaType";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r1 = r5.append(r1);
        r5 = ",";
        r1 = r1.append(r5);
        r1 = r1.toString();
        r4.n(r0, r1);
        r1 = "22IsPreload";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = r13.jAy;
        if (r0 == 0) goto L_0x0430;
    L_0x036b:
        r0 = 1;
    L_0x036c:
        r0 = r5.append(r0);
        r5 = ",";
        r0 = r0.append(r5);
        r0 = r0.toString();
        r4.n(r1, r0);
        r0 = "23CostTime";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r3);
        r3 = ",";
        r1 = r1.append(r3);
        r1 = r1.toString();
        r4.n(r0, r1);
        r0 = "24RetCode";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r3 = ",";
        r1 = r1.append(r3);
        r1 = r1.toString();
        r4.n(r0, r1);
        r0 = "25Scene";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = r13.scene;
        r1 = r1.append(r3);
        r3 = ",";
        r1 = r1.append(r3);
        r1 = r1.toString();
        r4.n(r0, r1);
        r0 = "26Size";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r2);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r4.n(r0, r1);
        r0 = "27StartDownloadTime";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r8 / r2;
        r1 = r1.append(r2);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r4.n(r0, r1);
        r0 = "MicroMsg.AdLandingPageDownloadFileTask";
        r1 = new java.lang.StringBuilder;
        r2 = "report logbuffer MM_KVSTAT_AdDownload(13572): ";
        r1.<init>(r2);
        r2 = r4.JH();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        r0 = com.tencent.mm.plugin.report.service.g.iuh;
        r1 = 13572; // 0x3504 float:1.9018E-41 double:6.7055E-320;
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r2[r3] = r4;
        r0.h(r1, r2);
        r0 = 0;
        goto L_0x0009;
    L_0x0430:
        r0 = 0;
        goto L_0x036c;
    L_0x0433:
        r0 = move-exception;
        r12 = r1;
        r1 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r12;
    L_0x0439:
        r6 = r13.jAT;	 Catch:{ all -> 0x06c4 }
        r6.aTV();	 Catch:{ all -> 0x06c4 }
        r6 = r13.filePath;	 Catch:{ all -> 0x06c4 }
        com.tencent.mm.modelsfs.FileOp.deleteFile(r6);	 Catch:{ all -> 0x06c4 }
        r6 = -1;
        r1 = r0.toString();	 Catch:{ all -> 0x06cc }
        if (r3 == 0) goto L_0x044d;
    L_0x044a:
        r3.close();	 Catch:{ IOException -> 0x06d3 }
    L_0x044d:
        if (r4 == 0) goto L_0x0452;
    L_0x044f:
        r4.close();	 Catch:{ IOException -> 0x06d3 }
    L_0x0452:
        if (r2 == 0) goto L_0x0457;
    L_0x0454:
        r2.disconnect();
    L_0x0457:
        r0 = jAS;
        r2 = 0;
        r2 = r14[r2];
        r0.remove(r2);
        r0 = 0;
        r0 = r14[r0];
        r0 = com.tencent.smtt.utils.h.aX(r0);
        r2 = r13.aTm();
        r6 = com.tencent.mm.sdk.platformtools.be.ay(r8);
        r3 = (int) r6;
        r4 = new com.tencent.mm.modelsns.c;
        r4.<init>();
        r6 = "20UrlMd5";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r7.append(r0);
        r7 = ",";
        r0 = r0.append(r7);
        r0 = r0.toString();
        r4.n(r6, r0);
        r0 = "21MediaType";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r2 = r6.append(r2);
        r6 = ",";
        r2 = r2.append(r6);
        r2 = r2.toString();
        r4.n(r0, r2);
        r2 = "22IsPreload";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r0 = r13.jAy;
        if (r0 == 0) goto L_0x0571;
    L_0x04b4:
        r0 = 1;
    L_0x04b5:
        r0 = r6.append(r0);
        r6 = ",";
        r0 = r0.append(r6);
        r0 = r0.toString();
        r4.n(r2, r0);
        r0 = "23CostTime";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r3);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "24RetCode";
        r2 = new java.lang.StringBuilder;
        r3 = "-1,";
        r2.<init>(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "25Scene";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r13.scene;
        r2 = r2.append(r3);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "26Size";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r5);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "27StartDownloadTime";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r8 / r6;
        r2 = r2.append(r6);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "MicroMsg.AdLandingPageDownloadFileTask";
        r2 = new java.lang.StringBuilder;
        r3 = "report logbuffer MM_KVSTAT_AdDownload(13572): ";
        r2.<init>(r3);
        r3 = r4.JH();
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);
        r0 = com.tencent.mm.plugin.report.service.g.iuh;
        r2 = 13572; // 0x3504 float:1.9018E-41 double:6.7055E-320;
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r5 = 0;
        r3[r5] = r4;
        r0.h(r2, r3);
        r0 = r1;
        goto L_0x0009;
    L_0x0571:
        r0 = 0;
        goto L_0x04b5;
    L_0x0574:
        r0 = move-exception;
        r6 = r4;
        r12 = r1;
        r1 = r0;
        r0 = r12;
    L_0x0579:
        if (r2 == 0) goto L_0x057e;
    L_0x057b:
        r2.close();	 Catch:{ IOException -> 0x06ab }
    L_0x057e:
        if (r3 == 0) goto L_0x0583;
    L_0x0580:
        r3.close();	 Catch:{ IOException -> 0x06ab }
    L_0x0583:
        if (r0 == 0) goto L_0x0588;
    L_0x0585:
        r0.disconnect();
    L_0x0588:
        r0 = jAS;
        r2 = 0;
        r2 = r14[r2];
        r0.remove(r2);
        r0 = 0;
        r0 = r14[r0];
        r0 = com.tencent.smtt.utils.h.aX(r0);
        r2 = r13.aTm();
        r10 = com.tencent.mm.sdk.platformtools.be.ay(r8);
        r3 = (int) r10;
        r4 = new com.tencent.mm.modelsns.c;
        r4.<init>();
        r7 = "20UrlMd5";
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r0 = r10.append(r0);
        r10 = ",";
        r0 = r0.append(r10);
        r0 = r0.toString();
        r4.n(r7, r0);
        r0 = "21MediaType";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r2 = r7.append(r2);
        r7 = ",";
        r2 = r2.append(r7);
        r2 = r2.toString();
        r4.n(r0, r2);
        r2 = "22IsPreload";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r13.jAy;
        if (r0 == 0) goto L_0x06a8;
    L_0x05e5:
        r0 = 1;
    L_0x05e6:
        r0 = r7.append(r0);
        r7 = ",";
        r0 = r0.append(r7);
        r0 = r0.toString();
        r4.n(r2, r0);
        r0 = "23CostTime";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r3);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "24RetCode";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r6);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "25Scene";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r13.scene;
        r2 = r2.append(r3);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "26Size";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r5);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "27StartDownloadTime";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r8 / r6;
        r2 = r2.append(r6);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "MicroMsg.AdLandingPageDownloadFileTask";
        r2 = new java.lang.StringBuilder;
        r3 = "report logbuffer MM_KVSTAT_AdDownload(13572): ";
        r2.<init>(r3);
        r3 = r4.JH();
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);
        r0 = com.tencent.mm.plugin.report.service.g.iuh;
        r2 = 13572; // 0x3504 float:1.9018E-41 double:6.7055E-320;
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r5 = 0;
        r3[r5] = r4;
        r0.h(r2, r3);
        throw r1;
    L_0x06a8:
        r0 = 0;
        goto L_0x05e6;
    L_0x06ab:
        r2 = move-exception;
        goto L_0x0583;
    L_0x06ae:
        r1 = move-exception;
        r6 = r4;
        goto L_0x0579;
    L_0x06b2:
        r1 = move-exception;
        goto L_0x0579;
    L_0x06b5:
        r1 = move-exception;
        r3 = r4;
        goto L_0x0579;
    L_0x06b9:
        r1 = move-exception;
        r2 = r3;
        r3 = r4;
        goto L_0x0579;
    L_0x06be:
        r1 = move-exception;
        r5 = r2;
        r2 = r3;
        r3 = r4;
        goto L_0x0579;
    L_0x06c4:
        r0 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r2;
        r2 = r3;
        r3 = r4;
        goto L_0x0579;
    L_0x06cc:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
        r2 = r3;
        r3 = r4;
        goto L_0x0579;
    L_0x06d3:
        r0 = move-exception;
        goto L_0x0452;
    L_0x06d6:
        r1 = move-exception;
        r12 = r1;
        r1 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r0;
        r0 = r12;
        goto L_0x0439;
    L_0x06df:
        r1 = move-exception;
        r4 = r3;
        r3 = r2;
        r2 = r0;
        r0 = r1;
        r1 = r6;
        goto L_0x0439;
    L_0x06e7:
        r1 = move-exception;
        r3 = r2;
        r2 = r0;
        r0 = r1;
        r1 = r6;
        goto L_0x0439;
    L_0x06ee:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        r1 = r6;
        goto L_0x0439;
    L_0x06f4:
        r1 = move-exception;
        r5 = r2;
        r2 = r0;
        r0 = r1;
        r1 = r6;
        goto L_0x0439;
    L_0x06fb:
        r1 = move-exception;
        goto L_0x0309;
    L_0x06fe:
        r1 = move-exception;
        goto L_0x01d0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.b.u(java.lang.String[]):java.lang.String");
    }

    private int aTm() {
        switch (this.jAz) {
            case 41:
            case 44:
            case 45:
            case 1000000001:
                return 1;
            case 61:
                return 2;
            case ao.CTRL_INDEX /*62*/:
                return 3;
            default:
                return 0;
        }
    }
}
