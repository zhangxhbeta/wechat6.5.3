package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

final class ag {
    public static boolean a(ViewParent viewParent, View view, View view2, int i) {
        try {
            return viewParent.onStartNestedScroll(view, view2, i);
        } catch (AbstractMethodError e) {
            new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onStartNestedScroll");
            return false;
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        try {
            return viewParent.onNestedFling(view, f, f2, z);
        } catch (AbstractMethodError e) {
            new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedFling");
            return false;
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2) {
        try {
            return viewParent.onNestedPreFling(view, f, f2);
        } catch (AbstractMethodError e) {
            new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedPreFling");
            return false;
        }
    }
}
