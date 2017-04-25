package com.tencent.mm.plugin.c.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.c.a.c.c.a;
import com.tencent.mm.plugin.c.a.c.c.c;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.v;

public final class b {
    public long epy;
    public BluetoothDevice epz;
    public long esr;
    public a ess = null;
    public com.tencent.mm.plugin.c.a.c.c.b est = null;
    public c esu = null;
    public int mState = 0;

    public b(long j) {
        this.esr = j;
        this.epy = j;
        this.epz = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(com.tencent.mm.plugin.c.a.e.a.aL(j));
    }

    public final void disconnect() {
        v.i("MicroMsg.exdevice.BluetoothChatSession", "disconnect");
        this.mState = 0;
        if (this.ess != null) {
            this.ess.disconnect();
            this.ess = null;
        }
        if (this.est != null) {
            this.est.cancel();
            e.H(this.est);
            this.est = null;
        }
        if (this.esu != null) {
            this.esu.cancel();
            e.H(this.est);
            this.esu = null;
        }
    }
}
