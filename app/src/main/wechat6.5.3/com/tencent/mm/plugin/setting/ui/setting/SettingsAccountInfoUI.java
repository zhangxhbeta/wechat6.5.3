package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.a.o;
import com.tencent.mm.e.a.ap;
import com.tencent.mm.e.a.hr;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.FacebookAuthUI;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.v.e;
import junit.framework.Assert;

public class SettingsAccountInfoUI extends MMPreference implements b, e {
    private ProgressDialog dwR;
    private f dxf;
    private final String iLd = "http://weixin.qq.com/cgi-bin/readtemplate?&t=w_safe";
    private final String iLe = "http://weixin.qq.com/cgi-bin/readtemplate?&t=w_safe&qqpimsecurestatus=1";
    private final String iLf = "http://weixin.qq.com/cgi-bin/readtemplate?&t=w_safe&qqpimsecurestatus=0";
    private final int iLg = 0;
    private final int iLh = 1;
    private final int iLi = 2;
    private final int iLj = 1;
    private int iLk = 0;
    private String iLl;
    private View iLm;
    private TextView iLn;
    private EditText iLo;
    private h iLp;
    private boolean iLq;
    private String iLr = null;
    private SparseIntArray iLs = new SparseIntArray();

    public SettingsAccountInfoUI() {
        this.iLs.put(0, 2131235000);
        this.iLs.put(-82, 2131234951);
        this.iLs.put(-83, 2131234948);
        this.iLs.put(-84, 2131234949);
        this.iLs.put(-85, 2131234944);
        this.iLs.put(-86, 2131234952);
    }

    public final int Oo() {
        return 2131099723;
    }

    public final boolean On() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        ak.yW();
        c.vf().a(this);
        ak.vy().a(256, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.yW();
        c.vf().b(this);
        ak.vy().b(256, this);
    }

    protected final void NI() {
        vD(2131234968);
        this.dxf = this.ocZ;
        this.iLm = View.inflate(this, 2130904345, null);
        this.iLn = (TextView) this.iLm.findViewById(2131759061);
        this.iLn.setText(getString(2131235028));
        this.iLo = (EditText) this.iLm.findViewById(2131759062);
        this.iLo.setInputType(129);
        this.iLl = getString(2131236652);
        String string = getString(2131236652);
        if (u.bsY().equals("zh_CN")) {
            this.iLl = string + "zh_CN";
        } else if (u.bsY().equals("zh_TW") || u.bsY().equals("zh_HK")) {
            this.iLl = string + "zh_TW";
        } else {
            this.iLl = string + "en";
        }
        ak.yW();
        if (((Integer) c.vf().get(9, Integer.valueOf(0))).intValue() != 0) {
            v.i("MicroMsg.SettingsAccountInfoUI", "summerqq BindQQSwitch bindqq");
        } else if (be.getInt(j.sU().getValue("BindQQSwitch"), 1) != 1) {
            this.dxf.aO("settings_uin", true);
            v.i("MicroMsg.SettingsAccountInfoUI", "summerqq BindQQSwitch off");
        }
        if (be.getInt(j.sU().getValue("VoiceprintEntry"), 0) != 1) {
            this.dxf.aO("settings_voiceprint_title", true);
        } else if (ak.uz()) {
            IconPreference iconPreference = (IconPreference) this.dxf.Ow("settings_voiceprint_title");
            ak.yW();
            if (((Boolean) c.vf().get(a.npd, Boolean.valueOf(true))).booleanValue()) {
                ak.yW();
                if ((c.vf().getInt(40, 0) & 131072) == 0) {
                    iconPreference.aO(getString(2131231102), 2130838762);
                    iconPreference.wG(0);
                    v.i("MicroMsg.SettingsAccountInfoUI", "show voiceprint dot");
                    this.dxf.notifyDataSetChanged();
                }
            }
        } else {
            v.e("MicroMsg.SettingsAccountInfoUI", "update voiceprint dot, account not ready!");
            return;
        }
        this.iLr = j.sU().getValue("CloseAcctUrl");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAccountInfoUI iLt;

            {
                this.iLt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iLt.axg();
                this.iLt.finish();
                return true;
            }
        });
    }

    protected void onResume() {
        ak.vy().a(255, this);
        ak.vy().a(384, this);
        aNc();
        aNf();
        aNg();
        aNb();
        aNe();
        aNd();
        this.iLq = false;
        aNh();
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.dxf.Ow("settings_phone_security");
        if (iconSwitchKeyValuePreference == null) {
            v.e("MicroMsg.SettingsAccountInfoUI", "phone_security preference is null");
        } else {
            try {
                String value = j.sU().getValue("ShowSecurityEntry");
                v.d("MicroMsg.SettingsAccountInfoUI", "cfgShowSecurityEntry %s, return", new Object[]{value});
                if (be.kS(value) || Integer.valueOf(value).intValue() != 1) {
                    this.dxf.aO("settings_phone_security", true);
                } else {
                    int i = this.iLk;
                    this.dxf.aO("settings_phone_security", false);
                    iconSwitchKeyValuePreference.wN(-1);
                    if (!p.o(this.nDR.nEl, "com.tencent.qqpimsecure")) {
                        iconSwitchKeyValuePreference.setSummary(2131234169);
                        this.iLk = 0;
                    } else if (be.aZ(this.nDR.nEl, "com.tencent.qqpimsecure")) {
                        iconSwitchKeyValuePreference.setSummary(2131234167);
                        this.iLk = 2;
                    } else {
                        iconSwitchKeyValuePreference.setSummary(2131234168);
                        this.iLk = 1;
                    }
                    if (i != this.iLk) {
                        this.dxf.notifyDataSetChanged();
                    }
                }
            } catch (Exception e) {
                v.e("MicroMsg.SettingsAccountInfoUI", "exception in updatePhoneSecurityState, %s", new Object[]{e.getMessage()});
                this.dxf.aO("settings_phone_security", true);
            }
        }
        aNi();
        PluginTextPreference pluginTextPreference = (PluginTextPreference) this.dxf.Ow("settings_about_vusertitle");
        SelfVuserPreference selfVuserPreference = (SelfVuserPreference) this.dxf.Ow("settings_about_vuserinfo");
        Preference Ow = this.dxf.Ow("settings_about_vuser_about");
        ak.yW();
        int f = be.f((Integer) c.vf().get(66049, null));
        if (f != 0) {
            Bitmap c;
            pluginTextPreference.visibility = 8;
            pluginTextPreference.wP(2131232201);
            if (ab.a.csb != null) {
                c = BackwardSupportUtil.b.c(ab.a.csb.eI(f), 2.0f);
            } else {
                c = null;
            }
            selfVuserPreference.drawable = new BitmapDrawable(getResources(), c);
            ak.yW();
            selfVuserPreference.text = (String) c.vf().get(66050, null);
        } else {
            this.dxf.b(pluginTextPreference);
            this.dxf.b(selfVuserPreference);
            this.dxf.b(Ow);
        }
        this.dxf.b(this.dxf.Ow("settings_about_domainmail"));
        if (be.kS(this.iLr)) {
            this.dxf.b(this.dxf.Ow("settings_delete_account"));
        }
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        ak.vy().b(255, this);
        ak.vy().b(384, this);
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        v.i("MicroMsg.SettingsAccountInfoUI", str + " item has been clicked!");
        String xF = k.xF();
        if (be.kS(str)) {
            return false;
        }
        if (str.equals("settings_username") && be.kS(k.xG()) && com.tencent.mm.storage.u.LL(xF)) {
            q(SettingsAliasUI.class);
        } else if (str.equals("settings_facebook")) {
            q(FacebookAuthUI.class);
        } else if (str.equals("settings_email_addr")) {
            boolean z;
            ak.yW();
            Integer num = (Integer) c.vf().get(7, null);
            if (num == null || (num.intValue() & 2) == 0) {
                z = false;
            } else {
                z = true;
            }
            ak.yW();
            str = (String) c.vf().get(5, null);
            if (z || !be.kS(str)) {
                startActivity(new Intent(this.nDR.nEl, SettingsModifyEmailAddrUI.class));
                return true;
            }
            if (this.dwR != null) {
                v.w("MicroMsg.SettingsAccountInfoUI", "do get email input, but tips dialog has not dismissed");
                this.dwR.dismiss();
                this.dwR = null;
            }
            g.a(this.nDR.nEl, getString(2131235058), be.ah(d.be(this.nDR.nEl), ""), getString(2131235059), 50, new g.b(this) {
                final /* synthetic */ SettingsAccountInfoUI iLt;

                {
                    this.iLt = r1;
                }

                public final boolean r(CharSequence charSequence) {
                    if (be.Kx(charSequence.toString())) {
                        com.tencent.mm.plugin.setting.a.drq.ow();
                        final com.tencent.mm.s.a aVar = new com.tencent.mm.s.a(com.tencent.mm.s.a.cxb, charSequence.toString());
                        ak.vy().a(aVar, 0);
                        SettingsAccountInfoUI settingsAccountInfoUI = this.iLt;
                        ActionBarActivity actionBarActivity = this.iLt.nDR.nEl;
                        this.iLt.getString(2131231164);
                        settingsAccountInfoUI.dwR = g.a(actionBarActivity, this.iLt.getString(2131234986), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass2 iLv;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(aVar);
                            }
                        });
                        return true;
                    }
                    g.bf(this.iLt.nDR.nEl, this.iLt.getString(2131235776));
                    return false;
                }
            });
            return true;
        } else if (str.equals("settings_mobile")) {
            r0 = new Intent(this, BindMContactIntroUI.class);
            r0.putExtra("key_upload_scene", 4);
            MMWizardActivity.w(this, r0);
            return true;
        } else if (str.equals("settings_uin")) {
            com.tencent.mm.plugin.setting.a.drp.h(new Intent(), this);
            return true;
        } else if (str.equals("settings_about_vuser_about")) {
            be.E(this.nDR.nEl, String.format("https://weixin.qq.com/cgi-bin/readtemplate?check=false&t=weixin_faq_verifyaccount&platform=android&lang=%s", new Object[]{u.bsY()}));
        } else if (str.equals("settings_independent_password")) {
            if (this.iLq) {
                fn(true);
            } else {
                final t tVar = new t(1);
                ak.vy().a(tVar, 0);
                getString(2131231164);
                this.dwR = g.a(this, getString(2131235044), true, new OnCancelListener(this) {
                    final /* synthetic */ SettingsAccountInfoUI iLt;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(tVar);
                    }
                });
            }
        } else if (str.equals("settings_safe_device")) {
            ak.yW();
            str = (String) c.vf().get(6, "");
            ak.yW();
            xF = (String) c.vf().get(4097, "");
            if (!be.kS(str)) {
                com.tencent.mm.ay.c.w(this, "safedevice", ".ui.MySafeDeviceListUI");
            } else if (be.kS(xF)) {
                com.tencent.mm.ay.c.a(this, "safedevice", ".ui.BindSafeDeviceUI", new Intent());
            } else {
                r0 = new Intent(this, BindMContactIntroUI.class);
                r0.putExtra("is_bind_for_safe_device", true);
                MMWizardActivity.w(this, r0);
            }
        } else if (str.equals("settings_room_right")) {
            com.tencent.mm.ay.c.w(this, "chatroom", ".ui.RoomRightUI");
            return true;
        } else if (str.equals("settings_delete_account")) {
            r0 = new Intent();
            if (!be.kS(this.iLr)) {
                r0.putExtra("rawUrl", this.iLr + "&lang=" + u.dJ(this.nDR.nEl));
                r0.putExtra("showShare", true);
                r0.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", r0, 1);
            }
        } else if (str.equals("settings_phone_security")) {
            r0 = new Intent();
            if (this.iLk == 0) {
                r0.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?&t=w_safe");
            } else if (this.iLk == 1) {
                r0.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?&t=w_safe&qqpimsecurestatus=0");
            } else if (this.iLk == 2) {
                r0.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?&t=w_safe&qqpimsecurestatus=1");
            }
            com.tencent.mm.plugin.report.service.g.iuh.h(10939, new Object[]{Integer.valueOf(this.iLk)});
            r0.putExtra("show_bottom", false);
            r0.putExtra("showShare", false);
            com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", r0);
        } else if (str.equals("settings_security_center")) {
            ActionBarActivity actionBarActivity = this.nDR.nEl;
            xF = this.iLl;
            Intent intent = new Intent();
            intent.putExtra("rawUrl", xF);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            intent.putExtra("needRedirect", false);
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
            com.tencent.mm.ay.c.b(actionBarActivity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        } else if (str.equals("settings_voiceprint_title")) {
            if (be.getInt(j.sU().getValue("VoiceprintEntry"), 0) == 1) {
                ak.yW();
                if ((c.vf().getInt(40, 0) & 131072) == 0) {
                    ak.yW();
                    c.vf().a(a.npd, Boolean.valueOf(false));
                    ((IconPreference) this.dxf.Ow("settings_voiceprint_title")).wG(8);
                    this.dxf.notifyDataSetChanged();
                    v.i("MicroMsg.SettingsAccountInfoUI", "unset setting account info new show");
                }
            }
            com.tencent.mm.ay.c.w(this.nDR.nEl, "voiceprint", "com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI");
        } else if (str.equals("settings_trust_friend")) {
            q(SettingsTrustFriendUI.class);
        }
        return false;
    }

    private void aNb() {
        Preference Ow = this.dxf.Ow("settings_email_addr");
        Assert.assertNotNull(Ow);
        ak.yW();
        String str = (String) c.vf().get(5, null);
        ak.yW();
        Integer num = (Integer) c.vf().get(7, null);
        if (num != null && (num.intValue() & 2) != 0) {
            Ow.setSummary(2131235005);
        } else if (str != null) {
            Ow.setSummary(2131235004);
        } else {
            Ow.setSummary(2131234943);
        }
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        aNc();
        aNb();
        aNf();
        aNg();
        aNe();
        aNd();
        aNh();
        aNi();
        int n = be.n(obj, 0);
        v.d("MicroMsg.SettingsAccountInfoUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), jVar});
        ak.yW();
        if (jVar != c.vf() || n <= 0) {
            v.e("MicroMsg.SettingsAccountInfoUI", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), jVar});
        } else if (n == 135175 || n == 135176) {
            aNh();
        }
    }

    private void aNc() {
        Preference Ow = this.dxf.Ow("settings_username");
        CharSequence xG = k.xG();
        if (be.kS(xG)) {
            xG = k.xF();
            if (com.tencent.mm.storage.u.LL(xG)) {
                Ow.setSummary(getString(2131235086));
                return;
            } else {
                Ow.setSummary(xG);
                return;
            }
        }
        Ow.setSummary(xG);
    }

    private void aNd() {
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.dxf.Ow("settings_safe_device");
        if (iconSwitchKeyValuePreference == null) {
            v.e("MicroMsg.SettingsAccountInfoUI", "safedevicesate preference is null");
            return;
        }
        ak.yW();
        if (((Integer) c.vf().get(9, null)).intValue() == 0) {
            v.d("MicroMsg.SettingsAccountInfoUI", "not bind uin");
            this.dxf.aO("settings_safe_device", true);
            return;
        }
        this.dxf.aO("settings_safe_device", false);
        if (k.xN()) {
            iconSwitchKeyValuePreference.setSummary(2131234691);
            iconSwitchKeyValuePreference.wN(1);
            return;
        }
        iconSwitchKeyValuePreference.setSummary(2131234692);
        iconSwitchKeyValuePreference.wN(2);
    }

    private void aNe() {
        Preference Ow = this.dxf.Ow("settings_facebook");
        if (Ow == null) {
            v.e("MicroMsg.SettingsAccountInfoUI", "updateFacebook Preference null");
        } else if (!k.yf()) {
            this.dxf.b(Ow);
        } else if (k.yh()) {
            ak.yW();
            Ow.setSummary((String) c.vf().get(65826, null));
        } else {
            Ow.setSummary(getString(2131234985));
        }
    }

    private void aNf() {
        Preference Ow = this.dxf.Ow("settings_mobile");
        if (Ow == null) {
            v.e("MicroMsg.SettingsAccountInfoUI", "updateMobile Preference null");
            return;
        }
        ak.yW();
        String str = (String) c.vf().get(6, null);
        v.d("MicroMsg.SettingsAccountInfoUI", "mobile :" + str);
        if (str == null || str.length() <= 0) {
            Ow.setSummary(getString(2131234985));
        } else {
            Ow.setSummary(str);
        }
    }

    private void aNg() {
        Preference Ow = this.dxf.Ow("settings_uin");
        if (Ow == null) {
            v.e("MicroMsg.SettingsAccountInfoUI", "updateUin Preference null");
            return;
        }
        ak.yW();
        int intValue = ((Integer) c.vf().get(9, null)).intValue();
        if (intValue == 0) {
            v.i("MicroMsg.SettingsAccountInfoUI", "updateUin 0 Preference");
            if (be.He() || be.getInt(j.sU().getValue("BindQQSwitch"), 1) != 1) {
                this.dxf.aO("settings_uin", true);
                return;
            } else {
                Ow.setSummary(2131234985);
                return;
            }
        }
        Ow.setSummary(new o(intValue));
    }

    private void aNh() {
        this.dxf.aO("settings_room_right", true);
    }

    private void aNi() {
        boolean z;
        boolean z2 = true;
        ap apVar = new ap();
        com.tencent.mm.sdk.c.a.nhr.z(apVar);
        if (apVar.aYj.aYk && apVar.aYj.aYl && apVar.aYj.aYm) {
            z = true;
        } else {
            z = false;
        }
        v.i("MicroMsg.SettingsAccountInfoUI", "check is support soter, isSupportSoter: %b, isSupportFP: %b, isSystemHasFPEnrolled: %b", new Object[]{Boolean.valueOf(apVar.aYj.aYk), Boolean.valueOf(apVar.aYj.aYl), Boolean.valueOf(apVar.aYj.aYm)});
        f fVar = this.dxf;
        String str = "settings_fingerprint_title";
        if (z) {
            z2 = false;
        }
        fVar.aO(str, z2);
    }

    private void fn(boolean z) {
        v.d("MicroMsg.SettingsAccountInfoUI", "handlePassword " + z);
        if (!z) {
            Intent intent = new Intent();
            intent.putExtra("kintent_hint", getString(2131235066));
            com.tencent.mm.ay.c.b(this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent);
        } else if (this.iLp != null) {
            this.iLp.show();
        } else {
            this.iLp = g.a(this, null, this.iLm, new OnClickListener(this) {
                final /* synthetic */ SettingsAccountInfoUI iLt;

                {
                    this.iLt = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    String obj = this.iLt.iLo.getText().toString();
                    this.iLt.iLo.setText("");
                    this.iLt.iLo.clearFocus();
                    this.iLt.cx(this.iLt.iLo);
                    if (obj == null || obj.equals("")) {
                        g.a(this.iLt, 2131235780, 2131231164, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass4 iLx;

                            {
                                this.iLx = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        return;
                    }
                    final ag agVar = new ag(obj, "", "", "");
                    ak.vy().a(agVar, 0);
                    SettingsAccountInfoUI settingsAccountInfoUI = this.iLt;
                    SettingsAccountInfoUI settingsAccountInfoUI2 = this.iLt;
                    this.iLt.getString(2131231164);
                    settingsAccountInfoUI.dwR = g.a(settingsAccountInfoUI2, this.iLt.getString(2131235044), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass4 iLx;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(agVar);
                        }
                    });
                }
            }, new OnClickListener(this) {
                final /* synthetic */ SettingsAccountInfoUI iLt;

                {
                    this.iLt = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.iLt.iLo.setText("");
                    this.iLt.iLp.dismiss();
                }
            });
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.d("MicroMsg.SettingsAccountInfoUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (kVar.getType() == 255) {
            if (i == 0 && i2 == 0) {
                fn(true);
            } else if (!com.tencent.mm.plugin.setting.a.drq.a(this, i, i2, str)) {
                fn(false);
            }
        } else if (kVar.getType() == 384) {
            if (i == 0 && i2 == 0) {
                ak.yW();
                c.vf().set(77830, ((ag) kVar).Fi());
                Intent intent = new Intent();
                intent.putExtra("kintent_hint", getString(2131235066));
                com.tencent.mm.ay.c.b(this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent);
                return;
            }
            this.iLq = true;
            g.a(this, 2131235087, 2131231164, new OnClickListener(this) {
                final /* synthetic */ SettingsAccountInfoUI iLt;

                {
                    this.iLt = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else if (kVar.getType() != 256) {
        } else {
            if ((i == 0 && i2 == 0) || !com.tencent.mm.plugin.setting.a.drq.a(this, i, i2, str)) {
                int i3 = this.iLs.get(i2);
                String string = getString(2131234999, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                if (i3 != 0) {
                    try {
                        string = getString(i3);
                    } catch (Throwable e) {
                        v.e("MicroMsg.SettingsAccountInfoUI", "try get string by id %d, fail:%s", new Object[]{Integer.valueOf(i3), e.getMessage()});
                        v.a("MicroMsg.SettingsAccountInfoUI", e, "", new Object[0]);
                    }
                }
                g.bf(this.nDR.nEl, string);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            switch (i2) {
                case -1:
                    if (!(ak.vy() == null || ak.vy().cAa == null)) {
                        ak.vy().cAa.aU(false);
                    }
                    com.tencent.mm.plugin.setting.a.drq.oC();
                    ak.yW();
                    c.vf().b(this);
                    hr hrVar = new hr();
                    hrVar.bhA.status = 0;
                    hrVar.bhA.bhB = 3;
                    com.tencent.mm.sdk.c.a.nhr.z(hrVar);
                    com.tencent.mm.e.a.v vVar = new com.tencent.mm.e.a.v();
                    vVar.aXi.aXj = true;
                    com.tencent.mm.sdk.c.a.nhr.z(vVar);
                    com.tencent.mm.sdk.platformtools.ab.Kj("show_whatsnew");
                    com.tencent.mm.kernel.h.c(this, true);
                    Intent intent2 = new Intent();
                    intent2.addFlags(67108864);
                    intent2.putExtra("Intro_Switch", true);
                    com.tencent.mm.plugin.setting.a.drp.t(intent2, this.nDR.nEl);
                    d.z(this, null);
                    finish();
                    return;
                default:
                    return;
            }
        }
    }
}
