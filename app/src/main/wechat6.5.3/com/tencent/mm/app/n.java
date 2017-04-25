package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ay.c;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.c.a;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.CheckCanSubscribeBizUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.LoginHistoryUI;
import com.tencent.mm.ui.account.LoginIndepPass;
import com.tencent.mm.ui.account.LoginUI;
import com.tencent.mm.ui.account.RegByMobileVoiceVerifyUI;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.bindgooglecontact.BindGoogleContactIntroUI;
import com.tencent.mm.ui.bindgooglecontact.BindGoogleContactUI;
import com.tencent.mm.ui.bindgooglecontact.GoogleFriendUI;
import com.tencent.mm.ui.bindlinkedin.ListLinkedInFriendUI;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.BindMContactUI;
import com.tencent.mm.ui.bindqq.BindQQUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.ContactRemarkInfoModUI;
import com.tencent.mm.ui.contact.ModRemarkNameUI;
import com.tencent.mm.ui.contact.SayHiEditUI;
import com.tencent.mm.ui.contact.SelectSpecialContactUI;
import com.tencent.mm.ui.contact.SnsAddressUI;
import com.tencent.mm.ui.contact.SnsLabelContactListUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.ui.tools.CountryCodeUI;
import com.tencent.mm.ui.tools.CropImageNewUI;
import com.tencent.mm.ui.tools.MultiStageCitySelectUI;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.transmit.SelectConversationUI;

public final class n implements h {
    public final void a(Intent intent, Context context) {
        if (context != null) {
            intent.setClass(context, SayHiEditUI.class);
            context.startActivity(intent);
        }
    }

    public final void b(Intent intent, Context context) {
        if (context != null) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(context, MultiStageCitySelectUI.class);
            context.startActivity(intent);
        }
    }

    public final void c(Intent intent, Context context) {
        if (context != null) {
            if (intent == null) {
                intent = new Intent();
            }
            c.b(context, "setting", ".ui.setting.EditSignatureUI", intent);
        }
    }

    public final void d(Intent intent, Context context) {
        if (context != null) {
            if (intent == null) {
                intent = new Intent();
            }
            c.b(context, "profile", ".ui.ContactInfoUI", intent);
        }
    }

    public final void e(Intent intent, Context context) {
        if (context != null) {
            if (intent == null) {
                intent = new Intent();
            }
            String stringExtra = intent.getStringExtra("Contact_User");
            if (stringExtra != null) {
                e.a(intent, stringExtra);
            }
            intent.setClass(context, ChattingUI.class);
            context.startActivity(intent);
        }
    }

    public final void f(Intent intent, Context context) {
        if (context != null) {
            intent.setClass(context, ChattingUI.class);
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, 1);
            } else {
                context.startActivity(intent);
            }
        }
    }

    public final void g(Intent intent, Context context) {
        if (context != null) {
            intent.setClass(context, BindMContactIntroUI.class);
            MMWizardActivity.w(context, intent);
        }
    }

    public final void h(Intent intent, Context context) {
        if (context != null) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(context, BindQQUI.class);
            MMWizardActivity.w(context, intent);
        }
    }

    public final void i(Intent intent, Context context) {
        if (context != null) {
            intent.setClass(context, LauncherUI.class).addFlags(67108864);
            context.startActivity(intent);
        }
    }

    public final void j(Intent intent, Context context) {
        if (context != null) {
            if (intent == null) {
                intent = new Intent();
            }
            c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    public final void k(Intent intent, Context context) {
        l.c(context, intent.getBundleExtra("reportArgs"));
    }

    public final com.tencent.mm.ui.base.h aj(Context context) {
        return MMAppMgr.aj(context);
    }

    public final void l(Intent intent, Context context) {
        if (context != null) {
            if (intent.getIntExtra("Retr_Msg_Type", -1) < 0) {
                intent.putExtra("Retr_Msg_Type", 4);
            }
            intent.setClass(context, MsgRetransmitUI.class);
            context.startActivity(intent);
        }
    }

    public final void a(String str, Intent intent, Context context) {
        intent.putExtra("Ksnsupload_type", 0);
        intent.putExtra("sns_kemdia_path", str);
        c.b(context, "sns", ".ui.SnsUploadUI", intent);
    }

    public final void m(Intent intent, Context context) {
        if (context != null) {
            intent.putExtra("Ksnsupload_type", 1);
            c.b(context, "sns", ".ui.SnsUploadUI", intent);
        }
    }

    public final void n(Intent intent, Context context) {
        if (context != null) {
            intent.putExtra("Ksnsupload_type", 2);
            c.b(context, "sns", ".ui.SnsUploadUI", intent);
        }
    }

    public final void a(MMActivity mMActivity, String str, WXMediaMessage wXMediaMessage, String str2, String str3) {
        String string = mMActivity.getResources().getString(2131231095);
        string = new StringBuffer(string).append(wXMediaMessage.title).toString();
        com.tencent.mm.pluginsdk.ui.applet.c.c cVar = new com.tencent.mm.pluginsdk.ui.applet.c.c(mMActivity);
        cVar.ba(str2).Hw(string).tS(2131231979);
        final WXMediaMessage wXMediaMessage2 = wXMediaMessage;
        final String str4 = str;
        final String str5 = str3;
        final String str6 = str2;
        final MMActivity mMActivity2 = mMActivity;
        cVar.d(Boolean.valueOf(true)).a(new a(this) {
            final /* synthetic */ n aSl;

            public final void a(boolean z, String str, int i) {
                if (z) {
                    com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage2, str4, str5, str6, 3, null);
                    if (!be.kS(str)) {
                        ak.vy().a(new i(str6, str, m.fp(str6)), 0);
                    }
                    g.bf(mMActivity2, mMActivity2.getResources().getString(2131231155));
                    com.tencent.mm.plugin.report.service.g.iuh.Y(10910, "2");
                }
            }
        }).iji.show();
    }

    public final void a(Intent intent, MMActivity mMActivity) {
        intent.setClass(mMActivity, SelectConversationUI.class);
        mMActivity.startActivityForResult(intent, 1);
    }

    public final void a(Intent intent, int i, MMActivity mMActivity, Intent intent2) {
        if (mMActivity != null) {
            intent.setClass(mMActivity, CropImageNewUI.class);
            ak.yW();
            com.tencent.mm.ui.tools.a.a(mMActivity, intent2, intent, com.tencent.mm.model.c.wP(), i);
        }
    }

    public final boolean b(Context context, String str, Bundle bundle) {
        return j.a.lxU.a(context, str, false, bundle);
    }

    public final void o(Intent intent, Context context) {
        if (context != null) {
            c.b(context, "location", ".ui.RedirectUI", intent);
        }
    }

    public final void a(Intent intent, int i, Activity activity) {
        if (activity != null) {
            c.b(activity, "location", ".ui.RedirectUI", intent, 4097);
        }
    }

    public final void a(Activity activity, Intent intent, int i) {
        if (activity != null) {
            intent.setClass(activity, CropImageNewUI.class);
            activity.startActivityForResult(intent, i);
        }
    }

    public final void a(Activity activity, Intent intent, Intent intent2, String str, int i, com.tencent.mm.ui.tools.a.a aVar) {
        if (activity != null) {
            intent2.setClass(activity, CropImageNewUI.class);
            com.tencent.mm.ui.tools.a.b(activity, intent, intent2, str, i, aVar);
        }
    }

    public final void p(Intent intent, Context context) {
        if (context != null) {
            c.b(context, "setting", ".ui.qrcode.ShowQRCodeStep1UI", intent);
        }
    }

    public final void q(Intent intent, Context context) {
        if (context != null) {
            intent.setClass(context, ContactRemarkInfoModUI.class);
            context.startActivity(intent);
        }
    }

    public final void r(Intent intent, Context context) {
        if (context != null) {
            intent.setClass(context, ModRemarkNameUI.class);
            context.startActivity(intent);
        }
    }

    public final void a(Intent intent, Activity activity) {
        if (activity != null) {
            intent.setClass(activity, ModRemarkNameUI.class);
            activity.startActivityForResult(intent, 2);
        }
    }

    public final void b(Intent intent, Activity activity) {
        if (activity != null) {
            intent.setClass(activity, CountryCodeUI.class);
            activity.startActivityForResult(intent, 100);
        }
    }

    public final void s(Intent intent, Context context) {
        if (context != null) {
            c.b(context, "setting", ".ui.setting.SettingsLanguageUI", intent);
        }
    }

    public final void t(Intent intent, Context context) {
        if (context != null) {
            intent.setClass(context, LauncherUI.class).addFlags(67108864);
            context.startActivity(intent);
        }
    }

    public final Intent ak(Context context) {
        return new Intent(context, LauncherUI.class).addFlags(67108864);
    }

    public final void al(Context context) {
        c.b(context, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
    }

    public final void u(Intent intent, Context context) {
        Intent intent2 = new Intent();
        intent2.putExtras(intent.getExtras());
        if (intent.getFlags() != 0) {
            intent2.addFlags(intent.getFlags());
        }
        c.b(context, "subapp", ".ui.gallery.GestureGalleryUI", intent2);
    }

    public final void v(Intent intent, Context context) {
        Intent intent2 = new Intent();
        intent2.putExtras(intent.getExtras());
        if (intent.getFlags() != 0) {
            intent2.addFlags(intent.getFlags());
        }
        d.cZ(context);
    }

    public final void w(Intent intent, Context context) {
        if (context != null) {
            Intent intent2 = new Intent();
            intent2.putExtras(intent.getExtras());
            if (intent.getFlags() != 0) {
                intent2.addFlags(intent.getFlags());
            }
            c.b(context, "subapp", ".ui.pluginapp.ContactSearchUI", intent2);
        }
    }

    public final void x(Intent intent, Context context) {
        if (context != null) {
            Intent intent2 = new Intent();
            intent2.putExtras(intent.getExtras());
            if (intent.getFlags() != 0) {
                intent2.addFlags(intent.getFlags());
            }
            c.b(context, "subapp", ".ui.pluginapp.ContactSearchResultUI", intent2);
        }
    }

    public final void a(Intent intent, Activity activity, int i) {
        if (activity != null) {
            intent.setClass(activity, SnsAddressUI.class);
            activity.startActivityForResult(intent, i);
        }
    }

    public final void y(Intent intent, Context context) {
        intent.setClass(context, SnsLabelContactListUI.class);
        context.startActivity(intent);
    }

    public final void a(boolean z, boolean z2, Context context, String str, int i, int i2) {
        if (!z && !z2) {
            Intent intent = new Intent();
            intent.putExtra("VideoPlayer_File_nam", str);
            intent.putExtra("VideoRecorder_VideoLength", i);
            intent.putExtra("VideoRecorder_VideoSize", i2);
            c.b(context, "subapp", ".ui.video.VideoPlayerUI", intent);
        } else if (!com.tencent.mm.pluginsdk.m.b.a.a.c(str, context, z2)) {
            Toast.makeText(context, context.getString(2131235797), 0).show();
        }
    }

    public final void am(Context context) {
        c.b(context, "subapp", ".ui.openapi.AddAppUI", new Intent());
    }

    public final void c(Context context, Intent intent) {
        if (context != null) {
            intent.setClass(context, ShowImageUI.class);
            context.startActivity(intent);
        }
    }

    public final void d(Context context, Intent intent) {
        if (context != null) {
            c.b(context, "safedevice", ".ui.MySafeDeviceListUI", intent);
        }
    }

    public final void a(MMWizardActivity mMWizardActivity, Intent intent) {
        if (mMWizardActivity != null) {
            intent.setClass(mMWizardActivity, MobileInputUI.class);
            MMWizardActivity.w(mMWizardActivity, intent);
        }
    }

    public final void e(Context context, Intent intent) {
        if (context != null) {
            intent.setClass(context, RegByMobileVoiceVerifyUI.class);
            context.startActivity(intent);
        }
    }

    public final void b(MMWizardActivity mMWizardActivity, Intent intent) {
        if (mMWizardActivity != null) {
            intent.setClass(mMWizardActivity, BindMContactUI.class);
            MMWizardActivity.w(mMWizardActivity, intent);
        }
    }

    public final void a(Context context, Intent intent, Intent intent2) {
        if (context != null && intent != null) {
            int intExtra = intent.getIntExtra("from_source", 1);
            if (intExtra == 1) {
                intent.setClass(context, LoginUI.class);
                context.startActivity(intent);
            } else if (intExtra == 2) {
                intent.setClass(context, LoginHistoryUI.class);
                context.startActivity(intent);
            } else if (intExtra == 3) {
                intent.setClass(context, SimpleLoginUI.class);
                if (intent2 != null) {
                    MMWizardActivity.b(context, intent, intent2);
                } else {
                    MMWizardActivity.w(context, intent);
                }
            } else if (intExtra == 5) {
                intent.setClass(context, LoginIndepPass.class);
                context.startActivity(intent);
            } else if (intExtra == 6) {
                intent.setClass(context, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 5);
                context.startActivity(intent);
            }
        }
    }

    public final void f(Context context, Intent intent) {
        if (context != null) {
            c.a(context, "safedevice", ".ui.SecurityAccountIntroUI", intent);
        }
    }

    public final void g(Context context, Intent intent) {
        if (context != null) {
            intent.setClass(context, GoogleFriendUI.class);
            context.startActivity(intent);
        }
    }

    public final void h(Context context, Intent intent) {
        if (context != null) {
            intent.setClass(context, BindGoogleContactUI.class);
            context.startActivity(intent);
        }
    }

    public final void i(Context context, Intent intent) {
        if (context != null) {
            intent.setClass(context, BindGoogleContactIntroUI.class);
            context.startActivity(intent);
        }
    }

    public final void j(Context context, Intent intent) {
        if (context != null) {
            intent.setClass(context, ListLinkedInFriendUI.class);
            context.startActivity(intent);
        }
    }

    public final void k(Context context, Intent intent) {
        if (context != null) {
            intent.setClass(context, SelectSpecialContactUI.class);
            context.startActivity(intent);
        }
    }

    public final boolean a(Context context, String str, Object... objArr) {
        return j.a.lxU.b(context, str, objArr);
    }

    public final void a(Intent intent, MMActivity.a aVar, MMActivity mMActivity) {
        if (mMActivity != null) {
            intent.setClass(mMActivity, CheckCanSubscribeBizUI.class);
            mMActivity.a(aVar, intent, 8);
        }
    }

    public final void oz() {
        MMAppMgr.oz();
    }

    public final void cancelNotification(String str) {
        a.bZF;
        if (str != null) {
            int id = b.qC().getId(str);
            v.d("MicroMsg.Notification.Handle", "cancel : %s", str);
            b.qC().cancel(id);
        }
    }

    public final void p(Context context, String str) {
        j.a.lxU.a(context, str, true);
    }
}
