package com.tencent.mm.ui.f;

import android.content.Context;
import java.util.List;

public abstract class b implements f {
    public Context context;
    private int iHJ;
    public com.tencent.mm.ui.f.f.b oPi;

    public b(Context context, com.tencent.mm.ui.f.f.b bVar, int i) {
        this.context = context;
        this.oPi = bVar;
        this.iHJ = i;
    }

    public int boZ() {
        return this.iHJ;
    }

    public static boolean cH(List<? extends Object> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        return true;
    }
}
