package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.p;
import java.util.List;

public final class e extends p {
    private String biB;
    private String bkC;
    private String[] dun;
    private Cursor duo;

    public e(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, true, 0);
        this.biB = str;
        List LF = ak.yW().wO().LF(this.biB);
        if (LF != null) {
            this.dun = be.bO(LF);
        }
    }

    public final void a(String str, int[] iArr, boolean z) {
        v.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", new Object[]{str});
        clearCache();
        this.bkC = str;
        if (this.duo != null) {
            this.duo.close();
            this.duo = null;
        }
        if (!(be.kS(this.bkC) || this.dun == null)) {
            ak.yW();
            this.duo = c.wH().a(this.dun, "@all.chatroom", this.bkC, null, null);
        }
        notifyDataSetChanged();
        aR(str, true);
    }

    protected final a gK(int i) {
        if (!this.duo.moveToPosition(i)) {
            return null;
        }
        u uVar = new u();
        uVar.b(this.duo);
        d dVar = new d(i);
        dVar.euW = uVar;
        dVar.oHa = true;
        return dVar;
    }

    public final void finish() {
        super.finish();
        if (this.duo != null) {
            this.duo.close();
            this.duo = null;
        }
    }

    public final int getCount() {
        if (this.duo == null) {
            return 0;
        }
        return this.duo.getCount();
    }
}
