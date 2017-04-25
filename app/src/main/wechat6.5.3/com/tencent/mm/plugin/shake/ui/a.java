package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.af;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.j;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a implements af, com.tencent.mm.pluginsdk.c.a, b {
    Context context;
    private f dxf;
    private u euW;

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
                i = xQ & -257;
            } else {
                i = xQ | 256;
            }
            v.i("MicroMsg.ContactWidgetShake", "setInstall pluginFlag install:%b  pluginFlag : %d -> %d", new Object[]{Boolean.valueOf(this.euZ), Integer.valueOf(xQ), Integer.valueOf(i)});
            ak.yW();
            c.vf().set(34, Integer.valueOf(i));
            ak.yW();
            c.wG().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.euZ) {
                com.tencent.mm.plugin.shake.b.k.aNR();
            }
            if (this.eva != null) {
                this.eva.a(null, null);
            }
        }
    }

    public a(Context context) {
        this.context = context;
    }

    public final boolean pz(String str) {
        v.d("MicroMsg.ContactWidgetShake", "handleEvent : key = " + str);
        if (be.ma(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_shake_go_shake")) {
            Intent intent = new Intent();
            intent.setClass(this.context, ShakeReportUI.class);
            this.context.startActivity(intent);
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_shake_install")) {
            f(this.context, true);
            return true;
        } else if (str.equals("contact_info_shake_uninstall")) {
            g.b(this.context, this.context.getString(2131235107), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ a iQE;

                {
                    this.iQE = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    a.f(this.iQE.context, false);
                }
            }, null);
            return true;
        } else {
            v.e("MicroMsg.ContactWidgetShake", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(m.eR(uVar.field_username));
        ak.yW();
        c.vf().a(this);
        ak.yW();
        c.a(this);
        this.euW = uVar;
        this.dxf = fVar;
        fVar.addPreferencesFromResource(2131099682);
        XR();
        return true;
    }

    private void XR() {
        boolean z;
        boolean z2 = true;
        boolean z3 = (k.xQ() & 256) == 0;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.dxf.Ow("contact_info_header_helper");
        if (helperHeaderPreference != null) {
            int i;
            helperHeaderPreference.U(this.euW.field_username, this.euW.tU(), this.context.getString(2131232164));
            if (z3) {
                i = 1;
            } else {
                i = 0;
            }
            helperHeaderPreference.updateStatus(i);
        }
        this.dxf.aO("contact_info_shake_install", z3);
        f fVar = this.dxf;
        String str = "contact_info_shake_go_shake";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.aO(str, z);
        f fVar2 = this.dxf;
        String str2 = "contact_info_shake_uninstall";
        if (z3) {
            z2 = false;
        }
        fVar2.aO(str2, z2);
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
        ak.yW();
        c.b(this);
        com.tencent.mm.plugin.shake.a.drq.ow();
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void yM() {
        XR();
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        int n = be.n(obj, 0);
        v.d("MicroMsg.ContactWidgetShake", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), jVar});
        ak.yW();
        if (jVar != c.vf() || n <= 0) {
            v.e("MicroMsg.ContactWidgetShake", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), jVar});
        } else if (n == 7 || n == 34) {
            XR();
        }
    }
}
