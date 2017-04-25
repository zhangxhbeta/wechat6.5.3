package com.tencent.mm.pluginsdk.k.a.b;

import java.io.IOException;

public final class e extends IOException {
    public final int httpStatusCode;
    public final IOException lEc;

    public e(int i, IOException iOException) {
        this.httpStatusCode = i;
        this.lEc = iOException;
    }
}
