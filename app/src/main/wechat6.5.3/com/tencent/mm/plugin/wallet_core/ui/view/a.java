package com.tencent.mm.plugin.wallet_core.ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.c;

public final class a {
    public static h a(final Context context, String str, String str2, String str3, final b bVar, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.jk(false);
        aVar.jl(true);
        aVar.wq(2131231010).b(onClickListener);
        aVar.Op(str);
        View inflate = View.inflate(context, 2130904605, null);
        final EditText editText = (EditText) inflate.findViewById(2131755280);
        if (!be.kS(str2)) {
            editText.append(str2);
        }
        TextView textView = (TextView) inflate.findViewById(2131757003);
        if (be.kS(str3)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str3);
        }
        aVar.wp(2131231107).a(false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                boolean z = true;
                if (bVar != null) {
                    z = bVar.r(editText.getText().toString().trim());
                }
                if (z) {
                    dialogInterface.dismiss();
                    if (context instanceof MMActivity) {
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 kWw;

                            {
                                this.kWw = r1;
                            }

                            public final void run() {
                                ((MMActivity) context).axg();
                            }
                        });
                    }
                }
            }
        });
        c.b(editText).yn(20).a(null);
        aVar.cC(inflate);
        h RX = aVar.RX();
        RX.show();
        if (context instanceof MMActivity) {
            ((MMActivity) context).a(RX);
        }
        if (context instanceof MMActivity) {
            inflate.post(new Runnable() {
                public final void run() {
                    ((MMActivity) context).aJs();
                }
            });
        }
        return RX;
    }
}
