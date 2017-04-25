package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.scanner.b.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class a extends Preference implements com.tencent.mm.platformtools.j.a {
    private f ezq;
    String fyK;
    private ImageView hTC;
    private TextView ixd = null;
    String ixe = null;
    private View mView = null;

    public a(Context context) {
        super(context);
        setLayoutResource(2130904299);
        j.a(this);
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
        this.ixd = (TextView) view.findViewById(2131756104);
        this.hTC = (ImageView) view.findViewById(2131758975);
        if (be.kS(this.ixe)) {
            this.ixd.setVisibility(8);
        } else {
            this.ixd.setText(this.ixe);
            this.ixd.setVisibility(0);
        }
        if (!be.kS(this.fyK)) {
            Bitmap a = j.a(new o(this.fyK));
            if (a != null && !a.isRecycled()) {
                this.hTC.setImageBitmap(a);
                this.hTC.setVisibility(0);
            }
        }
    }

    public final void k(String str, final Bitmap bitmap) {
        if (!be.kS(str) && str.equals(this.fyK) && bitmap != null && !bitmap.isRecycled() && this.hTC != null) {
            ad.o(new Runnable(this) {
                final /* synthetic */ a ixf;

                public final void run() {
                    this.ixf.hTC.setImageBitmap(bitmap);
                    this.ixf.hTC.setVisibility(0);
                    if (this.ixf.ezq != null) {
                        this.ixf.ezq.notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
