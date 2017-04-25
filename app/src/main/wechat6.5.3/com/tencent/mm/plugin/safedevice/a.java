package com.tencent.mm.plugin.safedevice;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;

public final class a implements i {
    public static h drp;
    private static g drq;

    public final void a(h hVar) {
        drp = hVar;
    }

    public final void a(g gVar) {
        drq = gVar;
    }

    public static void a(Context context, Intent intent, Intent intent2) {
        drp.a(context, intent, intent2);
    }
}
