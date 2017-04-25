package com.tencent.tinker.lib.service;

import android.os.Process;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public class DefaultTinkerResultService extends AbstractResultService {
    public void a(a aVar) {
        int i = 1;
        if (aVar == null) {
            a.e("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received null result!!!!", new Object[0]);
            return;
        }
        a.i("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received a result:%s ", new Object[]{aVar.toString()});
        b.gi(getApplicationContext());
        if (aVar.bbq) {
            File file = new File(aVar.pFD);
            if (file.exists()) {
                a.i("Tinker.DefaultTinkerResultService", "save delete raw patch file", new Object[0]);
                SharePatchFileUtil.P(file);
            }
            com.tencent.tinker.lib.d.a gh = com.tencent.tinker.lib.d.a.gh(getApplicationContext());
            if (gh.pFS) {
                d dVar = gh.pFR;
                if (dVar != null) {
                    String str = dVar.pFW;
                    if (aVar.pFE != null && aVar.pFE.equals(str)) {
                        i = 0;
                    }
                }
            }
            if (i != 0) {
                Process.killProcess(Process.myPid());
            } else {
                a.i("Tinker.DefaultTinkerResultService", "I have already install the newly patch version!", new Object[0]);
            }
        }
    }
}
