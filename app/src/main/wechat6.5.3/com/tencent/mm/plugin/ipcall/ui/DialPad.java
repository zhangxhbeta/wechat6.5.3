package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.RelativeLayout;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.video.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Map;

public class DialPad extends RelativeLayout implements OnClickListener, OnLongClickListener {
    private static final String[] gIQ = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"};
    private static final String[] gIR = new String[]{"", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "", "+", ""};
    boolean gIP = false;
    Map<Integer, DialNumberButton> gIS = new HashMap();
    private Map<String, DialNumberButton> gIT = new HashMap();
    Map<Integer, View> gIU = new HashMap();
    a gIV;

    public interface a {
        void uP(String str);

        void uQ(String str);
    }

    public DialPad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(2130903464, this);
        float dimensionPixelSize = (float) getContext().getResources().getDimensionPixelSize(2131492871);
        float dimensionPixelSize2 = (float) getContext().getResources().getDimensionPixelSize(2131492873);
        float dimensionPixelSize3 = (float) getContext().getResources().getDimensionPixelSize(2131492872);
        a(2131756596, gIQ[0], gIR[0], dimensionPixelSize);
        a(2131756597, gIQ[1], gIR[1], dimensionPixelSize);
        a(2131756598, gIQ[2], gIR[2], dimensionPixelSize);
        a(2131756600, gIQ[3], gIR[3], dimensionPixelSize);
        a(2131756601, gIQ[4], gIR[4], dimensionPixelSize);
        a(2131756602, gIQ[5], gIR[5], dimensionPixelSize);
        a(2131756604, gIQ[6], gIR[6], dimensionPixelSize);
        a(2131756605, gIQ[7], gIR[7], dimensionPixelSize);
        a(2131756606, gIQ[8], gIR[8], dimensionPixelSize);
        a(2131756608, gIQ[9], gIR[9], dimensionPixelSize3);
        a(2131756609, gIQ[10], gIR[10], dimensionPixelSize);
        a(2131756610, gIQ[11], gIR[11], dimensionPixelSize2);
        this.gIU.put(Integer.valueOf(2131756590), findViewById(2131756590));
        this.gIU.put(Integer.valueOf(2131756591), findViewById(2131756591));
        this.gIU.put(Integer.valueOf(2131756592), findViewById(2131756592));
        this.gIU.put(Integer.valueOf(2131756593), findViewById(2131756593));
        this.gIU.put(Integer.valueOf(2131756594), findViewById(2131756594));
        for (View view : this.gIU.values()) {
            if (this.gIP) {
                view.setBackgroundDrawable(getResources().getDrawable(2131690065));
            } else {
                view.setBackgroundDrawable(getResources().getDrawable(2131689670));
            }
        }
        setClipToPadding(false);
        setClipChildren(false);
    }

    private void a(int i, String str, String str2, float f) {
        DialNumberButton dialNumberButton = (DialNumberButton) findViewById(i);
        if (!be.kS(str) && str.length() == 1) {
            dialNumberButton.gIN.setText(str);
        }
        if (!be.kS(str2) || "1".equals(str)) {
            dialNumberButton.gIO.setText(str2);
            dialNumberButton.gIO.setVisibility(0);
        } else {
            dialNumberButton.gIO.setVisibility(8);
        }
        dialNumberButton.gIN.setTextSize(0, f);
        dialNumberButton.setOnClickListener(this);
        dialNumberButton.setOnLongClickListener(this);
        dialNumberButton.dL(this.gIP);
        this.gIS.put(Integer.valueOf(i), dialNumberButton);
        this.gIT.put(str, dialNumberButton);
    }

    public final void auZ() {
        this.gIP = true;
        for (DialNumberButton dL : this.gIS.values()) {
            dL.dL(true);
        }
        for (View view : this.gIU.values()) {
            if (this.gIP) {
                view.setBackgroundDrawable(getResources().getDrawable(2131690065));
            } else {
                view.setBackgroundDrawable(getResources().getDrawable(2131689670));
            }
        }
    }

    public void onClick(View view) {
        if (this.gIS.containsKey(Integer.valueOf(view.getId()))) {
            DialNumberButton dialNumberButton = (DialNumberButton) this.gIS.get(Integer.valueOf(view.getId()));
            String auX = dialNumberButton.auX();
            String auY = dialNumberButton.auY();
            d auw = i.auw();
            int CQ = d.CQ(auX);
            if (CQ != -1 && d.bdL()) {
                AudioManager audioManager = ak.yX().cba;
                if (audioManager == null) {
                    audioManager = (AudioManager) d.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                }
                int ringerMode = audioManager.getRingerMode();
                if (!(ringerMode == 0 || ringerMode == 1)) {
                    synchronized (auw.kAB) {
                        if (auw.kAC == null) {
                        } else {
                            auw.kAC.startTone(CQ, 250);
                        }
                    }
                }
            }
            if (this.gIV != null) {
                String str;
                a aVar = this.gIV;
                if (be.kS(auX)) {
                    str = auY;
                } else {
                    str = auX;
                }
                aVar.uP(str);
            }
        }
    }

    public boolean onLongClick(View view) {
        if (!this.gIS.containsKey(Integer.valueOf(view.getId()))) {
            return false;
        }
        DialNumberButton dialNumberButton = (DialNumberButton) this.gIS.get(Integer.valueOf(view.getId()));
        String auX = dialNumberButton.auX();
        String auY = dialNumberButton.auY();
        if (this.gIV != null) {
            a aVar = this.gIV;
            if (!be.kS(auX)) {
                auY = auX;
            }
            aVar.uQ(auY);
        }
        return true;
    }

    public void onViewAdded(View view) {
        v.i("MicroMsg.DialPad", "onViewAdded, class: %s", new Object[]{view.getClass().getSimpleName()});
    }

    public void onViewRemoved(View view) {
        v.i("MicroMsg.DialPad", "onViewRemoved, class: %s", new Object[]{view.getClass().getSimpleName()});
    }
}
