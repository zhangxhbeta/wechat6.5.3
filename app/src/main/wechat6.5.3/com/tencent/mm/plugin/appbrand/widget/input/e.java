package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowInsets;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.widget.input.c.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum e {
    ;
    
    public static final Set<String> dXO = null;
    private static final Map<String, WeakReference<c>> dXP = null;
    private static final SparseArray<j> dXQ = null;

    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ h dGq;
        final /* synthetic */ boolean dXT;
        final /* synthetic */ Integer dXU;
        final /* synthetic */ String dmi;

        AnonymousClass3(h hVar, String str, boolean z, Integer num) {
            this.dGq = hVar;
            this.dmi = str;
            this.dXT = false;
            this.dXU = num;
        }

        public final void run() {
            j jVar = (j) e.dXQ.get(this.dGq.hashCode());
            if (jVar != null) {
                if (!be.ma(jVar.getText().toString()).equals(this.dmi)) {
                    if (this.dXT) {
                        jVar.setText(this.dmi);
                    } else {
                        jVar.I(this.dmi);
                    }
                }
                if (this.dXU == null) {
                    jVar.setSelection(jVar.getText().length());
                    return;
                }
                try {
                    jVar.setSelection(Math.min(Math.max(this.dXU.intValue() == -1 ? jVar.getText().length() : this.dXU.intValue(), 0), jVar.getText().length()));
                } catch (Exception e) {
                }
            }
        }
    }

    public enum a {
        public static final a lqL = null;
        public static final a lqM = null;
        public static final a lqN = null;
        public static final a lqO = null;
        public static final a lqP = null;
        private static final int lqR = 0;
        private static final /* synthetic */ a[] lqS = null;
        public final int lqQ;

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) lqS.clone();
        }

        static {
            int i = 0;
            lqL = new a("DONE", 0, 6);
            lqM = new a("SEARCH", 1, 3);
            lqN = new a("NEXT", 2, 5);
            lqO = new a("GO", 3, 2);
            lqP = new a("SEND", 4, 4);
            lqS = new a[]{lqL, lqM, lqN, lqO, lqP};
            a[] values = values();
            int length = values.length;
            int i2 = 0;
            while (i < length) {
                i2 = Math.max(values[i].name().length(), i2);
                i++;
            }
            lqR = i2;
        }

        private a(String str, int i, int i2) {
            this.lqQ = i2;
        }

        public static a bRH() {
            return lqL;
        }

        public static a Rj(String str) {
            if (str.length() > lqR) {
                return null;
            }
            String toUpperCase = str.toUpperCase();
            for (a aVar : values()) {
                if (aVar.name().equals(toUpperCase)) {
                    return aVar;
                }
            }
            return null;
        }
    }

    enum b {
        private static final /* synthetic */ b[] fVG = null;

        static {
            fVG = new b[0];
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) fVG.clone();
        }

        static void c(Activity activity, View view) {
            if (anW() && activity.getResources().getConfiguration().orientation != 2) {
                activity.getWindow().setFlags(1024, 1024);
                activity.getWindow().addFlags(2048);
                view.setPadding(0, com.tencent.mm.pluginsdk.e.db(activity), 0, 0);
            }
        }

        private static boolean anW() {
            try {
                return ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
            } catch (Exception e) {
                if (Build.DEVICE.equals("mx2")) {
                    return true;
                }
                if (Build.DEVICE.equals("mx") || Build.DEVICE.equals("m9")) {
                    return false;
                }
                return false;
            }
        }
    }

    enum c {
        private static final /* synthetic */ c[] fVH = null;

        static {
            fVH = new c[0];
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) fVH.clone();
        }

        static void d(EditText editText) {
            if (editText != null) {
                ((InputMethodManager) aa.getContext().getSystemService("input_method")).hideSoftInputFromInputMethod(editText.getWindowToken(), 2);
            }
        }

        public static void setNoSystemInputOnEditText(EditText editText) {
            if (editText != null) {
                Class cls = EditText.class;
                try {
                    Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
                    method.setAccessible(true);
                    method.invoke(editText, new Object[]{Boolean.valueOf(false)});
                    method.setAccessible(false);
                } catch (NoSuchMethodException e) {
                    v.i("MicroMsg.AppBrandInputService", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
                    try {
                        Method method2 = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                        method2.setAccessible(true);
                        method2.invoke(editText, new Object[]{Boolean.valueOf(false)});
                        method2.setAccessible(false);
                    } catch (Throwable e2) {
                        v.e("MicroMsg.AppBrandInputService", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", new Object[]{be.e(e2)});
                        if (editText.getContext() != null && (editText.getContext() instanceof MMActivity)) {
                            ((MMActivity) editText.getContext()).cx(editText);
                        }
                    }
                } catch (Throwable e22) {
                    v.e("MicroMsg.AppBrandInputService", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", new Object[]{be.e(e22)});
                }
            }
        }
    }

    enum d {
        private static final /* synthetic */ d[] fVI = null;

        static {
            fVI = new d[0];
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) fVI.clone();
        }

        static void a(j jVar, String str, String str2) {
            String toLowerCase = str2.toLowerCase();
            if (jVar != null) {
                Typeface create = Typeface.create(str, tr(toLowerCase));
                if (create == null) {
                    create = jVar.getTypeface();
                }
                jVar.setTypeface(create, tr(toLowerCase));
            }
        }

        static int tr(String str) {
            int i = -1;
            switch (str.hashCode()) {
                case 3029637:
                    if (str.equals("bold")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    return 1;
                default:
                    return 0;
            }
        }
    }

    static {
        Set hashSet = new HashSet();
        hashSet.add("text");
        hashSet.add("emoji");
        hashSet.add("number");
        hashSet.add("digit");
        hashSet.add("idcard");
        dXO = Collections.unmodifiableSet(hashSet);
        dXP = new HashMap();
        dXQ = new SparseArray();
    }

    public static void a(MMActivity mMActivity) {
        if (mMActivity != null && mMActivity.getWindow() != null) {
            mMActivity.getWindow().setSoftInputMode(16);
        }
    }

    @TargetApi(20)
    public static void a(MMActivity mMActivity, View view) {
        if (mMActivity != null && mMActivity.getWindow() != null && view != null && view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            viewGroup.removeView(view);
            final View dVar = new d(mMActivity, mMActivity.getWindow().getDecorView(), view);
            viewGroup.addView(dVar, new LayoutParams(-1, -1));
            if (VERSION.SDK_INT >= 20) {
                ((ViewGroup) mMActivity.getWindow().getDecorView()).getChildAt(0).setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        dVar.setPadding(0, windowInsets.getSystemWindowInsetTop(), 0, 0);
                        return windowInsets.consumeSystemWindowInsets();
                    }
                });
            } else {
                Point point = new Point();
                mMActivity.getWindowManager().getDefaultDisplay().getSize(point);
                dVar.dXE = point.y - com.tencent.mm.pluginsdk.e.db(mMActivity);
            }
            b.c(mMActivity, viewGroup);
        }
    }

    public static void a(final String str, final c cVar) {
        if (!be.kS(str) && cVar != null) {
            com.tencent.mm.plugin.appbrand.k.a.runOnUiThread(new Runnable() {
                public final void run() {
                    e.dXP.put(str, new WeakReference(cVar));
                }
            });
        }
    }

    private static c oJ(String str) {
        WeakReference weakReference = (WeakReference) dXP.get(str);
        return weakReference == null ? null : (c) weakReference.get();
    }

    public static void a(h hVar, String str, Integer num) {
        if (hVar != null) {
            com.tencent.mm.plugin.appbrand.k.a.runOnUiThread(new AnonymousClass3(hVar, str, false, num));
        }
    }

    public static boolean a(c.h hVar, String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.AppBrandInputService", "updateInputStyle, inputId is Null Or Nil");
            return false;
        }
        c oJ = oJ(str);
        if (oJ == null) {
            return false;
        }
        boolean z;
        if (oJ.dWJ == null) {
            z = false;
        } else {
            g gVar = oJ.dWJ;
            if (hVar.dXe != null) {
                gVar.dXe = hVar.dXe;
            }
            if (hVar.dXf != null) {
                gVar.dXf = hVar.dXf;
            }
            if (hVar.dXg != null) {
                gVar.dXg = hVar.dXg;
            }
            if (hVar.dXh != null) {
                gVar.dXh = hVar.dXh;
            }
            if (hVar.dXi != null) {
                gVar.dXi = hVar.dXi;
            }
            if (hVar.dXk != null) {
                gVar.dXk = hVar.dXk;
            }
            if (hVar.dXl != null) {
                gVar.dXl = hVar.dXl;
            }
            if (hVar.dXm != null) {
                gVar.dXm = hVar.dXm;
            }
            if (!be.kS(hVar.dXn)) {
                gVar.dXn = hVar.dXn;
            }
            if (!be.kS(hVar.dXo)) {
                gVar.dXo = hVar.dXo;
            }
            if (hVar.dXp != null && hVar.dXp.intValue() >= 0) {
                gVar.dXp = hVar.dXp;
            }
            if (!be.kS(hVar.dXq)) {
                gVar.dXq = hVar.dXq;
            }
            if (!be.kS(hVar.dXr)) {
                gVar.dXr = hVar.dXr;
            }
            if (hVar.dXs != null) {
                gVar.dXs = hVar.dXs;
            }
            if (hVar.dXt != null) {
                gVar.dXt = hVar.dXt;
            }
            if (hVar.dXu != null) {
                gVar.dXu = hVar.dXu;
            }
            if (hVar.dXv != null) {
                gVar.dXv = hVar.dXv;
            }
            if (hVar.dXw != null) {
                gVar.dXw = hVar.dXw;
            }
            if (hVar.dXx != null) {
                gVar.dXx = hVar.dXx;
            }
            if (hVar.dXy != null) {
                gVar.dXy = hVar.dXy;
            }
            if (!be.kS(hVar.dXj)) {
                gVar.dXj = hVar.dXj;
            }
            if (hVar.dXz != null) {
                gVar.dXz = hVar.dXz;
            }
            if (hVar.dXA != null) {
                gVar.dXA = hVar.dXA;
            }
            if (hVar.lqI != null) {
                gVar.lqI = hVar.lqI;
            }
            if (hVar.lqJ != null) {
                gVar.lqJ = hVar.lqJ;
            }
            if (oJ.dWJ.dXb || (oJ.dWJ.dXg != null && oJ.dWJ.dXg.intValue() > 0)) {
                oJ.bG(false);
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            return true;
        }
        return false;
    }

    public static boolean l(h hVar) {
        EditText editText = (EditText) dXQ.get(hVar.hashCode());
        if (editText == null) {
            return false;
        }
        String str = (String) editText.getTag(2131755012);
        if (be.kS(str)) {
            return false;
        }
        c oJ = oJ(str);
        if (oJ == null) {
            return false;
        }
        if (!(oJ.dWL == null || oJ.dGH == null || oJ.dGH.get() == null)) {
            View view = (h) oJ.dGH.get();
            i bJ = i.bJ(view);
            if (bJ != null) {
                bJ.setVisibility(8);
            }
            g bI = g.bI(view);
            if (bI != null) {
                bI.setVisibility(8);
            }
        }
        return true;
    }

    public static boolean a(h hVar, String str) {
        c oJ = oJ(str);
        if (oJ != null) {
            if ((oJ.dGH == null ? null : (h) oJ.dGH.get()) == hVar) {
                if (!(oJ.dWL == null || oJ.dGH == null || oJ.dGH.get() == null)) {
                    oJ.dWL.performClick();
                }
                return true;
            }
        }
        return false;
    }

    public static void m(final h hVar) {
        ad.o(new Runnable() {
            public final void run() {
                e.l(hVar);
            }
        });
    }

    public static boolean oK(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.AppBrandInputService", "removeInput, inputId is Null Or Nil");
            return false;
        }
        c oJ = oJ(str);
        if (oJ == null) {
            return false;
        }
        if (!(oJ.dWL == null || oJ.dGH == null || oJ.dGH.get() == null)) {
            b bVar = ((h) oJ.dGH.get()).dOh;
            if (bVar != null) {
                if (oJ.dWL.hasFocus()) {
                    if (oJ.dWN != null) {
                        oJ.dWN.setVisibility(8);
                    }
                    oJ.SQ();
                    if (oJ.dWM != null) {
                        oJ.dWM.setVisibility(8);
                    }
                }
                bVar.bD(oJ.dWL);
            }
        }
        oJ.onDestroy();
        return true;
    }

    static void n(h hVar) {
        if (hVar != null) {
            final int hashCode = hVar.hashCode();
            com.tencent.mm.plugin.appbrand.k.a.runOnUiThread(new Runnable() {
                public final void run() {
                    e.dXQ.remove(hashCode);
                }
            });
        }
    }

    public static void a(final h hVar, final j jVar) {
        if (hVar != null) {
            com.tencent.mm.plugin.appbrand.k.a.runOnUiThread(new Runnable() {
                public final void run() {
                    e.dXQ.put(hVar.hashCode(), jVar);
                }
            });
        }
    }
}
