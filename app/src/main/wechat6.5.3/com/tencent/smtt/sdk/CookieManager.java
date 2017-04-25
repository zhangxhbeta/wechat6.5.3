package com.tencent.smtt.sdk;

import android.os.Build.VERSION;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.tencent.smtt.utils.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class CookieManager {
    private static CookieManager pum;
    ArrayList<a> pun;

    class a {
        int puo;
        u<Boolean> pup;
        final /* synthetic */ CookieManager puq;
        String url;
        String value;

        a(CookieManager cookieManager) {
            this.puq = cookieManager;
        }
    }

    private CookieManager() {
    }

    public static synchronized CookieManager getInstance() {
        CookieManager cookieManager;
        synchronized (CookieManager.class) {
            if (pum == null) {
                pum = new CookieManager();
            }
            cookieManager = pum;
        }
        return cookieManager;
    }

    public boolean acceptCookie() {
        y bNJ = y.bNJ();
        if (bNJ == null || !bNJ.bNK()) {
            return android.webkit.CookieManager.getInstance().acceptCookie();
        }
        Object invokeStaticMethod = bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    public synchronized boolean acceptThirdPartyCookies(WebView webView) {
        boolean booleanValue;
        y bNJ = y.bNJ();
        Object invokeStaticMethod;
        if (bNJ != null && bNJ.bNK()) {
            invokeStaticMethod = bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[]{Object.class}, webView.getView());
            booleanValue = invokeStaticMethod != null ? ((Boolean) invokeStaticMethod).booleanValue() : true;
        } else if (VERSION.SDK_INT < 21) {
            booleanValue = true;
        } else {
            invokeStaticMethod = n.a(android.webkit.CookieManager.getInstance(), "acceptThirdPartyCookies", new Class[]{WebView.class}, webView.getView());
            booleanValue = invokeStaticMethod != null ? ((Boolean) invokeStaticMethod).booleanValue() : false;
        }
        return booleanValue;
    }

    final synchronized void bMD() {
        if (!(this.pun == null || this.pun.size() == 0)) {
            y bNJ = y.bNJ();
            if (bNJ != null && bNJ.bNK()) {
                Iterator it = this.pun.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    switch (aVar.puo) {
                        case 1:
                            setCookie(aVar.url, aVar.value, aVar.pup);
                            break;
                        case 2:
                            setCookie(aVar.url, aVar.value);
                            break;
                        default:
                            break;
                    }
                }
                this.pun.clear();
            }
        }
    }

    public void flush() {
        y bNJ = y.bNJ();
        if (bNJ != null && bNJ.bNK()) {
            bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
        } else if (VERSION.SDK_INT >= 21) {
            n.a(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
        }
    }

    public String getCookie(String str) {
        y bNJ = y.bNJ();
        if (bNJ == null || !bNJ.bNK()) {
            return android.webkit.CookieManager.getInstance().getCookie(str);
        }
        Object invokeStaticMethod = bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[]{String.class}, str);
        return invokeStaticMethod == null ? null : (String) invokeStaticMethod;
    }

    public boolean hasCookies() {
        y bNJ = y.bNJ();
        if (bNJ == null || !bNJ.bNK()) {
            return android.webkit.CookieManager.getInstance().hasCookies();
        }
        Object invokeStaticMethod = bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    public void removeAllCookie() {
        y bNJ = y.bNJ();
        if (bNJ == null || !bNJ.bNK()) {
            android.webkit.CookieManager.getInstance().removeAllCookie();
        } else {
            bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
        }
    }

    public void removeAllCookies(u<Boolean> uVar) {
        y bNJ = y.bNJ();
        if (bNJ != null && bNJ.bNK()) {
            bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[]{ValueCallback.class}, uVar);
        } else if (VERSION.SDK_INT >= 21) {
            n.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[]{ValueCallback.class}, uVar);
        }
    }

    public void removeExpiredCookie() {
        y bNJ = y.bNJ();
        if (bNJ == null || !bNJ.bNK()) {
            android.webkit.CookieManager.getInstance().removeExpiredCookie();
        } else {
            bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
        }
    }

    public void removeSessionCookie() {
        y bNJ = y.bNJ();
        if (bNJ == null || !bNJ.bNK()) {
            android.webkit.CookieManager.getInstance().removeSessionCookie();
        } else {
            bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
        }
    }

    public void removeSessionCookies(u<Boolean> uVar) {
        y bNJ = y.bNJ();
        if (bNJ != null && bNJ.bNK()) {
            bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[]{ValueCallback.class}, uVar);
        } else if (VERSION.SDK_INT >= 21) {
            n.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[]{ValueCallback.class}, uVar);
        }
    }

    public synchronized void setAcceptCookie(boolean z) {
        y bNJ = y.bNJ();
        if (bNJ == null || !bNJ.bNK()) {
            android.webkit.CookieManager.getInstance().setAcceptCookie(z);
        } else {
            bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public synchronized void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        y bNJ = y.bNJ();
        if (bNJ != null && bNJ.bNK()) {
            bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[]{Object.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        } else if (VERSION.SDK_INT >= 21) {
            n.a(android.webkit.CookieManager.getInstance(), "setAcceptThirdPartyCookies", new Class[]{WebView.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        }
    }

    public synchronized void setCookie(String str, String str2) {
        y bNJ = y.bNJ();
        if (bNJ == null || !bNJ.bNK()) {
            android.webkit.CookieManager.getInstance().setCookie(str, str2);
            if (!y.bNJ().pvf) {
                a aVar = new a(this);
                aVar.puo = 2;
                aVar.url = str;
                aVar.value = str2;
                aVar.pup = null;
                if (this.pun == null) {
                    this.pun = new ArrayList();
                }
                this.pun.add(aVar);
            }
        } else {
            bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class}, str, str2);
        }
    }

    public synchronized void setCookie(String str, String str2, u<Boolean> uVar) {
        y bNJ = y.bNJ();
        if (bNJ == null || !bNJ.bNK()) {
            if (!y.bNJ().pvf) {
                a aVar = new a(this);
                aVar.puo = 1;
                aVar.url = str;
                aVar.value = str2;
                aVar.pup = uVar;
                if (this.pun == null) {
                    this.pun = new ArrayList();
                }
                this.pun.add(aVar);
            }
            if (VERSION.SDK_INT >= 21) {
                n.a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, ValueCallback.class}, str, str2, uVar);
            }
        } else {
            bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class, ValueCallback.class}, str, str2, uVar);
        }
    }

    public void setCookies(Map<String, String[]> map) {
        boolean z;
        y bNJ = y.bNJ();
        if (bNJ == null || !bNJ.bNK()) {
            z = false;
        } else {
            Object invokeStaticMethod = bNJ.bNL().pxC.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[]{Map.class}, map);
            z = invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
        }
        if (!z) {
            for (String str : map.keySet()) {
                for (String cookie : (String[]) map.get(str)) {
                    setCookie(str, cookie);
                }
            }
        }
    }
}
