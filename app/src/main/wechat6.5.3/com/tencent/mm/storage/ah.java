package com.tencent.mm.storage;

public final class ah {
    public String aZD;
    public String fkg;
    public int nvb;
    private boolean nvc;
    public int nvd;
    public int nve;
    public String nvf;

    public ah() {
        this.nvc = false;
        this.nvb = -1;
    }

    public ah(String str) {
        this.nvc = false;
        this.aZD = str;
        this.nvb = -1;
    }

    public final void ve(int i) {
        if (!(this.nvb == -1 || this.nvb == i || i != 7)) {
            this.nvc = true;
        }
        this.nvb = i;
    }
}
