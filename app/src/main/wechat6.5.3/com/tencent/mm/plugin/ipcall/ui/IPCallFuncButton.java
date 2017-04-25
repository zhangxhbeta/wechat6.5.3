package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.be;

public class IPCallFuncButton extends LinearLayout {
    private boolean eBX = false;
    private ImageView gMn;
    private TextView gMo;
    private Drawable gMp;
    private Drawable gMq;
    private Drawable gMr;
    private boolean gMs;
    private boolean gMt = true;
    a gMu;
    private OnTouchListener gMv = new OnTouchListener(this) {
        final /* synthetic */ IPCallFuncButton gMw;

        {
            this.gMw = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.gMw.gMt) {
                if (motionEvent.getAction() == 0) {
                    if (this.gMw.gMs) {
                        if (this.gMw.eBX) {
                            this.gMw.gMn.setImageDrawable(this.gMw.gMp);
                            this.gMw.eBX = false;
                        } else {
                            this.gMw.gMn.setImageDrawable(this.gMw.gMq);
                            this.gMw.eBX = true;
                        }
                        if (this.gMw.gMu != null) {
                            this.gMw.gMu.dO(this.gMw.eBX);
                        }
                    } else if (this.gMw.gMq != null) {
                        this.gMw.gMn.setImageDrawable(this.gMw.gMq);
                    }
                } else if ((motionEvent.getAction() == 3 || motionEvent.getAction() == 1) && !this.gMw.gMs) {
                    if (this.gMw.gMp != null) {
                        this.gMw.gMn.setImageDrawable(this.gMw.gMp);
                    }
                    if (this.gMw.gMu != null) {
                        this.gMw.gMu.dO(false);
                    }
                }
            }
            return false;
        }
    };
    private String text;

    public interface a {
        void dO(boolean z);
    }

    public IPCallFuncButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(2130903823, this);
        this.gMn = (ImageView) findViewById(2131755282);
        this.gMo = (TextView) findViewById(2131755098);
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.b.aPh, 0, 0);
        this.gMp = obtainStyledAttributes.getDrawable(0);
        this.gMq = obtainStyledAttributes.getDrawable(1);
        this.gMs = obtainStyledAttributes.getBoolean(4, false);
        this.gMr = obtainStyledAttributes.getDrawable(2);
        int resourceId = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId != 0) {
            this.text = getContext().getString(resourceId);
        }
        obtainStyledAttributes.recycle();
        if (be.kS(this.text)) {
            this.gMo.setVisibility(8);
        } else {
            this.gMo.setText(this.text);
        }
        if (this.gMp != null) {
            this.gMn.setImageDrawable(this.gMp);
        }
        this.gMn.setClickable(true);
        this.gMn.setOnTouchListener(this.gMv);
    }

    public final boolean isChecked() {
        if (this.gMs) {
            return this.eBX;
        }
        return false;
    }

    public final void dN(boolean z) {
        if (z != this.gMt) {
            this.gMt = z;
            if (this.gMt || this.gMr == null) {
                this.gMn.setImageDrawable(this.gMp);
            } else {
                this.gMn.setImageDrawable(this.gMr);
            }
            this.eBX = false;
        }
    }

    public final void setChecked(boolean z) {
        if (z != this.eBX && this.gMs) {
            this.eBX = z;
            if (this.eBX) {
                this.gMn.setImageDrawable(this.gMq);
            } else {
                this.gMn.setImageDrawable(this.gMp);
            }
        }
    }
}
