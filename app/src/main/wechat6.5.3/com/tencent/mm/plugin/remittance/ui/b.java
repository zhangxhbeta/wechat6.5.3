package com.tencent.mm.plugin.remittance.ui;

import android.database.Cursor;
import android.database.MergeCursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.n;
import java.util.ArrayList;
import java.util.List;

public final class b extends n implements com.tencent.mm.sdk.h.j.b {
    private Cursor duo;
    private int isA;
    private int isB;
    private List<String> isC;
    private int isD = 0;

    public b(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, List<String> list2) {
        super(mMBaseSelectContactUI, list2, true, false);
        this.isC = list;
        v.i("MicroMsg.RecentConversationAdapter", "create!");
        amB();
        ak.yW();
        c.wK().a(this);
    }

    private void amB() {
        int i;
        v.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.duo != null) {
            this.duo.close();
            this.duo = null;
        }
        this.isD = 0;
        List arrayList = new ArrayList();
        this.isA = -1;
        this.isB = -1;
        if (this.isC == null || this.isC.size() <= 0) {
            i = 0;
        } else {
            ak.yW();
            Cursor bZ = c.wH().bZ(this.isC);
            arrayList.add(bZ);
            i = bZ.getCount();
            if (i > 0) {
                this.isA = this.oGZ.aQr().getHeaderViewsCount();
                this.isD++;
            } else {
                this.isA = -1;
            }
        }
        List list = this.ejp;
        if (list != null) {
            list.addAll(this.isC);
        } else {
            list = this.isC;
        }
        ak.yW();
        Cursor b = c.wK().b(m.crE, list, this.oHp, "");
        if (b.getCount() > 0) {
            this.isD++;
            if (i > 0) {
                this.isB = (i + this.isA) + 1;
            } else {
                this.isB = this.oGZ.aQr().getHeaderViewsCount();
            }
        } else {
            this.isB = -1;
        }
        arrayList.add(b);
        this.duo = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
    }

    protected final a gK(int i) {
        a fVar;
        if (i == this.isB || i == this.isA) {
            fVar = new f(i);
            if (i == this.isA) {
                fVar.oJx = this.oGZ.getActivity().getResources().getString(2131234534);
                return fVar;
            } else if (i != this.isB) {
                return fVar;
            } else {
                fVar.oJx = this.oGZ.getActivity().getResources().getString(2131234868);
                return fVar;
            }
        }
        int i2;
        if (this.isD == 2) {
            if (i > this.isB) {
                i2 = i - 2;
            } else {
                i2 = i - 1;
            }
        } else if (this.isD == 1) {
            i2 = i - 1;
        } else {
            v.e("MicroMsg.RecentConversationAdapter", "Actually dead branch. position=%d", new Object[]{Integer.valueOf(i)});
            i2 = i;
        }
        if (!this.duo.moveToPosition(i2)) {
            return null;
        }
        fVar = new e(i);
        ab abVar = new ab();
        abVar.b(this.duo);
        ak.yW();
        fVar.euW = c.wH().LS(abVar.field_username);
        if (fVar.euW != null) {
            return fVar;
        }
        ak.yW();
        fVar.euW = c.wH().LW(abVar.field_username);
        return fVar;
    }

    public final int getCount() {
        return this.duo.getCount() + this.isD;
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
