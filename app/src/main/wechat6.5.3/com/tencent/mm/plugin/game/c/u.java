package com.tencent.mm.plugin.game.c;

import com.tencent.mm.plugin.game.c.n.c;
import com.tencent.mm.sdk.platformtools.be;
import java.util.Map;

public final class u {
    public static u gjm;

    static u arB() {
        if (gjm == null) {
            gjm = new u();
        }
        return gjm;
    }

    static void b(Map<String, String> map, n nVar) {
        String str = ".sysmsg.gamecenter.jump_info.jump";
        nVar.giq.clear();
        int i = 0;
        while (true) {
            String str2;
            if (i == 0) {
                str2 = str;
            } else {
                str2 = str + i;
            }
            if (map.containsKey(str2)) {
                String str3 = (String) map.get(str2 + ".$id");
                c cVar = new c();
                cVar.gjb = be.getInt((String) map.get(str2 + ".jump_type"), 0);
                cVar.fBu = be.ah((String) map.get(str2 + ".jump_url"), "");
                if (!be.kS(str3)) {
                    nVar.giq.put(str3, cVar);
                }
                i++;
            } else {
                return;
            }
        }
    }

    static void c(Map<String, String> map, n nVar) {
        nVar.giT = be.getInt((String) map.get(".sysmsg.gamecenter.report.msg_subtype"), 0);
        nVar.giU = be.ah((String) map.get(".sysmsg.gamecenter.report.noticeid"), "");
    }
}
