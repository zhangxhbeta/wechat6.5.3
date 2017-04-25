package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.wearable.l;
import com.google.android.gms.wearable.m;
import java.util.ArrayList;
import java.util.List;

public final class ac implements m {

    public static class a implements com.google.android.gms.wearable.m.a {
        private final Status aDC;
        private final List<l> aFA;

        public a(Status status, List<l> list) {
            this.aDC = status;
            this.aFA = list;
        }

        public final Status jo() {
            return this.aDC;
        }

        public final List<l> mA() {
            return this.aFA;
        }
    }

    public final e<com.google.android.gms.wearable.m.a> a(c cVar) {
        return cVar.a(new aw<com.google.android.gms.wearable.m.a>(this, cVar) {
            final /* synthetic */ ac aFz;

            protected final /* synthetic */ g b(Status status) {
                return new a(status, new ArrayList());
            }

            protected final /* synthetic */ void b(b bVar) {
                ((x) ((ao) bVar).jT()).d(new c(this));
            }
        });
    }
}
