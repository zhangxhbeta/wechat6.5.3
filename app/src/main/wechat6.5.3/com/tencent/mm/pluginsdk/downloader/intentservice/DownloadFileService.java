package com.tencent.mm.pluginsdk.downloader.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;
import android.os.ResultReceiver;
import android.support.v4.app.w.d;
import java.io.File;

public class DownloadFileService extends IntentService {
    private static final String TAG = DownloadFileService.class.getSimpleName();
    private ResultReceiver lyB;
    private int lyC;
    private int lyD;

    public DownloadFileService() {
        super("com.tencent.mm.pluginsdk.downloader.intentservice.DownloadFileService");
    }

    public void onCreate() {
        super.onCreate();
        d dVar = new d(this);
        dVar.a("Something Download").b("Download in progress").L(2130838373);
        startForeground(4657, dVar.build());
    }

    protected void onHandleIntent(Intent intent) {
        String string = intent.getExtras().getString("url");
        this.lyB = (ResultReceiver) intent.getParcelableExtra("receiver");
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download");
        if (!file.exists()) {
            file.mkdirs();
        }
        a(string, new File(file, "file11.apk"));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r12, java.io.File r13) {
        /*
        r11 = this;
        r10 = 0;
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x008f }
        r2.<init>(r13);	 Catch:{ FileNotFoundException -> 0x008f }
        r1 = 0;
        r0 = new java.net.URL;	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r0.<init>(r12);	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r0 = r0.openConnection();	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r3 = "GET";
        r0.setRequestMethod(r3);	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r3 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setReadTimeout(r3);	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r3 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r0.setConnectTimeout(r3);	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r3 = "Content-Length";
        r3 = r0.getHeaderField(r3);	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r3 = r3.intValue();	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r1 = r0.getInputStream();	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r0 = r0.getResponseCode();	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r4) goto L_0x00a3;
    L_0x003d:
        r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = new byte[r0];	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
    L_0x0041:
        r4 = r1.read(r0);	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r5 = -1;
        if (r4 == r5) goto L_0x00b8;
    L_0x0048:
        r5 = 0;
        r2.write(r0, r5, r4);	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r5 = r11.lyC;	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r4 = r4 + r5;
        r11.lyC = r4;	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r4 = new android.os.Bundle;	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r4.<init>();	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r5 = r11.lyC;	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r6 = (long) r5;	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r8 = 100;
        r6 = r6 * r8;
        r8 = (long) r3;	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r6 = r6 / r8;
        r5 = (int) r6;	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r6 = r11.lyD;	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        if (r5 <= r6) goto L_0x0041;
    L_0x0063:
        r6 = "progress";
        r4.putInt(r6, r5);	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r6 = r11.lyB;	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r7 = 4657; // 0x1231 float:6.526E-42 double:2.301E-320;
        r6.send(r7, r4);	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r11.lyD = r5;	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        goto L_0x0041;
    L_0x0073:
        r0 = move-exception;
        r3 = TAG;	 Catch:{ all -> 0x0132 }
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0132 }
        com.tencent.mm.sdk.platformtools.v.a(r3, r0, r4, r5);	 Catch:{ all -> 0x0132 }
        r0 = r2.getFD();	 Catch:{ Exception -> 0x0155 }
        r0.sync();	 Catch:{ Exception -> 0x0155 }
    L_0x0086:
        r2.close();	 Catch:{ IOException -> 0x00d4 }
        if (r1 == 0) goto L_0x008e;
    L_0x008b:
        r1.close();	 Catch:{ IOException -> 0x00d4 }
    L_0x008e:
        return;
    L_0x008f:
        r0 = move-exception;
        r1 = TAG;
        r2 = "can not fond output folder";
        com.tencent.mm.sdk.platformtools.v.e(r1, r2);
        r1 = TAG;
        r2 = "";
        r3 = new java.lang.Object[r10];
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);
        goto L_0x008e;
    L_0x00a3:
        r3 = TAG;	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r4 = new java.lang.StringBuilder;	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r5 = "Server return code:";
        r4.<init>(r5);	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r0 = r4.append(r0);	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        r0 = r0.toString();	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
        com.tencent.mm.sdk.platformtools.v.e(r3, r0);	 Catch:{ ProtocolException -> 0x0073, MalformedURLException -> 0x00e0, IOException -> 0x0108 }
    L_0x00b8:
        r0 = r2.getFD();	 Catch:{ Exception -> 0x0158 }
        r0.sync();	 Catch:{ Exception -> 0x0158 }
    L_0x00bf:
        r2.close();	 Catch:{ IOException -> 0x00c8 }
        if (r1 == 0) goto L_0x008e;
    L_0x00c4:
        r1.close();	 Catch:{ IOException -> 0x00c8 }
        goto L_0x008e;
    L_0x00c8:
        r0 = move-exception;
        r1 = TAG;
        r2 = "";
        r3 = new java.lang.Object[r10];
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);
        goto L_0x008e;
    L_0x00d4:
        r0 = move-exception;
        r1 = TAG;
        r2 = "";
        r3 = new java.lang.Object[r10];
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);
        goto L_0x008e;
    L_0x00e0:
        r0 = move-exception;
        r3 = TAG;	 Catch:{ all -> 0x0132 }
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0132 }
        com.tencent.mm.sdk.platformtools.v.a(r3, r0, r4, r5);	 Catch:{ all -> 0x0132 }
        r0 = r2.getFD();	 Catch:{ Exception -> 0x0153 }
        r0.sync();	 Catch:{ Exception -> 0x0153 }
    L_0x00f3:
        r2.close();	 Catch:{ IOException -> 0x00fc }
        if (r1 == 0) goto L_0x008e;
    L_0x00f8:
        r1.close();	 Catch:{ IOException -> 0x00fc }
        goto L_0x008e;
    L_0x00fc:
        r0 = move-exception;
        r1 = TAG;
        r2 = "";
        r3 = new java.lang.Object[r10];
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);
        goto L_0x008e;
    L_0x0108:
        r0 = move-exception;
        r3 = TAG;	 Catch:{ all -> 0x0132 }
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0132 }
        com.tencent.mm.sdk.platformtools.v.a(r3, r0, r4, r5);	 Catch:{ all -> 0x0132 }
        r0 = r2.getFD();	 Catch:{ Exception -> 0x0151 }
        r0.sync();	 Catch:{ Exception -> 0x0151 }
    L_0x011b:
        r2.close();	 Catch:{ IOException -> 0x0125 }
        if (r1 == 0) goto L_0x008e;
    L_0x0120:
        r1.close();	 Catch:{ IOException -> 0x0125 }
        goto L_0x008e;
    L_0x0125:
        r0 = move-exception;
        r1 = TAG;
        r2 = "";
        r3 = new java.lang.Object[r10];
        com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);
        goto L_0x008e;
    L_0x0132:
        r0 = move-exception;
        r3 = r2.getFD();	 Catch:{ Exception -> 0x014f }
        r3.sync();	 Catch:{ Exception -> 0x014f }
    L_0x013a:
        r2.close();	 Catch:{ IOException -> 0x0143 }
        if (r1 == 0) goto L_0x0142;
    L_0x013f:
        r1.close();	 Catch:{ IOException -> 0x0143 }
    L_0x0142:
        throw r0;
    L_0x0143:
        r1 = move-exception;
        r2 = TAG;
        r3 = "";
        r4 = new java.lang.Object[r10];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
        goto L_0x0142;
    L_0x014f:
        r3 = move-exception;
        goto L_0x013a;
    L_0x0151:
        r0 = move-exception;
        goto L_0x011b;
    L_0x0153:
        r0 = move-exception;
        goto L_0x00f3;
    L_0x0155:
        r0 = move-exception;
        goto L_0x0086;
    L_0x0158:
        r0 = move-exception;
        goto L_0x00bf;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.downloader.intentservice.DownloadFileService.a(java.lang.String, java.io.File):void");
    }
}
