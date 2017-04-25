package com.tencent.mm.plugin.voiceprint.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.voiceprint.model.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class SettingsVoicePrintUI extends MMPreference implements e {
    private ProgressDialog dwR = null;
    private f dxf;
    private View fhF;
    private VoiceHeaderPreference kpy;
    private boolean kpz = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131235198);
        ak.vy().a(615, this);
        this.fhF = findViewById(2131758287);
        NI();
        this.fhF.setBackgroundResource(2131690127);
        ak.yW();
        c.vf().a(a.npa, Boolean.valueOf(false));
        ak.yW();
        c.vf().a(a.npb, Boolean.valueOf(false));
        ak.yW();
        c.vf().a(a.npc, Boolean.valueOf(false));
        ak.yW();
        c.vf().a(a.npd, Boolean.valueOf(false));
        v.i("MicroMsg.VoiceSettingsUI", "unset all voiceprint config");
    }

    public void onResume() {
        super.onResume();
        if (this.kpz) {
            this.kpz = false;
            if (this.dwR != null && this.dwR.isShowing()) {
                this.dwR.dismiss();
            }
            ActionBarActivity actionBarActivity = this.nDR.nEl;
            getString(2131231164);
            this.dwR = g.a(actionBarActivity, getString(2131231182), true, new OnCancelListener(this) {
                final /* synthetic */ SettingsVoicePrintUI kpA;

                {
                    this.kpA = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            v.d("MicroMsg.VoiceSettingsUI", "resume after create voiceprint, get switch status");
            ak.vy().a(new i(1), 0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ak.vy().b(615, this);
        if (this.dwR != null) {
            this.dwR.dismiss();
        }
    }

    public final void NI() {
        ak.yW();
        int n = be.n(c.vf().get(40, Integer.valueOf(0)), 0);
        v.i("MicroMsg.VoiceSettingsUI", "plugSwitch " + n + " " + (n & 131072));
        this.dxf = this.ocZ;
        this.kpy = (VoiceHeaderPreference) this.dxf.Ow("settings_voiceprint_header");
        ((CheckBoxPreference) this.dxf.Ow("settings_voiceprint_title")).jx(true);
        this.dxf.notifyDataSetChanged();
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
        }
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        getString(2131231164);
        this.dwR = g.a(actionBarActivity, getString(2131231182), true, new OnCancelListener(this) {
            final /* synthetic */ SettingsVoicePrintUI kpA;

            {
                this.kpA = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        ak.vy().a(new i(0), 0);
        this.dxf.aO("settings_voiceprint_unlock", true);
        this.dxf.aO("settings_voiceprint_reset", true);
        this.dxf.aO("settings_voiceprint_create", true);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsVoicePrintUI kpA;

            {
                this.kpA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kpA.finish();
                return true;
            }
        });
    }

    public final int Oo() {
        return 2131099734;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        Intent intent = new Intent();
        if (str.equals("settings_voiceprint_title")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.Ow("settings_voiceprint_title");
            v.d("MicroMsg.VoiceSettingsUI", "checkPref.isChecked() " + checkBoxPreference.isChecked());
            if (this.dwR != null && this.dwR.isShowing()) {
                this.dwR.dismiss();
            }
            ActionBarActivity actionBarActivity = this.nDR.nEl;
            getString(2131231164);
            this.dwR = g.a(actionBarActivity, getString(2131231182), true, new OnCancelListener(this) {
                final /* synthetic */ SettingsVoicePrintUI kpA;

                {
                    this.kpA = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            if (checkBoxPreference.isChecked()) {
                ak.vy().a(new i(1), 0);
            } else {
                ak.vy().a(new i(2), 0);
            }
            return true;
        } else if (str.equals("settings_voiceprint_unlock")) {
            intent.setClass(this, VoiceUnLockUI.class);
            intent.putExtra("kscene_type", 73);
            startActivity(intent);
            return true;
        } else if (!str.equals("settings_voiceprint_reset")) {
            return false;
        } else {
            intent.setClass(this, VoiceCreateUI.class);
            intent.putExtra("KvoicePrintReset", true);
            intent.putExtra("kscene_type", 73);
            startActivityForResult(intent, 1);
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.VoiceSettingsUI", "onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType())});
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 615) {
                i iVar = (i) kVar;
                if (iVar.mStatus == 1) {
                    int i3;
                    v.d("MicroMsg.VoiceSettingsUI", "voiceprint exist");
                    this.dxf.aO("settings_voiceprint_unlock", false);
                    this.dxf.notifyDataSetChanged();
                    int xL = com.tencent.mm.model.k.xL();
                    CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_voiceprint_title");
                    v.d("MicroMsg.VoiceSettingsUI", "opScene.getSwitch:%d", new Object[]{Integer.valueOf(iVar.koF)});
                    if (iVar.koF > 0) {
                        v.d("MicroMsg.VoiceSettingsUI", "voiceprint open");
                        checkBoxPreference.jx(true);
                        this.dxf.aO("settings_voiceprint_reset", false);
                        this.dxf.aO("settings_voiceprint_unlock", false);
                        i3 = 131072 | xL;
                        this.kpy.cQ(getString(2131235841), "");
                    } else {
                        v.d("MicroMsg.VoiceSettingsUI", "voiceprint close");
                        checkBoxPreference.jx(false);
                        this.dxf.aO("settings_voiceprint_reset", true);
                        this.dxf.aO("settings_voiceprint_unlock", true);
                        i3 = -131073 & xL;
                        this.kpy.cQ(getString(2131235839), "");
                    }
                    v.i("MicroMsg.VoiceSettingsUI", "scene end plugSwitch %d", new Object[]{Integer.valueOf(i3)});
                    ai.cse.J("last_login_use_voice", String.valueOf(i3));
                    ak.yW();
                    c.vf().set(40, Integer.valueOf(i3));
                    this.dxf.aO("settings_voiceprint_create", true);
                    this.dxf.aO("settings_voiceprint_title", false);
                    this.kpy.f(null);
                    this.dxf.notifyDataSetChanged();
                } else {
                    v.d("MicroMsg.VoiceSettingsUI", "voiceprint not exist");
                    com.tencent.mm.plugin.report.service.g.iuh.h(11390, new Object[]{Integer.valueOf(2)});
                    this.dxf.aO("settings_voiceprint_unlock", true);
                    this.dxf.aO("settings_voiceprint_reset", true);
                    this.dxf.aO("settings_voiceprint_create", true);
                    this.dxf.aO("settings_voiceprint_title", true);
                    this.kpy.cQ(getString(2131235843), getString(2131235842));
                    this.kpy.f(new OnClickListener(this) {
                        final /* synthetic */ SettingsVoicePrintUI kpA;

                        {
                            this.kpA = r1;
                        }

                        public final void onClick(View view) {
                            v.i("MicroMsg.VoiceSettingsUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.kpA, "android.permission.RECORD_AUDIO", 80, "", "")), be.bur(), this.kpA});
                            if (com.tencent.mm.pluginsdk.i.a.a(this.kpA, "android.permission.RECORD_AUDIO", 80, "", "")) {
                                this.kpA.bbe();
                            }
                        }
                    });
                    this.dxf.notifyDataSetChanged();
                }
            }
            if (this.dwR != null) {
                this.dwR.dismiss();
                return;
            }
            return;
        }
        this.dxf.aO("settings_voiceprint_unlock", true);
        this.dxf.aO("settings_voiceprint_reset", true);
        this.dxf.aO("settings_voiceprint_create", true);
        ((CheckBoxPreference) this.dxf.Ow("settings_voiceprint_title")).jx(false);
        this.kpy.cQ(getString(2131235839), "");
        this.dxf.notifyDataSetChanged();
        if (this.dwR != null) {
            this.dwR.dismiss();
        }
    }

    private void bbe() {
        com.tencent.mm.plugin.report.service.g.iuh.h(11390, new Object[]{Integer.valueOf(3)});
        Intent intent = new Intent();
        intent.setClass(this, VoiceCreateUI.class);
        intent.putExtra("kscene_type", 71);
        intent.putExtra("createVoicePrint", true);
        startActivityForResult(intent, 1);
        this.kpz = false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && intent != null) {
            this.kpz = intent.getBooleanExtra("KIsCreateSuccess", false);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.VoiceSettingsUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 80:
                if (iArr[0] == 0) {
                    bbe();
                    return;
                } else {
                    g.a(this, getString(2131234163), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsVoicePrintUI kpA;

                        {
                            this.kpA = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.kpA.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsVoicePrintUI kpA;

                        {
                            this.kpA = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
