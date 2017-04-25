package com.tencent.mm.plugin.c.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public final class a {
    public static final UUID esl = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    public static final UUID esm = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    public BluetoothAdapter eoz;
    public HashMap<Long, b> epg = new HashMap();
    public a esn;
    public Context eso;
    public final BroadcastReceiver esp = new BroadcastReceiver(this) {
        final /* synthetic */ a esq;

        {
            this.esq = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                v.i("MicroMsg.exdevice.BluetoothChatManager", "------onReceive------ action  = " + action);
                BluetoothDevice bluetoothDevice;
                if ("android.bluetooth.device.action.FOUND".equals(action)) {
                    bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice.getBondState() != 12) {
                        this.esq.esn.bb(bluetoothDevice.getAddress(), bluetoothDevice.getName());
                    }
                } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                    this.esq.esn.Xl();
                } else if ("android.bluetooth.adapter.action.SCAN_MODE_CHANGED".equals(action)) {
                    a aVar;
                    switch (intent.getIntExtra("android.bluetooth.adapter.extra.SCAN_MODE", -1)) {
                        case 20:
                        case 21:
                            aVar = this.esq.esn;
                            return;
                        case 23:
                            aVar = this.esq.esn;
                            return;
                        default:
                            return;
                    }
                } else if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
                    String address = ((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress();
                    if (this.esq.epg.containsKey(Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.sE(address)))) {
                        v.i("MicroMsg.exdevice.BluetoothChatManager", "------ACTION_ACL_DISCONNECTED------ device name = %s, device Mac = %s", new Object[]{bluetoothDevice.getName(), address});
                        if (this.esq.esn != null) {
                            this.esq.esn.d(com.tencent.mm.plugin.exdevice.j.b.sE(address), false);
                        }
                    }
                }
            }
        }
    };
    private Runnable lv;
    public ac mHandler;
    public boolean mIsInit = false;

    public static abstract class a {
        public void d(long j, long j2, long j3) {
        }

        public void bb(String str, String str2) {
        }

        public void Xl() {
        }

        public void d(long j, boolean z) {
        }

        public void b(long j, byte[] bArr) {
        }

        public void e(long j, boolean z) {
        }

        public void b(long j, int i, String str) {
        }
    }

    private final class b implements Runnable {
        private long epr = 0;
        private long eps = 0;
        final /* synthetic */ a esq;

        public b(a aVar, long j, long j2) {
            this.esq = aVar;
            this.epr = j;
            this.eps = j2;
        }

        public final void run() {
            a aVar = this.esq;
            b bVar = new b(this.epr);
            long j = bVar.epy;
            b bVar2 = (b) aVar.epg.remove(Long.valueOf(j));
            if (bVar2 != null) {
                bVar2.disconnect();
            }
            aVar.epg.put(Long.valueOf(j), bVar);
            if (this.esq.esn != null) {
                this.esq.esn.d(j, this.epr, this.eps);
            }
        }
    }

    public a(ad adVar) {
        this.mHandler = new ac(adVar.htb.getLooper());
        this.lv = new Runnable(this) {
            final /* synthetic */ a esq;

            {
                this.esq = r1;
            }

            public final void run() {
                if (this.esq.eoz.isDiscovering()) {
                    this.esq.eoz.cancelDiscovery();
                }
            }
        };
    }

    public final boolean Xu() {
        Assert.assertTrue(this.mIsInit);
        if (this.eoz == null) {
            return false;
        }
        return true;
    }

    private boolean Xv() {
        if (!this.eoz.isDiscovering()) {
            return true;
        }
        if (this.eoz.cancelDiscovery()) {
            this.mHandler.removeCallbacks(this.lv);
            return true;
        }
        v.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.cancelDiscovery Failed!!!");
        return false;
    }

    public final boolean bY(boolean z) {
        v.i("MicroMsg.exdevice.BluetoothChatManager", "scanDevices" + (z ? "true" : "false"));
        Assert.assertTrue(this.mIsInit);
        if (!Xu()) {
            v.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
            return false;
        } else if (!z) {
            return Xv();
        } else {
            if (this.eoz.isDiscovering() && !Xv()) {
                return false;
            }
            if (this.eoz.startDiscovery()) {
                this.mHandler.postDelayed(this.lv, 10000);
                return true;
            }
            v.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.startDiscovery() Failed");
            return false;
        }
    }
}
