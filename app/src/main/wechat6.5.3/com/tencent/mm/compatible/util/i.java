package com.tencent.mm.compatible.util;

import java.security.PrivilegedAction;

public final class i implements PrivilegedAction {
    private String cgv;
    private String cgw;

    public i(String str) {
        this.cgv = str;
    }

    public final Object run() {
        Object property = System.getProperty(this.cgv);
        return property == null ? this.cgw : property;
    }
}
