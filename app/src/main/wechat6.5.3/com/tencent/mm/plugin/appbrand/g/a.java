package com.tencent.mm.plugin.appbrand.g;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.g.a.b;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class a {
    public static int FAILED = -1;
    public static int SUCCESS = 0;
    public int dMg = 5;
    public String dMh = (e.cge + "appbrand/");
    public final ArrayList<b> dMi = new ArrayList();

    public interface a {
        void b(int i, String str, String str2, String str3);

        void nz(String str);
    }

    class AnonymousClass1 implements com.tencent.mm.plugin.appbrand.g.a.a {
        final /* synthetic */ a dMj;
        final /* synthetic */ a dMk;

        public AnonymousClass1(a aVar, a aVar2) {
            this.dMk = aVar;
            this.dMj = aVar2;
        }

        public final void e(String str, String str2, String str3, String str4) {
            a.a(this.dMk, str3);
            this.dMj.b(a.SUCCESS, str2, str, str4);
            v.i("MicroMsg.AppBrandNetworkDownload", "download success! filename %s, url %s", new Object[]{str, str3});
        }

        public final void i(String str, String str2, int i) {
            v.v("MicroMsg.AppBrandNetworkDownload", "filename %s, url %s , percent %d", new Object[]{str, str2, Integer.valueOf(i)});
        }

        public final void w(String str, String str2, String str3) {
            a.a(this.dMk, str2);
            v.e("MicroMsg.AppBrandNetworkDownload", "download error! filename %s, url %s", new Object[]{str, str2});
            this.dMj.nz(str3);
        }

        public final void aN(String str, String str2) {
            v.i("MicroMsg.AppBrandNetworkDownload", "download start! filename %s, url %s", new Object[]{str, str2});
        }
    }

    static /* synthetic */ void a(a aVar, String str) {
        if (str != null) {
            Collection arrayList = new ArrayList();
            synchronized (aVar.dMi) {
                Iterator it = aVar.dMi.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (bVar.uri.equals(str)) {
                        arrayList.add(bVar);
                    }
                }
                if (arrayList.size() > 0) {
                    aVar.dMi.removeAll(arrayList);
                }
            }
        }
    }

    public a(int i) {
        if (i > 0) {
            this.dMg = i;
        }
    }

    public b nK(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.dMi) {
            Iterator it = this.dMi.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.uri.equals(str)) {
                    return bVar;
                }
            }
            return null;
        }
    }
}
