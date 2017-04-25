package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import java.util.LinkedList;

public final class auc extends aqx {
    public String bom;
    public String coN;
    public String eBK;
    public String eBM;
    public String eBN;
    public String eBO;
    public int eBR;
    public String eCD;
    public int eCZ;
    public int iOH;
    public int iOK;
    public String iOL;
    public String iOM;
    public String iON;
    public String iOO;
    public String iOP;
    public boolean iOQ;
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.mQl != null) {
                aVar.dX(1, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            aVar.dV(2, this.eCZ);
            if (this.eBK != null) {
                aVar.e(3, this.eBK);
            }
            if (this.bom != null) {
                aVar.e(4, this.bom);
            }
            if (this.title != null) {
                aVar.e(5, this.title);
            }
            if (this.eBN != null) {
                aVar.e(6, this.eBN);
            }
            if (this.eBO != null) {
                aVar.e(7, this.eBO);
            }
            if (this.eCD != null) {
                aVar.e(8, this.eCD);
            }
            if (this.eBM != null) {
                aVar.e(9, this.eBM);
            }
            if (this.coN != null) {
                aVar.e(10, this.coN);
            }
            aVar.dV(11, this.iOH);
            aVar.dV(12, this.iOK);
            if (this.iOL != null) {
                aVar.e(13, this.iOL);
            }
            if (this.iOM != null) {
                aVar.e(14, this.iOM);
            }
            if (this.iON != null) {
                aVar.e(19, this.iON);
            }
            if (this.iOO != null) {
                aVar.e(21, this.iOO);
            }
            aVar.dV(22, this.eBR);
            if (this.iOP != null) {
                aVar.e(23, this.iOP);
            }
            aVar.ab(24, this.iOQ);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.eCZ);
            if (this.eBK != null) {
                r0 += a.a.a.b.b.a.f(3, this.eBK);
            }
            if (this.bom != null) {
                r0 += a.a.a.b.b.a.f(4, this.bom);
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(5, this.title);
            }
            if (this.eBN != null) {
                r0 += a.a.a.b.b.a.f(6, this.eBN);
            }
            if (this.eBO != null) {
                r0 += a.a.a.b.b.a.f(7, this.eBO);
            }
            if (this.eCD != null) {
                r0 += a.a.a.b.b.a.f(8, this.eCD);
            }
            if (this.eBM != null) {
                r0 += a.a.a.b.b.a.f(9, this.eBM);
            }
            if (this.coN != null) {
                r0 += a.a.a.b.b.a.f(10, this.coN);
            }
            r0 = (r0 + a.a.a.a.dS(11, this.iOH)) + a.a.a.a.dS(12, this.iOK);
            if (this.iOL != null) {
                r0 += a.a.a.b.b.a.f(13, this.iOL);
            }
            if (this.iOM != null) {
                r0 += a.a.a.b.b.a.f(14, this.iOM);
            }
            if (this.iON != null) {
                r0 += a.a.a.b.b.a.f(19, this.iON);
            }
            if (this.iOO != null) {
                r0 += a.a.a.b.b.a.f(21, this.iOO);
            }
            r0 += a.a.a.a.dS(22, this.eBR);
            if (this.iOP != null) {
                r0 += a.a.a.b.b.a.f(23, this.iOP);
            }
            return r0 + (a.a.a.b.b.a.cw(24) + 1);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            auc com_tencent_mm_protocal_c_auc = (auc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auc.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_auc.eCZ = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_auc.eBK = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_auc.bom = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_auc.title = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_auc.eBN = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_auc.eBO = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_auc.eCD = aVar3.pMj.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_auc.eBM = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_auc.coN = aVar3.pMj.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_auc.iOH = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_auc.iOK = aVar3.pMj.mH();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_auc.iOL = aVar3.pMj.readString();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    com_tencent_mm_protocal_c_auc.iOM = aVar3.pMj.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_auc.iON = aVar3.pMj.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_auc.iOO = aVar3.pMj.readString();
                    return 0;
                case bf.CTRL_INDEX /*22*/:
                    com_tencent_mm_protocal_c_auc.eBR = aVar3.pMj.mH();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_auc.iOP = aVar3.pMj.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_auc.iOQ = aVar3.bQJ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
