package com.tencent.mm.modelgeo;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.sa;
import com.tencent.mm.protocal.c.sb;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends k implements j {
    private String bfi = "";
    public final b cif;
    private e cii;

    public d(double d, double d2) {
        a aVar = new a();
        aVar.czn = new sa();
        aVar.czo = new sb();
        aVar.uri = "/cgi-bin/micromsg-bin/getaddress";
        aVar.czm = 655;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        sa saVar = (sa) this.cif.czk.czs;
        saVar.mhZ = d;
        saVar.mhY = d2;
    }

    public final int getType() {
        return 655;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetAddress", "onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            this.bfi = ((sb) ((b) pVar).czl.czs).mwc;
            v.d("MicroMsg.NetSceneGetAddress", this.bfi);
            if (this.cii != null) {
                this.cii.a(i2, i3, str, this);
            }
        } else if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final Addr Gb() {
        if (be.kS(this.bfi)) {
            return null;
        }
        Addr addr = new Addr();
        try {
            v.d("MicroMsg.NetSceneGetAddress", "tofutest retJson: %s", new Object[]{this.bfi});
            JSONArray jSONArray = new JSONObject(this.bfi).getJSONArray("results");
            addr.cJf = jSONArray.getJSONObject(1).getString("address_name");
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            addr.cJh = jSONObject.getString("p");
            addr.cJi = jSONObject.getString("c");
            addr.cJk = jSONObject.getString("d");
            addr.cJl = "";
            addr.cJm = "";
            addr.cJn = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("dtype");
                    if ("ST".equals(string)) {
                        addr.cJm = jSONObject.getString("name");
                    } else if ("ST_NO".equals(string)) {
                        addr.cJn = jSONObject.getString("name");
                    }
                    if ("FORMAT_ADDRESS".equals(string)) {
                        addr.cJo = jSONObject.getString("rough_address_name");
                    }
                } catch (Exception e) {
                }
            }
            if (!be.kS(addr.cJn)) {
                addr.cJm = "";
            }
            return addr;
        } catch (Exception e2) {
            return null;
        }
    }
}
