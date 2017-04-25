package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class j {
    private static int cgA = -1;
    private static int cgB = -1;
    private static int cgx = -1;
    private static int cgy = -1;
    private static boolean cgz = false;

    public static void so() {
        cgz = false;
    }

    public static final int aA(Context context) {
        if (cgz) {
            return aC(context);
        }
        if (cgx > 0) {
            return cgx;
        }
        if (cgz) {
            return aC(context);
        }
        if (!aE(context)) {
            return aa.btk().getInt("com.tencent.mm.compatible.util.keybord.height", 690);
        }
        int i = aa.btk().getInt("com.tencent.mm.compatible.util.keybord.height", a.fromDPToPix(context, 230));
        cgx = i;
        return i;
    }

    @TargetApi(11)
    public static final void f(Activity activity) {
        if (activity != null) {
            int height;
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int i = rect.top;
            if (activity instanceof AppCompatActivity) {
                if (((AppCompatActivity) activity).cU().cV() != null) {
                    height = ((AppCompatActivity) activity).cU().cV().getHeight();
                }
                height = a.e(activity);
            } else {
                if (activity.getActionBar() != null) {
                    height = activity.getActionBar().getHeight();
                }
                height = a.e(activity);
            }
            cgy = (activity.getResources().getDisplayMetrics().heightPixels - height) - i;
        }
    }

    public static final int sp() {
        return cgy;
    }

    public static final boolean n(Context context, int i) {
        if (cgx == i) {
            return true;
        }
        if (!aE(context)) {
            return false;
        }
        if (i < 0) {
            return false;
        }
        cgx = i;
        v.d("MicroMsg.KeyBordUtil", "save keybord: %d", Integer.valueOf(i));
        return aa.btk().edit().putInt("com.tencent.mm.compatible.util.keybord.height", i).commit();
    }

    public static final int aB(Context context) {
        if (cgz) {
            return aC(context);
        }
        if (cgA > 0) {
            return cgA;
        }
        if (!aE(context)) {
            return 1140;
        }
        int fromDPToPix = a.fromDPToPix(context, 380);
        cgA = fromDPToPix;
        return fromDPToPix;
    }

    public static final int aC(Context context) {
        if (cgB > 0) {
            return cgB;
        }
        if (!aE(context)) {
            return cgB * 3;
        }
        int fromDPToPix = a.fromDPToPix(context, 230);
        cgB = fromDPToPix;
        return fromDPToPix;
    }

    public static final int o(Context context, int i) {
        int aC = aC(context);
        int aB;
        if (aF(context)) {
            if (i <= 0) {
                i = aA(context);
            }
            aB = aB(context);
            if (i > aB) {
                return aB;
            }
            if (i < aC) {
                return aC;
            }
            return i;
        }
        aB = (int) (((double) aC) / 1.5d);
        aC = aG(context)[0];
        if (aB > aC / 2) {
            return aC / 2;
        }
        return aB;
    }

    public static final int aD(Context context) {
        return o(context, -1);
    }

    private static final boolean aE(Context context) {
        if (context == null) {
            context = aa.getContext();
        }
        return context != null;
    }

    public static boolean aF(Context context) {
        int[] aG = aG(context);
        return aG[0] < aG[1] ? true : true;
    }

    private static int[] aG(Context context) {
        Context context2;
        if (context == null) {
            context2 = aa.getContext();
        } else {
            context2 = context;
        }
        int[] iArr = new int[2];
        if (context2 instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context2).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) context2.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        return iArr;
    }
}
