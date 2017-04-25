package com.tencent.mm.plugin.base.stub;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.v;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class MMPluginProvider extends ContentProvider {
    private static final UriMatcher enn;
    private c enm = new c();

    protected static abstract class a {
        private Context context = null;

        protected a() {
        }

        public boolean bx(Context context) {
            this.context = context;
            return true;
        }
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        enn = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.sdk.plugin.provider", "sharedpref", 2);
    }

    public String getType(Uri uri) {
        switch (enn.match(uri)) {
        }
        return null;
    }

    public boolean onCreate() {
        this.enm.bx(getContext());
        return true;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        v.v("MicroMsg.MMPluginProvider", "plugin insert" + uri);
        switch (enn.match(uri)) {
            case 2:
                return c.WH();
            default:
                v.e("MicroMsg.MMPluginProvider", "Unknown URI " + uri);
                return null;
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        v.v("MicroMsg.MMPluginProvider", "plugin delete" + uri);
        switch (enn.match(uri)) {
            case 2:
                return c.WI();
            default:
                v.e("MicroMsg.MMPluginProvider", "Unknown URI " + uri);
                return 0;
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        v.i("MicroMsg.MMPluginProvider", "plugin query" + uri);
        switch (enn.match(uri)) {
            case 2:
                return c.a(strArr, strArr2);
            default:
                v.e("MicroMsg.MMPluginProvider", "Unknown URI " + uri);
                return null;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        v.d("MicroMsg.MMPluginProvider", "plugin update" + uri);
        switch (enn.match(uri)) {
            case 2:
                return c.WJ();
            default:
                v.e("MicroMsg.MMPluginProvider", "Unknown URI " + uri);
                return 0;
        }
    }
}
