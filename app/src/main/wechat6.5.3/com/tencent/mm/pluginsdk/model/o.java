package com.tencent.mm.pluginsdk.model;

public final class o {
    public String aZD;
    private int lzI;
    public String lzJ;
    public String lzK;
    public String lzL;
    public int lzM;

    o(int i, String str, String str2, String str3, String str4, int i2) {
        this.lzI = i;
        this.aZD = str;
        this.lzJ = str2;
        this.lzM = i2;
        this.lzK = str3;
        this.lzL = str4;
    }

    public final String toString() {
        return "id:" + this.lzI + ";productId:" + this.aZD + ";full:" + this.lzJ + ";productState:" + this.lzM + ";priceCurrencyCode:" + this.lzK + ";priceAmountMicros:" + this.lzL;
    }
}
