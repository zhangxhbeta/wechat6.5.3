package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.b;
import com.tencent.mm.plugin.wallet_payu.remittance.a.f;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.e;

public class PayURemittanceDetailUI extends RemittanceDetailUI {
    private int hNy;
    private int hNz;
    private int isS;
    private String iti;
    private String lar;
    private String las;
    private int lau;
    private int lav;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.isS = getIntent().getIntExtra("total_fee", 0);
        this.lar = getIntent().getStringExtra("fee_type");
        if (getIntent().getBooleanExtra("is_sender", false)) {
            this.las = k.xF();
            this.iti = this.isN;
            return;
        }
        this.las = this.isN;
        this.iti = k.xF();
    }

    protected final void oO(int i) {
        b(new f(this.isO, this.isN, this.isK), true);
    }

    protected final void oP(int i) {
        b(new f(this.isO, this.isN, this.isK, 1, i), true);
    }

    protected final void F(Intent intent) {
        c.b(this, "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", intent);
    }

    protected final void aKs() {
        j(new com.tencent.mm.plugin.wallet_payu.remittance.a.c(this.isO, this.isS, this.lar, this.isN));
    }

    protected final void aKt() {
        j(new b(this.isO, this.isS, this.lar, this.isN));
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        boolean z = false;
        if (kVar instanceof f) {
            f fVar = (f) kVar;
            String string;
            String string2;
            CharSequence spannableString;
            a aVar;
            if (fVar.bdf != 0) {
                if (i == 0 && i2 == 0) {
                    this.lau = fVar.status;
                    this.lav = fVar.irD;
                    this.hNz = fVar.lan;
                    this.hNy = fVar.lao;
                    this.isS = (int) (fVar.eWz * 100.0d);
                    this.lar = fVar.hNg;
                    boolean equals = this.iti.equals(k.xF());
                    this.isH.setVisibility(8);
                    this.isG.setText(e.d(((double) this.isS) / 100.0d, this.lar));
                    int i3 = this.lau;
                    switch (i3) {
                        case 2000:
                            if (equals) {
                                this.isE.setImageResource(2130839534);
                                this.isH.setVisibility(0);
                                this.isH.setOnClickListener(new OnClickListener(this) {
                                    final /* synthetic */ PayURemittanceDetailUI law;

                                    {
                                        this.law = r1;
                                    }

                                    public final void onClick(View view) {
                                        this.law.aKs();
                                    }
                                });
                                string = getString(2131234512, new Object[]{Integer.valueOf(this.isQ)});
                                string2 = getString(2131234500);
                                spannableString = new SpannableString(string + string2);
                                aVar = new a(this);
                                aVar.hPW = new a.a(this) {
                                    final /* synthetic */ PayURemittanceDetailUI law;

                                    {
                                        this.law = r1;
                                    }

                                    public final void onClick(View view) {
                                        g.b(this.law, this.law.getString(2131234497, new Object[]{RemittanceDetailUI.ad(this.law.las, false)}), this.law.getString(2131231139), this.law.getString(2131234501), this.law.getString(2131231010), new DialogInterface.OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass3 lay;

                                            {
                                                this.lay = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                this.lay.law.aKt();
                                            }
                                        }, new DialogInterface.OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass3 lay;

                                            {
                                                this.lay = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                            }
                                        });
                                    }
                                };
                                spannableString.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                                this.heA.setMovementMethod(LinkMovementMethod.getInstance());
                                this.heA.setText(spannableString);
                            } else {
                                this.isF.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, getString(2131234509, new Object[]{RemittanceDetailUI.ad(this.iti, true)}), this.isF.getTextSize()));
                                string = getString(2131234516, new Object[]{Integer.valueOf(this.isQ)});
                                string2 = getString(2131234538);
                                spannableString = new SpannableString(string + string2);
                                aVar = new a(this);
                                aVar.hPW = new a.a(this) {
                                    final /* synthetic */ PayURemittanceDetailUI law;

                                    {
                                        this.law = r1;
                                    }

                                    public final void onClick(View view) {
                                        g.b(this.law, this.law.getString(2131234483), this.law.getString(2131231139), this.law.getString(2131234537), this.law.getString(2131231010), new DialogInterface.OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass1 lax;

                                            {
                                                this.lax = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent = new Intent();
                                                intent.putExtra("transaction_id", this.lax.law.isM);
                                                intent.putExtra("receiver_name", this.lax.law.iti);
                                                intent.putExtra("total_fee", this.lax.law.isS);
                                                intent.putExtra("fee_type", this.lax.law.lar);
                                                this.lax.law.F(intent);
                                            }
                                        }, new DialogInterface.OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass1 lax;

                                            {
                                                this.lax = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                            }
                                        });
                                    }
                                };
                                spannableString.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                                this.heA.setMovementMethod(LinkMovementMethod.getInstance());
                                this.heA.setText(spannableString);
                            }
                            this.isE.setImageResource(2130839534);
                            this.isI.setText(getString(2131234517, new Object[]{e.yB(this.hNz)}));
                            this.isI.setVisibility(0);
                            this.isJ.setVisibility(8);
                            z = true;
                            break;
                        case 2001:
                            this.isE.setImageResource(2131165874);
                            if (equals) {
                                this.isF.setText(2131234503);
                                Object string3 = getString(2131234487);
                                CharSequence spannableString2 = new SpannableString(string3);
                                a aVar2 = new a(this);
                                aVar2.hPW = new a.a(this) {
                                    final /* synthetic */ PayURemittanceDetailUI law;

                                    {
                                        this.law = r1;
                                    }

                                    public final void onClick(View view) {
                                        com.tencent.mm.pluginsdk.wallet.e.L(this.law, 0);
                                    }
                                };
                                spannableString2.setSpan(aVar2, 0, string3.length(), 33);
                                this.heA.setMovementMethod(LinkMovementMethod.getInstance());
                                this.heA.setText(spannableString2);
                                this.heA.setVisibility(0);
                            } else {
                                this.isF.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, RemittanceDetailUI.ad(this.iti, true) + " " + getString(2131234503), this.isF.getTextSize()));
                                this.heA.setVisibility(8);
                            }
                            this.isI.setText(getString(2131234517, new Object[]{e.yB(this.lav)}));
                            this.isI.setVisibility(0);
                            this.isJ.setText(getString(2131234493, new Object[]{e.yB(this.hNy)}));
                            this.isJ.setVisibility(0);
                            z = true;
                            break;
                        case 2002:
                        case 2003:
                            if (i3 != 2003 || equals) {
                                this.isE.setImageResource(2131165875);
                                if (equals) {
                                    this.isF.setText(2131234505);
                                } else {
                                    this.isF.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, RemittanceDetailUI.ad(this.iti, true) + getString(2131234505), this.isF.getTextSize()));
                                }
                            } else {
                                this.isE.setImageResource(2131165876);
                                this.isF.setText(2131234507);
                            }
                            if (equals) {
                                this.heA.setText("");
                            } else {
                                string = getString(2131234498);
                                string2 = getString(2131234487);
                                spannableString = new SpannableString(string + string2);
                                aVar = new a(this);
                                aVar.hPW = new a.a(this) {
                                    final /* synthetic */ PayURemittanceDetailUI law;

                                    {
                                        this.law = r1;
                                    }

                                    public final void onClick(View view) {
                                        com.tencent.mm.pluginsdk.wallet.e.L(this.law, 0);
                                    }
                                };
                                spannableString.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                                this.heA.setMovementMethod(LinkMovementMethod.getInstance());
                                this.heA.setText(spannableString);
                            }
                            this.heA.setVisibility(0);
                            this.isI.setText(getString(2131234517, new Object[]{e.yB(this.lav)}));
                            this.isI.setVisibility(0);
                            this.isJ.setText(getString(2131234496, new Object[]{e.yB(this.hNz)}));
                            this.isJ.setVisibility(0);
                            z = true;
                            break;
                        default:
                            finish();
                            z = true;
                            break;
                    }
                }
                if (fVar.bkU == 1) {
                    ak.yW();
                    if (((String) com.tencent.mm.model.c.vf().get(327729, "0")).equals("0")) {
                        g.a(this.nDR.nEl, 2131231806, 2131231807, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ PayURemittanceDetailUI law;

                            {
                                this.law = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                g.bf(this.law.nDR.nEl, this.law.getString(2131234491));
                            }
                        });
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(327729, "1");
                    } else {
                        g.bf(this.nDR.nEl, getString(2131234491));
                    }
                }
                return z;
            } else if (i != 0 || i2 != 0) {
                oP(0);
                return true;
            } else if (this.isL != 1 || getIntent().getBooleanExtra("is_sender", false)) {
                return true;
            } else {
                this.isE.setImageResource(2130839534);
                this.isF.setText(2131234508);
                this.isG.setText(e.d(fVar.eWz, fVar.hNg));
                this.isH.setVisibility(0);
                this.isH.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ PayURemittanceDetailUI law;

                    {
                        this.law = r1;
                    }

                    public final void onClick(View view) {
                        this.law.aKs();
                    }
                });
                string = getString(2131234512, new Object[]{Integer.valueOf(this.isQ)});
                string2 = getString(2131234500);
                spannableString = new SpannableString(string + string2);
                aVar = new a(this);
                aVar.hPW = new a.a(this) {
                    final /* synthetic */ PayURemittanceDetailUI law;

                    {
                        this.law = r1;
                    }

                    public final void onClick(View view) {
                        g.b(this.law, this.law.getString(2131234497, new Object[]{RemittanceDetailUI.ad(this.law.isN, false)}), this.law.getString(2131231139), this.law.getString(2131234501), this.law.getString(2131231010), new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass7 laz;

                            {
                                this.laz = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.laz.law.aKt();
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass7 laz;

                            {
                                this.laz = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                };
                spannableString.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                this.heA.setMovementMethod(LinkMovementMethod.getInstance());
                this.heA.setText(spannableString);
                this.isI.setText(getString(2131234517, new Object[]{e.yB(fVar.irD)}));
                this.isI.setVisibility(0);
                this.isJ.setVisibility(8);
                return true;
            }
        } else if (!(kVar instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.c) && !(kVar instanceof b)) {
            return false;
        } else {
            if (i != 0 || i2 != 0) {
                X(i2, str);
                return true;
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.c) {
                oP(1);
                return true;
            } else {
                X(0, getString(2131234492));
                return true;
            }
        }
    }
}
