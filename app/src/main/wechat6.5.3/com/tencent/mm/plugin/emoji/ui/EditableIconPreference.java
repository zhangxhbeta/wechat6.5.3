package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.ui.base.preference.Preference;

public class EditableIconPreference extends Preference {
    private Context context;
    private Drawable drawable;
    private int fgA;
    private int fgB;
    private int fgC;
    private ImageView fgD;
    private ViewGroup fgE;
    private View fgF;
    LayoutParams fgG;
    private boolean fgH;
    private Button fgI;
    private String fgv;
    private int fgw;
    private int fgx;
    private Bitmap fgy;
    private int fgz;
    private int height;
    private int mMode;

    public EditableIconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditableIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fgv = "";
        this.fgw = -1;
        this.fgx = 8;
        this.fgy = null;
        this.fgz = -1;
        this.fgA = 8;
        this.fgB = 0;
        this.fgC = 8;
        this.fgD = null;
        this.fgE = null;
        this.fgF = null;
        this.height = -1;
        this.mMode = 0;
        this.fgH = false;
        this.context = context;
        setLayoutResource(2130903996);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, 2130904016, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        this.fgH = true;
        this.fgI = (Button) view.findViewById(2131758275);
        switch (this.mMode) {
            case 1:
                setWidgetLayoutResource(2130904036);
                if (this.fgI != null) {
                    this.fgI.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ EditableIconPreference fgJ;

                        {
                            this.fgJ = r1;
                        }

                        public final void onClick(View view) {
                        }
                    });
                    break;
                }
                break;
        }
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(2131756901);
        if (imageView != null) {
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.OL != 0) {
                imageView.setImageResource(this.OL);
                imageView.setVisibility(0);
            } else {
                imageView.setImageDrawable(null);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131758240);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        TextView textView = (TextView) view.findViewById(2131758235);
        if (textView != null) {
            textView.setVisibility(this.fgx);
            textView.setText(this.fgv);
            if (this.fgw != -1) {
                textView.setBackgroundDrawable(a.a(this.context, this.fgw));
            }
        }
        if (this.fgD == null) {
            this.fgD = (ImageView) view.findViewById(2131758257);
        }
        if (this.fgE == null) {
            this.fgE = (ViewGroup) view.findViewById(2131758256);
        }
        if (this.fgF == null) {
            this.fgF = view.findViewById(2131758258);
        }
        this.fgF.setVisibility(this.fgC);
        if (this.fgy != null) {
            this.fgD.setImageBitmap(this.fgy);
        } else if (this.fgz != -1) {
            this.fgD.setImageResource(this.fgz);
        }
        this.fgD.setVisibility(this.fgA);
        this.fgE.setVisibility(this.fgB);
        if (this.fgG != null) {
            this.fgD.setLayoutParams(this.fgG);
        }
    }
}
