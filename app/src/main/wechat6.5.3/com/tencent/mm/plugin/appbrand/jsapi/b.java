package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import junit.framework.Assert;

public abstract class b {
    private String dEK;
    private Integer dEL;

    public b() {
        Assert.assertTrue("Must declare NAME and CTRL_INDEX in subclasses", true);
    }

    public final String getName() {
        if (be.kS(this.dEK)) {
            try {
                this.dEK = (String) new c(this, "NAME", null).get();
            } catch (Throwable e) {
                v.e("MicroMsg.AppBrand.BaseJsApi", "getName exp = %s", new Object[]{be.e(e)});
            }
        }
        return this.dEK;
    }

    public final int PS() {
        return be.a(PT(), -1);
    }

    private Integer PT() {
        if (this.dEL == null) {
            try {
                this.dEL = (Integer) new c(this, "CTRL_INDEX", null).get();
            } catch (Throwable e) {
                v.e("MicroMsg.AppBrand.BaseJsApi", "getCtrlIndex exp = %s", new Object[]{be.e(e)});
            }
        }
        return this.dEL;
    }
}
