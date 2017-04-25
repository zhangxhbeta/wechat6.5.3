package com.tencent.mm.plugin.card.b;

import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.protocal.c.jh;
import com.tencent.mm.protocal.c.ji;
import com.tencent.mm.protocal.c.jj;
import com.tencent.mm.protocal.c.up;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h {
    public static void a(LinkedList<jh> linkedList, int i) {
        if (linkedList != null) {
            int size = linkedList.size();
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                jh jhVar = (jh) linkedList.get(i2);
                c aak = af.aak();
                String str = jhVar.bol;
                int i3 = ((size - i2) * 10) + i;
                String str2 = jhVar.eEN;
                int i4 = jhVar.eBR;
                if (be.kS(str)) {
                    v.w("MicroMsg.CardInfoStorage", "cardId null");
                } else {
                    aak.cie.dF("UserCardInfo", "update UserCardInfo set stickyIndex=" + i3 + ", stickyAnnouncement='" + str2 + "', stickyEndTime=" + i4 + " where card_id='" + str + "'");
                }
            }
        }
    }

    public static up qt(String str) {
        boolean z = true;
        if (be.kS(str)) {
            v.w("MicroMsg.CardStickyHelper", "jsonRet null");
            return null;
        }
        up upVar = new up();
        try {
            JSONObject jSONObject = new JSONObject(str);
            upVar.mxe = jSONObject.optString("layout_buff");
            jSONObject = jSONObject.getJSONObject("list");
            if (jSONObject == null) {
                return upVar;
            }
            upVar.mxh = new jj();
            upVar.mxh.mlE = o(jSONObject.optJSONObject("expiring_list"));
            upVar.mxh.mlF = o(jSONObject.optJSONObject("member_card_list"));
            upVar.mxh.mlG = o(jSONObject.optJSONObject("nearby_list"));
            upVar.mxi = jSONObject.optString("red_dot_wording");
            if (jSONObject.optInt("show_red_dot", 0) != 1) {
                z = false;
            }
            upVar.mxj = z;
            Object optString = jSONObject.optString("title");
            if (optString == null) {
                optString = "";
            }
            af.aap().putValue("key_card_entrance_tips", optString);
            upVar.mxk = jSONObject.optInt("top_scene", 100);
            return upVar;
        } catch (Throwable e) {
            v.a("MicroMsg.CardStickyHelper", e, "", new Object[0]);
            return upVar;
        }
    }

    private static ji o(JSONObject jSONObject) {
        if (jSONObject == null) {
            v.w("MicroMsg.CardStickyHelper", "parseLayoutItemList param obj null");
            return null;
        }
        ji jiVar = new ji();
        jiVar.mlD = new LinkedList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("item_list");
            for (int i = 0; i < jSONArray.length(); i++) {
                jh jhVar;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 == null) {
                    jhVar = null;
                } else {
                    jhVar = new jh();
                    jhVar.eEN = jSONObject2.optString("announcement");
                    jhVar.bol = jSONObject2.optString("card_id");
                    jhVar.eBR = jSONObject2.optInt("end_time", 0);
                    jhVar.mlC = jSONObject2.optInt("update_time");
                }
                if (jhVar == null || (((long) jhVar.eBR) <= be.Nh() && jhVar.eBR != 0)) {
                    v.i("MicroMsg.CardStickyHelper", "item.end_time > Util.nowSecond()");
                } else {
                    jiVar.mlD.add(jhVar);
                }
            }
        } catch (Throwable e) {
            v.a("MicroMsg.CardStickyHelper", e, "", new Object[0]);
        }
        return jiVar;
    }
}
