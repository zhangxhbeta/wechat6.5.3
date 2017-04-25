package com.tencent.mm.plugin.c.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import junit.framework.Assert;

@TargetApi(18)
public final class c implements LeScanCallback {
    private static c ept;
    private BluetoothAdapter eoz;
    private ArrayList<a> epu;
    private boolean epv;
    private Context mContext;
    private ac mHandler;

    public interface a {
        void Xl();

        void a(BluetoothDevice bluetoothDevice, int i, byte[] bArr);
    }

    static /* synthetic */ boolean a(c cVar, boolean z, a aVar) {
        boolean z2;
        if (cVar.mContext == null) {
            v.e("MicroMsg.exdevice.BluetoothLEScaner", "not found context");
            z2 = false;
        } else {
            z2 = cVar.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        }
        if (!z2) {
            v.e("MicroMsg.exdevice.BluetoothLEScaner", "this phone is not support BLE");
            return false;
        } else if (cVar.eoz == null) {
            v.e("MicroMsg.exdevice.BluetoothLEScaner", "not found BluetoothAdapter");
            return false;
        } else {
            if (z) {
                if (cVar.epv) {
                    v.w("MicroMsg.exdevice.BluetoothLEScaner", "ble has scan. just add callback and return");
                    cVar.a(aVar);
                    return true;
                }
                v.d("MicroMsg.exdevice.BluetoothLEScaner", "start scan");
                z2 = cVar.eoz.startLeScan(cVar);
                if (z2) {
                    cVar.epv = true;
                    cVar.a(aVar);
                } else if (cVar.epu.size() <= 0) {
                    v.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed and callbacklist size is 0,start retry,and bluetooth state is(12 is on ,10 is off): " + cVar.eoz.getState());
                    int i = 0;
                    while (!z2 && i < 3) {
                        cVar.eoz.stopLeScan(cVar);
                        cVar.epv = false;
                        v.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed,retry no " + i + " time");
                        boolean startLeScan = cVar.eoz.startLeScan(cVar);
                        if (startLeScan) {
                            cVar.epv = true;
                            cVar.a(aVar);
                        }
                        i++;
                        z2 = startLeScan;
                    }
                    return z2;
                } else if (cVar.eoz.getState() == 12) {
                    v.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed when bluetooth state is on.");
                    cVar.epv = true;
                    cVar.a(aVar);
                    z2 = true;
                } else {
                    v.e("MicroMsg.exdevice.BluetoothLEScaner", "start BLE scan failed");
                }
            } else if (cVar.epv) {
                if (aVar == null) {
                    v.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
                } else {
                    v.d("MicroMsg.exdevice.BluetoothLEScaner", "remove callback " + cVar.epu.remove(aVar));
                }
                if (aVar != null) {
                    aVar.Xl();
                }
                v.d("MicroMsg.exdevice.BluetoothLEScaner", "stop deleteCallback");
                if (cVar.epu.size() <= 0) {
                    v.d("MicroMsg.exdevice.BluetoothLEScaner", "stop scan");
                    cVar.eoz.stopLeScan(cVar);
                    cVar.epv = false;
                }
                z2 = true;
            } else {
                v.w("MicroMsg.exdevice.BluetoothLEScaner", "scan haven't started. just return, callback size = %d", new Object[]{Integer.valueOf(cVar.epu.size())});
                return true;
            }
            return z2;
        }
    }

    public static c Xm() {
        if (ept != null) {
            return ept;
        }
        c cVar = new c(aa.getContext());
        ept = cVar;
        return cVar;
    }

    private c(Context context) {
        if (context == null) {
            v.e("MicroMsg.exdevice.BluetoothLEScaner", "no context for scaner");
            return;
        }
        this.mContext = context;
        this.epu = new ArrayList();
        this.epv = false;
        this.eoz = null;
        this.mHandler = null;
        this.eoz = ((BluetoothManager) this.mContext.getSystemService("bluetooth")).getAdapter();
        this.mHandler = new ac(new ad("BluetoothLEScanerThread").htb.getLooper());
    }

    public final boolean a(final boolean z, final a aVar) {
        Boolean bool = (Boolean) new az<Boolean>(this) {
            final /* synthetic */ c epx;

            protected final /* synthetic */ Object run() {
                return Boolean.valueOf(c.a(this.epx, z, aVar));
            }
        }.c(this.mHandler);
        Assert.assertTrue(bool != null);
        return bool.booleanValue();
    }

    private boolean a(a aVar) {
        if (aVar == null) {
            v.e("MicroMsg.exdevice.BluetoothLEScaner", "callback is null");
            return false;
        }
        int i = 0;
        while (i < this.epu.size()) {
            if (((a) this.epu.get(i)) == aVar) {
                break;
            }
            i++;
        }
        i = -1;
        if (i < 0) {
            boolean add = this.epu.add(aVar);
            v.d("MicroMsg.exdevice.BluetoothLEScaner", "add callback " + add);
            return add;
        }
        v.w("MicroMsg.exdevice.BluetoothLEScaner", "callback has in queue. pass");
        return true;
    }

    public final void onLeScan(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
        v.d("MicroMsg.exdevice.BluetoothLEScaner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[]{bluetoothDevice.getAddress(), bluetoothDevice.getName(), b.ak(bArr)});
        v.d("MicroMsg.exdevice.BluetoothLEScaner", "callback size = %d", new Object[]{Integer.valueOf(this.epu.size())});
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ c epx;

            public final void run() {
                for (int i = 0; i < this.epx.epu.size(); i++) {
                    ((a) this.epx.epu.get(i)).a(bluetoothDevice, i, bArr);
                }
            }
        });
    }
}
