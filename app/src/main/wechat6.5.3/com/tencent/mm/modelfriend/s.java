package com.tencent.mm.modelfriend;

import com.tencent.mm.e.b.bv;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class s extends bv {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[12];
        aVar.bXK = new String[13];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "wechatId";
        aVar.nmd.put("wechatId", "TEXT");
        stringBuilder.append(" wechatId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[1] = "linkedInId";
        aVar.nmd.put("linkedInId", "TEXT");
        stringBuilder.append(" linkedInId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "name";
        aVar.nmd.put("name", "TEXT");
        stringBuilder.append(" name TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "position";
        aVar.nmd.put("position", "TEXT");
        stringBuilder.append(" position TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "picUrl";
        aVar.nmd.put("picUrl", "TEXT");
        stringBuilder.append(" picUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "wechatUsername";
        aVar.nmd.put("wechatUsername", "TEXT");
        stringBuilder.append(" wechatUsername TEXT");
        stringBuilder.append(", ");
        aVar.bXK[6] = "wechatSmallHead";
        aVar.nmd.put("wechatSmallHead", "TEXT");
        stringBuilder.append(" wechatSmallHead TEXT");
        stringBuilder.append(", ");
        aVar.bXK[7] = "wechatBigHead";
        aVar.nmd.put("wechatBigHead", "TEXT");
        stringBuilder.append(" wechatBigHead TEXT");
        stringBuilder.append(", ");
        aVar.bXK[8] = "linkedInProfileUrl";
        aVar.nmd.put("linkedInProfileUrl", "TEXT");
        stringBuilder.append(" linkedInProfileUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[9] = "status";
        aVar.nmd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[10] = "userOpStatus";
        aVar.nmd.put("userOpStatus", "INTEGER default '0' ");
        stringBuilder.append(" userOpStatus INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[11] = "nickname";
        aVar.nmd.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        aVar.bXK[12] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("wechatIdwechatId\n");
        stringBuffer.append("linkedInIdlinkedInId\n");
        stringBuffer.append("namename\n");
        stringBuffer.append("positionposition\n");
        stringBuffer.append("picUrlpicUrl\n");
        stringBuffer.append("wechatUsernamewechatUsername\n");
        stringBuffer.append("wechatBigHeadwechatSmallHead\n");
        stringBuffer.append("wechatUsernamewechatBigHead\n");
        stringBuffer.append("linkedInProfileUrllinkedInProfileUrl\n");
        stringBuffer.append("statusstatus\n");
        stringBuffer.append("userOpStatusstatus\n");
        return stringBuffer.toString();
    }
}
