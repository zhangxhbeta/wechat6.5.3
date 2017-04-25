package com.tencent.mm.plugin.remittance.a;

import android.text.TextUtils;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.kq;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.remittance.c.j;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.d.a;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class b implements ag {
    private static HashMap<Integer, c> bXq;
    private com.tencent.mm.model.bo.b fvh = new com.tencent.mm.model.bo.b(this) {
        final /* synthetic */ b irj;

        {
            this.irj = r1;
        }

        public final void a(a aVar) {
            v.i("MicroMsg.SubCoreRemittance", "hy: received AddMsg");
            bm bmVar = aVar.czu;
            if (bmVar == null) {
                v.e("MicroMsg.SubCoreRemittance", "recieve a null msg");
                return;
            }
            String a = m.a(bmVar.mbW);
            if (be.kS(a)) {
                v.e("MicroMsg.SubCoreRemittance", "msg illegal,content is null");
                return;
            }
            Map q = bf.q(a, "sysmsg");
            if (q == null) {
                v.e("MicroMsg.SubCoreRemittance", "Resolve msg error");
                return;
            }
            a = (String) q.get(".sysmsg.paymsg.PayMsgType");
            String str;
            if ("15".equals(a)) {
                String decode = URLDecoder.decode((String) q.get(".sysmsg.paymsg.appmsgcontent"));
                if (TextUtils.isEmpty(decode)) {
                    v.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
                    return;
                }
                Map q2 = bf.q(decode, "msg");
                if (q2 == null) {
                    v.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
                    return;
                }
                a = (String) q2.get(".msg.appmsg.wcpayinfo.paymsgid");
                if (be.kS(a)) {
                    v.e("MicroMsg.SubCoreRemittance", "paymsgid is null");
                } else if (this.irj.aKd().yD(a)) {
                    v.e("MicroMsg.SubCoreRemittance", "it is a duplicate msg");
                } else {
                    str = (String) q.get(".sysmsg.paymsg.tousername");
                    if (be.kS(decode) || be.kS(str)) {
                        v.e("MicroMsg.SubCoreRemittance", "onRecieveMsg get a illegal msg,which content or toUserName is null");
                    } else {
                        this.irj.aKd().H(a, decode, str);
                    }
                }
            } else if ("22".equals(a)) {
                a = (String) q.get(".sysmsg.paymsg.tousername");
                str = (String) q.get(".sysmsg.paymsg.fromusername");
                try {
                    String decode2 = URLDecoder.decode((String) q.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
                    if (be.kS(decode2)) {
                        v.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
                        return;
                    }
                    Map q3 = bf.q(decode2, "msg");
                    if (q3 == null) {
                        v.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
                        return;
                    }
                    com.tencent.mm.plugin.remittance.b.a yC;
                    String str2 = (String) q3.get(".msg.appmsg.wcpayinfo.transferid");
                    int i = be.getInt((String) q3.get(".msg.appmsg.wcpayinfo.paysubtype"), -1);
                    v.d("MicroMsg.SubCoreRemittance", "fromusername: %s, tousername: %s, transferId: %s, paysubtype: %d", new Object[]{str, a, str2, Integer.valueOf(i)});
                    try {
                        b.aKb();
                        yC = b.aKc().yC(str2);
                    } catch (Throwable e) {
                        v.a("MicroMsg.SubCoreRemittance", e, "", new Object[0]);
                        yC = null;
                    }
                    if (yC == null) {
                        v.i("MicroMsg.SubCoreRemittance", "empty record");
                        return;
                    }
                    ak.yW();
                    at ek = com.tencent.mm.model.c.wJ().ek(yC.field_msgId);
                    if (ek.field_msgId <= 0) {
                        v.i("MicroMsg.SubCoreRemittance", "has delete msg");
                        b.aKb();
                        b.aKc().c(yC, new String[0]);
                        return;
                    }
                    v.i("MicroMsg.SubCoreRemittance", "update msg: %s", new Object[]{Long.valueOf(ek.field_msgId)});
                    ek.setContent(decode2);
                    ak.yW();
                    com.tencent.mm.model.c.wJ().a(ek.field_msgId, ek);
                } catch (Throwable e2) {
                    v.a("MicroMsg.SubCoreRemittance", e2, "", new Object[0]);
                }
            }
        }
    };
    private j irg = null;
    public com.tencent.mm.plugin.remittance.b.b irh = null;
    private com.tencent.mm.sdk.c.c<kq> iri = new com.tencent.mm.sdk.c.c<kq>(this) {
        final /* synthetic */ b irj;

        {
            this.irj = r2;
            this.nhz = kq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            kq kqVar = (kq) bVar;
            v.i("MicroMsg.SubCoreRemittance", "do insert delay transfer record: %s, %s", new Object[]{Long.valueOf(kqVar.blU.bao), kqVar.blU.blV});
            com.tencent.mm.plugin.remittance.b.a aVar = new com.tencent.mm.plugin.remittance.b.a();
            aVar.field_msgId = kqVar.blU.bao;
            aVar.field_transferId = kqVar.blU.blV;
            b.aKb();
            b.aKc().b(aVar);
            return false;
        }
    };

    static {
        com.tencent.mm.wallet_core.a.b("RemittanceProcess", a.class);
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("DelayTransferRecord".hashCode()), new c() {
            public final String[] pS() {
                return com.tencent.mm.plugin.remittance.b.b.cic;
            }
        });
    }

    public static b aKb() {
        b bVar = (b) ak.yP().fY("plugin.remittance");
        if (bVar != null) {
            return bVar;
        }
        v.w("MicroMsg.SubCoreRemittance", "not found in MMCore, new one");
        bVar = new b();
        ak.yP().a("plugin.remittance", bVar);
        return bVar;
    }

    public static com.tencent.mm.plugin.remittance.b.b aKc() {
        if (aKb().irh == null) {
            b aKb = aKb();
            ak.yW();
            aKb.irh = new com.tencent.mm.plugin.remittance.b.b(com.tencent.mm.model.c.wE());
        }
        return aKb().irh;
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
    }

    public final void aG(boolean z) {
        if (this.irg != null) {
            j jVar = this.irg;
            jVar.irS = null;
            jVar.fgr = null;
            synchronized (jVar.lock) {
                jVar.irR = new HashSet();
            }
        }
        ak.yU().a("paymsg", this.fvh, true);
        com.tencent.mm.sdk.c.a.nhr.d(this.iri);
    }

    public final void th() {
        ak.yU().b("paymsg", this.fvh, true);
        com.tencent.mm.sdk.c.a.nhr.f(this.iri);
    }

    public final j aKd() {
        if (this.irg == null) {
            this.irg = new j();
        }
        return this.irg;
    }
}
