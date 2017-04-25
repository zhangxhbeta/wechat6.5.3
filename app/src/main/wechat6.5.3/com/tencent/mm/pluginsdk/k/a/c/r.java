package com.tencent.mm.pluginsdk.k.a.c;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.b.cg;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Field;

public final class r extends cg {
    public static final a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[33];
        aVar.bXK = new String[34];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "urlKey_hashcode";
        aVar.nmd.put("urlKey_hashcode", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" urlKey_hashcode INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "urlKey_hashcode";
        aVar.bXK[1] = "urlKey";
        aVar.nmd.put("urlKey", "TEXT");
        stringBuilder.append(" urlKey TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = SlookSmartClipMetaTag.TAG_TYPE_URL;
        aVar.nmd.put(SlookSmartClipMetaTag.TAG_TYPE_URL, "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "fileVersion";
        aVar.nmd.put("fileVersion", "TEXT");
        stringBuilder.append(" fileVersion TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "networkType";
        aVar.nmd.put("networkType", "INTEGER default '2' ");
        stringBuilder.append(" networkType INTEGER default '2' ");
        stringBuilder.append(", ");
        aVar.bXK[5] = "maxRetryTimes";
        aVar.nmd.put("maxRetryTimes", "INTEGER default '3' ");
        stringBuilder.append(" maxRetryTimes INTEGER default '3' ");
        stringBuilder.append(", ");
        aVar.bXK[6] = "retryTimes";
        aVar.nmd.put("retryTimes", "INTEGER default '3' ");
        stringBuilder.append(" retryTimes INTEGER default '3' ");
        stringBuilder.append(", ");
        aVar.bXK[7] = "filePath";
        aVar.nmd.put("filePath", "TEXT");
        stringBuilder.append(" filePath TEXT");
        stringBuilder.append(", ");
        aVar.bXK[8] = "status";
        aVar.nmd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[9] = "contentLength";
        aVar.nmd.put("contentLength", "LONG default '0' ");
        stringBuilder.append(" contentLength LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[10] = "contentType";
        aVar.nmd.put("contentType", "TEXT");
        stringBuilder.append(" contentType TEXT");
        stringBuilder.append(", ");
        aVar.bXK[11] = "expireTime";
        aVar.nmd.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[12] = "md5";
        aVar.nmd.put("md5", "TEXT");
        stringBuilder.append(" md5 TEXT");
        stringBuilder.append(", ");
        aVar.bXK[13] = "groupId1";
        aVar.nmd.put("groupId1", "TEXT");
        stringBuilder.append(" groupId1 TEXT");
        stringBuilder.append(", ");
        aVar.bXK[14] = "groupId2";
        aVar.nmd.put("groupId2", "TEXT");
        stringBuilder.append(" groupId2 TEXT");
        stringBuilder.append(", ");
        aVar.bXK[15] = "priority";
        aVar.nmd.put("priority", "INTEGER default '0' ");
        stringBuilder.append(" priority INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[16] = "fileUpdated";
        aVar.nmd.put("fileUpdated", "INTEGER");
        stringBuilder.append(" fileUpdated INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[17] = "deleted";
        aVar.nmd.put("deleted", "INTEGER default 'false' ");
        stringBuilder.append(" deleted INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.bXK[18] = "resType";
        aVar.nmd.put("resType", "INTEGER");
        stringBuilder.append(" resType INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[19] = "subType";
        aVar.nmd.put("subType", "INTEGER");
        stringBuilder.append(" subType INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[20] = "reportId";
        aVar.nmd.put("reportId", "LONG");
        stringBuilder.append(" reportId LONG");
        stringBuilder.append(", ");
        aVar.bXK[21] = "sampleId";
        aVar.nmd.put("sampleId", "TEXT");
        stringBuilder.append(" sampleId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[22] = "eccSignature";
        aVar.nmd.put("eccSignature", "BLOB");
        stringBuilder.append(" eccSignature BLOB");
        stringBuilder.append(", ");
        aVar.bXK[23] = "originalMd5";
        aVar.nmd.put("originalMd5", "TEXT");
        stringBuilder.append(" originalMd5 TEXT");
        stringBuilder.append(", ");
        aVar.bXK[24] = "fileCompress";
        aVar.nmd.put("fileCompress", "INTEGER default 'false' ");
        stringBuilder.append(" fileCompress INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.bXK[25] = "fileEncrypt";
        aVar.nmd.put("fileEncrypt", "INTEGER default 'false' ");
        stringBuilder.append(" fileEncrypt INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.bXK[26] = "encryptKey";
        aVar.nmd.put("encryptKey", "TEXT");
        stringBuilder.append(" encryptKey TEXT");
        stringBuilder.append(", ");
        aVar.bXK[27] = "keyVersion";
        aVar.nmd.put("keyVersion", "INTEGER default '0' ");
        stringBuilder.append(" keyVersion INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[28] = "EID";
        aVar.nmd.put("EID", "INTEGER");
        stringBuilder.append(" EID INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[29] = "fileSize";
        aVar.nmd.put("fileSize", "LONG");
        stringBuilder.append(" fileSize LONG");
        stringBuilder.append(", ");
        aVar.bXK[30] = "appId";
        aVar.nmd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[31] = "wvCacheType";
        aVar.nmd.put("wvCacheType", "INTEGER");
        stringBuilder.append(" wvCacheType INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[32] = "packageId";
        aVar.nmd.put("packageId", "TEXT");
        stringBuilder.append(" packageId TEXT");
        aVar.bXK[33] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ResDownloaderRecord {");
        try {
            for (Field field : getClass().getSuperclass().getDeclaredFields()) {
                if (field.getName().startsWith("field_")) {
                    field.setAccessible(true);
                    stringBuilder.append(field.getName().replaceFirst("field_", SQLiteDatabase.KeyEmpty)).append(" = ").append(field.get(this)).append(", ");
                }
            }
        } catch (Throwable e) {
            v.a("MicroMsg.ResDownloaderRecord", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        try {
            Field field2 = getClass().getSuperclass().getSuperclass().getField("systemRowid");
            field2.setAccessible(true);
            stringBuilder.append("systemRowid = ").append(field2.get(this));
        } catch (Throwable e2) {
            v.a("MicroMsg.ResDownloaderRecord", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
        } catch (Throwable e22) {
            v.a("MicroMsg.ResDownloaderRecord", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return stringBuilder.append(" }").toString();
    }

    protected final a tl() {
        return chq;
    }
}
