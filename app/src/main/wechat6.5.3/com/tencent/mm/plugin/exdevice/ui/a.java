package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.l;
import com.tencent.mm.protocal.c.ig;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.List;

final class a extends BaseAdapter {
    private String dFj;
    String dRA;
    c fCh;
    private boolean fCi;
    boolean fCj;
    int fCk;
    int fCl;
    ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.c> fCm;
    List<ig> fCn;
    private Context mContext;

    class a {
        final /* synthetic */ a fCo;
        TextView fCp;
        View fCq;
        ImageView fzm;

        a(a aVar) {
            this.fCo = aVar;
        }
    }

    class b {
        final /* synthetic */ a fCo;
        TextView fCp;
        View fCr;

        b(a aVar) {
            this.fCo = aVar;
        }
    }

    class c {
        View dUZ;
        final /* synthetic */ a fCo;
        TextView fCp;
        View fCq;
        ImageView fzm;

        c(a aVar) {
            this.fCo = aVar;
        }
    }

    class d {
        final /* synthetic */ a fCo;
        Button fCs;

        d(a aVar) {
            this.fCo = aVar;
        }
    }

    class e {
        ImageView eXC;
        final /* synthetic */ a fCo;
        View fCq;
        NoMeasuredTextView fCt;
        TextView fCu;

        e(a aVar) {
            this.fCo = aVar;
        }
    }

    class f {
        ImageView eXC;
        final /* synthetic */ a fCo;

        f(a aVar) {
            this.fCo = aVar;
        }
    }

    public a(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.dRA = str2;
        this.fCi = z;
        this.dFj = str;
    }

    public final int getCount() {
        if (this.fCi) {
            return (this.fCk + 5) + this.fCl;
        }
        return 2;
    }

    public final int getViewTypeCount() {
        return 8;
    }

    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        if (this.fCi) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 6;
            }
            if (i > 1 && i <= this.fCk + 1) {
                return 1;
            }
            if (i == this.fCk + 2) {
                return 2;
            }
            if (i == this.fCk + 3) {
                return 5;
            }
            if (i <= this.fCk + 3 || i > (this.fCk + 3) + this.fCl) {
                return i == (this.fCk + this.fCl) + 4 ? 7 : 5;
            } else {
                return 3;
            }
        } else if (i == 0) {
            return 0;
        } else {
            return 4;
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        d dVar;
        e eVar;
        f fVar;
        b bVar = null;
        int itemViewType = getItemViewType(i);
        c cVar;
        b bVar2;
        if (view != null) {
            switch (itemViewType) {
                case 0:
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = (f) view.getTag();
                    bVar2 = null;
                    break;
                case 1:
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = (e) view.getTag();
                    fVar = null;
                    bVar2 = null;
                    break;
                case 2:
                    cVar = null;
                    aVar = (a) view.getTag();
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    bVar2 = null;
                    break;
                case 3:
                    cVar = (c) view.getTag();
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    bVar2 = null;
                    break;
                case 4:
                    cVar = null;
                    aVar = null;
                    dVar = (d) view.getTag();
                    eVar = null;
                    fVar = null;
                    bVar2 = null;
                    break;
                case 5:
                    view.getTag();
                    bVar2 = null;
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
                case 6:
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    bVar2 = null;
                    bVar = (b) view.getTag();
                    break;
                case 7:
                    bVar2 = (b) view.getTag();
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
                default:
                    bVar2 = null;
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
            }
        }
        switch (itemViewType) {
            case 0:
                view = LayoutInflater.from(this.mContext).inflate(2130903563, viewGroup, false);
                f fVar2 = new f(this);
                fVar2.eXC = (ImageView) view.findViewById(2131756848);
                view.setTag(fVar2);
                bVar2 = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = fVar2;
                cVar = null;
                break;
            case 1:
                view = LayoutInflater.from(this.mContext).inflate(2130903562, viewGroup, false);
                e eVar2 = new e(this);
                eVar2.fCt = (NoMeasuredTextView) view.findViewById(2131756840);
                eVar2.fCu = (TextView) view.findViewById(2131756841);
                eVar2.eXC = (ImageView) view.findViewById(2131756837);
                eVar2.fCq = view.findViewById(2131756836);
                eVar2.fCt.G(this.mContext.getResources().getDimension(2131493052));
                eVar2.fCt.setTextColor(this.mContext.getResources().getColor(2131689703));
                eVar2.fCt.bCo();
                eVar2.fCt.oaP = true;
                view.setTag(eVar2);
                bVar2 = null;
                aVar = null;
                dVar = null;
                eVar = eVar2;
                fVar = null;
                cVar = null;
                break;
            case 2:
                view = LayoutInflater.from(this.mContext).inflate(2130903558, viewGroup, false);
                a aVar2 = new a(this);
                aVar2.fCp = (TextView) view.findViewById(2131756823);
                aVar2.fCq = view.findViewById(2131756819);
                aVar2.fzm = (ImageView) view.findViewById(2131756820);
                view.setTag(aVar2);
                bVar2 = null;
                aVar = aVar2;
                dVar = null;
                eVar = null;
                fVar = null;
                cVar = null;
                break;
            case 3:
                view = LayoutInflater.from(this.mContext).inflate(2130903558, viewGroup, false);
                cVar = new c(this);
                cVar.fCp = (TextView) view.findViewById(2131756823);
                cVar.fCq = view.findViewById(2131756819);
                cVar.fzm = (ImageView) view.findViewById(2131756820);
                cVar.dUZ = view.findViewById(2131756825);
                view.setTag(cVar);
                bVar2 = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            case 4:
                view = LayoutInflater.from(this.mContext).inflate(2130903561, viewGroup, false);
                d dVar2 = new d(this);
                dVar2.fCs = (Button) view.findViewById(2131756834);
                view.setTag(dVar2);
                bVar2 = null;
                aVar = null;
                dVar = dVar2;
                eVar = null;
                fVar = null;
                cVar = null;
                break;
            case 5:
                view = LayoutInflater.from(this.mContext).inflate(2130903560, viewGroup, false);
                view.setTag(new b(this));
                bVar2 = null;
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            case 6:
                view = LayoutInflater.from(this.mContext).inflate(2130903560, viewGroup, false);
                b bVar3 = new b(this);
                bVar3.fCp = (TextView) view.findViewById(2131756831);
                view.setTag(bVar3);
                bVar2 = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                b bVar4 = bVar3;
                cVar = null;
                bVar = bVar4;
                break;
            case 7:
                view = LayoutInflater.from(this.mContext).inflate(2130903560, viewGroup, false);
                bVar2 = new b(this);
                bVar2.fCr = view.findViewById(2131756829);
                view.setTag(bVar2);
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            default:
                bVar2 = null;
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
        }
        switch (itemViewType) {
            case 0:
                com.tencent.mm.pluginsdk.ui.a.b.p(fVar.eXC, this.dRA);
                break;
            case 1:
                if (i - 2 >= 0 && !be.bP(this.fCm)) {
                    com.tencent.mm.plugin.exdevice.f.b.a.c cVar2 = (com.tencent.mm.plugin.exdevice.f.b.a.c) this.fCm.get(i - 2);
                    if (cVar2 != null) {
                        int i2 = cVar2.field_step;
                        final String str = cVar2.field_username;
                        if (cVar2.field_step >= 10000) {
                            eVar.fCu.setTextColor(this.mContext.getResources().getColor(2131689702));
                        } else {
                            eVar.fCu.setTextColor(this.mContext.getResources().getColor(2131689701));
                        }
                        eVar.fCt.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.mContext, l.er(str), eVar.fCt.gl.getTextSize()));
                        eVar.fCu.setText(String.valueOf(i2));
                        com.tencent.mm.pluginsdk.ui.a.b.o(eVar.eXC, str);
                        eVar.fCq.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ a fCo;

                            public final void onClick(View view) {
                                Context a = this.fCo.mContext;
                                Intent intent = new Intent(a, ExdeviceProfileUI.class);
                                intent.putExtra("username", str);
                                a.startActivity(intent);
                            }
                        });
                        break;
                    }
                }
                break;
            case 2:
                aVar.fCp.setText(this.mContext.getResources().getText(2131232562));
                aVar.fzm.setImageResource(2131165470);
                aVar.fCq.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a fCo;

                    {
                        this.fCo = r1;
                    }

                    public final void onClick(View view) {
                        if (this.fCo.fCh != null) {
                            this.fCo.fCh.akq();
                        }
                    }
                });
                break;
            case 3:
                if ((i - this.fCk) - 4 >= 0 && !be.bP(this.fCn)) {
                    ig igVar = (ig) this.fCn.get((i - this.fCk) - 4);
                    if (igVar != null) {
                        CharSequence charSequence = igVar.title;
                        String str2 = igVar.bll;
                        final String str3 = igVar.url;
                        cVar.fCp.setText(charSequence);
                        if ((i - this.fCk) - 4 != this.fCl - 1) {
                            cVar.dUZ.setVisibility(0);
                        }
                        com.tencent.mm.plugin.exdevice.f.a.e.a(this.mContext, cVar.fzm, str2);
                        cVar.fCq.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ a fCo;

                            public final void onClick(View view) {
                                com.tencent.mm.plugin.exdevice.model.f.P(this.fCo.mContext, str3);
                            }
                        });
                        break;
                    }
                }
                break;
            case 4:
                if (!this.fCj) {
                    ak.yW();
                    if (com.tencent.mm.model.c.wH().LT(this.dRA)) {
                        dVar.fCs.setVisibility(0);
                        dVar.fCs.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ a fCo;

                            {
                                this.fCo = r1;
                            }

                            public final void onClick(View view) {
                                if (this.fCo.fCh != null) {
                                    this.fCo.fCh.akr();
                                }
                            }
                        });
                        break;
                    }
                }
                dVar.fCs.setVisibility(4);
                break;
            case 6:
                bVar.fCp.setText(this.mContext.getString(2131232566));
                break;
            case 7:
                bVar2.fCr.setVisibility(0);
                break;
        }
        return view;
    }
}
