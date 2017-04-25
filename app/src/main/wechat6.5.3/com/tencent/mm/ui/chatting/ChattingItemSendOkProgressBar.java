package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.aa;
import java.lang.ref.SoftReference;

public class ChattingItemSendOkProgressBar extends ProgressBar {
    private static SoftReference<Bitmap> opA = null;
    private static int opG;
    private static int opH;
    private static SoftReference<Bitmap> opy = null;
    private static SoftReference<Bitmap> opz = null;
    private boolean gWB = false;
    private Bitmap opB = null;
    private Bitmap opC = null;
    private Bitmap opD = null;
    private boolean opE = false;
    private a opF = null;
    private int opu = 0;
    private int opv = 0;
    private boolean opw = false;
    private boolean opx = false;
    private float rotation = 0.0f;

    public interface a {
    }

    static {
        opG = 0;
        opH = 0;
        opG = com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 1);
        opH = com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 6);
    }

    public ChattingItemSendOkProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChattingItemSendOkProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        if (this.opE) {
            canvas.saveLayerAlpha(new RectF(0.0f, 0.0f, (float) this.opB.getWidth(), (float) this.opB.getHeight()), 255, 31);
            if (!this.gWB) {
                canvas.drawBitmap(this.opD, new Rect(0, 0, this.opD.getWidth(), this.opD.getHeight()), new Rect(opG, opH, this.opD.getWidth() + opG, this.opD.getHeight() + opH), null);
                return;
            } else if (this.opw) {
                if (this.opu <= this.opC.getWidth()) {
                    Matrix matrix = new Matrix();
                    this.rotation += 6.0f;
                    matrix.setRotate(this.rotation, (float) (this.opB.getWidth() / 2), (float) (this.opB.getHeight() / 2));
                    int i = ((int) this.rotation) % 360;
                    if (i < 270) {
                        i += 360;
                    }
                    if (i >= 270 && i < 450) {
                        Paint paint = new Paint();
                        paint.setColor(-16776961);
                        canvas.drawBitmap(this.opB, matrix, paint);
                        paint.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
                        canvas.drawRect(0.0f, 0.0f, (float) this.opB.getWidth(), (float) (this.opB.getHeight() / 2), paint);
                    }
                    canvas.drawBitmap(this.opC, new Rect(0, 0, this.opu, this.opC.getHeight()), new Rect(opG, opH, this.opu + opG, this.opC.getHeight() + opH), null);
                    this.opu += 2;
                    invalidate();
                    return;
                }
                Rect rect = new Rect(0, 0, this.opC.getWidth(), this.opC.getHeight());
                Rect rect2 = new Rect(opG, opH, this.opC.getWidth() + opG, this.opC.getHeight() + opH);
                canvas.drawBitmap(this.opC, rect, rect2, null);
                if (this.opv < 255) {
                    Paint paint2 = new Paint();
                    paint2.setAlpha(this.opv);
                    canvas.drawBitmap(this.opD, rect, rect2, paint2);
                    this.opv += 20;
                    invalidate();
                    return;
                }
                canvas.drawBitmap(this.opD, rect, rect2, null);
                this.gWB = false;
                this.rotation = 0.0f;
                this.opu = 0;
                this.opv = 0;
                this.opx = false;
                this.opw = false;
                return;
            } else if (((int) (this.rotation - 270.0f)) % 360 == 0 && this.opx) {
                this.opw = true;
                invalidate();
                return;
            } else {
                Matrix matrix2 = new Matrix();
                matrix2.setRotate(this.rotation, (float) (this.opB.getWidth() / 2), (float) (this.opB.getHeight() / 2));
                canvas.drawBitmap(this.opB, matrix2, null);
                this.rotation += 6.0f;
                invalidate();
                return;
            }
        }
        super.onDraw(canvas);
    }
}
