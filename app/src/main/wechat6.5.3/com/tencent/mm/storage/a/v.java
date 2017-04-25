package com.tencent.mm.storage.a;

import android.database.Cursor;
import com.tencent.mm.bg.f.a;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import java.util.ArrayList;

public final class v extends f<u> implements a {
    public static final String[] cic = new String[]{f.a(u.chq, "SmileyPanelConfigInfo")};
    private static final String[] nxq = new String[]{"position", "key"};
    public d cie;

    public v(d dVar) {
        this(dVar, u.chq, "SmileyPanelConfigInfo");
    }

    private v(d dVar, c.a aVar, String str) {
        super(dVar, aVar, str, null);
        this.cie = dVar;
    }

    public final int a(com.tencent.mm.bg.f fVar) {
        if (fVar != null) {
            this.cie = fVar;
        }
        return 0;
    }

    public final ArrayList<u> afd() {
        Throwable e;
        ArrayList<u> arrayList = new ArrayList();
        Cursor query;
        try {
            query = this.cie.query("SmileyPanelConfigInfo", nxq, null, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        do {
                            u uVar = new u();
                            uVar.b(query);
                            arrayList.add(uVar);
                        } while (query.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.emoji.SmileyPanelConfigInfoStorage", be.e(e));
                        if (query != null) {
                            query.close();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.emoji.SmileyPanelConfigInfoStorage", be.e(e));
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
        return arrayList;
    }
}
