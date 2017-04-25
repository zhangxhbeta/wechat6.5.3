package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public final class m {
    static final f Cy;

    interface f {
        void a(PopupWindow popupWindow, int i);

        void a(PopupWindow popupWindow, View view, int i, int i2, int i3);

        void a(PopupWindow popupWindow, boolean z);
    }

    static class c implements f {
        c() {
        }

        public void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2);
        }

        public void a(PopupWindow popupWindow, boolean z) {
        }

        public void a(PopupWindow popupWindow, int i) {
        }
    }

    static class d extends c {
        d() {
        }

        public void a(PopupWindow popupWindow, int i) {
            if (!o.CB) {
                try {
                    Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                    o.CA = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception e) {
                }
                o.CB = true;
            }
            if (o.CA != null) {
                try {
                    o.CA.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
                } catch (Exception e2) {
                }
            }
        }
    }

    static class e extends d {
        e() {
        }

        public final void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2, i3);
        }
    }

    static class a extends e {
        a() {
        }

        public void a(PopupWindow popupWindow, boolean z) {
            n.a(popupWindow, z);
        }
    }

    static class b extends a {
        b() {
        }

        public final void a(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }

        public final void a(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            Cy = new b();
        } else if (i >= 21) {
            Cy = new a();
        } else if (i >= 19) {
            Cy = new e();
        } else if (i >= 9) {
            Cy = new d();
        } else {
            Cy = new c();
        }
    }

    public static void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        Cy.a(popupWindow, view, i, i2, i3);
    }

    public static void a(PopupWindow popupWindow, boolean z) {
        Cy.a(popupWindow, z);
    }

    public static void a(PopupWindow popupWindow, int i) {
        Cy.a(popupWindow, i);
    }
}
