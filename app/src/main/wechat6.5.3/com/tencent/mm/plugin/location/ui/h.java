package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Iterator;

public final class h {
    Context context;
    private String eSe = "";
    private int fSt;
    MMHorList gUQ;
    a gUR;
    c gUS = null;
    private ac mHandler = new ac(Looper.getMainLooper());
    private boolean mIsInit = false;

    class a extends BaseAdapter {
        final /* synthetic */ h gUT;
        ArrayList<b> gUV = new ArrayList();

        public a(h hVar, ArrayList<b> arrayList) {
            this.gUT = hVar;
            this.gUV.addAll(arrayList);
        }

        public final int getCount() {
            return this.gUV.size();
        }

        public final Object getItem(int i) {
            return this.gUV.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            return ((b) this.gUV.get(i)).gUY.gUZ;
        }

        public final b vO(String str) {
            for (int i = 0; i < this.gUV.size(); i++) {
                if (((b) this.gUV.get(i)).username.equals(str)) {
                    return (b) this.gUV.get(i);
                }
            }
            return null;
        }

        public final boolean vP(String str) {
            for (int i = 0; i < this.gUV.size(); i++) {
                if (((b) this.gUV.get(i)).username.equals(str)) {
                    return true;
                }
            }
            return false;
        }

        public final ArrayList<String> awF() {
            ArrayList<String> arrayList = new ArrayList();
            Iterator it = this.gUV.iterator();
            while (it.hasNext()) {
                arrayList.add(((b) it.next()).username);
            }
            return arrayList;
        }
    }

    class b {
        final /* synthetic */ h gUT;
        boolean gUW = false;
        private LayoutParams gUX;
        a gUY;
        String username;

        class a {
            ImageView duZ;
            RelativeLayout gUZ;
            final /* synthetic */ b gVa;

            a(b bVar) {
                this.gVa = bVar;
            }
        }

        public b(h hVar, String str) {
            this.gUT = hVar;
            this.username = str;
            if (be.kS(str)) {
                v.e("MicroMsg.ShareHeaderAvatarViewMgr", "init HeaderAvatar, username can't not be null");
                return;
            }
            this.gUY = new a(this);
            LayoutInflater layoutInflater = (LayoutInflater) this.gUT.context.getSystemService("layout_inflater");
            this.gUY.gUZ = (RelativeLayout) layoutInflater.inflate(2130903868, null);
            this.gUY.duZ = (ImageView) this.gUY.gUZ.findViewById(2131756854);
            com.tencent.mm.pluginsdk.ui.a.b.o(this.gUY.duZ, this.username);
            this.gUY.gUZ.setTag(this.username);
            this.gUX = new LayoutParams(-2, -2);
            this.gUX.leftMargin = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.gUT.context, 5.0f);
            this.gUX.rightMargin = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.gUT.context, 5.0f);
            this.gUX.gravity = 17;
        }

        public final void awG() {
            v.i("MicroMsg.ShareHeaderAvatarViewMgr", "setTalking, username=%s", new Object[]{this.username});
            this.gUY.gUZ.setBackgroundResource(2130838491);
            this.gUY.gUZ.invalidate();
            this.gUW = true;
        }

        public final void awH() {
            v.i("MicroMsg.ShareHeaderAvatarViewMgr", "exitTalking, username=%s", new Object[]{this.username});
            this.gUY.gUZ.setBackgroundResource(2130838490);
            this.gUY.gUZ.invalidate();
            this.gUW = false;
        }
    }

    public interface c {
        void vQ(String str);
    }

    public h(Context context, View view, String str) {
        this.context = context;
        this.gUQ = (MMHorList) view;
        this.eSe = str;
        awD();
    }

    private void awD() {
        v.d("MicroMsg.ShareHeaderAvatarViewMgr", "initAvatarList, memebers.size=%d", new Object[]{Integer.valueOf(l.awj().vH(this.eSe).size())});
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : r0) {
            if (!be.kS(str)) {
                arrayList.add(new b(this, str));
                arrayList2.add(str);
            }
        }
        G(arrayList);
        H(arrayList2);
        this.gUQ.invalidate();
        this.gUR.notifyDataSetChanged();
    }

    private void G(ArrayList<b> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.gUW) {
                bVar.awG();
            }
        }
        this.fSt = com.tencent.mm.bd.a.fromDPToPix(this.context, 60);
        this.gUQ.nWm = true;
        this.gUQ.nWn = this.fSt;
        this.gUQ.nWl = true;
        this.gUQ.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ h gUT;

            {
                this.gUT = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String str = (String) view.getTag();
                if (!be.kS(str)) {
                    g.iuh.h(10997, new Object[]{"15", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                    if (this.gUT.gUS != null) {
                        this.gUT.gUS.vQ(str);
                    }
                }
            }
        });
        this.gUR = new a(this, arrayList);
        this.gUQ.setAdapter(this.gUR);
    }

    private void vL(String str) {
        v.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberEnter, usernmae=%s", new Object[]{str});
        if (!this.gUR.vP(str)) {
            b bVar = new b(this, str);
            a aVar = this.gUR;
            aVar.gUV.add(bVar);
            aVar.notifyDataSetChanged();
            this.gUQ.invalidate();
        }
    }

    private void vM(String str) {
        v.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberExit, username=%s", new Object[]{str});
        if (this.gUR.vP(str)) {
            a aVar = this.gUR;
            int i = 0;
            while (i < aVar.gUV.size()) {
                if (((b) aVar.gUV.get(i)).username.equals(str)) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i != -1) {
                aVar.gUV.remove(i);
                aVar.notifyDataSetChanged();
            }
            this.gUQ.invalidate();
        }
    }

    public final void vN(String str) {
        int i = 0;
        v.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberTalk, username=%s", new Object[]{str});
        if (this.gUR.vP(str)) {
            this.gUR.vO(str).awG();
            this.gUR.notifyDataSetChanged();
            this.gUQ.invalidate();
            if (!this.gUQ.hDR && !be.kS(str)) {
                a aVar = this.gUR;
                int i2 = 0;
                while (i2 < aVar.gUV.size()) {
                    if (((b) aVar.gUV.get(i2)).username.equals(str)) {
                        break;
                    }
                    i2++;
                }
                i2 = -1;
                v.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker, index=%d", new Object[]{Integer.valueOf(i2)});
                if (i2 != -1) {
                    int i3 = i2 * this.fSt;
                    int i4 = this.gUQ.nVZ;
                    if (i3 >= i4) {
                        i4 = i3 > i4 + (this.fSt * 3) ? i3 - (this.fSt * 3) : 0;
                    }
                    if (i2 != 0) {
                        i = i4;
                    }
                    this.mHandler.post(new Runnable(this) {
                        final /* synthetic */ h gUT;

                        public final void run() {
                            v.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker pos=%d", new Object[]{Integer.valueOf(i)});
                            this.gUT.gUQ.wz(i);
                        }
                    });
                }
            }
        }
    }

    public final void awE() {
        a aVar = this.gUR;
        Iterator it = aVar.gUV.iterator();
        while (it.hasNext()) {
            ((b) it.next()).awH();
        }
        aVar.notifyDataSetChanged();
        this.gUQ.invalidate();
    }

    public final void H(ArrayList<String> arrayList) {
        Iterator it;
        v.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, members.size=%d", new Object[]{Integer.valueOf(arrayList.size())});
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList awF = this.gUR.awF();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (awF.indexOf(str) == -1) {
                arrayList2.add(str);
            }
        }
        Iterator it3 = awF.iterator();
        while (it3.hasNext()) {
            str = (String) it3.next();
            if (arrayList.indexOf(str) == -1) {
                arrayList3.add(str);
            }
        }
        v.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, newMember.size=%d, removeMember.size=%d", new Object[]{Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList3.size())});
        if (arrayList2.size() > 0) {
            it = arrayList2.iterator();
            while (it.hasNext()) {
                vL((String) it.next());
            }
        }
        if (arrayList3.size() > 0) {
            it = arrayList3.iterator();
            while (it.hasNext()) {
                vM((String) it.next());
            }
        }
    }
}
