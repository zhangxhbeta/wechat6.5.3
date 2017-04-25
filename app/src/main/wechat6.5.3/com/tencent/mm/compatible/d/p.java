package com.tencent.mm.compatible.d;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public final class p {
    public static b ceA = new b();
    public static a ceB = new a();
    public static v ceC = new v();
    public static aa ceD = new aa();
    public static s ceE = new s();
    public static u ceF = new u();
    public static y ceG = new y();
    public static t ceH = new t();
    private static int ceI = -1;
    public static j ceJ = new j();
    public static o ceK = new o();
    public static x ceL = new x();
    private static String ceM = null;
    public static n cez = new n();

    class a implements FileFilter {
        a() {
        }

        public final boolean accept(File file) {
            if (Pattern.matches("cpu[0-9]+", file.getName())) {
                return true;
            }
            return false;
        }
    }

    public static String rJ() {
        String str = (String) k.rv().get(258);
        if (str == null) {
            str = getDeviceID(aa.getContext());
            if (str == null) {
                str = "1234567890ABCDEF";
            }
            k.rv().set(258, str);
        }
        return str;
    }

    public static String getDeviceID(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            String deviceId = telephonyManager.getDeviceId();
            return deviceId == null ? null : deviceId.trim();
        } catch (SecurityException e) {
            v.e("MicroMsg.DeviceInfo", "getDeviceId failed, security exception");
            return null;
        } catch (Throwable e2) {
            v.a("MicroMsg.DeviceInfo", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }

    public static String rK() {
        if (ceM == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Secure.getString(aa.getContext().getContentResolver(), "android_id"));
            String str = (String) k.rv().get(FileUtils.S_IRUSR);
            if (str == null) {
                str = rN();
                k.rv().set(FileUtils.S_IRUSR, str);
            }
            stringBuilder.append(str);
            str = (String) k.rv().get(259);
            if (str != null) {
                v.d("MicroMsg.DeviceInfo", "getHardWareId from file " + str);
            } else {
                str = Build.MANUFACTURER + Build.MODEL + m.rC();
                k.rv().set(259, str);
                v.d("MicroMsg.DeviceInfo", "getHardWareId " + str);
            }
            stringBuilder.append(str);
            ceM = "A" + g.m(stringBuilder.toString().getBytes()).substring(0, 15);
            v.w("MicroMsg.DeviceInfo", "guid:%s, dev=%s", ceM, str);
        }
        return ceM;
    }

    public static String rL() {
        WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getMacAddress() : null;
    }

    public static String rM() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            return defaultAdapter.getAddress();
        }
        return null;
    }

    private static String rN() {
        String str;
        String dW = be.dW(aa.getContext());
        if (dW == null || dW.length() <= 0) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            str = "A";
            int i = 0;
            while (i < 15) {
                i++;
                str = str + ((char) (random.nextInt(25) + 65));
            }
        } else {
            str = ("A" + dW + "123456789ABCDEF").substring(0, 15);
        }
        v.w("MicroMsg.DeviceInfo", "generated deviceId=" + str);
        return str;
    }

    public static void dr(String str) {
        v.i("MicroMsg.DeviceInfo", "update deviceInfo %s", str);
        if (str != null && str.length() > 0 && str.hashCode() != ceI) {
            ceI = str.hashCode();
            cez.reset();
            ceA.reset();
            ceB.reset();
            ceJ.reset();
            ceC.reset();
            ceD.reset();
            ceL.reset();
            s sVar = ceE;
            sVar.ceP = 0;
            sVar.ceQ = 0;
            u uVar = ceF;
            uVar.ceZ = SQLiteDatabase.KeyEmpty;
            uVar.cfa = null;
            ceG.bqg = false;
            ceH.reset();
            q qVar = new q();
            if (q.a(str, cez, ceA, ceB, ceJ, ceC, ceD, ceL, ceE, ceF, ceG, ceH)) {
                v.d("MicroMsg.DeviceInfo", "steve: mCameraInfo.mNeedEnhance = " + ceA.cdc);
            }
        }
    }

    public static String rO() {
        return Build.MODEL;
    }

    public static String aw(Context context) {
        try {
            v.i("MicroMsg.DeviceInfo", "lm: getManufacturer CurrentLanguage is %s", u.dJ(context));
            if (ceF == null || ceF.cfa == null || ceF.cfa.size() == 0) {
                v.i("MicroMsg.DeviceInfo", "lm: getManufacturer return is %s", Build.MANUFACTURER);
                return Build.MANUFACTURER;
            }
            String str = (String) ceF.cfa.get(".manufacturerName." + u.dJ(context));
            v.i("MicroMsg.DeviceInfo", "lm: getManufacturer is %s", str);
            if (!be.kS(str)) {
                return str;
            }
            str = (String) ceF.cfa.get(".manufacturerName.en");
            v.i("MicroMsg.DeviceInfo", "lm: getManufacturer is %s", str);
            if (be.kS(str)) {
                return Build.MANUFACTURER;
            }
            return str;
        } catch (Exception e) {
            return Build.MANUFACTURER;
        }
    }

    public static String ax(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
        } catch (Throwable e) {
            v.a("MicroMsg.DeviceInfo", e, "getMobileSPType", new Object[0]);
            return SQLiteDatabase.KeyEmpty;
        }
    }

    public static String getSimCountryIso() {
        TelephonyManager telephonyManager = (TelephonyManager) aa.getContext().getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        v.i("MicroMsg.DeviceInfo", "get isoCode:[%s]", telephonyManager.getSimCountryIso());
        return telephonyManager.getSimCountryIso();
    }

    public static String[] rP() {
        Throwable th;
        String[] strArr = new String[]{SQLiteDatabase.KeyEmpty, "0"};
        BufferedReader bufferedReader = null;
        BufferedReader bufferedReader2;
        try {
            bufferedReader2 = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
            try {
                String[] split = be.ma(bufferedReader2.readLine()).split("\\s+");
                for (int i = 2; i < split.length; i++) {
                    strArr[0] = strArr[0] + split[i] + " ";
                }
                strArr[1] = be.ma(bufferedReader2.readLine()).split("\\s+")[2];
                try {
                    bufferedReader2.close();
                } catch (Exception e) {
                }
            } catch (IOException e2) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception e3) {
                    }
                }
                return strArr;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                bufferedReader = bufferedReader2;
                th = th3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            bufferedReader2 = null;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            return strArr;
        } catch (Throwable th4) {
            th = th4;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
        return strArr;
    }

    public static String getAndroidId() {
        v.i("MicroMsg.DeviceInfo", "androidid:[%s]", Secure.getString(aa.getContext().getContentResolver(), "android_id"));
        return Secure.getString(aa.getContext().getContentResolver(), "android_id");
    }

    public static String rQ() {
        String str = null;
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && defaultAdapter.isEnabled()) {
                str = defaultAdapter.getAddress();
            }
            return be.ma(str);
        } catch (Throwable e) {
            v.e("MicroMsg.DeviceInfo", "getBlueToothAddress failed: %s", be.e(e));
            return SQLiteDatabase.KeyEmpty;
        }
    }

    @SuppressLint({"NewApi"})
    public static String rR() {
        String str = null;
        try {
            if (VERSION.SDK_INT >= 14) {
                str = Build.getRadioVersion();
            } else {
                str = Build.RADIO;
            }
        } catch (Throwable e) {
            v.a("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
            throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
        } catch (Throwable th) {
        }
        return be.ma(str);
    }

    public static String rS() {
        return VERSION.RELEASE;
    }

    public static String rT() {
        try {
            return be.ma(((TelephonyManager) aa.getContext().getSystemService("phone")).getSubscriberId());
        } catch (Throwable e) {
            v.a("MicroMsg.DeviceInfo", e, "getPhoneIMSI", new Object[0]);
            return SQLiteDatabase.KeyEmpty;
        }
    }

    public static String rU() {
        try {
            return be.ma(((TelephonyManager) aa.getContext().getSystemService("phone")).getSimSerialNumber());
        } catch (Throwable e) {
            v.a("MicroMsg.DeviceInfo", e, "getPhoneICCID", new Object[0]);
            return SQLiteDatabase.KeyEmpty;
        }
    }

    @SuppressLint({"NewApi"})
    public static String rV() {
        String str = null;
        if (VERSION.SDK_INT >= 9) {
            str = Build.SERIAL;
        }
        return be.ma(str);
    }

    public static Map<String, String> rW() {
        Map<String, String> hashMap = new HashMap();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ProcessBuilder(new String[]{"/system/bin/cat", "/proc/cpuinfo"}).start().getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (!readLine.trim().equals(SQLiteDatabase.KeyEmpty)) {
                    String[] split = readLine.split(":");
                    if (split.length > 1) {
                        hashMap.put(split[0].trim().toLowerCase(), split[1].trim());
                    }
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
        }
        return hashMap;
    }

    public static int rX() {
        try {
            return new File("/sys/devices/system/cpu").listFiles(new a()).length;
        } catch (Exception e) {
            return 1;
        }
    }

    public static String rY() {
        return "android-" + Build.MODEL + "-" + VERSION.SDK_INT;
    }
}
