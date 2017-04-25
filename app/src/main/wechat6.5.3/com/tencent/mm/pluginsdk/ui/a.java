package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import junit.framework.Assert;

public final class a extends h implements com.tencent.mm.u.d.a {

    public interface a {
        void doInvalidate();

        Drawable getDrawable();

        void setImageDrawable(Drawable drawable);
    }

    public static class b {
        public static com.tencent.mm.pluginsdk.ui.h.a hXG;

        public static com.tencent.mm.pluginsdk.ui.h.a box() {
            Assert.assertTrue(hXG != null);
            return hXG;
        }

        public static void m(ImageView imageView, String str) {
            if (imageView == null) {
                v.e("MicroMsg.AvatarDrawable", "imageView is null");
                return;
            }
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof a)) {
                drawable = new a(str);
            } else {
                drawable = (a) drawable;
            }
            drawable.Ho(str);
            imageView.setImageDrawable(drawable);
            imageView.invalidate();
        }

        public static void o(ImageView imageView, String str) {
            a(imageView, str, 0.5f, false);
        }

        public static void p(ImageView imageView, String str) {
            a(imageView, str, 0.5f, true);
        }

        public static void a(ImageView imageView, String str, float f, boolean z) {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof b)) {
                drawable = new b(str, f);
                drawable.hS(z);
            } else {
                drawable = (b) drawable;
            }
            drawable.Ho(str);
            imageView.setImageDrawable(drawable);
            imageView.invalidate();
        }

        public static void b(ImageView imageView, String str, boolean z) {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof a)) {
                drawable = new a(str);
            } else {
                drawable = (a) drawable;
            }
            drawable.Ho(str);
            imageView.setImageDrawable(drawable);
            imageView.invalidate();
        }

        public static void a(a aVar, String str) {
            Drawable drawable = aVar.getDrawable();
            if (drawable == null || !(drawable instanceof a)) {
                drawable = new a(str);
            } else {
                drawable = (a) drawable;
            }
            drawable.Ho(str);
            aVar.setImageDrawable(drawable);
            aVar.doInvalidate();
        }

        public static void d(ImageView imageView, String str, int i) {
            if (imageView != null) {
                Drawable drawable = imageView.getDrawable();
                if (drawable == null || !(drawable instanceof c)) {
                    drawable = new c(str);
                } else {
                    drawable = (c) drawable;
                }
                if (drawable.lGb != i || drawable.lGa == null || drawable.lGa.eAm == null || drawable.lGa.eAm.isRecycled()) {
                    drawable.lGb = i;
                    Bitmap uU = d.uU(i);
                    if (drawable.lGa != null) {
                        drawable.lGa.eAm = uU;
                    }
                }
                drawable.Ho(str);
                imageView.setImageDrawable(drawable);
                imageView.invalidate();
            }
        }
    }

    private a(String str) {
        super(b.hXG, str);
    }

    private a(String str, byte b) {
        super(b.hXG, str, false);
    }

    public final void gM(String str) {
        super.gM(str);
    }
}
