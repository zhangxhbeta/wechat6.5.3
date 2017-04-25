package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.card.a;
import com.tencent.mm.plugin.card.ui.CardNewMsgUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public final class b {
    public static void a(MMActivity mMActivity, boolean z) {
        Intent intent = new Intent(mMActivity, CardNewMsgUI.class);
        intent.putExtra("from_menu", z);
        mMActivity.startActivity(intent);
        v.v("MicroMsg.CardActivityHelper", "start CardNewMsgUI");
        g.iuh.h(11324, new Object[]{"CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), ""});
    }

    public static void L(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            v.v("MicroMsg.CardActivityHelper", "username is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        intent.putExtra("force_get_contact", true);
        a.drp.d(intent, context);
    }

    public static void M(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            v.v("MicroMsg.CardActivityHelper", "username is null");
        } else if (!m.eC(str)) {
            L(context, str);
        } else if (TextUtils.isEmpty(str)) {
            v.v("MicroMsg.CardActivityHelper", "username is null");
        } else {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", str);
            intent.putExtra("finish_direct", true);
            c.a(context, ".ui.chatting.ChattingUI", intent);
        }
    }

    public static void a(MMActivity mMActivity, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("stastic_scene", i);
        c.b(mMActivity, "webview", ".ui.tools.WebViewUI", intent);
    }

    public static void a(MMActivity mMActivity, float f, float f2, String str) {
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kwebmap_slat", (double) f);
        intent.putExtra("kwebmap_lng", (double) f2);
        intent.putExtra("Kwebmap_locaion", str);
        c.b(mMActivity, "location", ".ui.RedirectUI", intent);
    }

    public static void a(MMActivity mMActivity, int i, MMActivity.a aVar) {
        Intent intent = new Intent();
        intent.putExtra("select_is_ret", false);
        intent.putExtra("Select_Conv_Type", 3);
        c.a(mMActivity, ".ui.transmit.SelectConversationUI", intent, i, aVar);
    }

    public static void a(MMActivity mMActivity, String str) {
        Intent intent = new Intent();
        intent.putExtra("KEY_BRAND_NAME", str);
        c.b(mMActivity, "card", ".ui.CardShowWaringTransparentUI", intent);
    }

    public static void a(MMActivity mMActivity, int i, String str, boolean z, com.tencent.mm.plugin.card.base.b bVar) {
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 3);
        intent.putExtra("key_expire_time", i);
        intent.putExtra("key_begin_time", System.currentTimeMillis());
        intent.putExtra("key_card_tips", str);
        intent.putExtra("key_is_mark", z);
        intent.putExtra("key_card_id", bVar.ZA());
        intent.putExtra("key_user_card_id", bVar.Zz());
        intent.putExtra("key_card_code", bVar.Zw().code);
        c.b(mMActivity, "offline", ".ui.WalletOfflineEntranceUI", intent);
        g.iuh.h(11850, new Object[]{Integer.valueOf(5), Integer.valueOf(0)});
    }
}
