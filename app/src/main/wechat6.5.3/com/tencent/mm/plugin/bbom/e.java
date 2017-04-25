package com.tencent.mm.plugin.bbom;

import android.app.Service;
import android.content.IntentFilter;
import com.tencent.mm.booter.TrafficStatsReceiver;
import com.tencent.mm.modelfriend.AddrBookObserver;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.plugin.zero.a.b;
import com.tencent.mm.pluginsdk.a;

public final class e implements b {
    private AddrBookObserver enU;
    private WatchDogPushReceiver enV;
    private TrafficStatsReceiver enW;

    public final void a(Service service) {
        this.enU = new AddrBookObserver(service);
        service.getContentResolver().registerContentObserver(a.bmp(), true, this.enU);
        this.enV = new WatchDogPushReceiver();
        service.registerReceiver(this.enV, new IntentFilter("com.tencent.mm.WatchDogPushReceiver"));
        this.enW = new TrafficStatsReceiver();
        service.registerReceiver(this.enW, new IntentFilter("com.tencent.mm.TrafficStatsReceiver"));
        TrafficStatsReceiver.at(service);
    }

    public final void b(Service service) {
        service.getContentResolver().unregisterContentObserver(this.enU);
        service.unregisterReceiver(this.enV);
        service.unregisterReceiver(this.enW);
        TrafficStatsReceiver.au(service);
    }
}
