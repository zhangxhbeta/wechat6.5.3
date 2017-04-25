package com.tencent.mm.ae;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class b {
    private HashMap<String, c> cLf = new HashMap();

    static class a implements Runnable {
        private HashMap<String, c> cLf;
        private Bitmap cLg;
        private String url;

        public a(String str, Bitmap bitmap, HashMap<String, c> hashMap) {
            this.url = str;
            this.cLg = bitmap;
            this.cLf = hashMap;
        }

        public final void run() {
            n.GG();
            b.f(this.url, this.cLg);
            if (this.cLf != null) {
                c cVar = (c) this.cLf.remove(this.url);
                if (cVar != null) {
                    cVar.j(this.cLg);
                }
            }
            String str = "MicroMsg.CdnImageService";
            String str2 = "finish download post job, url[%s]";
            Object[] objArr = new Object[1];
            objArr[0] = this.url == null ? "null" : this.url;
            v.i(str, str2, objArr);
        }
    }

    static class b implements Runnable {
        private HashMap<String, c> cLf;
        private String url;

        b(String str, HashMap<String, c> hashMap) {
            this.url = str;
            this.cLf = hashMap;
        }

        public final void run() {
            byte[] KO = be.KO(this.url);
            if (KO == null) {
                v.w("MicroMsg.CdnImageService", "download fail: url[%s] data is null", this.url);
                return;
            }
            Bitmap bc;
            try {
                bc = d.bc(KO);
            } catch (Exception e) {
                v.w("MicroMsg.CdnImageService", "download fail: url[%s] decode bitmap error[%s]", this.url, e.getLocalizedMessage());
                bc = null;
            }
            v.i("MicroMsg.CdnImageService", "download finish, url[%s], do post job", this.url);
            ad.o(new a(this.url, bc, this.cLf));
        }
    }

    public interface c {
        void j(Bitmap bitmap);
    }

    protected final void finalize() {
        super.finalize();
    }

    public static void f(String str, Bitmap bitmap) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.CdnImageService", "push fail, key is null");
        } else {
            com.tencent.mm.cache.a.a.a("local_cdn_img_cache", str, (Object) bitmap);
        }
    }

    public static Bitmap gu(String str) {
        if (str != null && str.length() != 0) {
            return (Bitmap) com.tencent.mm.cache.a.a.x("local_cdn_img_cache", str);
        }
        v.e("MicroMsg.CdnImageService", "get fail, key is null");
        return null;
    }

    public final void iO(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.CdnImageService", "stop load fail, url is empty");
        } else {
            this.cLf.remove(str);
        }
    }

    public final void a(String str, c cVar) {
        if (be.kS(str)) {
            v.w("MicroMsg.CdnImageService", "do load fail, url is empty");
            return;
        }
        Bitmap gu = gu(str);
        if (gu == null || gu.isRecycled()) {
            boolean z;
            String str2 = "MicroMsg.CdnImageService";
            String str3 = "try to download: url[%s], src bitmap is null[%B]";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (gu == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            v.w(str2, str3, objArr);
            if (this.cLf.containsKey(str)) {
                v.w("MicroMsg.CdnImageService", "contains url[%s]", str);
                return;
            }
            this.cLf.put(str, cVar);
            e.a(new b(str, this.cLf), "CdnImageService_download");
            return;
        }
        v.i("MicroMsg.CdnImageService", "do load ok, url[%s], bitmap exists", str);
        if (cVar != null) {
            cVar.j(gu);
        }
    }
}
