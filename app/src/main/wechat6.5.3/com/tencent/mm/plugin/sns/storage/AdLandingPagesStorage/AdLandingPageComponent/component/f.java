package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.c;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.ui.d.g.3;
import com.tencent.mm.pluginsdk.ui.d.g.4;
import com.tencent.mm.ui.tools.l;
import java.util.List;

public final class f extends d {
    LinearLayout fQp;
    private TextView gtw;
    private ImageView jxI;
    private ImageView jxJ;
    LinearLayout jxK;

    public f(Context context, c cVar, ViewGroup viewGroup) {
        super(context, cVar, viewGroup);
    }

    protected final int aGY() {
        return 2130904423;
    }

    protected final void aTS() {
        this.gtw.setText((CharSequence) ((c) this.jxU).jvk.get(0));
        if (((c) this.jxU).jvO) {
            this.jxI.setImageDrawable(a.a(this.context, 2130839310));
            this.jxJ.setImageDrawable(a.a(this.context, 2130839053));
            this.gtw.setTextColor(-16777216);
            this.jxK.setBackgroundResource(2130837617);
        } else {
            this.jxI.setImageDrawable(a.a(this.context, 2130839309));
            this.jxJ.setImageDrawable(a.a(this.context, 2130839052));
            this.gtw.setTextColor(-1);
            this.jxK.setBackgroundResource(2130837618);
        }
        this.jxK.setPadding((int) ((c) this.jxU).jvK, 0, (int) ((c) this.jxU).jvL, 0);
        this.fQp.setPadding(0, (int) ((c) this.jxU).jvI, 0, (int) ((c) this.jxU).jvJ);
        a(this.jxK);
        this.jxK.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ f jxL;

            {
                this.jxL = r1;
            }

            public final void onClick(View view) {
                if (((c) this.jxL.jxU).jvk.size() > 1) {
                    Context context = this.jxL.context;
                    List list = ((c) this.jxL.jxU).jvk;
                    if (!list.isEmpty() && context != null) {
                        new l(context).b(null, new 3(list), new 4(context));
                        return;
                    }
                    return;
                }
                g.a(this.jxL.context, (String) ((c) this.jxL.jxU).jvk.get(0), null, new Bundle());
            }
        });
    }

    public final View aTM() {
        if (((c) this.jxU).jvk.isEmpty()) {
            return null;
        }
        View view = this.dtW;
        this.jxI = (ImageView) view.findViewById(2131759244);
        this.jxJ = (ImageView) view.findViewById(2131759245);
        this.gtw = (TextView) view.findViewById(2131757325);
        this.fQp = (LinearLayout) view.findViewById(2131755326);
        this.jxK = (LinearLayout) view.findViewById(2131759242);
        return this.dtW;
    }
}
