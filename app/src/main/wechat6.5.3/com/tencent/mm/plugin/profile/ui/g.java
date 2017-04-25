package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.i;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;
import junit.framework.Assert;

public final class g implements a {
    Context context;
    private f dxf;
    private String ePn;
    o ePs;
    private u euW;
    private boolean hTY;
    private boolean hTZ;
    private int hUa;
    private int hVI;
    ContactListExpandPreference hVJ;

    public g(Context context) {
        this.context = context;
        this.hVJ = new ContactListExpandPreference(context, 0);
    }

    public final boolean pz(String str) {
        v.d("MicroMsg.ContactWidgetGroupCard", "handleEvent " + str);
        ak.yW();
        u LX = c.wH().LX(str);
        if (LX != null && ((int) LX.chr) > 0) {
            Intent intent = new Intent();
            intent.setClass(this.context, ContactInfoUI.class);
            intent.putExtra("Contact_User", LX.field_username);
            this.context.startActivity(intent);
        }
        return true;
    }

    public final boolean a(f fVar, u uVar, boolean z, int i) {
        Assert.assertTrue(uVar != null);
        Assert.assertTrue(be.ma(uVar.field_username).length() > 0);
        Assert.assertTrue(fVar != null);
        this.dxf = fVar;
        this.euW = uVar;
        this.hTY = z;
        this.hUa = i;
        this.hTZ = ((Activity) this.context).getIntent().getBooleanExtra("User_Verify", false);
        this.hVI = ((Activity) this.context).getIntent().getIntExtra("Kdel_from", -1);
        this.ePn = uVar.field_username;
        this.ePs = ak.yW().wO().LD(this.ePn);
        this.dxf.removeAll();
        this.dxf.a(new PreferenceSmallCategory(this.context));
        this.hVJ.setKey("roominfo_contact_anchor");
        this.dxf.a(this.hVJ);
        this.dxf.a(new PreferenceCategory(this.context));
        NormalUserFooterPreference normalUserFooterPreference = new NormalUserFooterPreference(this.context);
        normalUserFooterPreference.setLayoutResource(2130903410);
        normalUserFooterPreference.setKey("contact_info_footer_normal");
        if (normalUserFooterPreference.a(this.euW, "", this.hTY, this.hTZ, false, this.hUa, this.hVI, false, false, 0, "")) {
            this.dxf.a(normalUserFooterPreference);
        }
        this.hVJ.a(this.dxf, this.hVJ.dnU);
        List ej = i.ej(this.ePn);
        this.hVJ.hZ(false).ia(false);
        this.hVJ.j(this.ePn, ej);
        this.hVJ.a(new ContactListExpandPreference.a(this) {
            final /* synthetic */ g hVK;

            {
                this.hVK = r1;
            }

            public final void jo(int i) {
            }

            public final void jp(int i) {
                if (this.hVK.hVJ.tW(i)) {
                    String tY = this.hVK.hVJ.tY(i);
                    if (!be.kS(tY)) {
                        Intent intent = new Intent();
                        intent.setClass(this.hVK.context, ContactInfoUI.class);
                        intent.putExtra("Contact_User", tY);
                        intent.putExtra("Contact_RoomNickname", this.hVK.ePs.er(tY));
                        this.hVK.context.startActivity(intent);
                    }
                }
            }

            public final void adp() {
            }

            public final void jq(int i) {
            }
        });
        return true;
    }

    public final boolean XS() {
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.dxf.Ow("contact_info_footer_normal");
        if (normalUserFooterPreference != null) {
            normalUserFooterPreference.XS();
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
