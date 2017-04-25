package com.tencent.mm.plugin.backup.backupmodel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.sdk.platformtools.v;

public class BackupUSBReceiver extends BroadcastReceiver {
    private static String eaP = "MMBakchatServiceStart";
    private static String eaQ = "MMBakchatServiceStop";

    public void onReceive(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            if (eaP.equalsIgnoreCase(action)) {
                context.startService(new Intent(context, BackupUSBService.class).putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL)));
                v.d("MicroMsg.BackupUSBReceiver", "START_ACTION onReceive start end");
            } else if (eaQ.equalsIgnoreCase(action)) {
                b.UP().stop();
                b.UJ().Tz();
                com.tencent.mm.plugin.backup.b.b.clear();
                context.stopService(new Intent(context, BackupUSBService.class));
                v.d("MicroMsg.BackupUSBReceiver", "STOP_ACTION onReceive stop end");
            }
        } catch (Throwable e) {
            v.a("MicroMsg.BackupUSBReceiver", e, "onReceive:", new Object[0]);
        }
    }
}
