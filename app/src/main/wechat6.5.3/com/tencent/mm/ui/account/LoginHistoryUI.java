package com.tencent.mm.ui.account;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.support.v7.a.a.f;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.af.b;
import com.tencent.mm.e.a.v;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import org.json.JSONObject;

@a(19)
public class LoginHistoryUI extends MMActivity implements e {
    private String bpX = SQLiteDatabase.KeyEmpty;
    private SharedPreferences cnm;
    protected ProgressDialog dwR = null;
    private EditText fAv;
    private String ivc;
    protected String koC = SQLiteDatabase.KeyEmpty;
    private SecurityImage nFq = null;
    private LinearLayout nIT;
    private LinearLayout nIU;
    private TextView nJc;
    protected View nJd;
    private Button nJe;
    protected Button nJf;
    protected Button nJg;
    private f nJh = new f();
    private String nJi;
    private String nJj;
    private ImageView nJk;
    private MMKeyboardUperView nJl;
    private ResizeLayout nJm;
    private String nJn;
    private com.tencent.mm.pluginsdk.j.a nJo;
    protected boolean nJp = false;
    private int nJq;
    boolean nJr = false;
    String nJs;
    private c nJt = new c(this) {
        final /* synthetic */ LoginHistoryUI nJw;

        {
            this.nJw = r1;
        }

        public final void gT(int i) {
            if (b.Ha()) {
                switch (i) {
                    case 0:
                        Intent intent = new Intent(this.nJw, MobileInputUI.class);
                        intent.putExtra("mobile_input_purpose", 5);
                        this.nJw.startActivity(intent);
                        return;
                    case 1:
                        this.nJw.startActivity(new Intent(this.nJw, LoginUI.class));
                        return;
                    case 2:
                        this.nJw.startActivity(new Intent(this.nJw, FacebookLoginUI.class));
                        return;
                    default:
                        return;
                }
            }
            switch (i) {
                case 0:
                    intent = new Intent(this.nJw, MobileInputUI.class);
                    intent.putExtra("mobile_input_purpose", 5);
                    this.nJw.startActivity(intent);
                    return;
                case 1:
                    this.nJw.startActivity(new Intent(this.nJw, LoginUI.class));
                    return;
                default:
                    return;
            }
        }
    };
    private int nJu = 0;

    static /* synthetic */ void a(LoginHistoryUI loginHistoryUI) {
        ab.Kj("welcome_page_show");
        h.c(loginHistoryUI, true);
        com.tencent.mm.sdk.c.b vVar = new v();
        vVar.aXi.aXj = false;
        com.tencent.mm.sdk.c.a.nhr.z(vVar);
        ak.oH().oz();
        loginHistoryUI.finish();
        Context context = loginHistoryUI.nDR.nEl;
        com.tencent.mm.sdk.platformtools.v.bta();
        MMNativeJpeg.Destroy();
        Intent intent = null;
        try {
            intent = new Intent().setClass(context, Class.forName(aa.btg()));
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.LoginHistoryUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        intent.addFlags(67108864);
        intent.putExtra("absolutely_exit_pid", Process.myPid());
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(intent);
    }

    static /* synthetic */ void d(LoginHistoryUI loginHistoryUI) {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LoginHistoryUI", "showProblemH5");
        e.V(loginHistoryUI.nDR.nEl, 1);
    }

    static /* synthetic */ void e(LoginHistoryUI loginHistoryUI) {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LoginHistoryUI", "showLoginMore");
        l lVar = new l(loginHistoryUI.nDR.nEl);
        lVar.jXn = new n.c(loginHistoryUI) {
            final /* synthetic */ LoginHistoryUI nJw;

            {
                this.nJw = r1;
            }

            public final void a(com.tencent.mm.ui.base.l lVar) {
                if (this.nJw.bAQ() && (this.nJw.nJq & 131072) != 0) {
                    lVar.dg(7001, 2131233553);
                }
                if (this.nJw.bAP() && (this.nJw.nJq & 262144) != 0) {
                    lVar.dg(7005, 2131233551);
                }
                lVar.dg(7002, 2131233552);
                lVar.dg(7003, 2131233298);
                lVar.dg(7004, 2131233558);
            }
        };
        lVar.jXo = new d(loginHistoryUI) {
            final /* synthetic */ LoginHistoryUI nJw;

            {
                this.nJw = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 7001:
                        LoginHistoryUI.l(this.nJw);
                        return;
                    case 7002:
                        LoginHistoryUI.m(this.nJw);
                        return;
                    case 7003:
                        LoginHistoryUI.n(this.nJw);
                        return;
                    case 7004:
                        LoginHistoryUI.o(this.nJw);
                        return;
                    default:
                        return;
                }
            }
        };
        lVar.aXZ();
    }

    static /* synthetic */ void g(LoginHistoryUI loginHistoryUI) {
        int i = 0;
        int KL = be.KL(ai.cse.A("last_bind_info", "0"));
        if (KL == 0) {
            i = !b.He() ? 7 : 6;
        } else {
            if (!((KL & 2) == 0 && (KL & 4) == 0)) {
                i = 2;
            }
            if ((KL & 4) != 0) {
                i |= 4;
            }
            if ((KL & 1) != 0) {
                i |= 1;
            }
        }
        i |= 8;
        l lVar = new l(loginHistoryUI);
        lVar.jXn = new com.tencent.mm.ui.account.e.AnonymousClass1(i, loginHistoryUI);
        lVar.jXo = new com.tencent.mm.ui.account.e.AnonymousClass2(loginHistoryUI, null, null, null);
        lVar.aXZ();
    }

    static /* synthetic */ void l(LoginHistoryUI loginHistoryUI) {
        g.iuh.h(11557, Integer.valueOf(2));
        String A = ai.cse.A("login_user_name", SQLiteDatabase.KeyEmpty);
        Intent intent = new Intent();
        intent.putExtra("Kusername", A);
        intent.putExtra("kscene_type", 1);
        com.tencent.mm.ay.c.b(loginHistoryUI.nDR.nEl, "voiceprint", ".ui.VoiceLoginUI", intent, 1024);
    }

    static /* synthetic */ void m(LoginHistoryUI loginHistoryUI) {
        Intent intent = new Intent(loginHistoryUI, MobileInputUI.class);
        intent.putExtra("mobile_input_purpose", 5);
        loginHistoryUI.startActivity(intent);
    }

    static /* synthetic */ void n(LoginHistoryUI loginHistoryUI) {
        if (com.tencent.mm.protocal.d.lWk) {
            String string = loginHistoryUI.getString(2131232240, new Object[]{"0x" + Integer.toHexString(com.tencent.mm.protocal.d.lWh), u.bsY()});
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LoginHistoryUI", "url " + string);
            bc(loginHistoryUI.nDR.nEl, string);
            return;
        }
        com.tencent.mm.model.be.zN();
        Intent intent = new Intent(loginHistoryUI, RegByMobileRegAIOUI.class);
        intent.putExtra("login_type", 0);
        loginHistoryUI.startActivity(intent);
        com.tencent.mm.model.be.zN();
        com.tencent.mm.plugin.a.b.gM(20);
        com.tencent.mm.plugin.a.b.mi("RE200_100");
        com.tencent.mm.plugin.a.b.mh("RE100_100_logout");
        com.tencent.mm.plugin.a.b.b(false, ak.uR() + "," + loginHistoryUI.getClass().getName() + ",RE100_100_logout," + ak.dR("RE100_100_logout") + ",2");
    }

    static /* synthetic */ void o(LoginHistoryUI loginHistoryUI) {
        bc(loginHistoryUI.nDR.nEl, u.bsY().equals("zh_CN") ? loginHistoryUI.getString(2131236652) + "zh_CN" : "https://help.wechat.com/cgi-bin/newreadtemplate?t=help_center/w_index&Channel=Client&lang=");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bAb();
        com.tencent.mm.plugin.a.a.drq.oz();
        this.cnm = aa.getContext().getSharedPreferences(aa.bti(), 0);
        Intent intent = getIntent();
        if (intent != null) {
            this.nJr = intent.getBooleanExtra("login_success_need_bind_fingerprint", false);
            this.nJr = this.nJr;
            if (this.nJr) {
                this.nJs = intent.getStringExtra("bind_login_fingerprint_info");
            }
        }
        NI();
        this.nJo = new com.tencent.mm.pluginsdk.j.a();
    }

    public void onDestroy() {
        ak.vy().b(701, (e) this);
        if (this.nJo != null) {
            this.nJo.close();
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        ak.uS();
        String A = ai.cse.A("login_user_name", SQLiteDatabase.KeyEmpty);
        if (!ak.uN() || A.equals(SQLiteDatabase.KeyEmpty)) {
            if (com.tencent.mm.l.a.tX() == 2) {
                com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this);
                aVar.wm(2131231920);
                aVar.Oq(getString(2131231919));
                aVar.jk(false);
                aVar.wp(2131231917).a(new OnClickListener(this) {
                    final /* synthetic */ LoginHistoryUI nJw;

                    {
                        this.nJw = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LoginHistoryUI", "db dangerous and auto logout");
                        LoginHistoryUI.a(this.nJw);
                    }
                });
                aVar.RX().show();
                com.tencent.mm.l.a.b(this, System.currentTimeMillis());
            }
        } else if (this.dwR == null || !this.dwR.isShowing()) {
            a(null);
        }
    }

    public void onPause() {
        super.onPause();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Intent ak = com.tencent.mm.plugin.a.a.drp.ak(this);
            ak.addFlags(67108864);
            ak.putExtra("can_finish", true);
            startActivity(ak);
            finish();
            com.tencent.mm.ui.base.b.ew(this);
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected final void NI() {
        String str;
        this.nIT = (LinearLayout) findViewById(2131757726);
        this.nIU = (LinearLayout) findViewById(2131757727);
        this.nJn = ai.cse.A("login_user_name", SQLiteDatabase.KeyEmpty);
        String string = ai.cse.cnm.getString("last_avatar_path", SQLiteDatabase.KeyEmpty);
        if (!(string.length() == 0 || string.endsWith("last_avatar"))) {
            String str2 = string + ".bm";
            str = com.tencent.mm.compatible.util.e.cng + "last_avatar";
            String str3 = str + ".bm";
            if (FileOp.p(string, str) > 0 || FileOp.p(str2, str3) > 0) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LastLoginInfo", "Copy avatar: %s -> %s", str2, str3);
                string = str;
            } else {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.LastLoginInfo", "Can't find avatar file: " + str2);
            }
        }
        be.KL(ai.cse.A("last_bind_info", "0"));
        str = getIntent().getStringExtra("email_address");
        if (!(be.kS(str) || str.equalsIgnoreCase(this.nJn))) {
            string = SQLiteDatabase.KeyEmpty;
            this.nJn = str;
        }
        str = string;
        this.nJk = (ImageView) findViewById(2131757725);
        if (!be.kS(str)) {
            Bitmap gL = com.tencent.mm.u.d.gL(str);
            if (gL != null && gL.getWidth() > 10) {
                this.nJk.setImageBitmap(Bitmap.createBitmap(gL, 5, 5, gL.getWidth() - 10, gL.getHeight() - 10, null, false));
            }
        }
        if (!ak.uN() || this.nJn.equals(SQLiteDatabase.KeyEmpty)) {
            this.nJl = (MMKeyboardUperView) findViewById(f.Jr);
            this.nJc = (TextView) findViewById(2131757719);
            this.fAv = (EditText) findViewById(2131757720);
            com.tencent.mm.ui.tools.a.c.b(this.fAv).dw(4, 16).a(null);
            this.nJd = findViewById(2131757722);
            this.nJd.setVisibility(0);
            this.nJq = be.KL(ai.cse.A("last_login_use_voice", SQLiteDatabase.KeyEmpty));
            this.nJe = (Button) findViewById(2131757736);
            this.nJf = (Button) findViewById(2131757721);
            this.nJg = (Button) findViewById(2131757734);
            this.nJg.setVisibility(8);
            this.nJm = (ResizeLayout) findViewById(2131757724);
            if (be.KT(this.nJn).booleanValue()) {
                al alVar = new al();
                string = "86";
                String str4 = this.nJn;
                if (this.nJn.startsWith("+")) {
                    str4 = str4.replace("+", SQLiteDatabase.KeyEmpty);
                    string = al.vl(this.nJn);
                    if (string != null) {
                        str4 = str4.substring(string.length());
                    }
                }
                this.nJc.setText(al.formatNumber(string, str4));
            } else {
                this.nJc.setText(this.nJn);
            }
            MMKeyboardUperView mMKeyboardUperView = this.nJl;
            mMKeyboardUperView.nKa = findViewById(2131757735);
            mMKeyboardUperView.defaultHeight = -1;
            this.nJm.nMr = new ResizeLayout.a(this) {
                final /* synthetic */ LoginHistoryUI nJw;

                {
                    this.nJw = r1;
                }

                public final void dd(int i, int i2) {
                    MMKeyboardUperView b = this.nJw.nJl;
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMKeyboardUperView", "onLayoutChange h " + i + "  oh " + i2);
                    if (b.defaultHeight == -1) {
                        b.defaultHeight = i;
                    }
                    if (i == b.defaultHeight) {
                        b.nKa.post(b.nKc);
                    } else {
                        b.nKa.post(b.nKb);
                    }
                }
            };
            this.fAv.setTypeface(Typeface.DEFAULT);
            this.fAv.setTransformationMethod(new PasswordTransformationMethod());
            this.nJl.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ LoginHistoryUI nJw;

                {
                    this.nJw = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    this.nJw.axg();
                    return false;
                }
            });
            this.fAv.setOnEditorActionListener(new OnEditorActionListener(this) {
                final /* synthetic */ LoginHistoryUI nJw;

                {
                    this.nJw = r1;
                }

                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i != 6 && i != 5) {
                        return false;
                    }
                    this.nJw.apN();
                    return true;
                }
            });
            this.fAv.setOnKeyListener(new OnKeyListener(this) {
                final /* synthetic */ LoginHistoryUI nJw;

                {
                    this.nJw = r1;
                }

                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (66 != i || keyEvent.getAction() != 0) {
                        return false;
                    }
                    this.nJw.apN();
                    return true;
                }
            });
            this.fAv.addTextChangedListener(new TextWatcher(this) {
                final /* synthetic */ LoginHistoryUI nJw;

                {
                    this.nJw = r1;
                }

                public final void afterTextChanged(Editable editable) {
                    if (this.nJw.fAv.getText().toString().length() > 0) {
                        this.nJw.nJf.setEnabled(true);
                    } else {
                        this.nJw.nJf.setEnabled(false);
                    }
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            this.nJf.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ LoginHistoryUI nJw;

                {
                    this.nJw = r1;
                }

                public final void onClick(View view) {
                    this.nJw.apN();
                }
            });
            if (this.fAv.getText().toString().length() > 0) {
                this.nJf.setEnabled(true);
            } else {
                this.nJf.setEnabled(false);
            }
            this.nJd.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ LoginHistoryUI nJw;

                {
                    this.nJw = r1;
                }

                public final void onClick(View view) {
                    LoginHistoryUI.d(this.nJw);
                }
            });
            this.nJe.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ LoginHistoryUI nJw;

                {
                    this.nJw = r1;
                }

                public final void onClick(View view) {
                    LoginHistoryUI.e(this.nJw);
                }
            });
            this.ivc = getIntent().getStringExtra("auth_ticket");
            if (!be.kS(this.ivc)) {
                this.nJc.setText(be.ma(f.bAR()));
                this.fAv.setText(be.ma(f.bAS()));
                new ac().postDelayed(new Runnable(this) {
                    final /* synthetic */ LoginHistoryUI nJw;

                    {
                        this.nJw = r1;
                    }

                    public final void run() {
                        this.nJw.apN();
                    }
                }, 500);
            }
            if (com.tencent.mm.sdk.platformtools.f.nhZ) {
                com.tencent.mm.plugin.a.a.drq.d(this);
                return;
            }
            return;
        }
        this.nJp = true;
        a(null);
    }

    protected final void apN() {
        if (isFinishing() || getWindow() == null) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LoginHistoryUI", "LoginHistoryUI is finishing");
            return;
        }
        this.nJh.cYN = this.nJn.trim();
        this.nJh.nJH = this.fAv.getText().toString();
        if (this.nJh.cYN.equals(SQLiteDatabase.KeyEmpty)) {
            com.tencent.mm.ui.base.g.f(this, 2131235782, 2131233557);
        } else if (this.nJh.nJH.equals(SQLiteDatabase.KeyEmpty)) {
            com.tencent.mm.ui.base.g.f(this, 2131235780, 2131233557);
        } else {
            axg();
            ak.vy().a(701, (e) this);
            final k sVar = new s(this.nJh.cYN, this.nJh.nJH, this.ivc, 0);
            ak.vy().a(sVar, 0);
            getString(2131231164);
            this.dwR = com.tencent.mm.ui.base.g.a((Context) this, getString(2131233565), true, new OnCancelListener(this) {
                final /* synthetic */ LoginHistoryUI nJw;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(sVar);
                    ak.vy().b(701, this.nJw);
                }
            });
        }
    }

    public final void axg() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = -1;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginHistoryUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        com.tencent.mm.sdk.platformtools.v.d(str, str2, objArr);
        if (i2 == -1 && i == 1024 && intent != null) {
            str = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            String str3 = "MicroMsg.LoginHistoryUI";
            String str4 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(be.kS(str));
            objArr2[1] = Integer.valueOf(be.kS(str) ? 0 : str.length());
            objArr2[2] = Integer.valueOf(intExtra);
            com.tencent.mm.sdk.platformtools.v.d(str3, str4, objArr2);
            if (intExtra == -217) {
                apN();
                return;
            }
            this.koC = str;
            this.nJh.cYN = this.nJn.trim();
            ak.vy().a(701, (e) this);
            final k sVar = new s(ai.cse.A("login_user_name", SQLiteDatabase.KeyEmpty), this.koC, SQLiteDatabase.KeyEmpty, 0);
            sVar.kh(this.koC);
            str2 = "MicroMsg.LoginHistoryUI";
            str3 = "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]";
            Object[] objArr3 = new Object[4];
            objArr3[0] = Integer.valueOf(this.koC == null ? -1 : this.koC.length());
            objArr3[1] = be.KW(this.koC);
            if (this.nJh.nJH != null) {
                i3 = this.nJh.nJH.length();
            }
            objArr3[2] = Integer.valueOf(i3);
            objArr3[3] = be.KW(this.nJh.nJH);
            com.tencent.mm.sdk.platformtools.v.i(str2, str3, objArr3);
            getString(2131231164);
            this.dwR = com.tencent.mm.ui.base.g.a((Context) this, getString(2131233565), true, new OnCancelListener(this) {
                final /* synthetic */ LoginHistoryUI nJw;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(sVar);
                    ak.vy().b(701, this.nJw);
                }
            });
            ak.vy().a(sVar, 0);
        }
    }

    public final void a(final int i, int i2, String str, final k kVar) {
        Object obj;
        String A;
        final s sVar;
        final String string;
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LoginHistoryUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LoginHistoryUI", "Scene Type " + kVar.getType());
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        this.bpX = ((s) kVar).Jh();
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.LoginHistoryUI", "url " + this.bpX);
        if (kVar.getType() == 701) {
            ak.vy().b(701, (e) this);
            this.nJh.nJM = ((s) kVar).Ji();
            this.nJh.nJJ = ((s) kVar).Fw();
            this.nJh.nJL = ((s) kVar).Fv();
            this.nJh.nJK = ((s) kVar).Jj();
            if (i2 == -205) {
                this.ivc = ((s) kVar).Fj();
                this.nJi = ((s) kVar).Jk();
                this.nJj = ((s) kVar).Jn();
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                obj = 1;
                ak.vy().a(new ay(new ay.a(this) {
                    final /* synthetic */ LoginHistoryUI nJw;

                    {
                        this.nJw = r1;
                    }

                    public final void a(com.tencent.mm.network.e eVar) {
                        if (eVar != null) {
                            com.tencent.mm.network.c BU = eVar.BU();
                            byte[] bArr = new byte[0];
                            ak.yW();
                            BU.i(bArr, com.tencent.mm.model.c.ww());
                        }
                    }
                }), 0);
                if (obj == null || (i == 0 && i2 == 0)) {
                    ak.unhold();
                    A = ai.cse.A("login_user_name", SQLiteDatabase.KeyEmpty);
                    if (!A.equals(SQLiteDatabase.KeyEmpty) || A.equals(this.nJh.cYN)) {
                        sVar = (s) kVar;
                        com.tencent.mm.platformtools.l.a(this, new Runnable(this) {
                            final /* synthetic */ LoginHistoryUI nJw;

                            public final void run() {
                                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LoginHistoryUI", "onSceneEnd, in runnable");
                                this.nJw.a(sVar);
                            }
                        }, false, 2);
                        com.tencent.mm.modelsimple.d.aX(this);
                        if (this.nJr) {
                            try {
                                JSONObject jSONObject = new JSONObject(this.nJs);
                                string = jSONObject.getString("SignatureWithAuthKey");
                                A = jSONObject.getString("JsonSignedByAuthKey");
                                if (!be.kS(string) && !be.kS(A)) {
                                    com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                                        final /* synthetic */ LoginHistoryUI nJw;

                                        public final void run() {
                                            ak.vy().a(new com.tencent.mm.ap.b(string, A), 0);
                                        }
                                    }, "BindFingerprint");
                                    return;
                                }
                            } catch (Exception e) {
                                com.tencent.mm.sdk.platformtools.v.a("MicroMsg.LoginHistoryUI", null, "bind fingerprint parse json exception: %s", e.getMessage());
                                return;
                            }
                        }
                    }
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LoginHistoryUI", "onSceneEnd, start launcher without show addrbook comfirm. lastAcc:%s, curAcc:%s", A, this.nJh.cYN);
                    com.tencent.mm.platformtools.l.lX(this.nJh.cYN);
                    a((s) kVar);
                    return;
                } else if (i2 == -106) {
                    com.tencent.mm.platformtools.l.D(this, str);
                    return;
                } else if (i2 == -217) {
                    com.tencent.mm.platformtools.l.a(this, ((s) kVar).Jg(), i2);
                    return;
                } else if (i2 != -30) {
                    boolean z;
                    if (i == 4) {
                        switch (i2) {
                            case -4:
                            case -3:
                                if (this.nJu <= 0) {
                                    com.tencent.mm.ui.base.g.f(this, 2131232483, 2131233557);
                                    this.nJu++;
                                } else {
                                    com.tencent.mm.ui.base.g.b((Context) this, getString(2131232484), getString(2131233557), getString(2131232485), getString(2131231010), new OnClickListener(this) {
                                        final /* synthetic */ LoginHistoryUI nJw;

                                        {
                                            this.nJw = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            LoginHistoryUI.g(this.nJw);
                                        }
                                    }, new OnClickListener(this) {
                                        final /* synthetic */ LoginHistoryUI nJw;

                                        {
                                            this.nJw = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            this.nJw.nJu = this.nJw.nJu + 1;
                                        }
                                    });
                                }
                                z = true;
                                break;
                        }
                    }
                    if (com.tencent.mm.plugin.a.a.drq.a((Context) this, i, i2, str)) {
                        if (this.nFq != null) {
                            this.nFq.dismiss();
                        }
                        z = true;
                    } else {
                        if (i == 4) {
                            switch (i2) {
                                case -311:
                                case -310:
                                case -6:
                                    ak.vy().a(701, (e) this);
                                    if (this.nFq == null) {
                                        this.nFq = SecurityImage.a.a(this, this.nJh.nJM, this.nJh.nJL, this.nJh.nJJ, this.nJh.nJK, new OnClickListener(this) {
                                            final /* synthetic */ LoginHistoryUI nJw;

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                int i2 = -1;
                                                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.nJw.nJh.nJJ + " img len" + this.nJw.nJh.nJL.length + " " + com.tencent.mm.compatible.util.g.sm());
                                                String str = "MicroMsg.LoginHistoryUI";
                                                String str2 = "summervoice errType:%d, mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]";
                                                Object[] objArr = new Object[5];
                                                objArr[0] = Integer.valueOf(i);
                                                objArr[1] = Integer.valueOf(this.nJw.koC == null ? -1 : this.nJw.koC.length());
                                                objArr[2] = be.KW(this.nJw.koC);
                                                if (this.nJw.nJh.nJH != null) {
                                                    i2 = this.nJw.nJh.nJH.length();
                                                }
                                                objArr[3] = Integer.valueOf(i2);
                                                objArr[4] = be.KW(this.nJw.nJh.nJH);
                                                com.tencent.mm.sdk.platformtools.v.d(str, str2, objArr);
                                                final k sVar = new s(this.nJw.nJh.cYN, this.nJw.nJh.nJH, this.nJw.nJh.nJM, this.nJw.nFq.bBA(), this.nJw.nFq.nJJ, this.nJw.nFq.nJK, 0, SQLiteDatabase.KeyEmpty, false, false);
                                                if (be.kS(this.nJw.nJh.nJH) && !be.kS(this.nJw.koC)) {
                                                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LoginHistoryUI", "summervoice resetMd5BeforeDoSceneByVoice mAuthPwd:", be.KW(this.nJw.koC));
                                                    sVar.kh(this.nJw.koC);
                                                }
                                                ak.vy().a(sVar, 0);
                                                LoginHistoryUI loginHistoryUI = this.nJw;
                                                Context context = this.nJw;
                                                this.nJw.getString(2131231164);
                                                loginHistoryUI.dwR = com.tencent.mm.ui.base.g.a(context, this.nJw.getString(2131233565), true, new OnCancelListener(this) {
                                                    final /* synthetic */ AnonymousClass13 nJy;

                                                    public final void onCancel(DialogInterface dialogInterface) {
                                                        ak.vy().c(sVar);
                                                        ak.vy().b(701, this.nJy.nJw);
                                                    }
                                                });
                                            }
                                        }, null, new OnDismissListener(this) {
                                            final /* synthetic */ LoginHistoryUI nJw;

                                            {
                                                this.nJw = r1;
                                            }

                                            public final void onDismiss(DialogInterface dialogInterface) {
                                                this.nJw.nFq = null;
                                            }
                                        }, this.nJh);
                                    } else {
                                        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.LoginHistoryUI", "imgSid:" + this.nJh.nJJ + " img len" + this.nJh.nJL.length + " " + com.tencent.mm.compatible.util.g.sm());
                                        this.nFq.a(this.nJh.nJM, this.nJh.nJL, this.nJh.nJJ, this.nJh.nJK);
                                    }
                                    z = true;
                                    break;
                                case -205:
                                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LoginHistoryUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", be.KW(this.ivc), this.nJj);
                                    f.a(this.nJh);
                                    Intent intent = new Intent();
                                    intent.putExtra("auth_ticket", this.ivc);
                                    intent.putExtra("binded_mobile", this.nJi);
                                    intent.putExtra("close_safe_device_style", this.nJj);
                                    intent.putExtra("from_source", 2);
                                    com.tencent.mm.plugin.a.a.drp.f((Context) this, intent);
                                    z = true;
                                    break;
                                case -140:
                                    if (!be.kS(this.bpX)) {
                                        com.tencent.mm.platformtools.l.j(this, str, this.bpX);
                                    }
                                    z = true;
                                    break;
                                case -100:
                                    ak.hold();
                                    com.tencent.mm.ui.base.g.a((Context) this, TextUtils.isEmpty(ak.uA()) ? com.tencent.mm.bd.a.O(this, 2131233716) : ak.uA(), getString(2131231164), new OnClickListener(this) {
                                        final /* synthetic */ LoginHistoryUI nJw;

                                        {
                                            this.nJw = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                        }
                                    }, new OnCancelListener(this) {
                                        final /* synthetic */ LoginHistoryUI nJw;

                                        {
                                            this.nJw = r1;
                                        }

                                        public final void onCancel(DialogInterface dialogInterface) {
                                        }
                                    });
                                    z = true;
                                    break;
                                case -75:
                                    com.tencent.mm.platformtools.l.bl(this);
                                    z = true;
                                    break;
                                case -72:
                                    com.tencent.mm.ui.base.g.f(this, 2131234451, 2131231164);
                                    z = true;
                                    break;
                                case -1:
                                    if (ak.vy().BJ() == 5) {
                                        com.tencent.mm.ui.base.g.f(this, 2131234021, 2131234020);
                                        z = true;
                                        break;
                                    }
                                case -9:
                                    com.tencent.mm.ui.base.g.f(this, 2131233556, 2131233557);
                                    z = true;
                                    break;
                            }
                        }
                        z = this.nJo.a(this, new p(i, i2, str));
                    }
                    if (!z) {
                        if (kVar.getType() == 701) {
                            com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
                            if (dm != null && dm.a(this, null, null)) {
                                return;
                            }
                        }
                        Toast.makeText(this, getString(2131232858, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        return;
                    }
                    return;
                } else if (com.tencent.mm.protocal.d.lWk) {
                    bc(this.nDR.nEl, this.bpX);
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(2131233580), SQLiteDatabase.KeyEmpty, new OnClickListener(this) {
                        final /* synthetic */ LoginHistoryUI nJw;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.a.b.mi("R400_100_login");
                            Intent intent = new Intent();
                            intent.putExtra("regsetinfo_binduin", this.nJw.nJh.cYN);
                            intent.putExtra("regsetinfo_pwd", this.nJw.nJh.nJH);
                            intent.putExtra("regsetinfo_ismobile", 0);
                            intent.putExtra("regsetinfo_NextControl", ((s) kVar).Fl());
                            intent.setClass(this.nJw, RegSetInfoUI.class);
                            this.nJw.nDR.nEl.startActivity(intent);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ LoginHistoryUI nJw;

                        {
                            this.nJw = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                }
            }
        }
        obj = null;
        if (obj == null) {
        }
        ak.unhold();
        A = ai.cse.A("login_user_name", SQLiteDatabase.KeyEmpty);
        if (A.equals(SQLiteDatabase.KeyEmpty)) {
        }
        sVar = (s) kVar;
        com.tencent.mm.platformtools.l.a(this, /* anonymous class already generated */, false, 2);
        com.tencent.mm.modelsimple.d.aX(this);
        if (this.nJr) {
            JSONObject jSONObject2 = new JSONObject(this.nJs);
            string = jSONObject2.getString("SignatureWithAuthKey");
            A = jSONObject2.getString("JsonSignedByAuthKey");
            if (!be.kS(string)) {
            }
        }
    }

    private void a(s sVar) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LoginHistoryUI", "checktask LoginHistoryUI startLauncher 0x%x, stack: %s", Integer.valueOf(hashCode()), be.bur());
        Intent ak = com.tencent.mm.plugin.a.a.drp.ak(this);
        ak.addFlags(67108864);
        if (sVar != null) {
            ak.putExtra("kstyle_show_bind_mobile_afterauth", sVar.Jl());
            ak.putExtra("kstyle_bind_recommend_show", sVar.Jo());
            ak.putExtra("kstyle_bind_wording", sVar.Jm());
        }
        startActivity(ak);
        finish();
    }

    protected final int getLayoutId() {
        return 2130903872;
    }

    public void setRequestedOrientation(int i) {
    }

    private static void bc(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
        com.tencent.mm.ay.c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    public boolean bAQ() {
        return true;
    }

    public boolean bAP() {
        return true;
    }
}
