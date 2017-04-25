package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsAboutCamera extends MMPreference {
    private f dxf;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public void onResume() {
        super.onResume();
        aMU();
    }

    public final int Oo() {
        return 2131099725;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        String str = preference.dnU;
        if (str.equals("settings_take_photo_auto_save_photo")) {
            ak.yW();
            boolean booleanValue = ((Boolean) c.vf().get(a.nuh, Boolean.valueOf(true))).booleanValue();
            ak.yW();
            c.vf().a(a.nuh, Boolean.valueOf(!booleanValue));
        }
        if (str.equals("settings_take_photo_auto_save_video")) {
            ak.yW();
            booleanValue = ((Boolean) c.vf().get(a.nui, Boolean.valueOf(true))).booleanValue();
            ak.yW();
            r vf = c.vf();
            a aVar = a.nui;
            if (booleanValue) {
                z = false;
            }
            vf.a(aVar, Boolean.valueOf(z));
        }
        aMU();
        return false;
    }

    private void aMU() {
        ak.yW();
        ((CheckBoxPreference) this.dxf.Ow("settings_take_photo_auto_save_photo")).ocf = ((Boolean) c.vf().get(a.nuh, Boolean.valueOf(true))).booleanValue();
        ak.yW();
        ((CheckBoxPreference) this.dxf.Ow("settings_take_photo_auto_save_video")).ocf = ((Boolean) c.vf().get(a.nui, Boolean.valueOf(true))).booleanValue();
        this.dxf.notifyDataSetChanged();
    }

    protected final void NI() {
        this.dxf = this.ocZ;
        vD(2131235164);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAboutCamera iKu;

            {
                this.iKu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iKu.axg();
                this.iKu.finish();
                return true;
            }
        });
    }
}
