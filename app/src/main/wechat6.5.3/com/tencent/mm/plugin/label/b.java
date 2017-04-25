package com.tencent.mm.plugin.label;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.label.a.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j.e;
import com.tencent.mm.protocal.c.bcz;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.z;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class b implements e {
    ArrayList<String> gPL;
    ArrayList<String> gPM;
    private com.tencent.mm.v.e gPN = new com.tencent.mm.v.e(this) {
        final /* synthetic */ b gPO;

        {
            this.gPO = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            v.e("MicroMsg.Label.ContactLabelManagerImpl", "onSceneEnd");
            switch (kVar.getType()) {
                case 635:
                    if (i == 0 && i2 == 0) {
                        b.d(this.gPO.username, this.gPO.gPL);
                        return;
                    }
                    this.gPO.avH();
                    v.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact lable faild");
                    return;
                case 638:
                    if (i == 0 && i2 == 0) {
                        int i3;
                        int i4;
                        if (this.gPO.gPM == null || this.gPO.gPM.isEmpty()) {
                            i3 = 0;
                        } else {
                            i3 = this.gPO.gPM.size();
                        }
                        if (this.gPO.gPL == null || this.gPO.gPL.isEmpty()) {
                            i4 = 0;
                        } else {
                            i4 = this.gPO.gPL.size() - i3;
                        }
                        if (i3 > 0 || i4 > 0) {
                            v.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
                            g.iuh.h(11220, new Object[]{com.tencent.mm.model.k.xF(), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(0)});
                        }
                    }
                    this.gPO.avH();
                    return;
                default:
                    return;
            }
        }
    };
    String username;

    public final /* synthetic */ List avI() {
        return e.avK().bvt();
    }

    public final /* synthetic */ List vx(String str) {
        if (be.kS(str)) {
            v.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[getLabelStrList]");
            return null;
        }
        if (str.endsWith("\u0000")) {
            str = str.replace("\u0000", "");
        }
        return e.avK().D(str.split(","));
    }

    public final /* synthetic */ List vy(String str) {
        return e.avK().LN(str);
    }

    public final void avF() {
        e.avK().avF();
    }

    public final String vu(String str) {
        return e.avK().vu(str);
    }

    public final String vv(String str) {
        return e.avK().vv(str);
    }

    public final void a(a aVar) {
        e.avK().c(aVar);
    }

    public final void b(a aVar) {
        e.avK().d(aVar);
    }

    public final List<String> avG() {
        z avK = e.avK();
        long Ni = be.Ni();
        ArrayList bvu = avK.bvu();
        if (bvu == null) {
            return null;
        }
        avK.bvv();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bvu.size(); i++) {
            ArrayList arrayList2 = (ArrayList) avK.nun.get(Integer.valueOf(((w) bvu.get(i)).field_labelID));
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList.add(((w) bvu.get(i)).field_labelName);
            }
        }
        v.i("MicroMsg.Label.ContactLabelStorage", "getAllLabelHasContact time:%s all:%s hascontact:%s stack:%s", new Object[]{Long.valueOf(be.ay(Ni)), Integer.valueOf(bvu.size()), Integer.valueOf(arrayList.size()), be.bur()});
        return arrayList;
    }

    public final List<String> vw(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.Label.ContactLabelManagerImpl", "labels is null.");
            return null;
        }
        String[] split = str.split(",");
        if (split == null || split.length <= 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(split));
        return arrayList;
    }

    public final String aC(List<String> list) {
        if (list == null || list.isEmpty()) {
            v.w("MicroMsg.Label.ContactLabelManagerImpl", "labelList is empty");
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append((String) list.get(i));
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }

    public final synchronized void bV(String str, String str2) {
        v.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] user:%s labels:%s", new Object[]{str, str2});
        if (be.kS(str2)) {
            v.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labels is null.");
        } else {
            ArrayList arrayList = (ArrayList) vw(str2);
            if (arrayList == null || arrayList.isEmpty()) {
                v.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labelList is null.");
            } else {
                this.username = str;
                this.gPL = arrayList;
                int size = arrayList.size();
                this.gPM = new ArrayList();
                for (int i = 0; i < size; i++) {
                    w LO = e.avK().LO((String) arrayList.get(i));
                    if (LO != null && LO.field_isTemporary) {
                        this.gPM.add(arrayList.get(i));
                    }
                }
                ak.vy().a(635, this.gPN);
                ak.vy().a(638, this.gPN);
                if (this.gPM == null || this.gPM.isEmpty()) {
                    d(str, arrayList);
                    avH();
                } else {
                    v.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel]addList:%s", new Object[]{this.gPM.toString()});
                    ak.vy().a(new com.tencent.mm.plugin.label.a.a(this.gPM), 0);
                }
            }
        }
    }

    final void avH() {
        this.username = null;
        this.gPL = null;
        this.gPM = null;
        ak.vy().b(635, this.gPN);
        ak.vy().b(638, this.gPN);
    }

    static void d(String str, ArrayList<String> arrayList) {
        String str2 = "MicroMsg.Label.ContactLabelManagerImpl";
        String str3 = "cpan[saveContact] username:%s,list:%s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = arrayList == null ? "" : arrayList.toString();
        v.d(str2, str3, objArr);
        if (be.kS(str) || arrayList == null || arrayList.size() <= 0) {
            v.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact label faild.");
            return;
        }
        String str4 = "";
        if (arrayList != null && arrayList.size() > 0) {
            str4 = c.aE(e.avK().Y(arrayList));
        }
        LinkedList linkedList = new LinkedList();
        bcz com_tencent_mm_protocal_c_bcz = new bcz();
        com_tencent_mm_protocal_c_bcz.moP = str4;
        com_tencent_mm_protocal_c_bcz.gln = str;
        linkedList.add(com_tencent_mm_protocal_c_bcz);
        ak.vy().a(new d(linkedList), 0);
    }

    public final void aD(List<String> list) {
        ak.vy().a(new com.tencent.mm.plugin.label.a.a((List) list), 0);
    }

    public final void e(List<String> list, List<String> list2) {
        String str;
        String str2;
        Map hashMap = new HashMap();
        LinkedList linkedList = new LinkedList();
        if (list.size() > 0) {
            Iterator it = list2.iterator();
            for (String str22 : list) {
                List<String> g = be.g(((String) it.next()).split(","));
                if (g != null && g.size() > 0) {
                    for (String str3 : g) {
                        String str4;
                        String bW;
                        if (hashMap.containsKey(str3)) {
                            str4 = (String) hashMap.get(str3);
                            bW = c.bW(str4, str22);
                            if (!bW.equalsIgnoreCase(str4)) {
                                hashMap.put(str3, bW);
                            }
                        } else {
                            ak.yW();
                            u LX = c.wH().LX(str3);
                            if (LX != null) {
                                str4 = LX.field_contactLabelIds;
                                bW = c.bW(str4, str22);
                                if (!bW.equalsIgnoreCase(str4)) {
                                    hashMap.put(str3, bW);
                                }
                            }
                        }
                    }
                }
            }
        }
        for (Entry entry : hashMap.entrySet()) {
            str3 = (String) entry.getKey();
            str22 = (String) entry.getValue();
            bcz com_tencent_mm_protocal_c_bcz = new bcz();
            com_tencent_mm_protocal_c_bcz.gln = str3;
            com_tencent_mm_protocal_c_bcz.moP = str22;
            linkedList.add(com_tencent_mm_protocal_c_bcz);
        }
        if (linkedList.size() > 0) {
            ak.vy().a(new d(linkedList), 0);
        }
    }
}
