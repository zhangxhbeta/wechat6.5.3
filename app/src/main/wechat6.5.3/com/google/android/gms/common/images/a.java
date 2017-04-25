package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.c.k;
import com.google.android.gms.c.l;
import com.google.android.gms.common.internal.v;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public abstract class a {
    final a anB;
    protected int anC;
    protected int anD;

    static final class a {
        public final Uri uri;

        public a(Uri uri) {
            this.uri = uri;
        }

        public final boolean equals(Object obj) {
            return !(obj instanceof a) ? false : this == obj ? true : v.d(((a) obj).uri, this.uri);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.uri});
        }
    }

    public static final class b extends a {
        private WeakReference<com.google.android.gms.common.images.ImageManager.a> anE;

        public final boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            b bVar = (b) obj;
            com.google.android.gms.common.images.ImageManager.a aVar = (com.google.android.gms.common.images.ImageManager.a) this.anE.get();
            com.google.android.gms.common.images.ImageManager.a aVar2 = (com.google.android.gms.common.images.ImageManager.a) bVar.anE.get();
            return aVar2 != null && aVar != null && v.d(aVar2, aVar) && v.d(bVar.anB, this.anB);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.anB});
        }

        protected final void jM() {
            this.anE.get();
        }
    }

    final void a(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("null reference");
        }
        if ((this.anD & 1) != 0) {
            bitmap = k.b(bitmap);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        jM();
    }

    final void a(Context context, l lVar) {
        if (this.anC != 0) {
            int i = this.anC;
            Resources resources = context.getResources();
            if (this.anD > 0) {
                com.google.android.gms.c.l.a aVar = new com.google.android.gms.c.l.a(i, this.anD);
                if (((Drawable) lVar.get(aVar)) == null) {
                    Object drawable = resources.getDrawable(i);
                    if ((this.anD & 1) != 0) {
                        Bitmap bitmap;
                        if (drawable == null) {
                            bitmap = null;
                        } else if (drawable instanceof BitmapDrawable) {
                            bitmap = ((BitmapDrawable) drawable).getBitmap();
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                            drawable.draw(canvas);
                            bitmap = createBitmap;
                        }
                        drawable = new BitmapDrawable(resources, k.b(bitmap));
                    }
                    lVar.put(aVar, drawable);
                }
            } else {
                resources.getDrawable(i);
            }
        }
        jM();
    }

    protected abstract void jM();
}
