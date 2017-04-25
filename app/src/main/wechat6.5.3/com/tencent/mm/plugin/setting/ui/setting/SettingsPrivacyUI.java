package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.mm.ak.j;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.j.ak;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.protocal.c.rc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ap;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import java.util.HashMap;
import java.util.Map.Entry;

public class SettingsPrivacyUI extends MMPreference {
    private String bYE = "";
    private f dxf;
    boolean ePv = false;
    private HashMap<Integer, Integer> euP = new HashMap();
    private boolean iLb = false;
    private int status;

    public final h a(SharedPreferences sharedPreferences) {
        return new a(this, sharedPreferences);
    }

    public final int Oo() {
        return 2131099717;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dxf = this.ocZ;
        this.status = k.xJ();
        this.bYE = k.xF();
        NI();
    }

    protected void onResume() {
        super.onResume();
        this.status = k.xJ();
        axg com_tencent_mm_protocal_c_axg = new axg();
        if (ak.lyf != null) {
            com_tencent_mm_protocal_c_axg = ak.lyf.Bv(this.bYE);
        }
        if (com_tencent_mm_protocal_c_axg == null) {
            v.e("MicroMsg.SettingPrivacy", "userinfo is null");
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
        if (!this.ePv) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!be.kS(stringExtra)) {
                final int Oy = this.dxf.Oy(stringExtra);
                setSelection(Oy - 3);
                new ac().postDelayed(new Runnable(this) {
                    final /* synthetic */ SettingsPrivacyUI iMG;

                    public final void run() {
                        View a = ((a) this.iMG.dxf).a(Oy, this.iMG.gMx);
                        if (a != null) {
                            com.tencent.mm.ui.g.a.b(this.iMG.nDR.nEl, a);
                        }
                    }
                }, 10);
            }
            this.ePv = true;
        }
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.model.ak.yW();
        c.vf().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.euP.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            rc rcVar = new rc();
            rcVar.muR = intValue;
            rcVar.muS = intValue2;
            com.tencent.mm.model.ak.yW();
            c.wG().b(new j.a(23, rcVar));
            v.d("MicroMsg.SettingPrivacy", "switch  " + intValue + " " + intValue2);
        }
        this.euP.clear();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        boolean z2 = true;
        String str = preference.dnU;
        v.i("MicroMsg.SettingPrivacy", str + " item has been clicked!");
        SharedPreferences sharedPreferences = this.cnm;
        if (str.equals("settings_need_verify")) {
            return c(sharedPreferences.getBoolean("settings_need_verify", false), 32, 4);
        }
        if (str.equals("settings_recommend_mobilefriends_to_me")) {
            boolean z3;
            if (((CheckBoxPreference) fVar.Ow("settings_recommend_mobilefriends_to_me")).isChecked()) {
                z3 = false;
            } else {
                z3 = true;
            }
            return c(z3, 256, 7);
        } else if (str.equals("settings_about_blacklist")) {
            ap fB = r.fB(getString(2131233189));
            Intent intent = new Intent();
            intent.putExtra("filter_type", fB.getType());
            intent.putExtra("titile", getString(2131235113));
            intent.putExtra("list_attr", 32768);
            com.tencent.mm.plugin.setting.a.drp.k(this, intent);
            return true;
        } else {
            Intent intent2;
            if (str.equals("timline_outside_permiss")) {
                intent2 = new Intent();
                intent2.putExtra("k_sns_tag_id", 4);
                intent2.putExtra("k_sns_from_settings_about_sns", 1);
                com.tencent.mm.ay.c.b(this, "sns", ".ui.SnsBlackDetailUI", intent2);
            } else if (str.equals("edit_timeline_group")) {
                com.tencent.mm.ay.c.w(this, "sns", ".ui.SnsTagPartlyUI");
            } else if (str.equals("timeline_black_permiss")) {
                intent2 = new Intent();
                intent2.putExtra("k_sns_tag_id", 5);
                intent2.putExtra("k_sns_from_settings_about_sns", 2);
                intent2.putExtra("k_tag_detail_sns_block_scene", 8);
                com.tencent.mm.ay.c.b(this, "sns", ".ui.SnsTagDetailUI", intent2);
            } else if (str.equals("timeline_stranger_show")) {
                if (this.iLb) {
                    z2 = false;
                }
                this.iLb = z2;
                if (ak.lyf != null) {
                    ak.lyf.am(this.bYE, this.iLb);
                }
                if (ak.lyf != null) {
                    axg an = ak.lyf.an(this.bYE, this.iLb);
                    ak.lyf.a(this.bYE, an);
                    if (an == null) {
                        v.e("MicroMsg.SettingPrivacy", "userinfo in null !");
                        return false;
                    }
                    v.d("MicroMsg.SettingPrivacy", "dancy userinfo " + an.toString());
                    com.tencent.mm.model.ak.yW();
                    c.wG().b(new j.a(51, an));
                }
            } else if (str.equals("settings_find_google_contact")) {
                if (!((CheckBoxPreference) fVar.Ow("settings_find_google_contact")).isChecked()) {
                    z = true;
                }
                c(z, 1048576, 29);
                return true;
            } else if (str.equals("settings_add_me_way")) {
                startActivity(new Intent(this, SettingsAddMeUI.class));
                return true;
            }
            return false;
        }
    }

    protected final void NI() {
        String str;
        boolean z = false;
        vD(2131234965);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsPrivacyUI iMG;

            {
                this.iMG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iMG.axg();
                this.iMG.finish();
                return true;
            }
        });
        this.dxf.removeAll();
        this.dxf.addPreferencesFromResource(2131099717);
        Editor edit = this.cnm.edit();
        v.v("MicroMsg.SettingPrivacy", "init function status: " + Integer.toBinaryString(this.status));
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_need_verify");
        boolean op = op(32);
        checkBoxPreference.ocf = op;
        edit.putBoolean("settings_need_verify", op);
        com.tencent.mm.model.ak.yW();
        String str2 = (String) c.vf().get(6, null);
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.dxf.Ow("settings_recommend_mobilefriends_to_me");
        if (str2 == null || str2.length() <= 0) {
            this.dxf.b(checkBoxPreference2);
        } else {
            boolean z2;
            checkBoxPreference2.ocf = !op(256);
            str = "settings_recommend_mobilefriends_to_me";
            if (op(256)) {
                z2 = false;
            } else {
                z2 = true;
            }
            edit.putBoolean(str, z2);
        }
        checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_find_google_contact");
        if (op(1048576)) {
            op = false;
        } else {
            op = true;
        }
        checkBoxPreference.ocf = op;
        String str3 = "settings_find_google_contact";
        if (op(1048576)) {
            op = false;
        } else {
            op = true;
        }
        edit.putBoolean(str3, op);
        com.tencent.mm.model.ak.yW();
        str = (String) c.vf().get(208903, null);
        if (!be.He() || TextUtils.isEmpty(str)) {
            this.dxf.b(checkBoxPreference);
        }
        if (com.tencent.mm.ay.c.EH("sns") && (k.xQ() & 32768) == 0) {
            z = true;
        }
        if (z) {
            com.tencent.mm.model.ak.yW();
            if (!(((Boolean) c.vf().get(335873, Boolean.valueOf(true))).booleanValue() && ak.lyh.aVj())) {
                this.dxf.aO("edit_timeline_group", true);
            }
        } else {
            this.dxf.aO("settings_add_friends_timeline_tip", true);
            this.dxf.aO("timline_outside_permiss", true);
            this.dxf.aO("timeline_black_permiss", true);
            this.dxf.aO("edit_timeline_group", true);
            this.dxf.aO("timeline_stranger_show", true);
        }
        edit.commit();
        this.dxf.notifyDataSetChanged();
    }

    private boolean op(int i) {
        return (this.status & i) != 0;
    }

    private boolean c(boolean z, int i, int i2) {
        v.d("MicroMsg.SettingPrivacy", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.euP.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        return true;
    }
}
