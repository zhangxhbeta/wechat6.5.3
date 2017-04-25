package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ak.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.protocal.c.rc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import java.util.HashMap;
import java.util.Map.Entry;

public class SettingsAddMeUI extends MMPreference {
    private f dxf;
    private HashMap<Integer, Integer> euP = new HashMap();
    private long iKb;
    private int iLI;
    private int status;

    public final h a(SharedPreferences sharedPreferences) {
        return new a(this, sharedPreferences);
    }

    public final int Oo() {
        return 2131099719;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dxf = this.ocZ;
        this.iLI = k.xL();
        this.status = k.xJ();
        this.iKb = k.xK();
        NI();
    }

    public void onPause() {
        super.onPause();
        v.d("MicroMsg.SettingsAddMeUI", "plug:" + this.iLI + ",status:" + this.status + ",extstatus:" + this.iKb);
        ak.yW();
        c.vf().set(7, Integer.valueOf(this.status));
        ak.yW();
        c.vf().set(40, Integer.valueOf(this.iLI));
        ak.yW();
        c.vf().set(147457, Long.valueOf(this.iKb));
        for (Entry entry : this.euP.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            rc rcVar = new rc();
            rcVar.muR = intValue;
            rcVar.muS = intValue2;
            ak.yW();
            c.wG().b(new j.a(23, rcVar));
            v.d("MicroMsg.SettingsAddMeUI", "switch  " + intValue + " " + intValue2);
        }
        this.euP.clear();
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        String str = preference.dnU;
        v.i("MicroMsg.SettingsAddMeUI", str + " item has been clicked!");
        if (str.equals("settings_find_me_by_QQ")) {
            boolean z2 = !((CheckBoxPreference) fVar.Ow("settings_find_me_by_QQ")).isChecked();
            a(z2, 8, 2);
            a(z2, 16, 3);
            return true;
        } else if (str.equals("settings_find_me_by_weixin")) {
            if (!((CheckBoxPreference) fVar.Ow("settings_find_me_by_weixin")).isChecked()) {
                z = true;
            }
            v.d("MicroMsg.SettingsAddMeUI", "switch plug change : open = " + z + " item value = 512 functionId = 25");
            if (z) {
                this.iLI |= 512;
            } else {
                this.iLI &= -513;
            }
            this.euP.put(Integer.valueOf(25), Integer.valueOf(z ? 1 : 2));
            return true;
        } else if (str.equals("settings_find_me_by_mobile")) {
            if (!((CheckBoxPreference) fVar.Ow("settings_find_me_by_mobile")).isChecked()) {
                z = true;
            }
            a(z, 512, 8);
            return true;
        } else if (str.equals("settings_find_me_by_google")) {
            if (!((CheckBoxPreference) fVar.Ow("settings_find_me_by_google")).isChecked()) {
                z = true;
            }
            a(z, 524288, 30);
            return true;
        } else if (str.equals("settings_add_me_by_chatroom")) {
            if (!((CheckBoxPreference) fVar.Ow("settings_add_me_by_chatroom")).isChecked()) {
                z = true;
            }
            b(z, 1, 38);
            return true;
        } else if (str.equals("settings_add_me_by_qrcode")) {
            if (!((CheckBoxPreference) fVar.Ow("settings_add_me_by_qrcode")).isChecked()) {
                z = true;
            }
            b(z, 2, 39);
            return true;
        } else if (!str.equals("settings_add_me_by_namecard")) {
            return false;
        } else {
            if (!((CheckBoxPreference) fVar.Ow("settings_add_me_by_namecard")).isChecked()) {
                z = true;
            }
            b(z, 4, 40);
            return true;
        }
    }

    private void a(boolean z, int i, int i2) {
        v.d("MicroMsg.SettingsAddMeUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.euP.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
    }

    private void b(boolean z, int i, int i2) {
        v.d("MicroMsg.SettingsAddMeUI", "switch ext change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.iKb |= (long) i;
        } else {
            this.iKb &= (long) (i ^ -1);
        }
        this.euP.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
    }

    protected final void NI() {
        String str;
        boolean z;
        vD(2131234977);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAddMeUI iLJ;

            {
                this.iLJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iLJ.axg();
                this.iLJ.finish();
                return true;
            }
        });
        this.dxf.removeAll();
        this.dxf.addPreferencesFromResource(2131099719);
        Editor edit = this.cnm.edit();
        v.d("MicroMsg.SettingsAddMeUI", "plug:" + this.iLI + ",status:" + this.status + ",extstatus:" + this.iKb);
        ak.yW();
        Integer num = (Integer) c.vf().get(9, null);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_find_me_by_QQ");
        if (num == null || num.intValue() == 0) {
            this.dxf.b(checkBoxPreference);
        } else {
            boolean z2 = (op(8) && op(16)) ? false : true;
            checkBoxPreference.ocf = z2;
            edit.putBoolean("settings_find_me_by_QQ", z2);
        }
        ak.yW();
        String str2 = (String) c.vf().get(6, null);
        checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_find_me_by_mobile");
        if (str2 == null || str2.length() <= 0) {
            this.dxf.b(checkBoxPreference);
        } else {
            if (op(512)) {
                z2 = false;
            } else {
                z2 = true;
            }
            checkBoxPreference.ocf = z2;
            str = "settings_find_me_by_mobile";
            if (op(512)) {
                z2 = false;
            } else {
                z2 = true;
            }
            edit.putBoolean(str, z2);
        }
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.dxf.Ow("settings_find_me_by_weixin");
        if ((this.iLI & 512) != 0) {
            checkBoxPreference2.ocf = false;
            edit.putBoolean("settings_find_me_by_weixin", false);
        } else {
            checkBoxPreference2.ocf = true;
            edit.putBoolean("settings_find_me_by_weixin", true);
        }
        checkBoxPreference2 = (CheckBoxPreference) this.dxf.Ow("settings_find_me_by_google");
        if (op(524288)) {
            z = false;
        } else {
            z = true;
        }
        checkBoxPreference2.ocf = z;
        String str3 = "settings_find_me_by_google";
        if (op(524288)) {
            z = false;
        } else {
            z = true;
        }
        edit.putBoolean(str3, z);
        ak.yW();
        str = (String) c.vf().get(208903, null);
        if (!be.He() || TextUtils.isEmpty(str)) {
            this.dxf.b(checkBoxPreference2);
        }
        checkBoxPreference2 = (CheckBoxPreference) this.dxf.Ow("settings_add_me_by_chatroom");
        if ((this.iKb & 1) != 0) {
            checkBoxPreference2.ocf = false;
            edit.putBoolean("settings_add_me_by_chatroom", false);
        } else {
            checkBoxPreference2.ocf = true;
            edit.putBoolean("settings_add_me_by_chatroom", true);
        }
        checkBoxPreference2 = (CheckBoxPreference) this.dxf.Ow("settings_add_me_by_qrcode");
        if ((this.iKb & 2) != 0) {
            checkBoxPreference2.ocf = false;
            edit.putBoolean("settings_add_me_by_qrcode", false);
        } else {
            checkBoxPreference2.ocf = true;
            edit.putBoolean("settings_add_me_by_qrcode", true);
        }
        checkBoxPreference2 = (CheckBoxPreference) this.dxf.Ow("settings_add_me_by_namecard");
        if ((this.iKb & 4) != 0) {
            checkBoxPreference2.ocf = false;
            edit.putBoolean("settings_add_me_by_namecard", false);
        } else {
            checkBoxPreference2.ocf = true;
            edit.putBoolean("settings_add_me_by_namecard", true);
        }
        edit.commit();
        this.dxf.notifyDataSetChanged();
    }

    private boolean op(int i) {
        return (this.status & i) != 0;
    }
}
