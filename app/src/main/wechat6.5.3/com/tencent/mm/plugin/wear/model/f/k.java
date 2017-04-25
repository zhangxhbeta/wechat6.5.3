package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.bia;
import java.io.IOException;

public final class k extends c {
    private int aJW;
    private String lcr;

    public k(int i, String str) {
        this.aJW = i;
        this.lcr = str;
    }

    protected final void send() {
        bia com_tencent_mm_protocal_c_bia = new bia();
        switch (this.aJW) {
            case 0:
                com_tencent_mm_protocal_c_bia.mVA = 0;
                break;
            case 6:
                com_tencent_mm_protocal_c_bia.mVA = 196610;
                break;
            case 7:
                com_tencent_mm_protocal_c_bia.mVA = 196615;
                break;
            case 8:
                com_tencent_mm_protocal_c_bia.mVA = 196614;
                break;
            case 9:
                com_tencent_mm_protocal_c_bia.mVA = 196613;
                break;
        }
        com_tencent_mm_protocal_c_bia.ncO = this.lcr;
        try {
            a.bhH();
            r.a(20016, com_tencent_mm_protocal_c_bia.toByteArray(), true);
        } catch (IOException e) {
        }
    }

    public final String getName() {
        return "WearPushPayResponseTask";
    }
}
