package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.mm.bd.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class b extends e {
    public String aGX;
    public int kCd = 0;
    private boolean oJk;

    public b(int i) {
        super(i);
    }

    public final void bo(Context context) {
        if (this.kCd == 0 || this.aGX == null) {
            u uVar = this.euW;
            if (!this.oJk) {
                ak.yW();
                uVar = c.wH().LX(this.username);
                this.euW = uVar;
                this.oJk = true;
            }
            if (uVar == null) {
                this.dtS = SQLiteDatabase.KeyEmpty;
                return;
            }
            this.dtS = e.a(context, l.c(uVar), a.N(context, 2131493169));
            this.username = uVar.field_username;
            return;
        }
        this.oJt = this.kCd;
        this.oJs = this.aGX;
    }
}
