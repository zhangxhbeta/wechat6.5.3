package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.bhi;
import com.tencent.mm.protocal.c.bhj;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.u.b;
import java.io.IOException;

public final class f extends c {
    private String cID;
    private int type;
    private String username;

    public f(String str, String str2, int i) {
        this.username = str;
        this.cID = str2;
        this.type = i;
    }

    protected final void send() {
        com.tencent.mm.plugin.wear.model.f DH = a.bhH().laT.DH(this.username);
        bhj com_tencent_mm_protocal_c_bhj = new bhj();
        if (this.type == 1) {
            bhi com_tencent_mm_protocal_c_bhi = new bhi();
            com_tencent_mm_protocal_c_bhi.gof = DH.id;
            com_tencent_mm_protocal_c_bhi.gln = this.username;
            com_tencent_mm_protocal_c_bhi.efy = this.cID;
            com_tencent_mm_protocal_c_bhi.hQP = aa.getContext().getString(2131234095);
            Bitmap a = b.a(this.username, false, -1);
            if (a != null) {
                com_tencent_mm_protocal_c_bhi.ncq = new com.tencent.mm.ba.b(h.A(a));
            }
            com_tencent_mm_protocal_c_bhj.eeu.add(com_tencent_mm_protocal_c_bhi);
        }
        try {
            a.bhH();
            r.a(20006, com_tencent_mm_protocal_c_bhj.toByteArray(), true);
        } catch (IOException e) {
        }
    }

    public final String getName() {
        return "WearFriendCreateTask";
    }
}
