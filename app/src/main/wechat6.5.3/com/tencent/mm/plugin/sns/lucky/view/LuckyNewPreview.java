package com.tencent.mm.plugin.sns.lucky.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.ac;

public class LuckyNewPreview extends LinearLayout {
    public Bitmap bitmap = null;
    private ac cnC = new ac(Looper.getMainLooper());
    public int height;
    private ImageView jig;
    public int width;

    public LuckyNewPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LuckyNewPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.jig = (ImageView) View.inflate(getContext(), 2130903906, this).findViewById(2131757946);
    }

    public final void setImageBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        this.cnC.post(new Runnable(this) {
            final /* synthetic */ LuckyNewPreview jih;

            {
                this.jih = r1;
            }

            public final void run() {
                this.jih.jig.setImageBitmap(this.jih.bitmap);
            }
        });
    }
}
