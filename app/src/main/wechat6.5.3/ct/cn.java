package ct;

import com.tencent.map.geolocation.TencentDistanceAnalysis;

public final class cn implements TencentDistanceAnalysis {
    private double a;
    private int b;
    private int c;

    public final double getConfidence() {
        return this.a;
    }

    public final void a(double d) {
        this.a = d;
    }

    public final int getGpsCount() {
        return this.b;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final int getNetworkCount() {
        return this.c;
    }

    public final void b(int i) {
        this.c = i;
    }
}
