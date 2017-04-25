package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ab extends a {
    public int pOe;

    public ab() {
        this.pOe = 0;
        this.pMT = 306;
    }

    public final Boolean bQY() {
        if (this.pND < 2) {
            return Boolean.valueOf(false);
        }
        this.pOe = util.K(this.pMN, this.pNC);
        if (this.pOe + 2 > this.pND) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }
}
