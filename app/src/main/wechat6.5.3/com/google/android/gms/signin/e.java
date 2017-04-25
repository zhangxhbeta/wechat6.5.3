package com.google.android.gms.signin;

import com.google.android.gms.common.api.c.d;

public final class e {
    public static final e aBN = new a().lE();
    public final boolean aBO;
    public final boolean aBP;
    public final d aBQ;
    public final String akh;

    public static final class a {
        private boolean aBR;
        private boolean aBS;
        private String aBT;
        private d aBU;

        public final e lE() {
            return new e(this.aBR, this.aBS, this.aBT, this.aBU);
        }
    }

    private e(boolean z, boolean z2, String str, d dVar) {
        this.aBO = z;
        this.aBP = z2;
        this.akh = str;
        this.aBQ = dVar;
    }
}
