package com.tencent.mm.plugin.ext.provider;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ext.a.a;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.bc;
import com.tencent.mmdb.database.SQLiteDatabase;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderEntry extends ExtContentProviderBase {
    private static final UriMatcher fHn;
    private String[] fGX;
    private int fGY;
    private boolean fHo;
    private Context fHp;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        fHn = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.entry", "view_profile", 2);
        fHn.addURI("com.tencent.mm.plugin.ext.entry", "to_chatting", 3);
        fHn.addURI("com.tencent.mm.plugin.ext.entry", "to_nearby", 4);
        fHn.addURI("com.tencent.mm.plugin.ext.entry", "sns_comment_detail", 5);
        fHn.addURI("com.tencent.mm.plugin.ext.entry", "share_time_line", 6);
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public ExtControlProviderEntry() {
        this.fHo = false;
        this.fGX = null;
        this.fGY = -1;
    }

    public ExtControlProviderEntry(String[] strArr, int i, Context context) {
        this.fHo = false;
        this.fGX = null;
        this.fGY = -1;
        this.fHo = true;
        this.fGX = strArr;
        this.fGY = i;
        this.fHp = context;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        v.i("MicroMsg.ExtControlEntryProvider", "ExtControlProviderEntry query() mIsLocalUsed :" + this.fHo);
        if (this.fHo) {
            a(uri, this.fHp, this.fGY, this.fGX);
            if (be.kS(this.fHh)) {
                v.e("MicroMsg.ExtControlEntryProvider", "AppID == null");
                bB(3, 7);
                return ExtContentProviderBase.kC(7);
            } else if (be.kS(akY())) {
                v.e("MicroMsg.ExtControlEntryProvider", "PkgName == null");
                bB(3, 6);
                return ExtContentProviderBase.kC(6);
            } else {
                int akZ = akZ();
                if (akZ != 1) {
                    v.e("MicroMsg.ExtControlEntryProvider", "invalid appid ! return code = " + akZ);
                    bB(2, akZ);
                    return ExtContentProviderBase.kC(akZ);
                }
            }
        }
        this.fHp = getContext();
        a(uri, this.fHp, fHn);
        if (uri == null) {
            kB(3);
            return null;
        } else if (be.kS(this.fHh) || be.kS(akY())) {
            kB(3);
            return ExtContentProviderBase.kC(3);
        } else if (!WN()) {
            kB(1);
            return this.enz;
        } else if (!bG(this.fHp)) {
            v.w("MicroMsg.ExtControlEntryProvider", "invalid appid ! return null");
            kB(2);
            return null;
        }
        String ma = be.ma(uri.getQueryParameter("source"));
        if (!this.fHo) {
            this.fGY = fHn.match(uri);
        }
        switch (this.fGY) {
            case 2:
                return j(strArr2);
            case 3:
                return a(strArr2, ma);
            case 4:
                if (this.fHp == null) {
                    kB(4);
                    return null;
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI"));
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.fHp.startActivity(intent);
                kB(0);
                return ExtContentProviderBase.kC(1);
            case 5:
                return k(strArr2);
            case 6:
                if (strArr2 == null || strArr2.length <= 0) {
                    v.w("MicroMsg.ExtControlEntryProvider", "wrong args");
                    kB(3);
                    return null;
                } else if (this.fHp == null) {
                    kB(4);
                    return null;
                } else {
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
                    intent2.setAction("android.intent.action.SEND");
                    intent2.addCategory("android.intent.category.DEFAULT");
                    intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent2.putExtra("android.intent.extra.TEXT", strArr2[1] == null ? SQLiteDatabase.KeyEmpty : strArr2[1]);
                    if (strArr2[0] != null && strArr2[0].trim().length() > 0) {
                        intent2.putExtra("android.intent.extra.STREAM", Uri.parse(strArr2[0]));
                    }
                    intent2.putExtra("Ksnsupload_empty_img", true);
                    intent2.setType("image/*");
                    this.fHp.startActivity(intent2);
                    kB(0);
                    return ExtContentProviderBase.kC(1);
                }
            default:
                bB(3, 15);
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

    private Cursor j(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            v.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            kB(3);
            return null;
        }
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            v.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
            kB(3);
            return null;
        }
        try {
            ak.yW();
            ab eg = c.wH().eg(a.sH(str));
            if (eg == null || ((int) eg.chr) <= 0 || this.fHp == null) {
                kB(3);
                return null;
            }
            Intent intent = new Intent();
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("Contact_User", eg.field_username);
            com.tencent.mm.ay.c.b(this.fHp, "profile", ".ui.ContactInfoUI", intent);
            kB(0);
            return ExtContentProviderBase.kC(1);
        } catch (Throwable e) {
            v.w("MicroMsg.ExtControlEntryProvider", e.getMessage());
            v.a("MicroMsg.ExtControlEntryProvider", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            kB(3);
            return null;
        }
    }

    private Cursor a(String[] strArr, String str) {
        v.i("MicroMsg.ExtControlEntryProvider", "toChattingUI");
        if (strArr == null || strArr.length <= 0) {
            v.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            bB(3, 3601);
            return ExtContentProviderBase.kC(3601);
        } else if (be.kS(str)) {
            v.w("MicroMsg.ExtControlEntryProvider", "callSource == null");
            bB(3, 3602);
            return ExtContentProviderBase.kC(3602);
        } else {
            String str2 = strArr[0];
            if (str2 == null || str2.length() <= 0) {
                v.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
                bB(3, 3603);
                return ExtContentProviderBase.kC(3603);
            }
            ab LX;
            boolean z = str != null && str.equalsIgnoreCase("openapi");
            if (z) {
                try {
                    bc Ny = b.akN().Ny(str2);
                    if (Ny == null || be.kS(Ny.field_openId) || be.kS(Ny.field_username)) {
                        v.e("MicroMsg.ExtControlEntryProvider", "openidInApp is null");
                        bB(3, 3604);
                        return ExtContentProviderBase.kC(3604);
                    }
                    ak.yW();
                    LX = c.wH().LX(Ny.field_username);
                } catch (Throwable e) {
                    v.w("MicroMsg.ExtControlEntryProvider", e.getMessage());
                    v.a("MicroMsg.ExtControlEntryProvider", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    z(5, 4, 12);
                    return ExtContentProviderBase.kC(12);
                }
            }
            ak.yW();
            LX = c.wH().eg(a.sH(str2));
            if (LX == null || ((int) LX.chr) <= 0 || this.fHp == null) {
                v.e("MicroMsg.ExtControlEntryProvider", "wrong args ct");
                bB(3, 3605);
                return ExtContentProviderBase.kC(3605);
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.chatting.ChattingUI"));
            intent.putExtra("Chat_User", LX.field_username);
            intent.putExtra("finish_direct", true);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.addFlags(67108864);
            this.fHp.startActivity(intent);
            z(4, 0, 1);
            return ExtContentProviderBase.kC(1);
        }
    }

    private Cursor k(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            v.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            kB(3);
            return null;
        }
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            v.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            kB(3);
            return null;
        }
        try {
            long sH = a.sH(str);
            if (sH <= 0) {
                kB(3);
                return null;
            } else if (this.fHp == null) {
                kB(4);
                return null;
            } else {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI"));
                intent.putExtra("INTENT_SNS_LOCAL_ID", (int) sH);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.fHp.startActivity(intent);
                kB(0);
                return ExtContentProviderBase.kC(1);
            }
        } catch (Throwable e) {
            v.w("MicroMsg.ExtControlEntryProvider", e.getMessage());
            v.a("MicroMsg.ExtControlEntryProvider", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            kB(3);
            return null;
        }
    }
}
