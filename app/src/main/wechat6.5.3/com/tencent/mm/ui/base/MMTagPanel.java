package com.tencent.mm.ui.base;

import android.content.Context;
import android.os.IBinder;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.bf.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MMTagPanel extends FlowLayout {
    private boolean fOI = false;
    public int fPA = 2130839272;
    public int fPz = 2131689909;
    public int gMg = 2130839266;
    public int gMh = 2131690123;
    public boolean gjg = true;
    public LinkedList<d> mtZ = new LinkedList();
    public boolean nYe = true;
    private boolean nYf = false;
    public boolean nYg = true;
    public boolean nYh = false;
    public boolean nYi = false;
    public int nYj = 2130839262;
    private int nYk = 0;
    public int nYl = 2130839269;
    private int nYm = com.tencent.mm.bi.a.a.white;
    private d nYn = null;
    private LinkedList<d> nYo = new LinkedList();
    public a nYp;
    private int nYq;
    private View nYr;
    public MMEditText nYs;
    private OnClickListener nYt = new OnClickListener(this) {
        final /* synthetic */ MMTagPanel nYu;

        {
            this.nYu = r1;
        }

        public final void onClick(final View view) {
            if (((Integer) view.getTag()).intValue() == 0) {
                this.nYu.a((TextView) view, true, false);
                if (this.nYu.nYp != null) {
                    view.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass8 nYw;

                        public final void run() {
                            this.nYw.nYu.nYp.rT(((TextView) view).getText().toString());
                        }
                    });
                }
            } else if (!this.nYu.nYf || this.nYu.nYh) {
                this.nYu.a((TextView) view, false, false);
                if (this.nYu.nYp != null) {
                    view.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass8 nYw;

                        public final void run() {
                            this.nYw.nYu.nYp.rS(((TextView) view).getText().toString());
                        }
                    });
                }
            } else if (this.nYu.nYn == null) {
                this.nYu.nYn = MMTagPanel.a(this.nYu, ((TextView) view).getText().toString());
                if (this.nYu.nYn != null) {
                    this.nYu.a(this.nYu.nYn.nYG, false, true);
                }
            } else if (this.nYu.nYn.nYG == view) {
                this.nYu.nYn = null;
                this.nYu.a((TextView) view, false, false);
                if (this.nYu.nYp != null) {
                    view.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass8 nYw;

                        public final void run() {
                            this.nYw.nYu.nYp.rS(((TextView) view).getText().toString());
                        }
                    });
                }
            } else {
                this.nYu.bCD();
                this.nYu.nYn = MMTagPanel.a(this.nYu, ((TextView) view).getText().toString());
                this.nYu.a(this.nYu.nYn.nYG, false, true);
            }
        }
    };

    public interface a {
        void aii();

        void f(boolean z, int i);

        void rS(String str);

        void rT(String str);

        void rU(String str);

        void rV(String str);

        void rW(String str);
    }

    public class b implements InputFilter {
        int mark;
        final /* synthetic */ MMTagPanel nYu;
        List<String> nYx = new LinkedList();

        public b(MMTagPanel mMTagPanel) {
            this.nYu = mMTagPanel;
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            v.d("MicroMsg.MMTagPanel", "on create tag filter, %s [%d, %d) %s [%d, %d), maxlength[%B]", charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.nYu.fOI));
            this.mark = -1;
            this.nYx.clear();
            char[] cArr = new char[(i2 - i)];
            TextUtils.getChars(charSequence, i, i2, cArr, 0);
            if (this.nYu.nYg) {
                int i5 = i;
                while (i5 < i2) {
                    if (cArr[i5] == '\n' || cArr[i5] == ',' || cArr[i5] == ';' || cArr[i5] == '、' || cArr[i5] == '，' || cArr[i5] == '；') {
                        if (-1 == this.mark) {
                            this.nYx.add((spanned.subSequence(0, i3).toString() + charSequence.subSequence(i, i5)).trim());
                        } else {
                            this.nYx.add(charSequence.subSequence(this.mark, i5).toString().trim());
                        }
                        this.mark = i5 + 1;
                    }
                    i5++;
                }
                if (this.nYx.isEmpty()) {
                    return null;
                }
                String charSequence2;
                if (this.nYu.nYp != null) {
                    for (final String charSequence22 : this.nYx) {
                        if (charSequence22.length() > 0) {
                            this.nYu.post(new Runnable(this) {
                                final /* synthetic */ b nYz;

                                public final void run() {
                                    this.nYz.nYu.nYp.rW(charSequence22.trim());
                                }
                            });
                        }
                    }
                }
                if (this.mark >= i2) {
                    spanned.length();
                    charSequence22 = spanned.subSequence(i4, spanned.length()).toString();
                } else {
                    charSequence22 = charSequence.subSequence(this.mark, i2).toString() + spanned.subSequence(i4, spanned.length());
                }
                this.nYu.post(new Runnable(this) {
                    final /* synthetic */ b nYz;

                    public final void run() {
                        this.nYz.nYu.nYs.setText(SQLiteDatabase.KeyEmpty);
                        this.nYz.nYu.nYs.append(charSequence22);
                    }
                });
                return SQLiteDatabase.KeyEmpty;
            }
            Object obj = null;
            final StringBuilder stringBuilder = new StringBuilder();
            while (i < i2) {
                if (cArr[i] == '\n') {
                    obj = 1;
                } else {
                    stringBuilder.append(cArr[i]);
                }
                i++;
            }
            if (obj == null) {
                return null;
            }
            CharSequence stringBuilder2 = stringBuilder.toString();
            stringBuilder.insert(0, spanned.subSequence(0, i3));
            stringBuilder.append(spanned.subSequence(i4, spanned.length()));
            this.nYu.post(new Runnable(this) {
                final /* synthetic */ b nYz;

                public final void run() {
                    this.nYz.nYu.nYp.rW(stringBuilder.toString());
                }
            });
            return stringBuilder2;
        }
    }

    public class c implements InputFilter {
        int nYB = 36;
        private int nYC = FileUtils.S_IRUSR;
        private int nYD;
        final /* synthetic */ MMTagPanel nYu;

        public c(MMTagPanel mMTagPanel) {
            this.nYu = mMTagPanel;
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int PC = h.PC(spanned.toString()) + h.PC(charSequence.toString());
            if (i4 > i3) {
                if (PC - (i4 - i3) > this.nYB) {
                    this.nYu.fOI = true;
                    this.nYD = (PC - (i4 - i3)) - this.nYB;
                } else {
                    this.nYu.fOI = false;
                }
            } else if (PC > this.nYB) {
                this.nYu.fOI = true;
                this.nYD = PC - this.nYB;
            } else {
                this.nYu.fOI = false;
            }
            if (this.nYu.nYp != null) {
                this.nYu.post(new Runnable(this) {
                    final /* synthetic */ c nYE;

                    {
                        this.nYE = r1;
                    }

                    public final void run() {
                        this.nYE.nYu.nYp.f(this.nYE.nYu.fOI, h.aw(this.nYE.nYD, SQLiteDatabase.KeyEmpty));
                    }
                });
            }
            if (PC > this.nYC) {
                return SQLiteDatabase.KeyEmpty;
            }
            return charSequence;
        }
    }

    public static final class d {
        public String nYF;
        public TextView nYG;
    }

    static /* synthetic */ d a(MMTagPanel mMTagPanel, String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.MMTagPanel", "want to get tag info, but it is null or empty");
            return null;
        }
        Iterator it = mMTagPanel.mtZ.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.nYF)) {
                return dVar;
            }
        }
        v.w("MicroMsg.MMTagPanel", "want to get tag %s, but it not exsited!", str);
        return null;
    }

    public MMTagPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public MMTagPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void amV() {
    }

    private void init() {
        this.nYq = getContext().getResources().getDimensionPixelSize(2131493128);
        this.nYr = LayoutInflater.from(getContext()).inflate(2130904078, null);
        this.nYs = (MMEditText) this.nYr.findViewById(2131755280);
        this.nYs.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ MMTagPanel nYu;

            {
                this.nYu = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0 && 67 == i) {
                    v.d("MicroMsg.MMTagPanel", "on del click, selection[%d, %d]", Integer.valueOf(this.nYu.nYs.getSelectionStart()), Integer.valueOf(this.nYu.nYs.getSelectionEnd()));
                    boolean z = this.nYu.nYs.getSelectionStart() == 0 && this.nYu.nYs.getSelectionStart() == this.nYu.nYs.getSelectionEnd();
                    if (z) {
                        this.nYu.amV();
                        if (!(this.nYu.mtZ == null || this.nYu.mtZ.isEmpty())) {
                            if (!this.nYu.nYh && this.nYu.nYn == null) {
                                this.nYu.nYn = (d) this.nYu.mtZ.getLast();
                                this.nYu.a(this.nYu.nYn.nYG, false, true);
                                this.nYu.nYs.setCursorVisible(false);
                            } else if (this.nYu.nYn == null || this.nYu.mtZ == null || this.nYu.mtZ.getLast() == null || be.kS(this.nYu.nYn.nYF) || be.kS(((d) this.nYu.mtZ.getLast()).nYF) || this.nYu.nYn.nYF.equals(((d) this.nYu.mtZ.getLast()).nYF)) {
                                String str = ((d) this.nYu.mtZ.getLast()).nYF;
                                this.nYu.removeTag(str);
                                if (this.nYu.nYp != null) {
                                    this.nYu.nYp.rU(str);
                                }
                                this.nYu.bCD();
                            } else {
                                v.i("MicroMsg.MMTagPanel", "change hight");
                                this.nYu.bCD();
                                this.nYu.nYn = (d) this.nYu.mtZ.getLast();
                                this.nYu.a(this.nYu.nYn.nYG, false, true);
                                this.nYu.nYs.setCursorVisible(false);
                            }
                        }
                    }
                }
                return false;
            }
        });
        this.nYs.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MMTagPanel nYu;

            {
                this.nYu = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (this.nYu.nYp != null) {
                    this.nYu.nYp.rV(obj);
                }
                if (obj.length() > 0) {
                    this.nYu.bCD();
                }
            }
        });
        this.nYs.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ MMTagPanel nYu;

            {
                this.nYu = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                v.d("MicroMsg.MMTagPanel", "on edittext focus changed %B", Boolean.valueOf(z));
                if (z && this.nYu.nYp != null) {
                    this.nYu.nYp.aii();
                }
            }
        });
        this.nYs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MMTagPanel nYu;

            {
                this.nYu = r1;
            }

            public final void onClick(View view) {
                v.d("MicroMsg.MMTagPanel", "on edittext click");
                this.nYu.bCD();
                if (this.nYu.nYp != null) {
                    this.nYu.nYp.aii();
                }
            }
        });
        this.nYs.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ MMTagPanel nYu;

            {
                this.nYu = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                v.d("MicroMsg.MMTagPanel", "on action %d, %s", Integer.valueOf(i), keyEvent);
                return false;
            }
        });
        final c cVar = new c(this);
        b bVar = new b(this);
        this.nYs.setFilters(new InputFilter[]{cVar, bVar});
        bCA();
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MMTagPanel nYu;

            {
                this.nYu = r1;
            }

            public final void onClick(View view) {
                v.d("MicroMsg.MMTagPanel", "on panel click, enableEditMode %B", Boolean.valueOf(this.nYu.nYf));
                if (this.nYu.nYf) {
                    this.nYu.bCD();
                    this.nYu.nYs.requestFocus();
                    this.nYu.nYs.setSelection(this.nYu.nYs.getText().length());
                    ((InputMethodManager) this.nYu.getContext().getSystemService("input_method")).showSoftInput(this.nYu.nYs, 0);
                    v.d("MicroMsg.MMTagPanel", "on content click");
                    if (this.nYu.nYp != null) {
                        this.nYu.nYp.aii();
                    }
                }
            }
        });
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MMTagPanel nYu;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.nYu.nYi) {
                    String bCw = this.nYu.bCw();
                    if (!be.kS(bCw)) {
                        if (cVar != null && h.PC(bCw) > cVar.nYB) {
                            int PD = cVar.nYB - h.PD(bCw);
                            if (PD <= bCw.length()) {
                                bCw = bCw.substring(0, PD);
                            }
                        }
                        this.nYu.aM(bCw, true);
                        if (this.nYu.nYp != null) {
                            this.nYu.nYp.rW(bCw);
                        }
                        this.nYu.bCx();
                    }
                }
                return false;
            }
        });
    }

    public final void bCv() {
        this.nYk = 2130839263;
        if (this.nYs != null) {
            com.tencent.mm.bd.a.fromDPToPix(getContext(), 6);
            getResources().getDimensionPixelSize(2131493168);
            this.nYs.setBackgroundResource(this.nYk);
        }
    }

    public final void Ou(String str) {
        if (this.nYs != null) {
            this.nYs.setHint(str);
        }
    }

    public final String bCw() {
        if (this.nYs != null) {
            return this.nYs.getText().toString();
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public final void bCx() {
        if (this.nYs != null) {
            this.nYs.setText(SQLiteDatabase.KeyEmpty);
        }
    }

    public final boolean bCy() {
        if (this.nYs == null) {
            return false;
        }
        return this.nYs.isFocused();
    }

    public final void bCz() {
        if (this.nYs != null && !this.nYs.isFocused()) {
            this.nYs.requestFocus();
        }
    }

    public final void bCA() {
        if (this.nYs != null && this.nYs.isFocused()) {
            v.d("MicroMsg.MMTagPanel", "do clear edit focus");
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                IBinder windowToken = this.nYs.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                    this.nYs.clearFocus();
                }
            }
        }
    }

    public final void ju(boolean z) {
        if (z != this.nYf) {
            this.nYf = z;
            removeView(this.nYr);
            if (this.nYf) {
                addView(this.nYr);
                bCA();
            }
        }
    }

    public final ArrayList<String> bCB() {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.mtZ.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (!be.kS(dVar.nYF)) {
                arrayList.add(dVar.nYF);
            }
        }
        return arrayList;
    }

    public void bCn() {
        this.mtZ.clear();
        removeAllViews();
        Iterator it = this.mtZ.iterator();
        while (it.hasNext()) {
            a((d) it.next());
        }
    }

    public final void a(Collection<String> collection, List<String> list) {
        bCn();
        if (this.nYf) {
            addView(this.nYr);
        }
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                aM(str, collection == null ? false : collection.contains(str));
            }
        }
    }

    public final d bCC() {
        if (!this.nYo.isEmpty()) {
            return (d) this.nYo.removeFirst();
        }
        d dVar = new d();
        TextView textView = new TextView(getContext());
        textView.setBackgroundResource(this.fPA);
        textView.setTextColor(getResources().getColor(this.fPz));
        textView.setTag(Integer.valueOf(0));
        textView.setGravity(17);
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.nYj, 0);
        textView.setOnClickListener(this.nYe ? this.nYt : null);
        textView.setEllipsize(TruncateAt.END);
        textView.setSingleLine();
        dVar.nYG = textView;
        return dVar;
    }

    public final void a(d dVar) {
        dVar.nYG.setOnClickListener(null);
        if (this.nYo.size() < 16) {
            this.nYo.add(dVar);
        }
    }

    public final void a(d dVar, String str, boolean z) {
        dVar.nYF = str;
        dVar.nYG.setText(g.buU().e(getContext(), str, this.nYq));
        dVar.nYG.setOnClickListener(this.nYe ? this.nYt : null);
        a(dVar.nYG, z, false);
    }

    public final void bCD() {
        if (this.nYs != null) {
            v.d("MicroMsg.MMTagPanel", "do clear high light info, edittext is focus %B", Boolean.valueOf(this.nYs.isFocused()));
            this.nYs.setCursorVisible(true);
        }
        if (this.nYn != null) {
            boolean z;
            TextView textView = this.nYn.nYG;
            if (((Integer) this.nYn.nYG.getTag()).intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            a(textView, z, false);
            this.nYn = null;
        }
    }

    public final void a(TextView textView, boolean z, boolean z2) {
        textView.setTextSize(0, getContext().getResources().getDimension(2131493128) * com.tencent.mm.bd.a.ds(getContext()));
        if (z2) {
            textView.setBackgroundResource(this.nYl);
            textView.setTextColor(getResources().getColor(this.nYm));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.nYj, 0);
        } else if (z) {
            textView.setTag(Integer.valueOf(1));
            textView.setBackgroundResource(this.gMg);
            textView.setTextColor(getResources().getColor(this.gMh));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            textView.setTag(Integer.valueOf(0));
            textView.setBackgroundResource(this.fPA);
            textView.setTextColor(getResources().getColor(this.fPz));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    public final void aM(String str, boolean z) {
        if (be.kS(str)) {
            v.w("MicroMsg.MMTagPanel", "want to add tag, but it is null or empty");
            return;
        }
        String trim = str.trim();
        v.d("MicroMsg.MMTagPanel", "want to add tag %s, do remove tag first", trim);
        removeTag(trim);
        Iterator it = this.mtZ.iterator();
        while (it.hasNext()) {
            if (trim.equals(((d) it.next()).nYF)) {
                v.w("MicroMsg.MMTagPanel", "want to add tag %s, but it exsited!", trim);
                return;
            }
        }
        d bCC = bCC();
        a(bCC, trim, z);
        this.mtZ.add(bCC);
        if (this.nYf) {
            addView(bCC.nYG, getChildCount() - 1);
        } else {
            addView(bCC.nYG);
        }
        bCD();
    }

    public final void removeTag(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.MMTagPanel", "want to remove tag, but it is null or empty");
            return;
        }
        Iterator it = this.mtZ.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.nYF)) {
                this.mtZ.remove(dVar);
                removeView(dVar.nYG);
                a(dVar);
                bCD();
                return;
            }
        }
        v.w("MicroMsg.MMTagPanel", "want to remove tag %s, but it not exsited!", str);
    }

    public final void aN(String str, boolean z) {
        if (be.kS(str)) {
            v.w("MicroMsg.MMTagPanel", "want to update tag status, but it is null or empty");
            return;
        }
        Iterator it = this.mtZ.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.nYF)) {
                a(dVar, str, z);
                bCD();
                return;
            }
        }
        v.w("MicroMsg.MMTagPanel", "want to update tag %s status, but it not exsited!", str);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.gjg) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }
}
