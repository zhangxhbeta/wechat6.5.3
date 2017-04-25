package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.a.a.c.a;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q;
import com.tencent.mm.v.e;

public class CardGiftReceiveUI extends MMActivity implements OnClickListener, e {
    private int cpq;
    private String cpr;
    private p dwg = null;
    private TextView eIJ;
    private CardGiftInfo eIP;
    private ScrollView eJg;
    private TextView eJh;
    private ImageView eJi;
    private TextView eJj;
    private TextView eJk;
    private TextView eJl;
    private LinearLayout eJm;
    private LinearLayout eJn;
    private LinearLayout eJo;
    private TextView eJp;
    private TextView eJq;
    private ImageView eJr;
    private TextView eJs;
    private ImageView eJt;
    private ImageView eJu;
    private TextView eJv;

    protected final int getLayoutId() {
        return 2130903222;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cpr = getIntent().getStringExtra("key_order_id");
        this.cpq = getIntent().getIntExtra("key_biz_uin", -1);
        this.eIP = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        v.i("MicroMsg.CardGiftReceiveUI", "onCreate, orderId:%s, bizUin:%s", new Object[]{this.cpr, Integer.valueOf(this.cpq)});
        NI();
        ak.vy().a(1165, this);
        if (this.eIP == null) {
            v.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo is null, sync GiftCard from serve");
            if (this.cpq == -1) {
                v.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, bizUin is -1, fail!");
                return;
            }
            if (this.cpr == null) {
                v.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo, orderId is null, fail");
            }
            v.e("MicroMsg.CardGiftReceiveUI", "doNetSceneGetCardGiftInfo");
            ak.vy().a(new com.tencent.mm.plugin.card.model.v(this.cpq, this.cpr), 0);
            this.dwg = g.a(this.nDR.nEl, getString(2131233521), true, new OnCancelListener(this) {
                final /* synthetic */ CardGiftReceiveUI eJw;

                {
                    this.eJw = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.eJw.dwg != null && this.eJw.dwg.isShowing()) {
                        this.eJw.dwg.dismiss();
                    }
                    if (this.eJw.nDR.dtW.getVisibility() == 8 || this.eJw.nDR.dtW.getVisibility() == 4) {
                        v.i("MicroMsg.CardGiftReceiveUI", "user cancel & finish");
                        this.eJw.finish();
                    }
                }
            });
            if (this.dwg != null) {
                this.dwg.show();
                return;
            }
            return;
        }
        aaI();
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(1165, this);
    }

    private void aaI() {
        if (this.eIP == null) {
            v.e("MicroMsg.CardGiftReceiveUI", "doUpdate due to cardGiftInfo is null!");
            return;
        }
        if (be.kS(this.eIP.eCs)) {
            this.eJi.setVisibility(8);
            v.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
        } else {
            a aVar = new a();
            aVar.cPv = com.tencent.mm.compatible.util.e.cnj;
            n.GM();
            aVar.cPN = null;
            aVar.cPu = i.pR(this.eIP.eCs);
            aVar.cPs = true;
            aVar.cPq = true;
            n.GL().a(this.eIP.eCs, this.eJi, aVar.GU());
        }
        if (be.kS(this.eIP.eCr)) {
            this.eJh.setVisibility(8);
            v.i("MicroMsg.CardGiftReceiveUI", "descIconUrl is null");
        } else {
            this.eJh.setVisibility(0);
            this.eJh.setText(this.eIP.eCr);
        }
        v.i("MicroMsg.CardGiftReceiveUI", "cardGiftInfo.descLayoutMode:%d", new Object[]{Integer.valueOf(this.eIP.eCt)});
        if (this.eIP.eCt == 1) {
            this.eJh.setText(this.eIP.eCr);
            this.eJj.setText(this.eIP.eCk);
            this.eJk.setText("¥" + this.eIP.eCl);
        } else if (this.eIP.eCt == 2) {
            this.eJh.setVisibility(8);
            this.eJj.setText(this.eIP.eCr);
            this.eJk.setText(this.eIP.eCk + "     ¥" + this.eIP.eCl);
        } else {
            this.eJh.setText(this.eIP.eCr);
            this.eJj.setText(this.eIP.eCk);
            this.eJk.setText("¥" + this.eIP.eCl);
        }
        this.eJl.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, this.eIP.bcB, this.eJl.getTextSize()));
        this.eJs.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, this.eIP.bmE, this.eJs.getTextSize()));
        if (be.kS(this.eIP.eCa)) {
            v.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is null");
        } else {
            int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(this, 20);
            int fromDPToPix2 = com.tencent.mm.bd.a.fromDPToPix(this, 3);
            a aVar2 = new a();
            aVar2.cPv = com.tencent.mm.compatible.util.e.cnj;
            n.GM();
            aVar2.cPN = null;
            aVar2.cPu = i.pR(this.eIP.eCa);
            aVar2.cPs = true;
            aVar2.cPP = true;
            aVar2.cPQ = (float) fromDPToPix2;
            aVar2.cPq = true;
            aVar2.cPz = fromDPToPix;
            aVar2.cPy = fromDPToPix;
            aVar2.cPI = new ColorDrawable(j.qv("#CCCCCC"));
            n.GL().a(this.eIP.eCa, this.eJr, aVar2.GU());
        }
        if (be.kS(this.eIP.eCj)) {
            v.i("MicroMsg.CardGiftReceiveUI", "cardLogoLUrl is null");
        } else {
            aVar = new a();
            aVar.cPv = com.tencent.mm.compatible.util.e.cnj;
            n.GM();
            aVar.cPN = null;
            aVar.cPu = i.pR(this.eIP.eCj);
            aVar.cPP = true;
            aVar.cPs = true;
            aVar.cPq = true;
            aVar.cPI = new ColorDrawable(j.qv("#CCCCCC"));
            n.GL().a(this.eIP.eCj, this.eJu, aVar.GU());
        }
        if (be.kS(this.eIP.eCi)) {
            v.i("MicroMsg.CardGiftReceiveUI", "cardBackgroundPicUrl is null");
        } else {
            aVar = new a();
            aVar.cPv = com.tencent.mm.compatible.util.e.cnj;
            n.GM();
            aVar.cPN = null;
            aVar.cPu = i.pR(this.eIP.eCi);
            aVar.cPs = true;
            aVar.cPq = true;
            aVar.cPI = new ColorDrawable(j.qv("#CCCCCC"));
            aVar.cPP = true;
            aVar.cPQ = (float) com.tencent.mm.bd.a.fromDPToPix(this, 8);
            n.GL().a(this.eIP.eCi, this.eJt, aVar.GU());
        }
        if (be.kS(this.eIP.coN)) {
            v.i("MicroMsg.CardGiftReceiveUI", "color is null");
        } else {
            k.a((MMActivity) this, j.qv(this.eIP.coN));
            this.eJg.setBackgroundColor(j.qv(this.eIP.coN));
        }
        if (be.kS(this.eIP.eCc)) {
            this.eJp.setVisibility(8);
            this.eJn.setVisibility(8);
            v.i("MicroMsg.CardGiftReceiveUI", "fromUserImgUrl is empty");
        } else {
            this.eJp.setVisibility(0);
            this.eJn.setVisibility(0);
        }
        if (be.kS(this.eIP.eCd)) {
            this.eJq.setVisibility(8);
            this.eJo.setVisibility(8);
            v.e("MicroMsg.CardGiftReceiveUI", "fromUserContentVideoUrl is empty!");
        } else {
            this.eJq.setVisibility(0);
            this.eJo.setVisibility(0);
        }
        if (be.kS(this.eIP.eCb)) {
            this.eJm.setVisibility(0);
            v.e("MicroMsg.CardGiftReceiveUI", "fromUserContent is empty!");
        } else {
            this.eJm.setVisibility(0);
            this.eIJ.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, this.eIP.eCb, this.eIJ.getTextSize()));
            this.eIJ.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                final /* synthetic */ CardGiftReceiveUI eJw;

                {
                    this.eJw = r1;
                }

                public final void onGlobalLayout() {
                    this.eJw.eIJ.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    if (this.eJw.eIJ.getLayout() != null) {
                        for (int i = 0; i < this.eJw.eIJ.getLineCount(); i++) {
                            int i2;
                            View inflate = q.em(this.eJw).inflate(2130903224, null, false);
                            this.eJw.eJm.addView(inflate);
                            TextView textView = (TextView) inflate.findViewById(2131755872);
                            String str = this.eJw.eIP.eCb;
                            if (i == 0) {
                                i2 = 0;
                            } else {
                                i2 = this.eJw.eIJ.getLayout().getLineEnd(i - 1);
                            }
                            textView.setText(str.substring(i2, this.eJw.eIJ.getLayout().getLineEnd(i)));
                        }
                        return;
                    }
                    v.e("MicroMsg.CardGiftReceiveUI", "onGlobalLayoutListener getLayout() is null");
                }
            });
        }
        if (be.kS(this.eIP.eCu)) {
            this.eJq.setText(2131231627);
            this.eJq.setText(2131231627);
        } else {
            this.eJq.setText(this.eIP.eCu);
            this.eJp.setText(this.eIP.eCu);
        }
        if (be.kS(this.eIP.eCm)) {
            this.eJv.setVisibility(8);
            return;
        }
        this.eJv.setVisibility(0);
        this.eJv.setText(this.eIP.eCm);
    }

    protected final void NI() {
        this.eJg = (ScrollView) findViewById(2131755845);
        this.eJh = (TextView) findViewById(2131755847);
        this.eJj = (TextView) findViewById(2131755850);
        this.eJi = (ImageView) findViewById(2131755849);
        this.eJk = (TextView) findViewById(2131755852);
        this.eJl = (TextView) findViewById(2131755855);
        this.eJm = (LinearLayout) findViewById(2131755856);
        this.eIJ = (TextView) findViewById(2131755846);
        this.eJn = (LinearLayout) findViewById(2131755857);
        this.eJo = (LinearLayout) findViewById(2131755859);
        this.eJp = (TextView) findViewById(2131755858);
        this.eJq = (TextView) findViewById(2131755860);
        this.eJo.setOnClickListener(this);
        this.eJn.setOnClickListener(this);
        if (VERSION.SDK_INT < 21) {
            this.eIJ.setPadding(0, 0, 0, 0);
        }
        this.eJr = (ImageView) findViewById(2131755861);
        this.eJs = (TextView) findViewById(2131755862);
        this.eJt = (ImageView) findViewById(2131755853);
        this.eJu = (ImageView) findViewById(2131755854);
        this.eJv = (TextView) findViewById(2131755863);
        k.a((MMActivity) this, getResources().getColor(2131689596));
        this.eJv.setOnClickListener(this);
        Fd("");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardGiftReceiveUI eJw;

            {
                this.eJw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eJw.finish();
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (this.dwg != null && this.dwg.isShowing()) {
            this.dwg.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.card.model.v) {
                v.i("MicroMsg.CardGiftReceiveUI", "card gift info cgi success!");
                this.eIP = ((com.tencent.mm.plugin.card.model.v) kVar).eDq;
                aaI();
            }
        } else if (kVar instanceof com.tencent.mm.plugin.card.model.v) {
            v.e("MicroMsg.CardGiftReceiveUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            c.a(this, str, true);
        }
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case 2131755857:
                if (!be.kS(this.eIP.eCc)) {
                    intent = new Intent(this, CardGiftImageUI.class);
                    intent.putExtra("key_gift_into", this.eIP);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                    com.tencent.mm.plugin.report.service.g.iuh.h(13866, new Object[]{Integer.valueOf(4), this.cpr, o.getString(this.cpq)});
                    return;
                }
                return;
            case 2131755859:
                if (!be.kS(this.eIP.eCd)) {
                    intent = new Intent(this, CardGiftVideoUI.class);
                    intent.putExtra("key_gift_into", this.eIP);
                    intent.putExtra("key_is_mute", false);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                    com.tencent.mm.plugin.report.service.g.iuh.h(13866, new Object[]{Integer.valueOf(3), this.cpr, o.getString(this.cpq)});
                    return;
                }
                return;
            case 2131755863:
                if (this.eIP != null && this.eIP.eCn) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(13866, new Object[]{Integer.valueOf(7), this.cpr, o.getString(this.cpq)});
                    intent = new Intent(this, CardHomePageUI.class);
                    intent.putExtra("key_home_page_from_scene", 2);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0, 0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
