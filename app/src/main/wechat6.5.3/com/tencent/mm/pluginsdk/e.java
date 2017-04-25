package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.mm.compatible.util.a;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.k;
import com.tencent.mmdb.FileUtils;

public final class e {
    public static int da(Context context) {
        int height;
        if (context instanceof MMActivity) {
            k kVar = ((MMActivity) context).nDR;
            height = kVar.FG == null ? 0 : kVar.FG.getHeight();
        } else {
            height = 0;
        }
        if (height <= 0) {
            return context.getResources().getDimensionPixelSize(2131493015);
        }
        return height;
    }

    public static void N(Activity activity) {
        if (VERSION.SDK_INT < 16) {
            return;
        }
        if (activity instanceof AppCompatActivity) {
            ((AppCompatActivity) activity).aq(MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM);
        } else {
            activity.requestWindowFeature(9);
        }
    }

    public static void f(MMActivity mMActivity) {
        if (VERSION.SDK_INT >= 16) {
            mMActivity.aq(MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM);
        }
    }

    public static void g(final MMActivity mMActivity) {
        if (VERSION.SDK_INT >= 16) {
            mMActivity.getWindow().getDecorView().post(new Runnable() {
                public final void run() {
                    mMActivity.getWindow().getDecorView().setSystemUiVisibility(mMActivity.getWindow().getDecorView().getSystemUiVisibility() | FileUtils.S_IRUSR);
                    v.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to bodyView, height: %s", Integer.valueOf(a.e(mMActivity)));
                    mMActivity.nDR.nDX.setPadding(0, r0 - com.tencent.mm.bd.a.fromDPToPix(mMActivity, 2), 0, 0);
                }
            });
        }
    }

    public static void a(final MMFragmentActivity mMFragmentActivity, final View view) {
        if (VERSION.SDK_INT >= 16) {
            mMFragmentActivity.getWindow().getDecorView().post(new Runnable() {
                public final void run() {
                    mMFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(mMFragmentActivity.getWindow().getDecorView().getSystemUiVisibility() | FileUtils.S_IRUSR);
                    v.i("MicroMsg.FullScreenHelper", "setFullScreenAfterSetContentView to contentView, height: %s", Integer.valueOf(a.e(mMFragmentActivity)));
                    if (view != null) {
                        view.setPadding(0, r0, 0, 0);
                    }
                }
            });
        }
    }

    public static int db(Context context) {
        int X = s.X(context, -1);
        Rect rect;
        if (X > 0) {
            rect = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            return rect.top > X ? 0 : X;
        } else if (!(context instanceof Activity)) {
            return com.tencent.mm.bd.a.fromDPToPix(context, 20);
        } else {
            rect = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            X = ((Activity) context).getWindow().getDecorView().getHeight();
            int[] iArr = new int[2];
            ((Activity) context).getWindow().getDecorView().getLocationOnScreen(iArr);
            if (X - rect.height() < 0 || iArr[1] <= 200) {
                return rect.top;
            }
            return X - rect.height();
        }
    }
}
