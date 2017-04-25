package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.scanner.b.o;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class b extends Preference implements a {
    f dxf;
    String ffl;
    private ImageView ixg = null;
    private Context mContext;
    private View mView = null;

    public b(Context context) {
        super(context);
        setLayoutResource(2130904171);
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
        this.ixg = (ImageView) view.findViewById(2131758580);
        if (!be.kS(this.ffl)) {
            Bitmap a = j.a(new o(this.ffl));
            if (a == null || a.isRecycled()) {
                this.ixg.setBackgroundColor(this.mContext.getResources().getColor(2131689780));
                this.ixg.setImageBitmap(null);
                return;
            }
            this.ixg.setImageBitmap(a);
            this.ixg.setBackgroundColor(0);
        }
    }

    public final void k(String str, Bitmap bitmap) {
        if (!be.kS(str) && str.equals(this.ffl) && bitmap != null && !bitmap.isRecycled()) {
            this.ixg.setImageBitmap(bitmap);
            this.ixg.setBackgroundColor(0);
            if (this.dxf != null) {
                this.dxf.notifyDataSetChanged();
            }
        }
    }
}
