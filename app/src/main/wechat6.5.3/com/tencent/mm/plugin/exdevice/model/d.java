package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.c.a;
import com.tencent.mm.plugin.exdevice.service.e;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.k;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.exdevice.service.w;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class d {
    private static int frW = 0;
    c frR;
    private w frS;
    HashMap<Long, ah> frT;
    HashMap<Long, ah> frU;
    HashMap<Long, Integer> frV;
    j frX = null;
    private Object frY = new Object();

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ d frZ;
        final /* synthetic */ String fsc;
        final /* synthetic */ boolean fsd;

        AnonymousClass5(d dVar, String str, boolean z) {
            this.frZ = dVar;
            this.fsc = str;
            this.fsd = z;
        }

        public final void run() {
            if (this.frZ.frR == null) {
                this.frZ.frR = new c();
                this.frZ.frR.fxm = new a(this) {
                    final /* synthetic */ AnonymousClass5 fse;

                    {
                        this.fse = r2;
                    }

                    public final void onServiceConnected() {
                        this.fse.frZ.frR.fxm = null;
                        e.ajL().V(this.fse.fsc, this.fse.fsd);
                        synchronized (this.fse.frZ.frY) {
                            this.fse.frZ.frY.notify();
                        }
                    }
                };
                this.frZ.frR.bD(aa.getContext());
                synchronized (this.frZ.frY) {
                    try {
                        this.frZ.frY.wait();
                    } catch (Throwable e) {
                        v.e("MicroMsg.exdevice.ExdeviceConnectManager", "mSyncLock.wait failed!!!, %s", new Object[]{e.getMessage()});
                        v.a("MicroMsg.exdevice.ExdeviceConnectManager", e, "", new Object[0]);
                    }
                }
                return;
            }
            e.ajL().V(this.fsc, this.fsd);
        }

        public final String toString() {
            return super.toString() + "|ranging";
        }
    }

    class AnonymousClass11 extends a {
        final /* synthetic */ d frZ;

        AnonymousClass11(d dVar, int i) {
            this.frZ = dVar;
            super(0);
        }

        public final void onServiceConnected() {
            v.d("MicroMsg.exdevice.ExdeviceConnectManager", "onServiceConnected");
        }
    }

    class AnonymousClass2 extends a {
        final /* synthetic */ d frZ;
        final /* synthetic */ j fsa;

        AnonymousClass2(d dVar, j jVar) {
            this.frZ = dVar;
            this.fsa = jVar;
            super(0);
        }

        public final void onServiceConnected() {
            if (!u.ajW().frL.a(this.fsa)) {
                v.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
            }
        }
    }

    class AnonymousClass3 extends a {
        final /* synthetic */ long eqb;
        final /* synthetic */ d frZ;
        final /* synthetic */ k fsb;

        AnonymousClass3(d dVar, long j, k kVar) {
            this.frZ = dVar;
            this.eqb = j;
            this.fsb = kVar;
            super(0);
        }

        public final void onServiceConnected() {
            if (!u.ajW().frL.a(this.eqb, this.fsb)) {
                v.e("MicroMsg.exdevice.ExdeviceConnectManager", "connect failed!!!");
            }
        }
    }

    public d() {
        if (this.frS == null) {
            this.frS = new w(this) {
                final /* synthetic */ d frZ;

                {
                    this.frZ = r1;
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void a(long r12, int r14, int r15, int r16, long r17) {
                    /*
                    r11 = this;
                    r0 = "MicroMsg.exdevice.ExdeviceConnectManager";
                    r1 = "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d";
                    r2 = 4;
                    r2 = new java.lang.Object[r2];
                    r3 = 0;
                    r4 = com.tencent.mm.plugin.exdevice.j.b.br(r12);
                    r2[r3] = r4;
                    r3 = 1;
                    r4 = java.lang.Integer.valueOf(r14);
                    r2[r3] = r4;
                    r3 = 2;
                    r4 = java.lang.Integer.valueOf(r15);
                    r2[r3] = r4;
                    r3 = 3;
                    r4 = java.lang.Integer.valueOf(r16);
                    r2[r3] = r4;
                    com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
                    r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
                    if (r0 != 0) goto L_0x0038;
                L_0x002e:
                    r0 = "MicroMsg.exdevice.ExdeviceConnectManager";
                    r1 = "MMApplicationContext is null";
                    com.tencent.mm.sdk.platformtools.v.e(r0, r1);
                L_0x0037:
                    return;
                L_0x0038:
                    r0 = 4;
                    if (r0 != r15) goto L_0x00cb;
                L_0x003b:
                    r0 = com.tencent.mm.plugin.exdevice.service.u.ajV();
                    r0.bj(r12);
                    r0 = "shut_down_device";
                    r1 = com.tencent.mm.plugin.exdevice.h.a.so(r0);
                    if (r1 == 0) goto L_0x0083;
                L_0x004b:
                    r0 = r1.length;
                    if (r0 == 0) goto L_0x0083;
                L_0x004e:
                    r2 = r1.length;
                    r0 = 0;
                L_0x0050:
                    if (r0 >= r2) goto L_0x0083;
                L_0x0052:
                    r4 = r1[r0];
                    r3 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1));
                    if (r3 != 0) goto L_0x0080;
                L_0x0058:
                    r3 = "MicroMsg.exdevice.ExdeviceConnectManager";
                    r6 = "Stop channel in the shut down device list, deviceId = %d";
                    r7 = 1;
                    r7 = new java.lang.Object[r7];
                    r8 = 0;
                    r9 = java.lang.Long.valueOf(r4);
                    r7[r8] = r9;
                    com.tencent.mm.sdk.platformtools.v.i(r3, r6, r7);
                    com.tencent.mm.plugin.exdevice.model.d.aU(r4);
                    r3 = "shut_down_device";
                    r3 = com.tencent.mm.plugin.exdevice.h.a.r(r3, r4);
                    if (r3 != 0) goto L_0x0080;
                L_0x0077:
                    r3 = "MicroMsg.exdevice.ExdeviceConnectManager";
                    r4 = "removeFromSharedPreferences failed!!!";
                    com.tencent.mm.sdk.platformtools.v.e(r3, r4);
                L_0x0080:
                    r0 = r0 + 1;
                    goto L_0x0050;
                L_0x0083:
                    r0 = r11.frZ;
                    r0 = r0.frV;
                    r1 = java.lang.Long.valueOf(r12);
                    r0 = r0.get(r1);
                    if (r0 == 0) goto L_0x00c8;
                L_0x0093:
                    r0 = "MicroMsg.exdevice.ExdeviceConnectManager";
                    r1 = "Device connect strategy(%d)";
                    r2 = 1;
                    r2 = new java.lang.Object[r2];
                    r3 = 0;
                    r4 = r11.frZ;
                    r4 = r4.frV;
                    r5 = java.lang.Long.valueOf(r12);
                    r4 = r4.get(r5);
                    r2[r3] = r4;
                    com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
                    r0 = r11.frZ;
                    r0 = r0.frV;
                    r1 = java.lang.Long.valueOf(r12);
                    r0 = r0.get(r1);
                    r0 = (java.lang.Integer) r0;
                    r0 = r0.intValue();
                    r0 = r0 & 1;
                    if (r0 > 0) goto L_0x00cb;
                L_0x00c8:
                    com.tencent.mm.plugin.exdevice.model.d.aU(r12);
                L_0x00cb:
                    if (r14 == r15) goto L_0x0037;
                L_0x00cd:
                    r0 = com.tencent.mm.plugin.exdevice.model.ac.ajq();
                    r1 = java.lang.String.valueOf(r12);
                    r0 = r0.sp(r1);
                    if (r0 == 0) goto L_0x00e3;
                L_0x00db:
                    r1 = r0.field_brandName;
                    r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
                    if (r1 == 0) goto L_0x00f8;
                L_0x00e3:
                    r0 = "MicroMsg.exdevice.ExdeviceConnectManager";
                    r1 = "get hdinfo by mac failed : %d";
                    r2 = 1;
                    r2 = new java.lang.Object[r2];
                    r3 = 0;
                    r4 = java.lang.Long.valueOf(r12);
                    r2[r3] = r4;
                    com.tencent.mm.sdk.platformtools.v.e(r0, r1, r2);
                    goto L_0x0037;
                L_0x00f8:
                    r1 = com.tencent.mm.plugin.exdevice.service.u.ajV();
                    r1 = r1.bg(r12);
                    if (r1 == 0) goto L_0x0112;
                L_0x0102:
                    r1.baO = r15;
                L_0x0104:
                    r1 = 2;
                    if (r15 != r1) goto L_0x0126;
                L_0x0107:
                    r0 = "MicroMsg.exdevice.ExdeviceConnectManager";
                    r1 = "newState = EMMACCS_connected";
                    com.tencent.mm.sdk.platformtools.v.w(r0, r1);
                    goto L_0x0037;
                L_0x0112:
                    r1 = "MicroMsg.exdevice.ExdeviceConnectManager";
                    r2 = "get connect state faild : %d";
                    r3 = 1;
                    r3 = new java.lang.Object[r3];
                    r4 = 0;
                    r5 = java.lang.Long.valueOf(r12);
                    r3[r4] = r5;
                    com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);
                    goto L_0x0104;
                L_0x0126:
                    com.tencent.mm.plugin.exdevice.model.ac.ajB();
                    r1 = r0.field_brandName;
                    r2 = r0.field_url;
                    r0 = r0.field_deviceID;
                    com.tencent.mm.plugin.exdevice.model.e.a(r1, r2, r15, r0);
                    goto L_0x0037;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.d.10.a(long, int, int, int, long):void");
                }
            };
        }
        this.frT = new HashMap();
        this.frU = new HashMap();
        this.frV = new HashMap();
    }

    public static int aiM() {
        return frW;
    }

    public final synchronized void kl(int i) {
        v.i("MicroMsg.exdevice.ExdeviceConnectManager", "setConnectMode, mode = %d", new Object[]{Integer.valueOf(i)});
        frW = i;
    }

    public final synchronized void a(Long l, int i) {
        this.frV.put(l, Integer.valueOf(i));
    }

    public final void c(String str, long j, int i) {
        a(str, j, i, false);
    }

    public final void a(String str, long j, int i, boolean z) {
        com.tencent.mm.plugin.exdevice.h.a.r("shut_down_device", j);
        final String str2;
        final long j2;
        final boolean z2;
        if (this.frR == null) {
            v.i("MicroMsg.exdevice.ExdeviceConnectManager", "Bind exdeviceService");
            this.frR = new c();
            str2 = str;
            j2 = j;
            z2 = z;
            this.frR.fxm = new a(this, i) {
                final /* synthetic */ d frZ;

                public final void onServiceConnected() {
                    this.frZ.frR.fxm = null;
                    this.frZ.b(str2, j2, this.bbf, z2);
                }
            };
            this.frR.bD(aa.getContext());
        } else if (this.frR == null || this.frR.fxn) {
            b(str, j, i, z);
        } else {
            v.i("MicroMsg.exdevice.ExdeviceConnectManager", "ExdeviceService setConnected");
            str2 = str;
            j2 = j;
            z2 = z;
            this.frR.fxm = new a(this, i) {
                final /* synthetic */ d frZ;

                public final void onServiceConnected() {
                    this.frZ.frR.fxm = null;
                    this.frZ.b(str2, j2, this.bbf, z2);
                }
            };
            this.frR.bD(aa.getContext());
        }
    }

    public final void b(String str, long j, int i, boolean z) {
        boolean d;
        v.i("MicroMsg.exdevice.ExdeviceConnectManager", "doConnect");
        if (z) {
            d = d(str, j, i);
        } else if (ak.vy().BJ() != 4) {
            v.i("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
            d = false;
        } else {
            if (this.frT.containsKey(Long.valueOf(j))) {
                v.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is connecting, reset timer : brand name = %s, deviceid = %d, bluetooth version = %d", new Object[]{str, Long.valueOf(j), Integer.valueOf(i)});
                ah ahVar = (ah) this.frT.get(Long.valueOf(j));
                ahVar.QI();
                ahVar.ea(30000);
            } else {
                v.i("MicroMsg.exdevice.ExdeviceConnectManager", "the device is not connecting, brand name = %s, deviceid = %d, bluetooth version = %d", new Object[]{str, Long.valueOf(j), Integer.valueOf(i)});
                final long j2 = j;
                final String str2 = str;
                final int i2 = i;
                ah ahVar2 = new ah(Looper.getMainLooper(), new ah.a(this) {
                    final /* synthetic */ d frZ;

                    public final boolean oU() {
                        v.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to notify ui show the connect time out tips, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[]{str2, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(u.ajV().bf(j2))});
                        if (u.ajV().bf(j2) != 2) {
                            ac.ajB();
                            e.as(str2, 2);
                        }
                        this.frZ.frT.remove(Long.valueOf(j2));
                        return false;
                    }
                }, false);
                ahVar2.ea(30000);
                this.frT.put(Long.valueOf(j), ahVar2);
            }
            if (u.ajW().frL == null) {
                v.w("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null, Just leave, brand name is %s, device id is %d, bluetooth version is %d", new Object[]{str, Long.valueOf(j), Integer.valueOf(i)});
                d = false;
            } else {
                f.a bg = u.ajV().bg(j);
                if (bg == null) {
                    v.w("MicroMsg.exdevice.ExdeviceConnectManager", "Device unbond: %s", new Object[]{Long.valueOf(j)});
                    d = false;
                } else {
                    v.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, connectState = %d ", new Object[]{Integer.valueOf(bg.baO)});
                    if (!(bg.baO == 2 || bg.baO == 1)) {
                        u.ajW().frL.a(j, i, this.frS);
                    }
                    d = true;
                }
            }
        }
        v.i("MicroMsg.exdevice.ExdeviceConnectManager", "startChannel Ret = %s", new Object[]{Boolean.valueOf(d)});
    }

    public static void aU(long j) {
        if (u.ajW().frL != null) {
            boolean bm = u.ajW().frL.bm(j);
            v.i("MicroMsg.exdevice.ExdeviceConnectManager", "now stop the devide channel : %d, result : %b", new Object[]{Long.valueOf(j), Boolean.valueOf(bm)});
        }
    }

    public final void aiN() {
        if (this.frR != null) {
            aa.getContext().unbindService(this.frR);
        }
    }

    private synchronized boolean d(String str, long j, int i) {
        boolean z;
        int BJ = ak.vy().BJ();
        if (BJ != 4 && BJ != 6) {
            v.e("MicroMsg.exdevice.ExdeviceConnectManager", "now network is not avaiable, notify directly");
            z = false;
        } else if (this.frU.containsKey(Long.valueOf(j))) {
            v.i("MicroMsg.exdevice.ExdeviceConnectManager", "now the device is syncing data : %s, %d, Just leave!!!", new Object[]{str, Long.valueOf(j)});
            z = false;
        } else {
            final long j2 = j;
            final String str2 = str;
            final int i2 = i;
            ah ahVar = new ah(Looper.getMainLooper(), new ah.a(this) {
                final /* synthetic */ d frZ;

                public final boolean oU() {
                    int bf = u.ajV().bf(j2);
                    v.i("MicroMsg.exdevice.ExdeviceConnectManager", "now it is time to check the sync connect state, brand name = %s, deviceid = %d, bluetooth version = %d, connect state = %d", new Object[]{str2, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(bf)});
                    d.aU(j2);
                    this.frZ.frU.remove(Long.valueOf(j2));
                    return false;
                }
            }, false);
            v.i("MicroMsg.exdevice.ExdeviceConnectManager", "now sync time out is : %d", new Object[]{Long.valueOf(b.akI())});
            ahVar.ea(r0);
            this.frU.put(Long.valueOf(j), ahVar);
            if (u.ajW().frL != null) {
                v.i("MicroMsg.exdevice.ExdeviceConnectManager", "start channel now : %s, %d", new Object[]{str, Long.valueOf(j)});
                z = u.ajW().frL.a(j, i, this.frS);
            } else {
                v.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMExDeviceCore.getTaskQueue().getDispatcher() == null");
                z = false;
            }
        }
        return z;
    }

    public static boolean cL(boolean z) {
        long[] ajF = u.ajW().frL.ajF();
        if (ajF == null || ajF.length <= 0 || u.ajW().frL == null) {
            v.w("MicroMsg.exdevice.ExdeviceConnectManager", "connectedDevices = null or connectedDevices.length = 0");
            return false;
        }
        for (long j : ajF) {
            v.i("MicroMsg.exdevice.ExdeviceConnectManager", "deviceId = %s", new Object[]{Long.valueOf(j)});
            com.tencent.mm.plugin.exdevice.h.b bq = ac.ajq().bq(j);
            if (bq == null) {
                v.w("MicroMsg.exdevice.ExdeviceConnectManager", "Get device info failed, deviceId = %s", new Object[]{Long.valueOf(j)});
            } else if (z && (bq.field_closeStrategy & 1) == 0) {
                v.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device is not close after exit chatting, deviceId = %s", new Object[]{Long.valueOf(j)});
            } else {
                v.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel, deviceId = %s", new Object[]{Long.valueOf(j)});
                u.ajW().frL.bm(j);
            }
        }
        return true;
    }

    public final void a(final int i, j jVar) {
        v.i("MicroMsg.exdevice.ExdeviceConnectManager", "scanLogic, bluetooth version = %d", new Object[]{Integer.valueOf(i)});
        if (jVar == null) {
            v.e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
            return;
        }
        this.frX = jVar;
        if (this.frR == null) {
            this.frR = new c();
            this.frR.fxm = new a(this, i) {
                final /* synthetic */ d frZ;

                public final void onServiceConnected() {
                    if (!u.ajW().frL.b(i, this.frZ.frX)) {
                        v.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
                    }
                }
            };
            this.frR.bD(aa.getContext());
            return;
        }
        v.i("MicroMsg.exdevice.ExdeviceConnectManager", "try start scan");
        if (u.ajW().frL == null) {
            v.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
        } else if (!u.ajW().frL.b(i, this.frX)) {
            v.e("MicroMsg.exdevice.ExdeviceConnectManager", "scan failed!!!");
        }
    }

    public final void l(final Runnable runnable) {
        v.d("MicroMsg.exdevice.ExdeviceConnectManager", "doTaskAfterServiceStarted");
        if (this.frR == null) {
            this.frR = new c();
            this.frR.fxm = new a(this) {
                final /* synthetic */ d frZ;

                public final void onServiceConnected() {
                    runnable.run();
                }
            };
            this.frR.bD(aa.getContext());
            return;
        }
        this.frR.m(runnable);
    }
}
