package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.DrawedCallBackLinearLayout;

public class TestTimeForChatting extends DrawedCallBackLinearLayout {
    public final String TAG = "MicroMsg.TestTimeForChatting";
    public int clU = 0;
    public int oVh = 0;
    public int oVi = 0;

    public TestTimeForChatting(Context context) {
        super(context);
    }

    public TestTimeForChatting(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public final void bJw() {
        v.i("MicroMsg.TestTimeForChatting", "klem frameCount:%d", Integer.valueOf(this.clU));
        g.iuh.h(11198, Integer.valueOf(this.clU));
    }

    protected void dispatchDraw(Canvas canvas) {
        this.clU++;
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
            v.e("MicroMsg.TestTimeForChatting", "dispatchDraw", th);
        }
        f.oS(9);
        f.oS(18);
        f.oS(25);
        f.oS(24);
        f.oS(20);
    }

    public boolean fitSystemWindows(Rect rect) {
        v.d("MicroMsg.TestTimeForChatting", "ashu::fitSystemWindows: %s, fixBottomPadding:%d fixRightPadding:%d", rect.toString(), Integer.valueOf(this.oVh), Integer.valueOf(this.oVi));
        rect.bottom += this.oVh;
        rect.right += this.oVi;
        return super.fitSystemWindows(rect);
    }
}
