package com.tencent.mm.plugin.bbom;

import android.database.Cursor;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.i;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.plugin.f.a.a.f;
import com.tencent.mm.plugin.f.a.a.h.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aih;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class h implements f, a {
    public final void a(aih com_tencent_mm_protocal_c_aih, at atVar) {
        if (e.hC(atVar.field_talker) && be.kS(atVar.bNo)) {
            atVar.cN(com.tencent.mm.modelbiz.a.e.zr());
            v.d("MicroMsg.MsgSrcBBOMImpl", "NetSceneSendMsg:MsgSource:%s", atVar.bNo);
        }
        if (e.hC(atVar.field_talker)) {
            if (!(com_tencent_mm_protocal_c_aih == null || atVar == null)) {
                c Z = u.DA().Z(atVar.field_bizChatId);
                if (com_tencent_mm_protocal_c_aih.efm == 1 && Z.DN() && com_tencent_mm_protocal_c_aih.hQP.contains("@")) {
                    long currentTimeMillis = System.currentTimeMillis();
                    List<String> DM = Z.DM();
                    if (!(DM == null || DM.size() == 0)) {
                        List<String> linkedList = new LinkedList();
                        String str = com_tencent_mm_protocal_c_aih.hQP;
                        int i = 0;
                        while (i < str.length()) {
                            i = str.indexOf("@", i);
                            if (i == -1) {
                                break;
                            }
                            int indexOf = str.indexOf(8197, i);
                            if (indexOf == -1 || indexOf - i > 40) {
                                break;
                            }
                            linkedList.add(str.substring(i + 1, indexOf));
                            i = indexOf + 1;
                        }
                        v.d("MicroMsg.MsgSrcBBOMImpl", "after split @ :%s", linkedList);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("<atuserlist><![CDATA[");
                        Object obj = null;
                        for (String str2 : DM) {
                            Object obj2 = obj;
                            for (String str3 : linkedList) {
                                String er = Z.er(str2);
                                if (!be.kS(er) && str3.equals(er)) {
                                    if (obj2 != null) {
                                        stringBuilder.append(",");
                                    }
                                    stringBuilder.append(str2);
                                    obj2 = 1;
                                }
                            }
                            obj = obj2;
                        }
                        stringBuilder.append("]]></atuserlist>");
                        com_tencent_mm_protocal_c_aih.mbZ = atVar.bNo;
                        String str22 = (be.kS(com_tencent_mm_protocal_c_aih.mbZ) || !com_tencent_mm_protocal_c_aih.mbZ.startsWith("<msgsource>")) ? "<msgsource></msgsource>" : com_tencent_mm_protocal_c_aih.mbZ;
                        com_tencent_mm_protocal_c_aih.mbZ = str22;
                        com_tencent_mm_protocal_c_aih.mbZ = com_tencent_mm_protocal_c_aih.mbZ.replace("<msgsource>", "<msgsource>" + stringBuilder.toString());
                        com_tencent_mm_protocal_c_aih.mbZ = com.tencent.mm.modelbiz.a.e.hY(com_tencent_mm_protocal_c_aih.mbZ);
                        v.d("MicroMsg.MsgSrcBBOMImpl", "send text msg with MsgSrouce: %s", com_tencent_mm_protocal_c_aih.mbZ);
                        v.d("MicroMsg.MsgSrcBBOMImpl", "format msgsource time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            }
            if (be.kS(com_tencent_mm_protocal_c_aih.mbZ)) {
                com_tencent_mm_protocal_c_aih.mbZ = com.tencent.mm.modelbiz.a.e.hY(atVar.bNo);
                return;
            }
            return;
        }
        a(com_tencent_mm_protocal_c_aih);
    }

    private static void a(aih com_tencent_mm_protocal_c_aih) {
        if (com_tencent_mm_protocal_c_aih.efm != 1 || !m.dE(com_tencent_mm_protocal_c_aih.mbV.mQy)) {
            com_tencent_mm_protocal_c_aih.mbZ = ax.zr();
        } else if (com_tencent_mm_protocal_c_aih.hQP.contains("@")) {
            long currentTimeMillis = System.currentTimeMillis();
            List ej = i.ej(com_tencent_mm_protocal_c_aih.mbV.mQy);
            if (ej != null && ej.size() != 0) {
                String str;
                List<String> linkedList = new LinkedList();
                String str2 = com_tencent_mm_protocal_c_aih.hQP;
                int i = 0;
                while (i < str2.length()) {
                    i = str2.indexOf("@", i);
                    if (i == -1) {
                        break;
                    }
                    int indexOf = str2.indexOf(8197, i);
                    if (indexOf == -1 || indexOf - i > 40) {
                        break;
                    }
                    linkedList.add(str2.substring(i + 1, indexOf));
                    i = indexOf + 1;
                }
                v.d("MicroMsg.MsgSrcBBOMImpl", "after split @ :%s", linkedList);
                long currentTimeMillis2 = System.currentTimeMillis();
                Map hashMap = new HashMap();
                ak.yW();
                Cursor ca = com.tencent.mm.model.c.wH().ca(ej);
                if (ca != null) {
                    ca.moveToFirst();
                    while (!ca.isAfterLast()) {
                        ab uVar = new com.tencent.mm.storage.u();
                        uVar.b(ca);
                        for (String str3 : linkedList) {
                            if (str3.length() != 0) {
                                if (!be.kS(uVar.field_nickname) && str3.equals(uVar.field_nickname)) {
                                    hashMap.put(uVar.field_username, uVar.field_username);
                                } else if (!be.kS(uVar.field_conRemark) && str3.equals(uVar.field_conRemark)) {
                                    hashMap.put(uVar.field_username, uVar.field_username);
                                } else if (!be.kS(uVar.pD()) && str3.equals(uVar.pD())) {
                                    hashMap.put(uVar.field_username, uVar.field_username);
                                } else if (!be.kS(uVar.field_username) && str3.equals(uVar.field_username)) {
                                    hashMap.put(uVar.field_username, uVar.field_username);
                                }
                            }
                        }
                        ca.moveToNext();
                    }
                    ca.close();
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                Map hashMap2 = new HashMap();
                i.a(com_tencent_mm_protocal_c_aih.mbV.mQy, hashMap2);
                for (String str32 : hashMap2.keySet()) {
                    for (String str4 : linkedList) {
                        if (str4.length() != 0) {
                            str2 = (String) hashMap2.get(str32);
                            if (!be.kS(str2) && str4.equals(str2)) {
                                hashMap.put(str32, str32);
                            }
                        }
                    }
                }
                if (hashMap.values().size() > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("<msgsource><atuserlist><![CDATA[");
                    Object obj = null;
                    for (String str322 : hashMap.keySet()) {
                        if (obj != null) {
                            stringBuilder.append(",");
                        }
                        stringBuilder.append(str322);
                        int i2 = 1;
                    }
                    stringBuilder.append("]]></atuserlist>");
                    stringBuilder.append(be.ma(ax.zq()));
                    str322 = (be.kS(com_tencent_mm_protocal_c_aih.mbZ) || !com_tencent_mm_protocal_c_aih.mbZ.startsWith("<msgsource>")) ? "<msgsource></msgsource>" : com_tencent_mm_protocal_c_aih.mbZ;
                    com_tencent_mm_protocal_c_aih.mbZ = str322;
                    com_tencent_mm_protocal_c_aih.mbZ = com_tencent_mm_protocal_c_aih.mbZ.replace("<msgsource>", stringBuilder.toString());
                    v.d("MicroMsg.MsgSrcBBOMImpl", "send text msg with MsgSrouce: %s", com_tencent_mm_protocal_c_aih.mbZ);
                    g.iuh.h(10976, Integer.valueOf(hashMap.values().size()), Integer.valueOf(0), Integer.valueOf(0));
                }
                v.d("MicroMsg.MsgSrcBBOMImpl", "format msgsource time:%d, %d, %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
            }
        }
    }

    public final String o(at atVar) {
        if (e.hC(atVar.field_talker)) {
            return com.tencent.mm.modelbiz.a.e.zr();
        }
        return null;
    }
}
