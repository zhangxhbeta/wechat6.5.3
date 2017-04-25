package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.sdk.platformtools.v;

public final class i extends d {
    private LinearLayout fQp;
    private TextView gtw;
    private ImageView jxJ;
    private LinearLayout jxK;
    f jxQ;
    private View jxR;
    private ImageView jxS;

    public i(Context context, f fVar, ViewGroup viewGroup) {
        super(context, fVar, viewGroup);
        this.jxQ = fVar;
    }

    public final View aTM() {
        View view = this.dtW;
        this.jxS = (ImageView) view.findViewById(2131759244);
        this.jxJ = (ImageView) view.findViewById(2131759245);
        this.gtw = (TextView) view.findViewById(2131757325);
        this.jxK = (LinearLayout) view.findViewById(2131759242);
        this.fQp = (LinearLayout) view.findViewById(2131755326);
        this.jxR = this.jxK;
        return this.dtW;
    }

    protected final void aTS() {
        this.gtw.setText(this.jxQ.jvm.gRM);
        if (this.jxQ.jvO) {
            this.jxS.setImageDrawable(a.a(this.context, 2130838462));
            this.jxJ.setImageDrawable(a.a(this.context, 2130839053));
            this.gtw.setTextColor(-16777216);
            this.jxK.setBackgroundResource(2130837617);
        } else {
            this.jxS.setImageDrawable(a.a(this.context, 2130838458));
            this.jxJ.setImageDrawable(a.a(this.context, 2130839052));
            this.gtw.setTextColor(-1);
            this.jxK.setBackgroundResource(2130837618);
        }
        this.jxK.setPadding((int) this.jxQ.jvK, 0, (int) this.jxQ.jvL, 0);
        this.fQp.setPadding(0, (int) this.jxQ.jvI, 0, (int) this.jxQ.jvJ);
        a(this.jxK);
        OnClickListener anonymousClass1 = new OnClickListener(this) {
            final /* synthetic */ i jxT;

            {
                this.jxT = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("map_view_type", 1);
                intent.putExtra("kwebmap_slat", this.jxT.jxQ.jvm.gRK);
                intent.putExtra("kwebmap_lng", this.jxT.jxQ.jvm.gRL);
                intent.putExtra("kwebmap_scale", this.jxT.jxQ.jvm.bhu);
                intent.putExtra("kPoiName", this.jxT.jxQ.jvm.bkV);
                intent.putExtra("Kwebmap_locaion", this.jxT.jxQ.jvm.gRM);
                v.i("AdLandingBorderedComp", "locatint to slat " + this.jxT.jxQ.jvm.gRK + ", slong " + this.jxT.jxQ.jvm.gRL + ", " + this.jxT.jxQ.jvm.bkV);
                c.b(this.jxT.context, "location", ".ui.RedirectUI", intent, 2);
            }
        };
        if (this.jxR != null) {
            this.jxR.setOnClickListener(anonymousClass1);
        }
    }

    protected final int aGY() {
        return 2130904423;
    }
}
