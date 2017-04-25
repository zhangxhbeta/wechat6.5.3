package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

public class VoipBigIconButton extends FrameLayout {
    private OnTouchListener dPb = new OnTouchListener(this) {
        final /* synthetic */ VoipBigIconButton kxN;

        {
            this.kxN = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.kxN.fqF.setBackgroundDrawable(this.kxN.kxK);
                    this.kxN.fqF.setImageDrawable(this.kxN.kxM);
                    this.kxN.kG.setTextColor(-855638017);
                    break;
                case 1:
                    this.kxN.fqF.setBackgroundDrawable(this.kxN.kxJ);
                    this.kxN.fqF.setImageDrawable(this.kxN.kxL);
                    this.kxN.kG.setTextColor(-1);
                    break;
            }
            return false;
        }
    };
    private ImageView fqF;
    private TextView kG;
    private Drawable kxJ = null;
    private Drawable kxK = null;
    private Drawable kxL = null;
    private Drawable kxM = null;

    public VoipBigIconButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(2130903852, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.b.aPC, 0, 0);
        try {
            CharSequence string;
            this.kxJ = obtainStyledAttributes.getDrawable(0);
            this.kxK = obtainStyledAttributes.getDrawable(1);
            this.kxL = obtainStyledAttributes.getDrawable(2);
            this.kxM = obtainStyledAttributes.getDrawable(3);
            int resourceId = obtainStyledAttributes.getResourceId(4, -1);
            int resourceId2 = obtainStyledAttributes.getResourceId(4, 0);
            if (resourceId2 != 0) {
                string = getContext().getString(resourceId2);
            } else {
                string = null;
            }
            obtainStyledAttributes.recycle();
            this.kxK = this.kxK == null ? this.kxJ : this.kxK;
            this.kxM = this.kxM == null ? this.kxL : this.kxM;
            this.fqF = (ImageView) findViewById(2131757687);
            this.fqF.setBackgroundDrawable(this.kxJ);
            this.fqF.setImageDrawable(this.kxL);
            this.fqF.setOnTouchListener(this.dPb);
            this.fqF.setContentDescription(string);
            this.kG = (TextView) findViewById(2131757688);
            if (resourceId != -1) {
                this.kG.setText(getContext().getString(resourceId));
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    public void setEnabled(boolean z) {
        this.fqF.setEnabled(z);
        this.kG.setEnabled(z);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.fqF.setOnClickListener(onClickListener);
    }
}
