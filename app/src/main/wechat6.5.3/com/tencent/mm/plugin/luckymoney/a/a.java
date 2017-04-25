package com.tencent.mm.plugin.luckymoney.a;

import android.text.TextUtils;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo.b;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.luckymoney.c.ah;
import com.tencent.mm.plugin.luckymoney.c.d;
import com.tencent.mm.plugin.luckymoney.c.f;
import com.tencent.mm.plugin.luckymoney.c.n;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public final class a implements ag {
    private b eWu = new b(this) {
        final /* synthetic */ a gZW;

        {
            this.gZW = r1;
        }

        public final void a(com.tencent.mm.v.d.a aVar) {
            Map q = bf.q(m.a(aVar.czu.mbW), "sysmsg");
            v.i("MicroMsg.SubCoreLuckyMoney", "helios::::mPayMsgListener");
            if (q == null) {
                v.e("MicroMsg.SubCoreLuckyMoney", "Resolve msg error");
                return;
            }
            if ("14".equals((String) q.get(".sysmsg.paymsg.PayMsgType"))) {
                String decode = URLDecoder.decode((String) q.get(".sysmsg.paymsg.appmsgcontent"));
                if (TextUtils.isEmpty(decode)) {
                    v.e("MicroMsg.SubCoreLuckyMoney", "msgxml illegal");
                    return;
                }
                Map q2 = bf.q(decode, "msg");
                if (q2 == null) {
                    v.e("MicroMsg.SubCoreLuckyMoney", "Resolve appmsgxml error");
                    return;
                }
                String str = (String) q2.get(".msg.appmsg.wcpayinfo.paymsgid");
                if (be.kS(str)) {
                    v.e("MicroMsg.SubCoreLuckyMoney", "paymsgid is null");
                    return;
                }
                String str2 = (String) q.get(".sysmsg.paymsg.tousername");
                if (be.kS(decode) || be.kS(str2)) {
                    v.e("MicroMsg.SubCoreLuckyMoney", "onRecieveMsg get a illegal msg,which content or toUserName is null");
                } else if (this.gZW.axC().vY(str)) {
                    v.i("MicroMsg.SubCoreLuckyMoney", "insert a local msg for luckymoney");
                    if (!n.v(decode, str2, 1)) {
                        this.gZW.axC().vZ(str);
                    }
                }
            }
        }
    };
    private d gZS;
    private f gZT;
    private com.tencent.mm.plugin.luckymoney.c.b gZU = new com.tencent.mm.plugin.luckymoney.c.b();
    private ah gZV;

    public static a axz() {
        a aVar = (a) ak.yP().fY("plugin.luckymoney");
        if (aVar != null) {
            return aVar;
        }
        v.w("MicroMsg.SubCoreLuckyMoney", "not found in MMCore, new one");
        aVar = new a();
        ak.yP().a("plugin.luckymoney", aVar);
        return aVar;
    }

    public a() {
        File file = new File(axB());
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(e.cgq);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public final HashMap<Integer, c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
    }

    public final void aG(boolean z) {
        boolean z2 = true;
        an bnG = an.bnG();
        if (ak.uz()) {
            am.ash().a(4, bnG);
            ak.vy().a(1060, bnG);
        }
        ak.yU().a("paymsg", this.eWu, true);
        ak.yW();
        if (System.currentTimeMillis() - com.tencent.mm.model.c.vf().vc(352276) < 43200000) {
            z2 = false;
        }
        v.i("MicroMsg.SubCoreLuckyMoney", "isTime=" + z2 + ", isUpdate=" + z);
        if (z || z2) {
            v.i("MicroMsg.SubCoreLuckyMoney", "get service applist");
            an.bnG().dj(aa.getContext());
        }
        com.tencent.mm.pluginsdk.j.a.lxZ = new com.tencent.mm.plugin.luckymoney.sns.a.a();
        com.tencent.mm.sdk.c.a.nhr.e(this.gZU);
        this.gZV = new ah();
    }

    public final void th() {
        an bnG = an.bnG();
        if (ak.uz()) {
            am.ash().b(4, bnG);
            ak.vy().b(1060, bnG);
            bnG.lBB = false;
            bnG.lBC = false;
        }
        ak.yU().b("paymsg", this.eWu, true);
        this.gZT = null;
        com.tencent.mm.pluginsdk.j.a.lxZ = null;
        com.tencent.mm.sdk.c.a.nhr.f(this.gZU);
        if (this.gZV != null) {
            ah ahVar = this.gZV;
            com.tencent.mm.sdk.c.a.nhr.f(ahVar.hcA);
            if (ahVar.hcx != null) {
                ak.vy().c(ahVar.hcx);
                ahVar.hcx = null;
            }
            if (ahVar.hcy != null) {
                ak.vy().c(ahVar.hcy);
                ahVar.hcy = null;
            }
        }
    }

    public static d axA() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (axz().gZS == null) {
            axz().gZS = new d();
        }
        return axz().gZS;
    }

    public static String axB() {
        if (!ak.uz()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(com.tencent.mm.model.c.wP()).append("luckymoney").toString();
    }

    public final synchronized f axC() {
        if (this.gZT == null) {
            this.gZT = new f();
        }
        return this.gZT;
    }
}
