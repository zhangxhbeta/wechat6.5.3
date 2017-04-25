package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.a.ao;
import oicq.wlogin_sdk.a.f;

public final class g extends d {
    public g(i iVar) {
        this.pMT = 2064;
        this.pMU = 2;
        this.pMW = iVar;
    }

    public final byte[] bG(byte[] bArr) {
        int length;
        int i;
        int i2 = this.pMW.pNg;
        byte[] bQW = this.pMW.pNb.bQW();
        oicq.wlogin_sdk.a.g gVar = this.pMW.pNc;
        Object obj = new byte[gVar.pNO];
        if (gVar.pNO > 0) {
            System.arraycopy(gVar.pMN, gVar.pNQ, obj, 0, gVar.pNO);
        }
        f fVar = new f();
        ao aoVar = new ao();
        Object bH = fVar.bH(bQW);
        Object o = aoVar.o(bArr, obj);
        Object obj2 = new byte[(bH.length + o.length)];
        if (bQW.length > 0) {
            System.arraycopy(bH, 0, obj2, 0, bH.length);
            length = bH.length + 0;
            i = 1;
        } else {
            length = 0;
            i = 0;
        }
        System.arraycopy(o, 0, obj2, length, o.length);
        a(this.pMO, this.pMT, pMP, this.pMW._uin, this.pMQ, this.pMR, i2, this.pMS, super.h(obj2, this.pMU, i + 1));
        return super.bQT();
    }
}
