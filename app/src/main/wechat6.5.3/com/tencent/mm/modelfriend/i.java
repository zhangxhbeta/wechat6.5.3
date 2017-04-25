package com.tencent.mm.modelfriend;

import android.database.Cursor;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.be;
import junit.framework.Assert;

public final class i extends g {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS facebookfriend ( fbid long  PRIMARY KEY , fbname text  , fbimgkey int  , status int  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , sex int  , personalcard int  , province text  , city text  , signature text  , alias text  , type int  , email text  ) "};
    public com.tencent.mm.bg.g cuX;

    public i(com.tencent.mm.bg.g gVar) {
        this.cuX = gVar;
    }

    public final boolean a(h hVar) {
        boolean z;
        Assert.assertTrue("Func Set always conv_flag == flag_all", hVar.bkU == -1);
        Cursor rawQuery = this.cuX.rawQuery("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.fbid = \"" + be.lZ(String.valueOf(hVar.bCb)) + "\"", null);
        if (rawQuery.getCount() > 0) {
            z = true;
        } else {
            z = false;
        }
        rawQuery.close();
        if (z) {
            int update = this.cuX.update("facebookfriend", hVar.py(), "fbid=?", new String[]{hVar.bCb});
            if (update > 0) {
                Ls();
            }
            if (update <= 0) {
                return false;
            }
            return true;
        }
        hVar.bkU = -1;
        if (((int) this.cuX.insert("facebookfriend", "fbid", hVar.py())) != -1) {
            return true;
        }
        return false;
    }

    public final boolean ER() {
        return this.cuX.dF("facebookfriend", "delete from facebookfriend");
    }
}
