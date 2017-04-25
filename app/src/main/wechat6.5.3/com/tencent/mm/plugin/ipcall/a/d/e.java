package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aat;
import com.tencent.mm.protocal.c.aau;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;
import java.io.IOException;

public final class e extends k implements j {
    private b cif = null;
    private com.tencent.mm.v.e cii;
    private aat gHG = null;
    public aau gHH = null;

    public e(int i) {
        a aVar = new a();
        aVar.czn = new aat();
        aVar.czo = new aau();
        aVar.czm = 257;
        aVar.uri = "/cgi-bin/micromsg-bin/getwechatoutcoupons";
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.gHG = (aat) this.cif.czk.czs;
        this.gHG.maG = i;
        aat com_tencent_mm_protocal_c_aat = this.gHG;
        ak.yW();
        com_tencent_mm_protocal_c_aat.mCb = ((Integer) c.vf().get(t.a.nqN, Integer.valueOf(0))).intValue();
        com_tencent_mm_protocal_c_aat = this.gHG;
        ak.yW();
        com_tencent_mm_protocal_c_aat.mCc = ((Integer) c.vf().get(t.a.nqC, Integer.valueOf(0))).intValue();
        v.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "NetSceneIPCallGetWeChatOutCoupons Scene:%d, RechargeWordingVersion:%d,AccountActivityWordingVersion:%d", new Object[]{Integer.valueOf(this.gHG.maG), Integer.valueOf(this.gHG.mCb), Integer.valueOf(this.gHG.mCc)});
    }

    public final int getType() {
        return 257;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gHH = (aau) ((b) pVar).czl.czs;
        if ((i2 == 0 || i3 == 0) && i2 == 0 && i3 == 0) {
            aau com_tencent_mm_protocal_c_aau = this.gHH;
            if (com_tencent_mm_protocal_c_aau != null) {
                v.i("MicroMsg.IPCallUtil", "[royle]begin save response,Balance:%s,PVWording:%s,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,SmsDesc:%s", new Object[]{com_tencent_mm_protocal_c_aau.mCg, com_tencent_mm_protocal_c_aau.mCh, com_tencent_mm_protocal_c_aau.mCd, com_tencent_mm_protocal_c_aau.gIE, com_tencent_mm_protocal_c_aau.aXz, com_tencent_mm_protocal_c_aau.gkC, com_tencent_mm_protocal_c_aau.mCe, com_tencent_mm_protocal_c_aau.mCf, com_tencent_mm_protocal_c_aau.mCi});
                try {
                    ak.yW();
                    c.vf().a(t.a.nrH, be.bn(com_tencent_mm_protocal_c_aau.toByteArray()));
                } catch (IOException e) {
                    v.i("MicroMsg.IPCallUtil", "[royle]save exception:%s", new Object[]{e.getMessage()});
                }
            }
        }
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
