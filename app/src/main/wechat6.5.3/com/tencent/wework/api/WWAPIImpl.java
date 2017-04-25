package com.tencent.wework.api;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import com.tencent.mmdb.FileUtils;
import com.tencent.wework.api.model.BaseMessage;

public final class WWAPIImpl implements IWWAPI {
    private Context context;

    public WWAPIImpl(Context context) {
        this.context = context;
    }

    public final boolean bPT() {
        return bPU() >= 100;
    }

    private int bPU() {
        int i = 0;
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.wework", FileUtils.S_IWUSR);
            if (packageInfo != null) {
                i = packageInfo.versionCode;
            }
        } catch (Throwable th) {
        }
        return i;
    }

    public final boolean a(BaseMessage baseMessage) {
        Intent intent = new Intent("com.tencent.wework.apihost");
        intent.setClassName("com.tencent.wework", "com.tencent.wework.apihost.WWAPIActivity");
        intent.addFlags(402653184);
        try {
            baseMessage.setContext(this.context);
            intent.putExtras(BaseMessage.b(baseMessage));
            this.context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
