package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.e.am;
import com.tencent.mm.plugin.sns.e.am.b;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.tools.j;

public class SnsTranslateResultView extends LinearLayout {
    private static final int jXy = Color.parseColor("#19000000");
    private Drawable cPK;
    public TextView iBv;
    private float jXA = -1.0f;
    private int jXB = -1;
    private TextView jXw;
    public View jXx;
    private int jXz = -1;

    public SnsTranslateResultView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(2130904554, this);
        this.jXw = (TextView) findViewById(2131759587);
        this.iBv = (TextView) findViewById(2131759588);
        this.jXx = findViewById(2131759586);
        this.cPK = getResources().getDrawable(2130839239);
        this.cPK.setBounds(0, 0, (int) (this.iBv.getTextSize() * 0.8f), (int) (this.iBv.getTextSize() * 0.8f));
        this.cPK.setColorFilter(jXy, Mode.SRC_IN);
    }

    public final void ri(int i) {
        this.iBv.setCompoundDrawables(this.cPK, null, null, null);
        this.iBv.setCompoundDrawablePadding(a.fromDPToPix(getContext(), 3));
        this.iBv.setText(2131235570);
        j.a(this.iBv, null);
        this.jXw.setVisibility(4);
        this.jXz = i;
        this.iBv.setTextSize(0, this.jXw.getTextSize());
        this.iBv.setTextColor(getContext().getResources().getColor(2131690045));
    }

    public final void ad(float f) {
        this.iBv.setTextSize(1, f);
        this.jXA = f;
        this.jXB = 1;
    }

    public final void ae(float f) {
        this.iBv.setTextSize(0, f);
        this.jXA = f;
        this.jXB = 0;
    }

    @TargetApi(11)
    public final void a(final b bVar, int i, String str, String str2, boolean z) {
        this.jXz = i;
        if (this.jXA != -1.0f || this.jXB != -1) {
            this.iBv.setTextSize(this.jXB, this.jXA);
        } else if (this.jXz == 2) {
            this.iBv.setTextSize(1, 14.0f * a.ds(getContext()));
        } else if (this.jXz == 1) {
            this.iBv.setTextSize(1, 15.0f * a.ds(getContext()));
        }
        if (this.jXz == 2) {
            this.iBv.setTextColor(getContext().getResources().getColor(2131690044));
        } else if (this.jXz == 1) {
            this.iBv.setTextColor(getContext().getResources().getColor(2131690046));
        }
        if (be.kS(str)) {
            this.iBv.setText(2131235568);
        } else {
            this.iBv.setText(str);
            e.e(this.iBv, 2);
        }
        this.iBv.setCompoundDrawables(null, null, null, null);
        if (z && d.dW(11)) {
            j.a(this.iBv, new AnimatorListener(this) {
                final /* synthetic */ SnsTranslateResultView jXD;

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    if (bVar != null) {
                        am.a(bVar);
                    }
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
        }
        if (be.kS(str2)) {
            this.jXw.setText(2131231907);
        } else {
            this.jXw.setText(str2);
        }
        this.jXw.setVisibility(0);
    }
}
