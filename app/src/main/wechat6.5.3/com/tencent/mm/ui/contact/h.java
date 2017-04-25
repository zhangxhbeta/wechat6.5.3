package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d;
import java.util.ArrayList;
import java.util.List;

public final class h extends n {
    private Cursor duo = c.wH().bY(this.oGk);
    private List<String> oGk;

    public h(MMBaseSelectContactUI mMBaseSelectContactUI, boolean z, List<String> list) {
        super(mMBaseSelectContactUI, new ArrayList(), true, z);
        this.oGk = list;
        ak.yW();
    }

    public final int getCount() {
        return this.duo.getCount();
    }

    protected final a gK(int i) {
        if (i < 0 || !this.duo.moveToPosition(i)) {
            v.e("MicroMsg.CustomContactAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
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
        v.i("MicroMsg.CustomContactAdapter", "finish!");
        if (this.duo != null) {
            this.duo.close();
            this.duo = null;
        }
    }
}
