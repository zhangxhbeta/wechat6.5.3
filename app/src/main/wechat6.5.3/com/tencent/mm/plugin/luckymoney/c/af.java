package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.model.k;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class af extends z {
    public af(String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("username", str);
        hashMap.put("sendId", str2);
        hashMap.put(DownloadInfoColumns.CHANNELID, "1");
        hashMap.put("ver", str3);
        hashMap.put("sendUserName", k.xF());
        u(hashMap);
    }

    public final int getType() {
        return 1668;
    }

    public final String axK() {
        return "/cgi-bin/mmpay-bin/sharewxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
