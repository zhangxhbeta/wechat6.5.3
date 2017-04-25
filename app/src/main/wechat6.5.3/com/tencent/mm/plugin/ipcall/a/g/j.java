package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.mm.bg.f.a;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.v;

public final class j extends f<i> implements a {
    public static final String[] cic = new String[]{f.a(i.chq, "IPCallPopularCountry")};
    public com.tencent.mm.sdk.h.j cHU = new com.tencent.mm.sdk.h.j(this) {
        final /* synthetic */ j gIJ;

        {
            this.gIJ = r1;
        }

        protected final boolean EP() {
            if (this.gIJ.cie != null && !this.gIJ.cie.buA()) {
                return true;
            }
            String str = "MicroMsg.IPCallPopularCountryStorage";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = this.gIJ.cie == null ? "null" : Boolean.valueOf(this.gIJ.cie.buA());
            v.w(str, str2, objArr);
            return false;
        }
    };
    public d cie;

    public j(d dVar) {
        super(dVar, i.chq, "IPCallPopularCountry", null);
        this.cie = dVar;
    }

    public final String getTableName() {
        return "IPCallPopularCountry";
    }

    public final int a(com.tencent.mm.bg.f fVar) {
        if (fVar != null) {
            this.cie = fVar;
        }
        return 0;
    }

    public final void t(int i, long j) {
        boolean b;
        i iVar = new i();
        Cursor query = this.cie.query("IPCallPopularCountry", null, "countryCode=?", new String[]{Integer.toString(i)}, null, null, null);
        if (query.getCount() <= 0) {
            v.i("MicroMsg.IPCallPopularCountryStorage", "get null with countryCode:" + i);
            query.close();
            iVar.field_countryCode = i;
            iVar.field_lastCallTime = j;
            iVar.field_callTimeCount = 1;
            b = b(iVar);
        } else {
            if (query.moveToFirst()) {
                iVar.b(query);
                iVar.field_callTimeCount++;
                iVar.field_lastCallTime = j;
                b = super.a(iVar);
            } else {
                b = false;
            }
            query.close();
        }
        v.i("MicroMsg.IPCallPopularCountryStorage", "updatePopularCountryCode ret:" + b);
    }
}
