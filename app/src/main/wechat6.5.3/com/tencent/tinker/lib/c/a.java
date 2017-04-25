package com.tencent.tinker.lib.c;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class a implements c {
    public final Context context;

    public a(Context context) {
        this.context = context;
    }

    public void c(File file, int i) {
        com.tencent.tinker.lib.e.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPatchListenerReceiveFail: patch receive fail:%s, code:%d", new Object[]{file.getAbsolutePath(), Integer.valueOf(i)});
    }

    public void a(String str, String str2, File file, String str3) {
        int i = 0;
        com.tencent.tinker.lib.e.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPatchVersionChanged: patch version change from " + str + " to " + str2, new Object[0]);
        if (str != null && str2 != null && !str.equals(str2) && com.tencent.tinker.lib.d.a.gh(this.context).pFP) {
            com.tencent.tinker.lib.e.a.i("Tinker.DefaultLoadReporter", "onLoadPatchVersionChanged, try kill all other process", new Object[0]);
            ShareTinkerInternals.gw(this.context);
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (i < length) {
                    File file2 = listFiles[i];
                    String name = file2.getName();
                    if (file2.isDirectory() && !name.equals(str3)) {
                        SharePatchFileUtil.e(file2);
                    }
                    i++;
                }
            }
        }
    }

    public void a(File file, int i, boolean z) {
        com.tencent.tinker.lib.e.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType:%d, isDirectory:%b", new Object[]{file.getAbsolutePath(), Integer.valueOf(i), Boolean.valueOf(z)});
        bOY();
    }

    public void a(File file, int i) {
        com.tencent.tinker.lib.e.a.i("Tinker.DefaultLoadReporter", "patch load Reporter onLoadFileMd5Mismatch: patch file md5 mismatch file: %s, fileType:%d", new Object[]{file.getAbsolutePath(), Integer.valueOf(i)});
        bOY();
    }

    public void a(String str, String str2, File file) {
        com.tencent.tinker.lib.e.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPatchInfoCorrupted: patch info file damage: %s, from version: %s to version: %s", new Object[]{file.getAbsolutePath(), str, str2});
        bOY();
    }

    public void a(File file, int i, long j) {
        com.tencent.tinker.lib.e.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadResult: patch load result, path:%s, code:%d, cost:%d", new Object[]{file.getAbsolutePath(), Integer.valueOf(i), Long.valueOf(j)});
    }

    public void a(Throwable th, int i) {
        switch (i) {
            case -5:
                com.tencent.tinker.lib.e.a.i("Tinker.DefaultLoadReporter", "patch load parallel dex opt exception: %s", new Object[]{th});
                break;
            case -4:
                com.tencent.tinker.lib.e.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load unCatch exception: %s", new Object[]{th});
                ShareTinkerInternals.gt(this.context);
                com.tencent.tinker.lib.e.a.i("Tinker.DefaultLoadReporter", "unCaught exception disable tinker forever with sp", new Object[0]);
                break;
            case -3:
                if (th.getMessage().contains("checkResInstall failed")) {
                    com.tencent.tinker.lib.e.a.e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: tinker res check fail:" + th.getMessage(), new Object[0]);
                } else {
                    com.tencent.tinker.lib.e.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load resource exception: %s", new Object[]{th});
                }
                ShareTinkerInternals.gt(this.context);
                com.tencent.tinker.lib.e.a.i("Tinker.DefaultLoadReporter", "res exception disable tinker forever with sp", new Object[0]);
                break;
            case ai.CTRL_INDEX /*-2*/:
                if (th.getMessage().contains("checkDexInstall failed")) {
                    com.tencent.tinker.lib.e.a.e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: tinker dex check fail:" + th.getMessage(), new Object[0]);
                } else {
                    com.tencent.tinker.lib.e.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load dex exception: %s", new Object[]{th});
                }
                ShareTinkerInternals.gt(this.context);
                com.tencent.tinker.lib.e.a.i("Tinker.DefaultLoadReporter", "dex exception disable tinker forever with sp", new Object[0]);
                break;
            case -1:
                com.tencent.tinker.lib.e.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load unknown exception: %s", new Object[]{th});
                break;
        }
        com.tencent.tinker.lib.e.a.e("Tinker.DefaultLoadReporter", "tinker load exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
        com.tencent.tinker.lib.e.a.a("Tinker.DefaultLoadReporter", th, "tinker load exception", new Object[0]);
        com.tencent.tinker.lib.d.a.gh(this.context).tinkerFlags = 0;
        bOY();
    }

    public void b(File file, int i) {
        com.tencent.tinker.lib.e.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPackageCheckFail: load patch package check fail file path:%s, errorCode:%d", new Object[]{file.getAbsolutePath(), Integer.valueOf(i)});
        bOY();
    }

    private void bOY() {
        com.tencent.tinker.lib.d.a gh = com.tencent.tinker.lib.d.a.gh(this.context);
        if (gh.pFP) {
            d dVar = gh.pFR;
            if (dVar.pFX) {
                SharePatchInfo sharePatchInfo = dVar.patchInfo;
                if (!(sharePatchInfo == null || ShareTinkerInternals.kS(sharePatchInfo.pGR))) {
                    com.tencent.tinker.lib.e.a.w("Tinker.DefaultLoadReporter", "checkAndCleanPatch, oldVersion %s is not null, try kill all other process", new Object[]{sharePatchInfo.pGR});
                    ShareTinkerInternals.gw(this.context);
                }
            }
        }
        gh.atH();
    }
}
