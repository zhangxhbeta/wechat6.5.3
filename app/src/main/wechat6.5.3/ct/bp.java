package ct;

import android.location.Location;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import ct.b.a;

final class bp extends bo {
    private SparseArray<Pair<Double, Double>> a = new SparseArray();

    public bp(String str) {
        super(str, "check cell");
    }

    public final void a() {
        super.a();
        this.a.clear();
    }

    protected final boolean a(Bundle bundle) {
        int i = bundle.getInt("lac");
        int i2 = bundle.getInt("cid");
        Location location = (Location) bundle.getParcelable("location");
        if (i == 0 || i2 == 0 || location == null) {
            return false;
        }
        i <<= i2 + 16;
        Pair pair = (Pair) this.a.get(i);
        if (pair != null) {
            return a.a(location.getLatitude(), location.getLongitude(), ((Double) pair.first).doubleValue(), ((Double) pair.second).doubleValue()) < 6000.0d;
        } else {
            this.a.put(i, Pair.create(Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
            if (this.a.size() > 320) {
                this.a.delete(this.a.keyAt(0));
            }
            return true;
        }
    }
}
