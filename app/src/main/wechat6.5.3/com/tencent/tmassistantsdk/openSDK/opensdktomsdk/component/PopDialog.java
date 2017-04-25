package com.tencent.tmassistantsdk.openSDK.opensdktomsdk.component;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.ActionButton;
import com.tencent.tmassistantsdk.util.Res;
import com.tencent.tmassistantsdk.util.TMLog;

public class PopDialog extends Dialog {
    public static final int DIALOG_STYLE_MUL_BTN = 2;
    public static final int DIALOG_STYLE_SINGLE_BTN = 1;
    protected static final String TAG = "PopDialog";
    protected RelativeLayout contentLayout = null;
    protected TextView contentView = null;
    public ProgressBar downloadProgressBar = null;
    public TextView downloadText = null;
    protected Context mContext = null;
    private Button negativeBtn = null;
    protected Button positiveBtn = null;
    protected FrameLayout positiveLayout = null;
    public Res rTool = null;
    protected int style = 0;
    protected TextView titleView = null;

    public PopDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    public PopDialog(Context context, int i) {
        super(context, i);
        this.mContext = context;
    }

    public PopDialog(Context context, int i, int i2) {
        super(context, i);
        this.mContext = context;
        this.style = i2;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rTool = new Res(this.mContext);
        super.setContentView(this.rTool.layout("com_tencent_tmassistant_sdk_white_list_dlg"));
        super.getWindow().setLayout(px(662), px(662));
        setCancelable(false);
        this.titleView = (TextView) findViewById(this.rTool.id("dlg_title_tv"));
        this.contentLayout = (RelativeLayout) findViewById(this.rTool.id("content"));
        this.contentView = (TextView) findViewById(this.rTool.id("dlg_body_tv"));
        this.positiveBtn = (Button) findViewById(this.rTool.id("positive_btn"));
        this.positiveLayout = (FrameLayout) findViewById(this.rTool.id("positive_btn_frame_layout"));
        this.downloadProgressBar = (ProgressBar) findViewById(this.rTool.id("download_pb"));
        this.downloadText = (TextView) findViewById(this.rTool.id("progress_txt_tv"));
        this.negativeBtn = (Button) findViewById(this.rTool.id("negtive_btn"));
        relayoutView();
    }

    private void relayoutView() {
        initHeaderView();
        switch (this.style) {
            case 1:
                initSingleDialog();
                return;
            case 2:
                initMulDialog();
                return;
            default:
                return;
        }
    }

    private void initHeaderView() {
        this.titleView.setPadding(px(30), 0, px(30), 0);
        this.contentLayout.setPadding(px(30), 0, px(30), px(30));
        this.contentView.setPadding(0, px(30), 0, px(30));
    }

    private void initSingleDialog() {
        this.positiveLayout.setVisibility(8);
        this.negativeBtn.setHeight(px(78));
        this.negativeBtn.setText(this.mContext.getString(this.rTool.string("white_list_submit")));
    }

    private void initMulDialog() {
        this.negativeBtn.setHeight(px(78));
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.negativeBtn.getLayoutParams();
        marginLayoutParams.setMargins(0, 0, px(30), 0);
        this.negativeBtn.setLayoutParams(marginLayoutParams);
        this.positiveBtn.setHeight(px(78));
        this.positiveBtn.setTextSize((float) px(30));
        this.downloadProgressBar.setMinimumHeight(px(78));
        this.downloadText.setHeight(px(78));
    }

    public void setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.titleView.setText(str);
        }
    }

    public void setContent(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.contentView.setText(str);
        }
    }

    public void setPositiveBtnTag(ActionButton actionButton) {
        if (actionButton != null) {
            this.positiveBtn.setTag(actionButton);
        }
    }

    public void setPositiveBtnClickListener(OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.positiveBtn.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtnText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.downloadText.setText(str);
        }
    }

    public void setPositiveBtnBgResource(int i) {
        if (i != 0) {
            this.positiveBtn.setBackgroundResource(i);
        }
    }

    public void setPositiveBtnEnable(boolean z) {
        if (this.positiveBtn != null) {
            this.positiveBtn.setEnabled(z);
        }
    }

    public void setNegativeBtnText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.negativeBtn.setText(str);
        }
    }

    public void setNegativeBtnClickListener(OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.negativeBtn.setOnClickListener(onClickListener);
        }
    }

    public int getScreenWidth() {
        if (this.mContext != null) {
            return this.mContext.getResources().getDisplayMetrics().widthPixels;
        }
        return 0;
    }

    public int getScreenHeight() {
        if (this.mContext != null) {
            return this.mContext.getResources().getDisplayMetrics().heightPixels;
        }
        return 0;
    }

    private int px(int i) {
        int screenHeight = getScreenHeight();
        int screenWidth = getScreenWidth();
        TMLog.i(TAG, " width = " + screenWidth + "  height = " + screenHeight);
        if (screenHeight <= screenWidth) {
            screenHeight = screenWidth;
        }
        screenHeight = (int) (((((float) screenHeight) + 0.0f) * ((float) i)) / 1280.0f);
        TMLog.i(TAG, "rtn" + i + ":" + screenHeight);
        return screenHeight;
    }
}
