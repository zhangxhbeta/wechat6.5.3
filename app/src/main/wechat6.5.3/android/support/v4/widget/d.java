package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

final class d {
    private static Field Ap;
    private static boolean Aq;

    static Drawable a(CompoundButton compoundButton) {
        if (!Aq) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                Ap = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            Aq = true;
        }
        if (Ap != null) {
            try {
                return (Drawable) Ap.get(compoundButton);
            } catch (IllegalAccessException e2) {
                Ap = null;
            }
        }
        return null;
    }
}
