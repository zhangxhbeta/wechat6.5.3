package android.support.design.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.a.b;
import android.support.design.a.e;
import android.support.design.a.f;
import android.support.design.a.h;
import android.support.design.widget.BottomSheetBehavior.a;
import android.support.v7.app.i;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public final class c extends i {
    private a fr;

    public c(Context context) {
        this(context, (byte) 0);
    }

    private c(Context context, byte b) {
        int i;
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(b.X, typedValue, true)) {
            i = typedValue.resourceId;
        } else {
            i = h.aM;
        }
        super(context, i);
        this.fr = new a(this) {
            final /* synthetic */ c fs;

            {
                this.fs = r1;
            }

            public final void k(int i) {
                if (i == 5) {
                    this.fs.dismiss();
                }
            }

            public final void d(float f) {
            }
        };
        de();
    }

    public final void setContentView(int i) {
        super.setContentView(a(i, null, null));
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
    }

    public final void setContentView(View view) {
        super.setContentView(a(0, view, null));
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(a(0, view, layoutParams));
    }

    private View a(int i, View view, LayoutParams layoutParams) {
        boolean z;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) View.inflate(getContext(), f.ax, null);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, coordinatorLayout, false);
        }
        View view2 = (FrameLayout) coordinatorLayout.findViewById(e.aq);
        BottomSheetBehavior.i(view2).fi = this.fr;
        if (layoutParams == null) {
            view2.addView(view);
        } else {
            view2.addView(view, layoutParams);
        }
        if (VERSION.SDK_INT < 11) {
            z = true;
        } else {
            TypedValue typedValue = new TypedValue();
            z = getContext().getTheme().resolveAttribute(16843611, typedValue, true) ? typedValue.data != 0 : false;
        }
        if (z) {
            coordinatorLayout.findViewById(e.av).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ c fs;

                {
                    this.fs = r1;
                }

                public final void onClick(View view) {
                    if (this.fs.isShowing()) {
                        this.fs.cancel();
                    }
                }
            });
        }
        return coordinatorLayout;
    }
}
