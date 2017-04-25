package com.tencent.mm.ui.account;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public final class a extends BaseAdapter {
    private LayoutInflater gwU;
    private String[] nHD;
    private Drawable nHE = null;
    private OnTouchListener nHF = new OnTouchListener(this) {
        final /* synthetic */ a nHG;

        {
            this.nHG = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                ((TextView) view.findViewById(2131755339)).setTextColor(-10395295);
            } else if (motionEvent.getAction() == 1) {
                ((TextView) view.findViewById(2131755339)).setTextColor(-1);
            }
            return false;
        }
    };

    public a(Context context, String[] strArr) {
        this.nHD = strArr;
        this.gwU = LayoutInflater.from(context);
        this.nHE = context.getResources().getDrawable(2130839188);
        this.nHE.setBounds(0, 0, this.nHE.getIntrinsicWidth(), this.nHE.getIntrinsicHeight());
    }

    public final int getCount() {
        return this.nHD.length;
    }

    public final Object getItem(int i) {
        return this.nHD[i];
    }

    private boolean vS(int i) {
        if (i == this.nHD.length - 1) {
            return true;
        }
        return false;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2 = 1;
        if (view == null) {
            view = this.gwU.inflate(2130903092, null);
        }
        TextView textView = (TextView) view.findViewById(2131755339);
        view.setOnTouchListener(this.nHF);
        if ((i == 0 ? 1 : 0) == 0 || !vS(i)) {
            if (i != 0) {
                i2 = 0;
            }
            if (i2 != 0) {
                textView.setPadding(25, 0, 10, 10);
                textView.setCompoundDrawablePadding(10);
                textView.setCompoundDrawables(null, null, this.nHE, null);
            } else if (vS(i)) {
                textView.setPadding(0, 0, 25, 10);
                textView.setCompoundDrawablePadding(0);
                textView.setCompoundDrawables(null, null, null, null);
            } else {
                textView.setPadding(0, 0, 10, 10);
                textView.setCompoundDrawablePadding(10);
                textView.setCompoundDrawables(null, null, this.nHE, null);
            }
        } else {
            textView.setPadding(25, 0, 25, 10);
            textView.setCompoundDrawablePadding(0);
            textView.setCompoundDrawables(null, null, null, null);
        }
        textView.setText(this.nHD[i]);
        return view;
    }
}
