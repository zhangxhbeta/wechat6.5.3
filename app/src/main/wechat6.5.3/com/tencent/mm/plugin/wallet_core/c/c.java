package com.tencent.mm.plugin.wallet_core.c;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c extends f<Bankcard> {
    public static final String[] cic = new String[]{f.a(Bankcard.chq, "WalletBankcard")};
    private List<Object> cJC = new LinkedList();
    public d cie;

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.h.c cVar, String[] strArr) {
        if (!super.a((Bankcard) cVar, strArr)) {
            return false;
        }
        Iterator it = this.cJC.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public final /* synthetic */ boolean b(com.tencent.mm.sdk.h.c cVar) {
        return d((Bankcard) cVar);
    }

    public final /* synthetic */ boolean c(com.tencent.mm.sdk.h.c cVar, String[] strArr) {
        if (!super.c((Bankcard) cVar, strArr)) {
            return false;
        }
        Iterator it = this.cJC.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public c(d dVar) {
        super(dVar, Bankcard.chq, "WalletBankcard", null);
        this.cie = dVar;
    }

    public final ArrayList<Bankcard> bgG() {
        ArrayList<Bankcard> arrayList = null;
        Cursor rawQuery = this.cie.rawQuery("select * from WalletBankcard where cardType <= 7", null);
        if (rawQuery != null) {
            if (rawQuery.getCount() == 0) {
                rawQuery.close();
            } else {
                arrayList = new ArrayList();
                if (rawQuery.moveToFirst()) {
                    while (!rawQuery.isAfterLast()) {
                        Bankcard bankcard = new Bankcard();
                        bankcard.b(rawQuery);
                        rawQuery.moveToNext();
                        arrayList.add(bankcard);
                    }
                }
                rawQuery.close();
            }
        }
        return arrayList;
    }

    public final ArrayList<Bankcard> bgR() {
        ArrayList<Bankcard> arrayList = null;
        Cursor rawQuery = this.cie.rawQuery("select * from WalletBankcard where cardType & " + Bankcard.kNn + " != 0 ", null);
        if (rawQuery != null) {
            if (rawQuery.getCount() == 0) {
                rawQuery.close();
            } else {
                arrayList = new ArrayList();
                if (rawQuery.moveToFirst()) {
                    while (!rawQuery.isAfterLast()) {
                        Bankcard bankcard = new Bankcard();
                        bankcard.b(rawQuery);
                        rawQuery.moveToNext();
                        arrayList.add(bankcard);
                    }
                }
                rawQuery.close();
            }
        }
        return arrayList;
    }

    public final boolean bC(List<Bankcard> list) {
        for (Bankcard b : list) {
            super.b(b);
        }
        Iterator it = this.cJC.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public final boolean d(Bankcard bankcard) {
        if (!super.b(bankcard)) {
            return false;
        }
        Iterator it = this.cJC.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }
}
