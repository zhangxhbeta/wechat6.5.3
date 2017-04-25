package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.e.b.dk;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class i extends dk {
    protected static a chq;

    static {
        a aVar = new a();
        aVar.ddU = new Field[17];
        aVar.bXK = new String[18];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "urlMd5Hashcode";
        aVar.nmd.put("urlMd5Hashcode", "INTEGER");
        stringBuilder.append(" urlMd5Hashcode INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[1] = "url";
        aVar.nmd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "appId";
        aVar.nmd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "domain";
        aVar.nmd.put("domain", "TEXT");
        stringBuilder.append(" domain TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "version";
        aVar.nmd.put("version", "TEXT");
        stringBuilder.append(" version TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "localPath";
        aVar.nmd.put("localPath", "TEXT");
        stringBuilder.append(" localPath TEXT");
        stringBuilder.append(", ");
        aVar.bXK[6] = DownloadInfo.CONTENTTYPE;
        aVar.nmd.put(DownloadInfo.CONTENTTYPE, "TEXT");
        stringBuilder.append(" contentType TEXT");
        stringBuilder.append(", ");
        aVar.bXK[7] = "contentLength";
        aVar.nmd.put("contentLength", "LONG");
        stringBuilder.append(" contentLength LONG");
        stringBuilder.append(", ");
        aVar.bXK[8] = "isLatestVersion";
        aVar.nmd.put("isLatestVersion", "INTEGER");
        stringBuilder.append(" isLatestVersion INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[9] = "createTime";
        aVar.nmd.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[10] = "accessTime";
        aVar.nmd.put("accessTime", "LONG");
        stringBuilder.append(" accessTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[11] = "expireTime";
        aVar.nmd.put("expireTime", "LONG default '0' ");
        stringBuilder.append(" expireTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[12] = "cacheType";
        aVar.nmd.put("cacheType", "INTEGER");
        stringBuilder.append(" cacheType INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[13] = "configId";
        aVar.nmd.put("configId", "TEXT");
        stringBuilder.append(" configId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[14] = "protocol";
        aVar.nmd.put("protocol", "INTEGER");
        stringBuilder.append(" protocol INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[15] = "packageId";
        aVar.nmd.put("packageId", "TEXT");
        stringBuilder.append(" packageId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[16] = "contentMd5";
        aVar.nmd.put("contentMd5", "TEXT");
        stringBuilder.append(" contentMd5 TEXT");
        aVar.bXK[17] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName() + " {");
        try {
            for (Field field : getClass().getSuperclass().getDeclaredFields()) {
                if (field.getName().startsWith("field_")) {
                    field.setAccessible(true);
                    stringBuilder.append(field.getName().replaceFirst("field_", "")).append(" = ").append(field.get(this)).append(", ");
                }
            }
        } catch (Throwable e) {
            v.a("MicroMsg.WebViewCacheRes", e, "", new Object[0]);
        }
        return stringBuilder.append(" }").toString();
    }
}
