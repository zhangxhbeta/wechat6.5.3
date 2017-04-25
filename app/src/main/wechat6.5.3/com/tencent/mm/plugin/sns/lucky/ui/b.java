package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;

public final class b {
    public static Dialog e(Context context, final View view) {
        View inflate = LayoutInflater.from(context).inflate(2130903879, null);
        String str = u.bsV() ? "font_1.otf" : u.bsW() ? "font_2.otf" : null;
        TextView textView = (TextView) inflate.findViewById(2131757749);
        if (!be.kS(str)) {
            textView.setTypeface(Typeface.createFromAsset(context.getAssets(), str));
        }
        if (!u.bsU()) {
            textView.setTextSize(1, 10.0f);
        }
        final Dialog dialog = new Dialog(context, 2131559263);
        dialog.setContentView(inflate);
        dialog.setTitle(null);
        dialog.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                v.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onCancel");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        ((TextView) inflate.findViewById(2131757751)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                v.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onClick");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                View view2 = view;
                if (view2 != null) {
                    view2.performClick();
                }
            }
        });
        View findViewById = inflate.findViewById(2131757747);
        int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context, 10.0f);
        be.k(findViewById, a, a, a, a);
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                v.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog OnClick: close");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
        return dialog;
    }
}
