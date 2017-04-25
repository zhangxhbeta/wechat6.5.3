package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bg.f;
import com.tencent.mm.bg.f.a;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import junit.framework.Assert;

public final class ay extends g implements a {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS role_info ( id TEXT PRIMARY KEY, name TEXT, status INT, text_reserved1 TEXT, text_reserved2 TEXT, text_reserved3 TEXT, text_reserved4 TEXT, int_reserved1 INT, int_reserved2 INT, int_reserved3 INT, int_reserved4 INT )"};
    public d cie = null;

    public ay(com.tencent.mm.bg.g gVar) {
        this.cie = gVar;
    }

    public final int a(f fVar) {
        if (fVar != null) {
            this.cie = fVar;
        }
        return 0;
    }

    public final String getTableName() {
        return "role_info";
    }

    public final ax Nr(String str) {
        ax axVar = null;
        if (str != null && str.length() > 0) {
            ax axVar2 = new ax();
            Cursor query = this.cie.query("role_info", null, "name LIKE ?", new String[]{"%" + str}, null, null, null);
            if (query.moveToFirst()) {
                axVar2.b(query);
                axVar = axVar2;
            }
            query.close();
        }
        return axVar;
    }

    public final ax Ns(String str) {
        ax axVar = null;
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        ax axVar2 = new ax();
        Cursor query = this.cie.query("role_info", null, "name= ?", new String[]{str}, null, null, null);
        if (query.moveToFirst()) {
            axVar2.b(query);
            axVar = axVar2;
        }
        query.close();
        return axVar;
    }

    public final void a(ax axVar) {
        axVar.bkU = 135;
        ContentValues py = axVar.py();
        if (py.size() > 0 && this.cie.insert("role_info", "id", py) != 0) {
            Ls();
        }
    }

    public final boolean has(String str) {
        ax Nr = Nr(new ax.a(str).Nq(SQLiteDatabase.KeyEmpty));
        return Nr != null && str.equals(Nr.name);
    }

    public final void bV(String str, int i) {
        if (be.kS(str)) {
            v.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
        } else if (Ns(str) == null) {
            a(new ax(str, true, i));
            v.d("MicroMsg.RoleStorage", "insert new role, user=" + str);
        }
    }

    public final void b(ax axVar) {
        ContentValues py = axVar.py();
        if (py.size() > 0) {
            int update = this.cie.update("role_info", py, "name like ?", new String[]{axVar.name});
            v.d("MicroMsg.RoleStorage", "update role info, name=" + axVar.name + ", res:" + update);
            if (update > 0) {
                Ls();
            }
        }
    }

    public final void hp(String str) {
        Assert.assertTrue(str.length() > 0);
        int delete = this.cie.delete("role_info", "name=?", new String[]{str});
        v.d("MicroMsg.RoleStorage", "delete name name :" + str + ", res:" + delete);
        if (delete > 0) {
            Ls();
        }
    }
}
