package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.e.b.cu;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;
import java.util.List;

public final class q extends cu {
    protected static a chq;
    public int jCt;

    static {
        a aVar = new a();
        aVar.ddU = new Field[4];
        aVar.bXK = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "tagId";
        aVar.nmd.put("tagId", "LONG default '0' ");
        stringBuilder.append(" tagId LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[1] = "tagName";
        aVar.nmd.put("tagName", "TEXT default '' ");
        stringBuilder.append(" tagName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[2] = "count";
        aVar.nmd.put("count", "INTEGER default '0' ");
        stringBuilder.append(" count INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[3] = "memberList";
        aVar.nmd.put("memberList", "TEXT default '' ");
        stringBuilder.append(" memberList TEXT default '' ");
        aVar.bXK[4] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final void bt(List<arf> list) {
        this.field_memberList = "";
        for (arf com_tencent_mm_protocal_c_arf : list) {
            this.field_memberList += com_tencent_mm_protocal_c_arf.mQy + ",";
        }
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.jCt = (int) this.nmb;
    }
}
