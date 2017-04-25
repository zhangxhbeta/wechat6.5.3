package com.tencent.mm.protocal;

import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.smtt.sdk.WebView;

public final class y {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public byte[] bdP = null;
        public long cSJ = -1;

        public final byte[] zf() {
            Object obj = new byte[(this.bdP.length + 8)];
            int Ni = (int) (be.Ni() - this.cSJ);
            obj[0] = (byte) ((Ni >> 24) & WebView.NORMAL_MODE_ALPHA);
            obj[1] = (byte) ((Ni >> 16) & WebView.NORMAL_MODE_ALPHA);
            obj[2] = (byte) ((Ni >> 8) & WebView.NORMAL_MODE_ALPHA);
            obj[3] = (byte) (Ni & WebView.NORMAL_MODE_ALPHA);
            obj[4] = (byte) ((this.bdP.length >> 24) & WebView.NORMAL_MODE_ALPHA);
            obj[5] = (byte) ((this.bdP.length >> 16) & WebView.NORMAL_MODE_ALPHA);
            obj[6] = (byte) ((this.bdP.length >> 8) & WebView.NORMAL_MODE_ALPHA);
            obj[7] = (byte) (this.bdP.length & WebView.NORMAL_MODE_ALPHA);
            System.arraycopy(this.bdP, 0, obj, 8, this.bdP.length);
            be.bk(obj);
            return obj;
        }

        public final int getCmdId() {
            return 1000000190;
        }

        public final int zg() {
            return 268369922;
        }

        public final boolean Cd() {
            return false;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        public final int y(byte[] bArr) {
            return 0;
        }

        public final int getCmdId() {
            return -1;
        }
    }
}
