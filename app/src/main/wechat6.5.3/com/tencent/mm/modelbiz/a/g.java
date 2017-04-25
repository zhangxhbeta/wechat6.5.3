package com.tencent.mm.modelbiz.a;

import android.database.Cursor;
import com.tencent.mm.e.b.u;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.h.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class g extends f<u> {
    public static final String[] cic = new String[]{f.a(f.chq, "BizChatMyUserInfo")};
    private final h<a, b> cBg = new h<a, b>(this) {
        final /* synthetic */ g cDV;

        {
            this.cDV = r1;
        }

        protected final /* bridge */ /* synthetic */ void o(Object obj, Object obj2) {
        }
    };
    private d cie;

    public interface a {

        public enum a {
            ;

            static {
                cDW = 1;
                cDX = 2;
                cDY = 3;
                cDZ = new int[]{cDW, cDX, cDY};
            }
        }

        public static class b {
            public String aZU;
            public int cEa;
            public f cEb;
        }
    }

    public g(d dVar) {
        super(dVar, f.chq, "BizChatMyUserInfo", null);
        this.cie = dVar;
        dVar.dF("BizChatMyUserInfo", "CREATE INDEX IF NOT EXISTS bizChatbrandUserNameIndex ON BizChatMyUserInfo ( brandUserName )");
    }

    public final f ie(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.BizChatMyUserInfoStorage", "get： wrong argument");
            return null;
        }
        c fVar = new f();
        fVar.field_brandUserName = str;
        super.b(fVar, new String[0]);
        return fVar;
    }

    public final boolean if(String str) {
        boolean z = false;
        if (be.kS(str)) {
            v.w("MicroMsg.BizChatMyUserInfoStorage", "delete wrong argument");
        } else {
            c fVar = new f();
            fVar.field_brandUserName = str;
            z = super.c(fVar, "brandUserName");
            if (z) {
                b bVar = new b();
                bVar.aZU = fVar.field_brandUserName;
                bVar.cEa = a.cDX;
                bVar.cEb = fVar;
                this.cBg.bg(bVar);
                this.cBg.Ls();
            }
        }
        return z;
    }

    public final boolean a(f fVar) {
        v.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert");
        boolean b = super.b(fVar);
        if (b) {
            b bVar = new b();
            bVar.aZU = fVar.field_brandUserName;
            bVar.cEa = a.cDW;
            bVar.cEb = fVar;
            this.cBg.bg(bVar);
            this.cBg.Ls();
        } else {
            v.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert fail");
        }
        return b;
    }

    public final boolean b(f fVar) {
        v.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update");
        if (fVar == null) {
            v.w("MicroMsg.BizChatMyUserInfoStorage", "update wrong argument");
            return false;
        }
        boolean a = super.a((c) fVar);
        if (a) {
            b bVar = new b();
            bVar.aZU = fVar.field_brandUserName;
            bVar.cEa = a.cDY;
            bVar.cEb = fVar;
            this.cBg.bg(bVar);
            this.cBg.Ls();
            return a;
        }
        v.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update fail");
        return a;
    }

    public final int getCount() {
        int i = 0;
        v.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage getCount");
        Cursor rawQuery = this.cie.rawQuery("SELECT COUNT(*) FROM BizChatMyUserInfo", null);
        if (rawQuery.moveToLast()) {
            i = rawQuery.getInt(0);
        }
        rawQuery.close();
        return i;
    }
}
