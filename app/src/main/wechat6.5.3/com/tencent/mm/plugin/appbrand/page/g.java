package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.a;

public final class g {
    long dNW;
    public int dNX;
    long dNY;
    public long dNZ;
    long dOa;
    boolean dOb = false;
    String dzg;
    Context mContext;

    g(Context context, String str) {
        this.mContext = context;
        this.dzg = str;
    }

    public final void a(String str, long j, int i) {
        a.a(this.mContext, this.dzg, str, j, i, this.dOa);
        this.dNZ = 0;
        this.dOa = 0;
    }

    public final void Rp() {
        a.b(this.dzg, System.currentTimeMillis() - this.dNW, this.dNX);
        this.dOb = false;
        AppBrandStatObject ms = com.tencent.mm.plugin.appbrand.a.ms(this.dzg);
        if (ms != null) {
            ms.dPP = System.currentTimeMillis();
            ms.dPQ = 1;
        }
    }

    public final void od(String str) {
        this.dOb = true;
        this.dNW = System.currentTimeMillis();
        a(str, this.dNW, 2);
        AppBrandIDKeyBatchReport.a(1, this.dzg, str, 1, "", "");
    }
}
