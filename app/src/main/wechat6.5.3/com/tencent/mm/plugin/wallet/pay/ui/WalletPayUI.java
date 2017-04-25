package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.e.a.qj;
import com.tencent.mm.e.a.qo;
import com.tencent.mm.e.a.qp;
import com.tencent.mm.e.a.qt;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wallet.pay.a.b.d;
import com.tencent.mm.plugin.wallet.pay.a.b.e;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.plugin.wallet_core.ui.c;
import com.tencent.mm.plugin.wallet_core.ui.i;
import com.tencent.mm.plugin.wallet_core.ui.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.m;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUI extends WalletBaseUI implements com.tencent.mm.plugin.wallet.pay.ui.a.a {
    private boolean hdn = false;
    protected com.tencent.mm.plugin.wallet.a irY = null;
    private String isk;
    public Orders ith = null;
    public k kFo;
    public ArrayList<Bankcard> kFq = null;
    public Bankcard kFr = null;
    public PayInfo kIA = null;
    public String kIC = null;
    public FavorPayInfo kID = null;
    private a kIE;
    c kIF;
    private com.tencent.mm.sdk.c.c kIG = new com.tencent.mm.sdk.c.c<qt>(this) {
        final /* synthetic */ WalletPayUI kJM;

        {
            this.kJM = r2;
            this.nhz = qt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            v.i("MicroMsg.WalletPayUI", "WalletRealNameResultNotifyMoreEvent %s", new Object[]{Integer.valueOf(((qt) bVar).bsm.bpc)});
            if (((qt) bVar).bsm.bpc == -1) {
                this.kJM.kJK = true;
                this.kJM.kJL = true;
                this.kJM.bff();
            }
            return false;
        }
    };
    public Button kIx;
    private LinearLayout kJA;
    private boolean kJB = true;
    private boolean kJC = false;
    private boolean kJD = false;
    private boolean kJE = false;
    private boolean kJF = false;
    private int kJG = -1;
    private boolean kJH = false;
    private boolean kJI = false;
    private d kJJ;
    private boolean kJK = false;
    private boolean kJL = false;
    protected com.tencent.mm.plugin.wallet_core.ui.a kJf = null;
    private boolean kJg = false;
    public boolean kJh = false;
    protected boolean kJi = false;
    protected String kJj = "";
    protected boolean kJk = false;
    public Bundle kJl = null;
    protected boolean kJm = false;
    protected TextView kJn;
    protected TextView kJo;
    private TextView kJp;
    protected TextView kJq;
    protected TextView kJr;
    protected TextView kJs;
    protected ImageView kJt;
    private TextView kJu;
    private TextView kJv;
    protected LinearLayout kJw;
    protected a kJx;
    private long kJy = 0;
    private TextView kJz;
    public int mCount = 0;

    protected class a {
        final /* synthetic */ WalletPayUI kJM;

        protected a(WalletPayUI walletPayUI) {
            this.kJM = walletPayUI;
        }

        public final void notifyDataSetChanged() {
            this.kJM.kJw.removeAllViews();
            int i = this.kJM.mCount == 0 ? 0 : this.kJM.kJk ? this.kJM.mCount : 1;
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            for (int i2 = 0; i2 < i; i2++) {
                String string;
                Object tU;
                View inflate = ((LayoutInflater) this.kJM.getSystemService("layout_inflater")).inflate(2130904666, null);
                TextView textView = (TextView) inflate.findViewById(2131759937);
                TextView textView2 = (TextView) inflate.findViewById(2131759930);
                Commodity commodity = (Commodity) this.kJM.ith.kPm.get(i2);
                String str = "";
                if (this.kJM.kIA != null && (this.kJM.kIA.bkq == 32 || this.kJM.kIA.bkq == 33 || this.kJM.kIA.bkq == 31)) {
                    string = this.kJM.kIA.lVD.getString("extinfo_key_1", "");
                    if (be.kS(string)) {
                        v.e("MicroMsg.WalletPayUI", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                    } else {
                        ak.yW();
                        u LV = com.tencent.mm.model.c.wH().LV(string);
                        if (LV != null) {
                            tU = LV.tU();
                        } else {
                            v.e("MicroMsg.WalletPayUI", "can not found contact for user::" + string);
                            string = str;
                        }
                        if (commodity == null) {
                            if (!be.kS(tU)) {
                                textView2.setText(tU);
                                textView2.setVisibility(0);
                                ((TextView) inflate.findViewById(2131759962)).setVisibility(0);
                            } else if (be.kS(commodity.hMV)) {
                                textView2.setText(commodity.hMV);
                                textView2.setVisibility(0);
                                ((TextView) inflate.findViewById(2131759962)).setVisibility(0);
                            } else {
                                ((TextView) inflate.findViewById(2131759962)).setVisibility(8);
                                textView2.setVisibility(8);
                            }
                            if (be.kS(commodity.desc)) {
                                textView.setText(commodity.desc);
                                textView.setVisibility(8);
                                ((TextView) inflate.findViewById(2131759936)).setVisibility(8);
                            } else {
                                ((TextView) inflate.findViewById(2131759936)).setVisibility(8);
                                textView.setVisibility(8);
                            }
                            if (be.kS(tU) || !be.kS(commodity.hMV)) {
                                inflate.setVisibility(0);
                            } else {
                                inflate.setVisibility(8);
                            }
                        }
                        inflate.setLayoutParams(layoutParams);
                        inflate.measure(-2, -2);
                        this.kJM.kJw.addView(inflate);
                    }
                }
                string = str;
                if (commodity == null) {
                    if (!be.kS(tU)) {
                        textView2.setText(tU);
                        textView2.setVisibility(0);
                        ((TextView) inflate.findViewById(2131759962)).setVisibility(0);
                    } else if (be.kS(commodity.hMV)) {
                        ((TextView) inflate.findViewById(2131759962)).setVisibility(8);
                        textView2.setVisibility(8);
                    } else {
                        textView2.setText(commodity.hMV);
                        textView2.setVisibility(0);
                        ((TextView) inflate.findViewById(2131759962)).setVisibility(0);
                    }
                    if (be.kS(commodity.desc)) {
                        ((TextView) inflate.findViewById(2131759936)).setVisibility(8);
                        textView.setVisibility(8);
                    } else {
                        textView.setText(commodity.desc);
                        textView.setVisibility(8);
                        ((TextView) inflate.findViewById(2131759936)).setVisibility(8);
                    }
                    if (be.kS(tU)) {
                    }
                    inflate.setVisibility(0);
                }
                inflate.setLayoutParams(layoutParams);
                inflate.measure(-2, -2);
                this.kJM.kJw.addView(inflate);
            }
        }
    }

    static /* synthetic */ void d(WalletPayUI walletPayUI) {
        Bundle bundle = new Bundle();
        if (walletPayUI.ith != null) {
            bundle.putString("key_reqKey", walletPayUI.ith.fTG);
            if (walletPayUI.ith.kPm != null && walletPayUI.ith.kPm.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) walletPayUI.ith.kPm.get(0)).eWA);
            }
            bundle.putLong("key_SessionId", walletPayUI.kJy);
        }
        if (walletPayUI.kIA != null) {
            bundle.putInt("key_scene", walletPayUI.kIA.bkq);
        }
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putBoolean("key_is_oversea", !walletPayUI.bfk());
        com.tencent.mm.wallet_core.a.a(walletPayUI, com.tencent.mm.plugin.wallet.pay.a.class, bundle, null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (ak.uz()) {
            com.tencent.mm.sdk.c.a.nhr.e(this.kIG);
            f.g(this, 5);
            this.irY = com.tencent.mm.plugin.wallet.a.K(getIntent());
            vD(2131236369);
            this.kIA = bfp();
            this.kJi = getIntent().getBooleanExtra("key_is_force_use_given_card", false);
            this.kJj = be.ah(getIntent().getStringExtra("key_force_use_bind_serail"), "");
            this.isk = getIntent().getStringExtra("key_receiver_true_name");
            if (this.kIA == null || this.kIA.lVH == 0) {
                this.kJy = System.currentTimeMillis();
            } else {
                this.kJy = this.kIA.lVH;
            }
            if (bfe()) {
                v.i("MicroMsg.WalletPayUI", "hy: pay end on create. finish");
                finish();
                return;
            }
            v.d("MicroMsg.WalletPayUI", "PayInfo = " + this.kIA);
            if (this.kIA == null || be.kS(this.kIA.fTG)) {
                String string;
                if (this.kIA == null || be.kS(this.kIA.biS)) {
                    string = getString(2131236362);
                } else {
                    string = this.kIA.biS;
                }
                g.a(this, string, null, false, new OnClickListener(this) {
                    final /* synthetic */ WalletPayUI kJM;

                    {
                        this.kJM = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.kJM.finish();
                    }
                });
            } else {
                bff();
            }
            NI();
            return;
        }
        v.e("MicroMsg.WalletPayUI", "hy: account not ready. finish now");
        finish();
    }

    private boolean bfe() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("intent_pay_end")) {
            v.i("MicroMsg.WalletPayUI", "hy: pay end. finish the activity");
            if (extras.getBoolean("intent_pay_end", false)) {
                v.d("MicroMsg.WalletPayUI", "pay done... errCode:" + extras.getInt("intent_pay_end_errcode"));
                v.d("MicroMsg.WalletPayUI", "pay done INTENT_PAY_APP_URL:" + extras.getString("intent_pay_app_url"));
                v.d("MicroMsg.WalletPayUI", "pay done INTENT_PAY_END:" + extras.getBoolean("intent_pay_end", false));
                c(-1, getIntent());
                this.hdn = true;
                return true;
            }
            v.d("MicroMsg.WalletPayUI", "pay cancel");
            c(0, getIntent());
            this.hdn = false;
            return true;
        } else if (extras == null || !extras.getBoolean("key_is_realname_verify_process")) {
            v.i("MicroMsg.WalletPayUI", "hy: pay not end");
            return false;
        } else {
            switch (extras.getInt("realname_verify_process_ret", 0)) {
                case -1:
                    return true;
                default:
                    return false;
            }
        }
    }

    public void onDestroy() {
        if (this.kIE != null) {
            this.kIE.beT();
            this.kIE.release();
        }
        com.tencent.mm.sdk.c.a.nhr.f(this.kIG);
        this.kIF = null;
        super.onDestroy();
    }

    public void bff() {
        com.tencent.mm.wallet_core.b.k kVar;
        int i = 2;
        com.tencent.mm.plugin.report.service.g.iuh.h(11850, new Object[]{Integer.valueOf(2), Integer.valueOf(this.kIA.bkq)});
        if (this.kIA.bkq == 11) {
            i = 3;
        }
        PayInfo payInfo = this.kIA;
        if (payInfo == null || be.kS(payInfo.fTG)) {
            v.i("MicroMsg.CgiManager", "no payInfo or reqKey");
            kVar = null;
        } else {
            String str = payInfo.fTG;
            v.i("MicroMsg.CgiManager", "qrorderinfo reqKey: %s", new Object[]{str});
            if (com.tencent.mm.plugin.wallet.pay.a.a.beR()) {
                v.i("MicroMsg.CgiManager", "qrorderinfo go new split cgi");
                kVar = str.startsWith("sns_aa_") ? new com.tencent.mm.plugin.wallet.pay.a.b.a(payInfo, i) : str.startsWith("sns_tf_") ? new com.tencent.mm.plugin.wallet.pay.a.b.f(payInfo, i) : str.startsWith("sns_ff_") ? new com.tencent.mm.plugin.wallet.pay.a.b.b(payInfo, i) : str.startsWith("ts_") ? new com.tencent.mm.plugin.wallet.pay.a.b.c(payInfo, i) : str.startsWith("sns_") ? new e(payInfo, i) : new d(payInfo, i);
            } else {
                kVar = new d(payInfo, i);
            }
        }
        if (kVar != null) {
            boolean z;
            kVar.mProcessName = "PayProcess";
            kVar.piE = this.kJy;
            if (this.kIA.bkq == 6 && this.kIA.lVy == 100) {
                kVar.cVh = 100;
            } else {
                kVar.cVh = this.kIA.bkq;
            }
            if (this.kIA.lVA) {
                z = true;
            } else {
                z = false;
            }
            super.bLE();
            this.pjH.a(kVar, true, z);
        }
    }

    public void onResume() {
        v.i("MicroMsg.WalletPayUI", "hy: onResume isFromH5RealNameVerify %s", new Object[]{Boolean.valueOf(this.kJK)});
        if (!this.pjH.axG()) {
            if (this.kFr == null) {
                com.tencent.mm.plugin.wallet.a.k.beN();
                this.kFr = com.tencent.mm.plugin.wallet.a.k.beO().a(null, null, beU(), false);
            } else {
                com.tencent.mm.plugin.wallet.a.k.beN();
                this.kFr = com.tencent.mm.plugin.wallet.a.k.beO().a(null, this.kFr.field_bindSerial, beU(), false);
            }
        }
        if (this.kJL) {
            v.i("MicroMsg.WalletPayUI", "onResume isResumePassFinish");
            this.kJL = false;
        } else if (this.kJh && this.nDR.dtW.getVisibility() != 0 && (this.kFo == null || !this.kFo.isShowing())) {
            v.i("MicroMsg.WalletPayUI", "hy: has started process and is transparent and no pwd appeared. finish self");
            finish();
        } else if (this.kIF != null) {
            this.kIF.bgV();
        }
        super.onResume();
    }

    protected final int getLayoutId() {
        return 2130904670;
    }

    public void finish() {
        bLz();
        if (this.hdn) {
            setResult(-1, getIntent());
        } else {
            setResult(0);
        }
        super.finish();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (this.kFo == null || this.kIA == null || !this.kIA.lVz) {
            axg();
            showDialog(1000);
        } else {
            finish();
        }
        return true;
    }

    public void onNewIntent(Intent intent) {
        boolean z;
        boolean z2 = true;
        v.v("MicroMsg.WalletPayUI", "onNewIntent");
        setIntent(intent);
        if (!bfe()) {
            v.w("MicroMsg.WalletPayUI", "hy: pay not end if judge from intent, but should finish this ui, and set cancel event");
            c(0, getIntent());
            this.hdn = false;
        }
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            z = false;
        } else {
            this.kJC = true;
            z = true;
        }
        if (z) {
            v.i("MicroMsg.WalletPayUI", "isFromBindCard is true");
            bff();
            return;
        }
        if (intent == null || !intent.getBooleanExtra("key_is_realname_verify_process", false)) {
            z2 = false;
        } else {
            this.kJD = true;
        }
        if (z2) {
            v.i("MicroMsg.WalletPayUI", "isFromRealNameVerify is true");
            finish();
        } else {
            v.e("MicroMsg.WalletPayUI", "isFromBindCard is false,isFromRealNameVerify is false");
        }
        finish();
    }

    private void c(int i, Intent intent) {
        qp qpVar = new qp();
        qpVar.bsg.context = this;
        qpVar.bsg.intent = intent;
        qpVar.bsg.bpc = i;
        com.tencent.mm.sdk.c.a.nhr.z(qpVar);
    }

    protected final void NI() {
        MMScrollView mMScrollView = (MMScrollView) findViewById(2131758524);
        mMScrollView.a(mMScrollView, mMScrollView);
        this.kIx = (Button) findViewById(2131759988);
        this.kIx.setClickable(false);
        this.kIx.setEnabled(false);
        this.kJn = (TextView) findViewById(2131759932);
        this.kJo = (TextView) findViewById(2131759967);
        this.kJq = (TextView) findViewById(2131759968);
        this.kJv = (TextView) findViewById(2131759973);
        this.kJp = (TextView) findViewById(2131759969);
        this.kJu = (TextView) findViewById(2131759987);
        this.kJp.getPaint().setFlags(16);
        this.kJr = (TextView) findViewById(2131759990);
        this.kJs = (TextView) findViewById(2131759989);
        this.kJs.setOnClickListener(new m(this) {
            final /* synthetic */ WalletPayUI kJM;

            {
                this.kJM = r1;
            }

            public final void ayv() {
                this.kJM.c(false, 0, "");
            }
        });
        this.kJt = (ImageView) findViewById(2131759974);
        this.kJt.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WalletPayUI kJM;

            {
                this.kJM = r1;
            }

            public final void onClick(View view) {
                if (this.kJM.kJk) {
                    this.kJM.kJt.setImageResource(2130838844);
                    this.kJM.kJk = false;
                } else {
                    this.kJM.kJt.setImageResource(2130838847);
                    this.kJM.kJk = true;
                }
                this.kJM.kJx.notifyDataSetChanged();
            }
        });
        this.kJw = (LinearLayout) findViewById(2131759970);
        this.kJx = new a(this);
        this.kIx.setOnClickListener(new m(this) {
            final /* synthetic */ WalletPayUI kJM;

            {
                this.kJM = r1;
            }

            public final void ayv() {
                this.kJM.bfl();
            }
        });
        this.kIx.setText(2131236324);
        this.kJz = (TextView) findViewById(2131759975);
        this.kJA = (LinearLayout) findViewById(2131759976);
        av();
    }

    public final void av() {
        boolean z;
        LinearLayout linearLayout;
        if (!(this.ith == null || this.ith.kPm == null || this.ith.kPm.size() <= 0)) {
            this.kJn.setText(com.tencent.mm.wallet_core.ui.e.m(this.ith.kOU));
            this.kJq.setText(com.tencent.mm.wallet_core.ui.e.PQ(this.ith.hNg));
            this.kJx.notifyDataSetChanged();
            if (this.ith.kPm.size() > 1) {
                this.kJt.setVisibility(0);
                this.kJo.setText(getString(2131236370, new Object[]{((Commodity) this.ith.kPm.get(0)).desc, this.ith.kPm.size()}));
            } else {
                this.kJo.setText(((Commodity) this.ith.kPm.get(0)).desc);
                this.kJt.setVisibility(8);
            }
            this.kJk = false;
            int i = this.ith.kOW;
        }
        this.kJr.setVisibility(8);
        this.kJs.setVisibility(8);
        this.kJz.setVisibility(8);
        this.kJA.setVisibility(8);
        this.kIx.setText(2131236324);
        if (this.kFr == null || !this.kFr.bfG()) {
            com.tencent.mm.plugin.wallet.a.k.beN();
            if (com.tencent.mm.plugin.wallet.a.k.beO().bgs()) {
                bfg();
            }
        } else if (be.kS(this.kFr.field_forbidWord)) {
            com.tencent.mm.plugin.wallet.a.k.beN();
            if (com.tencent.mm.plugin.wallet.a.k.beO().bgw()) {
                bfg();
            }
        } else {
            this.kJr.setText(this.kFr.field_forbidWord);
            this.kJr.setVisibility(4);
            this.kJs.setVisibility(8);
            com.tencent.mm.plugin.wallet.a.k.beN();
            if (com.tencent.mm.plugin.wallet.a.k.beO().bgw()) {
                bfg();
            }
        }
        com.tencent.mm.plugin.wallet.a.k.beN();
        if (!com.tencent.mm.plugin.wallet.a.k.beO().bgw()) {
            com.tencent.mm.plugin.wallet.a.k.beN();
            if (!com.tencent.mm.plugin.wallet.a.k.beO().bgs()) {
                z = false;
                linearLayout = (LinearLayout) findViewById(2131759971);
                if (z || this.kID == null || this.kJf == null || !this.kJg || this.ith == null) {
                    linearLayout.setVisibility(8);
                } else {
                    bfi();
                    this.kJv.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ WalletPayUI kJM;

                        {
                            this.kJM = r1;
                        }

                        public final void onClick(View view) {
                            i.a(this.kJM.nDR.nEl, this.kJM.ith, this.kJM.kID.kOv, new i.b(this) {
                                final /* synthetic */ AnonymousClass22 kJQ;

                                {
                                    this.kJQ = r1;
                                }

                                public final void a(FavorPayInfo favorPayInfo) {
                                    int i = 1;
                                    this.kJQ.kJM.kID = favorPayInfo;
                                    if (this.kJQ.kJM.kID != null) {
                                        if (this.kJQ.kJM.kFr == null || com.tencent.mm.plugin.wallet_core.ui.a.a(this.kJQ.kJM.kID, this.kJQ.kJM.kFr)) {
                                            this.kJQ.kJM.kJs.setVisibility(8);
                                            this.kJQ.kJM.kIx.setOnClickListener(new View.OnClickListener(this) {
                                                final /* synthetic */ AnonymousClass1 kJR;

                                                {
                                                    this.kJR = r1;
                                                }

                                                public final void onClick(View view) {
                                                    v.i("MicroMsg.WalletPayUI", "mDefaultBankcard null or needToPayWithBankcard after favor selection! payWithNewBankcard");
                                                    this.kJR.kJQ.kJM.c(false, 0, "");
                                                }
                                            });
                                        } else {
                                            com.tencent.mm.plugin.wallet.a.e Dn = this.kJQ.kJM.kJf.Dn(this.kJQ.kJM.kID.kOv);
                                            if (Dn != null && this.kJQ.kJM.kFr.bfG()) {
                                                com.tencent.mm.plugin.wallet.a.k.beN();
                                                Bankcard bankcard = com.tencent.mm.plugin.wallet.a.k.beO().kFU;
                                                double d = Dn.kHA;
                                                if (bankcard != null && bankcard.kNv < d) {
                                                    v.i("MicroMsg.WalletPayUI", "balance not meet");
                                                    this.kJQ.kJM.kJs.setVisibility(8);
                                                    this.kJQ.kJM.kIx.setOnClickListener(new View.OnClickListener(this) {
                                                        final /* synthetic */ AnonymousClass1 kJR;

                                                        {
                                                            this.kJR = r1;
                                                        }

                                                        public final void onClick(View view) {
                                                            v.i("MicroMsg.WalletPayUI", "Balance amount not meet, after favor selection! payWithNewBankcard");
                                                            this.kJR.kJQ.kJM.c(false, 0, "");
                                                        }
                                                    });
                                                }
                                            }
                                            i = 0;
                                        }
                                        if (i == 0) {
                                            this.kJQ.kJM.kJr.setVisibility(8);
                                            this.kJQ.kJM.kJs.setVisibility(0);
                                            this.kJQ.kJM.kIx.setOnClickListener(new View.OnClickListener(this) {
                                                final /* synthetic */ AnonymousClass1 kJR;

                                                {
                                                    this.kJR = r1;
                                                }

                                                public final void onClick(View view) {
                                                    this.kJR.kJQ.kJM.bfl();
                                                }
                                            });
                                        }
                                        this.kJQ.kJM.bfi();
                                    }
                                }
                            });
                        }
                    });
                    linearLayout.setVisibility(0);
                }
                if (this.ith != null || this.kFq == null || this.kIA == null) {
                    this.kIx.setClickable(false);
                    this.kIx.setEnabled(false);
                } else {
                    this.kIx.setClickable(true);
                    this.kIx.setEnabled(true);
                }
                if (this.ith == null) {
                    this.kJs.setVisibility(8);
                }
            }
        }
        z = true;
        linearLayout = (LinearLayout) findViewById(2131759971);
        if (z) {
        }
        linearLayout.setVisibility(8);
        if (this.ith != null) {
        }
        this.kIx.setClickable(false);
        this.kIx.setEnabled(false);
        if (this.ith == null) {
            this.kJs.setVisibility(8);
        }
    }

    private void bfg() {
        if (this.ith == null) {
            v.e("MicroMsg.WalletPayUI", "updatePaymentMethodForFavor mOrders is null");
            return;
        }
        this.kJs.setVisibility(8);
        this.kJr.setVisibility(8);
        this.kIx.setText(2131236324);
        this.kJz.setVisibility(0);
        this.kJA.setVisibility(0);
        View findViewById = this.kJA.findViewById(2131759977);
        View findViewById2 = this.kJA.findViewById(2131759981);
        if ("CFT".equals(this.ith.kPi)) {
            findViewById2.setVisibility(8);
        } else {
            findViewById2.setVisibility(0);
        }
        final CheckedTextView checkedTextView = (CheckedTextView) this.kJA.findViewById(2131759980);
        final CheckedTextView checkedTextView2 = (CheckedTextView) this.kJA.findViewById(2131759986);
        findViewById.setEnabled(true);
        boolean z;
        if (this.ith == null || this.ith.kPm == null || this.ith.kPm.size() <= 0) {
            z = false;
        } else if (this.ith.kOW == 1) {
            z = true;
        } else {
            z = false;
        }
        if (this.kFr == null) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WalletPayUI kJM;

                public final void onClick(View view) {
                    checkedTextView.setChecked(true);
                    checkedTextView2.setChecked(false);
                    this.kJM.kJB = false;
                    this.kJM.bfh();
                }
            });
        }
        findViewById2.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WalletPayUI kJM;

            public final void onClick(View view) {
                checkedTextView.setChecked(false);
                checkedTextView2.setChecked(true);
                this.kJM.kJB = true;
                this.kJM.bfh();
            }
        });
        this.kJB = true;
        checkedTextView.setChecked(false);
        checkedTextView2.setChecked(true);
        v.i("MicroMsg.WalletPayUI", "updatePaymentMethodForFavor needbindcardtoshowfavinfo is " + this.ith.kPo);
        if (this.ith.kPo == 1) {
            this.kJA.findViewById(2131759983).setVisibility(0);
            ((TextView) this.kJA.findViewById(2131759984)).setText(this.ith.kPp);
            if (TextUtils.isEmpty(this.ith.kPq)) {
                ((TextView) this.kJA.findViewById(2131759985)).setText("");
            } else {
                ((TextView) this.kJA.findViewById(2131759985)).setText(" (" + this.ith.kPq + ")");
            }
            if (!(this.kFr == null || !this.kFr.bfG() || TextUtils.isEmpty(this.kFr.field_forbidWord))) {
                findViewById.setEnabled(false);
                checkedTextView.setVisibility(8);
                ((TextView) this.kJA.findViewById(2131759979)).setText(this.kFr.field_forbidWord);
            }
        } else {
            this.kJA.findViewById(2131759983).setVisibility(8);
            if (this.kFr != null && this.kFr.bfG() && !TextUtils.isEmpty(this.kFr.field_forbidWord)) {
                findViewById.setEnabled(false);
                checkedTextView.setVisibility(8);
                ((TextView) this.kJA.findViewById(2131759979)).setText(this.kFr.field_forbidWord);
            } else if (this.kFr != null && this.kFr.bfG() && TextUtils.isEmpty(this.kFr.field_forbidWord) && !r2) {
                checkedTextView.setChecked(true);
                checkedTextView2.setChecked(false);
                this.kJB = false;
            }
        }
        bfh();
    }

    private void bfh() {
        if (this.kJB) {
            this.kIx.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WalletPayUI kJM;

                {
                    this.kJM = r1;
                }

                public final void onClick(View view) {
                    if (this.kJM.ith.kPo == 1) {
                        WalletPayUI.d(this.kJM);
                        return;
                    }
                    v.i("MicroMsg.WalletPayUI", "SimpleReg , assigned userinfo pay! payWithNewBankcard");
                    this.kJM.c(false, 0, "");
                }
            });
        } else {
            this.kIx.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ WalletPayUI kJM;

                {
                    this.kJM = r1;
                }

                public final void onClick(View view) {
                    this.kJM.bfl();
                }
            });
        }
    }

    public final void bfi() {
        double d;
        int i;
        com.tencent.mm.plugin.wallet.a.e Dn = this.kJf.Dn(this.kID.kOv);
        List bgU = this.kJf.bgU();
        com.tencent.mm.plugin.wallet.a.c cVar = this.kJf.kRH;
        CharSequence charSequence = "";
        if (Dn != null) {
            d = Dn.kHI;
            if (d > 0.0d) {
                String str = Dn.kHK;
                if (be.kS(Dn.kHL)) {
                    Object obj = str;
                    i = 1;
                } else {
                    charSequence = str + "," + Dn.kHL;
                    i = 1;
                }
            } else {
                i = 0;
            }
        } else {
            i = 0;
            d = 0.0d;
        }
        if (i == 0 && bgU.size() > 0) {
            charSequence = charSequence + this.nDR.nEl.getString(2131236400);
        }
        if (d <= 0.0d || cVar == null || cVar.kHE != 0) {
            this.kJn.setText(com.tencent.mm.wallet_core.ui.e.m(this.ith.kOU));
            this.kJq.setText(com.tencent.mm.wallet_core.ui.e.PQ(this.ith.hNg));
            this.kJp.setVisibility(8);
        } else {
            if (Dn != null) {
                this.kJn.setText(com.tencent.mm.wallet_core.ui.e.m(Dn.kHH));
            }
            this.kJq.setText(com.tencent.mm.wallet_core.ui.e.PQ(this.ith.hNg));
            this.kJp.setText(com.tencent.mm.wallet_core.ui.e.d(this.ith.kOU, this.ith.hNg));
            this.kJp.setVisibility(0);
        }
        if (!be.kS(charSequence)) {
            this.kJv.setText(charSequence);
        }
    }

    public final Authen bfj() {
        Authen authen = new Authen();
        if (bfk()) {
            authen.bkU = 3;
        } else {
            authen.bkU = 6;
        }
        if (!be.kS(this.kIC)) {
            authen.kMR = this.kIC;
        }
        if (this.kFr != null) {
            authen.hMu = this.kFr.field_bindSerial;
            authen.hMt = this.kFr.field_bankcardType;
        }
        if (this.kID != null) {
            authen.kNe = this.kID.kOv;
            authen.kNd = this.kID.kOy;
        }
        authen.imN = this.kIA;
        return authen;
    }

    public final boolean bfk() {
        if (this.kFr == null || this.ith.kLu != 3) {
            if (Bankcard.sm(this.ith.kLu)) {
                return false;
            }
            return true;
        } else if (this.kFr.bfI()) {
            return true;
        } else {
            return false;
        }
    }

    protected final void bfl() {
        hg(true);
    }

    protected final void hg(boolean z) {
        if (z) {
            boolean z2;
            if (this.ith != null && this.ith.kPe) {
                ak.yW();
                if (((Boolean) com.tencent.mm.model.c.vf().get(196614, Boolean.valueOf(true))).booleanValue()) {
                    View inflate = getLayoutInflater().inflate(2130904669, null);
                    final CheckBox checkBox = (CheckBox) inflate.findViewById(2131759965);
                    TextView textView = (TextView) inflate.findViewById(2131758446);
                    textView.setText(Html.fromHtml(String.format(getResources().getString(2131236363), new Object[]{getResources().getString(2131235977)})));
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    ((TextView) inflate.findViewById(2131757003)).setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ WalletPayUI kJM;

                        public final void onClick(View view) {
                            checkBox.setChecked(!checkBox.isChecked());
                        }
                    });
                    final h a = g.a(this, getString(2131236365), inflate, getString(2131236133), getString(2131233120), new OnClickListener(this) {
                        final /* synthetic */ WalletPayUI kJM;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (checkBox.isChecked()) {
                                ak.yW();
                                com.tencent.mm.model.c.vf().set(196614, Boolean.valueOf(false));
                            }
                            this.kJM.hg(false);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ WalletPayUI kJM;

                        {
                            this.kJM = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.kJM.finish();
                        }
                    });
                    a.setCancelable(false);
                    checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
                        final /* synthetic */ WalletPayUI kJM;

                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            Button button = a.getButton(-2);
                            if (z) {
                                button.setEnabled(false);
                            } else {
                                button.setEnabled(true);
                            }
                        }
                    });
                    z2 = false;
                    if (!z2) {
                        return;
                    }
                }
            }
            z2 = true;
            if (z2) {
                return;
            }
        }
        if (this.kJJ != null) {
            v.i("MicroMsg.WalletPayUI", "need real name,stop");
            d dVar = this.kJJ;
            if ("1".equals(dVar.brU)) {
                v.i("MicroMsg.WalletPayUI", "need realname verify");
                this.kJE = true;
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, dVar.brV, dVar.brW, dVar.brX, bundle, ayJ(), null, this.kIA != null ? this.kIA.bkq : 0, 2);
            } else if ("2".equals(dVar.brU)) {
                v.i("MicroMsg.WalletPayUI", "need upload credit");
                com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, dVar.brV, dVar.brY, dVar.brW, dVar.brX, ayJ(), null);
            } else {
                v.i("MicroMsg.WalletPayUI", "realnameGuideFlag =  " + dVar.brU);
            }
        } else if (this.kJi) {
            v.i("MicroMsg.WalletPayUI", "hy: start do pay with force use given bankcard");
            if (be.kS(this.kJj)) {
                c(false, 0, "");
                return;
            }
            this.kFr = bfn();
            beX();
        } else if (this.kFr != null) {
            int a2 = this.kFr.a(this.ith.kLu, this.ith);
            if (this.irY != null) {
                this.irY.aj(10002, "");
            }
            if (a2 != 0) {
                v.i("MicroMsg.WalletPayUI", "main bankcard(" + a2 + ") is useless! jump to select bankcard!");
                d(false, a2, "");
                return;
            }
            com.tencent.mm.plugin.wallet.a.k.beN();
            if (com.tencent.mm.plugin.wallet.a.k.beO().bgw()) {
                v.i("MicroMsg.WalletPayUI", "payWithoutPassword");
                hh(true);
                com.tencent.mm.plugin.wallet_core.d.c.bhu();
                return;
            }
            v.i("MicroMsg.WalletPayUI", "has useful bankcard ! payWithOldBankcard");
            beX();
        } else if (this.kFq == null || this.kFq.size() <= 0) {
            v.i("MicroMsg.WalletPayUI", "default bankcard not found! payWithNewBankcard");
            c(false, 0, "");
        } else {
            v.i("MicroMsg.WalletPayUI", " no last pay bankcard ! jump to select bankcard!");
            d(false, 8, "");
        }
    }

    public void beX() {
        if (Ox()) {
            boolean z;
            v.d("MicroMsg.WalletPayUI", "pay with old bankcard!");
            if (this.kJi) {
                z = false;
            } else {
                z = true;
            }
            this.kFo = k.a(this, z, this.ith, this.kID, this.kFr, this.kIA, this.isk, new k.c(this) {
                final /* synthetic */ WalletPayUI kJM;

                {
                    this.kJM = r1;
                }

                public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                    this.kJM.axg();
                    this.kJM.kID = favorPayInfo;
                    if (this.kJM.kID == null || !z) {
                        this.kJM.kIC = str;
                        this.kJM.hh(false);
                        com.tencent.mm.plugin.wallet_core.d.c.bhu();
                        this.kJM.kIF = null;
                        return;
                    }
                    this.kJM.N(-100, true);
                }
            }, new View.OnClickListener(this) {
                final /* synthetic */ WalletPayUI kJM;

                {
                    this.kJM = r1;
                }

                public final void onClick(View view) {
                    this.kJM.kID = (FavorPayInfo) view.getTag();
                    if (this.kJM.kID != null) {
                        this.kJM.kID.kOz = "";
                    }
                    this.kJM.d(false, 0, "");
                    this.kJM.kFo.dismiss();
                    this.kJM.kIC = null;
                    this.kJM.kFo = null;
                    this.kJM.kIF = null;
                }
            }, new OnCancelListener(this) {
                final /* synthetic */ WalletPayUI kJM;

                {
                    this.kJM = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    this.kJM.kIC = null;
                    this.kJM.kFo = null;
                    if (this.kJM.ayJ()) {
                        this.kJM.finish();
                    }
                    this.kJM.kIF = null;
                }
            });
            this.kIF = this.kFo;
        }
    }

    public final void c(boolean z, int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("pay with new bankcard! user's wxpay register status :");
        com.tencent.mm.plugin.wallet.a.k.beN();
        v.d("MicroMsg.WalletPayUI", stringBuilder.append(com.tencent.mm.plugin.wallet.a.k.beO().bgv()).append(", need confirm ? ").append(z).toString());
        if (z) {
            String D;
            if (be.kS(str)) {
                D = Bankcard.D(this, i);
            } else {
                D = str;
            }
            g.b(this, D, "", getString(2131236326), getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ WalletPayUI kJM;

                {
                    this.kJM = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.kJM.bfm();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ WalletPayUI kJM;

                {
                    this.kJM = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.kJM.ayJ()) {
                        this.kJM.finish();
                    }
                }
            });
            return;
        }
        bfm();
    }

    public final void d(boolean z, final int i, String str) {
        v.d("MicroMsg.WalletPayUI", "pay with select bankcard! need confirm ? " + z);
        if (z) {
            String D;
            if (be.kS(str)) {
                D = Bankcard.D(this, i);
            } else {
                D = str;
            }
            g.b(this, D, "", getString(2131236342), getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ WalletPayUI kJM;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.kJM.N(i, false);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ WalletPayUI kJM;

                {
                    this.kJM = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.kJM.ayJ()) {
                        this.kJM.finish();
                    }
                }
            });
            return;
        }
        N(i, false);
    }

    protected final void bfm() {
        Bundle extras = getIntent().getExtras();
        String str = "key_pay_flag";
        com.tencent.mm.plugin.wallet.a.k.beN();
        extras.putInt(str, com.tencent.mm.plugin.wallet.a.k.beO().bgv() ? 2 : 1);
        extras.putParcelable("key_orders", this.ith);
        extras.putParcelable("key_pay_info", this.kIA);
        extras.putParcelable("key_favor_pay_info", this.kID);
        y(extras);
    }

    protected final void N(int i, boolean z) {
        Bundle bundle = this.uA;
        bundle.putInt("key_main_bankcard_state", i);
        bundle.putParcelable("key_orders", this.ith);
        bundle.putParcelable("key_pay_info", this.kIA);
        bundle.putParcelable("key_authen", bfj());
        bundle.putString("key_pwd1", this.kIC);
        bundle.putInt("key_pay_flag", 3);
        bundle.putInt("key_err_code", -1004);
        bundle.putParcelable("key_favor_pay_info", this.kID);
        bundle.putBoolean("key_is_filter_bank_type", z);
        if (this.kFr != null) {
            bundle.putString("key_is_cur_bankcard_bind_serial", this.kFr.field_bindSerial);
        }
        y(bundle);
    }

    public boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        com.tencent.mm.plugin.wallet.pay.a.a.b bVar;
        Bundle bundle;
        if (i == 0 && i2 == 0) {
            if (kVar instanceof d) {
                com.tencent.mm.plugin.report.service.g gVar;
                Object[] objArr;
                d dVar = (d) kVar;
                if ("1".equals(dVar.brU) || "2".equals(dVar.brU)) {
                    this.kJJ = dVar;
                } else {
                    this.kJJ = null;
                }
                this.kJH = true;
                this.ith = ((d) kVar).ith;
                this.mCount = this.ith != null ? this.ith.kPm.size() : 0;
                v.d("MicroMsg.WalletPayUI", "get mOrders! bankcardTag : " + (this.ith != null ? Integer.valueOf(this.ith.kLu) : ""));
                Ox();
                if (!(this.ith == null || this.ith.kPn == null)) {
                    this.kJf = com.tencent.mm.plugin.wallet_core.ui.b.kRN.a(this.ith);
                    if (this.kJf != null) {
                        if (this.kJf.bgU().size() > 0) {
                            this.kJg = true;
                        }
                        this.kID = this.kJf.Dq(this.ith.kPn.kHB);
                        this.kID.kOv = this.kJf.Dr(this.kID.kOv);
                    }
                }
                if (!(this.ith == null || this.kFq == null || this.kIA == null)) {
                    com.tencent.mm.plugin.wallet_core.d.c.b(this.kIA, this.ith);
                    gVar = com.tencent.mm.plugin.report.service.g.iuh;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.kIA.bkq);
                    objArr[1] = Integer.valueOf(0);
                    com.tencent.mm.plugin.wallet.a.k.beN();
                    objArr[2] = Integer.valueOf(com.tencent.mm.plugin.wallet.a.k.beO().bgv() ? 2 : 1);
                    objArr[3] = Integer.valueOf((int) (this.ith.kOU * 100.0d));
                    objArr[4] = this.ith.hNg;
                    gVar.h(10690, objArr);
                }
                if (!(this.ith == null || this.ith.kPm == null)) {
                    LinkedList linkedList = new LinkedList();
                    for (Commodity commodity : this.ith.kPm) {
                        linkedList.add(commodity.eWA);
                    }
                    if (linkedList.size() > 0) {
                        qo qoVar = new qo();
                        qoVar.bsd.bsf = linkedList;
                        com.tencent.mm.sdk.c.a.nhr.z(qoVar);
                        if (this.irY != null) {
                            this.irY.aj(10001, (String) linkedList.get(0));
                        }
                    }
                }
                com.tencent.mm.plugin.wallet.a.k.beN();
                this.kFq = com.tencent.mm.plugin.wallet.a.k.beO().hk(beU());
                com.tencent.mm.plugin.wallet.a.k.beN();
                this.kFr = com.tencent.mm.plugin.wallet.a.k.beO().a(null, null, beU(), false);
                this.kIx.setClickable(true);
                if (be.kS(com.tencent.mm.plugin.wallet_core.model.k.bga().kQZ)) {
                    this.kJu.setVisibility(8);
                    this.kJu.setText("");
                } else {
                    this.kJu.setVisibility(0);
                    this.kJu.setText(com.tencent.mm.plugin.wallet_core.model.k.bga().kQZ);
                }
                if (!(this.ith == null || this.kFq == null || this.kIA == null)) {
                    com.tencent.mm.plugin.wallet_core.d.c.b(this.kIA, this.ith);
                    gVar = com.tencent.mm.plugin.report.service.g.iuh;
                    objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.kIA.bkq);
                    objArr[1] = Integer.valueOf(0);
                    com.tencent.mm.plugin.wallet.a.k.beN();
                    objArr[2] = Integer.valueOf(com.tencent.mm.plugin.wallet.a.k.beO().bgv() ? 2 : 1);
                    objArr[3] = Integer.valueOf((int) (this.ith.kOU * 100.0d));
                    objArr[4] = this.ith.hNg;
                    gVar.h(10690, objArr);
                }
                if (this.kJC) {
                    N(0, false);
                }
            } else if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                bundle = this.uA;
                bundle.putParcelable("key_pay_info", this.kIA);
                bundle.putParcelable("key_bankcard", this.kFr);
                bundle.putString("key_bank_type", this.kFr.field_bankcardType);
                if (!be.kS(this.kIC)) {
                    bundle.putString("key_pwd1", this.kIC);
                }
                bundle.putString("kreq_token", bVar.token);
                bundle.putParcelable("key_authen", bVar.hdp);
                bundle.putBoolean("key_need_verify_sms", !bVar.hdm);
                if (be.kS(bVar.kIp)) {
                    bundle.putString("key_mobile", this.kFr.field_mobile);
                } else {
                    bundle.putString("key_mobile", bVar.kIp);
                }
                bundle.putString("key_QADNA_URL", bVar.kIq);
                if (bVar.hdn) {
                    if (this.irY != null) {
                        this.irY.aj(10003, "");
                        com.tencent.mm.plugin.wallet.a aVar = this.irY;
                        com.tencent.mm.plugin.report.service.g.iuh.h(13455, new Object[]{aVar.kFe, Long.valueOf(System.currentTimeMillis()), aVar.kFf});
                    }
                    bundle.putParcelable("key_orders", bVar.hdo);
                } else {
                    bundle.putParcelable("key_orders", this.ith);
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("pwd", this.kIC);
                com.tencent.mm.pluginsdk.j.a.lxX.a(bVar.beS(), true, bundle2);
                bundle.putInt("key_pay_flag", 3);
                RealnameGuideHelper realnameGuideHelper = bVar.hKv;
                if (realnameGuideHelper != null) {
                    bundle.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
                y(bundle);
                return true;
            }
            av();
            return true;
        }
        if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
            bundle = new Bundle();
            bundle.putString("pwd", this.kIC);
            com.tencent.mm.pluginsdk.j.a.lxX.a(this.kIA.lVE == 1, false, bundle);
            switch (i2) {
                case 402:
                case 403:
                case 408:
                    String string;
                    bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                    this.kJl = this.uA;
                    this.kJl.putParcelable("key_pay_info", this.kIA);
                    this.kJl.putParcelable("key_bankcard", this.kFr);
                    if (!be.kS(this.kIC)) {
                        this.kJl.putString("key_pwd1", this.kIC);
                    }
                    this.kJl.putString("kreq_token", bVar.token);
                    this.kJl.putParcelable("key_authen", bVar.hdp);
                    this.kJl.putBoolean("key_need_verify_sms", !bVar.hdm);
                    this.kJl.putString("key_mobile", this.kFr.field_mobile);
                    this.kJl.putInt("key_err_code", i2);
                    this.kJl.putParcelable("key_orders", this.ith);
                    if (be.kS(str)) {
                        string = getString(2131236367, new Object[]{this.kFr.field_desc, this.kFr.field_mobile});
                    } else {
                        string = str;
                    }
                    g.b(this, string, "", getString(2131236366), getString(2131231010), new OnClickListener(this) {
                        final /* synthetic */ WalletPayUI kJM;

                        {
                            this.kJM = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.kJM.kJl.putInt("key_pay_flag", 3);
                            this.kJM.y(this.kJM.kJl);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ WalletPayUI kJM;

                        {
                            this.kJM = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (this.kJM.ayJ()) {
                                this.kJM.finish();
                            }
                        }
                    });
                    return true;
                case 404:
                    if (!(this.kFr == null || this.ith == null)) {
                        this.kFr.kNu = this.ith.fTG;
                        if (this.kFq == null || this.kFq.size() <= 1) {
                            c(true, 4, str);
                        } else {
                            d(true, 4, str);
                        }
                        return true;
                    }
                    break;
                case 100000:
                case 100001:
                    this.kIA.lVG = i2;
                    beX();
                    return true;
                case 100100:
                case 100101:
                    this.kIA.lVG = i2;
                    boolean z = false;
                    if (i2 == 100100) {
                        z = true;
                    }
                    if (this.kIE == null) {
                        this.kIE = new a(this, this);
                    }
                    this.kIE.b(z, this.kIA.bfq, this.kIA.fTG);
                    v.i("MicroMsg.WalletPayUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is " + z);
                    return true;
            }
        } else if (kVar instanceof d) {
            this.kJH = true;
            bfo();
            if (i2 == 416) {
                v.e("MicroMsg.WalletPayUI", "errCode is 416 need real name verify!");
                this.kJE = true;
                bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".pay.ui.WalletPayUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, i2, kVar, bundle, this.kIA != null ? this.kIA.bkq : 0);
            }
            v.i("MicroMsg.WalletPayUI", "errCode is %d , not need real name verify!", new Object[]{Integer.valueOf(i2)});
        }
        return false;
    }

    public final boolean ayM() {
        return false;
    }

    public final boolean Ox() {
        if (this.ith == null || this.ith.kPm == null || this.ith.kPm.size() <= 0) {
            v.w("MicroMsg.WalletPayUI", "mOrders info is Illegal!");
            g.a(this.nDR.nEl, 2131236242, 0, new OnClickListener(this) {
                final /* synthetic */ WalletPayUI kJM;

                {
                    this.kJM = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.kJM.finish();
                }
            });
            return false;
        } else if (!this.kJi || be.kS(this.kJj) || bfn() != null) {
            return true;
        } else {
            v.w("MicroMsg.WalletPayUI", "hy: should use given bankcard, but resolved as null. show error msg and quit");
            g.a(this.nDR.nEl, 2131236242, 0, new OnClickListener(this) {
                final /* synthetic */ WalletPayUI kJM;

                {
                    this.kJM = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.kJM.finish();
                }
            });
            return false;
        }
    }

    private Bankcard bfn() {
        com.tencent.mm.plugin.wallet.a.k.beN();
        ArrayList hk = com.tencent.mm.plugin.wallet.a.k.beO().hk(true);
        if (hk.size() != 0) {
            Iterator it = hk.iterator();
            while (it.hasNext()) {
                Bankcard bankcard = (Bankcard) it.next();
                if (be.ma(this.kJj).equals(bankcard.field_bindSerial)) {
                    v.i("MicroMsg.WalletPayUI", "hy: get given bankcard");
                    return bankcard;
                }
            }
        }
        return null;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.WalletPayUI", "onAcvityResult requestCode:" + i + ", resultCode:" + i2);
        switch (i) {
            case 0:
                if (i2 == -1) {
                    if (intent != null) {
                        this.kJG = intent.getIntExtra("auto_deduct_flag", -1);
                        this.ith.kPr.kJG = this.kJG;
                        bfp().lVI = this.kJG;
                        if (this.kJG == 1) {
                            bfp().lVJ = intent.getStringExtra("deduct_bank_type");
                            bfp().lVK = intent.getStringExtra("deduct_bind_serial");
                        }
                    }
                    this.kJF = true;
                    ayL();
                    return;
                }
                finish();
                return;
            default:
                return;
        }
    }

    protected final boolean ayL() {
        v.i("MicroMsg.WalletPayUI", "onProgressFinish isFromH5RealNameVerify %s", new Object[]{Boolean.valueOf(this.kJK)});
        com.tencent.mm.sdk.c.a.nhr.z(new qj());
        boolean z = (this.ith == null || this.ith.kPr == null || this.kJF) ? false : true;
        if (!z) {
            bfo();
        }
        if (this.kJK) {
            hg(true);
            return true;
        } else if (this.kJE) {
            return true;
        } else {
            if (z) {
                Intent intent = new Intent(this, WalletPayDeductUI.class);
                intent.putExtra("orders", this.ith);
                startActivityForResult(intent, 0);
                return true;
            } else if (this.nDR.dtW.getVisibility() == 0) {
                if (!(this.nDR.dtW.getVisibility() != 0 || this.ith == null || this.ith.kPr == null || !this.kIx.isEnabled() || this.kJI)) {
                    this.kIx.performClick();
                    this.kJI = true;
                }
                return false;
            } else if (this.kJm || !Ox()) {
                return true;
            } else {
                hg(true);
                this.kJm = true;
                return true;
            }
        }
    }

    public final boolean ayJ() {
        if (this.kJH) {
            String str = "MicroMsg.WalletPayUI";
            String str2 = "case 1 %s,";
            Object[] objArr = new Object[1];
            boolean z = bfp() == null || !bfp().lVz;
            objArr[0] = Boolean.valueOf(z);
            v.d(str, str2, objArr);
            str = "MicroMsg.WalletPayUI";
            str2 = "case 2 %s,";
            objArr = new Object[1];
            com.tencent.mm.plugin.wallet.a.k.beN();
            if (com.tencent.mm.plugin.wallet.a.k.beO().bgv()) {
                z = false;
            } else {
                z = true;
            }
            objArr[0] = Boolean.valueOf(z);
            v.d(str, str2, objArr);
            str = "MicroMsg.WalletPayUI";
            str2 = "case 3 mBankcardList %s, mDefaultBankcard %s";
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.kFq == null ? 0 : this.kFq.size());
            objArr[1] = this.kFr == null ? "" : this.kFr.field_forbidWord;
            v.d(str, str2, objArr);
            if (bfp() == null || !bfp().lVz) {
                v.i("MicroMsg.WalletPayUI", "get isTransparent1");
                return false;
            }
            com.tencent.mm.plugin.wallet.a.k.beN();
            if (!com.tencent.mm.plugin.wallet.a.k.beO().bgv()) {
                v.i("MicroMsg.WalletPayUI", "get isTransparent2");
                return false;
            } else if (this.kFq == null || (this.kFq.size() != 0 && (this.kFr == null || be.kS(this.kFr.field_forbidWord)))) {
                v.i("MicroMsg.WalletPayUI", "get isTransparent4");
                return true;
            } else {
                str = "MicroMsg.WalletPayUI";
                str2 = "get isTransparent3 1 %s 2 %s";
                objArr = new Object[2];
                z = this.kFq != null && this.kFq.size() == 0;
                objArr[0] = Boolean.valueOf(z);
                z = (this.kFr == null || be.kS(this.kFr.field_forbidWord)) ? false : true;
                objArr[1] = Boolean.valueOf(z);
                v.i(str, str2, objArr);
                return false;
            }
        }
        v.i("MicroMsg.WalletPayUI", "get isTransparent5");
        return true;
    }

    private void bfo() {
        if (ayJ()) {
            oa(4);
        } else {
            oa(0);
        }
    }

    protected final boolean beY() {
        return true;
    }

    public final void nU(int i) {
        if (i == 0) {
            if (ayJ()) {
                finish();
            }
        } else if (i == 1) {
            beX();
        }
    }

    public void hh(boolean z) {
        com.tencent.mm.plugin.wallet.pay.a.a.b a = com.tencent.mm.plugin.wallet.pay.a.a.a(bfj(), this.ith, z);
        if (this.ith != null) {
            Bundle bundle = new Bundle();
            bundle.putString("key_reqKey", this.ith.fTG);
            if (this.ith.kPm != null && this.ith.kPm.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) this.ith.kPm.get(0)).eWA);
            }
            bundle.putLong("key_SessionId", this.kJy);
            a.mProcessName = "PayProcess";
            a.uA = bundle;
        }
        if (this.kIA != null) {
            if (this.kIA.bkq == 6 && this.kIA.lVy == 100) {
                a.cVh = 100;
            } else {
                a.cVh = this.kIA.bkq;
            }
        }
        j(a);
    }

    public final boolean beU() {
        return (this.kIA == null || this.kIA.bkq == 11) ? false : true;
    }

    public final PayInfo bfp() {
        if (this.kIA == null) {
            this.kIA = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
        }
        return this.kIA;
    }

    protected final int NO() {
        return 1;
    }

    public void y(Bundle bundle) {
        boolean z;
        this.kJh = true;
        if (this.ith != null) {
            bundle.putInt("key_support_bankcard", this.ith.kLu);
            bundle.putString("key_reqKey", this.ith.fTG);
            if (this.ith.kPm != null && this.ith.kPm.size() > 0) {
                bundle.putString("key_TransId", ((Commodity) this.ith.kPm.get(0)).eWA);
            }
            bundle.putLong("key_SessionId", this.kJy);
        }
        if (this.kIA != null) {
            bundle.putInt("key_scene", this.kIA.bkq);
        }
        String str = "key_is_oversea";
        if (bfk()) {
            z = false;
        } else {
            z = true;
        }
        bundle.putBoolean(str, z);
        bundle.putInt("is_deduct_open", this.kJG);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pay.b.class, bundle, null);
    }

    public final void a(boolean z, String str, String str2) {
        v.i("MicroMsg.WalletPayUI", "onGenFinish callback");
        if (z) {
            v.i("MicroMsg.WalletPayUI", "onGenFinish callback, result.isSuccess is true");
            this.kIA.bfs = str;
            this.kIA.bft = str2;
            hh(false);
            com.tencent.mm.plugin.wallet_core.d.c.bhu();
            return;
        }
        v.e("MicroMsg.WalletPayUI", "onGenFinish callback, result.isSuccess is false");
        hh(false);
        com.tencent.mm.plugin.wallet_core.d.c.bhu();
    }

    public void onPause() {
        super.onPause();
        if (this.kIF != null) {
            this.kIF.bgW();
        }
    }
}
