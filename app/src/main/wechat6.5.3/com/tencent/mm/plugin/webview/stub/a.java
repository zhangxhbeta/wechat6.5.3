package com.tencent.mm.plugin.webview.stub;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public static final boolean cO(Context context) {
        try {
            PackageInfo av = s.av(context, "com.tencent.mobileqq");
            String str = "MicroMsg.ConstantsWebViewStub";
            String str2 = "isQQSupportShare(%s).";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(av != null);
            v.d(str, str2, objArr);
            if (av != null) {
                return true;
            }
        } catch (Exception e) {
            v.e("MicroMsg.ConstantsWebViewStub", "exception has occurred in isQQSupportShare(), e : %s.", new Object[]{e.getMessage()});
        }
        return false;
    }

    public static final boolean aG(Context context, String str) {
        if (be.kS(str)) {
            return false;
        }
        try {
            PackageInfo av = s.av(context, "com.tencent.weread");
            String str2 = "MicroMsg.ConstantsWebViewStub";
            String str3 = "isWeReadSupportShare(%s).";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(av != null);
            v.d(str2, str3, objArr);
            if (av == null || !Uri.parse(str).getHost().startsWith("mp.weixin.qq.com") || av.versionCode <= 2000812) {
                return false;
            }
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.ConstantsWebViewStub", "exception has occurred in isQzoneSupportShare(), e : %s.", new Object[]{e.getMessage()});
            return false;
        }
    }
}
