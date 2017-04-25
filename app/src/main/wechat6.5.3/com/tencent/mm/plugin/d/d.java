package com.tencent.mm.plugin.d;

import com.tencent.mm.kernel.plugin.ProcessProfile;
import com.tencent.mm.modelsfs.FileOp;

public final class d extends com.tencent.mm.kernel.a.d {
    public final void execute(ProcessProfile processProfile) {
        FileOp.init(com.tencent.mm.kernel.d.b(processProfile));
    }

    public final String name() {
        return "boot-sfs";
    }
}
