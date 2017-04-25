package com.tencent.mm.plugin.card.b;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build.VERSION;

public final class n {
    public static void O(Context context, String str) {
        if (VERSION.SDK_INT >= 11) {
            l lVar = new l();
            ((ClipboardManager) context.getSystemService("clipboard")).setText(str);
            return;
        }
        m mVar = new m();
        ((android.text.ClipboardManager) context.getSystemService("clipboard")).setText(str);
    }
}
