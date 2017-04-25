package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.ui.account.mobile.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class LoginByMobileUI extends MMActivity implements e {
    private String bfd = null;
    private String cQn = null;
    private String hUm = null;
    private String ivg;
    private EditText nIE;
    private LinearLayout nIF;
    private TextView nIG;
    private EditText nIH;
    private String nII = null;
    private Button nIJ;
    private a nIK = null;
    private Map<String, String> nIL = new HashMap();
    protected Map<String, String> nIM = new HashMap();
    private boolean nIN = true;
    private p nIO;
    private String nIP = null;
    private String nIQ = "";

    static /* synthetic */ void d(LoginByMobileUI loginByMobileUI, String str) {
        loginByMobileUI.getString(2131231164);
        loginByMobileUI.nIO = g.a(loginByMobileUI, loginByMobileUI.getString(2131234410), true, new OnCancelListener(loginByMobileUI) {
            final /* synthetic */ LoginByMobileUI nIR;

            {
                this.nIR = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        ak.vy().a(new u(str, 13, "", 0, ""), 0);
    }

    protected final int getLayoutId() {
        return 2130903874;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bAb();
        this.cQn = be.ah(getIntent().getStringExtra("country_name"), "");
        this.bfd = be.ah(getIntent().getStringExtra("couttry_code"), "");
        this.nII = be.ah(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.ivg = b.Oa();
        NI();
    }

    public void onResume() {
        super.onResume();
        ak.vy().a(701, this);
        ak.vy().a(145, this);
        b.b(true, ak.uR() + "," + getClass().getName() + ",L200_100," + ak.dR("L200_100") + ",1");
        b.mh("L200_100");
        this.nIH.setSelection(this.nIH.getText().toString().length());
        aJs();
    }

    public void onPause() {
        super.onPause();
        ak.vy().b(145, this);
        ak.vy().b(701, this);
        b.b(false, ak.uR() + "," + getClass().getName() + ",L200_100," + ak.dR("L200_100") + ",2");
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void NI() {
        this.nIL.clear();
        String[] split = getString(2131232236).trim().split(",");
        for (String trim : split) {
            String[] split2 = trim.trim().split(":");
            if (split2.length < 2) {
                v.e("MicroMsg.LoginByMobileUI", "this country item has problem %s", new Object[]{split[r0]});
            } else {
                this.nIL.put(split2[0], split2[1]);
                this.nIM.put(split2[1], split2[0]);
            }
        }
        this.nIE = (EditText) findViewById(2131757739);
        this.nIF = (LinearLayout) findViewById(2131755574);
        this.nIG = (TextView) findViewById(2131755576);
        this.nIH = (EditText) findViewById(2131755575);
        this.nIJ = (Button) findViewById(2131757738);
        String string = getString(2131234448);
        if (d.lWk) {
            string = getString(2131230720) + getString(2131230892);
        }
        Fd(string);
        iT(false);
        this.nIE.addTextChangedListener(new c(this.nIE, null, 20));
        this.nIE.addTextChangedListener(new TextWatcher(this) {
            private al gJe = new al();
            final /* synthetic */ LoginByMobileUI nIR;

            {
                this.nIR = r2;
            }

            public final void afterTextChanged(Editable editable) {
                String obj = this.nIR.nIE.getText().toString();
                if (!(obj == null || obj.equals(this.nIR.nIQ))) {
                    this.nIR.nIQ = al.formatNumber(this.nIR.nIH.getText().toString().replace("+", ""), obj);
                    this.nIR.nIE.setText(this.nIR.nIQ);
                    this.nIR.nIE.setSelection(this.nIR.nIE.getText().toString().length());
                }
                if (obj == null || obj.length() <= 0 || !this.nIR.nIN) {
                    this.nIR.iT(false);
                } else {
                    this.nIR.iT(true);
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.nIH.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ LoginByMobileUI nIR;

            {
                this.nIR = r1;
            }

            public final void afterTextChanged(Editable editable) {
                String obj = this.nIR.nIH.getText().toString();
                if (be.kS(obj)) {
                    this.nIR.iT(false);
                    this.nIR.nIH.setText("+");
                    this.nIR.nIH.setSelection(this.nIR.nIH.getText().toString().length());
                } else {
                    if (!obj.contains("+")) {
                        this.nIR.nIH.setText("+" + obj);
                        this.nIR.nIH.setSelection(this.nIR.nIH.getText().toString().length());
                    } else if (obj.length() > 1) {
                        String substring = obj.substring(1);
                        if (substring.length() > 4) {
                            this.nIR.nIH.setText(substring.substring(0, 4));
                            return;
                        }
                        obj = (String) this.nIR.nIL.get(substring);
                        if (be.kS(obj)) {
                            this.nIR.nIG.setText(this.nIR.getString(2131233848));
                            this.nIR.nIN = false;
                        } else {
                            if (this.nIR.nIM.get(this.nIR.nIG.getText()) == null || !((String) this.nIR.nIM.get(this.nIR.nIG.getText())).equals(substring)) {
                                this.nIR.nIG.setText(obj);
                            }
                            this.nIR.nIN = true;
                        }
                    }
                    if (this.nIR.nIE.getText() == null && this.nIR.nIE.getText().toString().length() > 0 && this.nIR.nIN) {
                        this.nIR.iT(true);
                        return;
                    } else {
                        this.nIR.iT(false);
                    }
                }
                this.nIR.nIG.setText(this.nIR.getString(2131233849));
                if (this.nIR.nIE.getText() == null) {
                }
                this.nIR.iT(false);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        a(0, getString(2131231103), new OnMenuItemClickListener(this) {
            final /* synthetic */ LoginByMobileUI nIR;

            {
                this.nIR = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nIR.nIP = this.nIR.nIH.getText().toString().trim();
                this.nIR.hUm = this.nIR.nIE.getText().toString();
                String str = this.nIR.nIP + this.nIR.hUm;
                this.nIR.axg();
                LoginByMobileUI.d(this.nIR, str);
                return true;
            }
        });
        if (be.kS(this.cQn) && be.kS(this.bfd)) {
            string = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            v.d("MicroMsg.LoginByMobileUI", "tm.getSimCountryIso()" + string);
            if (be.kS(string)) {
                v.e("MicroMsg.LoginByMobileUI", "getDefaultCountryInfo error");
            } else {
                com.tencent.mm.af.b.a g = com.tencent.mm.af.b.g(this, string, getString(2131232236));
                if (g == null) {
                    v.e("MicroMsg.LoginByMobileUI", "getDefaultCountryInfo error");
                } else {
                    this.cQn = g.cQn;
                    this.bfd = g.cQm;
                }
            }
        }
        if (!(this.cQn == null || this.cQn.equals(""))) {
            this.nIG.setText(this.cQn);
        }
        if (!(this.bfd == null || this.bfd.equals(""))) {
            this.nIH.setText("+" + this.bfd);
        }
        if (this.nII == null || this.nII.equals("")) {
            string = ((TelephonyManager) getSystemService("phone")).getLine1Number();
            if (!(string == null || string.equals("") || be.kS(this.bfd))) {
                string = string.trim();
                if (string.startsWith("+" + this.bfd)) {
                    this.nIE.setText(string.substring(("+" + this.bfd).length()));
                }
            }
        } else {
            this.nIE.setText(this.nII);
        }
        this.nIF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LoginByMobileUI nIR;

            {
                this.nIR = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", this.nIR.cQn);
                intent.putExtra("couttry_code", this.nIR.bfd);
                com.tencent.mm.plugin.a.a.drp.b(intent, this.nIR);
            }
        });
        this.nIJ.setVisibility(0);
        this.nIJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LoginByMobileUI nIR;

            {
                this.nIR = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.nIR, LoginUI.class);
                intent.putExtra("login_type", 1);
                this.nIR.startActivity(intent);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LoginByMobileUI nIR;

            {
                this.nIR = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nIR.goBack();
                return true;
            }
        });
    }

    private void goBack() {
        b.mi(this.ivg);
        axg();
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case 100:
                this.cQn = be.ah(intent.getStringExtra("country_name"), "");
                this.bfd = be.ah(intent.getStringExtra("couttry_code"), "");
                if (!this.cQn.equals("")) {
                    this.nIG.setText(this.cQn);
                }
                if (!this.bfd.equals("")) {
                    this.nIH.setText("+" + this.bfd);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.LoginByMobileUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.nIO != null) {
            this.nIO.dismiss();
            this.nIO = null;
        }
        if (kVar.getType() != 701 || this.nIK == null) {
            com.tencent.mm.f.a dm;
            if (kVar.getType() == 145) {
                int AG = ((u) kVar).AG();
                if (AG == 13) {
                    if (i2 == -41) {
                        dm = com.tencent.mm.f.a.dm(str);
                        if (dm != null) {
                            dm.a(this, null, null);
                            return;
                        } else {
                            g.f(this, 2131234422, 2131234423);
                            return;
                        }
                    } else if (i2 == -35) {
                        Intent intent = new Intent();
                        intent.putExtra("bindmcontact_mobile", this.nIP + " " + this.hUm);
                        a(LoginIndepPass.class, intent);
                        return;
                    } else if (i2 == -1) {
                        Toast.makeText(this, getString(2131232858, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        return;
                    } else if (i2 == -34) {
                        g.A(this, getString(2131231402), "");
                        return;
                    } else {
                        String Fk = ((u) kVar).Fk();
                        if (!be.kS(Fk)) {
                            this.hUm = Fk.trim();
                        }
                        this.hUm = al.Kq(this.hUm);
                        b.mj(ak.uR() + "," + getClass().getName() + ",L200_300," + ak.dR("L200_300") + ",1");
                        dm = com.tencent.mm.f.a.dm(str);
                        if (dm != null) {
                            dm.a(this, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ LoginByMobileUI nIR;

                                {
                                    this.nIR = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    LoginByMobileUI loginByMobileUI = this.nIR;
                                    LoginByMobileUI loginByMobileUI2 = this.nIR;
                                    this.nIR.getString(2131231164);
                                    loginByMobileUI.nIO = g.a(loginByMobileUI2, this.nIR.getString(2131234410), true, new OnCancelListener(this) {
                                        final /* synthetic */ AnonymousClass9 nIS;

                                        {
                                            this.nIS = r1;
                                        }

                                        public final void onCancel(DialogInterface dialogInterface) {
                                        }
                                    });
                                    ak.vy().a(new u(this.nIR.nIP + this.nIR.hUm, 16, "", 0, ""), 0);
                                    b.mj(ak.uR() + "," + this.nIR.getClass().getName() + ",L200_300," + ak.dR("L200_300") + ",2");
                                }
                            }, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ LoginByMobileUI nIR;

                                {
                                    this.nIR = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    b.mj(ak.uR() + "," + this.nIR.getClass().getName() + ",L200_300," + ak.dR("L200_300") + ",2");
                                }
                            });
                            return;
                        }
                        getString(2131231164);
                        this.nIO = g.a(this, getString(2131234410), true, new OnCancelListener(this) {
                            final /* synthetic */ LoginByMobileUI nIR;

                            {
                                this.nIR = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        });
                        ak.vy().a(new u(this.nIP + this.hUm, 16, "", 0, ""), 0);
                        return;
                    }
                } else if (AG == 16) {
                    if (i2 == -41) {
                        g.f(this, 2131234422, 2131234423);
                        return;
                    } else if (i2 == -75) {
                        g.A(this, getString(2131230894), "");
                        return;
                    } else {
                        b.mi("L3");
                        b.mj(ak.uR() + "," + getClass().getName() + ",L3," + ak.dR("L3") + ",1");
                        Intent intent2 = new Intent();
                        intent2.putExtra("bindmcontact_mobile", this.nIP + " " + this.nIE.getText().toString());
                        intent2.putExtra("bindmcontact_shortmobile", this.hUm);
                        intent2.putExtra("country_name", this.cQn);
                        intent2.putExtra("couttry_code", this.bfd);
                        intent2.putExtra("login_type", 3);
                        intent2.putExtra("mobileverify_countdownsec", ((u) kVar).Fm());
                        intent2.putExtra("mobileverify_countdownstyle", ((u) kVar).Fn());
                        intent2.putExtra("mobileverify_fb", ((u) kVar).Fo());
                        a(MobileVerifyUI.class, intent2);
                    }
                }
            }
            if (kVar.getType() == 701) {
                dm = com.tencent.mm.f.a.dm(str);
                if (dm != null && dm.a(this, null, null)) {
                    return;
                }
                return;
            }
            return;
        }
        this.nIK.a(this, i, i2, str, kVar);
    }

    public void setRequestedOrientation(int i) {
    }
}
