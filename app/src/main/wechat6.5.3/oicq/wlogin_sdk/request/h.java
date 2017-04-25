package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;

public final class h extends d {
    public h(i iVar) {
        this.pMT = 2064;
        this.pMU = 3;
        this.pMW = iVar;
    }

    public final int j(byte[] bArr, int i, int i2) {
        a fVar = new f();
        a gVar = new g();
        int G = super.G(bArr, i + 2);
        super.bQU();
        int i3 = i + 5;
        switch (G) {
            case 2:
                int l = fVar.l(bArr, i3, this.pMI - i3);
                if (l >= 0) {
                    this.pMW.pNb = fVar;
                    l = gVar.l(bArr, i3, this.pMI - i3);
                    if (l >= 0) {
                        this.pMW.pNc = gVar;
                        return G;
                    }
                }
                return l;
            case 5:
                super.i(bArr, i3, (this.pMI - i3) - 1);
                return G;
            default:
                i(bArr, i3, (this.pMI - i3) - 1);
                return G;
        }
    }
}
