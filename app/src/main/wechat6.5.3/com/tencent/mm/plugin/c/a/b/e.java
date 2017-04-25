package com.tencent.mm.plugin.c.a.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.tencent.mm.plugin.c.a.b.a.c;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(18)
public final class e {
    public Context aHq;
    a epR;
    private ReentrantLock epS;
    public HashSet<Long> epT;
    final HashMap<Long, Boolean> epU;
    public com.tencent.mm.plugin.c.a.b.f.a epV;
    public final HashMap<Long, f> epg;
    public c epi;
    public com.tencent.mm.plugin.c.a.b.c.a epl;
    public Runnable lv;
    public ac mHandler;

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ e epW;
        final /* synthetic */ long eqb;
        final /* synthetic */ f eqc;

        public AnonymousClass4(e eVar, long j, f fVar) {
            this.epW = eVar;
            this.eqb = j;
            this.eqc = fVar;
        }

        public final void run() {
            this.epW.epg.put(Long.valueOf(this.eqb), this.eqc);
        }
    }

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ e epW;
        final /* synthetic */ long eqb;

        public AnonymousClass5(e eVar, long j) {
            this.epW = eVar;
            this.eqb = j;
        }

        public final void run() {
            f fVar = (f) this.epW.epg.remove(Long.valueOf(this.eqb));
            if (fVar != null) {
                v.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------close------, mac=%s, name=%s", new Object[]{b.br(fVar.epy), fVar.epz.getName()});
                if (!fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(2))) {
                    v.e("MicroMsg.exdevice.BluetoothLESimpleSession", "SendMessage Failed!!! MessageWhat = %d", new Object[]{Integer.valueOf(2)});
                }
                this.epW.epU.put(Long.valueOf(this.eqb), Boolean.valueOf(true));
                return;
            }
            v.w("MicroMsg.exdevice.BluetoothLESimpleManager", "session not found! maybe ui don't handle session disconnect event correctly.");
        }
    }

    public static abstract class a {
        public void a(long j, boolean z, long j2) {
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

    public e(a aVar) {
        this.aHq = null;
        this.epS = new ReentrantLock();
        this.mHandler = null;
        this.lv = null;
        this.epl = new com.tencent.mm.plugin.c.a.b.c.a(this) {
            final /* synthetic */ e epW;

            {
                this.epW = r1;
            }

            public final void a(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                long sE = b.sE(bluetoothDevice.getAddress());
                if (!this.epW.epT.contains(Long.valueOf(sE))) {
                    v.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscover------ device Name = %s, mac = %s(%d), scanRecord = %s", new Object[]{bluetoothDevice.getName(), bluetoothDevice.getAddress(), Long.valueOf(sE), b.ak(bArr)});
                    this.epW.epT.add(Long.valueOf(sE));
                    if (c.ac(bArr)) {
                        this.epW.epR.a(bluetoothDevice.getAddress(), bluetoothDevice.getName(), i, bArr);
                    }
                }
            }

            public final void Xl() {
                v.d("MicroMsg.exdevice.BluetoothLESimpleManager", "------onDiscoverFinished------");
                if (this.epW.epR != null) {
                    this.epW.epR.Xl();
                } else {
                    v.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no SimpleBLEManagerCallback");
                }
                this.epW.epT.clear();
            }
        };
        this.epT = new HashSet();
        this.epg = new HashMap();
        this.epU = new HashMap();
        this.epV = new com.tencent.mm.plugin.c.a.b.f.a(this) {
            final /* synthetic */ e epW;

            {
                this.epW = r1;
            }

            public final void a(long j, boolean z, long j2) {
                String str = "MicroMsg.exdevice.BluetoothLESimpleManager";
                String str2 = "onConnected. mac = %s, connected = %s";
                Object[] objArr = new Object[2];
                objArr[0] = b.br(j);
                objArr[1] = z ? "true" : "false";
                v.d(str, str2, objArr);
                final long j3 = j;
                final boolean z2 = z;
                final long j4 = j2;
                this.epW.j(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 eqa;

                    public final void run() {
                        f fVar = (f) this.eqa.epW.epg.get(Long.valueOf(j3));
                        Boolean.valueOf(false);
                        if (z2) {
                            boolean z = false;
                        } else {
                            int i = 1;
                        }
                        if (fVar == null && i == 0) {
                            v.e("MicroMsg.exdevice.BluetoothLESimpleManager", "no seesion(mac=%s) found", new Object[]{b.br(j3)});
                            return;
                        }
                        if (this.eqa.epW.epR != null) {
                            this.eqa.epW.epR.a(j3, z2, j4);
                            if (i != 0) {
                                v.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnected, mBLEManagerCallback callback mac=%s", new Object[]{b.br(j3)});
                            }
                        }
                        if (i != 0) {
                            v.d("MicroMsg.exdevice.BluetoothLESimpleManager", "remove seesion(mac=%s)", new Object[]{b.br(j3)});
                            this.eqa.epW.epg.remove(Long.valueOf(j3));
                            this.eqa.epW.epU.remove(Long.valueOf(j3));
                        }
                    }
                });
                v.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session size = %d", new Object[]{Integer.valueOf(this.epW.epg.size())});
            }

            public final void b(long j, byte[] bArr) {
                v.d("MicroMsg.exdevice.BluetoothLESimpleManager", "onRecv. mac = %s", new Object[]{b.br(j)});
                if (this.epW.epR != null) {
                    this.epW.epR.b(j, bArr);
                } else {
                    v.w("MicroMsg.exdevice.BluetoothLESimpleManager", "no BLEManagerCallback");
                }
            }

            public final void e(long j, boolean z) {
                String str = "MicroMsg.exdevice.BluetoothLESimpleManager";
                String str2 = "onSend. mac = %s, success = %s";
                Object[] objArr = new Object[2];
                objArr[0] = b.br(j);
                objArr[1] = z ? "true" : "false";
                v.d(str, str2, objArr);
                if (this.epW.epR != null) {
                    this.epW.epR.e(j, z);
                }
            }
        };
        this.aHq = aa.getContext();
        this.epR = aVar;
        this.epi = c.Xm();
        this.lv = new Runnable(this) {
            final /* synthetic */ e epW;

            {
                this.epW = r1;
            }

            public final void run() {
                this.epW.epi.a(false, this.epW.epl);
                v.i("MicroMsg.exdevice.BluetoothLESimpleManager", "Time out for discovering. Stop it");
            }
        };
        this.mHandler = new ac(new ad("BluetoothLESimpleManagerThread").htb.getLooper());
    }

    public final void j(Runnable runnable) {
        this.epS.lock();
        runnable.run();
        this.epS.unlock();
    }

    @TargetApi(18)
    public final boolean Xk() {
        return this.aHq.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }
}
