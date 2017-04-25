package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontChooserView extends View {
    private static SoftReference<Bitmap> iNC = null;
    private int djS = 0;
    private float euH = 0.0f;
    private float gpD = 0.0f;
    private int hDP = 0;
    private List<b> iND = new ArrayList(4);
    private int iNE = 0;
    private int iNF = 0;
    private int iNG = 0;
    private int iNH = 0;
    public int iNI = 0;
    private boolean iNL = false;
    private boolean iNM = false;
    public a lrq = null;
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

    public FontChooserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FontChooserView(Context context, AttributeSet attributeSet, int i) {
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
        this.djS = (width - (this.iNE * 2)) / 3;
        Bitmap bitmap = (Bitmap) iNC.get();
        for (int i5 = 0; i5 < 4; i5++) {
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

    private void aNy() {
        if (iNC == null || iNC.get() == null) {
            iNC = new SoftReference(BitmapFactory.decodeResource(getResources(), 2130838247));
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aNy();
        Paint paint = new Paint();
        paint.setARGB(255, v.CTRL_INDEX, v.CTRL_INDEX, v.CTRL_INDEX);
        paint.setStrokeWidth(2.0f);
        int width = getWidth();
        int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(getContext(), 5);
        canvas.drawLine((float) this.iNE, (float) this.hDP, (float) (width - this.iNE), (float) this.hDP, paint);
        for (int i = 0; i < 4; i++) {
            canvas.drawLine((float) (this.iNE + (this.djS * i)), (float) (this.hDP - fromDPToPix), (float) (this.iNE + (this.djS * i)), (float) (this.hDP + fromDPToPix), paint);
        }
        Bitmap bitmap = (Bitmap) iNC.get();
        canvas.drawBitmap(bitmap, (float) this.iNG, (float) this.iNH, null);
        String string = getResources().getString(2131236596);
        String string2 = getResources().getString(2131236597);
        String string3 = getResources().getString(2131236594);
        String string4 = getResources().getString(2131236595);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131493454);
        Paint paint2 = new Paint();
        paint2.setTextSize((float) dimensionPixelSize);
        fromDPToPix = (int) paint2.measureText(string);
        dimensionPixelSize = tm(dimensionPixelSize);
        paint2.setColor(getResources().getColor(2131690120));
        paint2.setAntiAlias(true);
        canvas.drawText(string, (float) (this.iNE - (fromDPToPix / 2)), (float) ((this.hDP - dimensionPixelSize) - (bitmap.getHeight() / 3)), paint2);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131493455);
        paint2.setTextSize((float) dimensionPixelSize2);
        canvas.drawText(string2, (float) ((this.iNE + (this.djS * 1)) - (((int) paint2.measureText(string2)) / 2)), (float) ((this.hDP - tm(dimensionPixelSize2)) - (bitmap.getHeight() / 3)), paint2);
        dimensionPixelSize2 = getResources().getDimensionPixelSize(2131493452);
        paint2.setTextSize((float) dimensionPixelSize2);
        canvas.drawText(string3, (float) ((this.iNE + (this.djS * 2)) - (((int) paint2.measureText(string3)) / 2)), (float) ((this.hDP - tm(dimensionPixelSize2)) - (bitmap.getHeight() / 3)), paint2);
        dimensionPixelSize2 = getResources().getDimensionPixelSize(2131493453);
        paint2.setTextSize((float) dimensionPixelSize2);
        canvas.drawText(string4, (float) ((this.iNE + (this.djS * 3)) - (((int) paint2.measureText(string4)) / 2)), (float) ((this.hDP - tm(dimensionPixelSize2)) - (bitmap.getHeight() / 3)), paint2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        b bVar;
        b bVar2;
        float y;
        switch (motionEvent.getAction()) {
            case 0:
                this.gpD = motionEvent.getX();
                this.euH = motionEvent.getY();
                bVar = (b) this.iND.get(this.iNF);
                if (this.gpD >= ((float) bVar.left) && this.gpD <= ((float) bVar.right) && this.euH >= ((float) bVar.top) && this.euH <= ((float) bVar.bottom)) {
                    i = 1;
                }
                if (i == 0) {
                    this.iNM = true;
                    break;
                }
                this.iNL = true;
                return true;
            case 1:
                if (this.iNL) {
                    int i2 = 0;
                    while (i2 < 3) {
                        bVar = (b) this.iND.get(i2);
                        bVar2 = (b) this.iND.get(i2 + 1);
                        if (this.iNG <= bVar.left + (this.djS / 2) && this.iNG >= bVar.left) {
                            this.iNF = i2;
                            this.iNG = bVar.left;
                            this.iNI = this.iNF;
                            if (this.lrq != null) {
                                this.lrq.pi(this.iNF);
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
                            if (this.lrq != null) {
                                this.lrq.pi(this.iNF);
                            }
                            invalidate();
                            this.iNL = false;
                            return true;
                        }
                    }
                    this.iNI = this.iNF;
                    if (this.lrq != null) {
                        this.lrq.pi(this.iNF);
                    }
                    invalidate();
                    this.iNL = false;
                    return true;
                } else if (this.iNM) {
                    float x = motionEvent.getX();
                    y = motionEvent.getY();
                    if (Math.abs(x - this.gpD) <= 10.0f && Math.abs(y - this.euH) <= 10.0f) {
                        int i3 = 0;
                        while (i3 < 4) {
                            bVar = (b) this.iND.get(i3);
                            if (x < ((float) (bVar.left - 5)) || x > ((float) (bVar.right + 5))) {
                                i3++;
                            } else {
                                this.iNF = i3;
                                this.iNI = this.iNF;
                                this.iNG = bVar.left;
                                if (this.lrq != null) {
                                    this.lrq.pi(this.iNF);
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
                bVar2 = (b) this.iND.get(3);
                if (this.iNG <= bVar.left) {
                    this.iNG = bVar.left;
                } else if (this.iNG >= bVar2.left) {
                    this.iNG = bVar2.left;
                } else {
                    while (i < 4) {
                        bVar = (b) this.iND.get(i);
                        if (this.iNG < bVar.left - 5 || this.iNG > bVar.right + 5) {
                            i++;
                        } else {
                            this.iNF = i;
                            this.iNI = this.iNF;
                            if (this.lrq != null) {
                                this.lrq.pi(this.iNF);
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

    private static int tm(int i) {
        Paint paint = new Paint();
        paint.setTextSize((float) i);
        paint.setAntiAlias(true);
        return (int) Math.ceil((double) paint.getFontMetrics().bottom);
    }
}
