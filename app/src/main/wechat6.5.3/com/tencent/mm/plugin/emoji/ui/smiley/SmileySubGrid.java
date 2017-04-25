package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ListAdapter;
import com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.MMFlipper;
import java.io.InputStream;

public class SmileySubGrid extends SmileyGrid {
    private int Wj;
    private int XF;
    Rect XO = new Rect();
    int XT;
    int adi;
    private LayoutInflater dY;
    private WindowManager fjE;
    float fjw;
    float fjx;
    int fmM = 6;
    int fmN = -1;
    boolean fmO;
    private PopEmojiView fmP;
    private LayoutParams fmQ;
    private int fmR;
    private int fmS;
    private boolean fmT;
    private c fmU;
    private int fmV;
    private a fmW;
    private b fmX;
    View fmY;
    private int fmZ;
    private String fna;
    public boolean fnb = false;
    public volatile int fnc = -1;
    public volatile boolean fnd = false;
    public boolean fne = true;
    private final String fnf = "lock_refresh";
    private int iD = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    private ac mHandler = new ac();

    private class c implements Runnable {
        final /* synthetic */ SmileySubGrid fng;

        private c(SmileySubGrid smileySubGrid) {
            this.fng = smileySubGrid;
        }

        public final void run() {
            if (!this.fng.fmT) {
                this.fng.fjE.addView(this.fng.fmP, this.fng.fmQ);
                this.fng.fmT = true;
            }
        }
    }

    private class d {
        final /* synthetic */ SmileySubGrid fng;
        private int fnj;

        private d(SmileySubGrid smileySubGrid) {
            this.fng = smileySubGrid;
        }

        public final void ahT() {
            this.fnj = this.fng.getWindowAttachCount();
        }

        public final boolean ahU() {
            return this.fng.hasWindowFocus() && this.fng.getWindowAttachCount() == this.fnj;
        }
    }

    private class a extends d implements Runnable {
        final /* synthetic */ SmileySubGrid fng;

        private a(SmileySubGrid smileySubGrid) {
            this.fng = smileySubGrid;
            super();
        }

        public final void run() {
            int i = this.fng.XT;
            View childAt = this.fng.getChildAt(i - this.fng.getFirstVisiblePosition());
            if (childAt != null) {
                int i2 = this.fng.XT;
                long itemId = this.fng.getAdapter().getItemId(this.fng.XT);
                if (ahU()) {
                    v.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "CheckForLongPress performLongPress position:[%d] id:[%d]", new Object[]{Integer.valueOf(i2), Long.valueOf(itemId)});
                    this.fng.s(childAt, i);
                    this.fng.adi = -1;
                    this.fng.fmM = 5;
                    this.fng.cw(false);
                }
            }
        }
    }

    private class b extends d implements Runnable {
        final /* synthetic */ SmileySubGrid fng;
        View fnh;
        int fni;

        private b(SmileySubGrid smileySubGrid) {
            this.fng = smileySubGrid;
            super();
        }

        public final void run() {
            ListAdapter adapter = this.fng.getAdapter();
            int i = this.fni;
            if (adapter != null && this.fng.getCount() > 0 && i != -1 && i < adapter.getCount() && ahU()) {
                v.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "PerformClick performItemClick position:[%d] id:[%d] ", new Object[]{Integer.valueOf(i), Long.valueOf(adapter.getItemId(i))});
                this.fng.performItemClick(this.fnh, i, adapter.getItemId(i));
            }
        }
    }

    public SmileySubGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dY = LayoutInflater.from(context);
        this.fjE = (WindowManager) context.getSystemService("window");
        this.fmP = new PopEmojiView(getContext());
        this.fmQ = new LayoutParams(-1, -1, 2, 8, 1);
        this.fmZ = context.getResources().getDimensionPixelSize(2131493444);
        this.fmQ.width = this.fmZ;
        this.fmQ.height = this.fmZ;
        this.fmQ.gravity = 17;
        this.XF = agQ();
        this.fmV = ViewConfiguration.getPressedStateDuration();
        this.Wj = getResources().getConfiguration().orientation;
        if (this.Wj == 2) {
            this.fmR = this.fjE.getDefaultDisplay().getHeight();
            this.fmS = this.fjE.getDefaultDisplay().getWidth();
            return;
        }
        this.fmR = this.fjE.getDefaultDisplay().getWidth();
        this.fmS = this.fjE.getDefaultDisplay().getHeight();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fne) {
            int action = motionEvent.getAction();
            View view = null;
            int i;
            switch (action) {
                case 0:
                    action = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.fjw = (float) action;
                    this.fjx = (float) y;
                    action = pointToPosition(action, y);
                    if (action >= 0 && getAdapter().isEnabled(action)) {
                        this.adi = 0;
                    }
                    if (action >= 0) {
                        this.fmN = action;
                        view = getChildAt(action - getFirstVisiblePosition());
                    }
                    if (view != null) {
                        view.setPressed(true);
                        view.setSelected(true);
                        bR(view);
                    }
                    if (this.fmW == null) {
                        this.fmW = new a();
                    }
                    this.fmW.ahT();
                    this.XT = action;
                    if (this.fkt == 25 && this.fkG == 0 && action == 0) {
                        return true;
                    }
                    this.mHandler.postDelayed(this.fmW, (long) this.XF);
                    return true;
                case 1:
                case 3:
                    i = this.XT;
                    View childAt = getChildAt(i - getFirstVisiblePosition());
                    if (action == 1 && this.adi != -1) {
                        if (this.fmX == null) {
                            this.fmX = new b();
                        }
                        Runnable runnable = this.fmX;
                        runnable.fnh = childAt;
                        runnable.fni = i;
                        runnable.ahT();
                        this.mHandler.post(runnable);
                    }
                    this.mHandler.removeCallbacks(this.fmW);
                    cw(true);
                    ahS();
                    if (this.fmN >= 0) {
                        view = getChildAt(this.fmN - getFirstVisiblePosition());
                        if (view != null) {
                            view.setPressed(false);
                            view.setSelected(false);
                            bR(view);
                        }
                    }
                    this.fmM = 6;
                    return true;
                case 2:
                    i = (int) motionEvent.getX();
                    action = (int) motionEvent.getY();
                    if (this.fmM == 5) {
                        i = pointToPosition(i, action);
                        this.XT = i;
                        if ((i < 0 || (this.fkt == 25 && i == 0 && this.fkG == 0)) && !this.fnb) {
                            ahS();
                            if (this.fmN >= 0) {
                                view = getChildAt(this.fmN - getFirstVisiblePosition());
                                if (view != null) {
                                    view.setPressed(false);
                                    view.setSelected(false);
                                    bR(view);
                                }
                            }
                        } else if (this.fmN != i) {
                            this.fmN = i;
                            view = getChildAt(i - getFirstVisiblePosition());
                            layoutChildren();
                            if (view != null) {
                                view.setPressed(true);
                                view.setSelected(true);
                                bR(view);
                                s(view, this.fmN);
                            }
                        }
                        this.mHandler.removeCallbacks(this.fmW);
                        return true;
                    }
                    if (Math.abs(this.fjw - ((float) i)) > ((float) this.iD)) {
                        this.adi = -1;
                        this.mHandler.removeCallbacks(this.fmW);
                    }
                    ahS();
                    return true;
                default:
                    return true;
            }
        }
        ahS();
        return super.onTouchEvent(motionEvent);
    }

    private void s(View view, int i) {
        boolean z = i == this.fnc && this.fmP.isShown();
        if (z) {
            v.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks already show:%d", new Object[]{Integer.valueOf(i)});
        } else {
            v.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks begin show:%d", new Object[]{Integer.valueOf(i)});
            com.tencent.mm.storage.a.c cVar = (com.tencent.mm.storage.a.c) getAdapter().getItem(i);
            if (this.fmU == null) {
                this.fmU = new c();
            }
            m(cVar);
            this.fmP.setBackgroundResource(2130838139);
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (this.Wj == 1) {
                this.fmQ.x = (iArr[0] - ((this.fmR - view.getMeasuredWidth()) / 2)) + 0;
                this.fmQ.y = ((iArr[1] - (this.fmS / 2)) - view.getMeasuredHeight()) + 0;
            } else {
                this.fmQ.x = (iArr[0] - ((this.fmS - view.getMeasuredWidth()) / 2)) + 0;
                this.fmQ.y = ((iArr[1] - (this.fmR / 2)) - view.getMeasuredHeight()) + 0;
            }
            if (this.fmT) {
                this.fjE.updateViewLayout(this.fmP, this.fmQ);
            } else {
                this.fnd = true;
                this.mHandler.postDelayed(this.fmU, (long) this.fmV);
            }
        }
        this.fnc = i;
    }

    private void ahS() {
        if (this.fmU != null) {
            this.mHandler.removeCallbacks(this.fmU);
        }
        if (this.fmT) {
            this.fjE.removeView(this.fmP);
            this.fmT = false;
            this.fnd = false;
        }
        this.fna = "";
    }

    private void bR(View view) {
        Rect rect = this.XO;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        this.XO.set(rect.left - getPaddingLeft(), rect.top - getPaddingTop(), rect.right + getPaddingRight(), rect.bottom + getPaddingBottom());
        boolean z = this.fmO;
        if (view.isEnabled() != z) {
            this.fmO = !z;
            refreshDrawableState();
        }
    }

    public void cw(boolean z) {
        v.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "cpan t setScrollEnable:%b", new Object[]{Boolean.valueOf(z)});
        if (this.fmY == null) {
            return;
        }
        if (this.fmY instanceof MMFlipper) {
            ((MMFlipper) this.fmY).nTC = z;
        } else if (this.fmY instanceof CustomViewPager) {
            ((CustomViewPager) this.fmY).CM = z;
        }
    }

    public int agQ() {
        return ViewConfiguration.getLongPressTimeout();
    }

    public final void m(com.tencent.mm.storage.a.c cVar) {
        Object obj = 1;
        synchronized ("lock_refresh") {
            if (this.fmP == null) {
                v.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "mPopImageView is null.");
            } else if (cVar == null) {
                this.fmP.up(com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView.a.lOT);
                v.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "emoji is null. set null");
            } else if (!cVar.EB().equals(this.fna)) {
                this.fmP.up(com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView.a.lOU);
                this.fna = cVar.EB();
                if (!(cVar.field_catalog == com.tencent.mm.storage.a.a.nwK && (cVar.field_content.equals(String.valueOf(com.tencent.mm.storage.a.c.nwQ)) || cVar.field_content.equals(String.valueOf(com.tencent.mm.storage.a.c.nwP))))) {
                    obj = null;
                }
                if (obj != null) {
                    v.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "emoji drawable name is %s", new Object[]{cVar.getName().split("\\.")[0]});
                    int identifier = getResources().getIdentifier(r0, "drawable", aa.getPackageName());
                    PopEmojiView popEmojiView = this.fmP;
                    if (popEmojiView.lOQ != null) {
                        popEmojiView.lOQ.setImageResource(identifier);
                    }
                } else {
                    PopEmojiView popEmojiView2;
                    if (cVar.bxG()) {
                        popEmojiView2 = this.fmP;
                        InputStream ba = com.tencent.mm.storage.a.c.ba(aa.getContext(), cVar.getName());
                        String name = cVar.getName();
                        if (popEmojiView2.lOQ != null) {
                            popEmojiView2.lOQ.a(ba, name);
                        }
                    } else {
                        popEmojiView2 = this.fmP;
                        if (popEmojiView2.lOQ != null) {
                            popEmojiView2.lOQ.a(cVar, "");
                        }
                    }
                    popEmojiView2 = this.fmP;
                    if (popEmojiView2.lOQ != null) {
                        popEmojiView2.lOQ.resume();
                    }
                }
            }
        }
    }

    public final void release() {
        super.release();
        ahS();
        if (this.fmP != null) {
            this.fmP = null;
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ahS();
    }
}
