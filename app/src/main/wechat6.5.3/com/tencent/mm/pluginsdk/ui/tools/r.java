package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

public final class r {
    private static List<a> lVh = new ArrayList();

    public interface a {
        void bkO();

        void bkP();

        void cP(Context context);

        String getName();
    }

    public static void a(a aVar) {
        if (aVar != null) {
            v.d("MicroMsg.WebViewPluginCenter", "add, plugin name = " + aVar.getName());
            if (!lVh.contains(aVar)) {
                lVh.add(aVar);
            }
        }
    }

    public static List<a> brd() {
        return lVh;
    }

    public static void clear() {
        v.d("MicroMsg.WebViewPluginCenter", "clear");
        lVh.clear();
    }
}
