package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Looper;
import com.tencent.mmdb.database.SQLiteDatabase;
import ct.b.a;
import ct.bk;
import ct.bl;
import ct.by;

public final class TencentLocationManager {
    public static final int COORDINATE_TYPE_GCJ02 = 1;
    public static final int COORDINATE_TYPE_WGS84 = 0;
    private static TencentLocationManager d;
    private final byte[] a = new byte[0];
    private final bk b;
    private final by c;

    private TencentLocationManager(Context context) {
        this.b = bk.a(context);
        this.c = new by(this.b);
    }

    public static synchronized TencentLocationManager getInstance(Context context) {
        TencentLocationManager tencentLocationManager;
        synchronized (TencentLocationManager.class) {
            if (d == null) {
                if (context == null) {
                    throw new NullPointerException("context is null");
                } else if (context.getApplicationContext() == null) {
                    throw new NullPointerException("application context is null");
                } else if (Looper.myLooper() == null) {
                    throw new IllegalArgumentException("getInstance must be use in Thread with looper. Please first use Looper.prapare()");
                } else {
                    d = new TencentLocationManager(context.getApplicationContext());
                }
            }
            tencentLocationManager = d;
        }
        return tencentLocationManager;
    }

    public final void setCoordinateType(int i) {
        if (i == 1 || i == 0) {
            synchronized (this.a) {
                this.c.a(i);
            }
            return;
        }
        throw new IllegalArgumentException("unknown coordinate type: " + i);
    }

    public final int getCoordinateType() {
        return this.c.f();
    }

    public final int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener) {
        return requestLocationUpdates(tencentLocationRequest, tencentLocationListener, Looper.myLooper());
    }

    public final int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        if (tencentLocationRequest == null) {
            throw new NullPointerException("request is null");
        } else if (tencentLocationListener == null) {
            throw new NullPointerException("listener is null");
        } else if (looper == null) {
            throw new NullPointerException("looper is null");
        } else {
            int a;
            synchronized (this.a) {
                a = this.c.a(tencentLocationRequest, tencentLocationListener, looper);
            }
            return a;
        }
    }

    public final int requestSingleFreshLocation(TencentLocationListener tencentLocationListener, Looper looper) {
        if (tencentLocationListener == null) {
            throw new NullPointerException("listener is null");
        } else if (looper == null) {
            throw new NullPointerException("looper is null");
        } else {
            int a;
            synchronized (this.a) {
                a = this.c.a(tencentLocationListener, looper);
            }
            return a;
        }
    }

    public final String resumeLocationUpdates() {
        return this.c.d();
    }

    public final String pauseLocationUpdates() {
        return this.c.e();
    }

    public final int startDistanceCalculate(TencentDistanceListener tencentDistanceListener) {
        if (tencentDistanceListener == null) {
            throw new NullPointerException("listener is null");
        }
        int a;
        synchronized (this.a) {
            a = this.c.a(tencentDistanceListener);
        }
        return a;
    }

    public final TencentDistanceAnalysis stopDistanceCalculate(TencentDistanceListener tencentDistanceListener) {
        TencentDistanceAnalysis b;
        synchronized (this.a) {
            b = this.c.b();
        }
        return b;
    }

    public final TencentLocation getLastKnownLocation() {
        return this.c.a();
    }

    public final void removeUpdates(TencentLocationListener tencentLocationListener) {
        synchronized (this.a) {
            this.c.c();
        }
    }

    public final String getBuild() {
        bl a = this.b.a(-1);
        return a != null ? a.e() : "None";
    }

    public final String getVersion() {
        bl a = this.b.a(-1);
        return a != null ? a.d() : "None";
    }

    public final void setKey(String str) {
        if (str == null || str.equals(SQLiteDatabase.KeyEmpty)) {
            throw new IllegalArgumentException("bad key: " + str);
        }
        this.b.g().h = str;
    }

    public final String getKey() {
        return a.b(this.b.g().h);
    }
}
