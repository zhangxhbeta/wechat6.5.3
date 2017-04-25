package com.tencent.mm.ui.account.mobile;

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
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormMobileInputView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public class MobileInputUI extends MMActivity {
    protected String bfd = null;
    protected String cQn = null;
    protected EditText fAv;
    protected String hUm = null;
    protected String ivg;
    protected TextView khi;
    protected CheckBox lPH;
    protected EditText nIE;
    protected LinearLayout nIF;
    protected TextView nIG;
    protected EditText nIH;
    protected String nII = null;
    protected Map<String, String> nIL = new HashMap();
    protected Map<String, String> nIM = new HashMap();
    protected boolean nIN = true;
    protected p nIO;
    protected String nIP = null;
    protected MMFormInputView nJT;
    protected boolean nJV = false;
    protected MMFormMobileInputView nKq;
    protected TextView nKt;
    protected Button nKu;
    protected Button nKv;
    protected TextView nNQ;
    protected View nNR;
    protected TextView nNS;
    protected Button nNT;
    protected Button nNU;
    private int nNV = 0;
    private b nNW;

    protected enum a {
        ;

        public static int[] bBs() {
            return (int[]) nOa.clone();
        }

        static {
            nNY = 1;
            nNZ = 2;
            nOa = new int[]{nNY, nNZ};
        }
    }

    public interface b {
        void a(MobileInputUI mobileInputUI);

        void start();

        void stop();

        void vW(int i);
    }

    static /* synthetic */ boolean c(MobileInputUI mobileInputUI) {
        if (mobileInputUI.nNV == 5) {
            mobileInputUI.fAv.requestFocus();
        } else if (mobileInputUI.bBq() && !mobileInputUI.lPH.isChecked()) {
            return false;
        } else {
            mobileInputUI.bBr();
        }
        return true;
    }

    protected final int getLayoutId() {
        return 2130904087;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nNV = getIntent().getIntExtra("mobile_input_purpose", 0);
        switch (this.nNV) {
            case 1:
                this.nNW = new d();
                break;
            case 2:
                this.nNW = new e();
                break;
            case 3:
                this.nNW = new b();
                break;
            case 4:
                this.nNW = new e();
                break;
            case 5:
                this.nNW = new c();
                break;
            default:
                v.e("MicroMsg.MobileInputUI", "wrong purpose %s", Integer.valueOf(this.nNV));
                finish();
                return;
        }
        this.cQn = be.ah(getIntent().getStringExtra("country_name"), SQLiteDatabase.KeyEmpty);
        this.bfd = be.ah(getIntent().getStringExtra("couttry_code"), SQLiteDatabase.KeyEmpty);
        this.nII = be.ah(getIntent().getStringExtra("bindmcontact_shortmobile"), SQLiteDatabase.KeyEmpty);
        this.ivg = com.tencent.mm.plugin.a.b.Oa();
        NI();
        String stringExtra = getIntent().getStringExtra("mobile_cc");
        String stringExtra2 = getIntent().getStringExtra("mobile_number");
        this.nJV = getIntent().getBooleanExtra("from_deep_link", false);
        if (!(be.kS(stringExtra) || be.kS(stringExtra2))) {
            this.nIP = stringExtra;
            this.hUm = stringExtra2;
            MMFormMobileInputView mMFormMobileInputView = this.nKq;
            CharSequence charSequence = this.nIP;
            if (mMFormMobileInputView.nKp != null) {
                mMFormMobileInputView.nKp.setText(charSequence);
            } else {
                v.e("MicroMsg.MMFormMobileInputView", "countryCodeET is null!");
            }
            mMFormMobileInputView = this.nKq;
            charSequence = this.hUm;
            if (mMFormMobileInputView.nVf != null) {
                mMFormMobileInputView.nVf.setText(charSequence);
            } else {
                v.e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
            }
        }
        this.nNW.a(this);
    }

    public void onResume() {
        super.onResume();
        this.nNW.start();
        this.nIH.setSelection(this.nIH.getText().toString().length());
        aJs();
    }

    public void onPause() {
        super.onPause();
        this.nNW.stop();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private boolean bBq() {
        return this.nNV == 2;
    }

    protected final void NI() {
        this.nIL.clear();
        String[] split = getString(2131232236).trim().split(",");
        for (String trim : split) {
            String[] split2 = trim.trim().split(":");
            if (split2.length < 2) {
                v.e("MicroMsg.MobileInputUI", "this country item has problem %s", split[r0]);
            } else {
                this.nIL.put(split2[0], split2[1]);
                this.nIM.put(split2[1], split2[0]);
            }
        }
        this.nJT = (MMFormInputView) findViewById(2131758312);
        this.fAv = this.nJT.idd;
        c.b(this.fAv).yn(16).a(null);
        this.nKq = (MMFormMobileInputView) findViewById(2131758311);
        this.nIE = this.nKq.nVf;
        this.nIE.requestFocus();
        this.nIH = this.nKq.nKp;
        this.nIF = (LinearLayout) findViewById(2131755574);
        this.nIG = (TextView) findViewById(2131755576);
        this.nNQ = (TextView) findViewById(2131757741);
        this.nNR = findViewById(2131758314);
        this.lPH = (CheckBox) findViewById(2131758285);
        this.nKt = (TextView) findViewById(2131758315);
        this.nKu = (Button) findViewById(2131758286);
        this.nKv = (Button) findViewById(2131756365);
        this.nNS = (TextView) findViewById(2131758309);
        this.khi = (TextView) findViewById(2131758310);
        this.nNT = (Button) findViewById(2131758313);
        this.nNU = (Button) findViewById(2131757740);
        this.nJT.setVisibility(8);
        this.nNS.setVisibility(8);
        this.nKv.setVisibility(8);
        this.nNQ.setVisibility(8);
        this.nNR.setVisibility(8);
        this.nNT.setVisibility(8);
        this.nNU.setVisibility(8);
        this.lPH.setVisibility(8);
        this.lPH.setChecked(true);
        String string = getString(2131234448);
        if (d.lWk) {
            string = getString(2131230720) + getString(2131230892);
        }
        Fd(string);
        this.nIE.addTextChangedListener(new TextWatcher(this) {
            private al gJe = new al();
            final /* synthetic */ MobileInputUI nNX;

            {
                this.nNX = r2;
            }

            public final void afterTextChanged(Editable editable) {
                String bBT = this.nNX.nKq.bBT();
                if (bBT == null || bBT.length() <= 0 || !this.nNX.nIN || (this.nNX.bBq() && !this.nNX.lPH.isChecked())) {
                    this.nNX.iT(false);
                    this.nNX.nKv.setEnabled(false);
                    return;
                }
                this.nNX.iT(true);
                this.nNX.nKv.setEnabled(true);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.nIE.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ MobileInputUI nNX;

            {
                this.nNX = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 5) {
                    return MobileInputUI.c(this.nNX);
                }
                return false;
            }
        });
        this.nIE.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ MobileInputUI nNX;

            {
                this.nNX = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 == i && keyEvent.getAction() == 0) {
                    return MobileInputUI.c(this.nNX);
                }
                return false;
            }
        });
        this.nKq.nVi = new com.tencent.mm.ui.base.MMFormMobileInputView.a(this) {
            final /* synthetic */ MobileInputUI nNX;

            {
                this.nNX = r1;
            }

            public final void Ok(String str) {
                if (be.kS(str)) {
                    this.nNX.iT(false);
                    this.nNX.nKv.setEnabled(false);
                } else if (str.length() > 1) {
                    String substring = str.substring(1);
                    String str2 = (String) this.nNX.nIL.get(substring);
                    if (be.kS(str2)) {
                        this.nNX.nIG.setText(this.nNX.getString(2131233848));
                        this.nNX.nIN = false;
                    } else {
                        if (this.nNX.nIM.get(this.nNX.nIG.getText()) == null || !((String) this.nNX.nIM.get(this.nNX.nIG.getText())).equals(substring)) {
                            this.nNX.nIG.setText(str2);
                        }
                        this.nNX.nIN = true;
                    }
                } else {
                    this.nNX.nIG.setText(this.nNX.getString(2131233849));
                }
                if (this.nNX.nIE.getText() == null || this.nNX.nIE.getText().toString().length() <= 0 || !this.nNX.nIN || (this.nNX.bBq() && !this.nNX.lPH.isChecked())) {
                    this.nNX.iT(false);
                    this.nNX.nKv.setEnabled(false);
                    return;
                }
                this.nNX.iT(true);
                this.nNX.nKv.setEnabled(true);
            }
        };
        a(0, getString(2131231103), new OnMenuItemClickListener(this) {
            final /* synthetic */ MobileInputUI nNX;

            {
                this.nNX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nNX.bBr();
                return true;
            }
        });
        iT(false);
        this.nKv.setEnabled(false);
        this.nKv.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MobileInputUI nNX;

            {
                this.nNX = r1;
            }

            public final void onClick(View view) {
                this.nNX.bBr();
            }
        });
        if (be.kS(this.cQn) && be.kS(this.bfd)) {
            string = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            v.d("MicroMsg.MobileInputUI", "tm.getSimCountryIso()" + string);
            if (be.kS(string)) {
                v.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
            } else {
                com.tencent.mm.af.b.a g = com.tencent.mm.af.b.g(this, string, getString(2131232236));
                if (g == null) {
                    v.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
                } else {
                    this.cQn = g.cQn;
                    this.bfd = g.cQm;
                }
            }
        }
        if (!(this.cQn == null || this.cQn.equals(SQLiteDatabase.KeyEmpty))) {
            this.nIG.setText(this.cQn);
        }
        if (!(this.bfd == null || this.bfd.equals(SQLiteDatabase.KeyEmpty))) {
            this.nIH.setText("+" + this.bfd);
        }
        if (this.nII != null && !this.nII.equals(SQLiteDatabase.KeyEmpty)) {
            this.nIE.setText(this.nII);
        } else if (this.nNV != 1) {
            ak.vA().a(new com.tencent.mm.sdk.platformtools.ad.a(this) {
                String eRq;
                final /* synthetic */ MobileInputUI nNX;

                {
                    this.nNX = r1;
                }

                public final boolean Ba() {
                    if (be.kS((this.nNX.nIE.getText()).trim())) {
                        this.nNX.nIE.setText(be.kS(this.eRq) ? SQLiteDatabase.KeyEmpty : this.eRq);
                    }
                    return true;
                }

                public final boolean AZ() {
                    this.eRq = com.tencent.mm.modelsimple.c.x(this.nNX, this.nNX.bfd);
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|getSimCardNum";
                }
            });
        }
        this.nIF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MobileInputUI nNX;

            {
                this.nNX = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", this.nNX.cQn);
                intent.putExtra("couttry_code", this.nNX.bfd);
                com.tencent.mm.plugin.a.a.drp.b(intent, this.nNX);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MobileInputUI nNX;

            {
                this.nNX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nNX.goBack();
                return true;
            }
        });
    }

    private void bBr() {
        this.nIP = this.nKq.getCountryCode();
        this.hUm = this.nKq.bBT();
        axg();
        this.nNW.vW(a.nNZ);
    }

    private void goBack() {
        this.nNW.vW(a.nNY);
        com.tencent.mm.plugin.a.b.mi(this.ivg);
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
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case -1:
                if (i == 1024 && intent != null) {
                    String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                    int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
                    String str = "MicroMsg.MobileInputUI";
                    String str2 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
                    Object[] objArr = new Object[3];
                    objArr[0] = Boolean.valueOf(be.kS(stringExtra));
                    if (!be.kS(stringExtra)) {
                        i3 = stringExtra.length();
                    }
                    objArr[1] = Integer.valueOf(i3);
                    objArr[2] = Integer.valueOf(intExtra);
                    v.d(str, str2, objArr);
                    if (intExtra == -217) {
                        bBr();
                        return;
                    }
                    return;
                }
                return;
            case 100:
                this.cQn = be.ah(intent.getStringExtra("country_name"), SQLiteDatabase.KeyEmpty);
                this.bfd = be.ah(intent.getStringExtra("couttry_code"), SQLiteDatabase.KeyEmpty);
                if (!this.cQn.equals(SQLiteDatabase.KeyEmpty)) {
                    this.nIG.setText(this.cQn);
                }
                if (!this.bfd.equals(SQLiteDatabase.KeyEmpty)) {
                    this.nIH.setText("+" + this.bfd);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setRequestedOrientation(int i) {
    }
}
