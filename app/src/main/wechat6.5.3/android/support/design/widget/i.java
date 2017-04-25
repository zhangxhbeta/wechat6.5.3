package android.support.design.widget;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class i {
    private static Method hG;
    private static boolean hH;
    private static Field hI;
    private static boolean hJ;

    static boolean a(DrawableContainer drawableContainer, ConstantState constantState) {
        if (!hH) {
            try {
                Method declaredMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[]{DrawableContainerState.class});
                hG = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            hH = true;
        }
        if (hG != null) {
            try {
                hG.invoke(drawableContainer, new Object[]{constantState});
                return true;
            } catch (Exception e2) {
            }
        }
        return false;
    }

    static boolean b(DrawableContainer drawableContainer, ConstantState constantState) {
        if (!hJ) {
            try {
                Field declaredField = DrawableContainer.class.getDeclaredField("mDrawableContainerStateField");
                hI = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            hJ = true;
        }
        if (hI != null) {
            try {
                hI.set(drawableContainer, constantState);
                return true;
            } catch (Exception e2) {
            }
        }
        return false;
    }
}
