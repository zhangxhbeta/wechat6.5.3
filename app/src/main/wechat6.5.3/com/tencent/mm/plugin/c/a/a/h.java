package com.tencent.mm.plugin.c.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Arrays;

public final class h extends j {
    private static final byte[] eoS = new byte[]{(byte) 76, (byte) 0, (byte) 2, (byte) 21};
    private byte[] eoT = null;
    public byte[] eoU = null;
    public short eoV = (short) -1;
    public short eoW = (short) -1;
    public int eoX = 0;

    final boolean aa(byte[] bArr) {
        if (be.bl(bArr)) {
            v.e("MicroMsg.exdevice.IBeaconTLVSectionB", "valueByte is null or nil");
            return false;
        } else if (26 != this.mLength) {
            v.d("MicroMsg.exdevice.IBeaconTLVSectionB", "IBEACON_TLV_SECTION_B_LENGTH != mLength(%d) ", new Object[]{Integer.valueOf(this.mLength)});
            return false;
        } else {
            a aVar = new a(bArr.length);
            aVar.v(bArr, bArr.length);
            byte[] bArr2 = new byte[4];
            aVar.u(bArr2, 4);
            if (Arrays.equals(bArr2, eoS)) {
                this.eoT = bArr2;
                this.eoU = new byte[16];
                aVar.u(this.eoU, 16);
                try {
                    this.eoV = aVar.readShort();
                    this.eoW = aVar.readShort();
                    bArr2 = new byte[1];
                    aVar.u(bArr2, 1);
                    this.eoX = bArr2[0];
                    return true;
                } catch (Throwable e) {
                    v.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Read major/minor from autobuffer failed!!!");
                    v.a("MicroMsg.exdevice.IBeaconTLVSectionB", e, "", new Object[0]);
                    return false;
                }
            }
            v.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Cannot find ibeacon cookies!!!");
            return false;
        }
    }
}
