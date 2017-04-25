package com.tencent.mm.plugin.zero.tasks;

import com.tencent.mars.xlog.Xlog;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.d;
import com.tencent.mm.kernel.plugin.ProcessProfile;
import com.tencent.mm.protocal.MMProtocalJni;

public class LoadProtocolJNITask extends d {
    public void execute(ProcessProfile processProfile) {
        k.b("MMProtocalJni", getClass().getClassLoader());
        MMProtocalJni.setClientPackVersion(com.tencent.mm.protocal.d.lWh);
        MMProtocalJni.setProtocalJniLogLevel(new Xlog().getLogLevel());
        MMProtocalJni.setIsLite(false);
    }

    public String name() {
        return "boot-load-MMProtocalJni-library";
    }
}
