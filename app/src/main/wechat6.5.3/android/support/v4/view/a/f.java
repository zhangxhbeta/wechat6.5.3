package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityRecord;

public final class f {
    public static final c zz;
    public final Object zA;

    interface c {
        Object cm();

        void e(Object obj, int i);

        void f(Object obj, int i);

        void f(Object obj, boolean z);

        void g(Object obj, int i);

        void h(Object obj, int i);

        void i(Object obj, int i);

        void j(Object obj, int i);

        void k(Object obj, int i);
    }

    static class e implements c {
        e() {
        }

        public Object cm() {
            return null;
        }

        public void e(Object obj, int i) {
        }

        public void f(Object obj, int i) {
        }

        public void j(Object obj, int i) {
        }

        public void k(Object obj, int i) {
        }

        public void g(Object obj, int i) {
        }

        public void h(Object obj, int i) {
        }

        public void f(Object obj, boolean z) {
        }

        public void i(Object obj, int i) {
        }
    }

    static class a extends e {
        a() {
        }

        public final Object cm() {
            return AccessibilityRecord.obtain();
        }

        public final void e(Object obj, int i) {
            ((AccessibilityRecord) obj).setFromIndex(i);
        }

        public final void f(Object obj, int i) {
            ((AccessibilityRecord) obj).setItemCount(i);
        }

        public final void g(Object obj, int i) {
            ((AccessibilityRecord) obj).setScrollX(i);
        }

        public final void h(Object obj, int i) {
            ((AccessibilityRecord) obj).setScrollY(i);
        }

        public final void f(Object obj, boolean z) {
            ((AccessibilityRecord) obj).setScrollable(z);
        }

        public final void i(Object obj, int i) {
            ((AccessibilityRecord) obj).setToIndex(i);
        }
    }

    static class b extends a {
        b() {
        }

        public final void j(Object obj, int i) {
            ((AccessibilityRecord) obj).setMaxScrollX(i);
        }

        public final void k(Object obj, int i) {
            ((AccessibilityRecord) obj).setMaxScrollY(i);
        }
    }

    static class d extends b {
        d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            zz = new d();
        } else if (VERSION.SDK_INT >= 15) {
            zz = new b();
        } else if (VERSION.SDK_INT >= 14) {
            zz = new a();
        } else {
            zz = new e();
        }
    }

    public f(Object obj) {
        this.zA = obj;
    }

    public static f cl() {
        return new f(zz.cm());
    }

    public final void setScrollable(boolean z) {
        zz.f(this.zA, z);
    }

    public final void setItemCount(int i) {
        zz.f(this.zA, i);
    }

    public final void setFromIndex(int i) {
        zz.e(this.zA, i);
    }

    public final void setToIndex(int i) {
        zz.i(this.zA, i);
    }

    public final int hashCode() {
        return this.zA == null ? 0 : this.zA.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.zA == null) {
            if (fVar.zA != null) {
                return false;
            }
            return true;
        } else if (this.zA.equals(fVar.zA)) {
            return true;
        } else {
            return false;
        }
    }
}
