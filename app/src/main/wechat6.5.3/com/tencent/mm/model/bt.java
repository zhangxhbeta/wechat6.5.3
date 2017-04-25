package com.tencent.mm.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mm.h.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.d.b;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;
import java.util.UUID;

public final class bt {
    private Map<String, String> cvM;

    public bt(Map<String, String> map) {
        this.cvM = map;
    }

    public final b Ag() {
        long j;
        String str;
        String str2 = (String) this.cvM.get(".sysmsg.WakenPush.PushContent");
        String str3 = (String) this.cvM.get(".sysmsg.WakenPush.Jump");
        String str4 = (String) this.cvM.get(".sysmsg.WakenPush.ExpiredTime");
        String str5 = (String) this.cvM.get(".sysmsg.WakenPush.Username");
        v.d("MicroMsg.WakenPushMsgExtension", "dzmonster[xml parse of wakenpush,pushContent:%s, jump:%s, expiredTime %s]", str2, str3, str4);
        str4 = j.sU().getValue("WakenPushDeepLinkBitSet");
        v.d("MicroMsg.WakenPushMsgExtension", "dzmonster[config of WakenPushDeepLinkBitSet:%s", str4);
        if (be.kS(str4)) {
            j = 0;
        } else {
            j = be.getLong(str4, 0);
        }
        Bitmap a = com.tencent.mm.u.b.a(str5, false, -1);
        aa oH = ak.oH();
        if (be.kS(str3)) {
            v.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[url is null]");
            str = "com.tencent.mm.ui.LauncherUI";
        } else if ((4 & j) == 4 && str3.startsWith("weixin://dl/moments")) {
            str = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
        } else if ((j & 262144) == 262144 && str3.startsWith("weixin://dl/recommendation")) {
            str = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
        } else {
            v.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[unable to deal with the deep link:%s)", str3);
            str = "com.tencent.mm.ui.LauncherUI";
        }
        Intent intent = new Intent();
        intent.setClassName(aa.getContext(), str);
        intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        intent.putExtra("LauncherUI.Show.Update.DialogMsg", (String) this.cvM.get(".sysmsg.WakenPush.PushContent"));
        if (!str3.equals("weixin://dl/update_newest_version")) {
            intent.putExtra("LauncherUI.Show.Update.Url", (String) this.cvM.get(".sysmsg.WakenPush.Jump"));
        }
        g.iuh.a(405, 32, 1, true);
        Notification a2 = oH.a(PendingIntent.getActivity(aa.getContext(), UUID.randomUUID().hashCode(), intent, 134217728), aa.getContext().getString(2131230720), str2, str2, a, str5);
        a2.flags |= 16;
        ak.oH().a(a2, false);
        return null;
    }
}
