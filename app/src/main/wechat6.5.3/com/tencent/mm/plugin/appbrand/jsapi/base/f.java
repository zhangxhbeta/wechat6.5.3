package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {

    private static class d implements OnTouchListener {
        private static volatile View dJE;
        private Map<Integer, g> dJF = new HashMap();
        private boolean dJG;
        private boolean dJH;
        private g dJI;
        private Runnable dJJ;
        private com.tencent.mm.model.o.b dJK;
        private int dJL;
        private float dJM;
        private MotionEvent dJN;
        private MotionEvent dJO;
        private g dJP;
        private g dJQ;
        private String dzg;
        private View mView;

        d(h hVar, com.tencent.mm.model.o.b bVar) {
            this.dJK = bVar;
            this.dzg = hVar.dzg;
            this.dJL = hVar.hashCode();
            this.dJM = (float) ViewConfiguration.get(hVar.getContext()).getScaledTouchSlop();
            this.dJP = new g();
            this.dJQ = new g();
            this.dJJ = new Runnable(this) {
                final /* synthetic */ d dJR;

                {
                    this.dJR = r1;
                }

                public final void run() {
                    if (this.dJR.dJG) {
                        g bx = d.bx(this.dJR.mView);
                        if (Math.abs(this.dJR.dJI.x - bx.x) > 1.0f || Math.abs(this.dJR.dJI.y - bx.y) > 1.0f) {
                            v.v("MicroMsg.ViewMotionHelper", "check long press timeout, but view has moved.");
                            return;
                        } else if (this.dJR.dJF.size() != 1) {
                            v.v("MicroMsg.ViewMotionHelper", "check long press timeout, but more then one point.");
                            return;
                        } else if (Math.abs(this.dJR.dJP.x - this.dJR.dJQ.x) > this.dJR.dJM || Math.abs(this.dJR.dJP.y - this.dJR.dJQ.y) > this.dJR.dJM) {
                            v.v("MicroMsg.ViewMotionHelper", "check long press timeout, but point has moved(%s, %s, %s, %s).", new Object[]{Float.valueOf(this.dJR.dJP.x), Float.valueOf(this.dJR.dJQ.x), Float.valueOf(this.dJR.dJP.y), Float.valueOf(this.dJR.dJQ.y)});
                            return;
                        } else {
                            v.v("MicroMsg.ViewMotionHelper", "check long press timeout, publish event(%s, %s, %s, %s).", new Object[]{Float.valueOf(this.dJR.dJP.x), Float.valueOf(this.dJR.dJQ.x), Float.valueOf(this.dJR.dJP.y), Float.valueOf(this.dJR.dJQ.y)});
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("data", this.dJR.dJK.getString("data", ""));
                                jSONObject.put("touch", this.dJR.dJP.nT());
                            } catch (JSONException e) {
                            }
                            if (!this.dJR.dJK.getBoolean("disableScroll", false)) {
                                this.dJR.dJN = MotionEvent.obtainNoHistory(this.dJR.dJO);
                                this.dJR.dJN.setAction(0);
                                this.dJR.dJK.o("fakeDownEvent", true);
                                this.dJR.mView.getParent().requestDisallowInterceptTouchEvent(true);
                                this.dJR.mView.setDuplicateParentStateEnabled(false);
                                ((ViewGroup) this.dJR.mView.getParent()).dispatchTouchEvent(this.dJR.dJN);
                            }
                            this.dJR.a(new a(), jSONObject.toString());
                            return;
                        }
                    }
                    v.v("MicroMsg.ViewMotionHelper", "check long press timeout, but pressed is false or pointer is null.");
                }
            };
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouch(android.view.View r19, android.view.MotionEvent r20) {
            /*
            r18 = this;
            r2 = dJE;
            if (r2 == 0) goto L_0x0010;
        L_0x0004:
            r2 = dJE;
            r0 = r19;
            r2 = r2.equals(r0);
            if (r2 != 0) goto L_0x0010;
        L_0x000e:
            r6 = 0;
        L_0x000f:
            return r6;
        L_0x0010:
            r0 = r20;
            r1 = r18;
            r1.dJO = r0;
            r9 = r20.getActionMasked();
            r2 = r20.getActionIndex();
            r20.getPointerCount();
            r0 = r20;
            r10 = r0.getPointerId(r2);
            r0 = r20;
            r11 = r0.getX(r2);
            r0 = r20;
            r12 = r0.getY(r2);
            r5 = "";
            r4 = 0;
            r3 = 0;
            r2 = 0;
            r7 = 0;
            r0 = r18;
            r6 = r0.dJK;
            if (r6 == 0) goto L_0x0093;
        L_0x0040:
            if (r9 == 0) goto L_0x0051;
        L_0x0042:
            r0 = r18;
            r2 = r0.dJK;
            r3 = "isTouching";
            r2 = r2.fA(r3);
            if (r2 != 0) goto L_0x0051;
        L_0x004f:
            r6 = 0;
            goto L_0x000f;
        L_0x0051:
            r0 = r18;
            r2 = r0.dJK;
            r3 = "data";
            r4 = "";
            r5 = r2.getString(r3, r4);
            r0 = r18;
            r2 = r0.dJK;
            r3 = "disableScroll";
            r4 = 0;
            r4 = r2.getBoolean(r3, r4);
            r0 = r18;
            r2 = r0.dJK;
            r3 = "fakeDownEvent";
            r6 = 0;
            r3 = r2.getBoolean(r3, r6);
            r0 = r18;
            r2 = r0.dJK;
            r6 = "onLongClick";
            r8 = 0;
            r2 = r2.getBoolean(r6, r8);
            r0 = r18;
            r6 = r0.dJK;
            r8 = "enableLongClick";
            r13 = 0;
            r6 = r6.getBoolean(r8, r13);
            r0 = r18;
            r0.dJH = r6;
        L_0x0093:
            r0 = r18;
            r6 = r0.dJQ;
            r6.a(r10, r11, r12);
            r6 = r4 | r2;
            switch(r9) {
                case 0: goto L_0x00a1;
                case 1: goto L_0x029b;
                case 2: goto L_0x01a0;
                case 3: goto L_0x0309;
                case 4: goto L_0x009f;
                case 5: goto L_0x03a8;
                case 6: goto L_0x02dd;
                default: goto L_0x009f;
            };
        L_0x009f:
            goto L_0x000f;
        L_0x00a1:
            r0 = r18;
            r8 = r0.dJN;
            if (r8 == 0) goto L_0x00d2;
        L_0x00a7:
            r14 = r20.getDownTime();
            r0 = r18;
            r8 = r0.dJN;
            r16 = r8.getDownTime();
            r8 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
            if (r8 == 0) goto L_0x00d2;
        L_0x00b7:
            r3 = 0;
            r0 = r18;
            r8 = r0.dJK;
            if (r8 == 0) goto L_0x00c9;
        L_0x00be:
            r0 = r18;
            r8 = r0.dJK;
            r13 = "fakeDownEvent";
            r14 = 0;
            r8.o(r13, r14);
        L_0x00c9:
            r8 = "MicroMsg.ViewMotionHelper";
            r13 = "try to handle fake event failed";
            com.tencent.mm.sdk.platformtools.v.v(r8, r13);
        L_0x00d2:
            r8 = r3;
            if (r4 != 0) goto L_0x00d7;
        L_0x00d5:
            if (r8 == 0) goto L_0x0278;
        L_0x00d7:
            r3 = r19.getParent();
            r4 = 1;
            r3.requestDisallowInterceptTouchEvent(r4);
            r3 = 0;
            r0 = r19;
            r0.setDuplicateParentStateEnabled(r3);
            r3 = "MicroMsg.ViewMotionHelper";
            r4 = "onLongClick fake down event.";
            com.tencent.mm.sdk.platformtools.v.i(r3, r4);
        L_0x00ee:
            if (r8 == 0) goto L_0x0280;
        L_0x00f0:
            r3 = 1;
            r2 = 1;
            r0 = r18;
            r4 = r0.dJK;
            if (r4 == 0) goto L_0x010e;
        L_0x00f8:
            r0 = r18;
            r4 = r0.dJK;
            r6 = "fakeDownEvent";
            r13 = 0;
            r4.o(r6, r13);
            r0 = r18;
            r4 = r0.dJK;
            r6 = "onLongClick";
            r13 = 1;
            r4.o(r6, r13);
        L_0x010e:
            r0 = r18;
            r4 = r0.dJK;
            if (r4 == 0) goto L_0x011f;
        L_0x0114:
            r0 = r18;
            r4 = r0.dJK;
            r6 = "isTouching";
            r13 = 1;
            r4.o(r6, r13);
        L_0x011f:
            r0 = r18;
            r4 = r0.dJH;
            if (r4 == 0) goto L_0x0143;
        L_0x0125:
            if (r3 != 0) goto L_0x0143;
        L_0x0127:
            r0 = r18;
            r4 = r0.dJF;
            r6 = java.lang.Integer.valueOf(r10);
            r4 = r4.containsKey(r6);
            if (r4 != 0) goto L_0x0143;
        L_0x0135:
            r0 = r18;
            r4 = r0.dJJ;
            r6 = android.view.ViewConfiguration.getLongPressTimeout();
            r14 = (long) r6;
            r0 = r19;
            r0.postDelayed(r4, r14);
        L_0x0143:
            r6 = r2;
            r4 = r8;
        L_0x0145:
            r2 = 0;
            r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1));
            if (r2 < 0) goto L_0x0295;
        L_0x014a:
            r2 = 0;
            r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
            if (r2 < 0) goto L_0x0295;
        L_0x014f:
            r2 = r19.getWidth();
            r2 = (float) r2;
            r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1));
            if (r2 > 0) goto L_0x0295;
        L_0x0158:
            r2 = r19.getHeight();
            r2 = (float) r2;
            r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
            if (r2 > 0) goto L_0x0295;
        L_0x0161:
            r2 = 1;
        L_0x0162:
            if (r2 == 0) goto L_0x000f;
        L_0x0164:
            r8 = new com.tencent.mm.plugin.appbrand.jsapi.base.f$g;
            r8.<init>(r10, r11, r12);
            if (r9 != 0) goto L_0x0298;
        L_0x016b:
            if (r3 != 0) goto L_0x0298;
        L_0x016d:
            r2 = 1;
        L_0x016e:
            r0 = r18;
            r1 = r19;
            r0.f(r1, r2);
            r0 = r18;
            r2 = r0.dJF;
            r3 = java.lang.Integer.valueOf(r10);
            r2 = r2.containsKey(r3);
            if (r2 == 0) goto L_0x03a5;
        L_0x0183:
            r2 = 1;
        L_0x0184:
            r0 = r18;
            r3 = r0.dJF;
            r7 = java.lang.Integer.valueOf(r10);
            r3.put(r7, r8);
            if (r4 != 0) goto L_0x000f;
        L_0x0191:
            if (r2 != 0) goto L_0x000f;
        L_0x0193:
            r2 = new com.tencent.mm.plugin.appbrand.jsapi.base.f$c;
            r3 = 0;
            r2.<init>();
            r0 = r18;
            r0.a(r8, r2, r5);
            goto L_0x000f;
        L_0x01a0:
            r2 = 0;
            r3 = r2;
        L_0x01a2:
            r2 = r20.getPointerCount();
            if (r3 >= r2) goto L_0x025a;
        L_0x01a8:
            r0 = r20;
            r4 = r0.getX(r3);
            r0 = r20;
            r7 = r0.getY(r3);
            r0 = r20;
            r2 = r0.getPointerId(r3);
            r0 = r18;
            r8 = r0.dJF;
            r2 = java.lang.Integer.valueOf(r2);
            r2 = r8.get(r2);
            r2 = (com.tencent.mm.plugin.appbrand.jsapi.base.f.g) r2;
            if (r2 == 0) goto L_0x0255;
        L_0x01ca:
            r8 = r2.x;
            r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
            if (r4 != 0) goto L_0x01d6;
        L_0x01d0:
            r2 = r2.y;
            r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1));
            if (r2 == 0) goto L_0x0255;
        L_0x01d6:
            r2 = 1;
        L_0x01d7:
            if (r2 == 0) goto L_0x000f;
        L_0x01d9:
            r0 = r18;
            r2 = r0.dJF;
            r2 = r2.size();
            r3 = 1;
            if (r2 != r3) goto L_0x0224;
        L_0x01e4:
            r0 = r18;
            r2 = r0.dJG;
            if (r2 == 0) goto L_0x0224;
        L_0x01ea:
            r0 = r18;
            r2 = r0.dJP;
            r2 = r2.x;
            r0 = r18;
            r3 = r0.dJQ;
            r3 = r3.x;
            r2 = r2 - r3;
            r2 = java.lang.Math.abs(r2);
            r0 = r18;
            r3 = r0.dJM;
            r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
            if (r2 > 0) goto L_0x021c;
        L_0x0203:
            r0 = r18;
            r2 = r0.dJP;
            r2 = r2.y;
            r0 = r18;
            r3 = r0.dJQ;
            r3 = r3.y;
            r2 = r2 - r3;
            r2 = java.lang.Math.abs(r2);
            r0 = r18;
            r3 = r0.dJM;
            r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
            if (r2 <= 0) goto L_0x0224;
        L_0x021c:
            r2 = 0;
            r0 = r18;
            r1 = r19;
            r0.f(r1, r2);
        L_0x0224:
            r3 = new org.json.JSONObject;
            r3.<init>();
            r4 = new org.json.JSONArray;
            r4.<init>();
            r2 = "data";
            r3.put(r2, r5);	 Catch:{ JSONException -> 0x03a2 }
            r2 = "touches";
            r3.put(r2, r4);	 Catch:{ JSONException -> 0x03a2 }
        L_0x023a:
            r0 = r18;
            r1 = r20;
            r5 = r0.o(r1);
            r2 = r5.length;
            if (r2 <= 0) goto L_0x025d;
        L_0x0245:
            r2 = 0;
        L_0x0246:
            r7 = r5.length;
            if (r2 >= r7) goto L_0x025d;
        L_0x0249:
            r7 = r5[r2];
            r7 = r7.nT();
            r4.put(r7);
            r2 = r2 + 1;
            goto L_0x0246;
        L_0x0255:
            r2 = r3 + 1;
            r3 = r2;
            goto L_0x01a2;
        L_0x025a:
            r2 = 0;
            goto L_0x01d7;
        L_0x025d:
            r0 = r18;
            r2 = r0.dJF;
            r2 = r2.size();
            if (r2 == 0) goto L_0x000f;
        L_0x0267:
            r2 = new com.tencent.mm.plugin.appbrand.jsapi.base.f$e;
            r4 = 0;
            r2.<init>();
            r3 = r3.toString();
            r0 = r18;
            r0.a(r2, r3);
            goto L_0x000f;
        L_0x0278:
            r3 = 1;
            r0 = r19;
            r0.setDuplicateParentStateEnabled(r3);
            goto L_0x00ee;
        L_0x0280:
            dJE = r19;
            r3 = bx(r19);
            r0 = r18;
            r0.dJI = r3;
            r0 = r18;
            r3 = r0.dJP;
            r3.a(r10, r11, r12);
            r3 = r2;
            r2 = r6;
            goto L_0x010e;
        L_0x0295:
            r2 = 0;
            goto L_0x0162;
        L_0x0298:
            r2 = 0;
            goto L_0x016e;
        L_0x029b:
            if (r4 != 0) goto L_0x029f;
        L_0x029d:
            if (r2 == 0) goto L_0x0302;
        L_0x029f:
            r2 = r19.getParent();
            r3 = 0;
            r2.requestDisallowInterceptTouchEvent(r3);
        L_0x02a7:
            r2 = 0;
            dJE = r2;
            r0 = r18;
            r2 = r0.dJK;
            if (r2 == 0) goto L_0x02dd;
        L_0x02b0:
            r0 = r18;
            r2 = r0.dJK;
            r3 = "isTouching";
            r7 = 0;
            r2.o(r3, r7);
            r0 = r18;
            r2 = r0.dJK;
            r3 = "disableScroll-nextState";
            r2 = r2.containsKey(r3);
            if (r2 == 0) goto L_0x02dd;
        L_0x02c8:
            r0 = r18;
            r2 = r0.dJK;
            r3 = "disableScroll";
            r0 = r18;
            r7 = r0.dJK;
            r8 = "disableScroll-nextState";
            r4 = r7.getBoolean(r8, r4);
            r2.o(r3, r4);
        L_0x02dd:
            r0 = r18;
            r2 = r0.dJF;
            r3 = java.lang.Integer.valueOf(r10);
            r2 = r2.remove(r3);
            r2 = (com.tencent.mm.plugin.appbrand.jsapi.base.f.g) r2;
            if (r2 == 0) goto L_0x000f;
        L_0x02ed:
            r3 = 0;
            r0 = r18;
            r1 = r19;
            r0.f(r1, r3);
            r3 = new com.tencent.mm.plugin.appbrand.jsapi.base.f$f;
            r4 = 0;
            r3.<init>();
            r0 = r18;
            r0.a(r2, r3, r5);
            goto L_0x000f;
        L_0x0302:
            r2 = 0;
            r0 = r19;
            r0.setDuplicateParentStateEnabled(r2);
            goto L_0x02a7;
        L_0x0309:
            r3 = 0;
            dJE = r3;
            r3 = 0;
            r0 = r18;
            r1 = r19;
            r0.f(r1, r3);
            if (r4 != 0) goto L_0x0318;
        L_0x0316:
            if (r2 == 0) goto L_0x0381;
        L_0x0318:
            r2 = r19.getParent();
            r3 = 0;
            r2.requestDisallowInterceptTouchEvent(r3);
        L_0x0320:
            r0 = r18;
            r2 = r0.dJK;
            if (r2 == 0) goto L_0x0353;
        L_0x0326:
            r0 = r18;
            r2 = r0.dJK;
            r3 = "isTouching";
            r7 = 0;
            r2.o(r3, r7);
            r0 = r18;
            r2 = r0.dJK;
            r3 = "disableScroll-nextState";
            r2 = r2.containsKey(r3);
            if (r2 == 0) goto L_0x0353;
        L_0x033e:
            r0 = r18;
            r2 = r0.dJK;
            r3 = "disableScroll";
            r0 = r18;
            r7 = r0.dJK;
            r8 = "disableScroll-nextState";
            r4 = r7.getBoolean(r8, r4);
            r2.o(r3, r4);
        L_0x0353:
            r3 = new org.json.JSONObject;
            r3.<init>();
            r4 = new org.json.JSONArray;
            r4.<init>();
            r2 = "data";
            r3.put(r2, r5);	 Catch:{ JSONException -> 0x03a0 }
            r2 = "touches";
            r3.put(r2, r4);	 Catch:{ JSONException -> 0x03a0 }
        L_0x0369:
            r0 = r18;
            r1 = r20;
            r5 = r0.o(r1);
            r2 = 0;
        L_0x0372:
            r7 = r5.length;
            if (r2 >= r7) goto L_0x0388;
        L_0x0375:
            r7 = r5[r2];
            r7 = r7.nT();
            r4.put(r7);
            r2 = r2 + 1;
            goto L_0x0372;
        L_0x0381:
            r2 = 0;
            r0 = r19;
            r0.setDuplicateParentStateEnabled(r2);
            goto L_0x0320;
        L_0x0388:
            r2 = new com.tencent.mm.plugin.appbrand.jsapi.base.f$b;
            r4 = 0;
            r2.<init>();
            r3 = r3.toString();
            r0 = r18;
            r0.a(r2, r3);
            r0 = r18;
            r2 = r0.dJF;
            r2.clear();
            goto L_0x000f;
        L_0x03a0:
            r2 = move-exception;
            goto L_0x0369;
        L_0x03a2:
            r2 = move-exception;
            goto L_0x023a;
        L_0x03a5:
            r2 = r7;
            goto L_0x0184;
        L_0x03a8:
            r4 = r3;
            r3 = r2;
            goto L_0x0145;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.base.f.d.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }

        private void f(View view, boolean z) {
            this.mView = view;
            this.dJG = z;
            if (!z) {
                this.dJK.o("fakeDownEvent", false);
                this.dJK.o("onLongClick", false);
                this.mView.removeCallbacks(this.dJJ);
                this.dJP.a(-1, 0.0f, 0.0f);
                this.dJN = null;
            }
        }

        private void a(g gVar, com.tencent.mm.plugin.appbrand.jsapi.e eVar, String str) {
            if (gVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("data", str);
                    jSONObject.put("touch", gVar.nT());
                } catch (JSONException e) {
                }
                a(eVar, jSONObject.toString());
            }
        }

        private void a(com.tencent.mm.plugin.appbrand.jsapi.e eVar, String str) {
            com.tencent.mm.plugin.appbrand.jsapi.e aa = eVar.aa(this.dzg, this.dJL);
            aa.mData = str;
            aa.PX();
        }

        static g bx(View view) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            return new g(0, (float) iArr[0], (float) iArr[1]);
        }

        private g[] o(MotionEvent motionEvent) {
            int i = 0;
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
                g gVar = (g) this.dJF.get(Integer.valueOf(motionEvent.getPointerId(i2)));
                if (gVar != null) {
                    gVar.x = motionEvent.getX(i2);
                    gVar.y = motionEvent.getY(i2);
                    arrayList.add(gVar);
                }
            }
            g[] gVarArr = new g[arrayList.size()];
            while (i < arrayList.size()) {
                gVarArr[i] = (g) arrayList.get(i);
                i++;
            }
            return gVarArr;
        }
    }

    private static class g {
        int id;
        float x;
        float y;

        public g(int i, float f, float f2) {
            this.id = i;
            this.x = f;
            this.y = f2;
        }

        public final void a(int i, float f, float f2) {
            this.id = i;
            this.x = f;
            this.y = f2;
        }

        public final JSONObject nT() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.id);
                jSONObject.put("x", (double) com.tencent.mm.plugin.appbrand.k.d.J(this.x));
                jSONObject.put("y", (double) com.tencent.mm.plugin.appbrand.k.d.J(this.y));
            } catch (JSONException e) {
            }
            return jSONObject;
        }

        public final String toString() {
            return nT().toString();
        }
    }

    private static class a extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onLongPress";

        private a() {
        }
    }

    private static class b extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchCancel";

        private b() {
        }
    }

    private static class c extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchStart";

        private c() {
        }
    }

    private static class e extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchMove";

        private e() {
        }
    }

    private static class f extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTouchEnd";

        private f() {
        }
    }
}
