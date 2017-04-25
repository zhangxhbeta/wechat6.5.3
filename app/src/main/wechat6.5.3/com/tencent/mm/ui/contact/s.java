package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.e.b.af;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;

public final class s extends n implements b {
    private Cursor duo;
    private int isB;
    private List<String> oIc;
    private int oId;
    private boolean oIe;
    private int oIf;

    public s(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list) {
        this(mMBaseSelectContactUI, list, true, false, false, 0);
    }

    public s(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, boolean z2, boolean z3, int i) {
        super(mMBaseSelectContactUI, list, z, z2);
        this.oIf = 0;
        v.i("MicroMsg.RecentConversationAdapter", "create!");
        this.oIe = z3;
        this.oIf = i;
        amB();
        ak.yW();
        c.wK().a(this);
    }

    private void amB() {
        int i;
        int i2 = 0;
        v.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.duo != null) {
            this.duo.close();
            this.duo = null;
        }
        if (r.dn(this.oIf, 4)) {
            ak.yW();
            this.duo = c.wK().b(m.crE, this.ejp, this.oHp, SQLiteDatabase.KeyEmpty);
        } else {
            ak.yW();
            this.duo = c.wK().b(m.crA, this.ejp, this.oHp, SQLiteDatabase.KeyEmpty);
        }
        if (this.oIe) {
            i = 2;
        } else {
            i = 0;
        }
        if (this.oIc != null) {
            i2 = this.oIc.size();
        }
        this.oId = i2;
        this.isB = i + this.oId;
        clearCache();
    }

    public final int getCount() {
        return (this.duo.getCount() + this.isB) + 1;
    }

    protected final a gK(int i) {
        a fVar;
        a fVar2;
        if (this.isB > this.oId) {
            if (i == this.oId) {
                fVar = new f(i);
                fVar.oJx = this.oGZ.getActivity().getResources().getString(2131230868);
            } else if (i == this.oId + 1) {
                fVar = new com.tencent.mm.ui.contact.a.b(i);
                String string = this.oGZ.getActivity().getResources().getString(2131230868);
                fVar.kCd = 2131165463;
                fVar.aGX = string;
            }
            if (i == this.isB) {
                fVar2 = new f(i);
                fVar2.oJx = this.oGZ.getActivity().getResources().getString(2131234868);
                return fVar2;
            } else if (i < this.oId) {
                if (this.oIc != null || i < 0 || i >= this.oIc.size()) {
                    return null;
                }
                fVar2 = new com.tencent.mm.ui.contact.a.b(i);
                fVar2.username = (String) this.oIc.get(i);
                return fVar2;
            } else if (i > this.isB || !this.duo.moveToPosition((i - this.isB) - 1)) {
                v.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
                return fVar;
            } else {
                fVar2 = new e(i);
                af abVar = new ab();
                abVar.b(this.duo);
                ak.yW();
                fVar2.euW = c.wH().LS(abVar.field_username);
                if (fVar2.euW == null) {
                    ak.yW();
                    fVar2.euW = c.wH().LW(abVar.field_username);
                }
                fVar2.oHa = aQk();
                return fVar2;
            }
        }
        fVar = null;
        if (i == this.isB) {
            fVar2 = new f(i);
            fVar2.oJx = this.oGZ.getActivity().getResources().getString(2131234868);
            return fVar2;
        } else if (i < this.oId) {
            return this.oIc != null ? null : null;
        } else {
            if (i > this.isB) {
            }
            v.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
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
        ak.yW();
        c.wK().b(this);
    }

    public final void a(int i, j jVar, Object obj) {
        amB();
        notifyDataSetChanged();
    }
}
