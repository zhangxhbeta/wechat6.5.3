package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;

public final class v extends n {
    private Cursor duo = c.wH().d(this.oDA, SQLiteDatabase.KeyEmpty, this.ejp);
    private String oDA;

    public v(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, new ArrayList(), false, false);
        this.oDA = str;
        ak.yW();
    }

    public final int getCount() {
        return this.duo.getCount();
    }

    protected final a gK(int i) {
        if (i < 0 || !this.duo.moveToPosition(i)) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.SpecialContactAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
            return null;
        }
        a dVar = new d(i);
        u uVar = new u();
        uVar.b(this.duo);
        dVar.euW = uVar;
        dVar.oHa = aQk();
        return dVar;
    }

    public final void finish() {
        super.finish();
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.SpecialContactAdapter", "finish!");
        if (this.duo != null) {
            this.duo.close();
            this.duo = null;
        }
    }
}
