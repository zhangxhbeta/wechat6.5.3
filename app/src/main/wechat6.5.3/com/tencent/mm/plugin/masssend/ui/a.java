package com.tencent.mm.plugin.masssend.ui;

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
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.j;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a implements com.tencent.mm.pluginsdk.c.a, b {
    Context context;
    private f dxf;
    private u euW;
    private Map<String, Preference> euX = new HashMap();

    static class AnonymousClass3 extends ac {
        final /* synthetic */ boolean euZ;
        final /* synthetic */ j eva = null;

        AnonymousClass3(boolean z, j jVar) {
            this.euZ = z;
        }

        public final void handleMessage(Message message) {
            int i;
            int xQ = k.xQ();
            if (this.euZ) {
                i = xQ & -65537;
            } else {
                i = xQ | 65536;
            }
            ak.yW();
            c.vf().set(34, Integer.valueOf(i));
            ak.yW();
            c.wG().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.euZ) {
                a.ua();
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
        v.d("MicroMsg.ContactWidgetMassSend", "handleEvent : key = " + str);
        if (be.ma(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_masssend_view")) {
            this.context.startActivity(new Intent(this.context, MassSendHistoryUI.class));
            return true;
        } else if (str.equals("contact_info_masssend_clear_data")) {
            g.b(this.context, this.context.getString(2131232017), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ a hjF;

                {
                    this.hjF = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    a.ua();
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_masssend_install")) {
            f(this.context, true);
            return true;
        } else if (str.equals("contact_info_masssend_uninstall")) {
            g.b(this.context, this.context.getString(2131235107), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ a hjF;

                {
                    this.hjF = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    a.f(this.hjF.context, false);
                }
            }, null);
            return true;
        } else {
            v.e("MicroMsg.ContactWidgetMassSend", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(m.eM(uVar.field_username));
        ak.yW();
        c.vf().a(this);
        this.euW = uVar;
        this.dxf = fVar;
        fVar.addPreferencesFromResource(2131099672);
        XR();
        return true;
    }

    private void XR() {
        int i;
        boolean z;
        boolean z2 = true;
        boolean z3 = (k.xQ() & 65536) == 0;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.dxf.Ow("contact_info_masssend_header_helper");
        helperHeaderPreference.U(this.euW.field_username, this.euW.tU(), this.context.getString(2131232084));
        if (z3) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.updateStatus(i);
        this.dxf.aO("contact_info_masssend_install", z3);
        f fVar = this.dxf;
        String str = "contact_info_masssend_view";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.aO(str, z);
        fVar = this.dxf;
        str = "contact_info_masssend_clear_data";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.aO(str, z);
        f fVar2 = this.dxf;
        String str2 = "contact_info_masssend_uninstall";
        if (z3) {
            z2 = false;
        }
        fVar2.aO(str2, z2);
    }

    public static void f(Context context, boolean z) {
        String string = z ? context.getString(2131235103) : context.getString(2131235111);
        context.getString(2131231164);
        final p a = g.a(context, string, true, null);
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

    public static void ua() {
        com.tencent.mm.plugin.masssend.a.b azf = h.azf();
        if (azf.cuX.dF("massendinfo", "delete from massendinfo")) {
            azf.Ls();
        }
        ak.yW();
        c.wK().Mf("masssendapp");
    }

    public final boolean XS() {
        ak.yW();
        c.vf().b(this);
        com.tencent.mm.plugin.masssend.a.drq.ow();
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        int n = be.n(obj, 0);
        v.d("MicroMsg.ContactWidgetMassSend", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), jVar});
        ak.yW();
        if (jVar != c.vf() || n <= 0) {
            v.e("MicroMsg.ContactWidgetMassSend", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), jVar});
        } else if (n == 40 || n == 34 || n == 7) {
            XR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
