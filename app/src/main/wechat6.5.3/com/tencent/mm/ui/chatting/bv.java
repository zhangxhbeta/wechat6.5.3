package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ad.a;

final class bv implements a {
    bv() {
    }

    public final void a(a aVar, int i, ChattingUI.a aVar2, at atVar) {
        b bVar = (b) aVar;
        bVar.lts.setText(atVar.field_content);
        Object bundle = new Bundle();
        bundle.putString("chatroom_name", aVar2.bEn());
        bundle.putLong("msg_id", atVar.field_msgId);
        if ((atVar.field_flag & 8) != 0) {
            e.a(bVar.lts, 1, false, bundle);
            bVar.lts.setClickable(true);
        } else {
            e.a(bVar.lts, bundle);
        }
        bVar.lts.invalidate();
    }
}
