package com.tencent.mm.booter;

public abstract class r {
    public c mDebugger;

    public r(c cVar) {
        this.mDebugger = cVar;
    }

    public final String getString(String str) {
        return this.mDebugger.getString(str);
    }

    public final Integer getInteger(String str) {
        return this.mDebugger.getInteger(str);
    }

    public final Boolean cS(String str) {
        return this.mDebugger.cS(str);
    }

    public final void cR(String str) {
        this.mDebugger.cR(str);
    }
}
