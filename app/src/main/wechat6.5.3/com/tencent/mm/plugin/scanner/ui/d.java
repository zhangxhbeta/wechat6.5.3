package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.scanner.b.o;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.io.IOException;

public final class d extends Preference implements a {
    private f dxf;
    private TextView eXB = null;
    private ImageView eXC = null;
    String gjc;
    private TextView iys = null;
    String iyt;
    String iyu;
    private View mView = null;

    public d(Context context) {
        super(context);
        setLayoutResource(2130904173);
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
        this.eXC = (ImageView) view.findViewById(2131758582);
        this.eXB = (TextView) view.findViewById(2131758583);
        this.iys = (TextView) view.findViewById(2131758584);
        if (be.kS(this.iyt)) {
            this.eXC.setVisibility(8);
        } else {
            Bitmap a = j.a(new o(this.iyt));
            if (a == null || a.isRecycled()) {
                try {
                    this.eXC.setImageBitmap(b.a(aa.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bd.a.getDensity(null), 0, 0));
                } catch (IOException e) {
                    this.eXC.setImageBitmap(null);
                }
            } else {
                this.eXC.setImageBitmap(a);
                this.eXC.setBackgroundColor(0);
            }
        }
        if (be.kS(this.iyu)) {
            this.eXB.setVisibility(8);
        } else {
            this.eXB.setText(e.a(this.mContext, this.iyu, this.eXB.getTextSize()));
        }
        if (be.kS(this.gjc)) {
            this.iys.setVisibility(8);
        } else {
            this.iys.setText(this.gjc);
        }
        if (be.kS(this.iyu) && be.kS(this.iyt)) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(2131758581);
            LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(2131493546);
            linearLayout.setPadding(b.a(this.mContext, 9.0f), 0, 0, 0);
            linearLayout.setLayoutParams(layoutParams);
        }
    }

    public final void k(String str, Bitmap bitmap) {
        if (!be.kS(str) && str.equals(this.iyt) && bitmap != null && !bitmap.isRecycled()) {
            this.eXC.setImageBitmap(bitmap);
            this.eXC.setBackgroundColor(0);
            if (this.dxf != null) {
                this.dxf.notifyDataSetChanged();
            }
        }
    }
}
