package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Build.VERSION;
import android.os.Environment;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.s;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public enum f {
    ;
    
    private static Boolean dSA;
    private static final Method lqG = null;

    static i bs(final Context context) {
        View inflate = View.inflate(context, 2130903128, null);
        final i iVar = new i(context, 2131558555);
        iVar.setContentView(inflate);
        iVar.setCancelable(true);
        iVar.setCanceledOnTouchOutside(false);
        iVar.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (context instanceof MMActivity) {
                    ((MMActivity) context).finish();
                }
                iVar.setOnCancelListener(null);
            }
        });
        return iVar;
    }

    public static int e(int i, float f) {
        float f2 = 1.0f - f;
        return ((((int) ((f2 * 0.0f) + (((float) (i & 255)) * f))) & 255) << 0) | ((((((int) ((((float) ((i >> 24) & 255)) * f) + (255.0f * f2))) & 255) << 24) | ((((int) ((((float) ((i >> 16) & 255)) * f) + (0.0f * f2))) & 255) << 16)) | ((((int) ((((float) ((i >> 8) & 255)) * f) + (0.0f * f2))) & 255) << 8));
    }

    public static void a(Window window) {
        if (window != null && VERSION.SDK_INT >= 21) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    public static void a(Window window, boolean z) {
        if (window != null && window.getDecorView() != null && VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                systemUiVisibility |= 8192;
            } else {
                systemUiVisibility &= -8193;
            }
            decorView.setSystemUiVisibility(systemUiVisibility);
        }
    }

    public static boolean b(Window window) {
        if (window == null || window.getDecorView() == null || VERSION.SDK_INT < 23 || (window.getDecorView().getSystemUiVisibility() & 8192) == 0) {
            return false;
        }
        return true;
    }

    public static void a(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null && onGlobalLayoutListener != null) {
            if (VERSION.SDK_INT >= 16) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            } else {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
            }
        }
    }

    private static boolean ag(Activity activity) {
        try {
            Method method = lqG;
            if (method != null) {
                method.setAccessible(true);
                return ((Boolean) method.invoke(activity, new Object[0])).booleanValue();
            }
            v.d("MicroMsg.AppBrandUIUtil", "isInMultiWindowMode method null");
            return false;
        } catch (Exception e) {
            v.d("MicroMsg.AppBrandUIUtil", "isInMultiWindowMode, exp %s", new Object[]{e});
        }
    }

    public static boolean dg(View view) {
        if (VERSION.SDK_INT < 24) {
            return false;
        }
        if (view == null) {
            return false;
        }
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && !(context instanceof Activity)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (context instanceof Activity) && ag((Activity) context);
    }

    public static int Sj() {
        return s.X(aa.getContext(), a.fromDPToPix(aa.getContext(), 25));
    }

    public static boolean Sl() {
        if (dSA != null) {
            return dSA.booleanValue();
        }
        String str = null;
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            str = properties.getProperty("ro.miui.ui.version.name");
        } catch (Exception e) {
        }
        Boolean valueOf = Boolean.valueOf(str != null);
        dSA = valueOf;
        return valueOf.booleanValue();
    }
}
