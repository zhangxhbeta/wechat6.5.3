package com.tencent.mm.plugin.c.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.c.a.b.a.c;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import junit.framework.Assert;

@TargetApi(18)
public final class f {
    static int eqk = 0;
    private int cLr;
    private BluetoothAdapter eoz;
    private Context epA;
    private BluetoothGatt epB;
    private a epF;
    private Runnable epG;
    private Runnable epI;
    private final LinkedList<byte[]> epK;
    private volatile boolean epL;
    private HandlerThread epM;
    private volatile int epN;
    private final BluetoothGattCallback epO;
    public long epy;
    public BluetoothDevice epz;
    private a eqd;
    private Runnable eqe;
    private f eqf;
    private HashMap<String, HashMap<String, BluetoothGattCharacteristic>> eqg;
    private long eqh;
    private ArrayList<BluetoothGattCharacteristic> eqi;
    private boolean eqj;
    public ac mHandler;

    public static abstract class a {
        public void a(long j, boolean z, long j2) {
        }

        public void b(long j, byte[] bArr) {
        }

        public void e(long j, boolean z) {
        }
    }

    private static class b extends ac {
        private final WeakReference<f> epQ;

        public b(Looper looper, f fVar) {
            super(looper);
            this.epQ = new WeakReference(fVar);
        }

        public final void handleMessage(Message message) {
            f fVar = (f) this.epQ.get();
            if (fVar == null) {
                v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "null == BluetoothLESession");
                return;
            }
            switch (message.what) {
                case 0:
                    f.a(fVar);
                    return;
                case 1:
                    f.b(fVar);
                    return;
                case 2:
                    f.c(fVar);
                    return;
                case 3:
                    f.a(fVar, (byte[]) message.obj);
                    return;
                case 4:
                    f.a(fVar, message.arg1);
                    return;
                case 5:
                    if (!f.a(fVar, (BluetoothGatt) message.obj, message.arg1)) {
                        v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnect------, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.br(fVar.epy), fVar.epz.getName()});
                        if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(1))) {
                            v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(1)});
                            return;
                        }
                        return;
                    }
                    return;
                case 6:
                    Object obj = message.obj;
                    f.b(fVar, message.arg1);
                    return;
                case 7:
                    f.c(fVar, message.arg1);
                    return;
                case 8:
                    f.a(fVar, (BluetoothGattCharacteristic) message.obj);
                    return;
                case 9:
                    f.d(fVar);
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void a(f fVar) {
        v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connectImp------, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.br(fVar.epy), fVar.epz.getName()});
        if (1 == fVar.epN) {
            v.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device is connected !!!");
            if (fVar.eqd != null) {
                v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device has connected, just callback.");
                fVar.eqd.a(fVar.epy, true, fVar.eqh);
            }
        } else if (fVar.epN == 0) {
            v.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Remote device is connecting !!!");
        } else {
            fVar.Xn();
            if (fVar.epB == null) {
                fVar.epB = fVar.epz.connectGatt(fVar.epA, false, fVar.epO);
                eqk++;
                v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------create resource------, objid=%d, resourceCount=%d, mac=%s, name=%s", new Object[]{Integer.valueOf(fVar.hashCode()), Integer.valueOf(eqk), com.tencent.mm.plugin.exdevice.j.b.br(fVar.epy), fVar.epz.getName()});
                if (fVar.epB == null) {
                    v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mDevice.connectGatt Failed!!!");
                    fVar.Xr();
                    return;
                }
                fVar.epN = 0;
                fVar.mHandler.postDelayed(fVar.epI, 10000);
            } else if (fVar.epB.connect()) {
                fVar.epN = 0;
                fVar.mHandler.postDelayed(fVar.epI, 10000);
            } else {
                v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.connect() Failed!!!");
                fVar.Xr();
            }
        }
    }

    static /* synthetic */ void a(f fVar, int i) {
        String str = "MicroMsg.exdevice.BluetoothLESimpleSession";
        String str2 = "------onConnectionStateChangeImp------ aState = %s, mac=%s, name=%s";
        Object[] objArr = new Object[3];
        objArr[0] = i == 2 ? "Connected" : "Disconnected";
        objArr[1] = com.tencent.mm.plugin.exdevice.j.b.br(fVar.epy);
        objArr[2] = fVar.epz.getName();
        v.i(str, str2, objArr);
        if (i == 2) {
            v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "PHY Connected is OK, mConnectState = %d", new Object[]{Integer.valueOf(fVar.epN)});
            if (3 == fVar.epN) {
                v.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close or disconnect is Called, Leave without discover Services");
                fVar.mHandler.removeCallbacks(fVar.epI);
            } else if (1 == fVar.epN) {
                v.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected is done, Leave without discover Services");
                fVar.mHandler.removeCallbacks(fVar.epI);
            } else if (fVar.epB.discoverServices()) {
                fVar.mHandler.removeCallbacks(fVar.epI);
                fVar.mHandler.postDelayed(fVar.epI, 10000);
                v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "start discoverServices...");
            } else {
                v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "discover Services start failed!!!");
                fVar.Xp();
            }
        } else if (i == 0) {
            v.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Disconnected from GATT server.");
            fVar.eqg.clear();
            fVar.eqi.clear();
            fVar.eqh = 0;
            fVar.Xp();
        }
    }

    static /* synthetic */ void a(f fVar, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceiveImp------, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.br(fVar.epy), fVar.epz.getName()});
        if (bluetoothGattCharacteristic == null) {
            v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic is null");
            return;
        }
        byte[] value = bluetoothGattCharacteristic.getValue();
        String w = com.tencent.mm.plugin.exdevice.j.b.w(value, value.length);
        v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "data length = %d", new Object[]{Integer.valueOf(value.length)});
        v.d("MicroMsg.exdevice.BluetoothLESimpleSession", "data dump = %s", new Object[]{w});
        value = c.a(bluetoothGattCharacteristic, value);
        if (value == null) {
            v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parse data error");
        } else if (fVar.eqd != null) {
            fVar.eqd.b(fVar.epy, value);
        }
    }

    static /* synthetic */ void a(f fVar, byte[] bArr) {
        boolean z = true;
        v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------writeDataAsync------parserobj length = %d, mac=%s, name=%s", new Object[]{Integer.valueOf(bArr.length), com.tencent.mm.plugin.exdevice.j.b.br(fVar.epy), fVar.epz.getName()});
        if (1 != fVar.epN) {
            v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Not ready for write data, connectstate = %d", new Object[]{Integer.valueOf(fVar.epN)});
            if (fVar.eqd != null) {
                fVar.eqd.e(fVar.epy, false);
                return;
            }
            return;
        }
        com.tencent.mm.plugin.c.a.b.a.a ab = com.tencent.mm.plugin.c.a.b.a.a.ab(bArr);
        v.d("MicroMsg.exdevice.BluetoothLESimpleSession", "rawData data dump = %s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.ak(ab.Xt())});
        String str = ab.eqO;
        int i = ab.eqP;
        HashMap hashMap = (HashMap) fVar.eqg.get(c.aJ(ab.eqh));
        String str2;
        if (hashMap == null) {
            v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found", new Object[]{str2});
            if (fVar.eqd != null) {
                fVar.eqd.e(fVar.epy, false);
                return;
            }
            return;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) hashMap.get(str);
        String str3;
        if (bluetoothGattCharacteristic == null) {
            str3 = "MicroMsg.exdevice.BluetoothLESimpleSession";
            str2 = "characteristic(%s) not found";
            Object[] objArr = new Object[1];
            objArr[0] = str == null ? "null" : str;
            v.e(str3, str2, objArr);
            if (fVar.eqd != null) {
                fVar.eqd.e(fVar.epy, false);
            }
        } else if ((bluetoothGattCharacteristic.getProperties() | i) == 0) {
            v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "property not support. current = %d, provided = %d", new Object[]{Integer.valueOf(bluetoothGattCharacteristic.getProperties()), Integer.valueOf(i)});
            if (fVar.eqd != null) {
                fVar.eqd.e(fVar.epy, false);
            }
        } else if (i == 2) {
            boolean z2;
            if (bluetoothGattCharacteristic == null) {
                v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "characteristic not found");
                z2 = false;
            } else if (fVar.epB.readCharacteristic(bluetoothGattCharacteristic)) {
                z2 = true;
            } else {
                v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.readCharacteristic Failed!!!");
                z2 = false;
            }
            str3 = "MicroMsg.exdevice.BluetoothLESimpleSession";
            str2 = "readCharacteristic state: %s";
            Object[] objArr2 = new Object[1];
            objArr2[0] = z2 ? "true" : "false";
            v.d(str3, str2, objArr2);
            if (fVar.eqd == null) {
                return;
            }
            if (z2) {
                fVar.eqd.e(fVar.epy, true);
            } else {
                fVar.eqd.e(fVar.epy, false);
            }
        } else {
            Assert.assertTrue(fVar.epB != null);
            fVar.epK.add(bArr);
            if (!fVar.epL) {
                if (1 != fVar.epK.size()) {
                    z = false;
                }
                Assert.assertTrue(z);
                fVar.Xo();
            }
        }
    }

    static /* synthetic */ boolean a(f fVar, BluetoothGatt bluetoothGatt, int i) {
        v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "onServicesDiscoveredImp, status = %d, mac=%s, name=%s", new Object[]{Integer.valueOf(i), com.tencent.mm.plugin.exdevice.j.b.br(fVar.epy), fVar.epz.getName()});
        fVar.mHandler.removeCallbacks(fVar.epI);
        if (3 == fVar.epN) {
            v.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close or disconnect is Called, Just Leave");
            return false;
        }
        if (1 == fVar.epN) {
            v.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected is done, Just Leave");
        } else if (i != 0) {
            v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Discover services error");
            fVar.Xp();
            return false;
        } else {
            List services = bluetoothGatt.getServices();
            for (int i2 = 0; i2 < services.size(); i2++) {
                Object obj;
                BluetoothGattService bluetoothGattService = (BluetoothGattService) services.get(i2);
                if (bluetoothGattService == null) {
                    v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service is null");
                    obj = null;
                } else if (c.b(bluetoothGattService)) {
                    fVar.eqh |= c.a(bluetoothGattService);
                    HashMap hashMap = new HashMap();
                    List characteristics = bluetoothGattService.getCharacteristics();
                    for (int i3 = 0; i3 < characteristics.size(); i3++) {
                        BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) characteristics.get(i3);
                        Object uuid = bluetoothGattCharacteristic.getUuid().toString();
                        int properties = bluetoothGattCharacteristic.getProperties();
                        int permissions = bluetoothGattCharacteristic.getPermissions();
                        v.d("MicroMsg.exdevice.BluetoothLESimpleSession", "found characteristic = %s, properties = %d, permission = %d", new Object[]{uuid, Integer.valueOf(properties), Integer.valueOf(permissions)});
                        if (uuid == null) {
                            uuid = "null";
                        }
                        hashMap.put(uuid, bluetoothGattCharacteristic);
                        fVar.eqi.add(bluetoothGattCharacteristic);
                    }
                    fVar.eqg.put(bluetoothGattService.getUuid().toString(), hashMap);
                    obj = 1;
                } else {
                    v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parse service error");
                    obj = null;
                }
                if (obj == null) {
                    v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "parseService error. service uuid = %s", new Object[]{bluetoothGattService.getUuid().toString()});
                }
            }
            if (0 == fVar.eqh) {
                v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "the device hasn't pass test");
                fVar.Xp();
                return false;
            } else if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(9))) {
                v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(9)});
            }
        }
        return true;
    }

    static /* synthetic */ void b(f fVar) {
        v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------disconnectImp------, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.br(fVar.epy), fVar.epz.getName()});
        if (3 == fVar.epN) {
            v.w("MicroMsg.exdevice.BluetoothLESimpleSession", "diconnect or close is called aready, just leave");
        } else if (2 == fVar.epN) {
            v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "already disconnected, just leave");
        } else {
            fVar.Xn();
            if (fVar.epB == null) {
                v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "disconnect:BluetoothGatt not found");
                return;
            }
            fVar.epN = 3;
            fVar.mHandler.removeCallbacks(fVar.epI);
            if (fVar.epB != null) {
                fVar.epB.disconnect();
            }
        }
    }

    static /* synthetic */ void b(f fVar, int i) {
        v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWriteImp------ status = %d, mac=%s, name=%s", new Object[]{Integer.valueOf(i), com.tencent.mm.plugin.exdevice.j.b.br(fVar.epy), fVar.epz.getName()});
        if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(9))) {
            v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(9)});
        }
    }

    static /* synthetic */ void c(f fVar) {
        v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------closeImp------, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.br(fVar.epy), fVar.epz.getName()});
        if (3 == fVar.epN) {
            v.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Close aready, Just leave");
            fVar.Xr();
            return;
        }
        fVar.Xn();
        if (fVar.epB == null) {
            v.w("MicroMsg.exdevice.BluetoothLESimpleSession", "close:BluetoothGatt not found");
            fVar.Xr();
            return;
        }
        fVar.epN = 3;
        fVar.mHandler.removeCallbacks(fVar.epI);
        fVar.Xr();
        if (fVar.epB != null) {
            v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "disconnect gatt, and wait gatt disconnected callback, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.br(fVar.epy), fVar.epz.getName()});
            fVar.epB.disconnect();
            fVar.eqj = true;
            fVar.mHandler.postDelayed(fVar.eqe, 10000);
        }
    }

    static /* synthetic */ void c(f fVar, int i) {
        v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallbackImp------ status = %d, mac=%s, name=%s", new Object[]{Integer.valueOf(i), com.tencent.mm.plugin.exdevice.j.b.br(fVar.epy), fVar.epz.getName()});
        fVar.mHandler.removeCallbacks(fVar.epG);
        if (i != 0) {
            v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "write data error: " + i);
            if (fVar.eqd != null) {
                fVar.eqd.e(fVar.epy, false);
            }
            fVar.Xo();
            return;
        }
        byte[] Xi = fVar.epF.Xi();
        v.d("MicroMsg.exdevice.BluetoothLESimpleSession", "Out data dump = %s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.ak(Xi)});
        if (Xi == null) {
            v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "write data complete");
            if (fVar.eqd != null) {
                fVar.eqd.e(fVar.epy, true);
            }
            fVar.Xo();
            return;
        }
        v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "write next chunk...");
        fVar.epF.epe.setValue(Xi);
        fVar.epB.writeCharacteristic(fVar.epF.epe);
        fVar.mHandler.postDelayed(fVar.epG, 5000);
    }

    static /* synthetic */ void d(f fVar) {
        while (fVar.eqi.size() > 0) {
            int i;
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) fVar.eqi.remove(0);
            f fVar2 = fVar.eqf;
            int properties = bluetoothGattCharacteristic.getProperties();
            if ((properties & 48) == 0) {
                v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "no indicate and notify");
                i = 0;
            } else if (fVar2.epB.setCharacteristicNotification(bluetoothGattCharacteristic, true)) {
                BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(h.eqs));
                if (descriptor == null) {
                    v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not get configure descriptor");
                    i = 0;
                } else {
                    v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Configure descriptor permissions: " + descriptor.getPermissions());
                    byte[] bArr = new byte[]{(byte) 0, (byte) 0};
                    if ((properties & 32) != 0) {
                        bArr[0] = (byte) (bArr[0] | BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[0]);
                        bArr[1] = (byte) (bArr[1] | BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[1]);
                    }
                    if ((properties & 16) != 0) {
                        bArr[0] = (byte) (bArr[0] | BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE[0]);
                        bArr[1] = (byte) (bArr[1] | BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE[1]);
                    }
                    if (!descriptor.setValue(bArr)) {
                        v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not set configure descriptor value");
                        i = 0;
                    } else if (fVar2.epB.writeDescriptor(descriptor)) {
                        boolean z = true;
                    } else {
                        v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Can not write configure descriptor value");
                        i = 0;
                    }
                }
            } else {
                v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Unable to set indicator for read characteristic");
                i = 0;
            }
            if (i == 0) {
                v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mSelfSession.setCharacteristicNotification Failed!!!. uuid = %s, properties = %d", new Object[]{bluetoothGattCharacteristic.getUuid().toString(), Integer.valueOf(bluetoothGattCharacteristic.getProperties())});
            } else {
                return;
            }
        }
        v.d("MicroMsg.exdevice.BluetoothLESimpleSession", "onConnected = true");
        fVar.epN = 1;
        fVar.mHandler.removeCallbacks(fVar.epI);
        if (fVar.eqd != null) {
            fVar.eqd.a(fVar.epy, true, fVar.eqh);
        }
    }

    final void Xp() {
        v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "markSessionDisconnected, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.br(this.epy), this.epz.getName()});
        this.epN = 2;
        this.mHandler.removeCallbacks(this.epI);
        this.mHandler.removeCallbacks(this.eqe);
        Xr();
        Xq();
    }

    @TargetApi(18)
    public f(long j, Context context, a aVar) {
        this.epK = new LinkedList();
        this.epL = false;
        this.eqg = new HashMap();
        this.eqh = 0;
        this.eqi = new ArrayList();
        this.epO = new BluetoothGattCallback(this) {
            final /* synthetic */ f eql;

            {
                this.eql = r1;
            }

            public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(this.eql.epN)});
                if (!this.eql.mHandler.sendMessage(this.eql.mHandler.obtainMessage(4, i2, 0))) {
                    v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(4)});
                }
            }

            public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onServicesDiscovered------ status = %d", new Object[]{Integer.valueOf(i)});
                if (!this.eql.mHandler.sendMessage(this.eql.mHandler.obtainMessage(5, i, 0, bluetoothGatt))) {
                    v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(5)});
                }
            }

            public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDescriptorWrite------ status = %d", new Object[]{Integer.valueOf(i)});
                if (!this.eql.mHandler.sendMessage(this.eql.mHandler.obtainMessage(6, i, 0, bluetoothGatt))) {
                    v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(6)});
                }
            }

            public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataReceive------");
                if (!this.eql.mHandler.sendMessage(this.eql.mHandler.obtainMessage(8, bluetoothGattCharacteristic))) {
                    v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(8)});
                }
            }

            public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onCharacteristicRead------ status = %d", new Object[]{Integer.valueOf(i)});
                if (i == 0 && !this.eql.mHandler.sendMessage(this.eql.mHandler.obtainMessage(8, bluetoothGattCharacteristic))) {
                    v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(8)});
                }
            }

            public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------onDataWriteCallback------ status = %d", new Object[]{Integer.valueOf(i)});
                if (!this.eql.mHandler.sendMessage(this.eql.mHandler.obtainMessage(7, i, 0))) {
                    v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(7)});
                }
            }
        };
        this.cLr = -1;
        this.cLr = hashCode();
        this.eqf = this;
        this.eqd = aVar;
        this.epA = context;
        this.eoz = ((BluetoothManager) this.epA.getSystemService("bluetooth")).getAdapter();
        this.epy = j;
        this.epN = 3;
        this.epz = this.eoz.getRemoteDevice(com.tencent.mm.plugin.c.a.e.a.aL(j));
        this.epF = new a();
        this.eqj = false;
        this.epM = e.Lg("BluetoothLESimpleSession_handlerThread");
        this.epM.start();
        this.mHandler = new b(this.epM.getLooper(), this);
        this.epG = new Runnable(this) {
            final /* synthetic */ f eql;

            {
                this.eql = r1;
            }

            public final void run() {
                v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Write data timeout, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.br(this.eql.epy), this.eql.epz.getName()});
                if (this.eql.eqd != null) {
                    this.eql.eqd.e(this.eql.epy, false);
                }
                this.eql.Xo();
            }
        };
        this.epI = new Runnable(this) {
            final /* synthetic */ f eql;

            {
                this.eql = r1;
            }

            public final void run() {
                v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "Connected timeout!!!, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.br(this.eql.epy), this.eql.epz.getName()});
                if (3 == this.eql.epN) {
                    v.w("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already disconnet or close, just leave");
                } else if (this.eql.epN == 1) {
                    v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "Bluetooth device is already connected, just leave.");
                } else {
                    this.eql.Xp();
                }
            }
        };
        this.eqe = new Runnable(this) {
            final /* synthetic */ f eql;

            {
                this.eql = r1;
            }

            public final void run() {
                if (this.eql.eqj) {
                    if (this.eql.eqd != null) {
                        this.eql.eqd.a(this.eql.epy, false, this.eql.eqh);
                    }
                    v.d("MicroMsg.exdevice.BluetoothLESimpleSession", "close timeout!!! stop handle thread.");
                    this.eql.Xq();
                }
            }
        };
    }

    private void Xq() {
        if (this.epB == null) {
            v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------ nothing to release, objid=%d, mac=%s, name=%s", new Object[]{Integer.valueOf(hashCode()), com.tencent.mm.plugin.exdevice.j.b.br(this.epy), this.epz.getName()});
            return;
        }
        eqk--;
        v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------releaseResources------, objid=%d, resourceCount=%d, mac=%s, name=%s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(eqk), com.tencent.mm.plugin.exdevice.j.b.br(this.epy), this.epz.getName()});
        this.eqj = false;
        this.epB.close();
        this.epM.quitSafely();
        this.epB = null;
        this.epM = null;
    }

    public final boolean connect() {
        v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------connect------, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.br(this.epy), this.epz.getName()});
        return this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    }

    private void Xn() {
        this.epL = false;
        this.epK.clear();
    }

    private void Xr() {
        if (this.eqd == null) {
            v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------ don't need to notify, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.br(this.epy), this.epz.getName()});
            return;
        }
        v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------notifySessionClose------, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.br(this.epy), this.epz.getName()});
        if (this.eqd != null) {
            this.eqd.a(this.epy, false, this.eqh);
        }
        this.eqd = null;
    }

    private void Xo() {
        if (this.epK.isEmpty()) {
            this.epL = false;
            return;
        }
        com.tencent.mm.plugin.c.a.b.a.a ab = com.tencent.mm.plugin.c.a.b.a.a.ab((byte[]) this.epK.pop());
        byte[] Xt = ab.Xt();
        String str = ab.eqO;
        int i = ab.eqP;
        HashMap hashMap = (HashMap) this.eqg.get(c.aJ(ab.eqh));
        if (hashMap == null) {
            v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "service(%s) not found, mac=%s, name=%s", new Object[]{r4, com.tencent.mm.plugin.exdevice.j.b.br(this.epy), this.epz.getName()});
            if (this.eqd != null) {
                this.eqd.e(this.epy, false);
                return;
            }
            return;
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) hashMap.get(str);
        if (bluetoothGattCharacteristic == null) {
            String str2;
            String str3 = "MicroMsg.exdevice.BluetoothLESimpleSession";
            String str4 = "characteristic(%s) not found, mac=%s, name=%s";
            Object[] objArr = new Object[3];
            if (str == null) {
                str2 = "null";
            } else {
                str2 = str;
            }
            objArr[0] = str2;
            objArr[1] = com.tencent.mm.plugin.exdevice.j.b.br(this.epy);
            objArr[2] = this.epz.getName();
            v.e(str3, str4, objArr);
            if (this.eqd != null) {
                this.eqd.e(this.epy, false);
            }
        } else if (i == 8) {
            this.epF.epe = bluetoothGattCharacteristic;
            this.epF.setData(Xt);
            v.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write data to character, dump = %s, characteristicUuid=%s, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.ak(this.epF.Xi()), str, com.tencent.mm.plugin.exdevice.j.b.br(this.epy), this.epz.getName()});
            bluetoothGattCharacteristic.setValue(Xt);
            this.mHandler.postDelayed(this.epG, 5000);
            if (this.epB.writeCharacteristic(bluetoothGattCharacteristic)) {
                this.epL = true;
                return;
            }
            v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "mBluetoothGatt.writeCharacteristic Failed!!!, mac=%s, name=%s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.br(this.epy), this.epz.getName()});
            if (this.eqd != null) {
                this.eqd.e(this.epy, false);
            }
        } else {
            v.d("MicroMsg.exdevice.BluetoothLESimpleSession", "write property is needed. but current property is %d, mac=%s, name=%s", new Object[]{Integer.valueOf(i), com.tencent.mm.plugin.exdevice.j.b.br(this.epy), this.epz.getName()});
            if (this.eqd != null) {
                this.eqd.e(this.epy, false);
            }
        }
    }
}
