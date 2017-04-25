package com.tencent.mm.modelbiz.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.e.b.t;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.h.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.atomic.AtomicLong;

public final class d extends f<t> {
    public static final String[] cic = new String[]{f.a(c.chq, "BizChatInfo")};
    final h<a, b> cBg = new h<a, b>(this) {
        final /* synthetic */ d cDK;

        {
            this.cDK = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((a) obj).a((b) obj2);
        }
    };
    private AtomicLong cDJ = new AtomicLong(-1);
    public com.tencent.mm.sdk.h.d cie;

    public interface a {

        public enum a {
            ;

            static {
                cDL = 1;
                cDM = 2;
                cDN = 3;
                cDO = new int[]{cDL, cDM, cDN};
            }
        }

        public static class b {
            public String aZU;
            public long cDF;
            public int cDP;
            public c cDQ;
        }

        void a(b bVar);
    }

    public d(com.tencent.mm.sdk.h.d dVar) {
        super(dVar, c.chq, "BizChatInfo", null);
        this.cie = dVar;
        dVar.dF("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatLocalIdIndex ON BizChatInfo ( bizChatLocalId )");
        dVar.dF("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatInfo ( bizChatServId )");
        dVar.dF("BizChatInfo", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatInfo ( brandUserName )");
        synchronized (this.cDJ) {
            Cursor rawQuery = this.cie.rawQuery("select max(bizChatLocalId) from BizChatInfo", null);
            long j = 0;
            if (rawQuery.moveToFirst()) {
                j = (long) rawQuery.getInt(0);
                if (j > this.cDJ.get()) {
                    this.cDJ.set(j);
                }
            }
            rawQuery.close();
            v.i("MicroMsg.BizChatInfoStorage", "loading new BizChat id:" + j);
        }
    }

    public final void a(a aVar, Looper looper) {
        this.cBg.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.cBg != null) {
            this.cBg.remove(aVar);
        }
    }

    public final c Z(long j) {
        c cVar = new c();
        cVar.field_bizChatLocalId = j;
        super.b(cVar, new String[0]);
        return cVar;
    }

    public final c hR(String str) {
        c cVar = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * ");
        stringBuilder.append(" from BizChatInfo");
        stringBuilder.append(" where bizChatServId = '").append(str).append("' ");
        stringBuilder.append(" limit 1");
        v.d("MicroMsg.BizChatInfoStorage", "getByServId sql %s", stringBuilder.toString());
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                cVar = new c();
                cVar.b(rawQuery);
            }
            rawQuery.close();
        }
        return cVar;
    }

    public final boolean U(long j) {
        c Z = Z(j);
        boolean c = super.c(Z, "bizChatLocalId");
        if (c) {
            b bVar = new b();
            bVar.cDF = Z.field_bizChatLocalId;
            bVar.aZU = Z.field_brandUserName;
            bVar.cDP = a.cDM;
            bVar.cDQ = Z;
            this.cBg.bg(bVar);
            this.cBg.Ls();
        }
        return c;
    }

    public final boolean a(c cVar) {
        if (cVar == null) {
            v.w("MicroMsg.BizChatInfoStorage", "insert wrong argument");
            return false;
        } else if (be.kS(cVar.field_bizChatServId)) {
            v.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid null");
            return false;
        } else {
            c hR = hR(cVar.field_bizChatServId);
            if (hR != null) {
                cVar.field_bizChatLocalId = hR.field_bizChatLocalId;
                v.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid exist");
                return true;
            }
            cVar.field_bizChatLocalId = DP();
            boolean b = super.b(cVar);
            if (!b) {
                return b;
            }
            b bVar = new b();
            bVar.cDF = cVar.field_bizChatLocalId;
            bVar.aZU = cVar.field_brandUserName;
            bVar.cDP = a.cDL;
            bVar.cDQ = cVar;
            this.cBg.bg(bVar);
            this.cBg.Ls();
            return b;
        }
    }

    public final boolean b(c cVar) {
        boolean z = false;
        if (cVar == null) {
            v.w("MicroMsg.BizChatInfoStorage", "update wrong argument");
        } else if (cVar.field_bizChatLocalId < 0) {
            v.e("MicroMsg.BizChatInfoStorage", "update bizchat localid neg");
        } else {
            c Z = Z(cVar.field_bizChatLocalId);
            if (be.kS(Z.field_bizChatServId) || Z.field_bizChatServId.equals(cVar.field_bizChatServId)) {
                if (cVar == null || be.kS(cVar.field_chatName)) {
                    v.i("MicroMsg.BizChatInfoStorage", "dealWithChatNamePY null");
                } else {
                    cVar.field_chatNamePY = com.tencent.mm.platformtools.c.lT(cVar.field_chatName);
                }
                z = super.a((c) cVar);
                if (z) {
                    e.g(cVar);
                    b bVar = new b();
                    bVar.cDF = cVar.field_bizChatLocalId;
                    bVar.aZU = cVar.field_brandUserName;
                    bVar.cDP = a.cDN;
                    bVar.cDQ = cVar;
                    this.cBg.bg(bVar);
                    this.cBg.Ls();
                }
            } else {
                v.e("MicroMsg.BizChatInfoStorage", "update bizchat servid nequal");
            }
        }
        return z;
    }

    public final c c(c cVar) {
        if (cVar.field_bizChatServId == null) {
            v.w("MicroMsg.BizChatInfoStorage", "setNeedToUpdate： wrong argument!");
            return null;
        }
        c hR = hR(cVar.field_bizChatServId);
        if (hR != null) {
            if (cVar.field_chatVersion > hR.field_chatVersion || be.kS(hR.field_brandUserName)) {
                if (!be.kS(cVar.field_chatName)) {
                    hR.field_chatName = cVar.field_chatName;
                }
                hR.field_brandUserName = cVar.field_brandUserName;
                hR.field_needToUpdate = true;
                hR.field_chatType = cVar.field_chatType;
                b(hR);
            }
            return hR;
        }
        cVar.field_needToUpdate = true;
        if (a(cVar)) {
            return cVar;
        }
        return null;
    }

    private long DP() {
        synchronized (this.cDJ) {
            v.i("MicroMsg.BizChatInfoStorage", "incBizChatLocalId %d  ", Long.valueOf(this.cDJ.incrementAndGet()));
        }
        return r2;
    }
}
