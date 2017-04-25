package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class t {
    private final DataSetObservable wx = new DataSetObservable();
    private DataSetObserver wy;

    public abstract boolean a(View view, Object obj);

    public abstract int getCount();

    public Object b(ViewGroup viewGroup, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void d(Object obj) {
    }

    public void bb() {
    }

    public Parcelable bc() {
        return null;
    }

    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public int j(Object obj) {
        return -1;
    }

    public void notifyDataSetChanged() {
        synchronized (this) {
            if (this.wy != null) {
                this.wy.onChanged();
            }
        }
        this.wx.notifyChanged();
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.wx.registerObserver(dataSetObserver);
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.wx.unregisterObserver(dataSetObserver);
    }

    final void a(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.wy = dataSetObserver;
        }
    }
}
