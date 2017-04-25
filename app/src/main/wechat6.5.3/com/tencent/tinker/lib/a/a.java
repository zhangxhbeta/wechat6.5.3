package com.tencent.tinker.lib.a;

import android.content.Context;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class a implements b {
    public final Context context;

    public a(Context context) {
        this.context = context;
    }

    public final int Qw(String str) {
        int uE = uE(str);
        if (uE == 0) {
            TinkerPatchService.bz(this.context, str);
        } else {
            com.tencent.tinker.lib.d.a.gh(this.context).pFL.c(new File(str), uE);
        }
        return uE;
    }

    public int uE(String str) {
        com.tencent.tinker.lib.d.a gh = com.tencent.tinker.lib.d.a.gh(this.context);
        if (!ShareTinkerInternals.zC(gh.tinkerFlags) || !ShareTinkerInternals.gu(this.context)) {
            return -1;
        }
        File file = new File(str);
        if (!file.isFile() || !file.exists() || file.length() == 0) {
            return -2;
        }
        if (gh.pFQ) {
            return -4;
        }
        if (b.gj(this.context)) {
            return -3;
        }
        return 0;
    }
}
