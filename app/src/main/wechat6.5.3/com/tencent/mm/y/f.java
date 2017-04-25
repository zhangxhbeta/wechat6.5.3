package com.tencent.mm.y;

import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.v;

public final class f extends w {
    public final void transfer(int i) {
        v.i("MicroMsg.EmojiInfoDataTransfer", "start transfer EmojiInfoStorage and EmojiGroupInfoStorage");
        v.i("MicroMsg.EmojiInfoDataTransfer", "end transfer EmojiInfoStorage and EmojiGroupInfoStorage");
    }

    public final boolean eH(int i) {
        boolean z;
        if (i == 0 || i <= 604372991) {
            z = true;
        } else {
            z = false;
        }
        v.i("MicroMsg.EmojiInfoDataTransfer", "in needTransfer, sVer = %d, result = %b", Integer.valueOf(i), Boolean.valueOf(z));
        return z;
    }

    public final String getTag() {
        return "MicroMsg.EmojiInfoDataTransfer";
    }
}
