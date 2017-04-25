package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.mm.plugin.gallery.model.b.b;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class f extends Drawable implements b {
    private static final Paint cnN = new Paint();
    private static Rect rect = null;
    protected String aVL = "";
    protected int bcp = 0;
    protected ImageView fqF;
    protected long gdA = 0;
    protected String gdz = "";
    protected boolean gha = false;
    public a ghb;
    long ghc;
    boolean ghd = false;
    private Rect ghe = new Rect();
    private Runnable ghf = new Runnable(this) {
        final /* synthetic */ f ghg;

        {
            this.ghg = r1;
        }

        public final void run() {
            v.v("MicroMsg.ThumbDrawable", "invalidateSelf");
            f fVar = this.ghg;
            com.tencent.mm.plugin.gallery.model.a aqm = c.aqm();
            String str = this.ghg.aVL;
            String str2 = this.ghg.gdz;
            long j = this.ghg.gdA;
            fVar.mBitmap = aqm.tU(str);
            if (!(this.ghg.ghb == null || this.ghg.mBitmap == null || this.ghg.mBitmap.isRecycled())) {
                this.ghg.ghb.aqP();
            }
            this.ghg.ghc = SystemClock.uptimeMillis();
            this.ghg.invalidateSelf();
        }
    };
    private Bitmap mBitmap;

    public interface a {
        void aqP();
    }

    static {
        cnN.setAntiAlias(true);
        cnN.setFilterBitmap(true);
    }

    private f(ImageView imageView) {
        this.fqF = imageView;
        this.aVL = "";
    }

    public final int getIntrinsicWidth() {
        return 400;
    }

    public final int getIntrinsicHeight() {
        return 400;
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        v.v("MicroMsg.ThumbDrawable", "setBountsLTRB:%d %d - %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        super.setBounds(i, i2, i3, i4);
    }

    public final void setBounds(Rect rect) {
        v.v("MicroMsg.ThumbDrawable", "setBountsRECT:%s", new Object[]{rect.toString()});
        super.setBounds(rect);
    }

    public final void draw(Canvas canvas) {
        float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.ghc)) / 200.0f;
        if (this.ghc == 0) {
            v.d("MicroMsg.ThumbDrawable", "[duanyi test]: draw:[%s] startTimeMillis is 0", new Object[]{this.aVL});
            uptimeMillis = 0.0f;
        }
        v.d("MicroMsg.ThumbDrawable", "[duanyi test]: hash:[%s] draw:[%s] animating:[%s] normalized:[%s] alpha[%s]", new Object[]{Integer.valueOf(hashCode()), this.aVL, Boolean.valueOf(this.ghd), Float.valueOf(uptimeMillis), Integer.valueOf((int) (255.0f * uptimeMillis))});
        if (!this.ghd) {
            c(canvas, 255);
            setAlpha(255);
        } else if (uptimeMillis >= 1.0f) {
            this.ghd = false;
            c(canvas, 255);
        } else if (c(canvas, (int) (uptimeMillis * 255.0f))) {
            invalidateSelf();
        }
    }

    private boolean c(Canvas canvas, int i) {
        if (this.mBitmap == null || this.mBitmap.isRecycled()) {
            v.d("MicroMsg.ThumbDrawable", "[duanyi test] get bitmap is null: " + this.aVL);
            if (this.mBitmap != null && this.mBitmap.isRecycled()) {
                this.ghd = true;
                this.ghc = 0;
                this.mBitmap = c.aqm().b(this.aVL, this.bcp, this.gdz, this.gdA);
                if (!(this.ghb == null || this.mBitmap == null || this.mBitmap.isRecycled())) {
                    this.ghb.aqP();
                }
            }
            return false;
        }
        v.d("MicroMsg.ThumbDrawable", "[duanyi test] get bitmap ok:" + this.aVL);
        Bitmap bitmap = this.mBitmap;
        Rect rect = this.ghe;
        if (bitmap.getWidth() > bitmap.getHeight()) {
            rect.top = 0;
            rect.bottom = bitmap.getHeight();
            rect.left = (bitmap.getWidth() - bitmap.getHeight()) >> 1;
            rect.right = bitmap.getHeight() + rect.left;
        } else {
            rect.left = 0;
            rect.right = bitmap.getWidth();
            rect.top = (bitmap.getHeight() - bitmap.getWidth()) >> 1;
            rect.bottom = bitmap.getWidth() + rect.top;
        }
        cnN.setAlpha(i);
        canvas.drawBitmap(this.mBitmap, this.ghe, getBounds(), cnN);
        v.v("MicroMsg.ThumbDrawable", "Bounts:%s", new Object[]{getBounds().toString()});
        return true;
    }

    public final void tV(String str) {
        if (be.kS(str)) {
            v.d("MicroMsg.ThumbDrawable", "filepath is null or nill");
        } else if (this.aVL.equals(str)) {
            v.d("MicroMsg.ThumbDrawable", "notify thumb get " + str);
            this.fqF.post(this.ghf);
        } else {
            v.d("MicroMsg.ThumbDrawable", "not current filepath:[%s]", new Object[]{str});
        }
    }

    public static void a(ImageView imageView, int i, String str, String str2, long j) {
        a(imageView, i, str, str2, j, -1, null);
    }

    public static void a(ImageView imageView, int i, String str, String str2, long j, int i2, a aVar) {
        Drawable fVar;
        String str3;
        Drawable drawable = imageView.getDrawable();
        if (drawable == null || !(drawable instanceof f)) {
            fVar = new f(imageView);
        } else {
            fVar = (f) drawable;
        }
        fVar.ghb = aVar;
        if (be.kS(str)) {
            str3 = str2;
        } else {
            str3 = str;
        }
        if (be.kS(str3)) {
            v.e("MicroMsg.ThumbDrawable", "filepath is null or nil");
        } else {
            if (be.kS(str)) {
                fVar.gha = false;
            } else {
                fVar.gha = true;
            }
            com.tencent.mm.plugin.gallery.model.b bVar = c.aqm().gdr;
            if (bVar.cyf.size() > 64) {
                b bVar2 = (b) bVar.cyf.remove(0);
                v.i("MicroMsg.GalleryCache", "has exceed the max listener size[%d], remove some listeners[%s]", new Object[]{Integer.valueOf(64), bVar2});
            }
            v.v("MicroMsg.GalleryCache", "try add listener[%s]", new Object[]{fVar});
            if (!bVar.cyf.contains(fVar)) {
                v.d("MicroMsg.GalleryCache", "add listener[%s] ok", new Object[]{fVar});
                bVar.cyf.add(fVar);
            }
            String str4;
            String str5;
            Object[] objArr;
            if (!fVar.aVL.equals(str3) || fVar.mBitmap == null || fVar.mBitmap.isRecycled()) {
                fVar.aVL = str3;
                fVar.gdz = str2;
                fVar.gdA = j;
                fVar.bcp = i;
                fVar.mBitmap = c.aqm().tU(fVar.aVL);
                str4 = "MicroMsg.ThumbDrawable";
                str5 = "setMediaFeature ok filePath:[%s] mBitmap:[%s], mBitmap.isRecycled():[%s]";
                objArr = new Object[3];
                objArr[0] = str3;
                objArr[1] = Boolean.valueOf(fVar.mBitmap == null);
                objArr[2] = Boolean.valueOf(fVar.mBitmap != null ? fVar.mBitmap.isRecycled() : false);
                v.d(str4, str5, objArr);
                if (fVar.mBitmap == null || fVar.mBitmap.isRecycled()) {
                    fVar.ghd = true;
                    fVar.ghc = 0;
                    fVar.mBitmap = c.aqm().b(str3, i, str2, j);
                } else {
                    fVar.ghd = false;
                }
                if (!(fVar.ghb == null || fVar.mBitmap == null || fVar.mBitmap.isRecycled())) {
                    fVar.ghb.aqP();
                }
                fVar.fqF.invalidate();
            } else {
                str4 = "MicroMsg.ThumbDrawable";
                str5 = "setMediaFeature fuck filePath:[%s] mBitmap:[%s], mBitmap.isRecycled():[%s]";
                objArr = new Object[3];
                objArr[0] = str3;
                objArr[1] = Boolean.valueOf(fVar.mBitmap == null);
                objArr[2] = Boolean.valueOf(fVar.mBitmap != null ? fVar.mBitmap.isRecycled() : false);
                v.d(str4, str5, objArr);
            }
        }
        imageView.setImageDrawable(fVar);
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return 0;
    }
}
