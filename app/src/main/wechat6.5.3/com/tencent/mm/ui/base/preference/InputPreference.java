package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class InputPreference extends Preference {
    private String khd;
    private a khg;
    private OnClickListener khj;
    private String ocJ;
    private EditText ocK;
    private Button ocL;
    private OnEditorActionListener ocM;

    public interface a {
    }

    public InputPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.khj = new OnClickListener(this) {
            final /* synthetic */ InputPreference ocN;

            {
                this.ocN = r1;
            }

            public final void onClick(View view) {
                if (this.ocN.khg != null && this.ocN.ocK != null && this.ocN.ocK.getText() != null) {
                    this.ocN.ocK.getText().toString();
                }
            }
        };
        this.ocM = new OnEditorActionListener(this) {
            final /* synthetic */ InputPreference ocN;

            {
                this.ocN = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 != i || this.ocN.khg == null || this.ocN.ocK == null) {
                    return false;
                }
                if (this.ocN.ocK.getText() != null) {
                    this.ocN.ocK.getText().toString();
                }
                return true;
            }
        };
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.ocK = (EditText) view.findViewById(2131755280);
        this.ocK.setHint(this.khd);
        this.ocK.setOnEditorActionListener(this.ocM);
        this.ocL = (Button) view.findViewById(2131755282);
        this.ocL.setText(this.ocJ);
        this.ocL.setOnClickListener(this.khj);
    }
}
