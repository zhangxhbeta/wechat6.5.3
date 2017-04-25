package com.tencent.mm.plugin.sns.lucky.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.bd.a;

public class SnsLuckyAdBannerImageView extends ImageView {
    int color = -4144960;
    Paint evR = new Paint();
    Bitmap jgh;
    RectF jgi = new RectF();
    float jgj = 0.0f;
    int padding = 2;

    public SnsLuckyAdBannerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SnsLuckyAdBannerImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.jgj = (float) a.fromDPToPix(getContext(), 2);
    }
}
