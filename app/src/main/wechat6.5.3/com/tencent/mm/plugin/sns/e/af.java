package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class af implements e {
    HashMap<String, i> jmR = new HashMap();

    static /* synthetic */ void a(af afVar, int i) {
        if (afVar.jmR == null || afVar.jmR.size() == 0) {
            v.i("MicroMsg.SnsExtCache", "nothing need to pushto snsext");
            return;
        }
        Object obj;
        long er;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        if (ad.wE() != null) {
            obj = 1;
            er = ad.wE().er(Thread.currentThread().getId());
        } else {
            obj = null;
            er = 0;
        }
        v.d("MicroMsg.SnsExtCache", "writeNums " + i + " " + er);
        LinkedList linkedList = new LinkedList();
        for (String str2 : afVar.jmR.keySet()) {
            linkedList.add(str2);
            if (linkedList.size() >= i) {
                break;
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            str2 = (String) it.next();
            if (afVar.jmR.containsKey(str2) && !ad.aSn()) {
                ad.aSG().b((i) afVar.jmR.get(str2));
                afVar.jmR.remove(str2);
            }
        }
        if (obj != null) {
            ad.wE().es(er);
        }
        v.d("MicroMsg.SnsExtCache", "wirtes times : " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final i As(String str) {
        return (i) this.jmR.get(str);
    }

    public final boolean aSS() {
        ad.aSo().post(new Runnable(this) {
            final /* synthetic */ af jmS;

            {
                this.jmS = r1;
            }

            public final void run() {
                if (this.jmS.jmR.size() > 50) {
                    af.a(this.jmS, 10);
                }
            }
        });
        return true;
    }

    public final boolean aST() {
        ad.aSo().post(new Runnable(this) {
            final /* synthetic */ af jmS;

            {
                this.jmS = r1;
            }

            public final void run() {
                af.a(this.jmS, this.jmS.jmR.size());
            }
        });
        return true;
    }

    public final boolean a(final i iVar) {
        if (iVar == null || be.kS(iVar.field_userName)) {
            return false;
        }
        ad.aSo().post(new Runnable(this) {
            final /* synthetic */ af jmS;

            public final void run() {
                this.jmS.jmR.put(iVar.field_userName, iVar);
            }
        });
        return true;
    }
}
