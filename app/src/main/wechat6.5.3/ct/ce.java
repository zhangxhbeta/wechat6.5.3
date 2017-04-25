package ct;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.tencent.map.geolocation.TencentLocation;
import ct.b.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

final class ce extends BroadcastReceiver {
    private static Handler f;
    private static final Comparator<ScanResult> j = new Comparator<ScanResult>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((ScanResult) obj2).level - ((ScanResult) obj).level;
        }
    };
    private volatile boolean a;
    private final bk b;
    private final WifiManager c;
    private long d;
    private HashSet<String> e;
    private List<ScanResult> g;
    private final Runnable h;
    private final Object i = new Object();

    public ce(bk bkVar) {
        this.b = bkVar;
        this.c = bkVar.b();
        this.e = new HashSet();
        this.h = new Runnable(this) {
            private /* synthetic */ ce a;

            {
                this.a = r1;
            }

            public final void run() {
                this.a.c();
                this.a.a(this.a.b.g().m);
                a.b("TxWifiProvider", "Interval:" + this.a.b.g().m);
            }
        };
    }

    public final void a(Handler handler) {
        if (!this.a) {
            this.a = true;
            f = handler;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            try {
                this.b.a.registerReceiver(this, intentFilter, null, handler);
            } catch (Throwable e) {
                a.a("TxWifiProvider", "listenWifiState: failed", e);
            }
            a(0);
            a.a("TxWifiProvider", "startup: state=[start]");
        }
    }

    public final void a() {
        synchronized (this.i) {
            if (this.a) {
                this.a = false;
                f.removeCallbacksAndMessages(null);
                try {
                    this.b.a.unregisterReceiver(this);
                    a.b("TxWifiProvider", "unregisterReceiver success");
                } catch (Exception e) {
                    a.b("TxWifiProvider", "unregisterReceiver failed");
                }
                this.d = 0;
                this.e = null;
                if (this.g != null) {
                    this.g.clear();
                }
                if (this.e != null) {
                    this.e.clear();
                }
                a.a("TxWifiProvider", "shutdown: state=[shutdown]");
                return;
            }
        }
    }

    public final int b() {
        return c() ? 0 : 1;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                synchronized (this.i) {
                    String action = intent.getAction();
                    a.a("TxWifiProvider", "onReceive " + action);
                    if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action)) {
                        e();
                    }
                    if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action) || "android.net.wifi.SCAN_RESULTS".equals(action)) {
                        Collection b = da.b(this.c);
                        if (b != null && b.size() > 0) {
                            this.g = new ArrayList(b);
                            cf.a(this.g);
                            if (this.g != null && this.g.size() > 0) {
                                Collections.sort(this.g, j);
                                d();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                a.b("TxWifiProvider", e.toString());
            }
        }
    }

    public final void a(long j) {
        a.b("TxWifiProvider", "ScanInterval:" + j);
        Handler handler = f;
        Runnable runnable = this.h;
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, j);
    }

    private boolean c() {
        if (da.a(this.b)) {
            return da.a(this.c);
        }
        return false;
    }

    private void d() {
        Thread.currentThread().getName();
        if (this.e == null) {
            this.e = new HashSet();
        }
        if (this.e.size() == 0) {
            for (ScanResult scanResult : this.g) {
                this.e.add(scanResult.toString());
            }
            this.d = System.currentTimeMillis();
            a.b("TxWifiProvider", "first receiver");
            a(this.g);
            return;
        }
        int size = this.e.size();
        if (size != this.g.size()) {
            this.e.clear();
            for (ScanResult scanResult2 : this.g) {
                this.e.add(scanResult2.BSSID + scanResult2.level);
            }
            this.d = System.currentTimeMillis();
            a.b("TxWifiProvider", "size not same");
            a(this.g);
            return;
        }
        for (ScanResult scanResult22 : this.g) {
            this.e.add(scanResult22.BSSID + scanResult22.level);
        }
        if (size != this.e.size()) {
            this.e.clear();
            for (ScanResult scanResult222 : this.g) {
                this.e.add(scanResult222.BSSID + scanResult222.level);
            }
            this.d = System.currentTimeMillis();
            a.b("TxWifiProvider", "size same,but mac is not same");
            a(this.g);
            return;
        }
        a.b("TxWifiProvider", "size same,mac and rssi same");
    }

    private void a(List<ScanResult> list) {
        if (list == null || list.size() == 0) {
            e();
        } else if (da.a) {
            da.a = false;
            e();
        }
        long j = this.d;
        this.c.getWifiState();
        this.b.c(new ck(list, j));
    }

    private void e() {
        int i = 1;
        int wifiState = this.c.getWifiState();
        if (wifiState == 3) {
            a(0);
        } else if (wifiState == 1) {
            i = 0;
            if (this.g != null) {
                this.g.clear();
            }
            this.b.c(ck.a);
        } else {
            i = -1;
        }
        try {
            if (!(VERSION.SDK_INT < 23 || this.b.c().isProviderEnabled(TencentLocation.NETWORK_PROVIDER) || this.b.c().isProviderEnabled("gps"))) {
                i = 5;
            }
        } catch (Exception e) {
        }
        Object message = new Message();
        message.what = 12999;
        message.arg1 = 12001;
        message.arg2 = i;
        this.b.c(message);
    }
}
