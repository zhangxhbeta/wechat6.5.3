package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.pluginsdk.j.ag;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.JSAPIUploadLogHelperUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;

public final class a implements ag {
    public final boolean a(Context context, String str, boolean z) {
        return a(context, str, z, null);
    }

    public final boolean a(Context context, String str, boolean z, m mVar) {
        if (context == null) {
            v.e("MicroMsg.MMURIJumpHandler", "jumpToURLWithCallback, context is null!");
            return false;
        } else if (str.startsWith("http")) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            try {
                context.startActivity(intent);
            } catch (Exception e) {
                v.e("MicroMsg.MMURIJumpHandler", "openLinkInBrowser fail:%s", e.getMessage());
            }
            return true;
        } else if (b(context, str, z, mVar)) {
            return false;
        } else {
            v.w("MicroMsg.MMURIJumpHandler", "jumpToUI failed, uri:%s", str);
            return false;
        }
    }

    public final boolean a(Context context, String str, boolean z, Bundle bundle) {
        return a(context, str, z, null, bundle);
    }

    public final boolean b(Context context, String str, boolean z, m mVar) {
        return a(context, str, z, mVar, null);
    }

    private boolean a(Context context, String str, boolean z, m mVar, Bundle bundle) {
        if (context == null) {
            v.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal, context is null!");
            return false;
        } else if (str == null) {
            v.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal url is null");
            return false;
        } else if (str.startsWith("weixin://openSpecificView/")) {
            return b(context, str, new Object[0]);
        } else {
            e oQ = e.oQ();
            String str2 = "MicroMsg.URISpanHandler";
            String str3 = "handleUriJump, url:%s, isAllowScanQrCode:%b, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size: %d, mLowPriorityHandlerList.size: %d";
            Object[] objArr = new Object[6];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Boolean.valueOf(mVar == null);
            objArr[3] = Integer.valueOf(oQ.aSp.size());
            objArr[4] = Integer.valueOf(oQ.aSq.size());
            objArr[5] = Integer.valueOf(oQ.aSr.size());
            v.d(str2, str3, objArr);
            if (context == null) {
                v.e("MicroMsg.URISpanHandler", "handleUriJump, context is null!");
                oQ.aSo.mContext = null;
                return false;
            }
            oQ.mContext = context;
            oQ.aSo.mContext = oQ.mContext;
            if (be.kS(str)) {
                v.d("MicroMsg.URISpanHandler", "handleUriJump, url is null");
                oQ.mContext = null;
                oQ.aSo.mContext = null;
                return false;
            }
            Iterator it = oQ.aSp.iterator();
            while (it.hasNext()) {
                if (((BaseUriSpanHandler) it.next()).a(str, z, mVar, bundle)) {
                    v.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", ((BaseUriSpanHandler) it.next()).getClass().getName());
                    oQ.mContext = null;
                    oQ.aSo.mContext = null;
                    return true;
                }
            }
            it = oQ.aSq.iterator();
            while (it.hasNext()) {
                if (((BaseUriSpanHandler) it.next()).a(str, z, mVar, bundle)) {
                    v.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", ((BaseUriSpanHandler) it.next()).getClass().getName());
                    oQ.mContext = null;
                    oQ.aSo.mContext = null;
                    return true;
                }
            }
            it = oQ.aSr.iterator();
            while (it.hasNext()) {
                if (((BaseUriSpanHandler) it.next()).a(str, z, mVar, bundle)) {
                    v.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", ((BaseUriSpanHandler) it.next()).getClass().getName());
                    oQ.mContext = null;
                    oQ.aSo.mContext = null;
                    return true;
                }
            }
            oQ.mContext = null;
            oQ.aSo.mContext = null;
            v.d("MicroMsg.URISpanHandler", "handleUriJump, nothing handle");
            return false;
        }
    }

    public final boolean b(Context context, String str, Object... objArr) {
        if (str == null) {
            v.d("MicroMsg.MMURIJumpHandler", "openSpecificUI uri is null");
            return false;
        } else if (context == null) {
            v.e("MicroMsg.MMURIJumpHandler", "openSpecificUI, context is null");
            return false;
        } else {
            Intent intent = new Intent();
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            String replace = str.replace("weixin://openSpecificView/", SQLiteDatabase.KeyEmpty);
            Bundle bundle = null;
            if (objArr != null && objArr.length > 0) {
                bundle = (Bundle) objArr[0];
            }
            if (replace.equalsIgnoreCase("contacts")) {
                intent.addFlags(67108864);
                intent.putExtra("preferred_tab", 2);
                context.startActivity(intent.setClass(context, LauncherUI.class));
            } else if (replace.equalsIgnoreCase("newfriend")) {
                c.b(context, "subapp", ".ui.friend.FMessageConversationUI", intent);
            } else if (replace.equalsIgnoreCase("addfriend")) {
                c.b(context, "subapp", ".ui.pluginapp.AddMoreFriendsUI", intent);
            } else if (replace.equalsIgnoreCase("searchbrand")) {
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_Scene", 39);
                c.b(context, "brandservice", ".ui.SearchOrRecommendBizUI", intent2);
            } else if (replace.equalsIgnoreCase("discover")) {
                intent.addFlags(67108864);
                intent.putExtra("preferred_tab", 1);
                context.startActivity(intent.setClass(context, LauncherUI.class));
            } else if (replace.equalsIgnoreCase("timeline")) {
                c.b(context, "sns", ".ui.SnsTimeLineUI", intent);
            } else if (replace.equalsIgnoreCase("scan")) {
                c.b(context, "scanner", ".ui.BaseScanUI", intent);
            } else if (replace.equalsIgnoreCase("myprofile")) {
                c.b(context, "setting", ".ui.setting.SettingsPersonalInfoUI", intent);
            } else if (replace.equalsIgnoreCase("myaccount")) {
                c.b(context, "setting", ".ui.setting.SettingsAccountInfoUI", intent);
            } else if (replace.equalsIgnoreCase("bindphone")) {
                MMWizardActivity.w(context, intent.setClass(context, BindMContactIntroUI.class));
            } else if (replace.equalsIgnoreCase("privacy")) {
                c.b(context, "setting", ".ui.setting.SettingsPrivacyUI", intent);
            } else if (replace.equalsIgnoreCase("general")) {
                c.b(context, "setting", ".ui.setting.SettingsAboutSystemUI", intent);
            } else if (replace.equalsIgnoreCase("invitevoip")) {
                VoipAddressUI.eD(context);
            } else if (replace.equalsIgnoreCase("expose")) {
                replace = SQLiteDatabase.KeyEmpty;
                if (bundle != null) {
                    r0 = bundle.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                } else {
                    r0 = replace;
                }
                intent.putExtra("k_expose_url", r0);
                intent.putExtra("k_username", k.xF());
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(34)}));
                c.b(context, "webview", ".ui.tools.WebViewUI", intent);
            } else if (replace.equalsIgnoreCase("shakecard")) {
                replace = SQLiteDatabase.KeyEmpty;
                if (bundle != null) {
                    r0 = bundle.getString("extinfo");
                } else {
                    r0 = replace;
                }
                intent.putExtra("key_shake_card_from_scene", 3);
                intent.putExtra("shake_card", true);
                intent.putExtra("key_shake_card_ext_info", r0);
                c.b(context, "shake", ".ui.ShakeReportUI", intent);
            } else if (replace.equalsIgnoreCase("cardlistview")) {
                c.b(context, "card", ".ui.CardHomePageUI", intent);
            } else if (!replace.equalsIgnoreCase("uploadlog")) {
                return false;
            } else {
                int i;
                replace = k.xF();
                if (be.kS(replace)) {
                    replace = "weixin";
                }
                try {
                    i = be.getInt(bundle.getString("extinfo"), 0);
                } catch (Exception e) {
                    i = 0;
                }
                String str2 = "MicroMsg.MMURIJumpHandler";
                String str3 = "upload log from jsapi, before upload, is-login:%b, time:%d";
                Object[] objArr2 = new Object[2];
                boolean z = ak.uz() && !ak.uG();
                objArr2[0] = Boolean.valueOf(z);
                objArr2[1] = Integer.valueOf(i);
                v.i(str2, str3, objArr2);
                Intent intent3 = new Intent(context, JSAPIUploadLogHelperUI.class);
                intent3.putExtra("key_user", replace);
                intent3.putExtra("key_time", i);
                context.startActivity(intent3);
            }
            return true;
        }
    }
}
