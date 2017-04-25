package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class y extends z {
    public y(String str, String str2, int i, int i2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("offset", String.valueOf(i2));
        hashMap.put(Columns.TYPE, String.valueOf(i));
        hashMap.put("receiveId", str2);
        hashMap.put("ver", str3);
        u(hashMap);
    }

    public final int getType() {
        return 1612;
    }

    public final String axK() {
        return "/cgi-bin/mmpay-bin/deletelistwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("NetSceneLuckyMoneyMyRecordDelete", "onGYNetEnd");
    }
}
