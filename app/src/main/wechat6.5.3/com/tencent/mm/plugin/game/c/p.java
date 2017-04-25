package com.tencent.mm.plugin.game.c;

import com.tencent.mm.plugin.game.c.n.g;
import com.tencent.mm.sdk.platformtools.be;
import java.util.Map;

public final class p {
    static String q(Map<String, String> map) {
        return be.ah((String) map.get(".sysmsg.gamecenter.formatcontent"), "");
    }

    static void a(Map<String, String> map, n nVar) {
        nVar.gil.clear();
        String str = ".sysmsg.gamecenter.userinfo";
        int i = 0;
        while (true) {
            String str2;
            if (i == 0) {
                str2 = str;
            } else {
                str2 = str + i;
            }
            if (map.containsKey(str2)) {
                g gVar = new g();
                gVar.userName = be.ah((String) map.get(str2 + ".username"), "");
                gVar.aGX = be.ah((String) map.get(str2 + ".nickname"), "");
                gVar.gjh = be.ah((String) map.get(str2 + ".usericon"), "");
                gVar.gjj = be.ah((String) map.get(str2 + ".badge_icon"), "");
                gVar.gjk = be.ah((String) map.get(str2 + ".$jump_id"), "");
                nVar.gil.add(gVar);
                i++;
            } else {
                return;
            }
        }
    }

    static long r(Map<String, String> map) {
        return be.getLong((String) map.get(".sysmsg.game_control_info.control_flag"), 0);
    }
}
