package com.tencent.mm.plugin.game.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.game.d.ag;
import com.tencent.mm.plugin.game.d.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class y extends x {
    public ag gjn;
    public LinkedList<c> gjo;
    private int gjp = 0;
    private int mType = 0;

    public y(a aVar, int i, int i2) {
        if (aVar == null) {
            this.gjn = new ag();
            return;
        }
        this.gjn = (ag) aVar;
        this.mType = i;
        this.gjp = i2;
        LinkedList linkedList = new LinkedList();
        if (this.gjn.gmx != null) {
            int i3 = this.gjp + 1;
            Iterator it = this.gjn.gmx.iterator();
            int i4 = i3;
            while (it.hasNext()) {
                c a = x.a((d) it.next());
                if (a != null) {
                    switch (this.mType) {
                        case 1:
                            a.scene = 16;
                            a.bmG = 1601;
                            i3 = i4 + 1;
                            a.position = i4;
                            break;
                        case 2:
                            a.scene = 15;
                            a.bmG = 1501;
                            i3 = i4 + 1;
                            a.position = i4;
                            break;
                        default:
                            i3 = i4;
                            break;
                    }
                    linkedList.add(a);
                    i4 = i3;
                }
            }
        }
        this.gjo = linkedList;
        com.tencent.mm.plugin.game.e.d.N(this.gjo);
    }
}
