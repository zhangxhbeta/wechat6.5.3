package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

public final class r {
    static final f DP;

    interface f {
        void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4);

        int c(TextView textView);
    }

    static class b implements f {
        b() {
        }

        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, null, null, null);
        }

        public int c(TextView textView) {
            if (!s.DT) {
                s.DS = s.n("mMaxMode");
                s.DT = true;
            }
            if (s.DS != null && s.a(s.DS, textView) == 1) {
                if (!s.DR) {
                    s.DQ = s.n("mMaximum");
                    s.DR = true;
                }
                if (s.DQ != null) {
                    return s.a(s.DQ, textView);
                }
            }
            return -1;
        }
    }

    static class e extends b {
        e() {
        }

        public final int c(TextView textView) {
            return textView.getMaxLines();
        }
    }

    static class c extends e {
        c() {
        }

        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            Object obj = textView.getLayoutDirection() == 1 ? 1 : null;
            Drawable drawable5 = obj != null ? null : drawable;
            if (obj == null) {
                drawable = null;
            }
            textView.setCompoundDrawables(drawable5, null, drawable, null);
        }
    }

    static class d extends c {
        d() {
        }

        public final void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, null, null, null);
        }
    }

    static class a extends d {
        a() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            DP = new a();
        } else if (i >= 18) {
            DP = new d();
        } else if (i >= 17) {
            DP = new c();
        } else if (i >= 16) {
            DP = new e();
        } else {
            DP = new b();
        }
    }

    public static void a(TextView textView, Drawable drawable) {
        DP.a(textView, drawable, null, null, null);
    }

    public static int c(TextView textView) {
        return DP.c(textView);
    }
}
