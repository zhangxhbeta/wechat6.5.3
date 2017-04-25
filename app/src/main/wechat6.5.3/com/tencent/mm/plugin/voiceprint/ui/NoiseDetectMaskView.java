package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NoiseDetectMaskView extends RelativeLayout {
    ProgressBar fpm = null;
    TextView kpt;
    TextView kpu;
    b kpv;
    a kpw;
    private Context mContext = null;

    public interface a {
        void bbc();
    }

    public interface b {
        void bbd();
    }

    public NoiseDetectMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mContext.getSystemService("layout_inflater");
        LayoutInflater.from(this.mContext).inflate(2130904131, this);
        this.fpm = (ProgressBar) findViewById(2131758460);
        this.kpt = (TextView) findViewById(2131758461);
        this.kpu = (TextView) findViewById(2131758462);
        this.kpu.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NoiseDetectMaskView kpx;

            {
                this.kpx = r1;
            }

            public final void onClick(View view) {
                if (this.kpx.kpv != null) {
                    this.kpx.kpv.bbd();
                }
            }
        });
        findViewById(2131759676).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NoiseDetectMaskView kpx;

            {
                this.kpx = r1;
            }

            public final void onClick(View view) {
                if (this.kpx.kpw != null) {
                    this.kpx.kpw.bbc();
                }
            }
        });
    }
}
