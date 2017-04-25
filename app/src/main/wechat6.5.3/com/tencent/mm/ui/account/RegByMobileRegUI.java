package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Spannable.Factory;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.af.b.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class RegByMobileRegUI extends MMActivity implements e {
    private String bfd = null;
    private String cQn = null;
    private String cZU = null;
    private int dHn;
    private String hUm = null;
    private String ivg;
    private CheckBox lPH;
    private EditText nIE;
    private LinearLayout nIF;
    private TextView nIG;
    private EditText nIH;
    private String nII = null;
    private Button nIJ;
    private Map<String, String> nIL = new HashMap();
    protected Map<String, String> nIM = new HashMap();
    private boolean nIN = true;
    private p nIO;
    private String nIP = null;
    private String nIQ = "";
    private int nKA = 0;
    private String nKT = "";
    private int nKU = 2;
    private boolean nKV = false;
    private String nKr;
    private String nKs;
    private TextView nKt;
    private Button nKu;

    static /* synthetic */ void d(RegByMobileRegUI regByMobileRegUI, String str) {
        if (regByMobileRegUI.nIO != null) {
            v.d("MicroMsg.RegByMobileRegUI", "already checking ");
            return;
        }
        regByMobileRegUI.getString(2131231164);
        regByMobileRegUI.nIO = g.a(regByMobileRegUI, regByMobileRegUI.getString(2131234410), true, new OnCancelListener(regByMobileRegUI) {
            final /* synthetic */ RegByMobileRegUI nKW;

            {
                this.nKW = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        if (regByMobileRegUI.dHn == 1) {
            ak.vy().a(new com.tencent.mm.modelfriend.v(str, 1, "", 0, ""), 0);
        } else {
            String trim = regByMobileRegUI.nIE.getText().toString().trim();
            int i = (regByMobileRegUI.nKr == null || regByMobileRegUI.nKs == null || trim.equals(regByMobileRegUI.nKr) || !trim.equals(regByMobileRegUI.nKs)) ? (regByMobileRegUI.nKr == null || regByMobileRegUI.nKs == null || regByMobileRegUI.nKs.equals(regByMobileRegUI.nKr) || trim.equals(regByMobileRegUI.nKs)) ? 0 : 2 : 1;
            u uVar = new u(str, 12, "", 0, "");
            uVar.fq(regByMobileRegUI.nKA);
            uVar.fr(i);
            ak.vy().a(uVar, 0);
            regByMobileRegUI.nKr = regByMobileRegUI.nIE.getText().toString().trim();
        }
        regByMobileRegUI.nKA++;
    }

    protected final int getLayoutId() {
        return 2130904268;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cQn = be.ah(getIntent().getStringExtra("country_name"), "");
        this.bfd = be.ah(getIntent().getStringExtra("couttry_code"), "");
        this.nII = be.ah(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.dHn = getIntent().getIntExtra("login_type", 0);
        this.cZU = getIntent().getStringExtra("regsetinfo_ticket");
        this.nKT = getIntent().getStringExtra("regsetinfo_NextStep");
        this.nKU = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.ivg = b.Oa();
        NI();
    }

    public void onResume() {
        super.onResume();
        ak.vy().a(701, this);
        ak.vy().a(145, this);
        ak.vy().a(132, this);
        if (this.dHn == 0) {
            if (this.nKV) {
                b.b(true, ak.uR() + "," + getClass().getName() + ",R1_with_email_entry," + ak.dR("R1_with_email_entry") + ",1");
                b.mh("R1_with_email_entry");
            } else {
                b.b(true, ak.uR() + "," + getClass().getName() + ",R200_100," + ak.dR("R200_100") + ",1");
                b.mh("R200_100");
            }
        } else if (this.dHn == 2) {
            b.b(true, ak.uR() + "," + getClass().getName() + ",F200_100," + ak.dR("F200_100") + ",1");
            b.mh("F200_100");
        }
        this.nIH.setSelection(this.nIH.getText().toString().length());
        aJs();
        this.nKA = 0;
    }

    public void onPause() {
        super.onPause();
        ak.vy().b(701, this);
        ak.vy().b(145, this);
        ak.vy().b(132, this);
        if (this.dHn == 0) {
            if (this.nKV) {
                b.b(false, ak.uR() + "," + getClass().getName() + ",R1_with_email_entry," + ak.dR("R1_with_email_entry") + ",2");
            } else {
                b.b(false, ak.uR() + "," + getClass().getName() + ",R200_100," + ak.dR("R200_100") + ",2");
            }
        } else if (this.dHn == 2) {
            b.b(false, ak.uR() + "," + getClass().getName() + ",F200_100," + ak.dR("F200_100") + ",2");
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void NI() {
        String string;
        this.nIL.clear();
        String[] split = getString(2131232236).trim().split(",");
        for (String string2 : split) {
            String[] split2 = string2.trim().split(":");
            if (split2.length < 2) {
                v.e("MicroMsg.RegByMobileRegUI", "this country item has problem %s", new Object[]{split[r0]});
            } else {
                this.nIL.put(split2[0], split2[1]);
                this.nIM.put(split2[1], split2[0]);
            }
        }
        this.nIE = (EditText) findViewById(2131757739);
        this.nIF = (LinearLayout) findViewById(2131755574);
        this.nIG = (TextView) findViewById(2131755576);
        this.nIH = (EditText) findViewById(2131755575);
        this.nIH.setText(getString(2131232237));
        this.nIJ = (Button) findViewById(2131757738);
        this.lPH = (CheckBox) findViewById(2131758285);
        this.nKt = (TextView) findViewById(2131758315);
        this.nKu = (Button) findViewById(2131758286);
        String string3 = getString(2131234448);
        if (d.lWk) {
            string3 = string3 + getString(2131230892);
        }
        Fd(string3);
        this.lPH.setVisibility(8);
        this.lPH.setChecked(true);
        if (this.nKu != null) {
            this.nKu.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ RegByMobileRegUI nKW;

                {
                    this.nKW = r1;
                }

                public final void onClick(View view) {
                    be.E(this.nKW.nDR.nEl, this.nKW.getString(2131235735));
                }
            });
        }
        string3 = getString(2131233500);
        String str = "  ";
        if (com.tencent.mm.sdk.platformtools.u.bsV()) {
            string2 = getString(2131233501);
            CharSequence newSpannable = Factory.getInstance().newSpannable(string3 + str + string2);
            newSpannable.setSpan(new ClickableSpan(this) {
                final /* synthetic */ RegByMobileRegUI nKW;

                {
                    this.nKW = r1;
                }

                public final void onClick(View view) {
                    be.E(this.nKW.nDR.nEl, this.nKW.getString(2131235735));
                }
            }, string3.length() + str.length(), (string3.length() + string2.length()) + str.length(), 33);
            this.nKt.setText(newSpannable);
        } else {
            string2 = getString(2131233503);
            String string4 = getString(2131233502);
            String string5 = getString(2131230898);
            CharSequence newSpannable2 = Factory.getInstance().newSpannable(string3 + str + string2 + string5 + string4);
            newSpannable2.setSpan(new ClickableSpan(this) {
                final /* synthetic */ RegByMobileRegUI nKW;

                {
                    this.nKW = r1;
                }

                public final void onClick(View view) {
                    be.E(this.nKW.nDR.nEl, this.nKW.getString(2131235739));
                }
            }, string3.length() + str.length(), (string3.length() + str.length()) + string2.length(), 33);
            newSpannable2.setSpan(new ClickableSpan(this) {
                final /* synthetic */ RegByMobileRegUI nKW;

                {
                    this.nKW = r1;
                }

                public final void onClick(View view) {
                    be.E(this.nKW.nDR.nEl, this.nKW.getString(2131235738));
                }
            }, ((string3.length() + string2.length()) + str.length()) + string5.length(), (((string3.length() + string2.length()) + str.length()) + string5.length()) + string4.length(), 33);
            this.nKt.setText(newSpannable2);
        }
        this.nKt.setMovementMethod(LinkMovementMethod.getInstance());
        this.nIE.addTextChangedListener(new c(this.nIE, null, 20));
        this.nIE.addTextChangedListener(new TextWatcher(this) {
            private al gJe = new al();
            final /* synthetic */ RegByMobileRegUI nKW;

            {
                this.nKW = r2;
            }

            public final void afterTextChanged(Editable editable) {
                String obj = this.nKW.nIE.getText().toString();
                if (!(obj == null || obj.equals(this.nKW.nIQ))) {
                    this.nKW.nIQ = al.formatNumber(this.nKW.nIH.getText().toString().replace("+", ""), obj);
                    this.nKW.nIE.setText(this.nKW.nIQ);
                    this.nKW.nIE.setSelection(this.nKW.nIE.getText().toString().length());
                }
                if (obj == null || obj.length() <= 0 || !this.nKW.nIN || !this.nKW.lPH.isChecked()) {
                    this.nKW.iT(false);
                } else {
                    this.nKW.iT(true);
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.nIE.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ RegByMobileRegUI nKW;

            {
                this.nKW = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i != 6 && i != 5) || !this.nKW.lPH.isChecked()) {
                    return false;
                }
                this.nKW.nIP = this.nKW.nIH.getText().toString().trim();
                this.nKW.hUm = this.nKW.nIE.getText().toString();
                String str = this.nKW.nIP + this.nKW.hUm;
                this.nKW.axg();
                RegByMobileRegUI.d(this.nKW, str);
                return true;
            }
        });
        this.nIE.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ RegByMobileRegUI nKW;

            {
                this.nKW = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0 || !this.nKW.lPH.isChecked()) {
                    return false;
                }
                this.nKW.nIP = this.nKW.nIH.getText().toString().trim();
                this.nKW.hUm = this.nKW.nIE.getText().toString();
                String str = this.nKW.nIP + this.nKW.hUm;
                this.nKW.axg();
                RegByMobileRegUI.d(this.nKW, str);
                return true;
            }
        });
        this.nIH.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ RegByMobileRegUI nKW;

            {
                this.nKW = r1;
            }

            public final void afterTextChanged(Editable editable) {
                String obj = this.nKW.nIH.getText().toString();
                if (be.kS(obj)) {
                    this.nKW.iT(false);
                    this.nKW.nIH.setText("+");
                    this.nKW.nIH.setSelection(this.nKW.nIH.getText().toString().length());
                } else {
                    if (!obj.contains("+")) {
                        this.nKW.nIH.setText("+" + obj);
                        this.nKW.nIH.setSelection(this.nKW.nIH.getText().toString().length());
                    } else if (obj.length() > 1) {
                        String substring = obj.substring(1);
                        if (substring.length() > 4) {
                            this.nKW.nIH.setText(substring.substring(0, 4));
                            return;
                        }
                        obj = (String) this.nKW.nIL.get(substring);
                        if (be.kS(obj)) {
                            this.nKW.nIG.setText(this.nKW.getString(2131233848));
                            this.nKW.nIN = false;
                        } else {
                            if (this.nKW.nIM.get(this.nKW.nIG.getText()) == null || !((String) this.nKW.nIM.get(this.nKW.nIG.getText())).equals(substring)) {
                                this.nKW.nIG.setText(obj);
                            }
                            this.nKW.nIN = true;
                        }
                    }
                    if (this.nKW.nIE.getText() == null && this.nKW.nIE.getText().toString().length() > 0 && this.nKW.nIN && this.nKW.lPH.isChecked()) {
                        this.nKW.iT(true);
                        return;
                    } else {
                        this.nKW.iT(false);
                    }
                }
                this.nKW.nIG.setText(this.nKW.getString(2131233849));
                if (this.nKW.nIE.getText() == null) {
                }
                this.nKW.iT(false);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        a(0, getString(2131231103), new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByMobileRegUI nKW;

            {
                this.nKW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nKW.nIP = this.nKW.nIH.getText().toString().trim();
                this.nKW.hUm = this.nKW.nIE.getText().toString();
                String str = this.nKW.nIP + this.nKW.hUm;
                this.nKW.axg();
                RegByMobileRegUI.d(this.nKW, str);
                return true;
            }
        });
        iT(false);
        if (be.kS(this.cQn) && be.kS(this.bfd)) {
            string3 = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            v.d("MicroMsg.RegByMobileRegUI", "tm.getSimCountryIso()" + string3);
            if (be.kS(string3)) {
                v.e("MicroMsg.RegByMobileRegUI", "getDefaultCountryInfo error");
            } else {
                a g = com.tencent.mm.af.b.g(this, string3, getString(2131232236));
                if (g == null) {
                    v.e("MicroMsg.RegByMobileRegUI", "getDefaultCountryInfo error");
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
            ak.vA().a(new ad.a(this) {
                String eRq;
                final /* synthetic */ RegByMobileRegUI nKW;

                {
                    this.nKW = r1;
                }

                public final boolean Ba() {
                    if (be.kS((this.nKW.nIE.getText()).trim())) {
                        this.nKW.nIE.setText(be.kS(this.eRq) ? "" : this.eRq);
                    }
                    return true;
                }

                public final boolean AZ() {
                    try {
                        this.eRq = com.tencent.mm.modelsimple.c.x(this.nKW, this.nKW.bfd);
                    } catch (Exception e) {
                        v.e("MicroMsg.RegByMobileRegUI", "getPhoneNum err: " + e.getMessage());
                    }
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|initView";
                }
            });
        } else {
            this.nIE.setText(this.nII);
        }
        this.nIF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegByMobileRegUI nKW;

            {
                this.nKW = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", this.nKW.cQn);
                intent.putExtra("couttry_code", this.nKW.bfd);
                com.tencent.mm.plugin.a.a.drp.b(intent, this.nKW);
            }
        });
        this.nIJ.setVisibility(8);
        if (this.dHn == 2 || this.dHn == 1) {
            this.nIJ.setVisibility(4);
            this.nKu.setVisibility(8);
            this.nKt.setVisibility(8);
        } else if (this.dHn == 0) {
            if (!com.tencent.mm.af.b.He()) {
                this.nIJ.setVisibility(8);
            } else if (be.KV("2013-11-30 00:00:00") >= 0 || be.bus() % 2 == 0) {
                v.i("MicroMsg.RegByMobileRegUI", "has overtime:[%d]", new Object[]{Long.valueOf(System.currentTimeMillis())});
                this.nIJ.setVisibility(4);
            } else {
                this.nKV = true;
                this.nIJ.setText(2131234420);
                this.nIJ.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ RegByMobileRegUI nKW;

                    {
                        this.nKW = r1;
                    }

                    public final void onClick(View view) {
                        b.mi("R500_100");
                        this.nKW.startActivity(new Intent(this.nKW, RegByEmailUI.class));
                    }
                });
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByMobileRegUI nKW;

            {
                this.nKW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nKW.axg();
                this.nKW.aKM();
                this.nKW.finish();
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        aKM();
        return true;
    }

    private void aKM() {
        b.mi(this.ivg);
        finish();
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

    public final void a(int i, final int i2, String str, k kVar) {
        v.i("MicroMsg.RegByMobileRegUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.nIO != null) {
            this.nIO.dismiss();
            this.nIO = null;
        }
        if (kVar.getType() == 132) {
            if (i != 0 || i2 != 0) {
                Toast.makeText(this, getString(2131231444, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            } else if (((com.tencent.mm.modelfriend.v) kVar).AG() == 1) {
                if (this.dHn == 2) {
                    b.mi("L3");
                } else if (this.dHn == 0) {
                    b.mi("R200_300");
                }
                Intent intent = new Intent();
                intent.putExtra("bindmcontact_mobile", this.nIP + " " + this.nIE.getText().toString());
                intent.putExtra("bindmcontact_shortmobile", this.nIE.getText().toString().trim());
                intent.putExtra("country_name", this.cQn);
                intent.putExtra("couttry_code", this.bfd);
                intent.putExtra("login_type", this.dHn);
                if (this.dHn == 2) {
                    intent.putExtra("mobile_verify_purpose", 3);
                } else if (this.dHn == 0) {
                    intent.putExtra("mobile_verify_purpose", 2);
                }
                intent.putExtra("regsetinfo_ticket", this.cZU);
                intent.putExtra("regsetinfo_NextStep", this.nKT);
                intent.putExtra("regsetinfo_NextStyle", this.nKU);
                a(MobileVerifyUI.class, intent);
                finish();
            }
        } else if (i2 == -75) {
            g.f(this, 2131230895, 2131234378);
        } else {
            com.tencent.mm.f.a dm;
            if (kVar.getType() == 145) {
                int AG = ((u) kVar).AG();
                if (AG == 12) {
                    if (i2 == -41 || i2 == -59) {
                        dm = com.tencent.mm.f.a.dm(str);
                        if (dm != null) {
                            dm.a(this, null, null);
                            return;
                        } else {
                            g.f(this, 2131234422, 2131234423);
                            return;
                        }
                    } else if (i2 == -36 || i2 == -35 || i2 == -3) {
                        String Fk = ((u) kVar).Fk();
                        if (!be.kS(Fk)) {
                            this.hUm = Fk.trim();
                        }
                        this.hUm = al.Kq(this.hUm);
                        this.nKs = this.nIP + this.hUm;
                        if (this.dHn == 0) {
                            b.b(true, ak.uR() + "," + getClass().getName() + ",R200_200," + ak.dR("R200_200") + ",1");
                        } else if (this.dHn == 2) {
                            b.b(true, ak.uR() + "," + getClass().getName() + ",F200_200," + ak.dR("F200_200") + ",1");
                        }
                        dm = com.tencent.mm.f.a.dm(str);
                        if (dm != null) {
                            dm.a(this, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ RegByMobileRegUI nKW;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    RegByMobileRegUI regByMobileRegUI = this.nKW;
                                    RegByMobileRegUI regByMobileRegUI2 = this.nKW;
                                    this.nKW.getString(2131231164);
                                    regByMobileRegUI.nIO = g.a(regByMobileRegUI2, this.nKW.getString(2131234410), true, new OnCancelListener(this) {
                                        final /* synthetic */ AnonymousClass7 nKX;

                                        {
                                            this.nKX = r1;
                                        }

                                        public final void onCancel(DialogInterface dialogInterface) {
                                        }
                                    });
                                    ak.vy().a(new u(this.nKW.nIP + this.nKW.hUm, i2 == -3 ? 8 : 14, "", 0, ""), 0);
                                    if (this.nKW.dHn == 0) {
                                        b.b(true, ak.uR() + "," + this.nKW.getClass().getName() + ",R200_200," + ak.dR("R200_200") + ",2");
                                    } else if (this.nKW.dHn == 2) {
                                        b.b(true, ak.uR() + "," + this.nKW.getClass().getName() + ",F200_200," + ak.dR("F200_200") + ",2");
                                    }
                                }
                            }, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ RegByMobileRegUI nKW;

                                {
                                    this.nKW = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (this.nKW.dHn == 0) {
                                        b.b(true, ak.uR() + "," + this.nKW.getClass().getName() + ",R200_200," + ak.dR("R200_200") + ",2");
                                    } else if (this.nKW.dHn == 2) {
                                        b.b(true, ak.uR() + "," + this.nKW.getClass().getName() + ",F200_200," + ak.dR("F200_200") + ",2");
                                    }
                                }
                            });
                            return;
                        }
                        getString(2131231164);
                        this.nIO = g.a(this, getString(2131234410), true, new OnCancelListener(this) {
                            final /* synthetic */ RegByMobileRegUI nKW;

                            {
                                this.nKW = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        });
                        ak.vy().a(new u(this.nIP + this.hUm, i2 == -3 ? 8 : 14, "", 0, ""), 0);
                        if (this.dHn == 0) {
                            b.b(true, ak.uR() + "," + getClass().getName() + ",R200_200," + ak.dR("R200_200") + ",2");
                            return;
                        } else if (this.dHn == 2) {
                            b.b(true, ak.uR() + "," + getClass().getName() + ",F200_200," + ak.dR("F200_200") + ",2");
                            return;
                        } else {
                            return;
                        }
                    } else if (i2 == -34) {
                        g.A(this, getString(2131231402), "");
                        return;
                    } else {
                        Toast.makeText(this, getString(2131231444, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    }
                }
                if (AG == 14) {
                    if (i2 == -41) {
                        g.f(this, 2131234422, 2131234423);
                        return;
                    }
                    b.mi("R200_300");
                    Intent intent2 = new Intent();
                    intent2.putExtra("bindmcontact_mobile", this.nIP + " " + this.nIE.getText().toString());
                    intent2.putExtra("bindmcontact_shortmobile", this.hUm);
                    intent2.putExtra("country_name", this.cQn);
                    intent2.putExtra("couttry_code", this.bfd);
                    intent2.putExtra("login_type", this.dHn);
                    intent2.putExtra("mobileverify_countdownsec", ((u) kVar).Fm());
                    intent2.putExtra("mobileverify_countdownstyle", ((u) kVar).Fn());
                    intent2.putExtra("mobileverify_fb", ((u) kVar).Fo());
                    intent2.putExtra("mobileverify_reg_qq", ((u) kVar).Fq());
                    intent2.putExtra("mobile_verify_purpose", 2);
                    a(MobileVerifyUI.class, intent2);
                }
                if (AG == 8) {
                    if (i2 == 0) {
                        Intent intent3 = new Intent();
                        intent3.putExtra("bindmcontact_mobile", this.nIP + " " + this.nIE.getText().toString());
                        intent3.putExtra("bindmcontact_shortmobile", this.hUm);
                        intent3.putExtra("country_name", this.cQn);
                        intent3.putExtra("couttry_code", this.bfd);
                        intent3.putExtra("login_type", this.dHn);
                        intent3.putExtra("mobileverify_countdownsec", ((u) kVar).Fm());
                        intent3.putExtra("mobileverify_countdownstyle", ((u) kVar).Fn());
                        intent3.putExtra("mobileverify_fb", ((u) kVar).Fo());
                        intent3.putExtra("mobileverify_reg_qq", ((u) kVar).Fq());
                        intent3.putExtra("mobile_verify_purpose", 2);
                        a(MobileVerifyUI.class, intent3);
                    } else {
                        g.f(this, 2131234422, 2131234423);
                        return;
                    }
                }
            }
            if (kVar.getType() == 701) {
                dm = com.tencent.mm.f.a.dm(str);
                if (dm != null && dm.a(this, null, null)) {
                }
            }
        }
    }
}
