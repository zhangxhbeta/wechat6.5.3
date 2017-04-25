package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.mm.ak.j;
import com.tencent.mm.ba.a;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.aig;
import com.tencent.mm.protocal.c.aip;
import com.tencent.mm.protocal.c.bc;
import com.tencent.mm.protocal.c.mh;
import com.tencent.mm.protocal.c.mq;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.p;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class i {
    public static boolean a(String str, Map<String, String> map) {
        o LC = ak.yW().wO().LC(str);
        if (LC == null) {
            return false;
        }
        for (String str2 : LC.DM()) {
            map.put(str2, LC.er(str2));
        }
        return true;
    }

    public static boolean ee(String str) {
        String str2;
        p wO = ak.yW().wO();
        Assert.assertTrue(str.length() > 0);
        Cursor rawQuery = wO.cie.rawQuery("select roomowner from chatroom where chatroomname='" + be.lZ(str) + "'", null);
        if (rawQuery == null) {
            v.e("MicroMsg.ChatroomStorage", "getChatroomOwner fail, cursor is null");
            str2 = null;
        } else if (rawQuery.getCount() == 0) {
            v.e("MicroMsg.ChatroomStorage", "getChatroomOwner fail, cursor is null");
            rawQuery.close();
            str2 = null;
        } else {
            rawQuery.moveToFirst();
            o oVar = new o();
            oVar.b(rawQuery);
            rawQuery.close();
            str2 = oVar.field_roomowner;
        }
        String xF = k.xF();
        return (be.kS(str2) || be.kS(xF) || !str2.equals(xF)) ? false : true;
    }

    public static void a(String str, o oVar, boolean z) {
        int i = 1;
        oVar.iA(z);
        ak.yW().wO().a((c) oVar, new String[0]);
        String xF = k.xF();
        a com_tencent_mm_protocal_c_aip = new aip();
        com_tencent_mm_protocal_c_aip.moN = str;
        com_tencent_mm_protocal_c_aip.gln = xF;
        com_tencent_mm_protocal_c_aip.mIV = 1;
        if (!z) {
            i = 2;
        }
        com_tencent_mm_protocal_c_aip.itI = i;
        ak.yW();
        c.wG().b(new j.a(49, com_tencent_mm_protocal_c_aip));
    }

    public static String t(List<String> list) {
        return b(list, -1);
    }

    public static String b(List<String> list, int i) {
        if (list == null || list.size() == 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        String str = SQLiteDatabase.KeyEmpty;
        int i2 = i - 1;
        int i3 = 0;
        while (i3 < list.size()) {
            String str2 = (String) list.get(i3);
            if (str2.length() > 0) {
                ak.yW();
                str2 = str + c.wH().LX(str2).tU();
                if (i3 == i2 && i3 < list.size()) {
                    return str2 + "...";
                }
                if (i3 < list.size() - 1) {
                    str2 = str2 + aa.getContext().getString(2131231758);
                }
            } else {
                str2 = str;
            }
            i3++;
            str = str2;
        }
        return str;
    }

    public static boolean ef(String str) {
        ak.yW();
        String str2 = (String) c.vf().get(2, null);
        List ej = ej(str);
        if (ej == null) {
            v.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is null ");
            return false;
        } else if (ej.size() != 0 && ej.contains(str2)) {
            return true;
        } else {
            v.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is list is zero or no contains user  " + ej.size() + " ");
            return false;
        }
    }

    public static boolean eg(String str) {
        if (str == null || !str.toLowerCase().endsWith("@chatroom")) {
            return false;
        }
        boolean z;
        List LF;
        Cursor rawQuery = ak.yW().wO().cie.rawQuery("select * from chatroom where chatroomname='" + be.lZ(str) + "'", null);
        int count = rawQuery.getCount();
        if (count <= 1) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (count <= 0) {
            v.e("MicroMsg.ChatroomStorage", "getMemberListByChatroomName chatroomName:" + str + " getCount ==0");
            rawQuery.close();
        } else {
            rawQuery.moveToFirst();
            o oVar = new o();
            oVar.b(rawQuery);
            rawQuery.close();
            if ((oVar.field_roomflag & 1) == 0) {
                z = true;
                if (z) {
                    v.d("MicroMsg.ChatroomMembersLogic", "state is die");
                    return true;
                }
                LF = ak.yW().wO().LF(str);
                if (LF == null && LF.size() != 0) {
                    return false;
                }
            }
        }
        z = false;
        if (z) {
            LF = ak.yW().wO().LF(str);
            return LF == null ? true : true;
        } else {
            v.d("MicroMsg.ChatroomMembersLogic", "state is die");
            return true;
        }
    }

    public static boolean eh(String str) {
        if (str == null || !str.toLowerCase().endsWith("@chatroom")) {
            return false;
        }
        v.d("MicroMsg.ChatroomMembersLogic", "updateFailState chatRoomName %s", str);
        p wO = ak.yW().wO();
        o LC = wO.LC(str);
        if (LC == null) {
            return false;
        }
        LC.field_roomflag = 1;
        return wO.b(LC);
    }

    public static boolean a(o oVar) {
        if (oVar == null) {
            v.e("MicroMsg.ChatroomMembersLogic", "updateChatroomMember error! member is null");
            return false;
        }
        boolean b = ak.yW().wO().b(oVar);
        if (b) {
            String str = oVar.field_chatroomname;
            String str2 = oVar.field_roomowner;
            v.d("MicroMsg.ChatroomMembersLogic", "update contact chatroom type to %d", Integer.valueOf(1));
            ak.yW();
            com.tencent.mm.storage.aa wH = c.wH();
            com.tencent.mm.i.a LX = wH.LX(str);
            if (!(((int) LX.chr) == 0 || be.kS(str2) || be.kS(k.xF()))) {
                if (str2.equals(k.xF())) {
                    LX.ej(1);
                } else {
                    LX.ej(0);
                }
                wH.a(str, LX);
            }
        }
        return b;
    }

    public static boolean a(String str, mh mhVar) {
        if (!str.toLowerCase().endsWith("@chatroom") || mhVar.eOX == 0) {
            v.e("MicroMsg.ChatroomMembersLogic", "DelChatroomMember: room:[" + str + "] listCnt:" + mhVar.eOX);
            return false;
        }
        p wO = ak.yW().wO();
        o LC = wO.LC(str);
        List LB = o.LB(LC.field_memberlist);
        v.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember before " + LB.size());
        Iterator it = mhVar.mbB.iterator();
        while (it.hasNext()) {
            LB.remove(m.a(((mq) it.next()).moS));
        }
        v.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember after " + LB.size());
        LC.bS(LB).field_displayname = t(LB);
        boolean b = wO.b(LC);
        v.d("MicroMsg.ChatroomMembersLogic", "delChatroomMember " + b);
        return b;
    }

    public static boolean a(String str, bc bcVar) {
        if (!str.toLowerCase().endsWith("@chatroom") || bcVar.eOX == 0) {
            v.e("MicroMsg.ChatroomMembersLogic", "AddChatroomMember: room:[" + str + "] listCnt:" + bcVar.eOX);
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ak.yW();
        com.tencent.mm.storage.aa wH = c.wH();
        for (int i = 0; i < bcVar.eOX; i++) {
            String a = m.a(((aig) bcVar.mbB.get(i)).moS);
            if (((aig) bcVar.mbB.get(i)).mIN == 0) {
                if (be.kS(a)) {
                    v.e("MicroMsg.ChatroomMembersLogic", "this member name is null! chatRoomName : %s", str);
                } else {
                    ab abVar;
                    u LX = wH.LX(a);
                    if (((int) LX.chr) != 0) {
                        LX.to();
                        wH.a(LX.field_username, LX);
                        abVar = LX;
                    } else {
                        abVar = a(LX, (aig) bcVar.mbB.get(i));
                        wH.N(abVar);
                    }
                    arrayList.add(abVar.field_username);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        return a(str, arrayList, null);
    }

    public static boolean a(String str, ArrayList<String> arrayList, String str2) {
        List ej;
        int i = 0;
        p wO = ak.yW().wO();
        o LD = wO.LD(str);
        if (str.endsWith("@chatroom")) {
            ej = ej(str);
        } else {
            ej = new LinkedList();
        }
        List linkedList = new LinkedList();
        if (ej != null) {
            for (int i2 = 0; i2 < ej.size(); i2++) {
                linkedList.add(ej.get(i2));
            }
            while (i < arrayList.size()) {
                if (!ej.contains(arrayList.get(i))) {
                    linkedList.add(arrayList.get(i));
                }
                i++;
            }
            if (!be.kS(str2)) {
                LD.field_roomowner = str2;
            }
            LD.bS(linkedList).field_displayname = t(linkedList);
            return wO.b(LD);
        }
        while (i < arrayList.size()) {
            linkedList.add(arrayList.get(i));
            i++;
        }
        if (!be.kS(str2)) {
            LD.field_roomowner = str2;
        }
        LD.bS(linkedList).field_displayname = t(linkedList);
        LD.field_roomowner = str2;
        boolean b = wO.b(LD);
        v.d("MicroMsg.ChatroomMembersLogic", "insertMembersByChatRoomName " + b);
        return b;
    }

    public static boolean ei(String str) {
        return ak.yW().wO().LG(str);
    }

    public static List<String> ej(String str) {
        if (str == null) {
            v.e("MicroMsg.ChatroomMembersLogic", "chatroomName is null");
            return null;
        } else if (str.toLowerCase().endsWith("@chatroom")) {
            return ak.yW().wO().LF(str);
        } else {
            v.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: this is not room:[" + str + "]");
            return null;
        }
    }

    public static List<String> ek(String str) {
        if (str.toLowerCase().endsWith("@chatroom")) {
            return ak.yW().wO().LF(str);
        }
        v.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: room:[" + str + "]");
        return null;
    }

    public static int el(String str) {
        List ej = ej(str);
        if (ej != null) {
            return ej.size();
        }
        v.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: get room:[" + str + "] members count fail");
        return 0;
    }

    public static List<String> em(String str) {
        int i = 0;
        if (str.toLowerCase().endsWith("@chatroom")) {
            List<String> ej = ej(str);
            if (ej == null || ej.size() <= 0) {
                return null;
            }
            ak.yW();
            String str2 = (String) c.vf().get(2, null);
            boolean z = str2 != null && str2.length() > 0;
            Assert.assertTrue(z);
            while (i < ej.size()) {
                if (((String) ej.get(i)).equals(str2)) {
                    ej.remove(i);
                    break;
                }
                i++;
            }
            if (ej.size() <= 0) {
                return null;
            }
            return ej;
        }
        v.e("MicroMsg.ChatroomMembersLogic", "getOtherMembersByChatRoomName: room:[" + str + "]");
        return null;
    }

    public static u a(u uVar, aig com_tencent_mm_protocal_c_aig) {
        uVar.setUsername(m.a(com_tencent_mm_protocal_c_aig.moS));
        uVar.bS(m.a(com_tencent_mm_protocal_c_aig.moS));
        uVar.bT(m.a(com_tencent_mm_protocal_c_aig.moS));
        uVar.bU(m.a(com_tencent_mm_protocal_c_aig.moD));
        uVar.cV(com_tencent_mm_protocal_c_aig.cHc);
        uVar.bQ(m.a(com_tencent_mm_protocal_c_aig.mIO));
        uVar.bX(m.a(com_tencent_mm_protocal_c_aig.mIP));
        uVar.bW(m.a(com_tencent_mm_protocal_c_aig.moD));
        uVar.cY(com_tencent_mm_protocal_c_aig.mob);
        uVar.da(com_tencent_mm_protocal_c_aig.cHg);
        uVar.cl(RegionCodeDecoder.Y(com_tencent_mm_protocal_c_aig.cHl, com_tencent_mm_protocal_c_aig.cHd, com_tencent_mm_protocal_c_aig.cHe));
        uVar.cf(com_tencent_mm_protocal_c_aig.cHf);
        return uVar;
    }

    public static String en(String str) {
        o LC = ak.yW().wO().LC(str);
        if (LC == null) {
            return null;
        }
        return LC.field_chatroomnotice;
    }
}
