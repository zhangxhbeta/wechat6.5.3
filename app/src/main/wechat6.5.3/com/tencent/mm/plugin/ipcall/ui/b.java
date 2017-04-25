package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;

public final class b {
    MMActivity aWn;
    String ctB;
    TextView duy;
    a gIW;
    private DialPad gIX;
    TextView gIY;
    EditText gIZ;
    View gJa;
    private ImageButton gJb;
    View gJc;
    TextView gJd;
    private al gJe;
    String gJf;
    String gJg;
    String gJh = "";
    String gJi;
    long gJj = 0;
    boolean gJk = false;
    private Runnable gJl = new Runnable(this) {
        final /* synthetic */ b gJq;

        {
            this.gJq = r1;
        }

        public final void run() {
            if (System.currentTimeMillis() - this.gJq.gJj >= 500) {
                this.gJq.gJi = com.tencent.mm.plugin.ipcall.b.a.aa(this.gJq.aWn, this.gJq.gJg + this.gJq.gJh);
                final c uK = i.aur().uK(this.gJq.gJi);
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 gJs;

                    public final void run() {
                        if (uK == null || uK.nmb == -1) {
                            this.gJs.gJq.duy.setText("");
                        } else {
                            this.gJs.gJq.duy.setText(uK.field_systemAddressBookUsername);
                        }
                    }
                });
                return;
            }
            ad.o(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 gJs;

                {
                    this.gJs = r1;
                }

                public final void run() {
                    this.gJs.gJq.duy.setText("");
                    this.gJs.gJq.gJi = null;
                    this.gJs.gJq.ctB = null;
                }
            });
        }
    };
    private ad gJm = new ad("IPCallDialQueryPhoneNumber");
    boolean gJn = false;
    private TextWatcher gJo = new TextWatcher(this) {
        final /* synthetic */ b gJq;

        {
            this.gJq = r1;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.gJq.gJc.getLayoutParams() != null) {
                int i4;
                Paint paint = this.gJq.gIY.getPaint();
                int measureText;
                if ("+".equals(this.gJq.gIY.getText().toString())) {
                    measureText = (int) paint.measureText(this.gJq.gIY.getText().toString());
                    this.gJq.gJa.setVisibility(8);
                    this.gJq.gJd.setVisibility(8);
                    i4 = measureText;
                } else {
                    measureText = (int) paint.measureText(this.gJq.gIY.getText() + "+");
                    this.gJq.gJa.setVisibility(0);
                    this.gJq.gJd.setVisibility(0);
                    i4 = measureText;
                }
                LayoutParams layoutParams = (LayoutParams) this.gJq.gJc.getLayoutParams();
                layoutParams.width = i4;
                this.gJq.gJc.setLayoutParams(layoutParams);
            }
            String replace = this.gJq.gIY.getText().toString().replace("+", "");
            if (com.tencent.mm.plugin.ipcall.b.a.vm(replace)) {
                this.gJq.gJd.setText(com.tencent.mm.plugin.ipcall.b.a.vj(replace));
            } else {
                this.gJq.gJd.setText(this.gJq.aWn.getString(2131233346));
            }
            if (this.gJq.gIW != null) {
                this.gJq.gIW.uS(replace);
            }
        }

        public final void afterTextChanged(Editable editable) {
            String replace = this.gJq.gIY.getText().toString().replace("+", "");
            if (replace.startsWith("0") || replace.startsWith("*") || replace.startsWith("#")) {
                this.gJq.gIY.setText("+");
                this.gJq.gJg = "+";
            }
        }
    };
    String gJp = "";

    public interface a {
        void g(String str, String str2, String str3, String str4);

        void uS(String str);

        void uT(String str);
    }

    public b(MMActivity mMActivity, EditText editText, TextView textView, View view, DialPad dialPad, ImageButton imageButton, TextView textView2, View view2, TextView textView3) {
        this.aWn = mMActivity;
        this.gIZ = editText;
        this.gIY = textView;
        this.gJa = view;
        this.gIX = dialPad;
        this.gJb = imageButton;
        this.duy = textView2;
        this.gJc = view2;
        this.gJd = textView3;
        this.gJe = new al();
        this.gJg = com.tencent.mm.plugin.ipcall.b.c.avC();
        String string = aa.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryName", "");
        if (be.kS(string)) {
            string = com.tencent.mm.plugin.ipcall.b.a.vj(com.tencent.mm.plugin.ipcall.b.a.avy());
        }
        this.gJf = string;
        this.gIY.addTextChangedListener(this.gJo);
        this.gIY.setText("+" + this.gJg);
        this.gIX.gIV = new com.tencent.mm.plugin.ipcall.ui.DialPad.a(this) {
            final /* synthetic */ b gJq;

            {
                this.gJq = r1;
            }

            public final void uP(String str) {
                this.gJq.gJh = this.gJq.gIZ.getText().toString();
                if (this.gJq.gJk) {
                    b bVar = this.gJq;
                    bVar.gJg += str;
                    this.gJq.gIY.setText(this.gJq.gJg);
                    if (com.tencent.mm.plugin.ipcall.b.a.vm(this.gJq.gJg.replace("+", "")) || this.gJq.gJg.replace("+", "").length() >= 4) {
                        g.iuh.h(12061, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0)});
                        this.gJq.gJk = false;
                        this.gJq.gJf = com.tencent.mm.plugin.ipcall.b.a.vj(this.gJq.gJg.replace("+", ""));
                        this.gJq.gJh = this.gJq.bP(this.gJq.gJg.replace("+", ""), this.gJq.gJh);
                        this.gJq.aE(this.gJq.gJh, -1);
                        return;
                    }
                    return;
                }
                String replace = this.gJq.gIY.getText().toString().replace("+", "");
                if (this.gJq.gJn) {
                    StringBuffer stringBuffer = new StringBuffer(this.gJq.gJh);
                    stringBuffer.insert(this.gJq.gIZ.getSelectionStart(), str);
                    this.gJq.gJh = stringBuffer.toString();
                } else {
                    b bVar2 = this.gJq;
                    bVar2.gJh += str;
                }
                if (this.gJq.gJh.equals("00")) {
                    this.gJq.gIY.setText("+");
                    this.gJq.gJk = true;
                    this.gJq.gJg = "+";
                    this.gJq.gJh = "";
                }
                if (com.tencent.mm.plugin.ipcall.b.a.vm(this.gJq.gJg.replace("+", "") + this.gJq.gJh)) {
                    this.gJq.gIY.setText("+" + this.gJq.gJg.replace("+", "") + this.gJq.gJh);
                    this.gJq.gJf = com.tencent.mm.plugin.ipcall.b.a.vj(this.gJq.gJg.replace("+", ""));
                    this.gJq.gJk = false;
                    this.gJq.gJg = this.gJq.gJg.replace("+", "") + this.gJq.gJh;
                    this.gJq.gJh = "";
                }
                String str2 = this.gJq.gJh;
                this.gJq.gJh = this.gJq.bP(replace, this.gJq.gJh);
                if (!this.gJq.gJn) {
                    this.gJq.aE(this.gJq.gJh, -1);
                } else if (str2.length() < this.gJq.gJh.length()) {
                    this.gJq.aE(this.gJq.gJh, this.gJq.gIZ.getSelectionEnd() + 2);
                } else if (str2.length() == this.gJq.gJh.length()) {
                    this.gJq.aE(this.gJq.gJh, this.gJq.gIZ.getSelectionEnd() + 1);
                } else if (str2.length() > this.gJq.gJh.length()) {
                    this.gJq.aE(this.gJq.gJh, (this.gJq.gIZ.getSelectionEnd() + 1) - (str2.length() - this.gJq.gJh.length()));
                }
                this.gJq.gJj = System.currentTimeMillis();
                if (this.gJq.gJh.length() > com.tencent.mm.plugin.ipcall.b.a.gPy && !be.kS(this.gJq.gJg + this.gJq.gJh)) {
                    this.gJq.ava();
                }
            }

            public final void uQ(String str) {
                if (str.equals("0")) {
                    this.gJq.gIY.setText("+");
                    this.gJq.gJk = true;
                    this.gJq.gJg = "+";
                }
            }
        };
        this.gJa.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b gJq;

            {
                this.gJq = r1;
            }

            public final void onClick(View view) {
                String obj = this.gJq.gIZ.getText().toString();
                if (be.kS(obj)) {
                    obj = this.gJq.gIY.getText().toString();
                    if (!be.kS(obj)) {
                        Object substring = obj.substring(0, obj.length() - 1);
                        if (be.kS(substring) || substring.equals("+")) {
                            this.gJq.gIY.setText("+");
                            this.gJq.gJg = "+";
                            this.gJq.gJk = true;
                            return;
                        }
                        this.gJq.gIY.setText(substring);
                        this.gJq.gJg = substring;
                        return;
                    }
                    return;
                }
                int selectionStart = this.gJq.gIZ.getSelectionStart();
                if (!this.gJq.gJn || selectionStart - 1 < 0) {
                    obj = obj.substring(0, obj.length() - 1);
                } else {
                    Editable text = this.gJq.gIZ.getText();
                    text.delete(selectionStart - 1, selectionStart);
                    obj = text.toString();
                }
                if (be.kS(obj)) {
                    this.gJq.gJh = "";
                    this.gJq.aE("", -1);
                } else {
                    String replace = this.gJq.gIY.getText().toString().replace("+", "");
                    if (this.gJq.gJn) {
                        this.gJq.gJh = this.gJq.bP(replace, obj);
                        this.gJq.aE(this.gJq.gJh, (this.gJq.gJh.length() - obj.length()) + (selectionStart - 1));
                    } else {
                        this.gJq.gJh = this.gJq.bP(replace, obj);
                        this.gJq.aE(this.gJq.gJh, -1);
                    }
                    this.gJq.ava();
                }
                this.gJq.gJi = "";
                this.gJq.duy.setText("");
            }
        });
        this.gJa.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ b gJq;

            {
                this.gJq = r1;
            }

            public final boolean onLongClick(View view) {
                if (this.gJq.gJk) {
                    this.gJq.gJg = "+";
                    this.gJq.gIY.setText(this.gJq.gJg);
                } else {
                    this.gJq.duy.setText("");
                    this.gJq.gJh = "";
                    this.gJq.aE("", -1);
                }
                return true;
            }
        });
        this.gIY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b gJq;

            {
                this.gJq = r1;
            }

            public final void onClick(View view) {
                g.iuh.h(12061, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
                String replace = this.gJq.gIY.getText().toString().replace("+", "");
                Intent intent = new Intent(this.gJq.aWn, IPCallCountryCodeSelectUI.class);
                intent.putExtra("couttry_code", replace);
                intent.putExtra("CountryCodeUI_isShowCountryCode", true);
                this.gJq.aWn.startActivityForResult(intent, 100);
                this.gJq.aWn.overridePendingTransition(2130968646, -1);
            }
        });
        this.gJb.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b gJq;

            {
                this.gJq = r1;
            }

            public final void onClick(View view) {
                b bVar = this.gJq;
                bVar.gJg = bVar.gIY.getText().toString();
                bVar.gJh = bVar.gIZ.getText().toString();
                String string;
                if (be.kS(bVar.gJg) || be.kS(bVar.gJh)) {
                    string = aa.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputPhoneNumber", "");
                    if (!be.kS(string)) {
                        bVar.gJh = bVar.bP(bVar.gIY.getText().toString().replace("+", ""), com.tencent.mm.plugin.ipcall.b.c.vt(string));
                        bVar.aE(bVar.gJh, -1);
                        bVar.ava();
                        return;
                    }
                    return;
                }
                bVar.gJg = bVar.gIY.getText().toString().replace("+", "");
                bVar.gJi = com.tencent.mm.plugin.ipcall.b.a.aa(bVar.aWn, bVar.gJg + bVar.gJh);
                bVar.ctB = com.tencent.mm.plugin.ipcall.b.a.ac(bVar.aWn, bVar.gJi);
                string = com.tencent.mm.plugin.ipcall.b.c.vt(bVar.gJh);
                Editor edit = aa.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
                edit.putString("IPCall_LastInputPhoneNumber", string);
                edit.apply();
                String charSequence = bVar.gIY.getText().toString();
                string = bVar.gJf;
                if (!be.kS(charSequence)) {
                    if (be.kS(string)) {
                        string = "";
                    }
                    Editor edit2 = aa.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
                    edit2.putString("IPCall_LastInputCountryCode", charSequence.replace("+", ""));
                    edit2.putString("IPCall_LastInputCountryName", string);
                    edit2.apply();
                }
                if (bVar.gIW != null) {
                    bVar.gIW.g(bVar.gJg, com.tencent.mm.plugin.ipcall.b.c.vt(bVar.gJh), bVar.gJi, bVar.ctB);
                }
            }
        });
        this.gIZ.setHorizontallyScrolling(true);
        this.gIZ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b gJq;

            {
                this.gJq = r1;
            }

            public final void onClick(View view) {
                this.gJq.gIZ.setCursorVisible(true);
                this.gJq.aWn.axg();
                this.gJq.gJn = true;
            }
        });
        this.gIZ.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ b gJq;

            {
                this.gJq = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                CharSequence vt = be.vt(charSequence.toString());
                if (vt.contains(" ")) {
                    vt = vt.replace(" ", "");
                    this.gJq.gIZ.setText(be.E(vt));
                } else if ((!this.gJq.gJp.equals(vt) || i3 > 0) && be.kS(vt)) {
                    this.gJq.gJp = vt;
                    this.gJq.gIZ.setText("");
                }
                if (com.tencent.mm.plugin.ipcall.b.a.vn(vt)) {
                    String vl = com.tencent.mm.plugin.ipcall.b.a.vl(vt);
                    if (!be.kS(vl)) {
                        this.gJq.gIY.setText("+" + vl);
                        this.gJq.gIZ.setText(com.tencent.mm.plugin.ipcall.b.a.vq(vt));
                    }
                } else if (!vt.equals(this.gJq.gJp)) {
                    this.gJq.gJp = vt;
                    this.gJq.gIZ.setText(vt);
                    if (be.kS(this.gJq.gIY.getText().toString())) {
                        this.gJq.gIY.setText("+" + com.tencent.mm.plugin.ipcall.b.a.avy());
                    }
                }
                if (this.gJq.gIW != null) {
                    this.gJq.gIW.uT(this.gJq.gIZ.getText().toString());
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        if (d.dW(16)) {
            this.gIY.setTypeface(Typeface.create("sans-serif-light", 0));
            this.gIZ.setTypeface(Typeface.create("sans-serif-light", 0));
            this.duy.setTypeface(Typeface.create("sans-serif-light", 0));
        }
    }

    public final void uR(String str) {
        this.gJg = str;
        if (this.gIY != null) {
            this.gIY.setText("+" + str);
        }
    }

    final String bP(String str, String str2) {
        String formatNumber = al.formatNumber(str, com.tencent.mm.plugin.ipcall.b.c.vt(str2));
        return be.kS(formatNumber) ? str2 : formatNumber;
    }

    public final void aE(String str, int i) {
        this.gIZ.setText(str);
        if (!be.kS(str)) {
            if (i != -1) {
                if (this.gJn) {
                    if (i > 0 && i <= this.gIZ.getText().length()) {
                        this.gIZ.setSelection(i);
                    }
                }
            }
            this.gIZ.setSelection(this.gIZ.getText().length());
        }
        this.gJh = str;
    }

    public final void ava() {
        this.gJm.btx().removeCallbacks(this.gJl);
        this.gJm.f(this.gJl, 500);
    }
}
