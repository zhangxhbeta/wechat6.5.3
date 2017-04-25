package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.offline.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class OfflineAlertView extends LinearLayout {
    private View dtW = null;
    a hLn = null;

    public interface a {
        void aEU();

        void onClose();
    }

    static /* synthetic */ void a(OfflineAlertView offlineAlertView, View view) {
        offlineAlertView.setVisibility(0);
        j.aEM();
        be.KL(j.nO(196645));
        ((TextView) offlineAlertView.dtW.findViewById(2131759911)).setText(String.format(offlineAlertView.getContext().getString(2131236227), new Object[0]));
        ((TextView) offlineAlertView.dtW.findViewById(2131759551)).setOnClickListener(new OnClickListener(offlineAlertView) {
            final /* synthetic */ OfflineAlertView hLp;

            {
                this.hLp = r1;
            }

            public final void onClick(View view) {
                this.hLp.dismiss();
            }
        });
        offlineAlertView.dtW.findViewById(2131759912).setOnClickListener(new OnClickListener(offlineAlertView) {
            final /* synthetic */ OfflineAlertView hLp;

            {
                this.hLp = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.offline.b.a.cn(this.hLp.getContext());
            }
        });
        v.i("MicroMsg.OfflineAlertView", "qrCodeView.getHeight%s %s", new Object[]{Integer.valueOf(view.getHeight()), Integer.valueOf(view.getMeasuredHeight())});
        LayoutParams layoutParams = (LayoutParams) offlineAlertView.dtW.getLayoutParams();
        if (view.getHeight() > 0) {
            layoutParams.height = view.getHeight();
            offlineAlertView.dtW.setLayoutParams(layoutParams);
            offlineAlertView.dtW.invalidate();
        }
        if (offlineAlertView.hLn != null) {
            offlineAlertView.hLn.aEU();
        }
    }

    public OfflineAlertView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public OfflineAlertView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.dtW = LayoutInflater.from(getContext()).inflate(2130904654, this);
    }

    public final void bV(final View view) {
        setVisibility(0);
        g.iuh.h(13750, new Object[]{Integer.valueOf(1)});
        view.post(new Runnable(this) {
            final /* synthetic */ OfflineAlertView hLp;

            public final void run() {
                OfflineAlertView.a(this.hLp, view);
            }
        });
    }

    public final void dismiss() {
        setVisibility(8);
        if (this.hLn != null) {
            this.hLn.onClose();
        }
    }
}
