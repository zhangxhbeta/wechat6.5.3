package com.tencent.tinker.loader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class TinkerLoader extends AbstractTinkerLoader {
    private static final String TAG = "Tinker.TinkerLoader";
    private SharePatchInfo patchInfo;

    public Intent tryLoad(TinkerApplication tinkerApplication, int i, boolean z) {
        Intent intent = new Intent();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        tryLoadPatchFilesInternal(tinkerApplication, i, z, intent);
        ShareIntentUtil.a(intent, SystemClock.elapsedRealtime() - elapsedRealtime);
        return intent;
    }

    private void tryLoadPatchFilesInternal(TinkerApplication tinkerApplication, int i, boolean z, Intent intent) {
        if (ShareTinkerInternals.zC(i)) {
            File go = SharePatchFileUtil.go(tinkerApplication);
            if (go == null) {
                ShareIntentUtil.a(intent, -2);
                return;
            }
            String absolutePath = go.getAbsolutePath();
            if (go.exists()) {
                File Qx = SharePatchFileUtil.Qx(absolutePath);
                if (Qx.exists()) {
                    File Qy = SharePatchFileUtil.Qy(absolutePath);
                    this.patchInfo = SharePatchInfo.j(Qx, Qy);
                    if (this.patchInfo == null) {
                        ShareIntentUtil.a(intent, -4);
                        return;
                    }
                    String str = this.patchInfo.pGR;
                    String str2 = this.patchInfo.pGS;
                    if (str == null || str2 == null) {
                        ShareIntentUtil.a(intent, -4);
                        return;
                    }
                    intent.putExtra("intent_patch_old_version", str);
                    intent.putExtra("intent_patch_new_version", str2);
                    boolean gv = ShareTinkerInternals.gv(tinkerApplication);
                    int i2 = !str.equals(str2) ? 1 : 0;
                    if (i2 == 0 || !gv) {
                        str2 = str;
                    }
                    if (ShareTinkerInternals.kS(str2)) {
                        ShareIntentUtil.a(intent, -5);
                        return;
                    }
                    str = SharePatchFileUtil.Qz(str2);
                    if (str == null) {
                        ShareIntentUtil.a(intent, -6);
                        return;
                    }
                    absolutePath = absolutePath + "/" + str;
                    File file = new File(absolutePath);
                    if (file.exists()) {
                        File file2 = new File(file.getAbsolutePath(), SharePatchFileUtil.QA(str2));
                        if (file2.exists()) {
                            ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(tinkerApplication);
                            int a = ShareTinkerInternals.a(tinkerApplication, i, file2, shareSecurityCheck);
                            if (a != 0) {
                                intent.putExtra("intent_patch_package_patch_check", a);
                                ShareIntentUtil.a(intent, -8);
                                return;
                            }
                            intent.putExtra("intent_patch_package_config", shareSecurityCheck.bPa());
                            boolean zy = ShareTinkerInternals.zy(i);
                            if (zy && !TinkerDexLoader.a(absolutePath, shareSecurityCheck, intent)) {
                                return;
                            }
                            if (!ShareTinkerInternals.zz(i) || TinkerSoLoader.a(absolutePath, shareSecurityCheck, intent)) {
                                boolean zA = ShareTinkerInternals.zA(i);
                                if (!zA || TinkerResourceLoader.a((Context) tinkerApplication, absolutePath, shareSecurityCheck, intent)) {
                                    boolean z2 = ShareTinkerInternals.bPb() && ShareTinkerInternals.QE(this.patchInfo.pGT);
                                    if (z2 || (gv && i2 != 0)) {
                                        this.patchInfo.pGR = str2;
                                        if (!SharePatchInfo.a(Qx, this.patchInfo, Qy)) {
                                            ShareIntentUtil.a(intent, -18);
                                            return;
                                        }
                                    }
                                    if (!checkSafeModeCount(tinkerApplication)) {
                                        intent.putExtra("intent_patch_exception", new TinkerRuntimeException("checkSafeModeCount fail"));
                                        ShareIntentUtil.a(intent, -24);
                                        return;
                                    } else if (zy && !TinkerDexLoader.a(tinkerApplication, z, absolutePath, intent, z2)) {
                                        return;
                                    } else {
                                        if (!zA || TinkerResourceLoader.a((Context) tinkerApplication, z, absolutePath, intent)) {
                                            ShareIntentUtil.a(intent, 0);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        ShareIntentUtil.a(intent, -7);
                        return;
                    }
                    ShareIntentUtil.a(intent, -6);
                    return;
                }
                new StringBuilder("tryLoadPatchFiles:patch info not exist:").append(Qx.getAbsolutePath());
                ShareIntentUtil.a(intent, -3);
                return;
            }
            ShareIntentUtil.a(intent, -2);
            return;
        }
        ShareIntentUtil.a(intent, -1);
    }

    private boolean checkSafeModeCount(TinkerApplication tinkerApplication) {
        String str = "tinker_own_config_" + ShareTinkerInternals.gx(tinkerApplication);
        SharedPreferences sharedPreferences = tinkerApplication.getSharedPreferences(str, 0);
        int i = sharedPreferences.getInt("safe_mode_count", 0) + 1;
        new StringBuilder("tinker safe mode preferName:").append(str).append(" count:").append(i);
        if (i >= 3) {
            sharedPreferences.edit().putInt("safe_mode_count", 0).commit();
            return false;
        }
        tinkerApplication.setUseSafeMode(true);
        sharedPreferences.edit().putInt("safe_mode_count", i).commit();
        return true;
    }
}
