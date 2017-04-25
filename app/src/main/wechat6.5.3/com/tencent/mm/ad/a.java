package com.tencent.mm.ad;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.fy;
import com.tencent.mm.protocal.c.fz;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    public static int cKv = 0;
    public static int cKw = 1;
    public static int cKx = -85;
    private int cKA = 0;
    private int cKy = -1;
    private String cKz;
    private final b cif;
    private e cii;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] cKB = new int[a.Gh().length];

        static {
            try {
                cKB[a.cKC - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                cKB[a.cKD - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum a {
        ;

        public static int[] Gh() {
            return (int[]) cKE.clone();
        }

        static {
            cKC = 1;
            cKD = 2;
            cKE = new int[]{cKC, cKD};
        }
    }

    public a(int i, String str, int i2) {
        switch (AnonymousClass1.cKB[i - 1]) {
            case 1:
                this.cKy = 1;
                break;
            case 2:
                this.cKy = 2;
                break;
        }
        this.cKz = str;
        this.cKA = i2;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new fy();
        aVar.czo = new fz();
        aVar.uri = "/cgi-bin/micromsg-bin/bindgooglecontact";
        aVar.czm = 487;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
        this.cii = eVar2;
        fy fyVar = (fy) this.cif.czk.czs;
        fyVar.meB = this.cKy;
        fyVar.mgj = this.cKz;
        fyVar.mgk = this.cKA;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.cii.a(i2, i3, str, this);
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 487;
    }
}
