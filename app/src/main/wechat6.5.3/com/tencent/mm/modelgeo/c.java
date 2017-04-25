package com.tencent.mm.modelgeo;

import android.content.Context;
import android.location.LocationManager;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c implements a {
    public static c cCR;
    public boolean cJA = false;
    g cJB;
    List<WeakReference<a>> cJC = new ArrayList();
    public long cJD = 0;
    boolean cJE = false;
    boolean cJF = false;
    double cJG = 23.0d;
    double cJH = 100.0d;
    int cJI = 0;
    double cJJ = 0.0d;
    double cJK = 0.0d;
    private e cJL = new e(this) {
        final /* synthetic */ c cJN;

        {
            this.cJN = r1;
        }

        public final void a(boolean z, double d, double d2, int i, double d3, double d4) {
            if (z) {
                this.cJN.cJG = d;
                this.cJN.cJH = d2;
                this.cJN.cJI = i;
                this.cJN.cJJ = d3;
                this.cJN.cJK = d4;
                this.cJN.cJD = System.currentTimeMillis();
                this.cJN.cJE = true;
                this.cJN.cJF = false;
                c.a(this.cJN, 67592);
            }
            v.d("MicroMsg.LocationGeo", "onGetLocation fLongitude: %f fLatitude:%f locType:%d %f:spped", Double.valueOf(d2), Double.valueOf(d), Integer.valueOf(i), Double.valueOf(d3));
            final boolean z2 = z;
            final double d5 = d;
            final double d6 = d2;
            final int i2 = i;
            final double d7 = d3;
            final double d8 = d4;
            new ac(Looper.getMainLooper()).postDelayed(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 cJU;

                public final void run() {
                    c.a(this.cJU.cJN, z2, d5, d6, i2, d7, d8);
                }
            }, 200);
        }
    };
    private f cJM = new f(this) {
        final /* synthetic */ c cJN;

        {
            this.cJN = r1;
        }

        public final void a(boolean z, double d, double d2, int i, double d3, double d4) {
            if (z) {
                this.cJN.cJG = d;
                this.cJN.cJH = d2;
                this.cJN.cJI = i;
                this.cJN.cJJ = d3;
                this.cJN.cJK = d4;
                this.cJN.cJF = true;
                this.cJN.cJE = false;
                this.cJN.cJD = System.currentTimeMillis();
                c.a(this.cJN, 67591);
            }
            v.d("MicroMsg.LocationGeo", "onGetLocationWgs84 fLongitude: %f fLatitude:%f locType:%d %f:spped", Double.valueOf(d2), Double.valueOf(d), Integer.valueOf(i), Double.valueOf(d3));
            final boolean z2 = z;
            final double d5 = d;
            final double d6 = d2;
            final int i2 = i;
            final double d7 = d3;
            final double d8 = d4;
            new ac(Looper.getMainLooper()).postDelayed(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 cJV;

                public final void run() {
                    c.a(this.cJV.cJN, z2, d5, d6, i2, d7, d8);
                }
            }, 200);
        }
    };
    private ac cnC = new ac(Looper.getMainLooper());
    private Context mContext;

    static /* synthetic */ void a(c cVar, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((int) cVar.cJK);
        stringBuffer.append(",");
        stringBuffer.append(cVar.cJI);
        stringBuffer.append(",");
        stringBuffer.append((int) (cVar.cJG * 1000000.0d));
        stringBuffer.append(",");
        stringBuffer.append((int) (cVar.cJH * 1000000.0d));
        ak.yW();
        com.tencent.mm.model.c.vf().set(i, stringBuffer.toString());
        v.d("MicroMsg.LocationGeo", "Save Location Success id=%d|content=%s", Integer.valueOf(i), stringBuffer.toString());
    }

    static /* synthetic */ void a(c cVar, boolean z, double d, double d2, int i, double d3, double d4) {
        List<a> linkedList = new LinkedList();
        for (WeakReference weakReference : cVar.cJC) {
            if (!(weakReference == null || weakReference.get() == null)) {
                linkedList.add((a) weakReference.get());
            }
        }
        for (a aVar : linkedList) {
            boolean z2;
            if (q.dpI && b.bsI()) {
                z2 = z;
                aVar.a(z2, (float) q.lng, (float) q.lat, i, (double) ((float) d3), d4);
            } else {
                z2 = z;
                aVar.a(z2, (float) d2, (float) d, i, (double) ((float) d3), d4);
            }
        }
    }

    public static c FY() {
        if (cCR == null) {
            cCR = new c(aa.getContext());
        }
        return cCR;
    }

    private c(Context context) {
        this.mContext = context;
        this.cJB = g.aQ(context);
    }

    public final void a(a aVar, boolean z) {
        boolean z2;
        v.i("MicroMsg.LocationGeo", "startWgs84 %s userCache %s delay %d", aVar, Boolean.valueOf(z), Integer.valueOf(0));
        if (this.cJA && this.cJC.size() > 0) {
            try {
                g.Gc();
                g.a(this.cJM, 0, Looper.getMainLooper());
            } catch (g.a e) {
                v.d("MicroMsg.LocationGeo", e.toString());
            }
        }
        this.cJA = false;
        for (WeakReference weakReference : this.cJC) {
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                z2 = false;
                break;
            }
        }
        z2 = true;
        if (z2) {
            this.cJC.add(new WeakReference(aVar));
        }
        v.i("MicroMsg.LocationGeo", "add listeners size %d", Integer.valueOf(this.cJC.size()));
        if (this.cJC.size() == 1) {
            try {
                g.a(this.cJM, 0, Looper.getMainLooper());
            } catch (g.a e2) {
                v.d("MicroMsg.LocationGeo", e2.toString());
            }
        }
        if (z && this.cJF && System.currentTimeMillis() - this.cJD < 60000) {
            this.cJL.a(true, this.cJG, this.cJH, this.cJI, this.cJJ, this.cJK);
        }
    }

    public final void b(a aVar) {
        a(aVar, true);
    }

    public final void a(a aVar) {
        if (!this.cJA && this.cJC.size() > 0) {
            try {
                g.Gc();
                g.a(this.cJL, 1, Looper.getMainLooper());
            } catch (g.a e) {
                v.d("MicroMsg.LocationGeo", e.toString());
            }
        }
        this.cJA = true;
        for (WeakReference weakReference : this.cJC) {
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                int i = 0;
                break;
            }
        }
        boolean z = true;
        if (i != 0) {
            this.cJC.add(new WeakReference(aVar));
        }
        v.i("MicroMsg.LocationGeo", "add listeners size %d", Integer.valueOf(this.cJC.size()));
        if (this.cJC.size() == 1) {
            try {
                g.a(this.cJL, 1, Looper.getMainLooper());
            } catch (g.a e2) {
                v.d("MicroMsg.LocationGeo", e2.toString());
            }
        }
        if (this.cJE && System.currentTimeMillis() - this.cJD < 60000) {
            this.cJL.a(true, this.cJG, this.cJH, this.cJI, this.cJJ, this.cJK);
        }
    }

    public final void c(final a aVar) {
        new ac().post(new Runnable(this) {
            final /* synthetic */ c cJN;

            public final void run() {
                List<WeakReference> arrayList = new ArrayList();
                for (WeakReference weakReference : this.cJN.cJC) {
                    if (weakReference == null || weakReference.get() == null || ((a) weakReference.get()).equals(aVar)) {
                        arrayList.add(weakReference);
                    }
                }
                for (WeakReference weakReference2 : arrayList) {
                    this.cJN.cJC.remove(weakReference2);
                }
                v.i("MicroMsg.LocationGeo", "stop listeners size %d", Integer.valueOf(this.cJN.cJC.size()));
                if (this.cJN.cJC.size() == 0 && this.cJN.cJB != null) {
                    g.Gc();
                }
            }
        });
    }

    public static boolean FZ() {
        try {
            return ((LocationManager) aa.getContext().getSystemService("location")).isProviderEnabled("gps");
        } catch (Throwable e) {
            v.e("MicroMsg.LocationGeo", "exception:%s", be.e(e));
            return false;
        }
    }

    public static boolean Ga() {
        try {
            return ((LocationManager) aa.getContext().getSystemService("location")).isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
        } catch (Throwable e) {
            v.e("MicroMsg.LocationGeo", "exception:%s", be.e(e));
            return false;
        }
    }
}
