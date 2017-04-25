package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.smtt.sdk.aa;
import com.tencent.smtt.sdk.u;
import com.tencent.smtt.sdk.y;

public final class i implements b {
    aa dzJ;
    private ac mHandler;

    public i(Context context, Object obj, String str) {
        this.dzJ = new aa(context);
        aa aaVar = this.dzJ;
        if (obj != null) {
            if (aa.pyk) {
                try {
                    y bNJ = y.bNJ();
                    if (bNJ != null && bNJ.bNK()) {
                        bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "addJavascriptInterface", new Class[]{Object.class, String.class, Object.class}, new Object[]{obj, str, aaVar.pym});
                    }
                } catch (Exception e) {
                }
            } else if (aaVar.dOZ != null) {
                aaVar.dOZ.addJavascriptInterface(obj, str);
                aaVar.dOZ.loadUrl("about:blank");
            }
        }
        this.mHandler = new ac(Looper.getMainLooper());
    }

    public final void evaluateJavascript(final String str, final u<String> uVar) {
        final Runnable anonymousClass1 = new Runnable(this) {
            final /* synthetic */ i dzL;

            public final void run() {
                aa aaVar = this.dzL.dzJ;
                String str = str;
                u uVar = uVar;
                if (aa.pyk) {
                    try {
                        y bNJ = y.bNJ();
                        if (bNJ != null && bNJ.bNK()) {
                            bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "evaluateJavascript", new Class[]{String.class, ValueCallback.class, Object.class}, new Object[]{str, uVar, aaVar.pym});
                        }
                    } catch (Exception e) {
                    }
                } else if (aaVar.dOZ != null) {
                    aaVar.dOZ.evaluateJavascript(str, uVar);
                }
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            anonymousClass1.run();
        } else {
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ i dzL;

                public final void run() {
                    anonymousClass1.run();
                }
            });
        }
    }

    public final void OE() {
        aa aaVar = this.dzJ;
        if (aa.pyk) {
            try {
                y bNJ = y.bNJ();
                if (bNJ != null && bNJ.bNK()) {
                    bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "destroyX5JsCore", new Class[]{Object.class}, new Object[]{aaVar.pym});
                }
            } catch (Exception e) {
            }
        } else if (aaVar.dOZ != null) {
            aaVar.dOZ.clearHistory();
            aaVar.dOZ.clearCache(true);
            aaVar.dOZ.loadUrl("about:blank");
            aaVar.dOZ.freeMemory();
            aaVar.dOZ.pauseTimers();
            aaVar.dOZ.destroy();
            aaVar.dOZ = null;
        }
    }
}
