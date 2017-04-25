package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.f.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.accountsync.a.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.account.mobile.MobileInputUI.b;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class e implements b, com.tencent.mm.v.e {
    private int nKA = 0;
    private String nKr;
    private String nKs;
    private MobileInputUI nNH;

    static /* synthetic */ class AnonymousClass9 {
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
        String string = mobileInputUI.getString(2131234447);
        if (d.lWk) {
            string = string + mobileInputUI.getString(2131230892);
        }
        mobileInputUI.Fd(string);
        mobileInputUI.iU(false);
        mobileInputUI.nKv.setVisibility(0);
        mobileInputUI.nKv.setText(2131233579);
        mobileInputUI.nNR.setVisibility(0);
        if (mobileInputUI.nKu != null) {
            mobileInputUI.nKu.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ e nNP;

                public final void onClick(View view) {
                    be.E(mobileInputUI, mobileInputUI.getString(2131235735));
                }
            });
        }
        string = mobileInputUI.getString(2131233500);
        String str = "  ";
        String string2;
        if (u.bsV()) {
            string2 = mobileInputUI.getString(2131233501);
            CharSequence newSpannable = Factory.getInstance().newSpannable(string + str + string2);
            newSpannable.setSpan(new ClickableSpan(this) {
                final /* synthetic */ e nNP;

                public final void onClick(View view) {
                    be.E(mobileInputUI.nDR.nEl, mobileInputUI.getString(2131235735));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(mobileInputUI.getResources().getColor(2131689819));
                    textPaint.setUnderlineText(true);
                }
            }, string.length() + str.length(), (string.length() + string2.length()) + str.length(), 33);
            mobileInputUI.nKt.setText(newSpannable);
        } else {
            string2 = mobileInputUI.getString(2131233503);
            String string3 = mobileInputUI.getString(2131233502);
            String string4 = mobileInputUI.getString(2131230898);
            CharSequence newSpannable2 = Factory.getInstance().newSpannable(string + str + string2 + string4 + string3);
            newSpannable2.setSpan(new ClickableSpan(this) {
                final /* synthetic */ e nNP;

                public final void onClick(View view) {
                    be.E(mobileInputUI.nDR.nEl, mobileInputUI.getString(2131235739));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(mobileInputUI.getResources().getColor(2131689819));
                    textPaint.setUnderlineText(true);
                }
            }, string.length() + str.length(), (string.length() + str.length()) + string2.length(), 33);
            newSpannable2.setSpan(new ClickableSpan(this) {
                final /* synthetic */ e nNP;

                public final void onClick(View view) {
                    be.E(mobileInputUI.nDR.nEl, mobileInputUI.getString(2131235738));
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(mobileInputUI.getResources().getColor(2131689819));
                    textPaint.setUnderlineText(true);
                }
            }, ((string.length() + string2.length()) + str.length()) + string4.length(), (((string.length() + string2.length()) + str.length()) + string4.length()) + string3.length(), 33);
            mobileInputUI.nKt.setText(newSpannable2);
        }
        mobileInputUI.nKt.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void start() {
        ak.vy().a(145, (com.tencent.mm.v.e) this);
        com.tencent.mm.plugin.a.b.b(true, ak.uR() + "," + getClass().getName() + ",R200_100," + ak.dR("R200_100") + ",1");
        com.tencent.mm.plugin.a.b.mh("R200_100");
        this.nKA = 0;
    }

    public final void stop() {
        ak.vy().b(145, (com.tencent.mm.v.e) this);
        com.tencent.mm.plugin.a.b.b(false, ak.uR() + "," + getClass().getName() + ",R200_100," + ak.dR("R200_100") + ",2");
    }

    public final void vW(int i) {
        switch (AnonymousClass9.nNJ[i - 1]) {
            case 1:
                String str = this.nNH.nIP + this.nNH.hUm;
                if (this.nNH.nIO != null) {
                    v.d("MicroMsg.MobileInputRegLogic", "already checking ");
                    return;
                }
                MobileInputUI mobileInputUI = this.nNH;
                Context context = this.nNH;
                this.nNH.getString(2131231164);
                mobileInputUI.nIO = g.a(context, this.nNH.getString(2131234410), true, new OnCancelListener(this) {
                    final /* synthetic */ e nNP;

                    {
                        this.nNP = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                String bBT = this.nNH.nKq.bBT();
                int i2 = (this.nKr == null || this.nKs == null || bBT.equals(this.nKr) || !bBT.equals(this.nKs)) ? (this.nKr == null || this.nKs == null || this.nKs.equals(this.nKr) || bBT.equals(this.nKs)) ? 0 : 2 : 1;
                k uVar = new com.tencent.mm.modelfriend.u(str, 12, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty);
                uVar.fq(this.nKA);
                uVar.fr(i2);
                ak.vy().a(uVar, 0);
                this.nKr = this.nNH.nKq.bBT();
                this.nKA++;
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.nNH.nIO != null) {
            this.nNH.nIO.dismiss();
            this.nNH.nIO = null;
        }
        if (i2 == -75) {
            g.f(this.nNH, 2131230895, 2131234378);
        } else if (kVar.getType() != 145) {
        } else {
            a dm;
            if (i2 == -41 || i2 == -59) {
                dm = a.dm(str);
                if (dm != null) {
                    dm.a(this.nNH, null, null);
                    return;
                } else {
                    g.f(this.nNH, 2131234422, 2131234423);
                    return;
                }
            }
            int AG = ((com.tencent.mm.modelfriend.u) kVar).AG();
            if (AG == 12) {
                if (i2 == -36 || i2 == -35 || i2 == -3) {
                    String Fk = ((com.tencent.mm.modelfriend.u) kVar).Fk();
                    if (!be.kS(Fk)) {
                        this.nNH.hUm = Fk.trim();
                    }
                    this.nNH.hUm = al.Kq(this.nNH.hUm);
                    this.nKs = this.nNH.nIP + this.nNH.hUm;
                    com.tencent.mm.plugin.a.b.b(true, ak.uR() + "," + getClass().getName() + ",R200_200," + ak.dR("R200_200") + ",1");
                    dm = a.dm(str);
                    if (dm != null) {
                        dm.a(this.nNH, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ e nNP;

                            {
                                this.nNP = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.nNP.bBp();
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ e nNP;

                            {
                                this.nNP = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.plugin.a.b.b(true, ak.uR() + "," + getClass().getName() + ",R200_200," + ak.dR("R200_200") + ",2");
                            }
                        });
                        return;
                    }
                    bBp();
                    com.tencent.mm.plugin.a.b.b(true, ak.uR() + "," + getClass().getName() + ",R200_200," + ak.dR("R200_200") + ",2");
                    return;
                } else if (i2 == -34) {
                    g.A(this.nNH, this.nNH.getString(2131231402), SQLiteDatabase.KeyEmpty);
                    return;
                } else {
                    Toast.makeText(this.nNH, this.nNH.getString(2131231444, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
            if (AG == 14) {
                com.tencent.mm.plugin.a.b.mi("R200_300");
                Intent intent = new Intent();
                intent.putExtra("bindmcontact_mobile", this.nNH.nIP + " " + this.nNH.nKq.bBT());
                intent.putExtra("bindmcontact_shortmobile", this.nNH.hUm);
                intent.putExtra("country_name", this.nNH.cQn);
                intent.putExtra("couttry_code", this.nNH.bfd);
                intent.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.u) kVar).Fm());
                intent.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.u) kVar).Fn());
                intent.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.u) kVar).Fo());
                intent.putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.u) kVar).Fq());
                intent.putExtra("mobile_verify_purpose", 2);
                intent.setClass(this.nNH, MobileVerifyUI.class);
                this.nNH.startActivity(intent);
                c.gN(c.a.dwq);
            }
        }
    }

    private void bBp() {
        MobileInputUI mobileInputUI = this.nNH;
        Context context = this.nNH;
        this.nNH.getString(2131231164);
        mobileInputUI.nIO = g.a(context, this.nNH.getString(2131234410), true, new OnCancelListener(this) {
            final /* synthetic */ e nNP;

            {
                this.nNP = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        ak.vy().a(new com.tencent.mm.modelfriend.u(this.nNH.nIP + this.nNH.hUm, 14, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty), 0);
    }
}
