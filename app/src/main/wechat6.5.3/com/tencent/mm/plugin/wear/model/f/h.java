package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.model.l;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.bho;
import com.tencent.mm.protocal.c.bhp;
import java.util.List;

public final class h extends b {
    private long bao;
    private long bst;
    private String bsu;
    private List<String> bsv;

    public h(long j, long j2, String str, List<String> list) {
        this.bao = j;
        this.bst = j2;
        this.bsu = str;
        this.bsv = list;
    }

    protected final void send() {
        bho com_tencent_mm_protocal_c_bho = new bho();
        com_tencent_mm_protocal_c_bho.ncA = this.bst;
        com_tencent_mm_protocal_c_bho.ncz = this.bao;
        com_tencent_mm_protocal_c_bho.ncB = this.bsu;
        try {
            if (this.bsv != null) {
                for (String split : this.bsv) {
                    String[] split2 = split.split("=");
                    bhp com_tencent_mm_protocal_c_bhp = new bhp();
                    com_tencent_mm_protocal_c_bhp.ncy = split2[0];
                    com_tencent_mm_protocal_c_bhp.efy = split2[1];
                    if (com_tencent_mm_protocal_c_bhp.efy.startsWith("wxid")) {
                        com_tencent_mm_protocal_c_bhp.efy = l.er(com_tencent_mm_protocal_c_bhp.efy);
                    }
                    com_tencent_mm_protocal_c_bhp.ncA = Long.valueOf(split2[2]).longValue();
                    com_tencent_mm_protocal_c_bho.ncC.add(com_tencent_mm_protocal_c_bhp);
                }
            }
            a.bhH();
            r.a(20015, com_tencent_mm_protocal_c_bho.toByteArray(), true);
        } catch (Exception e) {
        }
        if (this.bst > 0) {
            com.tencent.mm.plugin.wear.model.c.a.ht(true);
        } else {
            com.tencent.mm.plugin.wear.model.c.a.ht(false);
        }
    }

    public final String getName() {
        return "WearLuckyReceiveTask";
    }
}
