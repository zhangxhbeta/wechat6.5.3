package com.tencent.mm.model;

import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.r;
import com.tencent.mm.v.d;
import com.tencent.mm.v.d.a;
import com.tencent.mm.v.d.b;
import java.util.Map;

public final class bp implements d {
    public final b b(a aVar) {
        bm bmVar = aVar.czu;
        if (bmVar == null) {
            v.e("MicroMsg.SysNoticeMsgExtension", "onPreAddMessage cmdAM is null");
        } else {
            try {
                Map q = bf.q("<root>" + bmVar.mbW + "</root>", "root");
                int intValue = Integer.valueOf((String) q.get(".root.newcount")).intValue();
                int intValue2 = Integer.valueOf((String) q.get(".root.version")).intValue();
                ak.yW();
                r vf = c.vf();
                if (intValue2 == be.f((Integer) vf.get(12305, null))) {
                    v.i("MicroMsg.SysNoticeMsgExtension", "ignore new sys notice count, same version");
                } else {
                    vf.set(12304, Integer.valueOf(intValue));
                    vf.set(12305, Integer.valueOf(intValue2));
                }
            } catch (Throwable e) {
                v.e("MicroMsg.SysNoticeMsgExtension", "exception:%s", be.e(e));
            }
        }
        return null;
    }

    public final void d(at atVar) {
    }
}
