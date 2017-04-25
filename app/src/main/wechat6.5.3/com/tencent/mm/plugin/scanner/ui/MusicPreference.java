package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.tencent.mm.ui.base.preference.Preference;

public class MusicPreference extends Preference {
    private OnClickListener iqU;
    public String ivK;
    public String ivL;
    public String ivM;
    private ImageButton iyQ;
    private boolean iyR;
    a iyS;
    private View mView;

    public interface a {
        void d(MusicPreference musicPreference);
    }

    public MusicPreference(Context context) {
        this(context, null);
    }

    public MusicPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MusicPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mView = null;
        this.iyQ = null;
        this.ivK = "";
        this.ivL = "";
        this.ivM = "";
        setLayoutResource(2130904057);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    public final void fi(boolean z) {
        this.iyR = z;
        if (this.iyQ == null) {
            return;
        }
        if (z) {
            this.iyQ.setImageResource(2130838908);
        } else {
            this.iyQ.setImageResource(2130838907);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.iqU == null) {
            this.iqU = new OnClickListener(this) {
                final /* synthetic */ MusicPreference iyT;

                {
                    this.iyT = r1;
                }

                public final void onClick(View view) {
                    if (this.iyT.iyS != null && view.getId() == 2131758289) {
                        if (this.iyT.iyR) {
                            this.iyT.iyR = false;
                            this.iyT.iyQ.setImageResource(2130838907);
                        } else {
                            this.iyT.iyR = true;
                            this.iyT.iyQ.setImageResource(2130838908);
                        }
                        this.iyT.iyS.d(this.iyT);
                    }
                }
            };
        }
        this.iyQ = (ImageButton) view.findViewById(2131758289);
        this.iyQ.setOnClickListener(this.iqU);
        if (this.iyR) {
            this.iyQ.setImageResource(2130838908);
        } else {
            this.iyQ.setImageResource(2130838907);
        }
    }
}
