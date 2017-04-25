package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.remittance.c.b;
import com.tencent.mm.plugin.remittance.c.j;
import com.tencent.mm.plugin.wallet_core.b.p;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.d;
import com.tencent.mm.u.h;
import com.tencent.mm.u.i;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.m;
import com.tencent.mm.wallet_core.b.k;
import com.tencent.mm.wallet_core.b.q;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.net.URLDecoder;

@a(19)
public abstract class RemittanceBaseUI extends WalletBaseUI implements d.a {
    private static final int duq = com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 270);
    public String bZy;
    public int cVh;
    protected String can;
    protected WalletFormView eWC;
    protected Button fzj;
    private int hcU;
    protected com.tencent.mm.plugin.wallet.a irY = null;
    public double irZ;
    private double irs;
    public int isa;
    public String isb;
    protected ImageView isc;
    protected TextView isd;
    protected TextView ise;
    protected TextView isf;
    protected TextView isg;
    protected ScrollView ish;
    private String isi;
    private String isj;
    private String isk;
    protected String isl = null;
    protected String ism = null;
    protected int isn;
    private int iso;
    private boolean isp = false;
    private boolean isq = false;
    private boolean isr = false;
    private boolean iss = false;

    public abstract void aKh();

    public abstract void aKk();

    public abstract void aKn();

    public abstract void yG(String str);

    static /* synthetic */ void c(RemittanceBaseUI remittanceBaseUI) {
        if (be.kS(remittanceBaseUI.can)) {
            remittanceBaseUI.isf.setVisibility(8);
            remittanceBaseUI.isg.setText(2131234478);
            remittanceBaseUI.isg.setVisibility(0);
            return;
        }
        g gVar = new g(remittanceBaseUI.nDR.nEl);
        CharSequence a = e.a(remittanceBaseUI, remittanceBaseUI.getString(2131231947, new Object[]{remittanceBaseUI.can, remittanceBaseUI.getString(2131234518)}));
        CharSequence spannableStringBuilder = new SpannableStringBuilder(a);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(2131689819), 0, a.length() - r0.length(), 34);
        remittanceBaseUI.isf.setText(spannableStringBuilder);
        remittanceBaseUI.isg.setVisibility(8);
        remittanceBaseUI.isf.setVisibility(0);
    }

    static /* synthetic */ void f(RemittanceBaseUI remittanceBaseUI) {
        if (remittanceBaseUI.ish != null) {
            final int i;
            int[] iArr = new int[2];
            remittanceBaseUI.fzj.getLocationInWindow(iArr);
            int dw = (com.tencent.mm.bd.a.dw(remittanceBaseUI) - i) - com.tencent.mm.bd.a.fromDPToPix(remittanceBaseUI, 30);
            v.d("MicroMsg.RemittanceUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[]{Integer.valueOf(iArr[1] + remittanceBaseUI.fzj.getHeight()), Integer.valueOf(com.tencent.mm.bd.a.dw(remittanceBaseUI)), Integer.valueOf(dw), Integer.valueOf(duq)});
            if (dw > 0 && dw < duq) {
                i = duq - dw;
                v.d("MicroMsg.RemittanceUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[]{Integer.valueOf(i)});
                remittanceBaseUI.ish.post(new Runnable(remittanceBaseUI) {
                    final /* synthetic */ RemittanceBaseUI ist;

                    public final void run() {
                        this.ist.ish.scrollBy(0, i);
                    }
                });
            }
        }
    }

    protected int getLayoutId() {
        if (aKq()) {
            return 2130904278;
        }
        return 2130904280;
    }

    public void onCreate(Bundle bundle) {
        this.cVh = getIntent().getIntExtra("scene", 0);
        super.onCreate(bundle);
        this.irY = com.tencent.mm.plugin.wallet.a.K(getIntent());
        this.isa = getIntent().getIntExtra("pay_scene", 31);
        this.isb = getIntent().getStringExtra("scan_remittance_id");
        this.irZ = getIntent().getDoubleExtra("fee", 0.0d);
        this.bZy = getIntent().getStringExtra("receiver_name");
        this.hcU = getIntent().getIntExtra("pay_channel", 0);
        if (be.kS(this.bZy)) {
            aKr();
        }
        ak.yW();
        long longValue = ((Long) c.vf().get(147457, null)).longValue();
        if ((16 & longValue) != 0) {
            this.iso = 1;
        } else if ((longValue & 32) != 0) {
            this.iso = 2;
        } else {
            this.iso = 0;
        }
        aKh();
        n.AX().a(this);
        NI();
    }

    public void onDestroy() {
        super.onDestroy();
        n.AX().b(this);
    }

    public void aKi() {
        k bVar = new b(this.bZy, this.isb);
        bVar.mProcessName = "RemittanceProcess";
        j(bVar);
    }

    public void aKj() {
    }

    protected final void NI() {
        if (this.cVh == 1) {
            vD(2131234482);
        } else {
            vD(2131234548);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RemittanceBaseUI ist;

            {
                this.ist = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.ist.cVh == 1) {
                    this.ist.aKi();
                    this.ist.finish();
                } else if (this.ist.cVh == 2 || this.ist.cVh == 5) {
                    this.ist.finish();
                } else {
                    this.ist.aKr();
                }
                this.ist.aKj();
                return true;
            }
        });
        this.ish = (ScrollView) findViewById(2131758900);
        this.isc = (ImageView) findViewById(2131758901);
        this.isd = (TextView) findViewById(2131758902);
        aKo();
        if (this.isa == 33) {
            ((TextView) findViewById(2131758906)).setText(com.tencent.mm.wallet_core.ui.e.l(this.irZ));
            TextView textView = (TextView) findViewById(2131758910);
            this.can = getIntent().getStringExtra("desc");
            if (be.kS(this.can)) {
                findViewById(2131758907).setVisibility(8);
            } else {
                textView.setText(this.can);
                findViewById(2131758907).setVisibility(0);
            }
            CharSequence stringExtra = getIntent().getStringExtra("rcvr_new_desc");
            if (!be.kS(stringExtra)) {
                ((TextView) findViewById(2131758909)).setText(stringExtra);
            }
            ((LinearLayout) findViewById(2131758905)).setVisibility(0);
        } else {
            this.eWC = (WalletFormView) findViewById(2131756361);
            this.eWC.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ RemittanceBaseUI ist;

                {
                    this.ist = r1;
                }

                public final void onClick(View view) {
                    this.ist.NP();
                }
            });
            this.eWC.eXB.setText(String.format(getString(2131234519), new Object[]{q.bLm()}));
            this.eWC.a(new TextWatcher(this) {
                final /* synthetic */ RemittanceBaseUI ist;

                {
                    this.ist = r1;
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    if (editable.toString().startsWith(".")) {
                        editable.insert(0, "0");
                    }
                    String obj = editable.toString();
                    int indexOf = obj.indexOf(".");
                    int length = obj.length();
                    if (indexOf >= 0 && length - indexOf > 2) {
                        editable.delete(indexOf + 3, length);
                    }
                }
            });
            d(this.eWC, 2, false);
            findViewById(2131758904);
            if (this.isa == 32) {
                findViewById(2131756362).setVisibility(8);
            }
            findViewById(2131756360).setVisibility(0);
            ((LinearLayout) findViewById(2131758905)).setVisibility(8);
            this.hcV = new com.tencent.mm.wallet_core.ui.a(this) {
                final /* synthetic */ RemittanceBaseUI ist;

                {
                    this.ist = r1;
                }

                public final void fd(boolean z) {
                    if (z) {
                        RemittanceBaseUI.f(this.ist);
                    } else {
                        this.ist.ish.scrollTo(0, 0);
                    }
                }
            };
        }
        this.fzj = (Button) findViewById(2131756365);
        if (this.cVh == 1) {
            this.fzj.setText(2131234482);
        }
        this.fzj.setOnClickListener(new m(this) {
            final /* synthetic */ RemittanceBaseUI ist;

            {
                this.ist = r1;
            }

            public final void ayv() {
                if (this.ist.isa != 33) {
                    this.ist.irZ = be.getDouble(this.ist.eWC.getText(), 0.0d);
                    if (!this.ist.eWC.Ou()) {
                        s.makeText(this.ist.nDR.nEl, 2131236020, 0).show();
                    } else if (this.ist.irZ < 0.01d) {
                        this.ist.aKk();
                    }
                    if (this.ist.irs != 0.0d) {
                    }
                    if (this.ist.cVh != 1) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(12689, new Object[]{Integer.valueOf(15), Integer.valueOf(1)});
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.h(12689, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
                    return;
                }
                this.ist.yG(this.ist.can);
                if (this.ist.irs != 0.0d) {
                    if (this.ist.cVh != 1) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(12689, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
                        return;
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.h(12689, new Object[]{Integer.valueOf(15), Integer.valueOf(1)});
                }
            }
        });
        this.isf = (TextView) findViewById(2131756363);
        this.isg = (TextView) findViewById(2131758903);
        if (!com.tencent.mm.model.k.xT()) {
            View findViewById = findViewById(2131756362);
            findViewById.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ RemittanceBaseUI ist;

                {
                    this.ist = r1;
                }

                public final void onClick(View view) {
                    this.ist.NP();
                    com.tencent.mm.plugin.report.service.g.iuh.h(12689, new Object[]{Integer.valueOf(9), Integer.valueOf(1)});
                    com.tencent.mm.plugin.wallet_core.ui.view.a.a(this.ist, this.ist.getString(2131234478), this.ist.can, this.ist.getString(2131234485), new com.tencent.mm.ui.base.g.b(this) {
                        final /* synthetic */ AnonymousClass13 isw;

                        {
                            this.isw = r1;
                        }

                        public final boolean r(CharSequence charSequence) {
                            if (be.kS(charSequence.toString())) {
                                this.isw.ist.can = null;
                                RemittanceBaseUI.c(this.isw.ist);
                            } else {
                                this.isw.ist.can = charSequence.toString();
                                RemittanceBaseUI.c(this.isw.ist);
                            }
                            return true;
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass13 isw;

                        {
                            this.isw = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ad.g(new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 isx;

                                {
                                    this.isx = r1;
                                }

                                public final void run() {
                                    this.isx.isw.ist.axg();
                                }
                            }, 500);
                        }
                    });
                }
            });
            if (this.isa == 32) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
        }
        if (this.cVh == 1) {
            ak.yW();
            if (((String) c.vf().get(327732, "0")).equals("0")) {
                com.tencent.mm.ui.base.g.a(this.nDR.nEl, 2131234520, 2131234521, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RemittanceBaseUI ist;

                    {
                        this.ist = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                ak.yW();
                c.vf().set(327732, "1");
                ak.yW();
                c.vf().iB(true);
            }
        }
        this.ise = (TextView) findViewById(2131758904);
        aKm();
        aKn();
        aKl();
    }

    private void aKl() {
        if (!aKq() || be.kS(this.ism) || this.iso == 0 || this.isn != 1) {
            this.nDR.bAi();
        } else {
            a(0, 2130839531, new OnMenuItemClickListener(this) {
                final /* synthetic */ RemittanceBaseUI ist;

                {
                    this.ist = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.wallet_core.ui.e.l(this.ist.nDR.nEl, this.ist.ism, false);
                    return false;
                }
            });
        }
    }

    private void aKm() {
        if (be.kS(this.isl) || this.iso == 0) {
            this.ise.setText("");
            return;
        }
        int i;
        if (this.iso == 1) {
            i = 2;
        } else {
            i = 24;
        }
        try {
            this.ise.setText(String.format(this.isl, new Object[]{Integer.valueOf(i)}));
        } catch (Throwable e) {
            v.a("MicroMsg.RemittanceUI", e, "", new Object[0]);
            this.ise.setText(getString(2131234524, new Object[]{Integer.valueOf(i)}));
        }
    }

    private void aKo() {
        if (!be.kS(this.bZy)) {
            int i;
            CharSequence er = com.tencent.mm.wallet_core.ui.e.er(this.bZy);
            if (this.cVh == 1) {
                String stringExtra = getIntent().getStringExtra("receiver_tips");
                if (be.kS(stringExtra)) {
                    er = getString(2131234481, new Object[]{er});
                } else {
                    er = be.g(stringExtra, new Object[]{com.tencent.mm.wallet_core.ui.e.PY(er)});
                }
            }
            this.isd.setText(e.a(this, er, this.isd.getTextSize()));
            this.isc.setImageResource(2130838080);
            if (ak.uz()) {
                i Bo = n.Bo();
                if (Bo != null) {
                    h gQ = Bo.gQ(this.bZy);
                    if (gQ == null || be.kS(gQ.Bf())) {
                        final long Ni = be.Ni();
                        ab.a.crZ.a(this.bZy, "", new ab.c.a(this) {
                            final /* synthetic */ RemittanceBaseUI ist;

                            public final void p(String str, boolean z) {
                                if (z) {
                                    v.v("MicroMsg.RemittanceUI", "getContact suc; cost=" + (be.Ni() - Ni) + " ms");
                                    com.tencent.mm.u.b.r(str, 3);
                                } else {
                                    v.w("MicroMsg.RemittanceUI", "getContact failed");
                                }
                                this.ist.aKp();
                            }
                        });
                        i = 1;
                        if (i == 0) {
                            aKp();
                        }
                    }
                }
            }
            i = 0;
            if (i == 0) {
                aKp();
            }
        }
    }

    private void aKp() {
        ad.o(new Runnable(this) {
            final /* synthetic */ RemittanceBaseUI ist;

            {
                this.ist = r1;
            }

            public final void run() {
                Bitmap a = com.tencent.mm.u.b.a(this.ist.bZy, false, -1);
                if (a == null) {
                    this.ist.isc.setImageResource(2130838080);
                } else {
                    this.ist.isc.setImageBitmap(a);
                }
            }
        });
    }

    public boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.remittance.c.d) {
                com.tencent.mm.plugin.remittance.c.d dVar = (com.tencent.mm.plugin.remittance.c.d) kVar;
                this.isj = dVar.irn;
                this.isk = dVar.irw;
                if (this.irY != null) {
                    this.irY.i(10000, new Object[]{Integer.valueOf(this.isa), this.bZy, Double.valueOf(dVar.irx)});
                }
                if (!a(dVar)) {
                    I(dVar.bfr, this.bZy, this.isk);
                }
            } else if (kVar instanceof p) {
                p pVar = (p) kVar;
                if (!be.kS(pVar.kLz)) {
                    ((TextView) findViewById(2131758912)).setText(pVar.kLz);
                    View findViewById = findViewById(2131758911);
                    findViewById.setVisibility(0);
                    findViewById.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ RemittanceBaseUI ist;

                        {
                            this.ist = r1;
                        }

                        public final void onClick(View view) {
                            a.a(this.ist, this.ist.cVh, this.ist.isi, this.ist.irs);
                            if (this.ist.cVh == 1) {
                                com.tencent.mm.plugin.report.service.g.iuh.h(12689, new Object[]{Integer.valueOf(13), Integer.valueOf(1)});
                                return;
                            }
                            com.tencent.mm.plugin.report.service.g.iuh.h(12689, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
                        }
                    });
                }
                this.isi = pVar.isi;
                this.irs = pVar.irs;
                if (this.irs == 0.0d) {
                    if (this.cVh == 1) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(12689, new Object[]{Integer.valueOf(14), Integer.valueOf(1)});
                    } else {
                        com.tencent.mm.plugin.report.service.g.iuh.h(12689, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
                    }
                }
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.q) {
                this.isl = ((com.tencent.mm.plugin.wallet_core.b.q) kVar).kLB;
                this.ism = ((com.tencent.mm.plugin.wallet_core.b.q) kVar).kLF;
                this.isn = ((com.tencent.mm.plugin.wallet_core.b.q) kVar).kLG;
                aKm();
                aKl();
            }
            return true;
        }
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.q) {
            v.i("MicroMsg.RemittanceUI", "net error, use hardcode wording");
            this.ise.setText("");
        } else if ((kVar instanceof com.tencent.mm.plugin.remittance.c.d) && b((com.tencent.mm.plugin.remittance.c.d) kVar)) {
            return true;
        }
        return false;
    }

    private boolean a(final com.tencent.mm.plugin.remittance.c.d dVar) {
        boolean z;
        boolean z2 = true;
        if (this.isp) {
            z = false;
        } else if (be.kS(dVar.irm)) {
            z = false;
        } else {
            this.isp = true;
            com.tencent.mm.ui.base.g.b(this, dVar.irm, getString(2131231139), getString(2131234484), getString(2131231010), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ RemittanceBaseUI ist;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (!this.ist.a(dVar)) {
                        this.ist.I(dVar.bfr, this.ist.bZy, this.ist.isk);
                    }
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ RemittanceBaseUI ist;

                {
                    this.ist = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            z = true;
        }
        if (!(z || this.isq)) {
            if (dVar.irl > 0) {
                this.isq = true;
                com.tencent.mm.ui.base.g.b(this, getString(2131234535, new Object[]{Integer.valueOf(dVar.irl)}), getString(2131231139), getString(2131234484), getString(2131234530), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RemittanceBaseUI ist;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (!this.ist.a(dVar)) {
                            this.ist.I(dVar.bfr, this.ist.bZy, this.ist.isk);
                        }
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RemittanceBaseUI ist;

                    {
                        this.ist = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.wallet_core.a.b(this.ist, "ShowOrdersInfoProcess", null);
                    }
                });
                z = true;
            } else {
                z = false;
            }
        }
        if (!(z || this.isr)) {
            if (dVar.irr) {
                this.isr = true;
                int i = this.cVh;
                double d = dVar.irv / 100.0d;
                String str = dVar.irt;
                a.a(this, i, d, dVar.iru / 100.0d, dVar.iro / 100.0d, dVar.irq, new OnClickListener(this) {
                    final /* synthetic */ RemittanceBaseUI ist;

                    public final void onClick(View view) {
                        this.ist.I(dVar.bfr, this.ist.bZy, this.ist.isk);
                        if (this.ist.cVh == 1) {
                            com.tencent.mm.plugin.report.service.g.iuh.h(12689, new Object[]{Integer.valueOf(12), Integer.valueOf(1)});
                            return;
                        }
                        com.tencent.mm.plugin.report.service.g.iuh.h(12689, new Object[]{Integer.valueOf(3), Integer.valueOf(1)});
                    }
                });
            } else {
                z2 = false;
            }
            z = z2;
        }
        if (z || this.iss) {
            return z;
        }
        return b(dVar);
    }

    private boolean b(final com.tencent.mm.plugin.remittance.c.d dVar) {
        if (dVar.hcp == null || !dVar.hcp.bfE()) {
            return false;
        }
        this.iss = true;
        com.tencent.mm.ui.base.g.b(this, dVar.hcp.bhe, "", dVar.hcp.hcn, dVar.hcp.hcm, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ RemittanceBaseUI ist;

            public final void onClick(DialogInterface dialogInterface, int i) {
                v.i("MicroMsg.RemittanceUI", "goto h5: %s", new Object[]{dVar.hcp.kMP});
                com.tencent.mm.wallet_core.ui.e.l(this.ist.nDR.nEl, dVar.hcp.kMP, false);
            }
        }, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ RemittanceBaseUI ist;

            {
                this.ist = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return true;
    }

    protected final boolean aKq() {
        return this.cVh == 0 || this.cVh == 2;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.d("MicroMsg.RemittanceUI", "reqcode=" + i + ", resultCode=" + i2 + ", username=" + this.bZy);
        switch (i) {
            case 1:
                if (i2 != -1) {
                    if (this.cVh != 1) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(12689, new Object[]{Integer.valueOf(7), Integer.valueOf(1)});
                        break;
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.h(12689, new Object[]{Integer.valueOf(16), Integer.valueOf(1)});
                    break;
                }
                if (!(this.isa == 33 || this.isa == 32)) {
                    com.tencent.mm.plugin.remittance.c.k.yF(this.bZy);
                }
                if (this.irs == 0.0d) {
                    if (this.cVh == 1) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(12689, new Object[]{Integer.valueOf(17), Integer.valueOf(1)});
                    } else {
                        com.tencent.mm.plugin.report.service.g.iuh.h(12689, new Object[]{Integer.valueOf(8), Integer.valueOf(1)});
                    }
                }
                finish();
                break;
            case 2:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!be.kS(stringExtra)) {
                        this.bZy = stringExtra;
                        aKo();
                        break;
                    }
                    finish();
                    break;
                }
                finish();
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void I(String str, String str2, String str3) {
        boolean z;
        if (this.isa == 31) {
            Object obj = this.isj;
            if (TextUtils.isEmpty(obj)) {
                v.e("MicroMsg.RemittanceUI", "msgxml is null");
            } else {
                String decode = URLDecoder.decode(obj);
                v.i("MicroMsg.RemittanceUI", "helios:" + decode);
                String str4 = (String) bf.q(decode, "msg").get(".msg.appmsg.wcpayinfo.paymsgid");
                if (TextUtils.isEmpty(str4)) {
                    v.e("MicroMsg.RemittanceUI", "paymsgid count't be null in appmsg");
                } else {
                    j aKd = com.tencent.mm.plugin.remittance.a.b.aKb().aKd();
                    if (be.kS(str4) || be.kS(decode)) {
                        v.e(j.TAG, "saveMsgContent param error");
                    } else {
                        aKd.irS = str4;
                        aKd.fgr = decode;
                    }
                }
            }
        }
        PayInfo payInfo = new PayInfo();
        payInfo.fTG = str;
        payInfo.bkq = this.isa;
        if (this.hcU > 0) {
            payInfo.bkh = this.hcU;
        }
        if (this.cVh == 2 || this.cVh == 5) {
            z = true;
        } else {
            z = false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str2);
        bundle.putString("extinfo_key_2", getIntent().getStringExtra("receiver_true_name"));
        bundle.putString("extinfo_key_3", this.can);
        bundle.putBoolean("extinfo_key_4", z);
        bundle.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
        payInfo.lVD = bundle;
        Intent intent = new Intent();
        com.tencent.mm.plugin.wallet.a.a(this.irY, intent);
        com.tencent.mm.pluginsdk.wallet.e.a(this, false, "", payInfo, str3, intent, 1);
    }

    protected final int NO() {
        return 1;
    }

    protected final void aKr() {
        Intent intent = new Intent();
        intent.putExtra("recent_remittance_contact_list", com.tencent.mm.plugin.remittance.c.k.aKf());
        intent.setClass(this.nDR.nEl, SelectRemittanceContactUI.class);
        startActivityForResult(intent, 2);
    }

    public void gM(String str) {
        v.i("MicroMsg.RemittanceUI", "onGet");
        if (be.ma(str).length() <= 0) {
            v.e("MicroMsg.RemittanceUI", "notifyChanged: user = " + str);
        } else if (str.equals(this.bZy)) {
            aKp();
        }
    }
}
