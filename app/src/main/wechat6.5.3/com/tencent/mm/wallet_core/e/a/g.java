package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.model.k;
import com.tencent.mm.network.e;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.azm;
import com.tencent.mm.protocal.c.azn;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.wallet_core.b.l;
import com.tencent.mm.wallet_core.b.p;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Vector;

public abstract class g extends com.tencent.mm.wallet_core.b.g {
    public static Vector<String> piX = new Vector();

    public abstract int aed();

    public int bfq() {
        return aed();
    }

    public final void x(boolean z, boolean z2) {
        b bVar = this.cif;
        if (bVar == null) {
            a aVar = new a();
            aVar.czn = new azm();
            aVar.czo = new azn();
            String uri = getUri();
            int zg = zg();
            aVar.uri = uri;
            aVar.czm = zg;
            aVar.czp = 185;
            aVar.czq = 1000000185;
            bVar = aVar.Bv();
            bVar.czB = true;
        }
        b bVar2 = bVar;
        azm com_tencent_mm_protocal_c_azm = (azm) bVar2.czk.czs;
        if (z) {
            com_tencent_mm_protocal_c_azm.mDi = aed();
        }
        if (z2) {
            com_tencent_mm_protocal_c_azm.mDj = 1;
        }
        this.cif = bVar2;
    }

    public int getType() {
        return 385;
    }

    public final String CX(String str) {
        return TenpayUtil.signWith3Des(str);
    }

    public final void a(b bVar, are com_tencent_mm_protocal_c_are) {
        ((azm) bVar.czk.czs).mDk = com_tencent_mm_protocal_c_are;
    }

    public final void b(b bVar, are com_tencent_mm_protocal_c_are) {
        ((azm) bVar.czk.czs).mNe = com_tencent_mm_protocal_c_are;
    }

    static {
        for (Object add : c.lVL) {
            piX.add(add);
        }
    }

    public final l c(b bVar) {
        azn com_tencent_mm_protocal_c_azn = (azn) bVar.czl.czs;
        l lVar = new l();
        lVar.mDo = com_tencent_mm_protocal_c_azn.mDo;
        lVar.mDn = com_tencent_mm_protocal_c_azn.mDn;
        lVar.mDm = com_tencent_mm_protocal_c_azn.mDm;
        lVar.mDl = com_tencent_mm_protocal_c_azn.mDl;
        lVar.fvD = com_tencent_mm_protocal_c_azn.mNg;
        lVar.piF = com_tencent_mm_protocal_c_azn.mNf;
        return lVar;
    }

    public final int a(e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        if (piX.contains(this.cif.uri)) {
            v.d("MicroMsg.NetSenceTenPayBase", "black cgi bye bye %s", new Object[]{this.cif.uri});
        } else {
            Object[] objArr = new Object[1];
            com.tencent.mm.wallet_core.b.a.bKZ();
            objArr[0] = Integer.valueOf(com.tencent.mm.wallet_core.b.a.getLastError());
            v.i("MicroMsg.NetSenceTenPayBase", "cert try get errormsg %s", objArr);
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.wallet_core.b.a.bKZ();
            com.tencent.mm.wallet_core.b.a.init(aa.getContext());
            azm com_tencent_mm_protocal_c_azm = (azm) this.cif.czk.czs;
            String str = "";
            String str2 = "";
            if (com_tencent_mm_protocal_c_azm.mDk != null) {
                str = new String(com_tencent_mm_protocal_c_azm.mDk.mQw.lVU);
            }
            if (com_tencent_mm_protocal_c_azm.mNe != null) {
                str2 = new String(com_tencent_mm_protocal_c_azm.mNe.mQw.lVU);
            }
            String str3 = new String((str + "&&" + str2).getBytes());
            p.bLj();
            String bLi = p.bLi();
            com.tencent.mm.wallet_core.b.a.bKZ();
            if (com.tencent.mm.wallet_core.b.a.isCertExist(bLi)) {
                com.tencent.mm.plugin.report.service.g.iuh.a(414, 20, 1, true);
                com.tencent.mm.wallet_core.b.a.bKZ();
                String genUserSig = com.tencent.mm.wallet_core.b.a.genUserSig(bLi, str3);
                com.tencent.mm.plugin.report.service.g.iuh.a(414, 21, System.currentTimeMillis() - currentTimeMillis, true);
                v.v("MicroMsg.NetSenceTenPayBase", "sign ret src:%s sign:%s", new Object[]{str3, genUserSig});
                com_tencent_mm_protocal_c_azm.fZW = genUserSig;
                com_tencent_mm_protocal_c_azm.mWk = bLi;
            } else {
                objArr = new Object[2];
                objArr[0] = bLi;
                com.tencent.mm.wallet_core.b.a.bKZ();
                objArr[1] = Integer.valueOf(com.tencent.mm.wallet_core.b.a.getLastError());
                v.i("MicroMsg.NetSenceTenPayBase", "cert not exist cn %s %s", objArr);
            }
            v.i("MicroMsg.NetSenceTenPayBase", "sign cost time %s cn %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), bLi});
        }
        if (k.xT()) {
            v.e("MicroMsg.NetSenceTenPayBase", "hy: serious error: is payupay");
            eVar2.a(BaseReportManager.MAX_READ_COUNT, -100868, "Pay Method Err", this);
            return 1;
        }
        return a(eVar, this.cif, this);
    }

    public String getUri() {
        return "/cgi-bin/micromsg-bin/tenpay";
    }

    public int zg() {
        return 385;
    }
}
