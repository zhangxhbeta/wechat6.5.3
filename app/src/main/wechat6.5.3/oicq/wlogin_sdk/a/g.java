package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class g extends a {
    public int pNN;
    public int pNO;
    public int pNP;
    public int pNQ;

    public g() {
        this.pNN = 0;
        this.pNO = 0;
        this.pNP = 0;
        this.pNQ = 0;
        this.pMT = 261;
    }

    public final Boolean bQY() {
        if (this.pND < 2) {
            return Boolean.valueOf(false);
        }
        this.pNO = util.K(this.pMN, this.pNC);
        if (this.pND < (this.pNO + 2) + 2) {
            return Boolean.valueOf(false);
        }
        this.pNN = util.K(this.pMN, (this.pNC + 2) + this.pNO);
        if (this.pND < ((this.pNO + 2) + 2) + this.pNN) {
            return Boolean.valueOf(false);
        }
        this.pNQ = this.pNC + 2;
        this.pNP = ((this.pNO + 2) + 2) + this.pNC;
        return Boolean.valueOf(true);
    }
}
