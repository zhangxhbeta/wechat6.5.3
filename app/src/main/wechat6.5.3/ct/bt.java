package ct;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;

public final class bt extends PhoneStateListener {
    volatile boolean a;
    private final bk b;
    private CellLocation c = null;
    private SignalStrength d = null;
    private ServiceState e = null;
    private long f;
    private HandlerThread g;
    private Handler h;

    final class a extends Handler {
        private /* synthetic */ bt a;

        private a(bt btVar, Looper looper) {
            this.a = btVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.a.a) {
                sendEmptyMessageDelayed(0, 20000);
                this.a.onCellLocationChanged(ct.b(this.a.b));
            }
        }
    }

    static class b implements Runnable {
        private bk a;
        private cg b;

        public b(bk bkVar) {
            this.a = bkVar;
        }

        public final void a(cg cgVar) {
            this.b = cgVar;
        }

        public final void run() {
            bk bkVar = this.a;
            Object obj = this.b;
            if (obj != null) {
                obj.a(ct.c(bkVar));
                bkVar.c(obj);
            }
        }
    }

    public bt(bk bkVar) {
        this.b = bkVar;
    }

    public final void a() {
        if (!this.a) {
            this.a = true;
            this.g = new HandlerThread("CellProvider");
            this.g.start();
            this.h = new a(this.g.getLooper());
            this.h.sendEmptyMessageDelayed(0, 3000);
            CellLocation b = ct.b(this.b);
            if (a(b)) {
                Object a = cg.a(this.b, b, null);
                if (a != null) {
                    this.c = b;
                    this.b.c(a);
                }
            }
            a(273);
            ct.b.a.a("TxCellProvider", "startup: state=[start]");
        }
    }

    public final void b() {
        if (this.a) {
            this.a = false;
            a(0);
            synchronized (this) {
                if (this.h != null) {
                    this.h.removeCallbacksAndMessages(null);
                    this.h = null;
                }
            }
            this.g.quit();
            this.g = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = 0;
            ct.b.a.a("TxCellProvider", "shutdown: state=[shutdown]");
        }
    }

    private void a(int i) {
        try {
            this.b.a().listen(this, i);
        } catch (Throwable e) {
            ct.b.a.a("TxCellProvider", "listenCellState: failed! flags=" + i, e);
        }
    }

    public final void onServiceStateChanged(ServiceState serviceState) {
        Object obj = 1;
        super.onServiceStateChanged(serviceState);
        if (serviceState != null) {
            ServiceState serviceState2 = this.e;
            if (serviceState2 == null || serviceState2.getState() != serviceState.getState()) {
                this.e = serviceState;
                if (this.a) {
                    int i;
                    TelephonyManager a;
                    boolean a2;
                    if (this.e != null) {
                        if (this.e.getState() == 0) {
                            i = 1;
                        } else if (this.e.getState() == 1) {
                            i = 0;
                        }
                        a = this.b.a();
                        a2 = ct.a(this.b.a);
                        if (a != null) {
                            obj = null;
                        } else if (a.getSimState() != 5) {
                            obj = null;
                        }
                        if (a2 || r1 == null) {
                            i = 0;
                        }
                        obj = new Message();
                        obj.what = 12999;
                        obj.arg1 = 12003;
                        obj.arg2 = i;
                        this.b.c(obj);
                    }
                    i = -1;
                    a = this.b.a();
                    a2 = ct.a(this.b.a);
                    if (a != null) {
                        obj = null;
                    } else if (a.getSimState() != 5) {
                        obj = null;
                    }
                    i = 0;
                    obj = new Message();
                    obj.what = 12999;
                    obj.arg1 = 12003;
                    obj.arg2 = i;
                    this.b.c(obj);
                }
            }
        }
    }

    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        if (signalStrength != null) {
            try {
                SignalStrength signalStrength2 = this.d;
                int i = this.b.g().b;
                if (signalStrength2 == null || ct.a(i, signalStrength2, signalStrength)) {
                    this.d = signalStrength;
                    c();
                }
            } catch (Exception e) {
                ct.b.a.b("TxCellProvider", e.toString());
            }
        }
    }

    public final void onCellLocationChanged(CellLocation cellLocation) {
        super.onCellLocationChanged(cellLocation);
        if (a(cellLocation)) {
            this.c = cellLocation;
            c();
            return;
        }
        ct.b.a.b("TxCellProvider", "onCellLocationChanged: illegal cell or same cell " + cellLocation);
    }

    private boolean a(CellLocation cellLocation) {
        if (cellLocation == null) {
            return false;
        }
        try {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            if (gsmCellLocation.getCid() == 0 && gsmCellLocation.getLac() == 0) {
                return false;
            }
        } catch (ClassCastException e) {
        }
        if (ct.a(cellLocation) < 0) {
            return false;
        }
        if (ct.a(this.c, cellLocation)) {
            return false;
        }
        cg a = cg.a(this.b, cellLocation, null);
        return a == null ? true : ct.a(a);
    }

    private void c() {
        if (this.a && this.c != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if ((currentTimeMillis - this.f > 2000 ? 1 : null) != null) {
                this.f = currentTimeMillis;
                cg a = cg.a(this.b, this.c, this.d);
                synchronized (this) {
                    if (!(this.h == null || a == null)) {
                        Runnable bVar = new b(this.b);
                        bVar.a(a);
                        this.h.post(bVar);
                    }
                }
            }
        }
    }
}
