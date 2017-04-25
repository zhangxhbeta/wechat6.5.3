package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.v;

public final class c {
    public e iao;

    public c(String str) {
        this.iao = new e(str, 10);
    }

    public final d aJ(String str, int i) {
        byte[] readFromFile = e.readFromFile(this.iao.iay + aK(str, i));
        if (readFromFile == null || readFromFile.length == 0) {
            return null;
        }
        try {
            return (d) new d().az(readFromFile);
        } catch (Throwable e) {
            v.a("MicroMsg.DraftBoxMgr", e, "", new Object[0]);
            return null;
        }
    }

    public static String aK(String str, int i) {
        if (str != null && str.length() != 0) {
            return str + "_" + i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(com.tencent.mm.model.c.vf().get(9, null)).toString();
    }
}
