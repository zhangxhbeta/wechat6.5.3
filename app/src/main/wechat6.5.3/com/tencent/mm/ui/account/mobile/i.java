package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.be;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.accountsync.a.c;
import com.tencent.mm.plugin.accountsync.a.c.a;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.RegSetInfoUI;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI.b;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.bindmobile.FindMContactAlertUI;
import com.tencent.mm.ui.bindmobile.FindMContactIntroUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.Map;

public final class i implements b, e {
    String cZU;
    a nIK = null;
    String nOB;
    MobileVerifyUI nOt;
    private boolean nOx = true;

    static /* synthetic */ class AnonymousClass8 {
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
        be.zN();
        com.tencent.mm.plugin.a.b.b(true, ak.uR() + "," + getClass().getName() + ",RE200_300," + ak.dR("RE200_300") + ",1");
        com.tencent.mm.plugin.a.b.mh("RE200_300");
    }

    public final void stop() {
    }

    public final boolean vX(int i) {
        final k uVar;
        MobileVerifyUI mobileVerifyUI;
        Context context;
        switch (AnonymousClass8.nOw[i - 1]) {
            case 1:
                g.b(this.nOt, this.nOt.getString(2131233865), SQLiteDatabase.KeyEmpty, this.nOt.getString(2131233866), this.nOt.getString(2131233867), new OnClickListener(this) {
                    final /* synthetic */ i nOC;

                    {
                        this.nOC = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.nOC.nOt.finish();
                        c.gN(a.dwp);
                        be.zN();
                        com.tencent.mm.plugin.a.b.mi(this.nOC.nOt.ivg);
                        com.tencent.mm.plugin.a.b.b(false, ak.uR() + "," + getClass().getName() + ",RE200_300," + ak.dR("RE200_300") + ",2");
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ i nOC;

                    {
                        this.nOC = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            case 2:
                ak.vy().a(145, (e) this);
                uVar = new u(this.nOt.bhT, 15, this.nOt.nNt.getText().toString().trim(), 0, SQLiteDatabase.KeyEmpty);
                ak.vy().a(uVar, 0);
                mobileVerifyUI = this.nOt;
                context = this.nOt;
                this.nOt.getString(2131231164);
                mobileVerifyUI.dwR = g.a(context, this.nOt.getString(2131231440), true, new OnCancelListener(this) {
                    final /* synthetic */ i nOC;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(uVar);
                        ak.vy().b(145, this.nOC);
                    }
                });
                return false;
            case 3:
                com.tencent.mm.plugin.a.b.mj(ak.uR() + "," + getClass().getName() + ",R200_400," + ak.dR("R200_400") + ",1");
                be.zN();
                com.tencent.mm.plugin.a.b.mh("RE200_250");
                ak.vy().a(145, (e) this);
                ak.vy().a(new u(this.nOt.bhT, 14, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty), 0);
                c.gN(a.dwq);
                return false;
            case 4:
                com.tencent.mm.plugin.a.b.mj(ak.uR() + "," + getClass().getName() + ",R200_350_auto," + ak.dR("R200_350_auto") + ",1");
                ak.vy().a(145, (e) this);
                uVar = new u(this.nOt.bhT, 15, this.nOt.nNt.getText().toString().trim(), 0, SQLiteDatabase.KeyEmpty);
                ak.vy().a(uVar, 0);
                mobileVerifyUI = this.nOt;
                context = this.nOt;
                this.nOt.getString(2131231164);
                mobileVerifyUI.dwR = g.a(context, this.nOt.getString(2131231440), true, new OnCancelListener(this) {
                    final /* synthetic */ i nOC;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(uVar);
                        ak.vy().b(145, this.nOC);
                    }
                });
                return false;
            default:
                return false;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.MobileVerifyRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.nOt.dwR != null) {
            this.nOt.dwR.dismiss();
            this.nOt.dwR = null;
        }
        if (kVar.getType() == WebView.NORMAL_MODE_ALPHA) {
            ak.vy().b((int) WebView.NORMAL_MODE_ALPHA, (e) this);
            if (i != 0 || i2 != 0) {
                this.nOt.je(this.nOx);
            }
        } else if (kVar.getType() != 701 || this.nIK == null) {
            com.tencent.mm.f.a dm;
            int AG;
            Intent intent;
            String str2;
            if (kVar.getType() == 145) {
                ak.vy().b(145, (e) this);
                AG = ((u) kVar).AG();
                if (AG != 15) {
                    return;
                }
                if (i == 0 && i2 == 0) {
                    if (AG != 15) {
                        return;
                    }
                    if (this.nOt.nOR.booleanValue()) {
                        this.nOB = ((u) kVar).Fi();
                        ak.vy().a(126, (e) this);
                        r3 = new com.tencent.mm.modelsimple.u(SQLiteDatabase.KeyEmpty, this.nOt.fTP, this.nOt.aGX, 0, SQLiteDatabase.KeyEmpty, this.nOt.bhT, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, this.nOB, this.nOt.cZg, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, true, this.nOt.nOQ.booleanValue());
                        ak.vy().a(r3, 0);
                        r4 = this.nOt;
                        r5 = this.nOt;
                        this.nOt.getString(2131231164);
                        r4.dwR = g.a(r5, this.nOt.getString(2131234461), true, new OnCancelListener(this) {
                            final /* synthetic */ i nOC;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(r3);
                                ak.vy().b(126, this.nOC);
                            }
                        });
                        return;
                    }
                    intent = new Intent();
                    intent.putExtra("regsetinfo_ticket", ((u) kVar).Fi());
                    intent.putExtra("regsetinfo_user", this.nOt.bhT);
                    intent.putExtra("regsetinfo_ismobile", 1);
                    intent.putExtra("regsetinfo_NextControl", ((u) kVar).Fl());
                    intent.setClass(this.nOt, RegSetInfoUI.class);
                    this.nOt.startActivity(intent);
                    c.gN(a.dwr);
                    com.tencent.mm.plugin.a.b.mi("R200_900_phone");
                    be.zN();
                    str2 = "RE200_300";
                    com.tencent.mm.plugin.a.b.b(false, ak.uR() + "," + getClass().getName() + "," + str2 + "," + ak.dR(str2) + ",2");
                    return;
                } else if (i2 == -35) {
                    dm = com.tencent.mm.f.a.dm(str);
                    final k kVar2;
                    if (dm != null) {
                        kVar2 = kVar;
                        dm.a(this.nOt, new OnClickListener(this) {
                            final /* synthetic */ i nOC;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ak.vy().a(701, this.nOC);
                                this.nOC.nIK = new a(new a.a(this) {
                                    final /* synthetic */ AnonymousClass13 nOE;

                                    {
                                        this.nOE = r1;
                                    }

                                    public final void a(ProgressDialog progressDialog) {
                                        this.nOE.nOC.nOt.dwR = progressDialog;
                                    }
                                }, ((u) kVar2).getUsername(), ((u) kVar2).Fh(), this.nOC.nOt.bhT);
                                this.nOC.nIK.h(this.nOC.nOt);
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ i nOC;

                            {
                                this.nOC = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        return;
                    }
                    kVar2 = kVar;
                    g.a(this.nOt, this.nOt.getString(2131231385), null, new OnClickListener(this) {
                        final /* synthetic */ i nOC;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ak.vy().a(701, this.nOC);
                            this.nOC.nIK = new a(new a.a(this) {
                                final /* synthetic */ AnonymousClass15 nOF;

                                {
                                    this.nOF = r1;
                                }

                                public final void a(ProgressDialog progressDialog) {
                                    this.nOF.nOC.nOt.dwR = progressDialog;
                                }
                            }, ((u) kVar2).getUsername(), ((u) kVar2).Fh(), this.nOC.nOt.bhT);
                            this.nOC.nIK.h(this.nOC.nOt);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ i nOC;

                        {
                            this.nOC = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                } else if (i2 == -212) {
                    intent = new Intent(this.nOt, MobileLoginOrForceReg.class);
                    intent.putExtra("ticket", ((u) kVar).Fi());
                    intent.putExtra("moble", this.nOt.bhT);
                    intent.putExtra("next_controll", ((u) kVar).Fl());
                    intent.putExtra("username", ((u) kVar).getUsername());
                    intent.putExtra("password", ((u) kVar).Fh());
                    intent.putExtra("nickname", ((u) kVar).Fs());
                    intent.putExtra("avatar_url", ((u) kVar).Fr());
                    if (this.nOt.nOR.booleanValue()) {
                        intent.putExtra("kintent_nickname", this.nOt.aGX);
                        intent.putExtra("kintent_password", this.nOt.fTP);
                        intent.putExtra("kintent_hasavatar", this.nOt.nOQ);
                    }
                    this.nOt.startActivity(intent);
                    com.tencent.mm.plugin.a.b.mi("R200_600");
                    be.zN();
                    str2 = "RE200_300";
                    com.tencent.mm.plugin.a.b.b(false, ak.uR() + "," + getClass().getName() + "," + str2 + "," + ak.dR(str2) + ",2");
                    return;
                } else if (i2 == -51) {
                    dm = com.tencent.mm.f.a.dm(str);
                    if (dm != null) {
                        dm.a(this.nOt, null, null);
                        return;
                    } else {
                        g.f(this.nOt, 2131231445, 2131231451);
                        return;
                    }
                }
            } else if (kVar.getType() == 126) {
                final String str3;
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    final Boolean bool = this.nOt.nOQ;
                    final String str4 = this.nOt.fTP;
                    str3 = this.nOt.aGX;
                    if (this.nOt.nFq == null) {
                        final k kVar3 = kVar;
                        final String str5 = str4;
                        final String str6 = str3;
                        final k kVar4 = kVar;
                        final Boolean bool2 = bool;
                        this.nOt.nFq = SecurityImage.a.a(this.nOt, 0, ((com.tencent.mm.modelsimple.u) kVar).Fv(), ((com.tencent.mm.modelsimple.u) kVar).Fw(), SQLiteDatabase.KeyEmpty, new OnClickListener(this) {
                            final /* synthetic */ i nOC;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ak.vy().a(126, this.nOC);
                                final k uVar = new com.tencent.mm.modelsimple.u(SQLiteDatabase.KeyEmpty, str4, str3, 0, SQLiteDatabase.KeyEmpty, this.nOC.nOt.bhT, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, this.nOC.nOB, this.nOC.nOt.cZg, SQLiteDatabase.KeyEmpty, ((com.tencent.mm.modelsimple.u) kVar3).Fw(), this.nOC.nOt.nFq.bBA(), true, bool.booleanValue());
                                ak.vy().a(uVar, 0);
                                MobileVerifyUI mobileVerifyUI = this.nOC.nOt;
                                Context context = this.nOC.nOt;
                                this.nOC.nOt.getString(2131231164);
                                mobileVerifyUI.dwR = g.a(context, this.nOC.nOt.getString(2131234461), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass2 nOD;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ak.vy().c(uVar);
                                        ak.vy().b(126, this.nOD.nOC);
                                    }
                                });
                            }
                        }, null, new OnDismissListener(this) {
                            final /* synthetic */ i nOC;

                            {
                                this.nOC = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                                this.nOC.nOt.nFq = null;
                            }
                        }, new SecurityImage.b(this) {
                            final /* synthetic */ i nOC;

                            public final void bAL() {
                                this.nOC.nOt.axg();
                                ak.vy().a(126, this.nOC);
                                ak.vy().a(new com.tencent.mm.modelsimple.u(SQLiteDatabase.KeyEmpty, str5, str6, 0, SQLiteDatabase.KeyEmpty, this.nOC.nOt.bhT, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, this.nOC.nOB, this.nOC.nOt.cZg, SQLiteDatabase.KeyEmpty, ((com.tencent.mm.modelsimple.u) kVar4).Fw(), SQLiteDatabase.KeyEmpty, true, bool2.booleanValue()), 0);
                            }
                        });
                        return;
                    }
                    this.nOt.nFq.a(0, ((com.tencent.mm.modelsimple.u) kVar).Fv(), ((com.tencent.mm.modelsimple.u) kVar).Fw(), SQLiteDatabase.KeyEmpty);
                    return;
                }
                if (i == 0 && i2 == 0) {
                    String str7;
                    final String str8;
                    Intent intent2;
                    String str9;
                    final k kVar5;
                    final boolean z;
                    final k kVar6;
                    final String str10;
                    final String str11;
                    final int i3;
                    final String str12 = this.nOt.bhT;
                    Boolean bool3 = this.nOt.nOQ;
                    int Fp = ((com.tencent.mm.modelsimple.u) kVar).Fp();
                    final String Jr = ((com.tencent.mm.modelsimple.u) kVar).Jr();
                    final int Js = ((com.tencent.mm.modelsimple.u) kVar).Js();
                    String str13 = null;
                    String str14 = null;
                    boolean z2 = false;
                    Map q = bf.q(((com.tencent.mm.modelsimple.u) kVar).Jt(), "wording");
                    if (q != null) {
                        str2 = (String) q.get(".wording.switch");
                        if (com.tencent.mm.sdk.platformtools.be.kS(str2)) {
                            z2 = true;
                        } else {
                            AG = com.tencent.mm.sdk.platformtools.be.KL(str2);
                            if (AG == 0) {
                                z2 = false;
                            } else if (AG == 1) {
                                z2 = true;
                            }
                        }
                        if (z2) {
                            str2 = (String) q.get(".wording.title");
                            if (!com.tencent.mm.sdk.platformtools.be.kS(str2)) {
                                str13 = str2;
                            }
                            str2 = (String) q.get(".wording.desc");
                            if (com.tencent.mm.sdk.platformtools.be.kS(str2)) {
                                str7 = str13;
                            } else {
                                str14 = str2;
                                str7 = str13;
                            }
                            v.i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", bool3);
                            v.i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", Integer.valueOf(Fp));
                            v.i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", Jr);
                            v.i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", Integer.valueOf(Js));
                            v.i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", str8);
                            ak.unhold();
                            ak.aL(true);
                            if (bool3.booleanValue()) {
                                this.cZU = ((com.tencent.mm.modelsimple.u) kVar).Jq();
                                ai.cse.J("login_user_name", str12);
                                if (Jr != null) {
                                    if (Jr.contains("0")) {
                                        com.tencent.mm.plugin.a.b.mi("R300_100_phone");
                                        if (z2) {
                                            intent2 = new Intent(this.nOt, FindMContactIntroUI.class);
                                        } else {
                                            intent2 = new Intent(this.nOt, FindMContactAlertUI.class);
                                            intent2.putExtra("alert_title", str7);
                                            intent2.putExtra("alert_message", str14);
                                        }
                                        intent2.addFlags(67108864);
                                        intent2.putExtra("regsetinfo_ticket", this.cZU);
                                        intent2.putExtra("regsetinfo_NextStep", Jr);
                                        intent2.putExtra("regsetinfo_NextStyle", Js);
                                        intent = com.tencent.mm.plugin.a.a.drp.ak(this.nOt);
                                        intent.addFlags(67108864);
                                        intent.putExtra("LauncherUI.enter_from_reg", true);
                                        MMWizardActivity.b(this.nOt, intent2, intent);
                                        this.nOt.finish();
                                    }
                                }
                                intent2 = com.tencent.mm.plugin.a.a.drp.ak(this.nOt);
                                intent2.addFlags(67108864);
                                intent2.putExtra("LauncherUI.enter_from_reg", true);
                                this.nOt.startActivity(intent2);
                                com.tencent.mm.plugin.a.b.mj(ak.uR() + "," + this.nOt.getClass().getName() + ",R200_900_phone," + ak.dR("R200_900_phone") + ",4");
                                this.nOt.finish();
                            } else {
                                str9 = com.tencent.mm.compatible.util.e.cgo + "temp.avatar";
                                str2 = com.tencent.mm.compatible.util.e.cgo + "temp.avatar.hd";
                                new File(str9).renameTo(new File(str2));
                                com.tencent.mm.loader.stub.b.deleteFile(str9);
                                d.b(str2, 96, 96, CompressFormat.JPEG, 90, str9);
                                kVar5 = kVar;
                                str3 = str12;
                                str8 = Jr;
                                z = z2;
                                kVar6 = kVar;
                                str10 = str7;
                                str11 = str14;
                                i3 = Js;
                                new n(this.nOt, com.tencent.mm.compatible.util.e.cgo + "temp.avatar").a(new Runnable(this) {
                                    final /* synthetic */ i nOC;

                                    public final void run() {
                                        this.nOC.cZU = ((com.tencent.mm.modelsimple.u) kVar5).Jq();
                                        ai.cse.J("login_user_name", str3);
                                        com.tencent.mm.loader.stub.b.deleteFile(com.tencent.mm.compatible.util.e.cgo + "temp.avatar");
                                        if (str8 == null || !str8.contains("0")) {
                                            Intent ak = com.tencent.mm.plugin.a.a.drp.ak(this.nOC.nOt);
                                            ak.addFlags(67108864);
                                            this.nOC.nOt.startActivity(ak);
                                            com.tencent.mm.plugin.a.b.mj(ak.uR() + "," + this.nOC.nOt.getClass().getName() + ",R200_900_phone," + ak.dR("R200_900_phone") + ",4");
                                            this.nOC.nOt.finish();
                                            return;
                                        }
                                        com.tencent.mm.plugin.a.b.mi("R300_100_phone");
                                        if (z) {
                                            ak = new Intent(this.nOC.nOt, FindMContactAlertUI.class);
                                            ak.putExtra("alert_title", str7);
                                            ak.putExtra("alert_message", str14);
                                        } else {
                                            ak = new Intent(this.nOC.nOt, FindMContactIntroUI.class);
                                        }
                                        ak.addFlags(67108864);
                                        ak.putExtra("regsetinfo_ticket", this.nOC.cZU);
                                        ak.putExtra("regsetinfo_NextStep", str8);
                                        ak.putExtra("regsetinfo_NextStyle", Js);
                                        Intent ak2 = com.tencent.mm.plugin.a.a.drp.ak(this.nOC.nOt);
                                        ak2.addFlags(67108864);
                                        MMWizardActivity.b(this.nOC.nOt, ak, ak2);
                                        this.nOC.nOt.finish();
                                    }
                                }, new Runnable(this) {
                                    final /* synthetic */ i nOC;

                                    public final void run() {
                                        this.nOC.cZU = ((com.tencent.mm.modelsimple.u) kVar6).Jq();
                                        ai.cse.J("login_user_name", str12);
                                        if (Jr == null || !Jr.contains("0")) {
                                            Intent ak = com.tencent.mm.plugin.a.a.drp.ak(this.nOC.nOt);
                                            ak.addFlags(67108864);
                                            this.nOC.nOt.startActivity(ak);
                                            com.tencent.mm.plugin.a.b.mj(ak.uR() + "," + this.nOC.nOt.getClass().getName() + ",R200_900_phone," + ak.dR("R200_900_phone") + ",4");
                                            this.nOC.nOt.finish();
                                            return;
                                        }
                                        com.tencent.mm.plugin.a.b.mi("R300_100_phone");
                                        if (z2) {
                                            ak = new Intent(this.nOC.nOt, FindMContactAlertUI.class);
                                            ak.putExtra("alert_title", str10);
                                            ak.putExtra("alert_message", str11);
                                        } else {
                                            ak = new Intent(this.nOC.nOt, FindMContactIntroUI.class);
                                        }
                                        ak.addFlags(67108864);
                                        ak.putExtra("regsetinfo_ticket", this.nOC.cZU);
                                        ak.putExtra("regsetinfo_NextStep", Jr);
                                        ak.putExtra("regsetinfo_NextStyle", i3);
                                        Intent ak2 = com.tencent.mm.plugin.a.a.drp.ak(this.nOC.nOt);
                                        ak2.addFlags(67108864);
                                        MMWizardActivity.b(this.nOC.nOt, ak, ak2);
                                        this.nOC.nOt.finish();
                                    }
                                });
                            }
                        }
                    }
                    str7 = null;
                    v.i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", bool3);
                    v.i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", Integer.valueOf(Fp));
                    v.i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", Jr);
                    v.i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", Integer.valueOf(Js));
                    v.i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", str8);
                    ak.unhold();
                    ak.aL(true);
                    if (bool3.booleanValue()) {
                        this.cZU = ((com.tencent.mm.modelsimple.u) kVar).Jq();
                        ai.cse.J("login_user_name", str12);
                        if (Jr != null) {
                            if (Jr.contains("0")) {
                                com.tencent.mm.plugin.a.b.mi("R300_100_phone");
                                if (z2) {
                                    intent2 = new Intent(this.nOt, FindMContactAlertUI.class);
                                    intent2.putExtra("alert_title", str7);
                                    intent2.putExtra("alert_message", str14);
                                } else {
                                    intent2 = new Intent(this.nOt, FindMContactIntroUI.class);
                                }
                                intent2.addFlags(67108864);
                                intent2.putExtra("regsetinfo_ticket", this.cZU);
                                intent2.putExtra("regsetinfo_NextStep", Jr);
                                intent2.putExtra("regsetinfo_NextStyle", Js);
                                intent = com.tencent.mm.plugin.a.a.drp.ak(this.nOt);
                                intent.addFlags(67108864);
                                intent.putExtra("LauncherUI.enter_from_reg", true);
                                MMWizardActivity.b(this.nOt, intent2, intent);
                                this.nOt.finish();
                            }
                        }
                        intent2 = com.tencent.mm.plugin.a.a.drp.ak(this.nOt);
                        intent2.addFlags(67108864);
                        intent2.putExtra("LauncherUI.enter_from_reg", true);
                        this.nOt.startActivity(intent2);
                        com.tencent.mm.plugin.a.b.mj(ak.uR() + "," + this.nOt.getClass().getName() + ",R200_900_phone," + ak.dR("R200_900_phone") + ",4");
                        this.nOt.finish();
                    } else {
                        str9 = com.tencent.mm.compatible.util.e.cgo + "temp.avatar";
                        str2 = com.tencent.mm.compatible.util.e.cgo + "temp.avatar.hd";
                        new File(str9).renameTo(new File(str2));
                        com.tencent.mm.loader.stub.b.deleteFile(str9);
                        d.b(str2, 96, 96, CompressFormat.JPEG, 90, str9);
                        kVar5 = kVar;
                        str3 = str12;
                        str8 = Jr;
                        z = z2;
                        kVar6 = kVar;
                        str10 = str7;
                        str11 = str14;
                        i3 = Js;
                        new n(this.nOt, com.tencent.mm.compatible.util.e.cgo + "temp.avatar").a(/* anonymous class already generated */, /* anonymous class already generated */);
                    }
                }
                dm = com.tencent.mm.f.a.dm(str);
                if (dm != null) {
                    dm.a(this.nOt, null, null);
                    return;
                }
            }
            if (!this.nOt.k(i, i2, str)) {
                if (kVar.getType() == 701) {
                    dm = com.tencent.mm.f.a.dm(str);
                    if (dm != null && dm.a(this.nOt, null, null)) {
                        return;
                    }
                }
                if (i != 0 || i2 != 0) {
                    Toast.makeText(this.nOt, this.nOt.getString(2131231444, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        } else {
            ak.vy().b(701, (e) this);
            this.nIK.a(this.nOt, i, i2, str, kVar);
            if (i == 0 && i2 == 0) {
                if (kVar instanceof s) {
                    this.nOx = ((s) kVar).Jp();
                }
                ak.vy().a((int) WebView.NORMAL_MODE_ALPHA, (e) this);
                r3 = new t(1);
                ak.vy().a(r3, 0);
                r4 = this.nOt;
                r5 = this.nOt;
                this.nOt.getString(2131231164);
                r4.dwR = g.a(r5, this.nOt.getString(2131235044), true, new OnCancelListener(this) {
                    final /* synthetic */ i nOC;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(r3);
                    }
                });
            }
        }
    }
}
