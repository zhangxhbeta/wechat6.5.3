package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.k;
import android.support.v4.app.q;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class v extends Fragment implements OnCancelListener, android.support.v4.app.q.a<ConnectionResult> {
    private ConnectionResult amA;
    private final Handler amB = new Handler(Looper.getMainLooper());
    public final SparseArray<b> amC = new SparseArray();
    private boolean amy;
    private int amz = -1;

    private static class b {
        public final c amE;
        public final com.google.android.gms.common.api.c.c amF;

        private b(c cVar, com.google.android.gms.common.api.c.c cVar2) {
            this.amE = cVar;
            this.amF = cVar2;
        }
    }

    private class c implements Runnable {
        private final int amH;
        private final ConnectionResult amI;
        final /* synthetic */ v amL;

        public c(v vVar, int i, ConnectionResult connectionResult) {
            this.amL = vVar;
            this.amH = i;
            this.amI = connectionResult;
        }

        public final void run() {
            if (this.amI.iX()) {
                try {
                    this.amI.a(this.amL.aG(), ((this.amL.aG().aS().aX().indexOf(this.amL) + 1) << 16) + 1);
                } catch (SendIntentException e) {
                    this.amL.jE();
                }
            } else if (e.bF(this.amI.akn)) {
                e.a(this.amI.akn, this.amL.aG(), this.amL, this.amL);
            } else {
                this.amL.a(this.amH, this.amI);
            }
        }
    }

    static class a extends android.support.v4.content.c<ConnectionResult> implements com.google.android.gms.common.api.c.b, com.google.android.gms.common.api.c.c {
        public final c amE;
        boolean amJ;
        private ConnectionResult amK;

        public a(Context context, c cVar) {
            super(context);
            this.amE = cVar;
        }

        private void g(ConnectionResult connectionResult) {
            this.amK = connectionResult;
            if (this.rm && !this.tl) {
                deliverResult(connectionResult);
            }
        }

        public final void a(ConnectionResult connectionResult) {
            this.amJ = true;
            g(connectionResult);
        }

        public final void bH(int i) {
        }

        public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            super.dump(str, fileDescriptor, printWriter, strArr);
            this.amE.a(str, printWriter);
        }

        public final void g(Bundle bundle) {
            this.amJ = false;
            g(ConnectionResult.akm);
        }

        protected final void onReset() {
            this.amK = null;
            this.amJ = false;
            this.amE.b((com.google.android.gms.common.api.c.b) this);
            this.amE.b((com.google.android.gms.common.api.c.c) this);
            this.amE.disconnect();
        }

        protected final void onStartLoading() {
            super.onStartLoading();
            this.amE.a((com.google.android.gms.common.api.c.b) this);
            this.amE.a((com.google.android.gms.common.api.c.c) this);
            if (this.amK != null) {
                deliverResult(this.amK);
            }
            if (!this.amE.isConnected() && !this.amE.isConnecting() && !this.amJ) {
                this.amE.connect();
            }
        }

        protected final void onStopLoading() {
            this.amE.disconnect();
        }
    }

    private void a(int i, ConnectionResult connectionResult) {
        b bVar = (b) this.amC.get(i);
        if (bVar != null) {
            this.amC.remove(i);
            aJ().destroyLoader(i);
            com.google.android.gms.common.api.c.c cVar = bVar.amF;
            if (cVar != null) {
                cVar.a(connectionResult);
            }
        }
        jE();
    }

    public static v c(FragmentActivity fragmentActivity) {
        w.V("Must be called from main thread of process");
        k aS = fragmentActivity.aS();
        try {
            v vVar = (v) aS.k("GmsSupportLoaderLifecycleFragment");
            if (vVar != null && !vVar.oO) {
                return vVar;
            }
            Fragment vVar2 = new v();
            aS.aW().a(vVar2, "GmsSupportLoaderLifecycleFragment").commit();
            aS.executePendingTransactions();
            return vVar2;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLoaderLifecycleFragment is not a SupportLoaderLifecycleFragment", e);
        }
    }

    private void jE() {
        int i = 0;
        this.amy = false;
        this.amz = -1;
        this.amA = null;
        q aJ = aJ();
        while (i < this.amC.size()) {
            int keyAt = this.amC.keyAt(i);
            a bK = bK(keyAt);
            if (bK != null && bK.amJ) {
                aJ.destroyLoader(keyAt);
                aJ.a(keyAt, this);
            }
            i++;
        }
    }

    public final android.support.v4.content.c<ConnectionResult> K(int i) {
        return new a(aG(), ((b) this.amC.get(i)).amE);
    }

    public final /* synthetic */ void a(android.support.v4.content.c cVar, Object obj) {
        ConnectionResult connectionResult = (ConnectionResult) obj;
        if (!connectionResult.iY()) {
            int i = cVar.dW;
            if (!this.amy) {
                this.amy = true;
                this.amz = i;
                this.amA = connectionResult;
                this.amB.post(new c(this, i, connectionResult));
            }
        }
    }

    public final a bK(int i) {
        try {
            return (a) aJ().J(i);
        } catch (Throwable e) {
            throw new IllegalStateException("Unknown loader in SupportLoaderLifecycleFragment", e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
        r3 = this;
        r0 = 1;
        r1 = 0;
        switch(r4) {
            case 1: goto L_0x0017;
            case 2: goto L_0x000c;
            default: goto L_0x0005;
        };
    L_0x0005:
        r0 = r1;
    L_0x0006:
        if (r0 == 0) goto L_0x001b;
    L_0x0008:
        r3.jE();
    L_0x000b:
        return;
    L_0x000c:
        r2 = r3.aG();
        r2 = com.google.android.gms.common.e.v(r2);
        if (r2 != 0) goto L_0x0005;
    L_0x0016:
        goto L_0x0006;
    L_0x0017:
        r2 = -1;
        if (r5 != r2) goto L_0x0005;
    L_0x001a:
        goto L_0x0006;
    L_0x001b:
        r0 = r3.amz;
        r1 = r3.amA;
        r3.a(r0, r1);
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.v.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        int i = 0;
        while (i < this.amC.size()) {
            int keyAt = this.amC.keyAt(i);
            a bK = bK(keyAt);
            if (bK == null || ((b) this.amC.valueAt(i)).amE == bK.amE) {
                aJ().a(keyAt, this);
            } else {
                aJ().b(keyAt, this);
            }
            i++;
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a(this.amz, new ConnectionResult(13, null));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.amy = bundle.getBoolean("resolving_error", false);
            this.amz = bundle.getInt("failed_client_id", -1);
            if (this.amz >= 0) {
                this.amA = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.amy);
        if (this.amz >= 0) {
            bundle.putInt("failed_client_id", this.amz);
            bundle.putInt("failed_status", this.amA.akn);
            bundle.putParcelable("failed_resolution", this.amA.ako);
        }
    }

    public final void onStart() {
        super.onStart();
        if (!this.amy) {
            for (int i = 0; i < this.amC.size(); i++) {
                aJ().a(this.amC.keyAt(i), this);
            }
        }
    }
}
