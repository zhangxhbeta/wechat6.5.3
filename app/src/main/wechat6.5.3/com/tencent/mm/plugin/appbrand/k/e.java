package com.tencent.mm.plugin.appbrand.k;

public final class e implements g {
    final g dSN;
    int dSO = 0;
    int dSP = -1;
    int dSQ = -1;
    Object dSR = null;

    public e(g gVar) {
        this.dSN = gVar;
    }

    public final void So() {
        if (this.dSO != 0) {
            switch (this.dSO) {
                case 1:
                    this.dSN.be(this.dSP, this.dSQ);
                    break;
                case 2:
                    this.dSN.bf(this.dSP, this.dSQ);
                    break;
                case 3:
                    this.dSN.d(this.dSP, this.dSQ, this.dSR);
                    break;
            }
            this.dSR = null;
            this.dSO = 0;
        }
    }

    public final void be(int i, int i2) {
        if (this.dSO != 1 || i < this.dSP || i > this.dSP + this.dSQ) {
            So();
            this.dSP = i;
            this.dSQ = i2;
            this.dSO = 1;
            return;
        }
        this.dSQ += i2;
        this.dSP = Math.min(i, this.dSP);
    }

    public final void bf(int i, int i2) {
        if (this.dSO != 2 || this.dSP < i || this.dSP > i + i2) {
            So();
            this.dSP = i;
            this.dSQ = i2;
            this.dSO = 2;
            return;
        }
        this.dSQ += i2;
        this.dSP = i;
    }

    public final void bg(int i, int i2) {
        So();
        this.dSN.bg(i, i2);
    }

    public final void d(int i, int i2, Object obj) {
        if (this.dSO != 3 || i > this.dSP + this.dSQ || i + i2 < this.dSP || this.dSR != obj) {
            So();
            this.dSP = i;
            this.dSQ = i2;
            this.dSR = obj;
            this.dSO = 3;
            return;
        }
        int i3 = this.dSP + this.dSQ;
        this.dSP = Math.min(i, this.dSP);
        this.dSQ = Math.max(i3, i + i2) - this.dSP;
    }
}
