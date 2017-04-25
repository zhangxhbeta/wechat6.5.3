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
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.UUID;
import junit.framework.Assert;

@TargetApi(18)
public final class d {
    private int cLr;
    private BluetoothAdapter eoz;
    Context epA;
    BluetoothGatt epB;
    b epC;
    BluetoothGattCharacteristic epD;
    BluetoothGattCharacteristic epE;
    a epF;
    Runnable epG;
    Runnable epH;
    Runnable epI;
    d epJ;
    final LinkedList<byte[]> epK;
    volatile boolean epL;
    private HandlerThread epM;
    int epN;
    final BluetoothGattCallback epO;
    long epy;
    BluetoothDevice epz;
    public ac mHandler;

    private static class a extends ac {
        private final WeakReference<d> epQ;

        public a(Looper looper, d dVar) {
            super(looper);
            this.epQ = new WeakReference(dVar);
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            d dVar = (d) this.epQ.get();
            if (dVar == null) {
                v.e("MicroMsg.exdevice.BluetoothLESession", "null == BluetoothLESession");
                return;
            }
            byte[] Xi;
            int i;
            int i2;
            switch (message.what) {
                case 0:
                    v.i("MicroMsg.exdevice.BluetoothLESession", "------connectImp------");
                    if (1 == dVar.epN) {
                        v.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connected !!!");
                        return;
                    } else if (dVar.epN == 0) {
                        v.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connecting !!!");
                        return;
                    } else {
                        dVar.Xn();
                        if (dVar.epB == null) {
                            dVar.epB = dVar.epz.connectGatt(dVar.epA, false, dVar.epO);
                            if (dVar.epB == null) {
                                v.e("MicroMsg.exdevice.BluetoothLESession", "mDevice.connectGatt Failed!!!");
                                if (dVar.epC != null) {
                                    dVar.epC.epf.d(dVar.epy, false);
                                    return;
                                }
                                return;
                            }
                            dVar.epN = 0;
                            dVar.mHandler.postDelayed(dVar.epI, 10000);
                            return;
                        } else if (dVar.epB.connect()) {
                            dVar.epN = 0;
                            dVar.mHandler.postDelayed(dVar.epI, 10000);
                            return;
                        } else {
                            v.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.connect() Failed!!!");
                            if (dVar.epC != null) {
                                dVar.epC.epf.d(dVar.epy, false);
                                return;
                            }
                            return;
                        }
                    }
                case 1:
                    v.i("MicroMsg.exdevice.BluetoothLESession", "------disconnectImp------");
                    if (3 == dVar.epN) {
                        v.w("MicroMsg.exdevice.BluetoothLESession", "diconnect or close is called aready, just leave");
                        return;
                    }
                    dVar.Xn();
                    if (dVar.epB == null) {
                        v.e("MicroMsg.exdevice.BluetoothLESession", "disconnect:BluetoothGatt not found");
                        return;
                    }
                    dVar.epN = 3;
                    dVar.mHandler.removeCallbacks(dVar.epI);
                    dVar.mHandler.removeCallbacks(dVar.epH);
                    dVar.epB.disconnect();
                    return;
                case 2:
                    v.i("MicroMsg.exdevice.BluetoothLESession", "------closeImp------");
                    if (3 == dVar.epN) {
                        v.w("MicroMsg.exdevice.BluetoothLESession", "Close aready, Just leave");
                        return;
                    }
                    dVar.Xn();
                    if (dVar.epB == null) {
                        v.w("MicroMsg.exdevice.BluetoothLESession", "close:BluetoothGatt not found");
                        return;
                    }
                    dVar.epN = 3;
                    dVar.epB.disconnect();
                    dVar.epB.close();
                    dVar.epB = null;
                    return;
                case 3:
                    v.i("MicroMsg.exdevice.BluetoothLESession", "------writeDataAsync------ length = %d", new Object[]{Integer.valueOf(((byte[]) message.obj).length)});
                    if (1 != dVar.epN) {
                        v.e("MicroMsg.exdevice.BluetoothLESession", "Not ready for write data, connectstate = %d", new Object[]{Integer.valueOf(dVar.epN)});
                        if (dVar.epC != null) {
                            dVar.epC.epf.e(dVar.epy, false);
                            return;
                        }
                        return;
                    }
                    boolean z2 = (dVar.epB == null || dVar.epE == null) ? false : true;
                    Assert.assertTrue(z2);
                    dVar.epK.add(Xi);
                    if (!dVar.epL) {
                        if (1 != dVar.epK.size()) {
                            z = false;
                        }
                        Assert.assertTrue(z);
                        dVar.Xo();
                        return;
                    }
                    return;
                case 4:
                    i = message.arg1;
                    String str = "MicroMsg.exdevice.BluetoothLESession";
                    String str2 = "------onConnectionStateChangeImp------ aState = %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = i == 2 ? "Connected" : "Disconnected";
                    v.i(str, str2, objArr);
                    if (i == 2) {
                        v.i("MicroMsg.exdevice.BluetoothLESession", "PHY Connected is OK, mConnectState = %d", new Object[]{Integer.valueOf(dVar.epN)});
                        if (3 == dVar.epN) {
                            v.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Leave without discover Services");
                            dVar.mHandler.removeCallbacks(dVar.epI);
                            return;
                        } else if (1 == dVar.epN) {
                            v.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Leave without discover Services");
                            dVar.mHandler.removeCallbacks(dVar.epI);
                            return;
                        } else if (dVar.epB.discoverServices()) {
                            v.i("MicroMsg.exdevice.BluetoothLESession", "start discoverServices...");
                            return;
                        } else {
                            v.e("MicroMsg.exdevice.BluetoothLESession", "discover Services start failed!!!");
                            dVar.epN = 2;
                            dVar.mHandler.removeCallbacks(dVar.epI);
                            if (dVar.epC != null) {
                                dVar.epC.epf.d(dVar.epy, false);
                                return;
                            }
                            return;
                        }
                    } else if (i == 0) {
                        v.w("MicroMsg.exdevice.BluetoothLESession", "Disconnected from GATT server.");
                        dVar.epN = 2;
                        dVar.mHandler.removeCallbacks(dVar.epI);
                        if (dVar.epC != null) {
                            dVar.epC.epf.d(dVar.epy, false);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 5:
                    BluetoothGatt bluetoothGatt = (BluetoothGatt) message.obj;
                    v.i("MicroMsg.exdevice.BluetoothLESession", "onServicesDiscoveredImp, status = %d", new Object[]{Integer.valueOf(message.arg1)});
                    if (3 == dVar.epN) {
                        v.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
                        dVar.mHandler.removeCallbacks(dVar.epI);
                        return;
                    } else if (1 == dVar.epN) {
                        v.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
                        dVar.mHandler.removeCallbacks(dVar.epI);
                        return;
                    } else if (i != 0) {
                        v.e("MicroMsg.exdevice.BluetoothLESession", "Discover services error");
                        dVar.epN = 2;
                        dVar.mHandler.removeCallbacks(dVar.epI);
                        if (dVar.epC != null) {
                            dVar.epC.epf.d(dVar.epy, false);
                            return;
                        }
                        return;
                    } else {
                        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(h.eqt));
                        if (service == null) {
                            v.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find service(with UUID 0xfee7)");
                            dVar.epN = 2;
                            dVar.mHandler.removeCallbacks(dVar.epI);
                            if (dVar.epC != null) {
                                dVar.epC.epf.d(dVar.epy, false);
                                return;
                            }
                            return;
                        }
                        dVar.epD = service.getCharacteristic(UUID.fromString(h.eqv));
                        if (dVar.epD == null) {
                            v.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec8)");
                            dVar.epN = 2;
                            dVar.mHandler.removeCallbacks(dVar.epI);
                            if (dVar.epC != null) {
                                dVar.epC.epf.d(dVar.epy, false);
                                return;
                            }
                            return;
                        }
                        dVar.epE = service.getCharacteristic(UUID.fromString(h.equ));
                        if (dVar.epE == null) {
                            v.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec7)");
                            dVar.epN = 2;
                            dVar.mHandler.removeCallbacks(dVar.epI);
                            if (dVar.epC != null) {
                                dVar.epC.epf.d(dVar.epy, false);
                                return;
                            }
                            return;
                        }
                        v.i("MicroMsg.exdevice.BluetoothLESession", "mRecvCharacteristic.getProperties = %d", new Object[]{Integer.valueOf(dVar.epD.getProperties())});
                        if ((dVar.epD.getProperties() & 32) == 0) {
                            v.e("MicroMsg.exdevice.BluetoothLESession", "Read characteristic can not be indicated");
                            dVar.epN = 2;
                            dVar.mHandler.removeCallbacks(dVar.epI);
                            if (dVar.epC != null) {
                                dVar.epC.epf.d(dVar.epy, false);
                                return;
                            }
                            return;
                        }
                        v.i("MicroMsg.exdevice.BluetoothLESession", "Set read characteristic indicator");
                        d dVar2 = dVar.epJ;
                        BluetoothGattCharacteristic bluetoothGattCharacteristic = dVar.epD;
                        if (dVar2.epB.setCharacteristicNotification(bluetoothGattCharacteristic, true)) {
                            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(h.eqs));
                            if (descriptor == null) {
                                v.e("MicroMsg.exdevice.BluetoothLESession", "Can not get configure descriptor");
                                z = false;
                            } else {
                                v.i("MicroMsg.exdevice.BluetoothLESession", "Configure descriptor permissions: " + descriptor.getPermissions());
                                if (!descriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE)) {
                                    v.e("MicroMsg.exdevice.BluetoothLESession", "Can not set configure descriptor value");
                                    z = false;
                                } else if (dVar2.epB.writeDescriptor(descriptor)) {
                                    dVar2.mHandler.postDelayed(dVar2.epH, 5000);
                                } else {
                                    v.e("MicroMsg.exdevice.BluetoothLESession", "Can not write configure descriptor value");
                                    z = false;
                                }
                            }
                        } else {
                            v.e("MicroMsg.exdevice.BluetoothLESession", "Unable to set indicator for read characteristic");
                            z = false;
                        }
                        if (!z) {
                            v.e("MicroMsg.exdevice.BluetoothLESession", "mSelfSession.setCharacteristicNotification Failed!!!");
                            dVar.epN = 2;
                            dVar.mHandler.removeCallbacks(dVar.epI);
                            if (dVar.epC != null) {
                                dVar.epC.epf.d(dVar.epy, false);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                case 6:
                    Object obj = message.obj;
                    v.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWriteImp------ status = %d", new Object[]{Integer.valueOf(message.arg1)});
                    dVar.mHandler.removeCallbacks(dVar.epH);
                    dVar.mHandler.removeCallbacks(dVar.epI);
                    if (3 == dVar.epN) {
                        v.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
                        return;
                    } else if (1 == dVar.epN) {
                        v.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
                        return;
                    } else if (i2 != 0) {
                        v.e("MicroMsg.exdevice.BluetoothLESession", "Write configure descriptor error");
                        dVar.epN = 2;
                        if (dVar.epC != null) {
                            dVar.epC.epf.d(dVar.epy, false);
                            return;
                        }
                        return;
                    } else {
                        dVar.epN = 1;
                        if (dVar.epC != null) {
                            dVar.epC.epf.d(dVar.epy, true);
                        }
                        v.i("MicroMsg.exdevice.BluetoothLESession", "------BLE connect successfully------ mConnectState = %d", new Object[]{Integer.valueOf(dVar.epN)});
                        return;
                    }
                case 7:
                    i2 = message.arg1;
                    v.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallbackImp------ status = %d", new Object[]{Integer.valueOf(i2)});
                    dVar.mHandler.removeCallbacks(dVar.epG);
                    if (i2 != 0) {
                        v.e("MicroMsg.exdevice.BluetoothLESession", "write data error: " + i2);
                        if (dVar.epC != null) {
                            dVar.epC.epf.e(dVar.epy, false);
                        }
                        dVar.Xo();
                        return;
                    }
                    Xi = dVar.epF.Xi();
                    v.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[]{b.ak(Xi)});
                    if (Xi == null) {
                        v.i("MicroMsg.exdevice.BluetoothLESession", "write data complete");
                        if (dVar.epC != null) {
                            dVar.epC.epf.e(dVar.epy, true);
                        }
                        dVar.Xo();
                        return;
                    }
                    v.i("MicroMsg.exdevice.BluetoothLESession", "write next chunk...");
                    dVar.epE.setValue(Xi);
                    dVar.epB.writeCharacteristic(dVar.epE);
                    dVar.mHandler.postDelayed(dVar.epG, 5000);
                    return;
                case 8:
                    Xi = (byte[]) message.obj;
                    v.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceiveImp------");
                    if (be.bl(Xi)) {
                        v.e("MicroMsg.exdevice.BluetoothLESession", "Receive data is null or nil");
                        return;
                    }
                    String w = b.w(Xi, Xi.length);
                    v.i("MicroMsg.exdevice.BluetoothLESession", "data length = %d", new Object[]{Integer.valueOf(Xi.length)});
                    v.d("MicroMsg.exdevice.BluetoothLESession", "data dump = %s", new Object[]{w});
                    if (dVar.epC != null) {
                        dVar.epC.epf.b(dVar.epy, Xi);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @TargetApi(18)
    public d(long j, Context context, b bVar) {
        this.epK = new LinkedList();
        this.epL = false;
        this.epO = new BluetoothGattCallback(this) {
            final /* synthetic */ d epP;

            {
                this.epP = r1;
            }

            public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                v.i("MicroMsg.exdevice.BluetoothLESession", "------onConnectionStateChange------ connect newState = %d, op status = %d, mConnectState = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(this.epP.epN)});
                if (!this.epP.mHandler.sendMessage(this.epP.mHandler.obtainMessage(4, i2, 0))) {
                    v.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(4)});
                }
            }

            public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                v.i("MicroMsg.exdevice.BluetoothLESession", "------onServicesDiscovered------ status = %d", new Object[]{Integer.valueOf(i)});
                if (!this.epP.mHandler.sendMessage(this.epP.mHandler.obtainMessage(5, i, 0, bluetoothGatt))) {
                    v.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(5)});
                }
            }

            public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                v.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWrite------ status = %d", new Object[]{Integer.valueOf(i)});
                if (!this.epP.mHandler.sendMessage(this.epP.mHandler.obtainMessage(6, i, 0, bluetoothGatt))) {
                    v.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(6)});
                }
            }

            public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                v.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceive------");
                if (!this.epP.mHandler.sendMessage(this.epP.mHandler.obtainMessage(8, bluetoothGattCharacteristic.getValue()))) {
                    v.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(8)});
                }
            }

            public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                v.i("MicroMsg.exdevice.BluetoothLESession", "------onCharacteristicRead------ status = %d", new Object[]{Integer.valueOf(i)});
            }

            public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                v.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallback------ status = %d", new Object[]{Integer.valueOf(i)});
                if (!this.epP.mHandler.sendMessage(this.epP.mHandler.obtainMessage(7, i, 0))) {
                    v.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(7)});
                }
            }
        };
        this.cLr = -1;
        this.cLr = hashCode();
        this.epJ = this;
        this.epC = bVar;
        this.epA = context;
        this.eoz = ((BluetoothManager) this.epA.getSystemService("bluetooth")).getAdapter();
        this.epy = j;
        this.epN = 3;
        this.epz = this.eoz.getRemoteDevice(com.tencent.mm.plugin.c.a.e.a.aL(j));
        this.epD = null;
        this.epE = null;
        this.epF = new a();
        this.epM = e.Lg("BluetoothLESession_handlerThread");
        this.epM.start();
        this.mHandler = new a(this.epM.getLooper(), this);
        this.epG = new Runnable(this) {
            final /* synthetic */ d epP;

            {
                this.epP = r1;
            }

            public final void run() {
                v.e("MicroMsg.exdevice.BluetoothLESession", "Write data timeout");
                if (this.epP.epC != null) {
                    this.epP.epC.epf.e(this.epP.epy, false);
                }
                this.epP.Xo();
            }
        };
        this.epH = new Runnable(this) {
            final /* synthetic */ d epP;

            {
                this.epP = r1;
            }

            public final void run() {
                v.e("MicroMsg.exdevice.BluetoothLESession", "Write descriptor timeout!!!");
                if (3 == this.epP.epN) {
                    v.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
                    return;
                }
                this.epP.mHandler.removeCallbacks(this.epP.epI);
                this.epP.epN = 2;
                if (this.epP.epC != null) {
                    this.epP.epC.epf.d(this.epP.epy, false);
                }
            }
        };
        this.epI = new Runnable(this) {
            final /* synthetic */ d epP;

            {
                this.epP = r1;
            }

            public final void run() {
                v.e("MicroMsg.exdevice.BluetoothLESession", "Connected timeout!!!");
                if (3 == this.epP.epN) {
                    v.w("MicroMsg.exdevice.BluetoothLESession", "Bluetooth device is aready disconnet or close, just leave");
                    return;
                }
                this.epP.mHandler.removeCallbacks(this.epP.epH);
                this.epP.epN = 2;
                if (this.epP.epC != null) {
                    this.epP.epC.epf.d(this.epP.epy, false);
                }
            }
        };
    }

    public final boolean connect() {
        v.i("MicroMsg.exdevice.BluetoothLESession", "------connect------");
        return this.mHandler.sendMessage(this.mHandler.obtainMessage(0));
    }

    public final void close() {
        v.i("MicroMsg.exdevice.BluetoothLESession", "------close------");
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2))) {
            v.e("MicroMsg.exdevice.BluetoothLESession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(2)});
        }
        this.epM.quitSafely();
    }

    final void Xn() {
        this.epL = false;
        this.epK.clear();
    }

    final void Xo() {
        if (this.epK.isEmpty()) {
            this.epL = false;
            return;
        }
        this.epF.setData((byte[]) this.epK.pop());
        v.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[]{b.ak(this.epF.Xi())});
        this.epE.setValue(r0);
        this.mHandler.postDelayed(this.epG, 5000);
        if (!this.epB.writeCharacteristic(this.epE)) {
            v.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.writeCharacteristic Failed!!!");
        }
        this.epL = true;
    }
}
