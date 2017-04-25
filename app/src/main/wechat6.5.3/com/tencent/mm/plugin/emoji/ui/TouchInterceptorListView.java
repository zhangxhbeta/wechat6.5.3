package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.v;

public class TouchInterceptorListView extends ListView {
    private int QW;
    private int eZj;
    private Rect ep = new Rect();
    private ImageView fjD;
    private WindowManager fjE;
    private LayoutParams fjF;
    private int fjG;
    private int fjH;
    private int fjI;
    private int fjJ;
    private int fjK;
    private int fjL;
    private a fjM;
    private b fjN;
    private c fjO;
    private int fjP;
    private int fjQ;
    private GestureDetector fjR;
    private int fjS = -1;
    private Bitmap fjT;
    private int fjU;
    private int fjV;
    private Drawable fjW;
    private int fjX = 0;
    private final int iD;

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    public TouchInterceptorListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iD = ViewConfiguration.get(context).getScaledTouchSlop();
        Resources resources = getResources();
        this.eZj = resources.getDimensionPixelSize(2131493431) + 1;
        this.fjV = this.eZj / 2;
        this.fjU = this.eZj * 2;
        this.fjX = resources.getDimensionPixelOffset(2131493437);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.fjO != null && this.fjR == null && this.fjS == 0) {
            this.fjR = new GestureDetector(getContext(), new SimpleOnGestureListener(this) {
                final /* synthetic */ TouchInterceptorListView fjY;

                {
                    this.fjY = r1;
                }

                public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    if (this.fjY.fjD == null) {
                        return false;
                    }
                    if (f > 1000.0f) {
                        Rect b = this.fjY.ep;
                        this.fjY.fjD.getDrawingRect(b);
                        if (motionEvent2.getX() > ((float) ((b.right * 2) / 3))) {
                            this.fjY.ahh();
                            this.fjY.cz(true);
                        }
                    }
                    return true;
                }
            });
        }
        if (!(this.fjM == null && this.fjN == null)) {
            switch (motionEvent.getAction()) {
                case 0:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int pointToPosition = pointToPosition(x, y);
                    if (pointToPosition != -1) {
                        ViewGroup viewGroup = (ViewGroup) getChildAt(pointToPosition - getFirstVisiblePosition());
                        this.fjI = x - viewGroup.getLeft();
                        this.fjJ = y - viewGroup.getTop();
                        this.fjK = ((int) motionEvent.getRawX()) - x;
                        this.fjL = ((int) motionEvent.getRawY()) - y;
                        if (x >= this.fjX) {
                            ahh();
                            break;
                        }
                        viewGroup.setDrawingCacheEnabled(true);
                        Bitmap createBitmap = Bitmap.createBitmap(viewGroup.getDrawingCache());
                        ahh();
                        this.fjF = new LayoutParams();
                        this.fjF.gravity = 49;
                        this.fjF.x = (x - this.fjI) + this.fjK;
                        this.fjF.y = (y - this.fjJ) + this.fjL;
                        this.fjF.height = -2;
                        this.fjF.width = -2;
                        this.fjF.flags = 920;
                        this.fjF.format = -3;
                        this.fjF.windowAnimations = 0;
                        Context context = getContext();
                        View imageView = new ImageView(context);
                        imageView.setBackgroundColor(context.getResources().getColor(2131690127));
                        imageView.setBackgroundResource(2130838174);
                        imageView.setPadding(0, 0, 0, 0);
                        imageView.setImageBitmap(createBitmap);
                        this.fjT = createBitmap;
                        this.fjE = (WindowManager) context.getSystemService("window");
                        this.fjE.addView(imageView, this.fjF);
                        this.fjD = imageView;
                        this.fjG = pointToPosition;
                        this.fjH = this.fjG;
                        this.QW = getHeight();
                        int i = this.iD;
                        this.fjP = Math.min(y - i, this.QW / 3);
                        this.fjQ = Math.max(i + y, (this.QW * 2) / 3);
                        return false;
                    }
                    break;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private int bA(int i, int i2) {
        int bA;
        if (i2 < 0) {
            bA = bA(i, this.eZj + i2);
            if (bA > 0) {
                return bA - 1;
            }
        }
        Rect rect = this.ep;
        for (bA = getChildCount() - 1; bA >= 0; bA--) {
            getChildAt(bA).getHitRect(rect);
            if (rect.contains(i, i2)) {
                return bA + getFirstVisiblePosition();
            }
        }
        return -1;
    }

    private void cz(boolean z) {
        int i = 0;
        while (true) {
            View childAt = getChildAt(i);
            if (childAt == null) {
                if (z) {
                    int firstVisiblePosition = getFirstVisiblePosition();
                    int top = getChildAt(0).getTop();
                    setAdapter(getAdapter());
                    setSelectionFromTop(firstVisiblePosition, top);
                }
                try {
                    layoutChildren();
                    childAt = getChildAt(i);
                } catch (IllegalStateException e) {
                }
                if (childAt == null) {
                    return;
                }
            }
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.height = this.eZj;
            childAt.setLayoutParams(layoutParams);
            childAt.setVisibility(0);
            i++;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 4;
        int i2 = 0;
        if (this.fjR != null) {
            this.fjR.onTouchEvent(motionEvent);
        }
        if ((this.fjM == null && this.fjN == null) || this.fjD == null) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        switch (action) {
            case 0:
            case 2:
                int width;
                int width2;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (this.fjS == 1) {
                    float f = 1.0f;
                    width = this.fjD.getWidth();
                    if (x > width / 2) {
                        f = ((float) (width - x)) / ((float) (width / 2));
                    }
                    this.fjF.alpha = f;
                }
                if (this.fjS == 0 || this.fjS == 2) {
                    this.fjF.x = (x - this.fjI) + this.fjK;
                } else {
                    this.fjF.x = 0;
                }
                this.fjF.y = (y - this.fjJ) + this.fjL;
                this.fjE.updateViewLayout(this.fjD, this.fjF);
                if (this.fjW != null) {
                    width2 = this.fjD.getWidth();
                    if (y > (getHeight() * 3) / 4) {
                        this.fjW.setLevel(2);
                    } else if (width2 <= 0 || x <= width2 / 4) {
                        this.fjW.setLevel(0);
                    } else {
                        this.fjW.setLevel(1);
                    }
                }
                x = (y - this.fjJ) - this.fjV;
                width2 = bA(0, x);
                if (width2 >= 0) {
                    if (width2 <= this.fjH) {
                        width2++;
                    }
                } else if (x < 0) {
                    width2 = 0;
                }
                if (width2 < 0) {
                    return true;
                }
                if (action == 0 || width2 != this.fjG) {
                    this.fjG = width2;
                    v.d("MicroMsg.emoji.TouchInterceptorListView", "doExpansion mDragPos:%d mSrcDragPos:%d", new Object[]{Integer.valueOf(this.fjG), Integer.valueOf(this.fjH)});
                    v.d("MicroMsg.emoji.TouchInterceptorListView", "getFirstVisiblePosition:%d", new Object[]{Integer.valueOf(getFirstVisiblePosition())});
                    v.d("MicroMsg.emoji.TouchInterceptorListView", "getHeaderViewsCount:%d", new Object[]{Integer.valueOf(getHeaderViewsCount())});
                    width = this.fjG - getFirstVisiblePosition();
                    int headerViewsCount = getHeaderViewsCount();
                    View childAt = getChildAt(this.fjH - getFirstVisiblePosition());
                    x = 0;
                    while (true) {
                        View childAt2 = getChildAt(x);
                        if (childAt2 != null) {
                            width2 = this.eZj;
                            if (this.fjG >= headerViewsCount || x != headerViewsCount) {
                                if (childAt2.equals(childAt)) {
                                    if (this.fjG == this.fjH || getPositionForView(childAt2) == getCount()) {
                                        width2 = this.eZj;
                                        v.d("MicroMsg.emoji.TouchInterceptorListView", "2. visibility = View.INVISIBLE");
                                        action = width2;
                                        width2 = 4;
                                    } else {
                                        v.d("MicroMsg.emoji.TouchInterceptorListView", "2. height = 1");
                                        width2 = 0;
                                        action = 1;
                                    }
                                } else if (x != width) {
                                    v.d("MicroMsg.emoji.TouchInterceptorListView", "4");
                                    action = width2;
                                    width2 = 0;
                                } else if (this.fjG < headerViewsCount || this.fjG >= getCount()) {
                                    v.d("MicroMsg.emoji.TouchInterceptorListView", "3. ");
                                    action = width2;
                                    width2 = 0;
                                } else {
                                    width2 = this.fjU;
                                    v.d("MicroMsg.emoji.TouchInterceptorListView", "3. height = mItemHeightExpanded;");
                                    action = width2;
                                    width2 = 0;
                                }
                            } else if (childAt2.equals(childAt)) {
                                v.d("MicroMsg.emoji.TouchInterceptorListView", "1. visibility = View.INVISIBLE");
                                action = width2;
                                width2 = 4;
                            } else {
                                width2 = this.fjU;
                                v.d("MicroMsg.emoji.TouchInterceptorListView", "1. height = mItemHeightExpanded");
                                action = width2;
                                width2 = 0;
                            }
                            ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                            layoutParams.height = action;
                            childAt2.setLayoutParams(layoutParams);
                            childAt2.setVisibility(width2);
                            x++;
                        }
                    }
                }
                if (y >= this.QW / 3) {
                    this.fjP = this.QW / 3;
                }
                if (y <= (this.QW * 2) / 3) {
                    this.fjQ = (this.QW * 2) / 3;
                }
                if (y > this.fjQ) {
                    if (getLastVisiblePosition() < getCount() - 1) {
                        if (y > (this.QW + this.fjQ) / 2) {
                            i = 16;
                        }
                        i2 = i;
                    } else {
                        i2 = 1;
                    }
                } else if (y < this.fjP) {
                    width2 = y < this.fjP / 2 ? -16 : -4;
                    if (getFirstVisiblePosition() != 0 || getChildAt(0).getTop() < getPaddingTop()) {
                        i2 = width2;
                    }
                }
                if (i2 == 0 || f.dX(8)) {
                    return true;
                }
                smoothScrollBy(i2, 30);
                return true;
            case 1:
            case 3:
                Rect rect = this.ep;
                this.fjD.getDrawingRect(rect);
                ahh();
                if (this.fjS != 1 || motionEvent.getX() <= ((float) ((rect.right * 3) / 4))) {
                    if (this.fjN != null && this.fjG >= 0) {
                        getCount();
                    }
                    cz(false);
                    return true;
                }
                cz(true);
                return true;
            default:
                return true;
        }
    }

    private void ahh() {
        if (this.fjD != null) {
            this.fjD.setVisibility(8);
            ((WindowManager) getContext().getSystemService("window")).removeView(this.fjD);
            this.fjD.setImageDrawable(null);
            this.fjD = null;
        }
        if (this.fjT != null) {
            v.i("MicroMsg.emoji.TouchInterceptorListView", "bitmap recycle %s", new Object[]{this.fjT});
            this.fjT.recycle();
            this.fjT = null;
        }
        if (this.fjW != null) {
            this.fjW.setLevel(0);
        }
    }
}
