package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Field;

public class LightHouseImageView extends ImageView {
    private AnimationDrawable evd;
    private ac handler = new ac();

    public LightHouseImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LightHouseImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setVisibility(final int i) {
        this.handler.postDelayed(new Runnable(this) {
            final /* synthetic */ LightHouseImageView eve;

            public final void run() {
                super.setVisibility(i);
                this.eve.evd = (AnimationDrawable) this.eve.getBackground();
                this.eve.iB(0);
                this.eve.evd.start();
            }
        }, 1000);
    }

    public void onDraw(Canvas canvas) {
        try {
            Field declaredField = AnimationDrawable.class.getDeclaredField("mCurFrame");
            declaredField.setAccessible(true);
            iB(declaredField.getInt(this.evd));
            super.onDraw(canvas);
        } catch (Exception e) {
        }
    }

    private void iB(int i) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
        FrameLayout frameLayout = (FrameLayout) getParent();
        if ((i >= 6 && i <= 8) || (i >= 21 && i <= 23)) {
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (frameLayout.getHeight() * 250) / 800, (frameLayout.getWidth() * au.CTRL_INDEX) / 480, marginLayoutParams.bottomMargin);
        } else if ((i < 0 || i > 8) && (i < 21 || i > 29)) {
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (frameLayout.getHeight() * 245) / 800, ((frameLayout.getWidth() * 125) / 480) - getWidth(), marginLayoutParams.bottomMargin);
        } else {
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (frameLayout.getHeight() * 245) / 800, (frameLayout.getWidth() * 130) / 480, marginLayoutParams.bottomMargin);
        }
        setLayoutParams(marginLayoutParams);
    }
}
