package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.pluginsdk.j.ah.a;
import com.tencent.mm.protocal.c.bhl;
import com.tencent.mm.sdk.platformtools.be;

public final class c implements a {
    public final String bhJ() {
        bhl com_tencent_mm_protocal_c_bhl = a.bhH().laR.lbj.lcb;
        if (com_tencent_mm_protocal_c_bhl != null) {
            return com_tencent_mm_protocal_c_bhl.ncu + "\n" + com_tencent_mm_protocal_c_bhl.ncv + "\n" + com_tencent_mm_protocal_c_bhl.ncw;
        }
        return "Not Connect";
    }

    public final void bhK() {
        a.bhH().laX.a(new com.tencent.mm.plugin.wear.model.f.a());
    }

    public final boolean bhL() {
        String str = null;
        bhl com_tencent_mm_protocal_c_bhl = a.bhH().laR.lbj.lcb;
        return (be.kS(str) && be.kS(str)) ? com_tencent_mm_protocal_c_bhl != null : be.kS(str) ? com_tencent_mm_protocal_c_bhl != null && str.equals("gh_43f2581f6fd6") : be.kS(str) ? com_tencent_mm_protocal_c_bhl != null && str.equals(com_tencent_mm_protocal_c_bhl.ncr) : com_tencent_mm_protocal_c_bhl != null && str.equals("gh_43f2581f6fd6") && str.equals(com_tencent_mm_protocal_c_bhl.ncr);
    }
}
