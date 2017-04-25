package com.tencent.mm.model;

import com.tencent.mm.network.j;

public final class az {
    public static a ctM = null;

    public interface a {
        j zt();
    }

    public static j a(j jVar) {
        return ctM == null ? jVar : ctM.zt();
    }
}
