package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ae.a.a.c.a;
import com.tencent.mm.ae.n;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.sdk.platformtools.v;

public final class e extends a {
    protected TextView dtY;
    private LinearLayout eFv;
    private RelativeLayout eNZ;
    private TextView eOa;
    private View eOb;
    private ImageView eOc;
    private ImageView eOd;
    private ImageView eOe;
    private ImageView eOf;
    private ImageView eOg;

    public e(Context context) {
        super(context);
    }

    protected final void acQ() {
        this.dtY = (TextView) acP().findViewById(2131755917);
        this.eNZ = (RelativeLayout) acP().findViewById(2131755914);
        this.eFv = (LinearLayout) acP().findViewById(2131755919);
        this.eOa = (TextView) acP().findViewById(2131755756);
        this.eOb = acP().findViewById(2131755918);
        this.eOc = (ImageView) acP().findViewById(2131755788);
        this.eOd = (ImageView) this.eND.findViewById(2131755921);
        this.eOe = (ImageView) this.eND.findViewById(2131755920);
        this.eOf = (ImageView) this.eND.findViewById(2131755915);
        this.eOg = (ImageView) this.eND.findViewById(2131755916);
    }

    protected final void acR() {
        if (this.eNF != null) {
            this.eNF.setText(this.eBg.Zv().eCD);
        }
        if (this.eBg.Zv().mkN != null && this.eBg.Zv().mkN.size() > 0) {
            ld ldVar = (ld) this.eBg.Zv().mkN.get(0);
            if (TextUtils.isEmpty(ldVar.title)) {
                this.dtY.setText("");
            } else {
                this.dtY.setText(ldVar.title);
            }
        }
        if (this.eBg.Zr()) {
            cm(true);
            this.eOf.setAlpha(255);
            if (this.eOf.getBackground() != null) {
                this.eOf.getBackground().setAlpha(255);
            }
            String str = this.eBg.Zw().code;
            if (!TextUtils.isEmpty(str)) {
                this.eOb.setOnClickListener(this.eFl);
                this.eOc.setOnClickListener(this.eFl);
                this.eOa.setOnClickListener(this.eFl);
                switch (this.eBg.Zw().mkn) {
                    case 0:
                        if (str.length() > 40) {
                            this.eOa.setText("");
                            break;
                        } else {
                            this.eOa.setText(k.qD(str));
                            break;
                        }
                    case 1:
                    case 2:
                        if (str.length() <= 40) {
                            if (!this.eBg.Zk()) {
                                this.eOa.setText("");
                                break;
                            } else {
                                this.eOa.setText(k.qD(str));
                                break;
                            }
                        }
                        this.eOa.setText("");
                        break;
                    default:
                        break;
                }
            }
            v.e("MicroMsg.CardWidgetMembership", "don't updateCodeLayout, code is empty!");
            cm(false);
        } else {
            this.eOa.setText("");
            this.eOc.setVisibility(8);
            this.eOb.setVisibility(8);
            this.eOf.setAlpha(90);
            if (this.eOf.getBackground() != null) {
                this.eOf.getBackground().setAlpha(90);
            }
        }
        LayoutParams layoutParams = this.eNZ.getLayoutParams();
        layoutParams.height = ((this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mContext.getResources().getDimensionPixelSize(2131493138) * 2)) * 3) / 5;
        v.d("MicroMsg.CardWidgetMembership", "padding:%d,originWidth:%d,targetWidth:%d", new Object[]{Integer.valueOf(r1), Integer.valueOf(r2), Integer.valueOf(r3)});
        this.eNZ.setLayoutParams(layoutParams);
    }

    public final void j(boolean z, boolean z2) {
    }

    public final void cm(boolean z) {
        if (TextUtils.isEmpty(this.eBg.Zw().code) || !z || this.eBg.Zw().mkn == 0) {
            this.eOc.setVisibility(8);
            this.eOb.setVisibility(8);
            return;
        }
        this.eOc.setVisibility(0);
        this.eOb.setVisibility(0);
    }

    public final void jm(int i) {
        if (!TextUtils.isEmpty(this.eBg.Zw().mky)) {
            this.eOf.setBackgroundDrawable(null);
            this.eOg.setVisibility(0);
            acV();
        } else if (this.eND != null) {
            this.eOf.setBackgroundResource(i);
            this.eOg.setVisibility(8);
        }
    }

    public final void a(ShapeDrawable shapeDrawable) {
        if (!TextUtils.isEmpty(this.eBg.Zw().mky)) {
            this.eOf.setBackgroundDrawable(null);
            this.eOg.setVisibility(0);
            acV();
        } else if (this.eND != null) {
            this.eOf.setBackgroundDrawable(shapeDrawable);
            this.eOg.setVisibility(8);
        }
    }

    public final void cn(boolean z) {
        if (TextUtils.isEmpty(this.eBg.Zw().mky)) {
            this.eOe.setVisibility(0);
            this.eOd.setVisibility(0);
            return;
        }
        this.eOe.setVisibility(8);
        this.eOd.setVisibility(8);
    }

    private void acV() {
        a aVar = new a();
        aVar.cPv = com.tencent.mm.compatible.util.e.cnj;
        n.GM();
        aVar.cPN = null;
        aVar.cPu = i.pR(this.eBg.Zw().mky);
        aVar.cPs = true;
        aVar.cPP = true;
        aVar.cPQ = (float) this.mContext.getResources().getDimensionPixelSize(2131493366);
        aVar.cPR = true;
        aVar.cPq = true;
        aVar.cPH = 2130837894;
        n.GL().a(this.eBg.Zw().mky, this.eOf, aVar.GU());
        v.i("MicroMsg.CardWidgetMembership", "the member back ground url is " + this.eBg.Zw().mky);
    }
}
