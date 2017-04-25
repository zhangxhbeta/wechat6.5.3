package com.tencent.mm.plugin.emoji.ui.smiley;

import com.tencent.mm.bf.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.pluginsdk.ui.chat.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.a;

public final class d {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelInfo";
    String fdU;
    f fkM;
    e fkN;
    int fkO;
    int fkP;
    int fkQ;
    int fkR;
    int fkS;
    boolean fkT = false;

    public d(a aVar, int i, f fVar, e eVar, boolean z) {
        if (aVar == null || be.kS(aVar.field_productID)) {
            v.i("MicroMsg.emoji.SmileyPanel.SmileyPanelInfo", "catch invalid Smiley Tab want add??!!");
            return;
        }
        this.fkN = eVar;
        this.fkM = fVar;
        this.fdU = aVar.field_productID;
        this.fkP = i;
        if (z || aVar.field_productID.equalsIgnoreCase(String.valueOf(a.nwJ))) {
            int Ti;
            f fVar2;
            String str;
            if (aVar != null) {
                if (aVar.field_productID.equals("TAG_DEFAULT_TAB")) {
                    Ti = e.buQ().Ti();
                } else if (aVar.field_productID.equals(String.valueOf(a.nwK))) {
                    ak.yW();
                    Ti = c.isSDCardAvailable() ? g.afx().fch.iC(true) + 1 : 0;
                } else if (aVar.field_productID.equalsIgnoreCase(String.valueOf(a.nwJ))) {
                    ak.yW();
                    Ti = c.isSDCardAvailable() ? 16 : 0;
                } else if (f.a(aVar)) {
                    Ti = 1;
                    if (aVar != null) {
                        if (aVar.field_count > 0) {
                            Ti = aVar.field_count;
                        } else {
                            Ti = g.afx().fch.NB(aVar.field_productID);
                            aVar.field_count = Ti;
                            long currentTimeMillis = System.currentTimeMillis();
                            g.afx().fci.a(aVar, new String[]{"productID"});
                            v.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        }
                    }
                    if (Ti == 0) {
                        Ti = 1;
                    }
                    ak.yW();
                    if (!c.isSDCardAvailable()) {
                        Ti = 0;
                    }
                }
                this.fkO = Ti;
                fVar2 = this.fkM;
                str = this.fdU;
                if (fVar2.fmc > 0 || be.kS(str)) {
                    Ti = 1;
                } else if (str.equals("TAG_STORE_TAB")) {
                    Ti = 1;
                } else {
                    int rN = fVar2.fmc / fVar2.rN(str);
                    Ti = be.kS(str) ? 0 : str.equals("TAG_DEFAULT_TAB") ? 3 : 2;
                    if (rN <= Ti) {
                        Ti = rN;
                    }
                    if (Ti <= 0) {
                        Ti = 1;
                    }
                }
                this.fkQ = Ti;
                this.fkR = this.fkM.rQ(this.fdU);
                this.fkS = this.fkM.ar(this.fdU, this.fkQ);
            }
            Ti = 1;
            this.fkO = Ti;
            fVar2 = this.fkM;
            str = this.fdU;
            if (fVar2.fmc > 0) {
            }
            Ti = 1;
            this.fkQ = Ti;
            this.fkR = this.fkM.rQ(this.fdU);
            this.fkS = this.fkM.ar(this.fdU, this.fkQ);
        } else {
            this.fkO = 1;
            this.fkQ = 1;
            this.fkR = 1;
            this.fkS = this.fkM.ar(this.fdU, this.fkQ);
        }
        this.fkT = z;
        v.i("MicroMsg.emoji.SmileyPanel.SmileyPanelInfo", "smiley panel tab: productId: %s, startIndex: %d mAllEmojiNums: %d mRow:%d mCol:%d mSpacing:%d ", new Object[]{this.fdU, Integer.valueOf(i), Integer.valueOf(this.fkO), Integer.valueOf(this.fkQ), Integer.valueOf(this.fkR), Integer.valueOf(this.fkS)});
    }

    public final int getType() {
        String str = this.fdU;
        if (str.equals("TAG_DEFAULT_TAB")) {
            return 20;
        }
        return str.equals(String.valueOf(a.nwK)) ? 25 : 23;
    }

    public final int ahs() {
        return this.fkQ * this.fkR;
    }

    public final int aht() {
        if (ahs() <= 0) {
            return 0;
        }
        if ("TAG_DEFAULT_TAB".equals(this.fdU)) {
            return (int) Math.ceil(((double) this.fkO) / ((double) (ahs() - 1)));
        }
        return (int) Math.ceil(((double) this.fkO) / ((double) ahs()));
    }

    public final int ahu() {
        return this.fkM.ahF() / (this.fkM.ahF() / this.fkM.flU);
    }

    public final k ahp() {
        e eVar = this.fkN;
        return eVar.fli == null ? null : eVar.fli.ahp();
    }
}
