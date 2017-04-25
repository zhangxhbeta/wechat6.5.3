package com.tencent.mm.plugin.emoji.h;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.emoji.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class b {
    private final String TAG = "MicroMsg.emoji.UseSmileyTool";
    public int dRo;
    public String fqT;

    public b(int i) {
        this.dRo = i;
    }

    public static void a(Intent intent, String str, Activity activity) {
        if (intent != null) {
            a(intent.getStringExtra("Select_Conv_User"), str, activity);
        }
    }

    public static void a(String str, String str2, Activity activity) {
        if (be.kS(str)) {
            v.d("MicroMsg.emoji.UseSmileyTool", "talker name is invalid so can't go to chat room use.");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("smiley_product_id", str2);
        a.drp.e(intent, activity);
    }

    public final void q(Activity activity) {
        v.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
        Intent intent = new Intent();
        intent.putExtra("MMActivity.OverrideEnterAnimation", 2130968622);
        intent.putExtra("MMActivity.OverrideExitAnimation", 2130968644);
        c.a(activity, ".ui.transmit.SelectConversationUI", intent, this.dRo);
        activity.overridePendingTransition(2130968646, 2130968623);
    }
}
