package com.tencent.mm.modelfriend;

import com.tencent.mm.bg.f.a;
import com.tencent.mm.bg.g;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;

public final class t extends f<s> implements a {
    public static final String[] cic = new String[]{f.a(s.chq, "LinkedInFriend")};
    public j cHU = new j(this) {
        final /* synthetic */ t cHY;

        {
            this.cHY = r1;
        }

        protected final boolean EP() {
            if (this.cHY.cie != null && !this.cHY.cie.buA()) {
                return true;
            }
            String str = "MicroMsg.LinkedInFriendStorage";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = this.cHY.cie == null ? "null" : Boolean.valueOf(this.cHY.cie.buA());
            v.w(str, str2, objArr);
            return false;
        }
    };
    public d cie;

    public final /* synthetic */ boolean b(c cVar) {
        return a((s) cVar);
    }

    public t(d dVar) {
        super(dVar, s.chq, "LinkedInFriend", null);
        this.cie = dVar;
    }

    public final String getTableName() {
        return "LinkedInFriend";
    }

    public final int a(com.tencent.mm.bg.f fVar) {
        if (fVar != null) {
            this.cie = fVar;
        }
        return 0;
    }

    private boolean a(s sVar) {
        if (sVar == null) {
            return false;
        }
        if (((int) this.cie.insert("LinkedInFriend", "linkedInId", sVar.py())) > 0) {
            return true;
        }
        return false;
    }

    public final boolean G(List<s> list) {
        int i = 0;
        if (list.size() <= 0) {
            v.d("MicroMsg.LinkedInFriendStorage", "insertList . list is null.");
            return false;
        }
        long er;
        g gVar;
        if (this.cie instanceof g) {
            g gVar2 = (g) this.cie;
            er = gVar2.er(Thread.currentThread().getId());
            v.i("MicroMsg.LinkedInFriendStorage", "surround insertList in a transaction, ticket = %d", Long.valueOf(er));
            gVar = gVar2;
        } else {
            gVar = null;
            er = -1;
        }
        while (i < list.size()) {
            a((s) list.get(i));
            i++;
        }
        if (gVar != null) {
            gVar.es(er);
            v.i("MicroMsg.LinkedInFriendStorage", "end updateList transaction");
        }
        this.cHU.b(2, this.cHU, SQLiteDatabase.KeyEmpty);
        return true;
    }

    public final boolean iL(String str) {
        return this.cie.dF("LinkedInFriend", "UPDATE LinkedInFriend SET userOpStatus='1" + "' WHERE linkedInId=" + "'" + str + "'");
    }

    public final void clear() {
        this.cie.dF("LinkedInFriend", " delete from LinkedInFriend");
        this.cHU.b(5, this.cHU, SQLiteDatabase.KeyEmpty);
    }
}
