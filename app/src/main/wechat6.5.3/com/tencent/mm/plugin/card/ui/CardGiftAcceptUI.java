package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.k.3;
import com.tencent.mm.plugin.card.model.ab;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

@a(3)
public class CardGiftAcceptUI extends MMActivity implements OnClickListener, e {
    private final String TAG = "MicroMsg.CardGiftAcceptUI";
    private String bmE;
    private int cpq;
    private String cpr;
    private p dwg = null;
    private RelativeLayout eIG;
    private ImageView eIH;
    private TextView eII;
    private TextView eIJ;
    private TextView eIK;
    private ImageView eIL;
    private ab eIM;
    private m eIN;

    protected final int getLayoutId() {
        return 2130903220;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cpr = getIntent().getStringExtra("key_order_id");
        this.cpq = getIntent().getIntExtra("key_biz_uin", -1);
        this.bmE = getIntent().getStringExtra("key_from_user_name");
        v.i("MicroMsg.CardGiftAcceptUI", "onCreate, orderId:%s, bizUin:%s, fromUserName:%s", new Object[]{this.cpr, Integer.valueOf(this.cpq), this.bmE});
        if (this.cpq == -1) {
            v.e("MicroMsg.CardGiftAcceptUI", "bizUin is -1, fail!");
            c.a(this, "", true);
        } else if (this.cpr == null) {
            v.e("MicroMsg.CardGiftAcceptUI", "orderId is null, fail");
            c.a(this, "", true);
        } else {
            if (!be.kS(this.bmE)) {
                g.iuh.h(13866, new Object[]{Integer.valueOf(1), this.cpr, o.getString(this.cpq), this.bmE});
            }
            NI();
            ak.vy().a(1171, this);
            ak.vy().a(1136, this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(1171, this);
        ak.vy().b(1136, this);
    }

    protected final void NI() {
        this.eIG = (RelativeLayout) findViewById(2131755835);
        this.eIH = (ImageView) findViewById(2131755836);
        this.eII = (TextView) findViewById(2131755837);
        this.eIJ = (TextView) findViewById(2131755838);
        this.eIK = (TextView) findViewById(2131755839);
        this.eIL = (ImageView) findViewById(2131755840);
        this.eIL.setOnClickListener(this);
        this.nDR.dtW.setVisibility(8);
        this.dwg = com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131233521), true, new OnCancelListener(this) {
            final /* synthetic */ CardGiftAcceptUI eIO;

            {
                this.eIO = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.eIO.dwg != null && this.eIO.dwg.isShowing()) {
                    this.eIO.dwg.dismiss();
                }
                v.i("MicroMsg.CardGiftAcceptUI", "user cancel & finish");
                this.eIO.finish();
            }
        });
        ak.vy().a(new ab(this.cpq, this.cpr), 0);
        if (this.dwg != null) {
            this.dwg.show();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case 2131755839:
                abD();
                if (!be.kS(this.bmE)) {
                    g.iuh.h(13866, new Object[]{Integer.valueOf(2), this.cpr, o.getString(this.cpq), this.bmE});
                    return;
                }
                return;
            case 2131755840:
                finish();
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            if (this.dwg != null && this.dwg.isShowing()) {
                this.dwg.dismiss();
            }
            if (kVar instanceof ab) {
                v.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                c.a(this, str, true);
            } else if (kVar instanceof m) {
                v.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                c.a(this, str, true);
            }
        } else if (kVar instanceof ab) {
            this.eIM = (ab) kVar;
            v.i("MicroMsg.CardGiftAcceptUI", "ignore:%b", new Object[]{Boolean.valueOf(this.eIM.eDG)});
            if (this.eIM.eDG) {
                v.i("MicroMsg.CardGiftAcceptUI", "NetScenePreAcceptGiftCard ignore is true~so ignore it");
                abD();
                return;
            }
            if (this.dwg != null && this.dwg.isShowing()) {
                this.dwg.dismiss();
            }
            if (this.eIM == null) {
                v.e("MicroMsg.CardGiftAcceptUI", "preAcceptGiftCard is null");
            } else {
                this.eIJ.setText(this.eIM.content);
                this.eII.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, this.eIM.bmE, this.eII.getTextSize()));
                if (this.eIM.status == 0) {
                    if (be.kS(this.eIM.eDF)) {
                        this.eIK.setVisibility(0);
                        this.eIK.setText(getResources().getString(2131231624));
                        this.eIK.setOnClickListener(this);
                    } else {
                        this.eIK.setVisibility(0);
                        this.eIK.setText(this.eIM.eDF);
                        this.eIK.setOnClickListener(this);
                    }
                } else if (this.eIM.status == 1 || this.eIM.status != 2) {
                    this.eIK.setVisibility(8);
                    this.eIK.setOnClickListener(null);
                } else if (be.kS(this.eIM.eDF)) {
                    this.eIK.setVisibility(8);
                    this.eIK.setOnClickListener(null);
                } else {
                    this.eIK.setVisibility(0);
                    this.eIK.setBackgroundDrawable(null);
                    this.eIK.setText(this.eIM.eDF);
                    this.eIK.setTextColor(getResources().getColor(2131690127));
                    this.eIK.setTextSize(1, 17.0f);
                    this.eIK.setOnClickListener(null);
                }
                if (!be.kS(this.eIM.eDE)) {
                    int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(this, 15);
                    com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
                    aVar.cPv = com.tencent.mm.compatible.util.e.cnj;
                    n.GM();
                    aVar.cPN = null;
                    aVar.cPu = i.pR(this.eIM.eDE);
                    aVar.cPs = true;
                    aVar.cPP = true;
                    aVar.cPQ = (float) fromDPToPix;
                    aVar.cPq = true;
                    aVar.cPH = 2130838736;
                    n.GL().a(this.eIM.eDE, this.eIH, aVar.GU());
                }
                if (!be.kS(this.eIM.dCB)) {
                    this.eIG.setBackgroundDrawable(j.bs(j.qv(this.eIM.dCB), com.tencent.mm.bd.a.fromDPToPix(this, 5)));
                }
            }
            View view = this.eIG;
            Animation scaleAnimation = new ScaleAnimation(0.0f, 0.96f, 0.0f, 0.96f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300);
            scaleAnimation.setInterpolator(new OvershootInterpolator());
            scaleAnimation.setFillAfter(true);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.96f, 1.0f, 0.96f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(100);
            scaleAnimation2.setFillAfter(true);
            scaleAnimation.setAnimationListener(new 3(view, scaleAnimation2));
            if (view != null) {
                view.startAnimation(scaleAnimation);
            }
            this.nDR.dtW.setVisibility(0);
        } else if (kVar instanceof m) {
            if (this.dwg != null && this.dwg.isShowing()) {
                this.dwg.dismiss();
            }
            v.i("MicroMsg.CardGiftAcceptUI", "accept gift card is success!");
            this.eIN = (m) kVar;
            Intent intent = new Intent(this, CardGiftReceiveUI.class);
            intent.putExtra("key_order_id", this.cpr);
            intent.putExtra("key_biz_uin", this.cpq);
            intent.putExtra("key_gift_into", this.eIN.eDq);
            startActivity(intent);
            finish();
        }
    }

    private void abD() {
        ak.vy().a(new m(this.cpq, this.cpr), 0);
        if (this.dwg != null) {
            this.dwg.show();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            v.e("MicroMsg.CardGiftAcceptUI", "onKeyDown finishUI");
            if (this.dwg != null && this.dwg.isShowing()) {
                this.dwg.dismiss();
            }
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
