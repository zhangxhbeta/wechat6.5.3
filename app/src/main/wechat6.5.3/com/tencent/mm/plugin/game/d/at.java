package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;

public final class at extends a {
    public String gkA;
    public String gmO;
    public String gmP;
    public String gmQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gmO != null) {
                aVar.e(1, this.gmO);
            }
            if (this.gmP != null) {
                aVar.e(2, this.gmP);
            }
            if (this.gkA != null) {
                aVar.e(3, this.gkA);
            }
            if (this.gmQ == null) {
                return 0;
            }
            aVar.e(4, this.gmQ);
            return 0;
        } else if (i == 1) {
            if (this.gmO != null) {
                r0 = a.a.a.b.b.a.f(1, this.gmO) + 0;
            } else {
                r0 = 0;
            }
            if (this.gmP != null) {
                r0 += a.a.a.b.b.a.f(2, this.gmP);
            }
            if (this.gkA != null) {
                r0 += a.a.a.b.b.a.f(3, this.gkA);
            }
            if (this.gmQ != null) {
                r0 += a.a.a.b.b.a.f(4, this.gmQ);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            at atVar = (at) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atVar.gmO = aVar3.pMj.readString();
                    return 0;
                case 2:
                    atVar.gmP = aVar3.pMj.readString();
                    return 0;
                case 3:
                    atVar.gkA = aVar3.pMj.readString();
                    return 0;
                case 4:
                    atVar.gmQ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
