package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.e.b.g;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class b extends g {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[19];
        aVar.bXK = new String[20];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "appId";
        aVar.nmd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[1] = "sdkVer";
        aVar.nmd.put("sdkVer", "LONG");
        stringBuilder.append(" sdkVer LONG");
        stringBuilder.append(", ");
        aVar.bXK[2] = "mediaSvrId";
        aVar.nmd.put("mediaSvrId", "TEXT");
        stringBuilder.append(" mediaSvrId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "mediaId";
        aVar.nmd.put("mediaId", "TEXT");
        stringBuilder.append(" mediaId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "clientAppDataId";
        aVar.nmd.put("clientAppDataId", "TEXT");
        stringBuilder.append(" clientAppDataId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "type";
        aVar.nmd.put("type", "LONG");
        stringBuilder.append(" type LONG");
        stringBuilder.append(", ");
        aVar.bXK[6] = "totalLen";
        aVar.nmd.put("totalLen", "LONG");
        stringBuilder.append(" totalLen LONG");
        stringBuilder.append(", ");
        aVar.bXK[7] = "offset";
        aVar.nmd.put("offset", "LONG");
        stringBuilder.append(" offset LONG");
        stringBuilder.append(", ");
        aVar.bXK[8] = "status";
        aVar.nmd.put("status", "LONG");
        stringBuilder.append(" status LONG");
        stringBuilder.append(", ");
        aVar.bXK[9] = "isUpload";
        aVar.nmd.put("isUpload", "INTEGER");
        stringBuilder.append(" isUpload INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[10] = "createTime";
        aVar.nmd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[11] = "lastModifyTime";
        aVar.nmd.put("lastModifyTime", "LONG");
        stringBuilder.append(" lastModifyTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[12] = "fileFullPath";
        aVar.nmd.put("fileFullPath", "TEXT");
        stringBuilder.append(" fileFullPath TEXT");
        stringBuilder.append(", ");
        aVar.bXK[13] = "msgInfoId";
        aVar.nmd.put("msgInfoId", "LONG");
        stringBuilder.append(" msgInfoId LONG");
        stringBuilder.append(", ");
        aVar.bXK[14] = "netTimes";
        aVar.nmd.put("netTimes", "LONG");
        stringBuilder.append(" netTimes LONG");
        stringBuilder.append(", ");
        aVar.bXK[15] = "isUseCdn";
        aVar.nmd.put("isUseCdn", "INTEGER");
        stringBuilder.append(" isUseCdn INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[16] = "signature";
        aVar.nmd.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.bXK[17] = "fakeAeskey";
        aVar.nmd.put("fakeAeskey", "TEXT");
        stringBuilder.append(" fakeAeskey TEXT");
        stringBuilder.append(", ");
        aVar.bXK[18] = "fakeSignature";
        aVar.nmd.put("fakeSignature", "TEXT");
        stringBuilder.append(" fakeSignature TEXT");
        aVar.bXK[19] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public b() {
        this.field_netTimes = 0;
    }

    public final boolean bnj() {
        if (this.field_totalLen > 0 && this.field_offset == this.field_totalLen) {
            return true;
        }
        return false;
    }
}
