package com.c.a.a;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;

final class k extends c implements Listener, LocationListener {
    private static k aJh;
    private LocationManager Hc;
    private Context aHq;
    private boolean aJi;
    private GpsStatus aJj;
    private a aJk;
    private Looper aJl;
    private final l aJm = new l();

    static class a extends a {
        final int aJn = 0;

        a(long j) {
            super(j);
        }
    }

    static class b extends p {
        final double aJo;
        final float aJp;
        final float aJq;
        final float aJr;
        final int aJs;
        final int aJt;
        final long aJu;
        final double lat;
        final double lng;

        private b(double d, double d2, double d3, float f, float f2, int i, int i2, float f3, long j) {
            super(401);
            this.lat = d;
            this.lng = d2;
            this.aJo = d3;
            this.aJp = f;
            this.aJq = f2;
            this.aJs = i;
            this.aJt = i2;
            this.aJr = f3;
            this.aJu = j;
        }
    }

    private k() {
    }

    static k nh() {
        if (aJh == null) {
            aJh = new k();
        }
        return aJh;
    }

    final synchronized void a(Handler handler, a aVar) {
        if (aVar == null) {
            aVar = new a(30000);
        } else if (aVar instanceof a) {
            a aVar2 = (a) aVar;
        } else {
            aVar = new a(aVar.aHt);
        }
        super.a(handler, aVar);
    }

    final void N(Context context) {
        this.aHq = context;
        this.Hc = (LocationManager) context.getSystemService("location");
        boolean z = (this.Hc == null || this.Hc.getProvider("gps") == null) ? false : true;
        this.aJi = z;
    }

    final void a(Context context, Handler handler, a aVar) {
        if (this.aJi) {
            this.aJk = (a) aVar;
            this.aJl = handler != null ? handler.getLooper() : null;
            a(this.aJk.aHt, (float) this.aJk.aJn);
            this.Hc.addGpsStatusListener(this);
            this.aJm.aJv = Math.max(5000, Math.min(this.aJk.aHt + 5000, 65000));
        }
    }

    final void O(Context context) {
        if (this.aJi) {
            this.Hc.removeUpdates(this);
            this.Hc.removeGpsStatusListener(this);
        }
    }

    final void na() {
    }

    public final void onLocationChanged(Location location) {
        int i;
        int i2;
        if (!y.aNz) {
            Object obj;
            if (Secure.getString(this.aHq.getContentResolver(), "mock_location").equals("0")) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                return;
            }
        }
        if (this.aJj != null) {
            int i3 = 0;
            int i4 = 0;
            for (GpsSatellite usedInFix : this.aJj.getSatellites()) {
                i3++;
                if (usedInFix.usedInFix()) {
                    i4++;
                }
            }
            i = i4;
            i2 = i3;
        } else {
            i = 0;
            i2 = 0;
        }
        this.aJm.a(location.getAccuracy(), i, location.getTime());
        c(new b(location.getLatitude(), location.getLongitude(), location.getAltitude(), location.getAccuracy(), location.getSpeed(), i2, i, this.aJm.aJr, this.aJm.aJz / 1000));
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onProviderDisabled(String str) {
    }

    public final void onGpsStatusChanged(int i) {
        if (i != 4) {
            return;
        }
        if (this.aJj == null) {
            this.aJj = this.Hc.getGpsStatus(null);
        } else {
            this.Hc.getGpsStatus(this.aJj);
        }
    }

    private void a(long j, float f) {
        this.Hc.requestLocationUpdates("gps", j, f, this, this.aJl);
    }

    final void nb() {
        if (this.aJi && this.aHp && this.aJk.aHt < 300000) {
            a(300000, (float) this.aJk.aJn);
        }
    }

    final void nc() {
        if (this.aJi && this.aHp && this.aJk.aHt < 300000) {
            a(this.aJk.aHt, (float) this.aJk.aJn);
        }
    }
}
