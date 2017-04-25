package com.tencent.mm.booter.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;

public class NotificationDeleteReceive extends BroadcastReceiver {
    private NotificationDeleteReceive() {
    }

    public void onReceive(Context context, Intent intent) {
        int intExtra;
        try {
            intExtra = intent.getIntExtra("com.tencent.notification.id.key", -1);
        } catch (Throwable e) {
            v.a("MicroMsg.Notification.Delete.Receive", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            intExtra = -1;
        }
        v.d("MicroMsg.Notification.Delete.Receive", "receive: %d", Integer.valueOf(intExtra));
        if (intExtra != -1) {
            NotificationItem notificationItem;
            Iterator it = b.qC().iterator();
            while (it.hasNext()) {
                notificationItem = (NotificationItem) it.next();
                if (notificationItem != null && notificationItem.id == intExtra) {
                    break;
                }
            }
            notificationItem = null;
            if (notificationItem == null) {
                v.w("MicroMsg.Notification.Delete.Receive", "receive delete notification: %d, but no item in queue", Integer.valueOf(intExtra));
                return;
            }
            if (notificationItem.bZx != null) {
                try {
                    notificationItem.bZx.send();
                } catch (Throwable e2) {
                    v.a("MicroMsg.NotificationItem", e2, "Delete intent send Exception?", new Object[0]);
                }
            }
            b.qC().remove(intExtra);
        }
    }
}
