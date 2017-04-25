package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.v4.b.a.c;
import android.util.AttributeSet;
import android.widget.ProgressBar;

class j {
    private static final int[] Pf = new int[]{16843067, 16843068};
    final h Ts;
    private final ProgressBar Ua;
    Bitmap Ub;

    j(ProgressBar progressBar, h hVar) {
        this.Ua = progressBar;
        this.Ts = hVar;
    }

    void a(AttributeSet attributeSet, int i) {
        ap a = ap.a(this.Ua.getContext(), attributeSet, Pf, i);
        Drawable by = a.by(0);
        if (by != null) {
            ProgressBar progressBar = this.Ua;
            if (by instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) by;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                Drawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i2 = 0; i2 < numberOfFrames; i2++) {
                    Drawable b = b(animationDrawable.getFrame(i2), true);
                    b.setLevel(10000);
                    animationDrawable2.addFrame(b, animationDrawable.getDuration(i2));
                }
                animationDrawable2.setLevel(10000);
                by = animationDrawable2;
            }
            progressBar.setIndeterminateDrawable(by);
        }
        by = a.by(1);
        if (by != null) {
            this.Ua.setProgressDrawable(b(by, false));
        }
        a.adM.recycle();
    }

    private Drawable b(Drawable drawable, boolean z) {
        int i = 0;
        Drawable bs;
        if (drawable instanceof c) {
            bs = ((c) drawable).bs();
            if (bs == null) {
                return drawable;
            }
            ((c) drawable).j(b(bs, z));
            return drawable;
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                boolean z2;
                int id = layerDrawable.getId(i2);
                Drawable drawable2 = layerDrawable.getDrawable(i2);
                if (id == 16908301 || id == 16908303) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                drawableArr[i2] = b(drawable2, z2);
            }
            bs = new LayerDrawable(drawableArr);
            while (i < numberOfLayers) {
                bs.setId(i, layerDrawable.getId(i));
                i++;
            }
            return bs;
        } else if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        } else {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.Ub == null) {
                this.Ub = bitmap;
            }
            bs = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            bs.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
            bs.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(bs, 3, 1) : bs;
        }
    }
}
