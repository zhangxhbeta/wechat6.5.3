package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.e.a.ej;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderAccountSync extends ExtContentProviderBase {
    private static final UriMatcher fHn;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        fHn = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.AccountSync", "accountSync", 1);
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        v.d("MicroMsg.ExtControlAccountSyncProvider", "query()");
        a(uri, getContext(), fHn);
        if (uri == null) {
            kB(3);
            return null;
        } else if (be.kS(this.fHh) || be.kS(akY())) {
            kB(3);
            return null;
        } else if (!WN()) {
            kB(1);
            return this.enz;
        } else if (bG(getContext())) {
            switch (fHn.match(uri)) {
                case 1:
                    v.i("MicroMsg.ExtControlAccountSyncProvider", "startContactSync()");
                    if (a.nhr.z(new ej())) {
                        kB(0);
                        return null;
                    }
                    v.e("MicroMsg.ExtControlAccountSyncProvider", "AccountHelper == null");
                    kB(4);
                    return null;
                default:
                    kB(3);
                    return null;
            }
        } else {
            v.w("MicroMsg.ExtControlAccountSyncProvider", "invalid appid ! return null");
            kB(2);
            return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
