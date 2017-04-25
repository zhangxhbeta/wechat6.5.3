package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.e.b.cm;
import com.tencent.mm.protocal.c.aup;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class n extends cm {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[5];
        aVar.bXK = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "card_id";
        aVar.nmd.put("card_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" card_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "card_id";
        aVar.bXK[1] = "state_flag";
        aVar.nmd.put("state_flag", "INTEGER");
        stringBuilder.append(" state_flag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[2] = "update_time";
        aVar.nmd.put("update_time", "LONG");
        stringBuilder.append(" update_time LONG");
        stringBuilder.append(", ");
        aVar.bXK[3] = "seq";
        aVar.nmd.put("seq", "LONG");
        stringBuilder.append(" seq LONG");
        stringBuilder.append(", ");
        aVar.bXK[4] = "retryCount";
        aVar.nmd.put("retryCount", "INTEGER");
        stringBuilder.append(" retryCount INTEGER");
        aVar.bXK[5] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        if (this.field_card_id == ((n) obj).field_card_id) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.field_card_id == null ? 0 : this.field_card_id.hashCode();
    }

    public static n b(aup com_tencent_mm_protocal_c_aup) {
        n nVar = new n();
        nVar.field_card_id = com_tencent_mm_protocal_c_aup.bol;
        nVar.field_update_time = (long) com_tencent_mm_protocal_c_aup.mlC;
        nVar.field_state_flag = com_tencent_mm_protocal_c_aup.eEu;
        nVar.field_seq = com_tencent_mm_protocal_c_aup.mSh;
        nVar.field_retryCount = 10;
        return nVar;
    }
}
