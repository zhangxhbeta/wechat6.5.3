package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.s;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.ui.MMActivity;

public class AppBrandSharedMessageUI extends MMActivity {
    private ListView Eq;
    private MRecyclerView dRT;

    public static class a extends android.support.v7.widget.RecyclerView.a {
        public final s a(ViewGroup viewGroup, int i) {
            return null;
        }

        public final void a(s sVar, int i) {
        }

        public final int getItemCount() {
            return 0;
        }

        public final int getItemViewType(int i) {
            return super.getItemViewType(i);
        }
    }

    private static class b extends BaseAdapter {
        private LayoutInflater CE;

        public b(LayoutInflater layoutInflater) {
            this.CE = layoutInflater;
        }

        public final int getCount() {
            return 0;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final int getItemViewType(int i) {
            return super.getItemViewType(i);
        }

        public final int getViewTypeCount() {
            return 4;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }

    protected final int getLayoutId() {
        return 2130903114;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Eq = (ListView) findViewById(2131755399);
        this.dRT = (MRecyclerView) findViewById(2131755400);
        this.Eq.setAdapter(new b(getLayoutInflater()));
        this.Eq.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ AppBrandSharedMessageUI dRU;

            {
                this.dRU = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.dRT.a(new LinearLayoutManager(1, false));
        this.dRT.a(new a());
        this.dRT.addHeaderView(getLayoutInflater().inflate(2130903113, null));
    }
}
