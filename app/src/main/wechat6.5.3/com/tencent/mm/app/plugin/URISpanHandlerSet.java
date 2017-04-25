package com.tencent.mm.app.plugin;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.ay.c;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.bb;
import com.tencent.mm.e.a.bc;
import com.tencent.mm.e.a.fz;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.n;
import com.tencent.mm.model.o;
import com.tencent.mm.model.r;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.pluginsdk.ui.applet.h;
import com.tencent.mm.pluginsdk.ui.d.b;
import com.tencent.mm.protocal.c.bad;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URLDecoder;
import java.util.LinkedList;
import java.util.List;

class URISpanHandlerSet {
    Context mContext = null;

    abstract class BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        abstract boolean a(h hVar, b bVar);

        abstract boolean a(String str, boolean z, m mVar, Bundle bundle);

        abstract h bw(String str);

        abstract int[] oR();

        public BaseUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
        }
    }

    enum PRIORITY {
        LOW,
        NORMAL,
        HIGH
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface a {
        PRIORITY oS() default PRIORITY.NORMAL;
    }

    @a
    class AAUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        AAUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().toLowerCase().startsWith("weixin://weixinnewaa/opendetail")) {
                return new h(str, 35, null);
            }
            if (str.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeurgenotify")) {
                return new h(str, 36, null);
            }
            return str.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeaa") ? new h(str, 37, null) : null;
        }

        final int[] oR() {
            return new int[]{35, 36, 37};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type == 35) {
                try {
                    String queryParameter = Uri.parse(hVar.url).getQueryParameter("billno");
                    if (be.kS(queryParameter)) {
                        v.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                        return true;
                    }
                    String string;
                    if (hVar.data instanceof Bundle) {
                        string = ((Bundle) hVar.data).getString("chatroom_name");
                    } else if (hVar.data instanceof String) {
                        string = hVar.data.toString();
                    } else {
                        v.e("MicroMsg.URISpanHandlerSet", "illegal data type, %s", hVar);
                        return true;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("bill_no", queryParameter);
                    intent.putExtra("enter_scene", 1);
                    intent.putExtra("chatroom", string);
                    c.b(this.aSs.mContext, "aa", ".ui.PaylistAAUI", intent);
                    return true;
                } catch (Exception e) {
                    v.e("MicroMsg.URISpanHandlerSet", "handle click new aa open detail link error: %s, url: %s", e.getMessage(), hVar.url);
                }
            } else {
                final String queryParameter2;
                Bundle bundle;
                final String string2;
                final long j;
                if (hVar.type == 37) {
                    try {
                        queryParameter2 = Uri.parse(hVar.url).getQueryParameter("billno");
                        if (be.kS(queryParameter2)) {
                            v.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                            return true;
                        } else if (hVar.data instanceof Bundle) {
                            bundle = (Bundle) hVar.data;
                            string2 = bundle.getString("chatroom_name");
                            if (be.kS(string2)) {
                                v.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
                                return true;
                            }
                            j = bundle.getLong("msg_id", -1);
                            if (j < 0) {
                                v.e("MicroMsg.URISpanHandlerSet", "msgId is null");
                                return true;
                            }
                            g.a(this.aSs.mContext, 2131230755, -1, 2131230759, 2131231565, (OnClickListener) new OnClickListener(this) {
                                final /* synthetic */ AAUriSpanHandler aSw;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    com.tencent.mm.sdk.c.b bbVar = new bb();
                                    bbVar.aYD.aYE = queryParameter2;
                                    bbVar.aYD.aYF = string2;
                                    bbVar.aYD.aYG = j;
                                    com.tencent.mm.sdk.c.a.nhr.z(bbVar);
                                }
                            }, null);
                        } else {
                            v.e("MicroMsg.URISpanHandlerSet", "error data!");
                            return true;
                        }
                    } catch (Exception e2) {
                        v.e("MicroMsg.URISpanHandlerSet", "handle click new aa close link error: %s, url: %s", e2.getMessage(), hVar.url);
                    }
                } else if (hVar.type == 36) {
                    try {
                        queryParameter2 = Uri.parse(hVar.url).getQueryParameter("billno");
                        if (be.kS(queryParameter2)) {
                            v.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                            return true;
                        }
                        bundle = null;
                        if (hVar.data instanceof Bundle) {
                            bundle = (Bundle) hVar.data;
                            if (bundle == null || be.kS(bundle.getString("chatroom_name"))) {
                                v.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
                                return true;
                            }
                        }
                        string2 = bundle.getString("chatroom_name");
                        j = bundle.getLong("msg_id", -1);
                        g.a(this.aSs.mContext, 2131230757, -1, 2131230758, 2131231565, (OnClickListener) new OnClickListener(this) {
                            final /* synthetic */ AAUriSpanHandler aSw;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.sdk.c.b bcVar = new bc();
                                bcVar.aYH.aYE = queryParameter2;
                                bcVar.aYH.aYF = string2;
                                bcVar.aYH.aYG = j;
                                com.tencent.mm.sdk.c.a.nhr.z(bcVar);
                            }
                        }, null);
                    } catch (Exception e22) {
                        v.e("MicroMsg.URISpanHandlerSet", "handle click new aa urge notify link error: %s, url: %s", e22.getMessage(), hVar.url);
                    }
                }
                return false;
            }
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class AlphaInstallUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        AlphaInstallUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().toLowerCase().startsWith("weixin://alphainstall?")) {
                return new h(str, 32, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{32};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 32) {
                return false;
            }
            String replace = hVar.url.replace("weixin://alphainstall?", SQLiteDatabase.KeyEmpty);
            String str = e.cnj + Uri.parse(replace).getQueryParameter("md5") + ".apk";
            if (com.tencent.mm.a.e.aR(str)) {
                be.i(str, aa.getContext());
            } else {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", replace.toString());
                c.b(this.aSs.mContext, "webview", ".ui.tools.WebViewUI", intent);
            }
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class BindLinkedinUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        BindLinkedinUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            return null;
        }

        final int[] oR() {
            return new int[0];
        }

        final boolean a(h hVar, b bVar) {
            return false;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (!str.toLowerCase().startsWith("weixin://linkedin/")) {
                return false;
            }
            v.d("MicroMsg.URISpanHandlerSet", "linkedin bind url %s", str);
            Bundle bundle2 = new Bundle();
            for (String str2 : str.substring(19).split("\\&")) {
                int indexOf = str2.indexOf(61);
                if (indexOf != -1) {
                    bundle2.putString(str2.substring(0, indexOf), URLDecoder.decode(str2.substring(indexOf + 1)));
                }
            }
            Intent intent = new Intent();
            intent.putExtra("qrcode_bundle", bundle2);
            c.b(this.aSs.mContext, "accountsync", "com.tencent.mm.ui.bindlinkedin.BindLinkedInUI", intent);
            return true;
        }
    }

    @a
    class BindMobileUrilSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        BindMobileUrilSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://setting/bindphone")) {
                return new h(str, 5, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{5};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 5) {
                return false;
            }
            if (bVar != null) {
                bVar.a(hVar);
            }
            MMWizardActivity.w(this.aSs.mContext, new Intent(this.aSs.mContext, BindMContactIntroUI.class));
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (!str.equals("weixin://setting/bindphone")) {
                return false;
            }
            Intent intent = new Intent(this.aSs.mContext, BindMContactIntroUI.class);
            if (this.aSs.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            MMWizardActivity.w(this.aSs.mContext, intent);
            return true;
        }
    }

    @a
    class CardUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        CardUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            return null;
        }

        final int[] oR() {
            return new int[0];
        }

        final boolean a(h hVar, b bVar) {
            return false;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (!str.startsWith("wxcard://cardjumptype=1")) {
                return false;
            }
            String str2 = null;
            if (mVar != null) {
                str2 = mVar.bmD().toString();
            }
            Intent intent = new Intent();
            intent.putExtra("user_name", str2);
            intent.putExtra("view_type", 1);
            c.b(this.aSs.mContext, "card", ".ui.CardViewUI", intent);
            return true;
        }
    }

    @a
    class ContactUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        ContactUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().equals("weixin://contacts/all/")) {
                return new h(str, 23, new ap("@all.android", null, this.aSs.mContext.getString(2131233188), null, true, true));
            } else if (str.trim().equals("weixin://contacts/microblog/")) {
                return new h(str, 22, r.fC(this.aSs.mContext.getString(2131233191)));
            } else {
                if (str.trim().equals("weixin://contacts/micromessenger/")) {
                    return new h(str, 2, new ap("@micromsg.qq.com", null, this.aSs.mContext.getString(2131233192), null, true, true));
                } else if (!str.trim().startsWith("weixin://contacts/")) {
                    return null;
                } else {
                    String substring = str.trim().substring(0, str.trim().length() - 1);
                    int lastIndexOf = substring.lastIndexOf("/");
                    if (lastIndexOf == -1) {
                        return null;
                    }
                    return new h(str, 21, r.H("@" + substring.substring(lastIndexOf + 1), this.aSs.mContext.getString(2131233190)));
                }
            }
        }

        final int[] oR() {
            return new int[]{23, 21, 22, 2};
        }

        final boolean a(h hVar, b bVar) {
            int i = hVar.type;
            if (i != 23 && i != 21 && i != 22 && i != 2) {
                return false;
            }
            ap apVar = (ap) hVar.l(ap.class);
            if (bVar != null) {
                bVar.a(hVar);
            }
            if (apVar == null) {
                g.A(this.aSs.mContext, this.aSs.mContext.getString(2131233504), this.aSs.mContext.getString(2131231164));
                return false;
            }
            if (apVar.getType().equals("@t.qq.com")) {
                ak.yW();
                if ((com.tencent.mm.model.c.wN().Nr("@t.qq.com") != null ? 1 : null) == null) {
                    g.A(this.aSs.mContext, this.aSs.mContext.getString(2131233504), this.aSs.mContext.getString(2131231164));
                }
            }
            if (apVar.getType().equals("@domain.android")) {
                Object obj;
                ak.yW();
                ay wN = com.tencent.mm.model.c.wN();
                List linkedList = new LinkedList();
                Cursor query = wN.cie.query("role_info", null, new StringBuilder("int_reserved1=1").toString(), null, null, null, null);
                if (query.getCount() > 0) {
                    query.moveToFirst();
                    while (!query.isAfterLast()) {
                        ax axVar = new ax();
                        axVar.b(query);
                        linkedList.add(axVar);
                        query.moveToNext();
                    }
                }
                query.close();
                if (linkedList.size() > 0) {
                    for (int i2 = 0; i2 < linkedList.size(); i2++) {
                        if (((ax) linkedList.get(i2)).aeX()) {
                            obj = 1;
                            break;
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    g.A(this.aSs.mContext, this.aSs.mContext.getString(2131233504), this.aSs.mContext.getString(2131231164));
                }
            }
            Intent intent = new Intent();
            intent.setClass(this.aSs.mContext, SelectContactUI.class);
            intent.putExtra("Contact_GroupFilter_Type", apVar.getType()).putExtra("Contact_GroupFilter_Str", apVar.bvX()).putExtra("Contact_GroupFilter_DisplayName", apVar.tT());
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            this.aSs.mContext.startActivity(intent);
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (!str.equals("weixin://contacts/microblog/") && !str.equals("weixin://contacts/micromessenger/") && !str.equals("weixin://contacts/all/")) {
                return false;
            }
            ap fC = r.fC(this.aSs.mContext.getString(2131233192));
            if (str.equals("weixin://contacts/microblog/")) {
                fC = r.fC(this.aSs.mContext.getString(2131233191));
            }
            if (str.equals("weixin://contacts/micromessenger/")) {
                fC = r.fC(this.aSs.mContext.getString(2131233192));
            }
            if (str.equals("weixin://contacts/all/")) {
                fC = r.fC(this.aSs.mContext.getString(2131233188));
            }
            Intent intent = new Intent();
            intent.setClass(this.aSs.mContext, SelectContactUI.class);
            intent.putExtra("Contact_GroupFilter_Type", fC.getType()).putExtra("Contact_GroupFilter_Str", fC.bvX()).putExtra("Contact_GroupFilter_DisplayName", fC.tT());
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            return true;
        }
    }

    @a(oS = PRIORITY.LOW)
    class DeeplinkUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        DeeplinkUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            v.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler getHrefFromUrl %s", str);
            if (str.trim().toLowerCase().startsWith("weixin://")) {
                return new h(str, 30, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{30};
        }

        final boolean a(h hVar, b bVar) {
            String str;
            v.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler handleSpanClick %d, %s", Integer.valueOf(hVar.type), hVar.url);
            if (bVar != null) {
                str = (String) bVar.a(hVar);
            } else {
                str = null;
            }
            if (hVar.type != 30) {
                return false;
            }
            final String ma = be.ma(hVar.url);
            if (ma.startsWith("weixin://shieldBrandMsg/") || ma.startsWith("weixin://receiveBrandMsg/")) {
                if (be.kS(str)) {
                    v.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null");
                    return true;
                }
                final BizInfo hw = com.tencent.mm.modelbiz.e.hw(str);
                if (hw == null) {
                    v.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler BizInfo is null");
                    return true;
                } else if (ma.startsWith("weixin://shieldBrandMsg/")) {
                    g.a(this.aSs.mContext, 2131235648, 2131231164, 2131235647, 2131231565, new OnClickListener(this) {
                        final /* synthetic */ DeeplinkUriSpanHandler aSA;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            int i2 = hw.field_brandFlag;
                            hw.field_brandFlag |= 1;
                            v.i("MicroMsg.URISpanHandlerSet", "shield biz msg %s, %s, old = %d, new = %d", ma, str, Integer.valueOf(i2), Integer.valueOf(hw.field_brandFlag));
                            com.tencent.mm.modelbiz.e.f(hw);
                        }
                    }, null);
                } else if (ma.startsWith("weixin://receiveBrandMsg/")) {
                    g.a(this.aSs.mContext, 2131235646, 2131231164, 2131235645, 2131231565, new OnClickListener(this) {
                        final /* synthetic */ DeeplinkUriSpanHandler aSA;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            int i2 = hw.field_brandFlag;
                            hw.field_brandFlag &= -2;
                            v.i("MicroMsg.URISpanHandlerSet", "receive biz msg %s, %s, old = %d, new = %d", ma, str, Integer.valueOf(i2), Integer.valueOf(hw.field_brandFlag));
                            com.tencent.mm.modelbiz.e.f(hw);
                        }
                    }, null);
                }
            } else if (d.i(Uri.parse(ma))) {
                d.s(this.aSs.mContext, str, ma);
            } else if (!ma.startsWith("weixin://receiveWeAppKFMsg")) {
                d.a(this.aSs.mContext, ma, str, 1, ma, null);
            } else if (be.kS(str)) {
                v.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null, handle the BUILTIN_RECEIVE_WEAPP_KFMSG ,  the herfUrl is %s", ma);
                return true;
            } else {
                g.a(this.aSs.mContext, 2131230982, 2131231164, 2131230981, 2131231565, new OnClickListener(this) {
                    final /* synthetic */ DeeplinkUriSpanHandler aSA;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        v.i("MicroMsg.URISpanHandlerSet", "AppBrandHelper switchTo to receive msg for username %s", str);
                        com.tencent.mm.ui.appbrand.a.i(this.aSA.aSs.mContext, str, true);
                    }
                }, null);
            }
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (be.kS(str) || bundle == null) {
                boolean z2;
                String str2 = "MicroMsg.URISpanHandlerSet";
                String str3 = "url is null ? %b, paramsBundle is null ? %b";
                Object[] objArr = new Object[2];
                if (str == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                if (bundle == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[1] = Boolean.valueOf(z2);
                v.e(str2, str3, objArr);
                return false;
            } else if (!d.i(Uri.parse(str))) {
                return false;
            } else {
                int i = bundle.getInt("key_scene", -1);
                v.d("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler jump, %d, %s", Integer.valueOf(i), str);
                if (i == -1) {
                    i = 5;
                }
                final p a = g.a(this.aSs.mContext, SQLiteDatabase.KeyEmpty, true, null);
                d.a(this.aSs.mContext, str, i, new com.tencent.mm.pluginsdk.d.a(this) {
                    final /* synthetic */ DeeplinkUriSpanHandler aSA;

                    public final void a(int i, int i2, String str, k kVar, boolean z) {
                        if (a != null && a.isShowing()) {
                            a.dismiss();
                        }
                        if (kVar != null && i != 0 && i2 != 0 && (kVar instanceof af)) {
                            bad Jy = ((af) kVar).Jy();
                            if (Jy != null && this.aSA.aSs.mContext != null) {
                                s.makeText(this.aSA.aSs.mContext, this.aSA.aSs.mContext.getString(2131231164) + " : " + be.ma(Jy.mWM), 0).show();
                            }
                        }
                    }
                });
                return true;
            }
        }
    }

    @a
    class EmotionStoreUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        EmotionStoreUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (!str.trim().startsWith("weixin://emoticonstore/")) {
                return null;
            }
            int lastIndexOf = str.lastIndexOf("/");
            Object obj = SQLiteDatabase.KeyEmpty;
            if (lastIndexOf != -1) {
                obj = str.substring(lastIndexOf + 1);
            }
            return new h(str, 29, obj);
        }

        final int[] oR() {
            return new int[]{29};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 29) {
                return false;
            }
            if (bVar != null) {
                bVar.a(hVar);
            }
            Intent intent = new Intent();
            intent.putExtra("download_entrance_scene", 21);
            intent.putExtra("extra_id", (String) hVar.l(String.class));
            intent.putExtra("preceding_scence", 3);
            c.b(this.aSs.mContext, "emoji", ".ui.EmojiStoreDetailUI", intent);
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class EnterRoomUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        EnterRoomUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            return null;
        }

        final int[] oR() {
            return new int[0];
        }

        final boolean a(h hVar, b bVar) {
            return false;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (str.startsWith("weixin://jump/mainframe/")) {
                int lastIndexOf = str.trim().lastIndexOf("/");
                if (lastIndexOf >= 0 && lastIndexOf < str.trim().length() - 1) {
                    String substring = str.trim().substring(lastIndexOf + 1);
                    if (com.tencent.mm.model.m.dE(substring)) {
                        ak.yW();
                        com.tencent.mm.i.a LX = com.tencent.mm.model.c.wH().LX(substring);
                        if (LX == null || ((int) LX.chr) == 0) {
                            u uVar = new u();
                            uVar.setUsername(substring);
                            ak.yW();
                            com.tencent.mm.model.c.wH().N(uVar);
                        }
                    }
                    Intent putExtra = new Intent(this.aSs.mContext, ChattingUI.class).putExtra("Chat_User", substring).putExtra("Chat_Mode", 1);
                    if (this.aSs.mContext instanceof Service) {
                        putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    }
                    this.aSs.mContext.startActivity(putExtra);
                    return true;
                }
            }
            return false;
        }
    }

    @a
    class ExposeUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        ExposeUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().toLowerCase().equals("weixin://expose/")) {
                return new h(str, 31, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{31};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 31) {
                return false;
            }
            int i;
            Intent intent = new Intent();
            String str = (String) bVar.a(hVar);
            intent.putExtra("k_username", str);
            if (be.kS(str) || !str.endsWith("@chatroom")) {
                i = 39;
            } else {
                i = 36;
            }
            intent.putExtra("showShare", false);
            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
            c.b(this.aSs.mContext, "webview", ".ui.tools.WebViewUI", intent);
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class FeedbackUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        FeedbackUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://feedback/next/")) {
                return new h(str, 34, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{34};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 34) {
                return false;
            }
            v.d("MicroMsg.URISpanHandlerSet", "FeedbackUriSpanHandler, url:%s, content:%s", hVar.url, hVar.url.trim().replace("weixin://feedback/next/", SQLiteDatabase.KeyEmpty));
            ak.vy().a(new l(com.tencent.mm.compatible.d.p.rY(), r2, 8), 0);
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class FlowStatUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        FlowStatUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://flowstat")) {
                return new h(str, 16, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{16};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 16) {
                return false;
            }
            if (bVar != null) {
                bVar.a(hVar);
            }
            LauncherUI bzB = LauncherUI.bzB();
            if (bzB != null) {
                bzB.NX("tab_settings");
            }
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (!str.equals("weixin://flowstat")) {
                return false;
            }
            LauncherUI bzB = LauncherUI.bzB();
            if (bzB != null) {
                bzB.NX("tab_settings");
            }
            return true;
        }
    }

    @a
    class FriendMobileUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        FriendMobileUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://findfriend/mobile")) {
                return new h(str, 20, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{20};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 20) {
                return false;
            }
            if (bVar != null) {
                bVar.a(hVar);
            }
            this.aSs.mContext.startActivity(new Intent(this.aSs.mContext, MobileFriendUI.class));
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (!str.equals("weixin://findfriend/mobile")) {
                return false;
            }
            Intent intent = new Intent(this.aSs.mContext, MobileFriendUI.class);
            if (this.aSs.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            this.aSs.mContext.startActivity(intent);
            return true;
        }
    }

    @a
    class FriendSearchUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        FriendSearchUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://findfriend/search")) {
                return new h(str, 17, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{17};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 17) {
                return false;
            }
            if (bVar != null) {
                bVar.a(hVar);
            }
            c.w(this.aSs.mContext, "subapp", ".ui.pluginapp.ContactSearchUI");
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (!str.equals("weixin://findfriend/search")) {
                return false;
            }
            Intent intent = new Intent();
            if (this.aSs.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            c.b(this.aSs.mContext, "subapp", ".ui.pluginapp.ContactSearchUI", intent);
            return true;
        }
    }

    @a
    class FriendShareUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        FriendShareUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://findfriend/share")) {
                return new h(str, 18, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{18};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 18) {
                return false;
            }
            if (bVar != null) {
                bVar.a(hVar);
            }
            c.w(this.aSs.mContext, "setting", ".ui.qrcode.ShareMicroMsgChoiceUI");
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (!str.equals("weixin://findfriend/share")) {
                return false;
            }
            Intent intent = new Intent();
            if (this.aSs.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            c.b(this.aSs.mContext, "setting", ".ui.qrcode.ShareMicroMsgChoiceUI", intent);
            return true;
        }
    }

    @a
    class HttpUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        HttpUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().toLowerCase().startsWith("http")) {
                return new h(str, 1, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{1};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 1) {
                return false;
            }
            String str;
            hVar.l(ap.class);
            ap H = r.H("@" + hVar.url, this.aSs.mContext.getString(2131233190));
            if (bVar != null) {
                str = (String) bVar.a(hVar);
            } else {
                str = null;
            }
            if (H == null || !H.aZw) {
                String str2 = hVar.url;
                if (!str2.toLowerCase().startsWith("http")) {
                    str2 = "http://" + str2;
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                if (hVar.data != null && (hVar.data instanceof Integer)) {
                    intent.putExtra("geta8key_scene", ((Integer) hVar.data).intValue());
                }
                str2 = hVar.jGE;
                if (!be.kS(str2)) {
                    o.b fy = o.yx().fy(str2);
                    if (fy != null) {
                        String string = fy.getString("prePublishId", null);
                        String string2 = fy.getString("preUsername", null);
                        String string3 = fy.getString("preChatName", null);
                        intent.putExtra("reportSessionId", str2);
                        intent.putExtra("KPublisherId", string);
                        intent.putExtra("geta8key_username", string3);
                        intent.putExtra("pre_username", string2);
                        intent.putExtra("prePublishId", string);
                        intent.putExtra("preUsername", string2);
                        intent.putExtra("preChatName", string3);
                        intent.putExtra("preChatTYPE", n.F(string2, string3));
                    }
                }
                intent.putExtra("geta8key_username", be.kS(str) ? null : str);
                c.b(this.aSs.mContext, "webview", ".ui.tools.WebViewUI", intent);
            }
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class JumpActivityUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        JumpActivityUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            return null;
        }

        final int[] oR() {
            return new int[0];
        }

        final boolean a(h hVar, b bVar) {
            return false;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (!str.toLowerCase().startsWith("weixin://jump/")) {
                return false;
            }
            String[] split = str.split("/");
            String str2 = split[split.length - 1];
            Intent intent;
            if ("mainframe".equalsIgnoreCase(str2)) {
                intent = new Intent(this.aSs.mContext, LauncherUI.class);
                if (this.aSs.mContext instanceof Service) {
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                intent.addFlags(67108864);
                this.aSs.mContext.startActivity(intent);
            } else if ("shake".equalsIgnoreCase(str2)) {
                com.tencent.mm.plugin.report.service.g.iuh.Y(10221, "1");
                intent = new Intent();
                intent.addFlags(67108864);
                if (this.aSs.mContext instanceof Service) {
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                c.b(this.aSs.mContext, "shake", ".ui.ShakeReportUI", intent);
                if (this.aSs.mContext != null && (this.aSs.mContext instanceof Activity)) {
                    ((Activity) this.aSs.mContext).finish();
                }
            } else if ("scanqrcode".equalsIgnoreCase(str2)) {
                intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
                intent.setFlags(65536);
                intent.addFlags(67108864);
                if (this.aSs.mContext instanceof Service) {
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                c.b(this.aSs.mContext, "scanner", ".ui.BaseScanUI", intent);
            }
            return true;
        }
    }

    @a
    class LuckyMoneyUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        LuckyMoneyUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().toLowerCase().startsWith("weixin://weixinhongbao/")) {
                return new h(str, 33, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{33};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 33) {
                return false;
            }
            Intent intent = new Intent();
            intent.putExtra("key_native_url", hVar.url);
            c.b(this.aSs.mContext, "luckymoney", ".ui.LuckyMoneyDetailUI", intent);
            com.tencent.mm.plugin.report.service.g.iuh.h(12097, Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
            com.tencent.mm.plugin.report.service.g.iuh.h(11850, Integer.valueOf(4), Integer.valueOf(1));
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class PayTransferUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        PayTransferUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            return null;
        }

        final int[] oR() {
            return new int[0];
        }

        final boolean a(h hVar, b bVar) {
            return false;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            String str2 = null;
            if (!str.startsWith("wxpay://")) {
                return false;
            }
            String obj;
            com.tencent.mm.plugin.wallet.a aVar;
            if (mVar != null) {
                obj = mVar.bmD().toString();
                Object bmE = mVar.bmE();
                if (bmE instanceof com.tencent.mm.plugin.wallet.a) {
                    aVar = (com.tencent.mm.plugin.wallet.a) bmE;
                    str2 = obj;
                } else {
                    aVar = null;
                    str2 = obj;
                }
            } else {
                aVar = null;
            }
            if (be.kS(str2)) {
                v.e("MicroMsg.URISpanHandlerSet", "SERVICE_JUMP_TO_PAY fail, null username");
                return false;
            }
            obj = str.substring(8);
            String str3 = SQLiteDatabase.KeyEmpty;
            if (obj.indexOf("&") > 0) {
                obj = obj.split("&")[0];
            }
            int indexOf = obj.indexOf("=");
            if (indexOf >= 0) {
                obj = obj.substring(indexOf + 1);
            } else {
                obj = str3;
            }
            if (be.getInt(obj, 0) == 1) {
                if (com.tencent.mm.model.k.xU() || com.tencent.mm.model.k.xV()) {
                    com.tencent.mm.pluginsdk.wallet.e.a(this.aSs.mContext, 5, str2, 11, aVar);
                } else {
                    com.tencent.mm.pluginsdk.wallet.e.a(this.aSs.mContext, 2, str2, 11, aVar);
                }
                return true;
            }
            Toast.makeText(this.aSs.mContext, this.aSs.mContext.getString(2131234927), 0).show();
            return false;
        }
    }

    @a
    class PayUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        PayUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            return null;
        }

        final int[] oR() {
            return new int[]{28};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 28) {
                return false;
            }
            if (bVar != null) {
                bVar.a(hVar);
            }
            com.tencent.mm.sdk.c.b fzVar = new fz();
            fzVar.bfx.actionCode = 11;
            fzVar.bfx.bfz = hVar.url;
            fzVar.bfx.context = this.aSs.mContext;
            com.tencent.mm.sdk.c.a.nhr.a(fzVar, Looper.myLooper());
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class PhoneEmailUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        PhoneEmailUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            return null;
        }

        final int[] oR() {
            return new int[]{25, 24};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type == 25) {
                String str = hVar.username;
                Bundle bundle = new Bundle();
                if (!(str == null || str.equals(com.tencent.mm.model.k.xF()))) {
                    bundle.putString("Contact_User", str);
                    com.tencent.mm.modelfriend.b iA = ah.FL().iA(str);
                    if (iA == null || be.kS(iA.EB())) {
                        str = null;
                    } else {
                        str = be.ma(iA.EJ()).replace(" ", SQLiteDatabase.KeyEmpty);
                    }
                    bundle.putString("Contact_Mobile_MD5", str);
                }
                bundle.putInt("fromScene", 1);
                com.tencent.mm.pluginsdk.ui.d.g.a(this.aSs.mContext, hVar.url, null, bundle);
                return true;
            }
            if (hVar.type == 24) {
                com.tencent.mm.pluginsdk.ui.d.g.b(this.aSs.mContext, hVar.url, null);
            }
            return false;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class PluginUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        PluginUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://plugin")) {
                return new h(str, 26, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{26};
        }

        final boolean a(h hVar, b bVar) {
            return false;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (!str.equals("weixin://plugin")) {
                return false;
            }
            Intent intent = new Intent();
            if (this.aSs.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            c.b(this.aSs.mContext, "setting", ".ui.setting.SettingsPluginsUI", intent);
            return true;
        }
    }

    @a
    class ProfileUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        ProfileUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://contacts/profile/")) {
                return new h(str, 3, str.trim().replace("weixin://contacts/profile/", SQLiteDatabase.KeyEmpty).replace("/", SQLiteDatabase.KeyEmpty));
            }
            return null;
        }

        final int[] oR() {
            return new int[]{3};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 3) {
                return false;
            }
            if (bVar != null) {
                bVar.a(hVar);
            }
            String str = (String) hVar.l(String.class);
            Intent intent = new Intent();
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("Contact_User", str);
            ak.yW();
            ab LX = com.tencent.mm.model.c.wH().LX(str);
            if (LX != null && ((int) LX.chr) > 0 && com.tencent.mm.i.a.ei(LX.field_type)) {
                com.tencent.mm.ui.contact.e.a(intent, str);
            }
            if (be.ma(str).length() > 0) {
                c.b(this.aSs.mContext, "profile", ".ui.ContactInfoUI", intent);
            }
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (!str.startsWith("weixin://contacts/profile/")) {
                return false;
            }
            String replace = str.trim().replace("weixin://contacts/profile/", SQLiteDatabase.KeyEmpty).replace("/", SQLiteDatabase.KeyEmpty);
            if (be.kS(replace)) {
                v.e("MicroMsg.URISpanHandlerSet", "jumpToActivity fail, user is null");
                return true;
            }
            Intent intent = new Intent();
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("Contact_User", replace);
            ak.yW();
            ab LX = com.tencent.mm.model.c.wH().LX(replace);
            if (LX != null && ((int) LX.chr) > 0 && com.tencent.mm.i.a.ei(LX.field_type)) {
                com.tencent.mm.ui.contact.e.a(intent, replace);
            }
            c.b(this.aSs.mContext, "profile", ".ui.ContactInfoUI", intent);
            return true;
        }
    }

    @a
    class ScanQrCodeUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        ScanQrCodeUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            return null;
        }

        final int[] oR() {
            return new int[0];
        }

        final boolean a(h hVar, b bVar) {
            return false;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            boolean z2 = false;
            if (!str.equals("weixin://scanqrcode/")) {
                return false;
            }
            if (z) {
                Intent intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                if (bundle != null && bundle.getInt("fromScene") == 100) {
                    z2 = true;
                }
                if (!z2) {
                    intent.addFlags(67108864);
                }
                if (this.aSs.mContext instanceof Service) {
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                if (z2) {
                    c.b(this.aSs.mContext, "scanner", ".ui.SingleTopScanUI", intent);
                    return true;
                }
                c.b(this.aSs.mContext, "scanner", ".ui.BaseScanUI", intent);
                return true;
            }
            v.e("MicroMsg.URISpanHandlerSet", "jumpToActivity, scan qrcode permission fail");
            return true;
        }
    }

    @a
    class SetSafeDeviceUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        SetSafeDeviceUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            return null;
        }

        final int[] oR() {
            return new int[0];
        }

        final boolean a(h hVar, b bVar) {
            return false;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (!str.equals("weixin://setting/account/safedevice")) {
                return false;
            }
            ak.yW();
            String str2 = (String) com.tencent.mm.model.c.vf().get(6, SQLiteDatabase.KeyEmpty);
            ak.yW();
            String str3 = (String) com.tencent.mm.model.c.vf().get(4097, SQLiteDatabase.KeyEmpty);
            Intent intent;
            if (!be.kS(str2)) {
                intent = new Intent();
                if (this.aSs.mContext instanceof Service) {
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                c.w(this.aSs.mContext, "safedevice", ".ui.MySafeDeviceListUI");
            } else if (be.kS(str3)) {
                intent = new Intent();
                if (this.aSs.mContext instanceof Service) {
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                c.a(this.aSs.mContext, "safedevice", ".ui.BindSafeDeviceUI", intent);
            } else {
                intent = new Intent(this.aSs.mContext, BindMContactIntroUI.class);
                intent.putExtra("is_bind_for_safe_device", true);
                if (this.aSs.mContext instanceof Service) {
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                MMWizardActivity.w(this.aSs.mContext, intent);
            }
            return true;
        }
    }

    @a
    class SettingBindEmailUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        SettingBindEmailUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://setting/bindemail")) {
                return new h(str, 7, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{7};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 7) {
                return false;
            }
            if (bVar != null) {
                bVar.a(hVar);
            }
            LauncherUI bzB = LauncherUI.bzB();
            if (bzB != null) {
                bzB.NX("tab_settings");
            }
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class SettingBlacklistUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        SettingBlacklistUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://setting/blacklist")) {
                return new h(str, 14, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{14};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 14) {
                return false;
            }
            if (bVar != null) {
                bVar.a(hVar);
            }
            ap fB = r.fB(this.aSs.mContext.getString(2131233189));
            Intent intent = new Intent();
            intent.setClass(this.aSs.mContext, SelectContactUI.class);
            intent.putExtra("Contact_GroupFilter_Type", fB.getType());
            intent.putExtra("Contact_GroupFilter_DisplayName", fB.tT());
            intent.addFlags(67108864);
            LauncherUI bzB = LauncherUI.bzB();
            if (bzB != null) {
                bzB.NX("tab_settings");
            }
            this.aSs.mContext.startActivity(intent);
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (!str.equals("weixin://setting/blacklist")) {
                return false;
            }
            ap fB = r.fB(this.aSs.mContext.getString(2131233189));
            Intent intent = new Intent();
            intent.setClass(this.aSs.mContext, AddressUI.class);
            intent.putExtra("Contact_GroupFilter_Type", fB.getType());
            intent.putExtra("Contact_GroupFilter_DisplayName", fB.tT());
            intent.addFlags(67108864);
            if (this.aSs.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            LauncherUI bzB = LauncherUI.bzB();
            if (bzB != null) {
                bzB.NX("tab_settings");
            }
            this.aSs.mContext.startActivity(intent);
            return true;
        }
    }

    @a
    class SettingHeadImgUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        SettingHeadImgUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://setting/setheadimage")) {
                return new h(str, 6, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{6};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 6) {
                return false;
            }
            if (bVar != null) {
                bVar.a(hVar);
            }
            LauncherUI bzB = LauncherUI.bzB();
            if (bzB != null) {
                bzB.NX("tab_settings");
            }
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (!str.equals("weixin://setting/setheadimage")) {
                return false;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", com.tencent.mm.model.k.xF());
            intent.putExtra("Contact_Nick", com.tencent.mm.model.k.xH());
            intent.putExtra("User_Avatar", true);
            if (this.aSs.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            c.b(this.aSs.mContext, "profile", ".ui.ContactInfoUI", intent);
            return true;
        }
    }

    @a
    class SettingNotifyUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        SettingNotifyUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://setting/notify")) {
                return new h(str, 9, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{9};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 9) {
                return false;
            }
            if (bVar != null) {
                bVar.a(hVar);
            }
            LauncherUI bzB = LauncherUI.bzB();
            if (bzB != null) {
                bzB.NX("tab_settings");
            }
            c.w(this.aSs.mContext, "setting", ".ui.setting.SettingsNotificationUI");
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (!str.equals("weixin://setting/notify")) {
                return false;
            }
            LauncherUI bzB = LauncherUI.bzB();
            if (bzB != null) {
                bzB.NX("tab_settings");
            }
            Intent intent = new Intent();
            intent.addFlags(67108864);
            if (this.aSs.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            c.b(this.aSs.mContext, "setting", ".ui.setting.SettingsNotificationUI", intent);
            return true;
        }
    }

    @a
    class SettingPluginLomoUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        SettingPluginLomoUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://setting/plugin/lomo")) {
                return new h(str, 12, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{12};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 12) {
                return false;
            }
            if (bVar != null) {
                bVar.a(hVar);
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", "weibo");
            c.b(this.aSs.mContext, "profile", ".ui.ContactInfoUI", intent);
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (!str.equals("weixin://setting/plugin/lomo")) {
                return false;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", "weibo");
            if (this.aSs.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            c.b(this.aSs.mContext, "profile", ".ui.ContactInfoUI", intent);
            return true;
        }
    }

    @a
    class SettingPluginQQMailUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        SettingPluginQQMailUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://setting/plugin/qqmail")) {
                return new h(str, 10, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{10};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 10) {
                return false;
            }
            if (bVar != null) {
                bVar.a(hVar);
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", "qqmail");
            c.b(this.aSs.mContext, "profile", ".ui.ContactInfoUI", intent);
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (!str.equals("weixin://setting/plugin/qqmail")) {
                return false;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", "qqmail");
            if (this.aSs.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            c.b(this.aSs.mContext, "profile", ".ui.ContactInfoUI", intent);
            return true;
        }
    }

    @a
    class SettingPluginQQMsgUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        SettingPluginQQMsgUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://setting/plugin/qqmsg")) {
                return new h(str, 13, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{13};
        }

        final boolean a(h hVar, b bVar) {
            return false;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class SettingPluginSxMsgUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        SettingPluginSxMsgUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://setting/plugin/sxmsg")) {
                return new h(str, 11, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{11};
        }

        final boolean a(h hVar, b bVar) {
            return false;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class SettingPrivacyUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        SettingPrivacyUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://setting/privacy")) {
                return new h(str, 15, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{15};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 15) {
                return false;
            }
            if (bVar != null) {
                bVar.a(hVar);
            }
            LauncherUI bzB = LauncherUI.bzB();
            if (bzB != null) {
                bzB.NX("tab_settings");
            }
            c.w(this.aSs.mContext, "setting", ".ui.setting.SettingsPrivacyUI");
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            if (!str.equals("weixin://setting/privacy")) {
                return false;
            }
            LauncherUI bzB = LauncherUI.bzB();
            if (bzB != null) {
                bzB.NX("tab_settings");
            }
            Intent intent = new Intent();
            if (this.aSs.mContext instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            c.b(this.aSs.mContext, "setting", ".ui.setting.SettingsPrivacyUI", intent);
            return true;
        }
    }

    @a
    class VerifyContactUriSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        VerifyContactUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://findfriend/verifycontact")) {
                return new h(str, 4, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{4};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type != 4) {
                return false;
            }
            if (bVar != null) {
                bVar.a(hVar);
            }
            return true;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class VoipCallAgainUrilSpanHandler extends BaseUriSpanHandler {
        final /* synthetic */ URISpanHandlerSet aSs;

        VoipCallAgainUrilSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
            this.aSs = uRISpanHandlerSet;
            super(uRISpanHandlerSet);
        }

        final h bw(String str) {
            if (str.trim().startsWith("weixin://voip/callagain/")) {
                return new h(str, 38, null);
            }
            return null;
        }

        final int[] oR() {
            return new int[]{38};
        }

        final boolean a(h hVar, b bVar) {
            if (hVar.type == 38) {
                Uri parse = Uri.parse(hVar.url);
                String queryParameter = parse.getQueryParameter("username");
                String queryParameter2 = parse.getQueryParameter("isvideocall");
                com.tencent.mm.sdk.c.b qiVar = new qi();
                qiVar.brC.bdn = 5;
                qiVar.brC.bdo = queryParameter;
                qiVar.brC.context = this.aSs.mContext;
                if (!(queryParameter == null || queryParameter.equals(SQLiteDatabase.KeyEmpty))) {
                    if (queryParameter2 == null || !queryParameter2.equals("true")) {
                        qiVar.brC.brx = 4;
                    } else {
                        qiVar.brC.brx = 2;
                    }
                    com.tencent.mm.sdk.c.a.nhr.z(qiVar);
                    return true;
                }
            }
            return false;
        }

        final boolean a(String str, boolean z, m mVar, Bundle bundle) {
            return false;
        }
    }

    public URISpanHandlerSet(Context context) {
        this.mContext = context == null ? aa.getContext() : this.mContext;
    }
}
