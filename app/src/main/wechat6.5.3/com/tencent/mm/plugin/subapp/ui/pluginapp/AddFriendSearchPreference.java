package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ui.base.preference.InputPreference.a;
import com.tencent.mm.ui.base.preference.Preference;

public class AddFriendSearchPreference extends Preference {
    private Context context;
    private String khc;
    String khd;
    private OnClickListener khe;
    OnClickListener khf;
    private a khg;
    private TextView khh;
    private TextView khi;
    private OnClickListener khj;

    public AddFriendSearchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AddFriendSearchPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.khc = "";
        this.khd = "";
        this.khe = null;
        this.khf = null;
        this.khg = null;
        this.khh = null;
        this.khi = null;
        this.khj = new OnClickListener(this) {
            final /* synthetic */ AddFriendSearchPreference khk;

            {
                this.khk = r1;
            }

            public final void onClick(View view) {
                if (this.khk.khg != null && this.khk.khh != null && this.khk.khh.getText() != null) {
                    this.khk.khh.getText().toString();
                }
            }
        };
        this.context = context;
        setLayoutResource(2130903996);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130904009, viewGroup2);
        viewGroup2.setPadding(0, viewGroup2.getPaddingTop(), 0, viewGroup2.getPaddingBottom());
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        view.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ AddFriendSearchPreference khk;

            {
                this.khk = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.khh = (TextView) view.findViewById(2131755280);
        this.khi = (TextView) view.findViewById(2131758241);
        this.khi.setText(this.khd);
        if (this.khf != null) {
            this.khi.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ AddFriendSearchPreference khk;

                {
                    this.khk = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        this.khk.khf.onClick(view);
                    }
                    return true;
                }
            });
        }
        if (this.khg != null) {
            Button button = (Button) view.findViewById(2131755282);
            button.setOnClickListener(this.khj);
            button.setVisibility(0);
        }
    }
}
