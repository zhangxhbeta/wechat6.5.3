package com.tencent.mm.modelsfs;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.FileInputStream;

public final class b extends FileInputStream {
    private boolean cXI = false;
    private a cXM;
    private long cXN = 0;

    public b(String str, long j) {
        super(str);
        this.cXM = new a(j);
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (this.cXI) {
            v.i("MicroMsg.EncInputStream", "read buffer  hashcode " + hashCode() + " " + be.bur().toString());
        }
        int read = super.read(bArr, i, i2);
        if (read >= 0) {
            this.cXM.j(bArr, i2);
        }
        return read;
    }

    public final long skip(long j) {
        long skip = super.skip(j);
        this.cXM.seek(j);
        return skip;
    }

    public final void close() {
        super.close();
        if (this.cXM != null) {
            this.cXM.free();
        }
        v.i("MicroMsg.EncInputStream", "close  hashcode " + hashCode());
    }

    public final void mark(int i) {
        this.cXN = this.cXM.IK();
    }

    public final void reset() {
        getChannel().position(this.cXN);
        this.cXM.reset();
    }

    public final boolean markSupported() {
        return true;
    }
}
