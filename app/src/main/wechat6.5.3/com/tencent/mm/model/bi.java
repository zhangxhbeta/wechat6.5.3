package com.tencent.mm.model;

import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.d;
import com.tencent.mm.v.d.a;
import com.tencent.mm.v.d.b;
import junit.framework.Assert;

public final class bi implements d {
    public final b b(a aVar) {
        boolean z = true;
        bm bmVar = aVar.czu;
        Assert.assertTrue(bmVar != null);
        if (bmVar.mbW == null) {
            z = false;
        }
        Assert.assertTrue(z);
        String str = (String) bf.q(m.a(bmVar.mbW), "tips").get(".tips.tip.url");
        v.v("MicroMsg.SoftwareMsgExtension", "url:" + str);
        ak.yW();
        c.vf().set(12308, str);
        return null;
    }

    public final void d(at atVar) {
    }
}
