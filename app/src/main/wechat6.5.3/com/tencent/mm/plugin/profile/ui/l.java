package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.downloader.d;
import com.tencent.mm.pluginsdk.model.downloader.e;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import java.net.URI;
import java.net.URL;

public final class l implements a, b {
    private boolean aZw;
    Context context;
    private f dxf;
    private u euW;

    public l(Context context) {
        this.context = context;
    }

    public final boolean pz(String str) {
        if (be.ma(str).length() <= 0) {
            return false;
        }
        if ("contact_info_go_to_sync".equals(str)) {
            if (p.o(this.context, "com.tencent.qqpim")) {
                Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpim");
                launchIntentForPackage.addFlags(268435456);
                this.context.startActivity(launchIntentForPackage);
            } else {
                g.a(this.context, 2131232126, 2131231164, 2131231024, 2131231010, new OnClickListener(this) {
                    final /* synthetic */ l hWf;

                    {
                        this.hWf = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        String str = "http://tools.3g.qq.com/j/wechatandriodpim";
                        if (com.tencent.mm.sdk.platformtools.f.aPW == 1) {
                            Intent addFlags = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tencent.qqpim")).addFlags(268435456);
                            if (be.m(this.hWf.context, addFlags)) {
                                this.hWf.context.startActivity(addFlags);
                                return;
                            }
                            str = "https://play.google.com/store/apps/details?id=com.tencent.qqpim";
                        }
                        try {
                            URL url = new URL(str);
                            URL toURL = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toURL();
                            e.a aVar = new e.a();
                            aVar.GR("qqpim.apk");
                            aVar.GQ(toURL.toString());
                            aVar.hO(true);
                            aVar.tE(1);
                            d.bnK().a(aVar.lCn);
                        } catch (Exception e) {
                            v.e("MicroMsg.ContactWidgetQQSync", "dz[download qq mail error:%s]", new Object[]{e.toString()});
                        }
                    }
                }, null);
            }
            return true;
        } else if ("contact_info_remind_me_syncing".equals(str)) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("contact_info_remind_me_syncing");
            ak.yW();
            c.vf().set(65792, Boolean.valueOf(checkBoxPreference.isChecked()));
            bl.p(6, checkBoxPreference.isChecked() ? "1" : "2");
            return true;
        } else if (str.equals("contact_info_qqsync_install")) {
            g(this.context, true);
            return true;
        } else if (!str.equals("contact_info_qqsync_uninstall")) {
            return false;
        } else {
            g.b(this.context, this.context.getString(2131235107), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ l hWf;

                {
                    this.hWf = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.hWf.g(this.hWf.context, false);
                }
            }, null);
            return true;
        }
    }

    final void g(Context context, final boolean z) {
        String string = z ? context.getString(2131235103) : context.getString(2131235111);
        context.getString(2131231164);
        final com.tencent.mm.ui.base.p a = g.a(context, string, true, null);
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ l hWf;

            public final void run() {
                boolean z = z;
                bl.p(6, z ? "3" : "4");
                int xQ = k.xQ();
                int i = z ? xQ & -129 : xQ | 128;
                ak.yW();
                c.vf().set(34, Integer.valueOf(i));
                ak.yW();
                c.wG().b(new n("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    aw.fO("qqsync");
                    ak.yW();
                    c.wK().Mf("qqsync");
                }
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 hWg;

                    {
                        this.hWg = r1;
                    }

                    public final void run() {
                        a.dismiss();
                    }
                });
            }
        });
    }

    public final boolean a(f fVar, u uVar, boolean z, int i) {
        ak.yW();
        c.vf().a(this);
        this.dxf = fVar;
        this.euW = uVar;
        fVar.addPreferencesFromResource(2131099679);
        XR();
        return true;
    }

    public final boolean XS() {
        ak.yW();
        c.vf().b(this);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void a(int i, j jVar, Object obj) {
        if (this.aZw != k.yb()) {
            XR();
        }
    }

    private void XR() {
        boolean z;
        boolean z2 = true;
        this.aZw = k.yb();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.dxf.Ow("contact_info_header_helper");
        helperHeaderPreference.U(this.euW.field_username, this.euW.tU(), this.context.getString(2131232127));
        helperHeaderPreference.updateStatus(this.aZw ? 1 : 0);
        f fVar = this.dxf;
        String str = "contact_info_go_to_sync";
        if (this.aZw) {
            z = false;
        } else {
            z = true;
        }
        fVar.aO(str, z);
        fVar = this.dxf;
        str = "contact_info_remind_me_syncing_tip";
        if (this.aZw) {
            z = false;
        } else {
            z = true;
        }
        fVar.aO(str, z);
        this.dxf.aO("contact_info_qqsync_install", this.aZw);
        f fVar2 = this.dxf;
        String str2 = "contact_info_qqsync_uninstall";
        if (this.aZw) {
            z2 = false;
        }
        fVar2.aO(str2, z2);
    }
}
