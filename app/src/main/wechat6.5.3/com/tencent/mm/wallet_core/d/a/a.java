package com.tencent.mm.wallet_core.d.a;

import com.tencent.mm.model.k;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.c.amn;
import com.tencent.mm.protocal.c.amo;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.wallet_core.b.g;
import com.tencent.mm.wallet_core.b.l;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import com.tenpay.android.wechat.TenpayUtil;
import java.net.URLEncoder;

public abstract class a extends g {
    public abstract int bfC();

    public final int bfq() {
        return bfC();
    }

    public final void x(boolean z, boolean z2) {
        b bVar = this.cif;
        if (bVar == null) {
            com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
            aVar.czn = new amn();
            aVar.czo = new amo();
            aVar.uri = "/cgi-bin/mmpay-bin/payu";
            aVar.czm = 1518;
            aVar.czp = 0;
            aVar.czq = 0;
            bVar = aVar.Bv();
            bVar.czB = true;
        }
        b bVar2 = bVar;
        amn com_tencent_mm_protocal_c_amn = (amn) bVar2.czk.czs;
        if (z) {
            com_tencent_mm_protocal_c_amn.mDi = bfC();
        }
        if (z2) {
            com_tencent_mm_protocal_c_amn.mDj = 1;
        }
        this.cif = bVar2;
    }

    public final int getType() {
        return 1518;
    }

    public final String CX(String str) {
        return TenpayUtil.signWith3Des(str);
    }

    public final void a(b bVar, are com_tencent_mm_protocal_c_are) {
        ((amn) bVar.czk.czs).mDk = com_tencent_mm_protocal_c_are;
    }

    public final void b(b bVar, are com_tencent_mm_protocal_c_are) {
        ((amn) bVar.czk.czs).mNe = com_tencent_mm_protocal_c_are;
    }

    public final l c(b bVar) {
        amo com_tencent_mm_protocal_c_amo = (amo) bVar.czl.czs;
        l lVar = new l();
        lVar.mDo = com_tencent_mm_protocal_c_amo.mDo;
        lVar.mDn = com_tencent_mm_protocal_c_amo.mDn;
        lVar.mDm = com_tencent_mm_protocal_c_amo.mDm;
        lVar.mDl = com_tencent_mm_protocal_c_amo.mDl;
        lVar.fvD = com_tencent_mm_protocal_c_amo.mNg;
        lVar.piF = com_tencent_mm_protocal_c_amo.mNf;
        return lVar;
    }

    public int a(e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        if (k.xT()) {
            return a(eVar, this.cif, this);
        }
        v.e("MicroMsg.NetScenePayUBase", "hy: serious error: not payupay");
        eVar2.a(BaseReportManager.MAX_READ_COUNT, -100868, "Pay Method Err", this);
        return 1;
    }

    public final void b(StringBuilder stringBuilder, String str) {
        stringBuilder.append(URLEncoder.encode(str));
    }
}
