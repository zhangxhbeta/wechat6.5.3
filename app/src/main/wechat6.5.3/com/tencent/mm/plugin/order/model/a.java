package com.tencent.mm.plugin.order.model;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.order.ui.a.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.d;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;

public final class a {

    public interface a {
        List<Preference> a(Context context, f fVar, MallTransactionObject mallTransactionObject);
    }

    public static e a(final Context context, final MallTransactionObject mallTransactionObject) {
        e eVar = new e(context);
        if (be.kS(mallTransactionObject.hNq)) {
            eVar.hPB = context.getString(2131236268);
        } else {
            eVar.hPB = context.getString(2131236265);
        }
        eVar.mOnClickListener = new OnClickListener() {
            public final void onClick(View view) {
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                if (!be.kS(mallTransactionObject.hNh)) {
                    linkedList2.add(Integer.valueOf(0));
                    linkedList.add(context.getString(2131236266));
                }
                if (!be.kS(mallTransactionObject.hMJ)) {
                    linkedList2.add(Integer.valueOf(1));
                    linkedList.add(context.getString(2131236267));
                }
                if (!be.kS(mallTransactionObject.hNq)) {
                    linkedList2.add(Integer.valueOf(2));
                    linkedList.add(context.getString(2131236269));
                }
                if (linkedList2.size() == 1) {
                    a.a(((Integer) linkedList2.get(0)).intValue(), context, mallTransactionObject);
                    return;
                }
                g.a(context, null, linkedList, linkedList2, null, true, new d(this) {
                    final /* synthetic */ AnonymousClass1 hMO;

                    {
                        this.hMO = r1;
                    }

                    public final void bw(int i, int i2) {
                        a.a(i2, context, mallTransactionObject);
                    }
                });
            }
        };
        return eVar;
    }

    public static void a(int i, Context context, MallTransactionObject mallTransactionObject) {
        switch (i) {
            case 0:
                ak.yW();
                u LX = c.wH().LX(mallTransactionObject.hNh);
                if (LX == null || !com.tencent.mm.i.a.ei(LX.field_type)) {
                    com.tencent.mm.wallet_core.ui.e.L(context, mallTransactionObject.hNh);
                    return;
                } else {
                    com.tencent.mm.wallet_core.ui.e.bj(context, mallTransactionObject.hNh);
                    return;
                }
            case 1:
                com.tencent.mm.wallet_core.ui.e.bk(context, mallTransactionObject.hMJ);
                return;
            case 2:
                com.tencent.mm.wallet_core.ui.e.l(context, mallTransactionObject.hNq, false);
                return;
            default:
                return;
        }
    }
}
