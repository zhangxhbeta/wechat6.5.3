package com.tencent.mm.pluginsdk;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.bf;
import com.tencent.mm.e.a.gl;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.draft.ui.SightDraftUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.bad;
import com.tencent.mm.protocal.c.cb;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class d {
    private static final Map<String, Long> lxA;
    public static String lxz = SQLiteDatabase.KeyEmpty;

    public interface a {
        void a(int i, int i2, String str, k kVar, boolean z);
    }

    static {
        Map hashMap = new HashMap();
        lxA = hashMap;
        hashMap.put("weixin://", Long.valueOf(0));
        lxA.put("weixin://dl/stickers", Long.valueOf(1));
        lxA.put("weixin://dl/games", Long.valueOf(2));
        lxA.put("weixin://dl/moments", Long.valueOf(4));
        lxA.put("weixin://dl/add", Long.valueOf(8));
        lxA.put("weixin://dl/shopping", Long.valueOf(16));
        lxA.put("weixin://dl/groupchat", Long.valueOf(32));
        lxA.put("weixin://dl/scan", Long.valueOf(64));
        lxA.put("weixin://dl/profile", Long.valueOf(128));
        lxA.put("weixin://dl/settings", Long.valueOf(256));
        lxA.put("weixin://dl/general", Long.valueOf(512));
        lxA.put("weixin://dl/help", Long.valueOf(1024));
        lxA.put("weixin://dl/notifications", Long.valueOf(2048));
        lxA.put("weixin://dl/terms", Long.valueOf(4096));
        lxA.put("weixin://dl/chat", Long.valueOf(8192));
        lxA.put("weixin://dl/features", Long.valueOf(16384));
        lxA.put("weixin://dl/clear", Long.valueOf(32768));
        lxA.put("weixin://dl/feedback", Long.valueOf(65536));
        lxA.put("weixin://dl/faq", Long.valueOf(131072));
        lxA.put("weixin://dl/recommendation", Long.valueOf(262144));
        lxA.put("weixin://dl/groups", Long.valueOf(524288));
        lxA.put("weixin://dl/tags", Long.valueOf(1048576));
        lxA.put("weixin://dl/officialaccounts", Long.valueOf(2097152));
        lxA.put("weixin://dl/posts", Long.valueOf(4194304));
        lxA.put("weixin://dl/favorites", Long.valueOf(8388608));
        lxA.put("weixin://dl/privacy", Long.valueOf(16777216));
        lxA.put("weixin://dl/security", Long.valueOf(33554432));
        lxA.put("weixin://dl/wallet", Long.valueOf(67108864));
        lxA.put("weixin://dl/businessPay", Long.valueOf(134217728));
        lxA.put("weixin://dl/businessPay/", Long.valueOf(134217728));
        lxA.put("weixin://dl/wechatout", Long.valueOf(268435456));
        lxA.put("weixin://dl/protection", Long.valueOf(1073741824));
        lxA.put("weixin://dl/card", Long.valueOf(2147483648L));
        lxA.put("weixin://dl/about", Long.valueOf(1125899906842624L));
        lxA.put("weixin://dl/blacklist", Long.valueOf(4294967296L));
        lxA.put("weixin://dl/textsize", Long.valueOf(8589934592L));
        lxA.put("weixin://dl/sight", Long.valueOf(17179869184L));
        lxA.put("weixin://dl/languages", Long.valueOf(34359738368L));
        lxA.put("weixin://dl/chathistory", Long.valueOf(68719476736L));
        lxA.put("weixin://dl/bindqq", Long.valueOf(137438953472L));
        lxA.put("weixin://dl/bindmobile", Long.valueOf(274877906944L));
        lxA.put("weixin://dl/bindemail", Long.valueOf(549755813888L));
        lxA.put("weixin://dl/securityassistant", Long.valueOf(1099511627776L));
        lxA.put("weixin://dl/broadcastmessage", Long.valueOf(2199023255552L));
        lxA.put("weixin://dl/setname", Long.valueOf(4398046511104L));
        lxA.put("weixin://dl/myQRcode", Long.valueOf(8796093022208L));
        lxA.put("weixin://dl/myaddress", Long.valueOf(17592186044416L));
        lxA.put("weixin://dl/hidemoments", Long.valueOf(35184372088832L));
        lxA.put("weixin://dl/blockmoments", Long.valueOf(70368744177664L));
        lxA.put("weixin://dl/stickersetting", Long.valueOf(140737488355328L));
        lxA.put("weixin://dl/log", Long.valueOf(281474976710656L));
        lxA.put("weixin://dl/wechatoutcoupon", Long.valueOf(562949953421312L));
        lxA.put("weixin://dl/wechatoutshare", Long.valueOf(18014398509481984L));
        lxA.put("weixin://dl/personalemoticon", Long.valueOf(4503599627370496L));
        lxA.put("weixin://dl/designeremoji", Long.valueOf(9007199254740992L));
        lxA.put("weixin://dl/sightdraft", Long.valueOf(576460752303423488L));
    }

    public static boolean E(String str, long j) {
        if (!be.kS(str)) {
            long longValue;
            String Gf = Gf(str);
            if (lxA.containsKey(Gf)) {
                longValue = ((Long) lxA.get(Gf)).longValue();
            } else {
                longValue = -1;
            }
            if (longValue != -1 && (longValue == 0 || (longValue & j) == longValue)) {
                return true;
            }
        }
        return false;
    }

    public static boolean Gb(String str) {
        String Gf = Gf(str);
        return lxA.containsKey(Gf) || Gc(Gf);
    }

    public static boolean Gc(String str) {
        return !be.kS(str) && str.startsWith("weixin://dl/business");
    }

    public static boolean i(Uri uri) {
        if (uri == null) {
            return false;
        }
        if (be.kS(uri.getQueryParameter("ticket"))) {
            return j(uri);
        }
        return true;
    }

    public static boolean j(Uri uri) {
        if (uri == null) {
            return false;
        }
        if (uri.toString().startsWith("weixin://dl/business/tempsession/") || uri.toString().startsWith("weixin://dl/businessTempSession/")) {
            return true;
        }
        return false;
    }

    private static boolean Gd(String str) {
        if ((!str.equals("weixin://dl/wechatout") && !str.equals("weixin://dl/wechatoutcoupon") && !str.equals("weixin://dl/wechatoutshare")) || Boolean.valueOf(com.tencent.mm.plugin.ipcall.d.atT()).booleanValue()) {
            return false;
        }
        Intent intent = new Intent();
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClassName(aa.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
        aa.getContext().startActivity(intent);
        return true;
    }

    public static void a(Context context, String str, String str2, int i, String str3, a aVar) {
        final String str4 = be.kS(str) ? str3 : str;
        if (!Gd(str4)) {
            k lVar = new l(str4, str2, i);
            final Context context2 = context;
            final int i2 = i;
            final String str5 = str2;
            final a aVar2 = aVar;
            ak.vy().a(233, new e() {
                public final void a(int i, int i2, String str, k kVar) {
                    ak.vy().b(233, (e) this);
                    v.i("MicroMsg.DeepLinkHelper", "[oneliang][doDeepLink][onSceneEnd]:errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    boolean z = false;
                    if (kVar != null && (kVar instanceof l)) {
                        l lVar = (l) kVar;
                        v.d("MicroMsg.DeepLinkHelper", "bitset:" + lVar.IZ());
                        long IZ = lVar.IZ();
                        String IT = lVar.IT();
                        if (d.E(IT, IZ)) {
                            try {
                                v.i("MicroMsg.DeepLinkHelper", "[oneliang] uri: %s", IT);
                                z = d.aI(context2, IT);
                                g.iuh.h(11405, IT, Integer.valueOf(1), Integer.valueOf(i2), str5, be.ma(str4));
                            } catch (Throwable e) {
                                v.a("MicroMsg.DeepLinkHelper", e, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                                g.iuh.h(11405, IT, Integer.valueOf(0), Integer.valueOf(i2), str5, be.ma(str4));
                            }
                        } else {
                            v.i("MicroMsg.DeepLinkHelper", "[oneliang] no permission");
                            Intent intent = new Intent();
                            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            intent.setClassName(aa.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                            intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
                            aa.getContext().startActivity(intent);
                            g.iuh.h(11405, IT, Integer.valueOf(0), Integer.valueOf(i2), str5, be.ma(str4));
                            z = true;
                        }
                    }
                    if (aVar2 != null) {
                        aVar2.a(i, i2, str, kVar, z);
                    }
                }
            });
            ak.vy().a(lVar, 0);
        }
    }

    public static void a(final Context context, final String str, final int i, final a aVar, String str2, String str3) {
        LinkedList linkedList = new LinkedList();
        cb cbVar = new cb();
        if (!(be.kS(str2) || be.kS(str3))) {
            v.i("MicroMsg.DeepLinkHelper", "package name = %s, package signature = %s", str2, str3);
            cbVar.mct = str2;
            cbVar.bCj = str3;
            linkedList.add(cbVar);
        }
        if (!Gd(str)) {
            k afVar = new af(str, i, linkedList);
            ak.vy().a(1200, new e() {
                public final void a(int i, int i2, String str, k kVar) {
                    ak.vy().b(1200, (e) this);
                    v.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: errType = %s; errCode = %s; errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    boolean z = false;
                    if (kVar != null && (kVar instanceof af)) {
                        bad com_tencent_mm_protocal_c_bad = (bad) ((af) kVar).cif.czl.czs;
                        String str2 = com_tencent_mm_protocal_c_bad == null ? null : com_tencent_mm_protocal_c_bad.mWL;
                        if (d.Gb(str2)) {
                            try {
                                v.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: deepLinkUri = %s", str2);
                                z = d.i(context, str2, i);
                                g.iuh.h(11405, str, Integer.valueOf(i), Integer.valueOf(1), str2);
                            } catch (Throwable e) {
                                v.a("MicroMsg.DeepLinkHelper", e, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                                g.iuh.h(11405, str, Integer.valueOf(i), Integer.valueOf(0), str2);
                            }
                        } else {
                            v.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: translate failed");
                            Intent intent = new Intent();
                            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            intent.setClassName(aa.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                            intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
                            intent.putExtra("showShare", false);
                            aa.getContext().startActivity(intent);
                            g.iuh.h(11405, str, Integer.valueOf(i), Integer.valueOf(0), str2);
                            z = true;
                        }
                    }
                    if (aVar != null) {
                        aVar.a(i, i2, str, kVar, z);
                    }
                }
            });
            ak.vy().a(afVar, 0);
        }
    }

    public static void a(Context context, String str, int i, a aVar) {
        a(context, str, i, aVar, null, null);
    }

    public static boolean Ge(String str) {
        return j(null, str, 0);
    }

    public static boolean aI(Context context, String str) {
        return j(context, str, 0);
    }

    public static boolean i(Context context, String str, int i) {
        return j(context, str, i);
    }

    private static boolean j(Context context, String str, int i) {
        String Gf = Gf(str);
        if (be.kS(Gf)) {
            return false;
        }
        String substring;
        String encode;
        Uri parse;
        String queryParameter;
        if (lxA.containsKey(Gf)) {
            long longValue = ((Long) lxA.get(Gf)).longValue();
            Gf = null;
            Intent intent = new Intent();
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (longValue == 0) {
                Gf = "com.tencent.mm.ui.LauncherUI";
            } else if (longValue == 1) {
                Gf = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
                g.iuh.h(12065, Integer.valueOf(7));
            } else if (longValue == 2) {
                intent.putExtra("from_deeplink", true);
                intent.putExtra("game_report_from_scene", 6);
                Gf = "com.tencent.mm.plugin.game.ui.GameCenterUI";
            } else if (longValue == 4) {
                if (((com.tencent.mm.model.k.xQ() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0 ? 1 : null) != null) {
                    Gf = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
                    intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                }
            } else if (longValue == 8) {
                Gf = "com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI";
            } else if (longValue == 16) {
                b glVar = new gl();
                com.tencent.mm.sdk.c.a.nhr.z(glVar);
                r4 = glVar.bfX.url;
                if (!be.kS(r4)) {
                    intent.putExtra("rawUrl", r4);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    Gf = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                }
            } else if (longValue == 32) {
                intent.putExtra("titile", aa.getContext().getString(2131230881));
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", r.s(r.oHK, FileUtils.S_IRUSR, 512));
                Gf = "com.tencent.mm.ui.contact.SelectContactUI";
            } else if (longValue == 64) {
                Gf = "com.tencent.mm.plugin.scanner.ui.BaseScanUI";
                intent.putExtra("animation_pop_in", true);
            } else if (longValue == 128) {
                Gf = "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI";
            } else if (longValue == 256) {
                Gf = "com.tencent.mm.plugin.setting.ui.setting.SettingsUI";
            } else if (longValue == 512) {
                Gf = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI";
            } else if (longValue == 1024) {
                cZ(aa.getContext());
            } else if (longValue == 2048) {
                Gf = "com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI";
            } else if (longValue == 4096) {
                intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE, aa.getContext().getResources().getString(2131234246));
                intent.putExtra("rawUrl", aa.getContext().getResources().getString(2131235735));
                intent.putExtra("showShare", false);
                Gf = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            } else if (longValue == 8192) {
                Gf = "com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI";
            } else if (longValue == 16384) {
                Gf = "com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI";
            } else if (longValue == 32768) {
                Gf = "com.tencent.mm.plugin.clean.ui.CleanUI";
            } else if (longValue == 65536) {
                try {
                    r4 = SQLiteDatabase.KeyEmpty;
                    int indexOf = str.indexOf("?");
                    if (indexOf > 0) {
                        substring = str.substring(indexOf + 1);
                    } else {
                        substring = r4;
                    }
                    r4 = ak.uQ();
                    encode = URLEncoder.encode(com.tencent.mm.protocal.d.lWf, "utf-8");
                    String encode2 = URLEncoder.encode(be.buj(), "utf-8");
                    String encode3 = URLEncoder.encode(p.rJ(), "utf-8");
                    String encode4 = URLEncoder.encode(com.tencent.mm.protocal.d.lWa, "utf-8");
                    String encode5 = URLEncoder.encode(com.tencent.mm.protocal.d.lWb, "utf-8");
                    r4 = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&version=" + com.tencent.mm.protocal.d.lWh + "&lang=" + u.dJ(aa.getContext()) + "&" + be.ma(substring) + ("&uin=" + r4 + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + encode3 + "&deviceBrand=" + encode4 + "&deviceModel=" + encode5 + "&ostype=" + URLEncoder.encode(com.tencent.mm.protocal.d.lWc, "utf-8") + "&clientSeqID=" + URLEncoder.encode(ak.uR(), "utf-8") + "&signature=" + URLEncoder.encode(bb.zw(), "utf-8") + "&scene=" + (be.kS(substring) ? 0 : 1));
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", r4);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                    Gf = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                } catch (UnsupportedEncodingException e) {
                    v.e("MicroMsg.DeepLinkHelper", "[oneliang]UnsupportedEncodingException:%s", e.getMessage());
                }
            } else if (longValue == 131072) {
                r4 = ak.uQ();
                ak.yW();
                r2 = be.f((Integer) c.vf().get(12304, null));
                Gf = aa.getContext().getString(2131235163, new Object[]{Integer.valueOf(r4), Integer.valueOf(r2)});
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", Gf);
                Gf = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            } else if (longValue == 262144) {
                Gf = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
            } else if (longValue == 524288) {
                Gf = "com.tencent.mm.ui.contact.ChatroomContactUI";
            } else if (longValue == 1048576) {
                Gf = "com.tencent.mm.plugin.label.ui.ContactLabelManagerUI";
            } else if (longValue == 2097152) {
                Gf = "com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI";
            } else if (longValue == 268435456) {
                intent.putExtra("IPCallAddressUI_KFrom", 1);
                com.tencent.mm.ay.c.b(aa.getContext(), "ipcall", ".ui.IPCallAddressUI", intent);
                return true;
            } else if (longValue == 4194304) {
                ak.yW();
                intent.putExtra("sns_userName", (String) c.vf().get(2, null));
                intent.addFlags(67108864);
                ak.yW();
                r2 = be.a((Integer) c.vf().get(68389, null), 0);
                ak.yW();
                c.vf().set(68389, Integer.valueOf(r2 + 1));
                Gf = "com.tencent.mm.plugin.sns.ui.SnsUserUI";
            } else if (longValue == 8388608) {
                Gf = "com.tencent.mm.plugin.favorite.ui.FavoriteIndexUI";
            } else if (longValue == 16777216) {
                Gf = "com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI";
            } else if (longValue == 33554432) {
                Gf = "com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI";
            } else if (longValue == 67108864) {
                Gf = "com.tencent.mm.plugin.mall.ui.MallIndexUI";
            } else if (longValue == 134217728) {
                if (!(context == null || be.kS(str))) {
                    if (str.startsWith("weixin://dl/businessPay")) {
                        parse = Uri.parse(str);
                        if (parse != null) {
                            r4 = parse.getQueryParameter("reqkey");
                            queryParameter = parse.getQueryParameter("appid");
                            if (be.kS(r4)) {
                                v.w("MicroMsg.DeepLinkHelper", "reqkey null");
                            } else {
                                Parcelable payInfo = new PayInfo();
                                payInfo.fTG = r4;
                                payInfo.appId = queryParameter;
                                payInfo.bkq = 36;
                                payInfo.lVz = false;
                                intent = new Intent();
                                intent.putExtra("key_pay_info", payInfo);
                                if (com.tencent.mm.model.k.xT()) {
                                    com.tencent.mm.ay.c.b(context, "wallet_payu", ".pay.ui.WalletPayUPayUI", intent, 1);
                                } else {
                                    com.tencent.mm.ay.c.b(context, "wallet", ".pay.ui.WalletPayUI", intent, 1);
                                }
                            }
                        } else {
                            v.w("MicroMsg.DeepLinkHelper", "payUri null");
                        }
                    }
                }
                intent = null;
            } else if (longValue == 1073741824) {
                Gf = "com.tencent.mm.plugin.safedevice.ui.MySafeDeviceListUI";
            } else if (longValue == 2147483648L) {
                Gf = "com.tencent.mm.plugin.card.ui.CardHomePageUI";
            } else if (longValue == 4294967296L) {
                intent.putExtra("filter_type", com.tencent.mm.model.r.fB(aa.getContext().getString(2131233189)).getType());
                intent.putExtra("titile", aa.getContext().getString(2131235113));
                intent.putExtra("list_attr", WXMediaMessage.THUMB_LENGTH_LIMIT);
                Gf = "com.tencent.mm.ui.contact.SelectSpecialContactUI";
            } else if (longValue == 8589934592L) {
                Gf = "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI";
            } else if (longValue == 17179869184L) {
                Gf = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI";
            } else if (longValue == 34359738368L) {
                Gf = "com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI";
            } else if (longValue == 68719476736L) {
                Gf = "com.tencent.mm.plugin.backup.moveui.BakMoveUI";
            } else if (longValue == 137438953472L) {
                intent.setClassName(aa.getContext(), "com.tencent.mm.ui.bindqq.BindQQUI");
                MMWizardActivity.w(context, intent);
                return true;
            } else if (longValue == 274877906944L) {
                intent.setClassName(aa.getContext(), "com.tencent.mm.ui.bindmobile.BindMContactIntroUI");
                MMWizardActivity.w(context, intent);
                return true;
            } else if (longValue == 549755813888L) {
                Gf = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI";
            } else if (longValue == 1099511627776L) {
                com.tencent.mm.ay.c.b(aa.getContext(), "profile", ".ui.ContactInfoUI", intent.putExtra("Contact_User", "qqsync"));
                return true;
            } else if (longValue == 2199023255552L) {
                Gf = "com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI";
            } else if (longValue == 4398046511104L) {
                Gf = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI";
            } else if (longValue == 8796093022208L) {
                Gf = "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI";
            } else if (longValue == 17592186044416L) {
                intent.putExtra("launch_from_webview", false);
                com.tencent.mm.ay.c.a(aa.getContext(), "address", ".ui.WalletSelectAddrUI", intent, true);
                return true;
            } else if (longValue == 35184372088832L) {
                intent.putExtra("k_sns_tag_id", 4);
                intent.putExtra("k_sns_from_settings_about_sns", 1);
                com.tencent.mm.ay.c.b(aa.getContext(), "sns", ".ui.SnsBlackDetailUI", intent);
                return true;
            } else if (longValue == 70368744177664L) {
                intent.putExtra("k_sns_tag_id", 5);
                intent.putExtra("k_sns_from_settings_about_sns", 2);
                intent.putExtra("k_tag_detail_sns_block_scene", 8);
                com.tencent.mm.ay.c.b(aa.getContext(), "sns", ".ui.SnsTagDetailUI", intent);
            } else if (longValue == 140737488355328L) {
                Gf = "com.tencent.mm.plugin.emoji.ui.EmojiMineUI";
            } else if (longValue == 281474976710656L) {
                b bfVar = new bf();
                bfVar.aYK.aYM = "//uplog";
                bfVar.aYK.context = aa.getContext();
                com.tencent.mm.sdk.c.a.nhr.z(bfVar);
                return true;
            } else if (longValue == 562949953421312L) {
                intent.putExtra("IPCallAddressUI_KFrom", 1);
                com.tencent.mm.ay.c.b(aa.getContext(), "ipcall", ".ui.IPCallAddressUI", intent);
                com.tencent.mm.ay.c.b(aa.getContext(), "ipcall", ".ui.IPCallShareCouponUI", intent);
                return true;
            } else if (longValue == 18014398509481984L) {
                intent.putExtra("IPCallAddressUI_KFrom", 1);
                com.tencent.mm.ay.c.b(aa.getContext(), "ipcall", ".ui.IPCallAddressUI", intent);
                com.tencent.mm.ay.c.b(aa.getContext(), "ipcall", ".ui.IPCallShareCouponUI", intent);
                com.tencent.mm.ay.c.b(aa.getContext(), "ipcall", ".ui.IPCallShareCouponCardUI", intent);
            } else if (longValue == 576460752303423488L) {
                intent.putExtra("IPCallAddressUI_KFrom", 1);
                intent.setClass(aa.getContext(), SightDraftUI.class);
                aa.getContext().startActivity(intent);
            } else if (longValue == 1125899906842624L) {
                Gf = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI";
            } else if (longValue == 4503599627370496L) {
                intent.putExtra("emoji_tab", 1);
                Gf = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
                g.iuh.h(12065, Integer.valueOf(7));
            } else if (longValue == 9007199254740992L) {
                Gf = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI";
            }
            if (be.kS(Gf)) {
                return false;
            }
            intent.setClassName(aa.getContext(), Gf);
            if (context != null) {
                try {
                    context.startActivity(intent);
                } catch (Throwable e2) {
                    v.a("MicroMsg.DeepLinkHelper", e2, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                }
            } else {
                aa.getContext().startActivity(intent);
                com.tencent.mm.ui.base.b.x(aa.getContext(), intent);
            }
            return true;
        } else if (Gf.startsWith("weixin://dl/businessTempSession/")) {
            r4 = new Intent();
            r4.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            parse = Uri.parse(str);
            if (parse == null) {
                v.e("MicroMsg.DeepLinkHelper", "tempsession uri is null");
                return false;
            }
            substring = parse.getQueryParameter("sessionFrom");
            encode = parse.getQueryParameter("showtype");
            Gf = parse.getQueryParameter("username");
            if (be.kS(Gf)) {
                Gf = parse.getQueryParameter("userName");
            }
            if (be.kS(Gf)) {
                v.e("MicroMsg.DeepLinkHelper", "tempsession user is null");
                return false;
            }
            int i2 = be.getInt(be.ma(parse.getQueryParameter("scene")), 0);
            if (i2 != 0 && i == 4) {
                v.i("MicroMsg.DeepLinkHelper", "Jsapi assign scene to " + i2);
                i = i2;
            }
            v.i("MicroMsg.DeepLinkHelper", "tempsession jump, %s, %s, %s, %s, %s.", Gf, substring, Integer.valueOf(i), str, encode);
            r4.setClassName(aa.getContext(), "com.tencent.mm.ui.chatting.ChattingUI");
            r4.putExtra("Chat_User", Gf);
            r4.putExtra("finish_direct", true);
            r4.putExtra("key_is_temp_session", true);
            r4.putExtra("key_temp_session_from", substring);
            r4.putExtra("key_temp_session_scene", i);
            r4.putExtra("key_temp_session_show_type", be.getInt(encode, 0));
            ak.yW();
            com.tencent.mm.i.a LX = c.wH().LX(Gf);
            if (LX == null || ((int) LX.chr) <= 0) {
                final Context context2 = context;
                com.tencent.mm.model.ab.a.crZ.a(Gf, SQLiteDatabase.KeyEmpty, new com.tencent.mm.model.ab.c.a() {
                    public final void p(String str, boolean z) {
                        if (z) {
                            r4.putExtra("Chat_User", str);
                            try {
                                if (context2 != null) {
                                    context2.startActivity(r4);
                                    return;
                                } else {
                                    aa.getContext().startActivity(r4);
                                    return;
                                }
                            } catch (Throwable e) {
                                v.a("MicroMsg.DeepLinkHelper", e, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                                return;
                            }
                        }
                        v.e("MicroMsg.DeepLinkHelper", "getContact fail, %s", str);
                    }
                });
            } else {
                context.startActivity(r4);
            }
            return true;
        } else if (Gf.startsWith("weixin://dl/businessGame/detail/") || Gf.startsWith("weixin://dl/businessGame/detail")) {
            parse = Uri.parse(str);
            Gf = null;
            r4 = new Intent();
            if (parse != null) {
                Gf = "com.tencent.mm.plugin.game.ui.GameDetailUI";
                r4.putExtra("game_app_id", parse.getQueryParameter("appid"));
                r4.putExtra("game_report_from_scene", 6);
            }
            if (be.kS(Gf)) {
                return false;
            }
            r4.setClassName(aa.getContext(), Gf);
            if (context != null) {
                try {
                    context.startActivity(r4);
                } catch (Throwable e22) {
                    v.a("MicroMsg.DeepLinkHelper", e22, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                }
            } else {
                aa.getContext().startActivity(r4);
                com.tencent.mm.ui.base.b.x(aa.getContext(), r4);
            }
            return true;
        } else if (Gf.startsWith("weixin://dl/businessGame/library/") || Gf.startsWith("weixin://dl/businessGame/library")) {
            Intent intent2 = new Intent();
            queryParameter = "com.tencent.mm.plugin.game.ui.GameLibraryUI";
            if (be.kS(queryParameter)) {
                return false;
            }
            intent2.putExtra("game_report_from_scene", 6);
            intent2.setClassName(aa.getContext(), queryParameter);
            if (context != null) {
                try {
                    context.startActivity(intent2);
                } catch (Throwable e222) {
                    v.a("MicroMsg.DeepLinkHelper", e222, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                }
            } else {
                aa.getContext().startActivity(intent2);
                com.tencent.mm.ui.base.b.x(aa.getContext(), intent2);
            }
            return true;
        } else if (!Gf.startsWith("weixin://dl/businessWebview/link/") && !Gf.startsWith("weixin://dl/businessWebview/link")) {
            return false;
        } else {
            parse = Uri.parse(str);
            r4 = new Intent();
            Gf = null;
            if (parse != null) {
                try {
                    Gf = URLDecoder.decode(parse.getQueryParameter(SlookSmartClipMetaTag.TAG_TYPE_URL), "utf-8");
                } catch (UnsupportedEncodingException e3) {
                    Gf = "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect";
                }
                r4.putExtra("rawUrl", Gf);
                r4.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                r4.putExtra("transaction_for_openapi_openwebview", lxz);
                Gf = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            }
            if (be.kS(Gf)) {
                return false;
            }
            r4.setClassName(aa.getContext(), Gf);
            if (context != null) {
                try {
                    context.startActivity(r4);
                } catch (Throwable e2222) {
                    v.a("MicroMsg.DeepLinkHelper", e2222, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                }
            } else {
                aa.getContext().startActivity(r4);
                com.tencent.mm.ui.base.b.x(aa.getContext(), r4);
            }
            return true;
        }
    }

    public static void cZ(Context context) {
        String string;
        if (!f.nia && u.bsY().equals("zh_CN")) {
            string = context.getString(2131236647);
        } else if (u.bsY().equals("zh_HK")) {
            string = context.getString(2131236648);
        } else if (u.bsY().equals("zh_TW")) {
            string = context.getString(2131236649);
        } else {
            string = context.getString(2131236650);
        }
        v.d("MicroMsg.DeepLinkHelper", "using faq webpage");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("show_feedback", false);
        com.tencent.mm.ay.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
    }

    private static String Gf(String str) {
        if (be.kS(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() + "://" + parse.getHost() + parse.getPath();
    }

    public static void s(final Context context, String str, String str2) {
        if (!Gd(str2)) {
            final ProgressDialog a = com.tencent.mm.ui.base.g.a(context, SQLiteDatabase.KeyEmpty, true, null);
            int i = 6;
            if (!be.kS(str)) {
                if (m.dE(str)) {
                    i = 7;
                } else if (m.eD(str)) {
                    i = 9;
                }
            }
            a(context, str2, i, new a() {
                public final void a(int i, int i2, String str, k kVar, boolean z) {
                    v.i("MicroMsg.DeepLinkHelper", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                    if (a != null && a.isShowing()) {
                        a.dismiss();
                    }
                    if (kVar != null && i != 0 && i2 != 0 && (kVar instanceof af)) {
                        bad Jy = ((af) kVar).Jy();
                        if (Jy != null && context != null) {
                            s.makeText(context, context.getString(2131231164) + " : " + be.ma(Jy.mWM), 0).show();
                        }
                    }
                }
            });
        }
    }

    public static void aJ(Context context, String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url is null. finish");
        } else if (str.startsWith("weixin://dl/login/phone_view")) {
            Uri parse = Uri.parse(str);
            v.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI cc:%s num:%s", parse.getQueryParameter("cc"), parse.getQueryParameter("num"));
            Intent intent = new Intent();
            intent.putExtra("mobile_cc", r1);
            intent.putExtra("mobile_number", r0);
            intent.putExtra("from_deep_link", true);
            intent.putExtra("mobile_input_purpose", 1);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.ay.c.b(context, "accountsync", "com.tencent.mm.ui.account.mobile.MobileInputUI", intent);
        } else if (str.startsWith("weixin://dl/login/common_view")) {
            v.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI  username:%s", Uri.parse(str).getQueryParameter("username"));
            Intent intent2 = new Intent();
            intent2.putExtra("login_username", r0);
            intent2.putExtra("from_deep_link", true);
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.ay.c.b(context, "accountsync", "com.tencent.mm.ui.account.LoginUI", intent2);
        } else {
            v.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url not Correct:%s", str);
        }
    }
}
