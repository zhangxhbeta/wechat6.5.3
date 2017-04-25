package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bdp;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.g;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class m extends k implements j {
    public int bdn;
    public String cKG;
    public final b cif;
    private e cii;
    public List<String> lzD;
    public String lzE;
    private List<String> lzF;

    private m(int i, String str, String str2, int i2) {
        this.lzD = null;
        this.bdn = 0;
        this.lzF = null;
        Assert.assertTrue("This NetSceneVerifyUser init MUST use opcode == MM_VERIFYUSER_VERIFYOK", true);
        this.lzD = new LinkedList();
        this.lzD.add(str);
        this.bdn = 3;
        a aVar = new a();
        aVar.czn = new bdo();
        aVar.czo = new bdp();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyuser";
        aVar.czm = 137;
        aVar.czp = 44;
        aVar.czq = 1000000044;
        this.cif = aVar.Bv();
        bdo com_tencent_mm_protocal_c_bdo = (bdo) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bdo.meB = 3;
        com_tencent_mm_protocal_c_bdo.mAS = SQLiteDatabase.KeyEmpty;
        LinkedList linkedList = new LinkedList();
        bdn com_tencent_mm_protocal_c_bdn = new bdn();
        com_tencent_mm_protocal_c_bdn.itR = str;
        com_tencent_mm_protocal_c_bdn.mZs = str2;
        com_tencent_mm_protocal_c_bdn.mvR = ak.yW().xv().Lw(str);
        com_tencent_mm_protocal_c_bdn.mQn = null;
        linkedList.add(com_tencent_mm_protocal_c_bdn);
        com_tencent_mm_protocal_c_bdo.mZx = linkedList;
        com_tencent_mm_protocal_c_bdo.mZw = linkedList.size();
        linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(i2));
        com_tencent_mm_protocal_c_bdo.mZz = linkedList;
        com_tencent_mm_protocal_c_bdo.mZy = linkedList.size();
        v.d("MicroMsg.NetSceneVerifyUser", "dkverify scene:%d user:%d ticket:%s, atispamTicket:%s", Integer.valueOf(com_tencent_mm_protocal_c_bdo.mZx.size()), Integer.valueOf(com_tencent_mm_protocal_c_bdo.mZz.size()), str2, com_tencent_mm_protocal_c_bdn.mvR);
    }

    public m(int i, List<String> list, List<Integer> list2, String str, String str2, Map<String, Integer> map, String str3) {
        this.lzD = null;
        this.bdn = 0;
        this.lzF = null;
        Assert.assertTrue("This NetSceneVerifyUser init NEVER use opcode == MM_VERIFYUSER_VERIFYOK", i != 3);
        this.bdn = i;
        this.lzD = list;
        a aVar = new a();
        aVar.czn = new bdo();
        aVar.czo = new bdp();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyuser";
        aVar.czm = 137;
        aVar.czp = 44;
        aVar.czq = 1000000044;
        this.cif = aVar.Bv();
        bdo com_tencent_mm_protocal_c_bdo = (bdo) this.cif.czk.czs;
        com_tencent_mm_protocal_c_bdo.meB = i;
        com_tencent_mm_protocal_c_bdo.mAS = str;
        this.lzE = str;
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            bdn com_tencent_mm_protocal_c_bdn = new bdn();
            com_tencent_mm_protocal_c_bdn.itR = (String) list.get(i2);
            com_tencent_mm_protocal_c_bdn.mZs = str2 == null ? SQLiteDatabase.KeyEmpty : str2;
            g xv = ak.yW().xv();
            String str4 = com_tencent_mm_protocal_c_bdn.itR;
            ((Integer) list2.get(i2)).intValue();
            com_tencent_mm_protocal_c_bdn.mvR = xv.Lw(str4);
            com_tencent_mm_protocal_c_bdn.mQn = str3;
            if (map != null && map.containsKey(com_tencent_mm_protocal_c_bdn.itR)) {
                com_tencent_mm_protocal_c_bdn.mZt = ((Integer) map.get(com_tencent_mm_protocal_c_bdn.itR)).intValue();
            }
            linkedList.add(com_tencent_mm_protocal_c_bdn);
        }
        com_tencent_mm_protocal_c_bdo.mZx = linkedList;
        com_tencent_mm_protocal_c_bdo.mZw = linkedList.size();
        LinkedList linkedList2 = new LinkedList();
        linkedList2.addAll(list2);
        com_tencent_mm_protocal_c_bdo.mZz = linkedList2;
        com_tencent_mm_protocal_c_bdo.mZy = linkedList2.size();
        v.d("MicroMsg.NetSceneVerifyUser", "dkverify scene:%d user:%d", Integer.valueOf(com_tencent_mm_protocal_c_bdo.mZx.size()), Integer.valueOf(com_tencent_mm_protocal_c_bdo.mZz.size()));
    }

    public m(String str, String str2, int i) {
        this(3, str, str2, i);
    }

    public m(int i, List<String> list, List<Integer> list2, String str, String str2) {
        this(i, list, list2, str, str2, null, null);
    }

    public final void dh(String str, String str2) {
        Iterator it = ((bdo) this.cif.czk.czs).mZx.iterator();
        while (it.hasNext()) {
            bdn com_tencent_mm_protocal_c_bdn = (bdn) it.next();
            com_tencent_mm_protocal_c_bdn.mZu = str;
            com_tencent_mm_protocal_c_bdn.mZv = str2;
        }
    }

    public final String bmW() {
        if (this.cif == null || this.cif.czl == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        return ((bdp) this.cif.czl.czs).gln;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 30;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            v.e("MicroMsg.NetSceneVerifyUser", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.cii.a(i2, i3, str, this);
    }
}
