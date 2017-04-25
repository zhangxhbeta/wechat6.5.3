package com.tencent.mm.plugin.c.a.a;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class g extends j {
    private byte eoR = (byte) 0;

    final boolean aa(byte[] bArr) {
        if (be.bl(bArr)) {
            v.e("MicroMsg.exdevice.IBeaconTLVSectionA", "valueByte is null or nil");
            return false;
        } else if (2 != this.mLength) {
            v.d("MicroMsg.exdevice.IBeaconTLVSectionA", "IBEACON_TLV_SECTION_A_LENGTH != mLength(%d)", new Object[]{Integer.valueOf(this.mLength)});
            return false;
        } else {
            this.eoR = bArr[0];
            return true;
        }
    }
}
