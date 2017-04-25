package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.ans;
import com.tencent.mm.protocal.c.ant;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class g extends k implements j {
    private b cif = null;
    private e cii = null;
    public ans gHK = null;
    public ant gHL = null;

    public g(String str, String str2, int i, int i2, int i3) {
        a aVar = new a();
        aVar.czn = new ans();
        aVar.czo = new ant();
        aVar.czm = 991;
        aVar.uri = "/cgi-bin/micromsg-bin/pstninvite";
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        long currentTimeMillis = System.currentTimeMillis();
        int avA = c.avA();
        ans com_tencent_mm_protocal_c_ans = (ans) this.cif.czk.czs;
        com_tencent_mm_protocal_c_ans.gon = com.tencent.mm.model.k.xF();
        com_tencent_mm_protocal_c_ans.mNP = str2;
        com_tencent_mm_protocal_c_ans.gom = str;
        com_tencent_mm_protocal_c_ans.mNO = i;
        com_tencent_mm_protocal_c_ans.mnk = avA;
        com_tencent_mm_protocal_c_ans.mNX = 1;
        com_tencent_mm_protocal_c_ans.mNN = currentTimeMillis;
        com_tencent_mm_protocal_c_ans.mNW = i2;
        com_tencent_mm_protocal_c_ans.mNY = i3;
        this.gHK = com_tencent_mm_protocal_c_ans;
        v.i("MicroMsg.NetSceneIPCallInvite", "toUsername: %s, phoneNumber: %s, invitedId: %s, netType: %d, dialScene: %d, countryType: %d", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(avA), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final int getType() {
        return 991;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneIPCallInvite", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gHL = (ant) ((b) pVar).czl.czs;
        if (i2 == 0 || i3 == 0) {
            if (this.cii != null) {
                this.cii.a(i2, i3, str, this);
            }
        } else if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
