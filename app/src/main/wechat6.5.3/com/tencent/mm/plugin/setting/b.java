package com.tencent.mm.plugin.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.pluginsdk.j.aj;
import com.tencent.mm.pluginsdk.j.p;
import com.tencent.mm.pluginsdk.j.u;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class b implements ag, u {
    public b() {
        v.i("MicroMsg.SubCoreSetting", "SubCoreSetting constructor: " + System.currentTimeMillis());
    }

    @SuppressLint({"UseSparseArrays"})
    public final HashMap<Integer, c> ti() {
        return null;
    }

    public final void ed(int i) {
        v.i("MicroMsg.SubCoreSetting", "SubCoreSetting clearPluginData: " + System.currentTimeMillis());
    }

    public final void aG(boolean z) {
        v.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset: " + System.currentTimeMillis());
        aj.lyc = this;
    }

    public final void aH(boolean z) {
        v.i("MicroMsg.SubCoreSetting", "SubCoreSetting onSdcardMount: " + System.currentTimeMillis());
    }

    public final void th() {
        v.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountRelease: " + System.currentTimeMillis());
    }

    public final p ap(Context context, String str) {
        return new com.tencent.mm.plugin.setting.ui.setting.b(context, str);
    }
}
