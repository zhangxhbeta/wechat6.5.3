package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class HeaderGridView extends GridView {
    public ArrayList<a> nSE = new ArrayList();

    private static class a {
        public Object data;
        public boolean isSelectable;
        public ViewGroup nSF;
        public View view;

        private a() {
        }
    }

    private class b extends FrameLayout {
        final /* synthetic */ HeaderGridView nSG;

        public b(HeaderGridView headerGridView, Context context) {
            this.nSG = headerGridView;
            super(context);
        }

        protected final void onMeasure(int i, int i2) {
            super.onMeasure(MeasureSpec.makeMeasureSpec((this.nSG.getMeasuredWidth() - this.nSG.getPaddingLeft()) - this.nSG.getPaddingRight(), 1073741824), i2);
        }
    }

    private static class c implements Filterable, WrapperListAdapter {
        private final ListAdapter EK;
        int eZz = 1;
        ArrayList<a> nSE;
        public final DataSetObservable nSH = new DataSetObservable();
        boolean nSI;
        private final boolean nSJ;

        public c(ArrayList<a> arrayList, ListAdapter listAdapter) {
            this.EK = listAdapter;
            this.nSJ = listAdapter instanceof Filterable;
            if (arrayList == null) {
                throw new IllegalArgumentException("headerViewInfos cannot be null");
            }
            this.nSE = arrayList;
            this.nSI = ab(this.nSE);
        }

        public final boolean isEmpty() {
            return (this.EK == null || this.EK.isEmpty()) && this.nSE.size() == 0;
        }

        private static boolean ab(ArrayList<a> arrayList) {
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!((a) it.next()).isSelectable) {
                        return false;
                    }
                }
            }
            return true;
        }

        public final int getCount() {
            if (this.EK != null) {
                return (this.nSE.size() * this.eZz) + this.EK.getCount();
            }
            return this.nSE.size() * this.eZz;
        }

        public final boolean areAllItemsEnabled() {
            if (this.EK == null) {
                return true;
            }
            if (this.nSI && this.EK.areAllItemsEnabled()) {
                return true;
            }
            return false;
        }

        public final boolean isEnabled(int i) {
            int size = this.nSE.size() * this.eZz;
            if (i >= size) {
                size = i - size;
                return (this.EK == null || size >= this.EK.getCount()) ? false : this.EK.isEnabled(size);
            } else if (i % this.eZz == 0 && ((a) this.nSE.get(i / this.eZz)).isSelectable) {
                return true;
            } else {
                return false;
            }
        }

        public final Object getItem(int i) {
            int size = this.nSE.size() * this.eZz;
            if (i >= size) {
                size = i - size;
                if (this.EK == null || size >= this.EK.getCount()) {
                    return null;
                }
                return this.EK.getItem(size);
            } else if (i % this.eZz == 0) {
                return ((a) this.nSE.get(i / this.eZz)).data;
            } else {
                return null;
            }
        }

        public final long getItemId(int i) {
            int size = this.nSE.size() * this.eZz;
            if (this.EK != null && i >= size) {
                size = i - size;
                if (size < this.EK.getCount()) {
                    return this.EK.getItemId(size);
                }
            }
            return -1;
        }

        public final boolean hasStableIds() {
            if (this.EK != null) {
                return this.EK.hasStableIds();
            }
            return false;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            int size = this.nSE.size() * this.eZz;
            if (i < size) {
                View view2 = ((a) this.nSE.get(i / this.eZz)).nSF;
                if (i % this.eZz == 0) {
                    return view2;
                }
                if (view == null) {
                    view = new View(viewGroup.getContext());
                }
                view.setVisibility(4);
                view.setMinimumHeight(view2.getHeight());
                return view;
            }
            size = i - size;
            if (this.EK != null && size < this.EK.getCount()) {
                return this.EK.getView(size, view, viewGroup);
            }
            if (view == null) {
                view = new View(viewGroup.getContext());
            }
            view.setVisibility(4);
            return view;
        }

        public final int getItemViewType(int i) {
            int size = this.nSE.size() * this.eZz;
            if (i < size && i % this.eZz != 0) {
                return this.EK != null ? this.EK.getViewTypeCount() : 1;
            } else {
                if (this.EK != null && i >= size) {
                    size = i - size;
                    if (size < this.EK.getCount()) {
                        return this.EK.getItemViewType(size);
                    }
                }
                return -2;
            }
        }

        public final int getViewTypeCount() {
            if (this.EK != null) {
                return this.EK.getViewTypeCount() + 1;
            }
            return 2;
        }

        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.nSH.registerObserver(dataSetObserver);
            if (this.EK != null) {
                this.EK.registerDataSetObserver(dataSetObserver);
            }
        }

        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.nSH.unregisterObserver(dataSetObserver);
            if (this.EK != null) {
                this.EK.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public final Filter getFilter() {
            if (this.nSJ) {
                return ((Filterable) this.EK).getFilter();
            }
            return null;
        }

        public final ListAdapter getWrappedAdapter() {
            return this.EK;
        }
    }

    public HeaderGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setClipChildren(false);
    }

    public HeaderGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setClipChildren(false);
    }

    @TargetApi(11)
    public int getNumColumns() {
        int i = 1;
        if (VERSION.SDK_INT >= 11) {
            return super.getNumColumns();
        }
        try {
            Field declaredField = getClass().getSuperclass().getDeclaredField("mNumColumns");
            declaredField.setAccessible(true);
            return declaredField.getInt(this);
        } catch (Exception e) {
            return i;
        }
    }

    public void setClipChildren(boolean z) {
    }

    public final void a(ListAdapter listAdapter) {
        if (this.nSE.size() > 0) {
            ListAdapter cVar = new c(this.nSE, listAdapter);
            if (cVar.eZz != 5) {
                cVar.eZz = 5;
                cVar.nSH.notifyChanged();
            }
            super.setAdapter(cVar);
            return;
        }
        super.setAdapter(listAdapter);
    }
}
