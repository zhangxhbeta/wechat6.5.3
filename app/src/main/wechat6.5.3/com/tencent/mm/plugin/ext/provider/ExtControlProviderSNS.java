package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bg.d;
import com.tencent.mm.e.a.ec;
import com.tencent.mm.e.a.ed;
import com.tencent.mm.e.a.el;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public final class ExtControlProviderSNS extends ExtContentProviderBase {
    private static boolean fHM = false;
    private static ah fHN = new ah(new a() {
        public final boolean oU() {
            ExtControlProviderSNS.fHM = false;
            return false;
        }
    }, false);
    private static final String[] fHP = new String[]{"feedId", "desc", SlookSmartClipMetaTag.TAG_TYPE_URL, "nickname", "avatar", "timestamp", "mediaCount", "type", "bigImgUrl", "firstImgWidth", "firstImgHeight"};
    private static final UriMatcher fHn;
    private boolean bcQ = false;
    private boolean bcR = false;
    private int bcS = 0;
    private String fHQ = SQLiteDatabase.KeyEmpty;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        fHn = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.SNS", "snsInfo", 17);
    }

    private static void cU(boolean z) {
        if (z) {
            fHM = true;
            fHN.ea(15000);
            return;
        }
        fHN.ea(0);
    }

    public final boolean onCreate() {
        return false;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        v.i("MicroMsg.ExtControlProviderSNS", "query() " + uri);
        a(uri, getContext(), fHn);
        if (uri == null) {
            kB(3);
            return null;
        } else if (be.kS(this.fHh) || be.kS(akY())) {
            kB(3);
            return null;
        } else if (fHM) {
            v.w("MicroMsg.ExtControlProviderSNS", "isBusy, return null");
            kB(5);
            return null;
        } else {
            cU(true);
            if (!WN()) {
                cU(false);
                kB(1);
                return this.enz;
            } else if (!bG(getContext())) {
                v.w("MicroMsg.ExtControlProviderSNS", "invalid appid ! return null");
                cU(false);
                kB(2);
                return null;
            } else if (strArr2 == null || strArr2.length == 0) {
                v.e("MicroMsg.ExtControlProviderSNS", "invaild selections");
                cU(false);
                kB(3);
                return null;
            } else {
                String str3 = strArr2[0];
                if (be.kS(str3)) {
                    v.e("MicroMsg.ExtControlProviderSNS", "userIdStr should not be null or nil");
                    cU(false);
                    kB(3);
                    return null;
                }
                try {
                    long j;
                    Cursor bw;
                    if ("0".equals(str3.trim())) {
                        j = 0;
                    } else {
                        j = Long.valueOf(com.tencent.mm.plugin.ext.a.a.sH(str3.trim())).longValue();
                    }
                    switch (fHn.match(uri)) {
                        case 17:
                            bw = bw(j);
                            break;
                        default:
                            bw = null;
                            break;
                    }
                    if (bw != null) {
                        kB(0);
                    } else {
                        kB(4);
                    }
                    cU(false);
                    return bw;
                } catch (Throwable e) {
                    v.e("MicroMsg.ExtControlProviderSNS", e.getMessage());
                    v.a("MicroMsg.ExtControlProviderSNS", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    cU(false);
                    kB(4);
                    return null;
                }
            }
        }
    }

    private Cursor bw(long j) {
        int i = 1;
        v.i("MicroMsg.ExtControlProviderSNS", "handleGetSnsInfo() userId = " + j);
        try {
            ab LV;
            v.i("MicroMsg.ExtControlProviderSNS", "startGetSNSInfo, userId=[%s]", Long.valueOf(j));
            if (j == 0) {
                ak.yW();
                LV = c.wH().LV(k.xF());
            } else {
                ak.yW();
                LV = c.wH().eg(j);
            }
            if (LV == null || ((int) LV.chr) <= 0) {
                v.e("MicroMsg.ExtControlProviderSNS", "ct == null");
                i = 0;
            } else {
                this.bcQ = com.tencent.mm.i.a.ei(LV.field_type);
                this.bcR = k.eo(LV.field_username);
                v.d("MicroMsg.ExtControlProviderSNS", "ct.getUsername()=[%s], isFriend=[%s], isSelf=[%s]", LV.field_username, Boolean.valueOf(this.bcQ), Boolean.valueOf(this.bcR));
                final com.tencent.mm.pluginsdk.e.a.a aVar = new com.tencent.mm.pluginsdk.e.a.a();
                aVar.b(10000, new Runnable(this) {
                    final /* synthetic */ ExtControlProviderSNS fHR;

                    public final void run() {
                        b elVar = new el();
                        elVar.bcP.type = 1;
                        elVar.bcP.username = LV.field_username;
                        elVar.bcP.bcQ = this.fHR.bcQ;
                        elVar.bcP.bcR = this.fHR.bcR;
                        elVar.bcP.bcS = this.fHR.bcS;
                        elVar.bcP.bcT = new ay.a(this) {
                            final /* synthetic */ AnonymousClass2 fHS;

                            {
                                this.fHS = r1;
                            }

                            public final void a(e eVar) {
                                aVar.countDown();
                            }
                        };
                        com.tencent.mm.sdk.c.a.nhr.z(elVar);
                    }
                });
            }
            if (i == 0) {
                v.w("MicroMsg.ExtControlProviderSNS", "startGetSNSInfo() return false");
                return null;
            }
        } catch (Throwable e) {
            v.e("MicroMsg.ExtControlProviderSNS", e.getMessage());
            v.a("MicroMsg.ExtControlProviderSNS", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return ald();
    }

    private Cursor ald() {
        v.i("MicroMsg.ExtControlProviderSNS", new StringBuilder("getSnsCursor() , needDownload = true").toString());
        d dVar = new d(fHP, (byte) 0);
        b ecVar = new ec();
        ecVar.bcf.bch = this.fHQ;
        if (com.tencent.mm.sdk.c.a.nhr.z(ecVar)) {
            Cursor cursor = ecVar.bcg.bbY;
            if (cursor != null) {
                try {
                    int count = cursor.getCount();
                    v.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), snsCount = " + count);
                    if (count <= 0 || !cursor.moveToFirst()) {
                        v.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + dVar.getCount());
                        cursor.close();
                    } else {
                        do {
                            if (cursor != null) {
                                b edVar = new ed();
                                edVar.bci.bck = cursor;
                                if (com.tencent.mm.sdk.c.a.nhr.z(edVar)) {
                                    ak.yW();
                                    com.tencent.mm.i.a LV = c.wH().LV(edVar.bcj.bcl);
                                    if (LV != null && ((int) LV.chr) > 0) {
                                        int i;
                                        Object obj;
                                        Object[] objArr;
                                        String str = SQLiteDatabase.KeyEmpty;
                                        String str2 = SQLiteDatabase.KeyEmpty;
                                        switch (edVar.bcj.bcp) {
                                            case 1:
                                            case 7:
                                            case 8:
                                                i = 2;
                                                break;
                                            case 2:
                                                i = 1;
                                                break;
                                            case 3:
                                                i = 6;
                                                break;
                                            case 4:
                                                i = 3;
                                                break;
                                            case 5:
                                                i = 4;
                                                break;
                                            default:
                                                i = 5;
                                                break;
                                        }
                                        if (!(edVar.bcj.bcr == null || edVar.bcj.bcr.size() <= 0 || getContext() == null)) {
                                            v.d("MicroMsg.ExtControlProviderSNS", "uris.size() = [%s]", Integer.valueOf(edVar.bcj.bcr.size()));
                                            if (i == 2 || i == 6 || i == 3 || i == 4) {
                                                obj = (String) edVar.bcj.bcr.get(0);
                                                if (!(edVar.bcj.bcs == null || edVar.bcj.bcs.size() <= 0 || getContext() == null)) {
                                                    v.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", Integer.valueOf(edVar.bcj.bcs.size()), Integer.valueOf(edVar.bcj.bct), Integer.valueOf(edVar.bcj.bcu));
                                                    if (i == 2 || i == 6 || i == 3 || i == 4) {
                                                        str2 = (String) edVar.bcj.bcs.get(0);
                                                    }
                                                }
                                                str = com.tencent.mm.u.b.r(edVar.bcj.bcl, false);
                                                objArr = new Object[11];
                                                objArr[0] = com.tencent.mm.plugin.ext.a.a.bv((long) edVar.bcj.bcm);
                                                objArr[1] = edVar.bcj.bcn;
                                                objArr[2] = obj;
                                                objArr[3] = LV.tU();
                                                if (str == null) {
                                                    str = SQLiteDatabase.KeyEmpty;
                                                }
                                                objArr[4] = str;
                                                objArr[5] = Long.valueOf(edVar.bcj.bco);
                                                objArr[6] = Integer.valueOf(edVar.bcj.bcq);
                                                objArr[7] = Integer.valueOf(i);
                                                objArr[8] = str2;
                                                objArr[9] = Integer.valueOf(edVar.bcj.bct);
                                                objArr[10] = Integer.valueOf(edVar.bcj.bcu);
                                                dVar.addRow(objArr);
                                            }
                                        }
                                        String str3 = str;
                                        v.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", Integer.valueOf(edVar.bcj.bcs.size()), Integer.valueOf(edVar.bcj.bct), Integer.valueOf(edVar.bcj.bcu));
                                        str2 = (String) edVar.bcj.bcs.get(0);
                                        str = com.tencent.mm.u.b.r(edVar.bcj.bcl, false);
                                        try {
                                            objArr = new Object[11];
                                            objArr[0] = com.tencent.mm.plugin.ext.a.a.bv((long) edVar.bcj.bcm);
                                            objArr[1] = edVar.bcj.bcn;
                                            objArr[2] = obj;
                                            objArr[3] = LV.tU();
                                            if (str == null) {
                                                str = SQLiteDatabase.KeyEmpty;
                                            }
                                            objArr[4] = str;
                                            objArr[5] = Long.valueOf(edVar.bcj.bco);
                                            objArr[6] = Integer.valueOf(edVar.bcj.bcq);
                                            objArr[7] = Integer.valueOf(i);
                                            objArr[8] = str2;
                                            objArr[9] = Integer.valueOf(edVar.bcj.bct);
                                            objArr[10] = Integer.valueOf(edVar.bcj.bcu);
                                            dVar.addRow(objArr);
                                        } catch (Throwable e) {
                                            v.e("MicroMsg.ExtControlProviderSNS", e.getMessage());
                                            v.a("MicroMsg.ExtControlProviderSNS", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                        }
                                    }
                                } else {
                                    v.w("MicroMsg.ExtControlProviderSNS", "ExtGetSnsDataEvent publish error");
                                }
                            }
                        } while (cursor.moveToNext());
                        v.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + dVar.getCount());
                        cursor.close();
                    }
                } catch (Throwable e2) {
                    v.e("MicroMsg.ExtControlProviderSNS", e2.getMessage());
                    v.a("MicroMsg.ExtControlProviderSNS", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (cursor != null) {
                        cursor.close();
                    }
                    dVar.close();
                    return null;
                }
            }
            return dVar;
        }
        dVar.close();
        return null;
    }

    public final String getType(Uri uri) {
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
