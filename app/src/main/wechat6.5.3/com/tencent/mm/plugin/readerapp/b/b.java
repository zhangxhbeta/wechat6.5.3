package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.e.a.bp;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.sdk.platformtools.v;

public final class b {
    public static boolean a(bp bpVar, bc bcVar, int i) {
        if (bpVar == null || bcVar == null) {
            v.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or readerAppInfo is null");
            if (bpVar != null) {
                bpVar.aZd.aZk = 2131232653;
            }
            return false;
        }
        String o;
        qf qfVar = new qf();
        qg qgVar = new qg();
        pw pwVar = new pw();
        qgVar.Jn("newsapp");
        qgVar.Jo(k.xF());
        qgVar.Jo(k.xF());
        qgVar.uN(1);
        qgVar.dV(bcVar.cuP);
        qgVar.Jr(bcVar.cuU);
        qgVar.Ju(bcVar.getUrl());
        qgVar.Jv("newsapp");
        pwVar.IO(String.valueOf(bcVar.cuU));
        if (i == 0) {
            o = r.o(bcVar.zK(), bcVar.type, "@T");
        } else {
            o = r.o(bcVar.zK(), bcVar.type, "@S");
        }
        if (FileOp.aR(o)) {
            pwVar.IL(o);
        } else {
            pwVar.ip(true);
            pwVar.IF(bcVar.zK());
            qp qpVar = new qp();
            qpVar.JD(bcVar.zK());
            qfVar.b(qpVar);
        }
        pwVar.uG(5);
        pwVar.Iw(bcVar.getTitle());
        pwVar.Ix(bcVar.zL());
        pwVar.io(true);
        qfVar.a(qgVar);
        qfVar.mtR.add(pwVar);
        bpVar.aZd.desc = bcVar.getTitle();
        bpVar.aZd.aZf = qfVar;
        bpVar.aZd.type = 5;
        return true;
    }
}
