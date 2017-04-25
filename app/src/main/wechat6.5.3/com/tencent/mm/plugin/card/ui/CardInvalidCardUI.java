package com.tencent.mm.plugin.card.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.j.a;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public class CardInvalidCardUI extends CardBaseUI {
    static /* synthetic */ LinkedList c(CardInvalidCardUI cardInvalidCardUI) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < cardInvalidCardUI.eAB.getCount(); i++) {
            CardInfo cardInfo = (CardInfo) cardInvalidCardUI.eAH.iQ(i);
            if (cardInfo != null) {
                linkedList.add(cardInfo.field_card_id);
            }
        }
        return linkedList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.NI();
    }

    protected final void NI() {
        super.NI();
    }

    protected final int YO() {
        return a.eDh;
    }

    protected final void YN() {
        vD(2131231634);
        a(0, getString(2131231596), new OnMenuItemClickListener(this) {
            final /* synthetic */ CardInvalidCardUI eKi;

            {
                this.eKi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                c.a(this.eKi, new c.a(this.eKi) {
                    final /* synthetic */ CardInvalidCardUI eKi;

                    {
                        this.eKi = r1;
                    }

                    public final void abK() {
                        this.eKi.eAF = true;
                        this.eKi.x(CardInvalidCardUI.c(this.eKi));
                    }
                });
                return true;
            }
        });
        if (this.eAB.getCount() > 0) {
            iT(true);
        } else {
            iT(false);
        }
    }

    protected final int getLayoutId() {
        return 2130903228;
    }

    public final void a(int i, int i2, String str, k kVar) {
        super.a(i, i2, str, kVar);
        if (i == 0 && i2 == 0 && (kVar instanceof n)) {
            if (this.eAF) {
                g.bf(this, getResources().getString(2131231598));
            } else {
                g.bf(this, getResources().getString(2131231610));
            }
        }
        this.eAF = false;
    }
}
