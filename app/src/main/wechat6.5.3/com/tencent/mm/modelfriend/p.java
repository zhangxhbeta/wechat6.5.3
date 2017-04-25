package com.tencent.mm.modelfriend;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.bg.f.a;
import com.tencent.mm.bg.g;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;

public final class p extends f<o> implements a {
    public static final String[] cic = new String[]{f.a(o.chq, "GoogleFriend")};
    public j cHU = new j(this) {
        final /* synthetic */ p cHV;

        {
            this.cHV = r1;
        }

        protected final boolean EP() {
            if (this.cHV.cie != null && !this.cHV.cie.buA()) {
                return true;
            }
            String str = "MicroMsg.GoogleContact.GoogleFriendUI";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = this.cHV.cie == null ? "null" : Boolean.valueOf(this.cHV.cie.buA());
            v.w(str, str2, objArr);
            return false;
        }
    };
    public d cie;

    public final /* synthetic */ boolean b(c cVar) {
        return a((o) cVar);
    }

    public p(d dVar) {
        super(dVar, o.chq, "GoogleFriend", null);
        this.cie = dVar;
    }

    public final String getTableName() {
        return "GoogleFriend";
    }

    public final int a(com.tencent.mm.bg.f fVar) {
        if (fVar != null) {
            this.cie = fVar;
        }
        return 0;
    }

    private boolean a(o oVar) {
        if (oVar == null) {
            return false;
        }
        if (((int) this.cie.insert("GoogleFriend", "googleitemid", oVar.py())) > 0) {
            return true;
        }
        return false;
    }

    public final boolean g(ArrayList<o> arrayList) {
        int i = 0;
        if (arrayList.size() <= 0) {
            v.d("MicroMsg.GoogleContact.GoogleFriendUI", "insertList . list is null.");
            return false;
        }
        long er;
        g gVar;
        if (this.cie instanceof g) {
            g gVar2 = (g) this.cie;
            er = gVar2.er(Thread.currentThread().getId());
            v.i("MicroMsg.GoogleContact.GoogleFriendUI", "surround insertList in a transaction, ticket = %d", Long.valueOf(er));
            gVar = gVar2;
        } else {
            gVar = null;
            er = -1;
        }
        while (i < arrayList.size()) {
            a((o) arrayList.get(i));
            i++;
        }
        if (gVar != null) {
            gVar.es(er);
            v.i("MicroMsg.GoogleContact.GoogleFriendUI", "end updateList transaction");
        }
        this.cHU.b(2, this.cHU, SQLiteDatabase.KeyEmpty);
        return true;
    }

    public final Cursor iJ(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(" WHERE ( ");
            stringBuilder.append("GoogleFriend.googleid='" + str + "'");
            stringBuilder.append(" ) ");
        }
        return this.cie.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  " + stringBuilder, null);
    }

    public final boolean b(o oVar) {
        Cursor rawQuery = this.cie.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend   WHERE GoogleFriend.googleitemid = \"" + be.lZ(oVar.field_googleitemid) + "\"", null);
        boolean z = rawQuery.getCount() > 0;
        rawQuery.close();
        if (!z) {
            return a(oVar);
        }
        int update = this.cie.update("GoogleFriend", oVar.py(), new StringBuilder("googleitemid=?").toString(), new String[]{oVar.field_googleitemid});
        if (update > 0) {
            Ls();
        }
        if (update <= 0) {
            return false;
        }
        return true;
    }

    public final boolean t(String str, int i) {
        return this.cie.dF("GoogleFriend", "UPDATE GoogleFriend SET googlecgistatus='" + i + "' WHERE googleitemid=" + "'" + str + "'");
    }

    public final boolean u(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.cie.dF("GoogleFriend", "UPDATE GoogleFriend SET googlecgistatus='" + i + "' , status=" + "'0' WHERE " + "username='" + str + "'");
    }

    public final void clear() {
        this.cie.dF("GoogleFriend", " delete from GoogleFriend");
        this.cHU.b(5, this.cHU, SQLiteDatabase.KeyEmpty);
    }
}
