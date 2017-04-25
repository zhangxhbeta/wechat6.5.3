package com.tencent.smtt.sdk;

import android.content.Context;

public final class aa {
    public static boolean pyk = false;
    private static boolean pyl = false;
    public WebView dOZ = null;
    public Object pym = null;

    public aa(Context context) {
        boolean fM = fM(context);
        pyk = fM;
        if (fM) {
            this.pym = fN(context);
            if (this.pym == null) {
                pyk = false;
            }
        }
        if (!pyk) {
            this.dOZ = new WebView(context);
            this.dOZ.getSettings().setJavaScriptEnabled(true);
        }
    }

    public static boolean fM(Context context) {
        if (pyl) {
            return pyk;
        }
        pyl = true;
        try {
            y bNJ = y.bNJ();
            if (bNJ != null && bNJ.bNK()) {
                Object invokeStaticMethod = bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canUseX5JsCore", new Class[]{Context.class}, new Object[]{context});
                if (invokeStaticMethod != null && (invokeStaticMethod instanceof Boolean)) {
                    pyk = ((Boolean) invokeStaticMethod).booleanValue();
                }
            }
        } catch (Exception e) {
        }
        return pyk;
    }

    private static Object fN(Context context) {
        try {
            y bNJ = y.bNJ();
            if (bNJ != null && bNJ.bNK()) {
                return bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createX5JavaBridge", new Class[]{Context.class}, new Object[]{context});
            }
        } catch (Exception e) {
        }
        return null;
    }
}
