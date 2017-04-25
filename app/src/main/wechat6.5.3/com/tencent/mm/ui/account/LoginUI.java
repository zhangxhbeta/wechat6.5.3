package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.l;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public class LoginUI extends MMActivity implements e {
    private TextWatcher abU = new TextWatcher(this) {
        final /* synthetic */ LoginUI nJW;

        {
            this.nJW = r1;
        }

        public final void afterTextChanged(Editable editable) {
            LoginUI.a(this.nJW);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    private String bax = null;
    private String bpX = SQLiteDatabase.KeyEmpty;
    private ProgressDialog dwR = null;
    private EditText fAv;
    private int hGO = 0;
    private String ivc;
    private String ivg;
    private SecurityImage nFq = null;
    private EditText nJR;
    private MMFormInputView nJS;
    private MMFormInputView nJT;
    private Button nJU;
    private boolean nJV = false;
    private f nJh = new f();
    private String nJi;
    private String nJj;
    private a nJo;

    static /* synthetic */ void a(LoginUI loginUI) {
        if (be.kS(loginUI.nJR.getText().toString()) || be.kS(loginUI.fAv.getText().toString())) {
            loginUI.nJU.setEnabled(false);
        } else {
            loginUI.nJU.setEnabled(true);
        }
    }

    static /* synthetic */ void g(LoginUI loginUI) {
        ak.fH(SQLiteDatabase.KeyEmpty);
        Intent intent = new Intent();
        intent.putExtra("Intro_Switch", true).addFlags(67108864);
        loginUI.finish();
        com.tencent.mm.plugin.a.a.drp.t(intent, loginUI);
    }

    protected final int getLayoutId() {
        return 2130903871;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(2131233569);
        if (d.lWk) {
            string = getString(2131230720) + getString(2131230892);
        }
        this.hGO = getIntent().getIntExtra("login_type", 0);
        Fd(string);
        com.tencent.mm.plugin.a.a.drq.oz();
        this.ivg = b.Oa();
        NI();
        this.nJo = new a();
    }

    public void onResume() {
        super.onResume();
        if (this.hGO == 0) {
            b.b(true, ak.uR() + "," + getClass().getName() + ",L100_100_logout," + ak.dR("L100_100_logout") + ",1");
            b.mh("L100_100_logout");
        } else if (this.hGO == 1) {
            b.b(true, ak.uR() + "," + getClass().getName() + ",L400_100_login," + ak.dR("L400_100_login") + ",1");
            b.mh("L400_100_login");
        }
    }

    public void onPause() {
        super.onPause();
        if (this.hGO == 0) {
            b.b(false, ak.uR() + "," + getClass().getName() + ",L100_100_logout," + ak.dR("L100_100_logout") + ",2");
        } else if (this.hGO == 1) {
            b.b(false, ak.uR() + "," + getClass().getName() + ",L400_100_login," + ak.dR("L400_100_login") + ",2");
        }
    }

    public void onDestroy() {
        if (this.nJo != null) {
            this.nJo.close();
        }
        ak.vy().b(701, (e) this);
        super.onDestroy();
    }

    protected final void NI() {
        this.nJS = (MMFormInputView) findViewById(2131757719);
        this.nJT = (MMFormInputView) findViewById(2131757720);
        this.nJR = this.nJS.idd;
        this.fAv = this.nJT.idd;
        c.b(this.fAv).yn(16).a(null);
        this.nJR.requestFocus();
        this.nJU = (Button) findViewById(2131757721);
        this.nJU.setEnabled(false);
        findViewById(2131757722).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LoginUI nJW;

            {
                this.nJW = r1;
            }

            public final void onClick(View view) {
                e.V(this.nJW.nDR.nEl, 3);
            }
        });
        boolean Ha = com.tencent.mm.af.b.Ha();
        View findViewById = findViewById(2131757723);
        findViewById.setVisibility(!Ha ? 8 : 0);
        findViewById.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LoginUI nJW;

            {
                this.nJW = r1;
            }

            public final void onClick(View view) {
                this.nJW.startActivity(new Intent(this.nJW, FacebookLoginUI.class));
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LoginUI nJW;

            {
                this.nJW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nJW.goBack();
                return true;
            }
        });
        this.nJU.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LoginUI nJW;

            {
                this.nJW = r1;
            }

            public final void onClick(View view) {
                this.nJW.apN();
            }
        });
        this.ivc = getIntent().getStringExtra("auth_ticket");
        if (!be.kS(this.ivc)) {
            this.nJR.setText(be.ma(f.bAR()));
            this.fAv.setText(be.ma(f.bAS()));
            new ac().postDelayed(new Runnable(this) {
                final /* synthetic */ LoginUI nJW;

                {
                    this.nJW = r1;
                }

                public final void run() {
                    this.nJW.apN();
                }
            }, 500);
        }
        this.nJR.addTextChangedListener(this.abU);
        this.fAv.addTextChangedListener(this.abU);
        this.fAv.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ LoginUI nJW;

            {
                this.nJW = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                this.nJW.apN();
                return true;
            }
        });
        this.fAv.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ LoginUI nJW;

            {
                this.nJW = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                this.nJW.apN();
                return true;
            }
        });
        if (f.nhZ) {
            com.tencent.mm.plugin.a.a.drq.d(this);
        }
        CharSequence stringExtra = getIntent().getStringExtra("login_username");
        this.nJV = getIntent().getBooleanExtra("from_deep_link", false);
        if (!be.kS(stringExtra)) {
            this.nJR.setText(stringExtra);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        axg();
        b.mi(this.ivg);
        p.bnu();
        finish();
    }

    private boolean k(int i, int i2, String str) {
        if (com.tencent.mm.plugin.a.a.drq.a(this.nDR.nEl, i, i2, str)) {
            return true;
        }
        if (i == 4) {
            switch (i2) {
                case -311:
                case -310:
                case -6:
                    ak.vy().a(701, (e) this);
                    if (this.nFq == null) {
                        this.nFq = SecurityImage.a.a(this, this.nJh.nJM, this.nJh.nJL, this.nJh.nJJ, this.nJh.nJK, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ LoginUI nJW;

                            {
                                this.nJW = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (this.nJW.nFq == null) {
                                    v.e("MicroMsg.LoginUI", "secimg is null!");
                                    return;
                                }
                                v.d("MicroMsg.LoginUI", "imgSid:" + this.nJW.nJh.nJJ + " img len" + this.nJW.nJh.nJL.length + " " + g.sm());
                                final k sVar = new s(this.nJW.nJh.cYN, this.nJW.nJh.nJH, this.nJW.nJh.nJM, this.nJW.nFq.bBA(), this.nJW.nFq.nJJ, this.nJW.nFq.nJK, 2, SQLiteDatabase.KeyEmpty, false, false);
                                ak.vy().a(sVar, 0);
                                LoginUI loginUI = this.nJW;
                                Context context = this.nJW;
                                this.nJW.getString(2131231164);
                                loginUI.dwR = com.tencent.mm.ui.base.g.a(context, this.nJW.getString(2131233565), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass17 nJX;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ak.vy().c(sVar);
                                        ak.vy().b(701, this.nJX.nJW);
                                    }
                                });
                            }
                        }, null, new OnDismissListener(this) {
                            final /* synthetic */ LoginUI nJW;

                            {
                                this.nJW = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                                this.nJW.nFq = null;
                            }
                        }, this.nJh);
                    } else {
                        v.d("MicroMsg.LoginUI", "imgSid:" + this.nJh.nJJ + " img len" + this.nJh.nJL.length + " " + g.sm());
                        this.nFq.a(this.nJh.nJM, this.nJh.nJL, this.nJh.nJJ, this.nJh.nJK);
                    }
                    return true;
                case -205:
                    v.i("MicroMsg.LoginUI", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", be.KW(this.ivc), this.nJj);
                    f.a(this.nJh);
                    b.mi("L600_100");
                    Intent intent = new Intent();
                    intent.putExtra("auth_ticket", this.ivc);
                    intent.putExtra("binded_mobile", this.nJi);
                    intent.putExtra("close_safe_device_style", this.nJj);
                    intent.putExtra("from_source", 1);
                    com.tencent.mm.plugin.a.a.drp.f((Context) this, intent);
                    return true;
                case -140:
                    if (!be.kS(this.bpX)) {
                        l.j(this, str, this.bpX);
                    }
                    return true;
                case -100:
                    String O;
                    ak.hold();
                    Context context = this.nDR.nEl;
                    if (TextUtils.isEmpty(ak.uA())) {
                        O = com.tencent.mm.bd.a.O(this.nDR.nEl, 2131233716);
                    } else {
                        O = ak.uA();
                    }
                    com.tencent.mm.ui.base.g.a(context, O, this.nDR.nEl.getString(2131231164), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ LoginUI nJW;

                        {
                            this.nJW = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            LoginUI.g(this.nJW);
                        }
                    }, new OnCancelListener(this) {
                        final /* synthetic */ LoginUI nJW;

                        {
                            this.nJW = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            LoginUI.g(this.nJW);
                        }
                    });
                    return true;
                case -75:
                    l.bl(this.nDR.nEl);
                    return true;
                case -72:
                    com.tencent.mm.ui.base.g.f(this.nDR.nEl, 2131234451, 2131231164);
                    return true;
                case -9:
                    com.tencent.mm.ui.base.g.f(this, 2131233556, 2131233557);
                    return true;
                case -4:
                case -3:
                    com.tencent.mm.ui.base.g.f(this, 2131232483, 2131233557);
                    return true;
                case -1:
                    if (ak.vy().BJ() != 5) {
                        return false;
                    }
                    com.tencent.mm.ui.base.g.f(this, 2131234021, 2131234020);
                    return true;
            }
        }
        return this.nJo.a(this, new com.tencent.mm.pluginsdk.j.p(i, i2, str));
    }

    public final void a(int i, int i2, String str, final k kVar) {
        v.i("MicroMsg.LoginUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (kVar.getType() == 701) {
            boolean z;
            ak.vy().b(701, (e) this);
            this.bpX = ((s) kVar).Jh();
            this.nJh.nJJ = ((s) kVar).Fw();
            this.nJh.nJL = ((s) kVar).Fv();
            this.nJh.nJK = ((s) kVar).Jj();
            this.nJh.nJM = ((s) kVar).Ji();
            if (i2 == -205) {
                this.ivc = ((s) kVar).Fj();
                this.nJi = ((s) kVar).Jk();
                this.nJj = ((s) kVar).Jn();
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                ak.vy().a(new ay(new ay.a(this) {
                    final /* synthetic */ LoginUI nJW;

                    {
                        this.nJW = r1;
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
                z = true;
            } else {
                z = false;
            }
            if (z || (i == 0 && i2 == 0)) {
                ak.unhold();
                l.lX(this.nJh.cYN);
                com.tencent.mm.modelsimple.d.aX(this);
                l.a(this, new Runnable(this) {
                    final /* synthetic */ LoginUI nJW;

                    public final void run() {
                        v.d("MicroMsg.LoginUI", "onSceneEnd, in runnable");
                        Intent ak = com.tencent.mm.plugin.a.a.drp.ak(this.nJW);
                        ak.addFlags(67108864);
                        ak.putExtra("kstyle_show_bind_mobile_afterauth", ((s) kVar).Jl());
                        ak.putExtra("kstyle_bind_wording", ((s) kVar).Jm());
                        ak.putExtra("kstyle_bind_recommend_show", ((s) kVar).Jo());
                        this.nJW.startActivity(ak);
                        this.nJW.finish();
                    }
                }, false, 2);
                b.mj(ak.uR() + "," + getClass().getName() + ",R200_900_phone," + ak.dR("R200_900_phone") + ",4");
                if (this.nJV) {
                    String string = aa.getContext().getSharedPreferences("randomid_prefs", 4).getString("randomID", SQLiteDatabase.KeyEmpty);
                    com.tencent.mm.plugin.report.service.g.iuh.h(11930, string, Integer.valueOf(4));
                }
            } else if (i2 == -106) {
                l.D(this, str);
            } else if (i2 == -217) {
                l.a(this, ((s) kVar).Jg(), i2);
            } else if (i2 == -30) {
                if (d.lWk) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", this.bpX);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                    com.tencent.mm.plugin.a.a.drp.j(intent, (Context) this);
                    return;
                }
                b.mj(ak.uR() + "," + getClass().getName() + ",R400_100_login," + ak.dR("R400_100_login") + ",1");
                com.tencent.mm.ui.base.g.a((Context) this, getString(2131233580), SQLiteDatabase.KeyEmpty, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LoginUI nJW;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b.mi("R400_100_login");
                        Intent intent = new Intent();
                        intent.putExtra("regsetinfo_binduin", this.nJW.nJh.cYN);
                        intent.putExtra("regsetinfo_pwd", this.nJW.nJh.nJH);
                        intent.putExtra("regsetinfo_ismobile", 0);
                        intent.putExtra("regsetinfo_ticket", this.nJW.bax);
                        intent.putExtra("regsetinfo_NextControl", ((s) kVar).Fl());
                        intent.setClass(this.nJW, RegSetInfoUI.class);
                        this.nJW.nDR.nEl.startActivity(intent);
                        b.mj(ak.uR() + "," + this.nJW.getClass().getName() + ",R400_100_login," + ak.dR("R400_100_login") + ",2");
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LoginUI nJW;

                    {
                        this.nJW = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b.mj(ak.uR() + "," + this.nJW.getClass().getName() + ",R400_100_login," + ak.dR("R400_100_login") + ",2");
                    }
                });
            } else if (!k(i, i2, str)) {
                if (i2 == -5) {
                    Toast.makeText(this, getString(2131233570), 0).show();
                    return;
                }
                if (kVar.getType() == 701) {
                    com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
                    if (dm != null && dm.a(this, null, null)) {
                        return;
                    }
                }
                Toast.makeText(this, getString(2131232858, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    private void apN() {
        this.nJh.cYN = this.nJR.getText().toString().trim();
        this.nJh.nJH = this.fAv.getText().toString();
        if (this.nJh.cYN.equals(SQLiteDatabase.KeyEmpty)) {
            com.tencent.mm.ui.base.g.f(this, 2131235782, 2131233557);
        } else if (this.nJh.nJH.equals(SQLiteDatabase.KeyEmpty)) {
            com.tencent.mm.ui.base.g.f(this, 2131235780, 2131233557);
        } else {
            axg();
            ak.vy().a(701, (e) this);
            final k sVar = new s(this.nJh.cYN, this.nJh.nJH, this.ivc, 2);
            ak.vy().a(sVar, 0);
            getString(2131231164);
            this.dwR = com.tencent.mm.ui.base.g.a((Context) this, getString(2131233565), true, new OnCancelListener(this) {
                final /* synthetic */ LoginUI nJW;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(sVar);
                    ak.vy().b(701, this.nJW);
                }
            });
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        v.d(str, str2, objArr);
        if (i2 == -1 && i == 1024 && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.LoginUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(be.kS(stringExtra));
            if (!be.kS(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            v.d(str2, str3, objArr2);
            if (intExtra == -217) {
                apN();
            }
        }
    }
}
