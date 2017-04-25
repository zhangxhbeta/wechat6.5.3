package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class z extends a {
    public int pOb;
    public int pOc;

    public z() {
        this.pOb = 0;
        this.pOc = 0;
        this.pMT = 293;
    }

    public final Boolean bQY() {
        if (this.pND < 2) {
            return Boolean.valueOf(false);
        }
        this.pOb = util.K(this.pMN, this.pNC);
        if (this.pND < (this.pOb + 2) + 2) {
            return Boolean.valueOf(false);
        }
        this.pOc = util.K(this.pMN, (this.pNC + 2) + this.pOb);
        return Boolean.valueOf(true);
    }
}
