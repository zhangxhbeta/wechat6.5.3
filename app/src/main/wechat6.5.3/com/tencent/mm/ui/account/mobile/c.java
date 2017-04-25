package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.l;
import com.tencent.mm.plugin.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.account.LoginUI;
import com.tencent.mm.ui.account.f;
import com.tencent.mm.ui.account.mobile.MobileInputUI.b;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class c implements b, e {
    private String bpX;
    private String cYN;
    private String ivc;
    SecurityImage nFq = null;
    MobileInputUI nNH;

    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] nNJ = new int[a.bBs().length];

        static {
            try {
                nNJ[a.nNZ - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public final void a(final MobileInputUI mobileInputUI) {
        this.nNH = mobileInputUI;
        mobileInputUI.vD(2131233862);
        mobileInputUI.nKv.setVisibility(0);
        mobileInputUI.nJT.setVisibility(0);
        mobileInputUI.nNU.setVisibility(0);
        mobileInputUI.nNQ.setVisibility(0);
        mobileInputUI.nNT.setVisibility(0);
        mobileInputUI.V(0, false);
        mobileInputUI.nNU.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c nNL;

            public final void onClick(View view) {
                com.tencent.mm.ui.account.e.V(mobileInputUI.nDR.nEl, 2);
            }
        });
        mobileInputUI.nNT.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c nNL;

            public final void onClick(View view) {
                String trim = mobileInputUI.nIG.getText().toString().trim();
                mobileInputUI.nIP = mobileInputUI.nKq.getCountryCode();
                mobileInputUI.hUm = mobileInputUI.nKq.bBT();
                mobileInputUI.axg();
                com.tencent.mm.ui.account.e.f(mobileInputUI, trim, mobileInputUI.nIP, mobileInputUI.hUm);
            }
        });
        mobileInputUI.nNQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c nNL;

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(mobileInputUI, LoginUI.class);
                intent.putExtra("login_type", 1);
                mobileInputUI.startActivity(intent);
            }
        });
        this.ivc = mobileInputUI.getIntent().getStringExtra("auth_ticket");
        if (!be.kS(this.ivc)) {
            new ac().postDelayed(new Runnable(this) {
                final /* synthetic */ c nNL;

                {
                    this.nNL = r1;
                }

                public final void run() {
                    this.nNL.dW(f.bAR(), f.bAS());
                }
            }, 500);
        }
    }

    public final void start() {
        ak.vy().a(701, (e) this);
        ak.vy().a(145, (e) this);
        com.tencent.mm.plugin.a.b.b(true, ak.uR() + "," + getClass().getName() + ",L200_100," + ak.dR("L200_100") + ",1");
        com.tencent.mm.plugin.a.b.mh("L200_100");
    }

    public final void stop() {
        ak.vy().b(701, (e) this);
        ak.vy().b(145, (e) this);
        com.tencent.mm.plugin.a.b.b(false, ak.uR() + "," + getClass().getName() + ",L200_100," + ak.dR("L200_100") + ",2");
    }

    public final void vW(int i) {
        switch (AnonymousClass4.nNJ[i - 1]) {
            case 1:
                if (!be.kS(this.nNH.nIP) && !be.kS(this.nNH.hUm)) {
                    this.cYN = al.Kq(this.nNH.nIP + this.nNH.hUm);
                    dW(this.cYN, this.nNH.fAv.getText().toString());
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dW(String str, String str2) {
        if (be.kS(str)) {
            g.f(this.nNH, 2131235782, 2131233557);
        } else if (be.kS(str2)) {
            g.f(this.nNH, 2131235780, 2131233557);
        } else {
            this.nNH.fAv.setText(str2);
            this.nNH.axg();
            ak.vy().a(701, (e) this);
            final k sVar = new s(str, str2, null, 1);
            ak.vy().a(sVar, 0);
            MobileInputUI mobileInputUI = this.nNH;
            Context context = this.nNH;
            this.nNH.getString(2131231164);
            mobileInputUI.nIO = g.a(context, this.nNH.getString(2131233565), true, new OnCancelListener(this) {
                final /* synthetic */ c nNL;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(sVar);
                }
            });
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.nNH.nIO != null) {
            this.nNH.nIO.dismiss();
            this.nNH.nIO = null;
        }
        if (kVar.getType() == 701) {
            this.bpX = ((s) kVar).Jh();
            final SecurityImage.b fVar = new f();
            ak.vy().b(701, (e) this);
            fVar.nJJ = ((s) kVar).Fw();
            fVar.nJL = ((s) kVar).Fv();
            fVar.nJK = ((s) kVar).Jj();
            fVar.nJM = ((s) kVar).Ji();
            fVar.cYN = this.cYN;
            fVar.nJH = this.nNH.fAv.getText().toString();
            if (i2 == -75) {
                l.bl(this.nNH);
                return;
            } else if (i2 == -106) {
                l.D(this.nNH, str);
                return;
            } else if (i2 == -217) {
                l.a(this.nNH, ((s) kVar).Jg(), i2);
                return;
            } else if (i2 == -205) {
                this.ivc = ((s) kVar).Fj();
                String Jk = ((s) kVar).Jk();
                v.i("MicroMsg.MobileInputIndepPassLoginLogic", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", be.KW(this.ivc), ((s) kVar).Jn());
                f.a(fVar);
                Intent intent = new Intent();
                intent.putExtra("auth_ticket", this.ivc);
                intent.putExtra("binded_mobile", Jk);
                intent.putExtra("close_safe_device_style", r3);
                intent.putExtra("from_source", 6);
                a.drp.f(this.nNH, intent);
                return;
            } else if (i2 != -140) {
                int i3;
                boolean z;
                if (i == 4 && (i2 == -16 || i2 == -17)) {
                    ak.vy().a(new ay(new ay.a(this) {
                        final /* synthetic */ c nNL;

                        {
                            this.nNL = r1;
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
                    i3 = 1;
                } else {
                    z = false;
                }
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    ak.vy().a(701, (e) this);
                    if (this.nFq == null) {
                        this.nFq = SecurityImage.a.a(this.nNH, fVar.nJM, fVar.nJL, fVar.nJJ, fVar.nJK, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ c nNL;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                v.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + fVar.nJJ + " img len" + fVar.nJL.length + " " + com.tencent.mm.compatible.util.g.sm());
                                final k sVar = new s(fVar.cYN, fVar.nJH, fVar.nJM, this.nNL.nFq.bBA(), this.nNL.nFq.nJJ, this.nNL.nFq.nJK, 1, SQLiteDatabase.KeyEmpty, false, false);
                                ak.vy().a(sVar, 0);
                                MobileInputUI mobileInputUI = this.nNL.nNH;
                                Context context = this.nNL.nNH;
                                this.nNL.nNH.getString(2131231164);
                                mobileInputUI.nIO = g.a(context, this.nNL.nNH.getString(2131233565), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass10 nNN;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ak.vy().c(sVar);
                                        ak.vy().b(701, this.nNN.nNL);
                                    }
                                });
                            }
                        }, null, new OnDismissListener(this) {
                            final /* synthetic */ c nNL;

                            {
                                this.nNL = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                                this.nNL.nFq = null;
                            }
                        }, fVar);
                        return;
                    }
                    v.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + fVar.nJJ + " img len" + fVar.nJL.length + " " + com.tencent.mm.compatible.util.g.sm());
                    this.nFq.a(fVar.nJM, fVar.nJL, fVar.nJJ, fVar.nJK);
                    return;
                } else if (i3 != 0 || (i == 0 && i2 == 0)) {
                    ak.unhold();
                    l.lX(fVar.cYN);
                    d.aX(this.nNH);
                    l.a(this.nNH, new Runnable(this) {
                        final /* synthetic */ c nNL;

                        {
                            this.nNL = r1;
                        }

                        public final void run() {
                            v.d("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd, in runnable");
                            Intent ak = a.drp.ak(this.nNL.nNH);
                            ak.addFlags(67108864);
                            this.nNL.nNH.startActivity(ak);
                            this.nNL.nNH.finish();
                        }
                    }, false, 2);
                    return;
                } else {
                    if (a.drq.a(this.nNH, i, i2, str)) {
                        i3 = 1;
                    } else {
                        if (i == 4) {
                            switch (i2) {
                                case -140:
                                    if (!be.kS(this.bpX)) {
                                        l.j(this.nNH, str, this.bpX);
                                    }
                                    i3 = 1;
                                    break;
                                case -100:
                                    ak.hold();
                                    g.a(this.nNH, TextUtils.isEmpty(ak.uA()) ? com.tencent.mm.bd.a.O(this.nNH, 2131233716) : ak.uA(), this.nNH.getString(2131231164), new DialogInterface.OnClickListener(this) {
                                        final /* synthetic */ c nNL;

                                        {
                                            this.nNL = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                        }
                                    }, new OnCancelListener(this) {
                                        final /* synthetic */ c nNL;

                                        {
                                            this.nNL = r1;
                                        }

                                        public final void onCancel(DialogInterface dialogInterface) {
                                        }
                                    });
                                    i3 = 1;
                                    break;
                                case -9:
                                    g.f(this.nNH, 2131233556, 2131233557);
                                    i3 = 1;
                                    break;
                                case -4:
                                case -3:
                                    g.f(this.nNH, 2131232483, 2131233557);
                                    i3 = 1;
                                    break;
                                case -1:
                                    if (ak.vy().BJ() != 5) {
                                        z = false;
                                        break;
                                    }
                                    g.f(this.nNH, 2131234021, 2131234020);
                                    i3 = 1;
                                    break;
                            }
                        }
                        z = false;
                    }
                    if (i3 != 0) {
                        return;
                    }
                    if (!(i == 0 && i2 == 0)) {
                        Toast.makeText(this.nNH, this.nNH.getString(2131232858, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    }
                }
            } else if (!be.kS(this.bpX)) {
                l.j(this.nNH, str, this.bpX);
                return;
            } else {
                return;
            }
        }
        if (kVar.getType() == 701) {
            com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
            if (dm != null && this.nNH != null && dm.a(this.nNH, null, null)) {
            }
        }
    }
}
