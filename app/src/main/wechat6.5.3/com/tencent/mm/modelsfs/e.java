package com.tencent.mm.modelsfs;

public final class e extends SFSOutputStream {
    private a cXM;

    public e(long j, String str) {
        super(j);
        this.cXM = new a(str);
    }

    public final void write(int i) {
        super.write(i);
    }

    public final void write(byte[] bArr, int i, int i2) {
        this.cXM.j(bArr, i2);
        super.write(bArr, i, i2);
    }

    public final void close() {
        super.close();
        if (this.cXM != null) {
            this.cXM.free();
        }
    }

    protected final void finalize() {
        super.finalize();
    }
}
