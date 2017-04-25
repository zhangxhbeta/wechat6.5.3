package com.tencent.mm.ad;

import android.text.TextUtils;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.e.b.f;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.o;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.abl;
import com.tencent.mm.protocal.c.abm;
import com.tencent.mm.protocal.c.agh;
import com.tencent.mm.protocal.c.agi;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.g;
import com.tencent.mm.u.h;
import com.tencent.mm.u.n;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c extends k implements j {
    private ArrayList<o> cKH;
    private int cKI;
    private int cKJ;
    private int cKK;
    private int cKL;
    private HashMap<String, o> cKM = new HashMap();
    private String cKN;
    private final b cif;
    private e cii;

    public c(ArrayList<o> arrayList, int i, HashMap<String, o> hashMap, String str) {
        a aVar = new a();
        aVar.czn = new agh();
        aVar.czo = new agi();
        aVar.uri = "/cgi-bin/micromsg-bin/listgooglecontact";
        aVar.czm = 488;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.cKH = arrayList;
        this.cKI = i;
        this.cKJ = 0;
        this.cKL = 1;
        this.cKM = hashMap;
        this.cKN = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene");
        this.cii = eVar2;
        agh com_tencent_mm_protocal_c_agh = (agh) this.cif.czk.czs;
        if (this.cKH != null) {
            LinkedList linkedList = new LinkedList();
            this.cKK = this.cKH.size();
            int i = this.cKJ;
            while (i < this.cKK && i < this.cKJ + 500) {
                abm com_tencent_mm_protocal_c_abm = new abm();
                com_tencent_mm_protocal_c_abm.mgj = ((o) this.cKH.get(i)).field_googlegmail;
                linkedList.add(com_tencent_mm_protocal_c_abm);
                i++;
            }
            com_tencent_mm_protocal_c_agh.eeu = linkedList;
            com_tencent_mm_protocal_c_agh.eet = linkedList.size();
            if (this.cKJ + 500 > this.cKK) {
                this.cKL = 0;
            } else {
                this.cKL = 1;
            }
            com_tencent_mm_protocal_c_agh.miR = this.cKL;
            com_tencent_mm_protocal_c_agh.mFW = this.cKI;
            v.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doscene mTotalSize:%d, mStarIndex:%d, mContinueFlag:%d", Integer.valueOf(this.cKK), Integer.valueOf(this.cKJ), Integer.valueOf(this.cKL));
        }
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            a(Gj());
            if (this.cKL == 1) {
                this.cKJ += 500;
                if (a(this.czE, this.cii) < 0) {
                    v.e("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene again failed");
                    this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                }
            }
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }

    public final agi Gj() {
        return (agi) this.cif.czl.czs;
    }

    private synchronized void a(agi com_tencent_mm_protocal_c_agi) {
        v.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "handleListGoogleContactCGIResponse Count:%d", Integer.valueOf(com_tencent_mm_protocal_c_agi.eet));
        if (com_tencent_mm_protocal_c_agi.eeu != null && com_tencent_mm_protocal_c_agi.eeu.size() > 0) {
            int size = com_tencent_mm_protocal_c_agi.eeu.size();
            ArrayList arrayList = new ArrayList();
            List linkedList = new LinkedList();
            for (int i = 0; i < size; i++) {
                int i2;
                abl com_tencent_mm_protocal_c_abl = (abl) com_tencent_mm_protocal_c_agi.eeu.get(i);
                if (TextUtils.isEmpty(com_tencent_mm_protocal_c_abl.gln)) {
                    i2 = 1;
                } else {
                    ak.yW();
                    ab LX = com.tencent.mm.model.c.wH().LX(com_tencent_mm_protocal_c_abl.gln);
                    i2 = (LX == null || !com.tencent.mm.i.a.ei(LX.field_type)) ? 0 : 2;
                }
                if (this.cKM != null && this.cKM.containsKey(com_tencent_mm_protocal_c_abl.mgj)) {
                    o oVar = (o) this.cKM.get(com_tencent_mm_protocal_c_abl.mgj);
                    oVar.field_username = com_tencent_mm_protocal_c_abl.gln;
                    oVar.field_nickname = com_tencent_mm_protocal_c_abl.efy;
                    oVar.field_usernamepy = com.tencent.mm.platformtools.c.lU(com_tencent_mm_protocal_c_abl.efy);
                    oVar.field_nicknameqp = com.tencent.mm.platformtools.c.lT(com_tencent_mm_protocal_c_abl.efy);
                    oVar.field_ret = com_tencent_mm_protocal_c_abl.mcj;
                    oVar.field_small_url = com_tencent_mm_protocal_c_abl.mCI;
                    oVar.field_big_url = com_tencent_mm_protocal_c_abl.mCH;
                    oVar.field_status = i2;
                    oVar.field_googlecgistatus = 2;
                    if (i2 == 2 || i2 == 0) {
                        oVar.field_contecttype = "weixin" + i;
                    } else {
                        oVar.field_contecttype = "google";
                    }
                    oVar.field_googlenamepy = com.tencent.mm.platformtools.c.lU(oVar.field_googlename);
                    arrayList.add(oVar);
                    Object obj = oVar.field_googleid;
                    String str = oVar.field_googlephotourl;
                    String str2 = this.cKN;
                    if (!(TextUtils.isEmpty(obj) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
                        String str3 = obj + "@google";
                        h gQ = n.Bo().gQ(str3);
                        if (gQ == null) {
                            gQ = new h();
                        }
                        gQ.username = str3;
                        gQ.bBY = 3;
                        gQ.cyD = com.tencent.mm.u.b.N(str, str2);
                        gQ.cyC = com.tencent.mm.u.b.N(str, str2);
                        gQ.aP(true);
                        gQ.bkU = 31;
                        n.Bo().a(gQ);
                    }
                    f aVar = new g.a();
                    aVar.field_userName = com_tencent_mm_protocal_c_abl.gln;
                    aVar.field_scene = 58;
                    aVar.field_ticket = com_tencent_mm_protocal_c_abl.mvR;
                    linkedList.add(aVar);
                }
            }
            ah.FT().g(arrayList);
            ak.yW().xv().bR(linkedList);
        }
    }

    public final int getType() {
        return 488;
    }

    protected final int ul() {
        return 20;
    }

    protected final int a(p pVar) {
        return b.czU;
    }
}
