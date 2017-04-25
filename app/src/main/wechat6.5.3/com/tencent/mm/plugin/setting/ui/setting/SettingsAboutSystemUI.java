package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Process;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.h.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.rc;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;
import com.tencent.recovery.b;
import java.util.List;

public class SettingsAboutSystemUI extends MMPreference {
    private f dxf;
    private boolean eut = false;
    private ProgressDialog iKE = null;
    private boolean iKM = false;
    private int iKN = -1;
    private int iKO = -1;
    private boolean iKP = false;

    public final int Oo() {
        return 2131099732;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iKM = false;
        NI();
    }

    protected final void NI() {
        vD(2131234967);
        this.dxf = this.ocZ;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAboutSystemUI iKQ;

            {
                this.iKQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iKQ.axg();
                this.iKQ.finish();
                return true;
            }
        });
        this.dxf.aO("settings_swipeback_mode", !d.dW(19));
        if (!c.EH("backup")) {
            this.dxf.aO("settings_bak_chat", true);
        }
        aMX();
        this.dxf.aO("settings_traffic_statistic", c.brh());
        if (q.drg) {
            this.dxf.aO("settings_take_photo", true);
        }
    }

    protected void onResume() {
        super.onResume();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_voice_play_mode");
        if (checkBoxPreference != null) {
            ak.yW();
            checkBoxPreference.ocf = ((Boolean) com.tencent.mm.model.c.vf().get(26, Boolean.valueOf(false))).booleanValue();
            checkBoxPreference.odB = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_enter_button_send");
        if (checkBoxPreference != null) {
            ak.yW();
            checkBoxPreference.ocf = ((Boolean) com.tencent.mm.model.c.vf().get(66832, Boolean.valueOf(false))).booleanValue();
            checkBoxPreference.odB = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_swipeback_mode");
        if (checkBoxPreference != null) {
            checkBoxPreference.ocf = a.sh();
            checkBoxPreference.odB = false;
        }
        Preference Ow = this.dxf.Ow("settings_language");
        if (Ow != null) {
            Ow.setSummary(u.dK(this.nDR.nEl));
        }
        aMX();
        aNa();
        aNa();
        aMZ();
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_nfc_switch");
        if (defaultAdapter == null) {
            this.dxf.aO("settings_nfc_switch", true);
            return;
        }
        this.dxf.aO("settings_nfc_switch", false);
        ak.yW();
        checkBoxPreference.setSummary(be.ma((String) com.tencent.mm.model.c.vf().get(t.a.nqq, null)));
        if (this.iKM) {
            v.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-updateNfcOpenSwitch go setSystemNfc and back");
            if (defaultAdapter.isEnabled()) {
                eH(true);
                fm(true);
                return;
            }
        }
        ak.yW();
        int intValue = ((Integer) com.tencent.mm.model.c.vf().get(t.a.nqm, Integer.valueOf(0))).intValue();
        if (intValue == 0) {
            ak.yW();
            if (((Integer) com.tencent.mm.model.c.vf().get(t.a.nqn, Integer.valueOf(0))).intValue() == 1) {
                fm(true);
            } else {
                fm(false);
            }
        } else if (intValue == 1) {
            fm(true);
        } else {
            fm(false);
        }
        this.dxf.notifyDataSetChanged();
    }

    protected void onDestroy() {
        boolean z = true;
        super.onDestroy();
        if (this.iKP) {
            boolean z2;
            String str = "MicroMsg.SettingsAboutSystemUI";
            String str2 = "kvstat, autodownload sight change: %d, %b";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.iKO);
            if (this.iKN == this.iKO) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            v.i(str, str2, objArr);
            g gVar = g.iuh;
            Object[] objArr2 = new Object[3];
            objArr2[0] = Integer.valueOf(1);
            objArr2[1] = Integer.valueOf(this.iKO);
            if (this.iKN != this.iKO) {
                z = false;
            }
            objArr2[2] = Boolean.valueOf(z);
            gVar.h(11437, objArr2);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        String str = preference.dnU;
        if (str.equals("settings_landscape_mode")) {
            if (this.cnm.getBoolean("settings_landscape_mode", false)) {
                setRequestedOrientation(-1);
                return true;
            }
            setRequestedOrientation(1);
            return true;
        } else if (str.equals("settings_voicerecorder_mode")) {
            if (this.cnm.getBoolean("settings_voicerecorder_mode", p.ceB.cbz != 1)) {
                return true;
            }
            com.tencent.mm.ui.base.g.a(this.nDR.nEl, 2131235206, 2131231164, new OnClickListener(this) {
                final /* synthetic */ SettingsAboutSystemUI iKQ;

                {
                    this.iKQ = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }, new OnClickListener(this) {
                final /* synthetic */ SettingsAboutSystemUI iKQ;

                {
                    this.iKQ = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.iKQ.cnm.edit().putBoolean("settings_voicerecorder_mode", true).commit();
                    ((CheckBoxPreference) this.iKQ.dxf.Ow("settings_voicerecorder_mode")).ocf = true;
                    this.iKQ.dxf.notifyDataSetChanged();
                }
            });
            return true;
        } else if (str.equals("settings_nfc_switch")) {
            NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
            if (defaultAdapter == null) {
                v.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch phone not suppot nfc");
                return true;
            }
            ak.yW();
            r2 = ((Integer) com.tencent.mm.model.c.vf().get(t.a.nqm, Integer.valueOf(0))).intValue();
            ak.yW();
            int intValue = ((Integer) com.tencent.mm.model.c.vf().get(t.a.nqn, Integer.valueOf(0))).intValue();
            if ((r2 == 2 || (r2 == 0 && intValue != 1)) && !defaultAdapter.isEnabled() && this.cnm.getBoolean("settings_nfc_switch", false)) {
                fm(false);
                com.tencent.mm.ui.base.g.b(this.nDR.nEl, getString(2131234036), "", getString(2131234037), getString(2131231010), new OnClickListener(this) {
                    final /* synthetic */ SettingsAboutSystemUI iKQ;

                    {
                        this.iKQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        v.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch user go set system nfc switch");
                        this.iKQ.iKM = true;
                        this.iKQ.startActivity(new Intent("android.settings.NFC_SETTINGS"));
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ SettingsAboutSystemUI iKQ;

                    {
                        this.iKQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        v.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch user cancel go set system nfc switch");
                    }
                });
                return true;
            }
            eH(this.cnm.getBoolean("settings_nfc_switch", false));
            return true;
        } else if (str.equals("settings_voice_play_mode")) {
            ak.yW();
            r1 = ((Boolean) com.tencent.mm.model.c.vf().get(26, Boolean.valueOf(false))).booleanValue();
            String str2 = "MicroMsg.SettingsAboutSystemUI";
            String str3 = "set voice mode from %B to %B";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(r1);
            objArr[1] = Boolean.valueOf(!r1);
            v.d(str2, str3, objArr);
            ak.yW();
            r vf = com.tencent.mm.model.c.vf();
            if (!r1) {
                z = true;
            }
            vf.set(26, Boolean.valueOf(z));
            return true;
        } else if (str.equals("settings_enter_button_send")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_enter_button_send");
            if (checkBoxPreference == null) {
                return true;
            }
            v.d("MicroMsg.SettingsAboutSystemUI", "set enter button send : %s", new Object[]{Boolean.valueOf(checkBoxPreference.isChecked())});
            ak.yW();
            com.tencent.mm.model.c.vf().set(66832, Boolean.valueOf(r0));
            return true;
        } else if (str.equals("settings_sns_sight_auto_download")) {
            r9 = new h.a(this.nDR.nEl);
            r9.wq(2131231010);
            r9.wm(2131235157);
            View inflate = View.inflate(this.nDR.nEl, 2130903970, null);
            r1 = (LinearLayout) inflate.findViewById(2131758212);
            r2 = be.getInt(j.sU().getValue("SIGHTAutoLoadNetwork"), 1);
            ak.yW();
            final int a = be.a((Integer) com.tencent.mm.model.c.vf().get(327686, null), r2);
            r5 = new View.OnClickListener(this) {
                final /* synthetic */ SettingsAboutSystemUI iKQ;

                public final void onClick(View view) {
                    for (int i = 0; i < r1.getChildCount(); i++) {
                        TextView textView = (TextView) r1.getChildAt(i);
                        if (2131757003 != textView.getId()) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(2131165881, 0, 0, 0);
                        }
                    }
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(2131165878, 0, 0, 0);
                    final int intValue = ((Integer) view.getTag()).intValue();
                    v.i("MicroMsg.SettingsAboutSystemUI", "choice: %d, %d", new Object[]{Integer.valueOf(a), Integer.valueOf(intValue)});
                    if (a != intValue) {
                        view.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 iKU;

                            public final void run() {
                                ((Dialog) r1.getTag()).dismiss();
                                ak.yW();
                                com.tencent.mm.model.c.vf().set(327686, Integer.valueOf(intValue));
                                ak.yW();
                                com.tencent.mm.model.c.vf().iB(true);
                                this.iKU.iKQ.aNa();
                            }
                        });
                    }
                }
            };
            a(r1, 2131235155, 1, 1 == a, r5);
            a(r1, 2131235158, 2, 2 == a, r5);
            a(r1, 2131235156, 3, 3 == a, r5);
            r9.cC(inflate);
            r0 = r9.RX();
            r1.setTag(r0);
            r0.show();
            a(r0);
            this.iKP = true;
            return true;
        } else if (str.equals("settings_silence_update_mode")) {
            r9 = new h.a(this.nDR.nEl);
            r9.wq(2131231010);
            r9.wm(2131235145);
            View inflate2 = View.inflate(this.nDR.nEl, 2130903970, null);
            r1 = (LinearLayout) inflate2.findViewById(2131758212);
            r5 = new View.OnClickListener(this) {
                final /* synthetic */ SettingsAboutSystemUI iKQ;

                public final void onClick(View view) {
                    int i;
                    int i2;
                    int i3 = 0;
                    for (i = 0; i < r1.getChildCount(); i++) {
                        TextView textView = (TextView) r1.getChildAt(i);
                        if (2131757003 != textView.getId()) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(2131165881, 0, 0, 0);
                        }
                    }
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(2131165878, 0, 0, 0);
                    ak.yW();
                    int intValue = ((Integer) com.tencent.mm.model.c.vf().get(7, Integer.valueOf(0))).intValue();
                    int intValue2 = ((Integer) view.getTag()).intValue();
                    v.d("MicroMsg.SettingsAboutSystemUI", "settings_silence_update_mode choice: %d", new Object[]{Integer.valueOf(intValue2)});
                    if (intValue2 == 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if ((intValue & 16777216) == 0) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i != i2) {
                        if (intValue2 == 0) {
                            i3 = 1;
                        }
                        if (i3 != 0) {
                            i = -16777217 & intValue;
                        } else {
                            i = intValue | 16777216;
                        }
                        i2 = i3 == 0 ? 1 : 2;
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(7, Integer.valueOf(i));
                        rc rcVar = new rc();
                        rcVar.muR = 35;
                        rcVar.muS = i2;
                        ak.yW();
                        com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.j.a(23, rcVar));
                        com.tencent.mm.plugin.setting.a.drq.ow();
                        view.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass10 iKZ;

                            {
                                this.iKZ = r1;
                            }

                            public final void run() {
                                ((Dialog) r1.getTag()).dismiss();
                                this.iKZ.iKQ.aMZ();
                            }
                        });
                    }
                }
            };
            ak.yW();
            boolean z2 = (((Integer) com.tencent.mm.model.c.vf().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0;
            a(r1, 2131235147, 0, z2, r5);
            a(r1, 2131235146, 1, !z2, r5);
            r9.cC(inflate2);
            r0 = r9.RX();
            r1.setTag(r0);
            r0.show();
            a(r0);
            return true;
        } else if (str.equals("settings_language")) {
            startActivity(new Intent(this.nDR.nEl, SettingsLanguageUI.class));
            return true;
        } else if (str.equals("settings_text_size")) {
            return aMY();
        } else {
            Intent intent;
            if (str.equals("settings_chatting_bg")) {
                intent = new Intent();
                intent.setClass(this, SettingsChattingBackgroundUI.class);
                this.nDR.nEl.startActivity(intent);
                return true;
            } else if (str.equals("settings_plugins")) {
                ak.yW();
                com.tencent.mm.model.c.vf().set(-2046825377, Boolean.valueOf(false));
                intent = new Intent();
                intent.setClass(this, SettingsPluginsUI.class);
                startActivity(intent);
                return true;
            } else if (str.equals("settings_reset")) {
                com.tencent.mm.ui.base.g.b(this.nDR.nEl, getResources().getString(2131235125), "", getString(2131231012), getString(2131231010), new OnClickListener(this) {
                    final /* synthetic */ SettingsAboutSystemUI iKQ;

                    {
                        this.iKQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.iKQ.eut = false;
                        SettingsAboutSystemUI settingsAboutSystemUI = this.iKQ;
                        SettingsAboutSystemUI settingsAboutSystemUI2 = this.iKQ;
                        this.iKQ.getString(2131231164);
                        settingsAboutSystemUI.iKE = com.tencent.mm.ui.base.g.a(settingsAboutSystemUI2, this.iKQ.getString(2131231182), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass5 iKY;

                            {
                                this.iKY = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                this.iKY.iKQ.eut = true;
                            }
                        });
                        ak.yW();
                        List bvK = com.tencent.mm.model.c.wK().bvK();
                        if (bvK.size() > 0) {
                            List s = com.tencent.mm.model.h.s(bvK);
                            if (s != null) {
                                for (int i2 = 0; i2 < s.size(); i2++) {
                                    if (((Boolean) s.get(i2)).booleanValue()) {
                                        com.tencent.mm.plugin.setting.a.drq.bq((String) bvK.get(i2));
                                    }
                                }
                            }
                        }
                        aw.a(new aw.a(this) {
                            final /* synthetic */ AnonymousClass5 iKY;

                            {
                                this.iKY = r1;
                            }

                            public final boolean zp() {
                                return this.iKY.iKQ.eut;
                            }

                            public final void zo() {
                                if (this.iKY.iKQ.iKE != null) {
                                    this.iKY.iKQ.iKE.dismiss();
                                    this.iKY.iKQ.iKE = null;
                                }
                            }
                        });
                    }
                }, null);
                return true;
            } else if (str.equals("settings_emoji_manager")) {
                intent = new Intent();
                intent.putExtra("10931", 2);
                c.b(this.nDR.nEl, "emoji", ".ui.EmojiMineUI", intent);
                return true;
            } else if (str.equals("settngs_clean")) {
                ak.yW();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    c.b(this.nDR.nEl, "clean", ".ui.CleanUI", new Intent());
                    return true;
                }
                s.ey(this.nDR.nEl);
                return true;
            } else if (str.equals("settings_traffic_statistic")) {
                startActivity(new Intent(this, SettingsNetStatUI.class));
                return true;
            } else if (str.equals("settings_text_size")) {
                return aMY();
            } else {
                if (str.equals("settings_swipeback_mode")) {
                    final CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) preference;
                    r1 = a.sh();
                    com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(!r1 ? 2131235161 : 2131235160), null, new OnClickListener(this) {
                        final /* synthetic */ SettingsAboutSystemUI iKQ;

                        {
                            this.iKQ = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            a.az(!a.sh());
                            ak.release();
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass3 iKV;

                                {
                                    this.iKV = r1;
                                }

                                public final void run() {
                                    int myPid = Process.myPid();
                                    b.yH(13);
                                    Process.killProcess(myPid);
                                }
                            });
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ SettingsAboutSystemUI iKQ;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            checkBoxPreference2.ocf = r1;
                            this.iKQ.dxf.notifyDataSetChanged();
                        }
                    });
                    return true;
                }
                if (str.equals("settings_take_photo")) {
                    startActivity(new Intent(this, SettingsAboutCamera.class));
                }
                return false;
            }
        }
    }

    private void aMX() {
        ak.yW();
        IconPreference iconPreference = (IconPreference) this.dxf.Ow("settings_plugins");
        if (be.a((Boolean) com.tencent.mm.model.c.vf().get(-2046825377, null), false)) {
            iconPreference.wG(0);
            iconPreference.aO(getString(2131231102), 2130838762);
        } else {
            iconPreference.wG(8);
            iconPreference.aO("", -1);
        }
        this.dxf.notifyDataSetChanged();
    }

    private boolean aMY() {
        startActivity(new Intent(this, SettingsFontUI.class));
        return true;
    }

    private void eH(boolean z) {
        if (z) {
            getPackageManager().setComponentEnabledSetting(new ComponentName(aa.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
            ak.yW();
            com.tencent.mm.model.c.vf().a(t.a.nqm, Integer.valueOf(1));
            return;
        }
        getPackageManager().setComponentEnabledSetting(new ComponentName(aa.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
        ak.yW();
        com.tencent.mm.model.c.vf().a(t.a.nqm, Integer.valueOf(2));
    }

    private void fm(boolean z) {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("settings_nfc_switch");
        aa.getContext().getSharedPreferences(aa.bti(), 0).edit().putBoolean("settings_nfc_switch", z).commit();
        checkBoxPreference.ocf = z;
        this.dxf.notifyDataSetChanged();
    }

    private void aMZ() {
        boolean z = true;
        boolean z2 = be.KL(j.sU().getValue("SilentDownloadApkAtWiFi")) != 0;
        if ((com.tencent.mm.sdk.platformtools.f.aPY & 1) != 0) {
            v.d("MicroMsg.SettingsAboutSystemUI", "channel pack, not silence download.");
            z2 = true;
        }
        if (z2) {
            this.dxf.aO("settings_silence_update_mode", true);
            return;
        }
        this.dxf.aO("settings_silence_update_mode", false);
        ak.yW();
        if ((((Integer) com.tencent.mm.model.c.vf().get(7, Integer.valueOf(0))).intValue() & 16777216) != 0) {
            z = false;
        }
        this.dxf.Ow("settings_silence_update_mode").setSummary(getString(z ? 2131235147 : 2131235146));
        this.dxf.notifyDataSetChanged();
    }

    private void a(LinearLayout linearLayout, int i, int i2, boolean z, View.OnClickListener onClickListener) {
        TextView textView = (TextView) View.inflate(this.nDR.nEl, 2130904220, null);
        textView.setText(i);
        textView.setTag(Integer.valueOf(i2));
        linearLayout.addView(textView);
        textView.setOnClickListener(onClickListener);
        if (z) {
            textView.setCompoundDrawablesWithIntrinsicBounds(2131165878, 0, 0, 0);
        }
    }

    private void aNa() {
        int i = be.getInt(j.sU().getValue("SIGHTAutoLoadNetwork"), 1);
        ak.yW();
        int a = be.a((Integer) com.tencent.mm.model.c.vf().get(327686, null), i);
        v.i("MicroMsg.SettingsAboutSystemUI", "auto getSightViewSummary %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(a)});
        if (this.iKN == -1) {
            this.iKN = a;
        }
        this.iKO = a;
        if (3 == a) {
            a = 2131235156;
        } else if (2 == a) {
            a = 2131235158;
        } else {
            a = 2131235155;
        }
        Preference Ow = this.dxf.Ow("settings_sns_sight_auto_download");
        if (Ow != null) {
            Ow.setSummary(getString(a));
        }
        this.dxf.notifyDataSetChanged();
    }
}
