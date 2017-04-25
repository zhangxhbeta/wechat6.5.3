package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class b implements a {
    private final Context context;
    private f dxf;

    public b(Context context) {
        this.context = context;
    }

    public final boolean pz(String str) {
        return true;
    }

    public final boolean a(f fVar, u uVar, boolean z, int i) {
        Assert.assertTrue(uVar != null);
        Assert.assertTrue(be.ma(uVar.field_username).length() > 0);
        Assert.assertTrue(fVar != null);
        XS();
        this.dxf = fVar;
        fVar.removeAll();
        fVar.addPreferencesFromResource(2131099664);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) fVar.Ow("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.lQq = "ContactWidgetBottleContact";
            normalUserHeaderPreference.a(uVar, 0, null);
        }
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) fVar.Ow("contact_info_footer_normal");
        boolean booleanExtra = ((Activity) this.context).getIntent().getBooleanExtra("Contact_FMessageCard", false);
        if (normalUserFooterPreference != null) {
            if (!normalUserFooterPreference.a(uVar, "", z, false, true, 25, 0, booleanExtra, false, 0, "")) {
                fVar.b(normalUserFooterPreference);
            }
        }
        KeyValuePreference keyValuePreference = (KeyValuePreference) fVar.Ow("contact_info_signature");
        if (uVar.bCj == null || uVar.bCj.trim().equals("")) {
            fVar.b(keyValuePreference);
        } else if (keyValuePreference != null) {
            keyValuePreference.ocP = false;
            keyValuePreference.setTitle(this.context.getString(2131232165));
            keyValuePreference.setSummary(e.a(this.context, uVar.bCj));
            keyValuePreference.jz(false);
        }
        return true;
    }

    public final boolean XS() {
        if (this.dxf != null) {
            FriendPreference friendPreference = (FriendPreference) this.dxf.Ow("contact_info_friend");
            if (friendPreference != null) {
                friendPreference.XS();
            }
            NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.dxf.Ow("contact_info_header_normal");
            if (normalUserHeaderPreference != null) {
                normalUserHeaderPreference.onDetach();
            }
            NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.dxf.Ow("contact_info_footer_normal");
            if (normalUserFooterPreference != null) {
                normalUserFooterPreference.XS();
            }
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
