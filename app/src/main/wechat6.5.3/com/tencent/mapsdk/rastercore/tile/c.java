package com.tencent.mapsdk.rastercore.tile;

import java.util.Locale;

public final class c {
    private static String a = (Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry());

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.net.URL r10, com.tencent.mapsdk.rastercore.tile.MapTile.MapSource r11) {
        /*
        r2 = 0;
        if (r10 != 0) goto L_0x0005;
    L_0x0003:
        r0 = r2;
    L_0x0004:
        return r0;
    L_0x0005:
        r4 = 0;
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0128, all -> 0x016e }
        r0 = android.net.Proxy.getDefaultHost();	 Catch:{ Exception -> 0x0128, all -> 0x016e }
        if (r0 == 0) goto L_0x01c3;
    L_0x0011:
        r0 = new java.net.Proxy;	 Catch:{ Exception -> 0x0128, all -> 0x016e }
        r1 = java.net.Proxy.Type.HTTP;	 Catch:{ Exception -> 0x0128, all -> 0x016e }
        r3 = new java.net.InetSocketAddress;	 Catch:{ Exception -> 0x0128, all -> 0x016e }
        r6 = android.net.Proxy.getDefaultHost();	 Catch:{ Exception -> 0x0128, all -> 0x016e }
        r7 = android.net.Proxy.getDefaultPort();	 Catch:{ Exception -> 0x0128, all -> 0x016e }
        r3.<init>(r6, r7);	 Catch:{ Exception -> 0x0128, all -> 0x016e }
        r0.<init>(r1, r3);	 Catch:{ Exception -> 0x0128, all -> 0x016e }
    L_0x0025:
        if (r0 == 0) goto L_0x00a6;
    L_0x0027:
        r0 = r10.openConnection(r0);	 Catch:{ Exception -> 0x0128, all -> 0x016e }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0128, all -> 0x016e }
        r6 = r0;
    L_0x002e:
        r0 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r6.setConnectTimeout(r0);	 Catch:{ Exception -> 0x01b7, all -> 0x01b1 }
        r0 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r6.setReadTimeout(r0);	 Catch:{ Exception -> 0x01b7, all -> 0x01b1 }
        r0 = "Accept-Encoding";
        r1 = "gzip, deflate";
        r6.setRequestProperty(r0, r1);	 Catch:{ Exception -> 0x01b7, all -> 0x01b1 }
        r0 = "User-Agent";
        r1 = "QmapSdk/1.2.4 Android";
        r6.setRequestProperty(r0, r1);	 Catch:{ Exception -> 0x01b7, all -> 0x01b1 }
        r0 = "Accept-Language";
        r1 = a;	 Catch:{ Exception -> 0x01b7, all -> 0x01b1 }
        r6.setRequestProperty(r0, r1);	 Catch:{ Exception -> 0x01b7, all -> 0x01b1 }
        r0 = r6.getResponseCode();	 Catch:{ Exception -> 0x01b7, all -> 0x01b1 }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r1) goto L_0x00df;
    L_0x005a:
        r1 = r6.getInputStream();	 Catch:{ Exception -> 0x01b7, all -> 0x01b1 }
        r0 = "gzip";
        r3 = "Content-Encoding";
        r3 = r6.getHeaderField(r3);	 Catch:{ Exception -> 0x01b7, all -> 0x01b1 }
        r0 = r0.equalsIgnoreCase(r3);	 Catch:{ Exception -> 0x01b7, all -> 0x01b1 }
        if (r0 == 0) goto L_0x01c0;
    L_0x006e:
        r0 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x01b7, all -> 0x01b1 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x01b7, all -> 0x01b1 }
    L_0x0073:
        r3 = com.tencent.mapsdk.rastercore.d.a.b(r0);	 Catch:{ Exception -> 0x01b7, all -> 0x01b1 }
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01b7, all -> 0x01b1 }
        r0 = r0 - r8;
        r4 = 0;
        r5 = r3.length;	 Catch:{ Exception -> 0x00ae, all -> 0x01b3 }
        android.graphics.BitmapFactory.decodeByteArray(r3, r4, r5);	 Catch:{ Exception -> 0x00ae, all -> 0x01b3 }
    L_0x0081:
        if (r6 == 0) goto L_0x0086;
    L_0x0083:
        r6.disconnect();
    L_0x0086:
        r2 = com.tencent.mapsdk.rastercore.tile.MapTile.MapSource.TENCENT;
        if (r11 != r2) goto L_0x00c1;
    L_0x008a:
        r2 = com.tencent.mapsdk.rastercore.d.e.a;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r4.append(r0);
        r1 = ",";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r2.append(r0);
    L_0x00a3:
        r0 = r3;
        goto L_0x0004;
    L_0x00a6:
        r0 = r10.openConnection();	 Catch:{ Exception -> 0x0128, all -> 0x016e }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0128, all -> 0x016e }
        r6 = r0;
        goto L_0x002e;
    L_0x00ae:
        r4 = move-exception;
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01bc, all -> 0x01b3 }
        r7 = "decoder bitmap error:";
        r5.<init>(r7);	 Catch:{ Exception -> 0x01bc, all -> 0x01b3 }
        r4 = r4.getMessage();	 Catch:{ Exception -> 0x01bc, all -> 0x01b3 }
        r5.append(r4);	 Catch:{ Exception -> 0x01bc, all -> 0x01b3 }
        r0 = -1;
        goto L_0x0081;
    L_0x00c1:
        r2 = com.tencent.mapsdk.rastercore.tile.MapTile.MapSource.BING;
        if (r11 != r2) goto L_0x00a3;
    L_0x00c5:
        r2 = com.tencent.mapsdk.rastercore.d.e.b;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r4.append(r0);
        r1 = ",";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r2.append(r0);
        goto L_0x00a3;
    L_0x00df:
        r1 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r0 < r1) goto L_0x00e5;
    L_0x00e3:
        r0 = -r0;
        r4 = (long) r0;
    L_0x00e5:
        if (r6 == 0) goto L_0x00ea;
    L_0x00e7:
        r6.disconnect();
    L_0x00ea:
        r0 = com.tencent.mapsdk.rastercore.tile.MapTile.MapSource.TENCENT;
        if (r11 != r0) goto L_0x010a;
    L_0x00ee:
        r0 = com.tencent.mapsdk.rastercore.d.e.a;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r4);
        r3 = ",";
        r1 = r1.append(r3);
        r1 = r1.toString();
        r0.append(r1);
    L_0x0107:
        r0 = r2;
        goto L_0x0004;
    L_0x010a:
        r0 = com.tencent.mapsdk.rastercore.tile.MapTile.MapSource.BING;
        if (r11 != r0) goto L_0x0107;
    L_0x010e:
        r0 = com.tencent.mapsdk.rastercore.d.e.b;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r4);
        r3 = ",";
        r1 = r1.append(r3);
        r1 = r1.toString();
        r0.append(r1);
        goto L_0x0107;
    L_0x0128:
        r0 = move-exception;
        r0 = r4;
        r3 = r2;
    L_0x012b:
        if (r3 == 0) goto L_0x0130;
    L_0x012d:
        r3.disconnect();
    L_0x0130:
        r3 = com.tencent.mapsdk.rastercore.tile.MapTile.MapSource.TENCENT;
        if (r11 != r3) goto L_0x0150;
    L_0x0134:
        r3 = com.tencent.mapsdk.rastercore.d.e.a;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r4.append(r0);
        r1 = ",";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r3.append(r0);
    L_0x014d:
        r0 = r2;
        goto L_0x0004;
    L_0x0150:
        r3 = com.tencent.mapsdk.rastercore.tile.MapTile.MapSource.BING;
        if (r11 != r3) goto L_0x014d;
    L_0x0154:
        r3 = com.tencent.mapsdk.rastercore.d.e.b;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r4.append(r0);
        r1 = ",";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r3.append(r0);
        goto L_0x014d;
    L_0x016e:
        r0 = move-exception;
        r6 = r2;
    L_0x0170:
        if (r6 == 0) goto L_0x0175;
    L_0x0172:
        r6.disconnect();
    L_0x0175:
        r1 = com.tencent.mapsdk.rastercore.tile.MapTile.MapSource.TENCENT;
        if (r11 != r1) goto L_0x0193;
    L_0x0179:
        r1 = com.tencent.mapsdk.rastercore.d.e.a;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r4);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.append(r2);
    L_0x0192:
        throw r0;
    L_0x0193:
        r1 = com.tencent.mapsdk.rastercore.tile.MapTile.MapSource.BING;
        if (r11 != r1) goto L_0x0192;
    L_0x0197:
        r1 = com.tencent.mapsdk.rastercore.d.e.b;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r4);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.append(r2);
        goto L_0x0192;
    L_0x01b1:
        r0 = move-exception;
        goto L_0x0170;
    L_0x01b3:
        r2 = move-exception;
        r4 = r0;
        r0 = r2;
        goto L_0x0170;
    L_0x01b7:
        r0 = move-exception;
        r0 = r4;
        r3 = r6;
        goto L_0x012b;
    L_0x01bc:
        r3 = move-exception;
        r3 = r6;
        goto L_0x012b;
    L_0x01c0:
        r0 = r1;
        goto L_0x0073;
    L_0x01c3:
        r0 = r2;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.rastercore.tile.c.a(java.net.URL, com.tencent.mapsdk.rastercore.tile.MapTile$MapSource):byte[]");
    }
}
