package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.sdk.platformtools.v;

public abstract class d extends j {
    public d(Context context, b bVar, ViewGroup viewGroup) {
        super(context, bVar, viewGroup);
    }

    protected final void a(LinearLayout linearLayout) {
        b bVar = (b) this.jxU;
        if (linearLayout != null) {
            int i = (int) bVar.jvh;
            int i2 = (int) bVar.jvi;
            if (Double.compare(bVar.jvh, bVar.jvi) != 0) {
                if (i == 0 && bVar.jvh != 0.0d) {
                    i = 1;
                }
                if (i2 == 0 && bVar.jvi != 0.0d) {
                    i2 = 1;
                }
            } else if (i == 0) {
                i2 = 1;
                i = 1;
            }
            v.i("AdLandingBorderedComp", "border width top %d,bottom %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            View linearLayout2 = new LinearLayout(linearLayout.getContext());
            linearLayout2.setBackgroundColor(bVar.jvj);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i);
            layoutParams.gravity = 48;
            linearLayout.addView(linearLayout2, 0, layoutParams);
            linearLayout2 = new LinearLayout(linearLayout.getContext());
            linearLayout2.setBackgroundColor(bVar.jvj);
            LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, i2);
            layoutParams2.gravity = 80;
            linearLayout.addView(linearLayout2, layoutParams2);
        }
    }
}
