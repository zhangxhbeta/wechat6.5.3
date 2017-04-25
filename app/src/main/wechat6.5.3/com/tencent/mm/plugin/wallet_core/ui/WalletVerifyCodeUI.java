package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.b.h;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.b.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

@com.tencent.mm.ui.base.a(19)
public class WalletVerifyCodeUI extends WalletBaseUI implements com.tencent.mm.wallet_core.ui.formview.WalletFormView.a {
    private Orders ith;
    private Button kHi;
    private Authen kHn;
    private PayInfo kIA;
    public int kWb = 60000;
    public WalletFormView kWc = null;
    private Button kWd;
    private String kWe;
    private e kWf = null;
    private String kWg;
    private boolean kWh = false;
    private a kWi = null;
    private TextView kWj;
    private boolean kWk = false;
    private e kWl = new e();
    private com.tencent.mm.wallet_core.b.f.a kWm = new com.tencent.mm.wallet_core.b.f.a(this) {
        final /* synthetic */ WalletVerifyCodeUI kWn;

        {
            this.kWn = r1;
        }

        public final void bhs() {
            this.kWn.bhr();
        }
    };

    class a extends CountDownTimer {
        final /* synthetic */ WalletVerifyCodeUI kWn;

        public a(WalletVerifyCodeUI walletVerifyCodeUI, long j) {
            this.kWn = walletVerifyCodeUI;
            super(j, 1000);
        }

        public final void onTick(long j) {
            this.kWn.kWd.setText(this.kWn.getString(2131236508) + "(" + (j / 1000) + ")");
        }

        public final void onFinish() {
            this.kWn.kWd.setClickable(true);
            this.kWn.kWd.setEnabled(true);
            this.kWn.kWd.setText(this.kWn.getString(2131236508));
        }
    }

    static /* synthetic */ boolean a(WalletVerifyCodeUI walletVerifyCodeUI, com.tencent.mm.wallet_core.b.f.a aVar) {
        if (walletVerifyCodeUI.kWk) {
            v.i("MicroMsg.WalletVertifyCodeUI", "isCertInstalled passed");
            return false;
        }
        e eVar = walletVerifyCodeUI.kWl;
        boolean z = eVar.bfL() && eVar.kNP == 0;
        if (z) {
            v.i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isBlockInstall %s", new Object[]{aVar});
            if (be.kS(walletVerifyCodeUI.kWc.getText())) {
                v.i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isBlockInstall sms error %s", new Object[]{aVar});
                return false;
            }
            g.iuh.h(13731, new Object[]{Integer.valueOf(6)});
            walletVerifyCodeUI.j(new f(walletVerifyCodeUI.kWc.getText(), walletVerifyCodeUI.bLx(), aVar, true));
            return true;
        } else if (walletVerifyCodeUI.kWl.bfL()) {
            v.i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isNeedInstall %s", new Object[]{aVar});
            g.iuh.h(13731, new Object[]{Integer.valueOf(6)});
            walletVerifyCodeUI.j(new f(walletVerifyCodeUI.kWc.getText(), walletVerifyCodeUI.bLx(), aVar, false));
            return true;
        } else {
            v.i("MicroMsg.WalletVertifyCodeUI", "no need installcert");
            return false;
        }
    }

    static /* synthetic */ void c(WalletVerifyCodeUI walletVerifyCodeUI) {
        if (walletVerifyCodeUI.kWg == null) {
            walletVerifyCodeUI.kWg = "";
        }
        CharSequence format = String.format(k.xT() ? walletVerifyCodeUI.getString(2131236499) : walletVerifyCodeUI.getString(2131236498), new Object[]{walletVerifyCodeUI.kWg});
        LayoutInflater layoutInflater = (LayoutInflater) walletVerifyCodeUI.nDR.nEl.getSystemService("layout_inflater");
        TextView textView = (TextView) layoutInflater.inflate(2130903785, null);
        int dimensionPixelSize = layoutInflater.getContext().getResources().getDimensionPixelSize(2131493135);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setText(format);
        com.tencent.mm.ui.base.g.a(walletVerifyCodeUI.nDR.nEl, walletVerifyCodeUI.getString(2131236500), walletVerifyCodeUI.getString(2131234768), textView, new OnClickListener(walletVerifyCodeUI) {
            final /* synthetic */ WalletVerifyCodeUI kWn;

            {
                this.kWn = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public void onCreate(Bundle bundle) {
        int i = 2;
        super.onCreate(bundle);
        vD(2131236511);
        this.kIA = (PayInfo) this.uA.getParcelable("key_pay_info");
        this.ith = (Orders) this.uA.getParcelable("key_orders");
        this.kWg = this.uA.getString("key_bank_phone");
        this.kWf = new e(this);
        this.kWf.kRW = getResources().getStringArray(2131296272);
        this.kWf.kRU = new com.tencent.mm.plugin.wallet_core.ui.e.a(this) {
            final /* synthetic */ WalletVerifyCodeUI kWn;

            {
                this.kWn = r1;
            }

            public final void Ds(String str) {
                this.kWn.kWc.setText(str);
            }
        };
        this.kWf.start();
        this.kWl = new e(this.uA);
        this.kWh = false;
        bhp();
        NI();
        g gVar = g.iuh;
        Object[] objArr = new Object[2];
        int i2 = (this.kIA == null || this.kIA.bkq == 0) ? 2 : 1;
        objArr[0] = Integer.valueOf(i2);
        if (!this.kWh) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        gVar.h(10706, objArr);
        c.bhu();
        c.a(this, this.uA, 4);
        if (this.kWl.bfK()) {
            g.iuh.h(13731, new Object[]{Integer.valueOf(5)});
            this.uA.putBoolean("key_block_bind_new_card", true);
            if (!be.kS(this.kWl.kNQ.title)) {
                Fd(this.kWl.kNQ.title);
            }
            findViewById(2131760039).setVisibility(0);
            ((TextView) findViewById(2131759890)).setText(this.kWl.kNQ.pir);
            if (this.kWj != null) {
                String bho = bho();
                this.kWj.setText(be.g(this.kWl.kNQ.pis, new Object[]{bho}));
                this.kWj.setGravity(1);
            }
            if (!(this.kHi == null || be.kS(this.kWl.kNQ.pit))) {
                this.kHi.setText(this.kWl.kNQ.pit);
            }
        } else {
            findViewById(2131760039).setVisibility(8);
        }
        this.pjH.gQ(1580);
    }

    private String bho() {
        String ah = be.ah(this.uA.getString("key_mobile"), "");
        if (be.kS(ah)) {
            Bankcard bankcard = (Bankcard) this.uA.getParcelable("key_bankcard");
            if (bankcard != null) {
                return bankcard.field_mobile;
            }
        }
        return ah;
    }

    public void bhp() {
    }

    public void bhq() {
        int i = 2;
        v.i("MicroMsg.WalletVertifyCodeUI", "get verify code!");
        g gVar = g.iuh;
        Object[] objArr = new Object[2];
        int i2 = (this.kIA == null || this.kIA.bkq == 0) ? 2 : 1;
        objArr[0] = Integer.valueOf(i2);
        if (!this.kWh) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        gVar.h(10706, objArr);
        this.kWh = true;
        this.kWd.setClickable(false);
        this.kWd.setEnabled(false);
        if (this.kWi != null) {
            this.kWi.cancel();
            this.kWi = null;
        }
        a aVar = new a(this, (long) this.kWb);
        this.kWi = aVar;
        aVar.start();
        if (this.kWf != null) {
            this.kWf.start();
        }
        if (!bLD().p(this.kWe) && !ku(false)) {
            this.kHn = (Authen) this.uA.getParcelable("key_authen");
            if (this.kHn == null) {
                v.w("MicroMsg.WalletVertifyCodeUI", "error authen is null");
            } else {
                c.bhu();
            }
        }
    }

    protected final void NI() {
        String str;
        CharSequence nK;
        a aVar;
        TextView textView;
        final Bankcard bankcard;
        boolean z;
        boolean z2;
        PayInfo payInfo;
        int i;
        b ae = com.tencent.mm.wallet_core.a.ae(this);
        this.kWj = (TextView) findViewById(2131760027);
        String bho = bho();
        if (be.kS(bho)) {
            Bankcard bankcard2 = (Bankcard) this.uA.getParcelable("key_bankcard");
            if (bankcard2 != null) {
                str = bankcard2.field_mobile;
                this.uA.putString("key_mobile", str);
                nK = nK(0);
                if (be.D(nK)) {
                    this.kWj.setText(nK);
                    this.kWj.setGravity(3);
                } else {
                    TextView textView2 = this.kWj;
                    if (k.xT()) {
                        bho = getString(2131236494);
                    } else {
                        bho = getString(2131236495);
                    }
                    textView2.setText(String.format(bho, new Object[]{str}));
                    this.kWj.setGravity(1);
                }
                this.kWc = (WalletFormView) findViewById(2131755621);
                this.kWc.pkk = this;
                this.kWd = (Button) findViewById(2131760040);
                this.kWd.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ WalletVerifyCodeUI kWn;

                    {
                        this.kWn = r1;
                    }

                    public final void onClick(View view) {
                        this.kWn.bhq();
                    }
                });
                this.kWd.setClickable(false);
                this.kWd.setEnabled(false);
                if (this.kWi != null) {
                    this.kWi.cancel();
                    this.kWi = null;
                }
                aVar = new a(this, (long) this.kWb);
                this.kWi = aVar;
                aVar.start();
                this.kHi = (Button) findViewById(2131755622);
                this.kHi.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ WalletVerifyCodeUI kWn;

                    {
                        this.kWn = r1;
                    }

                    public final void onClick(View view) {
                        if (!WalletVerifyCodeUI.a(this.kWn, this.kWn.kWm)) {
                            this.kWn.bhr();
                        }
                    }
                });
                textView = (TextView) findViewById(2131760041);
                bankcard = (Bankcard) this.uA.getParcelable("key_bankcard");
                z = this.uA.getBoolean("key_is_changing_balance_phone_num");
                z2 = this.uA.getBoolean("key_need_show_switch_phone", false);
                if (z || z2) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                payInfo = (PayInfo) this.uA.getParcelable("key_pay_info");
                if (payInfo == null) {
                    i = payInfo.bkq;
                } else {
                    i = 0;
                }
                if (z2) {
                    textView.setText(2131236503);
                    textView.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ WalletVerifyCodeUI kWn;

                        {
                            this.kWn = r1;
                        }

                        public final void onClick(View view) {
                            v.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
                            v.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess and finish!");
                            Bundle bundle = this.kWn.uA;
                            bundle.putInt("key_err_code", 417);
                            bundle.putBoolean("key_need_show_switch_phone", true);
                            com.tencent.mm.wallet_core.a.k(this.kWn, bundle);
                            this.kWn.finish();
                        }
                    });
                } else if (ae != null || !ae.bKX() || r2 == 11 || r2 == 21) {
                    textView.setText(k.xT() ? getString(2131236497) : getString(2131236496));
                    textView.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ WalletVerifyCodeUI kWn;

                        {
                            this.kWn = r1;
                        }

                        public final void onClick(View view) {
                            WalletVerifyCodeUI.c(this.kWn);
                        }
                    });
                } else if (bankcard.bfG()) {
                    textView.setText(2131236503);
                    textView.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ WalletVerifyCodeUI kWn;

                        {
                            this.kWn = r1;
                        }

                        public final void onClick(View view) {
                            v.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
                            v.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess3 and finish!");
                            if (this.kWn.kWl != null && this.kWn.kWl.bfK()) {
                                g.iuh.h(13731, new Object[]{Integer.valueOf(9)});
                            }
                            Bundle bundle = this.kWn.uA;
                            bundle.putInt("key_err_code", 417);
                            bundle.putBoolean("key_need_show_switch_phone", true);
                            com.tencent.mm.wallet_core.a.k(this.kWn, bundle);
                            this.kWn.finish();
                        }
                    });
                } else {
                    textView.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ WalletVerifyCodeUI kWn;

                        public final void onClick(View view) {
                            com.tencent.mm.ui.base.g.b(this.kWn, this.kWn.getString(2131236367, new Object[]{bankcard.field_desc, bankcard.field_mobile}), "", this.kWn.getString(2131236366), this.kWn.getString(2131231010), new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass8 kWo;

                                {
                                    this.kWo = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    v.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess2 and finish to reset mobile num!");
                                    Bundle bundle = this.kWo.kWn.uA;
                                    bundle.putInt("key_err_code", 408);
                                    com.tencent.mm.wallet_core.a.k(this.kWo.kWn, bundle);
                                    this.kWo.kWn.finish();
                                }
                            }, null);
                        }
                    });
                }
                this.kWc.requestFocus();
                a(0, 2130839531, new OnMenuItemClickListener(this) {
                    final /* synthetic */ WalletVerifyCodeUI kWn;

                    {
                        this.kWn = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        String string = this.kWn.uA.getString("key_QADNA_URL");
                        if (be.kS(string)) {
                            com.tencent.mm.wallet_core.ui.e.l(this.kWn.nDR.nEl, "https://kf.qq.com/touch/sappfaq/160830qY7NJJ1608307ZJzqy.html", false);
                        } else {
                            com.tencent.mm.wallet_core.ui.e.l(this.kWn.nDR.nEl, string, false);
                        }
                        return true;
                    }
                });
                b(new OnMenuItemClickListener(this) {
                    final /* synthetic */ WalletVerifyCodeUI kWn;

                    {
                        this.kWn = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.kWn.axg();
                        if (this.kWn.beY()) {
                            this.kWn.showDialog(BaseReportManager.MAX_READ_COUNT);
                        } else {
                            this.kWn.finish();
                        }
                        return false;
                    }
                });
            }
        }
        str = bho;
        nK = nK(0);
        if (be.D(nK)) {
            TextView textView22 = this.kWj;
            if (k.xT()) {
                bho = getString(2131236494);
            } else {
                bho = getString(2131236495);
            }
            textView22.setText(String.format(bho, new Object[]{str}));
            this.kWj.setGravity(1);
        } else {
            this.kWj.setText(nK);
            this.kWj.setGravity(3);
        }
        this.kWc = (WalletFormView) findViewById(2131755621);
        this.kWc.pkk = this;
        this.kWd = (Button) findViewById(2131760040);
        this.kWd.setOnClickListener(/* anonymous class already generated */);
        this.kWd.setClickable(false);
        this.kWd.setEnabled(false);
        if (this.kWi != null) {
            this.kWi.cancel();
            this.kWi = null;
        }
        aVar = new a(this, (long) this.kWb);
        this.kWi = aVar;
        aVar.start();
        this.kHi = (Button) findViewById(2131755622);
        this.kHi.setOnClickListener(/* anonymous class already generated */);
        textView = (TextView) findViewById(2131760041);
        bankcard = (Bankcard) this.uA.getParcelable("key_bankcard");
        z = this.uA.getBoolean("key_is_changing_balance_phone_num");
        z2 = this.uA.getBoolean("key_need_show_switch_phone", false);
        if (z) {
        }
        textView.setVisibility(0);
        payInfo = (PayInfo) this.uA.getParcelable("key_pay_info");
        if (payInfo == null) {
            i = 0;
        } else {
            i = payInfo.bkq;
        }
        if (z2) {
            textView.setText(2131236503);
            textView.setOnClickListener(/* anonymous class already generated */);
        } else {
            if (ae != null) {
            }
            if (k.xT()) {
            }
            textView.setText(k.xT() ? getString(2131236497) : getString(2131236496));
            textView.setOnClickListener(/* anonymous class already generated */);
        }
        this.kWc.requestFocus();
        a(0, 2130839531, /* anonymous class already generated */);
        b(/* anonymous class already generated */);
    }

    public void bhr() {
        Bundle bundle = this.uA;
        String string = this.uA.getString("key_pwd1");
        this.kWe = this.kWc.getText();
        l lVar = new l();
        lVar.kQj = string;
        lVar.imN = this.kIA;
        lVar.kQk = this.kWe;
        lVar.token = be.ah(this.uA.getString("kreq_token"), "");
        Bankcard bankcard = (Bankcard) bundle.getParcelable("key_bankcard");
        if (bankcard != null) {
            lVar.hMt = bankcard.field_bankcardType;
            lVar.hMu = bankcard.field_bindSerial;
            lVar.kMZ = be.ah(bankcard.field_arrive_type, "");
        } else {
            lVar.hMt = this.uA.getString("key_bank_type");
        }
        v.d("MicroMsg.WalletVertifyCodeUI", "payInfo " + lVar.imN + " mVerifyCode: " + this.kWe);
        bundle.putString("key_verify_code", this.kWe);
        com.tencent.mm.wallet_core.a.ae(this);
        v.i("MicroMsg.WalletVertifyCodeUI", "do verify result : " + bLD().j(this.kWe, lVar));
    }

    public boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.d("MicroMsg.WalletVertifyCodeUI", " errCode: " + i2 + " errMsg :" + str);
        if (!(kVar instanceof f)) {
            if (i == 0 && i2 == 0) {
                boolean z;
                b ae = com.tencent.mm.wallet_core.a.ae(this);
                if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.l) {
                    this.uA.putBoolean("intent_bind_end", true);
                    com.tencent.mm.ui.base.g.bf(this, getString(2131236024));
                    v.i("MicroMsg.WalletVertifyCodeUI", "query bound bank card resp!");
                    z = true;
                } else {
                    if (!(kVar instanceof com.tencent.mm.wallet_core.e.a.k)) {
                        if (ae.e(this, null)) {
                            p(new com.tencent.mm.plugin.wallet_core.b.l(bLx()));
                            v.i("MicroMsg.WalletVertifyCodeUI", "to query bound bank card!");
                        } else {
                            z = true;
                        }
                    }
                    z = false;
                }
                if (kVar instanceof h) {
                    g.iuh.h(10707, new Object[]{Integer.valueOf(2), Integer.valueOf(c.bhv())});
                }
                if (this.kHn != null && (kVar instanceof com.tencent.mm.wallet_core.e.a.g)) {
                    String axY = ((com.tencent.mm.wallet_core.e.a.g) kVar).axY();
                    if (!be.kS(axY)) {
                        this.uA.putString("kreq_token", axY);
                    }
                }
                if (z) {
                    v.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess1 and finish!");
                    com.tencent.mm.wallet_core.a.k(this, this.uA);
                    finish();
                    return true;
                }
            }
            return false;
        } else if (i2 == 0 || !((f) kVar).boF) {
            return true;
        } else {
            com.tencent.mm.ui.base.g.a(this.nDR.nEl, str, null, false, new OnClickListener(this) {
                final /* synthetic */ WalletVerifyCodeUI kWn;

                {
                    this.kWn = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return true;
        }
    }

    protected final int getLayoutId() {
        return 2130904691;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.kWf != null) {
            this.kWf.stop();
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final void fc(boolean z) {
        if (this.kWc.de(null)) {
            this.kHi.setEnabled(true);
            this.kHi.setClickable(true);
            return;
        }
        this.kHi.setEnabled(false);
        this.kHi.setClickable(false);
    }

    public void onDestroy() {
        if (this.kWf != null) {
            this.kWf.stop();
        }
        this.pjH.gR(1580);
        super.onDestroy();
    }

    public boolean beY() {
        if (this.kIA == null || !this.kIA.lVz) {
            return super.beY();
        }
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            int i2;
            String str = "MicroMsg.WalletVertifyCodeUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            if (iArr == null) {
                i2 = -1;
            } else {
                i2 = iArr.length;
            }
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = be.bur();
            v.w(str, str2, objArr);
            return;
        }
        v.i("MicroMsg.WalletVertifyCodeUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 128:
                if (iArr[0] == 0 && this.kWf != null) {
                    this.kWf.start();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final boolean g(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.WalletVertifyCodeUI", "onPreSceneEnd %s %s", new Object[]{Integer.valueOf(i2), kVar});
        if ((kVar instanceof f) && i2 == 0) {
            this.kWk = true;
            s.makeText(this, 2131236299, 0).show();
            v.i("MicroMsg.WalletVertifyCodeUI", "tag it isCertInstalled ok");
        }
        return true;
    }
}
