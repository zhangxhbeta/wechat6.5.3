package com.tencent.mm.plugin.sns.data;

public final class h {
    public String bdZ = "";
    public String desc = "";
    public int fileSize = 0;
    public int height = -1;
    public int jdS = 0;
    public int jdT;
    public int jdU;
    public int jdV;
    public String jdW = "";
    public String jdX = "";
    public String jdY = "";
    public String path = "";
    public int type;
    public int width = -1;

    public h(String str, int i) {
        this.path = str;
        this.type = i;
        this.jdV = -1;
    }

    public h(int i, int i2) {
        this.jdV = i;
        this.type = i2;
        this.path = "";
    }
}
