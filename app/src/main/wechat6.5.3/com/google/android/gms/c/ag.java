package com.google.android.gms.c;

import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ag<T extends ag> {
    public final ah ayU;
    protected final ae ayV;
    private final List<Object> ayW = new ArrayList();

    public ag(ah ahVar, v vVar) {
        w.Z(ahVar);
        this.ayU = ahVar;
        ae aeVar = new ae(this, vVar);
        aeVar.ayR = true;
        this.ayV = aeVar;
    }

    public void a(ae aeVar) {
    }

    public ae iR() {
        ae kW = this.ayV.kW();
        kZ();
        return kW;
    }

    public final ae kX() {
        return this.ayV;
    }

    public final List<ai> kY() {
        return this.ayV.ayT;
    }

    public final void kZ() {
        Iterator it = this.ayW.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
