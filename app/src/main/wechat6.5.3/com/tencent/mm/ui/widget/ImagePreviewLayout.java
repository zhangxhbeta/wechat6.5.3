package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImagePreviewLayout extends LinearLayout {
    private final Context context;
    private TableLayout jIL;
    private final Map<Integer, View> jIM = new HashMap();
    private final Map<Integer, TableRow> jIN = new HashMap();
    private final int jIO = 4;
    private boolean jIR = true;
    private List<String> pbD = new ArrayList();
    private int pbE = 9;

    public ImagePreviewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.jIL = (TableLayout) LayoutInflater.from(this.context).inflate(2130903800, this, true).findViewById(2131755329);
    }
}
