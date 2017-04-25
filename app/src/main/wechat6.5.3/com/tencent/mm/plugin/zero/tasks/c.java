package com.tencent.mm.plugin.zero.tasks;

import com.tencent.mm.d.a;
import com.tencent.mm.kernel.a.d;
import com.tencent.mm.kernel.plugin.ProcessProfile;

public final class c extends d {
    public final void execute(ProcessProfile processProfile) {
        a.b(processProfile.application(), true);
    }

    public final String name() {
        return "boot-multi-dex-install";
    }
}
