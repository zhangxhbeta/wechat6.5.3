package com.tencent.mm.modelstat;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.mm.a.h;
import com.tencent.mm.a.o;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import junit.framework.Assert;

public class e {
    private static e dbG;
    private int dbH = -1;
    private int dbI = 20000;
    private int dbJ = 3000;
    private int dbK = 1000;
    private int dbL = 20;
    private ArrayList<Pair<Float, Float>> dbM = new ArrayList();
    private ArrayList<Pair<Float, Float>> dbN = new ArrayList();
    private long startTime = 0;

    class a {
        long cvj = 0;
        final /* synthetic */ e dbT;
        private SensorManager dca;
        long dcb = 0;
        Pair<Integer, float[]> dcc = null;
        Pair<Integer, float[]> dcd = null;
        Pair<Integer, float[]> dce = null;
        private Long dcf = null;
        ArrayList<Long> dcg = new ArrayList();
        ArrayList<Pair<Integer, float[]>> dch = new ArrayList();
        ArrayList<Pair<Integer, float[]>> dci = new ArrayList();
        ArrayList<Pair<Integer, float[]>> dcj = new ArrayList();
        ArrayList<float[]> dck = new ArrayList();
        private SensorEventListener dcl = new SensorEventListener(this) {
            final /* synthetic */ a dcm;

            {
                this.dcm = r1;
            }

            public final void onAccuracyChanged(Sensor sensor, int i) {
            }

            public final void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null) {
                    long Ni = t.Ni();
                    if (sensorEvent.sensor.getType() == 1) {
                        this.dcm.dcc = new Pair(Integer.valueOf(sensorEvent.accuracy), sensorEvent.values);
                    } else if (sensorEvent.sensor.getType() == 2) {
                        this.dcm.dcd = new Pair(Integer.valueOf(sensorEvent.accuracy), sensorEvent.values);
                    } else if (sensorEvent.sensor.getType() == 4) {
                        this.dcm.dce = new Pair(Integer.valueOf(sensorEvent.accuracy), sensorEvent.values);
                    }
                    long j = Ni - this.dcm.cvj;
                    if (this.dcm.dcc != null && this.dcm.dcd != null && this.dcm.dce != null) {
                        if (j > this.dcm.dcb || j < 0) {
                            float[] fArr = new float[9];
                            SensorManager.getRotationMatrix(fArr, null, (float[]) this.dcm.dcc.second, (float[]) this.dcm.dcd.second);
                            Object obj = new float[3];
                            SensorManager.getOrientation(fArr, obj);
                            this.dcm.cvj = Ni;
                            this.dcm.dcg.add(Long.valueOf(Ni));
                            this.dcm.dch.add(this.dcm.dcc);
                            this.dcm.dci.add(this.dcm.dcd);
                            this.dcm.dcj.add(this.dcm.dce);
                            this.dcm.dck.add(obj);
                            v.v("MicroMsg.IndoorReporter", "Res:%d acc[%d,%f,%f,%f] mag[%d,%f,%f,%f] gyr[%d,%f,%f,%f] ori[%f,%f,%f]", Long.valueOf(j), this.dcm.dcc.first, Float.valueOf(((float[]) this.dcm.dcc.second)[0]), Float.valueOf(((float[]) this.dcm.dcc.second)[1]), Float.valueOf(((float[]) this.dcm.dcc.second)[2]), this.dcm.dcd.first, Float.valueOf(((float[]) this.dcm.dcd.second)[0]), Float.valueOf(((float[]) this.dcm.dcd.second)[1]), Float.valueOf(((float[]) this.dcm.dcd.second)[2]), this.dcm.dce.first, Float.valueOf(((float[]) this.dcm.dce.second)[0]), Float.valueOf(((float[]) this.dcm.dce.second)[1]), Float.valueOf(((float[]) this.dcm.dce.second)[2]), Float.valueOf(obj[0]), Float.valueOf(obj[1]), Float.valueOf(obj[2]));
                        }
                    }
                }
            }
        };
        private HandlerThread handlerThread = null;

        a(e eVar) {
            this.dbT = eVar;
        }

        public final boolean r(Context context, int i) {
            boolean z;
            try {
                if (this.dca == null) {
                    this.dca = (SensorManager) context.getSystemService("sensor");
                }
                if (this.handlerThread == null) {
                    this.handlerThread = com.tencent.mm.sdk.i.e.bJ("MicroMsg.IndoorReporter", 1);
                    this.handlerThread.start();
                }
                Handler handler = new Handler(this.handlerThread.getLooper());
                z = this.dca.registerListener(this.dcl, this.dca.getDefaultSensor(1), 3, handler) && this.dca.registerListener(this.dcl, this.dca.getDefaultSensor(4), 3, handler) && this.dca.registerListener(this.dcl, this.dca.getDefaultSensor(2), 3, handler);
            } catch (Exception e) {
                v.e("MicroMsg.IndoorReporter", "start except:%s", e.getMessage());
                z = false;
            }
            if (!z) {
                try {
                    if (this.dca != null) {
                        this.dca.unregisterListener(this.dcl);
                        this.dca = null;
                    }
                } catch (Exception e2) {
                }
                try {
                    if (this.handlerThread != null) {
                        this.handlerThread.quit();
                        this.handlerThread = null;
                    }
                } catch (Exception e3) {
                }
            }
            this.dcb = (long) i;
            this.dcf = Long.valueOf(t.Ni());
            return z;
        }

        public final String Ka() {
            try {
                if (this.dca != null) {
                    this.dca.unregisterListener(this.dcl);
                    this.dca = null;
                }
            } catch (Exception e) {
            }
            try {
                if (this.handlerThread != null) {
                    this.handlerThread.quit();
                    this.handlerThread = null;
                }
            } catch (Exception e2) {
            }
            v.i("MicroMsg.IndoorReporter", "stop sampling Res Count: %d", Integer.valueOf(this.dcg.size()));
            String str = this.dcf + ";" + this.dcg.size() + ";#";
            int i = 0;
            while (i < this.dcg.size()) {
                i++;
                str = ((((str + (((Long) this.dcg.get(i)).longValue() - this.dcf.longValue()) + ";") + a((Pair) this.dch.get(i))) + a((Pair) this.dcj.get(i))) + a((Pair) this.dci.get(i))) + String.format("%.3f;%.3f;%.3f;#", new Object[]{Float.valueOf(((float[]) this.dck.get(i))[0]), Float.valueOf(((float[]) this.dck.get(i))[1]), Float.valueOf(((float[]) this.dck.get(i))[2])});
            }
            v.i("MicroMsg.IndoorReporter", "stop  Res: %d [%s]", Integer.valueOf(str.length()), str);
            return str;
        }

        private static String a(Pair<Integer, float[]> pair) {
            try {
                String str = new String();
                return String.format("%d;%.3f;%.3f;%.3f;", new Object[]{pair.first, Float.valueOf(((float[]) pair.second)[0]), Float.valueOf(((float[]) pair.second)[1]), Float.valueOf(((float[]) pair.second)[2])});
            } catch (Exception e) {
                return "0;0;0;0;";
            }
        }
    }

    class b {
        WifiManager aNW;
        int dbL = 0;
        final /* synthetic */ e dbT;
        int dcn = 0;
        boolean dco = false;
        List<String> dcp = new ArrayList();
        long startTime = 0;
        Thread thread = com.tencent.mm.sdk.i.e.c(new Runnable(this) {
            final /* synthetic */ b dcq;

            {
                this.dcq = r1;
            }

            public final void run() {
                v.i("MicroMsg.IndoorReporter", "start wifi");
                while (this.dcq.dco) {
                    try {
                        int i;
                        long Ni = be.Ni();
                        List scanResults = this.dcq.aNW.getScanResults();
                        String str = SQLiteDatabase.KeyEmpty;
                        if (scanResults == null || scanResults.size() <= 0) {
                            i = 0;
                        } else {
                            Collections.sort(scanResults, new Comparator<ScanResult>(this) {
                                final /* synthetic */ AnonymousClass1 dcr;

                                {
                                    this.dcr = r1;
                                }

                                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                                    return ((ScanResult) obj2).level - ((ScanResult) obj).level;
                                }
                            });
                            int i2 = 0;
                            i = 0;
                            while (i2 < scanResults.size()) {
                                int i3;
                                String str2;
                                ScanResult scanResult = (ScanResult) scanResults.get(i2);
                                if (scanResult != null && !be.kS(scanResult.BSSID) && !be.kS(scanResult.SSID)) {
                                    str = str + scanResult.SSID.replace(";", SQLiteDatabase.KeyEmpty).replace(" ", SQLiteDatabase.KeyEmpty).replace(",", SQLiteDatabase.KeyEmpty).replace("#", SQLiteDatabase.KeyEmpty) + ";" + scanResult.BSSID + ";" + scanResult.level + ";";
                                    i3 = i + 1;
                                    if (i3 >= this.dcq.dbL) {
                                        i = i3;
                                        break;
                                    }
                                    str2 = str;
                                } else {
                                    i3 = i;
                                    str2 = str;
                                }
                                i2++;
                                str = str2;
                                i = i3;
                            }
                        }
                        v.i("MicroMsg.IndoorReporter", "%d %s", Integer.valueOf(((Ni - this.dcq.startTime) + ";" + (scanResults != null ? scanResults.size() : 0) + ";" + i + ";" + str).length()), (Ni - this.dcq.startTime) + ";" + (scanResults != null ? scanResults.size() : 0) + ";" + i + ";" + str);
                        this.dcq.dcp.add(r0);
                        this.dcq.aNW.startScan();
                        Thread.sleep((long) this.dcq.dcn);
                    } catch (Exception e) {
                        v.e("MicroMsg.IndoorReporter", "Except:%s", e.getMessage());
                        return;
                    }
                }
            }
        }, "MicroMsg.IndoorReporter_WIFI_Scan");

        b(e eVar) {
            this.dbT = eVar;
        }

        public final String Ka() {
            this.dco = false;
            try {
                if (this.thread != null && this.thread.isAlive()) {
                    this.thread.join(500);
                }
            } catch (Exception e) {
                v.e("MicroMsg.IndoorReporter", "stop, join Thread failed:%s ", e.getMessage());
            }
            String str = this.dcp.size() + ";#";
            int i = false;
            while (i < this.dcp.size()) {
                String str2 = str + ((String) this.dcp.get(i)) + "#";
                i++;
                str = str2;
            }
            return str;
        }
    }

    static /* synthetic */ boolean j(float f, float f2) {
        return ((double) Math.abs(f - f2)) < Math.pow(0.1d, 2.0d);
    }

    public static e JZ() {
        if (dbG == null) {
            synchronized (e.class) {
                if (dbG == null) {
                    dbG = new e();
                }
            }
        }
        return dbG;
    }

    public final void a(int i, boolean z, boolean z2, float f, float f2, int i2) {
        v.i("MicroMsg.IndoorReporter", "report scene:%d agps:%b mars:%b lon:%f lat:%f acc:%d", Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2));
        if (ak.uz() && !ak.uG()) {
            com.tencent.mm.ao.b IA = com.tencent.mm.ao.b.IA();
            String str = SQLiteDatabase.KeyEmpty;
            String str2 = SQLiteDatabase.KeyEmpty;
            int i3 = z2 ? 1 : 0;
            if (ak.uz() && !ak.uG()) {
                ak.vA().x(new com.tencent.mm.ao.b.AnonymousClass1(IA, i3, f, f2, i, i2, 0, str, str2));
            }
            if (this.dbN.size() != 0 || this.dbM.size() != 0 || kv(j.sU().getValue("AndroidIndoorSensorReport"))) {
                if (!com.tencent.mm.sdk.b.b.bsI()) {
                    ak.yW();
                    int aq = h.aq(c.ww() + 5, 100);
                    if (aq > this.dbH) {
                        r3 = new Object[3];
                        ak.yW();
                        r3[0] = Long.valueOf(new o(c.ww()).longValue());
                        r3[1] = Integer.valueOf(aq);
                        r3[2] = Integer.valueOf(this.dbH);
                        v.d("MicroMsg.IndoorReporter", "report uin:%s hash:%d config:%d", r3);
                        return;
                    }
                }
                final boolean z3 = z2;
                final float f3 = f;
                final float f4 = f2;
                final int i4 = i;
                final boolean z4 = z;
                final int i5 = i2;
                ak.vA().x(new Runnable(this) {
                    final /* synthetic */ e dbT;

                    public final void run() {
                        try {
                            if (ak.uz() && !ak.uG()) {
                                long Ni = be.Ni();
                                if (this.dbT.startTime == 0 || Ni - this.dbT.startTime >= 1800000) {
                                    List b;
                                    Pair pair;
                                    if (z3) {
                                        b = this.dbT.dbM;
                                    } else {
                                        Object c = this.dbT.dbN;
                                    }
                                    int i = 0;
                                    while (i < b.size()) {
                                        if (e.j(f3, ((Float) ((Pair) b.get(i)).first).floatValue()) && e.j(f4, ((Float) ((Pair) b.get(i)).second).floatValue())) {
                                            pair = (Pair) b.get(i);
                                            break;
                                        }
                                        i++;
                                    }
                                    pair = null;
                                    if (pair == null) {
                                        v.d("MicroMsg.IndoorReporter", "Ignore this report, no hit any Point");
                                        return;
                                    }
                                    int i2;
                                    this.dbT.startTime = Ni;
                                    StringBuilder stringBuilder = new StringBuilder();
                                    ak.yW();
                                    final String stringBuilder2 = stringBuilder.append(new o(c.ww()).toString()).append("_").append(this.dbT.startTime).toString();
                                    stringBuilder = new StringBuilder().append(pair.first).append(",").append(pair.second).append(",").append(i4).append(",");
                                    if (z4) {
                                        i2 = 1;
                                    } else {
                                        i2 = (z3 ? 10 : 20) + 2;
                                    }
                                    final String stringBuilder3 = stringBuilder.append(i2).append(",").append(f3).append(",").append(f4).append(",0,").append(i5).append(",").append(this.dbT.startTime).append(",").toString();
                                    final b bVar = new b(this.dbT);
                                    Context context = aa.getContext();
                                    int d = this.dbT.dbJ;
                                    int e = this.dbT.dbL;
                                    if (bVar.aNW == null) {
                                        bVar.aNW = (WifiManager) context.getSystemService("wifi");
                                    }
                                    bVar.dcn = d;
                                    bVar.dbL = e;
                                    bVar.startTime = be.Ni();
                                    bVar.dco = true;
                                    bVar.thread.start();
                                    final a aVar = new a(this.dbT);
                                    if (aVar.r(aa.getContext(), this.dbT.dbK)) {
                                        new ah(ak.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
                                            boolean dbU = false;
                                            final /* synthetic */ AnonymousClass1 dbZ;

                                            public final boolean oU() {
                                                boolean dI = l.dI(aa.getContext());
                                                long Ni = be.Ni();
                                                long a = Ni - this.dbZ.dbT.startTime;
                                                if (a <= ((long) this.dbZ.dbT.dbI)) {
                                                    if (dI) {
                                                        this.dbU = false;
                                                        return true;
                                                    } else if (!this.dbU) {
                                                        this.dbU = true;
                                                        return true;
                                                    }
                                                }
                                                v.i("MicroMsg.IndoorReporter", "Stop Now goingbg:%b fg:%b runtime:%d", Boolean.valueOf(this.dbU), Boolean.valueOf(dI), Long.valueOf(a));
                                                this.dbZ.dbT.startTime = 0;
                                                String Ka = aVar.Ka();
                                                String Ka2 = bVar.Ka();
                                                try {
                                                    if (be.kS(Ka) || be.kS(Ka2)) {
                                                        v.e("MicroMsg.IndoorReporter", "get Res Failed [%s][%s]", Ka, Ka2);
                                                        g.iuh.Y(13381, stringBuilder3 + stringBuilder2 + (!be.kS(Ka) ? ",-10011,ERROR:StopFailed." : ",-10012,ERROR:StopFailed."));
                                                        return false;
                                                    }
                                                    String str = Ka + Ka2;
                                                    int ceil = (int) Math.ceil(((double) str.length()) / 5400.0d);
                                                    for (int i = 0; i < ceil; i++) {
                                                        v.i("MicroMsg.IndoorReporter", "reportKV [%d/%d] res:%d kv:%d [%s]", Integer.valueOf(i), Integer.valueOf(ceil), Integer.valueOf(str.length()), Integer.valueOf((stringBuilder3 + stringBuilder2 + "_" + Ni + "_" + ceil + "_" + (a > ((long) this.dbZ.dbT.dbI) ? "1" : "2") + "," + (i + 1) + "," + str.substring(i * 5400, Math.min((i + 1) * 5400, str.length()))).length()), stringBuilder3 + stringBuilder2 + "_" + Ni + "_" + ceil + "_" + (a > ((long) this.dbZ.dbT.dbI) ? "1" : "2") + "," + (i + 1) + "," + str.substring(i * 5400, Math.min((i + 1) * 5400, str.length())));
                                                        g.iuh.Y(13381, Ka);
                                                    }
                                                    return false;
                                                } catch (Exception e) {
                                                    v.e("MicroMsg.IndoorReporter", "reprot Stop exception:%s", e.getMessage());
                                                }
                                            }
                                        }, true).ea(3000);
                                        return;
                                    }
                                    v.e("MicroMsg.IndoorReporter", "Ignore this report. Error:start wifi:%b sensor:%b  ", Boolean.valueOf(true), Boolean.valueOf(aVar.r(aa.getContext(), this.dbT.dbK)));
                                    aVar.Ka();
                                    bVar.Ka();
                                    g.iuh.Y(13381, stringBuilder3 + stringBuilder2 + ",-10002,ERROR:StartFailed.");
                                    return;
                                }
                                v.e("MicroMsg.IndoorReporter", "Ignore this Report,Another Report is Running & not timeout:%d.", Long.valueOf(Ni - this.dbT.startTime));
                            }
                        } catch (Exception e2) {
                            v.e("MicroMsg.IndoorReporter", "reprot Start exception:%s", e2.getMessage());
                        }
                    }
                });
            }
        }
    }

    public final boolean kv(String str) {
        if (be.kS(str)) {
            return false;
        }
        try {
            String[] split = str.split(",");
            this.dbH = be.getInt(split[0], -1);
            if (this.dbH > MMGIFException.D_GIF_ERR_OPEN_FAILED) {
                Assert.assertTrue(false);
            }
            this.dbI = be.getInt(split[1], 20000);
            this.dbJ = be.getInt(split[2], 3000);
            this.dbK = be.getInt(split[3], 1000);
            this.dbL = be.getInt(split[4], 20);
            int i = be.getInt(split[5], 0);
            for (int i2 = 0; i2 < i; i2++) {
                String[] split2 = split[i2 + 6].split(";");
                if ("1".equals(split2[0])) {
                    this.dbM.add(new Pair(Float.valueOf(Float.parseFloat(split2[1])), Float.valueOf(Float.parseFloat(split2[2]))));
                } else {
                    this.dbN.add(new Pair(Float.valueOf(Float.parseFloat(split2[1])), Float.valueOf(Float.parseFloat(split2[2]))));
                }
            }
            v.i("MicroMsg.IndoorReporter", "parseConfig: max:%d wifiFreq:%d sensorFreq:%d maxWifiCount:%d cnt:%d mars:%d earth:%d", Integer.valueOf(this.dbI), Integer.valueOf(this.dbJ), Integer.valueOf(this.dbK), Integer.valueOf(this.dbL), Integer.valueOf(i), Integer.valueOf(this.dbM.size()), Integer.valueOf(this.dbN.size()));
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.IndoorReporter", "parseConfig e:%s  [%s]", e.getMessage(), str);
            return false;
        }
    }
}
