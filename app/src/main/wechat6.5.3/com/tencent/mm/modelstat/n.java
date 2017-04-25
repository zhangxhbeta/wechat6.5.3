package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.tencent.mm.compatible.d.w;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aps;
import com.tencent.mm.protocal.c.apt;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class n {
    private static ah aSW = new ah(ak.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a() {
        public final boolean oU() {
            try {
                n.ddt = Long.MAX_VALUE;
                if (n.ddu >= 2000 || n.ddu <= 1000) {
                    n.a(n.ddu, 0.0f, 0.0f, 0, 0);
                    return false;
                }
                n.gq(n.ddu);
                return false;
            } catch (Throwable e) {
                v.e("MicroMsg.NetTypeReporter", "run :%s", be.e(e));
            }
        }
    }, false);
    private static final byte[] cGJ = new byte[0];
    private static int ddA = 0;
    private static long ddB = 0;
    private static String ddC = SQLiteDatabase.KeyEmpty;
    private static long ddq = 86400000;
    private static HashMap<String, Long> ddr = new HashMap();
    private static String dds = null;
    private static long ddt = Long.MAX_VALUE;
    private static int ddu = 0;
    private static long ddv = 0;
    private static long ddw = 0;
    private static float ddx = 0.0f;
    private static float ddy = 0.0f;
    private static int ddz = 0;

    private static class a extends BroadcastReceiver {
        private a() {
        }

        public final void onReceive(Context context, Intent intent) {
            try {
                if (!ak.uz() || ak.uG()) {
                    v.e("MicroMsg.NetTypeReporter", "onReceive acc not ready .%b %b", Boolean.valueOf(ak.uz()), Boolean.valueOf(ak.uG()));
                } else if (intent == null || be.kS(intent.getAction())) {
                    String str = "MicroMsg.NetTypeReporter";
                    String str2 = "onReceive %s  ";
                    Object[] objArr = new Object[1];
                    if (intent == null) {
                        r0 = "intent is null";
                    } else {
                        r0 = "action is null";
                    }
                    objArr[0] = r0;
                    v.e(str, str2, objArr);
                } else {
                    r0 = intent.getAction();
                    v.i("MicroMsg.NetTypeReporter", "onReceive action:%s foreground:%b", r0, Boolean.valueOf(b.foreground));
                    if (!b.foreground) {
                        return;
                    }
                    if (r0.equals("android.net.wifi.supplicant.CONNECTION_CHANGE")) {
                        n.gp(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
                    } else if (r0.equals("android.net.wifi.supplicant.STATE_CHANGE")) {
                        n.gp(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
                    } else if (r0.equals("android.net.wifi.STATE_CHANGE")) {
                        n.gp(MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED);
                    } else if (r0.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                        n.gp(MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED);
                    } else if (r0.equals("android.net.wifi.SCAN_RESULTS")) {
                        n.gp(MMBitmapFactory.ERROR_IO_FAILED);
                    } else if (r0.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        n.gp(MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT);
                    }
                }
            } catch (Throwable th) {
                v.e("MicroMsg.NetTypeReporter", "onReceive : %s", be.e(th));
            }
        }
    }

    static /* synthetic */ void gq(int i) {
        long Ni = be.Ni();
        if (ddv <= 0 || Ni - ddv <= 5000) {
            String[] go = go(i);
            if (go == null || go.length != 4 || be.kS(go[0])) {
                v.e("MicroMsg.NetTypeReporter", "report get failed val");
                return;
            }
            v.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", Integer.valueOf(i), Long.valueOf(be.ay(Ni)), Float.valueOf(0.0f), Float.valueOf(0.0f), Integer.valueOf(0), Long.valueOf(0), go[0]);
            Ni = be.ay(ddv);
            if (Ni > 600000 || Ni < 0) {
                Ni = 0;
            }
            g.iuh.Y(11747, go[0] + "1,0.0" + ",0.0" + ",0" + ",0" + "," + (b.foreground ? "1" : String.valueOf(Ni)) + "," + go[1] + "," + go[2] + "," + go[3]);
            ak.yW();
            c.vf().a(com.tencent.mm.storage.t.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, Long.valueOf(be.Ni()));
            return;
        }
        v.e("MicroMsg.NetTypeReporter", "never  report (reportKV) at  background :%d diff:%d", Long.valueOf(ddv), Long.valueOf(Ni - ddv));
    }

    public static void bh(Context context) {
        if (context == null) {
            try {
                v.e("MicroMsg.NetTypeReporter", "registerReceiver ctx == null");
                return;
            } catch (Throwable th) {
                v.e("MicroMsg.NetTypeReporter", "registerReceiver : %s", be.e(th));
                return;
            }
        }
        BroadcastReceiver aVar = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.supplicant.CONNECTION_CHANGE");
        intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(aVar, intentFilter);
        v.i("MicroMsg.NetTypeReporter", "registerReceiver finish");
    }

    private static boolean i(ArrayList<String> arrayList) {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        Throwable e;
        Iterator it;
        boolean z;
        String str;
        boolean z2;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        FileOutputStream fileOutputStream2;
        ObjectOutputStream objectOutputStream2 = null;
        if (arrayList.size() == 0) {
            v.w("MicroMsg.NetTypeReporter", "checkBssidShouldReport no value in list.");
            return false;
        }
        long ay;
        if (be.kS(dds)) {
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            dds = stringBuilder.append(c.xp()).append("bssidcache.bin").toString();
        }
        if (ddr.size() == 0) {
            try {
                fileInputStream = new FileInputStream(dds);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    try {
                        ddr = (HashMap) objectInputStream.readObject();
                        v.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport read file size:%d", Integer.valueOf(ddr.size()));
                        try {
                            objectInputStream.close();
                            fileInputStream.close();
                        } catch (Throwable e2) {
                            v.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", be.e(e2));
                            ddr = new HashMap();
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        try {
                            v.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", be.e(e2));
                            ddr = new HashMap();
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Throwable e22) {
                                    v.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", be.e(e22));
                                    ddr = new HashMap();
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            v.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(ddr.size()), dds);
                            com.tencent.mm.loader.stub.b.deleteFile(dds);
                            it = arrayList.iterator();
                            z = false;
                            while (it.hasNext()) {
                                str = (String) it.next();
                                ay = be.ay(be.bf(ddr.get(str)));
                                v.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", str, Long.valueOf(ay));
                                if (ay > 0) {
                                }
                                ddr.put(str, Long.valueOf(be.Ni()));
                                z2 = true;
                                z = z2;
                            }
                            try {
                                fileOutputStream = new FileOutputStream(dds);
                                try {
                                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                                    try {
                                        objectOutputStream.writeObject(ddr);
                                        fileOutputStream.flush();
                                        v.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(ddr.size()));
                                        try {
                                            objectOutputStream.close();
                                            fileOutputStream.close();
                                        } catch (Throwable e222) {
                                            v.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", be.e(e222));
                                        }
                                    } catch (Exception e4) {
                                        e222 = e4;
                                        objectOutputStream2 = objectOutputStream;
                                        fileOutputStream2 = fileOutputStream;
                                        try {
                                            v.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", be.e(e222));
                                            if (objectOutputStream2 != null) {
                                                try {
                                                    objectOutputStream2.close();
                                                } catch (Throwable e2222) {
                                                    v.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", be.e(e2222));
                                                }
                                            }
                                            if (fileOutputStream2 != null) {
                                                fileOutputStream2.close();
                                            }
                                            return z;
                                        } catch (Throwable th) {
                                            e2222 = th;
                                            fileOutputStream = fileOutputStream2;
                                            objectOutputStream = objectOutputStream2;
                                            if (objectOutputStream != null) {
                                                try {
                                                    objectOutputStream.close();
                                                } catch (Throwable e5) {
                                                    v.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", be.e(e5));
                                                    throw e2222;
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            throw e2222;
                                        }
                                    } catch (Throwable th2) {
                                        e2222 = th2;
                                        if (objectOutputStream != null) {
                                            objectOutputStream.close();
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        throw e2222;
                                    }
                                } catch (Exception e6) {
                                    e2222 = e6;
                                    fileOutputStream2 = fileOutputStream;
                                    v.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", be.e(e2222));
                                    if (objectOutputStream2 != null) {
                                        objectOutputStream2.close();
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                    return z;
                                } catch (Throwable th3) {
                                    e2222 = th3;
                                    objectOutputStream = null;
                                    if (objectOutputStream != null) {
                                        objectOutputStream.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw e2222;
                                }
                            } catch (Exception e7) {
                                e2222 = e7;
                                fileOutputStream2 = null;
                                v.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", be.e(e2222));
                                if (objectOutputStream2 != null) {
                                    objectOutputStream2.close();
                                }
                                if (fileOutputStream2 != null) {
                                    fileOutputStream2.close();
                                }
                                return z;
                            } catch (Throwable th4) {
                                e2222 = th4;
                                objectOutputStream = null;
                                fileOutputStream = null;
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw e2222;
                            }
                            return z;
                        } catch (Throwable th5) {
                            e2222 = th5;
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Throwable e52) {
                                    v.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", be.e(e52));
                                    ddr = new HashMap();
                                    throw e2222;
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw e2222;
                        }
                    }
                } catch (Exception e8) {
                    e2222 = e8;
                    objectInputStream = null;
                    v.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", be.e(e2222));
                    ddr = new HashMap();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    v.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(ddr.size()), dds);
                    com.tencent.mm.loader.stub.b.deleteFile(dds);
                    it = arrayList.iterator();
                    z = false;
                    while (it.hasNext()) {
                        str = (String) it.next();
                        ay = be.ay(be.bf(ddr.get(str)));
                        v.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", str, Long.valueOf(ay));
                        if (ay > 0) {
                        }
                        ddr.put(str, Long.valueOf(be.Ni()));
                        z2 = true;
                        z = z2;
                    }
                    fileOutputStream = new FileOutputStream(dds);
                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(ddr);
                    fileOutputStream.flush();
                    v.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(ddr.size()));
                    objectOutputStream.close();
                    fileOutputStream.close();
                    return z;
                } catch (Throwable th6) {
                    e2222 = th6;
                    objectInputStream = null;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e2222;
                }
            } catch (Exception e9) {
                e2222 = e9;
                objectInputStream = null;
                fileInputStream = null;
                v.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", be.e(e2222));
                ddr = new HashMap();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                v.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(ddr.size()), dds);
                com.tencent.mm.loader.stub.b.deleteFile(dds);
                it = arrayList.iterator();
                z = false;
                while (it.hasNext()) {
                    str = (String) it.next();
                    ay = be.ay(be.bf(ddr.get(str)));
                    v.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", str, Long.valueOf(ay));
                    if (ay > 0) {
                    }
                    ddr.put(str, Long.valueOf(be.Ni()));
                    z2 = true;
                    z = z2;
                }
                fileOutputStream = new FileOutputStream(dds);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(ddr);
                fileOutputStream.flush();
                v.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(ddr.size()));
                objectOutputStream.close();
                fileOutputStream.close();
                return z;
            } catch (Throwable th7) {
                e2222 = th7;
                objectInputStream = null;
                fileInputStream = null;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e2222;
            }
            if (ddr.size() <= 0 || ddr.size() > 1000) {
                v.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", Integer.valueOf(ddr.size()), dds);
                com.tencent.mm.loader.stub.b.deleteFile(dds);
            }
        }
        it = arrayList.iterator();
        z = false;
        while (it.hasNext()) {
            str = (String) it.next();
            ay = be.ay(be.bf(ddr.get(str)));
            v.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", str, Long.valueOf(ay));
            if (ay > 0 || ay > ddq) {
                ddr.put(str, Long.valueOf(be.Ni()));
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        if (z && ddr.size() > 0) {
            fileOutputStream = new FileOutputStream(dds);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(ddr);
            fileOutputStream.flush();
            v.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", Integer.valueOf(ddr.size()));
            objectOutputStream.close();
            fileOutputStream.close();
        }
        return z;
    }

    private static String[] go(int i) {
        Throwable th;
        v.i("MicroMsg.NetTypeReporter", "dkNetTypeRead scene:%d fg:%b time:%d diff:%d", Integer.valueOf(i), Boolean.valueOf(b.foreground), Long.valueOf(ddv), Long.valueOf(be.ay(ddv)));
        if (i <= 0) {
            v.e("MicroMsg.NetTypeReporter", "ERROR PARAM: scene:%d", Integer.valueOf(i));
            return null;
        }
        Context context = aa.getContext();
        if (context == null) {
            v.e("MicroMsg.NetTypeReporter", "ERROR Context is null scene:%d", Integer.valueOf(i));
            return null;
        }
        int sb;
        v.i("MicroMsg.NetTypeReporter", "read scene:%d foreground:%b", Integer.valueOf(i), Boolean.valueOf(b.foreground));
        int i2 = 0;
        try {
            sb = w.sb();
        } catch (Throwable e) {
            v.e("MicroMsg.NetTypeReporter", "getNetType : %s", be.e(e));
            sb = i2;
        }
        v.i("MicroMsg.NetTypeReporter", "get netType :%d", Integer.valueOf(sb));
        String str = SQLiteDatabase.KeyEmpty;
        String str2 = SQLiteDatabase.KeyEmpty;
        String str3 = SQLiteDatabase.KeyEmpty;
        String networkOperatorName;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            int i3 = 0;
            ArrayList arrayList = new ArrayList();
            stringBuffer.append(connectionInfo.getSSID());
            stringBuffer2.append(connectionInfo.getBSSID());
            String bssid = connectionInfo.getBSSID();
            arrayList.add(bssid);
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                Collections.sort(scanResults, new Comparator<ScanResult>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((ScanResult) obj2).level - ((ScanResult) obj).level;
                    }
                });
                int i4 = 20;
                for (ScanResult scanResult : scanResults) {
                    if (!(scanResult == null || be.kS(scanResult.BSSID))) {
                        if (!scanResult.BSSID.equals(bssid)) {
                            int i5 = i4 - 1;
                            if (i4 <= 0) {
                                break;
                            }
                            stringBuffer.append("|");
                            stringBuffer.append(be.ma(scanResult.SSID).replace("|", SQLiteDatabase.KeyEmpty).replace(" ", SQLiteDatabase.KeyEmpty));
                            stringBuffer2.append("|");
                            stringBuffer2.append(be.ma(scanResult.BSSID).replace("|", SQLiteDatabase.KeyEmpty).replace(" ", SQLiteDatabase.KeyEmpty));
                            arrayList.add(scanResult.BSSID);
                            stringBuffer3.append("|");
                            stringBuffer3.append(scanResult.level);
                            i4 = i5;
                        } else {
                            i3 = scanResult.level;
                        }
                    }
                }
            }
            i2 = i3;
            if (i >= 2000 || i(arrayList)) {
                str = stringBuffer.toString();
                str2 = stringBuffer2.toString();
                str3 = i2 + stringBuffer3.toString();
                v.d("MicroMsg.NetTypeReporter", "get wifi :[%s] [%s]", str2, str);
                String str4 = SQLiteDatabase.KeyEmpty;
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        networkOperatorName = telephonyManager.getNetworkOperatorName();
                    } else {
                        networkOperatorName = str4;
                    }
                    str4 = networkOperatorName;
                } catch (Throwable e2) {
                    v.e("MicroMsg.NetTypeReporter", "getNetType : %s", be.e(e2));
                }
                v.i("MicroMsg.NetTypeReporter", "get ispName: %s", str4);
                String str5 = SQLiteDatabase.KeyEmpty;
                String str6 = SQLiteDatabase.KeyEmpty;
                String str7 = SQLiteDatabase.KeyEmpty;
                String str8 = SQLiteDatabase.KeyEmpty;
                String str9 = SQLiteDatabase.KeyEmpty;
                try {
                    List dT = com.tencent.mm.sdk.platformtools.ak.dT(context);
                    for (int i6 = 0; i6 < dT.size(); i6++) {
                        com.tencent.mm.sdk.platformtools.ak.a aVar = (com.tencent.mm.sdk.platformtools.ak.a) dT.get(i6);
                        str5 = be.ah(aVar.nka, SQLiteDatabase.KeyEmpty);
                        str6 = be.ah(aVar.nkb, SQLiteDatabase.KeyEmpty);
                        if (str7.length() > 0 && !be.kS(aVar.nkd)) {
                            str7 = str7 + "|";
                        }
                        if (!be.kS(aVar.nkd)) {
                            str7 = str7 + aVar.nkd;
                        }
                        if (str8.length() > 0 && !be.kS(aVar.nkc)) {
                            str8 = str8 + "|";
                        }
                        if (!be.kS(aVar.nkc)) {
                            str8 = str8 + aVar.nkc;
                        }
                        if (str9.length() > 0) {
                            str9 = str9 + "|";
                        }
                        StringBuilder append = new StringBuilder().append(str9);
                        if (be.kS(aVar.nkg)) {
                            networkOperatorName = "0";
                        } else {
                            networkOperatorName = aVar.nkg;
                        }
                        str9 = append.append(networkOperatorName).toString();
                    }
                    networkOperatorName = str9;
                    str9 = str8;
                    str8 = str7;
                    str7 = str6;
                    str6 = str5;
                } catch (Throwable e22) {
                    th = e22;
                    networkOperatorName = str9;
                    str9 = str8;
                    str8 = str7;
                    str7 = str6;
                    str6 = str5;
                    v.e("MicroMsg.NetTypeReporter", "getNetType : %s", be.e(th));
                }
                v.d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", str6, str7, str8);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(be.Nh()).append(",");
                stringBuilder.append(i).append(",");
                stringBuilder.append(sb).append(",");
                stringBuilder.append(str.replace(",", " ")).append(",");
                stringBuilder.append(str2.replace(",", " ")).append(",");
                stringBuilder.append(str4.replace(",", " ")).append(",");
                stringBuilder.append(str6.replace(",", " ")).append(",");
                stringBuilder.append(str7.replace(",", " ")).append(",");
                stringBuilder.append(str8.replace(",", " ")).append(",");
                if (Kg() < 0) {
                    return null;
                }
                return new String[]{Kg() + "," + stringBuilder.toString(), be.ma(str3), be.ma(str9), be.ma(networkOperatorName)};
            }
            v.w("MicroMsg.NetTypeReporter", "checkBssid: find all report already  , give up. scene:%d ", Integer.valueOf(i));
            return null;
        } catch (Throwable e222) {
            th = e222;
            networkOperatorName = str2;
            str2 = str;
            v.e("MicroMsg.NetTypeReporter", "getWifiInfo : %s", be.e(th));
            str = str2;
            str2 = networkOperatorName;
        }
    }

    private static long Kg() {
        long a;
        synchronized (cGJ) {
            try {
                ak.yW();
                a = be.a((Long) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_REPORTNETTYPE_SEQ_LONG, null), 1);
                ak.yW();
                c.vf().a(com.tencent.mm.storage.t.a.USERINFO_REPORTNETTYPE_SEQ_LONG, Long.valueOf(1 + a));
                ak.yW();
                c.vf().iB(true);
                ak.yW();
                long a2 = be.a((Long) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_REPORTNETTYPE_SEQ_LONG, null), 1);
                v.i("MicroMsg.NetTypeReporter", "incSeq after write  old:%d new:%d", Long.valueOf(a), Long.valueOf(a2));
            } catch (Throwable e) {
                v.e("MicroMsg.NetTypeReporter", "incSeq :%s", be.e(e));
                return -1;
            }
        }
        return a;
    }

    private static void a(int i, float f, float f2, int i2, long j) {
        long Ni = be.Ni();
        if (ddv <= 0 || Ni - ddv <= 5000) {
            final String[] go = go(i);
            if (go == null || go.length != 4 || be.kS(go[0])) {
                v.e("MicroMsg.NetTypeReporter", "report get failed val");
                return;
            }
            v.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", Integer.valueOf(i), Long.valueOf(be.ay(Ni)), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Long.valueOf(j), go[0]);
            com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
            aVar.czn = new aps();
            aVar.czo = new apt();
            aVar.uri = "/cgi-bin/micromsg-bin/rtkvreport";
            aVar.czm = 716;
            com.tencent.mm.v.b Bv = aVar.Bv();
            final aps com_tencent_mm_protocal_c_aps = (aps) Bv.czk.czs;
            com_tencent_mm_protocal_c_aps.mio = d.lWb;
            com_tencent_mm_protocal_c_aps.mip = d.lWa;
            com_tencent_mm_protocal_c_aps.miq = d.lWd;
            com_tencent_mm_protocal_c_aps.mir = d.lWe;
            com_tencent_mm_protocal_c_aps.mis = u.bsY();
            com_tencent_mm_protocal_c_aps.mFd = 11747;
            Ni = be.ay(ddv);
            if (Ni > 600000 || Ni < 0) {
                Ni = 0;
            }
            com_tencent_mm_protocal_c_aps.itR = go[0] + "0," + f + "," + f2 + "," + i2 + "," + j + "," + (b.foreground ? "1" : String.valueOf(Ni)) + "," + go[1] + "," + go[2] + "," + go[3];
            final long Ni2 = be.Ni();
            final float f3 = f;
            final float f4 = f2;
            final int i3 = i2;
            final long j2 = j;
            com.tencent.mm.v.u.a(Bv, new com.tencent.mm.v.u.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                    v.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(be.ay(Ni2)), com_tencent_mm_protocal_c_aps.itR);
                    if (!(i == 0 && i2 == 0)) {
                        long ay = be.ay(n.ddv);
                        if (ay > 600000 || ay < 0) {
                            ay = 0;
                        }
                        g.iuh.Y(11747, go[0] + "1," + f3 + "," + f4 + "," + i3 + "," + j2 + "," + (b.foreground ? "1" : String.valueOf(ay)) + "," + go[1] + "," + go[2] + "," + go[3]);
                    }
                    ak.yW();
                    c.vf().a(com.tencent.mm.storage.t.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, Long.valueOf(be.Ni()));
                    return 0;
                }
            }, true);
            return;
        }
        v.e("MicroMsg.NetTypeReporter", "never  report  at  background :%d diff:%d", Long.valueOf(ddv), Long.valueOf(Ni - ddv));
    }

    public static void aB(int i, String str) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new aps();
        aVar.czo = new apt();
        aVar.uri = "/cgi-bin/micromsg-bin/rtkvreport";
        aVar.czm = 716;
        com.tencent.mm.v.b Bv = aVar.Bv();
        final aps com_tencent_mm_protocal_c_aps = (aps) Bv.czk.czs;
        com_tencent_mm_protocal_c_aps.mio = d.lWb;
        com_tencent_mm_protocal_c_aps.mip = d.lWa;
        com_tencent_mm_protocal_c_aps.miq = d.lWd;
        com_tencent_mm_protocal_c_aps.mir = d.lWe;
        com_tencent_mm_protocal_c_aps.mis = u.bsY();
        com_tencent_mm_protocal_c_aps.mFd = i;
        com_tencent_mm_protocal_c_aps.itR = str;
        v.i("MicroMsg.NetTypeReporter", "reportCgi logId:%d, value:%s", Integer.valueOf(i), str);
        final long Ni = be.Ni();
        com.tencent.mm.v.u.a(Bv, new com.tencent.mm.v.u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                v.d("MicroMsg.NetTypeReporter", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(be.ay(Ni)), com_tencent_mm_protocal_c_aps.itR);
                return 0;
            }
        });
    }

    private static void b(int i, float f, float f2, int i2, long j) {
        try {
            v.i("MicroMsg.NetTypeReporter", "checkTimeReport scene:%d diff:%d  time:%d", Integer.valueOf(i), Long.valueOf(be.ay(ddt)), Long.valueOf(ddt));
            if (i > 2000 || be.ay(ddt) > 300000) {
                v.i("MicroMsg.NetTypeReporter", "force Run, scene:%d diff:%d time:%d ", Integer.valueOf(i), Long.valueOf(be.ay(ddt)), Long.valueOf(ddt));
                ddu = i;
                ddt = Long.MAX_VALUE;
                a(i, f, f2, i2, j);
                return;
            }
            if (ddt == Long.MAX_VALUE) {
                ddt = be.Ni() + 60000;
            }
            ddu = i;
            aSW.ea(60000);
        } catch (Throwable th) {
            v.e("MicroMsg.NetTypeReporter", "checkTimeReport error: %s", be.e(th));
        }
    }

    public static void bh(boolean z) {
        if (z) {
            ddv = 0;
        } else if (!aSW.btC()) {
            v.i("MicroMsg.NetTypeReporter", "setToForeground user turn to background run report now");
            ddv = be.Ni();
            aSW.ea(0);
        }
    }

    public static synchronized void a(int i, float f, float f2, int i2) {
        synchronized (n.class) {
            if (i < 2000 || f == 0.0f || f2 == 0.0f) {
                v.e("MicroMsg.NetTypeReporter", "reportGps, invalid args, scene = %d, lon = %f, lat = %f, pre = %d", Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2));
            } else if (be.ay(ddB) < 60000) {
                v.e("MicroMsg.NetTypeReporter", "reportGps, hit lastReportGpsLimit, request dropped, scene = %d, lon = %f, lat = %f, pre = %d", Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2));
            } else {
                v.i("MicroMsg.NetTypeReporter", "reportGps scene:%d lon:%f lat:%f pre:%d last:%d", Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Long.valueOf(be.ay(ddB)));
                ddB = be.Ni();
                ddA = i;
                ddw = be.Ni();
                ddz = i2;
                ddx = f2;
                ddy = f;
                try {
                    ((WifiManager) aa.getContext().getSystemService("wifi")).startScan();
                    ak.vA().f(new Runnable() {
                        public final void run() {
                            n.gp(MMBitmapFactory.ERROR_IO_FAILED);
                        }
                    }, 5000);
                } catch (Throwable e) {
                    v.e("MicroMsg.NetTypeReporter", "reportGps :%s", be.e(e));
                }
            }
        }
    }

    public static synchronized void gp(int i) {
        synchronized (n.class) {
            v.i("MicroMsg.NetTypeReporter", "run scene:%d foreground:%b lastGpsTime:%d lastbssid:%s", Integer.valueOf(i), Boolean.valueOf(b.foreground), Long.valueOf(ddw), ddC);
            if (i == MMBitmapFactory.ERROR_IO_FAILED) {
                try {
                    if (ddw > 0) {
                        v.d("MicroMsg.NetTypeReporter", "report gps scene:%d lastscene:%d [%f,%f,%d] lastGpsTime", Integer.valueOf(i), Integer.valueOf(ddA), Float.valueOf(ddy), Float.valueOf(ddx), Integer.valueOf(ddz), Long.valueOf(ddw));
                        long ay = be.ay(ddw);
                        int i2 = ddA;
                        float f = ddx;
                        float f2 = ddy;
                        int i3 = ddz;
                        ddw = 0;
                        ddx = 0.0f;
                        ddy = 0.0f;
                        ddz = 0;
                        ddA = 0;
                        b(i2, f2, f, i3, ay);
                    }
                } catch (Throwable th) {
                    v.e("MicroMsg.NetTypeReporter", "run :%s", be.e(th));
                }
            }
            if (!b.foreground) {
                v.w("MicroMsg.NetTypeReporter", "run is not foreground give up %d ", Integer.valueOf(i));
            } else if (i == 3) {
                String bssid = ((WifiManager) aa.getContext().getSystemService("wifi")).getConnectionInfo().getBSSID();
                v.d("MicroMsg.NetTypeReporter", "run scene:%d SCENE_TO_FOREGROUND_BSSID_CHANGE %s %s ", Integer.valueOf(i), bssid, ddC);
                if (!(be.kS(bssid) || bssid.equals(ddC))) {
                    ddC = bssid;
                    b(i, 0.0f, 0.0f, 0, 0);
                }
            } else if (i == 4) {
                ak.yW();
                v.i("MicroMsg.NetTypeReporter", "run scene:%d SCENE_TO_FOREGROUND_TIMEOUT  diff:%d", Integer.valueOf(i), Long.valueOf(be.ay(be.a((Long) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, null), 0))));
                if (be.ay(be.a((Long) c.vf().get(com.tencent.mm.storage.t.a.USERINFO_REPORTNETTYPE_LASTREPORT_LONG, null), 0)) >= 21600000) {
                    b(i, 0.0f, 0.0f, 0, 0);
                }
            } else {
                b(i, 0.0f, 0.0f, 0, 0);
            }
        }
    }
}
