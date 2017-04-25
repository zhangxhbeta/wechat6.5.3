package ct;

import android.location.Location;

public final class ch extends cj {
    public final Location a;
    public final long b;
    public final int c;
    private int d;
    private int e;

    public ch(ch chVar) {
        Location location;
        if (chVar.a == null) {
            location = null;
        } else {
            location = new Location(chVar.a);
        }
        this.a = location;
        this.b = chVar.b;
        this.d = chVar.d;
        this.c = chVar.c;
        this.e = chVar.e;
    }

    public ch(Location location, long j, int i, int i2, int i3) {
        this.a = location;
        this.b = j;
        this.d = i;
        this.c = i2;
        this.e = i3;
    }

    public final String toString() {
        return "TxGpsInfo [location=" + this.a + ", gpsTime=" + this.b + ", visbleSatelliteNum=" + this.d + ", usedSatelliteNum=" + this.c + ", gpsStatus=" + this.e + "]";
    }
}
