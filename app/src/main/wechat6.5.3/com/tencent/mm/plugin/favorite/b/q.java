package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.protocal.c.qn;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;

public final class q {
    public static void a(Map<String, String> map, qn qnVar) {
        if (map == null || qnVar == null) {
            v.w("MicroMsg.FavTagParser", "maps is null or item is null");
            return;
        }
        qnVar.mub.clear();
        int i = 0;
        while (i < 1024) {
            String str = (String) map.get(".favitem.taglist.tag" + (i > 0 ? Integer.valueOf(i) : ""));
            if (str == null) {
                break;
            }
            qnVar.mub.add(str);
            i++;
        }
        if (!qnVar.mub.isEmpty()) {
            v.d("MicroMsg.FavTagParser", "user def tag not empty, res=%s", new Object[]{qnVar.mub});
        }
        qnVar.mua.clear();
        i = 0;
        while (i < 1024) {
            str = (String) map.get(".favitem.recommendtaglist.tag" + (i > 0 ? Integer.valueOf(i) : ""));
            if (str == null) {
                break;
            }
            qnVar.mua.add(str);
            i++;
        }
        if (!qnVar.mua.isEmpty()) {
            v.d("MicroMsg.FavTagParser", "recommended tag not empty, res=%s", new Object[]{qnVar.mua});
        }
    }

    public static String a(qn qnVar) {
        int i = 0;
        if (qnVar == null || (qnVar.mub.isEmpty() && qnVar.mua.isEmpty())) {
            v.v("MicroMsg.FavTagParser", "tag list toXml data list empty");
            return "";
        }
        int i2;
        StringBuffer stringBuffer = new StringBuffer();
        int size = qnVar.mub.size();
        stringBuffer.append("<taglist count='").append(size).append("'>");
        for (i2 = 0; i2 < size; i2++) {
            stringBuffer.append("<tag>").append(be.KJ((String) qnVar.mub.get(i2))).append("</tag>");
        }
        stringBuffer.append("</taglist>");
        i2 = qnVar.mua.size();
        stringBuffer.append("<recommendtaglist count='").append(i2).append("'>");
        while (i < i2) {
            stringBuffer.append("<tag>").append(be.KJ((String) qnVar.mua.get(i))).append("</tag>");
            i++;
        }
        stringBuffer.append("</recommendtaglist>");
        return stringBuffer.toString();
    }
}
