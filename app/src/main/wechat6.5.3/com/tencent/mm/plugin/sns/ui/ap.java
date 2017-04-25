package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.e.am;
import com.tencent.mm.plugin.sns.e.am.b;

public final class ap {
    public String bde;
    public String boC;
    public boolean jRD = false;
    public boolean jRE = false;
    public int scene;

    public ap(String str, String str2, boolean z, boolean z2, int i) {
        this.boC = str;
        this.jRD = z;
        this.jRE = z2;
        this.scene = i;
        this.bde = str2;
    }

    public final boolean aXl() {
        int i = 2;
        if (this.scene != 1) {
            if (this.scene == 2) {
                i = 4;
            } else {
                i = -1;
            }
        }
        b AA = am.AA(this.boC);
        if (AA == null || !AA.cvW || AA.cyo || (r0 & AA.bCd) == 0) {
            return false;
        }
        return true;
    }
}
