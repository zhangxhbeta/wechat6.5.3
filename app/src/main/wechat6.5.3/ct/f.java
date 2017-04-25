package ct;

import ct.t.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class f {
    public String a;
    public String b;
    public String c;
    public int d;
    public String e;
    public String f;
    public String g;
    public ArrayList h;
    public int i;
    public int j;
    public int k;
    public String l;
    public String m;
    public s n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;

    public final g a() {
        long currentTimeMillis = System.currentTimeMillis();
        bi biVar = new bi();
        bc.b();
        if (bc.e()) {
            this.f = be.b(this.h.toString());
            Map hashMap = new HashMap();
            hashMap.put("imei", be.a());
            hashMap.put("reqKey", this.f);
            ak akVar = new ak(this.a, this.b, this.h, this.e, this.c, this.d, this.i, this.j, this.g, hashMap);
            biVar.b("#halley-proxy.HalleyDispatchService");
            biVar.a("srvDispatch");
            biVar.a("request", akVar);
            aw a = i.a(biVar);
            a.b();
            this.o = bc.e();
            this.n = a.e();
            this.p = a.h();
            this.q = a.f();
            this.r = a.i();
            this.s = a.g();
            if (a.c() != 0 || a.a() == null) {
                this.k = a.c();
                this.m = a.d();
                return null;
            }
            try {
                al alVar = (al) a.a().b("response", new al());
                if (alVar == null) {
                    this.k = -8;
                    this.l = "Response is Null";
                    return null;
                }
                g gVar = new g();
                String a2 = bc.a();
                long currentTimeMillis2 = System.currentTimeMillis();
                if (a2.equals("unkonwn") || !a2.equals(this.g)) {
                    gVar.a = null;
                    this.k = -9;
                    this.l = "req apn:" + this.g + ",current apn:" + a2;
                } else {
                    Map map = alVar.a;
                    if (map != null && map.size() > 0) {
                        t tVar = new t(this.g);
                        for (String a22 : map.keySet()) {
                            if (map.get(a22) != null) {
                                ArrayList arrayList = ((am) map.get(a22)).a;
                                a aVar = new a(a22, currentTimeMillis2, ((am) alVar.a.get(a22)).b);
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    a22 = (String) it.next();
                                    s sVar = new s();
                                    if (sVar.a(a22)) {
                                        aVar.c.add(sVar);
                                    }
                                }
                                tVar.a(aVar);
                            }
                        }
                        gVar.a = tVar;
                    }
                }
                if (alVar.c != null) {
                    gVar.b = new d(alVar.c);
                }
                if (alVar.b != null) {
                    gVar.c = new c(alVar.b);
                }
                this.t = (int) (System.currentTimeMillis() - currentTimeMillis);
                return gVar;
            } catch (Exception e) {
                bd.d();
                this.k = -8;
                this.m = e.getClass().getSimpleName();
                this.l = be.a(e);
                return null;
            }
        }
        this.k = -4;
        this.l = "Network fail before schedule";
        return null;
    }
}
