package com.tencent.mm.plugin.card.model;

import com.tencent.mm.e.b.cd;
import com.tencent.mm.protocal.c.je;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class ad extends cd {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[2];
        aVar.bXK = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "cardUserId";
        aVar.nmd.put("cardUserId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" cardUserId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "cardUserId";
        aVar.bXK[1] = "retryCount";
        aVar.nmd.put("retryCount", "INTEGER");
        stringBuilder.append(" retryCount INTEGER");
        aVar.bXK[2] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ad)) {
            return false;
        }
        if (this.field_cardUserId == ((ad) obj).field_cardUserId) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.field_cardUserId == null ? 0 : this.field_cardUserId.hashCode();
    }

    public static ad a(je jeVar) {
        ad adVar = new ad();
        adVar.field_cardUserId = jeVar.mls;
        return adVar;
    }
}
