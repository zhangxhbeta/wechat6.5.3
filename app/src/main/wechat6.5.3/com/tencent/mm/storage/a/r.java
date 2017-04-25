package com.tencent.mm.storage.a;

import android.database.Cursor;
import com.tencent.mm.bg.f.a;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class r extends f<q> implements a {
    public static final String[] cic = new String[]{f.a(q.chq, "GetEmotionListCache")};
    private d cie;

    public r(d dVar) {
        this(dVar, q.chq, "GetEmotionListCache");
    }

    private r(d dVar, c.a aVar, String str) {
        super(dVar, aVar, str, null);
        this.cie = dVar;
    }

    public final int a(com.tencent.mm.bg.f fVar) {
        if (fVar != null) {
            this.cie = fVar;
        }
        return 0;
    }

    public final boolean a(int i, vt vtVar) {
        boolean z = false;
        if (vtVar != null) {
            try {
                this.cie.delete("GetEmotionListCache", "reqType=?", new String[]{String.valueOf(i)});
                q qVar = new q(String.valueOf(i), vtVar.toByteArray());
                v.d("MicroMsg.emoji.Storage", "insert cache: %d", new Object[]{Integer.valueOf(i)});
                z = b(qVar);
            } catch (Throwable e) {
                v.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{be.e(e)});
            }
        }
        return z;
    }

    public final vt vo(int i) {
        vt vtVar = null;
        Cursor query = this.cie.query("GetEmotionListCache", null, "reqType=?", new String[]{String.valueOf(i)}, null, null, null);
        if (query != null && query.moveToFirst()) {
            q qVar = new q(query);
            try {
                vt vtVar2 = new vt();
                vtVar2.az(qVar.field_cache);
                v.d("MicroMsg.emoji.Storage", "succed get cache: %d", new Object[]{Integer.valueOf(i)});
                vtVar = vtVar2;
            } catch (Throwable e) {
                v.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{be.e(e)});
            }
        }
        if (query != null) {
            query.close();
        }
        return vtVar;
    }

    public final boolean a(String str, xy xyVar) {
        boolean z = false;
        if (xyVar != null) {
            try {
                this.cie.delete("GetEmotionListCache", "reqType=?", new String[]{str});
                z = b(new q(str, xyVar.toByteArray()));
            } catch (Throwable e) {
                v.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{be.e(e)});
            }
        }
        return z;
    }

    public final xy NM(String str) {
        xy xyVar = null;
        Cursor query = this.cie.query("GetEmotionListCache", null, "reqType=?", new String[]{str}, null, null, null);
        if (query != null && query.moveToFirst()) {
            q qVar = new q(query);
            try {
                xy xyVar2 = new xy();
                xyVar2.az(qVar.field_cache);
                v.d("MicroMsg.emoji.Storage", "succed get designerID cache: %s", new Object[]{str});
                xyVar = xyVar2;
            } catch (Throwable e) {
                v.e("MicroMsg.emoji.Storage", "exception:%s", new Object[]{be.e(e)});
            }
        }
        if (query != null) {
            query.close();
        }
        return xyVar;
    }
}
