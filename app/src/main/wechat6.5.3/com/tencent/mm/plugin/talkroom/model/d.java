package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.azi;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.d.a;
import com.tencent.mm.v.d.b;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d implements com.tencent.mm.v.d {
    public final b b(a aVar) {
        int i = 1;
        bm bmVar = aVar.czu;
        if (bmVar == null) {
            v.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM is null");
        } else if (bmVar.gll != 56) {
            v.e("MicroMsg.TalkRoomExtension", "onPreAddMessage cmdAM.type:%d", new Object[]{Integer.valueOf(bmVar.gll)});
        } else {
            String a = m.a(bmVar.mbU);
            String a2 = m.a(bmVar.mbV);
            ak.yW();
            if (!((String) c.vf().get(2, null)).equals(a)) {
                a2 = a;
            }
            ak.yW();
            u LX = c.wH().LX(a2);
            if (LX == null || ((int) LX.chr) == 0) {
                ak.yW();
                c.wH().N(new u(a2));
            }
            String a3 = m.a(bmVar.mbW);
            v.d("MicroMsg.TalkRoomExtension", "talkroom xml:" + a3);
            Map q = bf.q(a3, "talkroominfo");
            if (q != null) {
                try {
                    int i2;
                    String str;
                    String aG;
                    if (CA((String) q.get(".talkroominfo.tracksysmsgtype")) == 0) {
                        CA((String) q.get(".talkroominfo.sysmsgtype"));
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    Object linkedList = new LinkedList();
                    CA((String) q.get(".talkroominfo.membersize"));
                    int i3 = 0;
                    while (true) {
                        str = ".talkroominfo.memberlist.member" + (i3 == 0 ? "" : Integer.valueOf(i3));
                        a3 = (String) q.get(str + ".username");
                        if (be.kS(a3)) {
                            break;
                        }
                        int CA = CA((String) q.get(str + ".memberid"));
                        azi com_tencent_mm_protocal_c_azi = new azi();
                        com_tencent_mm_protocal_c_azi.gln = a3;
                        com_tencent_mm_protocal_c_azi.mWg = CA;
                        linkedList.add(com_tencent_mm_protocal_c_azi);
                        i3++;
                    }
                    if (a2.equals(b.aZW().kkT)) {
                        str = aF(linkedList);
                        aG = be.kS(str) ? aG(linkedList) : null;
                    } else {
                        aG = null;
                        str = null;
                    }
                    e aZX = b.aZX();
                    if (i2 != 0) {
                        i = 0;
                    }
                    aZX.a(a2, linkedList, str, aG, i);
                } catch (Throwable e) {
                    v.e("MicroMsg.TalkRoomExtension", "parsing memList xml failed");
                    v.a("MicroMsg.TalkRoomExtension", e, "", new Object[0]);
                }
            }
        }
        return null;
    }

    public final void d(at atVar) {
    }

    private static int CA(String str) {
        int i = 0;
        if (!be.kS(str)) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (Throwable e) {
                v.a("MicroMsg.TalkRoomExtension", e, "", new Object[i]);
            }
        }
        return i;
    }

    private static String aF(List<azi> list) {
        List<azi> awq = b.aZW().awq();
        List linkedList = new LinkedList();
        for (azi com_tencent_mm_protocal_c_azi : list) {
            Object obj;
            for (azi com_tencent_mm_protocal_c_azi2 : awq) {
                if (com_tencent_mm_protocal_c_azi2.gln.equals(com_tencent_mm_protocal_c_azi.gln)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(com_tencent_mm_protocal_c_azi.gln);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            String str = (String) linkedList.get(i);
            if (!str.equals(k.xF())) {
                return str;
            }
        }
        return null;
    }

    private static String aG(List<azi> list) {
        List<azi> awq = b.aZW().awq();
        List linkedList = new LinkedList();
        for (azi com_tencent_mm_protocal_c_azi : awq) {
            Object obj;
            for (azi com_tencent_mm_protocal_c_azi2 : list) {
                if (com_tencent_mm_protocal_c_azi2.gln.equals(com_tencent_mm_protocal_c_azi.gln)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(com_tencent_mm_protocal_c_azi.gln);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            String str = (String) linkedList.get(i);
            if (!str.equals(k.xF())) {
                return str;
            }
        }
        return null;
    }
}
