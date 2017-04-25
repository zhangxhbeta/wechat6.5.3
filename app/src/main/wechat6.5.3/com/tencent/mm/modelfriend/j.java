package com.tencent.mm.modelfriend;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.a.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.protocal.c.agl;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j extends BaseAdapter {
    int aXx = 1;
    private List<String[]> cHA = new LinkedList();
    public int[] cHB;
    private a cHC;
    public com.tencent.mm.ui.applet.b cHD = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a(this) {
        final /* synthetic */ j cHF;

        {
            this.cHF = r1;
        }

        public final Bitmap iG(String str) {
            return com.tencent.mm.u.b.a(str, false, -1);
        }
    });
    private com.tencent.mm.ui.applet.b.b cHE = null;
    public LinkedList<agl> cHx = new LinkedList();
    private LinkedList<agl> cHy = new LinkedList();
    public List<String[]> cHz;
    private Context context;

    public interface a {
        void notifyDataSetChanged();
    }

    static class b {
        ImageView cHH;
        TextView cHI;
        TextView cHJ;
        Button cHK;
        Button cHL;
        TextView cHM;
        TextView cHN;

        b() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return fn(i);
    }

    public j(Context context, a aVar, int i) {
        this.context = context;
        this.aXx = i;
        this.cHC = aVar;
        this.cHB = new int[this.cHx.size()];
    }

    public final int ES() {
        int i = 0;
        for (int i2 : this.cHB) {
            if (this.aXx == 1) {
                if (i2 == 1) {
                    i++;
                }
            } else if (this.aXx == 2 && i2 == 2) {
                i++;
            }
        }
        return i;
    }

    public final boolean ET() {
        if (this.cHB == null || this.cHB.length == 0) {
            return false;
        }
        for (int i : this.cHB) {
            if (this.aXx == 1) {
                if (i == 0) {
                    return false;
                }
            } else if (this.aXx == 2 && i == 0) {
                return false;
            }
        }
        return true;
    }

    public final void fm(int i) {
        if (this.aXx == 1) {
            this.cHB[i] = 1;
        } else if (this.aXx == 2) {
            this.cHB[i] = 2;
        }
        notifyDataSetChanged();
    }

    public final void bb(boolean z) {
        int i;
        int i2;
        if (this.aXx == 1) {
            for (i = 0; i < this.cHB.length; i++) {
                int[] iArr = this.cHB;
                if (z) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                iArr[i] = i2;
            }
        } else if (this.aXx == 2) {
            for (i = 0; i < this.cHB.length; i++) {
                int[] iArr2 = this.cHB;
                if (z) {
                    i2 = 2;
                } else {
                    i2 = 0;
                }
                iArr2[i] = i2;
            }
        }
        notifyDataSetChanged();
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        if (this.cHC != null) {
            this.cHC.notifyDataSetChanged();
        }
    }

    public final void f(LinkedList<agl> linkedList) {
        if (linkedList != null) {
            this.cHy.clear();
            this.cHx.clear();
            this.cHA.clear();
            for (String[] strArr : this.cHz) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    agl com_tencent_mm_protocal_c_agl = (agl) it.next();
                    if (this.aXx == 1) {
                        if ((com_tencent_mm_protocal_c_agl.eeO == 1 || com_tencent_mm_protocal_c_agl.eeO == 0) && !be.kS(strArr[2]) && com_tencent_mm_protocal_c_agl.itR.equals(g.m(strArr[2].getBytes()))) {
                            a(com_tencent_mm_protocal_c_agl, strArr);
                        }
                    } else if (this.aXx == 2 && com_tencent_mm_protocal_c_agl.eeO == 2 && !be.kS(strArr[2]) && com_tencent_mm_protocal_c_agl.itR.equals(g.m(strArr[2].getBytes()))) {
                        a(com_tencent_mm_protocal_c_agl, strArr);
                    }
                }
            }
        }
        this.cHB = new int[this.cHy.size()];
        this.cHx.addAll(this.cHy);
        this.cHy.clear();
    }

    private void a(agl com_tencent_mm_protocal_c_agl, String[] strArr) {
        Iterator it = this.cHy.iterator();
        while (it.hasNext()) {
            agl com_tencent_mm_protocal_c_agl2 = (agl) it.next();
            if (com_tencent_mm_protocal_c_agl2.itR != null && com_tencent_mm_protocal_c_agl.itR != null && com_tencent_mm_protocal_c_agl2.itR.equals(com_tencent_mm_protocal_c_agl.itR)) {
                v.d("MicroMsg.FriendAdapter", "tigerreg mobile already added");
                return;
            }
        }
        this.cHy.add(com_tencent_mm_protocal_c_agl);
        this.cHA.add(new String[]{strArr[2], strArr[1]});
    }

    public final int getCount() {
        return this.cHx.size();
    }

    public final agl fn(int i) {
        return (agl) this.cHx.get(i);
    }

    public final long getItemId(int i) {
        return (long) ((agl) this.cHx.get(i)).hashCode();
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (this.aXx == 1) {
            if (this.cHE == null) {
                this.cHE = new com.tencent.mm.ui.applet.b.b(this) {
                    final /* synthetic */ j cHF;

                    {
                        this.cHF = r1;
                    }

                    public final String fo(int i) {
                        if (i < 0 || i >= this.cHF.getCount()) {
                            v.e("MicroMsg.FriendAdapter", "pos is invalid");
                            return null;
                        }
                        agl fn = this.cHF.fn(i);
                        if (fn != null) {
                            return fn.gln;
                        }
                        return null;
                    }

                    public final int EU() {
                        return this.cHF.getCount();
                    }
                };
            }
            if (this.cHD != null) {
                this.cHD.a(i, this.cHE);
            }
        }
        agl com_tencent_mm_protocal_c_agl = (agl) this.cHx.get(i);
        if (view == null) {
            bVar = new b();
            if (this.aXx == 1) {
                view = View.inflate(this.context, 2130903635, null);
                bVar.cHI = (TextView) view.findViewById(2131757021);
                bVar.cHJ = (TextView) view.findViewById(2131757026);
                bVar.cHK = (Button) view.findViewById(2131757024);
                bVar.cHL = (Button) view.findViewById(2131757025);
                bVar.cHH = (ImageView) view.findViewById(2131757020);
                bVar.cHM = (TextView) view.findViewById(2131757022);
                bVar.cHN = (TextView) view.findViewById(2131757023);
                view.setTag(bVar);
            } else if (this.aXx == 2) {
                view = View.inflate(this.context, 2130903636, null);
                bVar.cHI = (TextView) view.findViewById(2131757021);
                bVar.cHJ = (TextView) view.findViewById(2131757026);
                bVar.cHK = (Button) view.findViewById(2131757024);
                bVar.cHL = (Button) view.findViewById(2131757025);
                bVar.cHM = (TextView) view.findViewById(2131757022);
                bVar.cHN = (TextView) view.findViewById(2131757023);
                view.setTag(bVar);
            }
        } else {
            bVar = (b) view.getTag();
        }
        bVar.cHN.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ j cHF;

            public final void onClick(View view) {
                j jVar = this.cHF;
                int i = i;
                if (jVar.aXx == 1) {
                    jVar.cHB[i] = 0;
                } else if (jVar.aXx == 2) {
                    jVar.cHB[i] = 0;
                }
                jVar.notifyDataSetChanged();
            }
        });
        if (this.aXx == 1) {
            if (!be.kS(((String[]) this.cHA.get(i))[1])) {
                bVar.cHI.setText(((String[]) this.cHA.get(i))[1]);
            } else if (be.kS(com_tencent_mm_protocal_c_agl.efy)) {
                bVar.cHI.setText(com_tencent_mm_protocal_c_agl.gln);
            } else {
                bVar.cHI.setText(com_tencent_mm_protocal_c_agl.efy);
            }
            bVar.cHK.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ j cHF;

                public final void onClick(View view) {
                    this.cHF.fm(i);
                }
            });
            com.tencent.mm.pluginsdk.ui.a.b.m(bVar.cHH, com_tencent_mm_protocal_c_agl.gln);
        } else if (this.aXx == 2) {
            bVar.cHI.setText(((String[]) this.cHA.get(i))[1]);
            bVar.cHL.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ j cHF;

                public final void onClick(View view) {
                    this.cHF.fm(i);
                }
            });
        }
        switch (this.cHB[i]) {
            case 0:
                if (this.aXx != 1) {
                    if (this.aXx == 2) {
                        bVar.cHJ.setVisibility(8);
                        bVar.cHK.setVisibility(8);
                        bVar.cHL.setVisibility(0);
                        bVar.cHM.setVisibility(8);
                        bVar.cHN.setVisibility(8);
                        break;
                    }
                }
                bVar.cHJ.setVisibility(8);
                bVar.cHK.setVisibility(0);
                bVar.cHL.setVisibility(8);
                bVar.cHM.setVisibility(8);
                bVar.cHN.setVisibility(8);
                break;
                break;
            case 1:
                bVar.cHK.setVisibility(8);
                bVar.cHJ.setVisibility(0);
                bVar.cHM.setVisibility(0);
                bVar.cHN.setVisibility(0);
                break;
            case 2:
                bVar.cHK.setVisibility(8);
                bVar.cHL.setVisibility(8);
                bVar.cHJ.setVisibility(0);
                bVar.cHM.setVisibility(0);
                bVar.cHN.setVisibility(0);
                break;
            case 3:
                bVar.cHK.setVisibility(8);
                bVar.cHJ.setVisibility(0);
                bVar.cHM.setVisibility(0);
                bVar.cHN.setVisibility(0);
                break;
        }
        return view;
    }

    public final void iF(String str) {
        List arrayList = new ArrayList();
        for (int i = 0; i < this.cHA.size(); i++) {
            if (this.cHB[i] == 2) {
                arrayList.add(((String[]) this.cHA.get(i))[0]);
            }
        }
        ak.vy().a(new ab(str, arrayList), 0);
    }
}
