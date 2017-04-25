package com.tencent.mm.modelstat;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class g {
    long beginTime;
    boolean cFQ;
    long dcv;
    long dcw;
    long dcx;
    long endTime;
    int rtType;

    public g(int i, boolean z, long j) {
        this.rtType = i;
        this.cFQ = z;
        this.dcv = j;
        this.dcw = 0;
    }

    public final void Kc() {
        if (this.dcw == 0) {
            this.beginTime = be.Ni();
            this.dcx = be.Nj();
        }
        this.dcw++;
    }

    public final void aq(long j) {
        if (this.dcv == 0) {
            this.dcv = j;
        }
        this.dcx = be.Nj() - this.dcx;
        this.endTime = be.Ni();
        v.d("MicroMsg.MultiSceneStat", "FIN: TIME:" + (this.endTime - this.beginTime) + " datalen:" + this.dcv + " Count:" + this.dcw + " type:" + this.rtType);
        WatchDogPushReceiver.a(this);
    }
}
