package com.tencent.mm.plugin.wear.model;

public final class f {
    public String aZy = "";
    public String bdo = "";
    public int id = 0;
    public int lbA = 0;
    a lbB;

    public enum a {
        INIT,
        SHOWING,
        IGNORE,
        REPLY
    }

    protected final Object clone() {
        f fVar = new f();
        fVar.id = this.id;
        fVar.bdo = this.bdo;
        fVar.aZy = this.aZy;
        fVar.lbA = this.lbA;
        fVar.lbB = this.lbB;
        return fVar;
    }

    public final String toString() {
        return "WearNotification [talker=" + this.bdo + ", id=" + this.id + ", md5=" + this.aZy + ", ignoreInWatch=" + this.lbA + ", status=" + this.lbB + "]";
    }
}
