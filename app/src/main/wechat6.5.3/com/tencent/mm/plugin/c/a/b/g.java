package com.tencent.mm.plugin.c.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

@TargetApi(21)
public final class g extends ScanCallback {
    private static g eqm;
    private BluetoothAdapter eoz;
    private ArrayList<a> epu;
    private boolean epv;
    private BluetoothManager eqn;
    private BluetoothLeScanner eqo;
    private Context mContext;
    ac mHandler;

    class AnonymousClass1 extends az<Boolean> {
        final /* synthetic */ boolean dOn;
        final /* synthetic */ a eqp;
        final /* synthetic */ g eqq;

        AnonymousClass1(g gVar, boolean z, a aVar) {
            this.eqq = gVar;
            this.dOn = z;
            this.eqp = aVar;
        }

        protected final /* synthetic */ Object run() {
            return Boolean.valueOf(g.a(this.eqq, this.dOn, this.eqp));
        }
    }

    public interface a {
        void a(BluetoothDevice bluetoothDevice, int i, byte[] bArr);

        void is(int i);
    }

    static /* synthetic */ boolean a(g gVar, boolean z, a aVar) {
        boolean z2;
        if (gVar.mContext == null) {
            v.e("MicroMsg.exdevice.NewBluetoothLEScanner", "not found context");
            z2 = false;
        } else {
            z2 = gVar.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        }
        if (z2) {
            if (gVar.eqo == null) {
                gVar.eoz = gVar.eqn.getAdapter();
                if (gVar.eoz != null) {
                    v.d("MicroMsg.exdevice.NewBluetoothLEScanner", "Get bluetoothLeScanner");
                    gVar.eqo = gVar.eoz.getBluetoothLeScanner();
                    if (gVar.eqo == null) {
                        return false;
                    }
                }
                v.e("MicroMsg.exdevice.NewBluetoothLEScanner", "not found BluetoothScannner");
                return false;
            }
            if (!com.tencent.mm.plugin.c.a.e.a.Xw()) {
                v.i("MicroMsg.exdevice.NewBluetoothLEScanner", "Bluetooth state off");
            } else if (z) {
                v.d("MicroMsg.exdevice.NewBluetoothLEScanner", "start scan");
                if (gVar.epv) {
                    v.w("MicroMsg.exdevice.NewBluetoothLEScanner", "ble has scan. just add callback and return");
                    gVar.a(aVar);
                } else {
                    gVar.eqo.startScan(gVar);
                    gVar.a(aVar);
                    gVar.epv = true;
                }
            } else if (gVar.epv) {
                if (aVar == null) {
                    v.e("MicroMsg.exdevice.NewBluetoothLEScanner", "callback is null");
                } else {
                    v.d("MicroMsg.exdevice.NewBluetoothLEScanner", "remove callback " + gVar.epu.remove(aVar));
                }
                if (gVar.epu.size() <= 0) {
                    v.d("MicroMsg.exdevice.NewBluetoothLEScanner", "stop scan");
                    gVar.eqo.stopScan(gVar);
                    gVar.epv = false;
                }
            } else {
                v.w("MicroMsg.exdevice.NewBluetoothLEScanner", "scan haven't started. just return, callback size = %d", new Object[]{Integer.valueOf(gVar.epu.size())});
            }
            return true;
        }
        v.e("MicroMsg.exdevice.NewBluetoothLEScanner", "this phone is not support BLE");
        return false;
    }

    public static g Xs() {
        if (eqm != null) {
            return eqm;
        }
        g gVar = new g(aa.getContext());
        eqm = gVar;
        return gVar;
    }

    private g(Context context) {
        if (context == null) {
            v.e("MicroMsg.exdevice.NewBluetoothLEScanner", "No context for scanner");
            return;
        }
        this.mContext = context;
        this.epu = new ArrayList();
        this.epv = false;
        this.eoz = null;
        this.eqo = null;
        this.mHandler = null;
        this.eqn = (BluetoothManager) this.mContext.getSystemService("bluetooth");
        this.eoz = this.eqn.getAdapter();
        if (this.eoz != null) {
            v.d("MicroMsg.exdevice.NewBluetoothLEScanner", "Get bluetoothLeScanner");
            this.eqo = this.eoz.getBluetoothLeScanner();
        }
        this.mHandler = new ac(new ad("NewBluetoothLEScannerThread").htb.getLooper());
    }

    private boolean a(a aVar) {
        if (aVar == null) {
            v.e("MicroMsg.exdevice.NewBluetoothLEScanner", "callback is null");
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
            v.d("MicroMsg.exdevice.NewBluetoothLEScanner", "add callback " + add);
            return add;
        }
        v.w("MicroMsg.exdevice.NewBluetoothLEScanner", "callback has in queue. pass");
        return true;
    }

    public final void onScanFailed(final int i) {
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ g eqq;

            public final void run() {
                for (int i = 0; i < this.eqq.epu.size(); i++) {
                    ((a) this.eqq.epu.get(i)).is(i);
                }
            }
        });
    }

    public final void onScanResult(int i, ScanResult scanResult) {
        if (scanResult != null && scanResult.getScanRecord() != null) {
            v.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[]{scanResult.getDevice().getAddress(), scanResult.getDevice().getName(), b.ak(scanResult.getScanRecord().getBytes())});
            v.d("MicroMsg.exdevice.NewBluetoothLEScanner", "callback size = %d", new Object[]{Integer.valueOf(this.epu.size())});
            final BluetoothDevice device = scanResult.getDevice();
            final int rssi = scanResult.getRssi();
            final byte[] bytes = scanResult.getScanRecord().getBytes();
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ g eqq;

                public final void run() {
                    for (int i = 0; i < this.eqq.epu.size(); i++) {
                        ((a) this.eqq.epu.get(i)).a(device, rssi, bytes);
                    }
                }
            });
        }
    }

    public final void onBatchScanResults(List<ScanResult> list) {
        if (list != null) {
            for (ScanResult scanResult : list) {
                v.d("MicroMsg.exdevice.NewBluetoothLEScanner", "onLeScan. device addr = %s, name = %s, data = %s", new Object[]{scanResult.getDevice().getAddress(), scanResult.getDevice().getName(), b.ak(scanResult.getScanRecord().getBytes())});
            }
        }
    }
}
