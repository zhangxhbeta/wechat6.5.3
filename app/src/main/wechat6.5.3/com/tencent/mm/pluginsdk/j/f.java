package com.tencent.mm.pluginsdk.j;

import com.tencent.mm.sdk.platformtools.be;

public final class f {
    long dnm = 0;
    long lCF = be.Nj();
    long lCG = be.Nj();
    private String tag = "default";
    long value = 0;

    public f(String str) {
        this.tag = str;
    }

    public final void dO(long j) {
        if (this.dnm == 0) {
            this.lCF = be.Nj();
        }
        this.value += j;
        this.dnm++;
        this.lCG = be.Nj();
    }

    public final String getValue() {
        String str = "";
        if (this.dnm == 0) {
            return "";
        }
        double d = ((double) (this.lCG - this.lCF)) / 1000.0d;
        if (d == 0.0d) {
            d = 1.0d;
        }
        return String.format("CounterUtil %s tag %s count %s passed %.3f perValue %.3f/count counttime %.3f/s valuetime %.3f/s st:%s ed:%s diff%s", new Object[]{str, this.tag, Long.valueOf(this.dnm), Double.valueOf(d), Double.valueOf((((double) this.value) * 1.0d) / ((double) this.dnm)), Double.valueOf((((double) this.dnm) * 1.0d) / d), Double.valueOf((1.0d * ((double) this.value)) / d), Long.valueOf(this.lCF), Long.valueOf(this.lCG), Long.valueOf(this.lCG - this.lCF)});
    }

    public final String bnP() {
        if (this.dnm == 0) {
            return "";
        }
        double d = ((double) (this.lCG - this.lCF)) / 1000.0d;
        if (d == 0.0d) {
            d = 1.0d;
        }
        return ((1.0d * ((double) this.dnm)) / d);
    }

    public final void reset() {
        this.value = 0;
        this.dnm = 0;
    }
}
