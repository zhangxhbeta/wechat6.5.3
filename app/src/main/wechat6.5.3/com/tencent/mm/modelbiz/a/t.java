package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.adc;
import com.tencent.mm.protocal.c.add;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;

public final class t extends k implements j {
    public String cEj;
    public b cif;
    private e cii;
    Object data;

    public t(String str, String str2, LinkedList<String> linkedList, Object obj) {
        a aVar = new a();
        aVar.czn = new adc();
        aVar.czo = new add();
        aVar.uri = "/cgi-bin/mmocbiz-bin/initiatebizchat";
        this.cif = aVar.Bv();
        adc com_tencent_mm_protocal_c_adc = (adc) this.cif.czk.czs;
        com_tencent_mm_protocal_c_adc.mop = str;
        if (str2 == null) {
            str2 = SQLiteDatabase.KeyEmpty;
        }
        com_tencent_mm_protocal_c_adc.mEd = str2;
        com_tencent_mm_protocal_c_adc.mEe = linkedList;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneInitiateBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1389;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.i("MicroMsg.NetSceneInitiateBizChat", "do scene");
        return a(eVar, this.cif, this);
    }

    public final add DT() {
        if (this.cif == null || this.cif.czl.czs == null) {
            return null;
        }
        return (add) this.cif.czl.czs;
    }
}
