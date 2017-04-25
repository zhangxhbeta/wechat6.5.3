package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l {
    public static e p(JSONObject jSONObject) {
        e eVar = new e();
        if (jSONObject != null) {
            eVar.hau = jSONObject.optInt("hbType");
            eVar.hav = jSONObject.optInt("hbStatus");
            eVar.haw = jSONObject.optString("statusMess");
            eVar.hax = jSONObject.optString("gameMess");
            eVar.hay = jSONObject.optString("wishing");
            eVar.haz = jSONObject.optString("sendNick");
            eVar.haA = jSONObject.optString("sendHeadImg");
            eVar.haB = jSONObject.optString("sendId");
            eVar.haC = jSONObject.optString("adMessage");
            eVar.haD = jSONObject.optString("adUrl");
            eVar.bst = jSONObject.optLong("amount");
            eVar.haE = jSONObject.optLong("recNum");
            eVar.haF = jSONObject.optLong("recAmount");
            eVar.haG = jSONObject.optInt("totalNum");
            eVar.haH = jSONObject.optLong("totalAmount");
            eVar.haI = jSONObject.optString("receiveId");
            eVar.haJ = jSONObject.optInt("hasWriteAnswer");
            eVar.haK = jSONObject.optInt("isSender");
            eVar.haL = jSONObject.optInt("isContinue");
            eVar.haM = jSONObject.optString("headTitle");
            eVar.haN = jSONObject.optInt("receiveStatus");
            eVar.haO = jSONObject.optInt("canShare");
            eVar.haQ = jSONObject.optInt("jumpChange");
            eVar.haR = jSONObject.optString("changeWording");
            eVar.haZ = jSONObject.optString("changeUrl");
            eVar.haW = jSONObject.optInt("hbKind");
            eVar.haX = jSONObject.optString("externMess");
            eVar.haP = new a();
            JSONObject optJSONObject = jSONObject.optJSONObject("atomicFunc");
            if (optJSONObject != null) {
                eVar.haP.cdf = optJSONObject.optInt("enable");
                eVar.haP.haf = optJSONObject.optString("fissionContent");
                eVar.haP.hae = optJSONObject.optString("fissionUrl");
            }
            eVar.haS = new LinkedList();
            JSONArray optJSONArray = jSONObject.optJSONArray("operationHeader");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    eVar.haS.add(r(optJSONArray.getJSONObject(i)));
                }
            }
            eVar.haU = jSONObject.optString("watermark");
            eVar.haV = jSONObject.optString("context");
            eVar.hba = jSONObject.optString("contextMd5");
            eVar.resourceId = jSONObject.optInt("resourceId");
            eVar.haT = r(jSONObject.optJSONObject("operationTail"));
            eVar.haY = q(jSONObject);
        }
        return eVar;
    }

    private static LinkedList<m> q(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("record");
        LinkedList<m> linkedList = new LinkedList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                m mVar = new m();
                if (jSONObject2 != null) {
                    mVar.hbu = jSONObject2.optString("receiveName");
                    mVar.hbv = jSONObject2.optString("receiveHeadImg");
                    mVar.hbh = jSONObject2.optLong("receiveAmount");
                    mVar.hbi = jSONObject2.optString("receiveTime");
                    mVar.hbw = jSONObject2.optString("answer");
                    mVar.haI = jSONObject2.optString("receiveId");
                    mVar.hbx = jSONObject2.optString("gameTips");
                }
                linkedList.add(mVar);
            }
        }
        return linkedList;
    }

    public static ag r(JSONObject jSONObject) {
        ag agVar = new ag();
        if (jSONObject != null) {
            agVar.cdf = jSONObject.optInt("enable", 0);
            agVar.content = jSONObject.optString("content");
            agVar.iconUrl = jSONObject.optString("iconUrl");
            agVar.type = jSONObject.optString(Columns.TYPE);
            agVar.name = jSONObject.optString("name");
            agVar.hcu = jSONObject.optInt("ossKey");
            agVar.hcv = jSONObject.optInt("focus");
        }
        return agVar;
    }
}
