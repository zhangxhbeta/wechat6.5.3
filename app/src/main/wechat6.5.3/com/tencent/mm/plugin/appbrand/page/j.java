package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public final class j extends i {
    a dOC;
    b dOD;
    boolean dOE;
    private LinearLayout dOF;
    View dOG;
    ImageView dOH;
    ImageView dOI;
    ImageView dOJ;
    private long dOK;

    public interface a {
        void Rs();
    }

    public interface b {
        void hl(int i);
    }

    public j(Context context, l lVar) {
        super(context);
        this.dOE = false;
        this.dOK = 0;
        lVar.pdI = this;
        lVar.bKo();
        this.dOF = (LinearLayout) LayoutInflater.from(getContext()).inflate(2130903110, this, false);
        View view = this.dOF;
        this.dOq = view;
        this.dOr = new FrameLayout(getContext());
        this.dOr.setLayoutParams(new LayoutParams(-1, -1));
        this.dOr.addView(view);
        this.Hq = lVar;
        this.dOs = new FrameLayout(getContext());
        this.dOs.setLayoutParams(new LayoutParams(-1, -1));
        this.dOs.addView(lVar);
        addView(this.dOr);
        addView(this.dOs);
        this.dOG = findViewById(2131755394);
        this.dOH = (ImageView) findViewById(2131755395);
        this.dOI = (ImageView) findViewById(2131755396);
        this.dOJ = (ImageView) findViewById(2131755397);
    }

    protected final void Ru() {
        ((AnimationDrawable) this.dOH.getDrawable()).start();
        ((AnimationDrawable) this.dOI.getDrawable()).start();
        ((AnimationDrawable) this.dOJ.getDrawable()).start();
        if (this.dOC != null) {
            this.dOC.Rs();
        }
        this.dOK = System.currentTimeMillis();
    }

    protected final void Rv() {
        Rz();
    }

    protected final void hj(int i) {
        if (this.dOD != null) {
            this.dOD.hl(i);
        }
        if (this.dOE) {
            if (i > this.dOF.getHeight()) {
                i = this.dOF.getHeight();
            }
            this.dOF.setTranslationY((float) (i - this.dOF.getHeight()));
        }
    }

    public final void Ry() {
        long currentTimeMillis = System.currentTimeMillis() - this.dOK;
        if (currentTimeMillis < 1000) {
            postDelayed(new Runnable(this) {
                final /* synthetic */ j dOL;

                {
                    this.dOL = r1;
                }

                public final void run() {
                    this.dOL.Rt();
                }
            }, 1000 - currentTimeMillis);
        } else {
            Rt();
        }
    }

    protected final int Rx() {
        return this.dOG.getHeight();
    }

    public final void Rz() {
        ((AnimationDrawable) this.dOH.getDrawable()).stop();
        ((AnimationDrawable) this.dOH.getDrawable()).selectDrawable(0);
        ((AnimationDrawable) this.dOI.getDrawable()).stop();
        ((AnimationDrawable) this.dOI.getDrawable()).selectDrawable(0);
        ((AnimationDrawable) this.dOJ.getDrawable()).stop();
        ((AnimationDrawable) this.dOJ.getDrawable()).selectDrawable(0);
    }

    static AnimationDrawable a(int i, float[] fArr) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(d(i, fArr[0]), 0);
        animationDrawable.addFrame(d(i, fArr[1]), 300);
        animationDrawable.addFrame(d(i, fArr[2]), 300);
        animationDrawable.addFrame(d(i, fArr[3]), 300);
        return animationDrawable;
    }

    private static Drawable d(int i, float f) {
        Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(32);
        shapeDrawable.setIntrinsicWidth(32);
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setAlpha((int) (255.0f * f));
        return shapeDrawable;
    }
}
