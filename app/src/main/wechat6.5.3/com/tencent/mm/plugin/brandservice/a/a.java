package com.tencent.mm.plugin.brandservice.a;

import android.content.Context;
import android.os.Looper;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.protocal.c.md;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import java.util.List;

public final class a {
    private static ac cnO = new ac(Looper.getMainLooper());

    public static class a {
        public ImageView dtX;
        public String iconUrl;
        public String username;
    }

    public static BizInfo a(BizInfo bizInfo, md mdVar) {
        if (mdVar != null) {
            bizInfo.field_brandFlag = mdVar.cHq;
            bizInfo.field_brandIconURL = mdVar.cHt;
            bizInfo.field_brandInfo = mdVar.cHs;
            bizInfo.field_extInfo = mdVar.cHr;
        }
        return bizInfo;
    }

    public static Spanned b(Context context, String str, List<String> list) {
        if (be.kS(str)) {
            return null;
        }
        if (context == null || list == null) {
            return new SpannableString(str);
        }
        return h.a(context, str, list);
    }

    public static boolean b(TextView textView, CharSequence charSequence) {
        if (textView == null) {
            return false;
        }
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setVisibility(0);
        textView.setText(charSequence);
        return true;
    }
}
