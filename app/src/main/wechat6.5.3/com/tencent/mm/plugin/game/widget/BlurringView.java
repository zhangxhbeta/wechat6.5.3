package com.tencent.mm.plugin.game.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.renderscript.Allocation;
import android.renderscript.Allocation.MipmapControl;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Array;

@TargetApi(11)
public class BlurringView extends View {
    private int gAg = 11;
    private int gAh = 8;
    private int gAi = 0;
    private View gAj;
    private int gAk;
    private int gAl;
    private boolean gAm;
    private Bitmap gAn;
    private Bitmap gAo;
    private Canvas gAp;
    private RenderScript gAq;
    private ScriptIntrinsicBlur gAr;
    private Allocation gAs;
    private Allocation gAt;

    public BlurringView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (VERSION.SDK_INT > 16) {
            this.gAq = RenderScript.create(context);
            this.gAr = ScriptIntrinsicBlur.create(this.gAq, Element.U8_4(this.gAq));
        }
    }

    protected void onDraw(Canvas canvas) {
        int i = 1;
        super.onDraw(canvas);
        if (this.gAj != null) {
            int width = this.gAj.getWidth();
            int height = this.gAj.getHeight();
            if (this.gAp == null || this.gAm || this.gAk != width || this.gAl != height) {
                this.gAm = false;
                this.gAk = width;
                this.gAl = height;
                width /= this.gAh;
                height /= this.gAh;
                width = (width - (width % 4)) + 4;
                height = (height - (height % 4)) + 4;
                if (!(this.gAo != null && this.gAo.getWidth() == width && this.gAo.getHeight() == height)) {
                    this.gAn = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                    if (this.gAn == null) {
                        i = 0;
                    } else {
                        this.gAo = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                        if (this.gAo == null) {
                            i = 0;
                        }
                    }
                }
                this.gAp = new Canvas(this.gAn);
                this.gAp.scale(1.0f / ((float) this.gAh), 1.0f / ((float) this.gAh));
                if (VERSION.SDK_INT > 16) {
                    this.gAs = Allocation.createFromBitmap(this.gAq, this.gAn, MipmapControl.MIPMAP_NONE, 1);
                    this.gAt = Allocation.createTyped(this.gAq, this.gAs.getType());
                }
            }
            if (i != 0) {
                if (this.gAj.getBackground() == null || !(this.gAj.getBackground() instanceof ColorDrawable)) {
                    this.gAn.eraseColor(0);
                } else {
                    this.gAn.eraseColor(((ColorDrawable) this.gAj.getBackground()).getColor());
                }
                this.gAj.draw(this.gAp);
                lH(this.gAg);
                canvas.save();
                canvas.translate(this.gAj.getX() - getX(), this.gAj.getY() - getY());
                canvas.scale((float) this.gAh, (float) this.gAh);
                canvas.drawBitmap(this.gAo, 0.0f, 0.0f, null);
                canvas.restore();
            }
            canvas.drawColor(this.gAi);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gAq != null) {
            this.gAq.destroy();
        }
    }

    private void lH(int i) {
        if (VERSION.SDK_INT > 16) {
            this.gAr.setRadius((float) i);
            this.gAs.copyFrom(this.gAn);
            this.gAr.setInput(this.gAs);
            this.gAr.forEach(this.gAt);
            this.gAt.copyTo(this.gAo);
        } else if (i > 0) {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            int width = this.gAn.getWidth();
            int height = this.gAn.getHeight();
            int[] iArr = new int[(width * height)];
            v.i("MicroMsg.BlurringView", width + " " + height + " " + iArr.length);
            this.gAn.getPixels(iArr, 0, width, 0, 0, width, height);
            int i13 = width - 1;
            int i14 = height - 1;
            int i15 = width * height;
            int i16 = (i + i) + 1;
            int[] iArr2 = new int[i15];
            int[] iArr3 = new int[i15];
            int[] iArr4 = new int[i15];
            int[] iArr5 = new int[Math.max(width, height)];
            int i17 = (i16 + 1) >> 1;
            int i18 = i17 * i17;
            int[] iArr6 = new int[(i18 * 256)];
            for (i17 = 0; i17 < i18 * 256; i17++) {
                iArr6[i17] = i17 / i18;
            }
            int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i16, 3});
            int i19 = i + 1;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            while (i20 < height) {
                int[] iArr8;
                i18 = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                i9 = 0;
                for (i10 = -i; i10 <= i; i10++) {
                    i11 = iArr[Math.min(i13, Math.max(i10, 0)) + i22];
                    iArr8 = iArr7[i10 + i];
                    iArr8[0] = (16711680 & i11) >> 16;
                    iArr8[1] = (65280 & i11) >> 8;
                    iArr8[2] = i11 & 255;
                    i11 = i19 - Math.abs(i10);
                    i6 += iArr8[0] * i11;
                    i7 += iArr8[1] * i11;
                    i8 += i11 * iArr8[2];
                    if (i10 > 0) {
                        i18 += iArr8[0];
                        i9 += iArr8[1];
                        i2 += iArr8[2];
                    } else {
                        i3 += iArr8[0];
                        i4 += iArr8[1];
                        i5 += iArr8[2];
                    }
                }
                i11 = i22;
                i22 = i;
                i12 = i9;
                i9 = i18;
                i10 = i5;
                i5 = i4;
                i4 = i3;
                i3 = i2;
                i2 = i12;
                for (i18 = 0; i18 < width; i18++) {
                    iArr2[i11] = iArr6[i6];
                    iArr3[i11] = iArr6[i7];
                    iArr4[i11] = iArr6[i8];
                    i6 -= i4;
                    i7 -= i5;
                    i8 -= i10;
                    iArr8 = iArr7[((i22 - i) + i16) % i16];
                    i4 -= iArr8[0];
                    i5 -= iArr8[1];
                    i10 -= iArr8[2];
                    if (i20 == 0) {
                        iArr5[i18] = Math.min((i18 + i) + 1, i13);
                    }
                    int i23 = iArr[iArr5[i18] + i21];
                    iArr8[0] = (16711680 & i23) >> 16;
                    iArr8[1] = (65280 & i23) >> 8;
                    iArr8[2] = i23 & 255;
                    i9 += iArr8[0];
                    i2 += iArr8[1];
                    i3 += iArr8[2];
                    i6 += i9;
                    i7 += i2;
                    i8 += i3;
                    i22 = (i22 + 1) % i16;
                    iArr8 = iArr7[i22 % i16];
                    i4 += iArr8[0];
                    i5 += iArr8[1];
                    i10 += iArr8[2];
                    i9 -= iArr8[0];
                    i2 -= iArr8[1];
                    i3 -= iArr8[2];
                    i11++;
                }
                i20++;
                i21 += width;
                i22 = i11;
            }
            for (i20 = 0; i20 < width; i20++) {
                int[] iArr9;
                i9 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i10 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                i18 = (-i) * width;
                i2 = 0;
                for (i22 = -i; i22 <= i; i22++) {
                    i11 = Math.max(0, i18) + i20;
                    iArr9 = iArr7[i22 + i];
                    iArr9[0] = iArr2[i11];
                    iArr9[1] = iArr3[i11];
                    iArr9[2] = iArr4[i11];
                    i13 = i19 - Math.abs(i22);
                    i6 += iArr2[i11] * i13;
                    i7 += iArr3[i11] * i13;
                    i8 += iArr4[i11] * i13;
                    if (i22 > 0) {
                        i9 += iArr9[0];
                        i2 += iArr9[1];
                        i3 += iArr9[2];
                    } else {
                        i4 += iArr9[0];
                        i5 += iArr9[1];
                        i10 += iArr9[2];
                    }
                    if (i22 < i14) {
                        i18 += width;
                    }
                }
                i22 = i;
                i11 = i20;
                i12 = i3;
                i3 = i4;
                i4 = i5;
                i5 = i10;
                i10 = i6;
                i6 = i7;
                i7 = i8;
                i18 = i9;
                i9 = i2;
                i2 = i12;
                for (i8 = 0; i8 < height; i8++) {
                    iArr[i11] = (((-16777216 & iArr[i11]) | (iArr6[i10] << 16)) | (iArr6[i6] << 8)) | iArr6[i7];
                    i10 -= i3;
                    i6 -= i4;
                    i7 -= i5;
                    iArr9 = iArr7[((i22 - i) + i16) % i16];
                    i3 -= iArr9[0];
                    i4 -= iArr9[1];
                    i5 -= iArr9[2];
                    if (i20 == 0) {
                        iArr5[i8] = Math.min(i8 + i19, i14) * width;
                    }
                    i13 = iArr5[i8] + i20;
                    iArr9[0] = iArr2[i13];
                    iArr9[1] = iArr3[i13];
                    iArr9[2] = iArr4[i13];
                    i18 += iArr9[0];
                    i9 += iArr9[1];
                    i2 += iArr9[2];
                    i10 += i18;
                    i6 += i9;
                    i7 += i2;
                    i22 = (i22 + 1) % i16;
                    iArr9 = iArr7[i22];
                    i3 += iArr9[0];
                    i4 += iArr9[1];
                    i5 += iArr9[2];
                    i18 -= iArr9[0];
                    i9 -= iArr9[1];
                    i2 -= iArr9[2];
                    i11 += width;
                }
            }
            v.e("MicroMsg.BlurringView", width + " " + height + " " + i15);
            this.gAo.setPixels(iArr, 0, width, 0, 0, width, height);
        }
    }
}
