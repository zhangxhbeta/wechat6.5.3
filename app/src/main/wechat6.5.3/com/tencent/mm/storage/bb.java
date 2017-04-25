package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.h.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import junit.framework.Assert;

public final class bb extends f<ba> {
    public static final String[] cic = new String[]{f.a(ba.chq, "Stranger")};
    private d cie;
    private final h<a, ba> nwi = new h<a, ba>(this) {
        final /* synthetic */ bb nwF;

        {
            this.nwF = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((a) obj).a((ba) obj2);
        }
    };

    public interface a {
        void a(ba baVar);
    }

    public final /* synthetic */ boolean a(c cVar) {
        return c((ba) cVar);
    }

    private void b(ba baVar) {
        if (this.nwi.bg(baVar)) {
            this.nwi.Ls();
        }
    }

    public final void a(a aVar) {
        this.nwi.a(aVar, null);
    }

    public final void b(a aVar) {
        this.nwi.remove(aVar);
    }

    public bb(d dVar) {
        super(dVar, ba.chq, "Stranger", null);
        this.cie = dVar;
    }

    public final ba Nw(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        ba baVar = new ba();
        Cursor query = this.cie.query("Stranger", null, "encryptUsername = ?", new String[]{str}, null, null, null);
        if (query.getCount() != 0) {
            query.moveToFirst();
            baVar.b(query);
        }
        query.close();
        return baVar;
    }

    public final int Nx(String str) {
        int delete = this.cie.delete("Stranger", "(encryptUsername=?)", new String[]{str});
        if (delete > 0) {
            Ls();
        }
        v.i("MicroMsg.StrangerStorage", "delByEncryptUsername:" + str + " result:" + delete);
        return delete;
    }

    public final boolean c(ba baVar) {
        Assert.assertTrue("stranger NULL !", baVar != null);
        v.d("MicroMsg.StrangerStorage", "replace : encryptUsername=%s, conRemark=%s", baVar.field_encryptUsername, baVar.field_conRemark);
        if (this.cie.replace("Stranger", SQLiteDatabase.KeyEmpty, baVar.py()) > 0) {
            int i = 1;
        } else {
            boolean z = false;
        }
        if (i == 0) {
            return false;
        }
        b(baVar);
        return true;
    }
}
