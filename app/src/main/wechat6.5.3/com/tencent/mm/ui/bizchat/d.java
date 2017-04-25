package com.tencent.mm.ui.bizchat;

import android.database.Cursor;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.n;

public final class d extends n implements b {
    private Cursor duo;
    private String ezn;
    private int isB;

    public d(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, false, false);
        v.i("MicroMsg.RecentConversationAdapter", "create!");
        this.ezn = str;
        amB();
    }

    private void amB() {
        v.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.duo != null) {
            this.duo.close();
            this.duo = null;
        }
        this.duo = u.DB().hP(this.ezn);
        this.isB = 0;
    }

    public final int getCount() {
        return this.duo.getCount() + 1;
    }

    protected final a gK(int i) {
        a fVar;
        if (i == this.isB) {
            fVar = new f(i);
            fVar.oJx = this.oGZ.getActivity().getResources().getString(2131234868);
            return fVar;
        } else if (i <= this.isB || !this.duo.moveToPosition((i - this.isB) - 1)) {
            v.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
            return null;
        } else {
            fVar = new a(i);
            com.tencent.mm.modelbiz.a.a aVar = new com.tencent.mm.modelbiz.a.a();
            aVar.b(this.duo);
            if (fVar.ezh != -1) {
                return fVar;
            }
            fVar.ezh = aVar.field_bizChatId;
            c Z = u.DA().Z(aVar.field_bizChatId);
            if (Z.DN()) {
                fVar.dtS = Z.field_chatName;
                fVar.ohc = Z.field_headImageUrl;
                fVar.username = Z.field_brandUserName;
            } else {
                j ig = u.DC().ig(Z.field_bizChatServId);
                if (ig != null) {
                    fVar.dtS = ig.field_userName;
                    fVar.ohc = ig.field_headImageUrl;
                    fVar.username = ig.field_brandUserName;
                }
            }
            if (be.D(fVar.dtS)) {
                fVar.dtS = this.oGZ.getActivity().getResources().getString(2131234604);
            }
            if (!be.kS(fVar.username)) {
                return fVar;
            }
            fVar.username = aVar.field_brandUserName;
            return fVar;
        }
    }

    public final void finish() {
        super.finish();
        v.i("MicroMsg.RecentConversationAdapter", "finish!");
        if (this.duo != null) {
            this.duo.close();
            this.duo = null;
        }
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        amB();
        notifyDataSetChanged();
    }
}
