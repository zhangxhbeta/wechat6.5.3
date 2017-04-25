package com.tencent.mm.plugin.wear.model.e;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class f extends a {
    public final List<Integer> bhU() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11016));
        arrayList.add(Integer.valueOf(11017));
        arrayList.add(Integer.valueOf(11018));
        return arrayList;
    }

    protected final byte[] l(int i, byte[] bArr) {
        String str;
        String str2 = "";
        try {
            str = new String(bArr, "utf8");
        } catch (UnsupportedEncodingException e) {
            str = str2;
        }
        if (be.kS(str)) {
            v.i("MicroMsg.Wear.HttpFriendServer", "error to get username");
        } else {
            v.i("MicroMsg.Wear.HttpFriendServer", "handle friend request %s", new Object[]{str});
            Intent intent;
            if (i == 11016) {
                intent = new Intent();
                intent.setClassName(aa.getPackageName(), aa.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
                intent.putExtra("friend_message_transfer_username", str);
                intent.setAction("friend_message_accept_" + str);
                intent.setFlags(335544320);
                aa.getContext().startActivity(intent);
            } else if (i == 11017) {
                intent = new Intent();
                intent.setClassName(aa.getPackageName(), aa.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
                intent.putExtra("friend_message_transfer_username", str);
                intent.setAction("friend_message_ignore_" + str);
                intent.setFlags(335544320);
                aa.getContext().startActivity(intent);
            } else if (i == 11018) {
                Intent intent2 = new Intent();
                intent2.setClassName(aa.getPackageName(), aa.getPackageName() + ".plugin.subapp.ui.friend.FMessageConversationUI");
                intent2.setFlags(335544320);
                aa.getContext().startActivity(intent2);
            }
        }
        return null;
    }
}
