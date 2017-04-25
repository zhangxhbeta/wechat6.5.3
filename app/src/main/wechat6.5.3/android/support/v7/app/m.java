package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

final class m {
    static final a Hb = new a();
    private final LocationManager Hc;
    final Context mContext;

    private static class a {
        boolean Hd;
        long He;
        long Hf;
        long Hg;
        long Hh;
        long Hi;

        private a() {
        }
    }

    m(Context context) {
        this.mContext = context;
        this.Hc = (LocationManager) context.getSystemService("location");
    }

    final Location o(String str) {
        if (this.Hc != null) {
            try {
                if (this.Hc.isProviderEnabled(str)) {
                    return this.Hc.getLastKnownLocation(str);
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    static boolean a(a aVar) {
        return aVar != null && aVar.Hi > System.currentTimeMillis();
    }

    static void b(Location location) {
        long j;
        a aVar = Hb;
        long currentTimeMillis = System.currentTimeMillis();
        if (l.GY == null) {
            l.GY = new l();
        }
        l lVar = l.GY;
        lVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = lVar.GZ;
        lVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = lVar.state == 1;
        long j3 = lVar.Ha;
        long j4 = lVar.GZ;
        lVar.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = lVar.Ha;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            if (currentTimeMillis > j4) {
                j = 0 + j5;
            } else if (currentTimeMillis > j3) {
                j = 0 + j4;
            } else {
                j = 0 + j3;
            }
            j += 60000;
        }
        aVar.Hd = z;
        aVar.He = j2;
        aVar.Hf = j3;
        aVar.Hg = j4;
        aVar.Hh = j5;
        aVar.Hi = j;
    }
}
