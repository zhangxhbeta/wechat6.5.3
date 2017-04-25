package com.tencent.mm.plugin.f.a;

import android.database.Cursor;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.k;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.plugin.f.a.a.i;
import com.tencent.mm.plugin.f.a.a.j;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.protocal.c.ml;
import com.tencent.mm.protocal.c.mr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;

public final class c implements i {
    private static final b hkS = new b();

    public interface a {
        void c(bm bmVar);
    }

    private static final class b extends com.tencent.mm.av.a<a> implements a {
        private b() {
        }

        public final void c(final bm bmVar) {
            a(new com.tencent.mm.av.a.a<a>(this) {
                final /* synthetic */ b hkT;

                public final /* synthetic */ void an(Object obj) {
                    ((a) obj).c(bmVar);
                }
            });
        }
    }

    public static com.tencent.mm.vending.b.b a(a aVar) {
        return hkS.ay(aVar);
    }

    public final void a(kz kzVar, byte[] bArr, boolean z, j jVar) {
        int i;
        switch (kzVar.bkM) {
            case 5:
                bm bmVar = (bm) new bm().az(bArr);
                if (bmVar != null) {
                    a(new com.tencent.mm.v.d.a(bmVar, false, false, false), jVar);
                    return;
                }
                return;
            case 8:
                ml mlVar = (ml) new ml().az(bArr);
                String a = m.a(mlVar.moM);
                i = mlVar.moQ;
                Cursor bP = ((d) g.f(d.class)).azI().bP(a, i);
                if (bP.moveToFirst()) {
                    while (!bP.isAfterLast()) {
                        at atVar = new at();
                        atVar.b(bP);
                        aw.f(atVar);
                        bP.moveToNext();
                    }
                }
                bP.close();
                ((d) g.f(d.class)).azI().bO(a, i);
                return;
            case 9:
                mr mrVar = (mr) new mr().az(bArr);
                List list = mrVar.moT;
                for (i = 0; i < list.size(); i++) {
                    aw.i(m.a(mrVar.moM), (long) ((Integer) list.get(i)).intValue());
                }
                return;
            default:
                return;
        }
    }

    public static void a(com.tencent.mm.v.d.a aVar, j jVar) {
        bm bmVar = aVar.czu;
        if (10008 == q.dqj && q.dqk != 0) {
            v.i("MicroMsg.MessageSyncExtension", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(bmVar.mcb), Integer.valueOf(q.dqk));
            bmVar.mcb = Long.valueOf((long) q.dqk).longValue();
            q.dqk = 0;
        }
        if (((d) g.f(d.class)).azI().en(bmVar.mcb)) {
            v.i("MicroMsg.MessageSyncExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
            return;
        }
        String a = m.a(bmVar.mbU);
        String a2 = m.a(bmVar.mbV);
        if (a.equals(k.xF()) && a2.equals("newsapp") && bmVar.gll != 51) {
            v.w("MicroMsg.MessageSyncExtension", "msgid:%d type:%d this fucking msg from mac weixin ,someone send msg to newsapp at mac weixin ,givp up.", Long.valueOf(bmVar.mcb), Integer.valueOf(bmVar.gll));
            return;
        }
        String str = "MicroMsg.MessageSyncExtension";
        String str2 = "dkAddMsg from:%s to:%s id:[%d,%d] status:%d type:%d time:[%d %s] diff:%d imgstatus:%d imgbuf:%d src:%d push:%d content:%s";
        Object[] objArr = new Object[14];
        objArr[0] = a;
        objArr[1] = a2;
        objArr[2] = Long.valueOf(bmVar.mcb);
        objArr[3] = Integer.valueOf(bmVar.mbT);
        objArr[4] = Integer.valueOf(bmVar.eeO);
        objArr[5] = Integer.valueOf(bmVar.gll);
        objArr[6] = Integer.valueOf(bmVar.hNS);
        objArr[7] = be.ec((long) bmVar.hNS);
        objArr[8] = Long.valueOf(be.Nh() - ((long) bmVar.hNS));
        objArr[9] = Integer.valueOf(bmVar.mbX);
        objArr[10] = Integer.valueOf(m.a(bmVar.mbY, new byte[0]).length);
        objArr[11] = Integer.valueOf(be.ma(bmVar.mbZ).length());
        objArr[12] = Integer.valueOf(be.ma(bmVar.mca).length());
        arf com_tencent_mm_protocal_c_arf = bmVar.mbW;
        a2 = SQLiteDatabase.KeyEmpty;
        if (com_tencent_mm_protocal_c_arf != null) {
            a2 = com_tencent_mm_protocal_c_arf.mQy;
        }
        objArr[13] = be.KW(a2);
        v.i(str, str2, objArr);
        v.i("MicroMsg.MessageSyncExtension", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", bmVar.mbZ, SQLiteDatabase.KeyEmpty);
        if (a.equals("readerapp")) {
            bmVar.mbU = m.lY("newsapp");
            bmVar.gll = 12399999;
        }
        if ((a.equals("blogapp") || a.equals("newsapp")) && bmVar.gll != CdnLogic.MediaType_FAVORITE_VIDEO) {
            bmVar.gll = 12399999;
        }
        if (bmVar.gll == 52) {
            bmVar.gll = 1000052;
        }
        if (bmVar.gll == 53) {
            bmVar.gll = 1000053;
        }
        if (aVar.czu != null) {
            bm bmVar2 = aVar.czu;
            bx S = ((d) g.f(d.class)).azI().S(m.a(bmVar2.mbU), bmVar2.mcb);
            if (S.field_msgId != 0 && (S.field_isSend == 0 || bmVar2.mcc != 0)) {
                int i = S.field_flag;
                i = aVar.czv ? i | 2 : i & -3;
                i = aVar.czw ? i | 1 : i & -2;
                i = aVar.czx ? i | 4 : i & -5;
                if (i != S.field_flag) {
                    v.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr updateMsgFlagByAddMsgInfo msgType[%d], flag new[%d], old[%d]", Integer.valueOf(bmVar2.gll), Integer.valueOf(i), Integer.valueOf(S.field_flag));
                    S.dr(i);
                    ((d) g.f(d.class)).azI().b(S.field_msgSvrId, S);
                }
            }
        }
        Object obj = null;
        com.tencent.mm.v.d ax = com.tencent.mm.v.d.c.ax(Integer.valueOf(bmVar.gll));
        if (ax == null) {
            ax = com.tencent.mm.v.d.c.ax(a);
        }
        if (ax != null) {
            com.tencent.mm.v.d.b b = ax.b(aVar);
            bx bxVar = b == null ? null : b.aXd;
            if (bxVar == null) {
                v.w("MicroMsg.MessageSyncExtension", "extension declared but skipped msg, type=" + bmVar.gll + ", svrid=" + bmVar.mcb);
            } else {
                obj = (!com.tencent.mm.model.m.eH(a) || com.tencent.mm.af.b.He()) ? null : 1;
                if (obj == null) {
                    v.d("MicroMsg.MessageSyncExtension", " msg , id =" + bxVar.field_msgId + "  " + jVar);
                    if (bxVar.field_msgId > 0 && jVar != null && b.czy) {
                        jVar.a(bxVar, bmVar);
                    }
                }
            }
            obj = 1;
        }
        hkS.c(bmVar);
        if (obj == null) {
            v.f("MicroMsg.MessageSyncExtension", "unknown add msg request, type=%d. drop now !!!", Integer.valueOf(bmVar.gll));
        }
    }
}
