package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.r;
import com.tencent.mmdb.FileUtils;

public final class f extends b {
    String nQH = null;
    String nQI = null;

    public f(Context context, String str, String str2) {
        super(context);
        this.nQH = str;
        this.nQI = str2;
        if (this.view != null) {
            ImageView imageView = (ImageView) this.view.findViewById(2131756283);
            this.view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ f nQJ;

                {
                    this.nQJ = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent((Context) this.nQJ.lKT.get(), SelectContactUI.class);
                    intent.putExtra("list_attr", r.do(r.oHI, FileUtils.S_IRUSR));
                    intent.putExtra("list_type", 10);
                    intent.putExtra("received_card_name", this.nQJ.nQH);
                    intent.putExtra("recommend_friends", true);
                    intent.putExtra("titile", ((Context) this.nQJ.lKT.get()).getString(2131230883));
                    ((Context) this.nQJ.lKT.get()).startActivity(intent);
                    ak.yW().xt().gh(this.nQJ.nQH);
                    ak.yW().xt().gh(this.nQJ.nQI);
                    g.iuh.h(11003, this.nQJ.nQH, Integer.valueOf(2), Integer.valueOf(0));
                }
            });
            imageView.setImageBitmap(com.tencent.mm.u.b.a(this.nQH, true, -1));
        }
    }

    public final int getLayoutId() {
        return 2130903365;
    }

    public final void destroy() {
    }
}
