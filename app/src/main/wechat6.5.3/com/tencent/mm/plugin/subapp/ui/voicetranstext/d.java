package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.modelvoice.b;
import com.tencent.mm.modelvoice.h;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.protocal.c.bdx;

public final class d {
    public static bdx ag(int i, String str) {
        bdx com_tencent_mm_protocal_c_bdx = new bdx();
        switch (i) {
            case 0:
                com_tencent_mm_protocal_c_bdx.mdE = 8000;
                com_tencent_mm_protocal_c_bdx.mdF = 16;
                com_tencent_mm_protocal_c_bdx.mdC = 5;
                com_tencent_mm_protocal_c_bdx.mdD = 5;
                break;
            case 1:
                com_tencent_mm_protocal_c_bdx.mdE = 16000;
                com_tencent_mm_protocal_c_bdx.mdF = 16;
                com_tencent_mm_protocal_c_bdx.mdC = 4;
                com_tencent_mm_protocal_c_bdx.mdD = 4;
                break;
            case 4:
                com_tencent_mm_protocal_c_bdx.mdE = 16000;
                b lC = q.lC(str);
                if (lC != null) {
                    int SilkGetEncSampleRate = MediaRecorder.SilkGetEncSampleRate(((h) lC).aU(0, 1).buf);
                    if (SilkGetEncSampleRate >= 8000) {
                        com_tencent_mm_protocal_c_bdx.mdE = SilkGetEncSampleRate;
                    }
                }
                com_tencent_mm_protocal_c_bdx.mdF = 16;
                com_tencent_mm_protocal_c_bdx.mdC = 6;
                com_tencent_mm_protocal_c_bdx.mdD = 6;
                break;
            default:
                com_tencent_mm_protocal_c_bdx.mdE = 0;
                com_tencent_mm_protocal_c_bdx.mdF = 0;
                com_tencent_mm_protocal_c_bdx.mdC = 0;
                com_tencent_mm_protocal_c_bdx.mdD = 0;
                break;
        }
        return com_tencent_mm_protocal_c_bdx;
    }
}
