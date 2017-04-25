package com.tencent.mm.platformtools;

import android.content.Context;
import android.os.Build.VERSION;
import android.widget.ListView;

@Deprecated
public final class a {

    public static class a {
        public static int a(Context context, float f) {
            b bVar = new b();
            return Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * f) / 160.0f);
        }
    }

    public static class b {
        public static void a(ListView listView) {
            if (VERSION.SDK_INT >= 8) {
                o oVar = new o();
                if (listView.getFirstVisiblePosition() > 10) {
                    listView.setSelection(10);
                }
                if (VERSION.SDK_INT >= 8) {
                    listView.smoothScrollToPosition(0);
                    return;
                }
                return;
            }
            n nVar = new n();
            listView.setSelection(0);
        }
    }
}
