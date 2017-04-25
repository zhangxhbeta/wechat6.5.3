package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public abstract class a implements g {
    protected LayoutInflater CE;
    private final String TAG = "MicroMsg.CardWidgetCouponBase";
    protected b eBg;
    protected OnClickListener eFl;
    protected View eND;
    protected ImageView eNE;
    protected TextView eNF;
    protected Context mContext;

    protected abstract void acQ();

    protected abstract void acR();

    public a(Context context) {
        this.mContext = context;
    }

    public final void h(b bVar) {
        this.eBg = bVar;
    }

    public final View acN() {
        if (this.eBg == null || this.eBg.Zv() == null) {
            v.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
            return null;
        }
        int i;
        this.CE = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        LayoutInflater layoutInflater = this.CE;
        if (!this.eBg.Zd()) {
            if (this.eBg.Ze()) {
                i = 2130903264;
            } else if (this.eBg.Zc()) {
                i = 2130903235;
            } else if (this.eBg.Zf()) {
                i = 2130903218;
            } else if (this.eBg.Zg()) {
                i = 2130903229;
            }
            this.eND = layoutInflater.inflate(i, null);
            this.eNE = (ImageView) this.eND.findViewById(2131755763);
            this.eNF = (TextView) this.eND.findViewById(2131755419);
            acQ();
            acO();
            return this.eND;
        }
        i = 2130903213;
        this.eND = layoutInflater.inflate(i, null);
        this.eNE = (ImageView) this.eND.findViewById(2131755763);
        this.eNF = (TextView) this.eND.findViewById(2131755419);
        acQ();
        acO();
        return this.eND;
    }

    private void acO() {
        if (this.eBg == null || this.eBg.Zv() == null) {
            v.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
            return;
        }
        if (!be.kS(this.eBg.Zv().eBM)) {
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(2131493348);
            if (this.eBg.Za() && this.eBg.Zd()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(2131493346);
            } else if (this.eBg.Za() && this.eBg.Zc()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(2131493369);
            } else if (this.eBg.Za() && this.eBg.Ze()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(2131493381);
            } else if (this.eBg.Zg()) {
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize > 0) {
                k.a(this.eNE, this.eBg.Zv().eBM, dimensionPixelSize, 2130838736, true);
            }
        }
        if (!be.kS(this.eBg.Zv().eCD)) {
            this.eNF.setText(this.eBg.Zv().eCD);
        }
        acR();
    }

    protected final View acP() {
        return this.eND;
    }

    public final void release() {
        this.eFl = null;
        this.mContext = null;
    }

    public void jm(int i) {
    }

    public void cm(boolean z) {
    }

    public final void f(b bVar) {
        this.eBg = bVar;
        acO();
    }

    public void a(ShapeDrawable shapeDrawable) {
    }

    public void cn(boolean z) {
    }

    public void j(boolean z, boolean z2) {
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.eFl = onClickListener;
    }
}
