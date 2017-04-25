package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.Preference;

public final class e extends Preference {
    private Context context;
    private TextView dtB;
    private TextView hWl;
    private OnTouchListener hsc;
    private final int iyA = 5;
    private TextView iyB;
    public boolean iyC = false;
    public boolean iyD = false;
    private Boolean iyE;
    private OnGlobalLayoutListener iyF;
    a iyG;
    String mTitle;
    private View mView;

    public interface a {
        void a(String str, Boolean bool);

        void aLy();

        Boolean yQ(String str);
    }

    public e(Activity activity) {
        super(activity);
        setLayoutResource(2130904037);
        this.context = activity;
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.dtB == null) {
            this.dtB = (TextView) view.findViewById(16908310);
        }
        if (this.hWl == null) {
            this.hWl = (TextView) view.findViewById(16908304);
        }
        if (this.iyB == null) {
            this.iyB = (TextView) view.findViewById(2131758276);
        }
        if (this.hsc == null) {
            this.hsc = new OnTouchListener(this) {
                final /* synthetic */ e iyH;

                {
                    this.iyH = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        v.d("MicroMsg.scanner.PlainTextPreference", "moreTv onTouch");
                        this.iyH.iyB.setVisibility(4);
                        this.iyH.hWl.setMaxLines(2000);
                        this.iyH.iyC = true;
                        if (this.iyH.iyG != null) {
                            this.iyH.iyG.a(this.iyH.dnU, Boolean.valueOf(true));
                            this.iyH.iyG.aLy();
                        }
                    }
                    return false;
                }
            };
            this.iyB.setOnTouchListener(this.hsc);
        }
        if (this.iyG != null) {
            this.iyE = this.iyG.yQ(this.dnU);
            if (this.iyE == null) {
                this.iyB.setVisibility(8);
                this.hWl.setMaxLines(6);
            } else if (this.iyE.booleanValue()) {
                this.iyB.setVisibility(8);
                this.hWl.setMaxLines(2000);
            } else {
                this.iyB.setVisibility(0);
                this.hWl.setMaxLines(5);
            }
        } else {
            this.iyB.setVisibility(8);
            this.hWl.setMaxLines(6);
        }
        if (this.iyF == null) {
            this.iyF = new OnGlobalLayoutListener(this) {
                final /* synthetic */ e iyH;

                {
                    this.iyH = r1;
                }

                public final void onGlobalLayout() {
                    v.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() = " + this.iyH.hWl.getHeight() + ", summaryTv.getLineHeight() = " + this.iyH.hWl.getLineHeight());
                    if (this.iyH.hWl.getText() != null && this.iyH.hWl.getHeight() > 0 && this.iyH.hWl.getLineHeight() > 0 && this.iyH.iyE == null) {
                        if (!(this.iyH.hWl.getHeight() / this.iyH.hWl.getLineHeight() <= 5 || this.iyH.iyD || this.iyH.iyC)) {
                            this.iyH.iyB.setVisibility(0);
                            this.iyH.hWl.setMaxLines(5);
                            this.iyH.iyD = true;
                            if (this.iyH.iyG != null && this.iyH.iyG.yQ(this.iyH.dnU) == null) {
                                this.iyH.iyG.a(this.iyH.dnU, Boolean.valueOf(false));
                                this.iyH.iyG.aLy();
                            }
                        }
                        v.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() / summaryTv.getLineHeight() = " + (this.iyH.hWl.getHeight() / this.iyH.hWl.getLineHeight()));
                    }
                    this.iyH.hWl.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            };
            this.hWl.getViewTreeObserver().addOnGlobalLayoutListener(this.iyF);
        }
        if (be.kS(this.mTitle)) {
            this.dtB.setVisibility(8);
            return;
        }
        this.dtB.setText(this.mTitle);
        this.dtB.setVisibility(0);
    }
}
