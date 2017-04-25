package com.tencent.mm.ae.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.ae.a.c.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class d implements f {
    public final String jj(String str) {
        if (be.kS(str)) {
            return null;
        }
        v.d("MicroMsg.imageloader.DefaultImageFileNameCreater", "[cpan] create image file name :%s", g.m(str.getBytes()));
        return g.m(str.getBytes());
    }
}
