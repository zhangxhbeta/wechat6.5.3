package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import java.util.LinkedList;

public final class oh extends a {
    public int efl;
    public String gnp;
    public String mdM;
    public String mqd;
    public String mqe;
    public String mqf;
    public String mqg;
    public int mqh;
    public int mqi;
    public int mqj;
    public LinkedList<arf> mqk = new LinkedList();
    public String mql;
    public int mqm;
    public String mqn;
    public String mqo;
    public String mqp;
    public String mqq;
    public String mqr;
    public int mqs;
    public LinkedList<alh> mqt = new LinkedList();
    public String mqu;
    public String mqv;
    public String mqw;
    public og mqx;
    public amq mqy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mdM != null) {
                aVar.e(1, this.mdM);
            }
            if (this.gnp != null) {
                aVar.e(2, this.gnp);
            }
            if (this.mqd != null) {
                aVar.e(3, this.mqd);
            }
            if (this.mqe != null) {
                aVar.e(4, this.mqe);
            }
            if (this.mqf != null) {
                aVar.e(5, this.mqf);
            }
            if (this.mqg != null) {
                aVar.e(6, this.mqg);
            }
            aVar.dV(7, this.mqh);
            aVar.dV(8, this.mqi);
            aVar.dV(9, this.mqj);
            aVar.d(10, 8, this.mqk);
            if (this.mql != null) {
                aVar.e(11, this.mql);
            }
            aVar.dV(12, this.mqm);
            if (this.mqn != null) {
                aVar.e(13, this.mqn);
            }
            if (this.mqo != null) {
                aVar.e(14, this.mqo);
            }
            if (this.mqp != null) {
                aVar.e(15, this.mqp);
            }
            if (this.mqq != null) {
                aVar.e(16, this.mqq);
            }
            if (this.mqr != null) {
                aVar.e(17, this.mqr);
            }
            aVar.dV(18, this.mqs);
            aVar.d(19, 8, this.mqt);
            aVar.dV(20, this.efl);
            if (this.mqu != null) {
                aVar.e(21, this.mqu);
            }
            if (this.mqv != null) {
                aVar.e(22, this.mqv);
            }
            if (this.mqw != null) {
                aVar.e(23, this.mqw);
            }
            if (this.mqx != null) {
                aVar.dX(24, this.mqx.aHr());
                this.mqx.a(aVar);
            }
            if (this.mqy == null) {
                return 0;
            }
            aVar.dX(25, this.mqy.aHr());
            this.mqy.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mdM != null) {
                r0 = a.a.a.b.b.a.f(1, this.mdM) + 0;
            } else {
                r0 = 0;
            }
            if (this.gnp != null) {
                r0 += a.a.a.b.b.a.f(2, this.gnp);
            }
            if (this.mqd != null) {
                r0 += a.a.a.b.b.a.f(3, this.mqd);
            }
            if (this.mqe != null) {
                r0 += a.a.a.b.b.a.f(4, this.mqe);
            }
            if (this.mqf != null) {
                r0 += a.a.a.b.b.a.f(5, this.mqf);
            }
            if (this.mqg != null) {
                r0 += a.a.a.b.b.a.f(6, this.mqg);
            }
            r0 = (((r0 + a.a.a.a.dS(7, this.mqh)) + a.a.a.a.dS(8, this.mqi)) + a.a.a.a.dS(9, this.mqj)) + a.a.a.a.c(10, 8, this.mqk);
            if (this.mql != null) {
                r0 += a.a.a.b.b.a.f(11, this.mql);
            }
            r0 += a.a.a.a.dS(12, this.mqm);
            if (this.mqn != null) {
                r0 += a.a.a.b.b.a.f(13, this.mqn);
            }
            if (this.mqo != null) {
                r0 += a.a.a.b.b.a.f(14, this.mqo);
            }
            if (this.mqp != null) {
                r0 += a.a.a.b.b.a.f(15, this.mqp);
            }
            if (this.mqq != null) {
                r0 += a.a.a.b.b.a.f(16, this.mqq);
            }
            if (this.mqr != null) {
                r0 += a.a.a.b.b.a.f(17, this.mqr);
            }
            r0 = ((r0 + a.a.a.a.dS(18, this.mqs)) + a.a.a.a.c(19, 8, this.mqt)) + a.a.a.a.dS(20, this.efl);
            if (this.mqu != null) {
                r0 += a.a.a.b.b.a.f(21, this.mqu);
            }
            if (this.mqv != null) {
                r0 += a.a.a.b.b.a.f(22, this.mqv);
            }
            if (this.mqw != null) {
                r0 += a.a.a.b.b.a.f(23, this.mqw);
            }
            if (this.mqx != null) {
                r0 += a.a.a.a.dU(24, this.mqx.aHr());
            }
            if (this.mqy != null) {
                r0 += a.a.a.a.dU(25, this.mqy.aHr());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mqk.clear();
            this.mqt.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            oh ohVar = (oh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ohVar.mdM = aVar3.pMj.readString();
                    return 0;
                case 2:
                    ohVar.gnp = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ohVar.mqd = aVar3.pMj.readString();
                    return 0;
                case 4:
                    ohVar.mqe = aVar3.pMj.readString();
                    return 0;
                case 5:
                    ohVar.mqf = aVar3.pMj.readString();
                    return 0;
                case 6:
                    ohVar.mqg = aVar3.pMj.readString();
                    return 0;
                case 7:
                    ohVar.mqh = aVar3.pMj.mH();
                    return 0;
                case 8:
                    ohVar.mqi = aVar3.pMj.mH();
                    return 0;
                case 9:
                    ohVar.mqj = aVar3.pMj.mH();
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        arf com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        ohVar.mqk.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 11:
                    ohVar.mql = aVar3.pMj.readString();
                    return 0;
                case 12:
                    ohVar.mqm = aVar3.pMj.mH();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    ohVar.mqn = aVar3.pMj.readString();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    ohVar.mqo = aVar3.pMj.readString();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    ohVar.mqp = aVar3.pMj.readString();
                    return 0;
                case 16:
                    ohVar.mqq = aVar3.pMj.readString();
                    return 0;
                case 17:
                    ohVar.mqr = aVar3.pMj.readString();
                    return 0;
                case 18:
                    ohVar.mqs = aVar3.pMj.mH();
                    return 0;
                case 19:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        alh com_tencent_mm_protocal_c_alh = new alh();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_alh.a(aVar4, com_tencent_mm_protocal_c_alh, a.a(aVar4))) {
                        }
                        ohVar.mqt.add(com_tencent_mm_protocal_c_alh);
                    }
                    return 0;
                case 20:
                    ohVar.efl = aVar3.pMj.mH();
                    return 0;
                case 21:
                    ohVar.mqu = aVar3.pMj.readString();
                    return 0;
                case bf.CTRL_INDEX /*22*/:
                    ohVar.mqv = aVar3.pMj.readString();
                    return 0;
                case 23:
                    ohVar.mqw = aVar3.pMj.readString();
                    return 0;
                case 24:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        og ogVar = new og();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ogVar.a(aVar4, ogVar, a.a(aVar4))) {
                        }
                        ohVar.mqx = ogVar;
                    }
                    return 0;
                case 25:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        amq com_tencent_mm_protocal_c_amq = new amq();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_amq.a(aVar4, com_tencent_mm_protocal_c_amq, a.a(aVar4))) {
                        }
                        ohVar.mqy = com_tencent_mm_protocal_c_amq;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
