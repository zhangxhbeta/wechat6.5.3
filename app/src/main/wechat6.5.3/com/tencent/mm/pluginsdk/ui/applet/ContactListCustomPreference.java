package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactListCustomPreference extends Preference {
    int background = -1;
    OnClickListener iqU;
    private final OnTouchListener lKB = new OnTouchListener(this) {
        final /* synthetic */ ContactListCustomPreference lKC;

        {
            this.lKC = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    private View lks;

    public ContactListCustomPreference(Context context) {
        super(context);
        setLayoutResource(2130904006);
    }

    public ContactListCustomPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutResource(2130904006);
    }

    public ContactListCustomPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(2130904006);
    }

    public final void setCustomView(View view) {
        if (view != null) {
            this.lks = view;
        }
    }

    public final void onBindView(View view) {
        ViewGroup viewGroup = (ViewGroup) view;
        if (!(this.lks == null || this.lks == null)) {
            viewGroup.removeAllViews();
            if (this.lks.getParent() != null) {
                ((ViewGroup) this.lks.getParent()).removeAllViews();
            }
            viewGroup.addView(this.lks);
            if (this.iqU != null) {
                viewGroup.setOnClickListener(this.iqU);
            } else {
                viewGroup.setOnTouchListener(this.lKB);
            }
        }
        if (this.background >= 0) {
            view.setBackgroundResource(this.background);
        }
    }
}
