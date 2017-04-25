package ct;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationUtils;
import java.util.LinkedList;
import java.util.ListIterator;

public final class cd {
    private int a = 10;
    private int b = 4;
    private LinkedList<a> c = new LinkedList();
    private bs d = new bs();

    static class a {
        double a;
        double b;
        long c;
        int d;

        a() {
        }

        public final String toString() {
            return "[" + this.a + "," + this.b + "]";
        }

        static a a(TencentLocation tencentLocation) {
            int i = 2;
            a aVar = new a();
            aVar.a = tencentLocation.getLatitude();
            aVar.b = tencentLocation.getLongitude();
            aVar.c = tencentLocation.getTime();
            tencentLocation.getSpeed();
            if (TencentLocationUtils.isFromGps(tencentLocation)) {
                if (tencentLocation.getAccuracy() < 100.0f) {
                    i = 3;
                }
                aVar.d = i;
            } else {
                if (tencentLocation.getAccuracy() >= 500.0f) {
                    i = 1;
                }
                aVar.d = i;
            }
            return aVar;
        }
    }

    public final synchronized void a() {
        this.c.clear();
    }

    public final synchronized void a(TencentLocation tencentLocation) {
        this.c.add(a.a(tencentLocation));
        if (this.c.size() > this.a) {
            this.c.removeFirst();
        }
    }

    public final synchronized void b() {
    }

    public final synchronized boolean a(TencentLocation tencentLocation, bk bkVar) {
        return a(a.a(tencentLocation), bkVar);
    }

    private synchronized boolean a(a aVar, bk bkVar) {
        boolean z;
        if (bkVar == null) {
            z = true;
        } else if (aVar.d == 3) {
            z = true;
        } else {
            if ((this.c.size() >= this.b ? 1 : null) != null) {
                int i;
                int i2 = 0;
                ListIterator listIterator = this.c.listIterator(this.c.size());
                int i3 = 0;
                while (listIterator.hasPrevious()) {
                    a aVar2 = (a) listIterator.previous();
                    if ((ct.b.a.a(aVar2.a, aVar2.b, aVar.a, aVar.b) / (((double) (Math.abs(aVar2.c - aVar.c) + 1)) / 1000.0d) > 80.0d ? null : 1) == null) {
                        i = i2 + 1;
                    } else {
                        i = i2;
                    }
                    int i4 = i3 + 1;
                    if (i4 > this.b) {
                        break;
                    }
                    i3 = i4;
                    i2 = i;
                }
                i = i2;
                if (i > 1) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }
}
