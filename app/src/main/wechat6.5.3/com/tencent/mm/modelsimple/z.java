package com.tencent.mm.modelsimple;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.aa.a;
import com.tencent.mm.protocal.c.asn;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import junit.framework.Assert;

public final class z extends k implements j {
    private final p cAt;
    private e cii;

    public z(int i, String str) {
        this(i, str, "");
    }

    public z(int i, String str, String str2) {
        this.cAt = new e();
        a aVar = (a) this.cAt.Bx();
        aVar.lXw.gln = com.tencent.mm.model.k.xF();
        asn com_tencent_mm_protocal_c_asn = aVar.lXw;
        StringBuilder stringBuilder = new StringBuilder();
        if (i == 0) {
            i = 64;
        }
        stringBuilder = stringBuilder.append(i).append(";");
        if (str == null) {
            str = "";
        }
        com_tencent_mm_protocal_c_asn.hQP = stringBuilder.append(str).toString();
        v.d("MicroMsg.NetSceneSendCard", "content:" + aVar.lXw.hQP);
        Assert.assertTrue("empty sendcard", true);
        aVar.lXw.mKR = 64;
        if (str2 != null && str2.length() > 0) {
            aVar.lXw.mRk = str2;
        }
    }

    public z(String str) {
        this.cAt = new e();
        a aVar = (a) this.cAt.Bx();
        aVar.lXw.gln = com.tencent.mm.model.k.xF();
        aVar.lXw.hQP = str;
        v.d("MicroMsg.NetSceneSendCard", "content:" + str);
        asn com_tencent_mm_protocal_c_asn = aVar.lXw;
        ak.yW();
        com_tencent_mm_protocal_c_asn.mAp = be.f((Integer) c.vf().get(66561, null));
        Assert.assertTrue("empty sendcard", true);
        aVar.lXw.mKR = 128;
    }

    public z(String str, boolean z, boolean z2) {
        int i;
        this.cAt = new e();
        a aVar = (a) this.cAt.Bx();
        aVar.lXw.gln = com.tencent.mm.model.k.xF();
        aVar.lXw.hQP = str;
        v.d("MicroMsg.NetSceneSendCard", "content:" + str);
        asn com_tencent_mm_protocal_c_asn = aVar.lXw;
        ak.yW();
        com_tencent_mm_protocal_c_asn.mAp = be.f((Integer) c.vf().get(66561, null));
        int i2 = ((z ? 1 : 0) | 0) | 0;
        if (z2) {
            i = 4;
        } else {
            i = 0;
        }
        i = (i | i2) | 8;
        Assert.assertTrue("empty sendcard", true);
        aVar.lXw.mKR = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cAt, this);
    }

    public final int getType() {
        return 26;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.cii.a(i2, i3, pVar.ze().lWV, this);
    }
}
