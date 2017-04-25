package com.tencent.mm.plugin.emoji.ui.smiley;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.tencent.mm.bf.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.k;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;

public class SmileyGrid extends GridView {
    public static int fkD = 1;
    public ListAdapter EK;
    int cVh = ChatFooterPanel.lGp;
    private OnItemClickListener ezi = new OnItemClickListener(this) {
        final /* synthetic */ SmileyGrid fkK;

        {
            this.fkK = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (this.fkK.fkt) {
                case 20:
                    if (i == this.fkK.EK.getCount() - 1) {
                        if (this.fkK.fkI != null) {
                            this.fkK.fkI.Tm();
                            return;
                        }
                        return;
                    } else if ((this.fkK.fkG * (this.fkK.fkF - 1)) + i < this.fkK.fkE) {
                        int i2 = (this.fkK.fkG * (this.fkK.fkF - 1)) + i;
                        if (this.fkK.fkI != null) {
                            String hI;
                            if (this.fkK.fkJ) {
                                hI = e.buQ().hI(i2);
                            } else {
                                hI = e.buQ().getText(i2);
                            }
                            this.fkK.fkI.append(hI);
                            g.iuh.h(13470, new Object[]{hI.replaceAll(",", " "), Integer.valueOf(this.fkK.cVh)});
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 23:
                case 25:
                    if (this.fkK.fkt == 25 && i == 0 && this.fkK.fkG == 0) {
                        SmileyGrid.b(this.fkK);
                        return;
                    }
                    SmileyGrid.a(this.fkK, (c) this.fkK.EK.getItem(i));
                    return;
                default:
                    return;
            }
        }
    };
    private int fkE;
    public int fkF = 0;
    public int fkG;
    k fkH;
    a fkI;
    private boolean fkJ;
    int fkt = 20;
    private int fku = 0;

    static /* synthetic */ void a(SmileyGrid smileyGrid, c cVar) {
        if (smileyGrid.fkH == null || cVar == null) {
            v.e("MicroMsg.emoji.SmileyGrid", "jacks npe dealCustomEmojiClick");
        } else if (fkD != 2) {
            if (!smileyGrid.fkH.azH()) {
                com.tencent.mm.ui.base.g.a(smileyGrid.getContext(), 2131231849, 0, new OnClickListener(smileyGrid) {
                    final /* synthetic */ SmileyGrid fkK;

                    {
                        this.fkK = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (cVar == null) {
            } else {
                if (cVar.field_type != c.nwW && cVar.field_type != c.nwX) {
                    v.i("MicroMsg.emoji.SmileyGrid", "cpan send dealcustom emoji click emoji:%s", new Object[]{cVar.EB()});
                    c c = j.a.bmr().c(cVar);
                    if (c != null) {
                        smileyGrid.fkH.n(c);
                        v.d("MicroMsg.emoji.SmileyGrid", "onSendCustomEmoji emoji md5 is [%s]", new Object[]{c.EB()});
                        return;
                    }
                    v.w("MicroMsg.emoji.SmileyGrid", "onSendCustomEmoji error, emoji is null");
                } else if (smileyGrid.fkH.azG()) {
                    smileyGrid.fkH.o(cVar);
                    v.d("MicroMsg.emoji.SmileyGrid", "onSendAppMsgCustomEmoji emoji md5 is [%s]", new Object[]{cVar.EB()});
                } else {
                    Toast.makeText(smileyGrid.getContext(), smileyGrid.getContext().getString(2131231848), 0).show();
                }
            }
        } else if (cVar.field_catalog == com.tencent.mm.storage.a.a.nwK) {
            com.tencent.mm.ui.base.g.f(smileyGrid.getContext(), 2131231769, 2131231769).show();
        }
    }

    static /* synthetic */ void b(SmileyGrid smileyGrid) {
        g.iuh.h(11594, new Object[]{Integer.valueOf(1)});
        String value = com.tencent.mm.h.j.sU().getValue("ShowDesignerEmoji");
        v.i("MicroMsg.emoji.SmileyGrid", "get dynamic Designer_Emoji_Store_Show config value:%s", new Object[]{value});
        com.tencent.mm.ay.c.b(smileyGrid.getContext(), "emoji", ".ui.EmojiCustomUI", new Intent());
    }

    public SmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @TargetApi(8)
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void ahj() {
        setOnItemClickListener(this.ezi);
    }

    public final void f(int i, int i2, int i3, int i4, int i5) {
        v.v("MicroMsg.emoji.SmileyGrid", "type:" + i + " itemsPerPage:" + i4 + " totalPage:" + i5 + " curPage:" + this.fkG);
        setOnItemClickListener(this.ezi);
        this.fkt = i;
        this.fkG = i2;
        this.fkE = i3;
        this.fkF = i4;
        this.fku = i5;
    }

    public void release() {
        this.fkI = null;
        this.fkH = null;
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.EK = listAdapter;
    }
}
