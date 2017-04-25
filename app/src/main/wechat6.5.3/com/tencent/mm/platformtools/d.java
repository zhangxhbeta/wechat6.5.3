package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public final class d {
    public static boolean b(String str, Context context) {
        if (!o.JZ(str)) {
            return a(str, context, true);
        }
        if (!be.kS(str)) {
            String lV = lV("gif");
            e.aW(lV);
            if (FileOp.p(str, lV) >= 0) {
                c(lV, context);
                Toast.makeText(context, context.getString(2131232244, new Object[]{MT()}), 1).show();
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r9, android.content.Context r10, boolean r11) {
        /*
        r1 = 1;
        r0 = 0;
        if (r9 == 0) goto L_0x0021;
    L_0x0004:
        r2 = "";
        r2 = r9.equals(r2);
        if (r2 != 0) goto L_0x0021;
    L_0x000d:
        r2 = "jpg";
        r5 = lV(r2);
        com.tencent.mm.a.e.aW(r5);
        r2 = com.tencent.mm.modelsfs.FileOp.p(r9, r5);
        r6 = 0;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 >= 0) goto L_0x0022;
    L_0x0021:
        return r0;
    L_0x0022:
        r2 = com.tencent.mm.sdk.platformtools.MMNativeJpeg.isProgressive(r5);
        if (r2 == 0) goto L_0x004a;
    L_0x0028:
        r2 = 0;
        r4 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.JQ(r5);	 Catch:{ Exception -> 0x0076, all -> 0x0083 }
        r3 = com.tencent.mm.sdk.platformtools.MMNativeJpeg.decodeAsBitmap(r5);	 Catch:{ Exception -> 0x0076, all -> 0x0083 }
        if (r3 == 0) goto L_0x0097;
    L_0x0033:
        r4 = (float) r4;
        r3 = com.tencent.mm.sdk.platformtools.d.b(r3, r4);	 Catch:{ Exception -> 0x0067, all -> 0x0083 }
        r4 = r3;
    L_0x0039:
        r6 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ Exception -> 0x0076, all -> 0x0083 }
        r7 = 80;
        r3 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0076, all -> 0x0083 }
        r3.<init>(r5);	 Catch:{ Exception -> 0x0076, all -> 0x0083 }
        r4.compress(r6, r7, r3);	 Catch:{ Exception -> 0x0094, all -> 0x008e }
    L_0x0045:
        if (r3 == 0) goto L_0x004a;
    L_0x0047:
        r3.close();	 Catch:{ Exception -> 0x008a }
    L_0x004a:
        c(r5, r10);
        if (r11 == 0) goto L_0x0065;
    L_0x004f:
        r2 = 2131232244; // 0x7f0805f4 float:1.8080592E38 double:1.052968635E-314;
        r3 = new java.lang.Object[r1];
        r4 = MT();
        r3[r0] = r4;
        r0 = r10.getString(r2, r3);
        r0 = android.widget.Toast.makeText(r10, r0, r1);
        r0.show();
    L_0x0065:
        r0 = r1;
        goto L_0x0021;
    L_0x0067:
        r4 = move-exception;
        r6 = "Micromsg.ExportImgUtil";
        r7 = "rotate img failed.";
        r8 = 0;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0076, all -> 0x0083 }
        com.tencent.mm.sdk.platformtools.v.a(r6, r4, r7, r8);	 Catch:{ Exception -> 0x0076, all -> 0x0083 }
        r4 = r3;
        goto L_0x0039;
    L_0x0076:
        r1 = move-exception;
        r1 = r2;
    L_0x0078:
        com.tencent.mm.modelsfs.FileOp.deleteFile(r5);	 Catch:{ all -> 0x0091 }
        if (r1 == 0) goto L_0x0021;
    L_0x007d:
        r1.close();	 Catch:{ Exception -> 0x0081 }
        goto L_0x0021;
    L_0x0081:
        r1 = move-exception;
        goto L_0x0021;
    L_0x0083:
        r0 = move-exception;
    L_0x0084:
        if (r2 == 0) goto L_0x0089;
    L_0x0086:
        r2.close();	 Catch:{ Exception -> 0x008c }
    L_0x0089:
        throw r0;
    L_0x008a:
        r2 = move-exception;
        goto L_0x004a;
    L_0x008c:
        r1 = move-exception;
        goto L_0x0089;
    L_0x008e:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0084;
    L_0x0091:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0084;
    L_0x0094:
        r1 = move-exception;
        r1 = r3;
        goto L_0x0078;
    L_0x0097:
        r3 = r2;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.d.a(java.lang.String, android.content.Context, boolean):boolean");
    }

    public static String lV(String str) {
        return com.tencent.mm.compatible.util.e.cgg + String.format("%s%d.%s", new Object[]{"mmexport", Long.valueOf(System.currentTimeMillis()), str});
    }

    public static void c(String str, Context context) {
        if (!be.kS(str)) {
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str))));
            v.i("Micromsg.ExportImgUtil", "refreshing media scanner on path=%s", str);
        }
    }

    public static String MT() {
        String str = com.tencent.mm.compatible.util.e.cgg;
        return str.substring(str.indexOf("tencent/MicroMsg"));
    }
}
