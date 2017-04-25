package com.tencent.mm.ui.c;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.c.a.c;

public final class a {
    public static Animation eq(Context context) {
        if (context == null) {
            v.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
            return null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, 2130968588);
        if (-1 > 0) {
            loadAnimation.setDuration(-1);
        }
        loadAnimation.setInterpolator(new c());
        return loadAnimation;
    }
}
