package com.tencent.mm.plugin.emoji.d;

import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.o;
import java.util.HashMap;

public final class k {
    public int exY = 79;
    public boolean fbL = true;
    public long fbM = 863913600000L;
    public int fbN = 19;
    public o fbO;
    public HashMap<String, o> fbP = new HashMap();

    public final void afh() {
        if (this.fbO != null) {
            this.fbO.field_continuCount = 0;
            this.fbP.put(this.fbO.field_prodcutID, this.fbO);
            g.afx().fco.a(this.fbO);
            this.fbO = null;
        }
    }

    public final void a(o oVar, boolean z) {
        if (oVar == null) {
            v.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateLastRewardTipInfo failed. reward tip info is null.");
            return;
        }
        int i = (this.fbO == null || this.fbO.field_prodcutID.equalsIgnoreCase(oVar.field_prodcutID)) ? 1 : 0;
        if (i == 0) {
            this.fbO.field_continuCount = 0;
            this.fbP.put(this.fbO.field_prodcutID, this.fbO);
            g.afx().fco.a(this.fbO);
        }
        this.fbO = oVar;
        if (z) {
            this.fbO.field_modifyTime = 0;
            this.fbO.field_showTipsTime = System.currentTimeMillis();
            this.fbO.field_totalCount = 0;
            this.fbO.field_continuCount = 0;
        } else {
            if (i != 0) {
                this.fbO.field_continuCount++;
            } else {
                this.fbO.field_continuCount = 1;
            }
            this.fbO.field_totalCount++;
            this.fbO.field_modifyTime = System.currentTimeMillis();
        }
        this.fbP.put(this.fbO.field_prodcutID, this.fbO);
        g.afx().fco.a(this.fbO);
    }

    public final void ap(String str, int i) {
        if (be.kS(str)) {
            v.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag failed. no such product id.");
        } else if (this.fbP == null || !this.fbP.containsKey(str)) {
            v.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag map no contains this product id :%s", new Object[]{str});
        } else {
            ((o) this.fbP.get(str)).field_flag = i;
            ((o) this.fbP.get(str)).field_setFlagTime = System.currentTimeMillis();
        }
    }
}
