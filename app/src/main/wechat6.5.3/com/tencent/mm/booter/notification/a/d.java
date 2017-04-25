package com.tencent.mm.booter.notification.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public final class d {
    public Intent OH;

    public static PendingIntent a(Context context, int i, Intent intent) {
        return PendingIntent.getActivity(context, i, intent, 134217728);
    }
}
