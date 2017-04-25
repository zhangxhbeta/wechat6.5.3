package com.tencent.mm.plugin.mmsight.segment.mp.inner;

import java.io.File;

public final class c implements i {
    private File dAr;
    private File htH;

    public c(File file) {
        this.dAr = file;
    }

    public final g aBc() {
        g gVar = new g();
        gVar.setDataSource(this.dAr.getAbsolutePath());
        return gVar;
    }

    public final g aBd() {
        if (this.htH == null) {
            return null;
        }
        g gVar = new g();
        gVar.setDataSource(this.htH.getAbsolutePath());
        return gVar;
    }
}
