package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.modelbiz.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public class PickedBottleImageView extends ImageView {
    float density;
    private int etd;
    String eto;
    Bitmap evQ;
    private Paint evR = new Paint();
    private Rect evS = new Rect();
    private RectF evT = new RectF();
    private View evU;
    private Runnable evV = new Runnable(this) {
        final /* synthetic */ PickedBottleImageView evW;

        {
            this.evW = r1;
        }

        public final void run() {
            FrameLayout frameLayout = (FrameLayout) this.evW.getParent();
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.evW.evU.getLayoutParams();
            if (frameLayout != null) {
                marginLayoutParams.setMargins(frameLayout.getWidth() / 2, (frameLayout.getHeight() * 530) / 800, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            this.evW.evU.setLayoutParams(marginLayoutParams);
            this.evW.evU.setVisibility(0);
            this.evW.clearAnimation();
        }
    };
    String evv;
    private ac handler = new ac();
    String iconUrl;

    public PickedBottleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PickedBottleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void show(int i) {
        this.etd = i;
        if (i == 1) {
            setImageResource(2130837744);
            setContentDescription(getContext().getString(2131231528));
            this.evQ = null;
        } else if (i == 3) {
            setImageResource(2130837745);
            setContentDescription(getContext().getString(2131231528));
            this.evQ = null;
        } else if (i == 19990) {
            setImageResource(2130837722);
            this.evQ = j.b(this.eto, this.iconUrl, 2130838793);
            setContentDescription(getContext().getString(2131231528));
            this.evR.setAntiAlias(true);
            update();
        } else {
            setImageResource(2130837743);
            this.evQ = null;
            setContentDescription(getContext().getString(2131231529));
        }
        FrameLayout frameLayout = (FrameLayout) getParent();
        if (this.evU == null) {
            this.evU = ((View) getParent()).findViewById(2131755675);
        }
        this.evU.setVisibility(8);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, (frameLayout.getHeight() * 270) / 800);
        setLayoutParams(marginLayoutParams);
        startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968601));
        this.handler.postDelayed(this.evV, 3000);
        setVisibility(0);
    }

    public void setVisibility(int i) {
        if (i == 8) {
            super.clearAnimation();
        }
        if (i == 8 && this.evU != null) {
            this.handler.removeCallbacks(this.evV);
            this.evU.setVisibility(i);
        }
        super.setVisibility(i);
    }

    final void update() {
        boolean z = true;
        if (this.evQ == null || this.evQ.isRecycled()) {
            this.evQ = BitmapFactory.decodeResource(getResources(), 2130837790);
        }
        Bitmap bitmap = this.evQ;
        Matrix matrix = new Matrix();
        matrix.setRotate(-60.0f, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawBitmap(bitmap, matrix, paint);
        String str = "MicroMsg.PickedBottleImageView";
        StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
        if (createBitmap != null) {
            z = false;
        }
        v.d(str, stringBuilder.append(z).append("  degree:-60.0").toString());
        if (bitmap != createBitmap) {
            bitmap.recycle();
        }
        this.evQ = createBitmap;
        Rect rect = this.evS;
        this.evS.top = 0;
        rect.left = 0;
        this.evS.right = this.evQ.getWidth();
        this.evS.bottom = this.evQ.getHeight();
        this.evT.left = 40.0f * this.density;
        this.evT.top = 30.0f * this.density;
        this.evT.right = 72.0f * this.density;
        this.evT.bottom = 62.0f * this.density;
    }

    protected void onDraw(Canvas canvas) {
        if (!(19990 != this.etd || this.evQ == null || this.evQ.isRecycled())) {
            canvas.drawBitmap(this.evQ, this.evS, this.evT, this.evR);
        }
        super.onDraw(canvas);
    }
}
