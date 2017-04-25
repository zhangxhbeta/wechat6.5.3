package com.tencent.mm.model;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.loader.stub.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class ai extends c {
    public static ai cse = new ai(c.cnl);

    private ai(c cVar) {
        super(cVar.cnm);
    }

    public final void J(String str, String str2) {
        v.d("MicroMsg.LastLoginInfo", "save key : %s value : %s", str, str2);
        this.cnm.edit().putString(str, str2).commit();
        if (str.equals("login_weixin_username")) {
            aa.getContext().getSharedPreferences("notify_key_pref_no_account", 4).edit().putString("login_weixin_username", str2).commit();
        }
    }

    public final void c(String str, int i, String str2) {
        int i2 = 0;
        if (i != 0) {
            i2 = 1;
        }
        if (!be.kS(str2)) {
            i2 |= 2;
        }
        if (!be.kS(str)) {
            i2 |= 4;
        }
        J("last_bind_info", String.valueOf(i2));
    }

    public final void fG(String str) {
        v.i("MicroMsg.LastLoginInfo", "Save last avatar: " + str);
        String str2 = str + ".bm";
        String str3 = e.cng + "last_avatar";
        String str4 = str3 + ".bm";
        boolean deleteFile = FileOp.deleteFile(str3) | FileOp.deleteFile(str4);
        v.i("MicroMsg.LastLoginInfo", "delete old avatar path[%s], ret[%b]", str4, Boolean.valueOf(deleteFile));
        if (FileOp.p(str, str3) <= 0) {
            FileOp.p(str2, str4);
        }
        J("last_avatar_path", str3);
    }
}
