package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.mm.model.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class j {
    TextView EI;
    Context context;
    private String eSe;
    int gVA = Color.parseColor("#FFC90C");
    boolean gVB = false;
    String gVC = "";
    boolean gVh = false;
    private ViewGroup gVj;
    ArrayList<String> gVk;
    private final int gVl = 100;
    private final int gVm = 1;
    private final int gVn = 2;
    private final int gVo = 3;
    private final int gVp = 4;
    private final int gVq = 5;
    private final int gVr = 6;
    private final int gVs = 7;
    private final int gVt = 8;
    private final int gVu = 9;
    private final int gVv = 10;
    boolean gVw = true;
    private int gVx = Color.parseColor("#44FEBB");
    int gVy = Color.parseColor("#FFFFFF");
    int gVz = Color.parseColor("#E54646");
    ac mHandler = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ j gVD;

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            j jVar;
            Message obtain;
            String er;
            switch (message.what) {
                case 1:
                    this.gVD.EI.setText(this.gVD.gVC);
                    return;
                case 2:
                    v.d("MicroMsg.ShareHeaderMsgMgr", "update member num, isMyselfTalking=%b, isOtherTalking=%b", new Object[]{Boolean.valueOf(this.gVD.gVh), Boolean.valueOf(this.gVD.gVB)});
                    if (!this.gVD.gVh && !this.gVD.gVB) {
                        jVar = this.gVD;
                        jVar.EI.setTextColor(jVar.gVy);
                        jVar.EI.invalidate();
                        int intValue = ((Integer) message.obj).intValue();
                        if (intValue == 0) {
                            this.gVD.EI.setText(this.gVD.context.getString(2131235686));
                            return;
                        }
                        this.gVD.EI.setText(this.gVD.context.getResources().getQuantityString(2131361823, intValue, new Object[]{Integer.valueOf(intValue)}));
                        return;
                    }
                    return;
                case 3:
                    if (this.gVD.gVB || this.gVD.gVh) {
                        removeMessages(3);
                        obtain = Message.obtain();
                        obtain.what = 3;
                        obtain.obj = message.obj;
                        sendMessage(obtain);
                        return;
                    }
                    this.gVD.gVC = this.gVD.EI.getText().toString();
                    j.a(this.gVD);
                    er = l.er((String) message.obj);
                    this.gVD.EI.setText(this.gVD.context.getString(2131235692, new Object[]{er}));
                    if (this.gVD.gVh || this.gVD.gVB) {
                        j.b(this.gVD);
                        return;
                    }
                    return;
                case 4:
                    if (this.gVD.gVB || this.gVD.gVh) {
                        removeMessages(4);
                        obtain = Message.obtain();
                        obtain.what = 4;
                        obtain.obj = message.obj;
                        sendMessage(obtain);
                        return;
                    }
                    this.gVD.gVC = this.gVD.EI.getText().toString();
                    j.a(this.gVD);
                    er = l.er((String) message.obj);
                    this.gVD.EI.setText(this.gVD.context.getString(2131235693, new Object[]{er}));
                    if (this.gVD.gVh || this.gVD.gVB) {
                        j.b(this.gVD);
                        return;
                    }
                    return;
                case 5:
                    this.gVD.gVB = true;
                    this.gVD.gVh = false;
                    j.a(this.gVD);
                    er = l.er((String) message.obj);
                    this.gVD.EI.setText(this.gVD.context.getString(2131235694, new Object[]{er}));
                    return;
                case 6:
                    this.gVD.gVh = true;
                    this.gVD.gVB = false;
                    j.a(this.gVD);
                    this.gVD.EI.setText(this.gVD.context.getString(2131235691));
                    return;
                case 7:
                    this.gVD.gVB = true;
                    jVar = this.gVD;
                    jVar.EI.setTextColor(jVar.gVz);
                    jVar.EI.invalidate();
                    this.gVD.EI.setText(this.gVD.context.getString(2131235696));
                    this.gVD.gVC = this.gVD.EI.getText().toString();
                    j.b(this.gVD);
                    return;
                case 8:
                    jVar = this.gVD;
                    jVar.EI.setTextColor(jVar.gVA);
                    jVar.EI.invalidate();
                    this.gVD.EI.setText(this.gVD.context.getString(2131235697));
                    return;
                case NetStatusUtil.MOBILE /*9*/:
                    this.gVD.gVh = false;
                    if (!this.gVD.gVB) {
                        this.gVD.dW(true);
                        return;
                    }
                    return;
                case NetStatusUtil.LTE /*10*/:
                    this.gVD.gVB = false;
                    this.gVD.dW(false);
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ void a(j jVar) {
        jVar.EI.setTextColor(jVar.gVx);
        jVar.EI.invalidate();
    }

    static /* synthetic */ void b(j jVar) {
        jVar.mHandler.removeMessages(1);
        Message obtain = Message.obtain();
        obtain.what = 1;
        jVar.mHandler.sendMessageDelayed(obtain, 100);
    }

    public j(Context context, ViewGroup viewGroup, String str) {
        this.context = context;
        this.gVj = viewGroup;
        this.EI = (TextView) this.gVj.findViewById(2131755226);
        this.eSe = str;
        init();
    }

    private void init() {
        v.d("MicroMsg.ShareHeaderMsgMgr", "init");
        this.EI.invalidate();
        this.gVk = new ArrayList();
        for (String add : com.tencent.mm.plugin.location.model.l.awj().vH(this.eSe)) {
            this.gVk.add(add);
        }
        dW(false);
    }

    final void dW(boolean z) {
        this.mHandler.removeMessages(2);
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = Integer.valueOf(this.gVk.size());
        v.d("MicroMsg.ShareHeaderMsgMgr", "updateMemberCount, size=%d, isDelay=%b", new Object[]{Integer.valueOf(this.gVk.size()), Boolean.valueOf(z)});
        if (z) {
            this.mHandler.sendMessageDelayed(obtain, 100);
        } else {
            this.mHandler.sendMessage(obtain);
        }
    }
}
