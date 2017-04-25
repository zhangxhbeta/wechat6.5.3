package com.tencent.mm.bd;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class a {
    private static float density = -1.0f;
    private static a neF = null;
    private static SparseIntArray neG = new SparseIntArray();
    private static float neH = 0.0f;

    public interface a {
        int brS();

        ColorStateList brT();

        Drawable brU();

        int brV();

        String brW();
    }

    public static int b(Context context, int i) {
        if (neF != null) {
            return neF.brS();
        }
        if (context != null) {
            return context.getResources().getColor(i);
        }
        v.e("MicroMsg.ResourceHelper", "get color, resId %d, but context is null", Integer.valueOf(i));
        return 0;
    }

    public static ColorStateList M(Context context, int i) {
        if (neF != null) {
            return neF.brT();
        }
        if (context != null) {
            return context.getResources().getColorStateList(i);
        }
        v.e("MicroMsg.ResourceHelper", "get color state list, resId %d, but context is null", Integer.valueOf(i));
        return null;
    }

    public static Drawable a(Context context, int i) {
        if (neF != null) {
            return neF.brU();
        }
        if (context != null) {
            return context.getResources().getDrawable(i);
        }
        v.e("MicroMsg.ResourceHelper", "get drawable, resId %d, but context is null", Integer.valueOf(i));
        return null;
    }

    public static int N(Context context, int i) {
        int i2;
        if (neF != null) {
            i2 = neG.get(i, 0);
            if (i2 == 0) {
                i2 = neF.brV();
                neG.put(i, i2);
            }
            return (int) (((float) i2) * neH);
        } else if (context == null) {
            v.e("MicroMsg.ResourceHelper", "get dimension pixel size, resId %d, but context is null", Integer.valueOf(i));
            return 0;
        } else {
            i2 = neG.get(i, 0);
            if (i2 == 0) {
                i2 = context.getResources().getDimensionPixelSize(i);
                neG.put(i, i2);
            }
            return (int) (((float) i2) * neH);
        }
    }

    public static String O(Context context, int i) {
        if (neF != null) {
            return neF.brW();
        }
        if (context != null) {
            return context.getResources().getString(i);
        }
        v.e("MicroMsg.ResourceHelper", "get string, resId %d, but context is null", Integer.valueOf(i));
        return SQLiteDatabase.KeyEmpty;
    }

    public static float getDensity(Context context) {
        if (context == null) {
            context = aa.getContext();
        }
        if (density < 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        return density;
    }

    public static int fromDPToPix(Context context, int i) {
        return Math.round(getDensity(context) * ((float) i));
    }

    public static int P(Context context, int i) {
        return Math.round(((float) i) / getDensity(context));
    }

    public static float ds(Context context) {
        if (neH == 0.0f) {
            if (context == null) {
                neH = 1.0f;
            } else {
                neH = context.getSharedPreferences(aa.bti(), 0).getFloat("text_size_scale_key", 1.0f);
            }
        }
        return neH;
    }

    public static void c(Context context, float f) {
        Editor edit = context.getSharedPreferences(aa.bti(), 0).edit();
        edit.putFloat("text_size_scale_key", f);
        edit.commit();
        neH = f;
    }

    public static boolean dt(Context context) {
        float ds = ds(context);
        neH = ds;
        return Float.compare(ds, 1.125f) > 0;
    }

    public static boolean du(Context context) {
        float ds = ds(context);
        neH = ds;
        if (ds == 0.875f) {
            return true;
        }
        return false;
    }

    public static int dv(Context context) {
        if (neF != null) {
            return 0;
        }
        if (context != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        v.e("MicroMsg.ResourceHelper", "get widthPixels but context is null");
        return 0;
    }

    public static int dw(Context context) {
        if (neF != null) {
            return 0;
        }
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        v.e("MicroMsg.ResourceHelper", "get heightPixels but context is null");
        return 0;
    }
}
