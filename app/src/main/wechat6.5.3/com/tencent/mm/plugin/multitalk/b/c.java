package com.tencent.mm.plugin.multitalk.b;

import com.tencent.mm.e.b.bz;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class c extends bz {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[7];
        aVar.bXK = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "memberUuid";
        aVar.nmd.put("memberUuid", "LONG");
        stringBuilder.append(" memberUuid LONG");
        stringBuilder.append(", ");
        aVar.bXK[1] = "wxGroupId";
        aVar.nmd.put("wxGroupId", "TEXT");
        stringBuilder.append(" wxGroupId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "userName";
        aVar.nmd.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "inviteUserName";
        aVar.nmd.put("inviteUserName", "TEXT");
        stringBuilder.append(" inviteUserName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "memberId";
        aVar.nmd.put("memberId", "LONG");
        stringBuilder.append(" memberId LONG");
        stringBuilder.append(", ");
        aVar.bXK[5] = DownloadInfo.STATUS;
        aVar.nmd.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = "createTime";
        aVar.nmd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.bXK[7] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
