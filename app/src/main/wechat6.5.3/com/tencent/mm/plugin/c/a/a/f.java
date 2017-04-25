package com.tencent.mm.plugin.c.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.r;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class f implements LeScanCallback, b, r {
    private static boolean eow = false;
    public static boolean eoy = false;
    private boolean eoA = true;
    private int eoB = 0;
    private String eoC = "";
    private e eoD = null;
    private Map<String, Long> eoE = new ConcurrentHashMap();
    private final ah eoF = new ah(v.ajX().frO.htb.getLooper(), new a(this) {
        final /* synthetic */ f eoK;

        {
            this.eoK = r1;
        }

        public final boolean oU() {
            this.eoK.mHandler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 eoL;

                {
                    this.eoL = r1;
                }

                public final void run() {
                    this.eoL.eoK.eou.a(this.eoL.eoK.eoB, this.eoL.eoK.eoC, this.eoL.eoK.eoD);
                }
            });
            return false;
        }
    }, true);
    private final ah eoG = new ah(v.ajX().frO.htb.getLooper(), new a(this) {
        final /* synthetic */ f eoK;

        {
            this.eoK = r1;
        }

        public final boolean oU() {
            if (this.eoK.eov.size() > 0) {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now start");
                if (f.g(this.eoK).booleanValue()) {
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan ok");
                } else {
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer restart bleScan fail");
                }
                f.eoy = aa.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false);
                if (!f.eoy) {
                    if (!this.eoK.eoH.btC()) {
                        this.eoK.eoH.QI();
                    }
                    if (!this.eoK.eoG.btC()) {
                        this.eoK.eoG.QI();
                    }
                }
            }
            return false;
        }
    }, true);
    private final ah eoH = new ah(v.ajX().frO.htb.getLooper(), new a(this) {
        final /* synthetic */ f eoK;

        {
            this.eoK = r1;
        }

        public final boolean oU() {
            if (this.eoK.eov.size() <= 0) {
                return false;
            }
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]mSelfAdaptionTimer now stop");
            f.j(this.eoK);
            if (this.eoK.eoG.btC()) {
                this.eoK.eoG.ea(2000);
            }
            return true;
        }
    }, true);
    private final ah eoI = new ah(v.ajX().frO.htb.getLooper(), new a(this) {
        final /* synthetic */ f eoK;

        {
            this.eoK = r1;
        }

        public final boolean oU() {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]make isScanning status false");
            f.eow = false;
            return false;
        }
    }, true);
    private final ah eoJ = new ah(v.ajX().frO.htb.getLooper(), new a(this) {
        final /* synthetic */ f eoK;

        {
            this.eoK = r1;
        }

        public final boolean oU() {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]time out ,let's stop this new method scan");
            this.eoK.Xe();
            return false;
        }
    }, true);
    private final b eor;
    private final d eou;
    private final HashSet<UUID> eov;
    private boolean eox = false;
    private BluetoothAdapter eoz;
    public final ac mHandler;

    class AnonymousClass6 implements Runnable {
        final /* synthetic */ f eoK;
        final /* synthetic */ UUID eoM;

        public AnonymousClass6(f fVar, UUID uuid) {
            this.eoK = fVar;
            this.eoM = uuid;
        }

        public final void run() {
            if (!f.a(this.eoK, this.eoM)) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.exdevice.IBeaconServer", "startRanging failed!!!");
            }
        }
    }

    class AnonymousClass7 implements Runnable {
        final /* synthetic */ f eoK;
        final /* synthetic */ UUID eoM;

        public AnonymousClass7(f fVar, UUID uuid) {
            this.eoK = fVar;
            this.eoM = uuid;
        }

        public final void run() {
            if (!f.b(this.eoK, this.eoM)) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.exdevice.IBeaconServer", "stopRanging failed!!!");
            }
        }
    }

    static /* synthetic */ boolean a(f fVar, UUID uuid) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.exdevice.IBeaconServer", "startRanging");
        if (uuid == null) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
            return false;
        }
        if (!fVar.eov.contains(uuid)) {
            fVar.eov.add(uuid);
        }
        fVar.Xf();
        return true;
    }

    static /* synthetic */ boolean b(f fVar, UUID uuid) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.exdevice.IBeaconServer", "stopRanging");
        if (uuid == null) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
            return false;
        }
        fVar.eov.remove(uuid);
        fVar.Xe();
        return true;
    }

    static /* synthetic */ Boolean g(f fVar) {
        return fVar.eoz != null ? Boolean.valueOf(fVar.eoz.startLeScan(fVar)) : Boolean.valueOf(false);
    }

    static /* synthetic */ void j(f fVar) {
        if (fVar.eoz != null) {
            fVar.eoz.stopLeScan(fVar);
        }
    }

    public f(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("aCallback is null");
        }
        this.eov = new HashSet();
        this.eou = new d(this);
        this.eor = bVar;
        this.mHandler = new ac(v.ajX().frO.htb.getLooper());
        this.eoz = ((BluetoothManager) aa.getContext().getSystemService("bluetooth")).getAdapter();
    }

    private void Xe() {
        this.eoE.clear();
        eow = false;
        if (!this.eoI.btC()) {
            this.eoI.QI();
        }
        if (!this.eoH.btC()) {
            this.eoH.QI();
        }
        if (!this.eoG.btC()) {
            this.eoG.QI();
        }
        if (!this.eoF.btC()) {
            this.eoF.QI();
        }
        if (!this.eoJ.btC()) {
            this.eoJ.QI();
        }
        if (this.eox && this.eoz != null) {
            this.eoz.stopLeScan(this);
            this.eox = false;
        }
    }

    private synchronized void Xf() {
        if (this.eoI.btC()) {
            this.eoI.ea(2000);
        }
        if (eoy && this.eoH.btC()) {
            this.eoH.ea(10000);
        }
        if (this.eoJ.btC()) {
            if (eoy) {
                this.eoJ.ea(1800000);
            } else {
                this.eoJ.ea(120000);
            }
        }
        if (!eow) {
            this.eoA = true;
            Boolean valueOf = Boolean.valueOf(this.eoz.startLeScan(this));
            if (valueOf.booleanValue() || eow) {
                this.eox = true;
                eow = true;
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
            } else {
                int i = 0;
                while (!valueOf.booleanValue() && i < 3 && !eow) {
                    i++;
                    this.eoz.stopLeScan(this);
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.exdevice.IBeaconServer", "start IBEACON BLE scan failed,retry no " + i + " time");
                    valueOf = Boolean.valueOf(this.eoz.startLeScan(this));
                    if (valueOf.booleanValue()) {
                        eow = true;
                        this.eox = true;
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]start ibeacon range successful");
                    }
                }
            }
        }
    }

    public final void a(double d, c cVar) {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback, distance = %f", new Object[]{Double.valueOf(d)});
        String ak = b.ak(cVar.eoo.eot.eoU);
        if (ak.length() >= 32) {
            ak = ak.substring(0, 8) + "-" + ak.substring(8, 12) + "-" + ak.substring(12, 16) + "-" + ak.substring(16, 20) + "-" + ak.substring(20);
        }
        String str = ak + cVar.eoo.eot.eoV + cVar.eoo.eot.eoW;
        if (this.eoE.containsKey(str)) {
            long longValue = ((Long) this.eoE.get(str)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 500) {
                this.eoE.put(str, Long.valueOf(currentTimeMillis));
                this.eor.a(d, cVar);
                return;
            }
            return;
        }
        this.eoE.put(str, Long.valueOf(System.currentTimeMillis()));
        this.eor.a(d, cVar);
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.exdevice.IBeaconServer", "[shakezb]onRangingCallback,uuid = " + ak + ",major = " + cVar.eoo.eot.eoV + ",minor = " + (cVar.eoo.eot.eoW & 65535));
    }

    public final void ir(int i) {
        if (i == 0) {
            Xe();
        }
    }

    public final void a(final String str, String str2, int i, final int i2, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.exdevice.IBeaconServer", "onScanFound, device mac = %s, device name = %s, bluetooth version = %d, rssi = %d, advertisment = %s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), b.ak(bArr)});
        if (i == 0) {
            final e eVar = new e();
            if (eVar.Z(bArr)) {
                UUID am = b.am(eVar.eot.eoU);
                if (am == null) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
                    return;
                } else if (this.eov.contains(am)) {
                    if (this.eoA) {
                        this.eoC = str;
                    }
                    this.mHandler.post(new Runnable(this) {
                        final /* synthetic */ f eoK;

                        public final void run() {
                            this.eoK.eou.a(i2, str, eVar);
                        }
                    });
                    return;
                } else {
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
                    return;
                }
            }
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
        }
    }

    public final void pv(String str) {
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.exdevice.IBeaconServer", "------onScanError------ error code = %s, error msg = %s", new Object[]{Integer.valueOf(-1), str});
    }

    public final void onLeScan(final BluetoothDevice bluetoothDevice, final int i, byte[] bArr) {
        final e eVar = new e();
        if (eVar.Z(bArr)) {
            UUID am = b.am(eVar.eot.eoU);
            if (am == null) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.exdevice.IBeaconServer", "parse UUID from byte array failed!!!");
                return;
            } else if (this.eov.contains(am)) {
                if (this.eoA) {
                    this.eoB = i;
                    this.eoD = eVar;
                    if (this.eoF.btC()) {
                        this.eoF.ea(2000);
                    }
                    this.eoA = false;
                }
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ f eoK;

                    public final void run() {
                        this.eoK.eou.a(i, bluetoothDevice.getAddress(), eVar);
                    }
                });
                return;
            } else {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.exdevice.IBeaconServer", "this IBeacon UUID is not in the set");
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.exdevice.IBeaconServer", "protocal.ParseFromByte Failed!!!");
    }
}
