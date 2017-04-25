package com.tencent.mm.ui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.bf.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.a.c;
import java.util.ArrayList;
import java.util.List;

public class FTSEditTextView extends LinearLayout {
    private ImageButton fPX;
    public List<com.tencent.mm.ui.widget.d.b> jTC;
    private String lPG;
    public EditText ocq;
    private TextView pbo;
    private TextView pbp;
    private TextView pbq;
    private OnClickListener pbr = new OnClickListener(this) {
        final /* synthetic */ FTSEditTextView pbu;

        {
            this.pbu = r1;
        }

        public final void onClick(View view) {
            int i = -1;
            switch (view.getId()) {
                case 2131757164:
                    i = 0;
                    break;
                case 2131757165:
                    i = 1;
                    break;
                case 2131757166:
                    i = 2;
                    break;
            }
            if (this.pbu.pbs != null && i >= 0) {
                a f = this.pbu.pbs;
                this.pbu.jTC.get(i);
                f.bkU();
            }
        }
    };
    public a pbs;
    private b pbt = b.UserInput;

    public interface a {
        boolean Si();

        void a(String str, String str2, List<com.tencent.mm.ui.widget.d.b> list, b bVar);

        void bkU();

        void bkV();

        void hD(boolean z);
    }

    public enum b {
        UserInput,
        ClearText,
        SetText
    }

    static /* synthetic */ void d(FTSEditTextView fTSEditTextView) {
        String bkS = fTSEditTextView.bkS();
        if (fTSEditTextView.pbs != null) {
            fTSEditTextView.pbs.a(fTSEditTextView.bkR(), bkS, fTSEditTextView.jTC, fTSEditTextView.pbt);
        }
        if (bkS.length() == 0) {
            fTSEditTextView.ocq.setHint(fTSEditTextView.lPG);
        }
        if (bkS.length() > 0 || fTSEditTextView.jTC.size() > 0) {
            fTSEditTextView.fPX.setVisibility(0);
        } else {
            fTSEditTextView.fPX.setVisibility(8);
        }
    }

    public FTSEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public FTSEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(2130903679, this, true);
        this.ocq = (EditText) findViewById(2131755280);
        this.fPX = (ImageButton) findViewById(2131757141);
        this.pbo = (TextView) findViewById(2131757164);
        this.pbp = (TextView) findViewById(2131757165);
        this.pbq = (TextView) findViewById(2131757166);
        this.jTC = new ArrayList();
        this.ocq.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ FTSEditTextView pbu;

            {
                this.pbu = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && 67 == i) {
                    int selectionStart = this.pbu.ocq.getSelectionStart();
                    int selectionEnd = this.pbu.ocq.getSelectionEnd();
                    if (selectionStart == 0 && selectionEnd == 0 && this.pbu.jTC.size() > 0) {
                        this.pbu.jTC.remove(this.pbu.jTC.size() - 1);
                        this.pbu.bKg();
                        FTSEditTextView.d(this.pbu);
                    }
                }
                return false;
            }
        });
        this.ocq.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ FTSEditTextView pbu;

            {
                this.pbu = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (this.pbu.bkR().length() > 0) {
                    this.pbu.fPX.setVisibility(0);
                } else {
                    this.pbu.fPX.setVisibility(8);
                }
                FTSEditTextView.d(this.pbu);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.ocq.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ FTSEditTextView pbu;

            {
                this.pbu = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (this.pbu.pbs != null) {
                    this.pbu.pbs.hD(z);
                }
            }
        });
        this.ocq.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ FTSEditTextView pbu;

            {
                this.pbu = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 != i || this.pbu.pbs == null) {
                    return false;
                }
                return this.pbu.pbs.Si();
            }
        });
        this.pbo.setOnClickListener(this.pbr);
        this.pbp.setOnClickListener(this.pbr);
        this.pbq.setOnClickListener(this.pbr);
        this.fPX.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FTSEditTextView pbu;

            {
                this.pbu = r1;
            }

            public final void onClick(View view) {
                this.pbu.pbt = b.ClearText;
                this.pbu.jTC.clear();
                this.pbu.ocq.setText("");
                this.pbu.fPX.setVisibility(8);
                this.pbu.bKg();
                this.pbu.pbt = b.UserInput;
                if (this.pbu.pbs != null) {
                    this.pbu.pbs.bkV();
                }
            }
        });
        c.b(this.ocq).yn(100).a(null);
    }

    public final void n(String str, List<com.tencent.mm.ui.widget.d.b> list) {
        this.jTC.clear();
        if (list != null) {
            this.jTC.addAll(list);
        }
        v.i("MicroMsg.FTS.FTSEditTextView", "setText: %s %d", new Object[]{str, Integer.valueOf(this.jTC.size())});
        this.pbt = b.SetText;
        this.ocq.setText(str);
        Selection.setSelection(this.ocq.getText(), this.ocq.getText().length());
        bKg();
        this.pbt = b.UserInput;
    }

    public final void bKf() {
        this.ocq.requestFocus();
    }

    public final void BZ(String str) {
        this.ocq.setHint(str);
        this.lPG = str;
    }

    private void bKg() {
        v.i("MicroMsg.FTS.FTSEditTextView", "updateTagView %s", new Object[]{Integer.valueOf(this.jTC.size())});
        float N = (float) com.tencent.mm.bd.a.N(getContext(), 2131493169);
        if (this.jTC.size() > 0) {
            this.pbo.setVisibility(0);
            this.pbo.setText(g.buU().c(getContext(), ((com.tencent.mm.ui.widget.d.b) this.jTC.get(0)).getTagName(), N));
        } else {
            this.pbo.setVisibility(8);
        }
        if (this.jTC.size() >= 2) {
            this.pbp.setVisibility(0);
            this.pbp.setText(g.buU().c(getContext(), ((com.tencent.mm.ui.widget.d.b) this.jTC.get(1)).getTagName(), N));
        } else {
            this.pbp.setVisibility(8);
        }
        if (this.jTC.size() >= 3) {
            this.pbq.setVisibility(0);
            this.pbq.setText(g.buU().c(getContext(), ((com.tencent.mm.ui.widget.d.b) this.jTC.get(2)).getTagName(), N));
            return;
        }
        this.pbq.setVisibility(8);
    }

    public final String bkS() {
        return this.ocq.getText().toString().trim();
    }

    public final String bkR() {
        StringBuffer stringBuffer = new StringBuffer();
        for (com.tencent.mm.ui.widget.d.b tagName : this.jTC) {
            stringBuffer.append(tagName.getTagName());
            stringBuffer.append(" ");
        }
        stringBuffer.append(this.ocq.getText().toString());
        stringBuffer.trimToSize();
        return stringBuffer.toString();
    }
}
