package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tencent.mm.pluginsdk.model.t.a;

public abstract class s {
    public abstract boolean Gn(String str);

    public abstract String MV();

    public abstract String bmO();

    public abstract a bmP();

    public abstract boolean dc(Context context);

    public boolean t(Context context, Intent intent) {
        return false;
    }

    public String a(Context context, ResolveInfo resolveInfo) {
        return resolveInfo.activityInfo.loadLabel(context.getPackageManager()).toString();
    }
}
