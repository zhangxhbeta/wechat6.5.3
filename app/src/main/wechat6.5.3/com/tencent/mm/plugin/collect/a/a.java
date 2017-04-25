package com.tencent.mm.plugin.collect.a;

import com.tencent.mm.bg.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo.b;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.collect.b.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;

public final class a implements ag {
    private b eWu = new b(this) {
        final /* synthetic */ a eWv;

        {
            this.eWv = r1;
        }

        public final void a(com.tencent.mm.v.d.a aVar) {
            a.aeb();
            if (a.aec() != null) {
                String a = m.a(aVar.czu.mbW);
                a.aeb();
                com.tencent.mm.plugin.collect.b.a aec = a.aec();
                v.v("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] content:" + a);
                if (be.kS(a)) {
                    v.d("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] Msg content empty");
                    return;
                }
                Map q = bf.q(a, "sysmsg");
                int i = be.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), 0);
                if (i != 9) {
                    v.i("MicroMsg.CollectPayerMsgMgr", "Not ftf collect msg type, ignore; type=" + i);
                    return;
                }
                c cVar = new c();
                cVar.username = be.ma((String) q.get(".sysmsg.paymsg.username"));
                cVar.eWz = be.getDouble((String) q.get(".sysmsg.paymsg.fee"), 0.0d) / 100.0d;
                cVar.cpl = be.ma((String) q.get(".sysmsg.paymsg.feetype"));
                cVar.eWB = be.getInt((String) q.get(".sysmsg.paymsgtimestamp"), (int) be.Nh());
                cVar.eWA = be.ma((String) q.get(".sysmsg.paymsg.transid"));
                cVar.caJ = be.ma((String) q.get(".sysmsg.paymsg.displayname"));
                cVar.scene = be.getInt((String) q.get(".sysmsg.paymsg.scene"), 1);
                cVar.status = be.getInt((String) q.get(".sysmsg.paymsg.status"), 0);
                aec.a(cVar);
                return;
            }
            v.w("MicroMsg.SubCoreCollect", "func[onRecieveMsg] payerMsgMgr null");
        }
    };

    public static a aeb() {
        a aVar = (a) ak.yP().fY("plugin.collect");
        if (aVar != null) {
            return aVar;
        }
        v.w("MicroMsg.SubCoreCollect", "not found in MMCore, new one");
        aVar = new a();
        ak.yP().a("plugin.collect", aVar);
        return aVar;
    }

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
    }

    public final void aG(boolean z) {
        ak.yU().a("paymsg", this.eWu, true);
    }

    public final void th() {
        ak.yU().b("paymsg", this.eWu, true);
    }

    public static com.tencent.mm.plugin.collect.b.a aec() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() != 0) {
            return com.tencent.mm.plugin.collect.b.a.eWw;
        }
        throw new com.tencent.mm.model.b();
    }
}
