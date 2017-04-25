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
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.network.c;
import com.tencent.mm.platformtools.l;
import com.tencent.mm.plugin.a.a;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public class LoginIndepPass extends MMActivity implements e {
    private String bpX;
    private String cYN;
    private ProgressDialog dwR = null;
    private String ivc;
    private String ivg;
    private SecurityImage nFq = null;
    private Button nIJ;
    private p nIO;
    private EditText nJA;
    private String nJB;
    private f nJh = new f();
    private String nJi;
    private String nJj;

    static /* synthetic */ void a(LoginIndepPass loginIndepPass, String str, String str2) {
        if (be.kS(str)) {
            g.f(loginIndepPass, 2131235782, 2131233557);
        } else if (be.kS(str2)) {
            g.f(loginIndepPass, 2131235780, 2131233557);
        } else {
            loginIndepPass.nJA.setText(str2);
            loginIndepPass.axg();
            ak.vy().a(701, (e) loginIndepPass);
            final k sVar = new s(str, str2, null, 1);
            ak.vy().a(sVar, 0);
            loginIndepPass.getString(2131231164);
            loginIndepPass.dwR = g.a((Context) loginIndepPass, loginIndepPass.getString(2131233565), true, new OnCancelListener(loginIndepPass) {
                final /* synthetic */ LoginIndepPass nJC;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(sVar);
                }
            });
        }
    }

    static /* synthetic */ void b(LoginIndepPass loginIndepPass) {
        if (be.kS(loginIndepPass.nJA.getText().toString().trim())) {
            loginIndepPass.iT(false);
        } else {
            loginIndepPass.iT(true);
        }
    }

    protected final int getLayoutId() {
        return 2130903873;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(2131233559);
        if (d.lWk) {
            string = getString(2131230720) + getString(2131230892);
        }
        Fd(string);
        this.nJB = getIntent().getStringExtra("bindmcontact_mobile");
        if (this.nJB != null) {
            this.cYN = al.Kq(this.nJB);
        }
        a.drq.oz();
        this.ivg = b.Oa();
        NI();
    }

    public void onResume() {
        super.onResume();
        b.b(true, ak.uR() + "," + getClass().getName() + ",L200_200," + ak.dR("L200_200") + ",1");
        b.mh("L200_200");
    }

    public void onPause() {
        super.onPause();
        b.b(false, ak.uR() + "," + getClass().getName() + ",L200_200," + ak.dR("L200_200") + ",2");
    }

    public void onDestroy() {
        ak.vy().b(701, (e) this);
        super.onDestroy();
    }

    protected final void NI() {
        this.nJA = (EditText) findViewById(2131757737);
        this.nIJ = (Button) findViewById(2131757738);
        iT(false);
        a(0, getString(2131233561), new OnMenuItemClickListener(this) {
            final /* synthetic */ LoginIndepPass nJC;

            {
                this.nJC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nJC.apN();
                return true;
            }
        });
        this.nJA.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ LoginIndepPass nJC;

            {
                this.nJC = r1;
            }

            public final void afterTextChanged(Editable editable) {
                LoginIndepPass.b(this.nJC);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.nJA.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ LoginIndepPass nJC;

            {
                this.nJC = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 && i != 5) {
                    return false;
                }
                this.nJC.apN();
                return true;
            }
        });
        this.nJA.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ LoginIndepPass nJC;

            {
                this.nJC = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                this.nJC.apN();
                return true;
            }
        });
        this.nIJ.setText(getString(2131233574));
        this.nIJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LoginIndepPass nJC;

            {
                this.nJC = r1;
            }

            public final void onClick(View view) {
                g.a(this.nJC, this.nJC.getString(2131234442) + this.nJC.nJB, this.nJC.getString(2131234443), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass11 nJE;

                    {
                        this.nJE = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ak.vy().a(145, this.nJE.nJC);
                        final k uVar = new u(this.nJE.nJC.cYN, 16, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty);
                        ak.vy().a(uVar, 0);
                        LoginIndepPass loginIndepPass = this.nJE.nJC;
                        Context context = this.nJE.nJC;
                        this.nJE.nJC.getString(2131231164);
                        loginIndepPass.nIO = g.a(context, this.nJE.nJC.getString(2131235044), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass1 nJG;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(uVar);
                                ak.vy().b(701, this.nJG.nJE.nJC);
                            }
                        });
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass11 nJE;

                    {
                        this.nJE = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LoginIndepPass nJC;

            {
                this.nJC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                b.mi("L200_100");
                Intent intent = new Intent(this.nJC, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                intent.addFlags(67108864);
                this.nJC.startActivity(intent);
                this.nJC.finish();
                return true;
            }
        });
        this.ivc = getIntent().getStringExtra("auth_ticket");
        if (!be.kS(this.ivc)) {
            new ac().postDelayed(new Runnable(this) {
                final /* synthetic */ LoginIndepPass nJC;

                {
                    this.nJC = r1;
                }

                public final void run() {
                    LoginIndepPass.a(this.nJC, f.bAR(), f.bAS());
                }
            }, 500);
        }
    }

    private void apN() {
        String obj = this.nJA.getText().toString();
        if (be.kS(this.cYN)) {
            g.f(this, 2131235782, 2131233557);
        } else if (obj.equals(SQLiteDatabase.KeyEmpty)) {
            g.f(this, 2131235780, 2131233557);
        } else {
            axg();
            ak.vy().a(701, (e) this);
            final k sVar = new s(this.cYN, obj, null, 1);
            ak.vy().a(sVar, 0);
            getString(2131231164);
            this.dwR = g.a((Context) this, getString(2131233565), true, new OnCancelListener(this) {
                final /* synthetic */ LoginIndepPass nJC;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(sVar);
                }
            });
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.LoginIndepPass", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (this.nIO != null) {
            this.nIO.dismiss();
            this.nIO = null;
        }
        if (kVar.getType() == 701) {
            this.bpX = ((s) kVar).Jh();
            ak.vy().b(701, (e) this);
            this.nJh.nJJ = ((s) kVar).Fw();
            this.nJh.nJL = ((s) kVar).Fv();
            this.nJh.nJK = ((s) kVar).Jj();
            this.nJh.nJM = ((s) kVar).Ji();
            this.nJh.cYN = this.cYN;
            this.nJh.nJH = this.nJA.getText().toString();
            if (i2 == -75) {
                l.bl(this.nDR.nEl);
            } else if (i2 == -106) {
                l.D(this, str);
            } else if (i2 == -217) {
                l.a(this, ((s) kVar).Jg(), i2);
            } else if (i2 == -205) {
                this.ivc = ((s) kVar).Fj();
                this.nJi = ((s) kVar).Jk();
                this.nJj = ((s) kVar).Jn();
                v.i("MicroMsg.LoginIndepPass", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", be.KW(this.ivc), this.nJj);
                f.a(this.nJh);
                Intent intent = new Intent();
                intent.putExtra("auth_ticket", this.ivc);
                intent.putExtra("binded_mobile", this.nJi);
                intent.putExtra("close_safe_device_style", this.nJj);
                intent.putExtra("from_source", 5);
                a.drp.f((Context) this, intent);
            } else if (i2 != -140) {
                boolean z;
                if (i == 4 && (i2 == -16 || i2 == -17)) {
                    ak.vy().a(new ay(new ay.a(this) {
                        final /* synthetic */ LoginIndepPass nJC;

                        {
                            this.nJC = r1;
                        }

                        public final void a(com.tencent.mm.network.e eVar) {
                            if (eVar != null) {
                                c BU = eVar.BU();
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
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    ak.vy().a(701, (e) this);
                    if (this.nFq == null) {
                        this.nFq = SecurityImage.a.a(this.nDR.nEl, this.nJh.nJM, this.nJh.nJL, this.nJh.nJJ, this.nJh.nJK, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ LoginIndepPass nJC;

                            {
                                this.nJC = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                v.d("MicroMsg.LoginIndepPass", "imgSid:" + this.nJC.nJh.nJJ + " img len" + this.nJC.nJh.nJL.length + " " + com.tencent.mm.compatible.util.g.sm());
                                final k sVar = new s(this.nJC.nJh.cYN, this.nJC.nJh.nJH, this.nJC.nJh.nJM, this.nJC.nFq.bBA(), this.nJC.nFq.nJJ, this.nJC.nFq.nJK, 1, SQLiteDatabase.KeyEmpty, false, false);
                                ak.vy().a(sVar, 0);
                                LoginIndepPass loginIndepPass = this.nJC;
                                Context context = this.nJC;
                                this.nJC.getString(2131231164);
                                loginIndepPass.dwR = g.a(context, this.nJC.getString(2131233565), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass3 nJD;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ak.vy().c(sVar);
                                        ak.vy().b(701, this.nJD.nJC);
                                    }
                                });
                            }
                        }, null, new OnDismissListener(this) {
                            final /* synthetic */ LoginIndepPass nJC;

                            {
                                this.nJC = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                                this.nJC.nFq = null;
                            }
                        }, this.nJh);
                        return;
                    }
                    v.d("MicroMsg.LoginIndepPass", "imgSid:" + this.nJh.nJJ + " img len" + this.nJh.nJL.length + " " + com.tencent.mm.compatible.util.g.sm());
                    this.nFq.a(this.nJh.nJM, this.nJh.nJL, this.nJh.nJJ, this.nJh.nJK);
                } else if (z || (i == 0 && i2 == 0)) {
                    ak.unhold();
                    l.lX(this.nJh.cYN);
                    com.tencent.mm.modelsimple.d.aX(this);
                    l.a(this, new Runnable(this) {
                        final /* synthetic */ LoginIndepPass nJC;

                        {
                            this.nJC = r1;
                        }

                        public final void run() {
                            v.d("MicroMsg.LoginIndepPass", "onSceneEnd, in runnable");
                            Intent ak = a.drp.ak(this.nJC);
                            ak.addFlags(67108864);
                            this.nJC.startActivity(ak);
                            this.nJC.finish();
                        }
                    }, false, 2);
                } else if (!k(i, i2, str)) {
                    if (kVar.getType() == 701) {
                        com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
                        if (dm != null && dm.a(this, null, null)) {
                            return;
                        }
                    }
                    Toast.makeText(this, getString(2131232858, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            } else if (!be.kS(this.bpX)) {
                l.j(this, str, this.bpX);
            }
        } else if (kVar.getType() == 145) {
            ak.vy().b(145, (e) this);
            String Fk = ((u) kVar).Fk();
            if (i2 == -41) {
                g.f(this, 2131234422, 2131234423);
            } else if (i2 == -75) {
                g.A(this, getString(2131230894), SQLiteDatabase.KeyEmpty);
            } else {
                b.mi("L3");
                b.b(true, ak.uR() + "," + getClass().getName() + ",L3," + ak.dR("L3") + ",1");
                Intent intent2 = new Intent();
                intent2.putExtra("bindmcontact_mobile", this.nJB);
                intent2.putExtra("bindmcontact_shortmobile", Fk);
                intent2.putExtra("mobile_verify_purpose", 1);
                intent2.putExtra("login_type", 3);
                intent2.putExtra("mobileverify_countdownsec", ((u) kVar).Fm());
                intent2.putExtra("mobileverify_countdownstyle", ((u) kVar).Fn());
                intent2.putExtra("mobileverify_fb", ((u) kVar).Fo());
                a(MobileVerifyUI.class, intent2);
            }
        } else if (!k(i, i2, str)) {
            if (i != 0 || i2 != 0) {
                Toast.makeText(this, getString(2131232858, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    private boolean k(int i, int i2, String str) {
        if (a.drq.a(this.nDR.nEl, i, i2, str)) {
            return true;
        }
        if (i != 4) {
            return false;
        }
        switch (i2) {
            case -140:
                if (!be.kS(this.bpX)) {
                    l.j(this.nDR.nEl, str, this.bpX);
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
                g.a(context, O, this.nDR.nEl.getString(2131231164), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ LoginIndepPass nJC;

                    {
                        this.nJC = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, new OnCancelListener(this) {
                    final /* synthetic */ LoginIndepPass nJC;

                    {
                        this.nJC = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                return true;
            case -9:
                g.f(this, 2131233556, 2131233557);
                return true;
            case -4:
            case -3:
                g.f(this, 2131232483, 2131233557);
                return true;
            case -1:
                if (ak.vy().BJ() != 5) {
                    return false;
                }
                g.f(this, 2131234021, 2131234020);
                return true;
            default:
                return false;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.LoginIndepPass";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        v.d(str, str2, objArr);
        if (i2 == -1 && i == 1024 && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.LoginIndepPass";
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
