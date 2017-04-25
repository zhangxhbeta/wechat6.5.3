package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;

public final class m {

    public static class a {
        public String bea;
        public String hOv;
        public String iQw;
        public String title;

        private a() {
        }

        public static a zs(String str) {
            Map q = bf.q(str, "nativepay");
            if (q == null) {
                return null;
            }
            try {
                a aVar = new a();
                aVar.title = be.ma((String) q.get(".nativepay.title"));
                aVar.bea = be.ma((String) q.get(".nativepay.thumburl"));
                aVar.iQw = be.ma((String) q.get(".nativepay.wx_pay_url"));
                aVar.hOv = be.ma((String) q.get(".nativepay.price"));
                return aVar;
            } catch (Throwable e) {
                v.a("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                return null;
            }
        }
    }

    public static class b {
        public String bea;
        public String id;
        public String title;

        private b() {
        }

        public static b zt(String str) {
            Map q = bf.q(str, "product");
            if (q == null) {
                return null;
            }
            try {
                b bVar = new b();
                bVar.title = be.ma((String) q.get(".product.title"));
                bVar.bea = be.ma((String) q.get(".product.thumburl"));
                bVar.id = be.ma((String) q.get(".product.product_id"));
                return bVar;
            } catch (Throwable e) {
                v.a("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                return null;
            }
        }
    }

    public static class c {
        public String bea;
        public String iQx;
        public String title;
        public String username;

        private c() {
        }

        public static c zu(String str) {
            Map q = bf.q(str, "tempsession");
            if (q == null) {
                return null;
            }
            try {
                c cVar = new c();
                cVar.title = be.ma((String) q.get(".tempsession.title"));
                cVar.bea = be.ma((String) q.get(".tempsession.thumburl"));
                cVar.username = be.ma((String) q.get(".tempsession.username"));
                cVar.iQx = be.ma((String) q.get(".tempsession.deeplinkjumpurl"));
                return cVar;
            } catch (Throwable e) {
                v.a("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                return null;
            }
        }
    }

    public static class d {
        public String bea;
        public String bkp;
        public String cZp;
        public String title;

        private d() {
        }

        public static d zv(String str) {
            Map q = bf.q(str, "h5url");
            if (q == null) {
                return null;
            }
            try {
                d dVar = new d();
                dVar.title = be.ma((String) q.get(".h5url.title"));
                dVar.bea = be.ma((String) q.get(".h5url.thumburl"));
                dVar.cZp = be.ma((String) q.get(".h5url.link"));
                dVar.bkp = be.ma((String) q.get(".h5url.username"));
                return dVar;
            } catch (Throwable e) {
                v.a("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                return null;
            }
        }
    }

    public static class e {
        public String aGX;
        public String iQy;
        public String userName;

        private e() {
        }

        public static e zw(String str) {
            Map q = bf.q(str, "bizprofile");
            if (q == null) {
                return null;
            }
            try {
                e eVar = new e();
                eVar.aGX = be.ma((String) q.get(".bizprofile.nickname"));
                eVar.userName = be.ma((String) q.get(".bizprofile.username"));
                eVar.iQy = be.ma((String) q.get(".bizprofile.showchat"));
                return eVar;
            } catch (Throwable e) {
                v.a("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                return null;
            }
        }
    }
}
