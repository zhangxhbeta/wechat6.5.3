package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MainContentImageView extends ImageView {
    private final String TAG = "MicroMsg.MainContentImageView";
    boolean iXS = false;
    public a iXT;

    public interface a {
        void pF(int i);
    }

    public MainContentImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MainContentImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.iXT != null) {
            this.iXT.pF(i2);
        }
    }
}
