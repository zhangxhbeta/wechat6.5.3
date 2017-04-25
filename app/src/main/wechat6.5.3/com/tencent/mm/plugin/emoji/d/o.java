package com.tencent.mm.plugin.emoji.d;

import com.tencent.mm.h.j;
import com.tencent.mm.plugin.appbrand.jsapi.br;
import com.tencent.mm.sdk.platformtools.be;

public final class o {
    public static boolean afj() {
        if ((j.sU().getInt("EmotionRewardOption", 0) & 1) == 1) {
            return false;
        }
        return true;
    }

    public static int afk() {
        return be.getInt(j.sU().getValue("CustomEmojiMaxSize"), br.CTRL_INDEX);
    }
}
