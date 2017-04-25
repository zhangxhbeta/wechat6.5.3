package com.tencent.mm.plugin.backup.movemodel;

public final class a implements Cloneable, Comparable<a> {
    public long beE;
    public long dnm;
    public String username;

    public final /* synthetic */ Object clone() {
        return Wg();
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        a aVar = (a) obj;
        if (this.beE < aVar.beE) {
            return 1;
        }
        return this.beE > aVar.beE ? -1 : 0;
    }

    public final a Wg() {
        a aVar = new a();
        aVar.username = this.username;
        aVar.beE = this.beE;
        aVar.dnm = this.dnm;
        return aVar;
    }
}
