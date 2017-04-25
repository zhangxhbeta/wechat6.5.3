package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import java.util.ArrayList;

public final class bc {
    private boolean dOt = false;
    private String nlw;
    ArrayList<Long> nlx;
    ArrayList<String> nly;
    private String oZ;

    public bc(String str, String str2) {
        this.oZ = str;
        this.nlw = str2;
        if (!this.dOt) {
            if (this.nlx == null) {
                this.nlx = new ArrayList();
                this.nly = new ArrayList();
            } else {
                this.nlx.clear();
                this.nly.clear();
            }
            addSplit(null);
        }
    }

    public final void addSplit(String str) {
        if (!this.dOt) {
            this.nlx.add(Long.valueOf(SystemClock.elapsedRealtime()));
            this.nly.add(str);
        }
    }

    public final void dumpToLog() {
        if (!this.dOt) {
            v.d(this.oZ, this.nlw + ": begin");
            long longValue = ((Long) this.nlx.get(0)).longValue();
            int i = 1;
            long j = longValue;
            while (i < this.nlx.size()) {
                long longValue2 = ((Long) this.nlx.get(i)).longValue();
                v.d(this.oZ, this.nlw + ":      " + (longValue2 - ((Long) this.nlx.get(i - 1)).longValue()) + " ms, " + ((String) this.nly.get(i)));
                i++;
                j = longValue2;
            }
            v.d(this.oZ, this.nlw + ": end, " + (j - longValue) + " ms");
        }
    }
}
