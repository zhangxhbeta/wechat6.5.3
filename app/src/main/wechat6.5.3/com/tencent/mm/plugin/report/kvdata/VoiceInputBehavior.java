package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.ba.a;

public class VoiceInputBehavior extends a {
    public int cancel;
    public int click;
    public int fail;
    public int longClick;
    public long longClickTime;
    public int send;
    public int textChangeCount;
    public int textChangeReturn;
    public long textChangeTime;
    public int textClick;
    public long voiceInputTime;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.cancel);
            aVar.dV(2, this.send);
            aVar.dV(3, this.click);
            aVar.dV(4, this.longClick);
            aVar.C(5, this.longClickTime);
            aVar.dV(6, this.textClick);
            aVar.dV(7, this.textChangeCount);
            aVar.C(8, this.textChangeTime);
            aVar.dV(9, this.textChangeReturn);
            aVar.C(10, this.voiceInputTime);
            aVar.dV(11, this.fail);
            return 0;
        } else if (i == 1) {
            return ((((((((((a.a.a.a.dS(1, this.cancel) + 0) + a.a.a.a.dS(2, this.send)) + a.a.a.a.dS(3, this.click)) + a.a.a.a.dS(4, this.longClick)) + a.a.a.a.B(5, this.longClickTime)) + a.a.a.a.dS(6, this.textClick)) + a.a.a.a.dS(7, this.textChangeCount)) + a.a.a.a.B(8, this.textChangeTime)) + a.a.a.a.dS(9, this.textChangeReturn)) + a.a.a.a.B(10, this.voiceInputTime)) + a.a.a.a.dS(11, this.fail);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
                VoiceInputBehavior voiceInputBehavior = (VoiceInputBehavior) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        voiceInputBehavior.cancel = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        voiceInputBehavior.send = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        voiceInputBehavior.click = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        voiceInputBehavior.longClick = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        voiceInputBehavior.longClickTime = aVar3.pMj.mI();
                        return 0;
                    case 6:
                        voiceInputBehavior.textClick = aVar3.pMj.mH();
                        return 0;
                    case 7:
                        voiceInputBehavior.textChangeCount = aVar3.pMj.mH();
                        return 0;
                    case 8:
                        voiceInputBehavior.textChangeTime = aVar3.pMj.mI();
                        return 0;
                    case 9:
                        voiceInputBehavior.textChangeReturn = aVar3.pMj.mH();
                        return 0;
                    case 10:
                        voiceInputBehavior.voiceInputTime = aVar3.pMj.mI();
                        return 0;
                    case 11:
                        voiceInputBehavior.fail = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
