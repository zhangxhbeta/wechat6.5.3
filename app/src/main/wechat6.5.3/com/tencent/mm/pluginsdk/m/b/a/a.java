package com.tencent.mm.pluginsdk.m.b.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.as.k;
import com.tencent.mm.as.o;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

public final class a {
    public static boolean c(String str, Context context, boolean z) {
        k.KV();
        return d(o.lc(str), context, z);
    }

    public static boolean d(String str, Context context, boolean z) {
        if (be.kS(str) || context == null) {
            return false;
        }
        Intent addFlags = new Intent("android.intent.action.VIEW").addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        addFlags.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
        addFlags.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, 3);
        Uri fromFile = Uri.fromFile(new File(str));
        if (z) {
            addFlags.setDataAndType(fromFile, "video/quicktime");
        } else {
            addFlags.setDataAndType(fromFile, "video/*");
        }
        if (!be.m(context, addFlags)) {
            return false;
        }
        context.startActivity(addFlags);
        return true;
    }
}
