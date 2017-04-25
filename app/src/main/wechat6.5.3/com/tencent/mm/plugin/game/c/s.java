package com.tencent.mm.plugin.game.c;

import com.tencent.mm.e.a.ft;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class s {
    static void a(ft ftVar) {
        String str = ftVar.bff.bfh;
        v.d("MicroMsg.GameJsapiProcessor", "writeMsg param=%s", new Object[]{str});
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.isNull(Columns.TYPE) || be.getInt(jSONObject.optString(Columns.TYPE), 0) == 0) {
                    JSONArray jSONArray = new JSONArray();
                    JSONArray jSONArray2 = jSONObject.getJSONArray("localIdList");
                    int length = jSONArray2.length();
                    long[] jArr = new long[length];
                    for (int i = 0; i < length; i++) {
                        jArr[i] = jSONArray2.getLong(i);
                    }
                    au.asc().e(jArr);
                } else if (be.getInt(jSONObject.optString(Columns.TYPE), 0) == 65536) {
                    au.asc().dF("GameRawMessage", "update GameRawMessage set isRead=1 where 1=1");
                }
            } catch (JSONException e) {
                v.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[]{e.getMessage()});
            }
        }
    }
}
