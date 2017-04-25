package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.protocal.c.akf;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;

public final class x {

    public static class a extends c implements com.tencent.mm.protocal.l.a {
        public ake lXs = new ake();

        public final byte[] zf() {
            return this.lXs.toByteArray();
        }

        public final int zg() {
            return 138;
        }

        public final int getCmdId() {
            return 121;
        }
    }

    public static class b extends d implements com.tencent.mm.protocal.l.b {
        public akf lXt = new akf();

        public final int y(byte[] bArr) {
            this.lXt = (akf) new akf().az(bArr);
            return this.lXt.mcj;
        }

        public final int getCmdId() {
            return 1000000121;
        }
    }
}
