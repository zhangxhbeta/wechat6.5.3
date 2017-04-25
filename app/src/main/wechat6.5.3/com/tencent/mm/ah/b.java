package com.tencent.mm.ah;

import com.tencent.mm.e.b.by;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class b extends by {
    public static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[9];
        aVar.bXK = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "wxGroupId";
        aVar.nmd.put("wxGroupId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" wxGroupId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "wxGroupId";
        aVar.bXK[1] = "groupId";
        aVar.nmd.put("groupId", "TEXT");
        stringBuilder.append(" groupId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "roomId";
        aVar.nmd.put("roomId", "INTEGER");
        stringBuilder.append(" roomId INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[3] = "roomKey";
        aVar.nmd.put("roomKey", "LONG");
        stringBuilder.append(" roomKey LONG");
        stringBuilder.append(", ");
        aVar.bXK[4] = "routeId";
        aVar.nmd.put("routeId", "INTEGER");
        stringBuilder.append(" routeId INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[5] = "inviteUserName";
        aVar.nmd.put("inviteUserName", "TEXT");
        stringBuilder.append(" inviteUserName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[6] = "memberCount";
        aVar.nmd.put("memberCount", "INTEGER");
        stringBuilder.append(" memberCount INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[7] = "createTime";
        aVar.nmd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[8] = "state";
        aVar.nmd.put("state", "INTEGER default '0' ");
        stringBuilder.append(" state INTEGER default '0' ");
        aVar.bXK[9] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
