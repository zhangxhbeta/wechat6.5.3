package com.tencent.mm.plugin.sns.e;

import android.view.Menu;
import android.widget.Toast;
import com.tencent.mm.e.a.od;
import com.tencent.mm.e.a.oe;
import com.tencent.mm.e.a.of;
import com.tencent.mm.e.a.pi;
import com.tencent.mm.e.a.pk;
import com.tencent.mm.h.j;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class am {
    private static HashMap<String, b> jnk = new HashMap();
    private static LinkedList<a> jnl = new LinkedList();
    private static c jnm = new c<pk>() {
        {
            this.nhz = pk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            int i = 1;
            pk pkVar = (pk) bVar;
            if (pkVar instanceof pk) {
                String str = pkVar.bqM.id;
                int i2 = pkVar.bqM.type;
                a aV = am.aV(str, i2);
                if (aV != null) {
                    String str2 = pkVar.bqM.bqN;
                    aV.jno = str2;
                    aV.bpg = pkVar.bqM.bpg;
                    String str3 = "MicroMsg.SnsTranslateManager";
                    String str4 = "finish translate, id:%s, type: %d, success: %b";
                    Object[] objArr = new Object[3];
                    objArr[0] = aV.id;
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = Boolean.valueOf(!be.kS(str2));
                    v.i(str3, str4, objArr);
                    switch (i2) {
                        case 2:
                            break;
                        case 3:
                            i = 2;
                            break;
                        default:
                            i = -1;
                            break;
                    }
                    if (i != -1) {
                        am.d(str, i, aV.jno, aV.bpg);
                        am.jnl.remove(aV);
                    }
                }
            }
            return false;
        }
    };

    private static class a {
        String bpg;
        String id;
        String jnn;
        String jno;
        int type;

        private a() {
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            if (this.id.equals(aVar.id) && this.type == aVar.type) {
                return true;
            }
            return false;
        }
    }

    public static class b {
        public int bCd;
        public String bfz;
        public String cDd;
        public boolean cvW;
        public boolean cyo;
        public String id;
        public boolean jnp;
        public boolean jnq;
    }

    static /* synthetic */ a aV(String str, int i) {
        Iterator it = jnl.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.type == i && !be.kS(str) && !be.kS(aVar.id) && str.equals(aVar.id)) {
                return aVar;
            }
        }
        return null;
    }

    public static void init() {
        com.tencent.mm.sdk.c.a.nhr.e(jnm);
    }

    public static void Ny() {
        com.tencent.mm.sdk.c.a.nhr.f(jnm);
    }

    private static boolean oP() {
        if (!com.tencent.mm.ay.c.EH("translate")) {
            return false;
        }
        String value = j.sU().getValue("TranslateSnsOff");
        if (be.kS(value)) {
            return true;
        }
        if (be.KL(value) == 0) {
            return true;
        }
        return false;
    }

    public static void a(Menu menu, boolean z) {
        if (!oP()) {
            return;
        }
        if (z) {
            menu.add(0, 14, 0, 2131235567);
        } else {
            menu.add(0, 15, 0, 2131235567);
        }
    }

    public static void b(Menu menu, boolean z) {
        if (!oP()) {
            return;
        }
        if (z) {
            menu.add(0, 16, 0, 2131235569);
        } else {
            menu.add(0, 17, 0, 2131235569);
        }
    }

    public static void o(k kVar) {
        if (kVar != null) {
            String aUq = kVar.aUq();
            v.d("MicroMsg.SnsTranslateManager", "translatePost, id:%s", new Object[]{aUq});
            if (kVar.field_snsId == 0) {
                v.d("MicroMsg.SnsTranslateManager", "translatePost, the id is null or zero");
                jnk.remove(aUq);
                d(aUq, 1, null, null);
                return;
            }
            if (jnk.containsKey(aUq)) {
                b bVar = (b) jnk.get(aUq);
                if (!bVar.cvW || bVar.cyo) {
                    jnk.remove(aUq);
                } else {
                    v.d("MicroMsg.SnsTranslateManager", "translatePost, get from cache, id:%s", new Object[]{aUq});
                    d(bVar.id, 1, bVar.bfz, bVar.cDd);
                    return;
                }
            }
            if (kVar.aUp() != null) {
                String str = kVar.aUp().mWn;
                pi piVar = new pi();
                piVar.bqG.id = aUq;
                piVar.bqG.bqH = str;
                piVar.bqG.type = 2;
                com.tencent.mm.sdk.c.a.nhr.z(piVar);
                aR(kVar.aUq(), 1);
                a aVar = new a();
                aVar.id = aUq;
                aVar.jnn = str;
                aVar.type = 2;
                jnl.add(aVar);
            }
        }
    }

    public static void a(b bVar) {
        if ((bVar.bCd & 2) != 0) {
            bVar.jnp = false;
        } else if ((bVar.bCd & 4) != 0) {
            bVar.jnq = false;
        }
        jnk.put(bVar.id, bVar);
    }

    private static void b(b bVar) {
        if ((bVar.bCd & 2) != 0) {
            bVar.jnp = true;
        } else if ((bVar.bCd & 4) != 0) {
            bVar.jnq = true;
        }
        jnk.put(bVar.id, bVar);
    }

    public static void p(k kVar) {
        if (kVar != null) {
            String aUq = kVar.aUq();
            b(AA(aUq));
            of ofVar = new of();
            ofVar.bpi.type = 1;
            ofVar.bpi.id = aUq;
            com.tencent.mm.sdk.c.a.nhr.z(ofVar);
            v.d("MicroMsg.SnsTranslateManager", "unTranslatePost, id:%s", new Object[]{aUq});
        }
    }

    public static void a(com.tencent.mm.plugin.sns.ui.k kVar) {
        if (kVar != null && kVar.jkg != null) {
            long j;
            String str = kVar.hQP;
            StringBuilder stringBuilder = new StringBuilder();
            if (kVar.jkg.mSN != 0) {
                j = (long) kVar.jkg.mSN;
            } else {
                j = kVar.jkg.mSQ;
            }
            String cB = cB(kVar.jEU, stringBuilder.append(j).toString());
            if (jnk.containsKey(cB)) {
                b bVar = (b) jnk.get(cB);
                if (!bVar.cvW || be.kS(bVar.bfz)) {
                    jnk.remove(cB);
                } else {
                    v.d("MicroMsg.SnsTranslateManager", "translateComment, get from cache, id:%s", new Object[]{cB});
                    d(bVar.id, 2, bVar.bfz, bVar.cDd);
                    return;
                }
            }
            pi piVar = new pi();
            piVar.bqG.id = cB;
            piVar.bqG.bqH = str;
            piVar.bqG.type = 3;
            com.tencent.mm.sdk.c.a.nhr.z(piVar);
            aR(cB, 2);
            a aVar = new a();
            aVar.id = cB;
            aVar.jnn = str;
            aVar.type = 3;
            jnl.add(aVar);
            v.d("MicroMsg.SnsTranslateManager", "translateComment, id:%s", new Object[]{aVar.id});
        }
    }

    public static void b(com.tencent.mm.plugin.sns.ui.k kVar) {
        if (kVar != null) {
            String cB = cB(kVar.jEU, (kVar.jkg.mSN != 0 ? (long) kVar.jkg.mSN : kVar.jkg.mSQ));
            b(AA(cB));
            of ofVar = new of();
            ofVar.bpi.type = 2;
            ofVar.bpi.id = cB;
            com.tencent.mm.sdk.c.a.nhr.z(ofVar);
            v.d("MicroMsg.SnsTranslateManager", "unTranslateComment, id:%s", new Object[]{cB});
        }
    }

    private static void aR(String str, int i) {
        if (!jnk.containsKey(str)) {
            b bVar = new b();
            bVar.id = str;
            bVar.cDd = null;
            bVar.bfz = null;
            bVar.cvW = false;
            bVar.cyo = false;
            bVar.jnq = true;
            bVar.jnp = true;
            jnk.put(str, bVar);
        }
        oe oeVar = new oe();
        oeVar.bph.type = i;
        oeVar.bph.id = str;
        com.tencent.mm.sdk.c.a.nhr.z(oeVar);
    }

    private static void d(String str, int i, String str2, String str3) {
        if (jnk.containsKey(str)) {
            b bVar = (b) jnk.get(str);
            bVar.cDd = str3;
            bVar.bfz = str2;
            bVar.cvW = true;
            bVar.cyo = be.kS(str2);
            jnk.put(str, bVar);
        }
        if (be.kS(str2)) {
            Toast.makeText(aa.getContext(), 2131235568, 1).show();
        }
        od odVar = new od();
        odVar.bpf.type = i;
        odVar.bpf.id = str;
        odVar.bpf.bfz = str2;
        odVar.bpf.bpg = str3;
        com.tencent.mm.sdk.c.a.nhr.z(odVar);
    }

    public static String cB(String str, String str2) {
        return str + ";" + str2;
    }

    public static HashMap<String, b> aTc() {
        return jnk;
    }

    public static void aS(String str, int i) {
        if (jnk.containsKey(str)) {
            b bVar = (b) jnk.get(str);
            bVar.bCd |= i;
            jnk.put(str, bVar);
        }
    }

    public static void aT(String str, int i) {
        if (jnk.containsKey(str)) {
            b bVar = (b) jnk.get(str);
            bVar.bCd &= i ^ -1;
            if (i != 2 && i == 4) {
                bVar.jnq = true;
            }
            jnk.put(str, bVar);
        }
    }

    public static boolean aU(String str, int i) {
        if (!jnk.containsKey(str)) {
            return false;
        }
        if ((((b) jnk.get(str)).bCd & i) != 0) {
            return true;
        }
        return false;
    }

    public static boolean c(b bVar) {
        if (bVar == null || (bVar.bCd & 2) == 0) {
            return false;
        }
        return true;
    }

    public static b AA(String str) {
        if (jnk.containsKey(str)) {
            return (b) jnk.get(str);
        }
        return null;
    }
}
