package com.tencent.tinker.lib.b;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.tinker.lib.service.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.IOException;

public final class f extends a {
    public final boolean a(Context context, String str, a aVar) {
        com.tencent.tinker.lib.d.a gh = com.tencent.tinker.lib.d.a.gh(context);
        File file = new File(str);
        if (!ShareTinkerInternals.zC(gh.tinkerFlags) || !ShareTinkerInternals.gu(context)) {
            com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch is disabled, just return", new Object[0]);
            return false;
        } else if (file.isFile() && file.exists()) {
            ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(context);
            int a = ShareTinkerInternals.a(context, gh.tinkerFlags, file, shareSecurityCheck);
            if (a != 0) {
                com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchPackageCheckFail", new Object[0]);
                gh.pFM.d(file, a);
                return false;
            }
            SharePatchInfo sharePatchInfo = gh.pFR.patchInfo;
            String Q = SharePatchFileUtil.Q(file);
            if (Q == null) {
                com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch md5 is null, just return", new Object[0]);
                return false;
            }
            aVar.pFE = Q;
            if (sharePatchInfo == null) {
                sharePatchInfo = new SharePatchInfo("", Q, Build.FINGERPRINT);
            } else if (sharePatchInfo.pGR == null || sharePatchInfo.pGS == null) {
                com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchInfoCorrupted", new Object[0]);
                gh.pFM.a(file, sharePatchInfo.pGR, sharePatchInfo.pGS);
                return false;
            } else if (sharePatchInfo.pGR.equals(Q) || sharePatchInfo.pGS.equals(Q)) {
                com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchVersionCheckFail", new Object[0]);
                gh.pFM.a(file, sharePatchInfo, Q);
                return false;
            } else {
                sharePatchInfo = new SharePatchInfo(sharePatchInfo.pGR, Q, Build.FINGERPRINT);
            }
            String absolutePath = gh.pFJ.getAbsolutePath();
            com.tencent.tinker.lib.e.a.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchMd5:%s", new Object[]{Q});
            String str2 = absolutePath + "/" + SharePatchFileUtil.Qz(Q);
            com.tencent.tinker.lib.e.a.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchVersionDirectory:%s", new Object[]{str2});
            File file2 = new File(str2 + "/" + SharePatchFileUtil.QA(Q));
            try {
                String str3;
                boolean z;
                long elapsedRealtime;
                SharePatchFileUtil.h(file, file2);
                com.tencent.tinker.lib.e.a.w("Tinker.UpgradePatch", "UpgradePatch after %s size:%d, %s size:%d", new Object[]{file.getAbsolutePath(), Long.valueOf(file.length()), file2.getAbsolutePath(), Long.valueOf(file2.length())});
                if (ShareTinkerInternals.zy(gh.tinkerFlags)) {
                    str3 = (String) shareSecurityCheck.pHd.get("assets/dex_meta.txt");
                    if (str3 == null) {
                        com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not contained", new Object[0]);
                        z = true;
                    } else {
                        elapsedRealtime = SystemClock.elapsedRealtime();
                        z = d.b(context, str2, str3, file2);
                        elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                        com.tencent.tinker.lib.e.a.i("Tinker.DexDiffPatchInternal", "recover dex result:%b, cost:%d", new Object[]{Boolean.valueOf(z), Long.valueOf(elapsedRealtime)});
                    }
                } else {
                    com.tencent.tinker.lib.e.a.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not enabled", new Object[0]);
                    z = true;
                }
                if (z) {
                    if (ShareTinkerInternals.zz(gh.tinkerFlags)) {
                        str3 = (String) shareSecurityCheck.pHd.get("assets/so_meta.txt");
                        if (str3 == null) {
                            com.tencent.tinker.lib.e.a.w("Tinker.BsDiffPatchInternal", "patch recover, library is not contained", new Object[0]);
                            z = true;
                        } else {
                            elapsedRealtime = SystemClock.elapsedRealtime();
                            z = c.a(context, str2 + "/lib/", str3, file2);
                            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                            com.tencent.tinker.lib.e.a.i("Tinker.BsDiffPatchInternal", "recover lib result:%b, cost:%d", new Object[]{Boolean.valueOf(z), Long.valueOf(elapsedRealtime)});
                        }
                    } else {
                        com.tencent.tinker.lib.e.a.w("Tinker.BsDiffPatchInternal", "patch recover, library is not enabled", new Object[0]);
                        z = true;
                    }
                    if (z) {
                        if (ShareTinkerInternals.zA(gh.tinkerFlags)) {
                            str3 = (String) shareSecurityCheck.pHd.get("assets/res_meta.txt");
                            if (str3 == null || str3.length() == 0) {
                                com.tencent.tinker.lib.e.a.w("Tinker.ResDiffPatchInternal", "patch recover, resource is not contained", new Object[0]);
                                z = true;
                            } else {
                                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                if (e.d(context, str2 + "/res/", str3, file2)) {
                                    z = true;
                                } else {
                                    com.tencent.tinker.lib.e.a.w("Tinker.ResDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
                                    z = false;
                                }
                                elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                                com.tencent.tinker.lib.e.a.i("Tinker.ResDiffPatchInternal", "recover resource result:%b, cost:%d", new Object[]{Boolean.valueOf(z), Long.valueOf(elapsedRealtime2)});
                            }
                        } else {
                            com.tencent.tinker.lib.e.a.w("Tinker.ResDiffPatchInternal", "patch recover, resource is not enabled", new Object[0]);
                            z = true;
                        }
                        if (!z) {
                            com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch resource failed", new Object[0]);
                            return false;
                        } else if (SharePatchInfo.a(gh.pFN, sharePatchInfo, SharePatchFileUtil.Qy(absolutePath))) {
                            com.tencent.tinker.lib.e.a.w("Tinker.UpgradePatch", "UpgradePatch tryPatch: done, it is ok", new Object[0]);
                            return true;
                        } else {
                            com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, rewrite patch info failed", new Object[0]);
                            gh.pFM.a(file, sharePatchInfo.pGR, sharePatchInfo.pGS);
                            return false;
                        }
                    }
                    com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch library failed", new Object[0]);
                    return false;
                }
                com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch dex failed", new Object[0]);
                return false;
            } catch (IOException e) {
                com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:copy patch file fail from %s to %s", new Object[]{file.getPath(), file2.getPath()});
                gh.pFM.a(file, file2, file.getName(), 1);
                return false;
            }
        } else {
            com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch file is not found, just return", new Object[0]);
            return false;
        }
    }
}
