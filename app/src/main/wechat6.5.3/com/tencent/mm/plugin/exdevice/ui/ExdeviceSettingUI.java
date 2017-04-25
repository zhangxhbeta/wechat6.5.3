package com.tencent.mm.plugin.exdevice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.d.r;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.exdevice.devicestep.StepAwakeAlarmReceiver;
import com.tencent.mm.plugin.exdevice.devicestep.c;
import com.tencent.mm.plugin.exdevice.devicestep.d;
import com.tencent.mm.plugin.exdevice.f.a.n;
import com.tencent.mm.plugin.exdevice.service.ExDeviceService;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class ExdeviceSettingUI extends MMPreference implements e {
    int bkU = -1;
    private CheckBoxPreference fEA;
    private CheckBoxPreference fEB;
    private CheckBoxPreference fEC;
    private boolean fED;
    private boolean fEE;
    private final String fEr = "record_data";
    private final String fEs = "notify_rank";
    private final String fEt = "notify_like";
    private final String fEu = "join_rank";
    private final String fEv = "device_step_detector";
    boolean fEw;
    private ProgressDialog fEx;
    private Preference fEy;
    private CheckBoxPreference fEz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(1044, this);
        this.fEy = this.ocZ.Ow("record_data");
        this.fEz = (CheckBoxPreference) this.ocZ.Ow("notify_rank");
        this.fEA = (CheckBoxPreference) this.ocZ.Ow("notify_like");
        this.fEB = (CheckBoxPreference) this.ocZ.Ow("join_rank");
        this.fEC = (CheckBoxPreference) this.ocZ.Ow("device_step_detector");
        this.ocZ.aO("record_data", true);
        this.ocZ.aO("device_step_detector", true);
        a.a(19, new a.a(this) {
            final /* synthetic */ ExdeviceSettingUI fEF;

            {
                this.fEF = r1;
            }

            public final void run() {
                int aiI = d.aiI();
                if (aiI == 0) {
                    aiI = p.ceL.cfs;
                    if (aiI == 0) {
                        aa.btm();
                        aiI = r.getInt(103, 0);
                    }
                }
                boolean aiD = c.aiD();
                boolean aiC = c.aiC();
                v.i("MicroMsg.ExdeviceSettingUI", "[hakon][Step], stepCounterSwitch:%s.isDeviceNeedStepCounter:%s,hasStepCounterHardware:%s", new Object[]{Integer.valueOf(aiI), Boolean.valueOf(aiD), Boolean.valueOf(aiC)});
            }
        });
        ak.yW();
        Integer num = (Integer) com.tencent.mm.model.c.vf().get(397310, Integer.valueOf(0));
        v.d("MicroMsg.ExdeviceSettingUI", "hy: setting flag: %d", new Object[]{num});
        if (num == null || num.intValue() == 0) {
            this.fEw = false;
            cS(true);
            this.fEz.ocf = true;
            this.fEA.ocf = true;
            this.fEB.ocf = true;
            this.fEC.ocf = true;
            this.ocZ.notifyDataSetChanged();
            this.fEx = com.tencent.mm.ui.base.p.show(this, "", "", true, false);
        } else {
            this.fEw = true;
            this.bkU = num.intValue();
            akA();
        }
        ak.vy().a(new n(2, 0), 0);
        vD(2131234416);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceSettingUI fEF;

            {
                this.fEF = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fEF.finish();
                return false;
            }
        });
    }

    private void cS(boolean z) {
        this.fEE = z;
        v.i("MicroMsg.ExdeviceSettingUI", "update record data : %s.", new Object[]{Boolean.valueOf(this.fEE)});
        this.fEy.setSummary(z ? getString(2131232544) : getString(2131232554));
        this.ocZ.notifyDataSetChanged();
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(1044, this);
        if (this.fEx != null && this.fEx.isShowing()) {
            this.fEx.dismiss();
        }
        if (this.fEw) {
            boolean z;
            if (this.fEz.isChecked()) {
                this.bkU |= 1;
            } else {
                this.bkU &= -2;
            }
            if (this.fEA.isChecked()) {
                this.bkU |= 2;
            } else {
                this.bkU &= -3;
            }
            if (this.fEB.isChecked()) {
                this.bkU |= 8;
            } else {
                this.bkU &= -9;
            }
            if (this.fEC.isChecked()) {
                this.bkU |= 16;
            } else {
                this.bkU &= -17;
            }
            if (this.fEE) {
                this.bkU |= 32;
            } else {
                this.bkU &= -33;
            }
            ak.yW();
            com.tencent.mm.model.c.vf().set(397310, Integer.valueOf(this.bkU));
            if ((this.bkU & 16) == 16) {
                z = true;
            } else {
                z = false;
            }
            c.cJ(z);
            if ((this.bkU & 32) == 32) {
                z = true;
            } else {
                z = false;
            }
            c.cK(z);
            v.d("MicroMsg.ExdeviceSettingUI", "hy: doscene setting flag to %d", new Object[]{Integer.valueOf(this.bkU)});
            ak.vy().a(new n(1, this.bkU), 0);
        }
    }

    public final int Oo() {
        return 2131099692;
    }

    private void akA() {
        boolean z;
        boolean z2 = true;
        cS((this.bkU & 32) == 32);
        CheckBoxPreference checkBoxPreference = this.fEz;
        if ((this.bkU & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        checkBoxPreference.ocf = z;
        checkBoxPreference = this.fEA;
        if ((this.bkU & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        checkBoxPreference.ocf = z;
        checkBoxPreference = this.fEB;
        if ((this.bkU & 8) == 8) {
            z = true;
        } else {
            z = false;
        }
        checkBoxPreference.ocf = z;
        CheckBoxPreference checkBoxPreference2 = this.fEC;
        if ((this.bkU & 16) != 16) {
            z2 = false;
        }
        checkBoxPreference2.ocf = z2;
        this.ocZ.notifyDataSetChanged();
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = true;
        if (i == 0 && i2 == 0) {
            v.d("MicroMsg.ExdeviceSettingUI", "hy: scene end ok");
            n nVar = (n) kVar;
            if (nVar.opType != 2) {
                v.i("MicroMsg.ExdeviceSettingUI", "It isn't a GET_FLAG opType(%d).", new Object[]{Integer.valueOf(nVar.opType)});
                return;
            }
            if (this.fEx != null && this.fEx.isShowing()) {
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceSettingUI fEF;

                    {
                        this.fEF = r1;
                    }

                    public final void run() {
                        this.fEF.fEx.dismiss();
                    }
                });
            }
            this.fEw = true;
            if (this.bkU == nVar.fwG) {
                v.i("MicroMsg.ExdeviceSettingUI", "flag has not changed.(%s)", new Object[]{Integer.valueOf(this.bkU)});
                return;
            }
            boolean z2;
            this.bkU = nVar.fwG;
            v.d("MicroMsg.ExdeviceSettingUI", "hy: onSceneEnd setting flag to %d", new Object[]{Integer.valueOf(this.bkU)});
            ak.yW();
            com.tencent.mm.model.c.vf().set(397310, Integer.valueOf(this.bkU));
            if ((this.bkU & 16) == 16) {
                z2 = true;
            } else {
                z2 = false;
            }
            c.cJ(z2);
            if ((this.bkU & 32) != 32) {
                z = false;
            }
            c.cK(z);
            if (!this.fED) {
                akA();
                return;
            }
            return;
        }
        if (this.fEx != null && this.fEx.isShowing()) {
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceSettingUI fEF;

                {
                    this.fEF = r1;
                }

                public final void run() {
                    this.fEF.fEx.dismiss();
                }
            });
        }
        Toast.makeText(this, "scene error", 0).show();
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        cS(intent.getBooleanExtra("is_record_step_on", this.fEE));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        v.d("MicroMsg.ExdeviceSettingUI", "onPreferenceTreeClick, key is %s.", new Object[]{preference.dnU});
        this.fED = true;
        String str = preference.dnU;
        if ("device_step_detector".equals(str)) {
            boolean isChecked = this.fEC.isChecked();
            c.cJ(isChecked);
            if (isChecked) {
                com.tencent.mm.plugin.exdevice.service.d.bE(aa.getContext());
                StepAwakeAlarmReceiver.ar(aa.getContext());
            } else {
                Context context = aa.getContext();
                Intent intent = new Intent(context, ExDeviceService.class);
                intent.putExtra("step_stop", true);
                context.startService(intent);
                StepAwakeAlarmReceiver.as(aa.getContext());
            }
        } else if ("record_data".equals(str)) {
            Intent intent2 = new Intent(this, ExdeviceRankDataSourceUI.class);
            intent2.putExtra("is_record_step_on", this.fEE);
            startActivityForResult(intent2, 1);
        }
        return false;
    }
}
