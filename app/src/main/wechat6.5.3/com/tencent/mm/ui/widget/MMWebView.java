package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.u;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

public class MMWebView extends WebView {
    public boolean cfB;
    protected boolean pdF;
    public boolean pdG;
    private boolean pdH;
    public ViewGroup pdI;

    public static class a {
        public static MMWebView eP(Context context) {
            boolean z = true;
            MMWebView.eO(context);
            MMWebView mMWebView = new MMWebView(context);
            mMWebView.cfB = true;
            if (mMWebView.getX5WebViewExtension() == null) {
                z = false;
            }
            mMWebView.pdG = z;
            return mMWebView;
        }

        public static MMWebView eQ(Context context) {
            MMWebView.eO(context);
            MMWebView mMWebView = new MMWebView(context);
            mMWebView.cfB = true;
            mMWebView.pdG = mMWebView.getX5WebViewExtension() != null;
            mMWebView.pdF = true;
            return mMWebView;
        }

        public static MMWebView h(Activity activity, int i) {
            boolean z = true;
            MMWebView.eO(activity);
            MMWebView mMWebView = (MMWebView) activity.findViewById(i);
            mMWebView.cfB = true;
            if (mMWebView.getX5WebViewExtension() == null) {
                z = false;
            }
            mMWebView.pdG = z;
            return mMWebView;
        }
    }

    private static class b {
        ArrayList<Integer> pdK = new ArrayList();
        ArrayList<Integer> pdL = new ArrayList();

        private b() {
        }

        public static b PM(String str) {
            b bVar = new b();
            if (be.kS(str)) {
                v.e("MicroMsg.MMWebView.SectionParser", "parse fail, section is null");
            } else {
                try {
                    String[] split = str.split("\\|");
                    if (split != null) {
                        v.d("MicroMsg.MMWebView.SectionParser", "parse items array length = %d", Integer.valueOf(split.length));
                        for (String str2 : split) {
                            if (!be.kS(str2)) {
                                String[] split2 = str2.split(",");
                                if (split2 != null && split2.length == 2) {
                                    bVar.pdK.add(Integer.valueOf(be.getInt(split2[0], 0)));
                                    bVar.pdL.add(Integer.valueOf(be.getInt(split2[1], 0)));
                                }
                            }
                        }
                        v.d("MicroMsg.MMWebView.SectionParser", "parse items list size = %d", Integer.valueOf(bVar.pdK.size()));
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.MMWebView.SectionParser", "parse ex = %s", e.getMessage());
                }
            }
            return bVar;
        }
    }

    private class c {
        final /* synthetic */ MMWebView pdJ;

        private c(MMWebView mMWebView) {
            this.pdJ = mMWebView;
        }
    }

    private class d {
        final /* synthetic */ MMWebView pdJ;

        private d(MMWebView mMWebView) {
            this.pdJ = mMWebView;
        }
    }

    public MMWebView(Context context) {
        this(context, null);
    }

    public MMWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cfB = false;
        this.pdF = false;
        this.pdG = false;
        this.pdH = false;
        bKm();
    }

    public void loadData(String str, String str2, String str3) {
        super.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        super.loadUrl(str, map);
    }

    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @TargetApi(11)
    public final void bKm() {
        try {
            if (VERSION.SDK_INT >= 11) {
                super.removeJavascriptInterface("searchBoxJavaBridge_");
            }
        } catch (Exception e) {
            v.e("MicroMsg.MMWebView", "removeConfigJsInterface, ex = %s", e.getMessage());
        }
    }

    public final void bKn() {
        if (VERSION.SDK_INT >= 5) {
            d dVar = new d();
            setScrollbarFadingEnabled(true);
            setScrollBarStyle(0);
            return;
        }
        c cVar = new c();
        setScrollBarStyle(0);
    }

    public void switchNightMode(boolean z) {
        v.d("MicroMsg.MMWebView", "[cpan] swithc mode.");
        setDayOrNight(!z);
    }

    public void evaluateJavascript(String str, u<String> uVar) {
        if (!be.kS(str)) {
            int i;
            if (com.tencent.mm.compatible.util.d.dW(19) || getX5WebViewExtension() != null) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                super.evaluateJavascript(str, uVar);
            } else if (!this.pdF || !a(this, str)) {
                try {
                    super.loadUrl(str);
                } catch (Exception e) {
                    v.i("MicroMsg.MMWebView", "evaluateJavascript failed : %s", e.getMessage());
                }
            }
        }
    }

    private static boolean a(MMWebView mMWebView, String str) {
        try {
            Object obj = new com.tencent.mm.compatible.loader.c(new com.tencent.mm.compatible.loader.c(new com.tencent.mm.compatible.loader.c(mMWebView, "mSysWebView", null).get(), "mProvider", null).get(), "mWebViewCore", null).get();
            Method declaredMethod = obj.getClass().getDeclaredMethod("sendMessage", new Class[]{Message.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, new Object[]{Message.obtain(null, 194, str)});
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.MMWebView", "reflectJSExec, e = %s", e);
            return false;
        }
    }

    public final void bKo() {
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MMWebView pdJ;

            {
                this.pdJ = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA) {
                    case 0:
                    case 2:
                        this.pdJ.pdI.requestDisallowInterceptTouchEvent(true);
                        break;
                    case 1:
                    case 3:
                        this.pdJ.pdI.requestDisallowInterceptTouchEvent(false);
                        break;
                    default:
                        this.pdJ.pdI.requestDisallowInterceptTouchEvent(true);
                        break;
                }
                return false;
            }
        });
    }

    @TargetApi(9)
    public final boolean b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean super_overScrollBy = super.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        if (i4 < 0 || (i4 == 0 && i2 < 0)) {
            this.pdH = true;
        }
        return super_overScrollBy;
    }

    public final boolean z(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean super_onTouchEvent = super.super_onTouchEvent(motionEvent);
        switch (action & WebView.NORMAL_MODE_ALPHA) {
            case 0:
                this.pdH = false;
                break;
            case 2:
                if (this.pdI != null) {
                    if (!this.pdH) {
                        this.pdI.requestDisallowInterceptTouchEvent(true);
                        break;
                    }
                    this.pdI.requestDisallowInterceptTouchEvent(false);
                    break;
                }
                break;
        }
        if (!super_onTouchEvent) {
            return super_onTouchEvent;
        }
        if (this.pdH) {
            return false;
        }
        return true;
    }

    @TargetApi(9)
    public final void c(int i, int i2, boolean z, boolean z2) {
        super.super_onOverScrolled(i, i2, z, z2);
    }

    public final boolean A(MotionEvent motionEvent) {
        return super.super_dispatchTouchEvent(motionEvent);
    }

    public final boolean B(MotionEvent motionEvent) {
        return super.super_onInterceptTouchEvent(motionEvent);
    }

    @TargetApi(9)
    public final void bKp() {
        super.super_computeScroll();
    }

    public final void r(int i, int i2, int i3, int i4) {
        super.super_onScrollChanged(i, i2, i3, i4);
    }

    public static void eO(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        boolean z = sharedPreferences.getBoolean("tbs_force_user_sys_webview", false);
        v.i("MicroMsg.MMWebView", "initTbsSettings, forceUseSysWebView = %b, tbsEnable = %s, tbsSupportVerSec = %s", Boolean.valueOf(z), sharedPreferences.getString("tbs_enable", "1"), sharedPreferences.getString("tbs_supported_ver_sec", "25406,99999999"));
        v.i("MicroMsg.MMWebView", "initTbsSettings, enableTbsKernel = %b", Boolean.valueOf(a(context, z, r2, r0)));
        if (!a(context, z, r2, r0)) {
            QbSdk.forceSysWebView();
        }
    }

    private static boolean a(Context context, boolean z, String str, String str2) {
        if (z) {
            return false;
        }
        if (!"1".equals(str)) {
            return false;
        }
        if (be.kS(str2)) {
            v.w("MicroMsg.MMWebView", "enableTbsKernel, tbsSupportVerSec is null");
            return false;
        }
        try {
            int tbsCoreVersion = WebView.getTbsCoreVersion(context);
            if (tbsCoreVersion == 0) {
                v.i("MicroMsg.MMWebView", "tbs does not exist, should enable tbs");
                return true;
            } else if (VERSION.SDK_INT < 21 || tbsCoreVersion >= 25440) {
                boolean z2;
                b PM = b.PM(str2);
                for (int i = 0; i < PM.pdK.size(); i++) {
                    int intValue = ((Integer) PM.pdK.get(i)).intValue();
                    int intValue2 = ((Integer) PM.pdL.get(i)).intValue();
                    if (intValue >= 0 && intValue2 > 0 && intValue2 >= intValue && intValue <= tbsCoreVersion && tbsCoreVersion <= intValue2) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                v.i("MicroMsg.MMWebView", "enableTbsKernel, tbsCoreVersion = %d, inSection = %b", Integer.valueOf(tbsCoreVersion), Boolean.valueOf(z2));
                return z2;
            } else {
                v.i("MicroMsg.MMWebView", "enableTbsKernel, tbsCoreVersion = %d, sdk version = %d", Integer.valueOf(tbsCoreVersion), Integer.valueOf(VERSION.SDK_INT));
                return false;
            }
        } catch (Exception e) {
            v.e("MicroMsg.MMWebView", "enableTbsKernel, init x5 settings, ex = %s", e.getMessage());
            return false;
        }
    }
}
