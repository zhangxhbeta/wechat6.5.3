package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.base.g;

public final class c implements a {
    private d eXF;

    c(d dVar) {
        this.eXF = dVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(final android.content.Context r10, java.lang.String[] r11) {
        /*
        r9 = this;
        r5 = -1;
        r8 = 0;
        r1 = 0;
        r6 = 1;
        r0 = new java.io.File;
        com.tencent.mm.model.ak.yW();
        r2 = com.tencent.mm.model.c.xp();
        r0.<init>(r2);
        r2 = new java.io.File;
        r3 = "EnMicroMsg.db";
        r2.<init>(r0, r3);
        r4 = new java.io.File;
        r3 = "EnMicroMsg.db~";
        r4.<init>(r0, r3);
        r3 = new java.io.File;
        r7 = "EnMicroMsg.db~~";
        r3.<init>(r0, r7);
        r7 = r11.length;
        if (r7 <= r6) goto L_0x00d7;
    L_0x002b:
        r0 = r11[r6];
        r7 = r0.hashCode();
        switch(r7) {
            case -778987502: goto L_0x0050;
            case 1220142353: goto L_0x003a;
            case 1933703003: goto L_0x0045;
            default: goto L_0x0034;
        };
    L_0x0034:
        r0 = r5;
    L_0x0035:
        switch(r0) {
            case 0: goto L_0x005b;
            case 1: goto L_0x0089;
            case 2: goto L_0x00b0;
            default: goto L_0x0038;
        };
    L_0x0038:
        r0 = r1;
    L_0x0039:
        return r0;
    L_0x003a:
        r7 = "make-test";
        r0 = r0.equals(r7);
        if (r0 == 0) goto L_0x0034;
    L_0x0043:
        r0 = r1;
        goto L_0x0035;
    L_0x0045:
        r7 = "recover-test";
        r0 = r0.equals(r7);
        if (r0 == 0) goto L_0x0034;
    L_0x004e:
        r0 = r6;
        goto L_0x0035;
    L_0x0050:
        r7 = "clear-test";
        r0 = r0.equals(r7);
        if (r0 == 0) goto L_0x0034;
    L_0x0059:
        r0 = 2;
        goto L_0x0035;
    L_0x005b:
        r0 = r4.isFile();
        if (r0 != 0) goto L_0x0067;
    L_0x0061:
        r0 = r3.isFile();
        if (r0 == 0) goto L_0x0073;
    L_0x0067:
        r0 = "Corruption test database exists.\nClear or recover before creating a new one.";
        r0 = android.widget.Toast.makeText(r10, r0, r6);
        r0.show();
        r0 = r6;
        goto L_0x0039;
    L_0x0073:
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.wE();
        r0 = r0.bxY();
        r0.close();
        r2.renameTo(r4);
        com.tencent.mm.ui.MMAppMgr.a(r10, r6);
        r0 = r6;
        goto L_0x0039;
    L_0x0089:
        r0 = r4.isFile();
        if (r0 != 0) goto L_0x00a1;
    L_0x008f:
        r0 = r3.isFile();
        if (r0 != 0) goto L_0x00a1;
    L_0x0095:
        r0 = "Corruption test database not exist.";
        r0 = android.widget.Toast.makeText(r10, r0, r1);
        r0.show();
        r0 = r6;
        goto L_0x0039;
    L_0x00a1:
        r7 = "Do you really want to recover test database?\nYour current database WILL BE LOST.";
        r0 = new com.tencent.mm.plugin.dbbackup.c$3;
        r1 = r9;
        r5 = r10;
        r0.<init>(r1, r2, r3, r4, r5);
        com.tencent.mm.ui.base.g.a(r10, r7, r8, r0, r8);
        r0 = r6;
        goto L_0x0039;
    L_0x00b0:
        r0 = r4.isFile();
        if (r0 != 0) goto L_0x00c9;
    L_0x00b6:
        r0 = r3.isFile();
        if (r0 != 0) goto L_0x00c9;
    L_0x00bc:
        r0 = "Corruption test database not exist.";
        r0 = android.widget.Toast.makeText(r10, r0, r1);
        r0.show();
        r0 = r6;
        goto L_0x0039;
    L_0x00c9:
        r0 = "Do you really want to clear test database?\nIt can't be recovered anymore.";
        r1 = new com.tencent.mm.plugin.dbbackup.c$4;
        r1.<init>(r9, r4, r3, r10);
        com.tencent.mm.ui.base.g.a(r10, r0, r8, r1, r8);
        r0 = r6;
        goto L_0x0039;
    L_0x00d7:
        r2 = new com.tencent.mm.plugin.dbbackup.c$5;
        r2.<init>(r9);
        r0 = r0.list(r2);
        if (r0 != 0) goto L_0x00e4;
    L_0x00e2:
        r0 = new java.lang.String[r1];
    L_0x00e4:
        r2 = new java.lang.StringBuilder;
        r7 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        r2.<init>(r7);
        r7 = "Corruption test DB: ";
        r2.append(r7);
        r4 = r4.isFile();
        if (r4 == 0) goto L_0x011a;
    L_0x00f7:
        r3 = "activated\n";
        r2.append(r3);
    L_0x00fd:
        r3 = "\nCorrupted DB:\n";
        r2.append(r3);
        r3 = r0.length;
    L_0x0104:
        if (r1 >= r3) goto L_0x012e;
    L_0x0106:
        r4 = r0[r1];
        r7 = 9;
        r7 = r2.append(r7);
        r4 = r7.append(r4);
        r7 = 10;
        r4.append(r7);
        r1 = r1 + 1;
        goto L_0x0104;
    L_0x011a:
        r3 = r3.isFile();
        if (r3 == 0) goto L_0x0127;
    L_0x0120:
        r3 = "inactivated\n";
        r2.append(r3);
        goto L_0x00fd;
    L_0x0127:
        r3 = "not exist\n";
        r2.append(r3);
        goto L_0x00fd;
    L_0x012e:
        r0 = new android.widget.TextView;
        r0.<init>(r10);
        r0.setText(r2);
        r1 = 8388627; // 0x800013 float:1.175497E-38 double:4.1445324E-317;
        r0.setGravity(r1);
        r1 = 1092616192; // 0x41200000 float:10.0 double:5.398241246E-315;
        r0.setTextSize(r6, r1);
        r1 = new android.view.ViewGroup$LayoutParams;
        r2 = -2;
        r1.<init>(r5, r2);
        r0.setLayoutParams(r1);
        r1 = -16744704; // 0xffffffffff007f00 float:-1.708006E38 double:NaN;
        r0.setTextColor(r1);
        r1 = android.graphics.Typeface.MONOSPACE;
        r0.setTypeface(r1);
        r1 = new android.text.method.ScrollingMovementMethod;
        r1.<init>();
        r0.setMovementMethod(r1);
        r1 = r10.getResources();
        r2 = 2131493135; // 0x7f0c010f float:1.8609742E38 double:1.0530975323E-314;
        r1 = r1.getDimensionPixelSize(r2);
        r0.setPadding(r1, r1, r1, r1);
        com.tencent.mm.ui.base.g.a(r10, r8, r0, r8);
        r0 = r6;
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.dbbackup.c.b(android.content.Context, java.lang.String[]):boolean");
    }

    public final boolean a(Context context, String[] strArr) {
        String str = strArr[0];
        boolean z = true;
        switch (str.hashCode()) {
            case -1870250080:
                if (str.equals("//backupdb")) {
                    z = false;
                    break;
                }
                break;
            case -398050965:
                if (str.equals("//corruptdb")) {
                    z = true;
                    break;
                }
                break;
            case 1793722114:
                if (str.equals("//recoverdb")) {
                    z = true;
                    break;
                }
                break;
        }
        final long nanoTime;
        final Context context2;
        switch (z) {
            case false:
                if (strArr.length <= 1 || !strArr[1].equals("cipher")) {
                    final boolean z2 = strArr.length > 1 && strArr[1].equals("incremental");
                    nanoTime = System.nanoTime();
                    final ProgressDialog a = g.a(context, "Backing database up. Please wait...", false, null);
                    context2 = context;
                    if (this.eXF.a(z2, new b(this) {
                        final /* synthetic */ c eXI;

                        public final void gu(final int i) {
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 eXJ;

                                public final void run() {
                                    CharSequence format;
                                    if (a != null) {
                                        a.dismiss();
                                    }
                                    if (i == 0) {
                                        String str = "Database (%s) backup succeeded, elapsed %.2f seconds.";
                                        Object[] objArr = new Object[2];
                                        objArr[0] = z2 ? "incremental" : "new";
                                        objArr[1] = Float.valueOf(((float) (System.nanoTime() - nanoTime)) / 1.0E9f);
                                        format = String.format(str, objArr);
                                    } else if (i == 1) {
                                        format = "Database backup canceled.";
                                    } else {
                                        format = "Database backup failed.";
                                    }
                                    Toast.makeText(context2, format, 0).show();
                                }
                            });
                        }
                    })) {
                        return true;
                    }
                    if (a != null) {
                        a.dismiss();
                    }
                    Toast.makeText(context, "Database is busy.", 0).show();
                    return true;
                }
                ak.yW();
                r vf = com.tencent.mm.model.c.vf();
                if (strArr.length > 2) {
                    str = strArr[2];
                    z = true;
                    switch (str.hashCode()) {
                        case 48:
                            if (str.equals("0")) {
                                z = true;
                                break;
                            }
                            break;
                        case 49:
                            if (str.equals("1")) {
                                z = true;
                                break;
                            }
                            break;
                        case 3521:
                            if (str.equals("no")) {
                                z = true;
                                break;
                            }
                            break;
                        case 3551:
                            if (str.equals("on")) {
                                z = true;
                                break;
                            }
                            break;
                        case 109935:
                            if (str.equals("off")) {
                                z = true;
                                break;
                            }
                            break;
                        case 119527:
                            if (str.equals("yes")) {
                                z = false;
                                break;
                            }
                            break;
                    }
                    switch (z) {
                        case false:
                        case true:
                        case true:
                            vf.setInt(237571, 0);
                            vf.iB(true);
                            break;
                        case true:
                        case true:
                        case true:
                            vf.setInt(237571, 1);
                            vf.iB(true);
                            break;
                    }
                }
                Toast.makeText(context, "Database backup with cipher: " + (vf.getInt(237571, 0) == 0), 0).show();
                return true;
            case true:
                String str2 = strArr.length > 1 ? strArr[1] : null;
                nanoTime = System.nanoTime();
                context.getString(2131231164);
                final ProgressDialog a2 = g.a(context, context.getString(2131234368), false, null);
                context2 = context;
                int a3 = this.eXF.a(str2, new b(this) {
                    final /* synthetic */ c eXI;

                    public final void gu(final int i) {
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 eXK;

                            public final void run() {
                                CharSequence format;
                                if (a2 != null) {
                                    a2.dismiss();
                                }
                                if (i == 0) {
                                    format = String.format("Database recovery succeeded, elapsed %.2f seconds.", new Object[]{Float.valueOf(((float) (System.nanoTime() - nanoTime)) / 1.0E9f)});
                                } else if (i == 1) {
                                    format = "Database recovery canceled.";
                                } else {
                                    format = "Database recovery failed.";
                                }
                                Toast.makeText(context2, format, 0).show();
                            }
                        });
                    }
                });
                if (a3 == 0) {
                    return true;
                }
                if (a2 != null) {
                    a2.dismiss();
                }
                switch (a3) {
                    case -3:
                        a3 = 2131234369;
                        break;
                    case -2:
                        a3 = 2131234370;
                        break;
                    default:
                        a3 = 2131234367;
                        break;
                }
                Toast.makeText(context, a3, 1).show();
                return true;
            case true:
                return b(context, strArr);
            default:
                return false;
        }
    }
}
