package com.tencent.mm.ui.account;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.a.a.f;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.j.a;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormMobileInputView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public class RegByMobileRegAIOUI extends MMActivity implements e {
    private String bfd = null;
    private String cQn = null;
    private int dHn;
    private ImageView dtX;
    private String hUm = null;
    private String ivg;
    private EditText nIE;
    private LinearLayout nIF;
    private TextView nIG;
    private String nII = null;
    private Map<String, String> nIL = new HashMap();
    protected Map<String, String> nIM = new HashMap();
    private boolean nIN = true;
    private p nIO;
    private String nIP = null;
    private ResizeLayout nJm;
    private int nKA = 0;
    private boolean nKB;
    private boolean nKC;
    private ScrollView nKD;
    private boolean nKE = false;
    private ProgressBar nKF;
    private h nKG = null;
    private ac nKH = new ac(this) {
        final /* synthetic */ RegByMobileRegAIOUI nKQ;

        {
            this.nKQ = r1;
        }

        public final void handleMessage(Message message) {
            if ((this.nKQ.nKG == null || this.nKQ.nKG.isShowing()) && !this.nKQ.nKJ) {
                RegByMobileRegAIOUI.t(this.nKQ);
                this.nKQ.nKF.setProgress(this.nKQ.progress);
                if (this.nKQ.progress < this.nKQ.nKF.getMax()) {
                    sendEmptyMessageDelayed(0, 10);
                    return;
                }
                this.nKQ.nKF.setIndeterminate(true);
                if (!this.nKQ.nKJ) {
                    if (this.nKQ.nKG != null) {
                        this.nKQ.nKG.dismiss();
                    }
                    this.nKQ.Oi(null);
                }
            }
        }
    };
    private j nKI;
    private boolean nKJ = false;
    private a nKK = new a(this) {
        final /* synthetic */ RegByMobileRegAIOUI nKQ;

        {
            this.nKQ = r1;
        }

        public final void Oj(String str) {
            this.nKQ.Oi(str.trim());
        }

        public final void bAX() {
            this.nKQ.Oi(null);
        }
    };
    private int nKL;
    private int nKM;
    private boolean nKN;
    private boolean nKO;
    private final int nKP = FileUtils.S_IWUSR;
    private EditText nKp;
    private MMFormMobileInputView nKq;
    private String nKr;
    private String nKs;
    private TextView nKt;
    private Button nKu;
    private Button nKv;
    private MMFormInputView nKw;
    private boolean nKx = false;
    private ImageView nKy;
    private MMFormInputView nKz;
    private int progress = 0;

    static /* synthetic */ class AnonymousClass17 {
        static final /* synthetic */ int[] nKo = new int[a.bBj().length];

        static {
            try {
                nKo[a.nMx - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                nKo[a.nMy - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                nKo[a.nMA - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                nKo[a.nMz - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    static /* synthetic */ void a(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        View currentFocus = regByMobileRegAIOUI.getWindow().getCurrentFocus();
        if (currentFocus != null) {
            int[] iArr = new int[2];
            currentFocus.getLocationInWindow(iArr);
            final int height = (iArr[1] - regByMobileRegAIOUI.cU().cV().getHeight()) - 128;
            if (height > 0) {
                regByMobileRegAIOUI.nKD.post(new Runnable(regByMobileRegAIOUI) {
                    final /* synthetic */ RegByMobileRegAIOUI nKQ;

                    public final void run() {
                        this.nKQ.nKD.smoothScrollBy(0, height);
                    }
                });
            }
        }
    }

    static /* synthetic */ boolean b(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        String str = null;
        if (!(regByMobileRegAIOUI.nKp == null || regByMobileRegAIOUI.nKp.getText() == null || regByMobileRegAIOUI.nKp.getText().toString() == null)) {
            str = regByMobileRegAIOUI.nKp.getText().toString();
            if (str.startsWith("+")) {
                str = str.substring(1);
            }
        }
        int i = (str == null || str.length() == 0) ? 0 : 1;
        boolean a = regByMobileRegAIOUI.nKC ? i & regByMobileRegAIOUI.a(regByMobileRegAIOUI.nIE.getText(), regByMobileRegAIOUI.nKw.getText(), regByMobileRegAIOUI.nKz.getText()) : i & regByMobileRegAIOUI.a(regByMobileRegAIOUI.nIE.getText(), regByMobileRegAIOUI.nKz.getText());
        if (a) {
            regByMobileRegAIOUI.nKv.setEnabled(true);
        } else {
            regByMobileRegAIOUI.nKv.setEnabled(false);
        }
        return a;
    }

    static /* synthetic */ void c(RegByMobileRegAIOUI regByMobileRegAIOUI, String str) {
        String obj;
        if (regByMobileRegAIOUI.nKC) {
            int i;
            obj = regByMobileRegAIOUI.nKw.getText().toString();
            if (obj.length() > 16) {
                regByMobileRegAIOUI.vU(a.nMy);
                i = 0;
            } else if (be.Ku(obj)) {
                g.f(regByMobileRegAIOUI, 2131234409, 2131234430);
                i = 0;
            } else if (be.Kz(obj)) {
                boolean z = true;
            } else {
                if (obj.length() < 8 || obj.length() >= 16) {
                    regByMobileRegAIOUI.vU(a.nMz);
                } else {
                    regByMobileRegAIOUI.vU(a.nMA);
                }
                i = 0;
            }
            if (i == 0) {
                return;
            }
        }
        if (regByMobileRegAIOUI.nIO != null) {
            v.d("MicroMsg.RegByMobileRegAIOUI", "already checking ");
            return;
        }
        regByMobileRegAIOUI.getString(2131231164);
        regByMobileRegAIOUI.nIO = g.a((Context) regByMobileRegAIOUI, regByMobileRegAIOUI.getString(2131234410), true, new OnCancelListener(regByMobileRegAIOUI) {
            final /* synthetic */ RegByMobileRegAIOUI nKQ;

            {
                this.nKQ = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        if (regByMobileRegAIOUI.dHn == 0) {
            obj = al.Kq(regByMobileRegAIOUI.nIE.getText().toString().trim());
            int i2 = (regByMobileRegAIOUI.nKr == null || regByMobileRegAIOUI.nKs == null || obj.equals(regByMobileRegAIOUI.nKr) || !obj.equals(regByMobileRegAIOUI.nKs)) ? (regByMobileRegAIOUI.nKr == null || regByMobileRegAIOUI.nKs == null || regByMobileRegAIOUI.nKs.equals(regByMobileRegAIOUI.nKr) || obj.equals(regByMobileRegAIOUI.nKs)) ? 0 : 2 : 1;
            k uVar = new u(str, 12, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty);
            uVar.fq(regByMobileRegAIOUI.nKA);
            uVar.fr(i2);
            ak.vy().a(uVar, 0);
            regByMobileRegAIOUI.nKr = al.Kq(regByMobileRegAIOUI.nIE.getText().toString().trim());
            regByMobileRegAIOUI.nKA++;
            return;
        }
        throw new IllegalArgumentException("NO IMPLEMENT");
    }

    static /* synthetic */ int t(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        int i = regByMobileRegAIOUI.progress + 2;
        regByMobileRegAIOUI.progress = i;
        return i;
    }

    protected final int getLayoutId() {
        return 2130904269;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cQn = be.ah(getIntent().getStringExtra("country_name"), SQLiteDatabase.KeyEmpty);
        this.bfd = be.ah(getIntent().getStringExtra("couttry_code"), SQLiteDatabase.KeyEmpty);
        this.nII = be.ah(getIntent().getStringExtra("bindmcontact_shortmobile"), SQLiteDatabase.KeyEmpty);
        this.dHn = getIntent().getIntExtra("login_type", 0);
        this.ivg = b.Oa();
        com.tencent.mm.model.be.zN();
        b.gM(20);
        NI();
    }

    public void onResume() {
        super.onResume();
        ak.vy().a(701, (e) this);
        ak.vy().a(145, (e) this);
        ak.vy().a(132, (e) this);
        b.b(true, ak.uR() + "," + getClass().getName() + ",RE200_100," + ak.dR("RE200_100") + ",1");
        this.nKp.setSelection(this.nKp.getText().toString().length());
        aJs();
        this.nKA = 0;
    }

    public void onPause() {
        super.onPause();
        ak.vy().b(701, (e) this);
        ak.vy().b(145, (e) this);
        ak.vy().b(132, (e) this);
        b.mh("RE200_100");
    }

    protected final void NI() {
        this.nIL.clear();
        String[] split = getString(2131232236).trim().split(",");
        for (String trim : split) {
            String trim2;
            String[] split2 = trim2.trim().split(":");
            if (split2.length < 2) {
                v.e("MicroMsg.RegByMobileRegAIOUI", "this country item has problem %s", split[r0]);
            } else {
                this.nIL.put(split2[0], split2[1]);
                this.nIM.put(split2[1], split2[0]);
            }
        }
        this.nIF = (LinearLayout) findViewById(2131755574);
        this.nIG = (TextView) findViewById(2131755576);
        this.nKq = (MMFormMobileInputView) findViewById(2131758311);
        this.nIE = this.nKq.nVf;
        this.nKp = this.nKq.nKp;
        this.nKp.setText(getString(2131232237));
        this.nKt = (TextView) findViewById(2131758315);
        this.nKv = (Button) findViewById(2131758863);
        this.dtX = (ImageView) findViewById(2131758860);
        this.nKy = (ImageView) findViewById(2131758861);
        this.nKw = (MMFormInputView) findViewById(2131758862);
        c.b(this.nKw.idd).yn(16).a(null);
        this.nKD = (ScrollView) findViewById(f.Jr);
        this.nJm = (ResizeLayout) findViewById(2131757724);
        this.nKz = (MMFormInputView) findViewById(2131758858);
        this.nKz.idd.requestFocus();
        this.nJm.nMr = new ResizeLayout.a(this) {
            final /* synthetic */ RegByMobileRegAIOUI nKQ;

            {
                this.nKQ = r1;
            }

            public final void dd(int i, int i2) {
                RegByMobileRegAIOUI.a(this.nKQ);
            }
        };
        OnFocusChangeListener anonymousClass12 = new OnFocusChangeListener(this) {
            final /* synthetic */ RegByMobileRegAIOUI nKQ;

            {
                this.nKQ = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    RegByMobileRegAIOUI.a(this.nKQ);
                }
            }
        };
        this.nKz.nVd = anonymousClass12;
        this.nKw.nVd = anonymousClass12;
        com.tencent.mm.model.be.zN();
        this.nKC = true;
        com.tencent.mm.model.be.zN();
        this.nKB = true;
        if (!this.nKB) {
            this.dtX.setVisibility(8);
            this.nKy.setVisibility(8);
        }
        if (!this.nKC) {
            this.nKw.setVisibility(8);
        }
        String string = getString(2131234448);
        if (d.lWk) {
            string = string + getString(2131230892);
        }
        Fd(string);
        if (this.nKu != null) {
            this.nKu.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ RegByMobileRegAIOUI nKQ;

                {
                    this.nKQ = r1;
                }

                public final void onClick(View view) {
                    be.E(this.nKQ.nDR.nEl, this.nKQ.getString(2131235735));
                }
            });
        }
        string = getString(2131233500);
        String str = "  ";
        if (com.tencent.mm.sdk.platformtools.u.bsV()) {
            trim2 = getString(2131233501);
            CharSequence newSpannable = Factory.getInstance().newSpannable(string + str + trim2);
            newSpannable.setSpan(new ClickableSpan(this) {
                final /* synthetic */ RegByMobileRegAIOUI nKQ;

                {
                    this.nKQ = r1;
                }

                public final void onClick(View view) {
                    be.E(this.nKQ.nDR.nEl, this.nKQ.getString(2131235735));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(this.nKQ.getResources().getColor(2131689819));
                    textPaint.setUnderlineText(true);
                }
            }, string.length() + str.length(), (string.length() + trim2.length()) + str.length(), 33);
            this.nKt.setText(newSpannable);
        } else {
            trim2 = getString(2131233503);
            String string2 = getString(2131233502);
            String string3 = getString(2131230898);
            CharSequence newSpannable2 = Factory.getInstance().newSpannable(string + str + trim2 + string3 + string2);
            newSpannable2.setSpan(new ClickableSpan(this) {
                final /* synthetic */ RegByMobileRegAIOUI nKQ;

                {
                    this.nKQ = r1;
                }

                public final void onClick(View view) {
                    be.E(this.nKQ.nDR.nEl, this.nKQ.getString(2131235739));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(this.nKQ.getResources().getColor(2131689819));
                    textPaint.setUnderlineText(true);
                }
            }, string.length() + str.length(), (string.length() + str.length()) + trim2.length(), 33);
            newSpannable2.setSpan(new ClickableSpan(this) {
                final /* synthetic */ RegByMobileRegAIOUI nKQ;

                {
                    this.nKQ = r1;
                }

                public final void onClick(View view) {
                    be.E(this.nKQ.nDR.nEl, this.nKQ.getString(2131235738));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(this.nKQ.getResources().getColor(2131689819));
                    textPaint.setUnderlineText(true);
                }
            }, ((string.length() + trim2.length()) + str.length()) + string3.length(), (((string.length() + trim2.length()) + str.length()) + string3.length()) + string2.length(), 33);
            this.nKt.setText(newSpannable2);
        }
        this.nKt.setMovementMethod(LinkMovementMethod.getInstance());
        this.nIE.addTextChangedListener(new TextWatcher(this) {
            private al gJe = new al();
            final /* synthetic */ RegByMobileRegAIOUI nKQ;

            {
                this.nKQ = r2;
            }

            public final void afterTextChanged(Editable editable) {
                RegByMobileRegAIOUI.b(this.nKQ);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.nKq.nVi = new MMFormMobileInputView.a(this) {
            final /* synthetic */ RegByMobileRegAIOUI nKQ;

            {
                this.nKQ = r1;
            }

            public final void Ok(String str) {
                if (be.kS(str) || str.length() <= 1) {
                    this.nKQ.nIG.setText(this.nKQ.getString(2131233849));
                } else {
                    String substring = str.substring(1);
                    String str2 = (String) this.nKQ.nIL.get(substring);
                    if (be.kS(str2)) {
                        this.nKQ.nIG.setText(this.nKQ.getString(2131233848));
                        this.nKQ.nIN = false;
                    } else {
                        if (this.nKQ.nIM.get(this.nKQ.nIG.getText()) == null || !((String) this.nKQ.nIM.get(this.nKQ.nIG.getText())).equals(substring)) {
                            this.nKQ.nIG.setText(str2);
                        }
                        this.nKQ.nIN = true;
                    }
                }
                RegByMobileRegAIOUI.b(this.nKQ);
            }
        };
        this.nKw.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ RegByMobileRegAIOUI nKQ;

            {
                this.nKQ = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                RegByMobileRegAIOUI.b(this.nKQ);
            }
        });
        this.nKz.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ RegByMobileRegAIOUI nKQ;

            {
                this.nKQ = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                RegByMobileRegAIOUI.b(this.nKQ);
            }
        });
        this.nKv.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegByMobileRegAIOUI nKQ;

            {
                this.nKQ = r1;
            }

            public final void onClick(View view) {
                c dw = c.b(this.nKQ.nKz.idd).dw(1, 32);
                dw.oWy = true;
                dw.a(new c.a(this) {
                    final /* synthetic */ AnonymousClass3 nKR;

                    {
                        this.nKR = r1;
                    }

                    public final void qK(String str) {
                        this.nKR.nKQ.nIP = this.nKR.nKQ.nKp.getText().toString().trim();
                        this.nKR.nKQ.hUm = al.Kq(this.nKR.nKQ.nIE.getText().toString());
                        String str2 = this.nKR.nKQ.nIP + this.nKR.nKQ.hUm;
                        this.nKR.nKQ.axg();
                        RegByMobileRegAIOUI.c(this.nKR.nKQ, str2);
                    }

                    public final void adq() {
                        g.f(this.nKR.nKQ, 2131235061, 2131235064);
                    }

                    public final void adr() {
                        g.f(this.nKR.nKQ, 2131235062, 2131235064);
                    }
                });
            }
        });
        this.nKv.setEnabled(false);
        if (be.kS(this.cQn) && be.kS(this.bfd)) {
            string = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            v.i("MicroMsg.RegByMobileRegAIOUI", "tm.getSimCountryIso()" + string);
            if (be.kS(string)) {
                v.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
            } else {
                com.tencent.mm.af.b.a g = com.tencent.mm.af.b.g(this, string, getString(2131232236));
                if (g == null) {
                    v.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
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
            this.nKp.setText("+" + this.bfd);
        }
        if (this.nII == null || this.nII.equals(SQLiteDatabase.KeyEmpty)) {
            ak.vA().a(new ad.a(this) {
                String eRq;
                final /* synthetic */ RegByMobileRegAIOUI nKQ;

                {
                    this.nKQ = r1;
                }

                public final boolean Ba() {
                    if (be.kS((this.nKQ.nIE.getText()).trim())) {
                        this.nKQ.nIE.setText(be.kS(this.eRq) ? SQLiteDatabase.KeyEmpty : this.eRq);
                    }
                    return true;
                }

                public final boolean AZ() {
                    this.eRq = com.tencent.mm.modelsimple.c.x(this.nKQ, this.nKQ.bfd);
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|initView1";
                }
            });
        } else {
            this.nIE.setText(this.nII);
        }
        this.nIF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegByMobileRegAIOUI nKQ;

            {
                this.nKQ = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("country_name", this.nKQ.cQn);
                intent.putExtra("couttry_code", this.nKQ.bfd);
                com.tencent.mm.plugin.a.a.drp.b(intent, this.nKQ);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RegByMobileRegAIOUI nKQ;

            {
                this.nKQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nKQ.axg();
                this.nKQ.aKM();
                this.nKQ.finish();
                return true;
            }
        });
        this.dtX.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RegByMobileRegAIOUI nKQ;

            {
                this.nKQ = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.a.a.drq.c(this.nKQ);
            }
        });
        ak.vA().a(new ad.a(this) {
            Bitmap bitmap;
            String cID;
            final /* synthetic */ RegByMobileRegAIOUI nKQ;

            {
                this.nKQ = r1;
            }

            public final boolean Ba() {
                if (!be.kS(this.cID) && be.kS((this.nKQ.nKz.getText()).trim())) {
                    MMFormInputView i = this.nKQ.nKz;
                    CharSequence charSequence = this.cID;
                    if (i.idd != null) {
                        i.idd.setText(charSequence);
                    } else {
                        v.e("MicroMsg.MMFormInputView", "contentET is null!");
                    }
                }
                if (com.tencent.mm.compatible.util.f.sj()) {
                    if (!(this.bitmap == null || this.bitmap.isRecycled() || this.nKQ.nKx)) {
                        this.nKQ.dtX.setImageBitmap(this.bitmap);
                        this.nKQ.nKy.setVisibility(8);
                        this.nKQ.nKx = true;
                    }
                    return true;
                }
                v.e("MicroMsg.RegByMobileRegAIOUI", "SDcard is not available");
                return false;
            }

            public final boolean AZ() {
                this.cID = com.tencent.mm.modelsimple.c.aV(this.nKQ);
                this.bitmap = com.tencent.mm.modelsimple.c.aW(this.nKQ);
                if (!(this.bitmap == null || this.bitmap.isRecycled())) {
                    try {
                        com.tencent.mm.sdk.platformtools.d.a(this.bitmap, 100, CompressFormat.PNG, com.tencent.mm.compatible.util.e.cgo + "temp.avatar", false);
                    } catch (Throwable e) {
                        v.e("MicroMsg.RegByMobileRegAIOUI", "save avatar fail." + e.getMessage());
                        v.a("MicroMsg.RegByMobileRegAIOUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
                return true;
            }

            public final String toString() {
                return super.toString() + "|initView2";
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
        b.b(false, ak.uR() + "," + getClass().getName() + ",RE200_100," + ak.dR("RE200_100") + ",2");
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case 100:
                this.cQn = be.ah(intent.getStringExtra("country_name"), SQLiteDatabase.KeyEmpty);
                this.bfd = be.ah(intent.getStringExtra("couttry_code"), SQLiteDatabase.KeyEmpty);
                if (!this.cQn.equals(SQLiteDatabase.KeyEmpty)) {
                    this.nIG.setText(this.cQn);
                }
                if (!this.bfd.equals(SQLiteDatabase.KeyEmpty)) {
                    this.nKp.setText("+" + this.bfd);
                    return;
                }
                return;
            default:
                Bitmap a = com.tencent.mm.plugin.a.a.drq.a((Activity) this, i, i2, intent);
                if (a != null) {
                    this.dtX.setImageBitmap(a);
                    this.nKx = true;
                    this.nKy.setVisibility(8);
                    return;
                }
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.RegByMobileRegAIOUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.nIO != null) {
            this.nIO.dismiss();
            this.nIO = null;
        }
        if (i2 == -75) {
            g.f(this, 2131230895, 2131234378);
            return;
        }
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
                    b.mh("RE200_100");
                    b.b(true, ak.uR() + "," + getClass().getName() + ",RE200_200," + ak.dR("RE200_200") + ",1");
                    dm = com.tencent.mm.f.a.dm(str);
                    if (dm != null) {
                        dm.a(this, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ RegByMobileRegAIOUI nKQ;

                            {
                                this.nKQ = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                RegByMobileRegAIOUI regByMobileRegAIOUI = this.nKQ;
                                Context context = this.nKQ;
                                this.nKQ.getString(2131231164);
                                regByMobileRegAIOUI.nIO = g.a(context, this.nKQ.getString(2131234410), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass10 nKS;

                                    {
                                        this.nKS = r1;
                                    }

                                    public final void onCancel(DialogInterface dialogInterface) {
                                    }
                                });
                                ak.vy().a(new u(this.nKQ.nIP + this.nKQ.hUm, 14, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty), 0);
                                b.mi("RE200_250");
                                this.nKQ.nKE = true;
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ RegByMobileRegAIOUI nKQ;

                            {
                                this.nKQ = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                b.b(false, ak.uR() + "," + this.nKQ.getClass().getName() + ",RE200_200," + ak.dR("RE200_200") + ",2");
                                b.mi("RE200_100");
                            }
                        });
                        return;
                    }
                    getString(2131231164);
                    this.nIO = g.a((Context) this, getString(2131234410), true, new OnCancelListener(this) {
                        final /* synthetic */ RegByMobileRegAIOUI nKQ;

                        {
                            this.nKQ = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    ak.vy().a(new u(this.nIP + this.hUm, 14, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty), 0);
                    b.mi("RE200_250");
                    this.nKE = false;
                    return;
                } else if (i2 == -34) {
                    g.A(this, getString(2131231402), SQLiteDatabase.KeyEmpty);
                    return;
                } else if (!com.tencent.mm.plugin.a.a.drq.a((Context) this, i, i2, str)) {
                    Toast.makeText(this, getString(2131231444, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                } else {
                    return;
                }
            }
            if (AG == 14) {
                if (i2 == 0 || str == null) {
                    this.nKL = ((u) kVar).Fm();
                    this.nKM = ((u) kVar).Fn();
                    this.nKN = ((u) kVar).Fo();
                    this.nKO = ((u) kVar).Fq();
                    if (this.nKI == null) {
                        this.nKI = new j(this, this.nKK);
                        this.nKI.bBk();
                    }
                    if (this.nKG == null) {
                        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(2130904266, null);
                        this.nKF = (ProgressBar) inflate.findViewById(2131758671);
                        TextView textView = (TextView) inflate.findViewById(2131758854);
                        this.nKG = g.a((Context) this, false, getString(2131231427), inflate, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, null, null);
                        textView.setText(this.nKp.getText().toString() + " " + this.nIE.getText().toString());
                    } else {
                        this.nKG.show();
                    }
                    this.progress = 0;
                    this.nKF.setIndeterminate(false);
                    this.nKH.sendEmptyMessage(10);
                } else if (i2 == -41) {
                    g.f(this, 2131234422, 2131234423);
                    return;
                } else if (i2 == -34) {
                    g.A(this, getString(2131231402), SQLiteDatabase.KeyEmpty);
                    return;
                } else if (!com.tencent.mm.plugin.a.a.drq.a((Context) this, i, i2, str)) {
                    Toast.makeText(this, getString(2131231444, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    return;
                } else {
                    return;
                }
            }
        }
        if (!com.tencent.mm.plugin.a.a.drq.a((Context) this, i, i2, str) && kVar.getType() == 701) {
            dm = com.tencent.mm.f.a.dm(str);
            if (dm != null && dm.a(this, null, null)) {
            }
        }
    }

    protected void onDestroy() {
        if (this.nKI != null) {
            this.nKI.bBl();
            this.nKI = null;
        }
        if (this.nKG != null) {
            this.nKG.dismiss();
        }
        super.onDestroy();
    }

    private synchronized void Oi(String str) {
        if (this.nKI != null) {
            this.nKI.bBl();
            this.nKI = null;
        }
        if (!this.nKJ) {
            this.nKJ = true;
            finish();
            Intent intent = new Intent();
            intent.putExtra("bindmcontact_mobile", this.nIP + " " + this.nIE.getText().toString());
            intent.putExtra("bindmcontact_shortmobile", this.hUm);
            intent.putExtra("country_name", this.cQn);
            intent.putExtra("couttry_code", this.bfd);
            intent.putExtra("login_type", this.dHn);
            intent.putExtra("mobileverify_countdownsec", this.nKL);
            intent.putExtra("mobileverify_countdownstyle", this.nKM);
            intent.putExtra("mobileverify_fb", this.nKN);
            intent.putExtra("mobileverify_reg_qq", this.nKO);
            intent.putExtra("kintent_nickname", this.nKz.getText().toString());
            intent.putExtra("kintent_password", this.nKw.getText().toString());
            intent.putExtra("kintent_hasavatar", this.nKx);
            intent.putExtra("mobile_verify_purpose", 2);
            if (str != null && str.length() > 0) {
                intent.putExtra("MicroMsg.MobileVerifyUIIntent_sms_code", str);
            }
            a(MobileVerifyUI.class, intent);
        }
    }

    private boolean a(Editable... editableArr) {
        boolean z;
        for (Object obj : editableArr) {
            if (obj == null || obj.toString().length() == 0) {
                z = false;
                break;
            }
        }
        z = true;
        if (z && this.nIN) {
            return true;
        }
        return false;
    }

    private void vU(int i) {
        switch (AnonymousClass17.nKo[i - 1]) {
            case 1:
                g.f(this, 2131234428, 2131234430);
                return;
            case 2:
                g.f(this, 2131234429, 2131234430);
                return;
            case 3:
                g.f(this, 2131235779, 2131231040);
                return;
            case 4:
                g.f(this, 2131235781, 2131231040);
                return;
            default:
                return;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            int i2;
            String str = "MicroMsg.RegByMobileRegAIOUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            if (iArr == null) {
                i2 = -1;
            } else {
                i2 = iArr.length;
            }
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = be.bur();
            v.w(str, str2, objArr);
            return;
        }
        v.i("MicroMsg.RegByMobileRegAIOUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
                if (iArr[0] == 0 && this.nKI != null) {
                    this.nKI.bBm();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
