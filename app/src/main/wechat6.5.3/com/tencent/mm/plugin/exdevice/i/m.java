package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.l;
import com.tencent.mm.plugin.exdevice.service.o;
import com.tencent.mm.plugin.exdevice.service.p.a;
import junit.framework.Assert;

public final class m extends a {
    l fyA = null;
    private n fyz = null;

    public m(c cVar, c cVar2) {
        Assert.assertNotNull(cVar);
        Assert.assertNotNull(cVar2);
        this.fyz = new n(cVar);
        this.fyA = new l(cVar2);
    }

    public final o ajS() {
        Assert.assertNotNull(this.fyz);
        return this.fyz;
    }

    public final l ajT() {
        Assert.assertNotNull(this.fyA);
        return this.fyA;
    }
}
