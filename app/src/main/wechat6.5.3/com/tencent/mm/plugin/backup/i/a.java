package com.tencent.mm.plugin.backup.i;

import com.tencent.mm.as.n;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.g.z;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import java.io.File;
import java.util.HashMap;

public final class a {
    public static void b(HashMap<String, Integer> hashMap) {
        for (String str : hashMap.keySet()) {
            bx dL = b.Vd().wJ().dL(str, " and not ( type = 10000 and isSend != 2 ) ");
            int intValue = ((Integer) hashMap.get(str)).intValue();
            String str2 = dL.field_talker;
            v.i("MicroMsg.TempStorageLogic", "talker:%s, addUnreadCount:%d", str2, Integer.valueOf(intValue));
            ab Mh = b.Vd().wK().Mh(str2);
            if (Mh == null || Mh.field_conversationTime <= dL.field_createTime || Mh.field_conversationTime == Long.MAX_VALUE) {
                boolean z;
                if (Mh == null) {
                    v.i("MicroMsg.TempStorageLogic", "updateConvFromLastMsg conversation is null.");
                    v.d("MicroMsg.TempStorageLogic", "updateConvFromLastMsg cvs:%s", str2);
                    Mh = new ab(str2);
                    z = true;
                } else {
                    z = false;
                }
                Mh.di(dL.field_isSend);
                Mh.df(intValue + Mh.field_unReadCount);
                Mh.M(dL);
                Mh.ct(Integer.toString(dL.field_type));
                Mh.t((Mh.field_flag & 4611686018427387904L) | (dL.field_createTime & 72057594037927935L));
                Mh.de(0);
                if (z) {
                    v.d("MicroMsg.TempStorageLogic", "updateConvFromLastMsg cvs:%s, cvs.flag:%d", str2, Long.valueOf(Mh.field_flag));
                    b.Vd().wK().d(Mh);
                } else {
                    b.Vd().wK().a(Mh, str2, true);
                }
            } else {
                v.i("MicroMsg.TempStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
            }
        }
        b.Vd().wK().bvH();
    }

    public static boolean dE(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@chatroom");
    }

    public static long e(at atVar) {
        com.tencent.mm.i.a LX = b.Vd().wH().LX(atVar.field_talker);
        if (LX == null || ((int) LX.chr) == 0) {
            if (!be.kS(atVar.field_talker)) {
                b.Vh().b(2, atVar.field_talker);
                b.Vd().wH().N(new u(atVar.field_talker));
            } else if (atVar.field_talker.endsWith("@chatroom")) {
                z Vd = b.Vd();
                if (Vd.uin == 0) {
                    throw new com.tencent.mm.model.b();
                } else if (Vd.crb.LF(atVar.field_talker) == null) {
                    b.Vh().b(2, atVar.field_talker);
                }
            }
        }
        long R = b.Vd().wJ().R(atVar);
        if (R < 0) {
            v.e("MicroMsg.TempStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", Integer.valueOf(atVar.field_type), atVar.field_talker);
        }
        return R;
    }

    public static int fK(String str) {
        if (str == null || str.length() <= 0) {
            return -1;
        }
        int indexOf = str.indexOf(58);
        if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
            return indexOf;
        }
        return -1;
    }

    public static n lp(String str) {
        if (be.kS(str)) {
            return null;
        }
        return b.Vd().KV().kZ(str);
    }

    public static String iU(String str) {
        z Vd = b.Vd();
        if (Vd.uin == 0) {
            throw new com.tencent.mm.model.b();
        }
        String b = h.b(Vd.cka + "voice2/", "msg_", str, ".amr", 2);
        if (be.kS(b)) {
            return null;
        }
        if (new File(b).exists()) {
            return b;
        }
        StringBuilder stringBuilder = new StringBuilder();
        z Vd2 = b.Vd();
        if (Vd2.uin == 0) {
            throw new com.tencent.mm.model.b();
        }
        String stringBuilder2 = stringBuilder.append(Vd2.cka + "voice/").append(str).toString();
        if (new File(stringBuilder2 + ".amr").exists()) {
            j.n(stringBuilder2 + ".amr", b, true);
            return b;
        } else if (!new File(stringBuilder2).exists()) {
            return b;
        } else {
            j.n(stringBuilder2, b, true);
            return b;
        }
    }
}
