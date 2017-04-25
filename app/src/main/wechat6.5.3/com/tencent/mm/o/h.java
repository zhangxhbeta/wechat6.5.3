package com.tencent.mm.o;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class h implements ag {
    private static HashMap<Integer, c> bXq;
    private static h cip;
    private e cim;
    private c cin = new c();
    Map<Integer, List<f>> cio = new HashMap();

    static h un() {
        h hVar = (h) ak.yP().fY(h.class.getName());
        cip = hVar;
        if (hVar == null) {
            cip = new h();
            ak.yP().a(h.class.getName(), cip);
        }
        return cip;
    }

    public static e uo() {
        if (un().cim == null) {
            h un = un();
            ak.yW();
            un.cim = new e(com.tencent.mm.model.c.wE());
        }
        return un().cim;
    }

    public static c up() {
        if (un().cin == null) {
            un().cin = new c();
        }
        return un().cin;
    }

    public static synchronized void a(f fVar) {
        synchronized (h.class) {
            v.i("MicroMsg.SubCoreFunctionMsg", "removeUpdateCallback, msgType: %s, callback: %s", Integer.valueOf(12399999), fVar);
            if (fVar != null) {
                List list = (List) un().cio.get(Integer.valueOf(12399999));
                if (list != null && list.contains(fVar)) {
                    list.remove(fVar);
                    un().cio.put(Integer.valueOf(12399999), list);
                }
            }
        }
    }

    public static synchronized void b(f fVar) {
        synchronized (h.class) {
            v.i("MicroMsg.SubCoreFunctionMsg", "addUpdateCallback, msgType: %s, callback: %s", Integer.valueOf(12399999), fVar);
            if (fVar != null) {
                List list = (List) un().cio.get(Integer.valueOf(12399999));
                if (list == null) {
                    list = new ArrayList();
                }
                if (!list.contains(fVar)) {
                    list.add(fVar);
                }
                un().cio.put(Integer.valueOf(12399999), list);
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("FunctionMsgItem".hashCode()), new c() {
            public final String[] pS() {
                return e.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        v.i("MicroMsg.SubCoreFunctionMsg", "onAccountPostReset");
        ak.vA().x(new Runnable() {
            public final void run() {
                v.i("MicroMsg.FetchAllNeedFunctionJob", "FetchAllNeedFunctionJob, run");
                if (!h.up().ug() && !h.up().uh()) {
                    h.up().ui();
                }
            }
        });
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        v.d("MicroMsg.SubCoreFunctionMsg", "onAccountRelease");
    }
}
