package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.protocal.c.alf;

public final class f {
    public double aIl;
    public double aIm;
    public String gYP;
    public String gYQ;
    public String gYR;
    public String gYS;
    public String gYT;
    public String gYU;
    public String gYV;
    public String gYW;
    public String gYX;
    public String gYY;
    public Addr gYZ;
    public String mName;
    public int type;

    public f(alf com_tencent_mm_protocal_c_alf) {
        this.mName = com_tencent_mm_protocal_c_alf.gkB;
        this.gYP = com_tencent_mm_protocal_c_alf.mMa;
        this.aIm = com_tencent_mm_protocal_c_alf.mhY;
        this.aIl = com_tencent_mm_protocal_c_alf.mhZ;
        this.gYQ = com_tencent_mm_protocal_c_alf.mMb;
        this.gYR = com_tencent_mm_protocal_c_alf.mFI;
        this.gYS = com_tencent_mm_protocal_c_alf.mMc;
        this.gYT = com_tencent_mm_protocal_c_alf.cHd;
        this.gYU = com_tencent_mm_protocal_c_alf.cHe;
        this.gYV = com_tencent_mm_protocal_c_alf.moE;
        this.gYW = com_tencent_mm_protocal_c_alf.moF;
        this.gYX = com_tencent_mm_protocal_c_alf.mMd;
        this.gYZ = new Addr();
        this.gYZ.cJf = this.gYP;
        this.gYZ.cJi = this.gYU;
        this.gYZ.cJj = this.gYU;
        this.gYZ.cJk = this.gYV;
        this.gYZ.cJm = this.gYX;
        this.gYZ.cJp = this.mName;
        this.gYZ.cJh = this.gYT;
        this.gYZ.cJr = (float) com_tencent_mm_protocal_c_alf.mhY;
        this.gYZ.cJq = (float) com_tencent_mm_protocal_c_alf.mhZ;
        this.type = 0;
    }
}
