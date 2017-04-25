package com.tencent.mm.ui.bindqq;

import com.tencent.mm.e.a.ie;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;

public final class a extends c<ie> implements com.tencent.mm.ui.bindqq.b.a {
    private ie ogG;

    public a() {
        this.nhz = ie.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ie ieVar = (ie) bVar;
        if (ieVar instanceof ie) {
            this.ogG = ieVar;
            new b(this.ogG.bih.bij, this).bDs();
        }
        return false;
    }

    public final boolean q(int i, int i2, String str) {
        if (this.ogG == null) {
            return false;
        }
        if (this.ogG.bih.bik == null) {
            this.ogG = null;
            return false;
        } else if (i == 0 && i2 == 0) {
            this.ogG.bii.aYN = true;
            this.ogG.bih.bik.run();
            this.ogG = null;
            return true;
        } else {
            this.ogG.bii.aYN = false;
            this.ogG.bih.bik.run();
            this.ogG = null;
            return false;
        }
    }

    public final void bDr() {
        if (this.ogG != null && this.ogG.bih.bik != null) {
            this.ogG.bii.aYN = false;
            this.ogG.bih.bik.run();
            this.ogG = null;
        }
    }
}
