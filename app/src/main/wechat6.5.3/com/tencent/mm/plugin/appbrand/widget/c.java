package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.b.a.k;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.protocal.c.arn;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public final class c {
    private Context context;
    private String dFj = "";
    private String dFk;
    AppBrandLoginListView dVn;
    private b dVo;
    private LinearLayout dVp;

    public interface a {
        void c(int i, Bundle bundle);
    }

    private class b extends BaseAdapter {
        final /* synthetic */ c dVt;
        private LinkedList<arn> dVu;

        private class a {
            final /* synthetic */ b dVx;
            ImageView dVy;
            TextView dVz;

            private a(b bVar) {
                this.dVx = bVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return hz(i);
        }

        public b(c cVar, LinkedList<arn> linkedList) {
            this.dVt = cVar;
            this.dVu = linkedList;
        }

        public final int getCount() {
            return this.dVu == null ? 0 : this.dVu.size();
        }

        private arn hz(int i) {
            return (arn) this.dVu.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (this.dVu == null || this.dVu.size() <= 0) {
                return null;
            }
            a aVar;
            final arn hz = hz(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), 2130903104, null);
                aVar2.dVy = (ImageView) view.findViewById(2131755369);
                aVar2.dVz = (TextView) view.findViewById(2131755370);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (hz.mQG == 1) {
                aVar.dVy.setImageResource(2131165648);
            } else if (hz.mQG == 3) {
                aVar.dVy.setImageResource(2131165647);
            } else {
                aVar.dVy.setImageResource(2131165646);
            }
            aVar.dVz.setText(hz.gkC);
            final ImageView imageView = aVar.dVy;
            aVar.dVy.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b dVx;

                public final void onClick(View view) {
                    if (hz.mQG == 2) {
                        imageView.setImageResource(2131165648);
                        hz.mQG = 1;
                    } else if (hz.mQG == 1) {
                        imageView.setImageResource(2131165646);
                        hz.mQG = 2;
                    }
                }
            });
            return view;
        }
    }

    public c(Context context) {
        this.context = context;
    }

    public final void a(final LinkedList<arn> linkedList, String str, String str2, final a aVar) {
        v.d("MicroMsg.AppBrandJsLoginDialog", "stev AppBrandJsLoginDialog showAlert!");
        this.dFj = str;
        this.dFk = str2;
        if (linkedList.size() <= 0) {
            v.e("MicroMsg.AppBrandJsLoginDialog", "scopeInfoList is empty or null");
            return;
        }
        final i iVar = new i(this.context, 2131559265);
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(2130903105, null);
        ImageView imageView = (ImageView) linearLayout.findViewById(2131755373);
        android.support.v4.b.a.i a = k.a(aa.getResources(), com.tencent.mm.compatible.f.a.decodeResource(aa.getResources(), 2131166038));
        a.AM();
        if (imageView != null) {
            com.tencent.mm.t.a.b.AL().a(imageView, this.dFk, a, com.tencent.mm.t.a.c.cxH);
        }
        TextView textView = (TextView) linearLayout.findViewById(2131755374);
        if (this.dFj == null) {
            this.dFj = "";
        }
        textView.setText(this.context.getString(2131233550, new Object[]{this.dFj}));
        this.dVn = (AppBrandLoginListView) linearLayout.findViewById(2131755376);
        this.dVo = new b(this, linkedList);
        this.dVn.setAdapter(this.dVo);
        if (linkedList.size() > 5) {
            this.dVn.Tr = linkedList.size();
            this.dVp = (LinearLayout) linearLayout.findViewById(2131755375);
            LayoutParams layoutParams = (LayoutParams) this.dVp.getLayoutParams();
            layoutParams.height = this.context.getResources().getDimensionPixelSize(2131493475);
            this.dVp.setLayoutParams(layoutParams);
        }
        ((Button) linearLayout.findViewById(2131755378)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c dVt;

            public final void onClick(View view) {
                Serializable arrayList = new ArrayList();
                int i = 0;
                while (i < linkedList.size()) {
                    if (((arn) linkedList.get(i)).mQG == 2 || ((arn) linkedList.get(i)).mQG == 3) {
                        arrayList.add(((arn) linkedList.get(i)).miv);
                    }
                    i++;
                }
                v.d("MicroMsg.AppBrandJsLoginDialog", "stev acceptButton click!");
                Bundle bundle = new Bundle();
                bundle.putSerializable("key_scope", arrayList);
                aVar.c(1, bundle);
                iVar.dismiss();
            }
        });
        ((Button) linearLayout.findViewById(2131755377)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c dVt;

            public final void onClick(View view) {
                Serializable arrayList = new ArrayList();
                int i = 0;
                while (i < linkedList.size()) {
                    if (((arn) linkedList.get(i)).mQG == 2 || ((arn) linkedList.get(i)).mQG == 3) {
                        arrayList.add(((arn) linkedList.get(i)).miv);
                    }
                    i++;
                }
                v.d("MicroMsg.AppBrandJsLoginDialog", "stev rejectButton click!");
                Bundle bundle = new Bundle();
                bundle.putSerializable("key_scope", arrayList);
                aVar.c(2, bundle);
                iVar.dismiss();
            }
        });
        iVar.getWindow();
        iVar.setCanceledOnTouchOutside(false);
        iVar.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ c dVt;

            {
                this.dVt = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                if (this.dVt.dVn != null) {
                    this.dVt.dVn.setAdapter(null);
                }
            }
        });
        iVar.setOnCancelListener(new OnCancelListener(this) {
            final /* synthetic */ c dVt;

            public final void onCancel(DialogInterface dialogInterface) {
                v.d("MicroMsg.AppBrandJsLoginDialog", "stev dialog onCancel");
                aVar.c(3, null);
            }
        });
        iVar.setContentView(linearLayout);
        iVar.show();
    }
}
