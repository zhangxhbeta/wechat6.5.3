package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.a.a.c.a;
import com.tencent.mm.ae.n;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.preference.Preference;

public final class d extends Preference {
    String fyK;
    String mName;
    OnClickListener mOnClickListener;
    private View mView = null;

    public d(Context context) {
        super(context);
        setLayoutResource(2130903932);
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
        ImageView imageView = (ImageView) view.findViewById(2131758060);
        TextView textView = (TextView) view.findViewById(2131758061);
        imageView.setImageBitmap(null);
        if (!be.kS(this.fyK)) {
            a aVar = new a();
            b.aFF();
            aVar.cPv = b.axB();
            aVar.cPs = true;
            aVar.cPO = true;
            aVar.cPP = true;
            n.GL().a(this.fyK, imageView, aVar.GU());
        }
        textView.setText(this.mName);
        view.findViewById(2131758059).setOnClickListener(this.mOnClickListener);
    }
}
