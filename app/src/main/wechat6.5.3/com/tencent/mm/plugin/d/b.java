package com.tencent.mm.plugin.d;

import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.d;
import com.tencent.mm.kernel.plugin.ProcessProfile;

public final class b extends d {
    public final void execute(ProcessProfile processProfile) {
        k.b("tencentloc", getClass().getClassLoader());
    }

    public final String name() {
        return "boot-load-tencentloc-library";
    }
}
