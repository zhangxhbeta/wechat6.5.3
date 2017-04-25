package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.LinkedList;

public class GameDropdownView extends TextView implements OnClickListener, OnDismissListener {
    private b gsE;
    private LinkedList<String> gsF;
    private int gsG = 0;
    private int gsH = 0;
    a gsI = null;
    View gsJ = null;
    private OnClickListener gsK = new OnClickListener(this) {
        final /* synthetic */ GameDropdownView gsL;

        {
            this.gsL = r1;
        }

        public final void onClick(View view) {
            if (this.gsL.gsE.getContentView() == null || !(this.gsL.gsE.getContentView() instanceof ViewGroup)) {
                this.gsL.gsE.dismiss();
                return;
            }
            GameDropdownView.a(this.gsL, ((ViewGroup) this.gsL.gsE.getContentView()).indexOfChild(view));
            this.gsL.gsE.dismiss();
        }
    };
    private Context mContext;

    public interface a {
        void lA(int i);
    }

    private static class b extends PopupWindow {
        public b(Context context) {
            super(context);
            setWindowLayoutMode(-1, -2);
            setBackgroundDrawable(new BitmapDrawable());
            setFocusable(true);
            setOutsideTouchable(true);
            setTouchInterceptor(new OnTouchListener(this) {
                final /* synthetic */ b gsM;

                {
                    this.gsM = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 4) {
                        return false;
                    }
                    this.gsM.dismiss();
                    return true;
                }
            });
            setAnimationStyle(2130968627);
        }
    }

    static /* synthetic */ void a(GameDropdownView gameDropdownView, int i) {
        if (gameDropdownView.gsE.getContentView() != null && (gameDropdownView.gsE.getContentView() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) gameDropdownView.gsE.getContentView();
            if (i <= gameDropdownView.gsH && gameDropdownView.gsG <= gameDropdownView.gsH && (viewGroup.getChildAt(i) instanceof TextView) && (viewGroup.getChildAt(gameDropdownView.gsG) instanceof TextView)) {
                ((TextView) viewGroup.getChildAt(gameDropdownView.gsG)).setTextColor(gameDropdownView.mContext.getResources().getColor(2131689792));
                ((TextView) viewGroup.getChildAt(i)).setTextColor(gameDropdownView.mContext.getResources().getColor(2131689909));
                gameDropdownView.setText((CharSequence) gameDropdownView.gsF.get(i));
                if (!(gameDropdownView.gsI == null || gameDropdownView.gsG == i)) {
                    gameDropdownView.gsI.lA(i);
                }
                gameDropdownView.gsG = i;
            }
        }
    }

    public GameDropdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.gsE = new b(context);
        setOnClickListener(this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setVisibility(8);
    }

    public void onClick(View view) {
        if (this.gsE.isShowing()) {
            this.gsE.dismiss();
        } else if (this.gsJ == null) {
            this.gsE.showAsDropDown(this);
        } else {
            this.gsE.showAsDropDown(this.gsJ);
        }
    }

    public void onDismiss() {
    }

    public final void b(LinkedList<String> linkedList, int i) {
        if (linkedList.size() != 0) {
            this.gsF = linkedList;
            this.gsH = linkedList.size() - 1;
            if (i < 0 || i > this.gsH) {
                this.gsG = 0;
            } else {
                this.gsG = i;
            }
            LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(2130903733, null);
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                String str = (String) linkedList.get(i2);
                TextView textView = (TextView) layoutInflater.inflate(2130903734, linearLayout, false);
                textView.setText(str);
                textView.setOnClickListener(this.gsK);
                if (i2 == this.gsG) {
                    textView.setTextColor(this.mContext.getResources().getColor(2131689909));
                    setText(str);
                }
                linearLayout.addView(textView);
            }
            this.gsE.setContentView(linearLayout);
            setVisibility(0);
        }
    }
}
