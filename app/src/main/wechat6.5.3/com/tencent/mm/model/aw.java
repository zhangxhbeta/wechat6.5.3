package com.tencent.mm.model;

import android.database.Cursor;
import android.support.v7.a.a.k;
import com.tencent.mm.e.a.ia;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.d.c;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;
import java.util.Map;

public final class aw {

    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ a crx = null;
        final /* synthetic */ List ctr;

        public AnonymousClass3(List list, a aVar) {
            this.ctr = list;
        }

        public final void run() {
            for (String str : this.ctr) {
                Cursor MQ = ((d) g.f(d.class)).azI().MQ(str);
                if (MQ != null) {
                    if (MQ.moveToFirst()) {
                        while (!MQ.isAfterLast() && (this.crx == null || !this.crx.zp())) {
                            at atVar = new at();
                            atVar.b(MQ);
                            aw.f(atVar);
                            MQ.moveToNext();
                        }
                    }
                    MQ.close();
                    int MO = ((d) g.f(d.class)).azI().MO(str);
                    v.v("MicroMsg.MsgInfoStorageLogic", "delete msgs %s, %d", str, Integer.valueOf(MO));
                }
            }
            ad.o(new Runnable(this) {
                final /* synthetic */ AnonymousClass3 cts;

                {
                    this.cts = r1;
                }

                public final void run() {
                    if (this.cts.crx != null) {
                        this.cts.crx.zo();
                    }
                }
            });
        }

        public final String toString() {
            return super.toString() + "|deleteMsgByTalkers";
        }
    }

    public interface a {
        void zo();

        boolean zp();
    }

    public static class b {
        public String ctA;
        public String ctB;
        public String ctC;
        public String ctD;
        public int ctE;
        public String ctt;
        public String ctu;
        public String ctv;
        public String ctw;
        public String cty;
        public String ctz;
        public int scene = 0;
        public String userId;
    }

    @Deprecated
    public static int fJ(String str) {
        return fK(str);
    }

    public static String K(String str, String str2) {
        if (be.kS(str)) {
            return null;
        }
        return !be.kS(str2) ? str2 + ": " + str : str;
    }

    public static int fK(String str) {
        if (str == null) {
            v.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos text is null]");
            return -1;
        } else if (str.length() <= 0) {
            v.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos length < 0]");
            return -1;
        } else if (str.startsWith("~SEMI_XML~")) {
            v.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos startsWith(SemiXml.MAGIC_HEAD)]");
            return -1;
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
                return indexOf;
            }
            v.e("MicroMsg.MsgInfoStorageLogic", "dz[reject illegal character]");
            return -1;
        }
    }

    public static String fL(String str) {
        int fK = fK(str);
        if (fK == -1) {
            return null;
        }
        return str.substring(0, fK);
    }

    public static String fM(String str) {
        int fK = fK(str);
        return (fK != -1 && fK + 2 < str.length()) ? str.substring(fK + 2) : str;
    }

    public static long e(at atVar) {
        com.tencent.mm.i.a LX = ((d) g.f(d.class)).wH().LX(atVar.field_talker);
        if (LX == null || ((int) LX.chr) == 0) {
            u uVar = new u(atVar.field_talker);
            uVar.setType(2);
            com.tencent.mm.sdk.c.b iaVar = new ia();
            iaVar.bhU.bhV = uVar;
            com.tencent.mm.sdk.c.a.nhr.z(iaVar);
            ((d) g.f(d.class)).wH().N(uVar);
        }
        return ((d) g.f(d.class)).azI().R(atVar);
    }

    public static boolean eM(int i) {
        switch (i) {
            case k.MM /*22*/:
            case k.Nb /*23*/:
            case 24:
            case k.Kr /*26*/:
            case 27:
            case 28:
            case 29:
                return true;
            default:
                return false;
        }
    }

    public static long fN(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str != null) {
            bx MI = ((d) g.f(d.class)).azI().MI(str);
            if (MI != null && MI.field_createTime + 1 > currentTimeMillis) {
                return MI.field_createTime + 1;
            }
        }
        return currentTimeMillis;
    }

    public static long h(String str, long j) {
        long j2;
        if (str != null) {
            bx MI = ((d) g.f(d.class)).azI().MI(str);
            if (MI != null) {
                j2 = MI.field_createTime + 1;
                return j2 <= j * 1000 ? j2 : j * 1000;
            }
        }
        j2 = 0;
        if (j2 <= j * 1000) {
        }
    }

    public static void f(at atVar) {
        if (atVar != null) {
            int i = atVar.field_type;
            switch (i) {
                case -1879048191:
                case -1879048190:
                case -1879048189:
                    i = 49;
                    break;
            }
            com.tencent.mm.v.d ax = c.ax(Integer.valueOf(i));
            if (ax != null) {
                ax.d(atVar);
            }
        }
    }

    public static void w(List<Long> list) {
        if (list.size() != 0) {
            for (Long longValue : list) {
                L(longValue.longValue());
            }
        }
    }

    public static int L(long j) {
        bx ek = ((d) g.f(d.class)).azI().ek(j);
        if (ek.field_msgId != j) {
            return 0;
        }
        f(ek);
        return ((d) g.f(d.class)).azI().em(j);
    }

    public static int i(String str, long j) {
        bx S = ((d) g.f(d.class)).azI().S(str, j);
        if (S.field_msgSvrId != j) {
            return 0;
        }
        f(S);
        return ((d) g.f(d.class)).azI().Z(str, j);
    }

    public static int fO(String str) {
        return ((d) g.f(d.class)).azI().MO(str);
    }

    public static int a(final String str, final a aVar) {
        v.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalker %s", str);
        g.vx();
        g.vA().x(new Runnable() {
            final int ctl = 200;
            final int ctm = 30;
            final int ctn = 5;
            int cto = 100;

            public final void run() {
                long Ni = be.Ni();
                bx MI = ((d) g.f(d.class)).azI().MI(str);
                long j = MI == null ? Long.MAX_VALUE : MI.field_createTime;
                long j2 = 0;
                int i = 0;
                long j3;
                do {
                    if (this.cto < 200 && this.cto > 30) {
                        int i2;
                        if (j2 > 500) {
                            i2 = this.cto - 5;
                        } else {
                            i2 = this.cto + 5;
                        }
                        this.cto = i2;
                    }
                    long Ni2 = be.Ni();
                    Cursor c = ((d) g.f(d.class)).azI().c(str, this.cto, j);
                    long j4 = 0;
                    j3 = 0;
                    while (c.moveToNext() && (aVar == null || !aVar.zp())) {
                        bx atVar = new at();
                        atVar.b(c);
                        if (j4 < atVar.field_createTime) {
                            j4 = atVar.field_createTime;
                        }
                        j2 = 1 + j3;
                        aw.f(atVar);
                        j3 = j2;
                    }
                    c.close();
                    long Ni3 = be.Ni();
                    if (j4 > 0 && j3 > 0) {
                        ((d) g.f(d.class)).azI().aa(str, j4);
                    }
                    i = (int) (((long) i) + j3);
                    long Ni4 = be.Ni();
                    j2 = Ni4 - Ni2;
                    String str = "MicroMsg.MsgInfoStorageLogic";
                    String str2 = "deleteMsgByTalker:%s iDelMsg:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)";
                    Object[] objArr = new Object[10];
                    objArr[0] = be.KW(str);
                    objArr[1] = aVar == null ? "null" : Boolean.valueOf(aVar.zp());
                    objArr[2] = Integer.valueOf(i);
                    objArr[3] = Long.valueOf(j3);
                    objArr[4] = Long.valueOf(j - j4);
                    objArr[5] = Long.valueOf(j);
                    objArr[6] = Long.valueOf(Ni4 - Ni3);
                    objArr[7] = Long.valueOf(Ni4 - Ni2);
                    objArr[8] = Long.valueOf(Ni4 - Ni);
                    objArr[9] = Integer.valueOf(this.cto);
                    v.i(str, str2, objArr);
                } while (j3 > 0);
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 ctp;

                    {
                        this.ctp = r1;
                    }

                    public final void run() {
                        if (aVar != null) {
                            aVar.zo();
                        }
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|deleteMsgByTalker";
            }
        });
        return 0;
    }

    public static void a(final a aVar) {
        g.vx();
        g.vA().x(new Runnable() {
            public final void run() {
                int i = 0;
                if (aVar == null || !aVar.zp()) {
                    j wK = ((d) g.f(d.class)).wK();
                    int i2 = (wK.cie.dF("rconversation", "delete from rconversation") || wK.cie.dF("rconversation", "delete from rbottleconversation")) ? 1 : 0;
                    if (i2 != 0) {
                        wK.b(5, wK, SQLiteDatabase.KeyEmpty);
                    }
                    if (aVar == null || !aVar.zp()) {
                        aw.zm();
                        if (aVar == null || !aVar.zp()) {
                            aw.zn();
                            if (aVar == null || !aVar.zp()) {
                                aw.zl();
                                if (aVar == null || !aVar.zp()) {
                                    List ML = ((d) g.f(d.class)).azI().ML("message");
                                    if (ML != null) {
                                        while (i < ML.size()) {
                                            aw.f((at) ML.get(i));
                                            i++;
                                        }
                                    }
                                    ((d) g.f(d.class)).azI().MN("message");
                                }
                            }
                        }
                    }
                }
                if (aVar != null) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 ctq;

                        {
                            this.ctq = r1;
                        }

                        public final void run() {
                            aVar.zo();
                        }
                    });
                }
            }

            public final String toString() {
                return super.toString() + "|deleteAllMsg";
            }
        });
    }

    public static void zl() {
        List ML = ((d) g.f(d.class)).azI().ML("bottlemessage");
        if (ML != null) {
            for (int i = 0; i < ML.size(); i++) {
                f((at) ML.get(i));
            }
        }
        ((d) g.f(d.class)).azI().MN("bottlemessage");
    }

    public static void zm() {
        List ML = ((d) g.f(d.class)).azI().ML("qmessage");
        if (ML != null) {
            for (int i = 0; i < ML.size(); i++) {
                f((at) ML.get(i));
            }
        }
        ((d) g.f(d.class)).azI().MN("qmessage");
    }

    public static void zn() {
        List ML = ((d) g.f(d.class)).azI().ML("tmessage");
        if (ML != null) {
            for (int i = 0; i < ML.size(); i++) {
                f((at) ML.get(i));
            }
        }
        ((d) g.f(d.class)).azI().MN("tmessage");
    }

    public static b fP(String str) {
        if (be.kS(str)) {
            return null;
        }
        try {
            Map q = bf.q(str, "msgsource");
            if (q == null || q.isEmpty()) {
                return null;
            }
            b bVar = new b();
            bVar.ctt = (String) q.get(".msgsource.bizmsg.msgcluster");
            bVar.ctv = (String) q.get(".msgsource.kf.kf_worker");
            bVar.ctu = be.ma((String) q.get(".msgsource.bizmsg.bizclientmsgid"));
            bVar.cty = be.ma((String) q.get(".msgsource.enterprise_info.qy_msg_type"));
            bVar.ctz = be.ma((String) q.get(".msgsource.enterprise_info.bizchat_id"));
            bVar.ctA = be.ma((String) q.get(".msgsource.enterprise_info.bizchat_ver"));
            bVar.userId = be.ma((String) q.get(".msgsource.enterprise_info.user_id"));
            bVar.ctB = be.ma((String) q.get(".msgsource.enterprise_info.user_nickname"));
            bVar.ctC = be.ma((String) q.get(".msgsource.enterprise_info.sync_from_qy_im"));
            bVar.ctw = (String) q.get(".msgsource.strangerantispamticket.$ticket");
            bVar.scene = be.getInt((String) q.get(".msgsource.strangerantispamticket.$scene"), 0);
            bVar.ctD = (String) q.get(".msgsource.NotAutoDownloadRange");
            bVar.ctE = be.getInt((String) q.get(".msgsource.DownloadLimitKbps"), 0);
            return bVar;
        } catch (Throwable e) {
            v.e("MicroMsg.MsgInfoStorageLogic", "exception:%s", be.e(e));
            v.e("MicroMsg.MsgInfoStorageLogic", "Exception in getMsgSourceValue, %s", e.getMessage());
            return null;
        }
    }

    public static String fQ(String str) {
        b fP = fP(str);
        if (fP == null) {
            return null;
        }
        return fP.ctv;
    }

    public static void a(at atVar, com.tencent.mm.v.d.a aVar) {
        if (atVar == null || aVar == null || aVar.czu == null) {
            v.e("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgWithAddMsgInfo error input is null, stack[%s]", be.bur());
        } else if (atVar.field_msgSvrId == aVar.czu.mcb) {
            bm bmVar = aVar.czu;
            if (atVar.field_isSend == 0 || bmVar.mcc != 0) {
                if (atVar.field_msgSeq == 0 && bmVar.mcc != 0) {
                    atVar.B((long) bmVar.mcc);
                }
                int i = atVar.field_flag;
                if (aVar.czv) {
                    i |= 2;
                } else {
                    i &= -3;
                }
                if (aVar.czw) {
                    i |= 1;
                } else {
                    i &= -2;
                }
                if (aVar.czx) {
                    i |= 4;
                } else {
                    i &= -5;
                }
                atVar.dr(i);
                if (atVar.field_msgId == 0 && aVar.czv) {
                    atVar.z(a(atVar.field_talker, (long) aVar.czu.hNS, aVar.czx, (long) aVar.czu.mcc));
                }
            }
        }
    }

    public static int c(com.tencent.mm.v.d.a aVar) {
        int i = 0;
        if (aVar.czv) {
            i = 2;
        }
        if (aVar.czw) {
            i |= 1;
        }
        if (aVar.czx) {
            return i | 4;
        }
        return i;
    }

    public static long a(String str, long j, boolean z, long j2) {
        long j3 = j * 1000;
        long j4 = 0;
        long j5 = -1;
        bx bxVar = null;
        if (str != null) {
            bxVar = ((d) g.f(d.class)).azI().MI(str);
            if (bxVar != null) {
                j4 = bxVar.field_createTime;
            }
            j5 = ((d) g.f(d.class)).azI().Ng(str);
        }
        if (j5 == j4) {
            return j3 == j4 ? j3 + 1 : j3;
        } else {
            if (j5 >= j4) {
                v.w("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgCreateTime first > last [%d > %d], ret serverMillTime:%d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3));
                return j3;
            } else if (j3 == j5) {
                return j3 - 1;
            } else {
                if (j3 == j4) {
                    return j3 + 1;
                }
                if (z || j2 == 0 || j3 > j4) {
                    return j3;
                }
                bx U = ((d) g.f(d.class)).azI().U(str, j3);
                if (U.field_msgSeq == 0 || U.field_msgSeq == j2) {
                    j5 = j3;
                } else {
                    j5 = U.field_msgSeq < j2 ? 1 + j3 : j3 - 1;
                    v.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime 1 seq[%d, %d] need fix serverMillTime[%d]", Long.valueOf(U.field_msgSeq), Long.valueOf(j2), Long.valueOf(j5));
                    if (!(j5 != j4 || bxVar == null || bxVar.field_msgSeq == 0)) {
                        j5 = bxVar.field_msgSeq < j2 ? 1 + j4 : j4 - 1;
                        v.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime 2 seq[%d, %d] need fix serverMillTime[%d]", Long.valueOf(bxVar.field_msgSeq), Long.valueOf(j2), Long.valueOf(j5));
                    }
                }
                return j5;
            }
        }
    }
}
