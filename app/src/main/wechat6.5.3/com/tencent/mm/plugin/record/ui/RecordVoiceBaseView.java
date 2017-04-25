package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.as.u;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.record.a.r;
import com.tencent.mm.plugin.record.a.r.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.s;

public class RecordVoiceBaseView extends TextView implements a {
    private boolean aHp = false;
    public int bdW;
    private Context context;
    public int duration = -1;
    private AlphaAnimation iqH;
    private AnimationDrawable iqI;
    public r iqJ;
    public String path = "";

    static /* synthetic */ void d(RecordVoiceBaseView recordVoiceBaseView) {
        v.d("MicroMsg.RecordVoiceBaseView", "start play, path[%s] voiceType[%d]", new Object[]{recordVoiceBaseView.path, Integer.valueOf(recordVoiceBaseView.bdW)});
        if (!recordVoiceBaseView.iqJ.au(recordVoiceBaseView.path, recordVoiceBaseView.bdW)) {
            Toast.makeText(recordVoiceBaseView.getContext(), 2131232754, 1).show();
        } else if (!recordVoiceBaseView.aHp) {
            recordVoiceBaseView.aHp = true;
            recordVoiceBaseView.setCompoundDrawablesWithIntrinsicBounds(recordVoiceBaseView.iqI, null, null, null);
            recordVoiceBaseView.iqI.stop();
            recordVoiceBaseView.iqI.start();
        }
    }

    static /* synthetic */ boolean e(RecordVoiceBaseView recordVoiceBaseView) {
        v.i("MicroMsg.RecordVoiceBaseView", "resume play");
        r rVar = recordVoiceBaseView.iqJ;
        v.i("MicroMsg.RecordVoiceHelper", "resume play");
        ab.Ki("keep_app_silent");
        if (rVar.fLu != null) {
            return rVar.fLu.oV();
        }
        v.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
        return false;
    }

    public RecordVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        aJU();
    }

    public RecordVoiceBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        aJU();
    }

    private void aJU() {
        this.iqH = new AlphaAnimation(0.1f, 1.0f);
        this.iqH.setDuration(1000);
        this.iqH.setRepeatCount(-1);
        this.iqH.setRepeatMode(2);
        this.iqI = new AnimationDrawable();
        Drawable drawable = getResources().getDrawable(2131165377);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.iqI.addFrame(drawable, 300);
        drawable = getResources().getDrawable(2131165378);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.iqI.addFrame(drawable, 300);
        drawable = getResources().getDrawable(2131165379);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.iqI.addFrame(drawable, 300);
        this.iqI.setOneShot(false);
        this.iqI.setVisible(true, true);
    }

    private void aJV() {
        if (this.iqH != null && this.iqH.isInitialized()) {
            setAnimation(null);
        }
        this.aHp = false;
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2131165376), null, null, null);
        this.iqI.stop();
    }

    protected void onFinishInflate() {
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RecordVoiceBaseView iqK;

            {
                this.iqK = r1;
            }

            public final void onClick(View view) {
                v.d("MicroMsg.RecordVoiceBaseView", "clicked path %s, isPlay %s", new Object[]{this.iqK.path, Boolean.valueOf(this.iqK.iqJ.alM())});
                if (!u.bj(this.iqK.context) && !com.tencent.mm.ah.a.aT(this.iqK.context)) {
                    if (!f.sj() && !be.kS(this.iqK.path)) {
                        s.ey(view.getContext());
                    } else if (!be.ah(this.iqK.path, "").equals(this.iqK.iqJ.path)) {
                        RecordVoiceBaseView.d(this.iqK);
                    } else if (this.iqK.iqJ.alM()) {
                        this.iqK.XV();
                    } else if (!RecordVoiceBaseView.e(this.iqK)) {
                        RecordVoiceBaseView.d(this.iqK);
                    }
                }
            }
        });
    }

    public final void XV() {
        v.d("MicroMsg.RecordVoiceBaseView", "stop play");
        aJV();
        this.iqJ.XV();
    }

    public final void yz(String str) {
        v.d("MicroMsg.RecordVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[]{this.path, Integer.valueOf(this.duration), str});
        if (!be.ah(str, "").equals(this.path)) {
            aJV();
        }
    }

    public final void onFinish() {
        XV();
    }
}
