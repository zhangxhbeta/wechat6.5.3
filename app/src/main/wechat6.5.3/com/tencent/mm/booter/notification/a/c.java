package com.tencent.mm.booter.notification.a;

import com.tencent.mm.ax.a;
import com.tencent.mm.h.i;

public final class c {
    public int bZP = -1;

    public final int n(String str, int i) {
        this.bZP = a.bmo();
        if (i.ec(i)) {
            if (i.dA(str)) {
                try {
                    this.bZP = 2130839468;
                } catch (Exception e) {
                }
            } else if (i.dB(str)) {
                try {
                    this.bZP = 2130839468;
                } catch (Exception e2) {
                }
            }
        }
        if (this.bZP < 0) {
            this.bZP = a.bmo();
        }
        return this.bZP;
    }
}
