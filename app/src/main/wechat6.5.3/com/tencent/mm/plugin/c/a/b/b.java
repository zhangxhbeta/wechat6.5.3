package com.tencent.mm.plugin.c.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.hardware.input.InputManager;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.view.InputDevice;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

@TargetApi(18)
public final class b {
    public Context aHq;
    public BluetoothAdapter eoz;
    public a epf;
    public final HashMap<String, d> epg;
    volatile boolean eph;
    public c epi;
    public g epj;
    final HashSet<Long> epk;
    private com.tencent.mm.plugin.c.a.b.c.a epl;
    private com.tencent.mm.plugin.c.a.b.g.a epm;
    private Runnable lv;
    public ac mHandler;
    public volatile boolean mIsInit;

    public static abstract class a {
        public void d(long j, long j2, long j3) {
        }

        public void d(long j, boolean z) {
        }

        public void b(long j, byte[] bArr) {
        }

        public void e(long j, boolean z) {
        }

        public void a(String str, String str2, int i, byte[] bArr) {
        }

        public void Xl() {
        }
    }

    private final class b implements Runnable {
        final /* synthetic */ b epn;
        private long epr = 0;
        private long eps = 0;

        public b(b bVar, long j, long j2) {
            this.epn = bVar;
            this.epr = j;
            this.eps = j2;
        }

        public final void run() {
            b bVar = this.epn;
            d dVar = new d(this.epr, bVar.aHq, bVar);
            String valueOf = String.valueOf(dVar.epy);
            v.i("MicroMsg.exdevice.BluetoothLEManager", "BluetoothLESession hashCode = %d, macAddr = %d, mapKey = %s", new Object[]{Integer.valueOf(dVar.hashCode()), Long.valueOf(r2), valueOf});
            d dVar2 = (d) bVar.epg.remove(valueOf);
            if (dVar2 != null) {
                dVar2.close();
            }
            bVar.epg.put(valueOf, dVar);
            long j = dVar.epy;
            if (this.epn.epf != null) {
                this.epn.epf.d(j, this.epr, this.eps);
            }
        }
    }

    static /* synthetic */ void a(b bVar, BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        v.d("MicroMsg.exdevice.BluetoothLEManager", "onLeScanImp");
        if (!bVar.epk.isEmpty()) {
            long sE = com.tencent.mm.plugin.exdevice.j.b.sE(bluetoothDevice.getAddress());
            if (bVar.epk.contains(Long.valueOf(sE))) {
                v.i("MicroMsg.exdevice.BluetoothLEManager", "------onConnectPreScanFound------ sessionid = %d", new Object[]{Long.valueOf(sE)});
                d dVar = (d) bVar.epg.get(String.valueOf(sE));
                if (dVar == null) {
                    v.e("MicroMsg.exdevice.BluetoothLEManager", "null == les");
                    if (bVar.epf != null) {
                        bVar.epf.d(sE, false);
                    }
                } else if (!dVar.connect()) {
                    v.e("MicroMsg.exdevice.BluetoothLEManager", "les.connect() Failed!!!");
                    if (bVar.epf != null) {
                        bVar.epf.d(sE, false);
                    }
                }
                bVar.epk.remove(Long.valueOf(sE));
                if (bVar.epk.isEmpty()) {
                    v.i("MicroMsg.exdevice.BluetoothLEManager", "Connect PreScan is done.");
                }
            }
        }
        if (bVar.epf != null) {
            bVar.epf.a(bluetoothDevice.getAddress(), bluetoothDevice.getName(), i, bArr);
        }
    }

    public b(ad adVar) {
        this.epf = null;
        this.aHq = null;
        this.epg = new HashMap();
        this.eoz = null;
        this.mHandler = null;
        this.lv = null;
        this.eph = false;
        this.mIsInit = false;
        this.epk = new HashSet();
        this.epl = new com.tencent.mm.plugin.c.a.b.c.a(this) {
            final /* synthetic */ b epn;

            {
                this.epn = r1;
            }

            public final void a(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
                v.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", new Object[]{bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.sE(bluetoothDevice.getAddress()))});
                this.epn.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 epp;

                    public final void run() {
                        b.a(this.epp.epn, bluetoothDevice, i, bArr);
                    }
                });
            }

            public final void Xl() {
            }
        };
        this.epm = new com.tencent.mm.plugin.c.a.b.g.a(this) {
            final /* synthetic */ b epn;

            {
                this.epn = r1;
            }

            public final void a(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
                v.d("MicroMsg.exdevice.BluetoothLEManager", "------onDiscover------ device Name = %s, mac = %s(%d)", new Object[]{bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.sE(bluetoothDevice.getAddress()))});
                this.epn.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 epq;

                    public final void run() {
                        b.a(this.epq.epn, bluetoothDevice, i, bArr);
                    }
                });
            }

            public final void is(int i) {
                v.i("MicroMsg.exdevice.BluetoothLEManager", "(API21)start ble scan failed, errorCode = %d", new Object[]{Integer.valueOf(i)});
                if (i != 1) {
                    this.epn.mHandler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 epq;

                        {
                            this.epq = r1;
                        }

                        public final void run() {
                            if (!this.epq.epn.epk.isEmpty()) {
                                Iterator it = this.epq.epn.epk.iterator();
                                while (it.hasNext()) {
                                    v.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[]{(Long) it.next()});
                                    if (this.epq.epn.epf != null) {
                                        this.epq.epn.epf.d(r0.longValue(), false);
                                    }
                                }
                                this.epq.epn.epk.clear();
                            }
                        }
                    });
                }
            }
        };
        this.lv = new Runnable(this) {
            final /* synthetic */ b epn;

            {
                this.epn = r1;
            }

            public final void run() {
                this.epn.eph = false;
                this.epn.bX(false);
                v.i("MicroMsg.exdevice.BluetoothLEManager", "Time out for discovering. Stop it");
                this.epn.Xj();
                if (this.epn.epf != null) {
                    this.epn.epf.Xl();
                }
            }
        };
        this.mHandler = new ac(adVar.htb.getLooper());
    }

    final void Xj() {
        v.i("MicroMsg.exdevice.BluetoothLEManager", "tryToCleanPreScanSet");
        if (!this.epk.isEmpty()) {
            Iterator it = this.epk.iterator();
            while (it.hasNext()) {
                v.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[]{(Long) it.next()});
                if (this.epf != null) {
                    this.epf.d(r0.longValue(), false);
                }
            }
            this.epk.clear();
        }
    }

    @TargetApi(18)
    public final boolean Xk() {
        Assert.assertTrue(this.mIsInit);
        return this.aHq.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    private void Xe() {
        if (this.eph) {
            this.mHandler.removeCallbacks(this.lv);
            this.eph = false;
            bX(false);
            Xj();
            if (this.epf != null) {
                this.epf.Xl();
            }
        }
    }

    public final boolean a(boolean z, int... iArr) {
        v.i("MicroMsg.exdevice.BluetoothLEManager", "------scanLEDevice------" + (z ? "true" : "false"));
        Assert.assertTrue(this.mIsInit);
        if (!Xk()) {
            v.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
            return false;
        } else if (!z) {
            Xe();
            return true;
        } else if (this.eph) {
            return true;
        } else {
            if (bX(z)) {
                if (iArr == null || iArr.length <= 0 || iArr[0] != 1) {
                    this.mHandler.postDelayed(this.lv, 10000);
                } else {
                    this.mHandler.removeCallbacks(this.lv);
                }
                this.eph = true;
                return true;
            }
            v.e("MicroMsg.exdevice.BluetoothLEManager", "mAdapter.startLeScan Failed!!!");
            if (!this.epk.isEmpty()) {
                Iterator it = this.epk.iterator();
                while (it.hasNext()) {
                    v.e("MicroMsg.exdevice.BluetoothLEManager", "Cannot scan out Remote device(Mac = %d), Connect Failed!!!", new Object[]{(Long) it.next()});
                    if (this.epf != null) {
                        this.epf.d(r0.longValue(), false);
                    }
                }
                this.epk.clear();
            }
            return false;
        }
    }

    final boolean bX(boolean z) {
        boolean z2 = false;
        if (f.dW(21) && this.epj != null) {
            g gVar = this.epj;
            com.tencent.mm.plugin.c.a.b.g.a aVar = this.epm;
            v.i("MicroMsg.exdevice.NewBluetoothLEScanner", "(API21)execute scan");
            Boolean bool = (Boolean) new com.tencent.mm.plugin.c.a.b.g.AnonymousClass1(gVar, z, aVar).c(gVar.mHandler);
            if (bool != null) {
                z2 = true;
            }
            Assert.assertTrue(z2);
            return bool.booleanValue();
        } else if (this.epi != null) {
            return this.epi.a(z, this.epl);
        } else {
            v.e("MicroMsg.exdevice.BluetoothLEManager", "Scanner is null");
            return false;
        }
    }

    public final boolean connect(long j) {
        v.i("MicroMsg.exdevice.BluetoothLEManager", "------connect------ sessionId = %d ", new Object[]{Long.valueOf(j)});
        Assert.assertTrue(this.mIsInit);
        if (Xk()) {
            d dVar = (d) this.epg.get(String.valueOf(j));
            Assert.assertTrue(dVar != null);
            BluetoothManager bluetoothManager = (BluetoothManager) this.aHq.getSystemService("bluetooth");
            if (bluetoothManager == null) {
                v.e("MicroMsg.exdevice.BluetoothLEManager", "null == bluetoothManager");
            } else {
                List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(8);
                if (connectedDevices == null) {
                    v.i("MicroMsg.exdevice.BluetoothLEManager", "null == list, may be no device is connected phone now");
                } else {
                    for (BluetoothDevice address : connectedDevices) {
                        v.i("MicroMsg.exdevice.BluetoothLEManager", "get connected device: mac = %s, long of mac =%d, name = %s", new Object[]{address.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.sE(((BluetoothDevice) r3.next()).getAddress())), ((BluetoothDevice) r3.next()).getName()});
                        if (j == com.tencent.mm.plugin.exdevice.j.b.sE(((BluetoothDevice) r3.next()).getAddress())) {
                            v.i("MicroMsg.exdevice.BluetoothLEManager", "This device is connected to phone now, start connecting without scan...");
                            return dVar.connect();
                        }
                    }
                    v.i("MicroMsg.exdevice.BluetoothLEManager", "Android version realse code: %s", new Object[]{VERSION.RELEASE});
                    if (f.dW(23) && !((LocationManager) this.aHq.getSystemService("location")).isProviderEnabled("gps") && !VERSION.RELEASE.equalsIgnoreCase("6.0") && !VERSION.RELEASE.equalsIgnoreCase("6.0.0")) {
                        return dVar.connect();
                    }
                    Set<BluetoothDevice> bondedDevices = bluetoothManager.getAdapter().getBondedDevices();
                    if (bondedDevices == null) {
                        v.i("MicroMsg.exdevice.BluetoothLEManager", "null == pairedDevices,get paired devices failed");
                    } else {
                        for (BluetoothDevice bluetoothDevice : bondedDevices) {
                            v.i("MicroMsg.exdevice.BluetoothLEManager", "get paired device: mac = %s, long of mac =%d, name = %s", new Object[]{bluetoothDevice.getAddress(), Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.sE(bluetoothDevice.getAddress())), bluetoothDevice.getName()});
                            if (j == com.tencent.mm.plugin.exdevice.j.b.sE(bluetoothDevice.getAddress())) {
                                v.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device is paired to phone now, check if it is connected...");
                                InputManager inputManager = (InputManager) this.aHq.getSystemService("input");
                                int[] inputDeviceIds = inputManager.getInputDeviceIds();
                                if (inputDeviceIds == null) {
                                    v.i("MicroMsg.exdevice.BluetoothLEManager", "get input devices failed");
                                    break;
                                }
                                for (int inputDevice : inputDeviceIds) {
                                    InputDevice inputDevice2 = inputManager.getInputDevice(inputDevice);
                                    if (inputDevice2 != null) {
                                        String name = inputDevice2.getName();
                                        v.d("MicroMsg.exdevice.BluetoothLEManager", "Input devices: %s", new Object[]{name});
                                        if (name != null && name.equals(bluetoothDevice.getName())) {
                                            v.i("MicroMsg.exdevice.BluetoothLEManager", "This HID deivce has connected to phone as a input device");
                                            return dVar.connect();
                                        }
                                    }
                                }
                                v.i("MicroMsg.exdevice.BluetoothLEManager", "This HID device hasn't been connected...");
                            }
                        }
                    }
                }
            }
            this.epk.add(Long.valueOf(j));
            return a(true, new int[0]);
        }
        v.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
        return false;
    }
}
