package com.tencent.mars.comm;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;

public class NetworkSignalUtil {
    public static final String TAG = "MicroMsg.NetworkSignalUtil";
    private static Context context = null;
    private static long strength = 10000;

    public static void InitNetworkSignalUtil(Context context) {
        context = context;
        ((TelephonyManager) context.getSystemService("phone")).listen(new PhoneStateListener() {
            public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
                super.onSignalStrengthsChanged(signalStrength);
                NetworkSignalUtil.calSignalStrength(signalStrength);
            }
        }, FileUtils.S_IRUSR);
    }

    public static long getNetworkSignalStrength(boolean z) {
        return 0;
    }

    public static long getGSMSignalStrength() {
        return strength;
    }

    public static long getWifiSignalStrength() {
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null || connectionInfo.getBSSID() == null) {
            v.v(TAG, "Can Not Get Wifi Signal");
            return 0;
        }
        int calculateSignalLevel = WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 10);
        v.v(TAG, "Wifi Signal:" + (calculateSignalLevel * 10));
        if (calculateSignalLevel > 10) {
            calculateSignalLevel = 10;
        }
        if (calculateSignalLevel < 0) {
            calculateSignalLevel = 0;
        }
        return (long) (calculateSignalLevel * 10);
    }

    private static void calSignalStrength(SignalStrength signalStrength) {
        int gsmSignalStrength;
        long j;
        if (signalStrength.isGsm()) {
            gsmSignalStrength = signalStrength.getGsmSignalStrength();
        } else {
            gsmSignalStrength = (signalStrength.getCdmaDbm() + MMGIFException.D_GIF_ERR_EOF_TOO_SOON) / 2;
        }
        if (signalStrength.isGsm() && gsmSignalStrength == 99) {
            j = 0;
        } else {
            j = (long) (((float) gsmSignalStrength) * 3.2258065f);
            strength = j;
            j = j > 100 ? 100 : strength;
            strength = j;
            j = j < 0 ? 0 : strength;
        }
        strength = j;
    }
}
