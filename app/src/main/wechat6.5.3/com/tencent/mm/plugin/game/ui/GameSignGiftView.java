package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.d.aj;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public class GameSignGiftView extends RelativeLayout implements OnClickListener {
    static ac gyH = new ac(Looper.getMainLooper());
    String appId;
    TextView dID;
    int gjl;
    LayoutInflater gwU;
    LayoutParams gyA;
    LayoutParams gyB;
    a gyC;
    private int gyD;
    int gyE;
    int gyF;
    boolean gyG = false;
    private int gyq;
    private int gyr;
    int gys;
    int gyt;
    TextView gyu;
    HorizontalScrollView gyv;
    LinearLayout gyw;
    View gyx;
    View gyy;
    LayoutParams gyz;
    Context mContext;

    private class a implements Runnable {
        final /* synthetic */ GameSignGiftView gyI;
        int kB;

        private a(GameSignGiftView gameSignGiftView) {
            this.gyI = gameSignGiftView;
            this.kB = 0;
        }

        public final void run() {
            if (this.gyI.gyG) {
                this.gyI.gyx.setVisibility(8);
                this.gyI.gyy.setVisibility(8);
            } else if (this.kB > 3) {
                int width = this.gyI.gyv.getChildAt(0).getWidth();
                int e = (this.gyI.gyD - this.gyI.gyv.getPaddingLeft()) - this.gyI.gyv.getPaddingRight();
                if (width > e) {
                    this.gyI.gyv.scrollBy(width - e, 0);
                    this.gyI.gyx.setVisibility(0);
                    this.gyI.gyy.setVisibility(8);
                    return;
                }
                this.gyI.gyx.setVisibility(8);
                this.gyI.gyy.setVisibility(8);
            } else {
                this.gyI.gyv.scrollTo(0, 0);
                this.gyI.gyx.setVisibility(8);
                this.gyI.gyy.setVisibility(0);
            }
        }
    }

    public GameSignGiftView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.gyD = c.getScreenWidth(this.mContext);
        this.dID = (TextView) findViewById(2131755226);
        this.gyu = (TextView) findViewById(2131757305);
        this.gyx = findViewById(2131757392);
        this.gyy = findViewById(2131757393);
        this.gyv = (HorizontalScrollView) findViewById(2131757390);
        this.gyw = (LinearLayout) findViewById(2131757391);
        this.gyC = new a();
        this.gwU = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.gyq = com.tencent.mm.bd.a.fromDPToPix(this.mContext, 7);
        this.gyr = com.tencent.mm.bd.a.fromDPToPix(this.mContext, 10);
        this.gys = com.tencent.mm.bd.a.fromDPToPix(this.mContext, 36);
        this.gyt = com.tencent.mm.bd.a.fromDPToPix(this.mContext, 72);
        this.gyz = new LayoutParams(-2, -2);
        this.gyz.setMargins(0, 0, this.gyq, this.gyr);
        this.gyB = new LayoutParams(-2, -2);
        this.gyB.setMargins(this.gyq, 0, 0, this.gyr);
        this.gyA = new LayoutParams(-2, -2);
        this.gyA.setMargins(this.gyq, 0, this.gyq, this.gyr);
        v.i("MicroMsg.GameSignGiftView", "initView finished");
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof aj)) {
            v.w("MicroMsg.GameSignGiftView", "jumpURL is null");
            return;
        }
        aj ajVar = (aj) view.getTag();
        c.n(this.mContext, ajVar.gkT, "game_center_mygame_gift");
        af.a(this.mContext, 10, 1002, ajVar.gkU, 7, this.appId, this.gjl, af.ug(ajVar.gkV));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
