package com.tencent.mm.plugin.wallet_core.c;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.v;

public final class h extends f<x> {
    public static final String[] cic = new String[]{f.a(x.chq, "WalletRegionGreyAreaList")};
    private d cie;

    public h(d dVar) {
        super(dVar, x.chq, "WalletRegionGreyAreaList", null);
        this.cie = dVar;
    }

    public final void a(int i, alx com_tencent_mm_protocal_c_alx) {
        x xVar = new x();
        xVar.field_wallet_region = i;
        try {
            xVar.field_wallet_grey_item_buf = com_tencent_mm_protocal_c_alx.toByteArray();
        } catch (Exception e) {
            v.e("MicroMsg.WalletRegionGreyItemStg", "setWalletRegionGreyItem error " + e.getMessage());
        }
        super.a(xVar);
    }

    public final x sp(int i) {
        String str = "select * from WalletRegionGreyAreaList where wallet_region = " + i;
        Cursor rawQuery = this.cie.rawQuery(str, null);
        v.i("MicroMsg.WalletRegionGreyItemStg", "getWalletRegionGreyItem " + str);
        if (rawQuery == null) {
            return new x();
        }
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            return new x();
        }
        x xVar = new x();
        if (rawQuery.moveToNext()) {
            xVar = new x();
            xVar.b(rawQuery);
        }
        v.i("MicroMsg.WalletRegionGreyItemStg", "get grey item ");
        rawQuery.close();
        return xVar;
    }
}
