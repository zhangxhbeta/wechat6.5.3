package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class d extends a {
    public LinkedList<e> jqq = new LinkedList();
    public LinkedList<e> jqr = new LinkedList();
    public LinkedList<e> jqs = new LinkedList();
    public LinkedList<e> jqt = new LinkedList();
    public LinkedList<f> jqu = new LinkedList();
    public LinkedList<f> jqv = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.jqq);
            aVar.d(2, 8, this.jqr);
            aVar.d(3, 8, this.jqs);
            aVar.d(4, 8, this.jqt);
            aVar.d(5, 8, this.jqu);
            aVar.d(6, 8, this.jqv);
            return 0;
        } else if (i == 1) {
            return (((((a.a.a.a.c(1, 8, this.jqq) + 0) + a.a.a.a.c(2, 8, this.jqr)) + a.a.a.a.c(3, 8, this.jqs)) + a.a.a.a.c(4, 8, this.jqt)) + a.a.a.a.c(5, 8, this.jqu)) + a.a.a.a.c(6, 8, this.jqv);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.jqq.clear();
                this.jqr.clear();
                this.jqs.clear();
                this.jqt.clear();
                this.jqu.clear();
                this.jqv.clear();
                a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                d dVar = (d) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                LinkedList zQ;
                int size;
                e eVar;
                a.a.a.a.a aVar4;
                boolean z;
                f fVar;
                switch (intValue) {
                    case 1:
                        zQ = aVar3.zQ(intValue);
                        size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            eVar = new e();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.jqq.add(eVar);
                        }
                        return 0;
                    case 2:
                        zQ = aVar3.zQ(intValue);
                        size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            eVar = new e();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.jqr.add(eVar);
                        }
                        return 0;
                    case 3:
                        zQ = aVar3.zQ(intValue);
                        size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            eVar = new e();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.jqs.add(eVar);
                        }
                        return 0;
                    case 4:
                        zQ = aVar3.zQ(intValue);
                        size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            eVar = new e();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                            }
                            dVar.jqt.add(eVar);
                        }
                        return 0;
                    case 5:
                        zQ = aVar3.zQ(intValue);
                        size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            fVar = new f();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = fVar.a(aVar4, fVar, a.a(aVar4))) {
                            }
                            dVar.jqu.add(fVar);
                        }
                        return 0;
                    case 6:
                        zQ = aVar3.zQ(intValue);
                        size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            fVar = new f();
                            aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (z = true; z; z = fVar.a(aVar4, fVar, a.a(aVar4))) {
                            }
                            dVar.jqv.add(fVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
