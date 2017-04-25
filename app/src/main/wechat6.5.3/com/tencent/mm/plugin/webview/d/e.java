package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.protocal.c.ade;
import com.tencent.mm.protocal.c.afi;
import com.tencent.mm.sdk.platformtools.be;
import java.util.LinkedList;
import java.util.List;

public final class e {
    public int ldN;
    public int ldO;
    public int ldP;
    public final List<afi> ldQ;
    public int ldR;
    public long ldS;

    private static final class a {
        private static final e ldT = new e();
    }

    private e() {
        this.ldN = 20480;
        this.ldO = 30720;
        this.ldP = 51200;
        this.ldQ = new LinkedList();
        this.ldR = 0;
        this.ldS = 0;
    }

    public static void bE(List<ade> list) {
        if (!be.bP(list)) {
            for (ade com_tencent_mm_protocal_c_ade : list) {
                com.tencent.mm.plugin.webview.e.e.bjf().ldL.q(Integer.valueOf(com_tencent_mm_protocal_c_ade.mEf), Long.valueOf(be.Nh() + ((long) com_tencent_mm_protocal_c_ade.mEg)));
            }
            com.tencent.mm.plugin.webview.e.e.bjf().bia();
        }
    }
}
