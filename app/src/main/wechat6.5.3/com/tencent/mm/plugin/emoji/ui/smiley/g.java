package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.d.m;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.v;
import java.util.ArrayList;
import java.util.HashMap;

public final class g extends v {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter";
    private f fkM;
    boolean fmG;
    private View fmH;
    private Context mContext;
    int mCount;

    class a {
        EmojiStoreV2SingleRecommendView fmJ;
        SmileySubGrid fmK;
        final /* synthetic */ g fmL;

        public a(g gVar, View view, com.tencent.mm.plugin.emoji.ui.smiley.f.a aVar) {
            this.fmL = gVar;
            switch (aVar) {
                case RECOMMEND:
                    this.fmJ = (EmojiStoreV2SingleRecommendView) view;
                    return;
                case DEFAULT:
                case EMOJI:
                    this.fmK = (SmileySubGrid) view.findViewById(2131759224);
                    return;
                default:
                    return;
            }
        }
    }

    public g(f fVar, Context context) {
        this.mContext = context;
        this.fkM = fVar;
    }

    public final View c(int i, View view) {
        a aVar;
        d jZ = this.fkM.jZ(i);
        String str = jZ.fdU;
        com.tencent.mm.plugin.emoji.ui.smiley.f.a aVar2 = "TAG_DEFAULT_TAB".equals(str) ? com.tencent.mm.plugin.emoji.ui.smiley.f.a.DEFAULT : (String.valueOf(com.tencent.mm.storage.a.a.nwK).equals(str) || String.valueOf(com.tencent.mm.storage.a.a.nwJ).equals(str)) ? com.tencent.mm.plugin.emoji.ui.smiley.f.a.EMOJI : !jZ.fkT ? com.tencent.mm.plugin.emoji.ui.smiley.f.a.RECOMMEND : com.tencent.mm.plugin.emoji.ui.smiley.f.a.EMOJI;
        a aVar3;
        if (view == null || view.getTag() == null || view.getTag(2131755072) != aVar2) {
            switch (aVar2) {
                case RECOMMEND:
                    view = new EmojiStoreV2SingleRecommendView(this.mContext, this.fkM.ahO());
                    break;
                case DEFAULT:
                case EMOJI:
                    view = LayoutInflater.from(this.mContext).inflate(2130904412, null);
                    break;
            }
            aVar3 = new a(this, view, aVar2);
            view.setTag(aVar3);
            view.setTag(2131755072, aVar2);
            aVar = aVar3;
        } else {
            aVar3 = (a) view.getTag();
            view.setTag(2131755072, aVar2);
            aVar = aVar3;
        }
        int i2;
        switch (aVar2) {
            case RECOMMEND:
                EmojiStoreV2SingleRecommendView emojiStoreV2SingleRecommendView = aVar.fmJ;
                emojiStoreV2SingleRecommendView.fdK = jZ.fdU;
                if (!be.kS(emojiStoreV2SingleRecommendView.fdK)) {
                    emojiStoreV2SingleRecommendView.fqh = com.tencent.mm.plugin.emoji.model.g.afx().fci.aI(emojiStoreV2SingleRecommendView.fdK, false);
                    emojiStoreV2SingleRecommendView.fiu.setOnClickListener(emojiStoreV2SingleRecommendView);
                    emojiStoreV2SingleRecommendView.fqf.setOnClickListener(emojiStoreV2SingleRecommendView);
                    emojiStoreV2SingleRecommendView.fqb.setOnClickListener(emojiStoreV2SingleRecommendView);
                    com.tencent.mm.storage.a.a aVar4 = emojiStoreV2SingleRecommendView.fqh;
                    if (emojiStoreV2SingleRecommendView.fqf != null) {
                        switch (aVar4.field_buttonType) {
                            case 1:
                                emojiStoreV2SingleRecommendView.fqf.setVisibility(0);
                                emojiStoreV2SingleRecommendView.fqf.setText(2131232376);
                                break;
                            case 2:
                                emojiStoreV2SingleRecommendView.fqf.setVisibility(0);
                                emojiStoreV2SingleRecommendView.fqf.setText(2131233835);
                                break;
                            default:
                                emojiStoreV2SingleRecommendView.fqf.setVisibility(8);
                                break;
                        }
                    }
                    if (!be.kS(aVar4.field_packName)) {
                        emojiStoreV2SingleRecommendView.fqd.setText(aVar4.field_packName);
                    }
                    if (emojiStoreV2SingleRecommendView.fqe != null) {
                        if (be.kS(aVar4.field_recommandWord)) {
                            emojiStoreV2SingleRecommendView.fqe.setVisibility(8);
                        } else {
                            emojiStoreV2SingleRecommendView.fqe.setVisibility(0);
                            emojiStoreV2SingleRecommendView.fqe.setText(aVar4.field_recommandWord);
                        }
                    }
                    emojiStoreV2SingleRecommendView.fqg.setVisibility(8);
                    n.GL().a(emojiStoreV2SingleRecommendView.fqh.field_BigIconUrl, emojiStoreV2SingleRecommendView.fqc, com.tencent.mm.plugin.emoji.d.g.b(emojiStoreV2SingleRecommendView.fdK, emojiStoreV2SingleRecommendView.fqh.field_BigIconUrl, new Object[0]));
                    break;
                }
                emojiStoreV2SingleRecommendView.fqb.setVisibility(8);
                break;
            case DEFAULT:
                com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a aVar5;
                b bVar = new b(this.mContext, this.fkM);
                aVar.fmK.setAdapter((ListAdapter) bVar);
                aVar.fmK.ahj();
                aVar.fmK.fkH = jZ.ahp();
                SmileyGrid smileyGrid = aVar.fmK;
                e eVar = jZ.fkN;
                if (eVar.fli == null) {
                    aVar5 = null;
                } else {
                    aVar5 = eVar.fli.aho();
                }
                smileyGrid.fkI = aVar5;
                aVar.fmK.setNumColumns(jZ.fkR);
                aVar.fmK.setColumnWidth(jZ.ahu());
                aVar.fmK.setScrollbarFadingEnabled(false);
                aVar.fmK.setVerticalScrollBarEnabled(false);
                aVar.fmK.setSelector(2130838689);
                aVar.fmK.setHorizontalScrollBarEnabled(false);
                aVar.fmK.setVerticalScrollBarEnabled(false);
                aVar.fmK.setLongClickable(false);
                aVar.fmK.ahj();
                i2 = this.fkM.rP(jZ.fdU).fkS;
                aVar.fmK.setPadding(0, i2 == 0 ? this.fkM.fme : i2, 0, 0);
                aVar.fmK.setVerticalSpacing(i2 / 2);
                aVar.fmK.f(jZ.getType(), i - jZ.fkP, jZ.fkO, jZ.ahs(), jZ.aht());
                aVar.fmK.fne = false;
                aVar.fmK.cVh = this.fkM.cVh;
                bVar.b(jZ.getType(), jZ.fkO, jZ.ahs(), jZ.aht(), i - jZ.fkP, jZ.fkQ, jZ.fkR);
                bVar.fkw = jZ.fdU;
                break;
            case EMOJI:
                c cVar = new c(this.mContext, this.fkM);
                aVar.fmK.setAdapter((ListAdapter) cVar);
                aVar.fmK.ahj();
                aVar.fmK.setNumColumns(jZ.fkR);
                aVar.fmK.setColumnWidth(jZ.ahu());
                aVar.fmK.setScrollbarFadingEnabled(false);
                aVar.fmK.setHorizontalScrollBarEnabled(false);
                aVar.fmK.setVerticalScrollBarEnabled(false);
                aVar.fmK.fkH = jZ.ahp();
                aVar.fmK.setFastScrollEnabled(false);
                aVar.fmK.fmY = jZ.fkN.fkY;
                aVar.fmK.ahj();
                i2 = this.fkM.rP(jZ.fdU).fkS;
                aVar.fmK.setPadding(0, i2 == 0 ? this.fkM.fme : i2, 0, 0);
                aVar.fmK.setVerticalSpacing(i2 / 2);
                aVar.fmK.fne = true;
                aVar.fmK.f(jZ.getType(), i - jZ.fkP, jZ.fkO, jZ.ahs(), jZ.aht());
                cVar.b(jZ.getType(), jZ.fkO, jZ.fkR * jZ.fkQ, jZ.aht(), i - jZ.fkP, jZ.fkQ, jZ.fkR);
                cVar.fkw = jZ.fdU;
                if (cVar.fkt != 23) {
                    if (cVar.fkt == 25) {
                        cVar.fjj = com.tencent.mm.plugin.emoji.model.g.afx().afi();
                        break;
                    }
                }
                m afx = com.tencent.mm.plugin.emoji.model.g.afx();
                String str2 = cVar.fkw;
                if (m.fcx == null) {
                    m.fcx = new HashMap();
                }
                if (m.fcu) {
                    m.fcx.clear();
                    m.fcu = false;
                }
                if (!m.fcx.containsKey(str2)) {
                    ak.yW();
                    if (c.isSDCardAvailable()) {
                        m.fcx.put(str2, (ArrayList) afx.fch.rj(str2));
                    }
                }
                cVar.fjj = (ArrayList) m.fcx.get(str2);
                break;
                break;
        }
        this.fmH = view;
        return view;
    }

    public final int getCount() {
        return this.mCount;
    }

    public final int j(Object obj) {
        if (!this.fmG) {
            return super.j(obj);
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "get item position always changed");
        return -2;
    }

    public final void ahR() {
        f fVar = this.fkM;
        this.mCount = fVar.fmj ? fVar.rP("TAG_DEFAULT_TAB").aht() : fVar.fmf;
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "refresh data mCount:%d", new Object[]{Integer.valueOf(this.mCount)});
    }
}
