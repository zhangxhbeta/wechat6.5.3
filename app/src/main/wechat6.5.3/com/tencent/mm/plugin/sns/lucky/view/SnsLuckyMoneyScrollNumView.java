package com.tencent.mm.plugin.sns.lucky.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public class SnsLuckyMoneyScrollNumView extends RelativeLayout implements b {
    public LayoutInflater dY;
    private boolean hdQ = false;
    public a jiA;
    public List<String> jiB;
    public LinearLayout jix;
    public List<SnsLuckyMoneyAutoScrollItem> jiy;
    public List<ImageView> jiz;

    public interface a {
        void aye();
    }

    public SnsLuckyMoneyScrollNumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public SnsLuckyMoneyScrollNumView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.dY = LayoutInflater.from(context);
        this.jiy = new ArrayList();
        this.jiz = new ArrayList();
        this.jiB = new ArrayList();
        this.jix = (LinearLayout) this.dY.inflate(2130904469, this).findViewById(2131755326);
    }

    public final void ayd() {
        if (!this.hdQ) {
            this.hdQ = true;
            ad.o(new Runnable(this) {
                final /* synthetic */ SnsLuckyMoneyScrollNumView jiC;

                {
                    this.jiC = r1;
                }

                public final void run() {
                    SnsLuckyMoneyScrollNumView snsLuckyMoneyScrollNumView = this.jiC;
                    for (SnsLuckyMoneyAutoScrollItem visibility : snsLuckyMoneyScrollNumView.jiy) {
                        visibility.setVisibility(8);
                    }
                    for (ImageView visibility2 : snsLuckyMoneyScrollNumView.jiz) {
                        visibility2.setVisibility(0);
                    }
                    if (this.jiC.jiA != null) {
                        this.jiC.jiA.aye();
                    }
                }
            });
        }
    }
}
