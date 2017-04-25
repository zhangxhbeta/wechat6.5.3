package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ui.BasePanelKeybordLayout;

public class ChattingUILayout extends BasePanelKeybordLayout {
    private ChatFooterBottom lND;

    public ChattingUILayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private ChatFooterBottom f(ViewGroup viewGroup) {
        if (this.lND != null) {
            return this.lND;
        }
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return this.lND;
        }
        int i = 0;
        while (i < viewGroup.getChildCount()) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ChatFooterBottom) {
                this.lND = (ChatFooterBottom) childAt;
                return this.lND;
            } else if ((childAt instanceof ViewGroup) && f((ViewGroup) childAt) != null) {
                return this.lND;
            } else {
                i++;
            }
        }
        return this.lND;
    }

    protected final View ayB() {
        return f(this);
    }
}
