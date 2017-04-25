package com.tencent.mm.ui.widget;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.smtt.sdk.WebView;

public final class a extends i implements OnGestureListener, OnTouchListener {
    private int fjS;
    private int iD;
    private int oYZ = 0;
    boolean oZa = true;
    boolean oZb = false;
    private boolean oZc = false;
    private GestureDetector oZd;
    private GestureDetector oZe;
    private int oZf = -1;
    private int oZg = -1;
    private int oZh = -1;
    private int[] oZi = new int[2];
    private int oZj;
    private int oZk;
    private int oZl;
    private int oZm;
    private boolean oZn = false;
    private float oZo = 500.0f;
    private int oZp;
    private int oZq;
    private int oZr;
    private boolean oZs;
    private DragSortListView oZt;
    private int oZu;
    private OnGestureListener oZv = new SimpleOnGestureListener(this) {
        final /* synthetic */ a oZw;

        {
            this.oZw = r1;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (this.oZw.oZb && this.oZw.oZc) {
                int width = this.oZw.oZt.getWidth() / 5;
                if (f > this.oZw.oZo) {
                    if (this.oZw.oZu > (-width)) {
                        this.oZw.oZt.ai(f);
                    }
                } else if (f < (-this.oZw.oZo) && this.oZw.oZu < width) {
                    this.oZw.oZt.ai(f);
                }
                this.oZw.oZc = false;
            }
            return false;
        }
    };

    public a(DragSortListView dragSortListView, int i, int i2, int i3, int i4, int i5) {
        super(dragSortListView);
        this.oZt = dragSortListView;
        this.oZd = new GestureDetector(dragSortListView.getContext(), this);
        this.oZe = new GestureDetector(dragSortListView.getContext(), this.oZv);
        this.oZe.setIsLongpressEnabled(false);
        this.iD = ViewConfiguration.get(dragSortListView.getContext()).getScaledTouchSlop();
        this.oZp = i;
        this.oZq = i4;
        this.oZr = i5;
        this.fjS = i3;
        this.oYZ = i2;
    }

    private boolean U(int i, int i2, int i3) {
        int i4;
        int i5;
        boolean z = false;
        if (!this.oZa || this.oZc) {
            i4 = 0;
        } else {
            i4 = 12;
        }
        if (this.oZb && this.oZc) {
            i5 = (i4 | 1) | 2;
        } else {
            i5 = i4;
        }
        DragSortListView dragSortListView = this.oZt;
        int headerViewsCount = i - this.oZt.getHeaderViewsCount();
        if (dragSortListView.pam && dragSortListView.pan != null) {
            View yu = dragSortListView.pan.yu(headerViewsCount);
            if (yu != null) {
                z = dragSortListView.a(headerViewsCount, yu, i5, i2, i3);
            }
        }
        this.oZn = z;
        return this.oZn;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.oZt.oZQ && !this.oZt.paD) {
            this.oZd.onTouchEvent(motionEvent);
            if (this.oZb && this.oZn && this.fjS == 1) {
                this.oZe.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA) {
                case 0:
                    this.oZl = (int) motionEvent.getX();
                    this.oZm = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.oZb && this.oZc) {
                        int i;
                        if (this.oZu >= 0) {
                            i = this.oZu;
                        } else {
                            i = -this.oZu;
                        }
                        if (i > this.oZt.getWidth() / 2) {
                            this.oZt.ai(0.0f);
                            break;
                        }
                    }
                    break;
                case 3:
                    break;
                default:
                    break;
            }
            this.oZc = false;
            this.oZn = false;
        }
        return false;
    }

    public final void d(Point point) {
        if (this.oZb && this.oZc) {
            this.oZu = point.x;
        }
    }

    private int k(MotionEvent motionEvent, int i) {
        int pointToPosition = this.oZt.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.oZt.getHeaderViewsCount();
        int footerViewsCount = this.oZt.getFooterViewsCount();
        int count = this.oZt.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            View childAt = this.oZt.getChildAt(pointToPosition - this.oZt.getFirstVisiblePosition());
            count = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View findViewById = i == 0 ? childAt : childAt.findViewById(i);
            if (findViewById != null) {
                findViewById.getLocationOnScreen(this.oZi);
                if (count > this.oZi[0] && rawY > this.oZi[1] && count < this.oZi[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.oZi[1]) {
                        this.oZj = childAt.getLeft();
                        this.oZk = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        int i = -1;
        if (this.oZb && this.fjS == 0) {
            this.oZh = k(motionEvent, this.oZq);
        }
        this.oZf = k(motionEvent, this.oZp);
        if (this.oZf != -1 && this.oYZ == 0) {
            U(this.oZf, ((int) motionEvent.getX()) - this.oZj, ((int) motionEvent.getY()) - this.oZk);
        }
        this.oZc = false;
        this.oZs = true;
        this.oZu = 0;
        if (this.fjS == 1) {
            i = k(motionEvent, this.oZr);
        }
        this.oZg = i;
        return true;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int x2 = (int) motionEvent2.getX();
        int y2 = (int) motionEvent2.getY();
        int i = x2 - this.oZj;
        int i2 = y2 - this.oZk;
        if (!(!this.oZs || this.oZn || (this.oZf == -1 && this.oZg == -1))) {
            if (this.oZf != -1) {
                if (this.oYZ == 1 && Math.abs(y2 - y) > this.iD && this.oZa) {
                    U(this.oZf, i, i2);
                } else if (this.oYZ != 0 && Math.abs(x2 - x) > this.iD && this.oZb) {
                    this.oZc = true;
                    U(this.oZg, i, i2);
                }
            } else if (this.oZg != -1) {
                if (Math.abs(x2 - x) > this.iD && this.oZb) {
                    this.oZc = true;
                    U(this.oZg, i, i2);
                } else if (Math.abs(y2 - y) > this.iD) {
                    this.oZs = false;
                }
            }
        }
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        if (this.oZf != -1 && this.oYZ == 2) {
            this.oZt.performHapticFeedback(0);
            U(this.oZf, this.oZl - this.oZj, this.oZm - this.oZk);
        }
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.oZb && this.fjS == 0 && this.oZh != -1) {
            DragSortListView dragSortListView = this.oZt;
            int headerViewsCount = this.oZh - this.oZt.getHeaderViewsCount();
            dragSortListView.paB = false;
            dragSortListView.i(headerViewsCount, 0.0f);
        }
        return true;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }
}
