package com.tencent.mm.plugin.gif;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class d {
    public final int[] gCp = new int[6];

    public d(String str) {
        try {
            MMGIFJNI.recycle(MMGIFJNI.openByFilePath(str, this.gCp));
            v.i("MMGIFInfo", "width:%d height:%d", Integer.valueOf(this.gCp[0]), Integer.valueOf(this.gCp[1]));
        } catch (Throwable e) {
            v.e("MMGIFInfo", be.e(e));
        }
    }
}
