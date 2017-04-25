package com.tencent.mm.modelbiz.a;

import com.tencent.mm.e.b.v;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.be;
import java.lang.reflect.Field;

public final class j extends v {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[10];
        aVar.bXK = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "userId";
        aVar.nmd.put("userId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" userId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "userId";
        aVar.bXK[1] = "userName";
        aVar.nmd.put("userName", "TEXT default '' ");
        stringBuilder.append(" userName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[2] = "userNamePY";
        aVar.nmd.put("userNamePY", "TEXT default '' ");
        stringBuilder.append(" userNamePY TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[3] = "brandUserName";
        aVar.nmd.put("brandUserName", "TEXT default '' ");
        stringBuilder.append(" brandUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[4] = "UserVersion";
        aVar.nmd.put("UserVersion", "INTEGER default '-1' ");
        stringBuilder.append(" UserVersion INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.bXK[5] = "needToUpdate";
        aVar.nmd.put("needToUpdate", "INTEGER default 'true' ");
        stringBuilder.append(" needToUpdate INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.bXK[6] = "headImageUrl";
        aVar.nmd.put("headImageUrl", "TEXT");
        stringBuilder.append(" headImageUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[7] = "profileUrl";
        aVar.nmd.put("profileUrl", "TEXT");
        stringBuilder.append(" profileUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[8] = "bitFlag";
        aVar.nmd.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[9] = "addMemberUrl";
        aVar.nmd.put("addMemberUrl", "TEXT");
        stringBuilder.append(" addMemberUrl TEXT");
        aVar.bXK[10] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final boolean fe(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    public final boolean DO() {
        if (this.field_needToUpdate) {
            return true;
        }
        if (be.kS(this.field_profileUrl) && be.kS(this.field_headImageUrl)) {
            return true;
        }
        if (!be.kS(this.field_userNamePY) || be.kS(this.field_userName)) {
            return false;
        }
        return true;
    }
}
