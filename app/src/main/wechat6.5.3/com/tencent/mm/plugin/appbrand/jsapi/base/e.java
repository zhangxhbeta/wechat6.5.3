package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e {
    private static e dJx;
    private Map<String, WeakReference<View>> dJy = new ConcurrentHashMap();

    private e() {
    }

    public static e Qp() {
        if (dJx == null) {
            synchronized (e.class) {
                if (dJx == null) {
                    dJx = new e();
                }
            }
        }
        return dJx;
    }

    public static int a(h hVar, View view) {
        return (hVar.hashCode() + "#" + System.currentTimeMillis() + "#" + view.hashCode()).hashCode();
    }

    public static String a(h hVar, String str, int i) {
        return hVar.hashCode() + "#" + str + "#" + i;
    }

    public final boolean a(String str, View view) {
        if (be.kS(str)) {
            v.w("MicroMsg.InsertedViewManager", "add view into manager failed, key is null or nil.");
            return false;
        } else if (view == null) {
            v.w("MicroMsg.InsertedViewManager", "add view into manager failed, view is null.");
            return false;
        } else {
            WeakReference weakReference = (WeakReference) this.dJy.put(str, new WeakReference(view));
            if (!(weakReference == null || weakReference.get() == null)) {
                v.i("MicroMsg.InsertedViewManager", "add a new view and remove old one with key : %s.", new Object[]{str});
            }
            v.d("MicroMsg.InsertedViewManager", "add view success.(%s)", new Object[]{str});
            return true;
        }
    }

    public final View nE(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.InsertedViewManager", "remove view from manager failed, key is null or nil.");
            return null;
        }
        Integer valueOf;
        WeakReference weakReference = (WeakReference) this.dJy.remove(str);
        String str2 = "MicroMsg.InsertedViewManager";
        String str3 = "remove view success.(key : %s, ref : %s)";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (weakReference != null) {
            valueOf = Integer.valueOf(weakReference.hashCode());
        } else {
            valueOf = null;
        }
        objArr[1] = valueOf;
        v.d(str2, str3, objArr);
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public final View nF(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.InsertedViewManager", "get view from manager failed, key is null or nil.");
            return null;
        }
        Integer valueOf;
        WeakReference weakReference = (WeakReference) this.dJy.get(str);
        String str2 = "MicroMsg.InsertedViewManager";
        String str3 = "get view success.(key : %s, ref : %s)";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (weakReference != null) {
            valueOf = Integer.valueOf(weakReference.hashCode());
        } else {
            valueOf = null;
        }
        objArr[1] = valueOf;
        v.d(str2, str3, objArr);
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public final boolean contains(String str) {
        return nF(str) != null;
    }
}
