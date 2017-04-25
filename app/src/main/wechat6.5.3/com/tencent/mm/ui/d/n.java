package com.tencent.mm.ui.d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.v;

public final class n extends b {
    private TextView dtY;
    private ImageView eZn;
    private View edj = null;
    private boolean nRu = false;
    public boolean nRy = false;
    public a nRz;

    public interface a {
        void bzb();
    }

    public n(Context context) {
        super(context);
        if (!this.nRu && this.view != null) {
            this.edj = this.view.findViewById(2131759589);
            this.dtY = (TextView) this.view.findViewById(2131759591);
            this.eZn = (ImageView) this.view.findViewById(2131759590);
            this.nRu = true;
        }
    }

    public final int getLayoutId() {
        return 2130904556;
    }

    public final boolean agO() {
        if (!this.nRy) {
            v.i("MicroMsg.TryNewInitBanner", "summerinit update but initFailed[%b] just ret update false", Boolean.valueOf(this.nRy));
            this.edj.setVisibility(8);
            return false;
        } else if (l.Hm()) {
            boolean z;
            this.dtY.setText(2131231372);
            this.eZn.setVisibility(0);
            this.edj.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ n nRA;

                {
                    this.nRA = r1;
                }

                public final void onClick(View view) {
                    v.i("MicroMsg.TryNewInitBanner", "summerinit onClick trynewinit layout start try");
                    this.nRA.setVisibility(8);
                    if (this.nRA.nRz != null) {
                        this.nRA.nRz.bzb();
                    }
                    v.i("MicroMsg.TryNewInitBanner", "summerinit onClick tryNeeInitAgain done callBack[%s]", this.nRA.nRz);
                }
            });
            this.edj.setVisibility(0);
            String str = "MicroMsg.TryNewInitBanner";
            String str2 = "summerinit update set visible [%b]";
            Object[] objArr = new Object[1];
            if (this.edj.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.i(str, str2, objArr);
            return true;
        } else {
            v.i("MicroMsg.TryNewInitBanner", "summerinit update but not need init just update false");
            this.nRy = false;
            this.edj.setVisibility(8);
            return false;
        }
    }

    public final void setVisibility(int i) {
        if (this.edj != null) {
            this.edj.setVisibility(i);
        }
    }

    public final void destroy() {
        this.edj.setBackgroundResource(0);
        this.eZn.setImageResource(0);
    }
}
