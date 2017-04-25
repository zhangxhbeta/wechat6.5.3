package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ab;
import com.tencent.mm.protocal.c.atl;
import com.tencent.mm.protocal.c.atm;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import java.util.LinkedList;
import java.util.List;

public final class k extends com.tencent.mm.v.k implements j {
    private final b cif;
    private e cii;

    public k(List<b> list) {
        a aVar = new a();
        aVar.czn = new atl();
        aVar.czo = new atm();
        aVar.uri = "/cgi-bin/micromsg-bin/setapplist";
        aVar.czm = 386;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        atl com_tencent_mm_protocal_c_atl = (atl) this.cif.czk.czs;
        LinkedList linkedList = new LinkedList();
        for (b bVar : list) {
            ab abVar = new ab();
            abVar.gln = bVar.userName;
            linkedList.add(abVar);
        }
        com_tencent_mm_protocal_c_atl.eet = linkedList.size();
        com_tencent_mm_protocal_c_atl.eeu = linkedList;
        v.i("MicroMsg.BrandService.NetSceneSetAppList", "info: upload size %d, toString %s", new Object[]{Integer.valueOf(linkedList.size()), linkedList.toString()});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.BrandService.NetSceneSetAppList", "on scene end code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            v.i("MicroMsg.BrandService.NetSceneSetAppList", "ok, hash code is %d", new Object[]{Integer.valueOf(((atm) this.cif.czl.czs).mwb)});
            com.tencent.mm.plugin.brandservice.a.c(196610, Integer.valueOf(r0.mwb));
            com.tencent.mm.plugin.brandservice.a.c(196611, Boolean.valueOf(false));
        } else {
            com.tencent.mm.plugin.brandservice.a.c(196611, Boolean.valueOf(true));
        }
        this.cii.a(i2, i3, str, this);
    }

    public final int getType() {
        return 386;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.BrandService.NetSceneSetAppList", "do scene");
        return a(eVar, this.cif, this);
    }
}
