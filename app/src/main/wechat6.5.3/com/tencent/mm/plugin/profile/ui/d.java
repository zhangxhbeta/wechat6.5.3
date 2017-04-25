package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.j;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class d implements a, b {
    Context context;
    private f dxf;
    private u euW;
    private Map<String, Preference> euX = new HashMap();
    private HelperHeaderPreference.a hVz;

    static class AnonymousClass2 extends ac {
        final /* synthetic */ boolean euZ;
        final /* synthetic */ j eva = null;

        AnonymousClass2(boolean z, j jVar) {
            this.euZ = z;
        }

        public final void handleMessage(Message message) {
            int i;
            int xQ = k.xQ();
            if (this.euZ) {
                i = xQ & -8193;
            } else {
                i = xQ | 8192;
            }
            ak.yW();
            c.vf().set(34, Integer.valueOf(i));
            ak.yW();
            c.wG().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.euZ) {
                ah.FM().ER();
                ak.yW();
                c.vf().set(65828, "");
                ak.yW();
                c.wK().Mf("facebookapp");
                ak.yW();
                c.wJ().MO("facebookapp");
            }
            if (this.eva != null) {
                this.eva.a(null, null);
            }
        }
    }

    public d(Context context) {
        this.context = context;
        this.hVz = new q(context);
        ak.yW();
        c.wK().Mj("facebookapp");
    }

    public final boolean pz(String str) {
        v.d("MicroMsg.ContactWidgetFacebookapp", "handleEvent : key = " + str);
        if (be.ma(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_facebookapp_install")) {
            f(this.context, true);
            return true;
        } else if (str.equals("contact_info_facebookapp_uninstall")) {
            g.b(this.context, this.context.getString(2131235107), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ d hVA;

                {
                    this.hVA = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    d.f(this.hVA.context, false);
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_facebookapp_listfriend")) {
            com.tencent.mm.ay.c.b(this.context, "", "com.tencent.mm.ui.account.FacebookFriendUI", new Intent());
            return true;
        } else if (str.equals("contact_info_facebookapp_connect")) {
            com.tencent.mm.ay.c.a(this.context, ".ui.account.FacebookAuthUI", new Intent());
            return true;
        } else if (str.equals("contact_info_facebookapp_addr")) {
            com.tencent.mm.ay.c.a(this.context, ".ui.account.FacebookAuthUI", new Intent());
            return true;
        } else if (str.equals("contact_info_facebookapp_showqrcode")) {
            Intent intent = new Intent();
            intent.putExtra("show_to", 4);
            com.tencent.mm.plugin.profile.a.drp.p(intent, this.context);
            return true;
        } else {
            v.e("MicroMsg.ContactWidgetFacebookapp", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(f fVar, u uVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (uVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(m.eL(uVar.field_username));
        ak.yW();
        c.vf().a(this);
        this.euW = uVar;
        this.dxf = fVar;
        fVar.addPreferencesFromResource(2131099665);
        Preference Ow = fVar.Ow("contact_info_header_helper");
        if (Ow != null) {
            this.euX.put("contact_info_header_helper", Ow);
        }
        Ow = fVar.Ow("contact_info_facebookapp_listfriend");
        if (Ow != null) {
            this.euX.put("contact_info_facebookapp_listfriend", Ow);
        }
        Ow = fVar.Ow("contact_info_facebookapp_connect");
        if (Ow != null) {
            this.euX.put("contact_info_facebookapp_connect", Ow);
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) fVar.Ow("contact_info_facebookapp_cat");
        if (preferenceCategory != null) {
            this.euX.put("contact_info_facebookapp_cat", preferenceCategory);
        }
        Ow = fVar.Ow("contact_info_facebookapp_addr");
        if (Ow != null) {
            this.euX.put("contact_info_facebookapp_addr", Ow);
        }
        Ow = fVar.Ow("contact_info_facebookapp_showqrcode");
        if (Ow != null) {
            this.euX.put("contact_info_facebookapp_showqrcode", Ow);
        }
        preferenceCategory = (PreferenceCategory) fVar.Ow("contact_info_facebookapp_cat2");
        if (preferenceCategory != null) {
            this.euX.put("contact_info_facebookapp_cat2", preferenceCategory);
        }
        Ow = fVar.Ow("contact_info_facebookapp_install");
        if (Ow != null) {
            this.euX.put("contact_info_facebookapp_install", Ow);
        }
        Ow = fVar.Ow("contact_info_facebookapp_uninstall");
        if (Ow != null) {
            this.euX.put("contact_info_facebookapp_uninstall", Ow);
        }
        XR();
        return true;
    }

    private void XR() {
        this.dxf.removeAll();
        if (this.euX.containsKey("contact_info_header_helper")) {
            HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.euX.get("contact_info_header_helper");
            helperHeaderPreference.a(this.euW, this.hVz);
            this.dxf.a(helperHeaderPreference);
        }
        if (this.euX.containsKey("contact_info_facebookapp_cat")) {
            this.dxf.a((Preference) this.euX.get("contact_info_facebookapp_cat"));
        }
        if (((k.xQ() & 8192) == 0 ? 1 : null) != null) {
            if (k.yh()) {
                if (this.euX.containsKey("contact_info_facebookapp_addr")) {
                    this.dxf.a((Preference) this.euX.get("contact_info_facebookapp_addr"));
                    Preference preference = (Preference) this.euX.get("contact_info_facebookapp_addr");
                    ak.yW();
                    preference.setSummary((String) c.vf().get(65826, null));
                }
                if (this.euX.containsKey("contact_info_facebookapp_showqrcode")) {
                    this.dxf.a((Preference) this.euX.get("contact_info_facebookapp_showqrcode"));
                }
            } else if (this.euX.containsKey("contact_info_facebookapp_connect")) {
                this.dxf.a((Preference) this.euX.get("contact_info_facebookapp_connect"));
            }
            if (this.euX.containsKey("contact_info_facebookapp_cat2")) {
                this.dxf.a((Preference) this.euX.get("contact_info_facebookapp_cat2"));
            }
            if (this.euX.containsKey("contact_info_facebookapp_uninstall")) {
                this.dxf.a((Preference) this.euX.get("contact_info_facebookapp_uninstall"));
            }
        } else if (this.euX.containsKey("contact_info_facebookapp_install")) {
            this.dxf.a((Preference) this.euX.get("contact_info_facebookapp_install"));
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

    public final boolean XS() {
        ak.yW();
        c.vf().b(this);
        this.euX.get("contact_info_header_helper");
        com.tencent.mm.plugin.profile.a.drq.ow();
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        int n = be.n(obj, 0);
        v.d("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), jVar});
        ak.yW();
        if (jVar != c.vf() || n <= 0) {
            v.e("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), jVar});
        } else if (n == 40 || n == 34 || n == 65825) {
            XR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
