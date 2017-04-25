package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.tencent.smtt.sdk.WebView;

public class PagerTabStrip extends PagerTitleStrip {
    private final Rect ep = new Rect();
    private int iD;
    private int wA;
    private int wB;
    private int wC;
    private int wD;
    private int wE;
    private final Paint wF = new Paint();
    private int wG = WebView.NORMAL_MODE_ALPHA;
    private boolean wH = false;
    private boolean wI = false;
    private int wJ;
    private boolean wK;
    private float wL;
    private float wM;
    private int wz = this.xc;

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.wF.setColor(this.wz);
        float f = context.getResources().getDisplayMetrics().density;
        this.wA = (int) ((3.0f * f) + 0.5f);
        this.wB = (int) ((6.0f * f) + 0.5f);
        this.wC = (int) (64.0f * f);
        this.wE = (int) ((16.0f * f) + 0.5f);
        this.wJ = (int) ((1.0f * f) + 0.5f);
        this.wD = (int) ((f * 32.0f) + 0.5f);
        this.iD = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        V(this.wU);
        setWillNotDraw(false);
        this.wP.setFocusable(true);
        this.wP.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PagerTabStrip wN;

            {
                this.wN = r1;
            }

            public final void onClick(View view) {
                this.wN.wO.Z(this.wN.wO.xB - 1);
            }
        });
        this.wR.setFocusable(true);
        this.wR.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PagerTabStrip wN;

            {
                this.wN = r1;
            }

            public final void onClick(View view) {
                this.wN.wO.Z(this.wN.wO.xB + 1);
            }
        });
        if (getBackground() == null) {
            this.wH = true;
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.wB) {
            i4 = this.wB;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public final void V(int i) {
        if (i < this.wC) {
            i = this.wC;
        }
        super.V(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.wI) {
            this.wH = drawable == null;
        }
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (!this.wI) {
            this.wH = (WebView.NIGHT_MODE_COLOR & i) == 0;
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (!this.wI) {
            this.wH = i == 0;
        }
    }

    final int getMinHeight() {
        return Math.max(super.getMinHeight(), this.wD);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.wK) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.wL = x;
                this.wM = y;
                this.wK = false;
                break;
            case 1:
                if (x >= ((float) (this.wQ.getLeft() - this.wE))) {
                    if (x > ((float) (this.wQ.getRight() + this.wE))) {
                        this.wO.Z(this.wO.xB + 1);
                        break;
                    }
                }
                this.wO.Z(this.wO.xB - 1);
                break;
                break;
            case 2:
                if (Math.abs(x - this.wL) > ((float) this.iD) || Math.abs(y - this.wM) > ((float) this.iD)) {
                    this.wK = true;
                    break;
                }
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.wQ.getLeft() - this.wE;
        int right = this.wQ.getRight() + this.wE;
        int i = height - this.wA;
        this.wF.setColor((this.wG << 24) | (this.wz & 16777215));
        canvas.drawRect((float) left, (float) i, (float) right, (float) height, this.wF);
        if (this.wH) {
            this.wF.setColor(WebView.NIGHT_MODE_COLOR | (this.wz & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.wJ), (float) (getWidth() - getPaddingRight()), (float) height, this.wF);
        }
    }

    final void a(int i, float f, boolean z) {
        Rect rect = this.ep;
        int height = getHeight();
        int i2 = height - this.wA;
        rect.set(this.wQ.getLeft() - this.wE, i2, this.wQ.getRight() + this.wE, height);
        super.a(i, f, z);
        this.wG = (int) ((Math.abs(f - 0.5f) * 2.0f) * 255.0f);
        rect.union(this.wQ.getLeft() - this.wE, i2, this.wQ.getRight() + this.wE, height);
        invalidate(rect);
    }
}
