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

public class VoipSmallIconButton extends FrameLayout {
    private OnTouchListener dPb = new OnTouchListener(this) {
        final /* synthetic */ VoipSmallIconButton kxO;

        {
            this.kxO = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.kxO.fqF.setImageDrawable(this.kxO.kxM);
                    this.kxO.kG.setTextColor(-855638017);
                    break;
                case 1:
                    this.kxO.fqF.setImageDrawable(this.kxO.kxL);
                    this.kxO.kG.setTextColor(-1);
                    break;
            }
            return false;
        }
    };
    private ImageView fqF;
    private TextView kG;
    private Drawable kxL = null;
    private Drawable kxM = null;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.fqF.setOnClickListener(onClickListener);
    }

    public VoipSmallIconButton(Context context, AttributeSet attributeSet) {
        CharSequence charSequence = 0;
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(2130903853, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.b.aPC, 0, 0);
        try {
            this.kxL = obtainStyledAttributes.getDrawable(2);
            this.kxM = obtainStyledAttributes.getDrawable(3);
            charSequence = obtainStyledAttributes.getString(4);
            int resourceId = obtainStyledAttributes.getResourceId(4, -1);
            this.fqF = (ImageView) findViewById(2131757689);
            this.fqF.setImageDrawable(this.kxL);
            this.fqF.setOnTouchListener(this.dPb);
            this.fqF.setContentDescription(charSequence);
            this.kG = (TextView) findViewById(2131757690);
            if (resourceId != -1) {
                this.kG.setText(getContext().getString(resourceId));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setEnabled(boolean z) {
        this.fqF.setEnabled(z);
        this.kG.setEnabled(z);
    }
}
