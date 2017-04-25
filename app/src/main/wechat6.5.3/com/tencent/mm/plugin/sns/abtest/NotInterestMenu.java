package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.ui.q;

public class NotInterestMenu extends LinearLayout {
    private static int[] jaT = new int[]{2131235428, 2131235426, 2131235427};
    k jaC = null;
    private ListView jaS;
    c jaU = null;
    b jaV = null;
    private Context mContext = null;

    class a extends BaseAdapter {
        final /* synthetic */ NotInterestMenu jaW;

        class a {
            TextView jaX;
            final /* synthetic */ a jaY;

            a(a aVar) {
                this.jaY = aVar;
            }
        }

        a(NotInterestMenu notInterestMenu) {
            this.jaW = notInterestMenu;
        }

        public final int getCount() {
            return NotInterestMenu.jaT.length;
        }

        public final Object getItem(int i) {
            return Integer.valueOf(NotInterestMenu.jaT[i]);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = q.em(this.jaW.mContext).inflate(2130904134, viewGroup, false);
                a aVar = new a(this);
                aVar.jaX = (TextView) view.findViewById(2131758464);
                view.setTag(aVar);
            }
            ((a) view.getTag()).jaX.setText(NotInterestMenu.jaT[i]);
            return view;
        }
    }

    public interface b {
        void aQO();
    }

    public interface c {
        void c(k kVar);

        void d(k kVar);

        void e(k kVar);
    }

    public NotInterestMenu(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public NotInterestMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        q.em(this.mContext).inflate(2130904133, this);
        this.jaS = (ListView) findViewById(2131758463);
        this.jaS.setAdapter(new a(this));
        this.jaS.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ NotInterestMenu jaW;

            {
                this.jaW = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.jaW.jaV != null) {
                    this.jaW.jaV.aQO();
                }
                if (this.jaW.jaU != null) {
                    switch (i) {
                        case 0:
                            this.jaW.jaU.c(this.jaW.jaC);
                            return;
                        case 1:
                            this.jaW.jaU.d(this.jaW.jaC);
                            return;
                        case 2:
                            this.jaW.jaU.e(this.jaW.jaC);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
