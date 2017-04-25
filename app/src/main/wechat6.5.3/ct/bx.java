package ct;

import android.annotation.SuppressLint;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateFormat;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import ct.b.a;
import java.util.Arrays;
import java.util.Iterator;

final class bx implements Listener, LocationListener {
    private long a = 0;
    private final bk b;
    private int c = 1024;
    private boolean d = false;
    private boolean e = false;
    private int f = 0;
    private int g = 0;
    private volatile boolean h;
    private boolean i;
    private br j;
    private GpsStatus k;
    private final double[] l = new double[2];

    public bx(bk bkVar) {
        this.b = bkVar;
        this.j = br.a();
    }

    public final void a(long j, boolean z) {
        if (!this.h) {
            this.h = true;
            this.b.a((Object) this);
            long max = Math.max(j, 1000);
            LocationManager c = this.b.c();
            if (z) {
                c.requestLocationUpdates("passive", max, 0.0f, this);
            } else {
                try {
                    c.addGpsStatusListener(this);
                    c.requestLocationUpdates("gps", max, 0.0f, this);
                } catch (Throwable e) {
                    ct.a = true;
                    a.a("TxGpsProvider", "startup: can not add location listener", e);
                }
            }
            if (c()) {
                this.c = 4;
                d();
            }
            a.a("TxGpsProvider", "startup: state=[start]");
        }
    }

    public final void a() {
        if (this.h) {
            this.h = false;
            this.a = 0;
            this.c = 1024;
            this.d = false;
            this.e = false;
            this.f = 0;
            this.g = 0;
            this.i = false;
            Arrays.fill(this.l, 0.0d);
            this.b.b((Object) this);
            LocationManager c = this.b.c();
            try {
                c.removeGpsStatusListener(this);
            } catch (Exception e) {
            }
            try {
                c.removeUpdates(this);
            } catch (Exception e2) {
            }
            a.a("TxGpsProvider", "shutdown: state=[shutdown]");
        }
    }

    public final boolean b() {
        if ((this.c & 2) != 2 || System.currentTimeMillis() - this.a >= bw.a().b()) {
            return false;
        }
        return true;
    }

    public final boolean c() {
        boolean z = false;
        try {
            z = this.b.c().isProviderEnabled("gps");
        } catch (Exception e) {
        } catch (Error e2) {
        }
        return z;
    }

    public final void a(boolean z) {
        this.i = z;
    }

    private static boolean a(double d) {
        if (Math.abs(((double) Double.valueOf(d).longValue()) - d) < Double.MIN_VALUE) {
            return true;
        }
        return false;
    }

    private void d() {
        int i;
        if (this.c == 4) {
            i = 1;
        } else if (this.c == 0) {
            i = 0;
        } else {
            i = -1;
        }
        Object message = new Message();
        message.what = 12999;
        message.arg1 = 12002;
        message.arg2 = i;
        this.b.c(message);
    }

    @SuppressLint({"NewApi"})
    private boolean a(Location location) {
        if (!TencentExtraKeys.MOCK_LOCATION_FILTER) {
            return false;
        }
        try {
            if (!this.b.c().isProviderEnabled("gps")) {
                return true;
            }
            if (VERSION.SDK_INT < 18 || !location.isFromMockProvider()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        } catch (NoSuchMethodError e2) {
            return false;
        }
    }

    public final void onLocationChanged(Location location) {
        if (location != null) {
            try {
                if ("gps".equals(location.getProvider())) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    a.a("TxGpsProvider", "onLocationChanged: " + DateFormat.format("yyyy-MM-dd kk:mm:ss", this.a) + latitude + "," + longitude);
                    Object obj = location.getAccuracy() > 10000.0f ? null : (a(latitude) && a(longitude)) ? null : (Math.abs(latitude) < 1.0E-8d || Math.abs(longitude) < 1.0E-8d) ? null : (Math.abs(latitude - 1.0d) < 1.0E-8d || Math.abs(longitude - 1.0d) < 1.0E-8d) ? null : (latitude < -90.0d || latitude > 90.0d || longitude < -180.0d || longitude > 180.0d) ? null : 1;
                    if (obj != null) {
                        e();
                        this.c |= 2;
                        if (!a(location)) {
                            this.a = System.currentTimeMillis();
                            int i = 0;
                            if (this.g == 3) {
                                i = 1;
                            } else if (this.g >= 4 && this.g <= 6) {
                                i = 2;
                            } else if (this.g >= 7) {
                                i = 3;
                            }
                            obj = (this.i && cu.a(location.getLatitude(), location.getLongitude())) ? 1 : null;
                            if (obj != null) {
                                a.a(location, this.l);
                                a(location, this.l[0], this.l[1], i);
                            } else {
                                a(location, location.getLatitude(), location.getLongitude(), i);
                            }
                            this.b.c(new ch(location, this.a, this.f, this.g, this.c));
                        }
                    }
                }
            } catch (Exception e) {
            } catch (Error e2) {
            }
        }
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public final void onProviderEnabled(String str) {
        if ("gps".equals(str)) {
            a.a("TxGpsProvider", "onProviderEnabled: gps is enabled");
            this.c = 4;
            d();
        }
    }

    public final void onProviderDisabled(String str) {
        if ("gps".equals(str)) {
            a.a("TxGpsProvider", "onProviderDisabled: gps is disabled");
            this.g = 0;
            this.f = 0;
            this.c = 0;
            this.d = false;
            this.a = 0;
            d();
        }
    }

    public final void onGpsStatusChanged(int i) {
        int i2;
        switch (i) {
            case 1:
                this.c |= 1;
                break;
            case 2:
                this.c = 0;
                break;
            case 3:
                this.c |= 2;
                break;
            case 4:
                boolean a;
                LocationManager c = this.b.c();
                try {
                    if (this.k == null) {
                        this.k = c.getGpsStatus(null);
                    } else {
                        c.getGpsStatus(this.k);
                    }
                } catch (Exception e) {
                }
                if (this.k != null) {
                    a = this.j.a(this.k);
                } else {
                    a = true;
                }
                if (a) {
                    i2 = 3;
                } else {
                    i2 = 4;
                }
                Object message = new Message();
                message.what = 12999;
                message.arg1 = 12004;
                message.arg2 = i2;
                this.b.c(message);
                break;
        }
        e();
        i2 = f();
        int g = g();
        if (i2 > 0) {
            this.e = true;
        }
        if (g > 0) {
            this.d = true;
        }
    }

    private void e() {
        GpsStatus gpsStatus = null;
        try {
            this.g = 0;
            this.f = 0;
            try {
                gpsStatus = this.b.c().getGpsStatus(null);
            } catch (Exception e) {
            }
            if (gpsStatus != null) {
                int maxSatellites = gpsStatus.getMaxSatellites();
                Iterator it = gpsStatus.getSatellites().iterator();
                if (it != null) {
                    while (it.hasNext() && this.f <= maxSatellites) {
                        this.f++;
                        if (((GpsSatellite) it.next()).usedInFix()) {
                            this.g++;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            a.b("TxGpsProvider", e2.toString());
        }
    }

    private int f() {
        GpsStatus gpsStatus = null;
        int i = -1;
        try {
            gpsStatus = this.b.c().getGpsStatus(null);
        } catch (Exception e) {
        }
        if (gpsStatus != null) {
            int maxSatellites = gpsStatus.getMaxSatellites();
            Iterator it = gpsStatus.getSatellites().iterator();
            if (it != null) {
                i = 0;
                while (it.hasNext() && i <= maxSatellites) {
                    it.next();
                    i++;
                }
            }
        }
        return i;
    }

    private int g() {
        GpsStatus gpsStatus = null;
        int i = -1;
        try {
            gpsStatus = this.b.c().getGpsStatus(null);
        } catch (Exception e) {
        }
        if (gpsStatus != null) {
            int maxSatellites = gpsStatus.getMaxSatellites();
            Iterator it = gpsStatus.getSatellites().iterator();
            if (it != null) {
                i = 0;
                while (it.hasNext() && i <= maxSatellites) {
                    if (((GpsSatellite) it.next()).usedInFix()) {
                        i++;
                    }
                }
            }
        }
        return i;
    }

    private static void a(Location location, double d, double d2, int i) {
        Bundle extras = location.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putDouble("lat", d);
        extras.putDouble("lng", d2);
        extras.putInt("rssi", i);
        location.setExtras(extras);
    }
}
