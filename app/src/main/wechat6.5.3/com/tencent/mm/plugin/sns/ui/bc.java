package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.c.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;

public final class bc {
    private String gRN = u.dJ(aa.getContext());
    private LinearLayout jYH;
    public TextView jYI;
    public TextView jYJ;
    private View jYK;
    private View jYL;
    public b jYM;
    public a jYN;
    private View view;

    public final String aYl() {
        if (this.jYN == null) {
            return "";
        }
        if (this.jYN.jpt == null) {
            return "";
        }
        return this.jYN.jpt;
    }

    public final int[] aYm() {
        int[] iArr = new int[2];
        if (this.jYH != null) {
            this.jYK.getLocationInWindow(iArr);
            iArr[0] = iArr[0] + this.jYK.getMeasuredWidth();
        } else if (this.jYK != null) {
            this.jYK.getLocationInWindow(iArr);
            iArr[0] = iArr[0] + this.jYK.getMeasuredWidth();
        }
        return iArr;
    }

    public bc(View view) {
        this.view = view;
        v.i("MicroMsg.TimeLineAdView", "adView init lan " + this.gRN);
        this.jYI = (TextView) this.view.findViewById(2131759296);
        this.jYJ = (TextView) this.view.findViewById(2131759301);
        this.jYK = this.view.findViewById(2131759297);
        this.jYL = this.view.findViewById(2131759298);
        this.jYH = (LinearLayout) this.view.findViewById(2131759295);
        this.jYI.setText(" " + this.view.getResources().getString(2131235364) + " ");
    }

    public final void a(OnClickListener onClickListener, OnClickListener onClickListener2) {
        this.jYJ.setOnClickListener(onClickListener);
        this.jYI.setOnClickListener(onClickListener2);
        if (this.jYK != null) {
            this.jYK.setOnClickListener(onClickListener2);
        }
        if (this.jYH != null) {
            this.jYH.setOnClickListener(onClickListener2);
        }
    }

    public final void p(Object obj, Object obj2) {
        this.jYJ.setTag(obj);
        this.jYI.setTag(obj2);
        if (this.jYK != null) {
            this.jYK.setTag(obj2);
        }
        if (this.jYH != null) {
            this.jYH.setTag(obj2);
        }
    }

    public final void a(b bVar, a aVar) {
        this.jYN = aVar;
        this.jYM = bVar;
        String str = "";
        if (bVar != null) {
            str = bVar.juu;
        }
        if (aVar != null && aVar.jua == 1) {
            str = aVar.jub;
        }
        Context context = this.jYJ.getContext();
        if (be.kS(str)) {
            str = context.getString(2131235370);
        }
        final int length = str.length();
        final CharSequence spannableString = new SpannableString(str + "ad_");
        Drawable drawable = context.getResources().getDrawable(2131165221);
        if (!be.kS(bVar.juv)) {
            d.a("adId", bVar.juv, false, 41, 0, new d.a(this) {
                final /* synthetic */ bc jYQ;

                public final void aRx() {
                }

                public final void aTV() {
                }

                public final void Bg(String str) {
                    if (!be.kS(str)) {
                        Drawable createFromPath = Drawable.createFromPath(str);
                        if (createFromPath != null) {
                            createFromPath.setBounds(0, 0, (int) (((double) this.jYQ.jYJ.getTextSize()) * 1.3d), (int) (((double) this.jYQ.jYJ.getTextSize()) * 1.3d));
                            spannableString.setSpan(new ImageSpan(createFromPath, 0), length, length + 3, 33);
                            this.jYQ.jYJ.setText(spannableString);
                        }
                    }
                }
            });
        }
        drawable.setBounds(0, 0, (int) (((double) this.jYJ.getTextSize()) * 1.3d), (int) (((double) this.jYJ.getTextSize()) * 1.3d));
        spannableString.setSpan(new ImageSpan(drawable, 0), length, length + 3, 33);
        this.jYJ.setText(spannableString);
        if (aVar == null || be.kS(aVar.juh)) {
            this.jYL.setVisibility(8);
        } else {
            this.jYL.setVisibility(0);
        }
        if (bVar != null) {
            CharSequence charSequence = "";
            if ("zh_CN".equals(this.gRN)) {
                charSequence = bVar.juC;
            } else if ("zh_TW".equals(this.gRN) || "zh_HK".equals(this.gRN)) {
                charSequence = bVar.juE;
            } else if ("en".equals(this.gRN)) {
                charSequence = bVar.juD;
            }
            if (!be.kS(charSequence)) {
                this.jYI.setText(charSequence);
            }
        }
    }

    public final void setVisibility(int i) {
        int i2;
        if (this.jYM == null || this.jYM.jut != 1) {
            this.jYJ.setVisibility(i);
        } else {
            this.jYJ.setVisibility(8);
        }
        com.tencent.mm.storage.a Lp = c.Av().Lp("Sns_CanvasAd_DetailLink_JumpWay");
        if (Lp.isValid()) {
            i2 = be.getInt(Lp.field_value, -1);
        } else {
            i2 = -1;
        }
        if (i2 != -1 && this.jYM != null && this.jYM.jun && e.Bm(this.jYM.blq)) {
            this.jYJ.setVisibility(i);
        }
        this.jYI.setVisibility(i);
        if (this.jYK != null) {
            this.jYK.setVisibility(i);
        }
        if (this.jYH != null) {
            this.jYH.setVisibility(i);
        }
        if (this.jYN == null || be.kS(this.jYN.juh)) {
            this.jYL.setVisibility(8);
        } else {
            this.jYL.setVisibility(i);
        }
    }
}
