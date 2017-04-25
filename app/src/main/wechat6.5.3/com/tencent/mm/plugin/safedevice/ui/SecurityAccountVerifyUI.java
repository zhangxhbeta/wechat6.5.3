package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class SecurityAccountVerifyUI extends MMWizardActivity implements e {
    private ah aSW;
    private String bgb;
    private String bgd;
    private String bhT;
    private ProgressDialog dwR = null;
    private String ivc;
    private Button ivf;
    private String ivg;
    private EditText ivk;
    private TextView ivl;
    private TextView ivm;
    private Button ivn;
    private boolean ivo = false;

    protected final int getLayoutId() {
        return 2130904317;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ivg = b.Oa();
        NI();
    }

    protected void onResume() {
        ak.vy().a(145, this);
        ak.vy().a(132, this);
        super.onResume();
        if (!this.ivo) {
            b.b(true, ak.uR() + "," + getClass().getName() + ",L600_200," + ak.dR("L600_200") + ",1");
            b.mh("L600_200");
        }
    }

    protected void onPause() {
        ak.vy().b(145, this);
        ak.vy().b(132, this);
        super.onPause();
        if (!this.ivo) {
            b.b(false, ak.uR() + "," + getClass().getName() + ",L600_200," + ak.dR("L600_200") + ",2");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.aSW.QI();
    }

    protected final void NI() {
        this.bhT = getIntent().getStringExtra("binded_mobile");
        this.ivc = getIntent().getStringExtra("auth_ticket");
        this.ivo = getIntent().getBooleanExtra("re_open_verify", false);
        this.ivk = (EditText) findViewById(2131755621);
        this.ivl = (TextView) findViewById(2131759020);
        this.ivm = (TextView) findViewById(2131759021);
        this.ivn = (Button) findViewById(2131759022);
        this.ivk.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SecurityAccountVerifyUI ivp;

            {
                this.ivp = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                boolean z = (editable == null || be.kS(editable.toString())) ? false : true;
                this.ivp.iT(z);
            }
        });
        this.ivl.setText(be.KS(this.bhT));
        this.ivm.setTag(Integer.valueOf(60));
        this.aSW = new ah(new a(this) {
            final /* synthetic */ SecurityAccountVerifyUI ivp;

            {
                this.ivp = r1;
            }

            public final boolean oU() {
                int intValue = ((Integer) this.ivp.ivm.getTag()).intValue();
                if (intValue <= 1) {
                    this.ivp.ivn.setVisibility(0);
                    this.ivp.ivm.setVisibility(8);
                    return false;
                }
                this.ivp.ivm.setTag(Integer.valueOf(intValue - 1));
                this.ivp.ivm.setText(this.ivp.getString(2131234715, new Object[]{Integer.valueOf(intValue)}));
                if (this.ivp.ivm.getVisibility() != 0) {
                    this.ivp.ivm.setVisibility(0);
                }
                return true;
            }
        }, true);
        this.ivn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SecurityAccountVerifyUI ivp;

            {
                this.ivp = r1;
            }

            public final void onClick(View view) {
                v.v("MicroMsg.SecurityAccountVerifyUI", "on resend verify code button click");
                this.ivp.ivn.setVisibility(8);
                this.ivp.ivm.setTag(Integer.valueOf(60));
                this.ivp.aSW.QI();
                this.ivp.aSW.ea(1000);
                final u uVar = new u(this.ivp.bhT, 10, "", 0, "", this.ivp.ivc);
                ak.vy().a(uVar, 0);
                SecurityAccountVerifyUI securityAccountVerifyUI = this.ivp;
                ActionBarActivity actionBarActivity = this.ivp.nDR.nEl;
                this.ivp.getString(2131231164);
                securityAccountVerifyUI.dwR = g.a(actionBarActivity, this.ivp.getString(2131234718), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass3 ivq;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(uVar);
                    }
                });
            }
        });
        if (!this.ivo) {
            this.ivf = (Button) findViewById(2131759017);
            this.ivf.setVisibility(0);
            this.ivf.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SecurityAccountVerifyUI ivp;

                {
                    this.ivp = r1;
                }

                public final void onClick(View view) {
                    b.mj(ak.uR() + "," + getClass().getName() + ",L600_300," + ak.dR("L600_300") + ",1");
                    String d = com.tencent.mm.sdk.platformtools.u.d(this.ivp.getSharedPreferences(aa.bti(), 0));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[]{d}));
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, this.ivp.getString(2131234713));
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                    com.tencent.mm.plugin.a.a.drp.j(intent, this.ivp);
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SecurityAccountVerifyUI ivp;

            {
                this.ivp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ivp.aKM();
                return true;
            }
        });
        a(0, getString(2131231103), new OnMenuItemClickListener(this) {
            final /* synthetic */ SecurityAccountVerifyUI ivp;

            {
                this.ivp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = this.ivp.ivk.getText().toString().trim();
                if (be.kS(trim)) {
                    g.f(this.ivp, 2131231452, 2131231164);
                } else {
                    k vVar;
                    this.ivp.axg();
                    this.ivp.bgb = com.tencent.mm.plugin.safedevice.a.e.cr(this.ivp);
                    this.ivp.bgd = com.tencent.mm.plugin.safedevice.a.e.aKH();
                    if (this.ivp.ivo) {
                        vVar = new com.tencent.mm.modelfriend.v(this.ivp.bhT, 11, trim, "", this.ivp.bgb, this.ivp.bgd);
                    } else {
                        vVar = new u(this.ivp.bhT, trim, "", this.ivp.ivc, this.ivp.bgb, this.ivp.bgd);
                    }
                    ak.vy().a(vVar, 0);
                    SecurityAccountVerifyUI securityAccountVerifyUI = this.ivp;
                    SecurityAccountVerifyUI securityAccountVerifyUI2 = this.ivp;
                    this.ivp.getString(2131231164);
                    securityAccountVerifyUI.dwR = g.a(securityAccountVerifyUI2, this.ivp.getString(2131231440), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass6 ivs;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(vVar);
                        }
                    });
                }
                return true;
            }
        });
        iT(false);
        vD(2131234707);
        this.aSW.ea(1000);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        aKM();
        return true;
    }

    private void aKM() {
        cancel();
        bAv();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        Intent intent;
        switch (kVar.getType()) {
            case 132:
                if (i == 0 && i2 == 0) {
                    com.tencent.mm.plugin.safedevice.a.e.o(true, true);
                    intent = new Intent(this, MySafeDeviceListUI.class);
                    intent.addFlags(67108864);
                    startActivity(intent);
                    finish();
                    return;
                } else if (!k(i, i2, str)) {
                    Toast.makeText(this, getString(2131234720, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    return;
                } else {
                    return;
                }
            case 145:
                u uVar = (u) kVar;
                if (uVar.AG() == 10) {
                    if (i == 0 && i2 == 0) {
                        v.i("MicroMsg.SecurityAccountVerifyUI", "resend verify code successfully");
                        return;
                    }
                    v.w("MicroMsg.SecurityAccountVerifyUI", "resend verify code fail, errType %d, errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (!k(i, i2, str)) {
                        Toast.makeText(this.nDR.nEl, getString(2131234716, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        return;
                    }
                    return;
                } else if (uVar.AG() != 11) {
                    v.w("MicroMsg.SecurityAccountVerifyUI", "unknow bind mobile for reg op code %d, errType %d, errCode %d", new Object[]{Integer.valueOf(uVar.AG()), Integer.valueOf(i), Integer.valueOf(i2)});
                    return;
                } else if (i == 0 && i2 == 0) {
                    this.ivc = uVar.Fj();
                    v.d("MicroMsg.SecurityAccountVerifyUI", "duanyi test bind opmobile verify authticket = " + this.ivc);
                    int intExtra = getIntent().getIntExtra("from_source", 1);
                    Intent intent2 = new Intent();
                    intent2.putExtra("from_source", intExtra);
                    if (intExtra == 1) {
                        intent2.addFlags(67108864);
                        intent2.putExtra("auth_ticket", this.ivc);
                        com.tencent.mm.plugin.safedevice.a.a(this, intent2, null);
                        finish();
                        return;
                    } else if (intExtra == 2) {
                        intent2.addFlags(67108864);
                        intent2.putExtra("auth_ticket", this.ivc);
                        com.tencent.mm.plugin.safedevice.a.a(this, intent2, null);
                        finish();
                        return;
                    } else if (intExtra == 3) {
                        intent2.addFlags(67108864);
                        intent2.putExtra("auth_ticket", this.ivc);
                        Object stringExtra = getIntent().getStringExtra("WizardTransactionId");
                        if (stringExtra == null) {
                            stringExtra = "";
                        }
                        intent = (Intent) nFV.get(stringExtra);
                        nFV.clear();
                        if (intent != null) {
                            com.tencent.mm.plugin.safedevice.a.a(this, intent2, intent);
                        } else {
                            com.tencent.mm.plugin.safedevice.a.a(this, intent2, null);
                        }
                        finish();
                        return;
                    } else if (intExtra == 5) {
                        intent2.addFlags(67108864);
                        intent2.putExtra("auth_ticket", this.ivc);
                        com.tencent.mm.plugin.safedevice.a.a(this, intent2, null);
                        finish();
                        return;
                    } else if (intExtra == 6) {
                        intent2.addFlags(67108864);
                        intent2.putExtra("auth_ticket", this.ivc);
                        com.tencent.mm.plugin.safedevice.a.a(this, intent2, null);
                        finish();
                        return;
                    } else {
                        bAv();
                        return;
                    }
                } else {
                    v.w("MicroMsg.SecurityAccountVerifyUI", "verify verify-code fail, errType %d, errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (!k(i, i2, str)) {
                        Toast.makeText(this.nDR.nEl, getString(2131234720, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        return;
                    }
                    return;
                }
            default:
                return;
        }
    }

    private boolean k(int i, int i2, String str) {
        if (com.tencent.mm.plugin.a.a.drq.a(this.nDR.nEl, i, i2, str)) {
            return true;
        }
        switch (i2) {
            case -74:
                g.a(this.nDR.nEl, 2131231398, 2131231164, null);
                return true;
            case -57:
            case -1:
                Toast.makeText(this.nDR.nEl, 2131231042, 0).show();
                return true;
            case -41:
                Toast.makeText(this.nDR.nEl, 2131231401, 0).show();
                return true;
            case -34:
                Toast.makeText(this, 2131231402, 0).show();
                return true;
            case -33:
                g.a(this.nDR.nEl, 2131231445, 2131231451, null);
                return true;
            case -32:
                g.a(this.nDR.nEl, 2131231446, 2131231451, null);
                return true;
            default:
                return false;
        }
    }
}
