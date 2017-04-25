package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ak.l;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsPluginsNotifyUI extends MMPreference {
    private f dxf;
    private int state;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public void onResume() {
        super.onResume();
        aMU();
    }

    public final int Oo() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        if (str.equals("settings_plugings_disturb_on")) {
            pk(0);
        }
        if (str.equals("settings_plugings_disturb_on_night")) {
            pk(1);
        }
        if (str.equals("settings_plugings_disturb_off")) {
            pk(2);
        }
        return false;
    }

    private void aMU() {
        this.dxf.removeAll();
        Preference preference = new Preference(this);
        preference.setTitle(2131235091);
        preference.setKey("settings_plugings_disturb_on");
        preference.setLayoutResource(2130903996);
        if (this.state == 0) {
            preference.setWidgetLayoutResource(2130904059);
        } else {
            preference.setWidgetLayoutResource(2130904060);
        }
        this.dxf.a(preference);
        preference = new Preference(this);
        preference.setTitle(2131235092);
        preference.setKey("settings_plugings_disturb_on_night");
        preference.setLayoutResource(2130903996);
        if (this.state == 1) {
            preference.setWidgetLayoutResource(2130904059);
        } else {
            preference.setWidgetLayoutResource(2130904060);
        }
        this.dxf.a(preference);
        preference = new Preference(this);
        preference.setTitle(2131235090);
        preference.setKey("settings_plugings_disturb_off");
        preference.setLayoutResource(2130903996);
        if (this.state == 2) {
            preference.setWidgetLayoutResource(2130904059);
        } else {
            preference.setWidgetLayoutResource(2130904060);
        }
        this.dxf.a(preference);
        preference = new Preference(this);
        preference.setTitle(2131235093);
        preference.setLayoutResource(2130904048);
        this.dxf.a(preference);
        this.dxf.notifyDataSetChanged();
    }

    private void pk(int i) {
        this.state = i;
        if (this.state == 1 || this.state == 0) {
            ak.yW();
            c.vf().set(8200, Boolean.valueOf(true));
            if (this.state == 1) {
                ak.yW();
                c.vf().set(8201, Integer.valueOf(22));
                ak.yW();
                c.vf().set(8208, Integer.valueOf(8));
                ak.yW();
                c.wG().b(new l(true, 22, 8));
            } else {
                ak.yW();
                c.vf().set(8201, Integer.valueOf(0));
                ak.yW();
                c.vf().set(8208, Integer.valueOf(0));
                ak.yW();
                c.wG().b(new l(true, 0, 0));
            }
        } else {
            ak.yW();
            c.vf().set(8200, Boolean.valueOf(false));
            ak.yW();
            c.wG().b(new l());
        }
        aMU();
    }

    protected final void NI() {
        Boolean valueOf = Boolean.valueOf(k.yc());
        int yk = k.yk();
        int yl = k.yl();
        if (valueOf.booleanValue()) {
            this.state = yk == yl ? 0 : 1;
        } else {
            this.state = 2;
        }
        v.d("ui.settings.SettingsPlugingsNotify", valueOf + "st " + yk + " ed " + yl + "  state " + this.state);
        this.state = this.state;
        this.dxf = this.ocZ;
        vD(2131235094);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsPluginsNotifyUI iMA;

            {
                this.iMA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iMA.axg();
                this.iMA.finish();
                return true;
            }
        });
    }
}
