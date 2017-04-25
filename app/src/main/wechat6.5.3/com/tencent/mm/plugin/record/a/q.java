package com.tencent.mm.plugin.record.a;

import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.kw;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class q extends c<kw> {
    public q() {
        this.nhz = kw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        kw kwVar = (kw) bVar;
        v.i("MicroMsg.RecordOperationListener", "on record operation listener, %d", new Object[]{Integer.valueOf(kwVar.bmf.type)});
        switch (kwVar.bmf.type) {
            case 0:
                kwVar.bmg.bmp = m.yy(kwVar.bmf.bmh);
                break;
            case 1:
                v.i("MicroMsg.RecordOperationListener", "get record paths, msg id %d", new Object[]{Long.valueOf(kwVar.bmf.bao)});
                kwVar.bmg.bmr = m.d(kwVar.bmf.bdE, kwVar.bmf.bao);
                kwVar.bmg.bmq = m.c(kwVar.bmf.bdE, kwVar.bmf.bao);
                kwVar.bmg.bms = m.e(kwVar.bmf.bdE, kwVar.bmf.bao);
                kwVar.bmg.bdZ = m.f(kwVar.bmf.bdE, kwVar.bmf.bao);
                break;
            case 2:
                v.i("MicroMsg.RecordOperationListener", "send record msg, to %s, thumbPath %s, thumbId %s", new Object[]{kwVar.bmf.toUser, kwVar.bmf.bdZ, Integer.valueOf(kwVar.bmf.bmj)});
                m.a(kwVar.bmf.toUser, kwVar.bmf.bmi, kwVar.bmf.title, kwVar.bmf.desc, kwVar.bmf.bdZ, kwVar.bmf.bmj, kwVar.bmf.bmn);
                break;
            case 3:
                v.i("MicroMsg.RecordOperationListener", "clear resouces, msg id %d", new Object[]{Long.valueOf(kwVar.bmf.bao)});
                m.cu(kwVar.bmf.bao);
                break;
            case 4:
                v.i("MicroMsg.RecordOperationListener", "forward record msg, to %s, msg id %d", new Object[]{kwVar.bmf.toUser, Long.valueOf(kwVar.bmf.bmk.field_msgId)});
                m.a(kwVar.bmf.toUser, kwVar.bmf.bdV, kwVar.bmf.bmk);
                break;
            case 5:
                v.i("MicroMsg.RecordOperationListener", "summerrecord forward multi record msg, to %s", new Object[]{kwVar.bmf.toUser});
                m.a(kwVar.bmf.context, kwVar.bmf.toUser, kwVar.bmf.bmm, kwVar.bmf.bml, kwVar.bmf.blL, kwVar.bmf.bmo);
                break;
            case 6:
                bp bpVar = new bp();
                e.a(kwVar.bmf.context, bpVar, kwVar.bmf.bmm, kwVar.bmf.bml, true);
                d a = m.a(kwVar.bmf.context, bpVar, kwVar.bmf.bmm);
                kwVar.bmg.blL = bpVar;
                kwVar.bmg.bmo = a;
                break;
            case 8:
                m.a(kwVar.bmf.bdE, kwVar.bmf.bao, true);
                break;
        }
        return false;
    }
}
