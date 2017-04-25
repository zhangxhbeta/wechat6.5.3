package com.tencent.mm.plugin.sns.h;

import android.os.Message;

public class c implements a {
    protected c() {
    }

    public void enter() {
    }

    public void exit() {
    }

    public boolean i(Message message) {
        return false;
    }

    public final String getName() {
        String name = getClass().getName();
        return name.substring(name.lastIndexOf(36) + 1);
    }
}
