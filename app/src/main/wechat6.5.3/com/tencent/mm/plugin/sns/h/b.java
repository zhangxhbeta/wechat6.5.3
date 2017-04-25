package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.sdk.platformtools.v;

public class b extends c {
    public final String name = getClass().getSimpleName();

    public void enter() {
        super.enter();
        v.i("LogStateTransitionState", "entering " + this.name);
    }

    public final void exit() {
        super.exit();
        v.i("LogStateTransitionState", "exiting " + this.name);
    }
}
