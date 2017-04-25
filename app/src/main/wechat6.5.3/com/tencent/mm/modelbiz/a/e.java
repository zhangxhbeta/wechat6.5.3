package com.tencent.mm.modelbiz.a;

import com.tencent.mm.a.g;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw.a;
import com.tencent.mm.model.c;
import com.tencent.mm.modelbiz.a.b.a.b;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.protocal.c.gw;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {
    public static String bNo = null;
    public static final Object cDR = new Object();

    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String cDS;
        final /* synthetic */ boolean cDT;
        final /* synthetic */ a crx = null;

        AnonymousClass1(String str, boolean z, a aVar) {
            this.cDS = str;
            this.cDT = z;
        }

        public final void run() {
            b DB = u.DB();
            String str = this.cDS;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("delete from BizChatConversation");
            stringBuilder.append(" where brandUserName = '").append(str).append("' ");
            v.i("MicroMsg.BizConversationStorage", "deleteByBrandUserName sql %s,%s", stringBuilder.toString(), Boolean.valueOf(DB.cie.dF("BizChatConversation", stringBuilder.toString())));
            if (DB.cie.dF("BizChatConversation", stringBuilder.toString())) {
                a aVar = new a();
                b bVar = new b();
                bVar.cDF = -1;
                bVar.aZU = str;
                bVar.cDE = b.a.a.cDB;
                bVar.cDG = aVar;
                DB.cBg.bg(bVar);
                DB.cBg.Ls();
            }
            ak.yW();
            c.wK().Mf(this.cDS);
            d DA = u.DA();
            str = this.cDS;
            stringBuilder = new StringBuilder();
            stringBuilder.append("delete from BizChatInfo");
            stringBuilder.append(" where brandUserName = '").append(str).append("' ");
            v.i("MicroMsg.BizChatInfoStorage", "deleteByBrandUserName sql %s,%s", stringBuilder.toString(), Boolean.valueOf(DA.cie.dF("BizChatInfo", stringBuilder.toString())));
            if (DA.cie.dF("BizChatInfo", stringBuilder.toString())) {
                c cVar = new c();
                d.a.b bVar2 = new d.a.b();
                bVar2.cDF = -1;
                bVar2.aZU = str;
                bVar2.cDP = d.a.a.cDM;
                bVar2.cDQ = cVar;
                DA.cBg.bg(bVar2);
                DA.cBg.Ls();
            }
            com.tencent.mm.a.e.e(new File(e.ib(this.cDS)));
            if (this.cDT) {
                k DC = u.DC();
                str = this.cDS;
                stringBuilder = new StringBuilder();
                stringBuilder.append("delete from BizChatUserInfo");
                stringBuilder.append(" where brandUserName = '").append(str).append("' ");
                v.i("MicroMsg.BizChatUserInfoStorage", "deleteByBrandUserName sql %s,%s", stringBuilder.toString(), Boolean.valueOf(DC.cie.dF("BizChatUserInfo", stringBuilder.toString())));
                if (DC.cie.dF("BizChatUserInfo", stringBuilder.toString())) {
                    j jVar = new j();
                    k.a.b bVar3 = new k.a.b();
                    bVar3.cEh = k.a.a.cEe;
                    bVar3.cEi = jVar;
                    DC.cBg.bg(bVar3);
                    DC.cBg.Ls();
                }
                u.DD().if(this.cDS);
                com.tencent.mm.a.e.e(new File(e.ic(this.cDS)));
            }
            ad.o(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 cDU;

                {
                    this.cDU = r1;
                }

                public final void run() {
                    if (this.cDU.crx != null) {
                        this.cDU.crx.zo();
                    }
                }
            });
        }

        public final String toString() {
            return super.toString() + "|deleteMsgByTalkers";
        }
    }

    public static boolean hS(String str) {
        if (str == null) {
            return false;
        }
        if (str.endsWith("@qy_u") || str.endsWith("@qy_g")) {
            return true;
        }
        return false;
    }

    public static boolean hT(String str) {
        if (str != null) {
            return str.endsWith("@qy_g");
        }
        v.i("MicroMsg.BizChatInfoStorageLogic", "isGroupChat chatId == null");
        return false;
    }

    public static boolean d(c cVar) {
        if (cVar == null) {
            return false;
        }
        List<String> DM = cVar.DM();
        String ii = u.DC().ii(cVar.field_brandUserName);
        if (ii == null) {
            v.w("MicroMsg.BaseBizChatInfo", "bizchat myUserId is null");
            return false;
        }
        for (String equals : DM) {
            if (ii.equals(equals)) {
                return true;
            }
        }
        v.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom myUserId is %s", ii);
        v.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom memberlist is %s", Arrays.toString(DM.toArray()));
        return false;
    }

    public static int aa(long j) {
        List ab = ab(j);
        if (ab != null) {
            return ab.size();
        }
        v.w("MicroMsg.BizChatInfoStorageLogic", "getMembersCountByBizChatId list == null");
        return 0;
    }

    public static List<String> ab(long j) {
        return u.DA().Z(j).DM();
    }

    public static String hU(String str) {
        if (str == null) {
            v.w("MicroMsg.BizChatInfoStorageLogic", "getUserName bizChatId == null");
            return null;
        }
        j ig = u.DC().ig(str);
        if (ig != null) {
            return ig.field_userName;
        }
        v.i("MicroMsg.BizChatInfoStorageLogic", "getUserName userInfo == null");
        return null;
    }

    public static String hV(String str) {
        if (str == null) {
            v.w("MicroMsg.BizChatInfoStorageLogic", "getChatName bizChatId == null");
            return null;
        }
        c hR = u.DA().hR(str);
        if (hR != null) {
            return hR.field_chatName;
        }
        v.i("MicroMsg.BizChatInfoStorageLogic", "getUserName userInfo == null");
        return null;
    }

    public static String hW(String str) {
        j ig = u.DC().ig(str);
        if (ig != null) {
            return ig.field_headImageUrl;
        }
        return null;
    }

    public static c a(c cVar, long j) {
        String str = "MicroMsg.BizChatInfoStorageLogic";
        String str2 = "protectBizChatNotExist bizChatId:%s BizChatInfo:%s ";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Long.valueOf(cVar == null ? -1 : cVar.field_bizChatLocalId);
        v.w(str, str2, objArr);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        cVar2.field_bizChatLocalId = j;
        u.DA().b(cVar2);
        return u.DA().Z(j);
    }

    public static j a(j jVar, String str) {
        String str2 = "MicroMsg.BizChatInfoStorageLogic";
        String str3 = "protectBizChatNotExist userId:%s BizChatUserInfo:%s ";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = jVar == null ? Integer.valueOf(-1) : jVar.field_userId;
        v.w(str2, str3, objArr);
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j();
        jVar2.field_userId = str;
        u.DC().b(jVar2);
        jVar = u.DC().ig(str);
        if (jVar != null) {
            return jVar;
        }
        v.e("MicroMsg.BizChatInfoStorageLogic", "protectContactNotExist contact get from db is null!");
        return jVar2;
    }

    public static j hX(String str) {
        j jVar = null;
        if (be.kS(str)) {
            v.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo brandUserName==null");
        } else {
            f ie = u.DD().ie(str);
            if (ie == null) {
                v.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatMyUserInfo==null");
            } else {
                jVar = u.DC().ig(ie.field_userId);
                if (jVar == null) {
                    v.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatUserInfo==null");
                }
            }
        }
        return jVar;
    }

    public static String hY(String str) {
        if (str == null) {
            v.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource msgSource==null");
            return null;
        }
        int indexOf = str.indexOf("<enterprise_info>") + 17;
        int indexOf2 = str.indexOf("</enterprise_info>");
        if (indexOf == -1 || indexOf2 == -1 || indexOf >= indexOf2) {
            v.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource error start:%s,end:%s", Integer.valueOf(indexOf), Integer.valueOf(indexOf2));
            return null;
        }
        CharSequence substring = str.substring(indexOf, indexOf2);
        return str.replace(substring, substring.replace("<", "&lt;").replace(">", "&gt;"));
    }

    public static String zr() {
        String str;
        synchronized (cDR) {
            str = bNo;
        }
        return str;
    }

    public static String e(c cVar) {
        if (cVar == null) {
            v.w("MicroMsg.BizChatInfoStorageLogic", "getMsgSource bizChatInfo=%s");
            return null;
        }
        v.d("MicroMsg.BizChatInfoStorageLogic", "format msgSource");
        if (cVar.field_bizChatServId == null) {
            v.d("MicroMsg.BizChatInfoStorageLogic", "getMsgSource field_bizChatId=%s", cVar.field_bizChatServId);
            return null;
        }
        j hX = hX(cVar.field_brandUserName);
        if (hX == null || hX.field_userId == null) {
            v.d("MicroMsg.BizChatInfoStorageLogic", " bizChatMyUserInfo.field_userId is null getMsgSource field_bizChatId=%s", cVar.field_bizChatServId);
            return null;
        }
        synchronized (cDR) {
            bNo = String.format("<msgsource><enterprise_info><qy_msg_type>%d</qy_msg_type><bizchat_id>%s</bizchat_id><bizchat_ver>%d</bizchat_ver><user_id>%s</user_id></enterprise_info></msgsource>", new Object[]{Integer.valueOf(1), cVar.field_bizChatServId, Integer.valueOf(cVar.field_chatVersion), hX.field_userId});
        }
        v.d("MicroMsg.BizChatInfoStorageLogic", "send msgSource:%s", bNo);
        return bNo;
    }

    public static void hZ(String str) {
        synchronized (cDR) {
            bNo = str;
        }
    }

    public static boolean f(c cVar) {
        v.d("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember");
        if (cVar == null) {
            v.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: bizChatInfo == null");
            return false;
        }
        List<String> DM = cVar.DM();
        if (DM == null) {
            v.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: list == null");
            return false;
        }
        LinkedList linkedList = new LinkedList();
        for (String str : DM) {
            j ig = u.DC().ig(str);
            if (ig != null && ig.DO()) {
                linkedList.add(str);
            }
        }
        if (linkedList.size() > 0) {
            u.DE();
            h.a(linkedList, cVar.field_brandUserName, null);
            return true;
        }
        v.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: no need to update");
        return false;
    }

    public static String ac(long j) {
        return u.DA().Z(j).field_bizChatServId;
    }

    public static long ia(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.BizChatInfoStorageLogic", "chatId == null");
            return -1;
        }
        c hR = u.DA().hR(str);
        if (hR != null) {
            return hR.field_bizChatLocalId;
        }
        v.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo == null");
        return -1;
    }

    public static void v(String str, boolean z) {
        if (be.kS(str)) {
            v.d("MicroMsg.BizChatInfoStorageLogic", "delEnterpriseChatConvAndHeadImg, empty brandUserName");
            return;
        }
        v.d("MicroMsg.BizChatInfoStorageLogic", "deleteMsgByTalkers");
        ak.vA().x(new AnonymousClass1(str, z, null));
    }

    public static String ib(String str) {
        if (be.kS(str)) {
            str = "tempConv";
        }
        ak.yW();
        StringBuilder stringBuilder = new StringBuilder(c.wQ());
        stringBuilder.append(g.m(str.getBytes())).append("/");
        stringBuilder.append("conv/");
        return stringBuilder.toString();
    }

    public static String ic(String str) {
        if (be.kS(str)) {
            str = "tempUser";
        }
        ak.yW();
        StringBuilder stringBuilder = new StringBuilder(c.wQ());
        stringBuilder.append(g.m(str.getBytes())).append("/");
        stringBuilder.append("user/");
        return stringBuilder.toString();
    }

    public static boolean a(c cVar, String str, String str2, ra raVar) {
        if (!(str == null || be.kS(cVar.field_brandUserName))) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 1 && be.kS(str2)) {
                    j jVar;
                    boolean z;
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    String string = jSONObject.getString("id");
                    j ig = u.DC().ig(string);
                    if (ig == null) {
                        jVar = new j();
                        z = true;
                    } else {
                        jVar = ig;
                        z = false;
                    }
                    jVar.field_userId = string;
                    jVar.field_userName = jSONObject.getString("nick_name");
                    jVar.field_headImageUrl = jSONObject.getString("head_img_url");
                    jVar.field_profileUrl = jSONObject.getString("profile_url");
                    jVar.field_UserVersion = jSONObject.getInt("ver");
                    if (jVar.field_brandUserName == null || jVar.field_brandUserName.length() == 0) {
                        jVar.field_brandUserName = cVar.field_brandUserName;
                        z = true;
                    }
                    if (jVar.field_addMemberUrl == null || jVar.field_addMemberUrl.length() == 0) {
                        jVar.field_addMemberUrl = cVar.field_addMemberUrl;
                        z = true;
                    }
                    if (!u.DC().b(jVar)) {
                        u.DC().a(jVar);
                    }
                    if (z) {
                        u.DE();
                        h.a(jVar.field_userId, jVar.field_brandUserName, null);
                    }
                    c cVar2 = new c();
                    cVar2.field_bizChatServId = jVar.field_userId;
                    cVar2.field_brandUserName = jVar.field_brandUserName;
                    cVar2.field_chatName = jVar.field_userName;
                    cVar2.field_chatType = 1;
                    cVar2 = u.DA().c(cVar2);
                    if (cVar2 == null) {
                        return false;
                    }
                    cVar.field_bizChatLocalId = cVar2.field_bizChatLocalId;
                    cVar.field_chatName = jVar.field_userName;
                    return true;
                }
                LinkedList linkedList = new LinkedList();
                if (!be.kS(str2)) {
                    gw gwVar = new gw();
                    gwVar.mhK = str2;
                    linkedList.add(gwVar);
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    j jVar2 = new j();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    jVar2.field_userId = jSONObject2.getString("id");
                    jVar2.field_userName = jSONObject2.getString("nick_name");
                    jVar2.field_brandUserName = cVar.field_brandUserName;
                    jVar2.field_headImageUrl = jSONObject2.getString("head_img_url");
                    jVar2.field_profileUrl = jSONObject2.getString("profile_url");
                    jVar2.field_UserVersion = jSONObject2.getInt("ver");
                    jVar2.field_addMemberUrl = cVar.field_addMemberUrl;
                    if (!u.DC().b(jVar2)) {
                        u.DC().a(jVar2);
                    }
                    gw gwVar2 = new gw();
                    gwVar2.mhK = jVar2.field_userId;
                    linkedList.add(gwVar2);
                }
                raVar.mhL = linkedList;
                cVar.field_bizChatLocalId = -1;
                return true;
            } catch (Throwable e) {
                v.i("MicroMsg.BizChatInfoStorageLogic", "parse memberJson Exception:%s", e.getMessage());
                v.a("MicroMsg.BizChatInfoStorageLogic", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return false;
    }

    public static void g(c cVar) {
        if (cVar == null) {
            v.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo is null");
            return;
        }
        boolean W = u.DB().W(cVar.field_bizChatLocalId);
        boolean fe = cVar.fe(16);
        v.d("MicroMsg.BizChatInfoStorageLogic", "convPlaceTop: %s ,bizChatPlaceTop: %s, chatName: %s ", Boolean.valueOf(W), Boolean.valueOf(fe), cVar.field_chatName);
        if (fe && !W) {
            u.DB().X(cVar.field_bizChatLocalId);
        } else if (!fe && W) {
            u.DB().Y(cVar.field_bizChatLocalId);
        }
    }

    public static void h(c cVar) {
        if (cVar == null) {
            v.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName bizChatInfo is null");
            return;
        }
        ak.yW();
        ab Mh = c.wK().Mh(cVar.field_brandUserName);
        if (Mh == null) {
            v.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName cvs is null");
            return;
        }
        ak.yW();
        bx MI = c.wJ().MI(cVar.field_brandUserName);
        bx I = ak.yW().cqY.I(cVar.field_brandUserName, cVar.field_bizChatLocalId);
        if (MI != null && I != null && MI.field_msgId == I.field_msgId) {
            String str = Mh.field_digest;
            if (str != null) {
                int indexOf = str.indexOf(":");
                if (indexOf != -1) {
                    String substring = str.substring(0, indexOf);
                    str = str.substring(indexOf + 1);
                    if (substring != null && !substring.equals(cVar.field_chatName)) {
                        Mh.cu(cVar.field_chatName + ":" + str);
                        ak.yW();
                        c.wK().a(Mh, Mh.field_username, true);
                    }
                }
            }
        }
    }
}
