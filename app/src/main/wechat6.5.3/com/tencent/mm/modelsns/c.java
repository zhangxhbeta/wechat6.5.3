package com.tencent.mm.modelsns;

public final class c {
    StringBuffer cZQ = new StringBuffer();
    StringBuffer cZR = new StringBuffer();
    private int index = 0;

    public final void m(String str, Object obj) {
        this.cZQ.append(this.index + " " + str + "->" + obj + "\n");
        this.cZR.append(obj);
        this.index++;
    }

    public final void n(String str, Object obj) {
        this.cZQ.append(str + "->" + obj + "\n");
        this.cZR.append(obj);
    }

    public final String toString() {
        return this.cZR.toString();
    }

    public final String JH() {
        this.index = 0;
        this.cZQ.append("--end--\n\n");
        return this.cZQ.toString();
    }
}
