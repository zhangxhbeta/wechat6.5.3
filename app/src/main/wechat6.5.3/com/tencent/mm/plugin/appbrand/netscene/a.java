package com.tencent.mm.plugin.appbrand.netscene;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aqk;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.protocal.c.bjb;
import com.tencent.mm.protocal.c.bje;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class a extends k implements j {
    public final b cif;
    private e cxf;
    private a<a> dLZ;

    public interface a<T extends k> {
        void c(int i, int i2, String str, T t);
    }

    public a(LinkedList<bje> linkedList, aqk com_tencent_mm_protocal_c_aqk, a<a> aVar) {
        this(linkedList, com_tencent_mm_protocal_c_aqk);
        this.dLZ = aVar;
    }

    private a(LinkedList<bje> linkedList, aqk com_tencent_mm_protocal_c_aqk) {
        v.i("MicroMsg.webview.NetSceneIDKeyBatchReport", "NetSceneIDKeyBatchReport doScene recordList size %d", new Object[]{Integer.valueOf(linkedList.size())});
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new bja();
        aVar.czo = new bjb();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport";
        aVar.czm = 1009;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        bja com_tencent_mm_protocal_c_bja = (bja) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bja.ndq = linkedList;
        com_tencent_mm_protocal_c_bja.ndr = com_tencent_mm_protocal_c_aqk;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.webview.NetSceneIDKeyBatchReport", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.cxf != null) {
            this.cxf.a(i2, i3, str, this);
        }
        if (this.dLZ != null) {
            this.dLZ.c(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1009;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.webview.NetSceneIDKeyBatchReport", "doScene");
        this.cxf = eVar2;
        return a(eVar, this.cif, this);
    }
}
