package com.tencent.mm.plugin.product.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.product.c.a;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.plugin.product.ui.e;
import com.tencent.mm.protocal.c.afg;
import com.tencent.mm.protocal.c.ak;
import com.tencent.mm.protocal.c.ank;
import com.tencent.mm.protocal.c.apv;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.protocal.c.avd;
import com.tencent.mm.protocal.c.bt;
import com.tencent.mm.protocal.c.ng;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class c {
    private d hQb = null;
    public m hQc;
    public List<n> hQd;
    public String hQe;
    public String hQf;
    public String hQg;
    public pc hQh;
    public bt hQi;
    public apv hQj;
    public String hQk;
    public String hQl;
    public int hQm;
    public Map<String, e> hQn;
    public Map<String, String> hQo = new HashMap();
    public LinkedList<pc> hQp;
    public LinkedList<ak> hQq;
    public e hQr;
    private e hQs;
    public Map<String, LinkedList<ng>> hQt = null;
    public int mCount = 1;

    public final void clear() {
        this.hQc = null;
        if (this.hQd != null) {
            this.hQd.clear();
            this.hQd = null;
        }
        this.hQe = null;
        this.hQf = null;
        this.mCount = 1;
        this.hQg = null;
        this.hQh = null;
        this.hQj = null;
        this.hQk = null;
        this.hQm = 0;
        this.hQr = null;
        if (this.hQn != null) {
            this.hQn.clear();
            this.hQn = null;
        }
        if (this.hQo != null) {
            this.hQo.clear();
        }
        if (this.hQp != null) {
            this.hQp.clear();
            this.hQp = null;
        }
        if (this.hQt != null) {
            this.hQt.clear();
            this.hQt = null;
        }
    }

    public final void a(m mVar, List<n> list) {
        int i;
        int i2 = 0;
        clear();
        this.hQc = mVar;
        this.hQd = list;
        if (be.kS(this.hQc.hQK)) {
            this.hQc.hQK = this.hQf;
        }
        LinkedList linkedList = this.hQc.hQI;
        this.hQn = new HashMap();
        if (linkedList != null && linkedList.size() > 0) {
            int size = linkedList.size();
            for (int i3 = 0; i3 < size; i3++) {
                l lVar = (l) linkedList.get(i3);
                a(lVar.hRl.split(";"), lVar);
            }
            aGo();
        }
        if (!(this.hQc.hQG == null || this.hQc.hQG.hRc == null)) {
            this.hQm = this.hQc.hQG.hRc.size();
        }
        if (!(this.hQc.hQG == null || this.hQc.hQG.hQV == null || this.hQc.hQG.hQV.size() <= 0)) {
            this.hQk = (String) this.hQc.hQG.hQV.get(0);
        }
        if (!be.kS(this.hQc.aGs())) {
            j.a(new com.tencent.mm.plugin.product.ui.c(this.hQc.aGs()));
            v.d("MicroMsg.MallProductManager", "product img path : " + aGg());
        }
        if (this.hQc.hQJ == null || this.hQc.hQJ.hRg == null) {
            i = 0;
        } else {
            i = this.hQc.hQJ.hRg.bkU;
        }
        if (this.hQc.hQH != null) {
            i2 = this.hQc.hQH.bkU;
        }
        this.hQs = new e(i, i2);
    }

    public final e aFZ() {
        if (this.hQs == null) {
            this.hQs = new e(0, 0);
        }
        return this.hQs;
    }

    public final String aGa() {
        if (this.hQr == null || be.kS(this.hQr.url)) {
            return this.hQk;
        }
        return this.hQr.url;
    }

    public final String aGb() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.hQc.hQG.hRc.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            String str = (String) this.hQo.get(mVar.hRo);
            if (str != null) {
                Iterator it2 = mVar.hRq.iterator();
                while (it2.hasNext()) {
                    h hVar = (h) it2.next();
                    if (str.equals(hVar.id)) {
                        stringBuilder.append(hVar.name).append(" ");
                        break;
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    public final void E(Intent intent) {
        bt btVar = new bt();
        btVar.gln = be.ah(intent.getStringExtra("userName"), "");
        btVar.mcl = be.ah(intent.getStringExtra("telNumber"), "");
        btVar.mcm = be.ah(intent.getStringExtra("addressPostalCode"), "");
        btVar.cHd = be.ah(intent.getStringExtra("proviceFirstStageName"), "");
        btVar.cHe = be.ah(intent.getStringExtra("addressCitySecondStageName"), "");
        btVar.cHl = be.ah(intent.getStringExtra("addressCountiesThirdStageName"), "");
        btVar.glo = be.ah(intent.getStringExtra("addressDetailInfo"), "");
        if (!be.kS(btVar.gln) && !be.kS(btVar.mcl)) {
            this.hQi = btVar;
        }
    }

    public final LinkedList<a> I(Activity activity) {
        LinkedList<a> linkedList = new LinkedList();
        if (this.hQq != null) {
            Iterator it = this.hQq.iterator();
            while (it.hasNext()) {
                ak akVar = (ak) it.next();
                a aVar = new a();
                aVar.gkB = akVar.gkB;
                aVar.hQO = akVar.hQO;
                aVar.hQP = akVar.hQP;
                aVar.efm = akVar.efm;
                aVar.gnp = akVar.gnp;
                if (aVar.efm == 1 && xI(aVar.hQP) > 0) {
                    aVar.hQO = activity.getString(2131233782, new Object[]{b.c((double) xI(aVar.hQP), this.hQc.hQG.hNg)});
                }
                linkedList.add(aVar);
            }
        }
        return linkedList;
    }

    public final void nZ(int i) {
        if (this.hQp != null && i < this.hQp.size() && i >= 0) {
            this.hQh = (pc) this.hQp.get(i);
        }
    }

    public final int aGc() {
        int i = 0;
        if (!(aFZ().aGv() || this.hQh == null)) {
            i = this.hQh.mjf + 0;
        }
        if (this.hQr != null) {
            i += this.hQr.hQv * this.mCount;
        } else {
            i += this.hQc.hQG.hQT * this.mCount;
        }
        return i - aGd();
    }

    public final int aGd() {
        if (this.hQt == null || this.hQt.size() <= 0) {
            return 0;
        }
        int i = 0;
        for (LinkedList linkedList : this.hQt.values()) {
            if (linkedList != null && linkedList.size() > 0) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    i += ((ng) it.next()).mjf;
                }
            }
            i = i;
        }
        return i;
    }

    private int xI(String str) {
        int i = 0;
        if (this.hQt != null && this.hQt.size() > 0) {
            LinkedList linkedList = (LinkedList) this.hQt.get(str);
            if (linkedList != null && linkedList.size() > 0) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    i = ((ng) it.next()).mjf + i;
                }
            }
        }
        return i;
    }

    public final apv aGe() {
        if (this.hQj != null) {
            return this.hQj;
        }
        if (this.hQb == null) {
            this.hQb = com.tencent.mm.plugin.product.a.a.aFW().aFY();
        }
        d dVar = this.hQb;
        String str = (dVar.hQu == null || dVar.hQu.size() <= 0) ? null : (String) dVar.hQu.get(0);
        if (be.kS(str)) {
            bt btVar = this.hQi;
            if (btVar == null || be.kS(btVar.gln)) {
                return null;
            }
            this.hQj = new apv();
            this.hQj.glo = btVar.gln;
            this.hQj.mPl = 1;
            return this.hQj;
        }
        this.hQj = new apv();
        this.hQj.glo = str;
        this.hQj.mPl = 1;
        return this.hQj;
    }

    public final String getAppId() {
        if (this.hQc.hQH != null) {
            return this.hQc.hQH.bmJ;
        }
        return null;
    }

    public final String aGf() {
        if (this.hQc.hQH != null) {
            return this.hQc.hQH.username;
        }
        return null;
    }

    public final String aGg() {
        if (be.kS(this.hQc.aGs())) {
            return null;
        }
        return com.tencent.mm.plugin.product.ui.c.xK(this.hQc.aGs());
    }

    public final String aGh() {
        if (this.hQc.hQG != null && this.hQc.hQG.hRe != null) {
            return this.hQc.hQG.hRe.url;
        }
        if (be.kS(this.hQc.hQK)) {
            return this.hQf;
        }
        return this.hQc.hQK;
    }

    public final int aGi() {
        int i = this.hQc.hQE;
        if (this.hQr == null || i <= this.hQr.hQE) {
            return i;
        }
        return this.hQr.hQE;
    }

    public final boolean aGj() {
        return (this.mCount <= 0 || this.hQc == null || this.mCount > aGi() || this.hQc.hQG == null || this.hQc.hQG.hRc == null) ? false : true;
    }

    public final boolean aGk() {
        if (!aGj() || this.hQo == null || this.hQo.size() != this.hQm) {
            return false;
        }
        if (this.hQm > 0) {
            if (this.hQr == null || this.mCount <= 0 || this.mCount > aGi()) {
                return false;
            }
            return true;
        } else if (this.hQm == 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean aGl() {
        if (!aGk() || this.hQi == null) {
            return false;
        }
        if (aFZ().aGv() || this.hQh != null) {
            return true;
        }
        return false;
    }

    public final LinkedList<arj> aGm() {
        LinkedList<arj> linkedList = new LinkedList();
        arj com_tencent_mm_protocal_c_arj = new arj();
        com_tencent_mm_protocal_c_arj.eet = this.mCount;
        com_tencent_mm_protocal_c_arj.mzY = this.hQc.hQC;
        com_tencent_mm_protocal_c_arj.mNG = this.hQc.hQK;
        com_tencent_mm_protocal_c_arj.mNH = this.hQg;
        linkedList.add(com_tencent_mm_protocal_c_arj);
        return linkedList;
    }

    public final avd aGn() {
        avd com_tencent_mm_protocal_c_avd = new avd();
        com_tencent_mm_protocal_c_avd.mjX = this.hQe;
        com_tencent_mm_protocal_c_avd.hOe = 1;
        com_tencent_mm_protocal_c_avd.mSy = new LinkedList();
        ank com_tencent_mm_protocal_c_ank = new ank();
        com_tencent_mm_protocal_c_ank.eet = this.mCount;
        com_tencent_mm_protocal_c_ank.mzY = this.hQc.hQC;
        com_tencent_mm_protocal_c_ank.gkB = this.hQc.hQG.name;
        if (this.hQr != null) {
            com_tencent_mm_protocal_c_ank.mNF = this.hQr.hQv;
        } else {
            com_tencent_mm_protocal_c_ank.mNF = this.hQc.hQG.hQT;
        }
        com_tencent_mm_protocal_c_ank.mNG = this.hQc.hQK;
        com_tencent_mm_protocal_c_ank.mNH = this.hQg;
        com_tencent_mm_protocal_c_ank.efm = this.hQc.hQD;
        com_tencent_mm_protocal_c_ank.mND = this.hQm;
        com_tencent_mm_protocal_c_ank.mNE = new LinkedList();
        for (String str : this.hQo.keySet()) {
            String str2 = (String) this.hQo.get(str);
            afg com_tencent_mm_protocal_c_afg = new afg();
            com_tencent_mm_protocal_c_afg.mhC = str;
            com_tencent_mm_protocal_c_afg.itR = str2;
            com_tencent_mm_protocal_c_ank.mNE.add(com_tencent_mm_protocal_c_afg);
        }
        com_tencent_mm_protocal_c_ank.mNL = new LinkedList();
        com_tencent_mm_protocal_c_ank.mNK = 0;
        if (this.hQt != null && this.hQt.size() > 0) {
            for (LinkedList linkedList : this.hQt.values()) {
                com_tencent_mm_protocal_c_ank.mNL.addAll(linkedList);
                com_tencent_mm_protocal_c_ank.mNK = linkedList.size() + com_tencent_mm_protocal_c_ank.mNK;
            }
        }
        com_tencent_mm_protocal_c_avd.mSy.add(com_tencent_mm_protocal_c_ank);
        com_tencent_mm_protocal_c_avd.mSA = new LinkedList();
        com_tencent_mm_protocal_c_avd.mSB = 1;
        this.hQj = aGe();
        if (this.hQj != null) {
            com_tencent_mm_protocal_c_avd.mSA.add(this.hQj);
        } else {
            this.hQj = new apv();
            this.hQj.mPl = 0;
            com_tencent_mm_protocal_c_avd.mSA.add(this.hQj);
        }
        com_tencent_mm_protocal_c_avd.myZ = this.hQi;
        com_tencent_mm_protocal_c_avd.mSz = this.hQh;
        return com_tencent_mm_protocal_c_avd;
    }

    public final void aGo() {
        if (this.hQo != null) {
            Iterator it = this.hQc.hQG.hRc.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                Iterator it2 = mVar.hRq.iterator();
                while (it2.hasNext()) {
                    boolean z;
                    h hVar = (h) it2.next();
                    String str = mVar.hRo;
                    String str2 = hVar.id;
                    if (this.hQo == null || this.hQn == null) {
                        z = false;
                    } else if (this.hQo.containsKey(str)) {
                        r2 = (String) this.hQo.get(str);
                        this.hQo.put(str, str2);
                        str2 = x(this.hQo);
                        this.hQo.put(str, r2);
                        r2 = (e) this.hQn.get(str2);
                        z = r2 != null ? r2.hQE > 0 : false;
                    } else {
                        this.hQo.put(str, str2);
                        r2 = x(this.hQo);
                        this.hQo.remove(str);
                        r2 = (e) this.hQn.get(r2);
                        z = r2 != null ? r2.hQE > 0 : false;
                    }
                    hVar.hRi = z;
                    v.d("MicroMsg.MallProductManager", "(" + mVar.hRo + " , " + hVar.id + ") hasStock--> " + hVar.hRi);
                }
            }
        }
    }

    public static String x(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Object arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new Comparator<Entry<String, String>>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return ((String) ((Entry) obj).getKey()).compareTo((String) ((Entry) obj2).getKey());
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuilder.append((String) entry.getKey()).append(":").append((String) entry.getValue()).append(";");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(";"));
        return stringBuilder.toString();
    }

    private void a(String[] strArr, l lVar) {
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i = -1 >>> (32 - length);
            for (int i2 = 1; i2 <= i; i2++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i3 = 0; i3 < length; i3++) {
                    if (((i2 << (31 - i3)) >> 31) == -1) {
                        stringBuilder.append(strArr[i3]).append(";");
                    }
                }
                stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(";"));
                e eVar = (e) this.hQn.get(stringBuilder.toString());
                if (eVar != null) {
                    if (eVar.hQv < lVar.hRm) {
                        eVar.hQv = lVar.hRm;
                    }
                    if (eVar.hQw > lVar.hRm) {
                        eVar.hQw = lVar.hRm;
                    }
                    eVar.hQE += lVar.hQE;
                } else {
                    eVar = new e();
                    eVar.hQv = lVar.hRm;
                    eVar.hQw = lVar.hRm;
                    eVar.hQE = lVar.hQE;
                    eVar.hRn = lVar.hRn;
                    eVar.url = lVar.url;
                    this.hQn.put(stringBuilder.toString(), eVar);
                }
            }
        }
    }

    public final String aGp() {
        com.tencent.mm.q.a.a aVar = new com.tencent.mm.q.a.a();
        aVar.title = this.hQc.hQG.name;
        aVar.description = aGq();
        aVar.type = 13;
        aVar.url = aGh();
        aVar.thumburl = this.hQc.aGs();
        aVar.coD = this.hQc.hQD;
        aVar.coE = a(this.hQc);
        return com.tencent.mm.q.a.a.b(aVar);
    }

    public final String aGq() {
        return b.c((double) this.hQc.hQG.hQU, this.hQc.hQG.hNg);
    }

    public final String a(m mVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<mallProductInfo>");
        stringBuilder.append("<type>").append(mVar.hQD).append("</type>");
        stringBuilder.append("<id>").append(mVar.hQC).append("</id>");
        stringBuilder.append("<version>").append(mVar.hQG.version).append("</version>");
        stringBuilder.append("<name>").append(be.KJ(mVar.hQG.name)).append("</name>");
        stringBuilder.append("<highPrice>").append(mVar.hQG.hQT).append("</highPrice>");
        stringBuilder.append("<lowPrice>").append(mVar.hQG.hQU).append("</lowPrice>");
        stringBuilder.append("<originPrice>").append(mVar.hQG.hQS).append("</originPrice>");
        stringBuilder.append("<sourceUrl>").append(be.KJ(this.hQc.hQK)).append("</sourceUrl>");
        if (mVar.hQG.hQV != null) {
            stringBuilder.append("<imgCount>").append(mVar.hQG.hQV.size()).append("</imgCount>");
            stringBuilder.append("<imgList>");
            Iterator it = mVar.hQG.hQV.iterator();
            while (it.hasNext()) {
                stringBuilder.append("<imgUrl>").append(be.KJ((String) it.next())).append("</imgUrl>");
            }
            stringBuilder.append("</imgList>");
        }
        stringBuilder.append("<shareInfo>");
        stringBuilder.append("<shareUrl>").append(be.KJ(aGh())).append("</shareUrl>");
        stringBuilder.append("<shareThumbUrl>").append(be.KJ(mVar.aGs())).append("</shareThumbUrl>");
        stringBuilder.append("</shareInfo>");
        if (this.hQc.hQH != null) {
            stringBuilder.append("<sellerInfo>");
            stringBuilder.append("<appID>").append(mVar.hQH.bmJ).append("</appID>");
            stringBuilder.append("<appName>").append(mVar.hQH.name).append("</appName>");
            stringBuilder.append("<usrName>").append(mVar.hQH.username).append("</usrName>");
            stringBuilder.append("</sellerInfo>");
        }
        stringBuilder.append("</mallProductInfo>");
        return stringBuilder.toString();
    }
}
