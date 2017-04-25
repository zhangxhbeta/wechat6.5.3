package com.tencent.mm.plugin.game.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.game.d.ae;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.bx;
import com.tencent.mm.plugin.game.d.i;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class ab extends x {
    public LinkedList<c> gjA;
    public LinkedList<c> gjB;
    private int gjp;
    public ae gjz;

    public ab(a aVar, boolean z, int i) {
        this.gjp = 0;
        if (aVar == null) {
            this.gjz = new ae();
            return;
        }
        this.gjz = (ae) aVar;
        this.gjp = i;
        this.gjA = arL();
        this.gjB = arM();
        if (z) {
            au.asg().a("pb_library", aVar);
        }
        d.N(this.gjA);
        d.N(this.gjB);
    }

    public ab(byte[] bArr) {
        this.gjp = 0;
        this.gjz = new ae();
        if (bArr != null && bArr.length != 0) {
            try {
                this.gjz.az(bArr);
            } catch (IOException e) {
                v.e("MicroMsg.GamePBDataLibrary", "Parsing Failed: %s", new Object[]{e.getMessage()});
            }
            this.gjA = arL();
            this.gjB = arM();
            d.N(this.gjA);
            d.N(this.gjB);
        }
    }

    private LinkedList<c> arL() {
        LinkedList<c> linkedList = new LinkedList();
        if (this.gjz.gmr == null || this.gjz.gmr.gna == null || this.gjz.gmr.gna.gnq == null) {
            return linkedList;
        }
        Iterator it = this.gjz.gmr.gna.gnq.iterator();
        int i = 1;
        while (it.hasNext()) {
            bi biVar = (bi) it.next();
            c a = x.a(biVar.gkt);
            if (a != null) {
                a.ghx = biVar.gkt.gkJ;
                a.scene = 11;
                a.bmG = 1110;
                int i2 = i + 1;
                a.position = i;
                linkedList.add(a);
                i = i2;
            }
        }
        return linkedList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.LinkedList<com.tencent.mm.plugin.game.c.c> arM() {
        /*
        r7 = this;
        r3 = new java.util.LinkedList;
        r3.<init>();
        r0 = r7.gjz;
        r0 = r0.gms;
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        r0 = r3;
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = r7.gjp;
        r1 = r0 + 1;
        r0 = r7.gjp;
        r0 = r0 / 15;
        r0 = r0 + 901;
        r2 = r7.gjz;
        r2 = r2.gms;
        r5 = r2.iterator();
        r2 = r1;
        r1 = r0;
    L_0x0021:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x0076;
    L_0x0027:
        r0 = r5.next();
        r0 = (com.tencent.mm.plugin.game.d.b) r0;
        r4 = 0;
        r6 = r0.efm;
        switch(r6) {
            case 1: goto L_0x0046;
            case 2: goto L_0x0054;
            default: goto L_0x0033;
        };
    L_0x0033:
        r0 = r1;
        r1 = r2;
        r2 = r4;
    L_0x0036:
        if (r2 == 0) goto L_0x0078;
    L_0x0038:
        r4 = 11;
        r2.scene = r4;
        r4 = 1111; // 0x457 float:1.557E-42 double:5.49E-321;
        r2.bmG = r4;
        r3.add(r2);
        r2 = r1;
        r1 = r0;
        goto L_0x0021;
    L_0x0046:
        r0 = r0.gkt;
        r0 = com.tencent.mm.plugin.game.c.x.a(r0);
        r4 = r2 + 1;
        r0.position = r2;
        r2 = r0;
        r0 = r1;
        r1 = r4;
        goto L_0x0036;
    L_0x0054:
        r6 = r0.gkw;
        if (r6 == 0) goto L_0x0033;
    L_0x0058:
        r4 = r0.gkw;
        r4 = r4.gkt;
        r4 = com.tencent.mm.plugin.game.c.x.a(r4);
        r6 = 1;
        r4.type = r6;
        r6 = r0.gkw;
        r6 = r6.gkv;
        r4.ghp = r6;
        r0 = r0.gkw;
        r0 = r0.gku;
        r4.ghq = r0;
        r0 = r1 + 1;
        r4.position = r1;
        r1 = r2;
        r2 = r4;
        goto L_0x0036;
    L_0x0076:
        r0 = r3;
        goto L_0x000c;
    L_0x0078:
        r2 = r1;
        r1 = r0;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.c.ab.arM():java.util.LinkedList<com.tencent.mm.plugin.game.c.c>");
    }

    public final HashMap<Integer, String> arN() {
        HashMap<Integer, String> linkedHashMap = new LinkedHashMap();
        if (this.gjz.gmr == null || this.gjz.gmr.gnd == null) {
            return linkedHashMap;
        }
        Iterator it = this.gjz.gmr.gnd.iterator();
        while (it.hasNext()) {
            bx bxVar = (bx) it.next();
            int i = bxVar.gmp;
            linkedHashMap.put(Integer.valueOf(i), bxVar.gkB);
        }
        return linkedHashMap;
    }

    public final LinkedList<GameLibraryCategoriesView.a> arO() {
        if (this.gjz.gmr == null || this.gjz.gmr.gnb == null) {
            return null;
        }
        LinkedList<GameLibraryCategoriesView.a> linkedList = new LinkedList();
        Iterator it = this.gjz.gmr.gnb.iterator();
        int i = 0;
        while (it.hasNext()) {
            i iVar = (i) it.next();
            GameLibraryCategoriesView.a aVar = new GameLibraryCategoriesView.a();
            aVar.guA = iVar.glc;
            aVar.guB = iVar.gkB;
            aVar.guC = iVar.gkv;
            aVar.ghD = iVar.gkA;
            int i2 = i + 1;
            aVar.position = i2;
            linkedList.add(aVar);
            i = i2;
        }
        return linkedList;
    }
}
