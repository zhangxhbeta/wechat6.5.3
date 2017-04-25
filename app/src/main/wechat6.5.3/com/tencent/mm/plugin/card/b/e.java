package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.sdk.platformtools.bf;
import java.util.Map;

public final class e {
    public static d qo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d dVar = new d();
        Map q = bf.q(str, "msg");
        dVar.eCB = (String) q.get(".msg.appmsg.carditem.from_username");
        dVar.bol = (String) q.get(".msg.appmsg.carditem.card_id");
        dVar.eBL = qq((String) q.get(".msg.appmsg.carditem.card_type"));
        dVar.bon = qq((String) q.get(".msg.appmsg.carditem.from_scene"));
        dVar.coN = (String) q.get(".msg.appmsg.carditem.color");
        dVar.eCC = (String) q.get(".msg.appmsg.carditem.card_type_name");
        dVar.eCD = (String) q.get(".msg.appmsg.carditem.brand_name");
        dVar.bom = (String) q.get(".msg.appmsg.carditem.card_ext");
        dVar.eCE = qq((String) q.get(".msg.appmsg.carditem.is_recommend"));
        dVar.eCF = (String) q.get(".msg.appmsg.carditem.recommend_card_id");
        return dVar;
    }

    public static String qp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (String) bf.q(str, "msg").get(".msg.appmsg.fromusername");
    }

    private static int qq(String str) {
        if (TextUtils.isEmpty(str) || !j.qw(str)) {
            return 0;
        }
        return Integer.valueOf(str).intValue();
    }

    public static String a(d dVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<from_username>").append(dVar.eCB).append("</from_username>");
        stringBuilder.append("<card_id>").append(dVar.bol).append("</card_id>");
        stringBuilder.append("<card_type>").append(dVar.eBL).append("</card_type>");
        stringBuilder.append("<from_scene>").append(dVar.bon).append("</from_scene>");
        stringBuilder.append("<color>").append(dVar.coN).append("</color>");
        stringBuilder.append("<card_type_name>").append(dVar.eCC).append("</card_type_name>");
        stringBuilder.append("<brand_name>").append(dVar.eCD).append("</brand_name>");
        if (TextUtils.isEmpty(dVar.bom)) {
            stringBuilder.append("<card_ext></card_ext>");
        } else {
            stringBuilder.append("<card_ext>").append(dVar.bom).append("</card_ext>");
        }
        stringBuilder.append("<is_recommend>").append(dVar.eCE).append("</is_recommend>");
        stringBuilder.append("<recommend_card_id>").append(dVar.eCF).append("</recommend_card_id>");
        return stringBuilder.toString();
    }
}
