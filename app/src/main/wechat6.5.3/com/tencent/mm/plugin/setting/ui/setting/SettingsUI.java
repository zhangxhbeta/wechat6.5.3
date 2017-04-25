package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.e.a.dl;
import com.tencent.mm.e.a.hr;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.network.z;
import com.tencent.mm.p.a.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.d;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.v.n;

public class SettingsUI extends MMPreference implements b {
    private ah cSA = null;
    private e daB = null;
    private f dxf;
    private ProgressDialog iKE = null;
    private ah iKF;
    private e iKG = null;
    private PersonalPreference iNi = null;
    private a iNj = new a(this) {
        final /* synthetic */ SettingsUI iNq;

        {
            this.iNq = r1;
        }

        public final void er(int i) {
            if (i == 262145 || i == 262146) {
                this.iNq.aMX();
            }
        }

        public final void es(int i) {
        }

        public final void a(t.a aVar) {
        }
    };
    private Dialog iNk = null;
    private h iNl;
    private View iNm;
    private CheckBox iNn;
    private Dialog iNo = null;
    private e iNp = null;

    static /* synthetic */ void c(SettingsUI settingsUI) {
        Object[] objArr = new Object[1];
        ak.yW();
        objArr[0] = Integer.valueOf(c.ww());
        v.w("MicroMsg.SettingsUI", "dklogout User LOGOUT Now uin:%d , clear cookie", objArr);
        com.tencent.mm.modelstat.c.JW().JX();
        n vy = ak.vy();
        AnonymousClass7 anonymousClass7 = new e(settingsUI) {
            final /* synthetic */ SettingsUI iNq;

            {
                this.iNq = r1;
            }

            public final void a(final int i, final int i2, String str, final k kVar) {
                v.d("MicroMsg.SettingsUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass7 iNr;

                    public final void run() {
                        ak.vy().b(255, this.iNr.iNq.iKG);
                        this.iNr.iNq.iKG = null;
                        if (this.iNr.iNq.iKF != null) {
                            this.iNr.iNq.iKF.QI();
                            this.iNr.iNq.iKF = null;
                        }
                        if (this.iNr.iNq.iKE != null) {
                            this.iNr.iNq.iKE.dismiss();
                        }
                        if (kVar.getType() != 255 || ((com.tencent.mm.modelsimple.t) kVar).cYY != 2) {
                            return;
                        }
                        if (i2 == -3 && i == 4) {
                            Intent intent = new Intent(this.iNr.iNq.nDR.nEl, RegByMobileSetPwdUI.class);
                            intent.putExtra("kintent_hint", this.iNr.iNq.getString(2131234437));
                            this.iNr.iNq.startActivityForResult(intent, 5);
                            return;
                        }
                        SettingsUI.t(this.iNr.iNq);
                    }
                });
            }
        };
        settingsUI.iKG = anonymousClass7;
        vy.a(255, anonymousClass7);
        final com.tencent.mm.modelsimple.t tVar = new com.tencent.mm.modelsimple.t(2);
        tVar.cYY = 2;
        ak.vy().a(tVar, 0);
        settingsUI.iKF = new ah(Looper.getMainLooper(), new ah.a(settingsUI) {
            final /* synthetic */ SettingsUI iNq;

            public final boolean oU() {
                ak.vy().c(tVar);
                ak.vy().b(255, this.iNq.iKG);
                this.iNq.iKG = null;
                if (this.iNq.iKF != null) {
                    this.iNq.iKF.QI();
                    this.iNq.iKF = null;
                }
                if (this.iNq.iKE != null) {
                    this.iNq.iKE.cancel();
                }
                SettingsUI.t(this.iNq);
                return false;
            }
        }, false);
        settingsUI.iKF.ea(12000);
        settingsUI.getString(2131231164);
        settingsUI.iKE = g.a(settingsUI, settingsUI.getString(2131236694), false, new OnCancelListener(settingsUI) {
            final /* synthetic */ SettingsUI iNq;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(tVar);
                ak.vy().b(255, this.iNq.iKG);
                this.iNq.iKG = null;
                if (this.iNq.iKF != null) {
                    this.iNq.iKF.QI();
                    this.iNq.iKF = null;
                }
                if (this.iNq.iKE != null) {
                    this.iNq.iKE.dismiss();
                }
            }
        });
        ai.cse.fG(com.tencent.mm.u.b.r(com.tencent.mm.model.k.xF(), false));
    }

    static /* synthetic */ void f(SettingsUI settingsUI) {
        Object[] objArr = new Object[1];
        ak.yW();
        objArr[0] = Integer.valueOf(c.ww());
        v.w("MicroMsg.SettingsUI", "dklogout User EXIT Now uin:%d", objArr);
        if (settingsUI.iNo != null) {
            settingsUI.iNo.dismiss();
        }
        ak.yW();
        if (c.wC()) {
            n vy = ak.vy();
            AnonymousClass4 anonymousClass4 = new e(settingsUI) {
                final /* synthetic */ SettingsUI iNq;

                {
                    this.iNq = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    ak.vy().b(281, this.iNq.iNp);
                    this.iNq.iNp = null;
                    if (this.iNq.cSA != null) {
                        this.iNq.cSA.QI();
                        this.iNq.cSA = null;
                    }
                    if (this.iNq.iKE != null) {
                        this.iNq.iKE.dismiss();
                    }
                    this.iNq.aNw();
                }
            };
            settingsUI.iNp = anonymousClass4;
            vy.a(281, anonymousClass4);
            final com.tencent.mm.modelsimple.ah ahVar = new com.tencent.mm.modelsimple.ah(2);
            ak.vy().a(ahVar, 0);
            settingsUI.cSA = new ah(new ah.a(settingsUI) {
                final /* synthetic */ SettingsUI iNq;

                public final boolean oU() {
                    ak.vy().c(ahVar);
                    ak.vy().b(281, this.iNq.iNp);
                    this.iNq.iNp = null;
                    if (this.iNq.cSA != null) {
                        this.iNq.cSA.QI();
                        this.iNq.cSA = null;
                    }
                    if (this.iNq.iKE != null) {
                        this.iNq.iKE.dismiss();
                    }
                    this.iNq.aNw();
                    return false;
                }
            }, false);
            settingsUI.cSA.ea(5000);
            ActionBarActivity actionBarActivity = settingsUI.nDR.nEl;
            settingsUI.getString(2131231164);
            settingsUI.iKE = g.a(actionBarActivity, settingsUI.getString(2131236639), true, new OnCancelListener(settingsUI) {
                final /* synthetic */ SettingsUI iNq;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(ahVar);
                    ak.vy().b(281, this.iNq.iNp);
                    this.iNq.iNp = null;
                    if (this.iNq.cSA != null) {
                        this.iNq.cSA.QI();
                        this.iNq.cSA = null;
                    }
                    if (this.iNq.iKE != null) {
                        this.iNq.iKE.dismiss();
                    }
                }
            });
            return;
        }
        settingsUI.aNw();
    }

    static /* synthetic */ void t(SettingsUI settingsUI) {
        ak.yW();
        if (c.wC()) {
            n vy = ak.vy();
            AnonymousClass11 anonymousClass11 = new e(settingsUI) {
                final /* synthetic */ SettingsUI iNq;

                {
                    this.iNq = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass11 iNs;

                        {
                            this.iNs = r1;
                        }

                        public final void run() {
                            ak.vy().b(281, this.iNs.iNq.daB);
                            this.iNs.iNq.daB = null;
                            if (this.iNs.iNq.iKF != null) {
                                this.iNs.iNq.iKF.QI();
                                this.iNs.iNq.iKF = null;
                            }
                            if (this.iNs.iNq.iKE != null) {
                                this.iNs.iNq.iKE.dismiss();
                            }
                            this.iNs.iNq.aNt();
                        }
                    });
                }
            };
            settingsUI.daB = anonymousClass11;
            vy.a(281, anonymousClass11);
            final com.tencent.mm.modelsimple.ah ahVar = new com.tencent.mm.modelsimple.ah(2);
            ak.vy().a(ahVar, 0);
            settingsUI.iKF = new ah(Looper.getMainLooper(), new ah.a(settingsUI) {
                final /* synthetic */ SettingsUI iNq;

                public final boolean oU() {
                    ak.vy().c(ahVar);
                    ak.vy().b(281, this.iNq.daB);
                    this.iNq.daB = null;
                    if (this.iNq.iKF != null) {
                        this.iNq.iKF.QI();
                        this.iNq.iKF = null;
                    }
                    if (this.iNq.iKE != null) {
                        this.iNq.iKE.cancel();
                    }
                    this.iNq.aNt();
                    return false;
                }
            }, false);
            settingsUI.iKF.ea(3000);
            settingsUI.getString(2131231164);
            settingsUI.iKE = g.a(settingsUI, settingsUI.getString(2131236639), true, new OnCancelListener(settingsUI) {
                final /* synthetic */ SettingsUI iNq;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(ahVar);
                    ak.vy().b(281, this.iNq.daB);
                    this.iNq.daB = null;
                    if (this.iNq.iKF != null) {
                        this.iNq.iKF.QI();
                        this.iNq.iKF = null;
                    }
                    if (this.iNq.iKE != null) {
                        this.iNq.iKE.dismiss();
                    }
                }
            });
            return;
        }
        settingsUI.aNt();
    }

    public final int Oo() {
        return 2131099721;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        ak.yW();
        c.vf().a(this);
        com.tencent.mm.p.c.us().a(this.iNj);
        if (be.getInt(j.sU().getValue("VoiceprintEntry"), 0) == 1) {
            ak.yW();
            if ((c.vf().getInt(40, 0) & 131072) == 0) {
                ak.yW();
                c.vf().a(t.a.npa, Boolean.valueOf(false));
                v.i("MicroMsg.SettingsUI", "unset more tab dot");
            }
        }
    }

    protected void onDestroy() {
        if (ak.uz()) {
            ak.yW();
            c.vf().b(this);
            com.tencent.mm.p.c.us().b(this.iNj);
        }
        if (this.daB != null) {
            ak.vy().b(281, this.daB);
        }
        if (this.iKG != null) {
            ak.vy().b(255, this.iKG);
        }
        if (this.iNp != null) {
            ak.vy().b(281, this.iNp);
        }
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        v.v("MicroMsg.SettingsUI", "settings handle");
        Context applicationContext;
        String a;
        switch (i) {
            case 2:
                if (intent != null) {
                    applicationContext = getApplicationContext();
                    ak.yW();
                    a = l.a(applicationContext, intent, c.wP());
                    if (a != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        com.tencent.mm.u.n.AX();
                        intent2.putExtra("CropImage_OutputPath", d.s(com.tencent.mm.model.k.xF(), true));
                        intent2.putExtra("CropImage_ImgPath", a);
                        com.tencent.mm.pluginsdk.h hVar = com.tencent.mm.plugin.setting.a.drp;
                        ak.yW();
                        hVar.a(this, intent, intent2, c.wP(), 4, null);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                applicationContext = getApplicationContext();
                ak.yW();
                a = l.a(applicationContext, intent, c.wP());
                if (a != null) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("CropImageMode", 1);
                    intent3.putExtra("CropImage_OutputPath", a);
                    intent3.putExtra("CropImage_ImgPath", a);
                    com.tencent.mm.plugin.setting.a.drp.a(this.nDR.nEl, intent3, 4);
                    return;
                }
                return;
            case 4:
                if (intent != null) {
                    a = intent.getStringExtra("CropImage_OutputPath");
                    if (a == null) {
                        v.e("MicroMsg.SettingsUI", "crop picture failed");
                    } else {
                        new com.tencent.mm.pluginsdk.model.n(this.nDR.nEl, a).a(1, null);
                    }
                    super.onActivityResult(i, i2, intent);
                    return;
                }
                return;
            case 5:
                if (i2 == -1) {
                    aNt();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onPause() {
        super.onPause();
        ak.vA().A(new Runnable(this) {
            final /* synthetic */ SettingsUI iNq;

            {
                this.iNq = r1;
            }

            public final void run() {
                ak.yW();
                c.vf().iB(true);
            }
        });
    }

    public void onResume() {
        PersonalPreference personalPreference = (PersonalPreference) this.dxf.Ow("settings_account");
        if (personalPreference != null) {
            String xF = com.tencent.mm.model.k.xF();
            personalPreference.cxY = null;
            personalPreference.iJM = -1;
            personalPreference.dFt = xF;
            if (personalPreference.fSv != null) {
                com.tencent.mm.pluginsdk.ui.a.b.m(personalPreference.fSv, personalPreference.dFt);
            }
        }
        if (!com.tencent.mm.af.b.Ha()) {
            this.dxf.b(this.dxf.Ow("settings_like_facebook"));
            this.dxf.b(this.dxf.Ow("settings_follow_twitter"));
        }
        dl dlVar = new dl();
        com.tencent.mm.sdk.c.a.nhr.z(dlVar);
        if (!dlVar.bbx.aZW) {
            this.dxf.b(this.dxf.Ow("settings_about_device"));
        }
        aNr();
        aNs();
        aMX();
        v.v("MicroMsg.SettingsUI", "on resume");
        super.onResume();
    }

    private void aNr() {
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.dxf.Ow("settings_account_info");
        if (iconSwitchKeyValuePreference == null) {
            v.e("MicroMsg.SettingsUI", "safedevicesate preference is null");
            return;
        }
        iconSwitchKeyValuePreference.wL(8);
        ak.yW();
        if (((Integer) c.vf().get(9, Integer.valueOf(0))).intValue() != 0) {
            if (com.tencent.mm.model.k.xN()) {
                iconSwitchKeyValuePreference.setSummary(2131234691);
                iconSwitchKeyValuePreference.wN(1);
            } else {
                iconSwitchKeyValuePreference.setSummary(2131234692);
                iconSwitchKeyValuePreference.wN(2);
            }
            if (be.getInt(j.sU().getValue("VoiceprintEntry"), 0) == 1) {
                ak.yW();
                if (((Boolean) c.vf().get(t.a.npc, Boolean.valueOf(true))).booleanValue()) {
                    ak.yW();
                    if ((c.vf().getInt(40, 0) & 131072) == 0) {
                        iconSwitchKeyValuePreference.aO(getString(2131231102), 2130838762);
                        iconSwitchKeyValuePreference.wG(0);
                        v.i("MicroMsg.SettingsUI", "show voiceprint dot");
                    }
                } else {
                    iconSwitchKeyValuePreference.wG(8);
                }
                this.dxf.notifyDataSetChanged();
            }
        }
    }

    protected final void NI() {
        vD(2131235169);
        this.dxf = this.ocZ;
        Preference Ow = this.dxf.Ow("settings_push_software");
        if (Ow != null) {
            this.dxf.b(Ow);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsUI iNq;

            {
                this.iNq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iNq.finish();
                return true;
            }
        });
        AnonymousClass19 anonymousClass19 = new OnClickListener(this) {
            final /* synthetic */ SettingsUI iNq;

            {
                this.iNq = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.iNq.gMx);
            }
        };
        aNs();
        aMX();
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        int n = be.n(obj, 0);
        v.d("MicroMsg.SettingsUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), jVar});
        ak.yW();
        if (jVar != c.vf() || n <= 0) {
            v.e("MicroMsg.SettingsUI", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), jVar});
            return;
        }
        if (4 == n) {
            ak.yW();
            c.vf().get(2, null);
            ak.yW();
            c.vf().get(4, null);
        }
        if (6 == n) {
            aNs();
        } else if (64 == n) {
            aNr();
        }
    }

    private void aMX() {
        IconPreference iconPreference = (IconPreference) this.dxf.Ow("settings_about_micromsg");
        boolean a = be.a(Boolean.valueOf(com.tencent.mm.p.c.us().ax(262146, 266243)), false);
        boolean a2 = be.a(Boolean.valueOf(com.tencent.mm.p.c.us().ax(262145, 266243)), false);
        if (com.tencent.mm.sdk.platformtools.f.nia || !(a || a2)) {
            iconPreference.aO("", -1);
            iconPreference.wG(8);
            return;
        }
        iconPreference.wG(0);
        iconPreference.aO(getString(2131231102), 2130838762);
    }

    private void aNs() {
        m.a EY = m.EY();
        SwitchKeyValuePreference switchKeyValuePreference = (SwitchKeyValuePreference) this.dxf.Ow("settings_bind_mobile");
        if (switchKeyValuePreference != null) {
            boolean z = EY == m.a.cHR || EY == m.a.cHS;
            switchKeyValuePreference.aZw = z;
            switchKeyValuePreference.av();
            int i = (EY == m.a.cHR || EY == m.a.cHS) ? 2131235098 : 2131235097;
            switchKeyValuePreference.setSummary(i);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        v.i("MicroMsg.SettingsUI", str + " item has been clicked!");
        if ("settings_account_info".equals(str)) {
            if (be.getInt(j.sU().getValue("VoiceprintEntry"), 0) == 1) {
                ak.yW();
                if ((c.vf().getInt(40, 0) & 131072) == 0) {
                    ak.yW();
                    c.vf().a(t.a.npc, Boolean.valueOf(false));
                    v.i("MicroMsg.SettingsUI", "unset setting account info dot show");
                }
            }
            q(SettingsAccountInfoUI.class);
            return true;
        } else if ("settings_account".equals(str)) {
            this.nDR.nEl.startActivity(new Intent(this, SettingsPersonalInfoUI.class));
            return true;
        } else if (str.equals("settings_bind_mobile")) {
            Intent intent = new Intent(this, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 4);
            MMWizardActivity.w(this, intent);
            return true;
        } else if (str.equals("settings_about_privacy")) {
            startActivity(new Intent(this, SettingsPrivacyUI.class));
            return true;
        } else if (str.equals("settings_about_system")) {
            startActivity(new Intent(this, SettingsAboutSystemUI.class));
            return true;
        } else if (str.equals("settings_push_software")) {
            ak.yW();
            str = be.ma((String) c.vf().get(12308, null));
            Intent intent2 = new Intent();
            intent2.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, getString(2131235114));
            intent2.putExtra("rawUrl", str);
            intent2.putExtra("showShare", false);
            com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent2);
            return true;
        } else if (str.equals("settings_about_micromsg")) {
            com.tencent.mm.p.c.us().az(262145, 266243);
            com.tencent.mm.p.c.us().az(262146, 266243);
            this.nDR.nEl.startActivity(new Intent(this, SettingsAboutMicroMsgUI.class));
            new ac().postDelayed(new Runnable(this) {
                final /* synthetic */ SettingsUI iNq;

                {
                    this.iNq = r1;
                }

                public final void run() {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(com.tencent.mm.ui.d.d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                    intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                    this.iNq.sendBroadcast(intent);
                }
            }, 100);
            return true;
        } else if (str.equals("settings_about_device")) {
            com.tencent.mm.ay.c.b(this.nDR.nEl, "exdevice", ".ui.ExdeviceManageDeviceUI", new Intent());
            return true;
        } else if (str.equals("settings_logout")) {
            if (com.tencent.mm.af.b.He()) {
                v.i("MicroMsg.SettingsUI", "oversea user logout");
                g.a(this.nDR.nEl, true, getResources().getString(2131235048), "", getResources().getString(2131235045), getString(2131231010), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ SettingsUI iNq;

                    {
                        this.iNq = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SettingsUI.c(this.iNq);
                    }
                }, null);
                return true;
            }
            com.tencent.mm.plugin.report.service.g.iuh.h(11545, new Object[]{Integer.valueOf(8)});
            v.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCloseEntrance");
            h.a aVar = new h.a(this.nDR.nEl);
            View inflate = View.inflate(this.nDR.nEl, 2130903876, null);
            inflate.findViewById(2131757742).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SettingsUI iNq;

                {
                    this.iNq = r1;
                }

                public final void onClick(View view) {
                    this.iNq.iNo.dismiss();
                    this.iNq.aNu();
                }
            });
            inflate.findViewById(2131757743).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SettingsUI iNq;

                {
                    this.iNq = r1;
                }

                public final void onClick(View view) {
                    this.iNq.iNo.dismiss();
                    this.iNq.aNv();
                }
            });
            aVar.cC(inflate);
            this.iNo = aVar.RX();
            this.iNo.show();
            return true;
        } else if (str.equals("settings_exit")) {
            return aNv();
        } else {
            if (str.equals("settings_logout_option")) {
                return aNu();
            }
            String bsX;
            if (str.equals("settings_like_facebook")) {
                int uQ = ak.uQ();
                bsX = u.bsX();
                bsX = "android.intent.action.VIEW";
                startActivity(new Intent(bsX, Uri.parse(getString(2131235039, new Object[]{Integer.valueOf(uQ)}) + "&countrycode=" + bsX.toUpperCase())));
                return true;
            } else if (str.equals("settings_follow_twitter")) {
                bsX = "android.intent.action.VIEW";
                startActivity(new Intent(bsX, Uri.parse(getString(2131235024, new Object[]{Integer.valueOf(ak.uQ())}))));
                return true;
            } else if (str.equals("settings_notification_preference")) {
                startActivity(new Intent(this, SettingsNotificationUI.class));
                return true;
            } else if (str.equals("settings_chatting")) {
                q(SettingsChattingUI.class);
                return true;
            } else if (str.equals("settings_active_time")) {
                com.tencent.mm.plugin.report.service.g.iuh.h(11351, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                q(SettingsActiveTimeUI.class);
                return true;
            } else if (!str.equals("settings_safe")) {
                return false;
            } else {
                q(SettingsSafeUI.class);
                return true;
            }
        }
    }

    private void aNt() {
        com.tencent.mm.plugin.setting.a.drq.oC();
        ak.yW();
        c.vf().b(this);
        hr hrVar = new hr();
        hrVar.bhA.status = 0;
        hrVar.bhA.bhB = 0;
        com.tencent.mm.sdk.c.a.nhr.z(hrVar);
        com.tencent.mm.e.a.v vVar = new com.tencent.mm.e.a.v();
        vVar.aXi.aXj = true;
        com.tencent.mm.sdk.c.a.nhr.z(vVar);
        ab.Kj("show_whatsnew");
        com.tencent.mm.kernel.h.c(this, true);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Intro_Switch", true);
        com.tencent.mm.plugin.setting.a.drp.t(intent, this.nDR.nEl);
        com.tencent.mm.modelsimple.d.z(this, null);
        finish();
    }

    private boolean aNu() {
        com.tencent.mm.plugin.report.service.g.iuh.h(11545, new Object[]{Integer.valueOf(1)});
        v.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
        if (this.iNk != null) {
            this.iNk.show();
        } else {
            v.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
            this.iNk = g.b(this, getString(2131235048), "", getString(2131235045), getString(2131235047), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SettingsUI iNq;

                {
                    this.iNq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(11545, new Object[]{Integer.valueOf(3)});
                    v.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutConfirm");
                    com.tencent.mm.plugin.report.service.g.iuh.a(99, 145, 1, false);
                    if (!(ak.vy() == null || ak.vy().cAa == null)) {
                        ak.vy().cAa.aU(false);
                    }
                    if (this.iNq.iNk != null) {
                        this.iNq.iNk.dismiss();
                    }
                    SettingsUI.c(this.iNq);
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SettingsUI iNq;

                {
                    this.iNq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(11545, new Object[]{Integer.valueOf(2)});
                    v.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCancel");
                    if (this.iNq.iNk != null) {
                        this.iNq.iNk.dismiss();
                    }
                }
            });
        }
        return true;
    }

    private boolean aNv() {
        com.tencent.mm.plugin.report.service.g.iuh.h(11545, new Object[]{Integer.valueOf(4)});
        v.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseWeChat");
        if (this.iNm == null) {
            this.iNm = View.inflate(this.nDR.nEl, 2130904356, null);
            this.iNn = (CheckBox) this.iNm.findViewById(2131759080);
            this.iNn.setChecked(true);
        }
        if (this.iNl == null) {
            this.iNl = g.a(this.nDR.nEl, null, this.iNm, getString(2131233581), getString(2131231010), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SettingsUI iNq;

                {
                    this.iNq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.modelstat.c.JW().JX();
                    if (this.iNq.iNn == null || !this.iNq.iNn.isChecked()) {
                        v.i("MicroMsg.SettingsUI", "normally exit");
                        com.tencent.mm.plugin.report.service.g.iuh.a(99, 144, 1, false);
                        com.tencent.mm.plugin.report.service.g.iuh.h(11545, new Object[]{Integer.valueOf(7)});
                        v.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithoutNotify");
                        if (!(ak.vy() == null || ak.vy().cAa == null)) {
                            ak.vy().cAa.aU(false);
                        }
                        SettingsUI.f(this.iNq);
                        return;
                    }
                    v.i("MicroMsg.SettingsUI", "push notify mode exit");
                    com.tencent.mm.plugin.report.service.g.iuh.a(99, 143, 1, false);
                    com.tencent.mm.plugin.report.service.g.iuh.h(11545, new Object[]{Integer.valueOf(6)});
                    v.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithNotify");
                    z.Mq().edit().putBoolean("is_in_notify_mode", true).commit();
                    this.iNq.fq(false);
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SettingsUI iNq;

                {
                    this.iNq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(11545, new Object[]{Integer.valueOf(5)});
                    v.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseCancel");
                }
            });
        } else {
            this.iNl.show();
        }
        return true;
    }

    private void fq(boolean z) {
        ab.Kj("welcome_page_show");
        if (z) {
            ak.oH().qv();
        } else {
            ak.oH().k(-1, null);
        }
        com.tencent.mm.e.a.v vVar = new com.tencent.mm.e.a.v();
        vVar.aXi.aXj = false;
        com.tencent.mm.sdk.c.a.nhr.z(vVar);
        com.tencent.mm.plugin.setting.a.drq.oz();
        ak.oH().qs();
        finish();
        if (com.tencent.mm.pluginsdk.j.a.lxI != null) {
            com.tencent.mm.pluginsdk.j.a.lxI.a(this.nDR.nEl, z);
        }
    }

    private void aNw() {
        n vy = ak.vy();
        AnonymousClass15 anonymousClass15 = new e(this) {
            final /* synthetic */ SettingsUI iNq;

            {
                this.iNq = r1;
            }

            public final void a(final int i, final int i2, String str, final k kVar) {
                v.d("MicroMsg.SettingsUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass15 iNt;

                    public final void run() {
                        ak.vy().b(255, this.iNt.iNq.iKG);
                        this.iNt.iNq.iKG = null;
                        if (this.iNt.iNq.iKF != null) {
                            this.iNt.iNq.iKF.QI();
                            this.iNt.iNq.iKF = null;
                        }
                        if (this.iNt.iNq.iKE != null) {
                            this.iNt.iNq.iKE.dismiss();
                        }
                        if (kVar.getType() != 255 || ((com.tencent.mm.modelsimple.t) kVar).cYY != 1) {
                            return;
                        }
                        if (i2 == -3 && i == 4) {
                            Intent intent = new Intent(this.iNt.iNq.nDR.nEl, RegByMobileSetPwdUI.class);
                            intent.putExtra("kintent_hint", this.iNt.iNq.getString(2131234437));
                            this.iNt.iNq.startActivityForResult(intent, 0);
                            return;
                        }
                        this.iNt.iNq.fq(true);
                    }
                });
            }
        };
        this.iKG = anonymousClass15;
        vy.a(255, anonymousClass15);
        final com.tencent.mm.modelsimple.t tVar = new com.tencent.mm.modelsimple.t(2);
        tVar.cYY = 1;
        ak.vy().a(tVar, 0);
        this.iKF = new ah(Looper.getMainLooper(), new ah.a(this) {
            final /* synthetic */ SettingsUI iNq;

            public final boolean oU() {
                ak.vy().c(tVar);
                ak.vy().b(255, this.iNq.iKG);
                this.iNq.iKG = null;
                if (this.iNq.iKF != null) {
                    this.iNq.iKF.QI();
                    this.iNq.iKF = null;
                }
                if (this.iNq.iKE != null) {
                    this.iNq.iKE.cancel();
                }
                this.iNq.fq(true);
                return false;
            }
        }, false);
        this.iKF.ea(3000);
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        getString(2131231164);
        this.iKE = g.a(actionBarActivity, getString(2131236693), false, new OnCancelListener(this) {
            final /* synthetic */ SettingsUI iNq;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(tVar);
                ak.vy().b(255, this.iNq.iKG);
                this.iNq.iKG = null;
                if (this.iNq.iKF != null) {
                    this.iNq.iKF.QI();
                    this.iNq.iKF = null;
                }
                if (this.iNq.iKE != null) {
                    this.iNq.iKE.dismiss();
                }
            }
        });
    }
}
