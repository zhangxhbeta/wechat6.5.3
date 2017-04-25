package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.c.amv;
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

public final class m implements a, b {
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
            int xQ = k.xQ();
            if (this.euZ) {
                xQ &= -33554433;
            } else {
                xQ |= 33554432;
            }
            ak.yW();
            c.vf().set(34, Integer.valueOf(xQ));
            amv com_tencent_mm_protocal_c_amv = new amv();
            com_tencent_mm_protocal_c_amv.mau = 33554432;
            com_tencent_mm_protocal_c_amv.mNo = this.euZ ? 0 : 1;
            ak.yW();
            c.wG().b(new com.tencent.mm.ak.j.a(39, com_tencent_mm_protocal_c_amv));
            if (this.eva != null) {
                this.eva.a(null, null);
            }
        }
    }

    public m(Context context) {
        this.context = context;
    }

    public final boolean pz(String str) {
        v.d("MicroMsg.ContactWidgetVoiceInput", "handleEvent : key = " + str);
        if (be.ma(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_voiceinput_install")) {
            f(this.context, true);
            return true;
        } else if (str.equals("contact_info_voiceinput_uninstall")) {
            g.b(this.context, this.context.getString(2131235107), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ m hWh;

                {
                    this.hWh = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    m.f(this.hWh.context, false);
                }
            }, null);
            return true;
        } else {
            v.e("MicroMsg.ContactWidgetVoiceInput", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(com.tencent.mm.model.m.eW(uVar.field_username));
        ak.yW();
        c.vf().a(this);
        this.euW = uVar;
        this.dxf = fVar;
        fVar.addPreferencesFromResource(2131099685);
        XR();
        return true;
    }

    private void XR() {
        int i;
        boolean z = true;
        boolean z2 = (k.xQ() & 33554432) == 0;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.dxf.Ow("contact_info_header_helper");
        helperHeaderPreference.U(this.euW.field_username, this.euW.tU(), this.context.getString(2131232204));
        if (z2) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.updateStatus(i);
        this.dxf.aO("contact_info_voiceinput_install", z2);
        f fVar = this.dxf;
        String str = "contact_info_voiceinput_uninstall";
        if (z2) {
            z = false;
        }
        fVar.aO(str, z);
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
        com.tencent.mm.plugin.profile.a.drq.ow();
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        int n = be.n(obj, 0);
        v.d("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), jVar});
        ak.yW();
        if (jVar != c.vf() || n <= 0) {
            v.e("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), jVar});
        } else if (n == 40 || n == 34 || n == 7) {
            XR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
