package com.tencent.mm.pluginsdk.j;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build.VERSION;

public final class c {
    public static void a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        if (VERSION.SDK_INT >= 11) {
            d dVar = new d();
            ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(charSequence, charSequence2));
            return;
        }
        e eVar = new e();
        ((android.text.ClipboardManager) context.getSystemService("clipboard")).setText(charSequence2);
    }
}
