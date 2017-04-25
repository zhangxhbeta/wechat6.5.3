package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.platformtools.l;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.pluginsdk.j.p;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.RegByMobileRegAIOUI;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.ui.account.RegSetInfoUI;
import com.tencent.mm.ui.account.f;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.io.File;

public class MobileLoginOrForceReg extends MMActivity implements e {
    private String bax;
    private String bhT;
    private String bpX;
    private String cID;
    private int cZg;
    private ImageView dtX;
    protected ProgressDialog dwR = null;
    private TextView euh;
    private String fSc;
    private String fTP;
    private ac handler = new ac(this) {
        final /* synthetic */ MobileLoginOrForceReg nOl;

        {
            this.nOl = r1;
        }

        public final void handleMessage(Message message) {
            if (message.obj != null) {
                this.nOl.dtX.setImageBitmap((Bitmap) message.obj);
            }
        }
    };
    private String nFd;
    private SecurityImage nFq = null;
    private a nIK = null;
    private f nJh = null;
    private a nJo;
    private Button nOb;
    private Button nOc;
    private LinearLayout nOd;
    private LinearLayout nOe;
    private TextView nOf;
    private int nOg;
    private boolean nOh = true;
    private boolean nOi;
    private String nOj;
    private String nOk;
    private String username;

    static /* synthetic */ void j(MobileLoginOrForceReg mobileLoginOrForceReg) {
        final k uVar = new u(SQLiteDatabase.KeyEmpty, mobileLoginOrForceReg.nOk, mobileLoginOrForceReg.nOj, 0, SQLiteDatabase.KeyEmpty, mobileLoginOrForceReg.bhT, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, mobileLoginOrForceReg.bax, mobileLoginOrForceReg.cZg, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, true, mobileLoginOrForceReg.nOi);
        ak.vy().a(uVar, 0);
        Context context = mobileLoginOrForceReg.nDR.nEl;
        mobileLoginOrForceReg.getString(2131231164);
        mobileLoginOrForceReg.dwR = g.a(context, mobileLoginOrForceReg.getString(2131234461), true, new OnCancelListener(mobileLoginOrForceReg) {
            final /* synthetic */ MobileLoginOrForceReg nOl;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(uVar);
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nFd = b.Oa();
        ak.vy().a(701, (e) this);
        ak.vy().a(126, (e) this);
        ak.vy().a((int) WebView.NORMAL_MODE_ALPHA, (e) this);
        this.bax = getIntent().getStringExtra("ticket");
        this.bhT = getIntent().getStringExtra("moble");
        this.nOg = getIntent().getIntExtra("next_controll", 0);
        this.username = getIntent().getStringExtra("username");
        this.fTP = getIntent().getStringExtra("password");
        this.cID = getIntent().getStringExtra("nickname");
        this.fSc = getIntent().getStringExtra("avatar_url");
        this.nOi = getIntent().getBooleanExtra("kintent_hasavatar", false);
        this.nOj = getIntent().getStringExtra("kintent_nickname");
        this.nOk = getIntent().getStringExtra("kintent_password");
        if (this.nOk == null || this.nOk.length() < 8) {
            this.cZg = 4;
        } else {
            this.cZg = 1;
        }
        NI();
        this.nJo = new a();
    }

    public final void NI() {
        String vl;
        CharSequence charSequence;
        this.nOb = (Button) findViewById(2131758318);
        this.nOc = (Button) findViewById(2131758319);
        this.nOd = (LinearLayout) findViewById(2131758317);
        this.nOe = (LinearLayout) findViewById(2131758316);
        this.dtX = (ImageView) findViewById(2131755508);
        this.euh = (TextView) findViewById(2131756539);
        this.nOf = (TextView) findViewById(2131755619);
        al alVar = new al();
        if (this.bhT.startsWith("+")) {
            vl = al.vl(this.bhT);
            if (be.kS(vl)) {
                charSequence = this.bhT;
            } else {
                charSequence = "+" + vl + " " + al.formatNumber(vl, this.bhT.substring(vl.length() + 1));
            }
        } else {
            charSequence = "+86 " + al.formatNumber("86", this.bhT);
        }
        this.nOf.setText(charSequence);
        if (be.kS(this.cID) && be.kS(this.fSc)) {
            this.nOe.setVisibility(0);
            this.nOd.setVisibility(8);
        } else {
            this.nOe.setVisibility(8);
            this.nOd.setVisibility(0);
            if (be.kS(this.cID)) {
                this.euh.setVisibility(8);
            } else {
                this.euh.setText(this.cID);
            }
            Bitmap od = com.tencent.mm.pluginsdk.ui.a.b.box().od();
            if (od != null) {
                this.dtX.setImageBitmap(od);
            }
            if (!be.kS(this.fSc)) {
                vl = this.fSc;
                ak.vA().x(new Runnable(this) {
                    final /* synthetic */ MobileLoginOrForceReg nOl;

                    public final void run() {
                        Object obj = null;
                        try {
                            obj = d.decodeStream(com.tencent.mm.network.b.h(vl, 10000, 20000));
                        } catch (Throwable e) {
                            v.e("MicorMsg.MobileLoginOrForceReg", "download avatar failed");
                            v.a("MicorMsg.MobileLoginOrForceReg", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                        this.nOl.handler.sendMessage(this.nOl.handler.obtainMessage(0, obj));
                    }

                    public final String toString() {
                        return super.toString() + "|loadBitmap";
                    }
                });
            }
        }
        this.nOb.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MobileLoginOrForceReg nOl;

            {
                this.nOl = r1;
            }

            public final void onClick(View view) {
                this.nOl.nIK = new a(new a.a(this) {
                    final /* synthetic */ AnonymousClass12 nOp;

                    {
                        this.nOp = r1;
                    }

                    public final void a(ProgressDialog progressDialog) {
                        this.nOp.nOl.dwR = progressDialog;
                    }
                }, this.nOl.username, this.nOl.fTP, this.nOl.bhT);
                this.nOl.nIK.h(this.nOl);
            }
        });
        this.nOc.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MobileLoginOrForceReg nOl;

            {
                this.nOl = r1;
            }

            public final void onClick(View view) {
                if (this.nOl.nOj == null) {
                    Intent intent = new Intent();
                    b.mi("R200_900_phone");
                    intent.putExtra("regsetinfo_ticket", this.nOl.bax);
                    intent.putExtra("regsetinfo_user", this.nOl.bhT);
                    intent.putExtra("regsetinfo_ismobile", 1);
                    intent.putExtra("regsetinfo_isForce", true);
                    intent.putExtra("regsetinfo_NextControl", this.nOl.nOg);
                    intent.setClass(this.nOl, RegSetInfoUI.class);
                    this.nOl.startActivity(intent);
                    return;
                }
                MobileLoginOrForceReg.j(this.nOl);
            }
        });
        vD(2131233858);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MobileLoginOrForceReg nOl;

            {
                this.nOl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nOl.goBack();
                return false;
            }
        });
    }

    public void onResume() {
        super.onResume();
        b.mj(ak.uR() + "," + getClass().getName() + ",R200_600," + ak.dR("R200_600") + ",1");
        b.mh("R200_600");
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        ak.vy().b(701, (e) this);
        ak.vy().b(126, (e) this);
        ak.vy().b((int) WebView.NORMAL_MODE_ALPHA, (e) this);
        if (this.nJo != null) {
            this.nJo.close();
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130904088;
    }

    private void goBack() {
        b.mi("R200_100");
        com.tencent.mm.model.be.zN();
        Intent intent = new Intent(this, RegByMobileRegAIOUI.class);
        intent.putExtra("mobile_input_purpose", 2);
        intent.addFlags(67108864);
        startActivity(intent);
        b.mh(this.nFd);
        b.b(false, ak.uR() + "," + getClass().getName() + ",R200_600," + ak.dR("R200_600") + ",2");
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (this.nJh == null) {
            this.nJh = new f();
        }
        if (kVar.getType() == WebView.NORMAL_MODE_ALPHA) {
            if (i != 0 || i2 != 0) {
                boolean z = this.nOh;
                Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
                intent.putExtra("kintent_hint", getString(2131235066));
                intent.putExtra("kintent_cancelable", z);
                startActivityForResult(intent, 0);
            }
        } else if (kVar.getType() != 701 || this.nIK == null) {
            com.tencent.mm.f.a dm;
            Object obj;
            if (kVar.getType() == 126) {
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    final Boolean valueOf = Boolean.valueOf(this.nOi);
                    final String str2 = this.nOk;
                    final String str3 = this.nOj;
                    if (this.nFq == null) {
                        final k kVar2 = kVar;
                        final String str4 = str2;
                        final String str5 = str3;
                        final k kVar3 = kVar;
                        final Boolean bool = valueOf;
                        this.nFq = SecurityImage.a.a(this, 0, ((u) kVar).Fv(), ((u) kVar).Fw(), SQLiteDatabase.KeyEmpty, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ MobileLoginOrForceReg nOl;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                final k uVar = new u(SQLiteDatabase.KeyEmpty, str2, str3, 0, SQLiteDatabase.KeyEmpty, this.nOl.bhT, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, this.nOl.bax, this.nOl.cZg, SQLiteDatabase.KeyEmpty, ((u) kVar2).Fw(), this.nOl.nFq.bBA(), true, valueOf.booleanValue());
                                ak.vy().a(uVar, 0);
                                MobileLoginOrForceReg mobileLoginOrForceReg = this.nOl;
                                Context context = this.nOl.nDR.nEl;
                                this.nOl.getString(2131231164);
                                mobileLoginOrForceReg.dwR = g.a(context, this.nOl.getString(2131234461), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass18 nOs;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ak.vy().c(uVar);
                                    }
                                });
                            }
                        }, null, new OnDismissListener(this) {
                            final /* synthetic */ MobileLoginOrForceReg nOl;

                            {
                                this.nOl = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                                this.nOl.nFq = null;
                            }
                        }, new SecurityImage.b(this) {
                            final /* synthetic */ MobileLoginOrForceReg nOl;

                            public final void bAL() {
                                this.nOl.axg();
                                ak.vy().a(new u(SQLiteDatabase.KeyEmpty, str4, str5, 0, SQLiteDatabase.KeyEmpty, this.nOl.bhT, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, this.nOl.bax, this.nOl.cZg, SQLiteDatabase.KeyEmpty, ((u) kVar3).Fw(), SQLiteDatabase.KeyEmpty, true, bool.booleanValue()), 0);
                            }
                        });
                        return;
                    }
                    this.nFq.a(0, ((u) kVar).Fv(), ((u) kVar).Fw(), SQLiteDatabase.KeyEmpty);
                    return;
                }
                if (i == 0 && i2 == 0) {
                    final String str6 = this.bhT;
                    Boolean valueOf2 = Boolean.valueOf(this.nOi);
                    ak.unhold();
                    ak.aL(true);
                    if (valueOf2.booleanValue()) {
                        String str7 = com.tencent.mm.compatible.util.e.cgo + "temp.avatar";
                        String str8 = com.tencent.mm.compatible.util.e.cgo + "temp.avatar.hd";
                        new File(str7).renameTo(new File(str8));
                        com.tencent.mm.loader.stub.b.deleteFile(str7);
                        d.b(str8, 96, 96, CompressFormat.JPEG, 90, str7);
                        n nVar = new n(this, com.tencent.mm.compatible.util.e.cgo + "temp.avatar");
                        final k kVar4 = kVar;
                        Runnable anonymousClass4 = new Runnable(this) {
                            final /* synthetic */ MobileLoginOrForceReg nOl;

                            public final void run() {
                                this.nOl.bax = ((u) kVar4).Jq();
                                ai.cse.J("login_user_name", str6);
                                com.tencent.mm.loader.stub.b.deleteFile(com.tencent.mm.compatible.util.e.cgo + "temp.avatar");
                                Intent ak = com.tencent.mm.plugin.a.a.drp.ak(this.nOl);
                                ak.addFlags(67108864);
                                this.nOl.startActivity(ak);
                                b.mj(ak.uR() + "," + getClass().getName() + ",R200_600," + ak.dR("R200_600") + ",4");
                                this.nOl.finish();
                            }
                        };
                        kVar4 = kVar;
                        nVar.a(anonymousClass4, new Runnable(this) {
                            final /* synthetic */ MobileLoginOrForceReg nOl;

                            public final void run() {
                                this.nOl.bax = ((u) kVar4).Jq();
                                ai.cse.J("login_user_name", str6);
                                Intent ak = com.tencent.mm.plugin.a.a.drp.ak(this.nOl);
                                ak.addFlags(67108864);
                                this.nOl.startActivity(ak);
                                b.mj(ak.uR() + "," + getClass().getName() + ",R200_600," + ak.dR("R200_600") + ",4");
                                this.nOl.finish();
                            }
                        });
                    } else {
                        this.bax = ((u) kVar).Jq();
                        ai.cse.J("login_user_name", str6);
                        Intent ak = com.tencent.mm.plugin.a.a.drp.ak(this);
                        ak.addFlags(67108864);
                        ak.putExtra("LauncherUI.enter_from_reg", true);
                        startActivity(ak);
                        finish();
                        b.mi("RE900_100");
                        b.b(false, ak.uR() + "," + getClass().getName() + ",R200_600," + ak.dR("R200_600") + ",4");
                    }
                }
                dm = com.tencent.mm.f.a.dm(str);
                if (dm != null) {
                    dm.a(this, null, null);
                    return;
                }
            }
            if (!this.nJo.a(this, new p(i, i2, str))) {
                obj = null;
                switch (i2) {
                    case -140:
                        if (!be.kS(this.bpX)) {
                            l.j(this.nDR.nEl, str, this.bpX);
                        }
                        obj = 1;
                        break;
                    case -100:
                        ak.hold();
                        g.a(this.nDR.nEl, TextUtils.isEmpty(ak.uA()) ? com.tencent.mm.bd.a.O(this.nDR.nEl, 2131233716) : ak.uA(), this.nDR.nEl.getString(2131231164), new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ MobileLoginOrForceReg nOl;

                            {
                                this.nOl = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }, new OnCancelListener(this) {
                            final /* synthetic */ MobileLoginOrForceReg nOl;

                            {
                                this.nOl = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        });
                        obj = 1;
                        break;
                    case -75:
                        g.f(this, 2131230895, 2131234378);
                        obj = 1;
                        break;
                    case -43:
                        Toast.makeText(this, 2131231399, 0).show();
                        obj = 1;
                        break;
                    case -41:
                        Toast.makeText(this, 2131231401, 0).show();
                        obj = 1;
                        break;
                    case -36:
                        Toast.makeText(this, 2131231404, 0).show();
                        obj = 1;
                        break;
                    case -34:
                        Toast.makeText(this, 2131231402, 0).show();
                        obj = 1;
                        break;
                    case -33:
                        g.a((Context) this, 2131231445, 2131231451, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ MobileLoginOrForceReg nOl;

                            {
                                this.nOl = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        obj = 1;
                        break;
                    case -32:
                        g.a((Context) this, getString(2131231447), SQLiteDatabase.KeyEmpty, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ MobileLoginOrForceReg nOl;

                            {
                                this.nOl = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        obj = 1;
                        break;
                    default:
                        break;
                }
            }
            obj = 1;
            if (obj == null) {
                if (kVar.getType() == 701) {
                    dm = com.tencent.mm.f.a.dm(str);
                    if (dm != null && dm.a(this.nDR.nEl, null, null)) {
                        return;
                    }
                }
                if (i != 0 || i2 != 0) {
                    Toast.makeText(this.nDR.nEl, getString(2131231444, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        } else if (i2 == -6 || i2 == -311 || i2 == -310) {
            this.nJh.cYN = this.username;
            this.nJh.nJI = this.nOk;
            this.nJh.nJJ = ((s) kVar).Fw();
            this.nJh.nJL = ((s) kVar).Fv();
            this.nJh.nJK = ((s) kVar).Jj();
            this.nJh.nJM = ((s) kVar).Ji();
            if (this.nFq == null) {
                this.nFq = SecurityImage.a.a(this, this.nJh.nJM, this.nJh.nJL, this.nJh.nJJ, this.nJh.nJK, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ MobileLoginOrForceReg nOl;

                    {
                        this.nOl = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        v.d("MicorMsg.MobileLoginOrForceReg", "imgSid:" + this.nOl.nJh.nJJ + " img len" + this.nOl.nJh.nJL.length + " " + com.tencent.mm.compatible.util.g.sm());
                        final k sVar = new s(this.nOl.nJh.cYN, this.nOl.nJh.nJI, this.nOl.nJh.nJM, this.nOl.nFq.bBA(), this.nOl.nFq.nJJ, this.nOl.nFq.nJK, 1, SQLiteDatabase.KeyEmpty, false, true);
                        ak.vy().a(sVar, 0);
                        Context context = this.nOl;
                        this.nOl.getString(2131231164);
                        g.a(context, this.nOl.getString(2131233565), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass15 nOq;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(sVar);
                            }
                        });
                    }
                }, null, new OnDismissListener(this) {
                    final /* synthetic */ MobileLoginOrForceReg nOl;

                    {
                        this.nOl = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.nOl.nFq = null;
                    }
                }, this.nJh);
            } else {
                this.nFq.a(this.nJh.nJM, this.nJh.nJL, this.nJh.nJJ, this.nJh.nJK);
            }
        } else {
            this.bpX = ((s) kVar).Jh();
            this.nIK.a(this, i, i2, str, kVar);
            if (kVar instanceof s) {
                this.nOh = ((s) kVar).Jp();
            }
            if (i == 0 && i2 == 0) {
                final k tVar = new t(1);
                ak.vy().a(tVar, 0);
                getString(2131231164);
                this.dwR = g.a((Context) this, getString(2131235044), true, new OnCancelListener(this) {
                    final /* synthetic */ MobileLoginOrForceReg nOl;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(tVar);
                    }
                });
            }
        }
    }
}
