package com.tencent.mm.storage.a;

import android.database.Cursor;
import com.tencent.mm.bg.f.a;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class t extends f<s> implements a {
    public static final String[] cic = new String[]{f.a(s.chq, "SmileyInfo")};
    private static final String[] nxo = new String[]{"key", "cnValue", "qqValue", "enValue", "twValue", "thValue", "eggIndex", "fileName"};
    private static final String[] nxp = new String[]{"key"};
    public d cie;

    public t(d dVar) {
        this(dVar, s.chq, "SmileyInfo");
    }

    private t(d dVar, c.a aVar, String str) {
        super(dVar, aVar, str, null);
        this.cie = dVar;
    }

    public final int a(com.tencent.mm.bg.f fVar) {
        if (fVar != null) {
            this.cie = fVar;
        }
        return 0;
    }

    public final ArrayList<String> afc() {
        Throwable e;
        ArrayList<String> arrayList = new ArrayList();
        Cursor query;
        try {
            query = this.cie.query("SmileyInfo", nxp, "flag=?", new String[]{"0"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        do {
                            arrayList.add(query.getString(0));
                        } while (query.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.e("MicroMsg.emoji.NewSmileyInfoStorage", be.e(e));
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
            v.e("MicroMsg.emoji.NewSmileyInfoStorage", be.e(e));
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

    public final ArrayList<s> afb() {
        Throwable e;
        ArrayList<s> arrayList = new ArrayList();
        Cursor query;
        try {
            query = this.cie.query("SmileyInfo", nxo, "flag=?", new String[]{"0"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        do {
                            s sVar = new s();
                            sVar.b(query);
                            sVar.field_position = -1;
                            arrayList.add(sVar);
                        } while (query.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.e("MicroMsg.emoji.NewSmileyInfoStorage", be.e(e));
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
            v.e("MicroMsg.emoji.NewSmileyInfoStorage", be.e(e));
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
