package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class t extends a {
    public int pNZ;

    public t() {
        this.pNZ = 0;
        this.pMT = 282;
    }

    public final Boolean bQY() {
        if (this.pND < 5) {
            return Boolean.valueOf(false);
        }
        int J = util.J(this.pMN, ((this.pNC + 2) + 1) + 1);
        if (this.pND < J + 5) {
            return Boolean.valueOf(false);
        }
        this.pNZ = J;
        return Boolean.valueOf(true);
    }
}
