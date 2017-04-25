package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.e.b.bl;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class e extends bl {
    public static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[5];
        aVar.bXK = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "rankID";
        aVar.nmd.put("rankID", "TEXT");
        stringBuilder.append(" rankID TEXT");
        stringBuilder.append(", ");
        aVar.bXK[1] = "appusername";
        aVar.nmd.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "username";
        aVar.nmd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "timestamp";
        aVar.nmd.put("timestamp", "INTEGER default '0' ");
        stringBuilder.append(" timestamp INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[4] = "liketips";
        aVar.nmd.put("liketips", "TEXT default '' ");
        stringBuilder.append(" liketips TEXT default '' ");
        aVar.bXK[5] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
