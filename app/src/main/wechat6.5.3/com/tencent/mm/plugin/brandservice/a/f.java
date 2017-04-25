package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ab;
import com.tencent.mm.protocal.c.ry;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Iterator;
import java.util.LinkedList;

public final class f extends k implements j {
    private final b cif;
    private e cii;
    LinkedList<String> exp;

    public f() {
        a aVar = new a();
        aVar.czn = new ry();
        aVar.czo = new rz();
        aVar.uri = "/cgi-bin/micromsg-bin/getapplist";
        aVar.czm = 387;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.exp = new LinkedList();
        ry ryVar = (ry) this.cif.czk.czs;
        ak.yW();
        Object obj = c.vf().get(196610, null);
        String str = "MicroMsg.BrandService.BrandServiceApplication";
        String str2 = "get config, key[%d], value[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(196610);
        objArr[1] = obj == null ? "null" : obj.toString();
        v.i(str, str2, objArr);
        ryVar.mwb = be.a((Integer) obj, 0);
        v.i("MicroMsg.BrandService.NetSceneGetAppList", "info: request hash code %d", new Object[]{Integer.valueOf(ryVar.mwb)});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.w("MicroMsg.BrandService.NetSceneGetAppList", "on scene end code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            rz rzVar = (rz) this.cif.czl.czs;
            v.i("MicroMsg.BrandService.NetSceneGetAppList", "ok, hash code is %d, count is %d", new Object[]{Integer.valueOf(rzVar.mwb), Integer.valueOf(rzVar.eet)});
            v.i("MicroMsg.BrandService.NetSceneGetAppList", "result list is %s", new Object[]{rzVar.eeu.toString()});
            com.tencent.mm.plugin.brandservice.a.c(196610, Integer.valueOf(rzVar.mwb));
            Iterator it = rzVar.eeu.iterator();
            while (it.hasNext()) {
                this.exp.add(((ab) it.next()).gln);
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 387;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.BrandService.NetSceneGetAppList", "do scene");
        return a(eVar, this.cif, this);
    }
}
