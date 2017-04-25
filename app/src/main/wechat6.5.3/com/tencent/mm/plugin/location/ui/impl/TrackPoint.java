package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.pluginsdk.ui.a.b;

public class TrackPoint extends LinearLayout {
    private ImageView cHH;
    public double dKl = -1.0d;
    public double dKm = -1.0d;
    public double dKn = -1.0d;
    public double dKo = -1.0d;
    public ImageView gZA;
    public ImageView gZB;
    public View gZC;
    private double gZD = 0.0d;
    private Context mContext;
    private String username;
    public boolean visible = true;

    public TrackPoint(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public TrackPoint(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.mContext, 2130904551, this);
        this.cHH = (ImageView) inflate.findViewById(2131759579);
        this.gZA = (ImageView) inflate.findViewById(2131759580);
        this.gZB = (ImageView) inflate.findViewById(2131759581);
        this.gZB.setVisibility(4);
        this.gZC = inflate.findViewById(2131759578);
        this.cHH.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ TrackPoint gZE;

            {
                this.gZE = r1;
            }

            public final boolean onLongClick(View view) {
                if (this.gZE.gZC.getVisibility() == 0) {
                    this.gZE.gZC.setVisibility(4);
                } else {
                    this.gZE.gZC.setVisibility(0);
                }
                return false;
            }
        });
        this.gZA.requestFocus();
    }

    public final void b(OnClickListener onClickListener) {
        this.gZA.setOnClickListener(onClickListener);
    }

    public final void c(OnClickListener onClickListener) {
        this.cHH.setOnClickListener(onClickListener);
    }

    public final void vW(String str) {
        this.username = str;
        this.gZA.setTag(str);
        b.o(this.cHH, str);
        this.cHH.setTag(str);
    }

    public final void axt() {
        this.visible = false;
        this.gZC.setVisibility(4);
    }

    public final void axu() {
        this.visible = true;
        this.gZC.setVisibility(0);
    }

    public final void g(double d) {
        float f = (float) this.gZD;
        float f2 = (float) d;
        Animation rotateAnimation = new RotateAnimation(f.q(f, f2), f.p(f, f2), 1, 0.5f, 1, 0.7f);
        rotateAnimation.setDuration(200);
        rotateAnimation.setFillAfter(true);
        this.gZA.startAnimation(rotateAnimation);
        this.gZD = d;
    }

    public final void axv() {
        this.gZB.setVisibility(4);
    }
}
