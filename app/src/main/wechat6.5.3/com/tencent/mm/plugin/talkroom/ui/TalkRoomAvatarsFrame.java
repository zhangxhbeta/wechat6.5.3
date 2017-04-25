package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.MMHorList;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomAvatarsFrame extends FrameLayout {
    private final int fSt = com.tencent.mm.bd.a.fromDPToPix(null, 58);
    private String gVg;
    a klA;
    private ah klB;
    private final int klx = 2000;
    private final int kly = 5;
    private MMHorList klz;
    private ac mHandler;

    private static class a extends BaseAdapter {
        String gVg;
        List<String> klE = new LinkedList();
        private Context mContext;

        class a {
            public ImageView dtX;
            public TextView euh;
            final /* synthetic */ a klF;

            a(a aVar) {
                this.klF = aVar;
            }
        }

        public a(Context context) {
            this.mContext = context;
        }

        public final int getCount() {
            return this.klE.size();
        }

        public final Object getItem(int i) {
            return this.klE.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            String str = (String) this.klE.get(i);
            if (view == null) {
                view = View.inflate(this.mContext, 2130904537, null);
                a aVar2 = new a(this);
                aVar2.dtX = (ImageView) view.findViewById(2131759538);
                aVar2.euh = (TextView) view.findViewById(2131759539);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.dtX.setBackgroundResource(str.equals(this.gVg) ? 2130839275 : 0);
            aVar.euh.setVisibility(8);
            b.b(aVar.dtX, str, true);
            return view;
        }
    }

    public TalkRoomAvatarsFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        NI();
    }

    public TalkRoomAvatarsFrame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        NI();
    }

    private void NI() {
        inflate(getContext(), 2130904536, this);
        this.klz = (MMHorList) findViewById(2131759537);
        this.klz.nWm = true;
        this.klz.nWl = true;
        this.klz.nWn = this.fSt;
        this.klA = new a(getContext());
        this.klz.setAdapter(this.klA);
        this.mHandler = new ac(Looper.getMainLooper());
        this.klz.nVW = new com.tencent.mm.ui.base.MMHorList.a(this) {
            final /* synthetic */ TalkRoomAvatarsFrame klC;

            {
                this.klC = r1;
            }

            public final void bau() {
                this.klC.klB.QI();
            }

            public final void bav() {
                this.klC.klB.ea(2000);
            }

            public final void ayd() {
                this.klC.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 klD;

                    {
                        this.klD = r1;
                    }

                    public final void run() {
                        this.klD.klC.klA.notifyDataSetChanged();
                    }
                });
            }
        };
        this.klB = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
            final /* synthetic */ TalkRoomAvatarsFrame klC;

            {
                this.klC = r1;
            }

            public final boolean oU() {
                this.klC.avT();
                return false;
            }
        }, false);
    }

    public final void CD(String str) {
        if (this.klz != null) {
            if (!be.kS(this.gVg) || !be.kS(str)) {
                if (be.kS(this.gVg) || !this.gVg.equals(str)) {
                    this.gVg = str;
                    avT();
                }
            }
        }
    }

    private void avT() {
        this.klA.gVg = this.gVg;
        if (be.kS(this.gVg)) {
            this.klA.notifyDataSetChanged();
        } else if (!this.klz.hDR) {
            a aVar = this.klA;
            int indexOf = aVar.klE.indexOf(this.gVg) * this.fSt;
            int i = this.klz.nVZ;
            if (indexOf < i) {
                this.klz.wz(indexOf);
            } else if (indexOf > i + (this.fSt * 4)) {
                this.klz.wz(indexOf - (this.fSt * 4));
            } else {
                this.klA.notifyDataSetChanged();
            }
        }
    }
}
