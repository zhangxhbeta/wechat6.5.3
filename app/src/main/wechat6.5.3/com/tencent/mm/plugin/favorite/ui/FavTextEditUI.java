package com.tencent.mm.plugin.favorite.ui;

import android.os.Bundle;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.favorite.b.ad;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aix;
import com.tencent.mm.protocal.c.aja;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.MMTextInputUI;
import java.util.LinkedList;

public class FavTextEditUI extends MMTextInputUI {
    protected final int getLayoutId() {
        return 2130903595;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131232648);
    }

    protected final void s(CharSequence charSequence) {
        if (charSequence == null || be.kS(charSequence.toString())) {
            v.w("MicroMsg.FavTextEditUI", "text is null");
            return;
        }
        int intExtra = getIntent().getIntExtra("key_fav_item_id", -1);
        String charSequence2 = charSequence.toString();
        if (intExtra <= 0) {
            v.w("MicroMsg.ModFavItemLogic", "modEditText favid:%d", new Object[]{Integer.valueOf(intExtra)});
            return;
        }
        LinkedList linkedList = new LinkedList();
        aix com_tencent_mm_protocal_c_aix = new aix();
        com_tencent_mm_protocal_c_aix.mJs = 4;
        com_tencent_mm_protocal_c_aix.mJt = 0;
        linkedList.add(com_tencent_mm_protocal_c_aix);
        LinkedList linkedList2 = new LinkedList();
        aja com_tencent_mm_protocal_c_aja = new aja();
        com_tencent_mm_protocal_c_aja.gmM = "favitem.desc";
        com_tencent_mm_protocal_c_aja.itR = be.ah(charSequence2, "");
        linkedList2.add(com_tencent_mm_protocal_c_aja);
        com_tencent_mm_protocal_c_aja = new aja();
        com_tencent_mm_protocal_c_aja.gmM = "favitem.edittime";
        com_tencent_mm_protocal_c_aja.itR = String.valueOf(be.Nh());
        linkedList2.add(com_tencent_mm_protocal_c_aja);
        i bC = h.alu().bC((long) intExtra);
        if (bC != null) {
            bC.field_edittime = be.Nh();
            bC.field_favProto.dU(bC.field_edittime);
            bC.field_favProto.Jm(be.ah(charSequence2, ""));
            h.alu().a(bC, "localId");
        }
        ak.vy().a(new ad(intExtra, linkedList, linkedList2), 0);
        g.iuh.h(10874, new Object[]{Integer.valueOf(1)});
    }
}
