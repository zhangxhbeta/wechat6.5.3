package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class a {
    static final b ts;

    interface b {
        void a(Drawable drawable, float f, float f2);

        void a(Drawable drawable, int i);

        void a(Drawable drawable, int i, int i2, int i3, int i4);

        void a(Drawable drawable, ColorStateList colorStateList);

        void a(Drawable drawable, Theme theme);

        void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);

        void a(Drawable drawable, Mode mode);

        void a(Drawable drawable, boolean z);

        void b(Drawable drawable);

        void b(Drawable drawable, int i);

        boolean c(Drawable drawable);

        int d(Drawable drawable);

        boolean e(Drawable drawable);

        ColorFilter f(Drawable drawable);

        Drawable g(Drawable drawable);

        int i(Drawable drawable);
    }

    static class a implements b {
        a() {
        }

        public void b(Drawable drawable) {
        }

        public void a(Drawable drawable, boolean z) {
        }

        public boolean c(Drawable drawable) {
            return false;
        }

        public void a(Drawable drawable, float f, float f2) {
        }

        public void a(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public void a(Drawable drawable, int i) {
            if (drawable instanceof c) {
                ((c) drawable).M(i);
            }
        }

        public void a(Drawable drawable, ColorStateList colorStateList) {
            if (drawable instanceof c) {
                ((c) drawable).d(colorStateList);
            }
        }

        public void a(Drawable drawable, Mode mode) {
            if (drawable instanceof c) {
                ((c) drawable).a(mode);
            }
        }

        public Drawable g(Drawable drawable) {
            return !(drawable instanceof d) ? new d(drawable) : drawable;
        }

        public void b(Drawable drawable, int i) {
        }

        public int i(Drawable drawable) {
            return 0;
        }

        public int d(Drawable drawable) {
            return 0;
        }

        public void a(Drawable drawable, Theme theme) {
        }

        public boolean e(Drawable drawable) {
            return false;
        }

        public ColorFilter f(Drawable drawable) {
            return null;
        }

        public void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    static class c extends a {
        c() {
        }

        public Drawable g(Drawable drawable) {
            return !(drawable instanceof e) ? new e(drawable) : drawable;
        }
    }

    static class d extends c {
        d() {
        }

        public final void b(Drawable drawable) {
            drawable.jumpToCurrentState();
        }

        public Drawable g(Drawable drawable) {
            return !(drawable instanceof f) ? new f(drawable) : drawable;
        }
    }

    static class e extends d {
        e() {
        }

        public void b(Drawable drawable, int i) {
            if (!b.tu) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                    b.tt = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                }
                b.tu = true;
            }
            if (b.tt != null) {
                try {
                    b.tt.invoke(drawable, new Object[]{Integer.valueOf(i)});
                } catch (Exception e2) {
                    b.tt = null;
                }
            }
        }

        public int i(Drawable drawable) {
            int i = b.i(drawable);
            return i >= 0 ? i : 0;
        }
    }

    static class f extends e {
        f() {
        }

        public final void a(Drawable drawable, boolean z) {
            drawable.setAutoMirrored(z);
        }

        public final boolean c(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        public Drawable g(Drawable drawable) {
            return !(drawable instanceof g) ? new g(drawable) : drawable;
        }

        public final int d(Drawable drawable) {
            return drawable.getAlpha();
        }
    }

    static class g extends f {
        g() {
        }

        public final void a(Drawable drawable, float f, float f2) {
            drawable.setHotspot(f, f2);
        }

        public final void a(Drawable drawable, int i, int i2, int i3, int i4) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }

        public final void a(Drawable drawable, int i) {
            drawable.setTint(i);
        }

        public final void a(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        public final void a(Drawable drawable, Mode mode) {
            drawable.setTintMode(mode);
        }

        public Drawable g(Drawable drawable) {
            return !(drawable instanceof h) ? new h(drawable) : drawable;
        }

        public final void a(Drawable drawable, Theme theme) {
            drawable.applyTheme(theme);
        }

        public final boolean e(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        public final ColorFilter f(Drawable drawable) {
            return drawable.getColorFilter();
        }

        public final void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }
    }

    static class h extends g {
        h() {
        }

        public final void b(Drawable drawable, int i) {
            drawable.setLayoutDirection(i);
        }

        public final int i(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        public final Drawable g(Drawable drawable) {
            return drawable;
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            ts = new h();
        } else if (i >= 21) {
            ts = new g();
        } else if (i >= 19) {
            ts = new f();
        } else if (i >= 17) {
            ts = new e();
        } else if (i >= 11) {
            ts = new d();
        } else if (i >= 5) {
            ts = new c();
        } else {
            ts = new a();
        }
    }

    public static void b(Drawable drawable) {
        ts.b(drawable);
    }

    public static void a(Drawable drawable, boolean z) {
        ts.a(drawable, z);
    }

    public static boolean c(Drawable drawable) {
        return ts.c(drawable);
    }

    public static void a(Drawable drawable, float f, float f2) {
        ts.a(drawable, f, f2);
    }

    public static void a(Drawable drawable, int i, int i2, int i3, int i4) {
        ts.a(drawable, i, i2, i3, i4);
    }

    public static void a(Drawable drawable, int i) {
        ts.a(drawable, i);
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        ts.a(drawable, colorStateList);
    }

    public static void a(Drawable drawable, Mode mode) {
        ts.a(drawable, mode);
    }

    public static int d(Drawable drawable) {
        return ts.d(drawable);
    }

    public static void a(Drawable drawable, Theme theme) {
        ts.a(drawable, theme);
    }

    public static boolean e(Drawable drawable) {
        return ts.e(drawable);
    }

    public static ColorFilter f(Drawable drawable) {
        return ts.f(drawable);
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        ts.a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static Drawable g(Drawable drawable) {
        return ts.g(drawable);
    }

    public static <T extends Drawable> T h(Drawable drawable) {
        if (drawable instanceof c) {
            return ((c) drawable).bs();
        }
        return drawable;
    }

    public static void b(Drawable drawable, int i) {
        ts.b(drawable, i);
    }

    public static int i(Drawable drawable) {
        return ts.i(drawable);
    }
}
