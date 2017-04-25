package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.protocal.c.qw;
import com.tencent.mm.protocal.c.qx;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import java.util.LinkedList;

public final class e extends c {
    protected final void apq() {
        a aVar = new a();
        aVar.czn = new qw();
        aVar.czo = new qx();
        aVar.uri = "/cgi-bin/mmo2o-bin/freewifireport";
        aVar.czm = 1781;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
    }

    public final int getType() {
        return 1781;
    }

    public e(LinkedList<qv> linkedList) {
        apq();
        if (linkedList != null && linkedList.size() > 0) {
            ((qw) this.cif.czk.czs).muI = linkedList;
        }
    }

    protected final void a(int i, int i2, int i3, String str) {
        v.i("MicroMsg.FreeWifi.NetSceneFreeWifiReport", "doBeforeCallback. netId=%d, errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (m.bF(i2, i3)) {
            j.apn().aoU().post(new Runnable(this) {
                final /* synthetic */ e fZv;

                {
                    this.fZv = r1;
                }

                public final void run() {
                    qx qxVar = (qx) this.fZv.cif.czl.czs;
                    if (qxVar != null) {
                        LinkedList linkedList = qxVar.muI;
                    }
                }
            });
        }
    }

    public final LinkedList<qv> apz() {
        qx qxVar = (qx) this.cif.czl.czs;
        if (qxVar == null) {
            return null;
        }
        return qxVar.muI;
    }
}
