package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.sdk.platformtools.be;
import java.util.LinkedList;

public final class j implements c {
    private BaseAdapter eGK;
    private int eGO;
    protected LinkedList<CardTagTextView> eGS = new LinkedList();
    private int eLO;
    int eLP;
    int eLQ;
    private Context mContext;

    public class a {
        public RelativeLayout eGW;
        public ImageView eGX;
        public TextView eGY;
        public TextView eGZ;
        public TextView eHc;
        public ImageView eLR;
        public LinearLayout eLS;
        public ImageView eLT;
        public ImageView eLU;
        public ImageView eLV;
        final /* synthetic */ j eLW;
        public View eLc;
        public ImageView eLd;

        public a(j jVar) {
            this.eLW = jVar;
        }
    }

    public j(Context context, BaseAdapter baseAdapter) {
        this.mContext = context;
        this.eGK = baseAdapter;
        this.eLO = this.mContext.getResources().getDimensionPixelSize(2131493203);
        this.eGO = this.mContext.getResources().getDimensionPixelSize(2131493152);
        this.eLP = this.mContext.getResources().getDimensionPixelOffset(2131493354);
        this.eLQ = this.mContext.getResources().getDimensionPixelOffset(2131493355);
    }

    public final void release() {
        this.mContext = null;
        this.eGK = null;
        if (this.eGS != null) {
            this.eGS.clear();
        }
    }

    public final View a(int i, View view, b bVar) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.mContext, 2130903230, null);
            a aVar2 = new a(this);
            aVar2.eGW = (RelativeLayout) view.findViewById(2131755711);
            aVar2.eGX = (ImageView) view.findViewById(2131755713);
            aVar2.eLc = view.findViewById(2131755908);
            aVar2.eLd = (ImageView) view.findViewById(2131755909);
            aVar2.eGY = (TextView) view.findViewById(2131755714);
            aVar2.eGZ = (TextView) view.findViewById(2131755716);
            aVar2.eHc = (TextView) view.findViewById(2131755720);
            aVar2.eLR = (ImageView) view.findViewById(2131755911);
            aVar2.eLT = (ImageView) view.findViewById(2131755905);
            aVar2.eLU = (ImageView) view.findViewById(2131755906);
            aVar2.eLV = (ImageView) view.findViewById(2131755907);
            aVar2.eLS = (LinearLayout) view.findViewById(2131755910);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.eGK.getItem(i) instanceof CardInfo) {
            CardInfo cardInfo = (CardInfo) this.eGK.getItem(i);
            Object obj = null;
            if (cardInfo.field_stickyIndex % 10 != 0 && cardInfo.field_stickyIndex > 0) {
                obj = 1;
            }
            if (obj != null) {
                CharSequence charSequence;
                View cardTagTextView;
                for (int i2 = 0; i2 < aVar.eLS.getChildCount(); i2++) {
                    this.eGS.add((CardTagTextView) aVar.eLS.getChildAt(i2));
                }
                aVar.eLS.removeAllViews();
                Context context = this.mContext;
                Object string;
                switch (cardInfo.field_stickyIndex % 10) {
                    case 0:
                        string = context.getString(2131231713);
                        break;
                    case 1:
                        string = context.getString(2131231712);
                        break;
                    case 2:
                        string = context.getString(2131231711);
                        break;
                    case 3:
                        string = context.getString(2131231710);
                        break;
                    default:
                        charSequence = null;
                        break;
                }
                aVar.eLS.setVisibility(0);
                if (this.eGS.size() == 0) {
                    cardTagTextView = new CardTagTextView(this.mContext);
                } else {
                    CardTagTextView cardTagTextView2 = (CardTagTextView) this.eGS.removeFirst();
                }
                cardTagTextView.setPadding(this.eGO, this.eLO, this.eGO, this.eLO);
                cardTagTextView.setGravity(17);
                cardTagTextView.setMinWidth(this.mContext.getResources().getDimensionPixelSize(2131493360));
                cardTagTextView.setMinHeight(this.mContext.getResources().getDimensionPixelSize(2131493359));
                if (cardInfo.Zc()) {
                    cardTagTextView.setTextColor(com.tencent.mm.bd.a.b(this.mContext, 2131690127));
                    cardTagTextView.fillColor = com.tencent.mm.bd.a.b(this.mContext, 2131689600);
                } else {
                    cardTagTextView.setTextColor(com.tencent.mm.bd.a.b(this.mContext, 2131689819));
                    cardTagTextView.fillColor = 0;
                }
                cardTagTextView.setText(charSequence);
                cardTagTextView.setTextSize(1, 10.0f);
                aVar.eLS.addView(cardTagTextView);
            } else {
                aVar.eLS.setVisibility(8);
            }
        }
        if (bVar.Zh()) {
            ImageView imageView;
            aVar.eGX.setVisibility(0);
            aVar.eGZ.setVisibility(0);
            aVar.eHc.setVisibility(8);
            aVar.eGY.setVisibility(0);
            aVar.eGY.setText(bVar.Zv().eCD);
            aVar.eGZ.setText(bVar.Zv().title);
            if (bVar.Ze()) {
                aVar.eLc.setVisibility(0);
                aVar.eGX.setVisibility(4);
                imageView = aVar.eLd;
                if (TextUtils.isEmpty(bVar.Zv().mkV)) {
                    k.a(imageView, 2130837885, com.tencent.mm.plugin.card.b.j.qv(bVar.Zv().coN));
                } else {
                    k.a(this.mContext, imageView, bVar.Zv().mkV, this.mContext.getResources().getDimensionPixelSize(2131493362), com.tencent.mm.plugin.card.b.j.qv(bVar.Zv().coN));
                }
            } else {
                aVar.eLc.setVisibility(8);
                aVar.eGX.setVisibility(0);
                k.a(aVar.eGX, bVar.Zv().eBM, this.mContext.getResources().getDimensionPixelSize(2131493362), 2130838736, true);
            }
            if (bVar.Zc()) {
                if (be.kS(bVar.Zw().mky)) {
                    aVar.eGW.setBackgroundDrawable(com.tencent.mm.plugin.card.b.j.bs(com.tencent.mm.plugin.card.b.j.qv(bVar.Zv().coN), this.eLP));
                    aVar.eLT.setVisibility(8);
                    aVar.eLU.setVisibility(8);
                    aVar.eLV.setVisibility(0);
                } else {
                    aVar.eGW.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130837854));
                    aVar.eLT.setVisibility(0);
                    aVar.eLU.setVisibility(0);
                    imageView = aVar.eLT;
                    String str = bVar.Zw().mky;
                    com.tencent.mm.ae.a.a.c.a aVar3 = new com.tencent.mm.ae.a.a.c.a();
                    aVar3.cPv = e.cnj;
                    n.GM();
                    aVar3.cPN = null;
                    aVar3.cPu = i.pR(str);
                    aVar3.cPs = true;
                    aVar3.cPR = true;
                    aVar3.cPq = true;
                    aVar3.cPH = 2130837854;
                    n.GL().a(str, imageView, aVar3.GU());
                    imageView.setImageMatrix(new Matrix());
                    aVar.eLV.setVisibility(8);
                }
                aVar.eGY.setTextColor(this.mContext.getResources().getColor(2131690127));
                aVar.eGZ.setTextColor(this.mContext.getResources().getColor(2131690127));
            } else {
                aVar.eLV.setVisibility(8);
                aVar.eLT.setVisibility(8);
                aVar.eLU.setVisibility(8);
                aVar.eGW.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130837854));
                aVar.eGZ.setTextColor(this.mContext.getResources().getColor(2131689589));
                aVar.eGY.setTextColor(this.mContext.getResources().getColor(2131689589));
            }
        } else {
            aVar.eGX.setVisibility(8);
            aVar.eGZ.setVisibility(8);
            aVar.eGY.setVisibility(8);
            aVar.eLS.setVisibility(8);
            aVar.eHc.setVisibility(0);
            aVar.eGW.setBackgroundDrawable(com.tencent.mm.plugin.card.b.j.bs(this.mContext.getResources().getColor(2131689599), this.eLP));
            aVar.eHc.setText(this.mContext.getResources().getString(2131231661));
        }
        int i3 = bVar.Zv().eBL;
        LayoutParams layoutParams;
        if (i != this.eGK.getCount() - 1 || aVar.eGW == null) {
            layoutParams = (LayoutParams) aVar.eGW.getLayoutParams();
            if (layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                aVar.eGW.setLayoutParams(layoutParams);
            }
        } else {
            layoutParams = (LayoutParams) aVar.eGW.getLayoutParams();
            if (layoutParams.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(2131493144)) {
                layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(2131493144);
                aVar.eGW.setLayoutParams(layoutParams);
            }
        }
        return view;
    }

    public final void q(View view, int i) {
        ((a) view.getTag()).eLR.setImageResource(i);
    }

    public final void r(View view, int i) {
        ((a) view.getTag()).eLR.setVisibility(i);
    }

    public final void a(View view, int i, OnClickListener onClickListener) {
        a aVar = (a) view.getTag();
        aVar.eLR.setTag(Integer.valueOf(i));
        aVar.eLR.setOnClickListener(onClickListener);
    }
}
