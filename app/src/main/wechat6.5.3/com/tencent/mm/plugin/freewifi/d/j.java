package com.tencent.mm.plugin.freewifi.d;

import android.os.Build;
import com.tencent.mm.protocal.c.ahr;
import com.tencent.mm.protocal.c.ahs;
import com.tencent.mm.protocal.c.aht;
import com.tencent.mm.v.b.a;
import java.util.LinkedList;

public final class j extends c {
    protected final void apq() {
        a aVar = new a();
        aVar.czn = new ahr();
        aVar.czo = new ahs();
        aVar.uri = "/cgi-bin/mmo2o-bin/manufacturerapinfo";
        aVar.czm = 1707;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final int getType() {
        return 1707;
    }

    public j(LinkedList<aht> linkedList, int i) {
        apq();
        ahr com_tencent_mm_protocal_c_ahr = (ahr) this.cif.czk.czs;
        com_tencent_mm_protocal_c_ahr.mHo = Build.BRAND;
        com_tencent_mm_protocal_c_ahr.mHn = i;
        com_tencent_mm_protocal_c_ahr.mHm = linkedList;
    }

    public final ahs apD() {
        return (ahs) this.cif.czl.czs;
    }
}
