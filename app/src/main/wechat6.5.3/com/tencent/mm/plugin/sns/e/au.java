package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.ago;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.protocal.c.ahn;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.protocal.c.aie;
import com.tencent.mm.protocal.c.aj;
import com.tencent.mm.protocal.c.al;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awk;
import com.tencent.mm.protocal.c.axj;
import com.tencent.mm.protocal.c.ayj;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.protocal.c.ce;
import com.tencent.mm.protocal.c.cl;
import com.tencent.mm.protocal.c.cn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class au {
    private static final Pattern dxu = Pattern.compile("(\n){3,}");
    private String bYE;
    public ahn boZ;
    public azr bpt = d.JI();
    int jdT;
    int jdU;
    List<h> joa;
    public int job;
    String joc;
    String jod;
    LinkedList<axj> joe;
    LinkedList<Long> jof;
    public aic jog = new aic();
    k joh = new k();
    awa joi = null;
    al joj;
    public ayj jok;
    public boolean jol;

    class AnonymousClass1 extends h<String, Integer, Boolean> {
        aib boL;
        final /* synthetic */ String dhf;
        final /* synthetic */ String jom;
        final /* synthetic */ au jon;

        public AnonymousClass1(au auVar, String str, String str2) {
            this.jon = auVar;
            this.dhf = str;
            this.jom = str2;
        }

        public final /* synthetic */ Object aRX() {
            long currentTimeMillis = System.currentTimeMillis();
            String str = ad.xi() + g.m(this.dhf.getBytes());
            FileOp.p(this.dhf, str);
            this.boL = au.m("", 2, str);
            v.d("MicroMsg.UploadPackHelper", "addImageMediaObjByPathAsync cost %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            return Boolean.valueOf(true);
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Boolean) obj);
            if (this.boL == null) {
                v.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
                return;
            }
            this.boL.gkC = this.jom;
            if (be.kS(this.boL.aXz)) {
                this.boL.aXz = this.jom;
            }
            v.i("MicroMsg.UploadPackHelper", "onPostExecute");
            this.jon.bpt.mWq.mom.add(this.boL);
            ago com_tencent_mm_protocal_c_ago = new ago();
            com_tencent_mm_protocal_c_ago.mGh = this.boL.jdV;
            this.jon.jog.mIn.add(com_tencent_mm_protocal_c_ago);
            this.jon.jol = true;
        }

        public final ac aRW() {
            return ad.aSr();
        }
    }

    public au(int i) {
        al alVar = new al();
        alVar.maK = new aj();
        alVar.maM = new ce();
        alVar.maN = new cn();
        this.joj = alVar;
        this.jok = new ayj();
        this.boZ = new ahn();
        this.bYE = "";
        this.jol = false;
        this.bYE = ad.aSk();
        this.job = i;
        this.bpt.mWq.mol = i;
        v.d("MicroMsg.UploadPackHelper", "contentType " + i);
        this.bpt.mHR = 0;
        this.bpt.gln = this.bYE;
        this.jog.mbN = g.m((ad.aSk() + be.Nj() + System.currentTimeMillis()).getBytes());
        this.jog.mIl = 0;
        this.jog.mIm = 0;
        this.jog.mHR = 0;
        this.jog.mIp = 0;
        this.jog.cxZ = 0;
        this.jog.mIr = 0;
        this.jog.jJL = 0;
        awa com_tencent_mm_protocal_c_awa = new awa();
        com_tencent_mm_protocal_c_awa.mjq = 0;
        com_tencent_mm_protocal_c_awa.hNS = 0;
        com_tencent_mm_protocal_c_awa.mTh = 0;
        com_tencent_mm_protocal_c_awa.mdw = ad.aSk();
        com_tencent_mm_protocal_c_awa.mTk = new LinkedList();
        com_tencent_mm_protocal_c_awa.mTi = 0;
        com_tencent_mm_protocal_c_awa.mTj = 0;
        com_tencent_mm_protocal_c_awa.mTq = new LinkedList();
        com_tencent_mm_protocal_c_awa.mTo = 0;
        com_tencent_mm_protocal_c_awa.mTp = 0;
        com_tencent_mm_protocal_c_awa.mTn = new LinkedList();
        com_tencent_mm_protocal_c_awa.mTl = 0;
        com_tencent_mm_protocal_c_awa.mTm = 0;
        com_tencent_mm_protocal_c_awa.mTr = 1;
        com_tencent_mm_protocal_c_awa.mTh = 0;
        com_tencent_mm_protocal_c_awa.mTs = 0;
        com_tencent_mm_protocal_c_awa.mTg = new are().ba(new byte[0]);
        this.joi = com_tencent_mm_protocal_c_awa;
        k kVar = this.joh;
        kVar.field_localFlag |= 16;
        this.joh.fw((int) (System.currentTimeMillis() / 1000));
        this.joh.field_type = i;
        this.joh.field_userName = this.bYE;
        this.joh.field_pravited = 0;
        this.joh.field_stringSeq = "0000099999999999999999999";
        this.joh.qA(2);
        this.joh.aUI();
        if (i == 1 || i == 2) {
            this.joh.qA(4);
        }
        if (i == 7) {
            this.joh.qD(2);
        }
        this.jof = new LinkedList();
        this.jog.mIs = this.jof;
        Iterator it = this.jof.iterator();
        while (it.hasNext()) {
            long longValue = ((Long) it.next()).longValue();
            avw com_tencent_mm_protocal_c_avw = new avw();
            com_tencent_mm_protocal_c_avw.mTf = longValue;
            this.joi.mcs.add(com_tencent_mm_protocal_c_avw);
        }
        this.joi.mKB = this.jof.size();
    }

    private static String AF(String str) {
        String str2;
        if (str == null) {
            try {
                str2 = "";
            } catch (Exception e) {
                str2 = str;
                v.e("MicroMsg.UploadPackHelper", "filter desc error ");
                return str2;
            }
        }
        str2 = str;
        try {
            str2 = dxu.matcher(str2.trim().replace("\r\n", "\n")).replaceAll("\n\n");
        } catch (Exception e2) {
            v.e("MicroMsg.UploadPackHelper", "filter desc error ");
            return str2;
        }
        return str2;
    }

    public final au AG(String str) {
        this.joc = AF(str);
        this.bpt.mWn = this.joc;
        return this;
    }

    public final au cE(String str, String str2) {
        this.jog.token = str;
        this.jog.mIu = str2;
        return this;
    }

    public final au qk(int i) {
        this.bpt.mWs = 1;
        this.bpt.mWt = i;
        return this;
    }

    public final au AH(String str) {
        this.bpt.mWu = str;
        this.joj.maK.maD = str;
        return this;
    }

    public final au AI(String str) {
        this.bpt.jYp = str;
        return this;
    }

    public final au N(String str, String str2, String str3) {
        aj ajVar = this.joj.maK;
        if (be.kS(str)) {
            str = "";
        }
        ajVar.glj = str;
        ajVar = this.joj.maK;
        if (be.kS(str2)) {
            str2 = "";
        }
        ajVar.maE = str2;
        ajVar = this.joj.maK;
        if (be.kS(str3)) {
            str3 = "";
        }
        ajVar.maF = str3;
        return this;
    }

    public final au AJ(String str) {
        this.jod = str;
        this.bpt.mWq.gkC = str;
        return this;
    }

    public final au AK(String str) {
        this.bpt.mWq.glb = str;
        return this;
    }

    public final au AL(String str) {
        this.bpt.mWq.aXz = str;
        return this;
    }

    public final void ql(int i) {
        v.d("MicroMsg.UploadPackHelper", "set post form " + i);
        this.jog.mIr = i;
    }

    public final au a(agp com_tencent_mm_protocal_c_agp) {
        if (com_tencent_mm_protocal_c_agp != null) {
            this.bpt.mWo = com_tencent_mm_protocal_c_agp;
        }
        return this;
    }

    public final au qm(int i) {
        this.jdU = i;
        this.jog.mHR = i;
        this.bpt.mHR = i;
        if (i > 0) {
            this.joh.field_pravited = i;
            this.joh.aUF();
            this.joh.qD(2);
            this.joh.aUJ();
        }
        return this;
    }

    public final au qn(int i) {
        this.jdT = i;
        this.jog.mIm = i;
        return this;
    }

    public final au Y(LinkedList<axj> linkedList) {
        this.joe = linkedList;
        this.jog.mIo = linkedList;
        Iterator it = this.joe.iterator();
        while (it.hasNext()) {
            axj com_tencent_mm_protocal_c_axj = (axj) it.next();
            avr com_tencent_mm_protocal_c_avr = new avr();
            com_tencent_mm_protocal_c_avr.mdw = com_tencent_mm_protocal_c_axj.gln;
            this.joi.mTq.add(com_tencent_mm_protocal_c_avr);
        }
        this.joi.mTo = this.joe.size();
        this.joi.mTp = this.joe.size();
        return this;
    }

    public final au qo(int i) {
        this.jog.jJL = i;
        return this;
    }

    public final au AM(String str) {
        cl clVar = this.bpt.mWp;
        if (clVar == null) {
            clVar = new cl();
        }
        clVar.gID = str;
        this.bpt.mWp = clVar;
        return this;
    }

    public final au AN(String str) {
        cl clVar = this.bpt.mWp;
        if (clVar == null) {
            clVar = new cl();
        }
        clVar.hNZ = str;
        this.bpt.mWp = clVar;
        return this;
    }

    public final au AO(String str) {
        this.bpt.lJi = be.ma(str);
        return this;
    }

    public final au AP(String str) {
        this.bpt.lJj = be.ma(str);
        return this;
    }

    public final au bo(List<String> list) {
        if (list == null || list.size() == 0) {
            this.joi.mTr = 1;
        } else {
            LinkedList linkedList = new LinkedList();
            for (String str : list) {
                arf com_tencent_mm_protocal_c_arf = new arf();
                com_tencent_mm_protocal_c_arf.JF(str);
                linkedList.add(com_tencent_mm_protocal_c_arf);
            }
            this.jog.mIw = linkedList;
            if (this.joi.mTr == 3) {
                this.joi.mTw = linkedList;
                this.joi.mTv = linkedList.size();
            } else if (this.joi.mTr == 5) {
                this.joi.mIw = linkedList;
                this.joi.mTx = linkedList.size();
            }
        }
        return this;
    }

    public final au qp(int i) {
        if (i == 1) {
            this.joi.mTr = 3;
        } else if (i == 0) {
            this.joi.mTr = 5;
        }
        this.jog.mIv = i;
        return this;
    }

    private static aib q(String str, byte[] bArr) {
        if (be.bl(bArr)) {
            v.e("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.sm() + " attachBuf is null");
            return null;
        }
        String str2 = ad.xi() + g.m((" " + System.currentTimeMillis()).getBytes());
        v.d("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.sm() + " buildUploadAttachInfo file:" + str2);
        if (FileOp.b(str2, bArr, bArr.length) >= 0) {
            return m(str, 2, str2);
        }
        v.e("MicroMsg.UploadPackHelper", com.tencent.mm.compatible.util.g.sm() + " writeFile error file:" + str2);
        return null;
    }

    private static aib m(String str, int i, String str2) {
        aid com_tencent_mm_protocal_c_aid = null;
        aib JJ = d.JJ();
        JJ.gID = str;
        v.d("MicroMsg.UploadPackHelper", new StringBuilder("mediaOBj type 2").toString());
        JJ.efm = 2;
        if (FileOp.jP(str2) <= 0) {
            return null;
        }
        String str3 = ad.xi() + g.m((str2 + System.currentTimeMillis()).getBytes());
        FileOp.p(str2, str3);
        h hVar = new h(str3, 2);
        List linkedList = new LinkedList();
        linkedList.add(hVar);
        linkedList = ad.aSt().bs(linkedList);
        if (linkedList == null || linkedList.size() == 0) {
            return null;
        }
        h hVar2 = (h) linkedList.get(0);
        if (hVar2.height > 0 && hVar2.width > 0 && hVar2.fileSize > 0) {
            com_tencent_mm_protocal_c_aid = new aid();
            com_tencent_mm_protocal_c_aid.lHK = (float) hVar2.height;
            com_tencent_mm_protocal_c_aid.mID = (float) hVar2.width;
            com_tencent_mm_protocal_c_aid.mIE = (float) hVar2.fileSize;
        }
        JJ.gID = "Locall_path" + hVar2.jdV;
        JJ.mHS = com_tencent_mm_protocal_c_aid;
        JJ.jdV = hVar2.jdV;
        return JJ;
    }

    public static aib O(String str, String str2, String str3) {
        aib JJ = d.JJ();
        JJ.gID = str;
        v.d("MicroMsg.UploadPackHelper", new StringBuilder("mediaOBj type 2").toString());
        JJ.efm = 2;
        JJ.glb = str2;
        JJ.mHO = 0;
        JJ.mHP = str3;
        JJ.mHQ = 0;
        JJ.mHV = 1;
        return JJ;
    }

    public final boolean i(String str, String str2, String str3, String str4) {
        aid com_tencent_mm_protocal_c_aid = null;
        String str5 = ad.xi() + g.m(str.getBytes());
        FileOp.p(str, str5);
        String str6 = ad.xi() + g.m(str2.getBytes());
        FileOp.p(str2, str6);
        aib JJ = d.JJ();
        JJ.gID = "";
        v.i("MicroMsg.UploadPackHelper", "mediaType %d  videopath %s sightmd5 %s", new Object[]{Integer.valueOf(6), str5, str4});
        JJ.efm = 6;
        if (FileOp.jP(str5) > 0) {
            h hVar = new h(str5, 6);
            hVar.jdY = str4;
            h a = ad.aSt().a(hVar, str5, str6);
            if (a.height > 0 && a.width > 0 && a.fileSize > 0) {
                com_tencent_mm_protocal_c_aid = new aid();
                com_tencent_mm_protocal_c_aid.lHK = (float) a.height;
                com_tencent_mm_protocal_c_aid.mID = (float) a.width;
                com_tencent_mm_protocal_c_aid.mIE = (float) a.fileSize;
            }
            JJ.gID = "Locall_path" + a.jdV;
            JJ.mHS = com_tencent_mm_protocal_c_aid;
            JJ.jdV = a.jdV;
            aib com_tencent_mm_protocal_c_aib = JJ;
        }
        if (com_tencent_mm_protocal_c_aib == null) {
            v.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
            return false;
        }
        com_tencent_mm_protocal_c_aib.gkC = str3;
        if (be.kS(com_tencent_mm_protocal_c_aib.aXz)) {
            com_tencent_mm_protocal_c_aib.aXz = str3;
        }
        this.bpt.mWq.mom.add(com_tencent_mm_protocal_c_aib);
        ago com_tencent_mm_protocal_c_ago = new ago();
        com_tencent_mm_protocal_c_ago.mGh = com_tencent_mm_protocal_c_aib.jdV;
        this.jog.mIn.add(com_tencent_mm_protocal_c_ago);
        return true;
    }

    public final boolean cF(String str, String str2) {
        String str3 = ad.xi() + g.m(str.getBytes());
        FileOp.p(str, str3);
        aib m = m("", 2, str3);
        if (m == null) {
            v.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
            return false;
        }
        m.gkC = str2;
        if (be.kS(m.aXz)) {
            m.aXz = str2;
        }
        this.bpt.mWq.mom.add(m);
        ago com_tencent_mm_protocal_c_ago = new ago();
        com_tencent_mm_protocal_c_ago.mGh = m.jdV;
        this.jog.mIn.add(com_tencent_mm_protocal_c_ago);
        return true;
    }

    @Deprecated
    public final boolean a(String str, String str2, String str3, int i, String str4) {
        aib O = O("", str, str2);
        if (O == null) {
            v.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
            return false;
        }
        O.gkC = str3;
        if (i > 0) {
            O.aYp = i;
        }
        if (!be.kS(str4)) {
            O.jFe = str4;
        }
        this.bpt.mWq.mom.add(O);
        return true;
    }

    public final boolean a(byte[] bArr, String str, String str2) {
        return a(bArr, str, str2, -1, "");
    }

    public final boolean a(byte[] bArr, String str, String str2, int i, String str3) {
        aib q = q("", bArr);
        if (q == null) {
            v.e("MicroMsg.UploadPackHelper", "share img o.data is null!");
            return false;
        }
        q.gkC = str;
        if (i > 0) {
            q.aYp = i;
        }
        if (!be.kS(str3)) {
            q.jFe = str3;
        }
        if (!be.kS(str2)) {
            q.aXz = str2;
        }
        if (!be.kS(str)) {
            q.gkC = str;
        }
        this.bpt.mWq.mom.add(q);
        ago com_tencent_mm_protocal_c_ago = new ago();
        com_tencent_mm_protocal_c_ago.mGh = q.jdV;
        this.jog.mIn.add(com_tencent_mm_protocal_c_ago);
        return true;
    }

    public final boolean a(byte[] bArr, String str, String str2, String str3, int i, String str4, String str5) {
        aib q = q("", bArr);
        if (q == null || (be.kS(str2) && be.kS(str3))) {
            v.e("MicroMsg.UploadPackHelper", "share music/video  appmsg.thumbData is null!");
            return false;
        }
        if (!be.kS(str)) {
            this.bpt.mWq.glb = str;
        }
        if (!be.kS(str3)) {
            q.glb = str3;
            q.mHO = 0;
        } else if (!be.kS(str2)) {
            q.glb = str2;
            q.mHO = 0;
        }
        if (!be.kS(str2)) {
            q.mHT = str2;
            q.mHU = 0;
        }
        q.efm = i;
        q.aXz = be.ah(str4, "");
        q.gkC = be.ah(str5, "");
        this.bpt.mWq.mom.add(q);
        ago com_tencent_mm_protocal_c_ago = new ago();
        com_tencent_mm_protocal_c_ago.mGh = q.jdV;
        this.jog.mIn.add(com_tencent_mm_protocal_c_ago);
        return true;
    }

    public final void bp(List<h> list) {
        this.joa = list;
        List<h> bs = ad.aSt().bs(this.joa);
        LinkedList linkedList = new LinkedList();
        if (bs != null) {
            for (h hVar : bs) {
                ago com_tencent_mm_protocal_c_ago = new ago();
                com_tencent_mm_protocal_c_ago.mGh = hVar.jdV;
                linkedList.add(com_tencent_mm_protocal_c_ago);
            }
            this.jog.mIn = linkedList;
            for (h hVar2 : bs) {
                aid com_tencent_mm_protocal_c_aid = new aid();
                com_tencent_mm_protocal_c_aid.lHK = 0.0f;
                com_tencent_mm_protocal_c_aid.mID = 0.0f;
                com_tencent_mm_protocal_c_aid.mIE = 0.0f;
                if (hVar2.height > 0 && hVar2.width > 0 && hVar2.fileSize > 0) {
                    com_tencent_mm_protocal_c_aid.lHK = (float) hVar2.height;
                    com_tencent_mm_protocal_c_aid.mID = (float) hVar2.width;
                    com_tencent_mm_protocal_c_aid.mIE = (float) hVar2.fileSize;
                }
                this.bpt.mWq.mom.add(d.a("Locall_path" + hVar2.jdV, hVar2.type, "", "", 0, 0, this.jdU, "", com_tencent_mm_protocal_c_aid));
            }
        }
    }

    public final void d(String str, String str2, String str3, int i, int i2) {
        awk com_tencent_mm_protocal_c_awk = new awk();
        com_tencent_mm_protocal_c_awk.mcR = str;
        com_tencent_mm_protocal_c_awk.mcS = str2;
        com_tencent_mm_protocal_c_awk.mcT = str3;
        com_tencent_mm_protocal_c_awk.jhO = i;
        com_tencent_mm_protocal_c_awk.jhP = i2;
        this.jog.mIx = com_tencent_mm_protocal_c_awk;
    }

    public final void AQ(String str) {
        this.jog.aZj = str;
    }

    public final int commit() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.jog.mIq = System.currentTimeMillis();
            this.jog.cxZ = 0;
            this.joh.aC(this.joi.toByteArray());
            this.joh.field_postBuf = this.jog.toByteArray();
            v.d("MicroMsg.UploadPackHelper", "snsObj " + this.joi.toString());
            v.d("MicroMsg.UploadPackHelper", "postinfo " + this.jog.toString());
        } catch (Throwable e) {
            v.a("MicroMsg.UploadPackHelper", e, "", new Object[0]);
        }
        v.d("MicroMsg.UploadPackHelper", "timelineObj " + this.bpt.toString());
        if (this.bpt.mWq.mom != null) {
            v.d("MicroMsg.UploadPackHelper", "timelineObj MeidaCount %d ", new Object[]{Integer.valueOf(this.bpt.mWq.mom.size())});
            for (int i = 0; i < this.bpt.mWq.mom.size(); i++) {
                if (((aib) this.bpt.mWq.mom.get(i)) != null) {
                    v.d("MicroMsg.UploadPackHelper", "timelineObj media %d %s", new Object[]{Integer.valueOf(((aib) this.bpt.mWq.mom.get(i)).jdV), be.ah(((aib) this.bpt.mWq.mom.get(i)).glb, "")});
                }
            }
        }
        if (this.joj != null) {
            this.bpt.joj = this.joj;
        }
        this.joh.b(this.bpt);
        int y = ad.aSE().y(this.joh);
        Iterator it = this.jog.mIn.iterator();
        String str = null;
        while (it.hasNext()) {
            ago com_tencent_mm_protocal_c_ago = (ago) it.next();
            o de = ad.aSt().de((long) com_tencent_mm_protocal_c_ago.mGh);
            try {
                aie com_tencent_mm_protocal_c_aie = (aie) new aie().az(de.jCs);
                if (this.bpt.mWp != null) {
                    com_tencent_mm_protocal_c_aie.bmJ = this.bpt.mWp.gID;
                }
                if (this.boZ != null) {
                    this.boZ.mHe = 0;
                }
                com_tencent_mm_protocal_c_aie.mIM = this.boZ;
                com_tencent_mm_protocal_c_aie.job = this.bpt.mWq.mol;
                de.jCs = com_tencent_mm_protocal_c_aie.toByteArray();
                ad.aSt().a(com_tencent_mm_protocal_c_ago.mGh, de);
                str = com_tencent_mm_protocal_c_aie.aZy;
            } catch (Exception e2) {
                v.e("MicroMsg.UploadPackHelper", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
            }
        }
        v.i("MicroMsg.UploadPackHelper", "commit sns info ret %d, typeFlag %d sightMd5 %s", new Object[]{Integer.valueOf(y), Integer.valueOf(this.joh.field_type), str});
        if (y > 0 && this.joh.field_type == 15) {
            an.cC(s.A("sns_table_", (long) y), str);
        }
        v.d("MicroMsg.UploadPackHelper", "pack commit result " + y + " cost " + (System.currentTimeMillis() - currentTimeMillis));
        return y;
    }
}
