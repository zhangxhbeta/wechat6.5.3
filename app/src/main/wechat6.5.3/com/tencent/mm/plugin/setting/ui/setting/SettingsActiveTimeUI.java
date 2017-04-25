package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TimePicker;
import com.tencent.mm.h.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.sql.Time;
import java.text.DateFormat;

public class SettingsActiveTimeUI extends MMPreference {
    private boolean aWE = false;
    private f dxf;
    private int iLA;
    private int iLB;
    private int iLC;
    private boolean iLD = false;
    private Preference iLE;
    private Preference iLF;
    private final OnTimeSetListener iLG = new OnTimeSetListener(this) {
        final /* synthetic */ SettingsActiveTimeUI iLH;

        {
            this.iLH = r1;
        }

        public final void onTimeSet(TimePicker timePicker, int i, int i2) {
            if (this.iLH.iLD) {
                this.iLH.iLz = i;
                this.iLH.iLA = i2;
                i.aw(this.iLH.iLz, this.iLH.iLA);
            } else {
                this.iLH.iLB = i;
                this.iLH.iLC = i2;
                i.av(this.iLH.iLB, this.iLH.iLC);
            }
            this.iLH.NI();
        }
    };
    private int iLz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131234971);
        this.dxf = this.ocZ;
        NI();
    }

    protected final void NI() {
        this.dxf.removeAll();
        this.dxf.addPreferencesFromResource(2131099724);
        this.iLF = this.dxf.Ow("settings_active_begin_time");
        this.iLz = i.sA();
        this.iLA = i.sC();
        this.iLF.setSummary(d(this, this.iLz, this.iLA));
        this.iLE = this.dxf.Ow("settings_active_end_time");
        this.iLB = i.sz();
        this.iLC = i.sB();
        this.iLE.setSummary(d(this, this.iLB, this.iLC));
        this.aWE = !i.sy();
        ((CheckBoxPreference) this.dxf.Ow("settings_active_silence_time")).ocf = this.aWE;
        if (this.aWE) {
            this.iLF.setEnabled(true);
            this.iLE.setEnabled(true);
        } else {
            this.iLF.setEnabled(false);
            this.iLE.setEnabled(false);
        }
        if (!this.aWE) {
            this.dxf.b(this.iLF);
            this.dxf.b(this.iLE);
        }
        this.dxf.aO("settings_active_time_full", true);
        this.dxf.notifyDataSetChanged();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsActiveTimeUI iLH;

            {
                this.iLH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iLH.axg();
                this.iLH.finish();
                return true;
            }
        });
    }

    public final int Oo() {
        return 2131099724;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.dnU.equals("settings_active_begin_time")) {
            this.iLD = true;
            showDialog(1);
            return true;
        } else if (preference.dnU.equals("settings_active_end_time")) {
            this.iLD = false;
            showDialog(1);
            return true;
        } else if (!preference.dnU.equals("settings_active_silence_time")) {
            return false;
        } else {
            boolean z;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_active_silence_time");
            if (checkBoxPreference.isChecked()) {
                z = false;
            } else {
                z = true;
            }
            i.aF(z);
            g gVar = g.iuh;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(checkBoxPreference.isChecked() ? 1 : 2);
            gVar.h(11351, objArr);
            NI();
            return true;
        }
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                if (this.iLD) {
                    return new TimePickerDialog(this.nDR.nEl, this.iLG, this.iLz, this.iLA, false);
                }
                return new TimePickerDialog(this.nDR.nEl, this.iLG, this.iLB, this.iLC, false);
            default:
                return null;
        }
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        switch (i) {
            case 1:
                if (this.iLD) {
                    ((TimePickerDialog) dialog).updateTime(this.iLz, this.iLA);
                    return;
                } else {
                    ((TimePickerDialog) dialog).updateTime(this.iLB, this.iLC);
                    return;
                }
            default:
                return;
        }
    }

    private static String d(Context context, int i, int i2) {
        String e = u.e(context.getSharedPreferences(aa.bti(), 0));
        String bsY = u.bsY();
        if (!e.equalsIgnoreCase("zh_CN") && (!e.equalsIgnoreCase("language_default") || !"zh_CN".equalsIgnoreCase(bsY))) {
            return DateFormat.getTimeInstance(3, u.Ke(e)).format(new Time(i, i2, 0));
        }
        int i3;
        if (i > 12) {
            i3 = i - 12;
        } else {
            i3 = i;
        }
        return o.o(context, (((long) i) * 3600000) + (((long) i2) * 60000)) + String.format("%02d:%02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
    }
}
