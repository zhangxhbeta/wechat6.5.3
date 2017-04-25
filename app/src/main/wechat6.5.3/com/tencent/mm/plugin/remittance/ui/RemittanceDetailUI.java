package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.order.model.h;
import com.tencent.mm.plugin.remittance.c.c;
import com.tencent.mm.plugin.remittance.c.f;
import com.tencent.mm.plugin.wallet_core.b.q;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.b.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class RemittanceDetailUI extends WalletBaseUI {
    public TextView heA = null;
    public ImageView isE = null;
    public TextView isF = null;
    public TextView isG = null;
    public Button isH = null;
    public TextView isI = null;
    public TextView isJ = null;
    public int isK;
    public int isL;
    public String isM = null;
    public String isN = null;
    public String isO = null;
    protected String isP = null;
    public int isQ = 3;
    protected boolean isR = false;
    protected int isS;
    private int isT;
    private c isU;
    private String ism = null;
    private int isn;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.isK = getIntent().getIntExtra("invalid_time", 0);
        this.isL = getIntent().getIntExtra("appmsg_type", 0);
        this.isM = getIntent().getStringExtra("transaction_id");
        this.isP = getIntent().getStringExtra("bill_id");
        this.isO = getIntent().getStringExtra("transfer_id");
        this.isN = getIntent().getStringExtra("sender_name");
        this.isQ = getIntent().getIntExtra("effective_date", 3);
        this.isR = getIntent().getBooleanExtra("is_sender", false);
        this.isS = getIntent().getIntExtra("total_fee", 0);
        NI();
        oO(0);
    }

    public void oO(int i) {
        b(new f(i, this.isM, this.isO, this.isK), true);
    }

    protected final void NI() {
        vD(2131234543);
        this.isE = (ImageView) findViewById(2131758882);
        this.isF = (TextView) findViewById(2131758883);
        this.isG = (TextView) findViewById(2131758884);
        this.isH = (Button) findViewById(2131758885);
        this.heA = (TextView) findViewById(2131758886);
        this.isI = (TextView) findViewById(2131758887);
        this.isJ = (TextView) findViewById(2131758888);
    }

    public void oP(int i) {
        k hVar;
        if (getIntent().getBooleanExtra("is_sender", false)) {
            hVar = new h(this.isM, this.isP, i);
        } else {
            hVar = new h(this.isO, this.isP, i);
        }
        hVar.mProcessName = "RemittanceProcess";
        j(hVar);
    }

    public void F(Intent intent) {
        com.tencent.mm.ay.c.b(this, "remittance", ".ui.RemittanceResendMsgUI", intent);
    }

    public void aKs() {
        c cVar = new c(this.isM, this.isO, this.isS, "confirm", this.isN, this.isK);
        cVar.mProcessName = "RemittanceProcess";
        j(cVar);
    }

    public void aKt() {
        c cVar = new c(this.isM, this.isO, this.isS, "refuse", this.isN, this.isK);
        cVar.mProcessName = "RemittanceProcess";
        j(cVar);
    }

    private void aKl() {
        if (this.isT == 0 || this.isn != 1 || be.kS(this.ism)) {
            v.i("MicroMsg.RemittanceDetailUI", "flag: %d, descUrl empty: %B", new Object[]{Integer.valueOf(this.isT), Boolean.valueOf(be.kS(this.ism))});
            this.nDR.bAi();
            return;
        }
        a(0, 2130839531, new OnMenuItemClickListener(this) {
            final /* synthetic */ RemittanceDetailUI isW;

            {
                this.isW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                e.l(this.isW.nDR.nEl, this.isW.ism, false);
                return false;
            }
        });
    }

    public boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar instanceof f) {
            final f fVar = (f) kVar;
            if (i == 0 && i2 == 0) {
                if (fVar != null) {
                    boolean equals = fVar.irE.equals(com.tencent.mm.model.k.xF());
                    this.isH.setVisibility(8);
                    this.isG.setText(e.d(fVar.eWz, fVar.hNg));
                    int i3 = fVar.status;
                    v.d("MicroMsg.RemittanceDetailUI", "status: %d", new Object[]{Integer.valueOf(i3)});
                    String string;
                    String string2;
                    CharSequence spannableString;
                    a aVar;
                    Object string3;
                    CharSequence string4;
                    a aVar2;
                    switch (i3) {
                        case 2000:
                            if (equals) {
                                this.isE.setImageResource(2131165877);
                                this.isF.setText(2131234508);
                                this.isH.setVisibility(0);
                                this.isH.setOnClickListener(new OnClickListener(this) {
                                    final /* synthetic */ RemittanceDetailUI isW;

                                    {
                                        this.isW = r1;
                                    }

                                    public final void onClick(View view) {
                                        com.tencent.mm.plugin.wallet_core.model.k.bfW();
                                        if (!com.tencent.mm.plugin.wallet_core.model.k.b(this.isW, 2, this.isW.pjH, new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this) {
                                            final /* synthetic */ AnonymousClass2 isY;

                                            {
                                                this.isY = r1;
                                            }

                                            public final boolean a(int i, int i2, String str, boolean z) {
                                                if (i == 2) {
                                                    this.isY.isW.aKs();
                                                } else if (i == 0 && z) {
                                                    this.isY.isW.aKs();
                                                }
                                                return true;
                                            }
                                        }, 1008)) {
                                            this.isW.aKs();
                                        }
                                    }
                                });
                                if (fVar.irK == 0) {
                                    string = getString(2131234511, new Object[]{Integer.valueOf(this.isQ)});
                                } else if (be.kS(fVar.irJ)) {
                                    v.i("MicroMsg.RemittanceDetailUI", "use hardcode wording");
                                    string = fVar.irK == 1 ? "24" : "2";
                                    string = getString(2131234510, new Object[]{string}) + getString(2131234511, new Object[]{Integer.valueOf(this.isQ)});
                                } else {
                                    string = fVar.irJ;
                                }
                                string2 = getString(2131234500);
                                spannableString = new SpannableString(string + string2);
                                aVar = new a(this);
                                aVar.hPW = new a.a(this) {
                                    final /* synthetic */ RemittanceDetailUI isW;

                                    public final void onClick(View view) {
                                        g.b(this.isW, this.isW.getString(2131234497, new Object[]{RemittanceDetailUI.ad(fVar.irG, false)}), this.isW.getString(2131231139), this.isW.getString(2131234501), this.isW.getString(2131231010), new DialogInterface.OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass3 isZ;

                                            {
                                                this.isZ = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                this.isZ.isW.aKt();
                                            }
                                        }, new DialogInterface.OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass3 isZ;

                                            {
                                                this.isZ = r1;
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
                                this.isF.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, getString(2131234509, new Object[]{ad(fVar.irE, true)}), this.isF.getTextSize()));
                                string = getString(2131234515, new Object[]{Integer.valueOf(this.isQ)});
                                string2 = getString(2131234538);
                                spannableString = new SpannableString(string + string2);
                                aVar = new a(this);
                                aVar.hPW = new a.a(this) {
                                    final /* synthetic */ RemittanceDetailUI isW;

                                    public final void onClick(View view) {
                                        g.b(this.isW, this.isW.getString(2131234483), this.isW.getString(2131231139), this.isW.getString(2131234537), this.isW.getString(2131231010), new DialogInterface.OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass1 isX;

                                            {
                                                this.isX = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent = new Intent();
                                                intent.putExtra("transaction_id", this.isX.isW.isM);
                                                intent.putExtra("receiver_name", fVar.irE);
                                                this.isX.isW.F(intent);
                                            }
                                        }, new DialogInterface.OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass1 isX;

                                            {
                                                this.isX = r1;
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
                            this.isE.setImageResource(2131165877);
                            this.isI.setText(getString(2131234517, new Object[]{e.yB(fVar.irD)}));
                            this.isI.setVisibility(0);
                            this.isJ.setVisibility(8);
                            break;
                        case 2001:
                            this.isE.setImageResource(2131165874);
                            if (equals) {
                                this.isF.setText(2131234503);
                                string3 = getString(2131234488);
                                string4 = getString(2131234489);
                                spannableString = new SpannableStringBuilder();
                                spannableString.append(string3);
                                spannableString.append(string4);
                                aVar2 = new a(this);
                                aVar2.hPW = new a.a(this) {
                                    final /* synthetic */ RemittanceDetailUI isW;

                                    {
                                        this.isW = r1;
                                    }

                                    public final void onClick(View view) {
                                        com.tencent.mm.pluginsdk.wallet.e.L(this.isW, 0);
                                    }
                                };
                                spannableString.setSpan(aVar2, string3.length(), spannableString.length(), 18);
                                this.heA.setMovementMethod(LinkMovementMethod.getInstance());
                                this.heA.setText(spannableString);
                                this.heA.setVisibility(0);
                            } else {
                                this.isF.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, ad(fVar.irE, true) + getString(2131234503), this.isF.getTextSize()));
                                this.heA.setText(2131234514);
                                this.heA.setVisibility(0);
                            }
                            this.isI.setText(getString(2131234517, new Object[]{e.yB(fVar.irD)}));
                            this.isI.setVisibility(0);
                            this.isJ.setText(getString(2131234493, new Object[]{e.yB(fVar.irH)}));
                            this.isJ.setVisibility(0);
                            break;
                        case 2002:
                        case 2003:
                            if (i3 != 2003 || equals) {
                                this.isE.setImageResource(2131165875);
                                if (equals) {
                                    this.isF.setText(2131234505);
                                } else {
                                    this.isF.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, ad(fVar.irE, true) + getString(2131234505), this.isF.getTextSize()));
                                }
                            } else {
                                this.isE.setImageResource(2131165876);
                                this.isF.setText(2131234507);
                            }
                            if (equals) {
                                this.heA.setVisibility(8);
                            } else {
                                if ("CFT".equals(fVar.hNE)) {
                                    string = getString(2131234498);
                                    string2 = getString(2131234487);
                                    spannableString = new SpannableString(string + string2);
                                    aVar = new a(this);
                                    aVar.hPW = new a.a(this) {
                                        final /* synthetic */ RemittanceDetailUI isW;

                                        {
                                            this.isW = r1;
                                        }

                                        public final void onClick(View view) {
                                            com.tencent.mm.pluginsdk.wallet.e.L(this.isW, 0);
                                        }
                                    };
                                    spannableString.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                                    this.heA.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.heA.setText(spannableString);
                                } else {
                                    this.heA.setText(2131234499);
                                }
                                this.heA.setVisibility(0);
                            }
                            this.isI.setText(getString(2131234517, new Object[]{e.yB(fVar.irD)}));
                            this.isI.setVisibility(0);
                            this.isJ.setText(getString(2131234496, new Object[]{e.yB(fVar.irH)}));
                            this.isJ.setVisibility(0);
                            break;
                        case 2004:
                            if (equals) {
                                this.isE.setImageResource(2131165877);
                                if (be.kS(fVar.irI)) {
                                    this.isF.setText(2131234504);
                                } else {
                                    this.isF.setText(fVar.irI);
                                }
                                if (be.kS(fVar.irJ)) {
                                    this.heA.setText(2131234495);
                                } else {
                                    this.heA.setText(fVar.irJ);
                                }
                            } else {
                                this.isE.setImageResource(2131165874);
                                if (!be.kS(fVar.irI)) {
                                    try {
                                        this.isF.setText(String.format(fVar.irI, new Object[]{ad(fVar.irE, true)}));
                                    } catch (Throwable e) {
                                        v.a("MicroMsg.RemittanceDetailUI", e, "", new Object[0]);
                                    }
                                    if (be.kS(fVar.irJ)) {
                                        this.heA.setText(fVar.irJ);
                                    } else {
                                        this.heA.setText("");
                                    }
                                }
                                this.isF.setText(getString(2131234506, new Object[]{ad(fVar.irE, true)}));
                                if (be.kS(fVar.irJ)) {
                                    this.heA.setText("");
                                } else {
                                    this.heA.setText(fVar.irJ);
                                }
                            }
                            this.isI.setText(getString(2131234517, new Object[]{e.yB(fVar.irD)}));
                            this.isI.setVisibility(0);
                            this.isJ.setText(getString(2131234493, new Object[]{e.yB(fVar.irH)}));
                            this.isJ.setVisibility(0);
                            break;
                        case 2005:
                            this.isE.setImageResource(2131165873);
                            if (be.kS(fVar.irI)) {
                                this.isF.setText(2131234502);
                            } else {
                                this.isF.setText(fVar.irI);
                            }
                            if (be.kS(fVar.irJ)) {
                                if (equals) {
                                    this.heA.setText(2131234494);
                                } else {
                                    this.heA.setText(2131234513);
                                }
                            } else if ("CFT".equals(fVar.hNE)) {
                                string3 = fVar.irJ;
                                string4 = getString(2131234487);
                                spannableString = new SpannableStringBuilder();
                                spannableString.append(string3);
                                spannableString.append(string4);
                                aVar2 = new a(this);
                                aVar2.hPW = new a.a(this) {
                                    final /* synthetic */ RemittanceDetailUI isW;

                                    {
                                        this.isW = r1;
                                    }

                                    public final void onClick(View view) {
                                        com.tencent.mm.pluginsdk.wallet.e.L(this.isW, 0);
                                    }
                                };
                                spannableString.setSpan(aVar2, string3.length(), spannableString.length(), 18);
                                this.heA.setMovementMethod(LinkMovementMethod.getInstance());
                                this.heA.setText(spannableString);
                            } else {
                                this.heA.setText(fVar.irJ);
                            }
                            this.isI.setText(getString(2131234517, new Object[]{e.yB(fVar.irD)}));
                            this.isI.setVisibility(0);
                            if (fVar.irH <= 0) {
                                this.isJ.setVisibility(8);
                                break;
                            }
                            this.isJ.setText(getString(2131234486, new Object[]{e.yB(fVar.irH)}));
                            this.isJ.setVisibility(0);
                            break;
                        default:
                            finish();
                            break;
                    }
                    this.isT = fVar.irK;
                    ak.yW();
                    this.ism = (String) com.tencent.mm.model.c.vf().get(t.a.nud, "");
                    ak.yW();
                    this.isn = ((Integer) com.tencent.mm.model.c.vf().get(t.a.nue, Integer.valueOf(0))).intValue();
                    if (be.kS(this.ism)) {
                        q.a(true, this.pjH);
                    } else {
                        q.a(false, this.pjH);
                    }
                    aKl();
                }
                if (fVar.hNO == 1) {
                    ak.yW();
                    if (((String) com.tencent.mm.model.c.vf().get(327729, "0")).equals("0")) {
                        g.a(this.nDR.nEl, com.tencent.mm.model.k.xT() ? 2131231806 : 2131231805, 2131231807, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ RemittanceDetailUI isW;

                            {
                                this.isW = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                g.bf(this.isW.nDR.nEl, this.isW.getString(2131234491));
                            }
                        });
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(327729, "1");
                    } else if (this.isT == 0) {
                        g.bf(this.nDR.nEl, getString(2131234491));
                    }
                }
                return true;
            }
        } else if (kVar instanceof c) {
            if (i == 0 && i2 == 0) {
                this.isU = (c) kVar;
                if ("confirm".equals(this.isU.irk)) {
                    oO(1);
                } else {
                    X(0, getString(2131234492));
                }
                return true;
            } else if (i2 == 416) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
                return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, i2, kVar, bundle, 1008);
            } else {
                X(i2, str);
                return true;
            }
        } else if (kVar instanceof q) {
            if (i == 0 && i2 == 0) {
                this.ism = ((q) kVar).kLF;
                this.isn = ((q) kVar).kLG;
                aKl();
            } else {
                v.i("MicroMsg.RemittanceDetailUI", "net error");
            }
            return true;
        }
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.a.e) {
            return true;
        }
        return false;
    }

    protected final int getLayoutId() {
        return 2130904275;
    }

    public final void X(int i, String str) {
        Intent intent = new Intent();
        intent.putExtra("result_msg", str);
        setResult(i, intent);
        finish();
    }

    public void finish() {
        Bundle bundle = new Bundle();
        bundle.putString("realname_verify_process_jump_plugin", "remittance");
        bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
        if (this.isU == null || !com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, this.isU, bundle, true, null, 1008, 1)) {
            super.finish();
        } else {
            this.isU = null;
        }
    }

    public static String ad(String str, boolean z) {
        String er = e.er(str);
        if (er == null) {
            return "";
        }
        if (er.length() <= 10 || !z) {
            return er;
        }
        return er.substring(0, 8) + "...";
    }
}
