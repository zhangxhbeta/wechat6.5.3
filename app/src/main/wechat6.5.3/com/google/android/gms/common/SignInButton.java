package com.google.android.gms.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.R;
import com.google.android.gms.b.c.a;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.internal.zzab;

public final class SignInButton extends FrameLayout implements OnClickListener {
    private View aky;
    private OnClickListener akz;
    private int hO;
    private int sc;

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        int o;
        super(context, attributeSet, i);
        this.akz = null;
        w.a(true, "Unknown button size %d", new Object[]{Integer.valueOf(0)});
        w.a(true, "Unknown color scheme %s", new Object[]{Integer.valueOf(0)});
        this.hO = 0;
        this.sc = 0;
        Context context2 = getContext();
        if (this.aky != null) {
            removeView(this.aky);
        }
        try {
            this.aky = b.a(context2, this.hO, this.sc);
        } catch (a e) {
            int i2 = this.hO;
            int i3 = this.sc;
            View com_google_android_gms_common_internal_zzab = new zzab(context2);
            Resources resources = context2.getResources();
            boolean z = i2 >= 0 && i2 < 3;
            w.a(z, "Unknown button size %d", new Object[]{Integer.valueOf(i2)});
            z = i3 >= 0 && i3 < 2;
            w.a(z, "Unknown color scheme %s", new Object[]{Integer.valueOf(i3)});
            com_google_android_gms_common_internal_zzab.setTypeface(Typeface.DEFAULT_BOLD);
            com_google_android_gms_common_internal_zzab.setTextSize(14.0f);
            float f = resources.getDisplayMetrics().density;
            com_google_android_gms_common_internal_zzab.setMinHeight((int) ((48.0f * f) + 0.5f));
            com_google_android_gms_common_internal_zzab.setMinWidth((int) ((f * 48.0f) + 0.5f));
            switch (i2) {
                case 0:
                case 1:
                    o = zzab.o(i3, R.drawable.common_signin_btn_text_dark, R.drawable.common_signin_btn_text_light);
                    break;
                case 2:
                    o = zzab.o(i3, R.drawable.common_signin_btn_icon_dark, R.drawable.common_signin_btn_icon_light);
                    break;
                default:
                    throw new IllegalStateException("Unknown button size: " + i2);
            }
            if (o == -1) {
                throw new IllegalStateException("Could not find background resource!");
            }
            com_google_android_gms_common_internal_zzab.setBackgroundDrawable(resources.getDrawable(o));
            com_google_android_gms_common_internal_zzab.setTextColor(resources.getColorStateList(zzab.o(i3, R.color.common_signin_btn_text_dark, R.color.common_signin_btn_text_light)));
            switch (i2) {
                case 0:
                    com_google_android_gms_common_internal_zzab.setText(resources.getString(R.string.common_signin_button_text));
                    break;
                case 1:
                    com_google_android_gms_common_internal_zzab.setText(resources.getString(R.string.common_signin_button_text_long));
                    break;
                case 2:
                    com_google_android_gms_common_internal_zzab.setText(null);
                    break;
                default:
                    throw new IllegalStateException("Unknown button size: " + i2);
            }
            this.aky = com_google_android_gms_common_internal_zzab;
        }
        addView(this.aky);
        this.aky.setEnabled(isEnabled());
        this.aky.setOnClickListener(this);
    }

    public final void onClick(View view) {
        if (this.akz != null && view == this.aky) {
            this.akz.onClick(this);
        }
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.aky.setEnabled(z);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.akz = onClickListener;
        if (this.aky != null) {
            this.aky.setOnClickListener(this);
        }
    }
}
