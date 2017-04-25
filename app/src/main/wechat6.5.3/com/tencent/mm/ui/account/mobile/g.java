package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.f.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.account.RegSetInfoUI;
import com.tencent.mm.ui.account.f;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI.b;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;

@Deprecated
public final class g implements b, e {
    private a nIK = null;
    f nJh = new f();
    MobileVerifyUI nOt;
    private boolean nOx = true;

    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] nOw = new int[a.bBu().length];

        static {
            try {
                nOw[a.nPd - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                nOw[a.nPe - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                nOw[a.nPf - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                nOw[a.nPg - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public final void a(MobileVerifyUI mobileVerifyUI) {
        this.nOt = mobileVerifyUI;
    }

    public final void start() {
        com.tencent.mm.plugin.a.b.b(true, ak.uR() + "," + getClass().getName() + ",L200_400," + ak.dR("L200_400") + ",1");
        com.tencent.mm.plugin.a.b.mh("L200_400");
        ak.vy().a(701, (e) this);
    }

    public final void stop() {
        int i = 2;
        if (this.nOt.nOU != -1) {
            i = this.nOt.nOU;
        }
        com.tencent.mm.plugin.a.b.b(false, ak.uR() + "," + getClass().getName() + ",L200_400," + ak.dR("L200_400") + "," + i);
        ak.vy().b(701, (e) this);
    }

    public final boolean vX(int i) {
        final k uVar;
        MobileVerifyUI mobileVerifyUI;
        Context context;
        switch (AnonymousClass9.nOw[i - 1]) {
            case 1:
                com.tencent.mm.plugin.a.b.mi("L200_100");
                Intent intent = new Intent(this.nOt, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                intent.addFlags(67108864);
                this.nOt.startActivity(intent);
                this.nOt.finish();
                break;
            case 2:
                ak.vy().a(145, (e) this);
                uVar = new u(this.nOt.bhT, 17, this.nOt.nNt.getText().toString().trim(), 0, SQLiteDatabase.KeyEmpty);
                ak.vy().a(uVar, 0);
                mobileVerifyUI = this.nOt;
                context = this.nOt;
                this.nOt.getString(2131231164);
                mobileVerifyUI.dwR = com.tencent.mm.ui.base.g.a(context, this.nOt.getString(2131231440), true, new OnCancelListener(this) {
                    final /* synthetic */ g nOy;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(uVar);
                        ak.vy().b(145, this.nOy);
                    }
                });
                break;
            case 3:
                com.tencent.mm.plugin.a.b.mj(ak.uR() + "," + getClass().getName() + ",R200_400," + ak.dR("R200_400") + ",1");
                ak.vy().a(145, (e) this);
                ak.vy().a(new u(this.nOt.bhT, 16, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty), 0);
                break;
            case 4:
                com.tencent.mm.plugin.a.b.mj(ak.uR() + "," + getClass().getName() + ",R200_350_auto," + ak.dR("R200_350_auto") + ",1");
                ak.vy().a(145, (e) this);
                uVar = new u(this.nOt.bhT, 17, this.nOt.nNt.getText().toString().trim(), 0, SQLiteDatabase.KeyEmpty);
                ak.vy().a(uVar, 0);
                mobileVerifyUI = this.nOt;
                context = this.nOt;
                this.nOt.getString(2131231164);
                mobileVerifyUI.dwR = com.tencent.mm.ui.base.g.a(context, this.nOt.getString(2131231440), true, new OnCancelListener(this) {
                    final /* synthetic */ g nOy;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(uVar);
                        ak.vy().b(145, this.nOy);
                    }
                });
                break;
        }
        return false;
    }

    public final void a(int i, int i2, String str, final k kVar) {
        v.i("MicroMsg.MobileVerifyLoginLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.nOt.dwR != null) {
            this.nOt.dwR.dismiss();
            this.nOt.dwR = null;
        }
        if (kVar.getType() == WebView.NORMAL_MODE_ALPHA) {
            ak.vy().b((int) WebView.NORMAL_MODE_ALPHA, (e) this);
            if (i != 0 || i2 != 0) {
                this.nOt.je(this.nOx);
                return;
            }
            return;
        }
        a dm;
        if (kVar.getType() == 701) {
            this.nJh.nJM = ((s) kVar).Ji();
            this.nJh.nJJ = ((s) kVar).Fw();
            this.nJh.nJL = ((s) kVar).Fv();
            this.nJh.nJK = ((s) kVar).Jj();
        }
        if (kVar.getType() == 701 && this.nIK != null) {
            this.nIK.nJV = this.nOt.nJV;
            this.nIK.a(this.nOt, i, i2, str, kVar);
            if (i == 0 && i2 == 0) {
                if (kVar instanceof s) {
                    this.nOx = ((s) kVar).Jp();
                }
                ak.vy().a((int) WebView.NORMAL_MODE_ALPHA, (e) this);
                ak.vy().a(new t(1), 0);
                MobileVerifyUI mobileVerifyUI = this.nOt;
                Context context = this.nOt;
                this.nOt.getString(2131231164);
                mobileVerifyUI.dwR = com.tencent.mm.ui.base.g.a(context, this.nOt.getString(2131235044), true, new OnCancelListener(this) {
                    final /* synthetic */ g nOy;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(kVar);
                    }
                });
                return;
            } else if (i2 == -140) {
                return;
            } else {
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    if (this.nOt.nFq == null) {
                        this.nOt.nFq = SecurityImage.a.a(this.nOt, this.nJh.nJM, this.nJh.nJL, this.nJh.nJJ, this.nJh.nJK, new OnClickListener(this) {
                            final /* synthetic */ g nOy;

                            {
                                this.nOy = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                v.d("MicroMsg.MobileVerifyLoginLogic", "imgSid:" + this.nOy.nJh.nJJ + " img len" + this.nOy.nJh.nJL.length + " " + com.tencent.mm.compatible.util.g.sm());
                                final k sVar = new s(this.nOy.nJh.cYN, this.nOy.nJh.nJI, this.nOy.nJh.nJM, this.nOy.nOt.nFq.bBA(), this.nOy.nOt.nFq.nJJ, this.nOy.nOt.nFq.nJK, 1, SQLiteDatabase.KeyEmpty, false, true);
                                ak.vy().a(sVar, 0);
                                MobileVerifyUI mobileVerifyUI = this.nOy.nOt;
                                Context context = this.nOy.nOt;
                                this.nOy.nOt.getString(2131231164);
                                mobileVerifyUI.dwR = com.tencent.mm.ui.base.g.a(context, this.nOy.nOt.getString(2131233565), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass4 nOz;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ak.vy().c(sVar);
                                    }
                                });
                            }
                        }, null, new OnDismissListener(this) {
                            final /* synthetic */ g nOy;

                            {
                                this.nOy = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                                this.nOy.nOt.nFq = null;
                            }
                        }, this.nJh);
                        return;
                    }
                    v.d("MicroMsg.MobileVerifyLoginLogic", "imgSid:" + this.nJh.nJJ + " img len" + this.nJh.nJL.length + " " + com.tencent.mm.compatible.util.g.sm());
                    this.nOt.nFq.a(this.nJh.nJM, this.nJh.nJL, this.nJh.nJJ, this.nJh.nJK);
                    return;
                }
            }
        }
        if (kVar.getType() == 145) {
            ak.vy().b(145, (e) this);
            if (((u) kVar).AG() != 17) {
                return;
            }
            if (i == 0 && i2 == 0) {
                this.nJh.cYN = ((u) kVar).getUsername();
                this.nJh.nJH = SQLiteDatabase.KeyEmpty;
                this.nJh.nJI = ((u) kVar).Fh();
                this.nIK = new a(new a.a(this) {
                    final /* synthetic */ g nOy;

                    {
                        this.nOy = r1;
                    }

                    public final void a(ProgressDialog progressDialog) {
                        this.nOy.nOt.dwR = progressDialog;
                    }
                }, ((u) kVar).getUsername(), ((u) kVar).Fh(), this.nOt.bhT);
                this.nIK.h(this.nOt);
                return;
            } else if (i2 == -30) {
                com.tencent.mm.plugin.a.b.mj(ak.uR() + "," + getClass().getName() + ",L200_900_phone," + ak.dR("L200_900_phone") + ",1");
                String str2 = a.dm(str).desc;
                Context context2 = this.nOt;
                if (be.kS(str2)) {
                    str2 = this.nOt.getString(2131233577);
                }
                com.tencent.mm.ui.base.g.b(context2, str2, SQLiteDatabase.KeyEmpty, this.nOt.getString(2131233579), this.nOt.getString(2131233578), new OnClickListener(this) {
                    final /* synthetic */ g nOy;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (d.lWk) {
                            String string = this.nOy.nOt.getString(2131232240, new Object[]{"0x" + Integer.toHexString(d.lWh), com.tencent.mm.sdk.platformtools.u.bsY()});
                            v.e("MicroMsg.MobileVerifyLoginLogic", "url " + string);
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", string);
                            intent.putExtra("showShare", false);
                            intent.putExtra("show_bottom", false);
                            intent.putExtra("needRedirect", false);
                            intent.putExtra("neverGetA8Key", true);
                            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                            com.tencent.mm.plugin.a.a.drp.j(intent, this.nOy.nOt);
                            return;
                        }
                        intent = new Intent();
                        intent.putExtra("regsetinfo_ticket", ((u) kVar).Fi());
                        intent.putExtra("regsetinfo_user", this.nOy.nOt.bhT);
                        intent.putExtra("regsetinfo_ismobile", 1);
                        intent.putExtra("regsetinfo_NextControl", ((u) kVar).Fl());
                        intent.setClass(this.nOy.nOt, RegSetInfoUI.class);
                        com.tencent.mm.plugin.a.b.mi("R200_950_olduser");
                        this.nOy.nOt.startActivity(intent);
                        com.tencent.mm.plugin.a.b.mj(ak.uR() + "," + getClass().getName() + ",L200_900_phone," + ak.dR("L200_900_phone") + ",2");
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ g nOy;

                    {
                        this.nOy = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.a.b.mi("L200_100");
                        Intent intent = new Intent(this.nOy.nOt, MobileInputUI.class);
                        intent.putExtra("mobile_input_purpose", 1);
                        intent.addFlags(67108864);
                        this.nOy.nOt.startActivity(intent);
                        com.tencent.mm.plugin.a.b.mj(ak.uR() + "," + getClass().getName() + ",L200_900_phone," + ak.dR("L200_900_phone") + ",2");
                    }
                });
                return;
            } else if (i2 == -51) {
                dm = a.dm(str);
                if (dm != null) {
                    dm.a(this.nOt, null, null);
                    return;
                } else {
                    com.tencent.mm.ui.base.g.f(this.nOt, 2131231445, 2131231451);
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
            }
        }
    }
}
