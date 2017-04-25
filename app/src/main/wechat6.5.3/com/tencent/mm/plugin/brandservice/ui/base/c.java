package com.tencent.mm.plugin.brandservice.ui.base;

import com.tencent.mm.plugin.brandservice.ui.c.b;
import java.util.List;

public abstract class c extends a {
    protected b eye;
    public List<String> ezU;
    protected int ezV;
    protected int position;

    public c(int i, Object obj) {
        super(i, obj);
    }

    public final void a(b bVar) {
        this.eye = bVar;
    }

    public final b YG() {
        return this.eye;
    }

    public final void iN(int i) {
        this.ezV = i;
    }

    public final int YH() {
        return this.ezV;
    }

    public final void iO(int i) {
        this.position = i;
    }

    public final int getPosition() {
        return this.position;
    }
}
