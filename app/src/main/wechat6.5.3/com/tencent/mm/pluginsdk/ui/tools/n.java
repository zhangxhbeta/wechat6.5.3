package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.v;

public final class n {
    private static int lUx = -1;

    public static void a(final View view, VideoSightView videoSightView) {
        if (view == null || videoSightView == null) {
            v.e("VideoSightHelper", "null view object " + view + "," + videoSightView);
        } else if (view.getVisibility() == 0) {
            videoSightView.addOnLayoutChangeListener(new OnLayoutChangeListener() {
                public final void onLayoutChange(final View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    int i9 = i4 - i2;
                    int i10 = i8 - i6;
                    if (i9 > 0 && i10 != i9) {
                        view.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 lUz;

                            public final void run() {
                                int height = (view.getResources().getDisplayMetrics().heightPixels - view.getHeight()) >>> 1;
                                int height2 = (int) ((((double) height) / 1.618d) - ((double) (view.getHeight() >>> 1)));
                                if (height2 >= 0) {
                                    if (n.lUx < 0) {
                                        n.lUx = b.a(view.getContext(), 20.0f);
                                    }
                                    if ((view.getHeight() + height2) + n.lUx > height) {
                                        height = height2 - (((view.getHeight() + height2) + n.lUx) - height);
                                    } else {
                                        height = height2;
                                    }
                                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                                    if (height > 0 && height != layoutParams.bottomMargin) {
                                        v.i("VideoSightHelper", "setting tip marginBottom " + height);
                                        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, height);
                                        view.setLayoutParams(layoutParams);
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }
    }
}
