package com.tencent.mm.plugin.card.ui.b;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class m extends f {
    MMActivity eBk;
    private boolean eMX = false;
    private View eMY;
    private View eMZ;
    private ImageView eNa;
    private TextView eNb;
    private TextView eNc;
    private ImageView eNd;
    View eNe;
    private LinearLayout eNf;
    private OnClickListener eNg = new OnClickListener(this) {
        final /* synthetic */ m eNh;

        {
            this.eNh = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof r) {
                b abq = this.eNh.eMF.abq();
                this.eNh.eMF.abs();
                r rVar = (r) view.getTag();
                if (rVar != null && rVar.eEU != null && !rVar.eEU.isEmpty()) {
                    if (rVar.eES != null && rVar.eES.equals(abq.ZB())) {
                        this.eNh.eNe.setVisibility(8);
                        this.eNh.eMF.aaI();
                    } else if (TextUtils.isEmpty(rVar.eES) && TextUtils.isEmpty(abq.ZB())) {
                        this.eNh.eNe.setVisibility(8);
                        this.eNh.eMF.aaI();
                    } else {
                        boolean z;
                        ArrayList pV = com.tencent.mm.plugin.card.sharecard.a.b.pV(rVar.eBK);
                        if (pV == null || pV.size() <= 0) {
                            z = false;
                        } else {
                            z = false;
                            for (int i = 0; i < pV.size(); i++) {
                                r rVar2 = (r) pV.get(i);
                                if ((rVar2.eES == null || !rVar2.eES.equals(rVar.eES)) && !(TextUtils.isEmpty(rVar2.eES) && TextUtils.isEmpty(rVar.eES))) {
                                    rVar2.eEV = false;
                                    pV.set(i, rVar2);
                                } else {
                                    rVar2.eEV = true;
                                    if (!rVar2.eEW) {
                                        rVar2.eEW = true;
                                        z = true;
                                    }
                                    pV.set(i, rVar2);
                                }
                            }
                        }
                        b qc = af.aas().qc((String) rVar.eEU.get(0));
                        if (qc != null) {
                            this.eNh.eMF.d(qc);
                        }
                        if (z && this.eNh.eMF.abw() != null) {
                            this.eNh.eMF.abw().abj();
                        }
                        this.eNh.eNe.setVisibility(8);
                    }
                }
            }
        }
    };

    public final void NI() {
        this.eMY = findViewById(2131755798);
        this.eMZ = findViewById(2131755976);
        this.eNa = (ImageView) findViewById(2131755978);
        this.eNb = (TextView) findViewById(2131755979);
        this.eNc = (TextView) findViewById(2131755980);
        this.eNd = (ImageView) findViewById(2131755981);
        this.eMY.setVisibility(8);
        this.eNe = findViewById(2131755982);
        this.eNf = (LinearLayout) findViewById(2131755983);
        this.eNe.setVisibility(8);
        this.eBk = this.eMF.abt();
    }

    public final void update() {
        b abq = this.eMF.abq();
        ArrayList pV = com.tencent.mm.plugin.card.sharecard.a.b.pV(abq.ZA());
        g abv = this.eMF.abv();
        String str;
        if (abv.aco()) {
            this.eMY.setVisibility(0);
            if (com.tencent.mm.plugin.card.sharecard.a.b.pU(abq.ZA()) > 1) {
                this.eMZ.setOnClickListener(this.eMF.abu());
            } else {
                this.eNd.setVisibility(8);
                this.eNe.setVisibility(8);
                this.eNf.removeAllViews();
                this.eMF.abs();
            }
            b abq2 = this.eMF.abq();
            if (this.eMF.abr()) {
                this.eNa.setVisibility(8);
                this.eNb.setVisibility(8);
                this.eNc.setVisibility(0);
                this.eNd.setImageResource(2130837878);
                this.eNc.setText(this.eBk.getString(2131231688));
            } else {
                this.eNa.setVisibility(0);
                this.eNb.setVisibility(0);
                this.eNc.setVisibility(8);
                if (com.tencent.mm.plugin.card.sharecard.a.b.pU(abq2.ZA()) <= 1) {
                    this.eNd.setVisibility(8);
                } else {
                    this.eNd.setVisibility(0);
                    this.eNd.setImageResource(2130837877);
                }
                String str2 = "";
                if (pV != null && pV.size() > 0) {
                    for (int i = 0; i < pV.size(); i++) {
                        r rVar = (r) pV.get(i);
                        if (rVar.eEV) {
                            str = rVar.eES;
                            break;
                        }
                    }
                }
                str = str2;
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(abq2.ZB())) {
                    str = abq2.ZB();
                }
                if (!TextUtils.isEmpty(str)) {
                    a.b.m(this.eNa, str);
                    this.eNb.setText(e.d(this.eBk, this.eBk.getString(2131231693, new Object[]{j.qy(str)}), this.eBk.getResources().getDimensionPixelOffset(2131493169)));
                }
            }
            if (this.eMF.abr()) {
                this.eNe.setVisibility(0);
                r rVar2;
                ImageView imageView;
                if (this.eNf.getChildCount() != 0 || pV == null) {
                    for (int i2 = 0; i2 < this.eNf.getChildCount(); i2++) {
                        View childAt = this.eNf.getChildAt(i2);
                        rVar2 = pV.size() >= this.eNf.getChildCount() ? (r) pV.get(i2) : null;
                        ImageView imageView2 = (ImageView) childAt.findViewById(2131759188);
                        imageView = (ImageView) childAt.findViewById(2131759187);
                        if (rVar2 == null || !rVar2.eEV) {
                            imageView2.setVisibility(8);
                            imageView.setVisibility(8);
                        } else {
                            imageView2.setVisibility(0);
                            imageView.setVisibility(0);
                        }
                    }
                    this.eNf.invalidate();
                } else {
                    LayoutInflater layoutInflater = (LayoutInflater) this.eBk.getSystemService("layout_inflater");
                    Iterator it = pV.iterator();
                    while (it.hasNext()) {
                        rVar2 = (r) it.next();
                        View inflate = layoutInflater.inflate(2130904383, this.eNf, false);
                        ImageView imageView3 = (ImageView) inflate.findViewById(2131759186);
                        TextView textView = (TextView) inflate.findViewById(2131757361);
                        TextView textView2 = (TextView) inflate.findViewById(2131759189);
                        if (!TextUtils.isEmpty(rVar2.eES)) {
                            a.b.m(imageView3, rVar2.eES);
                            CharSequence qy = j.qy(rVar2.eES);
                            if (TextUtils.isEmpty(qy)) {
                                textView.setText("");
                            } else {
                                textView.setText(e.d(this.eBk, qy, this.eBk.getResources().getDimensionPixelOffset(2131493204)));
                            }
                        }
                        textView2.setText("x " + rVar2.eET);
                        inflate.setTag(rVar2);
                        inflate.setOnClickListener(this.eNg);
                        imageView = (ImageView) inflate.findViewById(2131759188);
                        imageView3 = (ImageView) inflate.findViewById(2131759187);
                        if (rVar2.eEV) {
                            imageView.setVisibility(0);
                            imageView3.setVisibility(0);
                        } else {
                            imageView.setVisibility(8);
                            imageView3.setVisibility(8);
                        }
                        this.eNf.addView(inflate);
                    }
                    this.eNf.invalidate();
                }
            } else {
                this.eNe.setVisibility(8);
                this.eNf.removeAllViews();
            }
            this.eMX = true;
        } else if (!abv.aco()) {
            this.eMY.setVisibility(0);
            this.eNa.setVisibility(0);
            this.eNb.setVisibility(0);
            this.eNc.setVisibility(8);
            this.eNd.setVisibility(8);
            str = "";
            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(abq.ZB())) {
                str = abq.ZB();
            }
            if (!TextUtils.isEmpty(str)) {
                a.b.m(this.eNa, str);
                this.eNb.setText(e.d(this.eBk, this.eBk.getString(2131231693, new Object[]{j.qy(str)}), this.eBk.getResources().getDimensionPixelOffset(2131493169)));
            }
            this.eMX = true;
        }
    }

    public final void acF() {
        this.eMY.setVisibility(8);
    }
}
