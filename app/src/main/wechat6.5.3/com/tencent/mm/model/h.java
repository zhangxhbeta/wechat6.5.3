package com.tencent.mm.model;

import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.i.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.util.ArrayList;
import java.util.List;

public final class h {
    public static boolean ed(String str) {
        if (!m.dE(str)) {
            return false;
        }
        long j;
        boolean z;
        ak.yW();
        af Mh = c.wK().Mh(str);
        if (!(Mh == null || Mh.field_lastSeq == 0)) {
            ak.yW();
            if (c.wJ().T(str, Mh.field_lastSeq).field_msgId == 0) {
                j = Mh.field_lastSeq;
                z = true;
                if (!z) {
                    ak.yW();
                    bx Nj = c.wJ().Nj(str);
                    if (!(Nj == null || Nj.field_msgId == 0)) {
                        z = true;
                    }
                }
                if (j == 0) {
                    j = ((d) g.f(d.class)).azI().Ni(str);
                }
                if (j != 0) {
                    ak.yW();
                    c.xw().Q(str, j);
                }
                v.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", str, Boolean.valueOf(z), Long.valueOf(j));
                return z;
            }
        }
        j = 0;
        z = false;
        if (z) {
            ak.yW();
            bx Nj2 = c.wJ().Nj(str);
            z = true;
        }
        if (j == 0) {
            j = ((d) g.f(d.class)).azI().Ni(str);
        }
        if (j != 0) {
            ak.yW();
            c.xw().Q(str, j);
        }
        v.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", str, Boolean.valueOf(z), Long.valueOf(j));
        return z;
    }

    public static List<Boolean> s(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String ed : list) {
            arrayList.add(Boolean.valueOf(ed(ed)));
        }
        return arrayList;
    }

    public static void a(String str, List<String> list, String str2, boolean z, String str3) {
        a(str, list, str2, z, str3, 2);
    }

    public static void a(String str, List<String> list, String str2, boolean z, String str3, int i) {
        at atVar = new at();
        atVar.cH(str);
        atVar.setType(10000);
        atVar.z(System.currentTimeMillis());
        atVar.dh(4);
        atVar.di(i);
        CharSequence stringBuffer = new StringBuffer();
        if (list != null) {
            String xF = k.xF();
            String string = aa.getContext().getString(2131231758);
            for (String str4 : list) {
                if (!str4.equals(xF)) {
                    ak.yW();
                    a LX = c.wH().LX(str4);
                    if (LX == null || ((int) LX.chr) == 0) {
                        if (z) {
                            stringBuffer.append("<a href=\"" + str3 + str4 + "\">" + str4 + "</a>" + string);
                        } else {
                            stringBuffer.append(str4 + string);
                        }
                    } else if (z) {
                        stringBuffer.append("<a href=\"" + str3 + str4 + "\">" + LX.tU() + "</a>" + string);
                    } else {
                        stringBuffer.append(LX.tU() + string);
                    }
                }
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(string));
            }
        }
        atVar.setContent(str2.replace("%s", stringBuffer));
        ak.yW();
        c.wJ().R(atVar);
    }
}
