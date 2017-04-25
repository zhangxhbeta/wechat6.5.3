package com.tencent.mm.modelgeo;

import android.content.Context;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mm.sdk.platformtools.v;

public final class g {
    private static g cJY = null;
    private static Context mContext;

    public static class a extends Exception {
    }

    private g() {
    }

    public static g aQ(Context context) {
        if (cJY == null) {
            cJY = new g();
        }
        mContext = context;
        return cJY;
    }

    public static void Gc() {
        v.d("MicroMsg.SLocationManager", "removeUpdate");
        TencentLocationManager.getInstance(mContext).removeUpdates(null);
    }

    public static void a(TencentLocationListener tencentLocationListener, int i, Looper looper) {
        v.d("MicroMsg.SLocationManager", "requestLocationUpdate %s, isLoaded %b", Integer.valueOf(i), Boolean.valueOf(TencentLocationManagerOptions.isLoadLibraryEnabled()));
        TencentLocationManager.getInstance(mContext).setCoordinateType(i);
        TencentLocationRequest create = TencentLocationRequest.create();
        create.setInterval(2000);
        int requestLocationUpdates = TencentLocationManager.getInstance(mContext).requestLocationUpdates(create, tencentLocationListener, looper);
        v.i("MicroMsg.SLocationManager", "requestCode %d", Integer.valueOf(requestLocationUpdates));
    }
}
