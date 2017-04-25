package com.tencent.mm.plugin.sns.data;

import com.tencent.mm.protocal.c.avr;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    public ConcurrentHashMap<String, CharSequence> jdM = new ConcurrentHashMap();

    public final void a(avr com_tencent_mm_protocal_c_avr, CharSequence charSequence) {
        this.jdM.put(com_tencent_mm_protocal_c_avr.mSN + "-" + com_tencent_mm_protocal_c_avr.mSQ + "-" + com_tencent_mm_protocal_c_avr.hQP, charSequence);
    }
}
