package com.tencent.mm.plugin.scanner.b;

public final class m {
    private static m iEa;
    byte[] iEb = null;
    byte[] iEc = null;

    private m() {
    }

    public static m aLZ() {
        if (iEa == null) {
            iEa = new m();
        }
        return iEa;
    }
}
