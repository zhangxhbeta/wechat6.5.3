package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.text.Html;
import com.tencent.mm.ak.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.l;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.ChoicePreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.ui.base.preference.f;

public final class c {
    private MMActivity aWn;
    private f dxf;

    public c(MMActivity mMActivity, f fVar) {
        this.aWn = mMActivity;
        this.dxf = fVar;
        ChoicePreference choicePreference = (ChoicePreference) this.dxf.Ow("settings_sex");
        choicePreference.ock = new a(this) {
            final /* synthetic */ c euR;

            {
                this.euR = r1;
            }

            public final boolean a(Preference preference, Object obj) {
                String str = (String) obj;
                int i = -1;
                if ("male".equalsIgnoreCase(str)) {
                    i = 1;
                } else if ("female".equalsIgnoreCase(str)) {
                    i = 2;
                }
                if (i > 0) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(12290, Integer.valueOf(i));
                }
                return false;
            }
        };
        choicePreference.setTitle(Html.fromHtml(this.aWn.getString(2131235140) + "<font color='red'>*</font>"));
        ((KeyValuePreference) this.dxf.Ow("settings_district")).setTitle(Html.fromHtml(this.aWn.getString(2131235002) + "<font color='red'>*</font>"));
    }

    public static void XM() {
        bf zO = bf.zO();
        ak.yW();
        com.tencent.mm.model.c.wG().b(new j.a(1, bf.a(zO)));
        com.tencent.mm.plugin.bottle.a.drq.ow();
    }

    public final void update() {
        ak.yW();
        ChoicePreference choicePreference = (ChoicePreference) this.dxf.Ow("settings_sex");
        switch (be.a((Integer) com.tencent.mm.model.c.vf().get(12290, null), 0)) {
            case 1:
                choicePreference.setValue("male");
                break;
            case 2:
                choicePreference.setValue("female");
                break;
            default:
                choicePreference.setValue("unknown");
                break;
        }
        bf zO = bf.zO();
        String province = zO.getProvince();
        this.dxf.Ow("settings_district").setSummary(l.eu(province) + " " + zO.getCity());
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.dxf.Ow("settings_signature");
        keyValuePreference.ocP = false;
        ak.yW();
        CharSequence ma = be.ma((String) com.tencent.mm.model.c.vf().get(12291, null));
        MMActivity mMActivity = this.aWn;
        if (ma.length() <= 0) {
            ma = this.aWn.getString(2131235144);
        }
        keyValuePreference.setSummary(e.a(mMActivity, ma));
        this.dxf.notifyDataSetChanged();
    }

    public final boolean XN() {
        Intent intent = new Intent();
        intent.putExtra("persist_signature", false);
        com.tencent.mm.plugin.bottle.a.drp.c(intent, this.aWn);
        return true;
    }

    public final boolean XO() {
        com.tencent.mm.plugin.bottle.a.drp.b(new Intent(), this.aWn);
        return true;
    }
}
