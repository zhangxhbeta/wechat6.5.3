package com.google.android.gms.common.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.internal.w;
import java.util.concurrent.atomic.AtomicReference;

public final class k {

    public interface b<R> {
        void V(R r);
    }

    public static abstract class a<R extends g, A extends com.google.android.gms.common.api.a.b> extends i<R> implements b<R>, e<A> {
        final c<A> akC;
        private AtomicReference<d> alq = new AtomicReference();

        public a(c<A> cVar, c cVar2) {
            super(((c) w.h(cVar2, "GoogleApiClient must not be null")).getLooper());
            this.akC = (c) w.Z(cVar);
        }

        private void a(RemoteException remoteException) {
            c(new Status(remoteException.getLocalizedMessage()));
        }

        public final /* synthetic */ void V(Object obj) {
            super.a((g) obj);
        }

        public final void a(A a) {
            try {
                b(a);
            } catch (RemoteException e) {
                a(e);
                throw e;
            } catch (RemoteException e2) {
                a(e2);
            }
        }

        public final void a(d dVar) {
            this.alq.set(dVar);
        }

        public abstract void b(A a);

        public final void c(Status status) {
            w.b(!status.iY(), "Failed result must not be success");
            a(b(status));
        }

        public final c<A> jb() {
            return this.akC;
        }

        protected final void jq() {
            d dVar = (d) this.alq.getAndSet(null);
            if (dVar != null) {
                dVar.b(this);
            }
        }
    }
}
