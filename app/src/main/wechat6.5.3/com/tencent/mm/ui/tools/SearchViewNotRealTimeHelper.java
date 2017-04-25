package com.tencent.mm.ui.tools;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.ActionBarSearchView.b;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;

public class SearchViewNotRealTimeHelper extends LinearLayout implements f {
    public View oQr;
    private ImageButton oQt;
    private com.tencent.mm.ui.tools.ActionBarSearchView.a oQy;
    public Button oUE;
    public a oUF;
    public EditText ocq;

    public interface a {
        void YC();

        void YD();

        boolean mk(String str);

        void pA(String str);
    }

    public SearchViewNotRealTimeHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SearchViewNotRealTimeHelper(Context context) {
        super(context);
        init();
    }

    private void init() {
        q.em(getContext()).inflate(2130903076, this, true);
        this.ocq = (EditText) findViewById(2131755280);
        this.oQt = (ImageButton) findViewById(2131755281);
        this.oQr = findViewById(2131755276);
        this.oUE = (Button) findViewById(2131755282);
        this.oUE.setEnabled(false);
        this.ocq.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SearchViewNotRealTimeHelper oUG;

            {
                this.oUG = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable == null || editable.length() <= 0) {
                    this.oUG.oQt.setVisibility(8);
                    this.oUG.oUE.setEnabled(false);
                    return;
                }
                this.oUG.oQt.setVisibility(0);
                this.oUG.oUE.setEnabled(true);
            }
        });
        this.ocq.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ SearchViewNotRealTimeHelper oUG;

            {
                this.oUG = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 != i || this.oUG.oUF == null) {
                    return false;
                }
                return this.oUG.oUF.mk(this.oUG.boJ());
            }
        });
        c.b(this.ocq).yn(100).a(null);
        this.oQt.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SearchViewNotRealTimeHelper oUG;

            {
                this.oUG = r1;
            }

            public final void onClick(View view) {
                this.oUG.ocq.setText(SQLiteDatabase.KeyEmpty);
                if (this.oUG.oUF != null) {
                    this.oUG.oUF.YC();
                }
            }
        });
        this.oQr.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SearchViewNotRealTimeHelper oUG;

            {
                this.oUG = r1;
            }

            public final void onClick(View view) {
                v.v("MicroMsg.SearchViewNotRealTimeHelper", "home btn click");
                if (this.oUG.oUF != null) {
                    this.oUG.oUF.YD();
                }
                if (this.oUG.oQy != null) {
                    this.oUG.oQy.bIV();
                }
            }
        });
        this.oUE.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SearchViewNotRealTimeHelper oUG;

            {
                this.oUG = r1;
            }

            public final void onClick(View view) {
                if (this.oUG.oUF != null) {
                    this.oUG.oUF.pA(this.oUG.boJ());
                }
            }
        });
    }

    public final void L(CharSequence charSequence) {
        this.ocq.setHint(charSequence);
    }

    public final void kg(boolean z) {
        this.ocq.setText(SQLiteDatabase.KeyEmpty);
    }

    public final void bIS() {
        this.ocq.clearFocus();
    }

    public final String boJ() {
        Editable editableText = this.ocq.getEditableText();
        return editableText == null ? SQLiteDatabase.KeyEmpty : editableText.toString();
    }

    public final void Pw(String str) {
        this.ocq.setText(SQLiteDatabase.KeyEmpty);
        this.ocq.append(str);
    }

    public final void setHint(CharSequence charSequence) {
        L(charSequence);
    }

    public final void a(b bVar) {
    }

    public final void kd(boolean z) {
    }

    public final void ke(boolean z) {
    }

    public final void kf(boolean z) {
    }

    public final void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
    }

    public final void a(a aVar) {
        this.oUF = aVar;
    }

    public boolean hasFocus() {
        return false;
    }

    public final boolean bIU() {
        return false;
    }

    public final boolean bIT() {
        return false;
    }

    public final void a(com.tencent.mm.ui.tools.ActionBarSearchView.a aVar) {
        this.oQy = aVar;
    }

    public final void ad(ArrayList<String> arrayList) {
    }

    public final void kh(boolean z) {
    }

    public final void yd(int i) {
    }
}
