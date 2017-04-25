package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.EditText;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;

public class EditPreference extends Preference {
    private h iji;
    private com.tencent.mm.ui.base.preference.Preference.a ock;
    a ocp;
    private EditText ocq;
    String value;

    public interface a {
        void bDc();
    }

    public EditPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(com.tencent.mm.ui.base.preference.Preference.a aVar) {
        this.ock = aVar;
    }

    public final void showDialog() {
        View view;
        if (this.ocq != null) {
            view = this.ocq;
        } else {
            view = new EditText(this.mContext);
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.setSingleLine(true);
            view.setText(this.value);
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(2131493135);
            marginLayoutParams.leftMargin = dimensionPixelSize;
            marginLayoutParams.rightMargin = dimensionPixelSize;
            marginLayoutParams.topMargin = dimensionPixelSize;
            marginLayoutParams.bottomMargin = dimensionPixelSize;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.iji = g.a(this.mContext, getTitle().toString(), view, com.tencent.mm.bd.a.O(this.mContext, 2131231107), com.tencent.mm.bd.a.O(this.mContext, 2131231010), new OnClickListener(this) {
            final /* synthetic */ EditPreference ocs;

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.ocs.iji != null) {
                    this.ocs.iji.dismiss();
                }
                this.ocs.value = view.getText().toString();
                if (this.ocs.ocp != null) {
                    this.ocs.ocp.bDc();
                }
                if (this.ocs.ock != null) {
                    this.ocs.ock.a(this.ocs, this.ocs.value);
                }
            }
        }, new OnClickListener(this) {
            final /* synthetic */ EditPreference ocs;

            {
                this.ocs = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.ocs.iji != null) {
                    this.ocs.iji.dismiss();
                }
            }
        });
    }
}
