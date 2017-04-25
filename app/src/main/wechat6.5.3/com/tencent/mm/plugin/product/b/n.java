package com.tencent.mm.plugin.product.b;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n {
    public List<a> hQN = new ArrayList();
    public String name;

    public static class a {
        public String data;
        public String iconUrl;
        public String title;
        public int type;
        public String url;
    }

    public static List<n> parse(String str) {
        List<n> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("group_list");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                n nVar = new n();
                nVar.name = jSONObject.getString("name");
                JSONArray jSONArray2 = jSONObject.getJSONArray("item_list");
                int length2 = jSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    a aVar = new a();
                    aVar.title = jSONObject2.getString(FFmpegMetadataRetriever.METADATA_KEY_TITLE);
                    aVar.type = jSONObject2.getInt("jump_type");
                    aVar.data = jSONObject2.getString("native_url_args");
                    aVar.iconUrl = jSONObject2.getString("icon_url");
                    aVar.url = jSONObject2.getString("h5_url");
                    nVar.hQN.add(aVar);
                }
                arrayList.add(nVar);
            }
            return arrayList;
        } catch (Exception e) {
            return null;
        }
    }
}
