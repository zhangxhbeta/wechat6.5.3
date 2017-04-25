package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class SettingsSafeUI extends MMPreference implements e {
    private ProgressDialog dwR;
    private f dxf;
    private final String iLd = "http://weixin.qq.com/cgi-bin/readtemplate?&t=w_safe";
    private final String iLe = "http://weixin.qq.com/cgi-bin/readtemplate?&t=w_safe&qqpimsecurestatus=1";
    private final String iLf = "http://weixin.qq.com/cgi-bin/readtemplate?&t=w_safe&qqpimsecurestatus=0";
    private final int iLg = 0;
    private final int iLh = 1;
    private final int iLi = 2;
    private int iLk = 0;
    private String iLl;
    private View iLm;
    private TextView iLn;
    private EditText iLo;
    private h iLp;
    private boolean iLq;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public final boolean On() {
        return true;
    }

    protected final void NI() {
        vD(2131235132);
        this.dxf = this.ocZ;
        this.iLm = View.inflate(this, 2130904345, null);
        this.iLn = (TextView) this.iLm.findViewById(2131759061);
        this.iLn.setText(getString(2131235028));
        this.iLo = (EditText) this.iLm.findViewById(2131759062);
        this.iLo.setInputType(129);
        this.iLl = getString(2131236652);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsSafeUI iMN;

            {
                this.iMN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iMN.axg();
                this.iMN.finish();
                return true;
            }
        });
    }

    public final int Oo() {
        return 2131099731;
    }

    protected void onResume() {
        ak.vy().a(255, this);
        ak.vy().a(384, this);
        this.dxf.aO("settings_room_right", true);
        if (!u.bsV()) {
            this.dxf.Ox("settings_security_center");
            this.dxf.Ox("settings_security_center_tip");
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
        v.i("MicroMsg.SettingsSafeUI", str + " item has been clicked!");
        if (str.equals("settings_independent_password")) {
            if (this.iLq) {
                fn(true);
            } else {
                final t tVar = new t(1);
                ak.vy().a(tVar, 0);
                getString(2131231164);
                this.dwR = g.a(this, getString(2131235044), true, new OnCancelListener(this) {
                    final /* synthetic */ SettingsSafeUI iMN;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(tVar);
                    }
                });
            }
        } else if (str.equals("settings_safe_device")) {
            ak.yW();
            str = (String) c.vf().get(6, "");
            ak.yW();
            r1 = (String) c.vf().get(4097, "");
            if (!be.kS(str)) {
                com.tencent.mm.ay.c.w(this, "safedevice", ".ui.MySafeDeviceListUI");
            } else if (be.kS(r1)) {
                com.tencent.mm.ay.c.a(this, "safedevice", ".ui.BindSafeDeviceUI", new Intent());
            } else {
                r0 = new Intent(this, BindMContactIntroUI.class);
                r0.putExtra("is_bind_for_safe_device", true);
                MMWizardActivity.w(this, r0);
            }
        } else if (str.equals("settings_room_right")) {
            com.tencent.mm.ay.c.w(this, "chatroom", ".ui.RoomRightUI");
            return true;
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
            r1 = this.iLl;
            Intent intent = new Intent();
            intent.putExtra("rawUrl", r1);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            intent.putExtra("needRedirect", false);
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
            com.tencent.mm.ay.c.b(actionBarActivity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
        return false;
    }

    private void fn(boolean z) {
        v.d("MicroMsg.SettingsSafeUI", "handlePassword " + z);
        if (!z) {
            Intent intent = new Intent();
            intent.putExtra("kintent_hint", getString(2131235066));
            com.tencent.mm.ay.c.b(this, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent);
        } else if (this.iLp != null) {
            this.iLp.show();
        } else {
            this.iLp = g.a(this, null, this.iLm, new OnClickListener(this) {
                final /* synthetic */ SettingsSafeUI iMN;

                {
                    this.iMN = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    String obj = this.iMN.iLo.getText().toString();
                    this.iMN.iLo.setText("");
                    this.iMN.iLo.clearFocus();
                    this.iMN.cx(this.iMN.iLo);
                    if (obj == null || obj.equals("")) {
                        g.a(this.iMN, 2131235780, 2131231164, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 iMO;

                            {
                                this.iMO = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        return;
                    }
                    final ag agVar = new ag(obj, "", "", "");
                    ak.vy().a(agVar, 0);
                    SettingsSafeUI settingsSafeUI = this.iMN;
                    SettingsSafeUI settingsSafeUI2 = this.iMN;
                    this.iMN.getString(2131231164);
                    settingsSafeUI.dwR = g.a(settingsSafeUI2, this.iMN.getString(2131235044), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass3 iMO;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(agVar);
                        }
                    });
                }
            }, new OnClickListener(this) {
                final /* synthetic */ SettingsSafeUI iMN;

                {
                    this.iMN = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.iMN.iLo.setText("");
                    this.iMN.iLp.dismiss();
                }
            });
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.SettingsSafeUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (kVar.getType() == 255) {
            if (i == 0 && i2 == 0) {
                fn(true);
            } else if (!a.drq.a(this, i, i2, str)) {
                fn(false);
            }
        } else if (kVar.getType() != 384) {
        } else {
            if (i == 0 && i2 == 0) {
                ak.yW();
                c.vf().set(77830, ((ag) kVar).Fi());
                return;
            }
            this.iLq = true;
            g.a(this, 2131235087, 2131231164, new OnClickListener(this) {
                final /* synthetic */ SettingsSafeUI iMN;

                {
                    this.iMN = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }
}
