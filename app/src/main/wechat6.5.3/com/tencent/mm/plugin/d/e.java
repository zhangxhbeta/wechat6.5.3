package com.tencent.mm.plugin.d;

import com.tencent.mm.app.k;
import com.tencent.mm.kernel.a.d;
import com.tencent.mm.kernel.plugin.ProcessProfile;

public final class e extends d {
    public final void execute(ProcessProfile processProfile) {
        k.a(processProfile.application());
    }

    public final String name() {
        return "boot-svg-init";
    }
}
