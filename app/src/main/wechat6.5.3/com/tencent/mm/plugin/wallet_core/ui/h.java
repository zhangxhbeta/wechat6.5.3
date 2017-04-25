package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.a;
import java.util.LinkedList;
import java.util.List;

public final class h {
    public static Dialog a(Context context, List<Bankcard> list, String str, String str2, Bankcard bankcard, a aVar) {
        List linkedList = new LinkedList();
        if ((list == null || list.size() == 0) && be.kS(str)) {
            v.w("MicroMsg.WalletDialogHelper", "hy: bankcard list is null and should not show new");
            return null;
        }
        int i;
        if (list == null || list.size() == 0) {
            v.i("MicroMsg.WalletDialogHelper", "hy: no bankcard show new only");
            linkedList.add(str);
            i = 0;
        } else {
            int i2 = 0;
            i = 0;
            for (Bankcard bankcard2 : list) {
                linkedList.add(bankcard2.field_desc);
                if (bankcard != null && bankcard.equals(bankcard2)) {
                    i = i2;
                }
                i2++;
            }
            if (!be.kS(str)) {
                linkedList.add(str);
                if (bankcard == null) {
                    i = i2;
                }
            }
        }
        return g.a(context, str2, linkedList, i, aVar);
    }

    public static com.tencent.mm.ui.base.h a(Context context, b bVar, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        if (bVar == null || (TextUtils.isEmpty(bVar.kNj) && (bVar.kNk == null || bVar.kNk.isEmpty()))) {
            v.w("MicroMsg.WalletDialogHelper", "show showBalanceFetchAlert alert fail");
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.jk(false);
        aVar.wq(2131231010).b(onClickListener2);
        if (z) {
            aVar.wp(2131235982).a(onClickListener);
        } else {
            aVar.wm(2131235988);
            aVar.wp(2131235992).a(onClickListener);
        }
        View inflate = View.inflate(context, 2130904641, null);
        if (bVar.kNk == null || bVar.kNk.isEmpty()) {
            v.e("MicroMsg.WalletDialogHelper", "fetch itemsList is empty");
        } else {
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131755326);
            linearLayout.removeAllViews();
            int i = 0;
            while (i < bVar.kNk.size() && i < bVar.kNk.size()) {
                View inflate2 = View.inflate(context, 2130904640, null);
                TextView textView = (TextView) inflate2.findViewById(2131755719);
                ((TextView) inflate2.findViewById(2131755226)).setText(((b.a) bVar.kNk.get(i)).apU);
                textView.setText(((b.a) bVar.kNk.get(i)).value);
                linearLayout.addView(inflate2, i);
                i++;
            }
        }
        ((TextView) inflate.findViewById(2131755226)).setText(bVar.kNj);
        if (z) {
            TextView textView2 = (TextView) inflate.findViewById(2131755290);
            textView2.setVisibility(0);
            textView2.setText(context.getString(2131235983));
        }
        aVar.cC(inflate);
        com.tencent.mm.ui.base.h RX = aVar.RX();
        RX.show();
        g.a(context, RX);
        return RX;
    }
}
