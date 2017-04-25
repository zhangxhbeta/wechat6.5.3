package com.tencent.mm.ap;

import com.tencent.mm.network.p;
import com.tencent.mm.pluginsdk.l.a.b;
import com.tencent.mm.protocal.c.bbh;
import com.tencent.mm.protocal.c.bbi;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class f extends b {
    private com.tencent.mm.v.b cif;
    private e cii;

    public f() {
        a aVar = new a();
        aVar.czn = new bbh();
        aVar.czo = new bbi();
        aVar.uri = "/cgi-bin/micromsg-bin/updatesoterloginauthkey";
        this.cif = aVar.Bv();
        bbh com_tencent_mm_protocal_c_bbh = (bbh) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bbh.mXp = SQLiteDatabase.KeyEmpty;
        com_tencent_mm_protocal_c_bbh.mXo = SQLiteDatabase.KeyEmpty;
        com_tencent_mm_protocal_c_bbh.maG = 620;
    }

    public final void b(int i, int i2, String str, p pVar) {
        if (this.cii != null) {
            this.cii.a(i, i2, str, this);
        }
    }

    public final void JK() {
        if (this.cii != null) {
            this.cii.a(4, -1, SQLiteDatabase.KeyEmpty, this);
        }
    }

    public final e BH() {
        return this.cii;
    }

    public final void b(int i, int i2, String str) {
        if (this.cii != null) {
            this.cii.a(3, i2, str, this);
        }
    }

    public final int getType() {
        return 620;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }
}
