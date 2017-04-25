package com.tencent.mm.as;

import com.tencent.mm.e.b.cn;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;

public final class f extends cn {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[8];
        aVar.bXK = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "localId";
        aVar.nmd.put("localId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" localId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "localId";
        aVar.bXK[1] = "fileName";
        aVar.nmd.put("fileName", "TEXT");
        stringBuilder.append(" fileName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "fileNameHash";
        aVar.nmd.put("fileNameHash", "INTEGER");
        stringBuilder.append(" fileNameHash INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[3] = "fileMd5";
        aVar.nmd.put("fileMd5", "TEXT default '' ");
        stringBuilder.append(" fileMd5 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[4] = "fileLength";
        aVar.nmd.put("fileLength", "LONG default '0' ");
        stringBuilder.append(" fileLength LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[5] = "fileStatus";
        aVar.nmd.put("fileStatus", "INTEGER default '0' ");
        stringBuilder.append(" fileStatus INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[6] = "fileDuration";
        aVar.nmd.put("fileDuration", "INTEGER default '0' ");
        stringBuilder.append(" fileDuration INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[7] = "createTime";
        aVar.nmd.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        aVar.bXK[8] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final void l(String str, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("localId=").append(this.field_localId).append(", ");
        stringBuilder.append("filename=").append(this.field_fileName).append(", ");
        stringBuilder.append("filenamehash=").append(this.field_fileNameHash).append(", ");
        stringBuilder.append("filelength=").append(this.field_fileLength).append(", ");
        stringBuilder.append("filemd5=").append(this.field_fileMd5).append(", ");
        stringBuilder.append("filestatus=").append(this.field_fileStatus);
        if (j > 0) {
            stringBuilder.append(", use ").append(be.az(j)).append("ms");
        }
        v.i("MicroMsg.SightDraftInfo", stringBuilder.toString());
    }
}
