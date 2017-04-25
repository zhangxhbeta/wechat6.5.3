package com.tencent.mm.storage;

import android.util.SparseArray;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import java.util.List;

public final class g extends f<com.tencent.mm.e.b.f> {
    public static final String[] cic = new String[]{f.a(com.tencent.mm.e.b.f.pz(), "AddContactAntispamTicket")};
    private com.tencent.mm.bg.g cuX;
    SparseArray<String> nnT = new SparseArray();

    public static class a extends com.tencent.mm.e.b.f {
        protected final com.tencent.mm.sdk.h.c.a tl() {
            return com.tencent.mm.e.b.f.pz();
        }
    }

    public g(d dVar) {
        super(dVar, com.tencent.mm.e.b.f.pz(), "AddContactAntispamTicket", null);
        this.cuX = (com.tencent.mm.bg.g) dVar;
    }

    public final void bR(List<com.tencent.mm.e.b.f> list) {
        if (list.size() != 0) {
            long er = this.cuX.er(Thread.currentThread().getId());
            for (com.tencent.mm.e.b.f a : list) {
                a((c) a);
            }
            this.cuX.es(er);
        }
    }

    public final void dJ(String str, String str2) {
        if (!be.kS(str)) {
            this.nnT.put(str.hashCode(), str2);
        }
    }

    public final String Lw(String str) {
        if (be.kS(str)) {
            return null;
        }
        String str2 = (String) this.nnT.get(str.hashCode());
        if (!be.kS(str2)) {
            return str2;
        }
        c aVar = new a();
        aVar.field_userName = str;
        if (!b(aVar, "userName")) {
            return null;
        }
        String str3 = aVar.field_userName;
        int i = aVar.field_scene;
        dJ(str3, aVar.field_ticket);
        return aVar.field_ticket;
    }
}
