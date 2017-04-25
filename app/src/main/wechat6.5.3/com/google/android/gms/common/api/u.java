package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.k;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class u extends Fragment implements OnCancelListener {
    private ConnectionResult amA;
    private final Handler amB = new Handler(Looper.getMainLooper());
    final SparseArray<a> amC = new SparseArray();
    boolean amy;
    private int amz = -1;
    boolean rm;

    private class b implements Runnable {
        final /* synthetic */ u amG;
        private final int amH;
        private final ConnectionResult amI;

        public b(u uVar, int i, ConnectionResult connectionResult) {
            this.amG = uVar;
            this.amH = i;
            this.amI = connectionResult;
        }

        public final void run() {
            if (this.amG.rm && !this.amG.amy) {
                this.amG.amy = true;
                this.amG.amz = this.amH;
                this.amG.amA = this.amI;
                if (this.amI.iX()) {
                    try {
                        this.amI.a(this.amG.aG(), ((this.amG.aG().aS().aX().indexOf(this.amG) + 1) << 16) + 1);
                    } catch (SendIntentException e) {
                        this.amG.jE();
                    }
                } else if (e.bF(this.amI.akn)) {
                    e.a(this.amI.akn, this.amG.aG(), this.amG, this.amG);
                } else {
                    this.amG.a(this.amH, this.amI);
                }
            }
        }
    }

    private class a implements c {
        public final int amD;
        public final c amE;
        public final c amF;
        final /* synthetic */ u amG;

        public a(u uVar, int i, c cVar, c cVar2) {
            this.amG = uVar;
            this.amD = i;
            this.amE = cVar;
            this.amF = cVar2;
            cVar.a((c) this);
        }

        public final void a(ConnectionResult connectionResult) {
            this.amG.amB.post(new b(this.amG, this.amD, connectionResult));
        }
    }

    public static u a(FragmentActivity fragmentActivity) {
        w.V("Must be called from main thread of process");
        try {
            u uVar = (u) fragmentActivity.aS().k("GmsSupportLifecycleFragment");
            return (uVar == null || uVar.oO) ? null : uVar;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", e);
        }
    }

    private void a(int i, ConnectionResult connectionResult) {
        a aVar = (a) this.amC.get(i);
        if (aVar != null) {
            c cVar = (a) this.amC.get(i);
            this.amC.remove(i);
            if (cVar != null) {
                cVar.amE.b(cVar);
                cVar.amE.disconnect();
            }
            c cVar2 = aVar.amF;
            if (cVar2 != null) {
                cVar2.a(connectionResult);
            }
        }
        jE();
    }

    public static u b(FragmentActivity fragmentActivity) {
        u a = a(fragmentActivity);
        k aS = fragmentActivity.aS();
        if (a != null) {
            return a;
        }
        Fragment uVar = new u();
        aS.aW().a(uVar, "GmsSupportLifecycleFragment").commitAllowingStateLoss();
        aS.executePendingTransactions();
        return uVar;
    }

    private void jE() {
        this.amy = false;
        this.amz = -1;
        this.amA = null;
        for (int i = 0; i < this.amC.size(); i++) {
            ((a) this.amC.valueAt(i)).amE.connect();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (int i = 0; i < this.amC.size(); i++) {
            a aVar = (a) this.amC.valueAt(i);
            printWriter.append(str).append("GoogleApiClient #").print(aVar.amD);
            printWriter.println(":");
            aVar.amE.a(str + "  ", printWriter);
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.u.onActivityResult(int, int, android.content.Intent):void");
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
        this.rm = true;
        if (!this.amy) {
            for (int i = 0; i < this.amC.size(); i++) {
                ((a) this.amC.valueAt(i)).amE.connect();
            }
        }
    }

    public final void onStop() {
        super.onStop();
        this.rm = false;
        for (int i = 0; i < this.amC.size(); i++) {
            ((a) this.amC.valueAt(i)).amE.disconnect();
        }
    }
}
