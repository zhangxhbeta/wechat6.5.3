package com.tencent.mm.plugin.radar.ui;

import com.tencent.mm.protocal.c.apa;

public final class c {
    public static String b(apa com_tencent_mm_protocal_c_apa) {
        if (com_tencent_mm_protocal_c_apa.gln != null) {
            return com_tencent_mm_protocal_c_apa.gln;
        }
        return com_tencent_mm_protocal_c_apa.mrE;
    }

    public static String c(apa com_tencent_mm_protocal_c_apa) {
        if (com_tencent_mm_protocal_c_apa == null) {
            return "";
        }
        if (com_tencent_mm_protocal_c_apa.mrE != null) {
            return com_tencent_mm_protocal_c_apa.mrE;
        }
        return com_tencent_mm_protocal_c_apa.gln;
    }
}
