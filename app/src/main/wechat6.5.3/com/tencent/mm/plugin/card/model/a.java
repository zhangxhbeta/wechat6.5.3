package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public String coN;
    public String eBK;
    public int eBL;
    public String eBM;
    public String eBN;
    public String eBO;
    public String eBP;
    public String eBQ;
    public int eBR;
    public String eBS;
    public boolean eBT;
    public String exN;
    public String title;
    public String userName;

    public static LinkedList<a> pO(String str) {
        LinkedList<a> linkedList = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                linkedList = a(new JSONObject(str).optJSONArray("available_cards"), false);
            } catch (Throwable e) {
                v.a("MicroMsg.AvailableCardItem", e, "", new Object[0]);
            }
        }
        return linkedList;
    }

    public static LinkedList<a> pP(String str) {
        LinkedList<a> linkedList = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                linkedList = a(new JSONObject(str).optJSONArray("available_share_cards"), true);
            } catch (Throwable e) {
                v.a("MicroMsg.AvailableCardItem", e, "", new Object[0]);
            }
        }
        return linkedList;
    }

    private static LinkedList<a> a(JSONArray jSONArray, boolean z) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        LinkedList<a> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            a aVar = new a();
            aVar.eBK = jSONObject.optString("card_tp_id");
            aVar.eBL = jSONObject.optInt("card_type");
            aVar.coN = jSONObject.optString("color");
            aVar.eBM = jSONObject.optString("logo_url");
            aVar.title = jSONObject.optString(FFmpegMetadataRetriever.METADATA_KEY_TITLE);
            aVar.eBN = jSONObject.optString("sub_title");
            aVar.eBO = jSONObject.optString("aux_title");
            aVar.eBP = jSONObject.optString("encrypt_code");
            aVar.userName = jSONObject.optString("from_user_name");
            aVar.eBQ = jSONObject.optString("app_id");
            aVar.eBR = jSONObject.optInt("end_time");
            aVar.eBS = jSONObject.optString("card_user_id");
            aVar.eBT = z;
            linkedList.add(aVar);
        }
        return linkedList;
    }
}
