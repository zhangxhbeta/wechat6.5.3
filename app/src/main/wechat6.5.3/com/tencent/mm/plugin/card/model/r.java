package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.card.b.q;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.protocal.c.iy;
import com.tencent.mm.protocal.c.iz;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;

public final class r extends k implements j {
    private final b cif;
    private e cii;
    public String eDv;
    public ArrayList<ix> eDw;

    public r(String str, float f, float f2, String str2) {
        this.eDv = str;
        a aVar = new a();
        aVar.czn = new iy();
        aVar.czo = new iz();
        aVar.uri = "/cgi-bin/micromsg-bin/cardshoplbs";
        aVar.czm = 563;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        iy iyVar = (iy) this.cif.czk.czs;
        iyVar.eBK = str;
        iyVar.biH = f;
        iyVar.bhs = f2;
        iyVar.bol = str2;
        v.d("MicroMsg.NetSceneCardShopLBS", "<init>, cardId = %s, longtitude = %f, latitude = %f, card_id = %s", new Object[]{str, Float.valueOf(f), Float.valueOf(f2), str2});
    }

    public final int getType() {
        return 563;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (be.kS(((iy) this.cif.czk.czs).eBK)) {
            v.e("MicroMsg.NetSceneCardShopLBS", "doScene fail, cardId is null");
            return -1;
        }
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            Object obj = ((iz) this.cif.czl.czs).eDn;
            if (TextUtils.isEmpty(obj)) {
                v.e("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd fail, json_ret is empty");
            }
            this.eDw = q.qI(obj);
            if (this.eDw != null) {
                v.d("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, respList size = %d", new Object[]{Integer.valueOf(this.eDw.size())});
            }
        }
        this.cii.a(i2, i3, str, this);
    }
}
