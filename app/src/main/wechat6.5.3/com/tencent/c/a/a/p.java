package com.tencent.c.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import java.lang.reflect.Method;

public class p {
    private static volatile p aON = null;
    private boolean aOO = false;
    private Context context = null;

    public final boolean n(String str, String str2) {
        if (this.aOO) {
            try {
                return System.putString(this.context.getContentResolver(), str, str2);
            } catch (Exception e) {
            }
        }
        return false;
    }

    private p(Context context) {
        this.context = context.getApplicationContext();
        this.aOO = s.l(this.context, "android.permission.WRITE_SETTINGS");
        if (VERSION.SDK_INT >= 23) {
            try {
                Method declaredMethod = System.class.getDeclaredMethod("canWrite", new Class[]{Context.class});
                declaredMethod.setAccessible(true);
                this.aOO = ((Boolean) declaredMethod.invoke(null, new Object[]{this.context})).booleanValue();
            } catch (Exception e) {
            }
        }
    }

    public static p S(Context context) {
        if (aON == null) {
            synchronized (p.class) {
                if (aON == null) {
                    aON = new p(context);
                }
            }
        }
        return aON;
    }
}
