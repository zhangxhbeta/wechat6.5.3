package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.c.m;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.w;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface c {

    public static final class a {
        private Account ajj;
        public final Set<Scope> akE = new HashSet();
        private int akF;
        private View akG;
        private String akH;
        private String akI;
        private final Map<a<?>, com.google.android.gms.common.internal.h.a> akJ = new m();
        public final Map<a<?>, Object> akK = new m();
        public FragmentActivity akL;
        public int akM = -1;
        public int akN = -1;
        public c akO;
        public Looper akP;
        public com.google.android.gms.common.b akQ = com.google.android.gms.common.b.iZ();
        public com.google.android.gms.common.api.a.a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.e> akR = com.google.android.gms.signin.b.aBG;
        public final ArrayList<b> akS = new ArrayList();
        public final ArrayList<c> akT = new ArrayList();
        private com.google.android.gms.signin.e.a akU = new com.google.android.gms.signin.e.a();
        public final Context mContext;

        class AnonymousClass1 implements Runnable {
            final /* synthetic */ c akV;
            final /* synthetic */ a akW;

            public AnonymousClass1(a aVar, c cVar) {
                this.akW = aVar;
                this.akV = cVar;
            }

            public final void run() {
                if (!this.akW.akL.isFinishing() && !this.akW.akL.aS().isDestroyed()) {
                    this.akW.a(u.b(this.akW.akL), this.akV);
                }
            }
        }

        public a(Context context) {
            this.mContext = context;
            this.akP = context.getMainLooper();
            this.akH = context.getPackageName();
            this.akI = context.getClass().getName();
        }

        public final void a(u uVar, c cVar) {
            int i = this.akM;
            c cVar2 = this.akO;
            w.h(cVar, "GoogleApiClient instance cannot be null");
            w.a(uVar.amC.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
            uVar.amC.put(i, new a(uVar, i, cVar, cVar2));
            if (uVar.rm && !uVar.amy) {
                cVar.connect();
            }
        }

        public final h jk() {
            return new h(this.ajj, this.akE, this.akJ, this.akF, this.akG, this.akH, this.akI, this.akU.lE());
        }
    }

    public interface b {
        void bH(int i);

        void g(Bundle bundle);
    }

    public interface c {
        void a(ConnectionResult connectionResult);
    }

    public interface d {

        public static class a {
            public boolean akX;
            public Set<Scope> akY;
        }

        a jl();

        boolean jm();
    }

    public interface e {
        void b(ConnectionResult connectionResult);

        void c(ConnectionResult connectionResult);
    }

    ConnectionResult a(TimeUnit timeUnit);

    <A extends com.google.android.gms.common.api.a.b, R extends g, T extends com.google.android.gms.common.api.k.a<R, A>> T a(T t);

    void a(b bVar);

    void a(c cVar);

    void a(String str, PrintWriter printWriter);

    void b(b bVar);

    void b(c cVar);

    void connect();

    void disconnect();

    Looper getLooper();

    boolean isConnected();

    boolean isConnecting();
}
