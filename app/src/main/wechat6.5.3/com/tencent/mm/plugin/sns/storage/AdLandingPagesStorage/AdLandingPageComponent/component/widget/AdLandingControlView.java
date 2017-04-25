package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.ui.base.MMPageControlView;

public class AdLandingControlView extends MMPageControlView {
    public AdLandingControlView(Context context) {
        super(context);
    }

    public AdLandingControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void qw(int i) {
        removeAllViews();
        if (i < this.count) {
            int i2 = this.count;
            for (int i3 = 0; i3 < i2; i3++) {
                this.bdF = null;
                if (i == i3) {
                    if (this.map.size() > i3) {
                        this.bdF = (ImageView) this.map.get(Integer.valueOf(i3));
                    }
                    if (this.bdF == null) {
                        this.bdF = (ImageView) View.inflate(this.context, this.nWL, null).findViewById(2131758302);
                        this.map.put(Integer.valueOf(i3), this.bdF);
                    }
                    this.bdF.setSelected(true);
                } else {
                    if (this.map.size() > i3) {
                        this.bdF = (ImageView) this.map.get(Integer.valueOf(i3));
                    }
                    if (this.bdF == null) {
                        this.bdF = (ImageView) View.inflate(this.context, this.nWL, null).findViewById(2131758302);
                        this.map.put(Integer.valueOf(i3), this.bdF);
                    }
                    this.bdF.setSelected(false);
                }
                addView(this.bdF);
            }
        }
    }
}
