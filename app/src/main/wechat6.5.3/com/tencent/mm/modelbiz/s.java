package com.tencent.mm.modelbiz;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.afc;
import com.tencent.mm.protocal.c.afd;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class s extends k implements j {
    public String cDf;
    public int cDg;
    public b cif;
    private e cii;
    public String tag;

    public s(String str, LinkedList<String> linkedList) {
        this(str, linkedList, (byte) 0);
    }

    private s(String str, LinkedList<String> linkedList, byte b) {
        this.cDg = 1;
        a aVar = new a();
        aVar.czn = new afc();
        aVar.czo = new afd();
        aVar.uri = "/cgi-bin/mmkf-bin/kfgetinfolist";
        aVar.czm = 675;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        afc com_tencent_mm_protocal_c_afc = (afc) this.cif.czk.czs;
        com_tencent_mm_protocal_c_afc.mEZ = str;
        com_tencent_mm_protocal_c_afc.mFc = linkedList;
        this.cDf = str;
        this.cDg = 1;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneKFGetInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 675;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.NetSceneKFGetInfoList", "do scene");
        return a(eVar, this.cif, this);
    }

    public final afd Dv() {
        if (this.cif == null || this.cif.czl.czs == null) {
            return null;
        }
        return (afd) this.cif.czl.czs;
    }
}
