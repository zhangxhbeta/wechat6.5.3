package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.ui.account.FacebookFriendUI;

public final class h extends b {
    public h(Context context) {
        super(context);
        if (this.view != null) {
            this.view.findViewById(2131756900).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ h nQM;

                {
                    this.nQM = r1;
                }

                public final void onClick(View view) {
                    ak.yW();
                    c.vf().set(65833, Integer.valueOf(0));
                    ((Context) this.nQM.lKT.get()).startActivity(new Intent((Context) this.nQM.lKT.get(), FacebookFriendUI.class));
                    this.nQM.view.setVisibility(8);
                }
            });
        }
    }

    public final int getLayoutId() {
        return 2130903586;
    }

    public final void destroy() {
    }
}
