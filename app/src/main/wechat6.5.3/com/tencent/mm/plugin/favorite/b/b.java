package com.tencent.mm.plugin.favorite.b;

import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.LinkedList;
import java.util.List;

public final class b extends f<a> {
    public static final String[] cic = new String[]{f.a(a.chq, "FavCdnInfo")};
    private List<a> cJC = new LinkedList();
    public d cie;

    public interface a {
        void b(a aVar);
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a((a) cVar);
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        return b((a) cVar, strArr);
    }

    public final void a(a aVar) {
        this.cJC.add(aVar);
    }

    public final void b(a aVar) {
        this.cJC.remove(aVar);
    }

    public b(d dVar) {
        super(dVar, a.chq, "FavCdnInfo", null);
        this.cie = dVar;
    }

    public final boolean a(a aVar) {
        int i = 0;
        if (aVar == null || !super.b(aVar)) {
            return false;
        }
        a[] aVarArr = new a[this.cJC.size()];
        this.cJC.toArray(aVarArr);
        int length = aVarArr.length;
        while (i < length) {
            a aVar2 = aVarArr[i];
            if (aVar2 != null) {
                aVar2.b(aVar);
            }
            i++;
        }
        return true;
    }

    public final boolean a(a aVar, String... strArr) {
        int i = 0;
        if (!super.a(aVar, strArr)) {
            return false;
        }
        a[] aVarArr = new a[this.cJC.size()];
        this.cJC.toArray(aVarArr);
        int length = aVarArr.length;
        while (i < length) {
            aVarArr[i].b(aVar);
            i++;
        }
        return true;
    }

    public final boolean b(a aVar, String... strArr) {
        int i = 0;
        if (!super.c(aVar, strArr)) {
            return false;
        }
        a[] aVarArr = new a[this.cJC.size()];
        this.cJC.toArray(aVarArr);
        int length = aVarArr.length;
        while (i < length) {
            aVarArr[i].b(aVar);
            i++;
        }
        return true;
    }

    public final a sL(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.FavCdnStorage", "md5 null");
            return null;
        }
        Cursor rawQuery = this.cie.rawQuery("select * from FavCdnInfo where dataId = '" + str + "'", null);
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            return null;
        }
        rawQuery.moveToFirst();
        a aVar = new a();
        aVar.b(rawQuery);
        rawQuery.close();
        return aVar;
    }

    public final void a(i iVar) {
        this.cie.dF("FavCdnInfo", "update FavCdnInfo set status = 1,modifyTime = " + be.Ni() + " where favLocalId = " + iVar.field_localId + " and type = 0" + " and status <> 3");
    }

    public final List<a> by(long j) {
        List<a> linkedList = new LinkedList();
        Cursor rawQuery = this.cie.rawQuery("select * from FavCdnInfo where favLocalId = " + j, null);
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            if (rawQuery != null) {
                rawQuery.close();
            }
            v.v("MicroMsg.FavCdnStorage", "getInfos size:%d", new Object[]{Integer.valueOf(linkedList.size())});
            return linkedList;
        }
        do {
            a aVar = new a();
            aVar.b(rawQuery);
            linkedList.add(aVar);
        } while (rawQuery.moveToNext());
        if (rawQuery != null) {
            rawQuery.close();
        }
        v.v("MicroMsg.FavCdnStorage", "getInfos size:%d", new Object[]{Integer.valueOf(linkedList.size())});
        return linkedList;
    }

    public final void bz(long j) {
        this.cie.dF("FavCdnInfo", String.format("delete from %s where %s = %d and %s = %d", new Object[]{"FavCdnInfo", "favLocalId", Long.valueOf(j), Columns.TYPE, Integer.valueOf(0)}));
    }

    public final int j(long j, int i) {
        Cursor rawQuery = this.cie.rawQuery("select status from FavCdnInfo where favLocalId = " + j + " and type = " + i, null);
        if (rawQuery == null) {
            return 3;
        }
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            return 3;
        }
        int i2 = 1;
        int i3 = 1;
        int i4 = 1;
        while (rawQuery.moveToNext()) {
            int i5 = rawQuery.getInt(0);
            if (i5 == 1) {
                rawQuery.close();
                return 1;
            }
            if (i5 != 4) {
                i4 = 0;
            }
            if (i5 != 2) {
                i3 = 0;
            }
            if (i5 != 3) {
                i2 = 0;
            }
        }
        rawQuery.close();
        if (i3 != 0) {
            return 2;
        }
        if (i4 != 0) {
            return 4;
        }
        if (i2 != 0) {
            return 3;
        }
        return 0;
    }

    public final boolean bA(long j) {
        a aVar = new a();
        aVar.field_favLocalId = j;
        return b(aVar, "favLocalId");
    }
}
