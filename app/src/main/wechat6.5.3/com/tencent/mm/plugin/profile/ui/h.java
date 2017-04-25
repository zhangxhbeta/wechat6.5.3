package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.protocal.c.amv;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.j;
import junit.framework.Assert;

public final class h implements a, b {
    Context context;
    private f dxf;
    private u euW;
    private HelperHeaderPreference.a hVL;

    static class AnonymousClass2 implements ah.a {
        final /* synthetic */ ProgressDialog eXG;
        final /* synthetic */ boolean euZ;
        final /* synthetic */ j eva = null;

        AnonymousClass2(ProgressDialog progressDialog, boolean z, j jVar) {
            this.eXG = progressDialog;
            this.euZ = z;
        }

        public final boolean oU() {
            if (this.eXG != null) {
                this.eXG.dismiss();
            }
            int xQ = k.xQ();
            if (this.euZ) {
                xQ &= -16777217;
            } else {
                xQ |= 16777216;
                ak.yW();
                c.vf().set(286722, "");
                ak.yW();
                c.vf().set(286721, "");
                ak.yW();
                c.vf().set(286723, "");
            }
            ak.yW();
            c.vf().set(34, Integer.valueOf(xQ));
            amv com_tencent_mm_protocal_c_amv = new amv();
            com_tencent_mm_protocal_c_amv.mau = 16777216;
            com_tencent_mm_protocal_c_amv.mNo = this.euZ ? 0 : 1;
            ak.yW();
            c.wG().b(new com.tencent.mm.ak.j.a(39, com_tencent_mm_protocal_c_amv));
            if (this.eva != null) {
                this.eva.a(null, null);
            }
            return false;
        }
    }

    public h(Context context) {
        this.context = context;
        this.hVL = new s(context);
    }

    public final boolean pz(String str) {
        v.d("MicroMsg.ContactWidgetLinkedIn", "handleEvent : key = " + str);
        if (be.ma(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_linkedin_install")) {
            f(this.context, true);
            return true;
        } else if (str.equals("contact_info_linkedin_uninstall")) {
            g.b(this.context, this.context.getString(2131235107), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ h hVM;

                {
                    this.hVM = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    h.f(this.hVM.context, false);
                    com.tencent.mm.modelfriend.ah.FU().clear();
                }
            }, null);
            return true;
        } else {
            if (str.equals("contact_info_linkedin_account")) {
                com.tencent.mm.ay.c.b(this.context, "accountsync", "com.tencent.mm.ui.bindlinkedin.BindLinkedInUI", 1);
            }
            if (str.equals("contact_info_linkedin_add_friend")) {
                Intent intent = new Intent();
                intent.putExtra("KScene", 2);
                com.tencent.mm.plugin.profile.a.drp.j(this.context, intent);
                return true;
            }
            v.e("MicroMsg.ContactWidgetLinkedIn", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(m.eX(uVar.field_username));
        ak.yW();
        c.vf().a(this);
        this.euW = uVar;
        this.dxf = fVar;
        XR();
        return true;
    }

    private void XR() {
        String str = null;
        boolean z = (k.xQ() & 16777216) == 0;
        this.dxf.removeAll();
        this.dxf.addPreferencesFromResource(2131099671);
        ((HelperHeaderPreference) this.dxf.Ow("contact_info_header_helper")).a(this.euW, this.hVL);
        if (z) {
            this.dxf.aO("contact_info_linkedin_account", false);
            this.dxf.Ox("contact_info_linkedin_install");
        } else {
            this.dxf.aO("contact_info_linkedin_account", true);
            this.dxf.Ox("contact_info_linkedin_uninstall");
        }
        ak.yW();
        Object obj = c.vf().get(286722, null);
        ak.yW();
        Object obj2 = c.vf().get(286721, null);
        if (z && com.tencent.mm.h.g.sX()) {
            String obj3;
            if (obj != null) {
                obj3 = obj.toString();
            } else {
                obj3 = null;
            }
            if (!be.kS(obj3)) {
                if (obj2 != null) {
                    str = obj2.toString();
                }
                if (!be.kS(str)) {
                    this.dxf.aO("contact_info_linkedin_add_friend", false);
                    return;
                }
            }
        }
        this.dxf.aO("contact_info_linkedin_add_friend", true);
    }

    public static void f(Context context, boolean z) {
        String string = z ? context.getString(2131235103) : context.getString(2131235111);
        context.getString(2131231164);
        new ah(new AnonymousClass2(g.a(context, string, true, null), z, null), false).ea(1500);
    }

    public final boolean XS() {
        ak.yW();
        c.vf().b(this);
        this.dxf.Ow("contact_info_header_helper");
        com.tencent.mm.plugin.profile.a.drq.ow();
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            XR();
        }
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (intValue == 40 || intValue == 34) {
                XR();
            }
        }
    }
}
