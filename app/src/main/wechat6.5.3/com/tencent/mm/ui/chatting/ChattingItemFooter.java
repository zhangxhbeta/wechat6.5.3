package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a;
import com.tencent.mm.modelbiz.n;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public class ChattingItemFooter extends LinearLayout implements OnClickListener {
    private static final int[] ooX = new int[]{2130837951, 2130837951, 2130837957, 2130837954};
    private static final int[] ooY = new int[]{2130839003, 2130839007, 2130839012, 2130839009};
    private LayoutInflater CE;
    private String dRA;
    private Context mContext;

    public ChattingItemFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.CE = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public final boolean b(List<a> list, String str, boolean z) {
        if (list == null || list.size() <= 0) {
            v.d("ChattingItemFooter", "no menulist!");
            setVisibility(8);
            return false;
        }
        int[] iArr;
        a aVar;
        TextView a;
        TextView a2;
        this.dRA = str;
        int childCount = getChildCount();
        if (z) {
            iArr = ooY;
        } else {
            iArr = ooX;
        }
        LayoutParams layoutParams = new LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        int size = list.size();
        switch (size) {
            case 1:
                aVar = (a) list.get(0);
                a = a(0, childCount, layoutParams);
                a.setText(aVar.name);
                a.setTag(aVar);
                a.setBackgroundResource(iArr[3]);
                break;
            case 2:
                break;
            case 3:
                aVar = (a) list.get(1);
                a2 = a(1, childCount, layoutParams);
                a2.setText(aVar.name);
                a2.setTag(aVar);
                a2.setBackgroundResource(iArr[1]);
                break;
        }
        aVar = (a) list.get(0);
        a2 = a(0, childCount, layoutParams);
        a2.setText(aVar.name);
        a2.setTag(aVar);
        a2.setBackgroundResource(iArr[0]);
        aVar = (a) list.get(size - 1);
        a = a(size - 1, childCount, layoutParams);
        a.setText(aVar.name);
        a.setTag(aVar);
        a.setBackgroundResource(iArr[2]);
        if (childCount > size && childCount - 1 > 0) {
            removeViews(size, childCount - 1);
        }
        setLongClickable(true);
        setVisibility(0);
        return true;
    }

    private TextView a(int i, int i2, LayoutParams layoutParams) {
        if (i < i2) {
            return (TextView) getChildAt(i);
        }
        TextView textView = (TextView) this.CE.inflate(2130903306, null);
        textView.setLongClickable(false);
        textView.setOnClickListener(this);
        textView.setLayoutParams(layoutParams);
        addView(textView);
        return textView;
    }

    private void d(a aVar) {
        ak.vy().a(new n(this.dRA, 1, aVar.getInfo()), 0);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof a) {
            a aVar = (a) tag;
            switch (aVar.type) {
                case 1:
                    v.d("ChattingItemFooter", "get latest message");
                    aVar.cCl = a.cCg;
                    d(aVar);
                    return;
                case 2:
                    v.d("ChattingItemFooter", "start webview url");
                    aVar.cCl = a.cCg;
                    d(aVar);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", aVar.value);
                    intent.putExtra("showShare", false);
                    intent.putExtra("geta8key_username", this.dRA);
                    c.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                default:
                    return;
            }
        }
    }
}
