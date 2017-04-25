package com.tencent.mm.plugin.emoji.d;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.c;

public class a {
    private static a fas;

    public static a aeQ() {
        if (fas == null) {
            synchronized (a.class) {
                fas = new a();
            }
        }
        return fas;
    }

    public static c rd(String str) {
        c Ls = com.tencent.mm.model.c.c.Au().Ls(str);
        if (Ls.isValid()) {
            return Ls;
        }
        v.i("MicroMsg.emoji.EmojiABTestMgr", "get tab name values is timeout, start time:%d end time:%d", new Object[]{Long.valueOf(Ls.field_startTime), Long.valueOf(Ls.field_endTime)});
        return new c();
    }

    public static String a(c cVar, String str) {
        if (cVar.isValid()) {
            v.i("MicroMsg.emoji.EmojiABTestMgr", "getTabNameValues success, layerId = %s", new Object[]{cVar.field_layerId});
            return (String) cVar.buX().get(str);
        }
        v.i("MicroMsg.emoji.EmojiABTestMgr", "get tab name values is timeout, start time:%d end time:%d", new Object[]{Long.valueOf(cVar.field_startTime), Long.valueOf(cVar.field_endTime)});
        return "";
    }
}
