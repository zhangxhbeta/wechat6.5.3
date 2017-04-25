package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.contact.p.a;
import java.util.List;

public final class o extends p {
    private String bkC;
    private Cursor duo;
    private String ezn;
    private ac handler = new ac(Looper.getMainLooper());
    private List<String> oHq = null;
    private a oHr;

    public o(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, false, 0);
        this.ezn = str;
        v.i("MicroMsg.MMSearchContactAdapter", "Create!");
        NH();
    }

    public final void a(a aVar) {
        this.oHr = aVar;
    }

    public final void aR(String str, boolean z) {
        if (this.oHr != null) {
            this.oHr.n(str, getCount(), z);
        }
    }

    private void NH() {
        v.i("MicroMsg.MMSearchContactAdapter", "initData!");
        this.bkC = null;
        clearCache();
    }

    public final int getCount() {
        return this.duo == null ? 0 : this.duo.getCount();
    }

    protected final com.tencent.mm.ui.contact.a.a gK(int i) {
        com.tencent.mm.ui.contact.a.a aVar = null;
        if (i < 0 || !this.duo.moveToPosition(i)) {
            v.e("MicroMsg.MMSearchContactAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
        } else {
            aVar = new com.tencent.mm.ui.bizchat.a(i);
            c cVar = new c();
            cVar.b(this.duo);
            if (aVar.ezh == -1) {
                aVar.ezh = cVar.field_bizChatLocalId;
                if (cVar.DN()) {
                    aVar.dtS = cVar.field_chatName;
                    aVar.ohc = cVar.field_headImageUrl;
                    aVar.username = cVar.field_brandUserName;
                } else {
                    j ig = u.DC().ig(cVar.field_bizChatServId);
                    if (ig != null) {
                        aVar.dtS = ig.field_userName;
                        aVar.ohc = ig.field_headImageUrl;
                        aVar.username = ig.field_brandUserName;
                    }
                }
                if (be.D(aVar.dtS)) {
                    aVar.dtS = this.oGZ.getActivity().getResources().getString(2131234604);
                }
                if (be.kS(aVar.username)) {
                    aVar.username = cVar.field_brandUserName;
                }
            }
        }
        return aVar;
    }

    public final void finish() {
        super.finish();
        v.i("MicroMsg.MMSearchContactAdapter", "finish!");
        NH();
    }

    protected final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        return true;
    }
}
