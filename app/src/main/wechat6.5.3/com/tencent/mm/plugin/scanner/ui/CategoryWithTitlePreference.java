package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.scanner.b.o;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class CategoryWithTitlePreference extends Preference implements a {
    private Context context;
    private TextView dtB;
    private f dxf;
    private ImageView hEP;
    private String iconUrl;
    private int ivD;
    private int ivE;
    private String title;

    public final /* bridge */ /* synthetic */ CharSequence getTitle() {
        return this.title;
    }

    public CategoryWithTitlePreference(Context context) {
        this(context, null);
    }

    public CategoryWithTitlePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CategoryWithTitlePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.title = "";
        this.ivD = 34;
        this.ivE = 34;
        setLayoutResource(2130904000);
        this.context = context;
        j.a(this);
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0) {
            this.title = charSequence.toString();
            if (this.dtB != null) {
                this.dtB.setVisibility(0);
                this.dtB.setText(charSequence);
                v.v("MicroMsg.scanner.CategoryWithTitlePreference", "title : " + this.dtB.getText());
            }
        } else if (this.dtB != null) {
            this.dtB.setVisibility(8);
        }
        super.setTitle(charSequence);
    }

    public final void setTitle(int i) {
        if (this.dtB != null) {
            if (this.context != null) {
                this.title = this.context.getString(i);
            }
            if (be.kS(this.title)) {
                this.dtB.setVisibility(8);
            } else {
                this.dtB.setVisibility(0);
                this.dtB.setText(this.title);
            }
        }
        super.setTitle(i);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.dtB = (TextView) view.findViewById(16908310);
        this.hEP = (ImageView) view.findViewById(2131755225);
        LayoutParams layoutParams = this.hEP.getLayoutParams();
        layoutParams.width = b.a(this.context, (float) (this.ivD / 2));
        layoutParams.height = b.a(this.context, (float) (this.ivE / 2));
        this.hEP.setLayoutParams(layoutParams);
        if (!(this.title == null || this.title.length() <= 0 || this.dtB == null)) {
            this.dtB.setVisibility(0);
            this.dtB.setText(this.title);
            v.v("MicroMsg.scanner.CategoryWithTitlePreference", "onBindView title : " + this.dtB.getText());
        }
        if (!be.kS(this.iconUrl)) {
            Bitmap a = j.a(new o(this.iconUrl));
            if (a != null && !a.isRecycled()) {
                this.hEP.setImageBitmap(a);
                this.hEP.setVisibility(0);
            }
        }
    }

    public final void k(String str, final Bitmap bitmap) {
        v.d("MicroMsg.scanner.CategoryWithTitlePreference", "get pic:" + str + ", iconurl:" + this.iconUrl);
        if (!be.kS(str) && str.equals(this.iconUrl) && bitmap != null && !bitmap.isRecycled() && this.hEP != null) {
            ad.o(new Runnable(this) {
                final /* synthetic */ CategoryWithTitlePreference iyr;

                public final void run() {
                    this.iyr.hEP.setImageBitmap(bitmap);
                    this.iyr.hEP.setVisibility(0);
                    if (this.iyr.dxf != null) {
                        this.iyr.dxf.notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
