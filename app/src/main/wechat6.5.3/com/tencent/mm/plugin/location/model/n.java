package com.tencent.mm.plugin.location.model;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.e;
import com.tencent.mm.model.k;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.d.a;
import com.tencent.mm.v.d.b;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class n extends e {
    public final b b(a aVar) {
        bm bmVar = aVar.czu;
        if (bmVar == null) {
            v.e("MicroMsg.TrackMsgExtension", "onPreAddMessage cmdAM is null");
        } else {
            Object linkedList = new LinkedList();
            String a = m.a(bmVar.mbU);
            String a2 = m.a(bmVar.mbV);
            ak.yW();
            String str = ((String) c.vf().get(2, null)).equals(a) ? a2 : a;
            String a3 = m.a(bmVar.mbW);
            v.d("MicroMsg.TrackMsgExtension", "cmd " + a3);
            Map q = bf.q(a3, "sysmsg");
            if (q != null) {
                try {
                    String aF;
                    String aG;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("talk  " + str + "\r\n");
                    stringBuffer.append("from fromUser " + a + "\r\n");
                    stringBuffer.append("from toUser " + a2 + "\r\n");
                    String str2 = (String) q.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.addr");
                    double vG = vG((String) q.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.latitude"));
                    stringBuffer.append("lat " + vG + "\r\n");
                    double vG2 = vG((String) q.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.longitude"));
                    stringBuffer.append("lng " + vG2 + "\r\n");
                    stringBuffer.append("times " + be.getInt((String) q.get(".sysmsg.trackmsg.trackroominfo.timestamp"), 0) + "\r\n");
                    int i = 0;
                    while (true) {
                        a3 = (String) q.get((".sysmsg.trackmsg.trackroominfo.trackmemberlist.member" + (i == 0 ? "" : Integer.valueOf(i))) + ".username");
                        if (be.kS(a3)) {
                            break;
                        }
                        i++;
                        linkedList.add(a3);
                    }
                    stringBuffer.append("userNameList size " + linkedList.size() + "\r\n");
                    v.i("MicroMsg.TrackMsgExtension", "xml : " + stringBuffer.toString());
                    if (str.equals(l.awi().gTc)) {
                        aF = aF(linkedList);
                        aG = be.kS(aF) ? aG(linkedList) : null;
                    } else {
                        aG = null;
                        aF = null;
                    }
                    l.awj().a(str, linkedList, vG, vG2, str2, aF, aG);
                } catch (Throwable e) {
                    v.a("MicroMsg.TrackMsgExtension", e, "", new Object[0]);
                }
            }
        }
        return null;
    }

    private static double vG(String str) {
        if (str == null) {
            return 0.0d;
        }
        return be.getDouble(str, 0.0d);
    }

    private static String aF(List<String> list) {
        String str;
        List<String> awq = l.awi().awq();
        List linkedList = new LinkedList();
        for (String str2 : list) {
            Object obj;
            for (String equals : awq) {
                if (equals.equals(str2)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(str2);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            str2 = (String) linkedList.get(i);
            if (!str2.equals(k.xF())) {
                return str2;
            }
        }
        return null;
    }

    private static String aG(List<String> list) {
        List<String> awq = l.awi().awq();
        List linkedList = new LinkedList();
        for (String str : awq) {
            String str2;
            Object obj;
            for (String equals : list) {
                if (equals.equals(str2)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(str2);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            str2 = (String) linkedList.get(i);
            if (!str2.equals(k.xF())) {
                return str2;
            }
        }
        return null;
    }
}
