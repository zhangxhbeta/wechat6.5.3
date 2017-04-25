package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.e.i;
import android.support.v4.e.j;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FragmentActivity extends f implements android.support.v4.app.a.a, android.support.v4.app.b.a {
    final Handler mHandler = new Handler(this) {
        final /* synthetic */ FragmentActivity pL;

        {
            this.pL = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (this.pL.pE) {
                        this.pL.n(false);
                        return;
                    }
                    return;
                case 2:
                    this.pL.aQ();
                    this.pL.pB.execPendingActions();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };
    final i pB = new i(new a(this));
    boolean pC;
    boolean pD;
    boolean pE;
    boolean pF;
    boolean pG;
    boolean pH;
    int pI;
    boolean pJ;
    j<String> pK;
    boolean pd;

    static final class b {
        Object pM;
        List<Fragment> pN;
        i<String, q> pO;

        b() {
        }
    }

    class a extends j<FragmentActivity> {
        final /* synthetic */ FragmentActivity pL;

        public a(FragmentActivity fragmentActivity) {
            this.pL = fragmentActivity;
            super(fragmentActivity);
        }

        public final void a(String str, PrintWriter printWriter, String[] strArr) {
            this.pL.dump(str, null, printWriter, strArr);
        }

        public final boolean aT() {
            return !this.pL.isFinishing();
        }

        public final LayoutInflater onGetLayoutInflater() {
            return this.pL.getLayoutInflater().cloneInContext(this.pL);
        }

        public final void aU() {
            this.pL.aR();
        }

        public final void b(Fragment fragment, Intent intent, int i, Bundle bundle) {
            this.pL.a(fragment, intent, i, null);
        }

        public final boolean onHasWindowAnimations() {
            return this.pL.getWindow() != null;
        }

        public final int onGetWindowAnimations() {
            Window window = this.pL.getWindow();
            return window == null ? 0 : window.getAttributes().windowAnimations;
        }

        public final View onFindViewById(int i) {
            return this.pL.findViewById(i);
        }

        public final boolean onHasView() {
            Window window = this.pL.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.pB.noteStateNotSaved();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.pK.get(i4);
            this.pK.remove(i4);
            if (str != null) {
                Fragment i5 = this.pB.i(str);
                if (i5 != null) {
                    i5.onActivityResult(65535 & i, i2, intent);
                    return;
                }
                return;
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.pB.oU.oT.popBackStackImmediate()) {
            if (VERSION.SDK_INT >= 21) {
                finishAfterTransition();
            } else {
                finish();
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.pB.oU.oT.dispatchConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        i iVar = this.pB;
        iVar.oU.oT.a(iVar.oU, iVar.oU, null);
        super.onCreate(bundle);
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            this.pB.oU.pR = bVar.pO;
        }
        if (bundle != null) {
            this.pB.oU.oT.restoreAllState(bundle.getParcelable("android:support:fragments"), bVar != null ? bVar.pN : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.pI = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (!(intArray == null || stringArray == null || intArray.length != stringArray.length)) {
                    this.pK = new j(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.pK.put(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.pK == null) {
            this.pK = new j();
            this.pI = 0;
        }
        this.pB.oU.oT.dispatchCreate();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        i iVar = this.pB;
        onCreatePanelMenu |= iVar.oU.oT.dispatchCreateOptionsMenu(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.pB.oU.oT.onCreateView(view, str, context, attributeSet);
    }

    public void onDestroy() {
        super.onDestroy();
        n(false);
        this.pB.oU.oT.dispatchDestroy();
        j jVar = this.pB.oU;
        if (jVar.pm != null) {
            jVar.pm.bj();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.pB.oU.oT.dispatchLowMemory();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.pB.oU.oT.dispatchOptionsItemSelected(menuItem);
            case 6:
                return this.pB.oU.oT.dispatchContextItemSelected(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.pB.oU.oT.dispatchOptionsMenuClosed(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    public void onPause() {
        super.onPause();
        this.pD = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            aQ();
        }
        this.pB.oU.oT.G(4);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.pB.noteStateNotSaved();
    }

    public void onStateNotSaved() {
        this.pB.noteStateNotSaved();
    }

    public void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.pD = true;
        this.pB.execPendingActions();
    }

    public void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        aQ();
        this.pB.execPendingActions();
    }

    protected final void aQ() {
        this.pB.oU.oT.dispatchResume();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.pG) {
            this.pG = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return super.onPreparePanel(0, view, menu) | this.pB.oU.oT.dispatchPrepareOptionsMenu(menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        List list;
        if (this.pE) {
            n(true);
        }
        l lVar = this.pB.oU.oT;
        if (lVar.pX != null) {
            list = null;
            for (int i = 0; i < lVar.pX.size(); i++) {
                Fragment fragment = (Fragment) lVar.pX.get(i);
                if (fragment != null && fragment.pc) {
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(fragment);
                    fragment.pd = true;
                    fragment.oL = fragment.oK != null ? fragment.oK.mIndex : -1;
                    if (l.DEBUG) {
                        new StringBuilder("retainNonConfig: keeping retained ").append(fragment);
                    }
                }
            }
        } else {
            list = null;
        }
        i aV = this.pB.oU.aV();
        if (list == null && aV == null) {
            return null;
        }
        b bVar = new b();
        bVar.pM = null;
        bVar.pN = list;
        bVar.pO = aV;
        return bVar;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable saveAllState = this.pB.oU.oT.saveAllState();
        if (saveAllState != null) {
            bundle.putParcelable("android:support:fragments", saveAllState);
        }
        if (this.pK.size() > 0) {
            bundle.putInt("android:support:next_request_index", this.pI);
            int[] iArr = new int[this.pK.size()];
            String[] strArr = new String[this.pK.size()];
            for (int i = 0; i < this.pK.size(); i++) {
                iArr[i] = this.pK.keyAt(i);
                strArr[i] = (String) this.pK.valueAt(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    public void onStart() {
        super.onStart();
        this.pE = false;
        this.pF = false;
        this.mHandler.removeMessages(1);
        if (!this.pC) {
            this.pC = true;
            this.pB.oU.oT.dispatchActivityCreated();
        }
        this.pB.noteStateNotSaved();
        this.pB.execPendingActions();
        j jVar = this.pB.oU;
        if (!jVar.pn) {
            jVar.pn = true;
            if (jVar.pm != null) {
                jVar.pm.be();
            } else if (!jVar.po) {
                jVar.pm = jVar.a("(root)", jVar.pn, false);
                if (!(jVar.pm == null || jVar.pm.rm)) {
                    jVar.pm.be();
                }
            }
            jVar.po = true;
        }
        this.pB.oU.oT.dispatchStart();
        j jVar2 = this.pB.oU;
        if (jVar2.pR != null) {
            int i;
            int size = jVar2.pR.size();
            r[] rVarArr = new r[size];
            for (i = size - 1; i >= 0; i--) {
                rVarArr[i] = (r) jVar2.pR.valueAt(i);
            }
            for (i = 0; i < size; i++) {
                r rVar = rVarArr[i];
                if (rVar.pd) {
                    if (r.DEBUG) {
                        new StringBuilder("Finished Retaining in ").append(rVar);
                    }
                    rVar.pd = false;
                    for (int size2 = rVar.rk.size() - 1; size2 >= 0; size2--) {
                        a aVar = (a) rVar.rk.valueAt(size2);
                        if (aVar.pd) {
                            if (r.DEBUG) {
                                new StringBuilder("  Finished Retaining: ").append(aVar);
                            }
                            aVar.pd = false;
                            if (!(aVar.rm == aVar.rt || aVar.rm)) {
                                aVar.stop();
                            }
                        }
                        if (aVar.rm && aVar.rr && !aVar.ru) {
                            aVar.c(aVar.rq, aVar.mData);
                        }
                    }
                }
                rVar.bi();
            }
        }
    }

    public void onStop() {
        super.onStop();
        this.pE = true;
        this.mHandler.sendEmptyMessage(1);
        this.pB.oU.oT.dispatchStop();
    }

    public void aR() {
        if (VERSION.SDK_INT >= 11) {
            invalidateOptionsMenu();
        } else {
            this.pG = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = VERSION.SDK_INT;
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.pC);
        printWriter.print("mResumed=");
        printWriter.print(this.pD);
        printWriter.print(" mStopped=");
        printWriter.print(this.pE);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.pF);
        j jVar = this.pB.oU;
        printWriter.print(str2);
        printWriter.print("mLoadersStarted=");
        printWriter.println(jVar.pn);
        if (jVar.pm != null) {
            printWriter.print(str2);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(jVar.pm)));
            printWriter.println(":");
            jVar.pm.dump(str2 + "  ", fileDescriptor, printWriter, strArr);
        }
        this.pB.oU.oT.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        a(str + "  ", printWriter, getWindow().getDecorView());
    }

    private static String w(View view) {
        char c;
        char c2 = 'F';
        char c3 = '.';
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case 0:
                stringBuilder.append('V');
                break;
            case 4:
                stringBuilder.append('I');
                break;
            case 8:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        if (view.isFocusable()) {
            c = 'F';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isEnabled()) {
            c = 'E';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        if (view.isHorizontalScrollBarEnabled()) {
            c = 'H';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isVerticalScrollBarEnabled()) {
            c = 'V';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isClickable()) {
            c = 'C';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isLongClickable()) {
            c = 'L';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c2 = '.';
        }
        stringBuilder.append(c2);
        if (view.isSelected()) {
            c = 'S';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isPressed()) {
            c3 = 'P';
        }
        stringBuilder.append(c3);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (WebView.NIGHT_MODE_COLOR & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(w(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    final void n(boolean z) {
        if (!this.pF) {
            this.pF = true;
            this.pd = z;
            this.mHandler.removeMessages(1);
            i iVar = this.pB;
            boolean z2 = this.pd;
            j jVar = iVar.oU;
            jVar.pS = z2;
            if (jVar.pm != null && jVar.pn) {
                jVar.pn = false;
                if (z2) {
                    jVar.pm.bg();
                } else {
                    jVar.pm.bf();
                }
            }
            this.pB.oU.oT.G(2);
        }
    }

    public final k aS() {
        return this.pB.oU.oT;
    }

    public void startActivityForResult(Intent intent, int i) {
        if (this.pJ || i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    public final void C(int i) {
        if (!this.pH && i != -1 && (-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.pK.get(i3);
            this.pK.remove(i3);
            if (str != null && this.pB.i(str) != null) {
                Fragment.aK();
            }
        }
    }

    public void a(Fragment fragment, Intent intent, int i) {
        a(fragment, intent, i, null);
    }

    public final void a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.pJ = true;
        if (i == -1) {
            try {
                a.a(this, intent, -1, bundle);
            } finally {
                this.pJ = false;
            }
        } else if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            a.a(this, intent, ((d(fragment) + 1) << 16) + (65535 & i), bundle);
            this.pJ = false;
        }
    }

    private int d(Fragment fragment) {
        if (this.pK.size() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.pK.indexOfKey(this.pI) >= 0) {
            this.pI = (this.pI + 1) % 65534;
        }
        int i = this.pI;
        this.pK.put(i, fragment.oI);
        this.pI = (this.pI + 1) % 65534;
        return i;
    }
}
