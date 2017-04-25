package com.tencent.mm.plugin.backup.g;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.a.e;
import com.tencent.mm.a.n;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.arg;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ag;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.apache.http.conn.util.InetAddressUtils;

public final class g {
    private static Random ciF = new Random();
    private static List<String> ejp = null;

    public static List<String> Vw() {
        if (ejp != null) {
            return ejp;
        }
        ejp = new LinkedList();
        for (Object add : m.crG) {
            ejp.add(add);
        }
        ejp.add("weixin");
        ejp.add("weibo");
        ejp.add("qqmail");
        ejp.add("fmessage");
        ejp.add("tmessage");
        ejp.add("qmessage");
        ejp.add("qqsync");
        ejp.add("floatbottle");
        ejp.add("lbsapp");
        ejp.add("shakeapp");
        ejp.add("medianote");
        ejp.add("qqfriend");
        ejp.add("readerapp");
        ejp.add("newsapp");
        ejp.add("blogapp");
        ejp.add("facebookapp");
        ejp.add("masssendapp");
        ejp.add("meishiapp");
        ejp.add("feedsapp");
        ejp.add("voipapp");
        ejp.add("officialaccounts");
        ejp.add("helper_entry");
        ejp.add("pc_share");
        ejp.add("cardpackage");
        ejp.add("voicevoipapp");
        ejp.add("voiceinputapp");
        ejp.add("linkedinplugin");
        ejp.add("appbrandcustomerservicemsg");
        return ejp;
    }

    public static int a(String str, dx dxVar, LinkedList<com.tencent.mm.plugin.backup.f.g> linkedList, int i, boolean z, boolean z2, com.tencent.mm.plugin.backup.f.g gVar) {
        return a(str, dxVar, linkedList, i, z, SQLiteDatabase.KeyEmpty, z2, gVar);
    }

    public static int a(String str, dx dxVar, LinkedList<com.tencent.mm.plugin.backup.f.g> linkedList, int i, boolean z, String str2, boolean z2, com.tencent.mm.plugin.backup.f.g gVar) {
        int aQ = e.aQ(str);
        if (aQ <= 0 || dxVar == null) {
            boolean z3;
            String str3 = "MicroMsg.BakUtil";
            StringBuilder append = new StringBuilder("filePath error or bakitem is null ").append(str);
            if (dxVar == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            v.e(str3, append.append(z3).toString());
            return 0;
        } else if (z) {
            return aQ;
        } else {
            if (aQ < 8192 && dxVar.meT.mQu == 0) {
                byte[] g;
                if (i == 5) {
                    g = a.bmr().g(b.Vd().We().NF(ag.Mv(com.tencent.mm.platformtools.m.a(dxVar.mbW)).aZy));
                } else {
                    g = e.d(str, 0, -1);
                }
                are ba = new are().ba(g);
                dxVar.meU = aQ;
                dxVar.meV = i;
                dxVar.meT = ba;
                return aQ;
            } else if (linkedList == null) {
                v.e("MicroMsg.BakUtil", "error addupMediaList == null");
                return 0;
            } else {
                String str4 = dxVar.mbU.toString() + "_" + dxVar.mbV.toString() + "_" + dxVar.mcb + "_backup" + str2;
                v.d("MicroMsg.BakUtil", "filePath " + str + " " + str4);
                dxVar.meR.add(new arf().JF(str4));
                dxVar.meS.add(new arg().uR(i));
                if (gVar == null) {
                    gVar = new com.tencent.mm.plugin.backup.f.g();
                }
                gVar.ehN = dxVar.mcb;
                gVar.mediaId = str4;
                gVar.path = str;
                gVar.type = i;
                if (!z2) {
                    linkedList.add(gVar);
                }
                dxVar.meQ = dxVar.meR.size();
                return 0;
            }
        }
    }

    public static String a(dx dxVar, int i) {
        return a(dxVar, i, null);
    }

    public static String a(dx dxVar, int i, String str) {
        if (dxVar.meV == i && dxVar.meT != null) {
            return com.tencent.mm.a.g.m(dxVar.meT.mQw.lVU);
        }
        Iterator it = dxVar.meS.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (((arg) it.next()).mQA == i) {
                String str2 = ((arf) dxVar.meR.get(i2)).mQy;
                if (!be.kS(str) && !str2.endsWith(str)) {
                    i2++;
                } else if (e.aR(pc(str2))) {
                    return str2;
                } else {
                    return null;
                }
            }
            i2++;
        }
        return null;
    }

    public static boolean b(dx dxVar, int i) {
        if (dxVar.meV == i && dxVar.meT != null) {
            return true;
        }
        Iterator it = dxVar.meS.iterator();
        while (it.hasNext()) {
            if (((arg) it.next()).mQA == i) {
                return true;
            }
        }
        return false;
    }

    public static int c(dx dxVar, int i) {
        if (dxVar.meV == i) {
            return dxVar.meT.mQw.lVU.length;
        }
        Iterator it = dxVar.meS.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (((arg) it.next()).mQA == i) {
                return e.aQ(pc(((arf) dxVar.meR.get(i2)).mQy));
            }
            i2++;
        }
        return 0;
    }

    public static byte[] d(dx dxVar, int i) {
        if (dxVar.meV == i) {
            return dxVar.meT.mQw.lVU;
        }
        Iterator it = dxVar.meS.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (((arg) it.next()).mQA == i) {
                String pc = pc(((arf) dxVar.meR.get(i2)).mQy);
                i2 = e.aQ(pc);
                if (i2 != 0 && i2 <= 1048576) {
                    return e.d(pc, 0, -1);
                }
                v.e("MicroMsg.BakUtil", "thumb not exist or  too big!");
                return null;
            }
            i2++;
        }
        return null;
    }

    public static String pc(String str) {
        if (str == null || str.equals(SQLiteDatabase.KeyEmpty)) {
            return SQLiteDatabase.KeyEmpty;
        }
        return b.Vj() + "mmbakMeida/" + pd(str) + str;
    }

    public static String pd(String str) {
        if (str == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        String m = com.tencent.mm.a.g.m(str.getBytes());
        String str2 = SQLiteDatabase.KeyEmpty;
        String str3 = SQLiteDatabase.KeyEmpty;
        if (m.length() > 0) {
            str2 = m.charAt(0) + "/";
        }
        if (m.length() >= 2) {
            str3 = m.charAt(1) + "/";
        }
        return str2 + str3;
    }

    public static boolean pe(String str) {
        if (str == null) {
            return false;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        if (bf.q(str, "msg") != null) {
            return true;
        }
        return false;
    }

    public static boolean b(dx dxVar, int i, String str) {
        if (dxVar.meV == i) {
            byte[] bArr = dxVar.meT.mQw.lVU;
            if (bArr.length <= 0) {
                return false;
            }
            e.b(str, bArr, bArr.length);
            return true;
        }
        String a = a(dxVar, i, null);
        if (be.kS(a)) {
            return false;
        }
        j.n(pc(a), str, false);
        return true;
    }

    public static int ag(String str, int i) {
        if (!be.kS(str)) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (Throwable e) {
                v.a("MicroMsg.BakUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return i;
    }

    public static int Vx() {
        if (ak.isWifi(aa.getContext())) {
            return 3;
        }
        if (ak.is2G(aa.getContext())) {
            return 1;
        }
        if (ak.is3G(aa.getContext())) {
            return 2;
        }
        ak.is4G(aa.getContext());
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(long r14, com.tencent.mm.pointers.PLong r16, com.tencent.mm.pointers.PLong r17, java.lang.String r18) {
        /*
        r2 = com.tencent.mm.compatible.util.h.getExternalStorageDirectory();
        r3 = new android.os.StatFs;
        r2 = r2.getPath();
        r3.<init>(r2);
        r2 = r3.getBlockSize();
        r4 = (long) r2;
        r2 = r3.getAvailableBlocks();
        r2 = (long) r2;
        r2 = r2 * r4;
        r0 = r16;
        r0.value = r2;
        r2 = com.tencent.mm.compatible.util.h.getDataDirectory();
        r3 = new android.os.StatFs;
        r4 = r2.getPath();
        r3.<init>(r4);
        r4 = r3.getBlockCount();
        r4 = (long) r4;
        r6 = r3.getAvailableBlocks();
        r6 = (long) r6;
        r8 = r3.getBlockSize();
        r8 = (long) r8;
        r3 = r3.getAvailableBlocks();
        r10 = (long) r3;
        r8 = r8 * r10;
        r0 = r17;
        r0.value = r8;
        r3 = "MicroMsg.BakUtil";
        r8 = "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d";
        r9 = 3;
        r9 = new java.lang.Object[r9];
        r10 = 0;
        r0 = r16;
        r12 = r0.value;
        r11 = java.lang.Long.valueOf(r12);
        r9[r10] = r11;
        r10 = 1;
        r0 = r17;
        r12 = r0.value;
        r11 = java.lang.Long.valueOf(r12);
        r9[r10] = r11;
        r10 = 2;
        r11 = java.lang.Long.valueOf(r14);
        r9[r10] = r11;
        com.tencent.mm.sdk.platformtools.v.i(r3, r8, r9);
        r8 = 0;
        r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r3 > 0) goto L_0x0073;
    L_0x0071:
        r2 = 0;
    L_0x0072:
        return r2;
    L_0x0073:
        r4 = r4 - r6;
        r6 = 0;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 >= 0) goto L_0x007c;
    L_0x007a:
        r2 = 0;
        goto L_0x0072;
    L_0x007c:
        r0 = r16;
        r4 = r0.value;
        r0 = r17;
        r6 = r0.value;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 == 0) goto L_0x0094;
    L_0x0088:
        r2 = r2.getPath();
        r0 = r18;
        r2 = r0.startsWith(r2);
        if (r2 == 0) goto L_0x009a;
    L_0x0094:
        r2 = 0;
        r0 = r16;
        r0.value = r2;
    L_0x009a:
        r0 = r17;
        r2 = r0.value;
        r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x00a4;
    L_0x00a2:
        r2 = 0;
        goto L_0x0072;
    L_0x00a4:
        r2 = 1;
        goto L_0x0072;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.g.g.a(long, com.tencent.mm.pointers.PLong, com.tencent.mm.pointers.PLong, java.lang.String):boolean");
    }

    public static String bw(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager.getWifiState() == 3) {
            String ssid;
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                try {
                    ssid = connectionInfo.getSSID();
                } catch (Throwable e) {
                    v.e("MicroMsg.BakUtil", "getConnectionInfo %s", e);
                    v.a("MicroMsg.BakUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return SQLiteDatabase.KeyEmpty;
                }
            }
            ssid = "wifi";
            if (ssid.length() < 2 || !ssid.startsWith("\"") || !ssid.endsWith("\"")) {
                return ssid;
            }
            v.i("MicroMsg.BakUtil", "start and end with \", and trunk it");
            return ssid.substring(1, ssid.length() - 1);
        }
        int intValue;
        int i = 13;
        try {
            i = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
            intValue = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
        } catch (Throwable e2) {
            v.e("MicroMsg.BakUtil", "getWifiApState %s", e2);
            v.a("MicroMsg.BakUtil", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            intValue = 0;
        }
        if (intValue == i) {
            v.i("MicroMsg.BakUtil", "getWifiName apmode");
            try {
                return ((WifiConfiguration) wifiManager.getClass().getMethod("getWifiApConfiguration", new Class[0]).invoke(wifiManager, new Object[0])).SSID;
            } catch (Throwable e3) {
                v.e("MicroMsg.BakUtil", "getWifiApConfiguration %s", e3);
                v.a("MicroMsg.BakUtil", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public static boolean pf(String str) {
        int intValue;
        Throwable e;
        String[] split = str.split("\\.");
        int o = n.o(new byte[]{(byte) (be.getInt(split[0], 0) & WebView.NORMAL_MODE_ALPHA), (byte) (be.getInt(split[1], 0) & WebView.NORMAL_MODE_ALPHA), (byte) (be.getInt(split[2], 0) & WebView.NORMAL_MODE_ALPHA), (byte) (be.getInt(split[3], 0) & WebView.NORMAL_MODE_ALPHA)});
        int o2 = n.o(new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) 0});
        WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
        int ipAddress;
        if (wifiManager.getWifiState() == 3) {
            ipAddress = wifiManager.getConnectionInfo().getIpAddress();
            String str2 = (ipAddress & WebView.NORMAL_MODE_ALPHA) + "." + ((ipAddress >> 8) & WebView.NORMAL_MODE_ALPHA) + "." + ((ipAddress >> 16) & WebView.NORMAL_MODE_ALPHA) + "." + ((ipAddress >> 24) & WebView.NORMAL_MODE_ALPHA);
            v.i("MicroMsg.BakUtil", "oldIpStr:%s, localIp:%s", str, str2);
            if ((o2 & o) == (ipAddress & o2)) {
                return true;
            }
            return false;
        }
        try {
            intValue = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
            try {
                ipAddress = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.BakUtil", "getWifiApState %s", e);
                v.a("MicroMsg.BakUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                ipAddress = 0;
                if (ipAddress == intValue) {
                    v.i("MicroMsg.BakUtil", "matchip in apmode");
                    return bl(o2, o);
                }
                v.i("MicroMsg.BakUtil", "apState:%d", Integer.valueOf(ipAddress));
                return false;
            }
        } catch (Exception e3) {
            e = e3;
            intValue = 13;
            v.e("MicroMsg.BakUtil", "getWifiApState %s", e);
            v.a("MicroMsg.BakUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            ipAddress = 0;
            if (ipAddress == intValue) {
                v.i("MicroMsg.BakUtil", "apState:%d", Integer.valueOf(ipAddress));
                return false;
            }
            v.i("MicroMsg.BakUtil", "matchip in apmode");
            return bl(o2, o);
        }
        if (ipAddress == intValue) {
            v.i("MicroMsg.BakUtil", "matchip in apmode");
            return bl(o2, o);
        }
        v.i("MicroMsg.BakUtil", "apState:%d", Integer.valueOf(ipAddress));
        return false;
    }

    private static boolean bl(int i, int i2) {
        try {
            for (NetworkInterface inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InetAddress inetAddress : Collections.list(inetAddresses.getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        String toUpperCase = inetAddress.getHostAddress().toUpperCase();
                        v.i("MicroMsg.BakUtil", "check ip:%s, isIPv4:%b", toUpperCase, Boolean.valueOf(InetAddressUtils.isIPv4Address(toUpperCase)));
                        if (InetAddressUtils.isIPv4Address(toUpperCase)) {
                            String[] split = toUpperCase.split("\\.");
                            if ((i & i2) == (n.o(new byte[]{(byte) (be.getInt(split[0], 0) & WebView.NORMAL_MODE_ALPHA), (byte) (be.getInt(split[1], 0) & WebView.NORMAL_MODE_ALPHA), (byte) (be.getInt(split[2], 0) & WebView.NORMAL_MODE_ALPHA), (byte) (be.getInt(split[3], 0) & WebView.NORMAL_MODE_ALPHA)}) & i)) {
                                return true;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean Vy() {
        int intValue;
        int intValue2;
        Throwable e;
        WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
        try {
            intValue = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
            try {
                intValue2 = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.BakUtil", "getWifiApState %s", e);
                v.a("MicroMsg.BakUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                intValue2 = 0;
                if (intValue2 == intValue) {
                    return false;
                }
                return true;
            }
        } catch (Exception e3) {
            e = e3;
            intValue = 13;
            v.e("MicroMsg.BakUtil", "getWifiApState %s", e);
            v.a("MicroMsg.BakUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            intValue2 = 0;
            if (intValue2 == intValue) {
                return true;
            }
            return false;
        }
        if (intValue2 == intValue) {
            return true;
        }
        return false;
    }

    public static void Vz() {
        b.oW("id");
        b.oX("hello");
        b.oY("ok");
        b.O("key".getBytes());
    }

    public static String aG(long j) {
        long j2 = j / 1024;
        long j3 = j2 / 1024;
        long j4 = j3 / 1024;
        if (j4 > 0) {
            return j4 + "." + (((j3 - (j4 * 1024)) * 10) / 1024) + "G";
        }
        if (j3 > 0) {
            return j3 + "." + (((j2 - (j3 * 1024)) * 10) / 1024) + "M";
        }
        if (j2 == 0) {
            j2 = 1;
        }
        return j2 + "K";
    }

    public static int VA() {
        Intent registerReceiver = aa.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return 100;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        boolean z = intExtra == 2 || intExtra == 5;
        v.i("MicroMsg.BakUtil", "Battery mCharging: %b", Boolean.valueOf(z));
        if (z) {
            return 100;
        }
        intExtra = registerReceiver.getIntExtra("level", -1);
        int intExtra2 = registerReceiver.getIntExtra("scale", -1);
        if (intExtra < 0 || intExtra2 <= 0) {
            intExtra = 100;
        } else {
            intExtra = (intExtra * 100) / intExtra2;
        }
        v.i("MicroMsg.BakUtil", "Battery Level Remaining: %d", Integer.valueOf(intExtra));
        return intExtra;
    }
}
