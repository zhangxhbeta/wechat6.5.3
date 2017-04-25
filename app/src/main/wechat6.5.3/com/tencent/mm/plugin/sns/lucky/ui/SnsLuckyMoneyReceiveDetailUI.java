package com.tencent.mm.plugin.sns.lucky.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.ae.n;
import com.tencent.mm.plugin.luckymoney.c.e;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.g;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import java.util.List;

@a(3)
public class SnsLuckyMoneyReceiveDetailUI extends LuckyMoneyBaseUI {
    private TextView eWQ;
    private String ftu;
    ac handler = new ac();
    private View hdZ;
    private TextView hea;
    private View hec;
    private String hei;
    private final int hfg = 750;
    private final int hfh = 300;
    private k jaC;
    private e jgN;
    private ImageView jgO;
    private final int jgP = 5;
    private int jgQ = 5;
    Runnable jgR = new Runnable(this) {
        final /* synthetic */ SnsLuckyMoneyReceiveDetailUI jgS;

        {
            this.jgS = r1;
        }

        public final void run() {
        }
    };
    private String jgp;
    private aib jgr;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        this.hei = getIntent().getStringExtra("key_sendid");
        this.ftu = getIntent().getStringExtra("key_feedid");
        long j = ad.aSE().Bq(this.ftu).field_snsId;
        this.jaC = ad.aSE().dd(j);
        if (this.jaC != null) {
            azr aUp = this.jaC.aUp();
            if (aUp != null) {
                List list = aUp.mWq.mom;
                if (list.size() > 0) {
                    aib com_tencent_mm_protocal_c_aib = (aib) list.get(0);
                    this.jgp = com_tencent_mm_protocal_c_aib.glb;
                    this.jgr = com_tencent_mm_protocal_c_aib;
                }
            }
        }
        this.jgN = new e();
        try {
            this.jgN.az(getIntent().getByteArrayExtra("key_lucky_money_detail"));
        } catch (Exception e) {
            v.e("MicroMsg.SnsLuckyMoneyReceiveDetailUI", e.getMessage() + "detail is error");
        }
        v.i("MicroMsg.SnsLuckyMoneyReceiveDetailUI", "sendid=" + be.ma(this.hei) + ", feedId=" + be.d(Long.valueOf(j)));
        if (this.jgN == null || this.jgN.bst <= 0) {
            this.hea.setText("0.00");
            this.hdZ.setVisibility(8);
        } else {
            CharSequence m = com.tencent.mm.wallet_core.ui.e.m(((double) this.jgN.bst) / 100.0d);
            if (!be.kS(m)) {
                this.hea.setText(m);
            }
        }
        if (!(this.jgN == null || this.jgN.haR == null)) {
            this.eWQ.setText(this.jgN.haR);
        }
        if (be.kS(this.jgN.haR)) {
            v.e("MicroMsg.SnsLuckyMoneyReceiveDetailUI", "detail.changeWording is empty");
            this.hec.setVisibility(8);
        } else {
            this.hec.setVisibility(0);
            this.eWQ.setText(this.jgN.haR);
            if (this.jgN.haQ == 1) {
                this.eWQ.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ SnsLuckyMoneyReceiveDetailUI jgS;

                    {
                        this.jgS = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.pluginsdk.wallet.e.L(this.jgS.nDR.nEl, 1);
                        v.e("MicroMsg.SnsLuckyMoneyReceiveDetailUI", "detail.changeUrl is empty");
                    }
                });
            } else {
                v.e("MicroMsg.SnsLuckyMoneyReceiveDetailUI", "detail.jumpChange is false");
                this.eWQ.setTextColor(getResources().getColor(2131689852));
            }
        }
        if (!be.kS(this.jgp)) {
            c.a aVar = new c.a();
            com.tencent.mm.plugin.luckymoney.a.a.axz();
            aVar.cPv = com.tencent.mm.plugin.luckymoney.a.a.axB();
            aVar.cPs = true;
            aVar.cPO = true;
            aVar.cPP = false;
            aVar.cPA = false;
            n.GL().a(this.jgp, this.jgO, aVar.GU());
            this.jgO.setScaleType(ScaleType.CENTER_INSIDE);
        } else if (this.jgr != null) {
            String C = g.C(this.jgr);
            com.tencent.mm.sdk.platformtools.k.bw(this.jgO);
            this.jgO.setImageBitmap(d.decodeFile(C, null));
            this.jgO.setScaleType(ScaleType.CENTER_INSIDE);
        }
    }

    protected final void NI() {
        getWindow().setFlags(1024, 1024);
        this.nDR.bAj();
        this.nDR.dtW.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyReceiveDetailUI jgS;

            {
                this.jgS = r1;
            }

            public final void onClick(View view) {
                this.jgS.finish();
            }
        });
        this.jgO = (ImageView) findViewById(2131759399);
        this.hdZ = findViewById(2131757818);
        this.hea = (TextView) findViewById(2131757819);
        this.hec = findViewById(2131757821);
        this.eWQ = (TextView) findViewById(2131757823);
        this.nDR.dtW.setVisibility(0);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return 2130904470;
    }
}
