package com.tencent.mm.network;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mm.model.ak;
import com.tencent.mm.network.n.a;

public final class w extends a {
    public final void reportKV(long j, String str, boolean z, boolean z2) {
        final boolean z3 = z;
        final long j2 = j;
        final String str2 = str;
        final boolean z4 = z2;
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ w dmk;

            public final void run() {
                if (z3) {
                    SmcLogic.writeImportKvData(j2, str2, z4);
                } else {
                    SmcLogic.writeKvData(j2, str2, z4);
                }
            }

            public final String toString() {
                return super.toString() + "|reportKV";
            }
        });
    }
}
