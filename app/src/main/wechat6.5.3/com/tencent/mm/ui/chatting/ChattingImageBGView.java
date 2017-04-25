package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.sdk.platformtools.v;

public class ChattingImageBGView extends ImageView {
    private Bitmap ggw;
    private int ony = 0;

    public ChattingImageBGView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setScaleType(ScaleType.MATRIX);
    }

    public ChattingImageBGView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setScaleType(ScaleType.MATRIX);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.ony != i3 - i) {
            this.ony = i3 - i;
            v.d("MicroMsg.ChattingImageBGView", "on layout changed, %d, %d, %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            bEw();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.ggw = bitmap;
        super.setImageBitmap(bitmap);
        bEw();
    }

    private void bEw() {
        post(new Runnable(this) {
            final /* synthetic */ ChattingImageBGView onz;

            {
                this.onz = r1;
            }

            public final void run() {
                if (this.onz.ggw == null) {
                    v.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but bmp is null");
                    return;
                }
                if (this.onz.ggw.getWidth() == 0) {
                    v.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but measured width error");
                }
                Matrix matrix = new Matrix();
                float measuredWidth = ((float) this.onz.getMeasuredWidth()) / ((float) this.onz.ggw.getWidth());
                float measuredHeight = ((float) this.onz.getMeasuredHeight()) / ((float) this.onz.ggw.getHeight());
                v.d("MicroMsg.ChattingImageBGView", "scaleW[%f], scaleH[%f] measured width[%d] measured height[%d]", new Object[]{Float.valueOf(measuredWidth), Float.valueOf(measuredHeight), Integer.valueOf(this.onz.getMeasuredWidth()), Integer.valueOf(this.onz.getMeasuredHeight())});
                if (measuredWidth > measuredHeight) {
                    matrix.setScale(measuredWidth, measuredWidth);
                } else {
                    matrix.setScale(measuredHeight, measuredHeight);
                    matrix.postTranslate((((float) this.onz.getMeasuredWidth()) - (((float) this.onz.ggw.getWidth()) * measuredHeight)) / 2.0f, 0.0f);
                }
                this.onz.setImageMatrix(matrix);
            }
        });
    }
}
