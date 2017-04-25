package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.b.a.a;
import android.support.v4.b.a.c;
import java.lang.reflect.Field;

public final class w {
    public static final Rect VI = new Rect();
    private static Class<?> VJ;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                VJ = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    public static Rect m(Drawable drawable) {
        if (VJ != null) {
            try {
                Drawable h = a.h(drawable);
                Object invoke = h.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(h, new Object[0]);
                if (invoke != null) {
                    Rect rect = new Rect();
                    for (Field field : VJ.getFields()) {
                        String name = field.getName();
                        Object obj = -1;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    obj = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    obj = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    obj = null;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    obj = 2;
                                    break;
                                }
                                break;
                        }
                        switch (obj) {
                            case null:
                                rect.left = field.getInt(invoke);
                                break;
                            case 1:
                                rect.top = field.getInt(invoke);
                                break;
                            case 2:
                                rect.right = field.getInt(invoke);
                                break;
                            case 3:
                                rect.bottom = field.getInt(invoke);
                                break;
                            default:
                                break;
                        }
                    }
                    return rect;
                }
            } catch (Exception e) {
            }
        }
        return VI;
    }

    static void n(Drawable drawable) {
        if (VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            int[] state = drawable.getState();
            if (state == null || state.length == 0) {
                drawable.setState(al.dM);
            } else {
                drawable.setState(al.EMPTY_STATE_SET);
            }
            drawable.setState(state);
        }
    }

    public static boolean o(Drawable drawable) {
        Drawable drawable2 = drawable;
        while (!(drawable2 instanceof LayerDrawable)) {
            if (drawable2 instanceof InsetDrawable) {
                return VERSION.SDK_INT >= 14;
            } else {
                if (drawable2 instanceof StateListDrawable) {
                    return VERSION.SDK_INT >= 8;
                } else {
                    if (drawable2 instanceof GradientDrawable) {
                        return VERSION.SDK_INT >= 14;
                    } else {
                        if (drawable2 instanceof DrawableContainer) {
                            ConstantState constantState = drawable2.getConstantState();
                            if (constantState instanceof DrawableContainerState) {
                                for (Drawable o : ((DrawableContainerState) constantState).getChildren()) {
                                    if (!o(o)) {
                                        return false;
                                    }
                                }
                            }
                        } else if (drawable2 instanceof c) {
                            drawable2 = ((c) drawable2).bs();
                        } else if (drawable2 instanceof android.support.v7.c.a.a) {
                            drawable2 = ((android.support.v7.c.a.a) drawable2).mDrawable;
                        } else if (drawable2 instanceof ScaleDrawable) {
                            drawable2 = ((ScaleDrawable) drawable2).getDrawable();
                        }
                        return true;
                    }
                }
            }
        }
        if (VERSION.SDK_INT >= 16) {
            return true;
        }
        return false;
    }

    static Mode aO(int i) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return VERSION.SDK_INT >= 11 ? Mode.valueOf("ADD") : null;
            default:
                return null;
        }
    }
}
