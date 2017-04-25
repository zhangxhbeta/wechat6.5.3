package com.tencent.mm.plugin.location_soso;

import com.tencent.mm.model.ag;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tencentmap.mapsdk.map.g;
import com.tencent.tencentmap.mapsdk.map.g.b;

public class Plugin implements c {
    public static final String TAG = "MicroMsg.Plugin";

    public Plugin() {
        v.d(TAG, "initLoctionInit");
        g.pAe = new b() {
            public void collectErrorInfo(String str) {
                v.i(Plugin.TAG, "error by map " + str);
            }
        };
    }

    public i createApplication() {
        return null;
    }

    public com.tencent.mm.pluginsdk.c.b getContactWidgetFactory() {
        return null;
    }

    public ag createSubCore() {
        return null;
    }
}
