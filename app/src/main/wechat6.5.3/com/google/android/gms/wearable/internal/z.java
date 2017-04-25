package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.wearable.j;
import com.google.android.gms.wearable.j.b;

public final class z implements j {

    public static class a implements b {
        private final Status aDC;
        private final int aFo;

        public a(Status status, int i) {
            this.aDC = status;
            this.aFo = i;
        }

        public final Status jo() {
            return this.aDC;
        }
    }

    public final e<b> a(c cVar, String str, String str2, byte[] bArr) {
        final String str3 = str;
        final String str4 = str2;
        final byte[] bArr2 = bArr;
        return cVar.a(new aw<b>(this, cVar) {
            final /* synthetic */ z aFy;

            protected final /* synthetic */ g b(Status status) {
                return new a(status, -1);
            }

            protected final /* synthetic */ void b(com.google.android.gms.common.api.a.b bVar) {
                ao aoVar = (ao) bVar;
                ((x) aoVar.jT()).a(new g(this), str3, str4, bArr2);
            }
        });
    }
}
