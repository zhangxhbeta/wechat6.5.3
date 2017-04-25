package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.d.e;
import java.util.LinkedList;

public class GameListSocialView extends LinearLayout {
    public GameListSocialView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    public final void B(LinkedList<String> linkedList) {
        if (linkedList == null || linkedList.size() == 0 || linkedList.size() % 2 != 0) {
            setVisibility(8);
            return;
        }
        int i;
        setVisibility(0);
        if (getChildCount() < linkedList.size() / 2) {
            int size = (linkedList.size() / 2) - getChildCount();
            for (i = 0; i < size; i++) {
                inflate(getContext(), 2130903741, this);
            }
        }
        for (i = 0; i < getChildCount(); i++) {
            if (i < linkedList.size() / 2) {
                getChildAt(i).setVisibility(0);
            } else {
                getChildAt(i).setVisibility(8);
            }
        }
        for (int i2 = 0; i2 < linkedList.size() / 2; i2++) {
            View childAt = getChildAt(i2);
            TextView textView = (TextView) childAt.findViewById(2131757338);
            TextView textView2 = (TextView) childAt.findViewById(2131757339);
            textView.setText(e.a(getContext(), (CharSequence) linkedList.get(i2 * 2), textView.getTextSize()));
            textView2.setText(e.a(getContext(), (CharSequence) linkedList.get((i2 * 2) + 1), textView2.getTextSize()));
        }
    }
}
