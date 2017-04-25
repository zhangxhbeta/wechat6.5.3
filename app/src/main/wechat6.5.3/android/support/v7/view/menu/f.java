package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.d;
import android.support.v4.view.l;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class f implements android.support.v4.c.a.a {
    private static final int[] Pu = new int[]{1, 4, 5, 3, 2, 0};
    private final Resources BE;
    public ArrayList<h> PA;
    private ArrayList<h> PB;
    private boolean PC;
    public int PD = 1;
    private ContextMenuInfo PE;
    CharSequence PF;
    Drawable PG;
    View PH;
    private boolean PI = false;
    private boolean PJ = false;
    boolean PK = false;
    private boolean PL = false;
    private ArrayList<h> PM = new ArrayList();
    public CopyOnWriteArrayList<WeakReference<l>> PN = new CopyOnWriteArrayList();
    h PO;
    public boolean PP;
    private boolean Pv;
    private boolean Pw;
    public a Px;
    private ArrayList<h> Py;
    private boolean Pz;
    ArrayList<h> eg;
    public final Context mContext;

    public interface a {
        boolean a(f fVar, MenuItem menuItem);

        void b(f fVar);
    }

    public interface b {
        boolean f(h hVar);
    }

    public f(Context context) {
        boolean z = true;
        this.mContext = context;
        this.BE = context.getResources();
        this.eg = new ArrayList();
        this.Py = new ArrayList();
        this.Pz = true;
        this.PA = new ArrayList();
        this.PB = new ArrayList();
        this.PC = true;
        if (this.BE.getConfiguration().keyboard == 1 || !this.BE.getBoolean(android.support.v7.a.a.b.HW)) {
            z = false;
        }
        this.Pw = z;
    }

    public final void a(l lVar) {
        a(lVar, this.mContext);
    }

    public final void a(l lVar, Context context) {
        this.PN.add(new WeakReference(lVar));
        lVar.a(context, this);
        this.PC = true;
    }

    public final void b(l lVar) {
        Iterator it = this.PN.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            l lVar2 = (l) weakReference.get();
            if (lVar2 == null || lVar2 == lVar) {
                this.PN.remove(weakReference);
            }
        }
    }

    public final void dispatchSaveInstanceState(Bundle bundle) {
        if (!this.PN.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator it = this.PN.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.PN.remove(weakReference);
                } else {
                    int id = lVar.getId();
                    if (id > 0) {
                        Parcelable onSaveInstanceState = lVar.onSaveInstanceState();
                        if (onSaveInstanceState != null) {
                            sparseArray.put(id, onSaveInstanceState);
                        }
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    public final void e(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View a = l.a(item);
            if (!(a == null || a.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                a.saveHierarchyState(sparseArray);
                if (l.d(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((p) item.getSubMenu()).e(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(dx(), sparseArray);
        }
    }

    public final void f(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(dx());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View a = l.a(item);
                if (!(a == null || a.getId() == -1)) {
                    a.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((p) item.getSubMenu()).f(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    l.b(item);
                }
            }
        }
    }

    protected String dx() {
        return "android:menu:actionviewstates";
    }

    public void a(a aVar) {
        this.Px = aVar;
    }

    public final MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int i4 = (-65536 & i3) >> 16;
        if (i4 < 0 || i4 >= Pu.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i5 = (Pu[i4] << 16) | (65535 & i3);
        MenuItem hVar = new h(this, i, i2, i3, i5, charSequence, this.PD);
        if (this.PE != null) {
            hVar.Qa = this.PE;
        }
        this.eg.add(b(this.eg, i5), hVar);
        h(true);
        return hVar;
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return a(0, 0, 0, this.BE.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.BE.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.BE.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        h hVar = (h) a(i, i2, i3, charSequence);
        SubMenu pVar = new p(this.mContext, this, hVar);
        hVar.b(pVar);
        return pVar;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.BE.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.mContext.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            Intent intent2;
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeItem(int i) {
        int i2;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((h) this.eg.get(i3)).getItemId() == i) {
                i2 = i3;
                break;
            }
        }
        i2 = -1;
        m(i2, true);
    }

    public void removeGroup(int i) {
        int i2;
        int size = size();
        for (i2 = 0; i2 < size; i2++) {
            if (((h) this.eg.get(i2)).getGroupId() == i) {
                size = i2;
                break;
            }
        }
        size = -1;
        if (size >= 0) {
            int size2 = this.eg.size() - size;
            int i3 = 0;
            while (true) {
                i2 = i3 + 1;
                if (i3 >= size2 || ((h) this.eg.get(size)).getGroupId() != i) {
                    h(true);
                } else {
                    m(size, false);
                    i3 = i2;
                }
            }
            h(true);
        }
    }

    private void m(int i, boolean z) {
        if (i >= 0 && i < this.eg.size()) {
            this.eg.remove(i);
            if (z) {
                h(true);
            }
        }
    }

    public void clear() {
        if (this.PO != null) {
            h(this.PO);
        }
        this.eg.clear();
        h(true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.eg.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) this.eg.get(i2);
            if (hVar.getGroupId() == i) {
                hVar.E(z2);
                hVar.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.eg.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            h hVar = (h) this.eg.get(i2);
            if (hVar.getGroupId() == i && hVar.G(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (z2) {
            h(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.eg.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) this.eg.get(i2);
            if (hVar.getGroupId() == i) {
                hVar.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.PP) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((h) this.eg.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) this.eg.get(i2);
            if (hVar.getItemId() == i) {
                return hVar;
            }
            if (hVar.hasSubMenu()) {
                MenuItem findItem = hVar.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int size() {
        return this.eg.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.eg.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.Pv = z;
        h(false);
    }

    boolean dy() {
        return this.Pv;
    }

    public boolean dz() {
        return this.Pw;
    }

    boolean b(f fVar, MenuItem menuItem) {
        return this.Px != null && this.Px.a(fVar, menuItem);
    }

    private static int b(ArrayList<h> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((h) arrayList.get(size)).OF <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = a(a, null, i2);
        }
        if ((i2 & 2) != 0) {
            D(true);
        }
        return z;
    }

    private void a(List<h> list, int i, KeyEvent keyEvent) {
        boolean dy = dy();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.eg.size();
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = (h) this.eg.get(i2);
                if (hVar.hasSubMenu()) {
                    ((f) hVar.getSubMenu()).a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = dy ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (dy && alphabeticShortcut == '\b' && i == 67)) && hVar.isEnabled())) {
                    list.add(hVar);
                }
            }
        }
    }

    private h a(int i, KeyEvent keyEvent) {
        List list = this.PM;
        list.clear();
        a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (h) list.get(0);
        }
        boolean dy = dy();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) list.get(i2);
            char alphabeticShortcut = dy ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return hVar;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return hVar;
            }
            if (dy && alphabeticShortcut == '\b' && i == 67) {
                return hVar;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), null, i2);
    }

    public final boolean a(MenuItem menuItem, l lVar, int i) {
        boolean z = false;
        h hVar = (h) menuItem;
        if (hVar == null || !hVar.isEnabled()) {
            return false;
        }
        boolean z2;
        boolean dI = hVar.dI();
        d dVar = hVar.PX;
        if (dVar == null || !dVar.hasSubMenu()) {
            z2 = false;
        } else {
            z2 = true;
        }
        boolean expandActionView;
        if (hVar.dP()) {
            expandActionView = hVar.expandActionView() | dI;
            if (!expandActionView) {
                return expandActionView;
            }
            D(true);
            return expandActionView;
        } else if (hVar.hasSubMenu() || z2) {
            D(false);
            if (!hVar.hasSubMenu()) {
                hVar.b(new p(this.mContext, this, hVar));
            }
            p pVar = (p) hVar.getSubMenu();
            if (z2) {
                dVar.onPrepareSubMenu(pVar);
            }
            if (!this.PN.isEmpty()) {
                if (lVar != null) {
                    z = lVar.a(pVar);
                }
                Iterator it = this.PN.iterator();
                boolean z3 = z;
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    l lVar2 = (l) weakReference.get();
                    if (lVar2 == null) {
                        this.PN.remove(weakReference);
                    } else {
                        if (z3) {
                            z = z3;
                        } else {
                            z = lVar2.a(pVar);
                        }
                        z3 = z;
                    }
                }
                z = z3;
            }
            expandActionView = dI | r2;
            if (expandActionView) {
                return expandActionView;
            }
            D(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                D(true);
            }
            return dI;
        }
    }

    public final void D(boolean z) {
        if (!this.PL) {
            this.PL = true;
            Iterator it = this.PN.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.PN.remove(weakReference);
                } else {
                    lVar.a(this, z);
                }
            }
            this.PL = false;
        }
    }

    public void close() {
        D(true);
    }

    public void h(boolean z) {
        if (this.PI) {
            this.PJ = true;
            return;
        }
        if (z) {
            this.Pz = true;
            this.PC = true;
        }
        if (!this.PN.isEmpty()) {
            dA();
            Iterator it = this.PN.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.PN.remove(weakReference);
                } else {
                    lVar.f(z);
                }
            }
            dB();
        }
    }

    public final void dA() {
        if (!this.PI) {
            this.PI = true;
            this.PJ = false;
        }
    }

    public final void dB() {
        this.PI = false;
        if (this.PJ) {
            this.PJ = false;
            h(true);
        }
    }

    final void dC() {
        this.Pz = true;
        h(true);
    }

    final void dD() {
        this.PC = true;
        h(true);
    }

    public final ArrayList<h> dE() {
        if (!this.Pz) {
            return this.Py;
        }
        this.Py.clear();
        int size = this.eg.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) this.eg.get(i);
            if (hVar.isVisible()) {
                this.Py.add(hVar);
            }
        }
        this.Pz = false;
        this.PC = true;
        return this.Py;
    }

    public final void dF() {
        ArrayList dE = dE();
        if (this.PC) {
            Iterator it = this.PN.iterator();
            int i = 0;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.PN.remove(weakReference);
                } else {
                    i = lVar.E() | i;
                }
            }
            if (i != 0) {
                this.PA.clear();
                this.PB.clear();
                i = dE.size();
                for (int i2 = 0; i2 < i; i2++) {
                    h hVar = (h) dE.get(i2);
                    if (hVar.dM()) {
                        this.PA.add(hVar);
                    } else {
                        this.PB.add(hVar);
                    }
                }
            } else {
                this.PA.clear();
                this.PB.clear();
                this.PB.addAll(dE());
            }
            this.PC = false;
        }
    }

    public final ArrayList<h> dG() {
        dF();
        return this.PB;
    }

    public void clearHeader() {
        this.PG = null;
        this.PF = null;
        this.PH = null;
        h(false);
    }

    final void a(CharSequence charSequence, Drawable drawable, View view) {
        if (view != null) {
            this.PH = view;
            this.PF = null;
            this.PG = null;
        } else {
            if (charSequence != null) {
                this.PF = charSequence;
            }
            if (drawable != null) {
                this.PG = drawable;
            }
            this.PH = null;
        }
        h(false);
    }

    protected final f g(CharSequence charSequence) {
        a(charSequence, null, null);
        return this;
    }

    protected final f k(Drawable drawable) {
        a(null, drawable, null);
        return this;
    }

    public f dH() {
        return this;
    }

    public boolean g(h hVar) {
        boolean z = false;
        if (!this.PN.isEmpty()) {
            dA();
            Iterator it = this.PN.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.PN.remove(weakReference);
                } else {
                    z = lVar.b(hVar);
                    if (z) {
                        break;
                    }
                    z2 = z;
                }
            }
            z = z2;
            dB();
            if (z) {
                this.PO = hVar;
            }
        }
        return z;
    }

    public boolean h(h hVar) {
        boolean z = false;
        if (!this.PN.isEmpty() && this.PO == hVar) {
            dA();
            Iterator it = this.PN.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.PN.remove(weakReference);
                } else {
                    z = lVar.c(hVar);
                    if (z) {
                        break;
                    }
                    z2 = z;
                }
            }
            z = z2;
            dB();
            if (z) {
                this.PO = null;
            }
        }
        return z;
    }
}
