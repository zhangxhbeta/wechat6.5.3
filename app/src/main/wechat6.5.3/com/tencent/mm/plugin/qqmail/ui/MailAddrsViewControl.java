package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.x;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class MailAddrsViewControl extends RelativeLayout {
    private static final Pattern ift = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    private boolean dxV = false;
    private ac handler = new ac();
    private GestureDetector iev;
    LinkedList<i> ifn = new LinkedList();
    AutoCompleteTextView ifo;
    private b ifp;
    c ifq;
    private View ifr;
    a ifs = null;
    private SimpleOnGestureListener ifu = new SimpleOnGestureListener(this) {
        final /* synthetic */ MailAddrsViewControl ifv;

        {
            this.ifv = r1;
        }

        private void aIo() {
            i iVar = (i) this.ifv.ifr.getTag();
            if (this.ifv.ifq != null) {
                this.ifv.ifq;
                this.ifv.ifr;
            }
            Intent intent = new Intent(this.ifv.getContext(), MailAddrProfileUI.class);
            intent.putExtra("name", iVar.name);
            intent.putExtra("addr", iVar.gRG);
            intent.putExtra("can_compose", !this.ifv.dxV);
            this.ifv.getContext().startActivity(intent);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            if (!this.ifv.dxV) {
                aIo();
            }
            return true;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            if (this.ifv.ifq != null && this.ifv.ifr != null) {
                this.ifv.ifq;
                this.ifv.ifr;
                this.ifv.ifr.getTag();
            }
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            aIo();
            return true;
        }
    };

    public interface a {
        void aHX();

        void b(MailAddrsViewControl mailAddrsViewControl);
    }

    public static class b extends BaseAdapter implements Filterable {
        private ArrayList<i> ifA;
        private a ifB;
        private List<i> ify;
        private boolean ifz = true;
        private Context mContext;
        private final Object mLock = new Object();

        private class a extends Filter {
            final /* synthetic */ b ifC;

            private a(b bVar) {
                this.ifC = bVar;
            }

            protected final FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                if (this.ifC.ifA == null) {
                    synchronized (this.ifC.mLock) {
                        this.ifC.ifA = new ArrayList(this.ifC.ify);
                    }
                }
                if (charSequence == null || charSequence.length() == 0) {
                    synchronized (this.ifC.mLock) {
                        ArrayList arrayList = new ArrayList(this.ifC.ifA);
                        filterResults.values = arrayList;
                        filterResults.count = arrayList.size();
                    }
                } else {
                    CharSequence toLowerCase = charSequence.toString().toLowerCase();
                    ArrayList b = this.ifC.ifA;
                    int size = b.size();
                    ArrayList arrayList2 = new ArrayList(size);
                    for (int i = 0; i < size; i++) {
                        i iVar = (i) b.get(i);
                        if (iVar.name.toLowerCase().contains(toLowerCase) || iVar.gRG.toLowerCase().contains(toLowerCase)) {
                            arrayList2.add(iVar);
                        }
                    }
                    filterResults.values = arrayList2;
                    filterResults.count = arrayList2.size();
                }
                return filterResults;
            }

            protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
                this.ifC.ify = (List) filterResults.values;
                if (filterResults.count > 0) {
                    this.ifC.notifyDataSetChanged();
                    return;
                }
                this.ifC.ify = new ArrayList(this.ifC.ifA);
                this.ifC.notifyDataSetInvalidated();
            }
        }

        private class b {
            TextView eVA;
            final /* synthetic */ b ifC;
            CheckBox ifD;
            TextView ifj;

            private b(b bVar) {
                this.ifC = bVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return oz(i);
        }

        public b(Context context, List<i> list) {
            this.mContext = context;
            this.ify = list;
        }

        public final void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            this.ifz = true;
        }

        public final int getCount() {
            return this.ify.size();
        }

        public final i oz(int i) {
            return (i) this.ify.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(this.mContext, 2130904214, null);
                b bVar = new b();
                bVar.eVA = (TextView) view.findViewById(2131758685);
                bVar.ifj = (TextView) view.findViewById(2131758686);
                bVar.ifD = (CheckBox) view.findViewById(2131758687);
                view.setTag(bVar);
            } else {
                ViewGroup viewGroup2 = (ViewGroup) view;
            }
            i oz = oz(i);
            b bVar2 = (b) view.getTag();
            bVar2.eVA.setText(oz.name);
            bVar2.ifj.setText(oz.gRG);
            bVar2.ifD.setVisibility(8);
            view.setBackgroundColor(-789517);
            return view;
        }

        public final Filter getFilter() {
            if (this.ifB == null) {
                this.ifB = new a();
            }
            return this.ifB;
        }
    }

    public static abstract class c {
        public void eS(boolean z) {
        }
    }

    public final boolean aIi() {
        Editable text = this.ifo.getText();
        if (text == null || text.toString().length() <= 0) {
            return true;
        }
        return false;
    }

    public MailAddrsViewControl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iev = new GestureDetector(context, this.ifu);
    }

    public final void aIj() {
        this.dxV = true;
        if (this.ifo == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (!(childAt instanceof AutoCompleteTextView)) {
                    if (childAt instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) childAt;
                        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                            View childAt2 = viewGroup.getChildAt(i2);
                            if (childAt2 instanceof AutoCompleteTextView) {
                                this.ifo = (AutoCompleteTextView) childAt2;
                            }
                        }
                    }
                    if (this.ifo != null) {
                        break;
                    }
                    i++;
                } else {
                    this.ifo = (AutoCompleteTextView) childAt;
                    break;
                }
            }
            if (this.ifo != null) {
                this.ifo.setDropDownBackgroundResource(2130838950);
                setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ MailAddrsViewControl ifv;

                    {
                        this.ifv = r1;
                    }

                    public final void onClick(View view) {
                        this.ifv.ifo.requestFocus();
                        ((InputMethodManager) this.ifv.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
                    }
                });
                this.ifo.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ MailAddrsViewControl ifv;

                    {
                        this.ifv = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.ifv.e(this.ifv.ifp.oz(i));
                        this.ifv.ifo.setText("");
                    }
                });
                this.ifo.setOnEditorActionListener(new OnEditorActionListener(this) {
                    final /* synthetic */ MailAddrsViewControl ifv;

                    {
                        this.ifv = r1;
                    }

                    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        if (i == 5) {
                            String obj = this.ifv.ifo.getEditableText().toString();
                            if (obj != null && obj.length() > 0) {
                                this.ifv.ab(obj, false);
                                this.ifv.aIn();
                            }
                        }
                        return true;
                    }
                });
                this.ifo.setOnKeyListener(new OnKeyListener(this) {
                    final /* synthetic */ MailAddrsViewControl ifv;

                    {
                        this.ifv = r1;
                    }

                    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                        String obj;
                        if (i == 67 && keyEvent.getAction() == 0) {
                            obj = this.ifv.ifo.getEditableText().toString();
                            if (obj.length() == 0 && this.ifv.ifr != null && this.ifv.ifr.isSelected()) {
                                this.ifv.f((i) this.ifv.ifr.getTag());
                                this.ifv.ifr = null;
                                this.ifv.aIn();
                            } else if (obj.length() == 0 && this.ifv.ifn.size() > 0) {
                                int size = this.ifv.ifn.size() - 1;
                                View childAt = this.ifv.getChildAt(size);
                                if (childAt.isSelected()) {
                                    this.ifv.f((i) this.ifv.ifn.get(size));
                                    this.ifv.aIn();
                                } else {
                                    childAt.setSelected(true);
                                }
                            }
                        } else if (i == 66 && keyEvent.getAction() == 0) {
                            obj = this.ifv.ifo.getEditableText().toString();
                            if (obj != null && obj.length() > 0) {
                                this.ifv.ab(obj, true);
                                this.ifv.aIn();
                            }
                        }
                        return false;
                    }
                });
                this.ifo.addTextChangedListener(new TextWatcher(this) {
                    final /* synthetic */ MailAddrsViewControl ifv;

                    {
                        this.ifv = r1;
                    }

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.endsWith("\n") || charSequence2.endsWith(" ")) {
                            this.ifv.ab(charSequence2, true);
                        }
                        this.ifv.aIn();
                    }

                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void afterTextChanged(Editable editable) {
                    }
                });
                this.ifo.setOnFocusChangeListener(new OnFocusChangeListener(this) {
                    final /* synthetic */ MailAddrsViewControl ifv;

                    {
                        this.ifv = r1;
                    }

                    public final void onFocusChange(View view, boolean z) {
                        if (this.ifv.ifq != null) {
                            this.ifv.ifq.eS(z);
                        }
                        String obj = this.ifv.ifo.getEditableText().toString();
                        if (!z && obj.trim().length() > 0) {
                            this.ifv.ab(obj, false);
                        }
                        if (this.ifv.ifr != null && this.ifv.ifr.isSelected()) {
                            this.ifv.ifr.setSelected(z);
                            this.ifv.ifr = null;
                        }
                        this.ifv.aIn();
                    }
                });
            }
        }
    }

    public final void a(b bVar) {
        if (this.ifo != null) {
            this.ifp = bVar;
            this.ifo.setAdapter(bVar);
        }
    }

    public final String[] a(boolean z, d dVar) {
        int i = 0;
        String userBindEmail;
        if (dVar == null || !dVar.isConnected()) {
            userBindEmail = k.getUserBindEmail();
        } else {
            try {
                userBindEmail = (String) new ReadMailProxy(dVar, null).REMOTE_CALL("getUserBindEmail", new Object[0]);
            } catch (Exception e) {
                v.e("MicroMsg.QQMail.MailAddrsViewControl", "getMailAddrStringArray, getUserBindEmail fail, ex = %s", new Object[]{e.getMessage()});
                return null;
            }
        }
        String[] strArr = new String[this.ifn.size()];
        while (i < this.ifn.size()) {
            i iVar = (i) this.ifn.get(i);
            if (z && iVar.gRG.equalsIgnoreCase(r1)) {
                strArr[i] = "";
            } else {
                strArr[i] = iVar.name + " " + iVar.gRG;
            }
            i++;
        }
        return strArr;
    }

    public final boolean aIk() {
        String trim = this.ifo.getEditableText().toString().trim();
        return !be.kS(trim) && yk(trim);
    }

    public final String aIl() {
        if (aIk()) {
            ab(this.ifo.getEditableText().toString(), false);
        }
        String str = "";
        for (int i = 0; i < this.ifn.size(); i++) {
            i iVar = (i) this.ifn.get(i);
            if (i != 0) {
                str = str + ",";
            }
            str = str + iVar.gRG;
        }
        return str;
    }

    public final void e(i iVar) {
        if (iVar != null) {
            Object obj;
            Iterator it = this.ifn.iterator();
            while (it.hasNext()) {
                if (((i) it.next()).gRG.equalsIgnoreCase(iVar.gRG)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                ViewGroup viewGroup = (ViewGroup) View.inflate(getContext(), 2130904212, null);
                final Button button = (Button) viewGroup.findViewById(2131758688);
                viewGroup.removeView((View) button.getParent());
                button.setText(iVar.name);
                if (this.dxV) {
                    button.setCompoundDrawables(null, null, null, null);
                }
                button.setTag(this.ifn.size());
                View view = (View) button.getParent();
                button.setTag(iVar);
                view.setVisibility(4);
                view.setTag(iVar);
                addView(view, this.ifn.size());
                this.ifn.add(iVar);
                this.handler.postDelayed(new Runnable(this) {
                    final /* synthetic */ MailAddrsViewControl ifv;

                    public final void run() {
                        button.invalidate();
                        button.setOnTouchListener(new OnTouchListener(this) {
                            final /* synthetic */ AnonymousClass2 ifx;

                            {
                                this.ifx = r1;
                            }

                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                if (!(this.ifx.ifv.ifr == null || this.ifx.ifv.ifr == view || !this.ifx.ifv.ifr.isSelected())) {
                                    this.ifx.ifv.ifr.setSelected(false);
                                    this.ifx.ifv.ifr = null;
                                }
                                this.ifx.ifv.ifr = view;
                                if (this.ifx.ifv.ifo != null && motionEvent.getAction() == 0) {
                                    button.setSelected(!button.isSelected());
                                    this.ifx.ifv.ifo.setVisibility(0);
                                    this.ifx.ifv.ifo.requestFocus();
                                    ((InputMethodManager) this.ifx.ifv.getContext().getSystemService("input_method")).toggleSoftInput(0, 1);
                                }
                                return this.ifx.ifv.iev.onTouchEvent(motionEvent);
                            }
                        });
                        this.ifv.aIn();
                        this.ifv.invalidate();
                    }
                }, 100);
            }
        }
    }

    public final void a(String[] strArr, boolean z) {
        if (z) {
            removeAllViews();
            this.ifn.clear();
            aIn();
            invalidate();
        }
        if (strArr != null && strArr.length != 0) {
            for (String yb : strArr) {
                i yb2 = j.yb(yb);
                if (yb2 != null) {
                    e(yb2);
                }
            }
        }
    }

    public final void bb(List<i> list) {
        if (list != null) {
            for (i e : list) {
                e(e);
            }
        }
    }

    public final void f(i iVar) {
        for (int i = 0; i < this.ifn.size(); i++) {
            if (iVar.gRG.equalsIgnoreCase(((i) this.ifn.get(i)).gRG)) {
                removeViewAt(i);
                this.ifn.remove(i);
                aIn();
                invalidate();
                return;
            }
        }
    }

    private static boolean yk(String str) {
        return ift.matcher(str).matches();
    }

    public final boolean aIm() {
        Iterator it = this.ifn.iterator();
        while (it.hasNext()) {
            if (!yk(((i) it.next()).gRG)) {
                return false;
            }
        }
        return true;
    }

    final void aIn() {
        int childCount = getChildCount();
        int measuredWidth = getMeasuredWidth();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8 || (childAt instanceof AutoCompleteTextView)) {
                int i4;
                int width = childAt.getWidth();
                int height = childAt.getHeight();
                if (width == 0) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
                    width = childAt.getMeasuredWidth();
                }
                if (this.ifo == null || i != childCount - 1 || this.ifo.isFocused()) {
                    i4 = width;
                } else {
                    i4 = 0;
                }
                if (i3 + i4 > measuredWidth) {
                    i2 += height;
                    i3 = 0;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.setMargins(i3, i2, layoutParams.rightMargin, layoutParams.bottomMargin);
                childAt.setLayoutParams(layoutParams);
                i3 += i4;
                childAt.setVisibility(0);
            }
            i++;
        }
    }

    private void ab(String str, boolean z) {
        Object trim = str.trim();
        if (trim.length() != 0) {
            List ya = x.aHG().ibk.ya(trim);
            if (ya.size() > 0) {
                e((i) ya.get(0));
                this.ifo.setText("");
            } else if (yk(trim)) {
                i iVar = new i();
                iVar.name = trim;
                iVar.gRG = trim;
                iVar.iaN = 0;
                e(iVar);
                this.ifo.setText("");
            } else if (z) {
                if (this.ifs != null) {
                    this.ifs.aHX();
                } else {
                    Toast.makeText(getContext(), 2131234219, 2000).show();
                }
                this.ifo.setText(trim);
                this.ifo.setSelection(trim.length());
            } else if (this.ifs != null) {
                this.ifs.b(this);
            }
        }
    }
}
