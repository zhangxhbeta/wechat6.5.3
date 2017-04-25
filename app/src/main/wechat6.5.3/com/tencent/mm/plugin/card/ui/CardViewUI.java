package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.i;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.j.a;
import com.tencent.mm.plugin.card.model.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.axv;
import com.tencent.mm.protocal.c.jd;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import java.util.Collection;
import java.util.LinkedList;

public class CardViewUI extends CardBaseUI {
    private int aeu = 1;
    private String eHB = "";
    private LinkedList<jd> eHu = new LinkedList();
    private String eLX;
    private View eLY;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            v.e("MicroMsg.CardViewUI", "onCreate intent is null");
            finish();
            return;
        }
        this.aeu = intent.getIntExtra("view_type", 0);
        this.eLX = intent.getStringExtra("user_name");
        Object stringExtra = intent.getStringExtra("card_list");
        this.eHB = getIntent().getStringExtra("key_template_id");
        if (this.aeu == 0) {
            if (TextUtils.isEmpty(stringExtra)) {
                v.e("MicroMsg.CardViewUI", "oncreate card_list is empty");
                finish();
                return;
            }
            Collection qu = i.qu(stringExtra);
            if (qu != null && qu.size() > 0) {
                this.eHu.clear();
                this.eHu.addAll(qu);
            }
        }
        NI();
    }

    protected void onDestroy() {
        ak.vy().b(699, this);
        super.onDestroy();
    }

    protected final void YN() {
        int i;
        if (this.aeu == 0) {
            vD(2131231721);
        } else if (this.aeu == 1) {
            vD(2131231629);
        }
        ak.vy().a(699, this);
        if (this.aeu == 0) {
            cg(true);
            axv com_tencent_mm_protocal_c_axv = new axv();
            com_tencent_mm_protocal_c_axv.mVn = this.eHB;
            v.i("MicroMsg.CardViewUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[]{this.eHB});
            ak.vy().a(new p(this.eHu, com_tencent_mm_protocal_c_axv), 0);
            i = 2131231576;
        } else if (this.aeu == 1) {
            this.eLY = View.inflate(this, 2130903232, null);
            if (this.eAD != null) {
                this.eAD.addView(this.eLY);
            }
            i = 2131231701;
        } else {
            i = 2131231576;
        }
        findViewById(2131755890).setVisibility(8);
        ((TextView) findViewById(2131755726)).setText(i);
    }

    protected final int YO() {
        return a.eDi;
    }

    protected final BaseAdapter YP() {
        if (this.aeu == 0) {
            return new f(getApplicationContext());
        }
        return super.YP();
    }

    protected final boolean YR() {
        if (this.aeu == 1) {
            return false;
        }
        return super.YR();
    }

    protected final void b(b bVar) {
        if (this.aeu == 1) {
            a((CardInfo) bVar);
        } else {
            super.b(bVar);
        }
    }

    protected final void a(CardInfo cardInfo) {
        if (this.aeu == 1) {
            this.eAI = cardInfo;
            h(this.eLX, 1, true);
            return;
        }
        super.a(cardInfo);
        if (this.eAI != null) {
            g.iuh.h(11582, new Object[]{"OperGift", Integer.valueOf(4), Integer.valueOf(this.eAI.Zv().eBL), this.eAI.field_card_tp_id, this.eAI.field_card_id, this.eLX});
        }
    }

    protected final void a(b bVar) {
        if (this.aeu == 0) {
            af.aap().eAI = (CardInfo) bVar;
            Intent intent = new Intent(this, CardDetailUI.class);
            intent.putExtra("key_card_id", ((CardInfo) bVar).field_card_id);
            intent.putExtra("key_from_scene", 51);
            startActivity(intent);
            return;
        }
        super.a(bVar);
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        if (kVar instanceof p) {
            cg(false);
            if (i == 0 && i2 == 0) {
                Object obj = ((p) kVar).eDu;
                if (obj != null && obj.size() > 0) {
                    if (this.eAB instanceof f) {
                        f fVar = (f) this.eAB;
                        if (obj != null) {
                            fVar.eGh.clear();
                            fVar.eGh.addAll(obj);
                            fVar.eKk.clear();
                            while (i3 < obj.size()) {
                                fVar.eKk.add(new Boolean(true));
                                i3++;
                            }
                        }
                    }
                    this.eAB.notifyDataSetChanged();
                    return;
                }
                return;
            }
            c.b(this, str, i2);
            return;
        }
        super.a(i, i2, str, kVar);
    }
}
