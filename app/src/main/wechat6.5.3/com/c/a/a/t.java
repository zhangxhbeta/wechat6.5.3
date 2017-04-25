package com.c.a.a;

import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import com.tencent.map.geolocation.TencentLocation;
import java.lang.ref.WeakReference;

public final class t {
    private static boolean aHp = false;
    private static Context aLg;
    private static WeakReference<b> aLh;
    private static WeakReference<d> aLi;
    private static WeakReference<c> aLj;
    private static WeakReference<e> aLk;
    private static final a aLl = new a();
    private static String imei;

    public interface b {
        void a(double d, double d2, int i, int i2, long j);
    }

    public interface c {
    }

    public interface d {
        void g(int i, String str);
    }

    public interface e {
    }

    private static class a implements m {
        private a() {
        }

        public final void a(p pVar) {
            switch (pVar.what) {
                case 8901:
                    if (t.aLj != null && ((c) t.aLj.get()) != null) {
                        return;
                    }
                    return;
                case 8902:
                    if (t.aLj != null) {
                        t.aLj.get();
                        return;
                    }
                    return;
                case 9901:
                    if (t.aLh != null) {
                        b bVar = (b) t.aLh.get();
                        if (bVar != null) {
                            a aVar = (a) pVar;
                            bVar.a(aVar.lat, aVar.lng, aVar.aJT, aVar.aJU, aVar.aJV);
                            return;
                        }
                        return;
                    }
                    return;
                case 9902:
                    if (t.aLi != null) {
                        d dVar = (d) t.aLi.get();
                        if (dVar != null) {
                            b bVar2 = (b) pVar;
                            dVar.g(bVar2.aJW, bVar2.aJX);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static void a(Context context, q qVar) {
        aLg = context.getApplicationContext();
        try {
            w.nH().a(context, aLl);
            r.nl().aKz = qVar;
            r.nl().aKA = imei;
        } catch (Exception e) {
        }
    }

    public static void setImei(String str) {
        imei = str;
    }

    public static boolean a(Handler handler, long j, b bVar, d dVar) {
        if (aLg == null) {
            return false;
        }
        if (aHp) {
            return true;
        }
        aLh = new WeakReference(bVar);
        aLi = new WeakReference(dVar);
        aLj = new WeakReference(null);
        try {
            w nH = w.nH();
            if (handler == null) {
                handler = new Handler(aLg.getMainLooper());
            }
            nH.a(handler, new c(j, 5000));
            if (y.aNz) {
                y.aNG = o.nk();
                o.m("filter_input_log_" + y.aNG, "type,unixTime,latR,lngR,alt,acc,numWap,speed,maturity,numStep,stepLength,bearingR");
                o.m("filter_output_log_" + y.aNG, "time,lat,lng,err,speed");
                o.m("gps_log_" + y.aNG, "lat,lng,alt,accuracy,speed,numSatVisible,numSatUsedInFix,quality,timeSinceFixS");
                o.m("post_processing_log_" + y.aNG, "tag,lat,lng");
            }
            if (!(aLk == null || ((e) aLk.get()) == null)) {
                boolean isProviderEnabled;
                LocationManager locationManager = (LocationManager) aLg.getSystemService("location");
                try {
                    isProviderEnabled = locationManager.isProviderEnabled("gps");
                } catch (SecurityException e) {
                    isProviderEnabled = false;
                }
                if (!isProviderEnabled) {
                    try {
                        locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
                    } catch (SecurityException e2) {
                    }
                }
            }
            aHp = true;
            return true;
        } catch (Exception e3) {
            aHp = false;
            return false;
        }
    }

    public static void ny() {
        try {
            w.nH().stop();
        } catch (Exception e) {
        } finally {
            aHp = false;
        }
    }

    public static void finish() {
        try {
            w.nH().nd();
        } catch (Exception e) {
        }
    }
}
