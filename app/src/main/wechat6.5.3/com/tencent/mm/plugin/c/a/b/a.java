package com.tencent.mm.plugin.c.a.b;

import android.bluetooth.BluetoothGattCharacteristic;

public final class a {
    private int epa = 20;
    private byte[] epb = null;
    private int epc = 0;
    private int epd = 0;
    BluetoothGattCharacteristic epe = null;

    public final void setData(byte[] bArr) {
        if (bArr == null) {
            this.epb = null;
            this.epd = 0;
            this.epc = 0;
            return;
        }
        this.epb = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.epb, 0, bArr.length);
        this.epd = bArr.length;
        this.epc = 0;
    }

    public final byte[] Xi() {
        int i = this.epd - this.epc;
        if (i == 0) {
            return null;
        }
        if (i >= this.epa) {
            i = this.epa;
        }
        Object obj = new byte[i];
        System.arraycopy(this.epb, this.epc, obj, 0, i);
        this.epc = i + this.epc;
        return obj;
    }
}
