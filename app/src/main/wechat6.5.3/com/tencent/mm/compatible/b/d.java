package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mm.compatible.d.k;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.d.z;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashSet;
import java.util.Set;

public final class d {
    private static boolean cbc = false;
    public static boolean cbd = false;
    private static boolean cbe = false;
    private static boolean cbf = false;
    private static Boolean cbk;
    public final AudioManager cba;
    private int cbb = -1;
    private int cbg = 0;
    private final Set<a> cbh = new HashSet();
    private final int cbi = 1000;
    private ac cbj = new ac(this) {
        final /* synthetic */ d cbl;

        {
            this.cbl = r1;
        }

        public final void handleMessage(Message message) {
            v.d("MicroMsg.MMAudioManager", "dkbt post delay BLUETOOTH_DEVICE_CONNECTED ");
            this.cbl.dM(3);
        }
    };

    public interface a {
        void cK(int i);
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.cbh.add(aVar);
        }
    }

    public final void b(a aVar) {
        if (aVar != null) {
            this.cbh.remove(aVar);
        }
    }

    public final void dM(int i) {
        v.d("MicroMsg.MMAudioManager", "notify, new status: %d, current status: %d", Integer.valueOf(i), Integer.valueOf(this.cbb));
        for (a cK : this.cbh) {
            cK.cK(i);
        }
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public d(Context context) {
        this.cba = (AudioManager) context.getSystemService("audio");
        v.d("MicroMsg.MMAudioManager", "init dkbt %s", qY());
        context.registerReceiver(new BroadcastReceiver(this) {
            final /* synthetic */ d cbl;

            {
                this.cbl = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    String action = intent.getAction();
                    d.cbe = intent.getBooleanExtra("existing", false);
                    v.d("MicroMsg.MMAudioManager", "dkbt onReceive action[" + action + "] existing:" + d.cbe);
                }
            }
        }, new IntentFilter("com.htc.accessory.action.CONNECTION_EXISTING"));
        context.registerReceiver(new BroadcastReceiver(this) {
            final /* synthetic */ d cbl;

            {
                this.cbl = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                v.d("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_CONNECTED ] ");
                if (f.dX(11)) {
                    d.cbc = true;
                    this.cbl.cbj.sendEmptyMessageDelayed(0, 1000);
                }
            }
        }, new IntentFilter("android.bluetooth.device.action.ACL_CONNECTED"));
        context.registerReceiver(new BroadcastReceiver(this) {
            final /* synthetic */ d cbl;

            {
                this.cbl = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                v.d("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_DISCONNECTED ] ");
                d.cbc = false;
                if (p.ceJ.cdn == 1) {
                    com.tencent.mm.compatible.c.a.a(this.cbl.cba);
                }
                this.cbl.dM(4);
            }
        }, new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECTED"));
        if (f.dW(11)) {
            context.registerReceiver(new BroadcastReceiver(this) {
                final /* synthetic */ d cbl;

                {
                    this.cbl = r1;
                }

                public final void onReceive(Context context, Intent intent) {
                    if (intent != null) {
                        String action = intent.getAction();
                        int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                        v.d("MicroMsg.MMAudioManager", "dkbt onReceive action[" + action + "] state:" + intExtra);
                        if (intExtra == 2) {
                            d.cbc = true;
                            this.cbl.cbj.sendEmptyMessageDelayed(0, 1000);
                        } else if (intExtra == 0) {
                            d.cbc = false;
                            if (p.ceJ.cdn == 1) {
                                com.tencent.mm.compatible.c.a.a(this.cbl.cba);
                            }
                            this.cbl.dM(4);
                        }
                    }
                }
            }, new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"));
        }
    }

    public final void qR() {
        v.d("MicroMsg.MMAudioManager", "dkbt bluetoothStopped %s", qY());
        cbd = false;
        dM(2);
    }

    public final int qS() {
        this.cbb = -1;
        if (!qX()) {
            return -1;
        }
        boolean z;
        v.h("MicroMsg.MMAudioManager", "dkbt begin tryStartBluetooth %s", qY());
        AudioManager audioManager = this.cba;
        if (!audioManager.isBluetoothScoAvailableOffCall()) {
            z = false;
        } else if (an.brE) {
            z = false;
        } else {
            v.d("MicroMsg.BluetoothUtil", "DeviceInfo mCommonInfo getStartBluetoothSco:%s ", Integer.valueOf(p.ceJ.cdp));
            if (p.ceJ.cdp == 1 || p.ceJ.cdp == -1) {
                v.d("MicroMsg.BluetoothUtil", "BluetoothUtil startBluetoothSco");
                audioManager.startBluetoothSco();
            }
            v.d("MicroMsg.BluetoothUtil", "DeviceInfo mCommonInfo getBluetoothScoOn:%s ", Integer.valueOf(p.ceJ.cdq));
            if (p.ceJ.cdq == 1 || p.ceJ.cdp == -1) {
                v.d("MicroMsg.BluetoothUtil", "BluetoothUtil setBluetoothScoOn");
                audioManager.setBluetoothScoOn(true);
            }
            z = true;
        }
        v.d("MicroMsg.MMAudioManager", "dkbt end tryStartBluetooth %s ret:%s", qY(), Boolean.valueOf(z));
        v.d("MicroMsg.MMAudioManager", "dkbt  tryStartBluetooth " + qY() + " ret:" + z);
        if (qU()) {
            return 1;
        }
        return 0;
    }

    public final void qT() {
        cbd = false;
        v.h("MicroMsg.MMAudioManager", "dkbt begin stopBluetooth %s", qY());
        com.tencent.mm.compatible.c.a.a(this.cba);
        this.cbj.removeCallbacksAndMessages(Integer.valueOf(1));
        v.d("MicroMsg.MMAudioManager", "dkbt end stopBluetooth %s", qY());
    }

    public final boolean qU() {
        return this.cba.isBluetoothScoOn() || this.cba.isBluetoothA2dpOn() || cbd;
    }

    @TargetApi(14)
    private static boolean qV() {
        try {
            if (VERSION.SDK_INT >= 14) {
                v.d("MicroMsg.MMAudioManager", "isConnectHeadset getProfileConnectionState: %s", Integer.valueOf(BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1)));
                if (BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1) == 2) {
                    return true;
                }
                return false;
            } else if (cbc) {
                return true;
            } else {
                if (p.ceJ.cdy == 1) {
                    return BluetoothAdapter.getDefaultAdapter().isEnabled();
                }
                return false;
            }
        } catch (Exception e) {
            v.e("MicroMsg.MMAudioManager", "dkbt exception in isConnectDevice()");
        }
    }

    public final int at(boolean z) {
        int i;
        if (z) {
            i = 3;
        } else {
            i = 0;
        }
        return qU() ? 0 : i;
    }

    public static int qW() {
        ((AudioManager) aa.getContext().getSystemService("audio")).isBluetoothScoOn();
        return 0;
    }

    public static boolean qX() {
        v.d("MicroMsg.MMAudioManager", "dkbt isBluetoothCanUse existing:" + cbe + " , isUseHTCAccessory = " + cbf);
        if (cbe && !cbf) {
            return false;
        }
        v.d("MicroMsg.MMAudioManager", "dkbt isACLConnected:" + cbc);
        if (qV()) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                v.d("MicroMsg.MMAudioManager", "dkbt BluetoothAdapter.getDefaultAdapter() == null");
                return false;
            } else if (defaultAdapter.isEnabled()) {
                Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
                if (bondedDevices == null || bondedDevices.size() == 0) {
                    v.d("MicroMsg.MMAudioManager", "dkbt setDev == null || setDev.size() == 0");
                    return false;
                }
                Object obj;
                for (BluetoothDevice bondState : bondedDevices) {
                    if (bondState.getBondState() == 12) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    return true;
                }
                v.d("MicroMsg.MMAudioManager", "dkbt hasBond == false");
                return false;
            } else {
                v.d("MicroMsg.MMAudioManager", "dkbt !adp.isEnabled()");
                return false;
            }
        }
        v.d("MicroMsg.MMAudioManager", "dkbt isACLConnected =  " + cbc + " , isConnectHeadset() = " + qV());
        return false;
    }

    public final String qY() {
        return "mode:" + this.cba.getMode() + " isSpeakerphoneOn:" + this.cba.isSpeakerphoneOn() + " isBluetoothOn:" + qU() + " btStatus:" + this.cbb;
    }

    public final boolean qZ() {
        return this.cba.getMode() == 0;
    }

    @TargetApi(11)
    public final boolean d(boolean z, boolean z2) {
        boolean z3 = true;
        int i = 0;
        int mode = this.cba.getMode();
        v.d("MicroMsg.MMAudioManager", "dkbt shiftSpeaker:%b -> %b  %s", Boolean.valueOf(qZ()), Boolean.valueOf(z), qY());
        if (an.brE) {
            v.v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling Mode:%d blue:%d", Integer.valueOf(mode), Integer.valueOf(this.cbb));
            return false;
        } else if (qU() || cbd) {
            this.cba.setMode(0);
            return false;
        } else {
            rd();
            if (z2) {
                if (p.ceB.cbr) {
                    if (p.ceB.rj()) {
                        if (p.ceB.cbt >= 0) {
                            setMode(p.ceB.cbt);
                        } else if (p.ceB.cbu >= 0) {
                            if (z) {
                                setMode(0);
                            } else {
                                setMode(2);
                            }
                        }
                        if (p.ceB.cbv <= 0) {
                            return z;
                        }
                        setSpeakerphoneOn(z);
                        return z;
                    } else if (p.ceB.rk()) {
                        if (z) {
                            if (p.ceB.rn()) {
                                setSpeakerphoneOn(true);
                            }
                            if (p.ceB.rm() < 0) {
                                return z;
                            }
                            setMode(p.ceB.rm());
                            return z;
                        }
                        if (p.ceB.rp()) {
                            setSpeakerphoneOn(false);
                        }
                        if (p.ceB.ro() < 0) {
                            return z;
                        }
                        setMode(p.ceB.ro());
                        return z;
                    }
                }
            } else if (p.ceB.cbr && p.ceB.rl()) {
                com.tencent.mm.compatible.d.a aVar;
                if (z) {
                    boolean z4;
                    aVar = p.ceB;
                    if (aVar.rl()) {
                        mode = aVar.cbx & 16;
                        v.d("VoipAudioInfo", "enableSpeaker " + (mode > 0));
                        if (mode > 0) {
                            z4 = true;
                        }
                    }
                    if (z4) {
                        setSpeakerphoneOn(true);
                    }
                    if (p.ceB.rq() < 0) {
                        return z;
                    }
                    setMode(p.ceB.rq());
                    return z;
                }
                aVar = p.ceB;
                if (aVar.rl()) {
                    mode = aVar.cbx & 1;
                    v.d("VoipAudioInfo", "disableSpeaker " + (mode > 0));
                    if (mode <= 0) {
                        z3 = false;
                    }
                } else {
                    z3 = false;
                }
                if (z3) {
                    setSpeakerphoneOn(false);
                }
                if (p.ceB.rr() < 0) {
                    return z;
                }
                setMode(p.ceB.rr());
                return z;
            }
            if (!z2) {
                setSpeakerphoneOn(z);
                if (qZ() == z) {
                    return z;
                }
                if (z) {
                    setMode(0);
                    return z;
                } else if (VERSION.SDK_INT >= 11 && l.qA() && 2 != p.ceJ.cdz) {
                    setMode(3);
                    return z;
                } else if (VERSION.SDK_INT >= 11) {
                    setMode(3);
                    return z;
                } else {
                    setMode(2);
                    return z;
                }
            } else if (z) {
                if (VERSION.SDK_INT >= 11) {
                    i = 3;
                }
                if (p.ceB.cbQ >= 0) {
                    i = p.ceB.cbQ;
                }
                v.d("MicroMsg.MMAudioManager", "voip doShiftSpeaker useSpeakerMode:" + i);
                if (i != this.cba.getMode()) {
                    setMode(i);
                }
                if (i != this.cba.getMode()) {
                    if (this.cbg == 0) {
                        this.cbg = 1;
                    } else if (this.cbg == 2) {
                        this.cbg = 3;
                    }
                }
                if (this.cba.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(true);
                return z;
            } else {
                if (VERSION.SDK_INT >= 11) {
                    mode = 3;
                } else if (p.ceJ.cdy == 1) {
                    v.d("MicroMsg.MMAudioManager", new StringBuilder("doShiftSpeaker htc usePhoneMode : 0").toString());
                    mode = 0;
                } else {
                    mode = 2;
                }
                if (VERSION.SDK_INT >= 11 && l.qA() && 2 == p.ceJ.cdz) {
                    mode = 2;
                }
                if (p.ceB.cbR >= 0) {
                    mode = p.ceB.cbR;
                }
                v.d("MicroMsg.MMAudioManager", "voip doShiftSpeaker usePhoneMode:" + mode);
                if (mode != this.cba.getMode()) {
                    setMode(mode);
                }
                if (mode != this.cba.getMode()) {
                    if (this.cbg == 0) {
                        this.cbg = 2;
                    } else if (this.cbg == 1) {
                        this.cbg = 3;
                    }
                }
                if (!this.cba.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(false);
                return z;
            }
        }
    }

    @TargetApi(11)
    public final boolean au(boolean z) {
        int i = 3;
        int i2 = 0;
        v.d("MicroMsg.MMAudioManager", "IPCall dkbt shiftSpeaker:%b -> %b  %s", Boolean.valueOf(qZ()), Boolean.valueOf(z), qY());
        if (an.brE) {
            v.v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling blue:%d", Integer.valueOf(this.cbb));
            return false;
        } else if (cbd) {
            this.cba.setMode(0);
            return false;
        } else {
            rd();
            if (!p.ceB.ccp) {
                if (p.ceB.cbr) {
                    if (p.ceB.rj()) {
                        if (p.ceB.cbt >= 0) {
                            setMode(p.ceB.cbt);
                        } else if (p.ceB.cbu >= 0) {
                            if (z) {
                                setMode(0);
                            } else {
                                setMode(2);
                            }
                        }
                        if (p.ceB.cbv <= 0) {
                            return z;
                        }
                        setSpeakerphoneOn(z);
                        return z;
                    } else if (p.ceB.rk()) {
                        if (z) {
                            if (p.ceB.rn()) {
                                setSpeakerphoneOn(true);
                            }
                            if (p.ceB.rm() < 0) {
                                return z;
                            }
                            setMode(p.ceB.rm());
                            return z;
                        }
                        if (p.ceB.rp()) {
                            setSpeakerphoneOn(false);
                        }
                        if (p.ceB.ro() < 0) {
                            return z;
                        }
                        setMode(p.ceB.ro());
                        return z;
                    }
                }
                if (z) {
                    if (VERSION.SDK_INT >= 11) {
                        i2 = 3;
                    }
                    if (p.ceB.cbQ >= 0) {
                        i2 = p.ceB.cbQ;
                    }
                    v.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:" + i2);
                    if (i2 != this.cba.getMode()) {
                        setMode(i2);
                    }
                    if (this.cba.isSpeakerphoneOn()) {
                        return z;
                    }
                    setSpeakerphoneOn(true);
                    return z;
                }
                if (VERSION.SDK_INT < 11) {
                    if (p.ceJ.cdy == 1) {
                        v.d("MicroMsg.MMAudioManager", new StringBuilder("doShiftSpeaker htc usePhoneMode : 0").toString());
                        i = 0;
                    } else {
                        i = 2;
                    }
                }
                if (VERSION.SDK_INT >= 11 && l.qA() && 2 == p.ceJ.cdz) {
                    i = 2;
                }
                if (p.ceB.cbR >= 0) {
                    i = p.ceB.cbR;
                }
                v.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:" + i);
                if (i != this.cba.getMode()) {
                    setMode(i);
                }
                if (!this.cba.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(false);
                return z;
            } else if (z) {
                if (VERSION.SDK_INT >= 11) {
                    i2 = 3;
                }
                if (p.ceB.ccq >= 0) {
                    i2 = p.ceB.ccq;
                }
                v.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:" + i2);
                if (i2 != this.cba.getMode()) {
                    setMode(i2);
                }
                if (this.cba.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(true);
                return z;
            } else {
                if (VERSION.SDK_INT < 11) {
                    if (p.ceJ.cdy == 1) {
                        v.d("MicroMsg.MMAudioManager", new StringBuilder("doShiftSpeaker htc usePhoneMode : 0").toString());
                        i = 0;
                    } else {
                        i = 2;
                    }
                }
                if (p.ceB.ccr >= 0) {
                    i = p.ceB.ccr;
                }
                v.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:" + i);
                if (i != this.cba.getMode()) {
                    setMode(i);
                }
                if (!this.cba.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(false);
                return z;
            }
        }
    }

    public final boolean a(boolean z, int i) {
        int streamMaxVolume = this.cba.getStreamMaxVolume(i);
        v.d("MicroMsg.MMAudioManager", "maxVolumn:" + streamMaxVolume);
        streamMaxVolume /= 3;
        int streamVolume = this.cba.getStreamVolume(i);
        if (streamVolume < streamMaxVolume) {
            this.cba.setStreamVolume(i, streamMaxVolume, 0);
        }
        v.d("MicroMsg.MMAudioManager", "StreamType:" + i + "  current:" + streamVolume);
        return d(z, true);
    }

    public final boolean ra() {
        if (this.cba != null) {
            return this.cba.isWiredHeadsetOn();
        }
        return false;
    }

    public final void dN(int i) {
        if (this.cba != null) {
            this.cba.adjustStreamVolume(i, 1, 5);
        }
    }

    public final void dO(int i) {
        if (this.cba != null) {
            this.cba.adjustStreamVolume(i, -1, 5);
        }
    }

    public final void rb() {
        if (this.cba != null) {
            this.cba.setStreamMute(3, true);
        }
    }

    public final void rc() {
        if (this.cba != null) {
            this.cba.setStreamMute(3, false);
        }
    }

    private void rd() {
        if (this.cba != null) {
            int mode = this.cba.getMode();
            boolean isSpeakerphoneOn = this.cba.isSpeakerphoneOn();
            Object dQ = k.rv().dQ(98305);
            Object dQ2 = k.rv().dQ(94209);
            if (dQ == null) {
                k.rv().set(98305, Boolean.valueOf(isSpeakerphoneOn));
                v.d("MicroMsg.MMAudioManager", "storeAudioConfig spearkeron " + isSpeakerphoneOn);
            }
            if (dQ2 == null) {
                k.rv().set(94209, Integer.valueOf(mode));
                v.d("MicroMsg.MMAudioManager", "storeAudioConfig inmode " + mode);
            }
        }
    }

    @Deprecated
    public final void re() {
        if (this.cba != null) {
            Object dQ = k.rv().dQ(98305);
            Object dQ2 = k.rv().dQ(94209);
            if (dQ != null) {
                v.d("MicroMsg.MMAudioManager", "resumeAudioConfig spearkeron: " + dQ);
                setSpeakerphoneOn(((Boolean) dQ).booleanValue());
                k.rv().set(98305, null);
            }
            if (dQ2 != null) {
                int i;
                try {
                    v.i("MicroMsg.MMAudioManager", "resumeAudioConfig oinmode: " + dQ2 + ",inmode:0");
                    i = be.getInt(String.valueOf(dQ2), 0);
                } catch (Exception e) {
                    i = 0;
                }
                if (i < -1 || i >= 4) {
                    setMode(0);
                } else {
                    setMode(i);
                }
                k.rv().set(94209, null);
            }
        }
    }

    public final void setMode(int i) {
        if (this.cba != null) {
            v.i("MicroMsg.MMAudioManager", "set mode from %d to %d", Integer.valueOf(this.cba.getMode()), Integer.valueOf(i));
            this.cba.setMode(i);
        }
    }

    public final void setSpeakerphoneOn(boolean z) {
        v.h("MicroMsg.MMAudioManager", "setSpeakerphoneOn, on: " + z, new Object[0]);
        if (this.cba != null) {
            v.i("MicroMsg.MMAudioManager", "setSpeakerphoneOn on: " + z);
            this.cba.setSpeakerphoneOn(z);
        }
    }

    public final int rf() {
        int i = this.cbg;
        this.cbg = 0;
        return i;
    }

    public final int getStreamMaxVolume(int i) {
        if (this.cba != null) {
            return this.cba.getStreamMaxVolume(i);
        }
        return 5;
    }

    public final int getStreamVolume(int i) {
        if (this.cba != null) {
            return this.cba.getStreamVolume(i);
        }
        return -1;
    }

    public static boolean rg() {
        if (cbk == null) {
            boolean z;
            String str = z.get("av.offload.enable");
            if (str == null || str.length() <= 0) {
                z = false;
            } else {
                z = ("1".equalsIgnoreCase(str) | "true".equalsIgnoreCase(str)) | 0;
            }
            String str2 = z.get("av.streaming.offload.enable");
            if (str2 != null && str2.length() > 0) {
                z |= "1".equalsIgnoreCase(str2) | "true".equalsIgnoreCase(str2);
            }
            str2 = z.get("audio.offload.video");
            if (str2 != null && str2.length() > 0) {
                z |= "1".equalsIgnoreCase(str2) | "true".equalsIgnoreCase(str2);
            }
            v.i("MicroMsg.MMAudioManager", "Audio isEnable offload %b", Boolean.valueOf(z));
            cbk = new Boolean(z);
        }
        return cbk.booleanValue();
    }

    public static int rh() {
        if (!rg()) {
            v.i("MicroMsg.MMAudioManager", "it disable offload, return STREAM_MUSIC");
            return 3;
        } else if (com.tencent.mm.compatible.util.d.dW(21)) {
            v.w("MicroMsg.MMAudioManager", "it enable offload and api level not below 5.0, return STREAM_DEFAULT");
            return -1;
        } else {
            v.e("MicroMsg.MMAudioManager", "it enable offload but api level below 5.0, return STREAM_SYSTEM ");
            return 1;
        }
    }
}
