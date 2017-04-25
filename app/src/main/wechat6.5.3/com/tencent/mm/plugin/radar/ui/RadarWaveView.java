package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.mm.sdk.platformtools.v;

public class RadarWaveView extends RelativeLayout {
    MediaPlayer ikX = null;
    View ikY;
    Animation ikZ;

    public RadarWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void aJb() {
        v.d("MicroMsg.RadarWaveView", "start wave animation");
        setVisibility(0);
        this.ikY.startAnimation(this.ikZ);
    }

    public final void aJc() {
        v.d("MicroMsg.RadarWaveView", "stop wave animation. forces, %d, %d", new Object[]{Integer.valueOf(getMeasuredHeight()), Integer.valueOf(getMeasuredWidth())});
        setVisibility(4);
        this.ikY.clearAnimation();
    }
}
