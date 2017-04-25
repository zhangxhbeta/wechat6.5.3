package com.tencent.smtt.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.c;
import java.util.Map;

final class t {
    private String pxA = null;
    private String[] pxB = null;
    DexLoader pxC = null;
    private String pxD = "TbsDexOpt";
    private String pxE = null;
    private Context pxy = null;
    private Context pxz = null;

    public t(Context context, Context context2, String str, String str2, String[] strArr, String str3, l lVar) {
        TbsLog.i("TbsWizard", "construction start...");
        if (context == null || context2 == null || TextUtils.isEmpty(str) || strArr == null || strArr.length == 0) {
            throw new Exception("TbsWizard paramter error:-1callerContext:" + context + "hostcontext" + context2 + "isEmpty" + TextUtils.isEmpty(str) + "dexfileList" + strArr);
        }
        int i;
        this.pxy = context.getApplicationContext();
        this.pxz = context2;
        this.pxA = str;
        this.pxB = strArr;
        this.pxD = str2;
        if (lVar != null) {
            lVar.a("load_tbs_dex", (byte) 1);
        }
        this.pxC = new DexLoader(str3, this.pxy, this.pxB, str2);
        if (lVar != null) {
            lVar.a("load_tbs_dex", (byte) 2);
        }
        libwebp.loadWepLibraryIfNeed(context2, this.pxA);
        if ("com.nd.android.pandahome2".equals(this.pxy.getApplicationInfo().packageName)) {
            this.pxC.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[]{Context.class}, this.pxy);
        }
        if (QbSdk.puX != null) {
            this.pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, QbSdk.puX);
        }
        if (lVar != null) {
            lVar.a("init_tbs", (byte) 1);
        }
        this.pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "putInfo", new Class[]{Context.class, String.class, String.class, String.class, String.class}, context, c.aKA, c.pyD, c.pyE, c.aOw);
        Object invokeStaticMethod = this.pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class}, context, this.pxz, this.pxC, this.pxA, this.pxD, "2.6.0.1061", Integer.valueOf(36901), QbSdk.bMF());
        if (invokeStaticMethod == null) {
            this.pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[]{String.class}, "2.6.0.1061");
            this.pxC.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf(36901));
            invokeStaticMethod = this.pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class}, context, this.pxz, this.pxC, this.pxA, this.pxD);
        }
        if (invokeStaticMethod == null) {
            i = -3;
        } else if (invokeStaticMethod instanceof Integer) {
            i = ((Integer) invokeStaticMethod).intValue();
        } else if (invokeStaticMethod instanceof Throwable) {
            g.bMS().a(this.pxy, 328, (Throwable) invokeStaticMethod);
            i = -5;
        } else {
            i = -4;
        }
        if (i < 0) {
            Object invokeStaticMethod2 = this.pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
            if (invokeStaticMethod2 instanceof Throwable) {
                Throwable th = (Throwable) invokeStaticMethod2;
                this.pxE = "#" + th.getMessage() + "; cause: " + th.getCause() + "; th: " + th;
            }
            if (invokeStaticMethod2 instanceof String) {
                this.pxE = (String) invokeStaticMethod2;
            }
        } else {
            this.pxE = null;
        }
        if (lVar != null) {
            lVar.a("init_tbs", (byte) 2);
        }
        if (i < 0) {
            throw new Exception("TbsWizard init error: " + i + "; msg: " + this.pxE);
        }
        TbsLog.i("TbsWizard", "construction end...");
    }
}
