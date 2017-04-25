package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class InstallReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            String action = intent.getAction();
            v.i("MicroMsg.InstallReceiver", "action:[%s]", action);
            if (be.kS(action) || !action.equals("com.android.vending.INSTALL_REFERRER")) {
                v.e("MicroMsg.InstallReceiver", "action is null or nil, or not the installed action");
                return;
            }
            action = SQLiteDatabase.KeyEmpty;
            try {
                action = intent.getStringExtra("referrer");
            } catch (Throwable e) {
                v.e("MicroMsg.InstallReceiver", "%s", be.e(e));
            }
            v.i("MicroMsg.InstallReceiver", "get referer:[%s]", action);
            if (be.kS(action)) {
                v.e("MicroMsg.InstallReceiver", "get referer is null or nil");
                return;
            }
            v.d("MicroMsg.InstallReceiver", "[PREF] write installreferer = " + action);
            context.getSharedPreferences(aa.bti(), 0).edit().putString("installreferer", action).commit();
        }
    }
}
