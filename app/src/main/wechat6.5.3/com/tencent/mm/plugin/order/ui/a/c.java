package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.ui.base.preference.Preference;

public final class c extends Preference {
    Bitmap cxY = null;
    private TextView hLJ;
    String hPA = "";
    private ImageView hPz;
    OnClickListener mOnClickListener;
    private View mView = null;

    public c(Context context) {
        super(context);
        setLayoutResource(2130903931);
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
        this.hLJ = (TextView) view.findViewById(2131758058);
        this.hPz = (ImageView) view.findViewById(2131758057);
        this.hLJ.setText(this.hPA);
        this.hPz.setImageBitmap(this.cxY);
        this.hPz.setOnClickListener(this.mOnClickListener);
        if (this.hPA != null && this.hPA.length() > 48) {
            this.hLJ.setTextSize(0, (float) a.N(this.mContext, 2131493128));
        }
    }
}
