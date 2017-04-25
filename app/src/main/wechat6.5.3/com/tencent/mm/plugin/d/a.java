package com.tencent.mm.plugin.d;

import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.d;
import com.tencent.mm.kernel.plugin.ProcessProfile;

public final class a extends d {
    public final void execute(ProcessProfile processProfile) {
        k.b("FFmpeg", getClass().getClassLoader());
        k.b("wechatpack", getClass().getClassLoader());
    }

    public final String name() {
        return "boot-load-FFmpeg-and-wechatpack-libraries";
    }
}
