package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class e extends BaseAdapter implements a, Filterable {
    protected a AA;
    protected DataSetObserver AB;
    protected f AC;
    protected FilterQueryProvider AD;
    protected boolean Aw;
    protected boolean Ax;
    public Cursor Ay;
    protected int Az;
    public Context mContext;

    private class a extends ContentObserver {
        final /* synthetic */ e AE;

        public final boolean deliverSelfNotifications() {
            return true;
        }

        public final void onChange(boolean z) {
            this.AE.onContentChanged();
        }
    }

    public abstract void a(View view, Cursor cursor);

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    public final Cursor getCursor() {
        return this.Ay;
    }

    public int getCount() {
        if (!this.Aw || this.Ay == null) {
            return 0;
        }
        return this.Ay.getCount();
    }

    public Object getItem(int i) {
        if (!this.Aw || this.Ay == null) {
            return null;
        }
        this.Ay.moveToPosition(i);
        return this.Ay;
    }

    public long getItemId(int i) {
        if (this.Aw && this.Ay != null && this.Ay.moveToPosition(i)) {
            return this.Ay.getLong(this.Az);
        }
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.Aw) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.Ay.moveToPosition(i)) {
            if (view == null) {
                view = newView(this.mContext, this.Ay, viewGroup);
            }
            a(view, this.Ay);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.Aw) {
            return null;
        }
        this.Ay.moveToPosition(i);
        if (view == null) {
            view = newDropDownView(this.mContext, this.Ay, viewGroup);
        }
        a(view, this.Ay);
        return view;
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    public void changeCursor(Cursor cursor) {
        Cursor cursor2;
        if (cursor == this.Ay) {
            cursor2 = null;
        } else {
            cursor2 = this.Ay;
            if (cursor2 != null) {
                if (this.AA != null) {
                    cursor2.unregisterContentObserver(this.AA);
                }
                if (this.AB != null) {
                    cursor2.unregisterDataSetObserver(this.AB);
                }
            }
            this.Ay = cursor;
            if (cursor != null) {
                if (this.AA != null) {
                    cursor.registerContentObserver(this.AA);
                }
                if (this.AB != null) {
                    cursor.registerDataSetObserver(this.AB);
                }
                this.Az = cursor.getColumnIndexOrThrow("_id");
                this.Aw = true;
                notifyDataSetChanged();
            } else {
                this.Az = -1;
                this.Aw = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? SQLiteDatabase.KeyEmpty : cursor.toString();
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        if (this.AD != null) {
            return this.AD.runQuery(charSequence);
        }
        return this.Ay;
    }

    public Filter getFilter() {
        if (this.AC == null) {
            this.AC = new f(this);
        }
        return this.AC;
    }

    protected final void onContentChanged() {
        if (this.Ax && this.Ay != null && !this.Ay.isClosed()) {
            this.Aw = this.Ay.requery();
        }
    }
}
