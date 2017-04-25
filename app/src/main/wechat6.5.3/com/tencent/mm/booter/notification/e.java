package com.tencent.mm.booter.notification;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.ad;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.sdk.platformtools.aa;
import java.util.LinkedList;
import java.util.Queue;

public final class e extends a {
    public c bZw = new c();
    private Context mContext = aa.getContext();
    private NotificationManager sF = ((NotificationManager) this.mContext.getSystemService("notification"));

    public static void cancel() {
        ad h = ad.h(aa.getContext());
        Queue linkedList = new LinkedList();
        for (Integer num : b.qC().qE()) {
            if (!linkedList.contains(num)) {
                b.qC().a(h, num.intValue());
                linkedList.add(num);
            }
        }
    }
}
