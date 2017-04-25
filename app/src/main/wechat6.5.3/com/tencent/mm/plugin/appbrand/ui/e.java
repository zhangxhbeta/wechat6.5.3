package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.widget.MMSimpleRoundCornerImageView;
import com.tencent.mm.plugin.appbrand.widget.a;
import com.tencent.mm.plugin.appbrand.widget.b;
import com.tencent.mm.t.a.c;

public final class e extends FrameLayout {
    MMSimpleRoundCornerImageView dSq;
    private TextView dSr;
    private View dSs;
    private ImageView dSt;
    private ImageView dSu;
    private ImageView dSv;
    boolean dSw = false;
    a lqE;
    private View lqF;
    private LinearLayout pQW;

    public e(Context context) {
        super(context);
        setClickable(true);
        addView(LayoutInflater.from(getContext()).inflate(2130903117, null));
        this.dSq = (MMSimpleRoundCornerImageView) findViewById(2131755403);
        this.dSq.setImageDrawable(com.tencent.mm.t.a.a.AK());
        this.dSr = (TextView) findViewById(2131755404);
        this.dSs = findViewById(2131755405);
        this.dSt = (ImageView) findViewById(2131755406);
        this.dSu = (ImageView) findViewById(2131755407);
        this.dSv = (ImageView) findViewById(2131755408);
        this.pQW = (LinearLayout) findViewById(2131760119);
        this.lqE = new a(getContext());
        this.pQW.addView(this.lqE);
        this.lqF = this.lqE.findViewById(2131755353);
        this.dSr.getLayoutParams().height = b.bv(getContext());
        if (getContext() instanceof Activity) {
            Window window = ((Activity) getContext()).getWindow();
            if (d.dW(23)) {
                window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 8192);
                window.setStatusBarColor(-1);
            } else if (VERSION.SDK_INT >= 21) {
                window.setStatusBarColor(f.e(-1, 0.8f));
            }
        }
        this.lqE.setBackgroundColor(-1);
        this.lqE.Ri("black");
        this.lqE.bE(false);
        this.lqE.dVg = new OnClickListener(this) {
            final /* synthetic */ e dSx;

            {
                this.dSx = r1;
            }

            public final void onClick(View view) {
                ((Activity) this.dSx.getContext()).finish();
            }
        };
        this.dSt.setImageDrawable(a(new float[]{0.1f, 0.4f, 0.2f, 0.1f}));
        this.dSu.setImageDrawable(a(new float[]{0.1f, 0.1f, 0.4f, 0.2f}));
        this.dSv.setImageDrawable(a(new float[]{0.1f, 0.2f, 0.1f, 0.4f}));
        ((AnimationDrawable) this.dSt.getDrawable()).start();
        ((AnimationDrawable) this.dSu.getDrawable()).start();
        ((AnimationDrawable) this.dSv.getDrawable()).start();
    }

    public final void as(String str, String str2) {
        com.tencent.mm.t.a.b.AL().a(this.dSq, str, null, c.cxH);
        this.dSr.setText(str2);
    }

    private static AnimationDrawable a(float[] fArr) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(d(-16777216, fArr[0]), 0);
        animationDrawable.addFrame(d(-16777216, fArr[1]), 300);
        animationDrawable.addFrame(d(-16777216, fArr[2]), 300);
        animationDrawable.addFrame(d(-16777216, fArr[3]), 300);
        return animationDrawable;
    }

    private static Drawable d(int i, float f) {
        Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(32);
        shapeDrawable.setIntrinsicWidth(32);
        shapeDrawable.getPaint().setColor(-16777216);
        shapeDrawable.getPaint().setAlpha((int) (255.0f * f));
        return shapeDrawable;
    }
}
