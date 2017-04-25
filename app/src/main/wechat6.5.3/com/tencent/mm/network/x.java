package com.tencent.mm.network;

import com.tencent.mm.a.n;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class x {
    private static final byte[] dml = n.cE(7);
    public l dmm;

    public final void onPush(int i, byte[] bArr) {
        v.i("MicroMsg.MMNativeNetNotifyAdapter", "onNotify, datalen=" + (bArr == null ? 0 : bArr.length) + " cmd= " + i);
        switch (i) {
            case 5:
                v.i("MicroMsg.MMNativeNetNotifyAdapter", "old notify");
                this.dmm.d(138, dml);
                return;
            case 8:
                if (bArr.length > 0) {
                    this.dmm.d(10, bArr);
                    return;
                }
                return;
            case 24:
                v.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush new notify [%s]", be.bk(bArr));
                this.dmm.d(138, bArr);
                return;
            case 39:
                v.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do synccheck");
                this.dmm.d(39, null);
                return;
            case 61:
                this.dmm.d(174, bArr);
                return;
            case 120:
                v.i("MicroMsg.MMNativeNetNotifyAdapter", "MM_PKT_VOIP_REQ");
                if (bArr.length > 0) {
                    this.dmm.d(120, bArr);
                    return;
                }
                return;
            case 122:
                v.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush MM_PKT_PUSH_DATA_REQ");
                if (bArr.length > 0) {
                    this.dmm.d(268369921, bArr);
                    return;
                }
                return;
            case 192:
                this.dmm.d(192, bArr);
                return;
            case 241:
                v.i("MicroMsg.MMNativeNetNotifyAdapter", "jacks do voice notify PUSH");
                this.dmm.d(241, bArr);
                return;
            case 244:
                v.i("MicroMsg.MMNativeNetNotifyAdapter", "pandy do gamesync notify");
                this.dmm.d(244, bArr);
                return;
            case 311:
                v.i("MicroMsg.MMNativeNetNotifyAdapter", "on notify F2F data");
                this.dmm.d(311, bArr);
                return;
            case 318:
                v.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on silence notify");
                this.dmm.d(318, bArr);
                return;
            case 319:
                v.i("MicroMsg.MMNativeNetNotifyAdapter", "hy: on notify new year shake");
                this.dmm.d(319, bArr);
                return;
            case 268369923:
                v.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do oob do notify");
                this.dmm.d(268369923, bArr);
                return;
            case 1000000205:
                this.dmm.d(1000000205, bArr);
                return;
            case 2147480001:
                v.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush GCM notify [%s]", be.bk(bArr));
                this.dmm.d(2147480001, bArr);
                return;
            default:
                return;
        }
    }
}
