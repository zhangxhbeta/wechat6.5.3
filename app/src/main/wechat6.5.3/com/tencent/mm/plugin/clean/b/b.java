package com.tencent.mm.plugin.clean.b;

import java.util.ArrayList;
import java.util.Iterator;

public final class b implements Comparable<b> {
    public long beE;
    public ArrayList<a> eUn;
    public String username;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        b bVar = (b) obj;
        if (this.beE < bVar.beE) {
            return -1;
        }
        return this.beE > bVar.beE ? 1 : 0;
    }

    public final boolean adF() {
        this.beE = 0;
        Iterator it = this.eUn.iterator();
        while (it.hasNext()) {
            this.beE += ((a) it.next()).size;
        }
        if (this.eUn.size() == 0) {
            return false;
        }
        return true;
    }
}
