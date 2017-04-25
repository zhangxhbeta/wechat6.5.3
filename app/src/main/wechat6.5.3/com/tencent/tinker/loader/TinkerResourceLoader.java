package com.tencent.tinker.loader;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import java.io.File;
import java.io.Serializable;

public class TinkerResourceLoader {
    private static ShareResPatchInfo pGw = new ShareResPatchInfo();

    private TinkerResourceLoader() {
    }

    public static boolean a(Context context, boolean z, String str, Intent intent) {
        if (pGw == null || pGw.pGV == null) {
            return true;
        }
        String str2 = str + "/res/resources.apk";
        File file = new File(str2);
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (SharePatchFileUtil.e(file, pGw.pGV)) {
                new StringBuilder("verify resource file:").append(file.getPath()).append(" md5, use time: ").append(System.currentTimeMillis() - currentTimeMillis);
            } else {
                new StringBuilder("Failed to load resource file, path: ").append(file.getPath()).append(", expect md5: ").append(pGw.pGV);
                ShareIntentUtil.a(intent, -23);
                return false;
            }
        }
        try {
            TinkerResourcePatcher.bB(context, str2);
            new StringBuilder("monkeyPatchExistingResources resource file:").append(str2).append(", use time: ").append(System.currentTimeMillis() - currentTimeMillis);
            return true;
        } catch (Throwable th) {
        }
        intent.putExtra("intent_patch_exception", th);
        ShareIntentUtil.a(intent, -22);
        return false;
    }

    public static boolean a(Context context, String str, ShareSecurityCheck shareSecurityCheck, Intent intent) {
        String str2 = (String) shareSecurityCheck.pHd.get("assets/res_meta.txt");
        if (str2 == null) {
            return true;
        }
        ShareResPatchInfo.b(str2, pGw);
        if (pGw.pGV == null) {
            return true;
        }
        if (ShareResPatchInfo.a(pGw)) {
            str2 = str + "/res/";
            File file = new File(str2);
            if (!file.exists() || !file.isDirectory()) {
                ShareIntentUtil.a(intent, -20);
                return false;
            } else if (new File(str2 + "resources.apk").exists()) {
                try {
                    TinkerResourcePatcher.gm(context);
                    return true;
                } catch (Serializable th) {
                    intent.putExtra("intent_patch_exception", th);
                    ShareIntentUtil.a(intent, -22);
                    return false;
                }
            } else {
                ShareIntentUtil.a(intent, -21);
                return false;
            }
        }
        intent.putExtra("intent_patch_package_patch_check", -8);
        ShareIntentUtil.a(intent, -8);
        return false;
    }
}
