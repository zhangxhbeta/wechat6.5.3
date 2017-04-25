package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.d.z;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class o {
    public static g do(Context context) {
        if (be.ah(p.ceJ.cef, SQLiteDatabase.KeyEmpty).equals("surface")) {
            v.i("MicroMsg.VideoViewFactory", "match full type surface");
            return new VideoSurfaceView(context);
        }
        String str = z.get("ro.mediatek.platform");
        Object obj = (str == null || !(str.startsWith("MT") || str.startsWith("mt"))) ? null : 1;
        if (obj != null) {
            v.i("MicroMsg.VideoViewFactory", "IS MTK platform");
            return new VideoSightView(context);
        }
        v.i("MicroMsg.VideoViewFactory", "default settings, use sightview");
        return new VideoSightView(context);
    }
}
