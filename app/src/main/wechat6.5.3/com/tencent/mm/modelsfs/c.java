package com.tencent.mm.modelsfs;

import java.io.FileOutputStream;

public final class c extends FileOutputStream {
    private a cXM;

    public c(String str, String str2) {
        super(str);
        this.cXM = new a(str2);
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
}
