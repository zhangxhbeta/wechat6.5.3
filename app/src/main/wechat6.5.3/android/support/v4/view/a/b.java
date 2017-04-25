package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mmdb.FileUtils;

public final class b {
    public static final e yS;
    public final Object yT;

    public static class a {
        public static final a yU = new a(1);
        public static final a yV = new a(2);
        public static final a yW = new a(4);
        public static final a yX = new a(8);
        public static final a yY = new a(16);
        public static final a yZ = new a(32);
        public static final a za = new a(64);
        public static final a zb = new a((int) FileUtils.S_IWUSR);
        public static final a zc = new a((int) FileUtils.S_IRUSR);
        public static final a zd = new a(512);
        public static final a ze = new a(1024);
        public static final a zf = new a(2048);
        public static final a zg = new a(4096);
        public static final a zh = new a(8192);
        public static final a zi = new a(16384);
        public static final a zj = new a((int) WXMediaMessage.THUMB_LENGTH_LIMIT);
        public static final a zk = new a(65536);
        public static final a zl = new a(131072);
        public static final a zm = new a(262144);
        public static final a zn = new a(524288);
        public static final a zo = new a(1048576);
        public static final a zp = new a(2097152);
        private final Object zq;

        private a(int i) {
            this(b.yS.a(i, null));
        }

        private a(Object obj) {
            this.zq = obj;
        }
    }

    interface e {
        boolean A(Object obj);

        void B(Object obj);

        int C(Object obj);

        boolean D(Object obj);

        boolean E(Object obj);

        String F(Object obj);

        Object a(int i, int i2, int i3, int i4, boolean z, boolean z2);

        Object a(int i, int i2, boolean z, int i3);

        Object a(int i, CharSequence charSequence);

        void a(Object obj, Rect rect);

        void a(Object obj, CharSequence charSequence);

        void a(Object obj, boolean z);

        void b(Object obj, Rect rect);

        void b(Object obj, CharSequence charSequence);

        void b(Object obj, boolean z);

        void c(Object obj, int i);

        void c(Object obj, Rect rect);

        void c(Object obj, View view);

        void c(Object obj, CharSequence charSequence);

        void c(Object obj, boolean z);

        void d(Object obj, int i);

        void d(Object obj, Rect rect);

        void d(Object obj, View view);

        void d(Object obj, CharSequence charSequence);

        void d(Object obj, boolean z);

        void e(Object obj, View view);

        void e(Object obj, CharSequence charSequence);

        void e(Object obj, boolean z);

        boolean e(Object obj, Object obj2);

        void f(Object obj, View view);

        void f(Object obj, Object obj2);

        void f(Object obj, boolean z);

        void g(Object obj, Object obj2);

        void g(Object obj, boolean z);

        void h(Object obj, boolean z);

        void i(Object obj, boolean z);

        void j(Object obj, boolean z);

        Object l(Object obj);

        int m(Object obj);

        CharSequence n(Object obj);

        CharSequence o(Object obj);

        CharSequence p(Object obj);

        CharSequence q(Object obj);

        boolean r(Object obj);

        boolean s(Object obj);

        boolean t(Object obj);

        boolean u(Object obj);

        boolean v(Object obj);

        boolean w(Object obj);

        boolean x(Object obj);

        boolean y(Object obj);

        boolean z(Object obj);
    }

    public static class k {
        public final Object yT;

        public k(Object obj) {
            this.yT = obj;
        }
    }

    public static class l {
        final Object yT;

        public static l a(int i, int i2, int i3, int i4, boolean z) {
            return new l(b.yS.a(i, i2, i3, i4, z, false));
        }

        private l(Object obj) {
            this.yT = obj;
        }
    }

    static class j implements e {
        j() {
        }

        public Object a(int i, CharSequence charSequence) {
            return null;
        }

        public Object l(Object obj) {
            return null;
        }

        public void c(Object obj, int i) {
        }

        public boolean e(Object obj, Object obj2) {
            return false;
        }

        public void c(Object obj, View view) {
        }

        public int m(Object obj) {
            return 0;
        }

        public void a(Object obj, Rect rect) {
        }

        public void b(Object obj, Rect rect) {
        }

        public CharSequence n(Object obj) {
            return null;
        }

        public CharSequence o(Object obj) {
            return null;
        }

        public CharSequence p(Object obj) {
            return null;
        }

        public CharSequence q(Object obj) {
            return null;
        }

        public boolean r(Object obj) {
            return false;
        }

        public boolean s(Object obj) {
            return false;
        }

        public boolean t(Object obj) {
            return false;
        }

        public boolean u(Object obj) {
            return false;
        }

        public boolean v(Object obj) {
            return false;
        }

        public boolean w(Object obj) {
            return false;
        }

        public boolean D(Object obj) {
            return false;
        }

        public boolean E(Object obj) {
            return false;
        }

        public boolean x(Object obj) {
            return false;
        }

        public boolean y(Object obj) {
            return false;
        }

        public boolean z(Object obj) {
            return false;
        }

        public boolean A(Object obj) {
            return false;
        }

        public void d(Object obj, int i) {
        }

        public int C(Object obj) {
            return 0;
        }

        public void c(Object obj, Rect rect) {
        }

        public void d(Object obj, Rect rect) {
        }

        public void b(Object obj, CharSequence charSequence) {
        }

        public void a(Object obj, boolean z) {
        }

        public void c(Object obj, CharSequence charSequence) {
        }

        public void b(Object obj, boolean z) {
        }

        public void c(Object obj, boolean z) {
        }

        public void d(Object obj, boolean z) {
        }

        public void h(Object obj, boolean z) {
        }

        public void i(Object obj, boolean z) {
        }

        public void e(Object obj, boolean z) {
        }

        public void d(Object obj, CharSequence charSequence) {
        }

        public void d(Object obj, View view) {
        }

        public void f(Object obj, boolean z) {
        }

        public void g(Object obj, boolean z) {
        }

        public void e(Object obj, View view) {
        }

        public void e(Object obj, CharSequence charSequence) {
        }

        public void B(Object obj) {
        }

        public String F(Object obj) {
            return null;
        }

        public void f(Object obj, Object obj2) {
        }

        public void g(Object obj, Object obj2) {
        }

        public Object a(int i, int i2, boolean z, int i3) {
            return null;
        }

        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return null;
        }

        public void j(Object obj, boolean z) {
        }

        public void a(Object obj, CharSequence charSequence) {
        }

        public void f(Object obj, View view) {
        }
    }

    static class d extends j {
        d() {
        }

        public final Object l(Object obj) {
            return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo) obj);
        }

        public final void c(Object obj, int i) {
            ((AccessibilityNodeInfo) obj).addAction(i);
        }

        public final void c(Object obj, View view) {
            ((AccessibilityNodeInfo) obj).addChild(view);
        }

        public final int m(Object obj) {
            return ((AccessibilityNodeInfo) obj).getActions();
        }

        public final void a(Object obj, Rect rect) {
            ((AccessibilityNodeInfo) obj).getBoundsInParent(rect);
        }

        public final void b(Object obj, Rect rect) {
            ((AccessibilityNodeInfo) obj).getBoundsInScreen(rect);
        }

        public final CharSequence n(Object obj) {
            return ((AccessibilityNodeInfo) obj).getClassName();
        }

        public final CharSequence o(Object obj) {
            return ((AccessibilityNodeInfo) obj).getContentDescription();
        }

        public final CharSequence p(Object obj) {
            return ((AccessibilityNodeInfo) obj).getPackageName();
        }

        public final CharSequence q(Object obj) {
            return ((AccessibilityNodeInfo) obj).getText();
        }

        public final boolean r(Object obj) {
            return ((AccessibilityNodeInfo) obj).isCheckable();
        }

        public final boolean s(Object obj) {
            return ((AccessibilityNodeInfo) obj).isChecked();
        }

        public final boolean t(Object obj) {
            return ((AccessibilityNodeInfo) obj).isClickable();
        }

        public final boolean u(Object obj) {
            return ((AccessibilityNodeInfo) obj).isEnabled();
        }

        public final boolean v(Object obj) {
            return ((AccessibilityNodeInfo) obj).isFocusable();
        }

        public final boolean w(Object obj) {
            return ((AccessibilityNodeInfo) obj).isFocused();
        }

        public final boolean x(Object obj) {
            return ((AccessibilityNodeInfo) obj).isLongClickable();
        }

        public final boolean y(Object obj) {
            return ((AccessibilityNodeInfo) obj).isPassword();
        }

        public final boolean z(Object obj) {
            return ((AccessibilityNodeInfo) obj).isScrollable();
        }

        public final boolean A(Object obj) {
            return ((AccessibilityNodeInfo) obj).isSelected();
        }

        public final void c(Object obj, Rect rect) {
            ((AccessibilityNodeInfo) obj).setBoundsInParent(rect);
        }

        public final void d(Object obj, Rect rect) {
            ((AccessibilityNodeInfo) obj).setBoundsInScreen(rect);
        }

        public final void b(Object obj, CharSequence charSequence) {
            ((AccessibilityNodeInfo) obj).setClassName(charSequence);
        }

        public final void a(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setClickable(z);
        }

        public final void c(Object obj, CharSequence charSequence) {
            ((AccessibilityNodeInfo) obj).setContentDescription(charSequence);
        }

        public final void b(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setEnabled(z);
        }

        public final void c(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setFocusable(z);
        }

        public final void d(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setFocused(z);
        }

        public final void e(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setLongClickable(z);
        }

        public final void d(Object obj, CharSequence charSequence) {
            ((AccessibilityNodeInfo) obj).setPackageName(charSequence);
        }

        public final void d(Object obj, View view) {
            ((AccessibilityNodeInfo) obj).setParent(view);
        }

        public final void f(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setScrollable(z);
        }

        public final void g(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setSelected(z);
        }

        public final void e(Object obj, View view) {
            ((AccessibilityNodeInfo) obj).setSource(view);
        }

        public final void e(Object obj, CharSequence charSequence) {
            ((AccessibilityNodeInfo) obj).setText(charSequence);
        }

        public final void B(Object obj) {
            ((AccessibilityNodeInfo) obj).recycle();
        }
    }

    static class f extends d {
        f() {
        }

        public final boolean D(Object obj) {
            return ((AccessibilityNodeInfo) obj).isVisibleToUser();
        }

        public final void h(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setVisibleToUser(z);
        }

        public final boolean E(Object obj) {
            return ((AccessibilityNodeInfo) obj).isAccessibilityFocused();
        }

        public final void i(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setAccessibilityFocused(z);
        }

        public final void d(Object obj, int i) {
            ((AccessibilityNodeInfo) obj).setMovementGranularities(i);
        }

        public final int C(Object obj) {
            return ((AccessibilityNodeInfo) obj).getMovementGranularities();
        }
    }

    static class g extends f {
        g() {
        }

        public final void f(Object obj, View view) {
            ((AccessibilityNodeInfo) obj).setLabelFor(view);
        }
    }

    static class h extends g {
        h() {
        }

        public final String F(Object obj) {
            return ((AccessibilityNodeInfo) obj).getViewIdResourceName();
        }
    }

    static class i extends h {
        i() {
        }

        public final void f(Object obj, Object obj2) {
            ((AccessibilityNodeInfo) obj).setCollectionInfo((CollectionInfo) obj2);
        }

        public Object a(int i, int i2, boolean z, int i3) {
            return CollectionInfo.obtain(i, i2, false);
        }

        public Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return CollectionItemInfo.obtain(i, i2, i3, i4, z);
        }

        public final void g(Object obj, Object obj2) {
            ((AccessibilityNodeInfo) obj).setCollectionItemInfo((CollectionItemInfo) obj2);
        }

        public final void j(Object obj, boolean z) {
            ((AccessibilityNodeInfo) obj).setContentInvalid(true);
        }
    }

    static class b extends i {
        b() {
        }

        public final Object a(int i, CharSequence charSequence) {
            return new AccessibilityAction(i, null);
        }

        public final Object a(int i, int i2, boolean z, int i3) {
            return CollectionInfo.obtain(i, i2, false, 0);
        }

        public final boolean e(Object obj, Object obj2) {
            return ((AccessibilityNodeInfo) obj).removeAction((AccessibilityAction) obj2);
        }

        public final Object a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return CollectionItemInfo.obtain(i, i2, i3, i4, z, false);
        }

        public final void a(Object obj, CharSequence charSequence) {
            ((AccessibilityNodeInfo) obj).setError(charSequence);
        }
    }

    static class c extends b {
        c() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 22) {
            yS = new c();
        } else if (VERSION.SDK_INT >= 21) {
            yS = new b();
        } else if (VERSION.SDK_INT >= 19) {
            yS = new i();
        } else if (VERSION.SDK_INT >= 18) {
            yS = new h();
        } else if (VERSION.SDK_INT >= 17) {
            yS = new g();
        } else if (VERSION.SDK_INT >= 16) {
            yS = new f();
        } else if (VERSION.SDK_INT >= 14) {
            yS = new d();
        } else {
            yS = new j();
        }
    }

    public b(Object obj) {
        this.yT = obj;
    }

    public static b a(b bVar) {
        Object l = yS.l(bVar.yT);
        return l != null ? new b(l) : null;
    }

    public final void setSource(View view) {
        yS.e(this.yT, view);
    }

    public final void addChild(View view) {
        yS.c(this.yT, view);
    }

    public final int getActions() {
        return yS.m(this.yT);
    }

    public final void addAction(int i) {
        yS.c(this.yT, i);
    }

    public final boolean a(a aVar) {
        return yS.e(this.yT, aVar.zq);
    }

    public final void setParent(View view) {
        yS.d(this.yT, view);
    }

    public final void getBoundsInParent(Rect rect) {
        yS.a(this.yT, rect);
    }

    public final void setBoundsInParent(Rect rect) {
        yS.c(this.yT, rect);
    }

    public final void getBoundsInScreen(Rect rect) {
        yS.b(this.yT, rect);
    }

    public final void setBoundsInScreen(Rect rect) {
        yS.d(this.yT, rect);
    }

    public final boolean isFocusable() {
        return yS.v(this.yT);
    }

    public final void setFocusable(boolean z) {
        yS.c(this.yT, z);
    }

    public final boolean isFocused() {
        return yS.w(this.yT);
    }

    public final void setFocused(boolean z) {
        yS.d(this.yT, z);
    }

    public final boolean isVisibleToUser() {
        return yS.D(this.yT);
    }

    public final void setVisibleToUser(boolean z) {
        yS.h(this.yT, z);
    }

    public final boolean isAccessibilityFocused() {
        return yS.E(this.yT);
    }

    public final void setAccessibilityFocused(boolean z) {
        yS.i(this.yT, z);
    }

    public final boolean isSelected() {
        return yS.A(this.yT);
    }

    public final void setSelected(boolean z) {
        yS.g(this.yT, z);
    }

    public final boolean isClickable() {
        return yS.t(this.yT);
    }

    public final void setClickable(boolean z) {
        yS.a(this.yT, z);
    }

    public final boolean isLongClickable() {
        return yS.x(this.yT);
    }

    public final void setLongClickable(boolean z) {
        yS.e(this.yT, z);
    }

    public final boolean isEnabled() {
        return yS.u(this.yT);
    }

    public final void setEnabled(boolean z) {
        yS.b(this.yT, z);
    }

    public final void setScrollable(boolean z) {
        yS.f(this.yT, z);
    }

    public final CharSequence getPackageName() {
        return yS.p(this.yT);
    }

    public final void setPackageName(CharSequence charSequence) {
        yS.d(this.yT, charSequence);
    }

    public final CharSequence getClassName() {
        return yS.n(this.yT);
    }

    public final void setClassName(CharSequence charSequence) {
        yS.b(this.yT, charSequence);
    }

    public final void setText(CharSequence charSequence) {
        yS.e(this.yT, charSequence);
    }

    public final CharSequence getContentDescription() {
        return yS.o(this.yT);
    }

    public final void setContentDescription(CharSequence charSequence) {
        yS.c(this.yT, charSequence);
    }

    public final void recycle() {
        yS.B(this.yT);
    }

    public final void k(Object obj) {
        yS.g(this.yT, ((l) obj).yT);
    }

    public final int hashCode() {
        return this.yT == null ? 0 : this.yT.hashCode();
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
        b bVar = (b) obj;
        if (this.yT == null) {
            if (bVar.yT != null) {
                return false;
            }
            return true;
        } else if (this.yT.equals(bVar.yT)) {
            return true;
        } else {
            return false;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        getBoundsInScreen(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(getPackageName());
        stringBuilder.append("; className: ").append(getClassName());
        stringBuilder.append("; text: ").append(yS.q(this.yT));
        stringBuilder.append("; contentDescription: ").append(getContentDescription());
        stringBuilder.append("; viewId: ").append(yS.F(this.yT));
        stringBuilder.append("; checkable: ").append(yS.r(this.yT));
        stringBuilder.append("; checked: ").append(yS.s(this.yT));
        stringBuilder.append("; focusable: ").append(isFocusable());
        stringBuilder.append("; focused: ").append(isFocused());
        stringBuilder.append("; selected: ").append(isSelected());
        stringBuilder.append("; clickable: ").append(isClickable());
        stringBuilder.append("; longClickable: ").append(isLongClickable());
        stringBuilder.append("; enabled: ").append(isEnabled());
        stringBuilder.append("; password: ").append(yS.y(this.yT));
        stringBuilder.append("; scrollable: " + yS.z(this.yT));
        stringBuilder.append("; [");
        int actions = getActions();
        while (actions != 0) {
            String str;
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(actions);
            int i = (numberOfTrailingZeros ^ -1) & actions;
            switch (numberOfTrailingZeros) {
                case 1:
                    str = "ACTION_FOCUS";
                    break;
                case 2:
                    str = "ACTION_CLEAR_FOCUS";
                    break;
                case 4:
                    str = "ACTION_SELECT";
                    break;
                case 8:
                    str = "ACTION_CLEAR_SELECTION";
                    break;
                case 16:
                    str = "ACTION_CLICK";
                    break;
                case FileUtils.S_IRGRP /*32*/:
                    str = "ACTION_LONG_CLICK";
                    break;
                case FileUtils.S_IXUSR /*64*/:
                    str = "ACTION_ACCESSIBILITY_FOCUS";
                    break;
                case FileUtils.S_IWUSR /*128*/:
                    str = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    break;
                case FileUtils.S_IRUSR /*256*/:
                    str = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    break;
                case 512:
                    str = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    break;
                case 1024:
                    str = "ACTION_NEXT_HTML_ELEMENT";
                    break;
                case 2048:
                    str = "ACTION_PREVIOUS_HTML_ELEMENT";
                    break;
                case 4096:
                    str = "ACTION_SCROLL_FORWARD";
                    break;
                case 8192:
                    str = "ACTION_SCROLL_BACKWARD";
                    break;
                case 16384:
                    str = "ACTION_COPY";
                    break;
                case WXMediaMessage.THUMB_LENGTH_LIMIT /*32768*/:
                    str = "ACTION_PASTE";
                    break;
                case 65536:
                    str = "ACTION_CUT";
                    break;
                case 131072:
                    str = "ACTION_SET_SELECTION";
                    break;
                default:
                    str = "ACTION_UNKNOWN";
                    break;
            }
            stringBuilder.append(str);
            if (i != 0) {
                stringBuilder.append(", ");
            }
            actions = i;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
