package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class PopEmojiView extends LinearLayout {
    private ViewGroup fqb;
    public MMEmojiView lOQ;
    private ProgressBar lOR;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] lOS = new int[a.bqz().length];

        static {
            try {
                lOS[a.lOT - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                lOS[a.lOU - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum a {
        ;

        static {
            lOT = 1;
            lOU = 2;
            lOV = new int[]{lOT, lOU};
        }

        public static int[] bqz() {
            return (int[]) lOV.clone();
        }
    }

    public PopEmojiView(Context context) {
        super(context);
        bqy();
    }

    public PopEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bqy();
    }

    public PopEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bqy();
    }

    private void bqy() {
        this.fqb = (ViewGroup) inflate(getContext(), 2130904170, null);
        this.lOQ = (MMEmojiView) this.fqb.findViewById(2131755052);
        this.lOR = (ProgressBar) this.fqb.findViewById(2131758183);
        addView(this.fqb, -1, -1);
    }

    public final void up(int i) {
        switch (AnonymousClass1.lOS[i - 1]) {
            case 1:
                this.lOQ.setVisibility(4);
                this.lOR.setVisibility(0);
                return;
            case 2:
                this.lOQ.setVisibility(0);
                this.lOR.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
