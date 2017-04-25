package com.tencent.mm.b;

import com.tencent.smtt.sdk.WebView;

public final class l implements Cloneable {
    int value;

    public l(byte[] bArr) {
        this(bArr, (byte) 0);
    }

    private l(byte[] bArr, byte b) {
        this.value = (bArr[1] << 8) & 65280;
        this.value += bArr[0] & WebView.NORMAL_MODE_ALPHA;
    }

    public l(int i) {
        this.value = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof l) && this.value == ((l) obj).value) {
            return true;
        }
        return false;
    }

    public final byte[] getBytes() {
        return new byte[]{(byte) (this.value & WebView.NORMAL_MODE_ALPHA), (byte) ((this.value & 65280) >> 8)};
    }

    public final int hashCode() {
        return this.value;
    }
}
