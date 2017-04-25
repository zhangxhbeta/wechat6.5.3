package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.signin.d;
import com.google.android.gms.signin.e;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public final class i extends k<f> implements d {
    private final boolean aBx;
    private final ExecutorService aBy;
    private final h alI;
    private final e aoA;
    private Integer aoB;

    private static class a extends com.google.android.gms.signin.internal.d.a {
        private final ExecutorService aBy;
        private final e aoA;

        public a(e eVar, ExecutorService executorService) {
            this.aoA = eVar;
            this.aBy = executorService;
        }

        public final void a(final String str, final String str2, final f fVar) {
            this.aBy.submit(new Runnable(this) {
                final /* synthetic */ a aBC;

                public final void run() {
                    try {
                        fVar.ad(this.aBC.aoA.aBQ.jm());
                    } catch (RemoteException e) {
                    }
                }
            });
        }

        public final void a(final String str, final List<Scope> list, final f fVar) {
            this.aBy.submit(new Runnable(this) {
                final /* synthetic */ a aBC;

                public final void run() {
                    try {
                        c.d a = this.aBC.aoA.aBQ;
                        Collections.unmodifiableSet(new HashSet(list));
                        com.google.android.gms.common.api.c.d.a jl = a.jl();
                        fVar.a(new CheckServerAuthResult(jl.akX, jl.akY));
                    } catch (RemoteException e) {
                    }
                }
            });
        }
    }

    public i(Context context, Looper looper, boolean z, h hVar, b bVar, c.c cVar, ExecutorService executorService) {
        super(context, looper, 44, hVar, bVar, cVar);
        this.aBx = z;
        this.alI = hVar;
        this.aoA = hVar.aoA;
        this.aoB = hVar.aoB;
        this.aBy = executorService;
    }

    public final void a(p pVar, Set<Scope> set, e eVar) {
        w.h(eVar, "Expecting a valid ISignInCallbacks");
        try {
            ((f) jT()).a(new AuthAccountRequest(pVar, set), eVar);
        } catch (RemoteException e) {
            try {
                eVar.a(new ConnectionResult(8, null), new AuthAccountResult());
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.");
            }
        }
    }

    public final void a(p pVar, boolean z) {
        try {
            ((f) jT()).a(pVar, this.aoB.intValue(), z);
        } catch (RemoteException e) {
        }
    }

    public final void a(t tVar) {
        w.h(tVar, "Expecting a valid IResolveAccountCallbacks");
        try {
            h hVar = this.alI;
            ((f) jT()).a(new ResolveAccountRequest(hVar.ajj != null ? hVar.ajj : new Account("<<default account>>", "com.google"), this.aoB.intValue()), tVar);
        } catch (RemoteException e) {
            try {
                tVar.a(new ResolveAccountResponse());
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.");
            }
        }
    }

    public final void connect() {
        a(new f(this));
    }

    protected final /* synthetic */ IInterface f(IBinder iBinder) {
        return com.google.android.gms.signin.internal.f.a.p(iBinder);
    }

    protected final Bundle jS() {
        e eVar = this.aoA;
        Integer num = this.alI.aoB;
        ExecutorService executorService = this.aBy;
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", eVar.aBO);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", eVar.aBP);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", eVar.akh);
        if (eVar.aBQ != null) {
            bundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper(new a(eVar, executorService).asBinder()));
        }
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        if (!this.mContext.getPackageName().equals(this.alI.akH)) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", this.alI.akH);
        }
        return bundle;
    }

    public final boolean jd() {
        return this.aBx;
    }

    protected final String jf() {
        return "com.google.android.gms.signin.service.START";
    }

    protected final String jg() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public final void lD() {
        try {
            ((f) jT()).ck(this.aoB.intValue());
        } catch (RemoteException e) {
        }
    }
}
