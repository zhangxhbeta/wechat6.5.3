package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ak.l;
import com.tencent.mm.h.i;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;

public class SettingsNotificationUI extends MMPreference {
    private f dxf;

    static /* synthetic */ void pj(int i) {
        if (i == 1 || i == 0) {
            ak.yW();
            c.vf().set(8200, Boolean.valueOf(true));
            if (i == 1) {
                ak.yW();
                c.vf().set(8201, Integer.valueOf(22));
                ak.yW();
                c.vf().set(8208, Integer.valueOf(8));
                ak.yW();
                c.wG().b(new l(true, 22, 8));
                return;
            }
            ak.yW();
            c.vf().set(8201, Integer.valueOf(0));
            ak.yW();
            c.vf().set(8208, Integer.valueOf(0));
            ak.yW();
            c.wG().b(new l(true, 0, 0));
            return;
        }
        ak.yW();
        c.vf().set(8200, Boolean.valueOf(false));
        ak.yW();
        c.wG().b(new l());
    }

    public final int Oo() {
        return 2131099728;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.yW();
        v.d("MicroMsg.SettingsNotificationUI", "sns Notify " + be.a((Boolean) c.vf().get(68384, null), true));
        NI();
    }

    protected final void NI() {
        vD(2131235083);
        this.dxf = this.ocZ;
        SharedPreferences sharedPreferences = this.cnm;
        this.dxf.removeAll();
        this.dxf.addPreferencesFromResource(2131099728);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_new_msg_notification");
        if (i.st()) {
            checkBoxPreference.ocf = true;
        }
        fp(checkBoxPreference.isChecked());
        if (checkBoxPreference.isChecked()) {
            checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_sound");
            if (i.sv()) {
                checkBoxPreference.ocf = true;
                aNm();
            } else {
                this.dxf.Ox("settings_notification_ringtone");
            }
            checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_shake");
            if (i.sx()) {
                checkBoxPreference.ocf = true;
            }
            checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_show_detail");
            if (i.su()) {
                checkBoxPreference.ocf = true;
            }
        } else {
            this.dxf.Ox("settings_show_detail");
            this.dxf.Ox("settings_sound");
            this.dxf.Ox("settings_notification_ringtone");
            this.dxf.Ox("settings_shake");
            this.dxf.Ox("settings_active_time");
        }
        checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_sns_notify");
        boolean z = com.tencent.mm.ay.c.EH("sns") && (k.xQ() & 32768) == 0;
        if (!z) {
            this.dxf.aO("settings_sns_notify", true);
        } else if (sharedPreferences.getBoolean(checkBoxPreference.dnU, true)) {
            sharedPreferences.edit().putBoolean(checkBoxPreference.dnU, true).commit();
            checkBoxPreference.ocf = true;
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsNotificationUI iMx;

            {
                this.iMx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iMx.axg();
                this.iMx.finish();
                return true;
            }
        });
    }

    public void onResume() {
        super.onResume();
        aNm();
    }

    private void aNm() {
        Preference Ow = this.dxf.Ow("settings_notification_ringtone");
        if (Ow != null) {
            Ow.setSummary(this.cnm.getString("settings.ringtone.name", getString(2131235084)));
        }
        this.dxf.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        if (str.equals("settings_new_msg_notification")) {
            i.aA(((CheckBoxPreference) preference).isChecked());
            NI();
            return fp(((CheckBoxPreference) preference).isChecked());
        } else if (str.equals("settings_sound")) {
            i.aD(((CheckBoxPreference) preference).isChecked());
            NI();
            return true;
        } else if (str.equals("settings_shake")) {
            i.aE(((CheckBoxPreference) preference).isChecked());
            be.j(this, ((CheckBoxPreference) preference).isChecked());
            return true;
        } else if (str.equals("settings_show_detail")) {
            i.aB(((CheckBoxPreference) preference).isChecked());
            return true;
        } else if (str.equals("settings_notification_ringtone")) {
            startActivity(new Intent(this.nDR.nEl, SettingsRingtoneUI.class));
            return true;
        } else if (str.equals("settings_sns_notify")) {
            boolean z = this.cnm.getBoolean("settings_sns_notify", true);
            ak.yW();
            c.vf().set(68384, Boolean.valueOf(z));
            return true;
        } else if (str.equals("settings_active_time")) {
            startActivity(new Intent(this, SettingsActiveTimeUI.class));
            return true;
        } else {
            if (str.equals("settings_plugings_notify")) {
                List linkedList = new LinkedList();
                linkedList.add(getString(2131235091));
                linkedList.add(getString(2131235092));
                linkedList.add(getString(2131235090));
                Boolean valueOf = Boolean.valueOf(k.yc());
                int yk = k.yk();
                int yl = k.yl();
                int i = valueOf.booleanValue() ? yk == yl ? 0 : 1 : 2;
                v.d("MicroMsg.SettingsNotificationUI", valueOf + "st " + yk + " ed " + yl + "  state " + i);
                ActionBarActivity actionBarActivity = this.nDR.nEl;
                String string = getString(2131235094);
                getString(2131235093);
                g.a(actionBarActivity, string, linkedList, i, new a(this) {
                    final /* synthetic */ SettingsNotificationUI iMx;

                    public final void oI(int i) {
                        if (i != i) {
                            SettingsNotificationUI.pj(i);
                        }
                    }
                });
            }
            return false;
        }
    }

    private boolean fp(boolean z) {
        Preference Ow = this.dxf.Ow("settings_sound");
        Preference Ow2 = this.dxf.Ow("settings_shake");
        Preference Ow3 = this.dxf.Ow("settings_show_detail");
        if (Ow != null) {
            Ow.setEnabled(z);
        }
        if (Ow2 != null) {
            Ow2.setEnabled(z);
        }
        if (Ow3 != null) {
            Ow3.setEnabled(z);
        }
        return true;
    }
}
