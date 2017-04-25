package com.tencent.mm.ui.d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.b.b;

public final class a extends b {
    private View edj = null;
    public b nQk;
    int nQl = 0;
    public d nQm;
    public a nQn;

    public interface a {
        void Ex(String str);

        void dX(String str, String str2);
    }

    public a(Context context) {
        super(context);
        if (this.view != null) {
            this.edj = this.view.findViewById(2131755337);
            this.nQm = new d();
            this.nQm.nQr = this.edj;
            this.nQm.nQs = (Button) this.view.findViewById(2131755338);
            this.nQm.nQs.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a nQo;

                {
                    this.nQo = r1;
                }

                public final void onClick(View view) {
                    if (this.nQo.nQk != null && this.nQo.nQn != null) {
                        this.nQo.nQn.Ex(this.nQo.nQk.vY(this.nQo.nQl).nQq.id);
                    }
                }
            });
            this.edj.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a nQo;

                {
                    this.nQo = r1;
                }

                public final void onClick(View view) {
                    if (this.nQo.nQk != null && this.nQo.nQn != null) {
                        c vY = this.nQo.nQk.vY(this.nQo.nQl);
                        this.nQo.nQn.dX(vY.nQq.id, vY.nQq.url);
                    }
                }
            });
        }
    }

    public final int getLayoutId() {
        return 2130903091;
    }

    public final void destroy() {
        ak.yW();
        c.vf().b(this.nQk);
    }

    public final void setVisibility(int i) {
        if (this.edj != null) {
            this.edj.setVisibility(i);
        }
    }
}
