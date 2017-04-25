package ct;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellInfo;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.map.geolocation.internal.TencentLog;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tencentmap.lbssdk.service.e;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends PhoneStateListener {
    volatile boolean a;
    private final bk b;
    private CellInfo c = null;
    private SignalStrength d = null;
    private ServiceState e = null;
    private long f;
    private HandlerThread g;
    private Handler h;

    public final class a {
        private static a c;
        public c a;
        public d b = new d();

        public a() {
            this.b.a();
            this.a = new c();
            this.a.a();
        }

        public static x a() {
            return y.a();
        }

        public static void a(Context context, String str, String str2, String str3, List list) {
            a a = h.a(context, str, str2, str3);
            if (a != null) {
                a.a(list);
            }
        }

        public static synchronized a b() {
            a aVar;
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
                aVar = c;
            }
            return aVar;
        }

        public static boolean a(Object obj) {
            return obj == null;
        }

        public static String b(String str) {
            if (str == null) {
                return SQLiteDatabase.KeyEmpty;
            }
            return str;
        }

        public static boolean b(Object obj) {
            return obj != null;
        }

        public static void a(String str, String str2) {
            a(str, 4, str2);
        }

        public static boolean a(Object obj, Object obj2) {
            return obj == null || obj2 == null;
        }

        public static void b(String str, String str2) {
            a(str, 6, str2);
        }

        public static void a(String str, String str2, Throwable th) {
            a(str, 6, str2 + " exception: " + Log.getStackTraceString(th));
        }

        public static void a(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                }
            }
        }

        public static void a(String str) {
            a("#", 4, str);
        }

        private static int c(Context context) {
            Object obj;
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                return -1;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.getType();
                }
            } catch (Exception e) {
            }
            return -1;
        }

        private static void a(String str, int i, String str2) {
            List<TencentLog> tencentLogs = TencentExtraKeys.getTencentLogs();
            if (str2 != null) {
                for (TencentLog println : tencentLogs) {
                    println.println(str, i, str2);
                }
            }
        }

        public static boolean a(Object obj, Object... objArr) {
            boolean z = objArr == null && obj == null;
            if (!z) {
                return false;
            }
            for (Object obj2 : objArr) {
                if (obj2 != null) {
                    return false;
                }
            }
            return true;
        }

        public static String a(Context context) {
            int c = c(context);
            if (c != -1) {
                if (c == 0) {
                    return "mobile";
                }
                if (c == 1) {
                    return "wifi";
                }
            }
            return "none";
        }

        public static void a(byte[] bArr, File file) {
            Closeable bufferedOutputStream;
            IOException e;
            Throwable th;
            Closeable closeable = null;
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, true));
                try {
                    bufferedOutputStream.write(bArr);
                    bufferedOutputStream.flush();
                    a(bufferedOutputStream);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = bufferedOutputStream;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                bufferedOutputStream = null;
                throw e;
            } catch (Throwable th3) {
                th = th3;
                a(closeable);
                throw th;
            }
        }

        public static void a(CharSequence charSequence, File file, Charset charset) {
            IOException e;
            Throwable th;
            Closeable closeable = null;
            Closeable bufferedWriter;
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), charset));
                try {
                    bufferedWriter.append(charSequence);
                    bufferedWriter.flush();
                    a(bufferedWriter);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = bufferedWriter;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                bufferedWriter = null;
                throw e;
            } catch (Throwable th3) {
                th = th3;
                a(closeable);
                throw th;
            }
        }

        public static boolean b(Context context) {
            boolean z = true;
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                z = false;
            }
            if (z) {
                return false;
            }
            try {
                boolean isConnected;
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
                if (networkInfo2 != null) {
                    isConnected = networkInfo2.isConnected();
                    if (!(isConnected || networkInfo == null)) {
                        isConnected = networkInfo.isConnected();
                    }
                } else {
                    isConnected = false;
                }
                return isConnected;
            } catch (Exception e) {
                return false;
            }
        }

        public static byte[] a(File file) {
            Closeable bufferedInputStream;
            IOException e;
            Throwable th;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                while (true) {
                    try {
                        int read = bufferedInputStream.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            byte[] toByteArray = byteArrayOutputStream.toByteArray();
                            a(bufferedInputStream);
                            return toByteArray;
                        }
                    } catch (IOException e2) {
                        e = e2;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                bufferedInputStream = null;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
                a(bufferedInputStream);
                throw th;
            }
        }

        public static boolean a(int i) {
            return i == 0;
        }

        public static boolean a(List<ScanResult> list, List<ScanResult> list2) {
            if (list == null || list2 == null) {
                return false;
            }
            int size = list.size();
            int size2 = list2.size();
            if (size == 0 && size2 == 0) {
                return true;
            }
            if (size == 0 || size2 == 0) {
                return false;
            }
            if (list.size() <= list2.size()) {
                List<ScanResult> list3 = list;
                list = list2;
                list2 = list3;
            }
            int i = 1;
            int i2 = 0;
            int i3 = 0;
            for (ScanResult scanResult : r12) {
                int i4;
                for (ScanResult scanResult2 : r11) {
                    int i5;
                    if (scanResult2.BSSID.equals(scanResult.BSSID)) {
                        if (i != 1 || scanResult.level <= -50) {
                            i5 = i3;
                        } else {
                            i5 = i3 + 1;
                        }
                        if (i == 2 && scanResult.level > -60) {
                            i5++;
                        }
                        if (i != 3 || scanResult.level <= -60) {
                            i4 = i5;
                        } else {
                            i4 = i5 + 1;
                        }
                        i3 = i2 + 1;
                        i++;
                        i2 = i3;
                        i3 = i4;
                    }
                }
                i4 = i3;
                i3 = i2;
                i++;
                i2 = i3;
                i3 = i4;
            }
            if (i3 == 3) {
                a("TxWifiChange", 4, "big 3 is similar");
                return false;
            }
            i5 = size + size2;
            boolean z = ((double) (i2 << 1)) < ((double) i5) * 0.85d || i2 < 13;
            a("TxWifiChange", "isDiffrent:c=" + size + ",k=" + i2 + ",f=" + i5 + ",r=0.85,s=" + z);
            return z;
        }

        public static boolean a(Location location, double[] dArr) {
            int latitude = (int) (location.getLatitude() * 1000000.0d);
            int longitude = (int) (location.getLongitude() * 1000000.0d);
            String d = d("tencent_loc_lib");
            int i = 0;
            for (int i2 = 0; i2 < d.length(); i2++) {
                char charAt = d.charAt(i2);
                int i3 = FileUtils.S_IRUSR;
                if (charAt >= 'A' && charAt <= 'Z') {
                    i3 = charAt - 65;
                }
                if (charAt >= 'a' && charAt <= 'z') {
                    i3 = (charAt - 97) + 64;
                }
                if (charAt >= '0' && charAt <= '9') {
                    i3 = (charAt + FileUtils.S_IWUSR) - 48;
                }
                i += i3;
            }
            double[] dArr2 = new double[2];
            try {
                e.b(latitude ^ i, i ^ longitude, dArr2);
            } catch (UnsatisfiedLinkError e) {
            }
            dArr[0] = dArr2[0];
            dArr[1] = dArr2[1];
            return true;
        }

        public static String d(String str) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(str.getBytes());
                byte[] digest = instance.digest();
                String str2 = SQLiteDatabase.KeyEmpty;
                StringBuilder stringBuilder = new StringBuilder();
                for (byte b : digest) {
                    stringBuilder.append(Integer.toHexString(b & WebView.NORMAL_MODE_ALPHA)).append(str2);
                }
                str = stringBuilder.toString();
            } catch (Exception e) {
            }
            return str;
        }

        public static double a(double d, int i) {
            double d2 = 0.0d;
            try {
                if (!Double.isNaN(d)) {
                    d2 = BigDecimal.valueOf(d).setScale(i, RoundingMode.HALF_DOWN).doubleValue();
                }
            } catch (Exception e) {
            }
            return d2;
        }

        public static <T> T b(T t, Object obj) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(String.valueOf(obj));
        }

        public static String a(ch chVar) {
            if (chVar == null) {
                return "{}";
            }
            Location location = chVar.a;
            StringBuilder stringBuilder = new StringBuilder();
            double a = a(location.getLatitude(), 6);
            double a2 = a(location.getLongitude(), 6);
            double a3 = a(location.getAltitude(), 1);
            double a4 = a((double) location.getAccuracy(), 1);
            double a5 = a((double) location.getBearing(), 1);
            double a6 = a((double) location.getSpeed(), 1);
            stringBuilder.append("{");
            stringBuilder.append("\"latitude\":");
            stringBuilder.append(a);
            stringBuilder.append(",\"longitude\":");
            stringBuilder.append(a2);
            stringBuilder.append(",\"additional\":");
            stringBuilder.append("\"" + a3 + "," + a4 + "," + a5 + "," + a6 + "," + chVar.b + "\"");
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public static String a(cg cgVar, boolean z) {
            if (cgVar == null) {
                return "[]";
            }
            int i = cgVar.b;
            int i2 = cgVar.c;
            int i3 = cgVar.a;
            Iterable arrayList = new ArrayList();
            List<NeighboringCellInfo> a = cgVar.a();
            if (ct.a(i3, i, i2, cgVar.d, cgVar.e)) {
                int i4 = cgVar.d;
                int i5 = cgVar.e;
                int i6 = cgVar.f;
                int i7 = cgVar.g;
                int i8 = cgVar.h;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("{");
                stringBuilder.append("\"mcc\":");
                stringBuilder.append(i);
                stringBuilder.append(",\"mnc\":");
                stringBuilder.append(i2);
                stringBuilder.append(",\"lac\":");
                stringBuilder.append(i4);
                stringBuilder.append(",\"cellid\":");
                stringBuilder.append(i5);
                stringBuilder.append(",\"rss\":");
                stringBuilder.append(i6);
                stringBuilder.append(",\"seed\":");
                stringBuilder.append(z ? 1 : 0);
                if (!(i7 == Integer.MAX_VALUE || i8 == Integer.MAX_VALUE)) {
                    stringBuilder.append(",\"stationLat\":");
                    stringBuilder.append(String.format("%.6f", new Object[]{Float.valueOf(((float) i7) / 14400.0f)}));
                    stringBuilder.append(",\"stationLng\":");
                    stringBuilder.append(String.format("%.6f", new Object[]{Float.valueOf(((float) i8) / 14400.0f)}));
                }
                stringBuilder.append("}");
                arrayList.add(stringBuilder.toString());
            } else {
                a("illeagal main cell! ", i, i2, i3, cgVar.d, cgVar.e);
            }
            try {
                for (NeighboringCellInfo neighboringCellInfo : a) {
                    i5 = neighboringCellInfo.getLac();
                    i6 = neighboringCellInfo.getCid();
                    if (ct.a(i3, i, i2, i5, i6)) {
                        i4 = (neighboringCellInfo.getRssi() << 1) - 113;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("{");
                        stringBuilder2.append("\"mcc\":");
                        stringBuilder2.append(i);
                        stringBuilder2.append(",\"mnc\":");
                        stringBuilder2.append(i2);
                        stringBuilder2.append(",\"lac\":");
                        stringBuilder2.append(i5);
                        stringBuilder2.append(",\"cellid\":");
                        stringBuilder2.append(i6);
                        stringBuilder2.append(",\"rss\":");
                        stringBuilder2.append(i4);
                        stringBuilder2.append("}");
                        arrayList.add(stringBuilder2.toString());
                    } else {
                        a("illeagal neighboringCell! ", i, i2, i3, i5, i6);
                    }
                }
            } catch (Exception e) {
            }
            StringBuilder stringBuilder3 = new StringBuilder("[");
            stringBuilder3.append(new cx(",").a(new StringBuilder(), arrayList.iterator()).toString());
            stringBuilder3.append("]");
            return stringBuilder3.toString();
        }

        public static byte[] a(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
            try {
                deflaterOutputStream.write(bArr, 0, bArr.length);
                deflaterOutputStream.finish();
                deflaterOutputStream.flush();
                deflaterOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Exception e) {
                return null;
            }
        }

        @Nullable
        public static byte[] b(byte[] bArr) {
            int i = 0;
            if (bArr == null) {
                return null;
            }
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
            Object obj = new byte[0];
            Object obj2 = new byte[1024];
            while (true) {
                try {
                    Object obj3;
                    int read = inflaterInputStream.read(obj2);
                    if (read > 0) {
                        i += read;
                        obj3 = new byte[i];
                        System.arraycopy(obj, 0, obj3, 0, obj.length);
                        System.arraycopy(obj2, 0, obj3, obj.length, read);
                    } else {
                        obj3 = obj;
                    }
                    if (read <= 0) {
                        try {
                            byteArrayInputStream.close();
                            inflaterInputStream.close();
                            return obj3;
                        } catch (IOException e) {
                            return null;
                        }
                    }
                    obj = obj3;
                } catch (Exception e2) {
                    return null;
                }
            }
        }

        private static void a(String str, int i, int i2, int i3, int i4, int i5) {
            boolean z = true;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getCellInfoWithJsonFormat: ");
            stringBuilder.append(str);
            StringBuilder append = stringBuilder.append("isGsm=");
            if (i3 != 1) {
                z = false;
            }
            append.append(z);
            stringBuilder.append(", mcc,mnc=").append(i).append(",").append(i2);
            stringBuilder.append(", lac,cid=").append(i4).append(",").append(i5);
        }

        public static String a(ck ckVar) {
            if (ckVar == null || ckVar.a() == null) {
                return "[]";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            if (ckVar.a() == null || ckVar.a().size() <= 0) {
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
            List<ScanResult> a = ckVar.a();
            int i = 0;
            for (ScanResult scanResult : a) {
                a.size();
                if (i > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append("{\"mac\":\"").append(scanResult.BSSID).append("\",");
                stringBuilder.append("\"rssi\":").append(scanResult.level).append("}");
                i++;
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        public static boolean c(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (str.contains("latitude")) {
                    return true;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("cells");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    return true;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("wifis");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        private static double a(double d) {
            return (3.141592653589793d * d) / 180.0d;
        }

        public static double a(double d, double d2, double d3, double d4) {
            double a = a(d);
            double a2 = a(d3);
            double a3 = a(d2) - a(d4);
            return (((double) Math.round(((Math.asin(Math.sqrt(((Math.cos(a) * Math.cos(a2)) * Math.pow(Math.sin(a3 / 2.0d), 2.0d)) + Math.pow(Math.sin((a - a2) / 2.0d), 2.0d))) * 2.0d) * 6178.137d) * 10000.0d)) / 10000.0d) * 1000.0d;
        }
    }

    final class b extends Handler {
        private /* synthetic */ b a;

        private b(b bVar, Looper looper) {
            this.a = bVar;
            super(looper);
        }

        @SuppressLint({"NewApi"})
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.a.a) {
                sendEmptyMessageDelayed(0, 20000);
                List list = null;
                TelephonyManager a = this.a.b.a();
                if (a != null) {
                    try {
                        list = a.getAllCellInfo();
                    } catch (Throwable e) {
                        a.a("TxCellProvider", "cannot get cell location", e);
                    } catch (Error e2) {
                    }
                }
                this.a.onCellInfoChanged(list);
            }
        }
    }

    static class c implements Runnable {
        private bk a;
        private cg b;

        public c(bk bkVar) {
            this.a = bkVar;
        }

        public final void a(cg cgVar) {
            this.b = cgVar;
        }

        public final void run() {
            bk bkVar = this.a;
            Object obj = this.b;
            if (obj != null) {
                obj.a(ct.c(bkVar));
                bkVar.c(obj);
            }
        }
    }

    public b(bk bkVar) {
        this.b = bkVar;
    }

    @SuppressLint({"NewApi"})
    public final void a() {
        byte b = (byte) 1;
        if (!this.a && this.b != null) {
            this.g = new HandlerThread("NewCellProvider");
            if (this.g != null) {
                this.g.start();
                this.h = new b(this.g.getLooper());
                this.h.sendEmptyMessageDelayed(0, 3000);
            } else {
                b = (byte) 0;
            }
            if (b != (byte) 0) {
                try {
                    CellInfo a = ct.a(this.b);
                    if (a(a) && cg.a(this.b, a) != null) {
                        this.c = a;
                    }
                    a(1281);
                    this.a = true;
                } catch (Exception e) {
                }
            }
        }
    }

    public final void b() {
        if (this.a) {
            this.a = false;
            a(0);
            synchronized (this) {
                if (this.h != null) {
                    this.h.removeCallbacksAndMessages(null);
                    this.h = null;
                }
            }
            this.g.quit();
            this.g = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = 0;
            a.a("TxCellProvider", "shutdown: state=[shutdown]");
        }
    }

    private void a(int i) {
        try {
            this.b.a().listen(this, i);
        } catch (Throwable e) {
            a.a("TxCellProvider", "listenCellState: failed! flags=" + i, e);
        }
    }

    public final void onServiceStateChanged(ServiceState serviceState) {
        Object obj = 1;
        super.onServiceStateChanged(serviceState);
        if (serviceState != null) {
            ServiceState serviceState2 = this.e;
            if (serviceState2 == null || serviceState2.getState() != serviceState.getState()) {
                this.e = serviceState;
                if (this.a) {
                    int i;
                    TelephonyManager a;
                    boolean a2;
                    if (this.e != null) {
                        if (this.e.getState() == 0) {
                            i = 1;
                        } else if (this.e.getState() == 1) {
                            i = 0;
                        }
                        a = this.b.a();
                        a2 = ct.a(this.b.a);
                        if (a != null) {
                            obj = null;
                        } else if (a.getSimState() != 5) {
                            obj = null;
                        }
                        if (a2 || r1 == null) {
                            i = 0;
                        }
                        obj = new Message();
                        obj.what = 12999;
                        obj.arg1 = 12003;
                        obj.arg2 = i;
                        this.b.c(obj);
                    }
                    i = -1;
                    a = this.b.a();
                    a2 = ct.a(this.b.a);
                    if (a != null) {
                        obj = null;
                    } else if (a.getSimState() != 5) {
                        obj = null;
                    }
                    i = 0;
                    obj = new Message();
                    obj.what = 12999;
                    obj.arg1 = 12003;
                    obj.arg2 = i;
                    this.b.c(obj);
                }
            }
        }
    }

    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        if (signalStrength != null) {
            try {
                SignalStrength signalStrength2 = this.d;
                int i = this.b.g().b;
                if (signalStrength2 == null || ct.a(i, signalStrength2, signalStrength)) {
                    this.d = signalStrength;
                    c();
                }
            } catch (Exception e) {
                a.b("TxCellProvider", e.toString());
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void onCellInfoChanged(List<CellInfo> list) {
        int i = 1;
        CellInfo cellInfo = null;
        if (list == null) {
            a.b("TxCellProvider", "onCellInfoChanged: cellinfo list is null ");
            c();
            return;
        }
        for (CellInfo cellInfo2 : list) {
            CellInfo cellInfo22;
            if (!cellInfo22.isRegistered()) {
                cellInfo22 = cellInfo;
            }
            cellInfo = cellInfo22;
        }
        int i2 = (list != null ? 1 : 0) & (cellInfo == null ? 1 : 0);
        if (list.size() <= 0) {
            i = 0;
        }
        if ((i2 & i) != 0) {
            cellInfo22 = (CellInfo) list.get(0);
        } else {
            cellInfo22 = cellInfo;
        }
        if (a(cellInfo22)) {
            this.c = cellInfo22;
            c();
            return;
        }
        a.b("TxCellProvider", "onCellInfoChanged: illegal cell or same cell " + (cellInfo22 == null ? "null cell" : cellInfo22.toString()));
    }

    @SuppressLint({"NewApi"})
    private boolean a(CellInfo cellInfo) {
        if (cellInfo == null || !ct.a(cellInfo) || ct.a(this.c, cellInfo)) {
            return false;
        }
        return true;
    }

    private void c() {
        if (this.a && this.c != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if ((currentTimeMillis - this.f > 2000 ? 1 : null) != null) {
                this.f = currentTimeMillis;
                cg a = cg.a(this.b, this.c);
                synchronized (this) {
                    if (!(this.h == null || a == null)) {
                        Runnable cVar = new c(this.b);
                        cVar.a(a);
                        this.h.post(cVar);
                    }
                }
            }
        }
    }
}
