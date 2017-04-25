package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.y;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.a.a.k;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public final class a {
    Button EA;
    CharSequence EB;
    Message EC;
    Button ED;
    CharSequence EE;
    Message EF;
    NestedScrollView EG;
    public int EH = 0;
    TextView EI;
    public View EJ;
    public ListAdapter EK;
    public int EL = -1;
    int EM;
    int EN;
    public int EO;
    public int EP;
    public int EQ;
    public int ER;
    int ES = 0;
    final OnClickListener ET = new OnClickListener(this) {
        final /* synthetic */ a EU;

        {
            this.EU = r1;
        }

        public final void onClick(View view) {
            Message obtain;
            if (view == this.EU.Ex && this.EU.Ez != null) {
                obtain = Message.obtain(this.EU.Ez);
            } else if (view == this.EU.EA && this.EU.EC != null) {
                obtain = Message.obtain(this.EU.EC);
            } else if (view != this.EU.ED || this.EU.EF == null) {
                obtain = null;
            } else {
                obtain = Message.obtain(this.EU.EF);
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            this.EU.mHandler.obtainMessage(1, this.EU.En).sendToTarget();
        }
    };
    final i En;
    final Window Eo;
    public CharSequence Ep;
    public ListView Eq;
    public int Er;
    public int Es;
    public int Et;
    public int Eu;
    public int Ev;
    public boolean Ew = false;
    Button Ex;
    CharSequence Ey;
    Message Ez;
    public Drawable jP;
    public TextView jp;
    public ImageView kH;
    public final Context mContext;
    Handler mHandler;
    public View mView;
    CharSequence up;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ a EU;
        final /* synthetic */ View EV;
        final /* synthetic */ View EW;

        AnonymousClass3(a aVar, View view, View view2) {
            this.EU = aVar;
            this.EV = view;
            this.EW = view2;
        }

        public final void run() {
            a.a(this.EU.EG, this.EV, this.EW);
        }
    }

    class AnonymousClass4 implements OnScrollListener {
        final /* synthetic */ a EU;
        final /* synthetic */ View EV;
        final /* synthetic */ View EW;

        AnonymousClass4(a aVar, View view, View view2) {
            this.EU = aVar;
            this.EV = view;
            this.EW = view2;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            a.a(absListView, this.EV, this.EW);
        }
    }

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ a EU;
        final /* synthetic */ View EV;
        final /* synthetic */ View EW;

        AnonymousClass5(a aVar, View view, View view2) {
            this.EU = aVar;
            this.EV = view;
            this.EW = view2;
        }

        public final void run() {
            a.a(this.EU.Eq, this.EV, this.EW);
        }
    }

    public static class a {
        public Cursor Ay;
        public final LayoutInflater CE;
        public int EH = 0;
        public View EJ;
        public ListAdapter EK;
        public int EL = -1;
        public int EX = 0;
        public CharSequence EY;
        public DialogInterface.OnClickListener EZ;
        public CharSequence Ep;
        public int Er;
        public int Es;
        public int Et;
        public int Eu;
        public int Ev;
        public boolean Ew = false;
        public CharSequence Fa;
        public DialogInterface.OnClickListener Fb;
        public CharSequence Fc;
        public DialogInterface.OnClickListener Fd;
        public OnCancelListener Fe;
        public OnDismissListener Ff;
        public OnKeyListener Fg;
        public CharSequence[] Fh;
        public DialogInterface.OnClickListener Fi;
        public boolean[] Fj;
        public boolean Fk;
        public boolean Fl;
        public OnMultiChoiceClickListener Fm;
        public String Fn;
        public String Fo;
        public OnItemSelectedListener Fp;
        public boolean Fq = true;
        public Drawable jP;
        public final Context mContext;
        public View mView;
        public boolean ov;
        public CharSequence up;

        class AnonymousClass1 extends ArrayAdapter<CharSequence> {
            final /* synthetic */ ListView Fr;
            final /* synthetic */ a Fs;

            public AnonymousClass1(a aVar, Context context, int i, CharSequence[] charSequenceArr, ListView listView) {
                this.Fs = aVar;
                this.Fr = listView;
                super(context, i, 16908308, charSequenceArr);
            }

            public final View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                if (this.Fs.Fj != null && this.Fs.Fj[i]) {
                    this.Fr.setItemChecked(i, true);
                }
                return view2;
            }
        }

        class AnonymousClass2 extends CursorAdapter {
            final /* synthetic */ ListView Fr;
            final /* synthetic */ a Fs;
            private final int Ft;
            private final int Fu;
            final /* synthetic */ a Fv;

            public AnonymousClass2(a aVar, Context context, Cursor cursor, ListView listView, a aVar2) {
                this.Fs = aVar;
                this.Fr = listView;
                this.Fv = aVar2;
                super(context, cursor, false);
                Cursor cursor2 = getCursor();
                this.Ft = cursor2.getColumnIndexOrThrow(this.Fs.Fn);
                this.Fu = cursor2.getColumnIndexOrThrow(this.Fs.Fo);
            }

            public final void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.Ft));
                this.Fr.setItemChecked(cursor.getPosition(), cursor.getInt(this.Fu) == 1);
            }

            public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return this.Fs.CE.inflate(this.Fv.EP, viewGroup, false);
            }
        }

        class AnonymousClass3 implements OnItemClickListener {
            final /* synthetic */ a Fs;
            final /* synthetic */ a Fv;

            public AnonymousClass3(a aVar, a aVar2) {
                this.Fs = aVar;
                this.Fv = aVar2;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.Fs.Fi.onClick(this.Fv.En, i);
                if (!this.Fs.Fl) {
                    this.Fv.En.dismiss();
                }
            }
        }

        class AnonymousClass4 implements OnItemClickListener {
            final /* synthetic */ ListView Fr;
            final /* synthetic */ a Fs;
            final /* synthetic */ a Fv;

            public AnonymousClass4(a aVar, ListView listView, a aVar2) {
                this.Fs = aVar;
                this.Fr = listView;
                this.Fv = aVar2;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.Fs.Fj != null) {
                    this.Fs.Fj[i] = this.Fr.isItemChecked(i);
                }
                this.Fs.Fm.onClick(this.Fv.En, i, this.Fr.isItemChecked(i));
            }
        }

        public a(Context context) {
            this.mContext = context;
            this.ov = true;
            this.CE = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    private static final class b extends Handler {
        private WeakReference<DialogInterface> Fw;

        public b(DialogInterface dialogInterface) {
            this.Fw = new WeakReference(dialogInterface);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.Fw.get(), message.what);
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    private static class c extends ArrayAdapter<CharSequence> {
        public c(Context context, int i, CharSequence[] charSequenceArr) {
            super(context, i, 16908308, charSequenceArr);
        }

        public final boolean hasStableIds() {
            return true;
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    class AnonymousClass2 implements android.support.v4.widget.NestedScrollView.b {
        final /* synthetic */ a EU;
        final /* synthetic */ View EV;
        final /* synthetic */ View EW;

        AnonymousClass2(a aVar, View view, View view2) {
            this.EU = aVar;
            this.EV = view;
            this.EW = view2;
        }

        public final void b(NestedScrollView nestedScrollView) {
            a.a(nestedScrollView, this.EV, this.EW);
        }
    }

    static /* synthetic */ void a(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(y.g(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!y.g(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    public a(Context context, i iVar, Window window) {
        this.mContext = context;
        this.En = iVar;
        this.Eo = window;
        this.mHandler = new b(iVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, k.bb, android.support.v7.a.a.a.alertDialogStyle, 0);
        this.EM = obtainStyledAttributes.getResourceId(k.KH, 0);
        this.EN = obtainStyledAttributes.getResourceId(k.KI, 0);
        this.EO = obtainStyledAttributes.getResourceId(k.KK, 0);
        this.EP = obtainStyledAttributes.getResourceId(k.KL, 0);
        this.EQ = obtainStyledAttributes.getResourceId(k.KM, 0);
        this.ER = obtainStyledAttributes.getResourceId(k.KJ, 0);
        obtainStyledAttributes.recycle();
        iVar.de();
    }

    static boolean aH(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (aH(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public final void setTitle(CharSequence charSequence) {
        this.up = charSequence;
        if (this.EI != null) {
            this.EI.setText(charSequence);
        }
    }

    public final void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (onClickListener != null) {
            message = this.mHandler.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.EE = charSequence;
                this.EF = message;
                return;
            case -2:
                this.EB = charSequence;
                this.EC = message;
                return;
            case -1:
                this.Ey = charSequence;
                this.Ez = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public final void setIcon(int i) {
        this.jP = null;
        this.EH = i;
        if (this.kH == null) {
            return;
        }
        if (i != 0) {
            this.kH.setVisibility(0);
            this.kH.setImageResource(this.EH);
            return;
        }
        this.kH.setVisibility(8);
    }

    static ViewGroup b(View view, View view2) {
        View inflate;
        if (view == null) {
            if (view2 instanceof ViewStub) {
                inflate = ((ViewStub) view2).inflate();
            } else {
                inflate = view2;
            }
            return (ViewGroup) inflate;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            inflate = ((ViewStub) view).inflate();
        } else {
            inflate = view;
        }
        return (ViewGroup) inflate;
    }
}
