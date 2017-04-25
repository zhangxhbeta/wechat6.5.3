package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

abstract class k implements a, b {
    protected Context context;
    protected f dxf;
    protected u euW;
    protected HelperHeaderPreference.a hWd;

    protected abstract boolean aGK();

    protected abstract void clear();

    protected abstract void eM(boolean z);

    public k(Context context, HelperHeaderPreference.a aVar) {
        this.context = context;
        this.hWd = aVar;
    }

    public void a(int i, j jVar, Object obj) {
        int n = be.n(obj, 0);
        v.d("MicroMsg.ContactWidgetPlugin", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), jVar});
        ak.yW();
        if (jVar != c.vf() || n <= 0) {
            v.e("MicroMsg.ContactWidgetPlugin", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), jVar});
        } else if (n == 40 || n == 34 || n == 7) {
            XR();
        }
    }

    public boolean a(f fVar, u uVar, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
        Assert.assertTrue(uVar != null);
        if (be.ma(uVar.field_username).length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (fVar != null) {
            z3 = true;
        }
        Assert.assertTrue(z3);
        ak.yW();
        c.vf().a(this);
        this.euW = uVar;
        this.dxf = fVar;
        XR();
        return true;
    }

    public boolean XS() {
        ak.yW();
        c.vf().b(this);
        this.dxf.Ow("contact_info_header_helper");
        return true;
    }

    public boolean pz(String str) {
        if ("contact_info_plugin_clear_data".equals(str)) {
            g.b(this.context, this.context.getString(2131232017), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ k hWe;

                {
                    this.hWe = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.hWe.clear();
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_plugin_install")) {
            eM(true);
            return true;
        } else if (str.equals("contact_info_plugin_uninstall")) {
            g.b(this.context, this.context.getString(2131235107), "", this.context.getString(2131231012), this.context.getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ k hWe;

                {
                    this.hWe = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.hWe.eM(false);
                }
            }, null);
            return true;
        } else {
            v.e("MicroMsg.ContactWidgetPlugin", "handleEvent : unexpected key = " + str);
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    private void XR() {
        this.dxf.removeAll();
        this.dxf.addPreferencesFromResource(2131099666);
        boolean aGK = aGK();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.dxf.Ow("contact_info_header_helper");
        if (helperHeaderPreference != null) {
            helperHeaderPreference.a(this.euW, this.hWd);
        }
        if (aGK) {
            this.dxf.Ox("contact_info_plugin_install");
            return;
        }
        this.dxf.Ox("contact_info_plugin_view");
        this.dxf.Ox("contact_info_plugin_outsize");
        this.dxf.Ox("contact_info_plugin_black");
        this.dxf.Ox("contact_info_plugin_clear_data");
        this.dxf.Ox("contact_info_plugin_uninstall");
    }
}
