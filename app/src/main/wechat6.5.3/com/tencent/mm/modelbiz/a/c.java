package com.tencent.mm.modelbiz.a;

import com.tencent.mm.e.b.t;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c extends t {
    protected static a chq;
    private Map<String, j> cDH = new HashMap();
    private List<String> cDI;

    static {
        a aVar = new a();
        aVar.ddU = new Field[14];
        aVar.bXK = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "bizChatLocalId";
        aVar.nmd.put("bizChatLocalId", "LONG PRIMARY KEY ");
        stringBuilder.append(" bizChatLocalId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "bizChatLocalId";
        aVar.bXK[1] = "bizChatServId";
        aVar.nmd.put("bizChatServId", "TEXT");
        stringBuilder.append(" bizChatServId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "brandUserName";
        aVar.nmd.put("brandUserName", "TEXT default '' ");
        stringBuilder.append(" brandUserName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[3] = "chatType";
        aVar.nmd.put("chatType", "INTEGER");
        stringBuilder.append(" chatType INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[4] = "headImageUrl";
        aVar.nmd.put("headImageUrl", "TEXT");
        stringBuilder.append(" headImageUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "chatName";
        aVar.nmd.put("chatName", "TEXT default '' ");
        stringBuilder.append(" chatName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[6] = "chatNamePY";
        aVar.nmd.put("chatNamePY", "TEXT default '' ");
        stringBuilder.append(" chatNamePY TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[7] = "chatVersion";
        aVar.nmd.put("chatVersion", "INTEGER default '-1' ");
        stringBuilder.append(" chatVersion INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.bXK[8] = "needToUpdate";
        aVar.nmd.put("needToUpdate", "INTEGER default 'true' ");
        stringBuilder.append(" needToUpdate INTEGER default 'true' ");
        stringBuilder.append(", ");
        aVar.bXK[9] = "bitFlag";
        aVar.nmd.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[10] = "maxMemberCnt";
        aVar.nmd.put("maxMemberCnt", "INTEGER default '0' ");
        stringBuilder.append(" maxMemberCnt INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[11] = "ownerUserId";
        aVar.nmd.put("ownerUserId", "TEXT");
        stringBuilder.append(" ownerUserId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[12] = "userList";
        aVar.nmd.put("userList", "TEXT");
        stringBuilder.append(" userList TEXT");
        stringBuilder.append(", ");
        aVar.bXK[13] = "addMemberUrl";
        aVar.nmd.put("addMemberUrl", "TEXT");
        stringBuilder.append(" addMemberUrl TEXT");
        aVar.bXK[14] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final boolean fe(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    public final List<String> DM() {
        if (this.cDI != null) {
            return this.cDI;
        }
        String str = this.field_userList;
        if (be.kS(str)) {
            return new LinkedList();
        }
        this.cDI = be.g(str.split(";"));
        return this.cDI;
    }

    public final String er(String str) {
        j hQ = hQ(str);
        if (hQ == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        return be.ah(hQ.field_userName, SQLiteDatabase.KeyEmpty);
    }

    public final j hQ(String str) {
        if (!this.cDH.containsKey(str) || this.cDH.get(str) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            j ig = u.DC().ig(str);
            if (ig != null) {
                this.cDH.put(ig.field_userId, ig);
            }
            v.d("MicroMsg.BaseBizChatInfo", "willen get userInfo use time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        if (this.cDH.containsKey(str)) {
            return (j) this.cDH.get(str);
        }
        return null;
    }

    public final boolean DN() {
        if (this.field_bizChatServId == null) {
            return false;
        }
        return this.field_bizChatServId.endsWith("@qy_g");
    }

    public final boolean DO() {
        if (this.field_needToUpdate) {
            return true;
        }
        if (DN() && be.kS(this.field_userList)) {
            return true;
        }
        if (!be.kS(this.field_chatNamePY) || be.kS(this.field_chatName)) {
            return false;
        }
        return true;
    }
}
