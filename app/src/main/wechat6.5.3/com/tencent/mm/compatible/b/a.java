package com.tencent.mm.compatible.b;

import java.util.concurrent.locks.Lock;

public final class a {
    public int caM = 0;
    public int caN = 0;
    public byte[] caO = null;
    public int caP = 0;
    public int caQ = 0;
    public boolean caR = false;
    public Lock caS = null;

    public final int qO() {
        if (this.caR) {
            this.caS.lock();
        }
        if (this.caP == this.caQ) {
            return 0;
        }
        if (this.caP < this.caQ) {
            this.caN = this.caQ - this.caP;
        } else if (this.caP > this.caQ) {
            this.caN = (this.caQ + this.caM) - this.caP;
        }
        if (this.caR) {
            this.caS.unlock();
        }
        return this.caN;
    }
}
