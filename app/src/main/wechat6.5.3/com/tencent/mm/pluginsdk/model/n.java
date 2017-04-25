package com.tencent.mm.pluginsdk.model;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.l;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import junit.framework.Assert;

public final class n implements e {
    private Context context;
    private ProgressDialog eLA;
    private Runnable lzG = null;
    private Runnable lzH = null;
    private String path;

    public n(Context context, String str) {
        this.context = context;
        this.path = str;
        this.eLA = null;
        ak.vy().a(157, (e) this);
    }

    public final boolean a(int i, Runnable runnable) {
        boolean z = (this.context == null || this.path == null || this.path.length() <= 0) ? false : true;
        Assert.assertTrue(z);
        this.lzG = runnable;
        Context context = this.context;
        this.context.getString(2131231164);
        this.eLA = g.a(context, this.context.getString(2131235195), true, null);
        ak.vy().a(new l(i, this.path), 0);
        String str = "MicroMsg.ProcessUploadHDHeadImg";
        String str2 = "post is null ? %B";
        Object[] objArr = new Object[1];
        if (runnable == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        v.i(str, str2, objArr);
        return true;
    }

    public final boolean a(Runnable runnable, Runnable runnable2) {
        boolean z = (this.context == null || this.path == null || this.path.length() <= 0) ? false : true;
        Assert.assertTrue(z);
        this.lzG = runnable;
        this.lzH = runnable2;
        ak.vy().a(new l(1, this.path), 0);
        v.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", Boolean.valueOf(false));
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r6, int r7, java.lang.String r8, com.tencent.mm.v.k r9) {
        /*
        r5 = this;
        r1 = 0;
        r0 = "MicroMsg.ProcessUploadHDHeadImg";
        r2 = new java.lang.StringBuilder;
        r3 = "onSceneEnd: errType = ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r3 = " errCode = ";
        r2 = r2.append(r3);
        r2 = r2.append(r7);
        r3 = " errMsg = ";
        r2 = r2.append(r3);
        r2 = r2.append(r8);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);
        r0 = com.tencent.mm.model.ak.vy();
        r2 = 157; // 0x9d float:2.2E-43 double:7.76E-322;
        r0.b(r2, r5);
        r0 = r5.eLA;
        if (r0 == 0) goto L_0x0057;
    L_0x003a:
        r0 = r5.eLA;
        r0 = r0.isShowing();
        if (r0 == 0) goto L_0x0057;
    L_0x0042:
        r0 = r5.context;
        r0 = r0 instanceof android.app.Activity;
        if (r0 == 0) goto L_0x0057;
    L_0x0048:
        r0 = r5.context;
        r0 = (android.app.Activity) r0;
        r0 = r0.isFinishing();
        if (r0 != 0) goto L_0x0057;
    L_0x0052:
        r0 = r5.eLA;	 Catch:{ IllegalArgumentException -> 0x007a }
        r0.dismiss();	 Catch:{ IllegalArgumentException -> 0x007a }
    L_0x0057:
        if (r6 != 0) goto L_0x0096;
    L_0x0059:
        if (r7 != 0) goto L_0x0096;
    L_0x005b:
        r0 = r5.context;
        r2 = 2131235194; // 0x7f08117a float:1.8086575E38 double:1.0529700926E-314;
        r0 = android.widget.Toast.makeText(r0, r2, r1);
        r0.show();
        r0 = r5.lzG;
        if (r0 == 0) goto L_0x0079;
    L_0x006b:
        r0 = new com.tencent.mm.sdk.platformtools.ac;
        r1 = android.os.Looper.getMainLooper();
        r0.<init>(r1);
        r1 = r5.lzG;
        r0.post(r1);
    L_0x0079:
        return;
    L_0x007a:
        r0 = move-exception;
        r2 = "MicroMsg.ProcessUploadHDHeadImg";
        r3 = new java.lang.StringBuilder;
        r4 = "dismiss dialog err";
        r3.<init>(r4);
        r0 = r0.getMessage();
        r0 = r3.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.v.e(r2, r0);
        goto L_0x0057;
    L_0x0096:
        r0 = r5.lzH;
        if (r0 == 0) goto L_0x00a8;
    L_0x009a:
        r0 = new com.tencent.mm.sdk.platformtools.ac;
        r2 = android.os.Looper.getMainLooper();
        r0.<init>(r2);
        r2 = r5.lzH;
        r0.post(r2);
    L_0x00a8:
        switch(r6) {
            case 4: goto L_0x00bb;
            default: goto L_0x00ab;
        };
    L_0x00ab:
        r0 = r1;
    L_0x00ac:
        if (r0 != 0) goto L_0x0079;
    L_0x00ae:
        r0 = r5.context;
        r2 = 2131235193; // 0x7f081179 float:1.8086573E38 double:1.052970092E-314;
        r0 = android.widget.Toast.makeText(r0, r2, r1);
        r0.show();
        goto L_0x0079;
    L_0x00bb:
        r0 = -4;
        if (r7 != r0) goto L_0x00ab;
    L_0x00be:
        r0 = r5.context;
        r2 = 2131232102; // 0x7f080566 float:1.8080304E38 double:1.052968565E-314;
        r0 = android.widget.Toast.makeText(r0, r2, r1);
        r0.show();
        r0 = 1;
        goto L_0x00ac;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.model.n.a(int, int, java.lang.String, com.tencent.mm.v.k):void");
    }
}
