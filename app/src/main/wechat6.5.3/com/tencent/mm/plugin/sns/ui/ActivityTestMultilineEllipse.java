package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class ActivityTestMultilineEllipse extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        addContentView(linearLayout, new LayoutParams(-1, -1));
        View scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new LayoutParams(-1, -1));
        linearLayout.addView(scrollView);
        linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        scrollView.addView(linearLayout);
        scrollView = new QTextView(this);
        scrollView.setLayoutParams(new LayoutParams(-1, -2));
        scrollView.jIY = "...";
        scrollView.jIZ = " Read More!";
        scrollView.setText("This is some short text. It won't need to be ellipsized.");
        scrollView.gAa = 3;
        scrollView.setPadding(10, 10, 10, 10);
        scrollView.setBackgroundColor(-1786127);
        linearLayout.addView(scrollView);
        scrollView = new QTextView(this);
        scrollView.setLayoutParams(new LayoutParams(-1, -2));
        scrollView.jIY = "...";
        scrollView.jIZ = " Read More!";
        scrollView.gAa = 3;
        scrollView.setText("This is some longer text. It should wrap and then eventually be ellipsized once it gets way too long for the horizontal width of the current application screen. We should be fixed to max [N] lines height.");
        scrollView.setPadding(10, 10, 10, 10);
        scrollView.setBackgroundColor(-204878);
        scrollView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ActivityTestMultilineEllipse jCw;

            public final void onClick(View view) {
                if (scrollView.jJd) {
                    QTextView qTextView = scrollView;
                    qTextView.jJd = false;
                    qTextView.requestLayout();
                    qTextView.invalidate();
                    return;
                }
                qTextView = scrollView;
                qTextView.jJd = true;
                qTextView.requestLayout();
                qTextView.invalidate();
            }
        });
        linearLayout.addView(scrollView);
    }
}
