package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.bip;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class l extends c {
    private String bdo;
    private int lbx;

    public l(int i, String str) {
        this.lbx = i;
        this.bdo = str;
    }

    public final String getName() {
        return "WearVoipControllerTask";
    }

    protected final void send() {
        switch (this.lbx) {
            case 20010:
                bip com_tencent_mm_protocal_c_bip = new bip();
                com_tencent_mm_protocal_c_bip.ncy = this.bdo;
                com_tencent_mm_protocal_c_bip.efy = h.DM(this.bdo);
                try {
                    a.bhH();
                    r.a(this.lbx, com_tencent_mm_protocal_c_bip.toByteArray(), false);
                    return;
                } catch (IOException e) {
                    return;
                }
            case 20011:
            case 20012:
                try {
                    a.bhH();
                    r.a(this.lbx, this.bdo.getBytes("utf8"), false);
                    return;
                } catch (UnsupportedEncodingException e2) {
                    return;
                }
            default:
                return;
        }
    }
}
