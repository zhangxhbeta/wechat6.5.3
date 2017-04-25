package com.tencent.mm.plugin.shake.e;

import android.content.Context;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import java.util.LinkedList;
import java.util.Map;

public final class c {

    public static class a {
        public String field_id;
        public String field_playstatid;
        public String field_playurl;
        public String field_shareurl;
        public String field_source;
        public String field_subtitle;
        public String field_thumburl;
        public String field_title;
        public String field_topic;
        public String field_xml;
        public LinkedList<a> iEd;
    }

    public static a zy(String str) {
        if (str == null) {
            return null;
        }
        String str2 = "";
        Map q = bf.q(str, "tv");
        if (q == null) {
            return null;
        }
        a aVar = new a();
        aVar.field_id = be.ma((String) q.get(str2 + ".tv.id"));
        aVar.field_topic = be.ma((String) q.get(str2 + ".tv.topic"));
        aVar.field_title = be.ma((String) q.get(str2 + ".tv.title"));
        aVar.field_subtitle = be.ma((String) q.get(str2 + ".tv.subtitle"));
        aVar.field_thumburl = be.ma((String) q.get(str2 + ".tv.thumburl"));
        aVar.field_shareurl = be.ma((String) q.get(str2 + ".tv.shareurl"));
        aVar.field_playurl = be.ma((String) q.get(str2 + ".tv.playurl"));
        aVar.field_playstatid = be.ma((String) q.get(str2 + ".tv.playurl$statid"));
        aVar.field_source = be.ma((String) q.get(str2 + ".tv.source"));
        aVar.iEd = a.i(q, str2 + ".tv");
        aVar.field_xml = str;
        return aVar;
    }

    public static String b(a aVar) {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("<tv>");
        if (!be.kS(aVar.field_id)) {
            stringBuilder.append("<id>" + be.KJ(aVar.field_id) + "</id>");
        }
        stringBuilder.append("<title>" + be.KJ(aVar.field_title) + "</title>");
        stringBuilder.append("<subtitle>" + be.KJ(aVar.field_subtitle) + "</subtitle>");
        stringBuilder.append("<topic>" + be.KJ(aVar.field_topic) + "</topic>");
        stringBuilder.append("<thumburl>" + be.KJ(aVar.field_thumburl) + "</thumburl>");
        stringBuilder.append("<shareurl>" + be.KJ(aVar.field_shareurl) + "</shareurl>");
        if (be.kS(aVar.field_playstatid)) {
            stringBuilder.append("<playurl>" + be.KJ(aVar.field_playurl) + "</playurl>");
        } else {
            stringBuilder.append("<playurl statid=\"" + aVar.field_playstatid + "\">" + be.KJ(aVar.field_playurl) + "</playurl>");
        }
        stringBuilder.append("<source>" + be.KJ(aVar.field_source) + "</source>");
        stringBuilder.append("</tv>");
        return stringBuilder.toString();
    }

    public static String a(Context context, a aVar) {
        com.tencent.mm.q.a.a aVar2 = new com.tencent.mm.q.a.a();
        aVar2.title = aVar.field_title;
        if (be.kS(aVar.field_topic)) {
            aVar2.description = aVar.field_subtitle;
        } else {
            aVar2.description = aVar.field_topic;
        }
        aVar2.type = 20;
        aVar2.url = aVar.field_shareurl;
        aVar2.bXP = "";
        if (k.aNM()) {
            aVar2.appName = context.getString(2131234798);
            aVar2.appId = "wxaf060266bfa9a35c";
        }
        aVar2.thumburl = aVar.field_thumburl;
        aVar2.coB = b(aVar);
        return com.tencent.mm.q.a.a.b(aVar2);
    }
}
