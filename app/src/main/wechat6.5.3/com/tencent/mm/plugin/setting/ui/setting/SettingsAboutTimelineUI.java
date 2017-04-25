package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ak.j.a;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.k;
import com.tencent.mm.pluginsdk.j.ak;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsAboutTimelineUI extends MMPreference {
    private String bYE = "";
    private f dxf;
    private boolean iLa = false;
    private boolean iLb = false;

    public final int Oo() {
        return 2131099718;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public void onResume() {
        super.onResume();
        axg com_tencent_mm_protocal_c_axg = new axg();
        if (ak.lyf != null) {
            com_tencent_mm_protocal_c_axg = ak.lyf.Bv(this.bYE);
        }
        if (com_tencent_mm_protocal_c_axg == null) {
            v.e("MicroMsg.SettingsAboutTimelineUI", "userinfo is null");
        } else {
            int i = com_tencent_mm_protocal_c_axg.mUx;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("timeline_stranger_show");
            if (checkBoxPreference != null) {
                this.iLb = (i & 1) > 0;
                SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
                if (this.iLb) {
                    checkBoxPreference.ocf = false;
                    sharedPreferences.edit().putBoolean("timeline_stranger_show", false).commit();
                } else {
                    checkBoxPreference.ocf = true;
                    sharedPreferences.edit().putBoolean("timeline_stranger_show", true).commit();
                }
            }
        }
        this.dxf.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        if (str.equals("timline_outside_permiss")) {
            Intent intent = new Intent();
            intent.putExtra("k_sns_tag_id", 4);
            intent.putExtra("k_sns_from_settings_about_sns", 1);
            c.b(this, "sns", ".ui.SnsBlackDetailUI", intent);
        }
        if (str.equals("timeline_black_permiss")) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 5);
            intent.putExtra("k_sns_from_settings_about_sns", 2);
            c.b(this, "sns", ".ui.SnsTagDetailUI", intent);
        }
        if (str.equals("timeline_stranger_show")) {
            this.iLb = !this.iLb;
            if (ak.lyf != null) {
                ak.lyf.am(this.bYE, this.iLb);
            }
            this.iLa = true;
        }
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.iLa && ak.lyf != null) {
            axg an = ak.lyf.an(this.bYE, this.iLb);
            if (an != null) {
                v.d("MicroMsg.SettingsAboutTimelineUI", "userinfo " + an.toString());
                com.tencent.mm.model.ak.yW();
                com.tencent.mm.model.c.wG().b(new a(51, an));
            }
        }
    }

    protected final void NI() {
        this.dxf = this.ocZ;
        vD(2131235089);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAboutTimelineUI iLc;

            {
                this.iLc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iLc.axg();
                this.iLc.finish();
                return true;
            }
        });
        this.bYE = k.xF();
    }
}
