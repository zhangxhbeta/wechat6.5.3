package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ad extends a {
    public int pOf;

    public ad() {
        this.pOf = 0;
        this.pMT = 312;
    }

    public final Boolean bQY() {
        if (this.pND < 4) {
            return Boolean.valueOf(false);
        }
        this.pOf = util.L(this.pMN, this.pNC);
        if (this.pND < (this.pOf * 10) + 4) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }

    public final int bQZ() {
        for (int i = 0; i < this.pOf; i++) {
            if (util.K(this.pMN, (this.pNC + 4) + (i * 10)) == 266) {
                return util.L(this.pMN, ((i * 10) + (this.pNC + 4)) + 2);
            }
        }
        return 0;
    }
}
