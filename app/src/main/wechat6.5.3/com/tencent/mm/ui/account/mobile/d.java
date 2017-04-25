package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.f.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.account.mobile.MobileInputUI.b;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class d implements b, e {
    private SecurityImage nFq = null;
    private a nIK = null;
    MobileInputUI nNH;

    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] nNJ = new int[a.bBs().length];

        static {
            try {
                nNJ[a.nNZ - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public final void a(MobileInputUI mobileInputUI) {
        this.nNH = mobileInputUI;
        mobileInputUI.vD(2131233861);
        mobileInputUI.nKv.setVisibility(8);
    }

    private void Om(String str) {
        MobileInputUI mobileInputUI = this.nNH;
        Context context = this.nNH;
        this.nNH.getString(2131231164);
        mobileInputUI.nIO = g.a(context, this.nNH.getString(2131234410), true, new OnCancelListener(this) {
            final /* synthetic */ d nNO;

            {
                this.nNO = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        ak.vy().a(new u(str, 16, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty), 0);
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
        switch (AnonymousClass5.nNJ[i - 1]) {
            case 1:
                String str = this.nNH.nIP + this.nNH.hUm;
                this.nNH.axg();
                MobileInputUI mobileInputUI = this.nNH;
                Context context = this.nNH;
                this.nNH.getString(2131231164);
                mobileInputUI.nIO = g.a(context, this.nNH.getString(2131234410), true, new OnCancelListener(this) {
                    final /* synthetic */ d nNO;

                    {
                        this.nNO = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                ak.vy().a(new u(str, 13, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty), 0);
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.MobileInputLoginLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.nNH.nIO != null) {
            this.nNH.nIO.dismiss();
            this.nNH.nIO = null;
        }
        if (kVar.getType() != 701 || this.nIK == null) {
            a dm;
            if (kVar.getType() == 145) {
                int AG = ((u) kVar).AG();
                String str2;
                if (AG == 13) {
                    if (i2 == -41) {
                        dm = a.dm(str);
                        if (dm != null) {
                            dm.a(this.nNH, null, null);
                            return;
                        } else {
                            g.f(this.nNH, 2131234422, 2131234423);
                            return;
                        }
                    } else if (i2 == -35) {
                        this.nNH.nIP = this.nNH.nKq.getCountryCode();
                        this.nNH.hUm = this.nNH.nKq.bBT();
                        str2 = this.nNH.nIP + this.nNH.hUm;
                        this.nNH.axg();
                        Om(str2);
                        return;
                    } else if (i2 == -1) {
                        Toast.makeText(this.nNH, this.nNH.getString(2131232858, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                        return;
                    } else if (i2 == -34) {
                        g.A(this.nNH, this.nNH.getString(2131231402), SQLiteDatabase.KeyEmpty);
                        return;
                    } else {
                        str2 = ((u) kVar).Fk();
                        if (!be.kS(str2)) {
                            this.nNH.hUm = str2.trim();
                        }
                        this.nNH.hUm = al.Kq(this.nNH.hUm);
                        com.tencent.mm.plugin.a.b.mj(ak.uR() + "," + getClass().getName() + ",L200_300," + ak.dR("L200_300") + ",1");
                        dm = a.dm(str);
                        if (dm != null) {
                            dm.a(this.nNH, new OnClickListener(this) {
                                final /* synthetic */ d nNO;

                                {
                                    this.nNO = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.nNO.Om(this.nNO.nNH.nIP + this.nNO.nNH.hUm);
                                    com.tencent.mm.plugin.a.b.mj(ak.uR() + "," + getClass().getName() + ",L200_300," + ak.dR("L200_300") + ",2");
                                }
                            }, new OnClickListener(this) {
                                final /* synthetic */ d nNO;

                                {
                                    this.nNO = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    com.tencent.mm.plugin.a.b.mj(ak.uR() + "," + getClass().getName() + ",L200_300," + ak.dR("L200_300") + ",2");
                                }
                            });
                            return;
                        } else {
                            Om(this.nNH.nIP + this.nNH.hUm);
                            return;
                        }
                    }
                } else if (AG == 16) {
                    if (i2 == -41) {
                        g.f(this.nNH, 2131234422, 2131234423);
                        return;
                    } else if (i2 == -75) {
                        g.A(this.nNH, this.nNH.getString(2131230894), SQLiteDatabase.KeyEmpty);
                        return;
                    } else {
                        com.tencent.mm.plugin.a.b.mi("L3");
                        com.tencent.mm.plugin.a.b.mj(ak.uR() + "," + getClass().getName() + ",L3," + ak.dR("L3") + ",1");
                        Intent intent = new Intent();
                        intent.putExtra("mobile_verify_purpose", 1);
                        intent.putExtra("bindmcontact_mobile", this.nNH.nIP + " " + this.nNH.nKq.bBT());
                        intent.putExtra("bindmcontact_shortmobile", this.nNH.hUm);
                        intent.putExtra("country_name", this.nNH.cQn);
                        intent.putExtra("couttry_code", this.nNH.bfd);
                        intent.putExtra("mobileverify_countdownsec", ((u) kVar).Fm());
                        intent.putExtra("mobileverify_countdownstyle", ((u) kVar).Fn());
                        intent.putExtra("mobileverify_fb", ((u) kVar).Fo());
                        intent.putExtra("from_deep_link", this.nNH.nJV);
                        intent.setClass(this.nNH, MobileVerifyUI.class);
                        this.nNH.startActivity(intent);
                        if (this.nNH.nJV) {
                            str2 = aa.getContext().getSharedPreferences("randomid_prefs", 4).getString("randomID", SQLiteDatabase.KeyEmpty);
                            com.tencent.mm.plugin.report.service.g.iuh.h(11930, str2, Integer.valueOf(5));
                        }
                    }
                }
            }
            if (kVar.getType() == 701) {
                dm = a.dm(str);
                if (dm != null && dm.a(this.nNH, null, null)) {
                    return;
                }
                return;
            }
            return;
        }
        this.nIK.nJV = this.nNH.nJV;
        this.nIK.a(this.nNH, i, i2, str, kVar);
    }
}
