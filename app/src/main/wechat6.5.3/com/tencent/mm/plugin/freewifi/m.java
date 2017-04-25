package com.tencent.mm.plugin.freewifi;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.protocal.c.dq;
import com.tencent.mm.protocal.c.nf;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bindmobile.BindMContactUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.logreport.UpdateInfoReportManager.UpdateLogConst;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.ConnectException;
import java.net.NetworkInterface;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public final class m {
    private static SimpleDateFormat fXP = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");

    public static boolean ty(String str) {
        return str == null || str.length() == 0;
    }

    public static String tz(String str) {
        if (ty(str)) {
            return "";
        }
        if (str.startsWith("\"") && str.endsWith("\"")) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    public static boolean aoB() {
        String bf = be.bf(aa.getContext());
        return bf != null && bf.toLowerCase().startsWith(aa.getPackageName());
    }

    public static void r(Intent intent) {
        if (ty(intent.getStringExtra("free_wifi_sessionkey"))) {
            d(intent, aoC());
        }
    }

    public static String aoC() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void d(Intent intent, String str) {
        intent.putExtra("free_wifi_sessionkey", str);
        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0);
    }

    public static String s(Intent intent) {
        return tA(intent.getStringExtra("free_wifi_sessionkey"));
    }

    public static int t(Intent intent) {
        int intExtra = intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", 0) + 1;
        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_LOG_STEP_ID", intExtra);
        return intExtra;
    }

    public static int u(Intent intent) {
        return intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    }

    public static int v(Intent intent) {
        return intent.getIntExtra("free_wifi_channel_id", 0);
    }

    public static String w(Intent intent) {
        return intent.getStringExtra("free_wifi_ap_key");
    }

    public static String tA(String str) {
        return str == null ? "" : str;
    }

    public static String tB(String str) {
        if (aoF()) {
            WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            String ssid = connectionInfo.getSSID();
            if (ty(ssid)) {
                v.i(str, "getConnectedWifiSsid() is empty");
                return "";
            }
            v.i(str, "getConnectedWifiSsid()=" + tz(ssid));
            return tz(ssid);
        }
        v.i(str, "wifi not connected. getConnectedWifiSsid() is empty");
        return "";
    }

    public static String tC(String str) {
        if (aoF()) {
            WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            String toLowerCase = tA(connectionInfo.getBSSID()).toLowerCase();
            v.i(str, "getConnectedWifiBssid()=" + toLowerCase);
            return toLowerCase;
        }
        v.i(str, "wifi not connected. getConnectedWifiBssid() is empty");
        return "";
    }

    public static String tD(String str) {
        WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            v.e(str, "error wifiManager is null!!");
            return "";
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            v.e(str, "error wifiInfo is null!!");
            return "";
        }
        String macAddress = connectionInfo.getMacAddress();
        if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
            macAddress = aoD();
        }
        macAddress = tA(macAddress).toLowerCase();
        v.i(str, "getConnectedWifiClientMac()=" + macAddress);
        return macAddress;
    }

    public static String aoD() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String str = "wlan0";
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        v.d("MicroMsg.FreeWifi.Utils", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
                        return "02:00:00:00:00:00";
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        stringBuilder.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                    v.d("MicroMsg.FreeWifi.Utils", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
                    return stringBuilder.toString();
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.FreeWifi.Utils", "get mobile mac from net fail!" + e);
        }
        v.d("MicroMsg.FreeWifi.Utils", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
        return "02:00:00:00:00:00";
    }

    public static String e(Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        String tA = tA(stringWriter.toString());
        if (tA.length() > 1024) {
            return tA.substring(0, 1024);
        }
        return tA;
    }

    public static String f(Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return tA(stringWriter.toString());
    }

    public static String a(int i, b bVar, int i2) {
        Object format;
        v.i("MicroMsg.FreeWifi.Utils", "getUiErrorCode, protocol=%d, stageName=%s, stageCode=%d, errocode=%d", new Object[]{Integer.valueOf(i), bVar.name, Long.valueOf(bVar.fXM), Integer.valueOf(i2)});
        int abs = Math.abs(i2);
        StringBuilder append = new StringBuilder().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(String.format("%03d", new Object[]{Long.valueOf(bVar.fXM)}));
        if (abs <= 999) {
            format = String.format("%03d", new Object[]{Integer.valueOf(abs)});
        } else {
            format = Integer.valueOf(abs);
        }
        return append.append(format).toString();
    }

    public static void a(Intent intent, String str, int i, int i2, FreeWifiFrontPageUI freeWifiFrontPageUI, String str2) {
        final String str3 = str2;
        final String str4 = str;
        final Intent intent2 = intent;
        final int i3 = i;
        final int i4 = i2;
        final FreeWifiFrontPageUI freeWifiFrontPageUI2 = freeWifiFrontPageUI;
        j.apm().aoU().post(new Runnable() {
            public final void run() {
                a aoy = k.aoy();
                aoy.ssid = m.tB(str3);
                aoy.bssid = m.tC(str3);
                aoy.aYA = m.tD(str3);
                aoy.aYz = str4;
                aoy.fXa = m.s(intent2);
                aoy.fXb = i3;
                aoy.fXc = b.GetBackPage.fXM;
                aoy.fXd = b.GetBackPage.name;
                aoy.bkh = m.v(intent2);
                aoy.bpc = 0;
                aoy.aoA().aoz();
                String tC = m.tC(str3);
                String tB = m.tB(str3);
                int aoX = d.aoX();
                v.i(str3, "NetStatusUtil.getNetType(MMApplicationContext.getContext()) = " + ak.getNetType(aa.getContext()));
                v.i(str3, "sessionKey=%s, step=%d, method=getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.s(intent2), Integer.valueOf(m.t(intent2)), str4, tC, tB, Integer.valueOf(aoX)});
                new com.tencent.mm.plugin.freewifi.d.a(str4, tC, tB, aoX, i4, m.s(intent2)).b(new e(this) {
                    final /* synthetic */ AnonymousClass1 fXU;

                    {
                        this.fXU = r1;
                    }

                    public final void a(int i, int i2, String str, k kVar) {
                        v.i(str3, "sessionKey=%s, step=%d, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.s(intent2), Integer.valueOf(m.t(intent2)), Integer.valueOf(i), Integer.valueOf(i2), str});
                        a aoy = k.aoy();
                        aoy.ssid = m.tB(str3);
                        aoy.bssid = m.tC(str3);
                        aoy.aYA = m.tD(str3);
                        aoy.aYz = str4;
                        aoy.fXa = m.s(intent2);
                        aoy.fXb = m.u(intent2);
                        aoy.fXc = b.GetBackPage33Return.fXM;
                        aoy.fXd = b.GetBackPage33Return.name;
                        aoy.bkh = m.v(intent2);
                        aoy.bpc = i2;
                        aoy.eOP = str;
                        aoy.aoA().b(intent2, true).aoz();
                        FreeWifiFrontPageUI freeWifiFrontPageUI;
                        FreeWifiFrontPageUI.d dVar;
                        FreeWifiFrontPageUI.a aVar;
                        if (i == 0 && i2 == 0) {
                            if (kVar instanceof com.tencent.mm.plugin.freewifi.d.a) {
                                dq apx = ((com.tencent.mm.plugin.freewifi.d.a) kVar).apx();
                                if (apx != null) {
                                    v.i(str3, "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{apx.mbH, apx.efy, apx.gln, Integer.valueOf(apx.mex), apx.mey, apx.cHf, apx.mez});
                                    FreeWifiFrontPageUI freeWifiFrontPageUI2 = freeWifiFrontPageUI2;
                                    FreeWifiFrontPageUI.d dVar2 = FreeWifiFrontPageUI.d.SUCCESS;
                                    FreeWifiFrontPageUI.b bVar = new FreeWifiFrontPageUI.b();
                                    bVar.gbO = apx;
                                    freeWifiFrontPageUI2.a(dVar2, bVar);
                                    return;
                                }
                                v.i(str3, "backPageInfo is null");
                                freeWifiFrontPageUI = freeWifiFrontPageUI2;
                                dVar = FreeWifiFrontPageUI.d.FAIL;
                                aVar = new FreeWifiFrontPageUI.a();
                                aVar.gbN = m.a(i3, b.GetBackPageReturn, 21);
                                freeWifiFrontPageUI.a(dVar, aVar);
                            }
                        } else if (!m.bG(i, i2) || m.ty(str)) {
                            freeWifiFrontPageUI = freeWifiFrontPageUI2;
                            dVar = FreeWifiFrontPageUI.d.FAIL;
                            aVar = new FreeWifiFrontPageUI.a();
                            aVar.gbN = m.a(i3, b.GetBackPageReturn, i2);
                            freeWifiFrontPageUI.a(dVar, aVar);
                        } else {
                            freeWifiFrontPageUI = freeWifiFrontPageUI2;
                            dVar = FreeWifiFrontPageUI.d.FAIL;
                            aVar = new FreeWifiFrontPageUI.a();
                            aVar.text = str;
                            aVar.gbN = m.a(i3, b.GetBackPageReturn, i2);
                            freeWifiFrontPageUI.a(dVar, aVar);
                        }
                    }
                });
            }
        });
    }

    public static int aoE() {
        com.tencent.mm.modelfriend.m.a EY = com.tencent.mm.modelfriend.m.EY();
        if (EY == com.tencent.mm.modelfriend.m.a.cHP || EY == com.tencent.mm.modelfriend.m.a.cHQ) {
            return 1;
        }
        com.tencent.mm.model.ak.yW();
        String str = (String) c.vf().get(6, null);
        if (ty(str)) {
            return 1;
        }
        Object vl;
        if (str.startsWith("+")) {
            vl = al.vl(str);
        } else {
            vl = "86";
        }
        if ("86".equals(vl)) {
            return 2;
        }
        return 3;
    }

    public static void bQ(Context context) {
        Intent intent = new Intent(context, BindMContactUI.class);
        intent.putExtra("is_bind_for_safe_device", false);
        intent.putExtra("is_bind_for_change_mobile", false);
        String simCountryIso = ((TelephonyManager) context.getSystemService("phone")).getSimCountryIso();
        if (!be.kS(simCountryIso)) {
            com.tencent.mm.af.b.a g = com.tencent.mm.af.b.g(context, simCountryIso, context.getString(2131232236));
            if (g != null) {
                intent.putExtra("country_name", g.cQn);
                intent.putExtra("couttry_code", g.cQm);
            }
        }
        MMWizardActivity.w(context, intent);
    }

    public static boolean bF(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return true;
        }
        return false;
    }

    public static boolean bG(int i, int i2) {
        if (i != 4 || i2 > -30000 || i2 <= -31000) {
            return false;
        }
        return true;
    }

    public static int g(Exception exception) {
        if (exception instanceof SocketTimeoutException) {
            String f = f(exception);
            if (f.indexOf(".read") != -1) {
                return 105;
            }
            if (f.indexOf(".connect") != -1) {
                return UpdateLogConst.ACTION_POP_INSTALL_DIALOG;
            }
            return 101;
        } else if (exception instanceof ConnectException) {
            return 106;
        } else {
            if (exception instanceof UnknownHostException) {
                return 102;
            }
            return 101;
        }
    }

    public static boolean h(Map<String, String> map, String str) {
        v.i(str, "CLIENT_VERSION=" + com.tencent.mm.protocal.d.lWh);
        String str2 = (String) map.get(".sysmsg.apply_versions.version_desc.$minInclude");
        String str3 = (String) map.get(".sysmsg.apply_versions.version_desc.$maxInclude");
        v.i(str, "checkMsgPushedVersion. min0=%s,max0=%s", new Object[]{str2, str3});
        if (ty(str2) && ty(str3)) {
            return false;
        }
        if (bA(str2, str3)) {
            return true;
        }
        int i = 1;
        while (true) {
            str2 = (String) map.get(".sysmsg.apply_versions.version_desc#" + i + ".$minInclude");
            str3 = (String) map.get(".sysmsg.apply_versions.version_desc#" + i + ".$maxInclude");
            v.i(str, "checkMsgPushedVersion. min" + i + "=%s,max" + i + "=%s", new Object[]{str2, str3});
            if (ty(str2) && ty(str3)) {
                return false;
            }
            if (bA(str2, str3)) {
                return true;
            }
            i++;
        }
    }

    private static boolean bA(String str, String str2) {
        int i = be.getInt(str, 0);
        int i2 = be.getInt(str2, 0);
        if (i == 0 && i2 != 0 && com.tencent.mm.protocal.d.lWh <= i2) {
            return true;
        }
        if (i != 0 && i2 == 0 && com.tencent.mm.protocal.d.lWh >= i) {
            return true;
        }
        if (i == 0 || i2 == 0 || com.tencent.mm.protocal.d.lWh < i || com.tencent.mm.protocal.d.lWh > i2) {
            return false;
        }
        return true;
    }

    public static boolean aoF() {
        if (((ConnectivityManager) aa.getContext().getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
            v.i("TAG", "isWifiConnected()=true");
            return true;
        }
        v.i("TAG", "isWifiConnected()=false");
        return false;
    }

    public static nf aoG() {
        nf nfVar = new nf();
        nfVar.deviceBrand = com.tencent.mm.protocal.d.lWa;
        if (d.fWG == null || d.fWG.equals("")) {
            nfVar.mpf = tD("MicroMsg.FreeWifi.Utils");
        } else {
            nfVar.mpf = d.fWG;
        }
        nfVar.deviceModel = com.tencent.mm.protocal.d.lWb;
        nfVar.osName = com.tencent.mm.protocal.d.lWd;
        nfVar.osVersion = com.tencent.mm.protocal.d.lWe;
        return nfVar;
    }

    public static String a(String str, LinkedHashMap<String, Class> linkedHashMap, f fVar, String str2) {
        if (linkedHashMap.size() == 0) {
            return "";
        }
        String str3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str).append("\r\n");
        StringBuilder stringBuilder2 = new StringBuilder();
        for (Entry key : linkedHashMap.entrySet()) {
            stringBuilder2.append((String) key.getKey()).append(",");
        }
        if (stringBuilder2.length() > 0) {
            stringBuilder2.delete(stringBuilder2.length() - 1, stringBuilder2.length());
        }
        String str4 = "select " + stringBuilder2.toString() + " from " + str;
        for (Entry key2 : linkedHashMap.entrySet()) {
            stringBuilder.append((String) key2.getKey()).append("\t");
        }
        stringBuilder.append("\r\n");
        Cursor rawQuery = fVar.rawQuery(str4, new String[0]);
        while (rawQuery.moveToNext()) {
            int i = 0;
            for (Entry key22 : linkedHashMap.entrySet()) {
                Class cls = (Class) key22.getValue();
                if (cls == String.class) {
                    stringBuilder.append(rawQuery.getString(i));
                } else if (cls == Integer.TYPE) {
                    stringBuilder.append(rawQuery.getInt(i));
                } else {
                    try {
                        if (cls == Long.TYPE) {
                            stringBuilder.append(rawQuery.getLong(i));
                        } else if (cls == Float.TYPE) {
                            stringBuilder.append(rawQuery.getFloat(i));
                        } else if (cls == Double.TYPE) {
                            stringBuilder.append(rawQuery.getDouble(i));
                        } else {
                            v.e(str2, "unkonwn type " + cls.toString());
                            stringBuilder.append(rawQuery.getString(i));
                        }
                    } catch (Exception e) {
                        v.i(str2, "print " + str + "error." + e.getMessage());
                        str3 = "";
                        return str3;
                    } finally {
                        rawQuery.close();
                    }
                }
                stringBuilder.append("\t");
                i++;
            }
            stringBuilder.append("\r\n");
        }
        v.i(str2, stringBuilder.toString());
        str3 = stringBuilder.toString();
        return str3;
    }

    public static void tE(String str) {
        v.i("FreeWifi", str);
    }
}
