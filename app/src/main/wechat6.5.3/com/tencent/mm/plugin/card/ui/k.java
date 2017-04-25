package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.g;
import java.util.ArrayList;
import java.util.List;

public final class k extends BaseAdapter {
    List<b> eBl = new ArrayList();
    OnClickListener eLZ;
    boolean eMa = false;
    private Context mContext;

    private class a {
        TextView eLe;
        final /* synthetic */ k eMb;
        TextView eMf;
        TextView eMg;
        ImageView eMh;
        CheckBox eMi;
        View edj;

        private a(k kVar) {
            this.eMb = kVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return ji(i);
    }

    public k(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.eBl.size();
    }

    private b ji(int i) {
        return (b) this.eBl.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        final b ji = ji(i);
        switch (ji.eBU) {
            case 2:
                view = View.inflate(this.mContext, 2130903206, null);
                TextView textView = (TextView) view.findViewById(2131755742);
                TextView textView2 = (TextView) view.findViewById(2131755743);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(2131755744);
                if (TextUtils.isEmpty(ji.eBY)) {
                    linearLayout.setVisibility(8);
                } else {
                    linearLayout.setTag(ji.eBY);
                    linearLayout.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ k eMb;

                        {
                            this.eMb = r1;
                        }

                        public final void onClick(View view) {
                            String str = (String) view.getTag();
                            if (!TextUtils.isEmpty(str)) {
                                String substring;
                                if (str.contains(";")) {
                                    substring = str.substring(0, str.indexOf(";"));
                                } else {
                                    substring = str;
                                }
                                g.a(this.eMb.mContext, true, substring, "", this.eMb.mContext.getString(2131232024), this.eMb.mContext.getString(2131231010), new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 eMd;

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent("android.intent.action.DIAL");
                                        intent.setFlags(268435456);
                                        intent.setData(Uri.parse("tel:" + substring));
                                        this.eMd.eMb.mContext.startActivity(intent);
                                    }
                                }, null);
                            }
                        }
                    });
                    ((ImageView) view.findViewById(2131755745)).setBackgroundColor(j.qv(ji.coN));
                    linearLayout.setVisibility(0);
                }
                textView.setText(ji.title);
                textView2.setText(ji.eBN);
                break;
            default:
                a aVar;
                boolean z;
                if (view != null) {
                    aVar = (a) view.getTag();
                } else {
                    aVar = null;
                }
                if (view == null || r0 == null) {
                    view = View.inflate(this.mContext, 2130903207, null);
                    a aVar2 = new a();
                    aVar2.eLe = (TextView) view.findViewById(2131755750);
                    aVar2.eMf = (TextView) view.findViewById(2131755751);
                    aVar2.eMg = (TextView) view.findViewById(2131755747);
                    aVar2.eMh = (ImageView) view.findViewById(2131755749);
                    aVar2.edj = view.findViewById(2131755748);
                    aVar2.eMi = (CheckBox) view.findViewById(2131755752);
                    view.setTag(aVar2);
                    aVar = aVar2;
                }
                aVar.eLe.setText(ji.title);
                if (ji.eBW) {
                    aVar.eMi.setVisibility(0);
                    aVar.eMi.setChecked(ji.eBX);
                    aVar.eMi.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ k eMb;

                        public final void onClick(View view) {
                            if (((CheckBox) view).isChecked()) {
                                ji.eBX = true;
                            } else {
                                ji.eBX = false;
                            }
                        }
                    });
                } else {
                    aVar.eMi.setVisibility(8);
                }
                if (TextUtils.isEmpty(ji.eBN)) {
                    aVar.eMf.setVisibility(4);
                } else {
                    aVar.eMf.setVisibility(0);
                    aVar.eMf.setText(ji.eBN);
                }
                if ((ji.mlB & 1) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    aVar.eLe.setGravity(17);
                    aVar.eLe.setTextColor(this.mContext.getResources().getColor(2131689819));
                    aVar.eMf.setVisibility(8);
                } else {
                    aVar.eLe.setGravity(3);
                    aVar.eLe.setTextColor(this.mContext.getResources().getColor(2131689809));
                }
                if (ji.eBV) {
                    aVar.eMg.setVisibility(0);
                } else {
                    aVar.eMg.setVisibility(8);
                }
                aVar.eMf.setTextColor(this.mContext.getResources().getColor(2131689808));
                if (be.kS(ji.eBZ)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    aVar.eMh.setVisibility(0);
                    com.tencent.mm.plugin.card.b.k.a(aVar.eMh, ji.eBZ, com.tencent.mm.bd.a.fromDPToPix(this.mContext, 20), 2130838736, false);
                } else {
                    aVar.eMh.setVisibility(8);
                }
                if (i + 1 >= getCount()) {
                    if (i + 1 == getCount()) {
                        if (!this.eMa) {
                            i(aVar.edj, false);
                            break;
                        }
                        i(aVar.edj, true);
                        break;
                    }
                }
                a(aVar.edj, ji(i));
                a(aVar.edj, ji(i + 1));
                break;
                break;
        }
        return view;
    }

    private static void a(View view, b bVar) {
        if (bVar != null) {
            i(view, bVar.eBV);
        }
    }

    private static void i(View view, boolean z) {
        Rect rect = new Rect();
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z) {
            view.setBackgroundResource(2130838689);
        } else {
            view.setBackgroundResource(2130838468);
        }
        view.setLayoutParams(layoutParams);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
