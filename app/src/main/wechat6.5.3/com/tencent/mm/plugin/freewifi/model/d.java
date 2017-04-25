package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d {
    private static Map<Integer, String> fYG = new HashMap<Integer, String>() {
        {
            put(Integer.valueOf(-1), "CONNECT_STATE_NOT_CONNECT");
            put(Integer.valueOf(0), "CONNECT_STATE_NOT_WECHAT_WIFI");
            put(Integer.valueOf(1), "CONNECT_STATE_CONNECTING");
            put(Integer.valueOf(2), "CONNECT_STATE_CONNECT_SUCCESS");
            put(Integer.valueOf(3), "CONNECT_STATE_CONNECT_FAILED");
            put(Integer.valueOf(4), "CONNECT_STATE_WAIT_START");
        }
    };

    public static int tG(String str) {
        if (be.kS(str)) {
            v.d("MicroMsg.FreeWifi.FreeWifiManager", "Illegal SSID");
            return 0;
        }
        c tP = j.apj().tP(str);
        if (tP == null || !str.equalsIgnoreCase(tP.field_ssid)) {
            return 0;
        }
        if (tP.field_connectState == 2 && tP.field_expiredTime > 0 && tP.field_expiredTime - be.Nh() <= 0) {
            tP.field_connectState = 1;
            boolean a = j.apj().a(tP, new String[0]);
            v.i("MicroMsg.FreeWifi.FreeWifiManager", "Expired, re-auth, expired time : %d, current time : %d, ret : %b", new Object[]{Long.valueOf(tP.field_expiredTime), Long.valueOf(be.Nh()), Boolean.valueOf(a)});
        }
        return tP.field_connectState;
    }

    public static void release() {
    }

    public static boolean tH(String str) {
        v.i("MicroMsg.FreeWifi.FreeWifiManager", "check is wechat free wifi, ssid : %s", new Object[]{str});
        if (be.kS(str)) {
            v.e("MicroMsg.FreeWifi.FreeWifiManager", "ssid is null or nil");
            return false;
        }
        String aoY = aoY();
        if (be.kS(aoY) || !aoY.equals(str)) {
            return false;
        }
        return true;
    }

    public static int tI(String str) {
        WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            v.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, get wifi manager failed");
            return -11;
        }
        int tK = tK(str);
        if (tK > 0) {
            v.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, the network has exsited, just enable it");
        } else {
            WifiConfiguration wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.allowedAuthAlgorithms.clear();
            wifiConfiguration.allowedGroupCiphers.clear();
            wifiConfiguration.allowedKeyManagement.clear();
            wifiConfiguration.allowedPairwiseCiphers.clear();
            wifiConfiguration.allowedProtocols.clear();
            wifiConfiguration.SSID = "\"" + str + "\"";
            v.i("MicroMsg.FreeWifi.FreeWifiManager", "check is the same ssid is exist, %b", new Object[]{Boolean.valueOf(tJ(str))});
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
            tK = wifiManager.addNetwork(wifiConfiguration);
        }
        v.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork netid : %d, result : %b", new Object[]{Integer.valueOf(tK), Boolean.valueOf(wifiManager.enableNetwork(tK, true))});
        if (wifiManager.enableNetwork(tK, true)) {
            return 0;
        }
        return -14;
    }

    public static int c(String str, String str2, int i, boolean z) {
        v.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt, ssid is : %s, password : %s, cryptType :%d, hideSSID = %b", new Object[]{str, str2, Integer.valueOf(i), Boolean.valueOf(z)});
        if (be.kS(str)) {
            v.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg failed, ssid is null");
            return -12;
        } else if (i == 0) {
            return tI(str);
        } else {
            if (be.kS(str2)) {
                v.e("MicroMsg.FreeWifi.FreeWifiManager", "encrypt type is not none, while password is null");
                return -15;
            }
            WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
            if (wifiManager == null) {
                v.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, get wifi manager failed");
                return -11;
            }
            int tK = tK(str);
            if (tK > 0) {
                boolean removeNetwork = wifiManager.removeNetwork(tK);
                v.i("MicroMsg.FreeWifi.FreeWifiManager", "this network has exist : %s, try to remove it : %b", new Object[]{str, Boolean.valueOf(removeNetwork)});
            }
            WifiConfiguration wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.SSID = "\"" + str + "\"";
            wifiConfiguration.status = 2;
            switch (i) {
                case 1:
                    wifiConfiguration.wepKeys = new String[]{"\"" + str2 + "\""};
                    wifiConfiguration.allowedKeyManagement.set(0);
                    break;
                case 2:
                case 3:
                    wifiConfiguration.preSharedKey = "\"" + str2 + "\"";
                    wifiConfiguration.allowedKeyManagement.set(1);
                    break;
                default:
                    v.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", new Object[]{Integer.valueOf(i)});
                    break;
            }
            wifiConfiguration.hiddenSSID = z;
            tK = wifiManager.addNetwork(wifiConfiguration);
            wifiManager.saveConfiguration();
            v.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, netid : %d, result : %b", new Object[]{Integer.valueOf(tK), Boolean.valueOf(wifiManager.enableNetwork(tK, true))});
            if (wifiManager.enableNetwork(tK, true)) {
                return 0;
            }
            return -14;
        }
    }

    public static boolean isWifiEnabled() {
        WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            v.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            return false;
        }
        v.i("MicroMsg.FreeWifi.FreeWifiManager", "is wifi enalbe now : %b", new Object[]{Boolean.valueOf(wifiManager.isWifiEnabled())});
        return wifiManager.isWifiEnabled();
    }

    public static boolean aoV() {
        WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
        if (wifiManager != null) {
            return wifiManager.setWifiEnabled(true);
        }
        v.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
        return false;
    }

    public static boolean tJ(String str) {
        int tK = tK(str);
        v.i("MicroMsg.FreeWifi.FreeWifiManager", "get network id by ssid :%s, netid is %d", new Object[]{str, Integer.valueOf(tK)});
        if (tK == -1) {
            v.i("MicroMsg.FreeWifi.FreeWifiManager", "ssid is not exist : %s", new Object[]{str});
            return false;
        }
        WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
        boolean removeNetwork = wifiManager.removeNetwork(tK);
        wifiManager.saveConfiguration();
        v.i("MicroMsg.FreeWifi.FreeWifiManager", "remove ssid : %s, ret = %b", new Object[]{str, Boolean.valueOf(removeNetwork)});
        return removeNetwork;
    }

    private static int tK(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
            return -1;
        }
        List<WifiConfiguration> configuredNetworks = ((WifiManager) aa.getContext().getSystemService("wifi")).getConfiguredNetworks();
        if (configuredNetworks == null) {
            v.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
            return -1;
        }
        v.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", new Object[]{Integer.valueOf(configuredNetworks.size())});
        for (WifiConfiguration wifiConfiguration : configuredNetworks) {
            v.i("MicroMsg.FreeWifi.FreeWifiManager", "existing WifiConfiguration.SSID = %s", new Object[]{wifiConfiguration.SSID});
            if (wifiConfiguration.SSID.equals("\"" + str + "\"")) {
                return wifiConfiguration.networkId;
            }
        }
        return -1;
    }

    public static String kX(int i) {
        String str = (String) fYG.get(Integer.valueOf(i));
        if (str == null) {
            return "";
        }
        return str;
    }

    public static void a(String str, int i, Intent intent) {
        v.i("MicroMsg.FreeWifi.FreeWifiManager", "sessionKey=%s, step=%d, method=FreeWifiManager.updateConnectState, desc=it changes the connect state of the model to %s. state=%d", new Object[]{m.s(intent), Integer.valueOf(m.t(intent)), kX(i), Integer.valueOf(i)});
        c tP = j.apj().tP(str);
        if (tP != null) {
            tP.field_connectState = i;
            boolean a = j.apj().a(tP, new String[0]);
            v.i("MicroMsg.FreeWifi.FreeWifiManager", "update %s, connect state : %d, return : %b", new Object[]{str, Integer.valueOf(i), Boolean.valueOf(a)});
        }
    }

    public static String aoW() {
        if (ak.getNetType(aa.getContext()) == 0) {
            WifiInfo aoZ = aoZ();
            if (!(aoZ == null || aoZ.getBSSID() == null)) {
                v.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiMacAddress, get bssid now : %s", new Object[]{aoZ.getBSSID()});
                return aoZ.getBSSID();
            }
        }
        return null;
    }

    public static int aoX() {
        if (ak.getNetType(aa.getContext()) == 0) {
            WifiInfo aoZ = aoZ();
            if (aoZ != null) {
                v.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiSignal, get rssi now : %d", new Object[]{Integer.valueOf(aoZ.getRssi())});
                return aoZ.getRssi();
            }
        }
        return 0;
    }

    public static String aoY() {
        v.i("MicroMsg.FreeWifi.FreeWifiManager", "networkType = %d", new Object[]{Integer.valueOf(ak.getNetType(aa.getContext()))});
        if (ak.getNetType(aa.getContext()) == 0) {
            WifiInfo aoZ = aoZ();
            if (!(aoZ == null || aoZ.getSSID() == null)) {
                v.i("MicroMsg.FreeWifi.FreeWifiManager", "get ssid now : %s", new Object[]{aoZ.getSSID().replace("\"", "")});
                return aoZ.getSSID().replace("\"", "");
            }
        }
        return null;
    }

    public static WifiInfo aoZ() {
        WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            v.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            return null;
        }
        try {
            return wifiManager.getConnectionInfo();
        } catch (Exception e) {
            v.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectionInfo failed : %s", new Object[]{e.getMessage()});
            return null;
        }
    }

    public static String apa() {
        WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            v.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            return "";
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            String bssid = connectionInfo.getBSSID();
            if (bssid == null) {
                return "";
            }
            return bssid;
        } catch (Exception e) {
            v.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiBssid failed : %s", new Object[]{e.getMessage()});
            return "";
        }
    }

    public static String apb() {
        WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            v.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            return "";
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            String ssid = connectionInfo.getSSID();
            if (ssid == null) {
                return "";
            }
            return m.tz(ssid);
        } catch (Exception e) {
            v.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiBssid failed : %s", new Object[]{e.getMessage()});
            return "";
        }
    }

    public static int getNetworkType() {
        return ak.getNetType(aa.getContext());
    }
}
