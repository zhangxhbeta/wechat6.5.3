package com.tencent.mm.plugin.exdevice.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Parcelable;
import com.tencent.mm.e.a.ct;
import com.tencent.mm.e.a.cu;
import com.tencent.mm.e.a.cv;
import com.tencent.mm.e.a.cw;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import org.json.JSONObject;

public final class ExdeviceWCLanSDKUtil {
    BroadcastReceiver esp;
    HashMap<String, byte[]> ftG;
    HashMap<String, Boolean> ftI;
    a ftJ;
    a ftL;
    private int ftZ;
    private int fua;
    a fub;
    a fuc;
    HashMap<String, String> fud;
    boolean fue;
    boolean fuf;
    boolean fug;
    int fuh;
    Context mContext;

    public class LanStateChangeReceiver extends BroadcastReceiver {
        final /* synthetic */ ExdeviceWCLanSDKUtil fui;

        public LanStateChangeReceiver(ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil) {
            this.fui = exdeviceWCLanSDKUtil;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                if (parcelableExtra != null) {
                    boolean z = ((NetworkInfo) parcelableExtra).getState() == State.CONNECTED;
                    v.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "isConnected =" + z);
                    if (this.fui.fuf || this.fui.fue != z) {
                        cw cwVar = new cw();
                        cwVar.baT.baU = z;
                        com.tencent.mm.sdk.c.a.nhr.z(cwVar);
                        this.fui.fuf = false;
                        this.fui.fue = z;
                    }
                }
            }
        }
    }

    public ExdeviceWCLanSDKUtil() {
        this.ftZ = 0;
        this.fua = 0;
        this.ftG = new HashMap();
        this.ftI = new HashMap();
        this.fud = new HashMap();
        this.mContext = null;
        this.fue = false;
        this.fuf = false;
        this.fug = false;
        this.fue = true;
        this.fuf = true;
        this.ftG.clear();
        this.ftI.clear();
        this.fud.clear();
        this.mContext = aa.getContext();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        if (this.esp == null) {
            this.esp = new LanStateChangeReceiver(this);
        }
        this.mContext.registerReceiver(this.esp, intentFilter);
        this.fub = new a(this) {
            final /* synthetic */ ExdeviceWCLanSDKUtil fui;

            {
                this.fui = r1;
            }

            public final void e(int i, Object... objArr) {
                String string;
                Throwable e;
                String str = null;
                if (i == 10 && objArr != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(new String((byte[]) objArr[0]));
                        JSONObject jSONObject2 = jSONObject.getJSONObject("deviceInfo");
                        string = jSONObject2.getString("deviceType");
                        try {
                            str = jSONObject2.getString("deviceId");
                            if (!jSONObject.isNull("manufacturerData")) {
                                this.fui.fud.put(str, jSONObject.getString("manufacturerData"));
                            }
                        } catch (Exception e2) {
                            e = e2;
                            v.a("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                            v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "json decode failed in disc package callback!");
                            if (string != null) {
                            }
                            v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanDeviceDiscPackageCallbackReceiver! ");
                        }
                    } catch (Exception e3) {
                        e = e3;
                        string = null;
                        v.a("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                        v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "json decode failed in disc package callback!");
                        if (string != null) {
                        }
                        v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanDeviceDiscPackageCallbackReceiver! ");
                    }
                    if (string != null || r1 == null) {
                        v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanDeviceDiscPackageCallbackReceiver! ");
                    }
                }
            }
        };
        this.ftJ = new a(this) {
            final /* synthetic */ ExdeviceWCLanSDKUtil fui;

            {
                this.fui = r1;
            }

            public final void e(int i, Object... objArr) {
                Exception e;
                String str = null;
                if (i == 14 && objArr != null && objArr.length > 0 && (objArr[0] instanceof byte[])) {
                    JSONObject jSONObject;
                    String string;
                    try {
                        jSONObject = new JSONObject(new String((byte[]) objArr[0])).getJSONObject("deviceInfo");
                        try {
                            string = jSONObject.getString("deviceType");
                        } catch (Exception e2) {
                            e = e2;
                            string = str;
                            v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in get device profile callback %s", new Object[]{e});
                            if (string != null) {
                            }
                            v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
                            return;
                        }
                        try {
                            str = jSONObject.getString("deviceId");
                        } catch (Exception e3) {
                            e = e3;
                            v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in get device profile callback %s", new Object[]{e});
                            if (string != null) {
                            }
                            v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
                            return;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        jSONObject = str;
                        string = str;
                        v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in get device profile callback %s", new Object[]{e});
                        if (string != null) {
                        }
                        v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
                        return;
                    }
                    if (string != null || str == null) {
                        v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
                        return;
                    }
                    v.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get device deviceType =" + string + ",deviceId = " + str);
                    if (ac.ajq().sq(str) == null) {
                        v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "hdInfo null, %s", new Object[]{str});
                        return;
                    }
                    this.fui.ftG.put(str, jSONObject.toString().getBytes());
                    cv cvVar = new cv();
                    cvVar.baQ.aRh = str;
                    if (this.fui.fud.containsKey(str)) {
                        String str2 = (String) this.fui.fud.get(str);
                        if (!be.kS(str2)) {
                            cvVar.baQ.baR = str2.getBytes();
                        }
                        this.fui.fud.remove(str);
                    }
                    cvVar.baQ.baS = false;
                    com.tencent.mm.sdk.c.a.nhr.z(cvVar);
                }
            }
        };
        this.ftL = new a(this) {
            final /* synthetic */ ExdeviceWCLanSDKUtil fui;

            {
                this.fui = r1;
            }

            public final void e(int i, Object... objArr) {
                String string;
                Throwable e;
                ct ctVar;
                String str = null;
                if (i == 13 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof String) && (objArr[1] instanceof Integer)) {
                    String str2 = (String) objArr[0];
                    int intValue = ((Integer) objArr[1]).intValue();
                    try {
                        JSONObject jSONObject = new JSONObject(new String(str2));
                        string = jSONObject.getString("deviceId");
                        try {
                            str = jSONObject.getString("deviceType");
                        } catch (Exception e2) {
                            e = e2;
                            v.a("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                            v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in device ConnState notify callback");
                            switch (intValue) {
                                case 1:
                                    this.fui.fuh = 2;
                                    this.fui.ftI.put(string, Boolean.valueOf(true));
                                    v.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device connect!");
                                    break;
                                default:
                                    this.fui.fuh = 0;
                                    this.fui.ftI.put(string, Boolean.valueOf(false));
                                    v.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device disconnect!");
                                    break;
                            }
                            if (!this.fui.fug) {
                                if (this.fui.fuh == 2) {
                                    this.fui.e(true, string);
                                }
                                ctVar = new ct();
                                ctVar.baN.aRh = string;
                                ctVar.baN.baO = this.fui.fuh;
                                ctVar.baN.aZU = str;
                                com.tencent.mm.sdk.c.a.nhr.z(ctVar);
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        string = str;
                        v.a("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                        v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in device ConnState notify callback");
                        switch (intValue) {
                            case 1:
                                this.fui.fuh = 2;
                                this.fui.ftI.put(string, Boolean.valueOf(true));
                                v.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device connect!");
                                break;
                            default:
                                this.fui.fuh = 0;
                                this.fui.ftI.put(string, Boolean.valueOf(false));
                                v.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device disconnect!");
                                break;
                        }
                        if (!this.fui.fug) {
                            if (this.fui.fuh == 2) {
                                this.fui.e(true, string);
                            }
                            ctVar = new ct();
                            ctVar.baN.aRh = string;
                            ctVar.baN.baO = this.fui.fuh;
                            ctVar.baN.aZU = str;
                            com.tencent.mm.sdk.c.a.nhr.z(ctVar);
                        }
                    }
                    switch (intValue) {
                        case 1:
                            this.fui.fuh = 2;
                            this.fui.ftI.put(string, Boolean.valueOf(true));
                            v.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device connect!");
                            break;
                        default:
                            this.fui.fuh = 0;
                            this.fui.ftI.put(string, Boolean.valueOf(false));
                            v.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device disconnect!");
                            break;
                    }
                    if (!this.fui.fug) {
                        if (this.fui.fuh == 2) {
                            this.fui.e(true, string);
                        }
                        ctVar = new ct();
                        ctVar.baN.aRh = string;
                        ctVar.baN.baO = this.fui.fuh;
                        ctVar.baN.aZU = str;
                        com.tencent.mm.sdk.c.a.nhr.z(ctVar);
                    }
                }
            }
        };
        this.fuc = new a(this) {
            final /* synthetic */ ExdeviceWCLanSDKUtil fui;

            {
                this.fui = r1;
            }

            public final void e(int i, Object... objArr) {
                String string;
                String str;
                Throwable th;
                cu cuVar;
                if (i == 16 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof String) && (objArr[1] instanceof byte[])) {
                    byte[] bArr = (byte[]) objArr[1];
                    try {
                        JSONObject jSONObject = new JSONObject(new String((String) objArr[0]));
                        String string2 = jSONObject.getString("deviceType");
                        try {
                            string = jSONObject.getString("deviceId");
                            str = string2;
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            string = string2;
                            th = th2;
                            v.a("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", th, "", new Object[0]);
                            v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in receive notify callback");
                            str = string;
                            string = null;
                            v.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = " + new String(bArr));
                            cuVar = new cu();
                            cuVar.baP.aRh = string;
                            cuVar.baP.data = bArr;
                            cuVar.baP.aZU = str;
                            com.tencent.mm.sdk.c.a.nhr.z(cuVar);
                        }
                    } catch (Throwable e2) {
                        th = e2;
                        string = null;
                        v.a("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", th, "", new Object[0]);
                        v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in receive notify callback");
                        str = string;
                        string = null;
                        v.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = " + new String(bArr));
                        cuVar = new cu();
                        cuVar.baP.aRh = string;
                        cuVar.baP.data = bArr;
                        cuVar.baP.aZU = str;
                        com.tencent.mm.sdk.c.a.nhr.z(cuVar);
                    }
                    v.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = " + new String(bArr));
                    cuVar = new cu();
                    cuVar.baP.aRh = string;
                    cuVar.baP.data = bArr;
                    cuVar.baP.aZU = str;
                    com.tencent.mm.sdk.c.a.nhr.z(cuVar);
                }
            }
        };
    }

    public final boolean e(boolean z, String str) {
        if (str == null || !this.ftG.containsKey(str)) {
            v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in openOrCloseDevice");
            return false;
        }
        byte[] bArr = (byte[]) this.ftG.get(str);
        try {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                v.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "open device!");
                jSONObject.put("cmd", "open");
            } else {
                v.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "close device!");
                jSONObject.put("cmd", "close");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("wxmsg_jsapi", jSONObject);
            jSONObject = new JSONObject();
            jSONObject.put("services", jSONObject2);
            this.fua = Java2CExDevice.useWCLanDeviceService(bArr, jSONObject.toString().getBytes());
            if (this.fua != 0) {
                v.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get openOrCloseDevice mCallBackCmdId =" + this.fua);
            } else {
                v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "openOrCloseDevice error!");
            }
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
            v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in openOrCloseDevice");
            return false;
        }
    }

    public final boolean R(String str, boolean z) {
        if (str == null || !this.ftG.containsKey(str)) {
            v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in connectWCLanDevice");
            return false;
        }
        byte[] bArr = (byte[]) this.ftG.get(str);
        this.fug = true;
        if (z) {
            try {
                String string = new JSONObject(new String(bArr)).getString("deviceType");
                v.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice deviceId: " + str);
                if (Java2CExDevice.connectWCLanDevice(bArr, false) != 0) {
                    v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice error!");
                    return false;
                }
                ct ctVar = new ct();
                ctVar.baN.aRh = str;
                ctVar.baN.baO = 1;
                ctVar.baN.aZU = string;
                com.tencent.mm.sdk.c.a.nhr.z(ctVar);
            } catch (Throwable e) {
                v.a("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in connectWCLanDevice!");
                return false;
            }
        }
        e(false, str);
        v.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "disconnectWCLanDevice...");
        Java2CExDevice.disconnectWCLanDevice(bArr);
        return true;
    }

    public final boolean br(String str, String str2) {
        if (!se(str)) {
            v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceId " + str + " not connected!");
            return false;
        } else if (str == null || !this.ftG.containsKey(str)) {
            v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in useWCLanDeviceService");
            return false;
        } else {
            byte[] bArr = (byte[]) this.ftG.get(str);
            this.ftZ = 0;
            try {
                boolean z;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", str2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("wxmsg_jsapi", jSONObject);
                jSONObject = new JSONObject();
                jSONObject.put("services", jSONObject2);
                this.ftZ = Java2CExDevice.useWCLanDeviceService(bArr, jSONObject.toString().getBytes());
                if (this.ftZ != 0) {
                    z = true;
                    v.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get useWCLanDeviceService mCallBackCmdId =" + this.ftZ);
                } else {
                    v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "useWCLanDeviceService error!");
                    z = false;
                }
                return z;
            } catch (Throwable e) {
                v.a("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                v.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in useWCLanDeviceService");
                return false;
            }
        }
    }

    public final boolean se(String str) {
        if (str == null || !this.ftI.containsKey(str)) {
            return false;
        }
        return ((Boolean) this.ftI.get(str)).booleanValue();
    }
}
