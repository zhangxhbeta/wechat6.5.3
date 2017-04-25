package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.exdevice.e.e;

public abstract class c {
    public long esP = -1;
    public short frc = (short) -1;
    public e frd = null;
    protected a fre = null;

    public abstract short air();

    public abstract short ais();

    public abstract byte[] ait();

    protected final e F(int i, String str) {
        this.frd = new e();
        this.frd.fvC = i;
        this.frd.fvD = str;
        return this.frd;
    }
}
