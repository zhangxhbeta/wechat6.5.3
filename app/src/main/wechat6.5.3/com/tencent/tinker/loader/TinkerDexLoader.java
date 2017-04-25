package com.tencent.tinker.loader;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Intent;
import com.tencent.tinker.loader.TinkerParallelDexOptimizer.ResultCallback;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class TinkerDexLoader {
    private static final ArrayList<ShareDexDiffPatchInfo> pGo = new ArrayList();
    private static boolean pGp;
    private static Throwable pGq;

    private TinkerDexLoader() {
    }

    @TargetApi(14)
    public static boolean a(Application application, boolean z, String str, Intent intent, boolean z2) {
        if (pGo.isEmpty()) {
            return true;
        }
        PathClassLoader pathClassLoader = (PathClassLoader) TinkerDexLoader.class.getClassLoader();
        if (pathClassLoader != null) {
            new StringBuilder("classloader: ").append(pathClassLoader.toString());
            String str2 = str + "/dex/";
            File file = new File(str + "/odex");
            Collection arrayList = new ArrayList();
            boolean bPb = ShareTinkerInternals.bPb();
            Iterator it = pGo.iterator();
            while (it.hasNext()) {
                ShareDexDiffPatchInfo shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it.next();
                if (!a(shareDexDiffPatchInfo)) {
                    File file2 = new File(str2 + shareDexDiffPatchInfo.cGS);
                    if (z) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (SharePatchFileUtil.d(file2, bPb ? shareDexDiffPatchInfo.pGK : shareDexDiffPatchInfo.pGJ)) {
                            new StringBuilder("verify dex file:").append(file2.getPath()).append(" md5, use time: ").append(System.currentTimeMillis() - currentTimeMillis);
                        } else {
                            ShareIntentUtil.a(intent, -13);
                            intent.putExtra("intent_patch_mismatch_dex_path", file2.getAbsolutePath());
                            return false;
                        }
                    }
                    arrayList.add(file2);
                }
            }
            if (z2) {
                pGp = true;
                pGq = null;
                TinkerParallelDexOptimizer.a(arrayList, file, new ResultCallback() {
                    long start;

                    public final void J(File file) {
                        this.start = System.currentTimeMillis();
                        new StringBuilder("start to optimize dex:").append(file.getPath());
                    }

                    public final void K(File file) {
                        new StringBuilder("success to optimize dex ").append(file.getPath()).append("use time ").append(System.currentTimeMillis() - this.start);
                    }

                    public final void b(File file, Throwable th) {
                        TinkerDexLoader.pGp = false;
                        TinkerDexLoader.pGq = th;
                        new StringBuilder("fail to optimize dex ").append(file.getPath()).append("use time ").append(System.currentTimeMillis() - this.start);
                    }
                });
                if (!pGp) {
                    intent.putExtra("intent_patch_exception", pGq);
                    ShareIntentUtil.a(intent, -15);
                    return false;
                }
            }
            try {
                SystemClassLoaderAdder.a(application, pathClassLoader, file, arrayList);
                return true;
            } catch (Serializable th) {
                intent.putExtra("intent_patch_exception", th);
                ShareIntentUtil.a(intent, -14);
                return false;
            }
        }
        ShareIntentUtil.a(intent, -12);
        return false;
    }

    public static boolean a(String str, ShareSecurityCheck shareSecurityCheck, Intent intent) {
        String str2 = (String) shareSecurityCheck.pHd.get("assets/dex_meta.txt");
        if (str2 == null) {
            return true;
        }
        pGo.clear();
        ShareDexDiffPatchInfo.j(str2, pGo);
        if (pGo.isEmpty()) {
            return true;
        }
        Serializable hashMap = new HashMap();
        Iterator it = pGo.iterator();
        while (it.hasNext()) {
            ShareDexDiffPatchInfo shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it.next();
            if (!a(shareDexDiffPatchInfo)) {
                if (ShareDexDiffPatchInfo.b(shareDexDiffPatchInfo)) {
                    hashMap.put(shareDexDiffPatchInfo.cGS, shareDexDiffPatchInfo.pGJ);
                } else {
                    intent.putExtra("intent_patch_package_patch_check", -3);
                    ShareIntentUtil.a(intent, -8);
                    return false;
                }
            }
        }
        String str3 = str + "/dex/";
        File file = new File(str3);
        if (file.exists() && file.isDirectory()) {
            File file2 = new File(str + "/odex/");
            for (String str22 : hashMap.keySet()) {
                File file3 = new File(str3 + str22);
                if (file3.exists()) {
                    file = new File(SharePatchFileUtil.i(file3, file2));
                    if (!file.exists()) {
                        intent.putExtra("intent_patch_missing_dex_path", file.getAbsolutePath());
                        ShareIntentUtil.a(intent, -11);
                        return false;
                    }
                }
                intent.putExtra("intent_patch_missing_dex_path", file3.getAbsolutePath());
                ShareIntentUtil.a(intent, -10);
                return false;
            }
            intent.putExtra("intent_patch_dexes_path", hashMap);
            return true;
        }
        ShareIntentUtil.a(intent, -9);
        return false;
    }

    private static boolean a(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        if (!ShareTinkerInternals.bPb() && shareDexDiffPatchInfo.pGJ.equals("0")) {
            return true;
        }
        return false;
    }
}
