package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Field;

final class n {
    private static Field Cz;

    static {
        try {
            Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            Cz = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
        }
    }

    static void a(PopupWindow popupWindow, boolean z) {
        if (Cz != null) {
            try {
                Cz.set(popupWindow, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
            }
        }
    }
}
