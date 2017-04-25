package com.tencent.mm.ui;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import java.util.ArrayList;
import java.util.List;

public final class x {
    public static List<String> bAI() {
        int xJ = k.xJ();
        List<String> arrayList = new ArrayList();
        if ((xJ & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            arrayList.add("floatbottle");
            v.d("MicroMsg.LauncherUI", "add bottle into show unread count blacklist.");
        }
        ak.yW();
        if (!c.vf().b(a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
            arrayList.add("notifymessage");
            v.d("MicroMsg.UnreadCountHelper", "add service notify message into show unread count blacklist.");
        }
        ak.yW();
        if (!c.vf().b(a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
            arrayList.add("appbrandcustomerservicemsg");
            v.d("MicroMsg.UnreadCountHelper", "add wxa custom session notify message into show unread count blacklist.");
        }
        v.d("MicroMsg.LauncherUI", "getShowUnreadCountBlacklist unread count blacklist(size : %s).", Integer.valueOf(arrayList.size()));
        return arrayList;
    }
}
