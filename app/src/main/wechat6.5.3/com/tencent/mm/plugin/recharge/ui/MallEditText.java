package com.tencent.mm.plugin.recharge.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MallEditText extends LinearLayout implements OnFocusChangeListener {
    private TextView duy;
    private OnFocusChangeListener dxN;
    ImageView dxQ;
    private String dxR;
    String dxS;
    int dxT;
    public boolean dxV;
    boolean dxX;
    private int dxY;
    private int dxZ;
    private int gravity;
    b imO;
    AutoCompleteTextView imP;
    boolean imQ;
    private a imR;
    private boolean imS;
    private List<String[]> imT;
    private com.tencent.mm.plugin.recharge.model.a imU;
    private Runnable imV;
    private boolean imW;
    private int imX;
    private int imeOptions;
    private int inputType;

    private class a extends BaseAdapter implements Filterable {
        final /* synthetic */ MallEditText imY;
        public List<com.tencent.mm.plugin.recharge.model.a> imZ;
        public boolean ina;
        private List<com.tencent.mm.plugin.recharge.model.a> inb;
        private a inc;
        private String ind;

        private class a extends Filter {
            final /* synthetic */ a ine;

            private a(a aVar) {
                this.ine = aVar;
            }

            protected final synchronized FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults;
                FilterResults filterResults2 = new FilterResults();
                List arrayList = new ArrayList();
                String yt = charSequence != null ? com.tencent.mm.plugin.recharge.model.b.yt(charSequence.toString()) : "";
                if (yt.equals(this.ine.ind)) {
                    this.ine.imY.imP.post(new Runnable(this) {
                        final /* synthetic */ a inf;

                        {
                            this.inf = r1;
                        }

                        public final void run() {
                            this.inf.ine.imY.imP.dismissDropDown();
                        }
                    });
                    filterResults = filterResults2;
                } else {
                    final com.tencent.mm.plugin.recharge.model.a aVar;
                    boolean z;
                    boolean z2;
                    this.ine.ind = yt;
                    if (this.ine.imY.Ou()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        v.d("MicroMsg.MallEditText", "performFiltering " + charSequence);
                        for (com.tencent.mm.plugin.recharge.model.a aVar2 : this.ine.inb) {
                            if (aVar2.imk.equals(this.ine.ind)) {
                                aVar2.iml = com.tencent.mm.plugin.recharge.model.a.imi;
                                arrayList.clear();
                                arrayList.add(aVar2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            if (this.ine.imY.imT == null) {
                                try {
                                    this.ine.imY.imT = com.tencent.mm.pluginsdk.a.cW(this.ine.imY.getContext());
                                } catch (Throwable e) {
                                    v.a("MicroMsg.MallEditText", e, "", new Object[0]);
                                }
                            }
                            if (this.ine.imY.imT != null) {
                                for (String[] strArr : this.ine.imY.imT) {
                                    String yt2 = com.tencent.mm.plugin.recharge.model.b.yt(strArr[2]);
                                    Object cp = cp(this.ine.ind, yt2);
                                    if (com.tencent.mm.plugin.recharge.model.a.imi.equals(cp)) {
                                        com.tencent.mm.plugin.recharge.model.a aVar3 = new com.tencent.mm.plugin.recharge.model.a(yt2, strArr[1], 1);
                                        aVar3.iml = com.tencent.mm.plugin.recharge.model.a.imi;
                                        arrayList.clear();
                                        arrayList.add(aVar3);
                                        break;
                                    } else if (!com.tencent.mm.plugin.recharge.model.a.imj.equals(cp) && arrayList.size() < 5) {
                                        com.tencent.mm.plugin.recharge.model.a aVar4 = new com.tencent.mm.plugin.recharge.model.a(yt2, strArr[1], 1);
                                        aVar4.iml = cp;
                                        arrayList.add(aVar4);
                                    }
                                }
                            }
                        }
                        v.d("MicroMsg.MallEditText", " search phone number cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                        z = true;
                    } else if (be.kS(this.ine.ind)) {
                        arrayList.addAll(this.ine.inb);
                        z = false;
                    } else {
                        v.d("MicroMsg.MallEditText", "performFiltering " + charSequence);
                        for (com.tencent.mm.plugin.recharge.model.a aVar22 : this.ine.inb) {
                            if (aVar22.imk.startsWith(this.ine.ind)) {
                                arrayList.add(aVar22);
                            }
                        }
                        z = false;
                    }
                    if (arrayList.size() == 0) {
                        this.ine.imY.imP.post(new Runnable(this) {
                            final /* synthetic */ a inf;

                            {
                                this.inf = r1;
                            }

                            public final void run() {
                                this.inf.ine.imY.imP.dismissDropDown();
                            }
                        });
                        z2 = false;
                    } else {
                        if (arrayList.size() == 1 && this.ine.imY.Ou()) {
                            aVar22 = (com.tencent.mm.plugin.recharge.model.a) arrayList.get(0);
                            if (com.tencent.mm.plugin.recharge.model.a.imi.equals(aVar22.iml)) {
                                this.ine.imY.imP.post(new Runnable(this) {
                                    final /* synthetic */ a inf;

                                    public final void run() {
                                        this.inf.ine.imY.imU = aVar22;
                                        if (be.kS(this.inf.ine.imY.imU.name)) {
                                            this.inf.ine.imY.duy.setText("");
                                            this.inf.ine.imY.duy.setVisibility(8);
                                        } else {
                                            this.inf.ine.imY.duy.setText(this.inf.ine.imY.imU.name);
                                            this.inf.ine.imY.duy.setVisibility(0);
                                        }
                                        this.inf.ine.imY.imP.dismissDropDown();
                                    }
                                });
                                z2 = false;
                            }
                        }
                        z2 = z;
                    }
                    List list = this.ine.imZ;
                    this.ine.imZ = arrayList;
                    this.ine.ina = z2;
                    filterResults2.count = this.ine.imZ.size();
                    filterResults2.values = this.ine.imZ;
                    v.d("MicroMsg.MallEditText", "results.count " + filterResults2.count);
                    list.clear();
                    filterResults = filterResults2;
                }
                return filterResults;
            }

            protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            }

            private static int[] cp(String str, String str2) {
                if (str.equals(str2)) {
                    return com.tencent.mm.plugin.recharge.model.a.imi;
                }
                if (str2 != null && str.length() == str2.length()) {
                    int[] iArr = new int[]{-1, -1};
                    int i = 0;
                    for (int length = str.length() - 1; length > 0; length--) {
                        if (str2.charAt(length) != str.charAt(length)) {
                            i++;
                            if (i > 2) {
                                break;
                            }
                            iArr[i - 1] = length;
                        }
                    }
                    if (i <= 2) {
                        return iArr;
                    }
                }
                return com.tencent.mm.plugin.recharge.model.a.imj;
            }
        }

        private a(MallEditText mallEditText) {
            this.imY = mallEditText;
            this.imZ = new ArrayList();
            this.ina = false;
        }

        public final /* synthetic */ Object getItem(int i) {
            return oH(i);
        }

        public final void bc(List<com.tencent.mm.plugin.recharge.model.a> list) {
            this.inb = list;
            this.imZ.clear();
            this.ina = false;
        }

        public final Filter getFilter() {
            v.d("MicroMsg.MallEditText", "getFilter");
            if (this.inc == null) {
                this.inc = new a();
            }
            return this.inc;
        }

        public final int getCount() {
            if (this.ina) {
                return this.imZ.size() + 2;
            }
            return this.imZ.size() > 0 ? this.imZ.size() + 1 : 0;
        }

        public final synchronized com.tencent.mm.plugin.recharge.model.a oH(int i) {
            com.tencent.mm.plugin.recharge.model.a aVar = null;
            synchronized (this) {
                if (this.ina) {
                    if (i != 0) {
                        if (i <= this.imZ.size()) {
                            aVar = (com.tencent.mm.plugin.recharge.model.a) this.imZ.get(i - 1);
                        }
                    }
                } else if (i < this.imZ.size()) {
                    aVar = (com.tencent.mm.plugin.recharge.model.a) this.imZ.get(i);
                }
            }
            return aVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    c cVar;
                    if (view == null) {
                        view = View.inflate(this.imY.getContext(), 2130904247, null);
                        c cVar2 = new c();
                        cVar2.inh = (TextView) view.findViewById(2131758817);
                        cVar2.dyN = (TextView) view.findViewById(2131758818);
                        view.setTag(cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (c) view.getTag();
                    }
                    com.tencent.mm.plugin.recharge.model.a oH = oH(i);
                    if (oH == null || cVar == null || cVar.inh == null || cVar.dyN == null) {
                        return view;
                    }
                    CharSequence yu = com.tencent.mm.plugin.recharge.model.b.yu(oH.imk);
                    v.d("MicroMsg.MallEditText", "record.record " + yu + ", record.name " + oH.name);
                    if (com.tencent.mm.plugin.recharge.model.a.imi.equals(oH.iml)) {
                        cVar.inh.setText(yu);
                    } else {
                        CharSequence spannableStringBuilder = new SpannableStringBuilder(yu);
                        for (int i2 : oH.iml) {
                            int i22;
                            if (i22 >= 0) {
                                if (i22 >= 7) {
                                    i22 += 2;
                                } else if (i22 >= 3) {
                                    i22++;
                                }
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(-65536), i22, i22 + 1, 34);
                            }
                        }
                        cVar.inh.setText(spannableStringBuilder);
                    }
                    if (oH.name == null || be.kS(oH.name.trim())) {
                        cVar.dyN.setText("");
                    } else {
                        cVar.dyN.setText(this.imY.getResources().getString(2131233804, new Object[]{oH.name}));
                    }
                    view.setBackgroundResource(2130838046);
                    return view;
                case 1:
                    view = View.inflate(this.imY.getContext(), 2130904248, null);
                    view.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ a ine;

                        {
                            this.ine = r1;
                        }

                        public final void onClick(View view) {
                            com.tencent.mm.plugin.recharge.a.a.aJi().bc(null);
                            this.ine.imY.b(null);
                            this.ine.imY.imR.bc(new LinkedList());
                            this.ine.imY.imR.notifyDataSetChanged();
                        }
                    });
                    return view;
                case 2:
                    view = View.inflate(this.imY.getContext(), 2130904246, null);
                    view.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ a ine;

                        {
                            this.ine = r1;
                        }

                        public final void onClick(View view) {
                            this.ine.imY.imP.dismissDropDown();
                        }
                    });
                    return view;
                case 3:
                    View inflate = View.inflate(this.imY.getContext(), 2130904248, null);
                    ((TextView) inflate).setText(2131233796);
                    inflate.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ a ine;

                        {
                            this.ine = r1;
                        }

                        public final void onClick(View view) {
                            this.ine.imY.imP.dismissDropDown();
                        }
                    });
                    return inflate;
                default:
                    return view;
            }
        }

        public final int getItemViewType(int i) {
            if (this.ina) {
                if (i == 0) {
                    return 2;
                }
                if (i > this.imZ.size()) {
                    return 3;
                }
                return 0;
            } else if (i >= this.imZ.size()) {
                return 1;
            } else {
                return 0;
            }
        }

        public final int getViewTypeCount() {
            return 4;
        }
    }

    public interface b {
        void aJm();

        void fc(boolean z);
    }

    private class c {
        TextView dyN;
        final /* synthetic */ MallEditText imY;
        TextView inh;

        private c(MallEditText mallEditText) {
            this.imY = mallEditText;
        }
    }

    public MallEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.imR = null;
        this.dxR = "";
        this.dxS = "";
        this.inputType = 1;
        this.imS = true;
        this.dxZ = -1;
        this.dxY = 1;
        this.gravity = 19;
        this.dxT = -1;
        this.dxX = false;
        this.imU = null;
        this.dxV = true;
        this.imV = null;
        this.imW = false;
        this.imX = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.b.aPq, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(6, 0);
        if (resourceId != 0) {
            this.dxR = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(7, 0);
        if (resourceId != 0) {
            this.dxS = context.getString(resourceId);
        }
        this.inputType = obtainStyledAttributes.getInteger(4, 1);
        this.dxV = obtainStyledAttributes.getBoolean(3, true);
        this.gravity = obtainStyledAttributes.getInt(0, 19);
        this.imS = obtainStyledAttributes.getBoolean(1, true);
        this.dxZ = obtainStyledAttributes.getInteger(2, -1);
        this.dxT = obtainStyledAttributes.getInteger(8, 0);
        this.imeOptions = obtainStyledAttributes.getInteger(5, 5);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(2130904244, this, true);
        this.duy = (TextView) inflate.findViewById(2131758815);
        this.imP = (AutoCompleteTextView) inflate.findViewById(2131755315);
        if (com.tencent.mm.bd.a.dt(context)) {
            this.imP.setTextSize(0, ((float) context.getResources().getDimensionPixelSize(2131493169)) * 1.25f);
        } else {
            this.imP.setTextSize(0, (float) com.tencent.mm.bd.a.N(context, 2131493169));
        }
        this.dxQ = (ImageView) inflate.findViewById(2131755316);
        v.d("MicroMsg.MallEditText", "setFormat editType:" + this.dxT);
        this.imP.setImeOptions(this.imeOptions);
        switch (this.dxT) {
            case 0:
                if (!this.dxV) {
                    this.dxQ.setImageResource(2130838673);
                    this.dxQ.setVisibility(0);
                    break;
                }
                break;
            case 1:
                this.dxY = 13;
                this.dxZ = 13;
                this.inputType = 2;
                oG(2130839037);
                this.dxQ.setVisibility(0);
                break;
        }
        this.inputType = 1;
        this.imP.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MallEditText imY;

            {
                this.imY = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String charSequence2 = charSequence.toString();
                int selectionStart = this.imY.imP.getSelectionStart();
                String str = "";
                if (charSequence2 != null) {
                    StringBuilder stringBuilder = new StringBuilder(charSequence2.replaceAll(" ", ""));
                    int length = stringBuilder.length();
                    if (length >= 4) {
                        stringBuilder.insert(3, ' ');
                    }
                    if (length >= 8) {
                        stringBuilder.insert(8, ' ');
                    }
                    str = stringBuilder.toString();
                    length = str.length();
                    if (length > this.imY.imX) {
                        if ((selectionStart == 4 || selectionStart == 9) && i3 == 1) {
                            selectionStart++;
                        } else if ((selectionStart == 4 || selectionStart == 9) && i3 > 1) {
                            selectionStart += i3;
                        }
                    } else if (length < this.imY.imX && (selectionStart == 4 || selectionStart == 9)) {
                        selectionStart--;
                    }
                    this.imY.imX = length;
                }
                String str2 = str;
                int i4 = selectionStart;
                String str3 = str2;
                if (charSequence2.equals(str3)) {
                    this.imY.aJk();
                    return;
                }
                this.imY.imP.setText(str3);
                if (i4 < this.imY.imX) {
                    this.imY.imP.setSelection(i4);
                } else {
                    this.imY.imP.setSelection(this.imY.imX);
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.imP.setOnFocusChangeListener(this);
        if (!be.kS(this.dxR)) {
            this.imP.setHint(this.dxR);
        }
        if (this.inputType == 2) {
            this.imP.setKeyListener(new NumberKeyListener(this) {
                final /* synthetic */ MallEditText imY;

                {
                    this.imY = r1;
                }

                public final int getInputType() {
                    return 3;
                }

                protected final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ' '};
                }
            });
        } else {
            this.imP.setInputType(this.inputType);
            this.imP.setRawInputType(this.inputType);
        }
        this.imP.setGravity(this.gravity);
        if (!this.imS) {
            this.imP.setEnabled(false);
            this.imP.setTextColor(getResources().getColor(2131689547));
            this.imP.setFocusable(false);
            this.imP.setClickable(false);
        }
        if (this.dxV) {
            this.dxX = false;
        } else {
            this.dxX = true;
            this.imP.setEnabled(false);
            this.imP.setFocusable(false);
            this.imP.setClickable(false);
        }
        if (this.dxZ != -1) {
            this.imP.setFilters(new InputFilter[]{new LengthFilter(this.dxZ)});
        }
        v.d("MicroMsg.MallEditText", "initData editType:" + this.dxT);
        switch (this.dxT) {
            case 1:
                v.d("MicroMsg.MallEditText", "setMobileEditTv");
                List aJj = com.tencent.mm.plugin.recharge.a.a.aJi().aJj();
                this.imR = new a();
                this.imR.bc(aJj);
                if (aJj != null && aJj.size() > 0) {
                    this.imU = (com.tencent.mm.plugin.recharge.model.a) aJj.get(0);
                    b(this.imU);
                } else if (this.imT == null) {
                    new Runnable(this) {
                        final /* synthetic */ MallEditText imY;

                        {
                            this.imY = r1;
                        }

                        public final void run() {
                            try {
                                this.imY.imT = com.tencent.mm.pluginsdk.a.cW(this.imY.getContext());
                            } catch (Throwable e) {
                                v.a("MicroMsg.MallEditText", e, "", new Object[0]);
                            }
                        }
                    }.run();
                }
                if (aJj == null || aJj.size() == 0) {
                    ak.yW();
                    this.imP.setText((String) com.tencent.mm.model.c.vf().get(6, null));
                    this.imP.setSelection(this.imP.getText().length());
                    aJk();
                }
                this.imP.setAdapter(this.imR);
                this.imP.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ MallEditText imY;

                    {
                        this.imY = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.imY.imU = this.imY.imR.oH(i);
                        if (this.imY.imU != null) {
                            v.d("MicroMsg.MallEditText", "onItemClick record.record " + this.imY.imU.imk + ", record.name " + this.imY.imU.name);
                            this.imY.b(this.imY.imU);
                        }
                        this.imY.imP.dismissDropDown();
                    }
                });
                return;
            default:
                return;
        }
    }

    public MallEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void oG(int i) {
        this.imQ = i == 2130838465;
        this.dxQ.setImageResource(i);
    }

    public final void b(com.tencent.mm.plugin.recharge.model.a aVar) {
        this.imU = aVar;
        if (aVar != null) {
            this.imP.setText(aVar.imk);
            this.imP.setSelection(this.imP.getText().length());
            aJk();
            v.d("MicroMsg.MallEditText", "editTv.setText " + aVar.imk + ", name " + aVar.name + ", isInputValid " + this.dxX);
            if (be.kS(aVar.name) || !this.dxX) {
                this.duy.setText("");
                this.duy.setVisibility(8);
                return;
            }
            this.duy.setText(aVar.name);
            this.duy.setVisibility(0);
            return;
        }
        this.imP.setText("");
        aJk();
        v.d("MicroMsg.MallEditText", "editTv.setText null");
        this.duy.setText("");
        this.duy.setVisibility(8);
    }

    private void aJk() {
        boolean Ou = Ou();
        if (Ou != this.dxX) {
            v.d("MicroMsg.MallEditText", "View:" + this.dxS + ", editType:" + this.dxT + " inputValid change to " + Ou);
            this.dxX = Ou;
            if (this.imO != null) {
                this.imO.fc(this.dxX);
            }
            if (!Ou) {
                if (this.duy.getVisibility() == 0) {
                    this.duy.setText("");
                    this.duy.setVisibility(8);
                }
                this.imU = null;
            }
        }
        if (this.imO != null) {
            this.imO.aJm();
        }
    }

    public final String getText() {
        switch (this.dxT) {
            case 1:
                return be.ah(this.imP.getText().toString(), "");
            default:
                return be.ah(this.imP.getText().toString(), "");
        }
    }

    public final boolean Ou() {
        switch (this.dxT) {
            case 1:
                String obj = this.imP.getText().toString();
                if (obj.length() < this.dxY || obj.length() > this.dxZ || !PhoneNumberUtils.isGlobalPhoneNumber(com.tencent.mm.plugin.recharge.model.b.yt(obj))) {
                    return false;
                }
                return true;
            default:
                if (this.imP.getText().length() >= this.dxY) {
                    return true;
                }
                return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.dxV) {
            return false;
        }
        return true;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.imP.setOnClickListener(onClickListener);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.dxN = onFocusChangeListener;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.dxN != null) {
            this.dxN.onFocusChange(this, z);
        }
        if (!((!this.imW) != z || z || this.imV == null)) {
            this.imV.run();
        }
        this.imW = z;
        v.d("MicroMsg.MallEditText", "View:" + this.dxS + ", editType:" + this.dxT + " onFocusChange to " + z);
        if (this.imO != null) {
            this.imO.fc(this.dxX);
        }
    }

    public final com.tencent.mm.plugin.recharge.model.a aJl() {
        if (this.imU != null) {
            return this.imU;
        }
        this.imU = new com.tencent.mm.plugin.recharge.model.a(getText(), this.duy.getText().toString(), 0);
        return this.imU;
    }
}
