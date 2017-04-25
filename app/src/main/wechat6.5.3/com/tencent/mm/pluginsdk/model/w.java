package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.mm.h.j;
import com.tencent.mm.pluginsdk.model.t.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class w extends s {
    public final boolean dc(Context context) {
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("sosomap://type=nav")), 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            int size = queryIntentActivities.size();
            for (int i = 0; i < size; i++) {
                ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                if (resolveInfo != null && resolveInfo.activityInfo != null && "com.tencent.map".equals(resolveInfo.activityInfo.packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean Gn(String str) {
        if (str == null || !"com.tencent.map".equals(str)) {
            return false;
        }
        return true;
    }

    public final String MV() {
        return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
    }

    public final String bmO() {
        return "TencentMap.apk";
    }

    public final a bmP() {
        a aVar = new a();
        aVar.lzW = 2131235652;
        String value = j.sU().getValue("QQMapDownloadTips");
        if (!be.kS(value)) {
            aVar.lzX = value;
        }
        aVar.lzY = 2131235653;
        aVar.lzV = 2130838409;
        return aVar;
    }

    public final String a(Context context, ResolveInfo resolveInfo) {
        if (context == null || resolveInfo == null || resolveInfo.activityInfo == null) {
            return null;
        }
        CharSequence loadLabel = resolveInfo.activityInfo.loadLabel(context.getPackageManager());
        if (loadLabel == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("\\(.*推荐.*\\)", 2).matcher(loadLabel.toString());
        if (matcher.find()) {
            return matcher.replaceAll(SQLiteDatabase.KeyEmpty);
        }
        return loadLabel.toString();
    }
}
