package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class an extends com.tencent.mm.ui.base.AnimatedExpandableListView.a {
    public static int[] jPE = new int[]{2131235450, 2131235448, 2131235444, 2131235437};
    public static int[] jQa = new int[]{2131235451, 2131235449, 2131235445, 2131235438};
    private LayoutInflater CE;
    ArrayList<String> jQb;
    public int jQc = 0;
    public boolean jQd = false;
    public ArrayList<String> jQe = new ArrayList();
    public ArrayList<String> jQf = new ArrayList();
    public ArrayList<String> jQg = new ArrayList();
    public ArrayList<String> jQh = new ArrayList();
    private Context mContext;
    public int style;

    private class a {
        ImageView fgD;
        TextView gYK;
        TextView jQi;
        TextView jQj;
        final /* synthetic */ an jQk;
        TextView titleView;

        private a(an anVar) {
            this.jQk = anVar;
        }
    }

    public an(Context context) {
        this.mContext = context;
        this.CE = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public final Object getChild(int i, int i2) {
        return this.jQb.get(i2);
    }

    public final long getChildId(int i, int i2) {
        return 0;
    }

    public final void O(ArrayList<String> arrayList) {
        List<String> aXi = aXi();
        Object arrayList2 = new ArrayList();
        if (!(aXi == null || arrayList == null)) {
            for (String str : aXi) {
                if (g(arrayList, str)) {
                    arrayList.remove(str);
                    arrayList2.add(str);
                }
            }
            arrayList.addAll(0, arrayList2);
            String str2 = be.b(arrayList2, ",");
            ak.yW();
            c.vf().set(335875, str2);
        }
        this.jQb = arrayList;
    }

    private static List<String> aXi() {
        ak.yW();
        String str = (String) c.vf().get(335875, null);
        v.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", new Object[]{str});
        if (be.kS(str)) {
            return null;
        }
        return be.g(str.split(","));
    }

    public static void Ca(String str) {
        v.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "recordTopFive : %s", new Object[]{str});
        if (aXi() != null) {
            List arrayList = new ArrayList(aXi());
            if (!g(arrayList, str)) {
                if (arrayList.size() == 5) {
                    arrayList.remove(4);
                }
                arrayList.add(0, str);
                String b = be.b(arrayList, ",");
                ak.yW();
                c.vf().set(335875, b);
                return;
            }
            return;
        }
        ak.yW();
        c.vf().set(335875, str);
    }

    private CharSequence Cb(String str) {
        List<String> vy = com.tencent.mm.pluginsdk.j.a.bmu().vy(com.tencent.mm.pluginsdk.j.a.bmu().vv(str));
        if (vy == null || vy.size() == 0) {
            return "";
        }
        List arrayList = new ArrayList(vy.size());
        for (String er : vy) {
            arrayList.add(l.er(er));
        }
        return e.a(this.mContext, be.b(arrayList, ","));
    }

    private static boolean g(List<String> list, String str) {
        for (String equals : list) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean ae(int i, String str) {
        if (i == 1) {
            return g(this.jQe, str);
        }
        return g(this.jQf, str);
    }

    public final Object getGroup(int i) {
        return null;
    }

    public final int getGroupCount() {
        return 4;
    }

    public final long getGroupId(int i) {
        return 0;
    }

    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            View inflate;
            if (this.style == 1) {
                inflate = this.CE.inflate(2130904460, null);
            } else {
                inflate = this.CE.inflate(2130904459, null);
            }
            a aVar2 = new a();
            aVar2.titleView = (TextView) inflate.findViewById(2131759378);
            aVar2.fgD = (ImageView) inflate.findViewById(2131759382);
            aVar2.gYK = (TextView) inflate.findViewById(2131759379);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.titleView.setText(jPE[i]);
        aVar.gYK.setText(jQa[i]);
        switch (i) {
            case 0:
            case 1:
                if (this.jQc == i) {
                    aVar.fgD.setImageResource(2131165878);
                    aVar.fgD.setContentDescription(this.mContext.getString(2131234876));
                    break;
                }
                aVar.fgD.setImageResource(2131165881);
                break;
            case 2:
                if (this.jQc == i) {
                    aVar.fgD.setImageResource(2131165878);
                    aVar.fgD.setContentDescription(this.mContext.getString(2131234876));
                    break;
                }
                aVar.fgD.setImageResource(2131165881);
                break;
            case 3:
                if (this.style != 1) {
                    if (this.jQc == i) {
                        aVar.fgD.setImageResource(2131165880);
                        aVar.fgD.setContentDescription(this.mContext.getString(2131234876));
                        break;
                    }
                    aVar.fgD.setImageResource(2131165881);
                    break;
                } else if (this.jQc == i) {
                    aVar.fgD.setImageResource(2131165879);
                    aVar.fgD.setContentDescription(this.mContext.getString(2131234876));
                    break;
                } else {
                    aVar.fgD.setImageResource(2131165881);
                    break;
                }
        }
        if (!this.jQd || i != 1) {
            return view;
        }
        view = new View(this.mContext);
        view.setVisibility(8);
        return view;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    private static List<String> ah(List<String> list) {
        List<String> linkedList = new LinkedList();
        if (!ak.uz()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            ak.yW();
            u LX = c.wH().LX(obj2);
            if (!(LX == null || ((int) LX.chr) == 0)) {
                obj2 = LX.tU();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    public final View a(int i, int i2, View view) {
        a aVar;
        if (view == null) {
            View inflate;
            if (this.style == 1) {
                inflate = this.CE.inflate(2130904458, null);
            } else {
                inflate = this.CE.inflate(2130904457, null);
            }
            a aVar2 = new a();
            aVar2.titleView = (TextView) inflate.findViewById(2131759378);
            aVar2.gYK = (TextView) inflate.findViewById(2131759379);
            aVar2.jQi = (TextView) inflate.findViewById(2131759380);
            aVar2.jQj = (TextView) inflate.findViewById(2131759381);
            aVar2.fgD = (ImageView) inflate.findViewById(2131759382);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (i2 == this.jQb.size()) {
            aVar.titleView.setVisibility(8);
            aVar.gYK.setVisibility(8);
            aVar.fgD.setVisibility(8);
            aVar.jQi.setVisibility(0);
            aVar.jQj.setVisibility(0);
            if (i == 3) {
                if (this.jQh.size() > 0) {
                    aVar.jQj.setText("√" + be.b(ah(this.jQh), ","));
                    aVar.jQj.setVisibility(0);
                    aVar.jQj.setTextColor(this.mContext.getResources().getColor(2131690041));
                } else {
                    aVar.jQj.setText("");
                    aVar.jQj.setVisibility(8);
                }
            } else if (i == 2) {
                if (this.jQg.size() > 0) {
                    aVar.jQj.setText("√" + be.b(ah(this.jQg), ","));
                    aVar.jQj.setVisibility(0);
                    aVar.jQj.setTextColor(this.mContext.getResources().getColor(2131690040));
                } else {
                    aVar.jQj.setText("");
                    aVar.jQj.setVisibility(8);
                }
            }
        } else {
            aVar.titleView.setVisibility(0);
            aVar.gYK.setVisibility(0);
            aVar.fgD.setVisibility(0);
            aVar.jQi.setVisibility(8);
            aVar.jQj.setVisibility(8);
            String str = (String) this.jQb.get(i2);
            aVar.titleView.setText(e.a(this.mContext, str));
            aVar.gYK.setText(Cb(str));
            aVar.fgD.setVisibility(0);
            if (this.style == 1) {
                if (i == 2) {
                    if (ae(1, str)) {
                        aVar.fgD.setImageResource(2131165926);
                    } else {
                        aVar.fgD.setImageResource(2131165928);
                    }
                } else if (i == 3) {
                    if (this.jQc != i) {
                        aVar.fgD.setImageResource(2131165929);
                    } else {
                        aVar.fgD.setImageResource(2131165927);
                    }
                    if (ae(2, str)) {
                        aVar.fgD.setImageResource(2131165927);
                    } else {
                        aVar.fgD.setImageResource(2131165929);
                    }
                }
            } else if (i == 2) {
                if (ae(1, str)) {
                    aVar.fgD.setImageResource(2131165400);
                } else {
                    aVar.fgD.setImageResource(2131165403);
                }
            } else if (i == 3) {
                if (ae(2, str)) {
                    aVar.fgD.setImageResource(2131165402);
                } else {
                    aVar.fgD.setImageResource(2131165403);
                }
            }
        }
        return view;
    }

    public final int rb(int i) {
        if (i <= 1 || this.jQb == null) {
            return 0;
        }
        return this.jQb.size() + 1;
    }
}
