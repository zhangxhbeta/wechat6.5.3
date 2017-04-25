package com.tencent.mm.plugin.game.c;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class a {
    private static String TAG = "MicroMsg.GameABTestStrategy";

    public static class a {
        public int bkU = 0;
        public String url = "";
    }

    public static a ara() {
        a aVar = new a();
        c Ls = com.tencent.mm.model.c.c.Au().Ls("100001");
        if (Ls.isValid()) {
            Map buX = Ls.buX();
            aVar.bkU = be.getInt((String) buX.get("game_homepage_jump"), 0);
            String str = (String) buX.get("game_homepage_url");
            if (str == null) {
                str = "";
            }
            aVar.url = str;
            v.i(TAG, "getIndexABTestInfo success, layerId = %s, flag = %d, url = %s", new Object[]{Ls.field_layerId, Integer.valueOf(aVar.bkU), aVar.url});
            return aVar;
        }
        v.e(TAG, "getIndexABTestInfo is timeout,startTime: %d, endTime: %d", new Object[]{Long.valueOf(Ls.field_startTime), Long.valueOf(Ls.field_endTime)});
        return aVar;
    }

    public static a uc(String str) {
        a aVar = new a();
        if (be.kS(str)) {
            v.e(TAG, "appid is null");
            return aVar;
        }
        c Ls = com.tencent.mm.model.c.c.Au().Ls("100002");
        if (Ls.isValid()) {
            v.i(TAG, "getDetailABTestInfo success, layerId = %s", new Object[]{Ls.field_layerId});
            Map buX = Ls.buX();
            aVar.bkU = be.getInt((String) buX.get("game_detail_jump"), 0);
            String str2 = (String) buX.get("game_detail_url");
            aVar.url = str2 == null ? "" : str2 + str;
            return aVar;
        }
        v.e(TAG, "getDetailABTestInfo is timeout,startTime: %d, endTime: %d", new Object[]{Long.valueOf(Ls.field_startTime), Long.valueOf(Ls.field_endTime)});
        return aVar;
    }

    public static a arb() {
        a aVar = new a();
        c Ls = com.tencent.mm.model.c.c.Au().Ls("100003");
        if (Ls.isValid()) {
            v.i(TAG, "getLibraryABTestInfo success, layerId = %s", new Object[]{Ls.field_layerId});
            Map buX = Ls.buX();
            aVar.bkU = be.getInt((String) buX.get("game_library_jump"), 0);
            String str = (String) buX.get("game_library_url");
            if (str == null) {
                str = "";
            }
            aVar.url = str;
            return aVar;
        }
        v.e(TAG, "getLibraryABTestInfo is timeout,startTime: %d, endTime: %d", new Object[]{Long.valueOf(Ls.field_startTime), Long.valueOf(Ls.field_endTime)});
        return aVar;
    }

    public static a arc() {
        a aVar = new a();
        c Ls = com.tencent.mm.model.c.c.Au().Ls("100022");
        if (!Ls.isValid()) {
            return aVar;
        }
        Map buX = Ls.buX();
        aVar.bkU = be.getInt((String) buX.get("game_message_jump"), 0);
        String str = (String) buX.get("game_message_url");
        if (str == null) {
            str = "";
        }
        aVar.url = str;
        return aVar;
    }
}
