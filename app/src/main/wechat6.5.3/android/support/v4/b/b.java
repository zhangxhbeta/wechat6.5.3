package android.support.v4.b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

public final class b {
    static final b cxD;

    interface b {
        int K(Bitmap bitmap);
    }

    static class a implements b {
        a() {
        }

        public int K(Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    }

    static class c extends a {
        c() {
        }

        public int K(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    static class d extends c {
        d() {
        }
    }

    static class e extends d {
        e() {
        }

        public final int K(Bitmap bitmap) {
            return bitmap.getAllocationByteCount();
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            cxD = new e();
        } else if (i >= 18) {
            cxD = new d();
        } else if (i >= 12) {
            cxD = new c();
        } else {
            cxD = new a();
        }
    }

    public static int K(Bitmap bitmap) {
        return cxD.K(bitmap);
    }
}
