package com.tencent.mm.storage;

import com.tencent.mm.e.b.ay;
import com.tencent.mm.sdk.h.c.a;
import java.lang.reflect.Field;

public final class al extends ay {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[17];
        aVar.bXK = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "downloadId";
        aVar.nmd.put("downloadId", "LONG default '-1'  PRIMARY KEY ");
        stringBuilder.append(" downloadId LONG default '-1'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "downloadId";
        aVar.bXK[1] = "downloadUrl";
        aVar.nmd.put("downloadUrl", "TEXT default '' ");
        stringBuilder.append(" downloadUrl TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[2] = "fileName";
        aVar.nmd.put("fileName", "TEXT default '' ");
        stringBuilder.append(" fileName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[3] = "filePath";
        aVar.nmd.put("filePath", "TEXT default '' ");
        stringBuilder.append(" filePath TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[4] = "fileType";
        aVar.nmd.put("fileType", "INTEGER default '0' ");
        stringBuilder.append(" fileType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[5] = "status";
        aVar.nmd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[6] = "md5";
        aVar.nmd.put("md5", "TEXT default '' ");
        stringBuilder.append(" md5 TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[7] = "autoInstall";
        aVar.nmd.put("autoInstall", "INTEGER default 'false' ");
        stringBuilder.append(" autoInstall INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.bXK[8] = "showNotification";
        aVar.nmd.put("showNotification", "INTEGER default 'false' ");
        stringBuilder.append(" showNotification INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.bXK[9] = "sysDownloadId";
        aVar.nmd.put("sysDownloadId", "LONG default '-1' ");
        stringBuilder.append(" sysDownloadId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.bXK[10] = "downloaderType";
        aVar.nmd.put("downloaderType", "INTEGER default '0' ");
        stringBuilder.append(" downloaderType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[11] = "appId";
        aVar.nmd.put("appId", "TEXT default '' ");
        stringBuilder.append(" appId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[12] = "downloadUrlHashCode";
        aVar.nmd.put("downloadUrlHashCode", "INTEGER default '0' ");
        stringBuilder.append(" downloadUrlHashCode INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[13] = "packageName";
        aVar.nmd.put("packageName", "TEXT default '' ");
        stringBuilder.append(" packageName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[14] = "downloadedSize";
        aVar.nmd.put("downloadedSize", "LONG default '0' ");
        stringBuilder.append(" downloadedSize LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[15] = "totalSize";
        aVar.nmd.put("totalSize", "LONG default '0' ");
        stringBuilder.append(" totalSize LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[16] = "autoDownload";
        aVar.nmd.put("autoDownload", "INTEGER default 'false' ");
        stringBuilder.append(" autoDownload INTEGER default 'false' ");
        aVar.bXK[17] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }
}
