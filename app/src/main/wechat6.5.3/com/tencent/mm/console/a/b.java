package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.mm.e.a.ha;
import com.tencent.mm.pluginsdk.a.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;

public final class b implements a {
    static {
        com.tencent.mm.pluginsdk.a.b.a(new b(), "//hotpatch");
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        if (v.getLogLevel() > 1) {
            return false;
        }
        if (strArr.length < 2) {
            return true;
        }
        String str = strArr[1];
        int i = -1;
        switch (str.hashCode()) {
            case 3237038:
                if (str.equals("info")) {
                    i = 1;
                    break;
                }
                break;
            case 93029230:
                if (str.equals("apply")) {
                    i = 0;
                    break;
                }
                break;
            case 94627080:
                if (str.equals("check")) {
                    i = 3;
                    break;
                }
                break;
            case 94746189:
                if (str.equals("clear")) {
                    i = 2;
                    break;
                }
                break;
        }
        String str2;
        switch (i) {
            case 0:
                v.d("MicroMsg.CommandTestHotPatches", "hotpatch test from %s", strArr.length < 3 ? "/data/local/tmp/test.apk" : strArr[2]);
                com.tencent.mm.sdk.c.b haVar = new ha();
                haVar.bgH.bgM = str2;
                com.tencent.mm.sdk.c.a.nhr.z(haVar);
                return true;
            case 1:
                v.d("MicroMsg.CommandTestHotPatches", "hotpatch current class loader=%s", getClass().getClassLoader());
                return true;
            case 2:
                v.d("MicroMsg.CommandTestHotPatches", "clear hotpatch");
                com.tencent.mm.sdk.c.b haVar2 = new ha();
                haVar2.bgH.aYt = 1;
                com.tencent.mm.sdk.c.a.nhr.z(haVar2);
                return true;
            case 3:
                if (strArr.length < 3) {
                    return true;
                }
                str2 = strArr[2];
                if (!str2.startsWith("/")) {
                    str2 = "/data/data/com.tencent.mm/app_dex/" + str2;
                }
                v.i("MicroMsg.CommandTestHotPatches", "hotpatch check patch file %s", str2);
                v.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
                v.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
                v.i("MicroMsg.CommandTestHotPatches", "hotpatch check md5, passed=%b", Boolean.valueOf(SharePatchFileUtil.QB(str2)));
                v.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
                return true;
            default:
                return true;
        }
    }
}
