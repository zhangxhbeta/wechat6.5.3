package com.tencent.mm.plugin.game.c;

import com.tencent.mm.plugin.game.d.aa;
import com.tencent.mm.plugin.game.d.am;
import com.tencent.mm.plugin.game.d.aq;
import com.tencent.mm.plugin.game.d.as;
import com.tencent.mm.plugin.game.d.bd;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class z extends x {
    public aa gjq;
    private boolean gjr;
    public c gjs;
    public aa gjt;

    public static class a {
        public String desc;
        public String title;
        public String url;
    }

    public static class b {
        public String bll;
        public String desc;
        public String title;
        public String url;
    }

    public z(com.tencent.mm.ba.a aVar) {
        if (aVar == null) {
            this.gjq = new aa();
            return;
        }
        this.gjq = (aa) aVar;
        this.gjr = false;
        NH();
    }

    public z(byte[] bArr) {
        this.gjq = new aa();
        if (bArr != null && bArr.length != 0) {
            try {
                this.gjq.az(bArr);
            } catch (IOException e) {
                v.e("MicroMsg.GamePBDataDetail", "Parsing Failed: %s", new Object[]{e.getMessage()});
            }
            this.gjr = true;
            NH();
        }
    }

    private void NH() {
        c a = x.a(this.gjq.gkt);
        a.scene = 12;
        a.bmG = 1201;
        this.gjs = a;
        if (this.gjr) {
            this.gjt = new aa(this.gjs.field_appId);
        } else {
            this.gjt = new aa(this.gjs.field_appId, this.gjq.glL != null ? this.gjq.glL.gnu : null);
        }
        if (!this.gjr) {
            d.b(this.gjs);
            au.asg().a(this.gjs.field_appId, this.gjq);
        }
    }

    public final String arC() {
        if (this.gjq.glP != null) {
            return this.gjq.glP.title;
        }
        if (this.gjq.glK != null) {
            return this.gjq.glK.aXz;
        }
        return null;
    }

    public final LinkedList<b> arD() {
        LinkedList<b> linkedList;
        Iterator it;
        b bVar;
        if (this.gjq.glP != null && this.gjq.glP.eEK != null) {
            linkedList = new LinkedList();
            it = this.gjq.glP.eEK.iterator();
            while (it.hasNext()) {
                as asVar = (as) it.next();
                bVar = new b();
                bVar.bll = asVar.bll;
                bVar.desc = asVar.desc;
                linkedList.add(bVar);
            }
            return linkedList;
        } else if (this.gjq.glK == null || this.gjq.glK.gmC == null) {
            return null;
        } else {
            linkedList = new LinkedList();
            it = this.gjq.glK.gmC.iterator();
            while (it.hasNext()) {
                am amVar = (am) it.next();
                bVar = new b();
                bVar.bll = amVar.gmF;
                bVar.title = amVar.aXz;
                bVar.desc = amVar.glo;
                bVar.url = amVar.gkv;
                linkedList.add(bVar);
            }
            return linkedList;
        }
    }

    public final int arE() {
        if (this.gjq.glP != null) {
            return 2;
        }
        return 1;
    }

    public final LinkedList<com.tencent.mm.plugin.game.ui.GameMediaList.a> VK() {
        LinkedList<com.tencent.mm.plugin.game.ui.GameMediaList.a> linkedList = new LinkedList();
        if (this.gjq.glI == null || this.gjq.glI.gmX == null) {
            return linkedList;
        }
        Iterator it = this.gjq.glI.gmX.iterator();
        while (it.hasNext()) {
            bd bdVar = (bd) it.next();
            com.tencent.mm.plugin.game.ui.GameMediaList.a aVar = new com.tencent.mm.plugin.game.ui.GameMediaList.a();
            aVar.type = bdVar.gng;
            aVar.gvu = bdVar.gnh;
            aVar.url = bdVar.gni;
            linkedList.add(aVar);
        }
        return linkedList;
    }

    public final String arF() {
        if (this.gjq.glI == null || this.gjq.glI.aXz == null) {
            return null;
        }
        return this.gjq.glI.aXz;
    }

    public final String arG() {
        if (this.gjq.glI == null || this.gjq.glI.glo == null) {
            return null;
        }
        return this.gjq.glI.glo;
    }

    public final String arH() {
        if (this.gjq.glJ == null) {
            return null;
        }
        return this.gjq.glJ.aXz;
    }

    public final LinkedList<aq> arI() {
        if (this.gjq.glJ == null) {
            return null;
        }
        return this.gjq.glJ.gmL;
    }
}
