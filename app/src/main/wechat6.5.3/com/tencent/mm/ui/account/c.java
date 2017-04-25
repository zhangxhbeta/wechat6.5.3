package com.tencent.mm.ui.account;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class c extends BaseAdapter implements Filterable {
    private ArrayList<String> ifA;
    private List<String> ify;
    private Context mContext;
    private final Object mLock = new Object();
    private a nHK;
    private String nHL;

    private class a extends Filter {
        final /* synthetic */ c nHM;

        private a(c cVar) {
            this.nHM = cVar;
        }

        protected final FilterResults performFiltering(CharSequence charSequence) {
            int i = 0;
            FilterResults filterResults = new FilterResults();
            if (this.nHM.ifA == null) {
                synchronized (this.nHM.mLock) {
                    this.nHM.ifA = new ArrayList(this.nHM.ify);
                }
            }
            if (charSequence == null || charSequence.length() == 0) {
                synchronized (this.nHM.mLock) {
                    ArrayList arrayList = new ArrayList(this.nHM.ifA);
                    filterResults.values = arrayList;
                    filterResults.count = arrayList.size();
                }
            } else {
                String str;
                ArrayList a;
                int size;
                ArrayList arrayList2;
                String toLowerCase = charSequence.toString().toLowerCase();
                String str2 = SQLiteDatabase.KeyEmpty;
                if (this.nHM.nHL != null && this.nHM.nHL.length() > 0) {
                    String[] split = toLowerCase.split(this.nHM.nHL);
                    if (split != null && split.length > 1) {
                        str2 = split[0] + this.nHM.nHL;
                        toLowerCase = split[1];
                        str = str2;
                        str2 = toLowerCase;
                        a = this.nHM.ifA;
                        size = a.size();
                        arrayList2 = new ArrayList(size);
                        while (i < size) {
                            toLowerCase = (String) a.get(i);
                            if (toLowerCase.toString().toLowerCase().startsWith(str2)) {
                                arrayList2.add(str + toLowerCase);
                            }
                            i++;
                        }
                        filterResults.values = arrayList2;
                        filterResults.count = arrayList2.size();
                    }
                }
                str = str2;
                str2 = toLowerCase;
                a = this.nHM.ifA;
                size = a.size();
                arrayList2 = new ArrayList(size);
                while (i < size) {
                    toLowerCase = (String) a.get(i);
                    if (toLowerCase.toString().toLowerCase().startsWith(str2)) {
                        arrayList2.add(str + toLowerCase);
                    }
                    i++;
                }
                filterResults.values = arrayList2;
                filterResults.count = arrayList2.size();
            }
            return filterResults;
        }

        protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            this.nHM.ify = (List) filterResults.values;
            if (filterResults.count > 0) {
                this.nHM.notifyDataSetChanged();
            } else {
                this.nHM.notifyDataSetInvalidated();
            }
        }
    }

    static class b {
        public TextView eux;

        b() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return hd(i);
    }

    public c(Context context, String[] strArr, String str) {
        this.mContext = context;
        this.ify = Arrays.asList(strArr);
        this.nHL = str;
    }

    public final int getCount() {
        return this.ify.size();
    }

    private String hd(int i) {
        return (String) this.ify.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.mContext, 2130903141, null);
            b bVar2 = new b();
            bVar2.eux = (TextView) view.findViewById(2131755497);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.eux.setText(hd(i));
        view.setBackgroundResource(2130838046);
        return view;
    }

    public final Filter getFilter() {
        if (this.nHK == null) {
            this.nHK = new a();
        }
        return this.nHK;
    }
}
