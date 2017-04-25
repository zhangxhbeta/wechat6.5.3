package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class k<T extends IInterface> implements com.google.android.gms.common.api.a.b, com.google.android.gms.common.internal.l.a {
    public static final String[] aoR = new String[]{"service_esmobile", "service_googleme"};
    private final Account ajj;
    private final Looper akP;
    private final com.google.android.gms.common.b akQ;
    private final Set<Scope> akY;
    private final h alI;
    private final m aoF;
    private final Object aoG;
    private s aoH;
    private com.google.android.gms.common.api.c.e aoI;
    private T aoJ;
    private final ArrayList<c<?>> aoK;
    private e aoL;
    private int aoM;
    private final com.google.android.gms.common.api.c.b aoN;
    private final com.google.android.gms.common.api.c.c aoO;
    private final int aoP;
    protected AtomicInteger aoQ;
    public final Context mContext;
    final Handler mHandler;

    final class b extends Handler {
        final /* synthetic */ k aoT;

        public b(k kVar, Looper looper) {
            this.aoT = kVar;
            super(looper);
        }

        private static void a(Message message) {
            ((c) message.obj).unregister();
        }

        private static boolean b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5 || message.what == 6;
        }

        public final void handleMessage(Message message) {
            PendingIntent pendingIntent = null;
            if (this.aoT.aoQ.get() != message.arg1) {
                if (b(message)) {
                    a(message);
                }
            } else if ((message.what == 1 || message.what == 5 || message.what == 6) && !this.aoT.isConnecting()) {
                a(message);
            } else if (message.what == 3) {
                if (message.obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) message.obj;
                }
                this.aoT.aoI.b(new ConnectionResult(message.arg2, pendingIntent));
                k.jQ();
            } else if (message.what == 4) {
                this.aoT.a(4, null);
                if (this.aoT.aoN != null) {
                    this.aoT.aoN.bH(message.arg2);
                }
                int i = message.arg2;
                k.jP();
                this.aoT.a(4, 1, null);
            } else if (message.what == 2 && !this.aoT.isConnected()) {
                a(message);
            } else if (b(message)) {
                ((c) message.obj).jV();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle this message.");
            }
        }
    }

    protected abstract class c<TListener> {
        private TListener amx;
        final /* synthetic */ k aoT;
        private boolean aoU = false;

        public c(k kVar, TListener tListener) {
            this.aoT = kVar;
            this.amx = tListener;
        }

        protected abstract void X(TListener tListener);

        public final void jV() {
            synchronized (this) {
                Object obj = this.amx;
                if (this.aoU) {
                    new StringBuilder("Callback proxy ").append(this).append(" being reused. This is not safe.");
                }
            }
            if (obj != null) {
                try {
                    X(obj);
                } catch (RuntimeException e) {
                    throw e;
                }
            }
            synchronized (this) {
                this.aoU = true;
            }
            unregister();
        }

        public final void jW() {
            synchronized (this) {
                this.amx = null;
            }
        }

        public final void unregister() {
            jW();
            synchronized (this.aoT.aoK) {
                this.aoT.aoK.remove(this);
            }
        }
    }

    public final class e implements ServiceConnection {
        final /* synthetic */ k aoT;
        private final int aoW;

        public e(k kVar, int i) {
            this.aoT = kVar;
            this.aoW = i;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            w.h(iBinder, "Expecting a valid IBinder");
            this.aoT.aoH = com.google.android.gms.common.internal.s.a.i(iBinder);
            k kVar = this.aoT;
            kVar.mHandler.sendMessage(kVar.mHandler.obtainMessage(6, this.aoW, -1, new h(kVar)));
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            this.aoT.mHandler.sendMessage(this.aoT.mHandler.obtainMessage(4, this.aoW, 1));
        }
    }

    private abstract class a extends c<Boolean> {
        public final Bundle aoS;
        final /* synthetic */ k aoT;
        public final int statusCode;

        protected a(k kVar, int i, Bundle bundle) {
            this.aoT = kVar;
            super(kVar, Boolean.valueOf(true));
            this.statusCode = i;
            this.aoS = bundle;
        }

        protected final /* synthetic */ void X(Object obj) {
            PendingIntent pendingIntent = null;
            if (((Boolean) obj) == null) {
                this.aoT.a(1, null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    if (!jU()) {
                        this.aoT.a(1, null);
                        h(new ConnectionResult(8, null));
                        return;
                    }
                    return;
                case 10:
                    this.aoT.a(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    this.aoT.a(1, null);
                    if (this.aoS != null) {
                        pendingIntent = (PendingIntent) this.aoS.getParcelable("pendingIntent");
                    }
                    h(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        protected abstract void h(ConnectionResult connectionResult);

        protected abstract boolean jU();
    }

    protected class f implements com.google.android.gms.common.api.c.e {
        final /* synthetic */ k aoT;

        public f(k kVar) {
            this.aoT = kVar;
        }

        public final void b(ConnectionResult connectionResult) {
            if (connectionResult.iY()) {
                this.aoT.a(null, this.aoT.akY);
            } else if (this.aoT.aoO != null) {
                this.aoT.aoO.a(connectionResult);
            }
        }

        public final void c(ConnectionResult connectionResult) {
            throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
        }
    }

    public static final class d extends com.google.android.gms.common.internal.r.a {
        private k aoV;
        private final int aoW;

        public d(k kVar, int i) {
            this.aoV = kVar;
            this.aoW = i;
        }

        public final void a(int i, IBinder iBinder, Bundle bundle) {
            w.h(this.aoV, "onPostInitComplete can be called only once per call to getRemoteService");
            this.aoV.a(i, iBinder, bundle, this.aoW);
            this.aoV = null;
        }

        public final void b(int i, Bundle bundle) {
            w.h(this.aoV, "onAccountValidationComplete can be called only once per call to validateAccount");
            k kVar = this.aoV;
            kVar.mHandler.sendMessage(kVar.mHandler.obtainMessage(5, this.aoW, -1, new i(kVar, i, bundle)));
            this.aoV = null;
        }
    }

    protected final class g extends a {
        final /* synthetic */ k aoT;
        public final IBinder aoX;

        public g(k kVar, int i, IBinder iBinder, Bundle bundle) {
            this.aoT = kVar;
            super(kVar, i, bundle);
            this.aoX = iBinder;
        }

        protected final void h(ConnectionResult connectionResult) {
            if (this.aoT.aoO != null) {
                this.aoT.aoO.a(connectionResult);
            }
            k.jQ();
        }

        protected final boolean jU() {
            try {
                String interfaceDescriptor = this.aoX.getInterfaceDescriptor();
                if (this.aoT.jg().equals(interfaceDescriptor)) {
                    IInterface f = this.aoT.f(this.aoX);
                    if (f == null || !this.aoT.a(2, 3, f)) {
                        return false;
                    }
                    if (this.aoT.aoN != null) {
                        this.aoT.aoN.g(null);
                    }
                    return true;
                }
                new StringBuilder("service descriptor mismatch: ").append(this.aoT.jg()).append(" vs. ").append(interfaceDescriptor);
                return false;
            } catch (RemoteException e) {
                return false;
            }
        }
    }

    protected final class h extends a {
        final /* synthetic */ k aoT;

        public h(k kVar) {
            this.aoT = kVar;
            super(kVar, 0, null);
        }

        protected final void h(ConnectionResult connectionResult) {
            this.aoT.aoI.b(connectionResult);
            k.jQ();
        }

        protected final boolean jU() {
            this.aoT.aoI.b(ConnectionResult.akm);
            return true;
        }
    }

    protected final class i extends a {
        final /* synthetic */ k aoT;

        public i(k kVar, int i, Bundle bundle) {
            this.aoT = kVar;
            super(kVar, i, bundle);
        }

        protected final void h(ConnectionResult connectionResult) {
            this.aoT.aoI.c(connectionResult);
            k.jQ();
        }

        protected final boolean jU() {
            this.aoT.aoI.c(ConnectionResult.akm);
            return true;
        }
    }

    public k(Context context, Looper looper, int i, h hVar, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.c cVar) {
        this(context, looper, m.A(context), com.google.android.gms.common.b.iZ(), i, hVar, (com.google.android.gms.common.api.c.b) w.Z(bVar), (com.google.android.gms.common.api.c.c) w.Z(cVar));
    }

    private k(Context context, Looper looper, m mVar, com.google.android.gms.common.b bVar, int i, h hVar, com.google.android.gms.common.api.c.b bVar2, com.google.android.gms.common.api.c.c cVar) {
        this.aoG = new Object();
        this.aoK = new ArrayList();
        this.aoM = 1;
        this.aoQ = new AtomicInteger(0);
        this.mContext = (Context) w.h(context, "Context must not be null");
        this.akP = (Looper) w.h(looper, "Looper must not be null");
        this.aoF = (m) w.h(mVar, "Supervisor must not be null");
        this.akQ = (com.google.android.gms.common.b) w.h(bVar, "API availability must not be null");
        this.mHandler = new b(this, looper);
        this.aoP = i;
        this.alI = (h) w.Z(hVar);
        this.ajj = hVar.ajj;
        this.akY = b(hVar.aoy);
        this.aoN = bVar2;
        this.aoO = cVar;
    }

    private void a(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        w.ab(z);
        synchronized (this.aoG) {
            this.aoM = i;
            this.aoJ = t;
            switch (i) {
                case 1:
                    if (this.aoL != null) {
                        this.aoF.b(jf(), jO(), this.aoL, this.alI.akI);
                        this.aoL = null;
                        break;
                    }
                    break;
                case 2:
                    if (this.aoL != null) {
                        new StringBuilder("Calling connect() while still connected, missing disconnect() for ").append(jf()).append(" on ").append(jO());
                        this.aoF.b(jf(), jO(), this.aoL, this.alI.akI);
                        this.aoQ.incrementAndGet();
                    }
                    this.aoL = new e(this, this.aoQ.get());
                    if (!this.aoF.a(jf(), jO(), this.aoL, this.alI.akI)) {
                        new StringBuilder("unable to connect to service: ").append(jf()).append(" on ").append(jO());
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.aoQ.get(), 9));
                        break;
                    }
                    break;
            }
        }
    }

    private boolean a(int i, int i2, T t) {
        boolean z;
        synchronized (this.aoG) {
            if (this.aoM != i) {
                z = false;
            } else {
                a(i2, (IInterface) t);
                z = true;
            }
        }
        return z;
    }

    private static Set<Scope> b(Set<Scope> set) {
        if (set != null) {
            for (Scope contains : set) {
                if (!set.contains(contains)) {
                    throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
                }
            }
        }
        return set;
    }

    protected static void jP() {
    }

    protected static void jQ() {
    }

    private void jR() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.aoQ.get(), 1));
    }

    public void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new g(this, i, iBinder, bundle)));
    }

    public void a(com.google.android.gms.common.api.c.e eVar) {
        this.aoI = (com.google.android.gms.common.api.c.e) w.h(eVar, "Connection progress callbacks cannot be null.");
        a(2, null);
    }

    public final void a(com.google.android.gms.common.api.c.e eVar, ConnectionResult connectionResult) {
        this.aoI = (com.google.android.gms.common.api.c.e) w.h(eVar, "Connection progress callbacks cannot be null.");
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.aoQ.get(), connectionResult.akn, connectionResult.ako));
    }

    public final void a(p pVar) {
        try {
            this.aoH.a(new d(this, this.aoQ.get()), new ValidateAccountRequest(pVar, (Scope[]) this.akY.toArray(new Scope[this.akY.size()]), this.mContext.getPackageName(), null));
        } catch (DeadObjectException e) {
            jR();
        } catch (RemoteException e2) {
        }
    }

    public final void a(p pVar, Set<Scope> set) {
        try {
            Bundle jS = jS();
            GetServiceRequest getServiceRequest = new GetServiceRequest(this.aoP);
            getServiceRequest.anO = this.mContext.getPackageName();
            getServiceRequest.anR = jS;
            if (set != null) {
                getServiceRequest.anQ = (Scope[]) set.toArray(new Scope[set.size()]);
            }
            if (jd()) {
                getServiceRequest.anS = this.ajj != null ? this.ajj : new Account("<<default account>>", "com.google");
                if (pVar != null) {
                    getServiceRequest.anP = pVar.asBinder();
                }
            }
            this.aoH.a(new d(this, this.aoQ.get()), getServiceRequest);
        } catch (DeadObjectException e) {
            jR();
        } catch (RemoteException e2) {
        }
    }

    public final void a(String str, PrintWriter printWriter) {
        synchronized (this.aoG) {
            int i = this.aoM;
            IInterface iInterface = this.aoJ;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("CONNECTING");
                break;
            case 3:
                printWriter.print("CONNECTED");
                break;
            case 4:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.println("null");
        } else {
            printWriter.append(jg()).append("@").println(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
    }

    public void disconnect() {
        this.aoQ.incrementAndGet();
        synchronized (this.aoK) {
            int size = this.aoK.size();
            for (int i = 0; i < size; i++) {
                ((c) this.aoK.get(i)).jW();
            }
            this.aoK.clear();
        }
        a(1, null);
    }

    public abstract T f(IBinder iBinder);

    public final boolean isConnected() {
        boolean z;
        synchronized (this.aoG) {
            z = this.aoM == 3;
        }
        return z;
    }

    public final boolean isConnecting() {
        boolean z;
        synchronized (this.aoG) {
            z = this.aoM == 2;
        }
        return z;
    }

    public String jO() {
        return "com.google.android.gms";
    }

    public Bundle jS() {
        return new Bundle();
    }

    public final T jT() {
        T t;
        synchronized (this.aoG) {
            if (this.aoM == 4) {
                throw new DeadObjectException();
            } else if (isConnected()) {
                w.a(this.aoJ != null, "Client is connected but service is null");
                t = this.aoJ;
            } else {
                throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
            }
        }
        return t;
    }

    public boolean jd() {
        return false;
    }

    public boolean je() {
        return true;
    }

    public abstract String jf();

    public abstract String jg();
}
