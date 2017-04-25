package ct;

import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.map.geolocation.TencentDistanceAnalysis;
import com.tencent.map.geolocation.TencentDistanceListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.eclipse.jdt.annotation.Nullable;

public final class by {
    private static SparseArray<String> a;
    private int A = 0;
    private int B = 0;
    private int C = 0;
    private TencentLocation D;
    private TencentDistanceListener E;
    private boolean F = false;
    private final Object G = new Object();
    private final TencentLocationRequest H = TencentLocationRequest.create();
    private cs I;
    private double J;
    private double K;
    private cs L;
    private int M = TencentLocation.ERROR_UNKNOWN;
    private final boolean N;
    private boolean O;
    private long P;
    private long Q;
    private String R;
    private int b = 1;
    private a c;
    private final bt d;
    private final b e;
    private final boolean f;
    private final bx g;
    private final ce h;
    private final bv i;
    private final ca j;
    private final cc k;
    private HandlerThread l;
    private int m = 0;
    private cd n;
    private final bm o;
    private cg p;
    private ck q;
    private ch r;
    private final bk s;
    private TencentLocationListener t;
    private TencentLocationListener u;
    private String v = "stop";
    private volatile boolean w = false;
    private volatile boolean x = false;
    private boolean y = false;
    private double z = 0.0d;

    class a extends Handler {
        private final bz a = bn.c();
        private int b;
        private long c = 0;
        private boolean d = false;
        private boolean e = false;
        private /* synthetic */ by f;

        a(by byVar, Looper looper) {
            this.f = byVar;
            super(looper);
            byVar.s;
        }

        public final void a() {
            removeCallbacksAndMessages(null);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r13) {
            /*
            r12 = this;
            r0 = r12.f;
            r1 = r0.G;
            monitor-enter(r1);
            r0 = r12.f;	 Catch:{ all -> 0x0037 }
            r0 = r0.t;	 Catch:{ all -> 0x0037 }
            if (r0 != 0) goto L_0x0011;
        L_0x000f:
            monitor-exit(r1);	 Catch:{ all -> 0x0037 }
        L_0x0010:
            return;
        L_0x0011:
            r0 = r12.f;	 Catch:{ all -> 0x0037 }
            r8 = r0.t;	 Catch:{ all -> 0x0037 }
            monitor-exit(r1);	 Catch:{ all -> 0x0037 }
            r0 = r12.f;
            r9 = r0.H;
            r1 = r9.getRequestLevel();
            r6 = r9.getInterval();
            r0 = r13.what;
            switch(r0) {
                case 555: goto L_0x002c;
                case 3997: goto L_0x016b;
                case 3998: goto L_0x03cb;
                case 3999: goto L_0x0215;
                case 4998: goto L_0x061f;
                case 4999: goto L_0x0417;
                case 7999: goto L_0x015a;
                case 11998: goto L_0x00e0;
                case 11999: goto L_0x003a;
                default: goto L_0x002b;
            };
        L_0x002b:
            goto L_0x0010;
        L_0x002c:
            r0 = r12.f;
            r0.q = null;
            r0 = 3999; // 0xf9f float:5.604E-42 double:1.976E-320;
            r12.sendEmptyMessage(r0);
            goto L_0x0010;
        L_0x0037:
            r0 = move-exception;
            monitor-exit(r1);
            throw r0;
        L_0x003a:
            r0 = r12.f;
            r0 = r0.I;
            if (r0 == 0) goto L_0x00d3;
        L_0x0042:
            r0 = r9.getInterval();
            r2 = 0;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 <= 0) goto L_0x00d3;
        L_0x004c:
            r0 = r12.f;
            r0 = r0.v;
            if (r0 == 0) goto L_0x00d3;
        L_0x0054:
            r0 = r12.f;
            r0 = r0.v;
            r1 = "start";
            r0 = r0.equalsIgnoreCase(r1);
            if (r0 == 0) goto L_0x00d3;
        L_0x0063:
            r0 = r12.f;
            r1 = r12.f;
            r1 = r1.I;
            r0.a(r1);
            r0 = r12.f;
            r1 = r0.I;
            r0 = r12.f;
            r2 = r0.M;
            r0 = ct.by.a;
            r3 = r12.f;
            r3 = r3.M;
            r0 = r0.get(r3);
            r0 = (java.lang.String) r0;
            r8.onLocationChanged(r1, r2, r0);
            r0 = r12.f;
            r0 = r0.y;
            if (r0 == 0) goto L_0x00d3;
        L_0x0095:
            r0 = r12.f;
            r0 = r0.E;
            if (r0 == 0) goto L_0x00d3;
        L_0x009d:
            r0 = r12.f;
            r0 = r0.E;
            r1 = r12.f;
            r1 = r1.I;
            r2 = r12.f;
            r2 = r2.z;
            r4 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
            r2 = r2 / r4;
            r4 = 2;
            r2 = ct.b.a.a(r2, r4);
            r4 = r12.f;
            r4 = r4.M;
            r5 = ct.by.a;
            r8 = r12.f;
            r8 = r8.M;
            r5 = r5.get(r8);
            r5 = (java.lang.String) r5;
            r0.onDistanceChanged(r1, r2, r4, r5);
        L_0x00d3:
            r0 = 0;
            r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
            if (r0 <= 0) goto L_0x0010;
        L_0x00d9:
            r0 = 11999; // 0x2edf float:1.6814E-41 double:5.9283E-320;
            r12.sendEmptyMessageDelayed(r0, r6);
            goto L_0x0010;
        L_0x00e0:
            r0 = r12.f;
            r0 = r0.I;
            if (r0 == 0) goto L_0x0010;
        L_0x00e8:
            r0 = r12.f;
            r1 = r12.f;
            r1 = r1.I;
            r0.a(r1);
            r0 = r12.f;
            r1 = r0.I;
            r0 = r12.f;
            r2 = r0.M;
            r0 = ct.by.a;
            r3 = r12.f;
            r3 = r3.M;
            r0 = r0.get(r3);
            r0 = (java.lang.String) r0;
            r8.onLocationChanged(r1, r2, r0);
            r0 = r12.f;
            r0 = r0.y;
            if (r0 == 0) goto L_0x0010;
        L_0x011a:
            r0 = r12.f;
            r0 = r0.E;
            if (r0 == 0) goto L_0x0010;
        L_0x0122:
            r0 = r12.f;
            r0 = r0.E;
            r1 = r12.f;
            r1 = r1.I;
            r2 = r12.f;
            r2 = r2.z;
            r4 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
            r2 = r2 / r4;
            r4 = 2;
            r2 = ct.b.a.a(r2, r4);
            r4 = r12.f;
            r4 = r4.M;
            r5 = ct.by.a;
            r6 = r12.f;
            r6 = r6.M;
            r5 = r5.get(r6);
            r5 = (java.lang.String) r5;
            r0.onDistanceChanged(r1, r2, r4, r5);
            goto L_0x0010;
        L_0x015a:
            r0 = r12.f;
            r0 = r0.n();
            if (r0 != 0) goto L_0x0010;
        L_0x0162:
            r0 = "TxLocationManagerImpl";
            r2 = "network connected --> prepare json";
            ct.b.a.a(r0, r2);
        L_0x016b:
            r0 = r12.f;
            r0 = ct.by.l(r0);
            r3 = 0;
            r2 = 0;
            if (r0 == 0) goto L_0x0661;
        L_0x0175:
            r2 = r12.f;
            r2 = r2.R;
            r3 = r12.f;
            r3 = r3.s;
            r4 = 0;
            r5 = 0;
            r6 = 0;
            r7 = 0;
            r2 = r0.a(r1, r2, r3, r4, r5, r6, r7);
            r1 = ct.b.a.c(r2);
            if (r1 != 0) goto L_0x01f1;
        L_0x018f:
            r1 = 1;
        L_0x0190:
            if (r0 == 0) goto L_0x0194;
        L_0x0192:
            if (r1 == 0) goto L_0x0204;
        L_0x0194:
            r1 = "TxLocationManagerImpl";
            if (r0 != 0) goto L_0x01f3;
        L_0x0199:
            r0 = "info3 is null";
        L_0x019c:
            ct.b.a.b(r1, r0);
            r0 = r12.f;
            r0 = r0.w;
            if (r0 == 0) goto L_0x0010;
        L_0x01a7:
            r0 = r12.f;
            r0 = r0.u;
            if (r0 == 0) goto L_0x0010;
        L_0x01af:
            r0 = r12.f;
            r0 = r0.M;
            if (r0 != 0) goto L_0x0010;
        L_0x01b7:
            r0 = r12.f;
            r1 = r0.u;
            r0 = r12.f;
            r2 = r0.I;
            r0 = r12.f;
            r3 = r0.M;
            r0 = ct.by.a;
            r4 = r12.f;
            r4 = r4.M;
            r0 = r0.get(r4);
            r0 = (java.lang.String) r0;
            r1.onLocationChanged(r2, r3, r0);
            r0 = r12.f;
            r0.u = null;
            r0 = r12.f;
            r0.w = false;
            r0 = "TxLocationManagerImpl";
            r1 = "Single connectfalse";
            ct.b.a.b(r0, r1);
            goto L_0x0010;
        L_0x01f1:
            r1 = 0;
            goto L_0x0190;
        L_0x01f3:
            r0 = new java.lang.StringBuilder;
            r3 = "handleMessage: bad json ";
            r0.<init>(r3);
            r0 = r0.append(r2);
            r0 = r0.toString();
            goto L_0x019c;
        L_0x0204:
            r1 = r12.f;
            r1 = r1.k;
            r3 = r12.f;
            r3 = r3.b;
            r1.a(r2, r0, r3);
            goto L_0x0010;
        L_0x0215:
            r0 = r12.f;
            r0 = r0.H;
            r0 = r0.getExtras();
            r2 = "daemon";
            r0 = r0.getBoolean(r2);
            if (r0 == 0) goto L_0x0294;
        L_0x0228:
            r0 = r12.f;
            r2 = r0.P;
            r4 = 120000; // 0x1d4c0 float:1.68156E-40 double:5.9288E-319;
            r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r0 >= 0) goto L_0x023a;
        L_0x0235:
            r0 = r12.f;
            r0.P = 120000;
        L_0x023a:
            r0 = "TxLocationManagerImpl";
            r2 = new java.lang.StringBuilder;
            r3 = "the daemonLocation,so we delay long time upload:";
            r2.<init>(r3);
            r3 = r12.f;
            r4 = r3.P;
            r2 = r2.append(r4);
            r3 = ",";
            r2 = r2.append(r3);
            r4 = java.lang.System.currentTimeMillis();
            r2 = r2.append(r4);
            r3 = ",";
            r2 = r2.append(r3);
            r3 = r12.f;
            r4 = r3.Q;
            r2 = r2.append(r4);
            r2 = r2.toString();
            ct.b.a.b(r0, r2);
            r2 = java.lang.System.currentTimeMillis();
            r0 = r12.f;
            r4 = r0.Q;
            r2 = r2 - r4;
            r0 = r12.f;
            r4 = r0.P;
            r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r0 < 0) goto L_0x0010;
        L_0x028b:
            r0 = r12.f;
            r2 = java.lang.System.currentTimeMillis();
            r0.Q = r2;
        L_0x0294:
            r0 = r13.obj;
            if (r0 == 0) goto L_0x02b4;
        L_0x0298:
            r0 = "TxLocationManagerImpl";
            r2 = new java.lang.StringBuilder;
            r3 = "wifi error.";
            r2.<init>(r3);
            r3 = r13.obj;
            r3 = r3.toString();
            r2 = r2.append(r3);
            r2 = r2.toString();
            ct.b.a.b(r0, r2);
        L_0x02b4:
            r0 = r12.f;
            r10 = r0.b;
            r0 = r12.f;
            r0 = ct.by.l(r0);
            if (r0 != 0) goto L_0x02c8;
        L_0x02c2:
            r0 = 2;
            r12.a(r0);
            goto L_0x0010;
        L_0x02c8:
            r2 = r0.b();
            if (r2 == 0) goto L_0x0366;
        L_0x02ce:
            r2 = java.lang.System.currentTimeMillis();
            r4 = r12.c;
            r2 = r2 - r4;
            r4 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
            r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r2 <= 0) goto L_0x0366;
        L_0x02dc:
            r2 = 1;
            r12.d = r2;
            r2 = 0;
            r12.e = r2;
            r2 = java.lang.System.currentTimeMillis();
            r12.c = r2;
        L_0x02e8:
            r2 = r12.f;
            r2 = r2.R;
            r3 = r12.f;
            r3 = r3.s;
            r4 = r12.d;
            r5 = r12.e;
            r6 = r12.f;
            r6 = r6.O;
            r7 = r12.f;
            r7 = r7.H;
            r7 = r7.getExtras();
            r11 = "daemon";
            r7 = r7.getBoolean(r11);
            r3 = r0.a(r1, r2, r3, r4, r5, r6, r7);
            r2 = ct.b.a.c(r3);
            if (r2 != 0) goto L_0x036b;
        L_0x0319:
            r2 = 1;
        L_0x031a:
            if (r2 == 0) goto L_0x0332;
        L_0x031c:
            r4 = "TxLocationManagerImpl";
            r5 = new java.lang.StringBuilder;
            r6 = "handleMessage: bad json ";
            r5.<init>(r6);
            r5 = r5.append(r3);
            r5 = r5.toString();
            ct.b.a.b(r4, r5);
        L_0x0332:
            if (r2 == 0) goto L_0x036d;
        L_0x0334:
            r0 = r12.b;
            r0 = r0 + 1;
            r12.b = r0;
            r0 = r12.b;
            r1 = 2;
            if (r0 < r1) goto L_0x0010;
        L_0x033f:
            r0 = r12.f;
            r0 = r0.o();
            if (r0 != 0) goto L_0x0010;
        L_0x0347:
            r0 = "TxLocationManagerImpl";
            r1 = new java.lang.StringBuilder;
            r2 = "handleMessage: bad json ";
            r1.<init>(r2);
            r1 = r1.append(r3);
            r1 = r1.toString();
            ct.b.a.b(r0, r1);
            r0 = 2;
            r12.a(r0);
            r0 = 0;
            r12.b = r0;
            goto L_0x0010;
        L_0x0366:
            r2 = 0;
            r12.d = r2;
            goto L_0x02e8;
        L_0x036b:
            r2 = 0;
            goto L_0x031a;
        L_0x036d:
            r2 = 0;
            r12.b = r2;
            r2 = r12.f;
            r2 = r2.H;
            r2 = r2.getExtras();
            r4 = "daemon";
            r2 = r2.getBoolean(r4);
            if (r2 != 0) goto L_0x03b4;
        L_0x0383:
            r2 = com.tencent.map.geolocation.internal.TencentExtraKeys.isRequestRawData(r9);
            if (r2 == 0) goto L_0x03b4;
        L_0x0389:
            r0 = new ct.cs$a;
            r0.<init>();
            r2 = 0;
            r0.b = r2;
            r0.c = r1;
            r1 = r0.a();
            r0 = r3.getBytes();
            com.tencent.map.geolocation.internal.TencentExtraKeys.setRawData(r1, r0);
            r0 = r12.f;
            r0.a(r1);
            r2 = 0;
            r0 = ct.by.a;
            r3 = 0;
            r0 = r0.get(r3);
            r0 = (java.lang.String) r0;
            r8.onLocationChanged(r1, r2, r0);
            goto L_0x0010;
        L_0x03b4:
            r1 = com.tencent.map.geolocation.internal.TencentExtraKeys.MOCK_LOCATION_FILTER;
            if (r1 == 0) goto L_0x0010;
        L_0x03b8:
            r1 = r12.f;
            r1 = r1.k;
            r1.a(r3, r0, r10);
            r0 = r12.f;
            r0.o;
            java.lang.System.currentTimeMillis();
            goto L_0x0010;
        L_0x03cb:
            r0 = new ct.ci;
            r9 = 0;
            r10 = 0;
            r2 = new ct.ch;
            r3 = r13.obj;
            r3 = (android.location.Location) r3;
            r4 = java.lang.System.currentTimeMillis();
            r6 = 3;
            r7 = 3;
            r8 = 0;
            r2.<init>(r3, r4, r6, r7, r8);
            r0.<init>(r9, r10, r2);
            r2 = r12.f;
            r2 = r2.R;
            r3 = r12.f;
            r3 = r3.s;
            r4 = 1;
            r5 = 0;
            r6 = 0;
            r7 = r12.f;
            r7 = r7.H;
            r7 = r7.getExtras();
            r8 = "daemon";
            r7 = r7.getBoolean(r8);
            r1 = r0.a(r1, r2, r3, r4, r5, r6, r7);
            r2 = r12.f;
            r2 = r2.k;
            r3 = r12.f;
            r3 = r3.b;
            r2.a(r1, r0, r3);
            goto L_0x0010;
        L_0x0417:
            r0 = r12.f;
            r0 = r0.H;
            r0 = r0.getExtras();
            r2 = "daemon";
            r0 = r0.getBoolean(r2);
            if (r0 == 0) goto L_0x0432;
        L_0x042a:
            r0 = r12.f;
            r1 = 1;
            r0.F = r1;
            goto L_0x0010;
        L_0x0432:
            r0 = 4998; // 0x1386 float:7.004E-42 double:2.4693E-320;
            r12.removeMessages(r0);
            r0 = r13.obj;
            r0 = (android.util.Pair) r0;
            r2 = r0.first;
            r4 = r2.toString();
            r0 = r0.second;
            r0 = (ct.cc.a) r0;
            r2 = r0.a;
            r2 = (ct.ci) r2;
            r5 = r0.b;
            r3 = r2.b();
            if (r3 == 0) goto L_0x0525;
        L_0x0451:
            r3 = "gps";
        L_0x0454:
            r6 = new ct.cs$a;	 Catch:{ JSONException -> 0x052a }
            r6.<init>();	 Catch:{ JSONException -> 0x052a }
            r6.a = r4;	 Catch:{ JSONException -> 0x052a }
            r6.c = r1;	 Catch:{ JSONException -> 0x052a }
            r6.d = r3;	 Catch:{ JSONException -> 0x052a }
            r3 = r6.a();	 Catch:{ JSONException -> 0x052a }
            r1 = r3.getExtra();	 Catch:{ JSONException -> 0x052a }
            r6 = "resp_json";
            r1.putString(r6, r4);	 Catch:{ JSONException -> 0x052a }
            r1 = r3.isMockGps();	 Catch:{ JSONException -> 0x052a }
            r4 = 1;
            if (r1 != r4) goto L_0x0477;
        L_0x0474:
            r1 = 1;
            r12.e = r1;	 Catch:{ JSONException -> 0x052a }
        L_0x0477:
            ct.cs.a(r3);	 Catch:{ JSONException -> 0x052a }
            r1 = r12.f;
            r1 = r1.p;
            ct.cs.a(r3, r1);
            com.tencent.map.geolocation.internal.TencentExtraKeys.setRawQuery(r3, r5);
            r1 = 0;
            r4 = r2.a();
            if (r4 == 0) goto L_0x0493;
        L_0x048d:
            r1 = r2.a();
            r1 = r1.c;
        L_0x0493:
            r2 = r3.getExtra();
            r4 = "sat_num";
            r2.putInt(r4, r1);
            r1 = r3.getExtra();
            r2 = "req_cost";
            r4 = r13.arg1;
            r4 = (long) r4;
            r1.putLong(r2, r4);
            r1 = r3.getExtra();
            r2 = "req_start";
            r4 = r0.c;
            r1.putLong(r2, r4);
            r0 = r12.f;
            r0 = r0.s;
            r1 = "map";
            r0 = r0.a(r1);
            r1 = r3.getExtra();
            r0.b(r1);
            r0 = r12.f;
            r1 = 1;
            r0.F = r1;
            r0 = r12.f;
            r0 = r0.o();
            if (r0 != 0) goto L_0x04de;
        L_0x04d8:
            r0 = r12.f;
            r1 = 0;
            r0.a(r1, r3);
        L_0x04de:
            r0 = r12.f;
            r0 = r0.w;
            if (r0 == 0) goto L_0x0599;
        L_0x04e6:
            r0 = r12.f;
            r0 = r0.u;
            if (r0 == 0) goto L_0x0599;
        L_0x04ee:
            r0 = r12.f;
            r1 = r0.u;
            r2 = 0;
            r0 = ct.by.a;
            r4 = 0;
            r0 = r0.get(r4);
            r0 = (java.lang.String) r0;
            r1.onLocationChanged(r3, r2, r0);
            r0 = r12.f;
            r0.u = null;
            r0 = "TxLocationManagerImpl";
            r1 = "Single response false";
            ct.b.a.b(r0, r1);
            r0 = r12.f;
            r0.w = false;
            r0 = r12.f;
            r0 = r0.x;
            if (r0 == 0) goto L_0x0599;
        L_0x051e:
            r0 = r12.f;
            r0.c();
            goto L_0x0010;
        L_0x0525:
            r3 = "network";
            goto L_0x0454;
        L_0x052a:
            r0 = move-exception;
            r0 = "TxLocationManagerImpl";
            r1 = "handleMessage: location failed";
            ct.b.a.b(r0, r1);
            r0 = r12.a;
            r0 = r0.d();
            r1 = ct.bu.b;
            if (r0 == r1) goto L_0x0547;
        L_0x053e:
            r1 = 3998; // 0xf9e float:5.602E-42 double:1.9753E-320;
            r0 = r12.obtainMessage(r1, r0);
            r0.sendToTarget();
        L_0x0547:
            r0 = r12.f;
            r0 = r0.w;
            if (r0 == 0) goto L_0x0010;
        L_0x054f:
            r0 = r12.f;
            r0 = r0.u;
            if (r0 == 0) goto L_0x0010;
        L_0x0557:
            r0 = r12.f;
            r0 = r0.M;
            if (r0 != 0) goto L_0x0010;
        L_0x055f:
            r0 = r12.f;
            r1 = r0.u;
            r0 = r12.f;
            r2 = r0.I;
            r0 = r12.f;
            r3 = r0.M;
            r0 = ct.by.a;
            r4 = r12.f;
            r4 = r4.M;
            r0 = r0.get(r4);
            r0 = (java.lang.String) r0;
            r1.onLocationChanged(r2, r3, r0);
            r0 = r12.f;
            r0.u = null;
            r0 = r12.f;
            r0.w = false;
            r0 = "TxLocationManagerImpl";
            r1 = "Single connectfalse";
            ct.b.a.b(r0, r1);
            goto L_0x0010;
        L_0x0599:
            r0 = r12.f;
            r0 = r0.O;
            if (r0 == 0) goto L_0x05e8;
        L_0x05a1:
            r0 = r3.getExtra();	 Catch:{ Exception -> 0x05ef, Error -> 0x0607 }
            if (r0 == 0) goto L_0x05e3;
        L_0x05a7:
            r1 = "icontrol";
            r2 = -1;
            r0 = r0.getInt(r1, r2);	 Catch:{ Exception -> 0x05ef, Error -> 0x0607 }
            r1 = r12.f;	 Catch:{ Exception -> 0x05ef, Error -> 0x0607 }
            r1 = r1.s;	 Catch:{ Exception -> 0x05ef, Error -> 0x0607 }
            r1 = r1.a;	 Catch:{ Exception -> 0x05ef, Error -> 0x0607 }
            r2 = "LocationSDK";
            r4 = 0;
            r1 = r1.getSharedPreferences(r2, r4);	 Catch:{ Exception -> 0x05ef, Error -> 0x0607 }
            r2 = "TxLocationManagerImpl";
            r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x05ef, Error -> 0x0607 }
            r5 = "start icontrol:";
            r4.<init>(r5);	 Catch:{ Exception -> 0x05ef, Error -> 0x0607 }
            r4 = r4.append(r0);	 Catch:{ Exception -> 0x05ef, Error -> 0x0607 }
            r4 = r4.toString();	 Catch:{ Exception -> 0x05ef, Error -> 0x0607 }
            ct.b.a.b(r2, r4);	 Catch:{ Exception -> 0x05ef, Error -> 0x0607 }
            r1 = r1.edit();	 Catch:{ Exception -> 0x05ef, Error -> 0x0607 }
            r2 = "control";
            r0 = r1.putInt(r2, r0);	 Catch:{ Exception -> 0x05ef, Error -> 0x0607 }
            r0.apply();	 Catch:{ Exception -> 0x05ef, Error -> 0x0607 }
        L_0x05e3:
            r0 = r12.f;
            r0.O = false;
        L_0x05e8:
            r0 = r12.f;
            r0.L = r3;
            goto L_0x0010;
        L_0x05ef:
            r0 = move-exception;
            r1 = "TxLocationManagerImpl";
            r2 = new java.lang.StringBuilder;
            r4 = "sp:";
            r2.<init>(r4);
            r0 = r2.append(r0);
            r0 = r0.toString();
            ct.b.a.b(r1, r0);
            goto L_0x05e3;
        L_0x0607:
            r0 = move-exception;
            r1 = "TxLocationManagerImpl";
            r2 = new java.lang.StringBuilder;
            r4 = "error:";
            r2.<init>(r4);
            r0 = r2.append(r0);
            r0 = r0.toString();
            ct.b.a.b(r1, r0);
            goto L_0x05e3;
        L_0x061f:
            r0 = r12.f;
            r1 = 0;
            r0.F = r1;
            r0 = "TxLocationManagerImpl";
            r1 = new java.lang.StringBuilder;
            r2 = "timeout";
            r1.<init>(r2);
            r2 = r12.f;
            r2 = r2.w;
            r1 = r1.append(r2);
            r2 = r12.f;
            r2 = r2.u;
            r1 = r1.append(r2);
            r1 = r1.toString();
            ct.b.a.b(r0, r1);
            r0 = r12.f;
            r0 = r0.M;
            if (r0 == 0) goto L_0x065b;
        L_0x0653:
            r0 = r12.f;
            r1 = 1;
            r2 = ct.cs.a;
            r0.a(r1, r2);
        L_0x065b:
            r0 = 1;
            r12.a(r0);
            goto L_0x0010;
        L_0x0661:
            r1 = r2;
            r2 = r3;
            goto L_0x0190;
            */
            throw new UnsupportedOperationException("Method not decompiled: ct.by.a.handleMessage(android.os.Message):void");
        }

        private void a(int i) {
            if (this.f.w && this.f.u != null) {
                if (this.f.M == 0) {
                    this.f.u.onLocationChanged(this.f.I, this.f.M, (String) by.a.get(this.f.M));
                } else {
                    this.f.u.onLocationChanged(cs.a, i, (String) by.a.get(i));
                }
                this.f.u = null;
                this.f.w = false;
                if (this.f.x) {
                    this.f.c();
                } else {
                    ct.b.a.b("TxLocationManagerImpl", "Single timeoutfalse");
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ ct.ci l(ct.by r9) {
        /*
        r1 = 0;
        r2 = r9.q;
        r0 = r9.p;
        r3 = r9.r;
        if (r3 == 0) goto L_0x0010;
    L_0x0009:
        r4 = r9.o();
        if (r4 != 0) goto L_0x0010;
    L_0x000f:
        r3 = r1;
    L_0x0010:
        if (r0 != 0) goto L_0x0028;
    L_0x0012:
        r0 = r9.s;
        r4 = android.os.Build.VERSION.SDK_INT;
        r5 = 17;
        if (r4 < r5) goto L_0x00a6;
    L_0x001a:
        r4 = ct.ct.a(r0);
        r5 = ct.ct.a(r4);
        if (r5 == 0) goto L_0x0096;
    L_0x0024:
        r0 = ct.cg.a(r0, r4);
    L_0x0028:
        if (r2 == 0) goto L_0x0038;
    L_0x002a:
        r4 = java.lang.System.currentTimeMillis();
        r6 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r4 = r2.a(r4, r6);
        if (r4 != 0) goto L_0x0038;
    L_0x0037:
        r2 = r1;
    L_0x0038:
        if (r0 == 0) goto L_0x00b6;
    L_0x003a:
        if (r3 == 0) goto L_0x00b6;
    L_0x003c:
        r4 = r0.d;
        r5 = r0.e;
        r6 = r3.a;
        r7 = new android.os.Bundle;
        r7.<init>();
        r8 = "lac";
        r7.putInt(r8, r4);
        r8 = "cid";
        r7.putInt(r8, r5);
        r8 = "location";
        r7.putParcelable(r8, r6);
        r6 = r9.s;
        r8 = "cell";
        r6 = r6.a(r8);
        r6 = r6.b(r7);
        if (r6 != 0) goto L_0x00b6;
    L_0x0068:
        r0 = "TxLocationManagerImpl";
        r6 = new java.lang.StringBuilder;
        r7 = "getFromLastKnownInfo: discard bad cell(";
        r6.<init>(r7);
        r4 = r6.append(r4);
        r6 = ",";
        r4 = r4.append(r6);
        r4 = r4.append(r5);
        r5 = ")";
        r4 = r4.append(r5);
        r4 = r4.toString();
        ct.b.a.a(r0, r4);
    L_0x0090:
        r0 = new ct.ci;
        r0.<init>(r2, r1, r3);
        return r0;
    L_0x0096:
        r4 = ct.ct.b(r0);
        r0 = ct.cg.a(r0, r4, r1);
        r4 = ct.ct.a(r0);
        if (r4 != 0) goto L_0x0028;
    L_0x00a4:
        r0 = r1;
        goto L_0x0028;
    L_0x00a6:
        r4 = ct.ct.b(r0);
        r0 = ct.cg.a(r0, r4, r1);
        r4 = ct.ct.a(r0);
        if (r4 == 0) goto L_0x00a4;
    L_0x00b4:
        goto L_0x0028;
    L_0x00b6:
        r1 = r0;
        goto L_0x0090;
        */
        throw new UnsupportedOperationException("Method not decompiled: ct.by.l(ct.by):ct.ci");
    }

    static {
        SparseArray sparseArray = new SparseArray();
        a = sparseArray;
        sparseArray.put(0, "OK");
        a.put(1, "ERROR_NETWORK");
        a.put(2, "BAD_JSON");
        a.put(4, "DEFLECT_FAILED");
    }

    private boolean h() {
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
        boolean booleanValue;
        try {
            booleanValue = ((Boolean) newFixedThreadPool.submit(new Callable<Boolean>(this) {
                private /* synthetic */ by a;

                {
                    this.a = r1;
                }

                public final /* synthetic */ Object call() {
                    if (ct.a(this.a.s) != null) {
                        return Boolean.valueOf(true);
                    }
                    ct.b.a.b("TxLocationManagerImpl", "SDK=" + VERSION.SDK_INT + "but get no cell");
                    return Boolean.valueOf(false);
                }
            }).get(500, TimeUnit.MILLISECONDS)).booleanValue();
            return booleanValue;
        } catch (TimeoutException e) {
            booleanValue = e;
            return false;
        } catch (Exception e2) {
            booleanValue = e2;
            return false;
        } finally {
            newFixedThreadPool.shutdown();
        }
    }

    public by(bk bkVar) {
        Object obj = null;
        this.s = bkVar;
        if (bkVar.g().t) {
            cv.a(bkVar.a);
        }
        this.o = bn.b();
        this.j = new ca(this.s);
        this.k = new cc(this.s);
        this.n = new cd();
        this.i = bv.a(bkVar.a);
        this.f = h();
        if (this.f) {
            this.d = null;
            this.h = j();
            if (this.s.d()) {
                obj = new b(this.s);
            } else {
                ct.b.a.b("TxLocationManagerImpl", "createNewCellProvider: failed");
            }
            this.e = obj;
            Object[] objArr = new Object[1];
            bx i = i();
            this.g = i;
            objArr[0] = i;
            this.N = ct.b.a.a(obj, objArr);
            return;
        }
        this.e = null;
        this.h = j();
        if (this.s.d()) {
            obj = new bt(this.s);
        } else {
            ct.b.a.b("TxLocationManagerImpl", "createCellProvider: failed");
        }
        this.d = obj;
        objArr = new Object[1];
        i = i();
        this.g = i;
        objArr[0] = i;
        this.N = ct.b.a.a(obj, objArr);
    }

    @Nullable
    private bx i() {
        if (this.s.f()) {
            return new bx(this.s);
        }
        ct.b.a.b("TxLocationManagerImpl", "createGpsProvider: failed");
        return null;
    }

    @Nullable
    private ce j() {
        if (this.s.e()) {
            return new ce(this.s);
        }
        ct.b.a.b("TxLocationManagerImpl", "createWifiProvider: failed");
        return null;
    }

    private static String a(String str) {
        Object obj = 1;
        if (str.contains(",")) {
            try {
                String[] split = str.split(",");
                if (split == null || split.length <= 1 || split[0] == null || split[1] == null || e.w(split[0], split[1]) <= 0) {
                    obj = null;
                }
                return obj != null ? split[0] : SQLiteDatabase.KeyEmpty;
            } catch (UnsatisfiedLinkError e) {
                return null;
            }
        }
        int v = e.v(str);
        return v >= 0 ? Integer.toString(v) : SQLiteDatabase.KeyEmpty;
    }

    public final int a(TencentDistanceListener tencentDistanceListener) {
        if (this.t == null) {
            return 1;
        }
        if (this.y) {
            return 2;
        }
        this.y = true;
        this.E = tencentDistanceListener;
        return 0;
    }

    public final int a(TencentLocationListener tencentLocationListener, Looper looper) {
        ct.b.a.b("TxLocationManagerImpl", "Single click:");
        if (this.w) {
            if (tencentLocationListener != null && this.M == 0) {
                tencentLocationListener.onLocationChanged(this.I, this.M, (String) a.get(this.M));
            }
            ct.b.a.b("TxLocationManagerImpl", "Single return");
            return 5;
        }
        this.w = true;
        if (tencentLocationListener != null) {
            this.u = tencentLocationListener;
            if (this.M != 0 || this.I == null || ((!this.I.getProvider().equals("gps") || System.currentTimeMillis() - this.I.getTime() > 90000) && (!this.I.getProvider().equals(TencentLocation.NETWORK_PROVIDER) || System.currentTimeMillis() - this.I.getTime() > 10000))) {
                int a;
                if (this.v == null || !this.v.equals("start")) {
                    this.x = true;
                    a = a(TencentLocationRequest.create().setInterval(5000), new TencentLocationListener() {
                        public final void onStatusUpdate(String str, int i, String str2) {
                        }

                        public final void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
                        }
                    }, looper);
                } else {
                    this.x = false;
                    ct.b.a.b("TxLocationManagerImpl", "Single send");
                    b(3997);
                    a = 0;
                }
                return a;
            }
            try {
                Thread.sleep((long) (((int) (Math.random() * 100.0d)) + 100));
            } catch (Exception e) {
            }
            if (this.u != null) {
                this.u.onLocationChanged(this.I, this.M, (String) a.get(this.M));
                this.u = null;
            }
            ct.b.a.b("TxLocationManagerImpl", "Single cache false");
            this.w = false;
            return 0;
        }
        ct.b.a.b("TxLocationManagerImpl", "Single 4 false");
        this.w = false;
        return 4;
    }

    public final int a(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        if (this.m == 1) {
            c();
            if (this.l != null) {
                this.l.quit();
                this.l = null;
            }
            this.m = 0;
        }
        if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {
            try {
                System.loadLibrary("tencentloc");
            } catch (Throwable e) {
                ct.b.a.a("TencentLocationSDK", "load library", e);
                return 3;
            }
        }
        bl g = this.s.g();
        String b = ct.b.a.b(g.h);
        this.R = a(b);
        if (TextUtils.isEmpty(this.R)) {
            ct.b.a.b("TxLocationManagerImpl", "requestLocationUpdates: illegal key [" + b + "]");
            return 2;
        } else if (this.N) {
            return 1;
        } else {
            m();
            synchronized (this.G) {
                this.t = tencentLocationListener;
            }
            TencentLocationRequest.copy(this.H, tencentLocationRequest);
            g.g = tencentLocationRequest.getQQ();
            if (TextUtils.isEmpty(ct.b.a.b(g.e))) {
                g.e = tencentLocationRequest.getPhoneNumber();
            }
            g.m = Math.max(5000, tencentLocationRequest.getInterval() == 0 ? 2 : tencentLocationRequest.getInterval());
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            if (ct.b.a.a(this.c)) {
                this.c = new a(this, looper);
            } else {
                this.c.removeCallbacksAndMessages(null);
                if (this.c.getLooper() != looper) {
                    this.c = new a(this, looper);
                }
            }
            l();
            k();
            this.v = "start";
            return 0;
        }
    }

    private void k() {
        boolean z = true;
        this.s.a((Object) this);
        boolean z2 = this.H.getExtras().getBoolean("use_network", true);
        Handler handler = this.c;
        this.j.a();
        cc ccVar = this.k;
        if (!ccVar.g) {
            ccVar.g = true;
            ccVar.b.h().execute(new ct.cc.AnonymousClass1(ccVar, handler));
            ccVar.f = SystemClock.elapsedRealtime();
        }
        cc ccVar2 = this.k;
        String i = this.s.i();
        SystemClock.elapsedRealtime();
        try {
            if (!TextUtils.isEmpty(i)) {
                boolean offer;
                byte[] a = cc.a(i.getBytes("UTF-8"));
                e.o(a, 2);
                a aVar = new a(2, a, "http://ue.indoorloc.map.qq.com", null);
                aVar.b = i;
                if (aVar.f != null) {
                    offer = ccVar2.a.offer(aVar);
                } else {
                    offer = false;
                }
                if (!offer) {
                    ccVar2.a.clear();
                    ccVar2.a.offer(aVar);
                    ct.b.a.b("TxRequestSender", "postLocationRequest: failed to add request,because the queue has full,so we delete the first");
                }
            }
        } catch (Throwable e) {
            ct.b.a.a("TxRequestSender", SQLiteDatabase.KeyEmpty, e);
        } catch (Throwable e2) {
            ct.b.a.a("TxRequestSender", SQLiteDatabase.KeyEmpty, e2);
        }
        if (this.f) {
            if (z2 && ct.b.a.b(this.e)) {
                this.e.a();
            }
        } else if (z2 && ct.b.a.b(this.d)) {
            this.d.a();
        }
        if (z2 && ct.b.a.b(this.h)) {
            this.h.a(handler);
        }
        if (!this.H.getExtras().getBoolean("daemon")) {
            this.O = true;
        }
        if (ct.b.a.b(this.g) && this.H.isAllowGPS()) {
            long interval;
            bx bxVar = this.g;
            if (this.b != 1) {
                z = false;
            }
            bxVar.a(z);
            if (this.H.getInterval() < 5000) {
                interval = this.H.getInterval();
            } else {
                interval = 5000;
            }
            this.g.a(interval, this.H.getExtras().getBoolean("daemon"));
        }
        if (this.H.isAllowDirection()) {
            this.i.a(handler);
        }
    }

    public final TencentLocation a() {
        if (this.M != 0) {
            return null;
        }
        a(this.I);
        return this.I;
    }

    private final void a(cs csVar) {
        if (csVar != null) {
            if (this.H.isAllowDirection()) {
                csVar.getExtra().putDouble(TencentLocation.EXTRA_DIRECTION, this.i.b());
            }
            try {
                csVar.getExtra().putAll(this.H.getExtras());
            } catch (Exception e) {
            }
        }
    }

    public final TencentDistanceAnalysis b() {
        this.E = null;
        this.z = 0.0d;
        this.y = false;
        this.D = null;
        TencentDistanceAnalysis cnVar = new cn();
        cnVar.a(ct.b.a.a(((double) (this.A + 1)) / ((double) (this.C + 1)), 4) * 100.0d);
        cnVar.a(this.A);
        cnVar.b(this.B);
        this.A = 0;
        this.B = 0;
        this.C = 0;
        return cnVar;
    }

    public final void c() {
        l();
        this.s.b((Object) this);
        if (ct.b.a.b(this.c)) {
            this.c.a();
        }
        synchronized (this.G) {
            this.t = null;
        }
        this.o.a();
        m();
        this.v = "stop";
        if (this.m == 0) {
            try {
                int i = this.s.a.getSharedPreferences("LocationSDK", 0).getInt("control", -1);
                ct.b.a.b("TxLocationManagerImpl", "read sp control:" + i);
                if (i == -1) {
                    ct.b.a.b("TxLocationManagerImpl", "control is -1 ,so we no start");
                } else if (i >= 120) {
                    this.P = (long) (i * 1000);
                    if (da.b(this.s).equalsIgnoreCase("{}")) {
                        this.l = new HandlerThread("daemonthread");
                        this.l.start();
                        TencentLocationRequest requestLevel = TencentLocationRequest.create().setInterval(this.P).setRequestLevel(0);
                        requestLevel.getExtras().putBoolean("daemon", true);
                        a(requestLevel, new TencentLocationListener() {
                            public final void onStatusUpdate(String str, int i, String str2) {
                            }

                            public final void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
                            }
                        }, this.l.getLooper());
                        this.m = 1;
                        this.Q = System.currentTimeMillis();
                    }
                }
            } catch (Exception e) {
                ct.b.a.b("TxLocationManagerImpl", "sp ex:" + e);
            }
        }
    }

    public final String d() {
        if (!this.v.equalsIgnoreCase("pause")) {
            return "warning!!!resume failed.only when the machine has paused, can resume!";
        }
        k();
        this.v = "start";
        return "success";
    }

    public final String e() {
        if (!this.v.equalsIgnoreCase("start")) {
            return "warning!!!pause failed.only when the machine has started, can pause!";
        }
        l();
        this.v = "pause";
        return "success";
    }

    private void l() {
        ct.a = false;
        this.j.b();
        cc ccVar = this.k;
        if (ccVar.g) {
            ccVar.g = false;
            ccVar.a.clear();
            ccVar.a.offer(a.d);
            if (ccVar.f != 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - ccVar.f;
                Object[] objArr = new Object[]{Long.valueOf(elapsedRealtime / 1000), Long.valueOf(ccVar.d), Long.valueOf(ccVar.e), Long.valueOf(ccVar.c)};
                ct.b.a.a("TxRequestSender", String.format(Locale.ENGLISH, "shutdown: duration=%ds, sent=%dB, recv=%dB, reqCount=%d", objArr));
            }
            ccVar.c = 0;
            ccVar.d = 0;
            ccVar.e = 0;
            ccVar.f = 0;
        }
        this.n.a();
        if (ct.b.a.b(this.h)) {
            this.h.a();
        }
        if (this.f) {
            if (ct.b.a.b(this.e)) {
                this.e.b();
            }
        } else if (ct.b.a.b(this.d)) {
            this.d.b();
        }
        if (ct.b.a.b(this.g)) {
            this.g.a();
        }
        if (this.H.isAllowDirection()) {
            this.i.a();
        }
    }

    private void m() {
        this.I = null;
        this.M = TencentLocation.ERROR_UNKNOWN;
        this.q = null;
        this.p = null;
        this.r = null;
        ci.a = 0;
        this.s.a("cell").a();
    }

    private void a(int i, cs csVar) {
        Object obj = null;
        if (csVar != null) {
            if (!(i != 0 || csVar.getLatitude() == 0.0d || csVar.getLongitude() == 0.0d)) {
                int i2;
                if (this.b == 1 && cu.a(csVar.getLatitude(), csVar.getLongitude())) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                cs.a(csVar, i2);
            }
            if (n()) {
                Object obj2;
                if (this.M == 0 || i != 0) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                this.M = i;
                this.I = csVar;
                if (csVar.getAccuracy() < 5000.0f && csVar.getAccuracy() > 0.0f) {
                    this.n.a(csVar);
                    if (this.y) {
                        this.D = csVar;
                    }
                }
                this.J = csVar.getLatitude();
                this.K = csVar.getLongitude();
                if (ct.b.a.b(this.t) && this.H.getInterval() > 0) {
                    a(11999, this.H.getInterval());
                }
                if (obj2 != null) {
                    b(11998);
                }
            } else if (i == 0 && csVar.getLatitude() != 0.0d && csVar.getLongitude() != 0.0d && Math.abs(csVar.getLatitude() - this.J) >= 1.0E-8d && Math.abs(csVar.getLongitude() - this.K) >= 1.0E-8d) {
                cd cdVar = this.n;
                bk bkVar = this.s;
                this.g.c();
                if (cdVar.a((TencentLocation) csVar, bkVar)) {
                    this.J = csVar.getLatitude();
                    this.K = csVar.getLongitude();
                    if (csVar.getAccuracy() < 5000.0f && csVar.getAccuracy() > 0.0f) {
                        this.n.b();
                        this.n.a(csVar);
                        if (this.y) {
                            if (this.D != null) {
                                double a = ct.b.a.a(this.D.getLatitude(), this.D.getLongitude(), csVar.getLatitude(), csVar.getLongitude());
                                if ((csVar.getProvider().equalsIgnoreCase(TencentLocation.NETWORK_PROVIDER) && a > 10.0d) || (csVar.getProvider().equalsIgnoreCase("gps") && a > 3.0d)) {
                                    this.z = a + this.z;
                                    if (csVar.getProvider().equalsIgnoreCase(TencentLocation.NETWORK_PROVIDER)) {
                                        this.B++;
                                    } else {
                                        this.A++;
                                    }
                                    this.C++;
                                    this.D = csVar;
                                }
                            } else {
                                this.D = csVar;
                            }
                        }
                    }
                } else {
                    ct.b.a.a("TxLocationManagerImpl", "discard " + csVar);
                    return;
                }
            }
            if (this.M != 0 && i == 0) {
                obj = 1;
            }
            if (this.M == 0 && this.I != null && this.I.getProvider().equals(TencentLocation.NETWORK_PROVIDER) && i == 0 && csVar != null && csVar.getProvider().equals("gps")) {
                obj = 1;
            }
            this.M = i;
            this.I = csVar;
            if (this.H.getInterval() == 0 && ct.b.a.b(this.t)) {
                b(11998);
            }
            if (obj != null && ct.b.a.b(this.t)) {
                b(11998);
            }
        }
    }

    private boolean n() {
        return this.M == TencentLocation.ERROR_UNKNOWN;
    }

    private boolean o() {
        boolean z = false;
        if (this.g != null && this.g.c() && this.g.b()) {
            z = true;
        }
        if (!z) {
            ct.b.a.b("TxLocationManagerImpl", "isGpsValid: provider=false");
        }
        return z;
    }

    public final void a(int i) {
        if (this.b != i) {
            this.b = i;
        }
    }

    public final int f() {
        return this.b;
    }

    private void b(int i) {
        if (this.c != null) {
            this.c.sendEmptyMessage(i);
        } else {
            ct.b.a.b("TxLocationManagerImpl", "mHandler is null");
        }
    }

    private void a(int i, long j) {
        if (this.c != null) {
            this.c.removeMessages(i);
            this.c.sendEmptyMessageDelayed(i, j);
        }
    }

    public final void onCellInfoEvent(cg cgVar) {
        int i;
        int i2;
        int i3 = cgVar.e;
        int i4 = cgVar.f;
        cg cgVar2 = this.p;
        if (cgVar2 != null) {
            i = cgVar2.f;
            i2 = cgVar2.e;
        } else {
            i = 0;
            i2 = 0;
        }
        this.p = cgVar;
        int b = this.h != null ? this.h.b() : 1;
        if (b != 0) {
            this.q = null;
        }
        if (b != 0 || (this.q != null && !this.q.a(System.currentTimeMillis(), 30000))) {
            b(3999);
        } else if (this.c != null) {
            this.c.sendMessageDelayed(this.c.obtainMessage(3999, "wifi_not_received"), 2000);
        }
        String str = "TxLocationManagerImpl";
        String str2 = "onCellChanged: %d(%d)-->%d(%d) (%d)%s";
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Integer.valueOf(i4);
        objArr[4] = Integer.valueOf(b);
        objArr[5] = b == 0 ? "scan wifi" : "prepare json. wifi is not scannable?";
        ct.b.a.a(str, String.format(str2, objArr));
    }

    public final void onWifiInfoEvent(ck ckVar) {
        if (this.c != null) {
            this.c.removeMessages(3999, "wifi_not_received");
        }
        if (ckVar == ck.a) {
            ct.b.a.a("TxLocationManagerImpl", "onWifiChanged --> clear wifi if needed");
            a(555, 1500);
            return;
        }
        if (this.q == null || !this.F || ckVar.a().size() < 3 || !this.q.a(ckVar)) {
            ct.b.a.a("TxLocationManagerImpl", "onWifiChanged: --> prepare json");
            b(3999);
        }
        this.q = ckVar;
    }

    public final void onGpsInfoEvent(ch chVar) {
        double d = 0.0d;
        if (chVar.a != bu.b) {
            double d2;
            this.r = chVar;
            bw.a().a(chVar);
            int i = this.b;
            int requestLevel = this.H.getRequestLevel();
            cs csVar = this.L;
            Location location = new Location(chVar.a);
            Bundle extras = location.getExtras();
            if (extras != null) {
                d2 = extras.getDouble("lat");
                d = extras.getDouble("lng");
            } else {
                d2 = 0.0d;
            }
            ct.cs.a aVar;
            cs a;
            if (ct.b.a.a(i)) {
                aVar = new ct.cs.a();
                aVar.b = csVar;
                aVar.d = "gps";
                aVar.c = requestLevel;
                a = aVar.a(new Location(chVar.a)).a();
                location.setLatitude(d2);
                location.setLongitude(d);
                a.a(location);
                a(0, a);
            } else {
                if (n()) {
                    b(3999);
                }
                aVar = new ct.cs.a();
                aVar.b = csVar;
                aVar.d = "gps";
                aVar.c = requestLevel;
                a = aVar.a(new Location(chVar.a)).a();
                location.setLatitude(d2);
                location.setLongitude(d);
                a.a(location);
                a(0, a);
                a(12004, 3);
            }
            if (this.g != null) {
                this.g.b();
            }
        }
    }

    public final void onStatusEvent(Message message) {
        int i = message.what;
        a(message.arg1, message.arg2);
    }

    public final void onNetworkEvent(Integer num) {
        String a = ct.b.a.a(this.s.a);
        switch (num.intValue()) {
            case -1:
                ct.b.a.a("TxLocationManagerImpl", "onNetworkEvent: networks not found");
                return;
            case 0:
                ct.b.a.a("TxLocationManagerImpl", "onNetworkEvent: " + a + " disconnected");
                return;
            case 1:
                ct.b.a.a("TxLocationManagerImpl", "onNetworkEvent: " + a + " connected");
                a(7999, 1000);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r5, int r6) {
        /*
        r4 = this;
        r0 = 0;
        r1 = 2;
        switch(r5) {
            case 12001: goto L_0x0055;
            case 12002: goto L_0x0014;
            case 12003: goto L_0x0038;
            case 12004: goto L_0x0026;
            default: goto L_0x0005;
        };
    L_0x0005:
        r1 = r0;
    L_0x0006:
        r2 = r4.G;
        monitor-enter(r2);
        r3 = r4.t;	 Catch:{ all -> 0x0077 }
        if (r3 == 0) goto L_0x0012;
    L_0x000d:
        r3 = r4.t;	 Catch:{ all -> 0x0077 }
        r3.onStatusUpdate(r1, r6, r0);	 Catch:{ all -> 0x0077 }
    L_0x0012:
        monitor-exit(r2);	 Catch:{ all -> 0x0077 }
        return;
    L_0x0014:
        r1 = "gps";
        switch(r6) {
            case 0: goto L_0x0022;
            case 1: goto L_0x001e;
            default: goto L_0x001a;
        };
    L_0x001a:
        r0 = "unknown";
        goto L_0x0006;
    L_0x001e:
        r0 = "gps enabled";
        goto L_0x0006;
    L_0x0022:
        r0 = "gps disabled";
        goto L_0x0006;
    L_0x0026:
        r1 = "gps";
        switch(r6) {
            case 3: goto L_0x0030;
            case 4: goto L_0x0034;
            default: goto L_0x002c;
        };
    L_0x002c:
        r0 = "unknown";
        goto L_0x0006;
    L_0x0030:
        r0 = "gps available";
        goto L_0x0006;
    L_0x0034:
        r0 = "gps unavailable";
        goto L_0x0006;
    L_0x0038:
        r2 = "cell";
        r0 = 1;
        if (r6 != r0) goto L_0x004b;
    L_0x003e:
        r0 = "cell enabled";
    L_0x0041:
        r3 = ct.ct.a;
        if (r3 == 0) goto L_0x007a;
    L_0x0045:
        r0 = "location permission denied";
        r6 = r1;
        r1 = r2;
        goto L_0x0006;
    L_0x004b:
        if (r6 != 0) goto L_0x0051;
    L_0x004d:
        r0 = "cell disabled";
        goto L_0x0041;
    L_0x0051:
        r0 = "unknown";
        goto L_0x0041;
    L_0x0055:
        r2 = "wifi";
        switch(r6) {
            case 0: goto L_0x006b;
            case 1: goto L_0x006f;
            case 2: goto L_0x005b;
            case 3: goto L_0x005b;
            case 4: goto L_0x005b;
            case 5: goto L_0x0073;
            default: goto L_0x005b;
        };
    L_0x005b:
        r0 = "unknown";
    L_0x005e:
        r3 = 5;
        if (r6 == r3) goto L_0x007a;
    L_0x0061:
        r3 = ct.da.a;
        if (r3 == 0) goto L_0x007a;
    L_0x0065:
        r0 = "location permission denied";
        r6 = r1;
        r1 = r2;
        goto L_0x0006;
    L_0x006b:
        r0 = "wifi disabled";
        goto L_0x005e;
    L_0x006f:
        r0 = "wifi enabled";
        goto L_0x005e;
    L_0x0073:
        r0 = "location service switch is off";
        goto L_0x005e;
    L_0x0077:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x007a:
        r1 = r2;
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: ct.by.a(int, int):void");
    }
}
