package com.tencent.map.geolocation;

import android.content.Context;
import ct.b.a;
import ct.cy;

public class TencentLocationUtils {
    private TencentLocationUtils() {
        throw new UnsupportedOperationException();
    }

    public static double distanceBetween(TencentLocation tencentLocation, TencentLocation tencentLocation2) {
        if (tencentLocation != null && tencentLocation2 != null) {
            return a.a(tencentLocation.getLatitude(), tencentLocation.getLongitude(), tencentLocation2.getLatitude(), tencentLocation2.getLongitude());
        }
        throw new NullPointerException();
    }

    public static double distanceBetween(double d, double d2, double d3, double d4) {
        return a.a(d, d2, d3, d4);
    }

    public static boolean contains(TencentLocation tencentLocation, double d, TencentLocation tencentLocation2) {
        if (tencentLocation != null && tencentLocation2 != null) {
            return distanceBetween(tencentLocation, tencentLocation2) <= d;
        } else {
            throw new NullPointerException();
        }
    }

    public static boolean isFromGps(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return false;
        }
        return "gps".equals(tencentLocation.getProvider());
    }

    public static boolean isFromNetwork(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return false;
        }
        return TencentLocation.NETWORK_PROVIDER.equals(tencentLocation.getProvider());
    }

    public static boolean isSupportGps(Context context) {
        if (context == null) {
            throw new NullPointerException();
        }
        cy.a();
        return (cy.a(context) & 16) == 0;
    }
}
