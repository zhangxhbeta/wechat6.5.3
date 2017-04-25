package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.protocal.c.amv;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.j;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class o implements a, b {
    Context context;
    private f dxf;
    private u euW;
    private HelperHeaderPreference.a hWi;

    static class AnonymousClass2 extends ac {
        final /* synthetic */ boolean euZ;
        final /* synthetic */ j eva = null;

        AnonymousClass2(boolean z, j jVar) {
            this.euZ = z;
        }

        public final void handleMessage(Message message) {
            int xQ = k.xQ();
            if (this.euZ) {
                xQ &= -4194305;
            } else {
                xQ |= 4194304;
            }
            ak.yW();
            c.vf().set(34, Integer.valueOf(xQ));
            amv com_tencent_mm_protocal_c_amv = new amv();
            com_tencent_mm_protocal_c_amv.mau = 4194304;
            com_tencent_mm_protocal_c_amv.mNo = this.euZ ? 0 : 1;
            ak.yW();
            c.wG().b(new com.tencent.mm.ak.j.a(39, com_tencent_mm_protocal_c_amv));
            if (this.eva != null) {
                this.eva.a(null, null);
            }
        }
    }

    public o(Context context) {
        this.context = context;
        this.hWi = new t(context);
    }

    private static boolean aGN() {
        try {
            ak.yW();
            return ((Boolean) c.vf().get(73218, Boolean.valueOf(true))).booleanValue();
        } catch (Exception e) {
            return true;
        }
    }

    public final boolean pz(String str) {
        v.d("MicroMsg.ContactWidgetVoipAudio", "handleEvent : key = " + str);
        if (be.ma(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_voipaudio_install")) {
            f(this.context, true);
            return true;
        } else if (str.equals("contact_info_voipaudio_uninstall")) {
            g.b(this.context, this.context.getString(2131235107), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ o hWk;

                {
                    this.hWk = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    o.f(this.hWk.context, false);
                }
            }, null);
            return true;
        } else {
            v.e("MicroMsg.ContactWidgetVoipAudio", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(m.eV(uVar.field_username));
        ak.yW();
        c.vf().a(this);
        this.euW = uVar;
        this.dxf = fVar;
        XR();
        return true;
    }

    private void XR() {
        Object obj;
        boolean aGN = aGN();
        if ((k.xQ() & 4194304) == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        this.dxf.removeAll();
        this.dxf.addPreferencesFromResource(2131099687);
        ((HelperHeaderPreference) this.dxf.Ow("contact_info_header_helper")).a(this.euW, this.hWi);
        ((CheckBoxPreference) this.dxf.Ow("contact_info_voipaudio_sound_notify")).ocf = aGN;
        if (obj != null) {
            this.dxf.Ox("contact_info_voipaudio_install");
            return;
        }
        this.dxf.Ox("contact_info_voipaudio_uninstall");
        this.dxf.Ox("contact_info_voipaudio_sound_notify");
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
        this.dxf.Ow("contact_info_header_helper");
        com.tencent.mm.plugin.profile.a.drq.ow();
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        int n = be.n(obj, 0);
        v.d("MicroMsg.ContactWidgetVoipAudio", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), jVar});
        ak.yW();
        if (jVar != c.vf() || n <= 0) {
            v.e("MicroMsg.ContactWidgetVoipAudio", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), jVar});
        } else if (n == 40 || n == 34 || n == 7) {
            XR();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
