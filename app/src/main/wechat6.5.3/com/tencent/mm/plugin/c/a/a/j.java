package com.tencent.mm.plugin.c.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.v;

public abstract class j {
    protected byte eoY = (byte) 0;
    protected byte[] eoZ = null;
    protected int mLength = -1;

    abstract boolean aa(byte[] bArr);

    public final boolean a(a aVar) {
        if (aVar.getSize() == 0) {
            v.w("MicroMsg.exdevice.TLVBase", "autoBuffer is null or nil");
            return false;
        }
        byte[] bArr = new byte[1];
        aVar.u(bArr, 1);
        byte b = bArr[0];
        if (b + 1 > aVar.getSize()) {
            v.w("MicroMsg.exdevice.TLVBase", "lengthInt(%d) + 1 > autoBuffer.getSize()(%d)", new Object[]{Integer.valueOf(b), Integer.valueOf(aVar.getSize())});
            return false;
        } else if (b <= (byte) 1) {
            v.w("MicroMsg.exdevice.TLVBase", "length(%d) <= 1", new Object[]{Integer.valueOf(b)});
            return false;
        } else {
            this.mLength = b;
            aVar.u(bArr, 1);
            this.eoY = bArr[0];
            this.eoZ = new byte[(this.mLength - 1)];
            aVar.u(this.eoZ, this.eoZ.length);
            return aa(this.eoZ);
        }
    }
}
