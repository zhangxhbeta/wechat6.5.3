package com.tencent.mm.booter.cache;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class CacheService extends Service {
    public void onCreate() {
        super.onCreate();
        a.prepare();
    }

    public void onDestroy() {
        super.onDestroy();
        a.destroy();
    }

    public IBinder onBind(Intent intent) {
        return a.bYR;
    }
}
