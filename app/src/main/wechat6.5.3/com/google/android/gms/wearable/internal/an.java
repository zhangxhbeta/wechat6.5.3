package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

final class an {

    static abstract class a<T> extends a {
        private com.google.android.gms.common.api.k.b<T> aFB;

        public a(com.google.android.gms.common.api.k.b<T> bVar) {
            this.aFB = bVar;
        }

        public final void ai(T t) {
            com.google.android.gms.common.api.k.b bVar = this.aFB;
            if (bVar != null) {
                bVar.V(t);
                this.aFB = null;
            }
        }
    }

    static final class e extends a {
        e() {
        }

        public final void f(Status status) {
        }
    }

    static final class b extends a<com.google.android.gms.wearable.c.c> {
        public b(com.google.android.gms.common.api.k.b<com.google.android.gms.wearable.c.c> bVar) {
            super(bVar);
        }

        public final void a(DeleteDataItemsResponse deleteDataItemsResponse) {
            ai(new com.google.android.gms.wearable.internal.bg.b(ak.cm(deleteDataItemsResponse.statusCode), deleteDataItemsResponse.aFb));
        }
    }

    static final class c extends a<com.google.android.gms.wearable.m.a> {
        public c(com.google.android.gms.common.api.k.b<com.google.android.gms.wearable.m.a> bVar) {
            super(bVar);
        }

        public final void a(GetConnectedNodesResponse getConnectedNodesResponse) {
            List arrayList = new ArrayList();
            arrayList.addAll(getConnectedNodesResponse.aFk);
            ai(new com.google.android.gms.wearable.internal.ac.a(ak.cm(getConnectedNodesResponse.statusCode), arrayList));
        }
    }

    static final class d extends a<com.google.android.gms.wearable.c.d> {
        public d(com.google.android.gms.common.api.k.b<com.google.android.gms.wearable.c.d> bVar) {
            super(bVar);
        }

        public final void a(GetFdForAssetResponse getFdForAssetResponse) {
            ai(new com.google.android.gms.wearable.internal.bg.c(ak.cm(getFdForAssetResponse.statusCode), getFdForAssetResponse.aFm));
        }
    }

    static final class f extends a<com.google.android.gms.wearable.c.a> {
        private final List<FutureTask<Boolean>> aFC;

        f(com.google.android.gms.common.api.k.b<com.google.android.gms.wearable.c.a> bVar, List<FutureTask<Boolean>> list) {
            super(bVar);
            this.aFC = list;
        }

        public final void a(PutDataResponse putDataResponse) {
            ai(new com.google.android.gms.wearable.internal.bg.a(ak.cm(putDataResponse.statusCode), putDataResponse.aFl));
            if (putDataResponse.statusCode != 0) {
                for (FutureTask cancel : this.aFC) {
                    cancel.cancel(true);
                }
            }
        }
    }

    static final class g extends a<com.google.android.gms.wearable.j.b> {
        public g(com.google.android.gms.common.api.k.b<com.google.android.gms.wearable.j.b> bVar) {
            super(bVar);
        }

        public final void a(SendMessageResponse sendMessageResponse) {
            ai(new com.google.android.gms.wearable.internal.z.a(ak.cm(sendMessageResponse.statusCode), sendMessageResponse.arX));
        }
    }
}
