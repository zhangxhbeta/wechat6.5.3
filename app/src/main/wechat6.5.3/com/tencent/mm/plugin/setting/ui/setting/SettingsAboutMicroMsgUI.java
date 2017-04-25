package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.j.ae;
import com.tencent.mm.pluginsdk.j.ai;
import com.tencent.mm.protocal.c.zv;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSummaryPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.v.n;

public class SettingsAboutMicroMsgUI extends MMPreference implements e {
    private f dxf;
    private boolean iKA = false;
    private zv iKB;
    private int iKC = 0;
    Intent iKD = null;
    private ProgressDialog iKE;
    private ah iKF;
    private e iKG = null;
    private boolean iKz = false;

    static /* synthetic */ void b(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        n vy = ak.vy();
        AnonymousClass3 anonymousClass3 = new e(settingsAboutMicroMsgUI) {
            final /* synthetic */ SettingsAboutMicroMsgUI iKH;

            {
                this.iKH = r1;
            }

            public final void a(final int i, final int i2, String str, final k kVar) {
                v.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 iKK;

                    public final void run() {
                        ak.vy().b(255, this.iKK.iKH.iKG);
                        this.iKK.iKH.iKG = null;
                        if (this.iKK.iKH.iKF != null) {
                            this.iKK.iKH.iKF.QI();
                            this.iKK.iKH.iKF = null;
                        }
                        if (this.iKK.iKH.iKE != null) {
                            this.iKK.iKH.iKE.dismiss();
                        }
                        if (kVar.getType() != 255 || ((t) kVar).cYY != 1) {
                            return;
                        }
                        if (i2 == -3 && i == 4) {
                            Intent intent = new Intent(this.iKK.iKH.nDR.nEl, RegByMobileSetPwdUI.class);
                            intent.putExtra("kintent_hint", this.iKK.iKH.getString(2131234437));
                            this.iKK.iKH.startActivityForResult(intent, 0);
                            return;
                        }
                        SettingsAboutMicroMsgUI.g(this.iKK.iKH);
                    }
                });
            }
        };
        settingsAboutMicroMsgUI.iKG = anonymousClass3;
        vy.a(255, anonymousClass3);
        final t tVar = new t(2);
        tVar.cYY = 1;
        ak.vy().a(tVar, 0);
        settingsAboutMicroMsgUI.iKF = new ah(Looper.getMainLooper(), new a(settingsAboutMicroMsgUI) {
            final /* synthetic */ SettingsAboutMicroMsgUI iKH;

            public final boolean oU() {
                ak.vy().c(tVar);
                ak.vy().b(255, this.iKH.iKG);
                this.iKH.iKG = null;
                if (this.iKH.iKF != null) {
                    this.iKH.iKF.QI();
                    this.iKH.iKF = null;
                }
                if (this.iKH.iKE != null) {
                    this.iKH.iKE.cancel();
                }
                SettingsAboutMicroMsgUI.g(this.iKH);
                return false;
            }
        }, false);
        settingsAboutMicroMsgUI.iKF.ea(3000);
        ActionBarActivity actionBarActivity = settingsAboutMicroMsgUI.nDR.nEl;
        settingsAboutMicroMsgUI.getString(2131231164);
        settingsAboutMicroMsgUI.iKE = g.a(actionBarActivity, settingsAboutMicroMsgUI.getString(2131236693), false, new OnCancelListener(settingsAboutMicroMsgUI) {
            final /* synthetic */ SettingsAboutMicroMsgUI iKH;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(tVar);
                ak.vy().b(255, this.iKH.iKG);
                this.iKH.iKG = null;
                if (this.iKH.iKF != null) {
                    this.iKH.iKF.QI();
                    this.iKH.iKF = null;
                }
                if (this.iKH.iKE != null) {
                    this.iKH.iKE.dismiss();
                }
            }
        });
    }

    static /* synthetic */ void g(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        ab.Kj("welcome_page_show");
        h.c(settingsAboutMicroMsgUI, true);
        com.tencent.mm.plugin.setting.a.drq.oz();
        ak.oH().qs();
        j.a.lxI.ai(settingsAboutMicroMsgUI.nDR.nEl);
        settingsAboutMicroMsgUI.finish();
    }

    public final int Oo() {
        return 2131099722;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.yW();
        if (c.ww() != 0) {
            this.iKz = com.tencent.mm.p.c.us().uq();
        } else {
            v.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBandage() uin not ready!");
        }
        NI();
        ak.vy().a(11, this);
        if (ai.bmA() != null) {
            ak.vy().a((k) ai.bmA().aKO(), 0);
            com.tencent.mm.plugin.report.service.g.iuh.a(405, 15, 1, true);
        }
    }

    public void onResume() {
        super.onResume();
        ak.yW();
        if (c.ww() != 0) {
            this.iKz = com.tencent.mm.p.c.us().uq();
        } else {
            v.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBandage() uin not ready!");
        }
        aMV();
    }

    public void onDestroy() {
        ak.vy().b(11, this);
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131235209);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAboutMicroMsgUI iKH;

            {
                this.iKH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iKH.axg();
                this.iKH.finish();
                return true;
            }
        });
        aMV();
    }

    private void aMV() {
        boolean z;
        this.dxf = this.ocZ;
        this.dxf.removeAll();
        this.dxf.addPreferencesFromResource(2131099722);
        SettingsAboutMMHeaderPreference settingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference) this.dxf.Ow("settings_about_mm_header");
        String S = com.tencent.mm.sdk.platformtools.f.S(this.nDR.nEl, d.lWh);
        if (d.lWk) {
            S = S + " " + getString(2131230892);
        }
        settingsAboutMMHeaderPreference.iKw = S;
        if (com.tencent.mm.sdk.platformtools.f.nia) {
            this.dxf.aO("settings_update", true);
            this.dxf.aO("settings_system_notice", true);
        }
        IconPreference iconPreference = (IconPreference) this.dxf.Ow("settings_update");
        if (this.iKz) {
            iconPreference.wG(0);
            iconPreference.aO(getString(2131231102), 2130838762);
        } else {
            iconPreference.aO("", -1);
            iconPreference.wG(8);
        }
        ak.yW();
        int f = be.f((Integer) c.vf().get(12304, null));
        iconPreference = (IconPreference) this.dxf.Ow("settings_system_notice");
        if (f > 0) {
            iconPreference.wG(0);
            iconPreference.aO(String.valueOf(f), s.eN(this.nDR.nEl));
        } else {
            iconPreference.wG(8);
            iconPreference.aO("", -1);
        }
        if (!u.bsV()) {
            this.dxf.aO("settings_system_notice", true);
        }
        if ((com.tencent.mm.sdk.platformtools.f.aPY & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        IconSummaryPreference iconSummaryPreference;
        if (this.iKA && !com.tencent.mm.sdk.platformtools.f.nia) {
            iconSummaryPreference = (IconSummaryPreference) this.dxf.Ow("funtion_update");
            iconSummaryPreference.fgx = 0;
            CharSequence S2 = com.tencent.mm.sdk.platformtools.f.S(null, this.iKC);
            iconSummaryPreference.Oz(getString(2131231102));
            iconSummaryPreference.setSummary(S2);
            iconSummaryPreference.ocF = 0;
            if (iconSummaryPreference.ocG != null) {
                iconSummaryPreference.ocG.setVisibility(iconSummaryPreference.ocF);
            }
            this.dxf.Ox("funtion_check_update");
        } else if (z || this.iKB == null || this.iKB.mBq == 0 || be.kS(this.iKB.mBr) || com.tencent.mm.sdk.platformtools.f.nia) {
            this.dxf.Ox("funtion_update");
        } else {
            v.i("MicroMsg.SettingsAboutMicroMsgUI", "show alpha update. url:%s, hint:%d", new Object[]{this.iKB.mBr, Integer.valueOf(this.iKB.mBs)});
            if (this.iKB.mBs != 0) {
                iconSummaryPreference = (IconSummaryPreference) this.dxf.Ow("funtion_update");
                iconSummaryPreference.fgx = 0;
                iconSummaryPreference.Oz(getString(2131231102));
                this.dxf.Ox("funtion_check_update");
            } else {
                this.dxf.Ox("funtion_update");
            }
        }
        Preference Ow = this.dxf.Ow("settings_market_ratings");
        if (Ow != null) {
            this.iKD = new Intent("android.intent.action.VIEW", Uri.parse(com.tencent.mm.sdk.platformtools.f.nhW));
            if (this.iKD == null || !be.m(this, this.iKD)) {
                v.d("MicroMsg.SettingsAboutMicroMsgUI", "removePreference settings_market_ratings :" + this.dxf.b(Ow) + " :" + Ow.getSummary());
            }
        }
        if (!u.bsV()) {
            this.dxf.aO("settings_report", true);
        }
        if (!j.a.lxI.oO()) {
            this.dxf.aO("funtion_about_wechat", true);
        }
        this.dxf.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        v.i("MicroMsg.SettingsAboutMicroMsgUI", str + " item has been clicked!");
        Intent intent;
        if (str.equals("settings_update")) {
            ak.yW();
            if (c.ww() != 0) {
                com.tencent.mm.p.c.us().s(262146, false);
            } else {
                v.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBandage() uin not ready!");
            }
            str = getString(2131235025, new Object[]{u.bsY(), Integer.valueOf(d.lWh)});
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
            return true;
        } else if (str.equals("funtion_update")) {
            com.tencent.mm.plugin.report.service.g.iuh.a(405, 16, 1, true);
            str = "";
            if (this.iKA) {
                str = getString(2131235026, new Object[]{u.bsY(), Integer.valueOf(this.iKC)});
            } else if (!(this.iKB == null || this.iKB.mBq == 0 || be.kS(this.iKB.mBr))) {
                str = this.iKB.mBr;
            }
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", true);
            intent.putExtra("show_bottom", false);
            com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
            return true;
        } else if (str.equals("funtion_check_update")) {
            com.tencent.mm.plugin.report.service.g.iuh.a(405, 17, 1, true);
            if (ai.bmA() != null) {
                ai.bmA().aKN();
                if ((com.tencent.mm.sdk.platformtools.f.aPY & 1) != 0) {
                    v.e("MicroMsg.SettingsAboutMicroMsgUI", "package has set external update mode");
                    Uri parse = Uri.parse(com.tencent.mm.sdk.platformtools.f.nhW);
                    intent = new Intent("android.intent.action.VIEW", parse).addFlags(268435456);
                    if (parse == null || intent == null || !be.m(this.nDR.nEl, intent)) {
                        v.e("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri failed, jump to weixin.qq.com");
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456));
                        com.tencent.mm.plugin.report.service.g.iuh.a(405, 18, 1, true);
                        return true;
                    }
                    v.i("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri ok");
                    startActivity(intent);
                    com.tencent.mm.plugin.report.service.g.iuh.a(405, 19, 1, true);
                    return true;
                } else if (this.iKB == null || this.iKB.mBq == 0 || be.kS(this.iKB.mBr)) {
                    aa.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", be.Nh()).commit();
                    j.ad a = ai.bmA().a(this, new OnCancelListener(this) {
                        final /* synthetic */ SettingsAboutMicroMsgUI iKH;

                        {
                            this.iKH = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.plugin.report.service.g.iuh.a(405, 23, 1, true);
                        }
                    });
                    if (a == null) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(405, 21, 1, true);
                    } else {
                        com.tencent.mm.plugin.report.service.g.iuh.a(405, 22, 1, true);
                        a.update(3);
                        return true;
                    }
                } else {
                    str = this.iKB.mBr;
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                    com.tencent.mm.plugin.report.service.g.iuh.a(405, 20, 1, true);
                    return true;
                }
            }
            return false;
        } else if (str.equals("funtion_about_wechat")) {
            com.tencent.mm.ay.c.b(this, "whatsnew", ".ui.WhatsNewUI", new Intent());
            return true;
        } else if (str.equals("settings_market_ratings")) {
            return aMW();
        } else {
            if (str.equals("settings_system_notice")) {
                int uQ = ak.uQ();
                ak.yW();
                int f = be.f((Integer) c.vf().get(12304, null));
                str = getString(2131235163, new Object[]{Integer.valueOf(uQ), Integer.valueOf(f)});
                if (str == null) {
                    return true;
                }
                ak.yW();
                c.vf().set(12304, Integer.valueOf(0));
                intent = new Intent();
                intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, getString(2131235162));
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                return true;
            } else if (str.equals("settings_feedback")) {
                str = (com.tencent.mm.sdk.platformtools.f.nia || !u.bsY().equals("zh_CN")) ? u.bsY().equals("zh_HK") ? getString(2131236648) : u.bsY().equals("zh_TW") ? getString(2131236649) : getString(2131236650) : getString(2131236647);
                v.d("MicroMsg.SettingsAboutMicroMsgUI", "using faq webpage");
                intent = new Intent();
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", str);
                intent.putExtra("show_feedback", false);
                com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                return true;
            } else if (str.equals("settings_report")) {
                intent = new Intent();
                intent.putExtra("showShare", false);
                intent.putExtra("show_feedback", false);
                intent.putExtra("rawUrl", "https://support.weixin.qq.com/security/readtemplate?t=complaints/index");
                com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                return true;
            } else if (!str.equals("settings_quit_wechat")) {
                return false;
            } else {
                g.a(this.nDR.nEl, 2131233720, 2131233719, 2131231183, 2131231104, new OnClickListener(this) {
                    private ah cSA = null;
                    private e daB = null;
                    final /* synthetic */ SettingsAboutMicroMsgUI iKH;

                    {
                        this.iKH = r2;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.modelstat.c.JW().JX();
                        ak.yW();
                        if (c.wC()) {
                            n vy = ak.vy();
                            AnonymousClass1 anonymousClass1 = new e(this) {
                                final /* synthetic */ AnonymousClass2 iKI;

                                {
                                    this.iKI = r1;
                                }

                                public final void a(int i, int i2, String str, k kVar) {
                                    ak.vy().b(281, this.iKI.daB);
                                    this.iKI.daB = null;
                                    if (this.iKI.cSA != null) {
                                        this.iKI.cSA.QI();
                                        this.iKI.cSA = null;
                                    }
                                    if (this.iKI.iKH.iKE != null) {
                                        this.iKI.iKH.iKE.dismiss();
                                    }
                                    SettingsAboutMicroMsgUI.b(this.iKI.iKH);
                                }
                            };
                            this.daB = anonymousClass1;
                            vy.a(281, anonymousClass1);
                            final com.tencent.mm.modelsimple.ah ahVar = new com.tencent.mm.modelsimple.ah(2);
                            ak.vy().a(ahVar, 0);
                            this.cSA = new ah(new a(this) {
                                final /* synthetic */ AnonymousClass2 iKI;

                                public final boolean oU() {
                                    ak.vy().c(ahVar);
                                    ak.vy().b(281, this.iKI.daB);
                                    this.iKI.daB = null;
                                    if (this.iKI.cSA != null) {
                                        this.iKI.cSA.QI();
                                        this.iKI.cSA = null;
                                    }
                                    if (this.iKI.iKH.iKE != null) {
                                        this.iKI.iKH.iKE.dismiss();
                                    }
                                    SettingsAboutMicroMsgUI.b(this.iKI.iKH);
                                    return false;
                                }
                            }, false);
                            this.cSA.ea(5000);
                            SettingsAboutMicroMsgUI settingsAboutMicroMsgUI = this.iKH;
                            ActionBarActivity actionBarActivity = this.iKH.nDR.nEl;
                            this.iKH.getString(2131231164);
                            settingsAboutMicroMsgUI.iKE = g.a(actionBarActivity, this.iKH.getString(2131236639), true, new OnCancelListener(this) {
                                final /* synthetic */ AnonymousClass2 iKI;

                                public final void onCancel(DialogInterface dialogInterface) {
                                    ak.vy().c(ahVar);
                                    ak.vy().b(281, this.iKI.daB);
                                    this.iKI.daB = null;
                                    if (this.iKI.cSA != null) {
                                        this.iKI.cSA.QI();
                                        this.iKI.cSA = null;
                                    }
                                    if (this.iKI.iKH.iKE != null) {
                                        this.iKI.iKH.iKE.dismiss();
                                    }
                                }
                            });
                            return;
                        }
                        SettingsAboutMicroMsgUI.b(this.iKH);
                    }
                }, null);
                return true;
            }
        }
    }

    private boolean aMW() {
        try {
            if (this.iKD != null) {
                this.nDR.nEl.startActivity(this.iKD);
            }
        } catch (Exception e) {
            v.e("MicroMsg.SettingsAboutMicroMsgUI", "start market activity.");
        }
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + i2 + " errType " + i);
        ae aeVar = (ae) kVar;
        v.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getDownloadUrls() " + aeVar.bmy());
        v.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getPackVersion() " + aeVar.bmx());
        v.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.now getPackVersion() " + d.lWh);
        if (ai.lyb || (i == 0 && i2 == 0)) {
            this.iKC = aeVar.bmx();
            if (this.iKC <= 0 || this.iKC <= d.lWh) {
                this.iKA = false;
                ak.yW();
                if (c.ww() != 0) {
                    com.tencent.mm.p.c.us().s(262145, false);
                } else {
                    v.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBandage() uin not ready!");
                }
            } else {
                this.iKA = true;
                ak.yW();
                if (c.ww() != 0) {
                    com.tencent.mm.p.c.us().s(262145, true);
                } else {
                    v.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBandage() uin not ready!");
                }
            }
            this.iKB = aeVar.bmz();
        }
        aMV();
    }
}
