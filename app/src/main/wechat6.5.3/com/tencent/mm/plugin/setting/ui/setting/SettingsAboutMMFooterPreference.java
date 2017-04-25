package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsAboutMMFooterPreference extends Preference {
    public SettingsAboutMMFooterPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SettingsAboutMMFooterPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        final View onCreateView = super.onCreateView(viewGroup);
        onCreateView.findViewById(2131759072).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SettingsAboutMMFooterPreference iKv;

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, onCreateView.getResources().getString(2131234246));
                intent.putExtra("rawUrl", onCreateView.getResources().getString(2131235735));
                intent.putExtra("showShare", false);
                c.b(onCreateView.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        return onCreateView;
    }

    protected final void onBindView(View view) {
        ((TextView) view.findViewById(2131759073)).setText(view.getResources().getString(2131231017, new Object[]{Integer.valueOf(2016)}));
        super.onBindView(view);
    }
}
