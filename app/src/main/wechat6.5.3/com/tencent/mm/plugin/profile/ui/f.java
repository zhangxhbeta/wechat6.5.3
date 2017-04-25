package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.j;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class f implements com.tencent.mm.pluginsdk.c.a, b {
    private com.tencent.mm.ui.base.preference.f ezq;
    private boolean hVC;
    private u hVD;
    private Map<String, Preference> hVE = new HashMap();
    private com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a hVF;
    private boolean hVG;
    Context mContext;

    static class AnonymousClass2 extends ac {
        final /* synthetic */ boolean euZ;
        final /* synthetic */ j eva = null;

        AnonymousClass2(boolean z, j jVar) {
            this.euZ = z;
        }

        public final void handleMessage(Message message) {
            boolean z = this.euZ;
            int xQ = k.xQ();
            int i = z ? xQ & -8388609 : xQ | 8388608;
            ak.yW();
            c.vf().set(34, Integer.valueOf(i));
            ak.yW();
            c.wG().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.euZ) {
                ak.yW();
                c.vf().set(208903, "");
                ak.yW();
                c.vf().set(208901, "");
                ak.yW();
                c.vf().set(208902, "");
                ak.yW();
                c.vf().set(208905, Boolean.valueOf(true));
            }
            if (this.eva != null) {
                this.eva.a(null, null);
            }
        }
    }

    class a implements com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a {
        final /* synthetic */ f hVH;
        private Context mContext;

        public a(f fVar, Context context) {
            this.hVH = fVar;
            this.mContext = context;
        }

        public final CharSequence getHint() {
            return this.mContext.getString(2131232054);
        }

        public final void a(HelperHeaderPreference helperHeaderPreference) {
            helperHeaderPreference.eO((k.xQ() & 8388608) == 0);
        }
    }

    public f(Context context) {
        this.mContext = context;
        this.hVF = new a(this, this.mContext);
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        int n = be.n(obj, 0);
        v.d("MicroMsg.ContactWidgetGoogleContact", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), jVar});
        ak.yW();
        if (jVar != c.vf() || n <= 0) {
            v.e("MicroMsg.ContactWidgetGoogleContact", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), jVar});
        } else if (n == 40 || n == 34 || n == 7) {
            XR();
        }
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, u uVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (uVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(m.ff(uVar.field_username));
        ak.yW();
        c.vf().a(this);
        this.hVG = com.tencent.mm.modelfriend.n.aP(this.mContext);
        this.hVD = uVar;
        this.ezq = fVar;
        fVar.addPreferencesFromResource(2131099669);
        Preference Ow = fVar.Ow("contact_info_header_helper");
        if (Ow != null) {
            this.hVE.put("contact_info_header_helper", Ow);
        }
        Ow = fVar.Ow("contact_info_googlecontact_add_view");
        if (Ow != null) {
            this.hVE.put("contact_info_googlecontact_add_view", Ow);
        }
        Ow = fVar.Ow("contact_info_googlecontact_setting_view");
        if (Ow != null) {
            this.hVE.put("contact_info_googlecontact_setting_view", Ow);
        }
        Ow = fVar.Ow("contact_info_googlecontact_install");
        if (Ow != null) {
            this.hVE.put("contact_info_googlecontact_install", Ow);
        }
        Ow = fVar.Ow("contact_info_googlecontact_uninstall");
        if (Ow != null) {
            this.hVE.put("contact_info_googlecontact_uninstall", Ow);
        }
        XR();
        return true;
    }

    public final boolean XS() {
        ak.yW();
        c.vf().b(this);
        this.hVE.get("contact_info_header_helper");
        com.tencent.mm.plugin.profile.a.drq.ow();
        return true;
    }

    public final boolean pz(String str) {
        v.d("MicroMsg.ContactWidgetGoogleContact", "handleEvent : key = " + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent;
        if (str.equals("contact_info_googlecontact_add_view")) {
            CharSequence charSequence;
            v.d("MicroMsg.ContactWidgetGoogleContact", "contact_info_googlecontact_add_view");
            ak.yW();
            String str2 = (String) c.vf().get(208903, null);
            if (this.hVG) {
                ak.yW();
                charSequence = (String) c.vf().get(208901, null);
            } else {
                ak.yW();
                String str3 = (String) c.vf().get(208902, null);
            }
            if (TextUtils.isEmpty(charSequence) || TextUtils.isEmpty(str2)) {
                intent = new Intent();
                intent.putExtra("enter_scene", 2);
                com.tencent.mm.plugin.profile.a.drp.h(this.mContext, intent);
            } else {
                intent = new Intent();
                intent.putExtra("enter_scene", 2);
                com.tencent.mm.plugin.profile.a.drp.g(this.mContext, intent);
            }
            return true;
        } else if (str.equals("contact_info_googlecontact_setting_view")) {
            v.d("MicroMsg.ContactWidgetGoogleContact", "contact_info_googlecontact_setting_view");
            intent = new Intent();
            intent.putExtra("enter_scene", 2);
            com.tencent.mm.plugin.profile.a.drp.i(this.mContext, intent);
            return true;
        } else if (str.equals("contact_info_googlecontact_install")) {
            v.d("MicroMsg.ContactWidgetGoogleContact", "contact_info_googlecontact_install");
            f(this.mContext, true);
            return true;
        } else if (str.equals("contact_info_googlecontact_uninstall")) {
            v.d("MicroMsg.ContactWidgetGoogleContact", "contact_info_googlecontact_uninstall");
            g.b(this.mContext, this.mContext.getString(2131235107), "", this.mContext.getString(2131231012), this.mContext.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ f hVH;

                {
                    this.hVH = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    f.f(this.hVH.mContext, false);
                }
            }, null);
            return true;
        } else {
            v.e("MicroMsg.ContactWidgetGoogleContact", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.ContactWidgetGoogleContact", "requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            if (i == 1005) {
                this.hVG = intent.getBooleanExtra("gpservices", false);
            }
        } else if (i == 1005) {
            this.hVG = intent.getBooleanExtra("gpservices", false);
        }
    }

    private void XR() {
        this.hVC = (k.xQ() & 8388608) == 0;
        this.ezq.removeAll();
        if (this.hVE.containsKey("contact_info_header_helper")) {
            HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.hVE.get("contact_info_header_helper");
            helperHeaderPreference.a(this.hVD, this.hVF);
            this.ezq.a(helperHeaderPreference);
        }
        if (this.hVC) {
            if (this.hVE.containsKey("contact_info_googlecontact_add_view")) {
                this.ezq.a((Preference) this.hVE.get("contact_info_googlecontact_add_view"));
            }
            if (this.hVE.containsKey("contact_info_googlecontact_setting_view")) {
                this.ezq.a((Preference) this.hVE.get("contact_info_googlecontact_setting_view"));
            }
            if (this.hVE.containsKey("contact_info_googlecontact_uninstall")) {
                this.ezq.a((Preference) this.hVE.get("contact_info_googlecontact_uninstall"));
            }
        } else if (this.hVE.containsKey("contact_info_googlecontact_install")) {
            this.ezq.a((Preference) this.hVE.get("contact_info_googlecontact_install"));
        }
    }

    public static void f(Context context, boolean z) {
        String string = z ? context.getString(2131235103) : context.getString(2131235111);
        context.getString(2131231164);
        final p a = g.a(context, string, true, null);
        final AnonymousClass2 anonymousClass2 = new AnonymousClass2(z, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass2.sendEmptyMessage(0);
                }
            }
        }, 1500);
    }
}
