package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_payu.order.a.c;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class PayUMallOrderDetailUI extends WalletBaseUI {
    private String hKp = "";
    private TextView hfA;
    private TextView hfW;
    private TextView kZA;
    private TextView kZB;
    private TextView kZC;
    private amb kZq;
    private LinearLayout kZr;
    private LinearLayout kZs;
    private LinearLayout kZt;
    private LinearLayout kZu;
    private LinearLayout kZv;
    private LinearLayout kZw;
    private LinearLayout kZx;
    private TextView kZy;
    private TextView kZz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gQ(1520);
        this.hKp = this.uA.getString("key_trans_id");
        if (be.kS(this.hKp)) {
            v.e("MicroMsg.PayUMallOrderDetailUI", "hy: trans id is null");
            finish();
        }
        j(new c(this.hKp));
        this.kZr = (LinearLayout) findViewById(2131758510);
        this.kZs = (LinearLayout) findViewById(2131758512);
        this.kZt = (LinearLayout) findViewById(2131758514);
        this.kZu = (LinearLayout) findViewById(2131758516);
        this.kZv = (LinearLayout) findViewById(2131758522);
        this.kZw = (LinearLayout) findViewById(2131758518);
        this.kZx = (LinearLayout) findViewById(2131758520);
        this.kZy = (TextView) findViewById(2131758511);
        this.kZz = (TextView) findViewById(2131758513);
        this.kZA = (TextView) findViewById(2131758515);
        this.kZB = (TextView) findViewById(2131758517);
        this.hfA = (TextView) findViewById(2131758523);
        this.hfW = (TextView) findViewById(2131758519);
        this.kZC = (TextView) findViewById(2131758521);
        bhF();
    }

    private void bhF() {
        if (this.kZq != null) {
            if (be.kS(this.kZq.hNP)) {
                this.kZr.setVisibility(8);
            } else {
                this.kZr.setVisibility(0);
                this.kZy.setText(this.kZq.hNP);
            }
            if (be.kS(this.kZq.hOa)) {
                this.kZs.setVisibility(8);
            } else {
                this.kZs.setVisibility(0);
                this.kZz.setText(this.kZq.hOa);
            }
            if (be.kS(this.kZq.hNR)) {
                this.kZt.setVisibility(8);
            } else {
                this.kZt.setVisibility(0);
                this.kZA.setText(this.kZq.hNR);
            }
            if (be.kS(this.kZq.hNV)) {
                this.kZu.setVisibility(8);
            } else {
                this.kZu.setVisibility(0);
                this.kZB.setText(e.d(((double) this.kZq.mMU) / 100.0d, this.kZq.hNV));
            }
            if (this.kZq.hNS >= 0) {
                this.kZv.setVisibility(0);
                this.hfA.setText(e.yB(this.kZq.hNS));
            } else {
                this.kZv.setVisibility(8);
            }
            if (be.kS(this.kZq.hNT)) {
                this.kZw.setVisibility(8);
            } else {
                this.kZw.setVisibility(0);
                this.hfW.setText(this.kZq.hNT);
            }
            switch (this.kZq.hNX) {
                case 3:
                    this.kZC.setText(2131236002);
                    return;
                case 5:
                    this.kZC.setText(2131236207);
                    return;
                default:
                    this.kZC.setText(2131236373);
                    return;
            }
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (kVar instanceof c) {
            this.kZq = ((c) kVar).kZp;
            bhF();
        }
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        gR(1520);
    }

    protected final int getLayoutId() {
        return 2130904152;
    }
}
