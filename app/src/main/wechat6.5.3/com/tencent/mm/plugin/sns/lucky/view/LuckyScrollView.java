package com.tencent.mm.plugin.sns.lucky.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class LuckyScrollView extends ScrollView {
    public LuckyScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LuckyScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void scrollTo(int i, int i2) {
        v.i("MicroMsg.LuckyScrollView", "scrollTo1 x : " + i + " y: " + i2);
        super.scrollTo(i, i2);
        v.i("MicroMsg.LuckyScrollView", "scrollTo2 x : " + i + " y: " + i2 + " " + be.bur().toString());
    }

    public void scrollBy(int i, int i2) {
        super.scrollBy(i, i2);
        v.i("MicroMsg.LuckyScrollView", "scrollBy " + be.bur().toString());
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        v.i("MicroMsg.LuckyScrollView", "scollchange l " + i + " t " + i2 + " oldl " + i3 + "  oldt " + i4);
        super.onScrollChanged(i, i2, i3, i4);
    }
}
