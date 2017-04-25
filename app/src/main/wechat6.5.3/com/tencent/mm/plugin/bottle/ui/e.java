package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.bottle.a.i;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.j;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class e implements a, b {
    private boolean aZw;
    final Context context;
    private f dxf;
    private u euW;
    private final Map<String, Preference> euX = new HashMap();
    private int status;

    static class AnonymousClass3 extends ac {
        final /* synthetic */ boolean euZ;
        final /* synthetic */ j eva = null;

        AnonymousClass3(boolean z, j jVar) {
            this.euZ = z;
        }

        public final void handleMessage(Message message) {
            int i;
            int i2;
            boolean z = this.euZ;
            int xJ = k.xJ();
            int xQ = k.xQ();
            if (z) {
                i = xJ | Downloads.RECV_BUFFER_SIZE;
                i2 = xQ & -65;
                ak.yW();
                c.wG().b(new g(11, 1));
            } else {
                i = xJ & -4097;
                i2 = xQ | 64;
                ak.yW();
                c.wG().b(new g(11, 2));
            }
            ak.yW();
            c.vf().set(7, Integer.valueOf(i));
            ak.yW();
            c.vf().set(34, Integer.valueOf(i2));
            ak.yW();
            c.wG().b(new n("", "", "", "", "", "", "", "", i2, "", ""));
            if (!this.euZ) {
                i.XH();
            }
            if (this.eva != null) {
                this.eva.a(null, null);
            }
        }
    }

    public e(Context context) {
        this.context = context;
    }

    public final boolean pz(String str) {
        v.d("MicroMsg.ContactWidgetFloatBottle", "handleEvent : key = " + str);
        if (be.ma(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_goto_floatbottle")) {
            bf zO = bf.zO();
            if (be.a(Integer.valueOf(zO.bBZ), 0) <= 0 || be.kS(zO.getProvince())) {
                this.context.startActivity(new Intent(this.context, BottleWizardStep1.class));
            } else {
                this.context.startActivity(new Intent(this.context, BottleBeachUI.class));
            }
            return true;
        } else if (str.equals("contact_info_floatbottle_clear_data")) {
            com.tencent.mm.ui.base.g.b(this.context, this.context.getString(2131232017), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ e euY;

                {
                    this.euY = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    i.XH();
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_floatbottle_install")) {
            f(this.context, true);
            return true;
        } else if (str.equals("contact_info_floatbottle_uninstall")) {
            com.tencent.mm.ui.base.g.b(this.context, this.context.getString(2131235107), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ e euY;

                {
                    this.euY = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    e.f(this.euY.context, false);
                }
            }, null);
            return true;
        } else {
            v.e("MicroMsg.ContactWidgetFloatBottle", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(m.eJ(uVar.field_username));
        ak.yW();
        c.vf().a(this);
        this.euW = uVar;
        this.dxf = fVar;
        fVar.addPreferencesFromResource(2131099667);
        Preference Ow = fVar.Ow("contact_info_header_helper");
        if (Ow != null) {
            this.euX.put("contact_info_header_helper", Ow);
        }
        Ow = fVar.Ow("contact_info_goto_floatbottle");
        if (Ow != null) {
            this.euX.put("contact_info_goto_floatbottle", Ow);
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) fVar.Ow("contact_info_floatbottle_hide_cat");
        if (preferenceCategory != null) {
            this.euX.put("contact_info_floatbottle_hide_cat", preferenceCategory);
        }
        Ow = fVar.Ow("contact_info_floatbottle_clear_data");
        if (Ow != null) {
            this.euX.put("contact_info_floatbottle_clear_data", Ow);
        }
        preferenceCategory = (PreferenceCategory) fVar.Ow("contact_info_floatbottle_hide_cat2");
        if (preferenceCategory != null) {
            this.euX.put("contact_info_floatbottle_hide_cat2", preferenceCategory);
        }
        preferenceCategory = (PreferenceCategory) fVar.Ow("contact_info_floatbottle_hide_cat3");
        if (preferenceCategory != null) {
            this.euX.put("contact_info_floatbottle_hide_cat3", preferenceCategory);
        }
        Ow = fVar.Ow("contact_info_floatbottle_install");
        if (Ow != null) {
            this.euX.put("contact_info_floatbottle_install", Ow);
        }
        Ow = fVar.Ow("contact_info_floatbottle_uninstall");
        if (Ow != null) {
            this.euX.put("contact_info_floatbottle_uninstall", Ow);
        }
        XR();
        return true;
    }

    private void XR() {
        int i = 1;
        this.status = k.xJ();
        this.aZw = (k.xQ() & 64) == 0;
        this.dxf.removeAll();
        if (this.euX.containsKey("contact_info_header_helper")) {
            this.dxf.a((HelperHeaderPreference) this.euX.get("contact_info_header_helper"));
            HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.dxf.Ow("contact_info_header_helper");
            helperHeaderPreference.U(this.euW.field_username, this.euW.tU(), this.context.getString(2131232045));
            if (!this.aZw) {
                i = 0;
            }
            helperHeaderPreference.updateStatus(i);
        }
        if (this.euX.containsKey("contact_info_floatbottle_hide_cat")) {
            this.dxf.a((Preference) this.euX.get("contact_info_floatbottle_hide_cat"));
        }
        if (this.aZw) {
            if (this.euX.containsKey("contact_info_goto_floatbottle")) {
                this.dxf.a((Preference) this.euX.get("contact_info_goto_floatbottle"));
            }
            if (this.euX.containsKey("contact_info_floatbottle_clear_data")) {
                this.dxf.a((Preference) this.euX.get("contact_info_floatbottle_clear_data"));
            }
            if (this.euX.containsKey("contact_info_floatbottle_hide_cat2")) {
                this.dxf.a((Preference) this.euX.get("contact_info_floatbottle_hide_cat2"));
            }
            if (this.euX.containsKey("contact_info_floatbottle_uninstall")) {
                this.dxf.a((Preference) this.euX.get("contact_info_floatbottle_uninstall"));
            }
        } else if (this.euX.containsKey("contact_info_floatbottle_install")) {
            this.dxf.a((Preference) this.euX.get("contact_info_floatbottle_install"));
        }
    }

    public static void f(Context context, boolean z) {
        String string = z ? context.getString(2131235103) : context.getString(2131235111);
        context.getString(2131231164);
        final p a = com.tencent.mm.ui.base.g.a(context, string, true, null);
        final AnonymousClass3 anonymousClass3 = new AnonymousClass3(z, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass3.sendEmptyMessage(0);
                }
            }
        }, 1500);
    }

    public final boolean XS() {
        ak.yW();
        c.vf().b(this);
        com.tencent.mm.plugin.bottle.a.drq.ow();
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        int n = be.n(obj, 0);
        v.d("MicroMsg.ContactWidgetFloatBottle", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), jVar});
        ak.yW();
        if (jVar != c.vf() || n <= 0) {
            v.e("MicroMsg.ContactWidgetFloatBottle", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), jVar});
        } else if (n == 40 || n == 34 || n == 7) {
            XR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
