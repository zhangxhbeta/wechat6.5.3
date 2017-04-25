package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.scanner.b.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.preference.Preference;

public final class f extends Preference implements a {
    com.tencent.mm.ui.base.preference.f dxf;
    String ffl;
    private ImageView ixg = null;
    private Context mContext;
    private View mView = null;

    public f(Context context) {
        super(context);
        setLayoutResource(2130904185);
        j.a(this);
        this.mContext = context;
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.ixg = (ImageView) view.findViewById(2131756015);
        if (!be.kS(this.ffl)) {
            Bitmap a = j.a(new o(this.ffl));
            if (a == null || a.isRecycled()) {
                this.ixg.setBackgroundColor(this.mContext.getResources().getColor(2131689780));
                this.ixg.setImageBitmap(null);
            } else {
                this.ixg.setImageBitmap(a);
                this.ixg.setBackgroundColor(0);
            }
            ((ImageView) view.findViewById(2131758611)).setVisibility(0);
        }
    }

    public final void k(String str, final Bitmap bitmap) {
        if (!be.kS(str) && str.equals(this.ffl) && bitmap != null && !bitmap.isRecycled()) {
            ad.o(new Runnable(this) {
                final /* synthetic */ f iyP;

                public final void run() {
                    this.iyP.ixg.setImageBitmap(bitmap);
                    this.iyP.ixg.setBackgroundColor(0);
                    if (this.iyP.dxf != null) {
                        this.iyP.dxf.notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
