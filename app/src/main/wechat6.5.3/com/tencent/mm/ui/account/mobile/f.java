package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.widget.Toast;
import com.tencent.mm.f.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI.b;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class f implements b, e {
    SecurityImage nFq = null;
    private a nIK = null;
    com.tencent.mm.ui.account.f nJh = null;
    MobileVerifyUI nOt;

    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] nOw = new int[a.bBu().length];

        static {
            try {
                nOw[a.nPe - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                nOw[a.nPf - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                nOw[a.nPg - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public final void a(MobileVerifyUI mobileVerifyUI) {
        this.nOt = mobileVerifyUI;
    }

    public final void start() {
        com.tencent.mm.plugin.a.b.b(true, ak.uR() + "," + getClass().getName() + ",F200_300," + ak.dR("F200_300") + ",1");
        com.tencent.mm.plugin.a.b.mh("F200_300");
    }

    public final void stop() {
        int i = 2;
        if (this.nOt.nOU != -1) {
            i = this.nOt.nOU;
        }
        com.tencent.mm.plugin.a.b.b(false, ak.uR() + "," + getClass().getName() + ",F200_300," + ak.dR("F200_300") + "," + i);
    }

    public final boolean vX(int i) {
        final k uVar;
        MobileVerifyUI mobileVerifyUI;
        Context context;
        switch (AnonymousClass6.nOw[i - 1]) {
            case 1:
                ak.vy().a(145, (e) this);
                uVar = new u(this.nOt.bhT, 9, this.nOt.nNt.getText().toString().trim(), 0, SQLiteDatabase.KeyEmpty);
                ak.vy().a(uVar, 0);
                mobileVerifyUI = this.nOt;
                context = this.nOt;
                this.nOt.getString(2131231164);
                mobileVerifyUI.dwR = g.a(context, this.nOt.getString(2131231440), true, new OnCancelListener(this) {
                    final /* synthetic */ f nOu;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(uVar);
                        ak.vy().b(145, this.nOu);
                    }
                });
                break;
            case 2:
                com.tencent.mm.plugin.a.b.mj(ak.uR() + "," + getClass().getName() + ",R200_400," + ak.dR("R200_400") + ",1");
                ak.vy().a(145, (e) this);
                ak.vy().a(new u(this.nOt.bhT, 8, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty), 0);
                break;
            case 3:
                com.tencent.mm.plugin.a.b.mj(ak.uR() + "," + getClass().getName() + ",R200_350_auto," + ak.dR("R200_350_auto") + ",1");
                ak.vy().a(145, (e) this);
                uVar = new u(this.nOt.bhT, 9, this.nOt.nNt.getText().toString().trim(), 0, SQLiteDatabase.KeyEmpty);
                ak.vy().a(uVar, 0);
                mobileVerifyUI = this.nOt;
                context = this.nOt;
                this.nOt.getString(2131231164);
                mobileVerifyUI.dwR = g.a(context, this.nOt.getString(2131231440), true, new OnCancelListener(this) {
                    final /* synthetic */ f nOu;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(uVar);
                        ak.vy().b(145, this.nOu);
                    }
                });
                break;
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.MobileVerifyForgetPwdLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.nOt.dwR != null) {
            this.nOt.dwR.dismiss();
            this.nOt.dwR = null;
        }
        if (this.nJh == null) {
            this.nJh = new com.tencent.mm.ui.account.f();
        }
        if (kVar.getType() != 701 || this.nIK == null) {
            a dm;
            if (kVar.getType() == 145) {
                this.nJh.cYN = ((u) kVar).getUsername();
                this.nJh.nJI = ((u) kVar).Fh();
                ak.vy().b(145, (e) this);
                if (((u) kVar).AG() != 9) {
                    return;
                }
                if (i == 0 && i2 == 0) {
                    ak.vy().a(701, (e) this);
                    this.nIK = new a(new a.a(this) {
                        final /* synthetic */ f nOu;

                        {
                            this.nOu = r1;
                        }

                        public final void a(ProgressDialog progressDialog) {
                            this.nOu.nOt.dwR = progressDialog;
                        }
                    }, ((u) kVar).getUsername(), ((u) kVar).Fh(), this.nOt.bhT);
                    this.nIK.h(this.nOt);
                    return;
                } else if (i2 == -51) {
                    dm = a.dm(str);
                    if (dm != null) {
                        dm.a(this.nOt, null, null);
                        return;
                    } else {
                        g.f(this.nOt, 2131231445, 2131231451);
                        return;
                    }
                }
            }
            if (!this.nOt.k(i, i2, str)) {
                if (kVar.getType() == 701) {
                    dm = a.dm(str);
                    if (dm != null && dm.a(this.nOt, null, null)) {
                        return;
                    }
                }
                if (i != 0 || i2 != 0) {
                    Toast.makeText(this.nOt, this.nOt.getString(2131231444, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    return;
                }
                return;
            }
            return;
        }
        ak.vy().b(701, (e) this);
        this.nJh.nJJ = ((s) kVar).Fw();
        this.nJh.nJL = ((s) kVar).Fv();
        this.nJh.nJK = ((s) kVar).Jj();
        this.nJh.nJM = ((s) kVar).Ji();
        if (i2 == -6 || i2 == -311 || i2 == -310) {
            ak.vy().a(701, (e) this);
            if (this.nFq == null) {
                this.nFq = SecurityImage.a.a(this.nOt, this.nJh.nJM, this.nJh.nJL, this.nJh.nJJ, this.nJh.nJK, new OnClickListener(this) {
                    final /* synthetic */ f nOu;

                    {
                        this.nOu = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        v.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.nOu.nJh.nJJ + " img len" + this.nOu.nJh.nJL.length + " " + com.tencent.mm.compatible.util.g.sm());
                        final k sVar = new s(this.nOu.nJh.cYN, this.nOu.nJh.nJI, this.nOu.nJh.nJM, this.nOu.nFq.bBA(), this.nOu.nFq.nJJ, this.nOu.nFq.nJK, 1, SQLiteDatabase.KeyEmpty, false, true);
                        ak.vy().a(sVar, 0);
                        Context context = this.nOu.nOt;
                        this.nOu.nOt.getString(2131231164);
                        g.a(context, this.nOu.nOt.getString(2131233565), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass3 nOv;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(sVar);
                                ak.vy().b(701, this.nOv.nOu);
                            }
                        });
                    }
                }, null, new OnDismissListener(this) {
                    final /* synthetic */ f nOu;

                    {
                        this.nOu = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.nOu.nFq = null;
                    }
                }, this.nJh);
                return;
            }
            v.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.nJh.nJJ + " img len" + this.nJh.nJL.length + " " + com.tencent.mm.compatible.util.g.sm());
            this.nFq.a(this.nJh.nJM, this.nJh.nJL, this.nJh.nJJ, this.nJh.nJK);
            return;
        }
        this.nIK.a(this.nOt, i, i2, str, kVar);
        if (i == 0 && i2 == 0) {
            boolean Jp;
            if (kVar instanceof s) {
                Jp = ((s) kVar).Jp();
            } else {
                Jp = true;
            }
            this.nOt.je(Jp);
        }
    }
}
