package com.tencent.mm.plugin.setting.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.setting.ui.setting.SetTextSizeUI;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontSelectorView extends View {
    private static SoftReference<Bitmap> iNC = null;
    private static int iNK = 5;
    private int djS = 0;
    private float euH = 0.0f;
    private float gpD = 0.0f;
    private int hDP = 0;
    private List<b> iND = new ArrayList(5);
    private int iNE = 0;
    private int iNF = 0;
    private int iNG = 0;
    private int iNH = 0;
    public int iNI = 0;
    public a iNJ = null;
    private boolean iNL = false;
    private boolean iNM = false;
    private int topOffset = 0;

    public interface a {
        void pi(int i);
    }

    private static class b {
        public int bottom;
        public int left;
        public int right;
        public int top;

        private b() {
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
        }
    }

    public FontSelectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FontSelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        aNy();
        this.iND.clear();
        setClickable(true);
        this.iNE = com.tencent.mm.bd.a.fromDPToPix(getContext(), 50);
        this.topOffset = com.tencent.mm.bd.a.fromDPToPix(getContext(), 10);
        int width = getWidth();
        this.hDP = (getHeight() / 2) + this.topOffset;
        iNK = 5;
        this.djS = (width - (this.iNE * 2)) / (iNK - 1);
        Bitmap bitmap = (Bitmap) iNC.get();
        for (int i5 = 0; i5 < iNK; i5++) {
            b bVar = new b();
            bVar.left = (this.iNE + (this.djS * i5)) - (bitmap.getWidth() / 2);
            bVar.top = this.hDP - (bitmap.getHeight() / 2);
            bVar.right = (this.iNE + (this.djS * i5)) + (bitmap.getWidth() / 2);
            bVar.bottom = this.hDP + (bitmap.getHeight() / 2);
            this.iND.add(bVar);
        }
        this.iNF = this.iNI;
        this.iNG = ((b) this.iND.get(this.iNF)).left;
        this.iNH = ((b) this.iND.get(this.iNF)).top;
        invalidate();
    }

    public static void aNx() {
        iNK = 5;
    }

    private void aNy() {
        if (iNC == null || iNC.get() == null) {
            iNC = new SoftReference(BitmapFactory.decodeResource(getResources(), 2130838247));
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        aNy();
        Paint paint = new Paint();
        paint.setARGB(255, 152, 152, 152);
        paint.setStrokeWidth(2.0f);
        int width = getWidth();
        int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(getContext(), 5);
        canvas.drawLine((float) this.iNE, (float) this.hDP, (float) (width - this.iNE), (float) this.hDP, paint);
        for (i = 0; i < iNK; i++) {
            canvas.drawLine((float) (this.iNE + (this.djS * i)), (float) (this.hDP - fromDPToPix), (float) (this.iNE + (this.djS * i)), (float) (this.hDP + fromDPToPix), paint);
        }
        Bitmap bitmap = (Bitmap) iNC.get();
        canvas.drawBitmap(bitmap, (float) this.iNG, (float) this.iNH, null);
        String str = "A";
        String string = getResources().getString(2131234940);
        getResources().getString(2131234939);
        getResources().getString(2131234942);
        String str2 = "A";
        float V = V(SetTextSizeUI.S(0.875f));
        paint = new Paint();
        paint.setTextSize(V);
        i = (int) paint.measureText(str);
        int W = W(V);
        paint.setColor(getResources().getColor(2131689547));
        paint.setAntiAlias(true);
        canvas.drawText(str, (float) (this.iNE - (i / 2)), (float) ((this.hDP - W) - (bitmap.getHeight() / 3)), paint);
        float V2 = V(SetTextSizeUI.S(1.0f));
        paint.setTextSize(V2);
        canvas.drawText(string, (float) ((this.iNE + (this.djS * 1)) - (((int) paint.measureText(string)) / 2)), (float) ((this.hDP - W(V2)) - (bitmap.getHeight() / 3)), paint);
        V2 = V(SetTextSizeUI.S(1.375f));
        paint.setTextSize(V2);
        canvas.drawText(str2, (float) ((this.iNE + (this.djS * 4)) - (((int) paint.measureText(str2)) / 2)), (float) ((this.hDP - W(V2)) - (bitmap.getHeight() / 3)), paint);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        b bVar;
        b bVar2;
        float y;
        int i;
        switch (motionEvent.getAction()) {
            case 0:
                this.gpD = motionEvent.getX();
                this.euH = motionEvent.getY();
                bVar = (b) this.iND.get(this.iNF);
                if (this.gpD >= ((float) bVar.left) && this.gpD <= ((float) bVar.right) && this.euH >= ((float) bVar.top) && this.euH <= ((float) bVar.bottom)) {
                    z = true;
                }
                if (!z) {
                    this.iNM = true;
                    break;
                }
                this.iNL = true;
                return true;
            case 1:
                if (this.iNL) {
                    int i2 = 0;
                    while (i2 < iNK - 1) {
                        bVar = (b) this.iND.get(i2);
                        bVar2 = (b) this.iND.get(i2 + 1);
                        if (this.iNG <= bVar.left + (this.djS / 2) && this.iNG >= bVar.left) {
                            this.iNF = i2;
                            this.iNG = bVar.left;
                            this.iNI = this.iNF;
                            if (this.iNJ != null) {
                                this.iNJ.pi(this.iNF);
                            }
                            invalidate();
                            this.iNL = false;
                            return true;
                        } else if (this.iNG < bVar2.left - (this.djS / 2) || this.iNG > bVar2.left) {
                            i2++;
                        } else {
                            this.iNF = i2 + 1;
                            this.iNG = bVar2.left;
                            this.iNI = this.iNF;
                            if (this.iNJ != null) {
                                this.iNJ.pi(this.iNF);
                            }
                            invalidate();
                            this.iNL = false;
                            return true;
                        }
                    }
                    this.iNI = this.iNF;
                    if (this.iNJ != null) {
                        this.iNJ.pi(this.iNF);
                    }
                    invalidate();
                    this.iNL = false;
                    return true;
                } else if (this.iNM) {
                    float x = motionEvent.getX();
                    y = motionEvent.getY();
                    if (Math.abs(x - this.gpD) <= 10.0f && Math.abs(y - this.euH) <= 10.0f) {
                        i = 0;
                        while (i < iNK) {
                            bVar = (b) this.iND.get(i);
                            if (x < ((float) (bVar.left - 5)) || x > ((float) (bVar.right + 5))) {
                                i++;
                            } else {
                                this.iNF = i;
                                this.iNI = this.iNF;
                                this.iNG = bVar.left;
                                if (this.iNJ != null) {
                                    this.iNJ.pi(this.iNF);
                                }
                            }
                        }
                    }
                    this.iNM = false;
                    invalidate();
                    return true;
                }
                break;
            case 2:
                if (!this.iNL) {
                    return super.onTouchEvent(motionEvent);
                }
                y = motionEvent.getX();
                float y2 = motionEvent.getY();
                this.iNG += (int) (y - this.gpD);
                this.gpD = y;
                this.euH = y2;
                bVar = (b) this.iND.get(0);
                bVar2 = (b) this.iND.get(iNK - 1);
                if (this.iNG <= bVar.left) {
                    this.iNG = bVar.left;
                } else if (this.iNG >= bVar2.left) {
                    this.iNG = bVar2.left;
                } else {
                    i = 0;
                    while (i < iNK) {
                        bVar = (b) this.iND.get(i);
                        if (this.iNG < bVar.left - 5 || this.iNG > bVar.right + 5) {
                            i++;
                        } else {
                            this.iNF = i;
                            this.iNI = this.iNF;
                            if (this.iNJ != null) {
                                this.iNJ.pi(this.iNF);
                            }
                        }
                    }
                }
                invalidate();
                return true;
            default:
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private float V(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private static int W(float f) {
        Paint paint = new Paint();
        paint.setTextSize(f);
        paint.setAntiAlias(true);
        return (int) Math.ceil((double) paint.getFontMetrics().bottom);
    }
}
