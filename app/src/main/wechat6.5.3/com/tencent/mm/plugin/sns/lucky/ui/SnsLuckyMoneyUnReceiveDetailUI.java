package com.tencent.mm.plugin.sns.lucky.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.c.e;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import java.util.List;

@a(3)
public class SnsLuckyMoneyUnReceiveDetailUI extends LuckyMoneyBaseUI {
    private String bZy;
    private Button fpp;
    private String ftu;
    private String hei;
    private final int hfg = 750;
    private final int hfh = 300;
    private e jgN;
    private ImageView jgO;
    private TextView jgU;
    private TextView jgV;
    private ImageView jgW;
    private TextView jgX;
    private String jgp;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        this.hei = getIntent().getStringExtra("key_sendid");
        this.ftu = getIntent().getStringExtra("key_feedid");
        this.bZy = getIntent().getStringExtra("key_username");
        v.i("MicroMsg.SnsLuckyMoneyUnReceiveDetailUI", "mSnsLocalId " + this.ftu);
        k Bq = ad.aSE().Bq(this.ftu);
        if (Bq != null) {
            azr aUp = Bq.aUp();
            if (aUp != null) {
                List list = aUp.mWq.mom;
                if (list.size() > 0) {
                    this.jgp = ((aib) list.get(0)).glb;
                }
            }
        }
        this.jgN = new e();
        try {
            this.jgN.az(getIntent().getByteArrayExtra("key_lucky_money_detail"));
        } catch (Exception e) {
            v.e("MicroMsg.SnsLuckyMoneyUnReceiveDetailUI", e.getMessage() + "detail is error");
        }
        v.i("MicroMsg.SnsLuckyMoneyUnReceiveDetailUI", "sendid=" + be.ma(this.hei) + ", feedId=" + be.d(Long.valueOf(Bq != null ? Bq.field_snsId : 0)));
        k Bq2 = ad.aSE().Bq(this.ftu);
        if (Bq2 != null) {
            aic aUD = Bq2.aUD();
            if (aUD == null || !(aUD.hav == 0 || aUD.hav == 2)) {
                this.fpp.setVisibility(8);
                this.jgU.setVisibility(8);
                this.jgV.setVisibility(8);
                this.jgW.setVisibility(0);
                this.jgX.setVisibility(0);
                return;
            }
            this.fpp.setVisibility(0);
            this.jgU.setVisibility(0);
            this.jgV.setVisibility(0);
            this.jgW.setVisibility(8);
            this.jgX.setVisibility(8);
            return;
        }
        this.fpp.setVisibility(8);
        this.jgU.setVisibility(8);
        this.jgV.setVisibility(8);
        this.jgW.setVisibility(0);
        this.jgX.setVisibility(0);
    }

    protected final void NI() {
        getWindow().setFlags(1024, 1024);
        this.nDR.bAj();
        this.jgO = (ImageView) findViewById(2131759399);
        this.jgU = (TextView) findViewById(2131759404);
        this.nDR.dtW.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyUnReceiveDetailUI jgY;

            {
                this.jgY = r1;
            }

            public final void onClick(View view) {
                this.jgY.finish();
            }
        });
        this.fpp = (Button) findViewById(2131759405);
        this.jgV = (TextView) findViewById(2131759403);
        this.jgW = (ImageView) findViewById(2131759401);
        this.jgX = (TextView) findViewById(2131759402);
        this.jgW.setVisibility(8);
        this.jgX.setVisibility(8);
        this.fpp.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyUnReceiveDetailUI jgY;

            {
                this.jgY = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.jgY.nDR.nEl, SnsLuckyMoneyNewYearSendUI.class);
                intent.putExtra("key_way", 2);
                intent.putExtra("key_username", this.jgY.bZy);
                intent.putExtra("key_sendid", this.jgY.hei);
                intent.putExtra("key_feedid", this.jgY.ftu);
                this.jgY.nDR.nEl.startActivityForResult(intent, 1);
            }
        });
        this.nDR.dtW.setVisibility(0);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return 2130904471;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    k Bq = ad.aSE().Bq(this.ftu);
                    if (Bq != null) {
                        aic aUD = Bq.aUD();
                        if (aUD != null) {
                            aUD.hav = 4;
                            try {
                                Bq.field_postBuf = aUD.toByteArray();
                                ad.aSE().b(Bq.field_snsId, Bq);
                            } catch (Exception e) {
                                v.e("MicroMsg.SnsLuckyMoneyUnReceiveDetailUI", e.getMessage() + "SnsInfo Storage the hbstatus error");
                            }
                        }
                    }
                    finish();
                    Intent intent2 = new Intent();
                    intent2.setClass(this.nDR.nEl, SnsLuckyMoneyReceiveDetailUI.class);
                    intent2.putExtra("key_username", this.bZy);
                    intent2.putExtra("key_sendid", this.hei);
                    intent2.putExtra("key_feedid", this.ftu);
                    try {
                        intent2.putExtra("key_lucky_money_detail", this.jgN.toByteArray());
                    } catch (Exception e2) {
                        v.e("MicroMsg.SnsLuckyMoneyUnReceiveDetailUI", e2.getMessage() + "detail is error");
                    }
                    startActivity(intent2);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
