package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mmdb.database.SQLiteDebug;

public class AnimImageView extends TextView {
    private boolean aHp = false;
    private Context context;
    private AlphaAnimation iqH;
    private AnimationDrawable iqI;
    public boolean nSh = false;
    private AnimationDrawable nSi;
    private int type = 1;

    public final void bBF() {
        if (this.nSh) {
            setBackgroundDrawable(a.a(this.context, 2130837949));
        } else {
            setBackgroundDrawable(a.a(this.context, 2130838028));
        }
    }

    public final void bBG() {
        switch (this.type) {
            case 0:
                if (this.nSh) {
                    setBackgroundDrawable(a.a(this.context, 2130837949));
                } else {
                    setBackgroundDrawable(a.a(this.context, 2130838028));
                }
                setAnimation(this.iqH);
                this.iqH.startNow();
                return;
            case 1:
                if (!this.aHp) {
                    this.aHp = true;
                    if (this.nSh) {
                        setCompoundDrawablesWithIntrinsicBounds(this.iqI, null, null, null);
                        this.iqI.stop();
                        this.iqI.start();
                        return;
                    }
                    setCompoundDrawablesWithIntrinsicBounds(null, null, this.nSi, null);
                    this.nSi.stop();
                    this.nSi.start();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void aJV() {
        if (this.iqH != null && this.iqH.isInitialized()) {
            setAnimation(null);
        }
        if (this.type == 1) {
            this.aHp = false;
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            this.iqI.stop();
            this.nSi.stop();
        }
    }

    public AnimImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        aJU();
    }

    public AnimImageView(Context context, AttributeSet attributeSet, int i) {
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
        this.iqI.addFrame(drawable, SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD);
        drawable = getResources().getDrawable(2131165378);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.iqI.addFrame(drawable, SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD);
        drawable = getResources().getDrawable(2131165379);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.iqI.addFrame(drawable, SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD);
        this.iqI.setOneShot(false);
        this.iqI.setVisible(true, true);
        this.nSi = new AnimationDrawable();
        drawable = getResources().getDrawable(2131165397);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.nSi.addFrame(drawable, SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD);
        drawable = getResources().getDrawable(2131165398);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.nSi.addFrame(drawable, SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD);
        drawable = getResources().getDrawable(2131165399);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.nSi.addFrame(drawable, SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD);
        this.nSi.setOneShot(false);
        this.nSi.setVisible(true, true);
    }
}
