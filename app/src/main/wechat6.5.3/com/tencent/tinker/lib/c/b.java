package com.tencent.tinker.lib.c;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class b implements d {
    public final Context context;

    public b(Context context) {
        this.context = context;
    }

    public void z(Intent intent) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchServiceStart: patch service start", new Object[0]);
    }

    public void d(File file, int i) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchPackageCheckFail: package check failed. path:%s, code:%d", new Object[]{file.getAbsolutePath(), Integer.valueOf(i)});
        if (i == -3 || i == -4 || i == -8) {
            com.tencent.tinker.lib.d.a.gh(this.context).L(file);
        }
    }

    public void a(File file, SharePatchInfo sharePatchInfo, String str) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchVersionCheckFail: patch version exist. path:%s, version:%s", new Object[]{file.getAbsolutePath(), str});
    }

    public void a(File file, File file2, String str, int i) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchTypeExtractFail: file extract fail type:%s, path:%s, extractTo:%s, filename:%s", new Object[]{ShareTinkerInternals.zB(i), file.getPath(), file2.getPath(), str});
        com.tencent.tinker.lib.d.a.gh(this.context).L(file);
    }

    public void a(File file, File file2, String str, String str2, Throwable th) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchDexOptFail: dex opt fail path:%s, dexPath:%s, optDir:%s, dexName:%s", new Object[]{file.getAbsolutePath(), file2.getPath(), str, str2});
        a.a("Tinker.DefaultPatchReporter", th, "onPatchDexOptFail:", new Object[0]);
        com.tencent.tinker.lib.d.a.gh(this.context).L(file);
    }

    public void a(File file, boolean z, long j) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchResult: patch all result path:%s, success:%b, cost:%d", new Object[]{file.getAbsolutePath(), Boolean.valueOf(z), Long.valueOf(j)});
    }

    public void a(File file, String str, String str2) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchInfoCorrupted: patch info is corrupted. old:%s, new:%s", new Object[]{str, str2});
        com.tencent.tinker.lib.d.a.gh(this.context).atH();
    }

    public void a(File file, Throwable th) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchException: patch exception path:%s, throwable:%s", new Object[]{file.getAbsolutePath(), th.getMessage()});
        a.e("Tinker.DefaultPatchReporter", "tinker patch exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
        a.a("Tinker.DefaultPatchReporter", th, "tinker patch exception", new Object[0]);
        com.tencent.tinker.lib.d.a.gh(this.context).tinkerFlags = 0;
        com.tencent.tinker.lib.d.a.gh(this.context).L(file);
    }
}
