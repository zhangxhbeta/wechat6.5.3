package com.tencent.mm.console.a;

import com.tencent.mm.pluginsdk.a.a;
import com.tencent.mm.pluginsdk.a.b;

public final class e implements a {
    static {
        b.a(new e(), "//disablesfs", "//exportsfs", "//sfsstat");
    }

    public static void init() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.content.Context r11, java.lang.String[] r12) {
        /*
        r10 = this;
        r9 = 0;
        r3 = -1;
        r1 = 0;
        r2 = 1;
        r0 = r12[r1];
        r4 = r0.hashCode();
        switch(r4) {
            case -1024646924: goto L_0x0029;
            case 1218851436: goto L_0x001e;
            case 1595670136: goto L_0x0013;
            default: goto L_0x000d;
        };
    L_0x000d:
        r0 = r3;
    L_0x000e:
        switch(r0) {
            case 0: goto L_0x0034;
            case 1: goto L_0x009d;
            case 2: goto L_0x00b1;
            default: goto L_0x0011;
        };
    L_0x0011:
        r2 = r1;
    L_0x0012:
        return r2;
    L_0x0013:
        r4 = "//disablesfs";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x000d;
    L_0x001c:
        r0 = r1;
        goto L_0x000e;
    L_0x001e:
        r4 = "//exportsfs";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x000d;
    L_0x0027:
        r0 = r2;
        goto L_0x000e;
    L_0x0029:
        r4 = "//sfsstat";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x000d;
    L_0x0032:
        r0 = 2;
        goto L_0x000e;
    L_0x0034:
        r3 = new java.io.File;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r4 = android.os.Environment.getExternalStorageDirectory();
        r4 = r4.getAbsolutePath();
        r0 = r0.append(r4);
        r4 = "/tencent/MicroMsg/disable-sfs";
        r0 = r0.append(r4);
        r0 = r0.toString();
        r3.<init>(r0);
        r0 = r12.length;	 Catch:{ Exception -> 0x008e }
        if (r0 <= 0) goto L_0x008a;
    L_0x0058:
        r0 = 1;
        r0 = r12[r0];	 Catch:{ Exception -> 0x008e }
        r4 = "0";
        r0 = r0.equals(r4);	 Catch:{ Exception -> 0x008e }
        if (r0 != 0) goto L_0x008a;
    L_0x0064:
        r3.createNewFile();	 Catch:{ Exception -> 0x008e }
    L_0x0067:
        r4 = new java.lang.StringBuilder;
        r0 = "Use SFS: ";
        r4.<init>(r0);
        r0 = r3.exists();
        if (r0 != 0) goto L_0x009b;
    L_0x0075:
        r0 = r2;
    L_0x0076:
        r0 = java.lang.Boolean.toString(r0);
        r0 = r4.append(r0);
        r0 = r0.toString();
        r0 = android.widget.Toast.makeText(r11, r0, r1);
        r0.show();
        goto L_0x0012;
    L_0x008a:
        r3.delete();	 Catch:{ Exception -> 0x008e }
        goto L_0x0067;
    L_0x008e:
        r0 = move-exception;
        r4 = "MicroMsg.SFSCommand";
        r5 = "Failed to operate flag file.";
        r6 = new java.lang.Object[r1];
        com.tencent.mm.sdk.platformtools.v.a(r4, r0, r5, r6);
        goto L_0x0067;
    L_0x009b:
        r0 = r1;
        goto L_0x0076;
    L_0x009d:
        r0 = r12.length;
        if (r0 > r2) goto L_0x00a3;
    L_0x00a0:
        r2 = r1;
        goto L_0x0012;
    L_0x00a3:
        r0 = r12[r2];
        com.tencent.mm.modelsfs.FileOp.jO(r0);
        r0 = android.widget.Toast.makeText(r11, r0, r1);
        r0.show();
        goto L_0x0012;
    L_0x00b1:
        r4 = java.lang.System.currentTimeMillis();
        r0 = com.tencent.mm.modelsfs.FileOp.IM();
        r6 = new java.lang.StringBuilder;
        r1 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r6.<init>(r1);
        r0 = r0.entrySet();
        r7 = r0.iterator();
    L_0x00c8:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x0102;
    L_0x00ce:
        r0 = r7.next();
        r1 = r0;
        r1 = (java.util.Map.Entry) r1;
        r0 = "===== ";
        r8 = r6.append(r0);
        r0 = r1.getKey();
        r0 = (java.lang.String) r0;
        r0 = r8.append(r0);
        r8 = " =====\n";
        r8 = r0.append(r8);
        r0 = r1.getValue();
        r0 = (com.tencent.mm.modelsfs.SFSContext.Statistics) r0;
        r0 = r0.toString();
        r0 = r8.append(r0);
        r1 = "\n\n";
        r0.append(r1);
        goto L_0x00c8;
    L_0x0102:
        r0 = java.lang.System.currentTimeMillis();
        r0 = r0 - r4;
        r4 = "elapsed: ";
        r4 = r6.append(r4);
        r0 = r4.append(r0);
        r1 = " ms";
        r0.append(r1);
        r0 = new android.widget.TextView;
        r0.<init>(r11);
        r0.setText(r6);
        r1 = 8388627; // 0x800013 float:1.175497E-38 double:4.1445324E-317;
        r0.setGravity(r1);
        r1 = 1092616192; // 0x41200000 float:10.0 double:5.398241246E-315;
        r0.setTextSize(r2, r1);
        r1 = new android.view.ViewGroup$LayoutParams;
        r4 = -2;
        r1.<init>(r3, r4);
        r0.setLayoutParams(r1);
        r1 = -16744704; // 0xffffffffff007f00 float:-1.708006E38 double:NaN;
        r0.setTextColor(r1);
        r1 = android.graphics.Typeface.MONOSPACE;
        r0.setTypeface(r1);
        r1 = new android.text.method.ScrollingMovementMethod;
        r1.<init>();
        r0.setMovementMethod(r1);
        r1 = r11.getResources();
        r3 = 2131493135; // 0x7f0c010f float:1.8609742E38 double:1.0530975323E-314;
        r1 = r1.getDimensionPixelSize(r3);
        r0.setPadding(r1, r1, r1, r1);
        com.tencent.mm.ui.base.g.a(r11, r9, r0, r9);
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.console.a.e.a(android.content.Context, java.lang.String[]):boolean");
    }
}
