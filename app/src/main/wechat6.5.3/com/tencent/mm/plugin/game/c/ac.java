package com.tencent.mm.plugin.game.c;

import android.content.Context;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.game.d.ar;
import com.tencent.mm.plugin.game.d.aw;
import com.tencent.mm.plugin.game.d.bk;
import com.tencent.mm.plugin.game.d.bp;
import com.tencent.mm.plugin.game.d.bt;
import com.tencent.mm.plugin.game.d.cb;
import com.tencent.mm.plugin.game.d.ce;
import com.tencent.mm.plugin.game.d.w;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class ac extends x {
    public com.tencent.mm.plugin.game.d.ac gjC;
    private boolean gjD;
    public LinkedList<c> gjE;
    public HashMap<String, Integer> gjF;
    public LinkedList<c> gjG;
    public com.tencent.mm.plugin.game.ui.GameInstalledView.a gjH;
    public com.tencent.mm.plugin.game.ui.RecentGameInfoView.a gjI;
    public com.tencent.mm.plugin.game.ui.GameRecommendView.a gjJ;
    public com.tencent.mm.plugin.game.ui.GameTopRecommendView.a gjK;
    private String gjL;
    private int gjM;

    public static class a {
        public String text;
        public String url;
    }

    public static class b {
        public ar gjN;
        public int gjO;
        public int position;
        public int scene;
    }

    public ac(com.tencent.mm.ba.a aVar) {
        this.gjF = new HashMap();
        if (aVar == null) {
            this.gjC = new com.tencent.mm.plugin.game.d.ac();
            return;
        }
        this.gjC = (com.tencent.mm.plugin.game.d.ac) aVar;
        this.gjD = true;
        NH();
    }

    public ac(byte[] bArr) {
        this.gjF = new HashMap();
        this.gjC = new com.tencent.mm.plugin.game.d.ac();
        if (bArr != null && bArr.length != 0) {
            try {
                this.gjC.az(bArr);
            } catch (IOException e) {
                v.e("MicroMsg.GamePBDataIndex", "Parsing Failed: %s", new Object[]{e.getMessage()});
            }
            this.gjD = false;
            NH();
        }
    }

    private void NH() {
        LinkedList linkedList;
        LinkedList linkedList2 = new LinkedList();
        if (this.gjC.gmc == null || this.gjC.gmc.gns == null) {
            linkedList = linkedList2;
        } else {
            Iterator it = this.gjC.gmc.gns.iterator();
            int i = 1;
            while (it.hasNext()) {
                bk bkVar = (bk) it.next();
                int i2;
                switch (bkVar.efm) {
                    case 1:
                        if (bkVar.gnt == null) {
                            break;
                        }
                        c a = x.a(bkVar.gnt.gkt);
                        if (a != null) {
                            if (bkVar.gnt.gkt.gkO == null) {
                                a.ghF = af.ug(bkVar.gkV);
                            } else if (bkVar.gnt.gkt.gkO.gkB == null || bkVar.gnt.gkt.gkO.gmY == null) {
                                a.ghF = af.ug(bkVar.gkV);
                            } else {
                                a.ghA = bkVar.gnt.gkt.gkO.gkB;
                                a.ghB = bkVar.gnt.gkt.gkO.gmY;
                                a.ghF = af.E(bkVar.gkV, "label", a.ghA);
                            }
                            if (bkVar.gnt.gky != null) {
                                Iterator it2 = bkVar.gnt.gky.iterator();
                                while (it2.hasNext()) {
                                    cb cbVar = (cb) it2.next();
                                    if (cbVar != null) {
                                        if (cbVar.goe == null || cbVar.goe.size() == 0) {
                                            a.ghv.add("");
                                        } else {
                                            StringBuilder stringBuilder = new StringBuilder();
                                            for (int i3 = 0; i3 < cbVar.goe.size(); i3++) {
                                                ak.yW();
                                                u LX = c.wH().LX((String) cbVar.goe.get(i3));
                                                if (LX == null || LX.chr == 0) {
                                                    stringBuilder.append((String) cbVar.goe.get(i3));
                                                } else {
                                                    stringBuilder.append(LX.tU());
                                                }
                                                if (i3 < cbVar.goe.size() - 1) {
                                                    stringBuilder.append("、");
                                                }
                                            }
                                            stringBuilder.append(" ");
                                            a.ghv.add(stringBuilder.toString());
                                        }
                                        a.ghv.add(cbVar.glo);
                                    }
                                }
                            }
                            a.scene = 10;
                            a.bmG = 1004;
                            i2 = i + 1;
                            a.position = i;
                            linkedList2.add(a);
                            i = i2;
                            break;
                        }
                        break;
                        break;
                    case 2:
                        if (!be.bP(bkVar.gmZ)) {
                            c cVar = new c();
                            cVar.type = 1;
                            int i4 = 0;
                            Iterator it3 = bkVar.gmZ.iterator();
                            while (it3.hasNext()) {
                                ar arVar = (ar) it3.next();
                                b bVar = new b();
                                bVar.gjN = arVar;
                                bVar.scene = 10;
                                bVar.gjO = 1015;
                                i2 = i4 + 1;
                                bVar.position = i2;
                                cVar.ghG.add(bVar);
                                i4 = i2;
                            }
                            linkedList2.add(cVar);
                            break;
                        }
                        break;
                    default:
                        v.e("MicroMsg.GamePBDataIndex", "unknowed NewHotItem type");
                        break;
                }
            }
            linkedList = linkedList2;
        }
        this.gjE = linkedList;
        this.gjG = arQ();
        com.tencent.mm.plugin.game.ui.GameInstalledView.a aVar = new com.tencent.mm.plugin.game.ui.GameInstalledView.a();
        if (!(this.gjC.glY == null || this.gjC.glY.gmV == null)) {
            aVar.iconUrl = this.gjC.glY.gmV.gkA;
            aVar.title = this.gjC.glY.gmV.aXz;
            aVar.guw = this.gjC.glY.gmV.gkv;
        }
        this.gjH = aVar;
        this.gjI = arR();
        this.gjJ = arS();
        this.gjK = arT();
        this.gjL = be.ah(this.gjC.gmj, "");
        this.gjM = this.gjC.gmk;
        if (this.gjD) {
            d.N(this.gjE);
            d.N(this.gjI.gwV);
            d.N(this.gjJ.gwV);
            d.N(this.gjK.gyQ);
            arP();
            au.asi().init(aa.getContext());
            Context context = aa.getContext();
            context.getSharedPreferences("game_center_pref", 0).edit().putInt("game_detail_jump_type", this.gjM).apply();
            context = aa.getContext();
            context.getSharedPreferences("game_center_pref", 0).edit().putString("game_detail_jump_url", this.gjL).apply();
        }
    }

    private void arP() {
        this.gjF = new HashMap();
        if (this.gjC.glY != null && this.gjC.glY.gmU != null) {
            Iterator it = this.gjC.glY.gmU.iterator();
            while (it.hasNext()) {
                aw awVar = (aw) it.next();
                c a = x.a(awVar.gkt);
                if (a != null) {
                    this.gjF.put(a.field_appId, Integer.valueOf(a.versionCode));
                    f Gz = am.bnB().Gz(a.field_appId);
                    if (Gz != null) {
                        Gz.bG(awVar.gmW);
                        if (!am.bnB().a(Gz, new String[0])) {
                            v.e("MicroMsg.GamePBDataIndex", "Store rank info failed, AppID: %s", new Object[]{Gz.field_appId});
                        }
                    }
                }
            }
        }
    }

    private LinkedList<c> arQ() {
        LinkedList<c> linkedList = new LinkedList();
        if (this.gjC.glY == null || this.gjC.glY.gmU == null) {
            return linkedList;
        }
        Iterator it = this.gjC.glY.gmU.iterator();
        while (it.hasNext()) {
            aw awVar = (aw) it.next();
            if (awVar != null) {
                c a = x.a(awVar.gkt);
                if (a != null) {
                    a.bG(awVar.gmW);
                    linkedList.addFirst(a);
                }
            }
        }
        return linkedList;
    }

    private com.tencent.mm.plugin.game.ui.RecentGameInfoView.a arR() {
        com.tencent.mm.plugin.game.ui.RecentGameInfoView.a aVar = new com.tencent.mm.plugin.game.ui.RecentGameInfoView.a();
        if (this.gjC.glZ == null || be.bP(this.gjC.glZ.gnM)) {
            return aVar;
        }
        aVar.gwV = new LinkedList();
        Iterator it = this.gjC.glZ.gnM.iterator();
        int i = 0;
        while (it.hasNext()) {
            bp bpVar = (bp) it.next();
            c a = x.a(bpVar.gkt);
            if (a != null) {
                a.ghC = bpVar.gnJ;
                a.scene = 10;
                a.bmG = 1002;
                i++;
                a.position = i;
                aVar.gwV.add(a);
                if (!be.bP(bpVar.gnK)) {
                    aVar.gzo = bpVar.gnK;
                }
            }
        }
        aVar.gzq = this.gjC.glZ.gnL;
        aVar.gzn = this.gjC.glZ.gkW;
        aVar.gzp = this.gjC.glZ.gnN;
        return aVar;
    }

    private com.tencent.mm.plugin.game.ui.GameRecommendView.a arS() {
        com.tencent.mm.plugin.game.ui.GameRecommendView.a aVar = new com.tencent.mm.plugin.game.ui.GameRecommendView.a();
        if (this.gjC.gmb == null) {
            return aVar;
        }
        w wVar = this.gjC.gmb;
        aVar.title = wVar.gkW;
        aVar.gwV = new LinkedList();
        if (!be.bP(wVar.glw)) {
            Iterator it = wVar.glw.iterator();
            int i = 0;
            while (it.hasNext()) {
                bt btVar = (bt) it.next();
                c a = x.a(btVar.gkt);
                if (a == null) {
                    if (!(btVar.gnp == null || btVar.aXz == null || btVar.gkT == null)) {
                        a = new c();
                        a.type = 2;
                        a.name = btVar.aXz;
                        a.ghD = btVar.gnp;
                        a.ghp = btVar.gkT;
                    }
                }
                a.ghn = btVar.gnQ;
                a.scene = 10;
                a.bmG = 1013;
                int i2 = i + 1;
                a.position = i2;
                aVar.gwV.add(a);
                i = i2;
            }
        }
        return aVar;
    }

    private com.tencent.mm.plugin.game.ui.GameTopRecommendView.a arT() {
        com.tencent.mm.plugin.game.ui.GameTopRecommendView.a aVar = new com.tencent.mm.plugin.game.ui.GameTopRecommendView.a();
        if (this.gjC.gma == null) {
            return aVar;
        }
        aVar.title = this.gjC.gma.aXz;
        aVar.type = this.gjC.gma.efm;
        aVar.ghF = af.ug(this.gjC.gma.gkV);
        switch (this.gjC.gma.efm) {
            case 1:
                aVar.ghp = this.gjC.gma.gkT;
                aVar.gyR = this.gjC.gma.gog;
                break;
            case 2:
                LinkedList linkedList = new LinkedList();
                if (!be.bP(this.gjC.gma.goh)) {
                    Iterator it = this.gjC.gma.goh.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        ce ceVar = (ce) it.next();
                        c a = x.a(ceVar.gkt);
                        if (a != null) {
                            if (!be.kS(ceVar.goi)) {
                                a.ghn = ceVar.goi;
                            }
                            if (!be.kS(ceVar.gok)) {
                                a.gho = ceVar.gok;
                            }
                            if (!be.kS(ceVar.gol)) {
                                a.ghE = ceVar.gol;
                            }
                            a.name = ceVar.goj;
                            a.scene = 10;
                            a.bmG = 1012;
                            i++;
                            a.position = i;
                            a.ghF = af.ug(ceVar.gkV);
                            linkedList.add(a);
                        }
                    }
                }
                aVar.gyR = this.gjC.gma.gog;
                aVar.gyQ = linkedList;
                break;
            default:
                v.e("MicroMsg.GamePBDataIndex", "unknowed TopRecommendBanner type : " + this.gjC.gma.efm);
                break;
        }
        return aVar;
    }
}
