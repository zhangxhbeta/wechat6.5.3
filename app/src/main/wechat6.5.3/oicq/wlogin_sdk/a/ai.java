package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ai extends a {
    public int pOl;
    public int pOm;
    public int pOn;

    public ai() {
        this.pOl = 0;
        this.pOm = 0;
        this.pOn = 0;
        this.pMT = 326;
    }

    public final Boolean bQY() {
        if (this.pND < 12) {
            return Boolean.valueOf(false);
        }
        int K = util.K(this.pMN, this.pNC + 4);
        if (this.pND < K + 12) {
            return Boolean.valueOf(false);
        }
        this.pOl = K;
        K = util.K(this.pMN, (this.pNC + 6) + this.pOl);
        if (this.pND < (this.pOl + 12) + K) {
            return Boolean.valueOf(false);
        }
        this.pOm = K;
        K = util.K(this.pMN, ((this.pNC + 10) + this.pOl) + this.pOm);
        if (this.pND < ((this.pOl + 12) + this.pOm) + K) {
            return Boolean.valueOf(false);
        }
        this.pOn = K;
        return Boolean.valueOf(true);
    }
}
