package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.modelappbrand.AppBrandExportUrlParams;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public enum g {
    ;

    public static String mE(String str) {
        return String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=overseas#wechat_redirect", new Object[]{str});
    }

    public static String cw(String str, int i) {
        return String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=offshelf&offshelf_type=%d#wechat_redirect", new Object[]{str, Integer.valueOf(i)});
    }

    public static String mG(String str) {
        return String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=notscan#wechat_redirect", new Object[]{str});
    }

    public static String M(String str, int i) {
        return String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=ban&banscene=%d#wechat_redirect", new Object[]{str, Integer.valueOf(i)});
    }

    public static String a(AppBrandExportUrlParams appBrandExportUrlParams) {
        String str = "";
        if (be.kS(appBrandExportUrlParams.appId)) {
            v.e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl fail, null or nil appId");
        } else {
            try {
                str = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[]{appBrandExportUrlParams.appId, p.encode(be.ma(appBrandExportUrlParams.dJA), "UTF-8"), Integer.valueOf(appBrandExportUrlParams.cPY), Integer.valueOf(be.n(Integer.valueOf(appBrandExportUrlParams.dBr), -1)), Integer.valueOf(be.n(Integer.valueOf(appBrandExportUrlParams.dBs), -1))});
            } catch (UnsupportedEncodingException e) {
                v.e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl encode fail, invalid arguments");
            }
        }
        return str;
    }

    public static String mH(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.AppBrandUrlBuilders", "buildEntityUrl fail, null or nil appId");
            return "";
        }
        return String.format("https://mp.weixin.qq.com/mp/waverifyinfo?action=get&appid=%s#wechat_redirect", new Object[]{str});
    }

    public static String mI(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.AppBrandUrlBuilders", "buildLowVersionUrl fail, invalid arguments");
            return "";
        }
        return String.format("https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=upgrade#wechat_redirect", new Object[]{str});
    }
}
