package com.tencent.mm.svg.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import com.tencent.mm.svg.c.b;

public final class c extends b {
    private a nyy;

    public static class a extends ConstantState {
        protected int koH;
        protected Bitmap nyA;
        protected Picture nyz;

        public a(Picture picture, int i) {
            this.nyz = picture;
            this.koH = i;
        }

        public final Drawable newDrawable() {
            return new c(this.nyz, this.koH);
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }

    public c(Picture picture, int i) {
        int i2 = 0;
        int width = picture != null ? picture.getWidth() : 0;
        if (picture != null) {
            i2 = picture.getHeight();
        }
        super(width, i2, i);
        this.nyy = new a(picture, i);
        byc();
    }

    public final ConstantState getConstantState() {
        return this.nyy;
    }

    public final void draw(Canvas canvas) {
        Object obj = 1;
        Object obj2 = null;
        long byk = b.byk();
        try {
            if (canvas.isHardwareAccelerated()) {
                if (this.nyy.nyz == null) {
                    com.tencent.mm.svg.c.c.e("MicroMsg.SVGPictureDrawable", "Must not go here! %s", Integer.valueOf(this.nyr));
                } else {
                    long nanoTime = System.nanoTime();
                    if (this.nyy.nyA == null || this.nyy.nyA.isRecycled()) {
                        if (getIntrinsicWidth() > 2048 || getIntrinsicHeight() > 2048) {
                            com.tencent.mm.svg.c.c.e("MicroMsg.SVGPictureDrawable", "This drawable is too big. %s", Integer.valueOf(this.nyr));
                        } else if (getIntrinsicWidth() <= 0 || getIntrinsicHeight() <= 0) {
                            com.tencent.mm.svg.c.c.e("MicroMsg.SVGPictureDrawable", "width and height must > 0.", new Object[0]);
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap);
                            this.nyy.nyz.draw(canvas2);
                            this.nyy.nyA = createBitmap;
                            b.et(nanoTime);
                            f(canvas2);
                        }
                    }
                }
                if (this.nyy.nyA == null || this.nyy.nyA.isRecycled()) {
                    obj = null;
                } else {
                    byd();
                    canvas.drawBitmap(this.nyy.nyA, null, this.tG, this.nyt);
                }
                obj2 = obj;
            } else if (!(this.nyy.nyA == null || this.nyy.nyA.isRecycled())) {
                com.tencent.mm.svg.c.c.i("MicroMsg.SVGPictureDrawable", "recycle bitmap:%s", this.nyy.nyA.toString());
                this.nyy.nyA.recycle();
                this.nyy.nyA = null;
            }
            if (this.nyu == null) {
                this.nyu = a.t(this);
            }
            a.b(this.nyu, this.nyt);
            if (obj2 == null) {
                if (!canvas.isHardwareAccelerated() || VERSION.SDK_INT >= 16) {
                    Picture picture = this.nyy.nyz;
                    if (picture != null) {
                        byd();
                        canvas.save();
                        canvas.drawPicture(picture, this.tG);
                        canvas.restore();
                    }
                } else {
                    com.tencent.mm.svg.c.c.i("MicroMsg.SVGPictureDrawable", "Skip this draw.", new Object[0]);
                    return;
                }
            }
            this.Ov = b.et(byk);
            f(canvas);
        } finally {
            this.Ov = b.et(byk);
            f(canvas);
        }
    }
}
