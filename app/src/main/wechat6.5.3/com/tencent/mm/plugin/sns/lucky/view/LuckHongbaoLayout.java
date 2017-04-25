package com.tencent.mm.plugin.sns.lucky.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.wallet_core.ui.e;
import java.util.Random;

public class LuckHongbaoLayout extends LinearLayout {
    private View jia;
    private TextView jib;
    EditText jic;
    private int jid = 0;
    private double jie = 0.0d;
    private Random random = new Random();

    public LuckHongbaoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LuckHongbaoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View.inflate(getContext(), 2130903880, this);
        this.jia = findViewById(2131757752);
        View findViewById = this.jia.findViewById(2131757899);
        this.jic = (EditText) this.jia.findViewById(2131757849);
        this.jic.setKeyListener(new DigitsKeyListener(false, false));
        this.jib = (TextView) findViewById(2131757753);
        findViewById.setVisibility(8);
        this.jic.setHint(2131233595);
        this.jic.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ LuckHongbaoLayout jif;

            {
                this.jif = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                int KL = be.KL(this.jif.jic.getText().toString());
                if (this.jif.jid != KL) {
                    this.jif.random.setSeed(System.currentTimeMillis());
                    this.jif.jie = (double) (((float) KL) * ((1.0f * ((float) this.jif.random.nextInt(10))) / 100.0f));
                    if (this.jif.jie == 0.0d) {
                        this.jif.jib.setText(2131233593);
                        return;
                    }
                    this.jif.jib.setText(this.jif.getContext().getResources().getString(2131233594, new Object[]{e.m(this.jif.jie)}));
                }
            }
        });
    }
}
