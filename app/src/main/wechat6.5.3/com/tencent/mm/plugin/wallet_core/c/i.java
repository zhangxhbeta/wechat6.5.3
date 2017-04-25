package com.tencent.mm.plugin.wallet_core.c;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i extends f<aa> {
    public static final String[] cic = new String[]{f.a(aa.chq, "WalletUserInfo")};
    private List<Object> cJC = new LinkedList();
    public d cie;

    public final /* synthetic */ boolean a(c cVar, String[] strArr) {
        if (!super.a((aa) cVar, strArr)) {
            return false;
        }
        Iterator it = this.cJC.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a((aa) cVar);
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        if (!super.c((aa) cVar, strArr)) {
            return false;
        }
        Iterator it = this.cJC.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public i(d dVar) {
        super(dVar, aa.chq, "WalletUserInfo", null);
        this.cie = dVar;
    }

    public final aa bgT() {
        aa aaVar = null;
        Cursor rawQuery = this.cie.rawQuery("select * from WalletUserInfo", null);
        aa aaVar2 = new aa();
        aaVar2.field_is_reg = -1;
        if (rawQuery == null) {
            return aaVar2;
        }
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            return aaVar2;
        }
        if (rawQuery.moveToNext()) {
            aaVar = new aa();
            aaVar.b(rawQuery);
        }
        rawQuery.close();
        return aaVar;
    }

    public final boolean a(aa aaVar) {
        if (!super.b(aaVar)) {
            return false;
        }
        Iterator it = this.cJC.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }
}
