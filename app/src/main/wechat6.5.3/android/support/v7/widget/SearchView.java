package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.view.f;
import android.support.v4.widget.e;
import android.support.v7.a.a.h;
import android.support.v7.a.a.k;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements android.support.v7.view.c {
    static final a abM = new a();
    private static final boolean abd;
    private final OnItemSelectedListener Fp;
    private final h Ts;
    private boolean abA;
    private e abB;
    private boolean abC;
    private CharSequence abD;
    private boolean abE;
    private boolean abF;
    private CharSequence abG;
    private CharSequence abH;
    private boolean abI;
    private int abJ;
    private SearchableInfo abK;
    private Bundle abL;
    private Runnable abN;
    private final Runnable abO;
    private Runnable abP;
    private final WeakHashMap<String, ConstantState> abQ;
    OnKeyListener abR;
    private final OnEditorActionListener abS;
    private final OnItemClickListener abT;
    private TextWatcher abU;
    private final SearchAutoComplete abe;
    private final View abf;
    private final View abg;
    private final View abh;
    private final ImageView abi;
    private final ImageView abj;
    private final ImageView abk;
    private final ImageView abl;
    private final View abm;
    private final ImageView abn;
    private final Drawable abo;
    private final int abp;
    private final int abq;
    private final Intent abr;
    private final Intent abs;
    private final CharSequence abt;
    private c abu;
    private b abv;
    private OnFocusChangeListener abw;
    private d abx;
    private OnClickListener aby;
    private boolean abz;
    private int iN;
    private final OnClickListener mOnClickListener;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean aca;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.aca = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.aca));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.aca + "}";
        }
    }

    private static class a {
        Method abW;
        Method abX;
        private Method abY;
        Method abZ;

        a() {
            try {
                this.abW = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.abW.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.abX = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.abX.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.abY = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.abY.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.abZ = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
                this.abZ.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        final void a(AutoCompleteTextView autoCompleteTextView) {
            if (this.abY != null) {
                try {
                    this.abY.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(true)});
                } catch (Exception e) {
                }
            }
        }
    }

    public interface b {
        boolean onClose();
    }

    public interface c {
        boolean gG();
    }

    public interface d {
        boolean gH();

        boolean gI();
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private int acb;
        SearchView acc;

        static /* synthetic */ boolean a(SearchAutoComplete searchAutoComplete) {
            return TextUtils.getTrimmedLength(searchAutoComplete.getText()) == 0;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, android.support.v7.a.a.a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.acb = getThreshold();
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.acb = i;
        }

        protected void replaceText(CharSequence charSequence) {
        }

        public void performCompletion() {
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.acc.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.n(getContext())) {
                    SearchView.abM.a(this);
                }
            }
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.acc.gE();
        }

        public boolean enoughToFilter() {
            return this.acb <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.acc.clearFocus();
                        this.acc.V(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }
    }

    static /* synthetic */ void a(SearchView searchView) {
        int[] iArr = searchView.abe.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = searchView.abg.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        background = searchView.abh.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        searchView.invalidate();
    }

    static /* synthetic */ void a(SearchView searchView, CharSequence charSequence) {
        boolean z = true;
        CharSequence text = searchView.abe.getText();
        searchView.abH = text;
        boolean z2 = !TextUtils.isEmpty(text);
        searchView.U(z2);
        if (z2) {
            z = false;
        }
        searchView.W(z);
        searchView.gA();
        searchView.gz();
        if (!(searchView.abu == null || TextUtils.equals(charSequence, searchView.abG))) {
            charSequence.toString();
        }
        searchView.abG = charSequence.toString();
    }

    static /* synthetic */ boolean b(SearchView searchView, int i) {
        if (searchView.abx != null && searchView.abx.gH()) {
            return false;
        }
        CharSequence text = searchView.abe.getText();
        Cursor cursor = searchView.abB.Ay;
        if (cursor != null) {
            if (cursor.moveToPosition(i)) {
                CharSequence convertToString = searchView.abB.convertToString(cursor);
                if (convertToString != null) {
                    searchView.h(convertToString);
                } else {
                    searchView.h(text);
                }
            } else {
                searchView.h(text);
            }
        }
        return true;
    }

    static /* synthetic */ void d(SearchView searchView) {
        if (searchView.abm.getWidth() > 1) {
            Resources resources = searchView.getContext().getResources();
            int paddingLeft = searchView.abg.getPaddingLeft();
            Rect rect = new Rect();
            boolean bu = as.bu(searchView);
            int dimensionPixelSize = searchView.abz ? resources.getDimensionPixelSize(android.support.v7.a.a.d.Ic) + resources.getDimensionPixelSize(android.support.v7.a.a.d.Ib) : 0;
            searchView.abe.getDropDownBackground().getPadding(rect);
            searchView.abe.setDropDownHorizontalOffset(bu ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            searchView.abe.setDropDownWidth((dimensionPixelSize + ((searchView.abm.getWidth() + rect.left) + rect.right)) - paddingLeft);
        }
    }

    static /* synthetic */ void h(SearchView searchView) {
        if (!TextUtils.isEmpty(searchView.abe.getText())) {
            searchView.abe.setText(SQLiteDatabase.KeyEmpty);
            searchView.abe.requestFocus();
            searchView.V(true);
        } else if (!searchView.abz) {
        } else {
            if (searchView.abv == null || !searchView.abv.onClose()) {
                searchView.clearFocus();
                searchView.T(true);
            }
        }
    }

    static /* synthetic */ void j(SearchView searchView) {
        CharSequence text = searchView.abe.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (searchView.abu != null) {
                c cVar = searchView.abu;
                text.toString();
                if (cVar.gG()) {
                    return;
                }
            }
            if (searchView.abK != null) {
                searchView.a(0, null, text.toString());
            }
            searchView.V(false);
            searchView.abe.dismissDropDown();
        }
    }

    static /* synthetic */ void l(SearchView searchView) {
        String str = null;
        if (searchView.abK != null) {
            SearchableInfo searchableInfo = searchView.abK;
            try {
                Intent intent;
                String str2;
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    intent = new Intent(searchView.abr);
                    ComponentName searchActivity = searchableInfo.getSearchActivity();
                    str2 = "calling_package";
                    if (searchActivity != null) {
                        str = searchActivity.flattenToShortString();
                    }
                    intent.putExtra(str2, str);
                    searchView.getContext().startActivity(intent);
                } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    String string;
                    Intent intent2 = searchView.abs;
                    ComponentName searchActivity2 = searchableInfo.getSearchActivity();
                    intent = new Intent("android.intent.action.SEARCH");
                    intent.setComponent(searchActivity2);
                    Parcelable activity = PendingIntent.getActivity(searchView.getContext(), 0, intent, 1073741824);
                    Bundle bundle = new Bundle();
                    if (searchView.abL != null) {
                        bundle.putParcelable("app_data", searchView.abL);
                    }
                    Intent intent3 = new Intent(intent2);
                    String str3 = "free_form";
                    int i = 1;
                    if (VERSION.SDK_INT >= 8) {
                        Resources resources = searchView.getResources();
                        string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : str3;
                        str2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
                        str3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
                        if (searchableInfo.getVoiceMaxResults() != 0) {
                            i = searchableInfo.getVoiceMaxResults();
                        }
                    } else {
                        str2 = null;
                        string = str3;
                        str3 = null;
                    }
                    intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
                    intent3.putExtra("android.speech.extra.PROMPT", str2);
                    intent3.putExtra("android.speech.extra.LANGUAGE", str3);
                    intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
                    String str4 = "calling_package";
                    if (searchActivity2 != null) {
                        str = searchActivity2.flattenToShortString();
                    }
                    intent3.putExtra(str4, str);
                    intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
                    intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
                    searchView.getContext().startActivity(intent3);
                }
            } catch (ActivityNotFoundException e) {
            }
        }
    }

    static {
        boolean z;
        if (VERSION.SDK_INT >= 8) {
            z = true;
        } else {
            z = false;
        }
        abd = z;
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abN = new Runnable(this) {
            final /* synthetic */ SearchView abV;

            {
                this.abV = r1;
            }

            public final void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) this.abV.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    a aVar = SearchView.abM;
                    View view = this.abV;
                    if (aVar.abZ != null) {
                        try {
                            aVar.abZ.invoke(inputMethodManager, new Object[]{Integer.valueOf(0), null});
                            return;
                        } catch (Exception e) {
                        }
                    }
                    inputMethodManager.showSoftInput(view, 0);
                }
            }
        };
        this.abO = new Runnable(this) {
            final /* synthetic */ SearchView abV;

            {
                this.abV = r1;
            }

            public final void run() {
                SearchView.a(this.abV);
            }
        };
        this.abP = new Runnable(this) {
            final /* synthetic */ SearchView abV;

            {
                this.abV = r1;
            }

            public final void run() {
                if (this.abV.abB != null && (this.abV.abB instanceof ak)) {
                    this.abV.abB.changeCursor(null);
                }
            }
        };
        this.abQ = new WeakHashMap();
        this.mOnClickListener = new OnClickListener(this) {
            final /* synthetic */ SearchView abV;

            {
                this.abV = r1;
            }

            public final void onClick(View view) {
                if (view == this.abV.abi) {
                    this.abV.gD();
                } else if (view == this.abV.abk) {
                    SearchView.h(this.abV);
                } else if (view == this.abV.abj) {
                    SearchView.j(this.abV);
                } else if (view == this.abV.abl) {
                    SearchView.l(this.abV);
                } else if (view == this.abV.abe) {
                    this.abV.gF();
                }
            }
        };
        this.abR = new OnKeyListener(this) {
            final /* synthetic */ SearchView abV;

            {
                this.abV = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (this.abV.abK == null) {
                    return false;
                }
                if (this.abV.abe.isPopupShowing() && this.abV.abe.getListSelection() != -1) {
                    return this.abV.b(i, keyEvent);
                }
                if (SearchAutoComplete.a(this.abV.abe) || !f.a(keyEvent) || keyEvent.getAction() != 1 || i != 66) {
                    return false;
                }
                view.cancelLongPress();
                this.abV.a(0, null, this.abV.abe.getText().toString());
                return true;
            }
        };
        this.abS = new OnEditorActionListener(this) {
            final /* synthetic */ SearchView abV;

            {
                this.abV = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                SearchView.j(this.abV);
                return true;
            }
        };
        this.abT = new OnItemClickListener(this) {
            final /* synthetic */ SearchView abV;

            {
                this.abV = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.abV.bi(i);
            }
        };
        this.Fp = new OnItemSelectedListener(this) {
            final /* synthetic */ SearchView abV;

            {
                this.abV = r1;
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                SearchView.b(this.abV, i);
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.abU = new TextWatcher(this) {
            final /* synthetic */ SearchView abV;

            {
                this.abV = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SearchView.a(this.abV, charSequence);
            }

            public final void afterTextChanged(Editable editable) {
            }
        };
        this.Ts = h.eD();
        ap a = ap.a(context, attributeSet, k.cG, i);
        LayoutInflater.from(context).inflate(a.getResourceId(k.Me, h.JZ), this, true);
        this.abe = (SearchAutoComplete) findViewById(android.support.v7.a.a.f.Jy);
        this.abe.acc = this;
        this.abf = findViewById(android.support.v7.a.a.f.Ju);
        this.abg = findViewById(android.support.v7.a.a.f.Jx);
        this.abh = findViewById(android.support.v7.a.a.f.JD);
        this.abi = (ImageView) findViewById(android.support.v7.a.a.f.Js);
        this.abj = (ImageView) findViewById(android.support.v7.a.a.f.Jv);
        this.abk = (ImageView) findViewById(android.support.v7.a.a.f.Jt);
        this.abl = (ImageView) findViewById(android.support.v7.a.a.f.Jz);
        this.abn = (ImageView) findViewById(android.support.v7.a.a.f.Jw);
        this.abg.setBackgroundDrawable(a.getDrawable(k.Mf));
        this.abh.setBackgroundDrawable(a.getDrawable(k.Mj));
        this.abi.setImageDrawable(a.getDrawable(k.Mi));
        this.abj.setImageDrawable(a.getDrawable(k.Mc));
        this.abk.setImageDrawable(a.getDrawable(k.LZ));
        this.abl.setImageDrawable(a.getDrawable(k.Ml));
        this.abn.setImageDrawable(a.getDrawable(k.Mi));
        this.abo = a.getDrawable(k.Mh);
        this.abp = a.getResourceId(k.Mk, h.JY);
        this.abq = a.getResourceId(k.Ma, 0);
        this.abi.setOnClickListener(this.mOnClickListener);
        this.abk.setOnClickListener(this.mOnClickListener);
        this.abj.setOnClickListener(this.mOnClickListener);
        this.abl.setOnClickListener(this.mOnClickListener);
        this.abe.setOnClickListener(this.mOnClickListener);
        this.abe.addTextChangedListener(this.abU);
        this.abe.setOnEditorActionListener(this.abS);
        this.abe.setOnItemClickListener(this.abT);
        this.abe.setOnItemSelectedListener(this.Fp);
        this.abe.setOnKeyListener(this.abR);
        this.abe.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ SearchView abV;

            {
                this.abV = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (this.abV.abw != null) {
                    this.abV.abw.onFocusChange(this.abV, z);
                }
            }
        });
        boolean z = a.getBoolean(k.Md, true);
        if (this.abz != z) {
            this.abz = z;
            T(z);
            gC();
        }
        int dimensionPixelSize = a.getDimensionPixelSize(k.LY, -1);
        if (dimensionPixelSize != -1) {
            this.iN = dimensionPixelSize;
            requestLayout();
        }
        this.abt = a.getText(k.Mb);
        this.abD = a.getText(k.Mg);
        dimensionPixelSize = a.getInt(k.LW, -1);
        if (dimensionPixelSize != -1) {
            this.abe.setImeOptions(dimensionPixelSize);
        }
        dimensionPixelSize = a.getInt(k.LX, -1);
        if (dimensionPixelSize != -1) {
            this.abe.setInputType(dimensionPixelSize);
        }
        setFocusable(a.getBoolean(k.LV, true));
        a.adM.recycle();
        this.abr = new Intent("android.speech.action.WEB_SEARCH");
        this.abr.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.abr.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.abs = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.abs.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.abm = findViewById(this.abe.getDropDownAnchor());
        if (this.abm != null) {
            if (VERSION.SDK_INT >= 11) {
                this.abm.addOnLayoutChangeListener(new OnLayoutChangeListener(this) {
                    final /* synthetic */ SearchView abV;

                    {
                        this.abV = r1;
                    }

                    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                        SearchView.d(this.abV);
                    }
                });
            } else {
                this.abm.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                    final /* synthetic */ SearchView abV;

                    {
                        this.abV = r1;
                    }

                    public final void onGlobalLayout() {
                        SearchView.d(this.abV);
                    }
                });
            }
        }
        T(this.abz);
        gC();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.abE || !isFocusable()) {
            return false;
        }
        if (this.abA) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.abe.requestFocus(i, rect);
        if (requestFocus) {
            T(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.abE = true;
        V(false);
        super.clearFocus();
        this.abe.clearFocus();
        this.abE = false;
    }

    protected void onMeasure(int i, int i2) {
        if (this.abA) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.iN <= 0) {
                    size = Math.min(gx(), size);
                    break;
                } else {
                    size = Math.min(this.iN, size);
                    break;
                }
            case 0:
                if (this.iN <= 0) {
                    size = gx();
                    break;
                } else {
                    size = this.iN;
                    break;
                }
            case 1073741824:
                if (this.iN > 0) {
                    size = Math.min(this.iN, size);
                    break;
                }
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    private int gx() {
        return getContext().getResources().getDimensionPixelSize(android.support.v7.a.a.d.Id);
    }

    private void T(boolean z) {
        boolean z2;
        boolean z3 = true;
        int i = 8;
        this.abA = z;
        int i2 = z ? 0 : 8;
        if (TextUtils.isEmpty(this.abe.getText())) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.abi.setVisibility(i2);
        U(z2);
        View view = this.abf;
        if (z) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view.setVisibility(i2);
        if (!(this.abn.getDrawable() == null || this.abz)) {
            i = 0;
        }
        this.abn.setVisibility(i);
        gA();
        if (z2) {
            z3 = false;
        }
        W(z3);
        gz();
    }

    private boolean gy() {
        return (this.abC || this.abF) && !this.abA;
    }

    private void U(boolean z) {
        int i = 8;
        if (this.abC && gy() && hasFocus() && (z || !this.abF)) {
            i = 0;
        }
        this.abj.setVisibility(i);
    }

    private void gz() {
        int i = 8;
        if (gy() && (this.abj.getVisibility() == 0 || this.abl.getVisibility() == 0)) {
            i = 0;
        }
        this.abh.setVisibility(i);
    }

    private void gA() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.abe.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.abz || this.abI)) {
            i = 0;
        }
        ImageView imageView = this.abk;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.abk.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void gB() {
        post(this.abO);
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.abO);
        post(this.abP);
        super.onDetachedFromWindow();
    }

    private void V(boolean z) {
        if (z) {
            post(this.abN);
            return;
        }
        removeCallbacks(this.abN);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private boolean b(int i, KeyEvent keyEvent) {
        if (this.abK == null || this.abB == null || keyEvent.getAction() != 0 || !f.a(keyEvent)) {
            return false;
        }
        if (i == 66 || i == 84 || i == 61) {
            return bi(this.abe.getListSelection());
        }
        if (i != 21 && i != 22) {
            return (i == 19 && this.abe.getListSelection() == 0) ? false : false;
        } else {
            int i2;
            if (i == 21) {
                i2 = 0;
            } else {
                i2 = this.abe.length();
            }
            this.abe.setSelection(i2);
            this.abe.setListSelection(0);
            this.abe.clearListSelection();
            abM.a(this.abe);
            return true;
        }
    }

    private void gC() {
        CharSequence text = this.abD != null ? this.abD : (!abd || this.abK == null || this.abK.getHintId() == 0) ? this.abt : getContext().getText(this.abK.getHintId());
        SearchAutoComplete searchAutoComplete = this.abe;
        if (text == null) {
            text = SQLiteDatabase.KeyEmpty;
        }
        if (this.abz && this.abo != null) {
            int textSize = (int) (((double) this.abe.getTextSize()) * 1.25d);
            this.abo.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.abo), 1, 2, 33);
            spannableStringBuilder.append(text);
            Object obj = spannableStringBuilder;
        }
        searchAutoComplete.setHint(text);
    }

    private void W(boolean z) {
        int i;
        if (this.abF && !this.abA && z) {
            i = 0;
            this.abj.setVisibility(8);
        } else {
            i = 8;
        }
        this.abl.setVisibility(i);
    }

    private void gD() {
        T(false);
        this.abe.requestFocus();
        V(true);
        if (this.aby != null) {
            this.aby.onClick(this);
        }
    }

    final void gE() {
        T(this.abA);
        gB();
        if (this.abe.hasFocus()) {
            gF();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        gB();
    }

    public final void onActionViewCollapsed() {
        CharSequence charSequence = SQLiteDatabase.KeyEmpty;
        this.abe.setText(charSequence);
        this.abe.setSelection(this.abe.length());
        this.abH = charSequence;
        clearFocus();
        T(true);
        this.abe.setImeOptions(this.abJ);
        this.abI = false;
    }

    public final void onActionViewExpanded() {
        if (!this.abI) {
            this.abI = true;
            this.abJ = this.abe.getImeOptions();
            this.abe.setImeOptions(this.abJ | 33554432);
            this.abe.setText(SQLiteDatabase.KeyEmpty);
            gD();
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.aca = this.abA;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            T(savedState.aca);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private boolean bi(int i) {
        if (this.abx != null && this.abx.gI()) {
            return false;
        }
        Cursor cursor = this.abB.Ay;
        if (cursor != null && cursor.moveToPosition(i)) {
            Intent a = a(cursor, 0, null);
            if (a != null) {
                try {
                    getContext().startActivity(a);
                } catch (RuntimeException e) {
                    new StringBuilder("Failed launch activity: ").append(a);
                }
            }
        }
        V(false);
        this.abe.dismissDropDown();
        return true;
    }

    final void h(CharSequence charSequence) {
        this.abe.setText(charSequence);
        this.abe.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    private void a(int i, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", null, null, str2, 0, null));
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.abH);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.abL != null) {
            intent.putExtra("app_data", this.abL);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (abd) {
            intent.setComponent(this.abK.getSearchActivity());
        }
        return intent;
    }

    private Intent a(Cursor cursor, int i, String str) {
        try {
            String a = ak.a(cursor, "suggest_intent_action");
            if (a == null && VERSION.SDK_INT >= 8) {
                a = this.abK.getSuggestIntentAction();
            }
            if (a == null) {
                a = "android.intent.action.SEARCH";
            }
            String a2 = ak.a(cursor, "suggest_intent_data");
            if (abd && a2 == null) {
                a2 = this.abK.getSuggestIntentData();
            }
            if (a2 != null) {
                String a3 = ak.a(cursor, "suggest_intent_data_id");
                if (a3 != null) {
                    a2 = a2 + "/" + Uri.encode(a3);
                }
            }
            return a(a, a2 == null ? null : Uri.parse(a2), ak.a(cursor, "suggest_intent_extra_data"), ak.a(cursor, "suggest_intent_query"), 0, null);
        } catch (RuntimeException e) {
            int position;
            try {
                position = cursor.getPosition();
            } catch (RuntimeException e2) {
                position = -1;
            }
            new StringBuilder("Search suggestions cursor at row ").append(position).append(" returned exception.");
            return null;
        }
    }

    private void gF() {
        a aVar = abM;
        SearchAutoComplete searchAutoComplete = this.abe;
        if (aVar.abW != null) {
            try {
                aVar.abW.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception e) {
            }
        }
        aVar = abM;
        searchAutoComplete = this.abe;
        if (aVar.abX != null) {
            try {
                aVar.abX.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception e2) {
            }
        }
    }

    static boolean n(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
