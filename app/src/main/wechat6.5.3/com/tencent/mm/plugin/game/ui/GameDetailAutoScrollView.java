package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import java.util.ArrayList;

public class GameDetailAutoScrollView extends LinearLayout {
    int fqz = 0;
    ah gpC = new ah(new a(this) {
        final /* synthetic */ GameDetailAutoScrollView gqX;

        {
            this.gqX = r1;
        }

        public final boolean oU() {
            GameDetailAutoScrollView.a(this.gqX);
            return true;
        }
    }, true);
    ArrayList<String> gqO = new ArrayList();
    ViewGroup gqP;
    TextView gqQ;
    TextView gqR;
    ViewGroup gqS;
    private TextView gqT;
    private TextView gqU;
    private Animation gqV;
    private Animation gqW;

    static /* synthetic */ void a(GameDetailAutoScrollView gameDetailAutoScrollView) {
        if (gameDetailAutoScrollView.fqz < (gameDetailAutoScrollView.gqO.size() / 2) - 1) {
            gameDetailAutoScrollView.fqz++;
        } else {
            gameDetailAutoScrollView.fqz = 0;
        }
        String str = (String) gameDetailAutoScrollView.gqO.get((gameDetailAutoScrollView.fqz * 2) + 1);
        gameDetailAutoScrollView.gqT.setText(e.a(gameDetailAutoScrollView.getContext(), (String) gameDetailAutoScrollView.gqO.get(gameDetailAutoScrollView.fqz * 2), gameDetailAutoScrollView.gqT.getTextSize()));
        gameDetailAutoScrollView.gqU.setText(str);
        gameDetailAutoScrollView.gqP.startAnimation(gameDetailAutoScrollView.gqW);
        gameDetailAutoScrollView.gqP.setVisibility(8);
        gameDetailAutoScrollView.gqS.startAnimation(gameDetailAutoScrollView.gqV);
        gameDetailAutoScrollView.gqS.setVisibility(0);
        ViewGroup viewGroup = gameDetailAutoScrollView.gqP;
        gameDetailAutoScrollView.gqP = gameDetailAutoScrollView.gqS;
        gameDetailAutoScrollView.gqS = viewGroup;
        TextView textView = gameDetailAutoScrollView.gqQ;
        gameDetailAutoScrollView.gqQ = gameDetailAutoScrollView.gqT;
        gameDetailAutoScrollView.gqT = textView;
        textView = gameDetailAutoScrollView.gqR;
        gameDetailAutoScrollView.gqR = gameDetailAutoScrollView.gqU;
        gameDetailAutoScrollView.gqU = textView;
    }

    public GameDetailAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gqP = (ViewGroup) LayoutInflater.from(context).inflate(2130903706, this, false);
        this.gqQ = (TextView) this.gqP.findViewById(2131757268);
        this.gqR = (TextView) this.gqP.findViewById(2131757269);
        addView(this.gqP);
        this.gqP.setVisibility(8);
        this.gqS = (ViewGroup) LayoutInflater.from(context).inflate(2130903706, this, false);
        this.gqT = (TextView) this.gqS.findViewById(2131757268);
        this.gqU = (TextView) this.gqS.findViewById(2131757269);
        addView(this.gqS);
        this.gqS.setVisibility(8);
        this.gqV = AnimationUtils.loadAnimation(context, 2130968675);
        this.gqW = AnimationUtils.loadAnimation(context, 2130968683);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gpC.QI();
    }
}
