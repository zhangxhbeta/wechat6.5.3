package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class n {
    private List<WeakReference<a>> eAR = new ArrayList();
    public ArrayList<Long> hIJ = new ArrayList();
    public b hKX = null;

    public interface a {
        boolean a(c cVar);
    }

    public class c {
        final /* synthetic */ n hLb;
        public int hLc;

        public c(n nVar) {
            this.hLb = nVar;
        }
    }

    public class b extends c {
        public String hKY;
        public String hKZ;
        public String hLa;
        final /* synthetic */ n hLb;

        public b(n nVar) {
            this.hLb = nVar;
            super(nVar);
        }
    }

    public class d extends c {
        final /* synthetic */ n hLb;
        public String hLd;
        public String hLe;
        public String hLf;
        public String hLg;
        public String hLh;

        public d(n nVar) {
            this.hLb = nVar;
            super(nVar);
        }
    }

    public class e extends c {
        final /* synthetic */ n hLb;
        public String hLi;
        public Orders hLj;

        public e(n nVar) {
            this.hLb = nVar;
            super(nVar);
        }
    }

    public class f extends c {
        final /* synthetic */ n hLb;
        public String hLk;
        public String hLl;
        public int hLm;
        public String id;

        public f(n nVar) {
            this.hLb = nVar;
            super(nVar);
        }
    }

    public n() {
        Object aFs = com.tencent.mm.plugin.offline.b.a.aFs();
        if (!TextUtils.isEmpty(aFs)) {
            Map q = bf.q(aFs, "sysmsg");
            if (q != null) {
                int i = be.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1);
                if (i >= 0 && i == 4) {
                    v.i("MicroMsg.WalletOfflineMsgManager", "msg type is 4 ");
                    b(v(q));
                }
            }
        }
        this.hIJ.clear();
    }

    public final void b(c cVar) {
        if (this.eAR != null) {
            for (int i = 0; i < this.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null && aVar.a(cVar)) {
                        return;
                    }
                }
            }
        }
    }

    public final void a(a aVar) {
        if (this.eAR == null) {
            this.eAR = new ArrayList();
        }
        if (aVar != null) {
            this.eAR.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        if (this.eAR != null && aVar != null) {
            for (int i = 0; i < this.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        this.eAR.remove(weakReference);
                        return;
                    }
                }
            }
        }
    }

    public final b v(Map<String, String> map) {
        if (this.hKX == null) {
            this.hKX = new b(this);
        }
        this.hKX.hLc = be.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), -1);
        this.hKX.hKY = (String) map.get(".sysmsg.paymsg.isfreeze");
        this.hKX.hKZ = (String) map.get(".sysmsg.paymsg.freezetype");
        this.hKX.hLa = (String) map.get(".sysmsg.paymsg.freezemsg");
        return this.hKX;
    }
}
