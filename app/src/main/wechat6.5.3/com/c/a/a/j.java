package com.c.a.a;

import java.lang.reflect.Array;

final class j {
    private double[] aIh = new double[4];
    final b aIi = new b();
    private final b aIj = new b();

    protected static class a {
        double aIk;
        double aIl;
        double aIm;
        double[] aIn = new double[2];
        double aIo;
        double aIp;
        int aIq;
        double aIr;
        double aIs;
        int aIt;
        double aIu;
        double aIv;
        double aIw;
        int mType;

        protected a(int i, double d, double d2, double d3, double d4, double d5, int i2, double d6, int i3, double d7, double d8) {
            this.mType = i;
            this.aIk = d;
            this.aIl = d2;
            this.aIm = d3;
            this.aIo = d4;
            this.aIp = d5;
            this.aIq = i2;
            this.aIr = d6;
            this.aIs = 0.0d;
            this.aIt = i3;
            this.aIu = 0.0d;
            this.aIv = d7;
            this.aIw = d8;
        }

        public final String toString() {
            return new StringBuilder(String.valueOf(String.valueOf(this.mType))).append(',').append(this.aIk).append(',').append(this.aIl).append(',').append(this.aIm).append(',').append(this.aIo).append(',').append(this.aIp).append(',').append(this.aIq).append(',').append(this.aIr).append(',').append(this.aIs).append(',').append(this.aIt).append(',').append(this.aIv).append(',').append(this.aIw).toString();
        }
    }

    private static class b {
        double aIA;
        boolean aIB;
        double[] aIC;
        double aID;
        int aIE;
        int aIF;
        boolean aIG;
        boolean aIH;
        double aII;
        double aIJ;
        double aIK;
        double aIL;
        double aIM;
        double aIN;
        double aIO;
        double[] aIP;
        private boolean aIQ;
        boolean aIR;
        boolean aIS;
        double[] aIT;
        double[][] aIU;
        double aIV;
        double aIW;
        double aIX;
        boolean aIY;
        double aIZ;
        double aIk;
        double aIx;
        boolean aIy;
        double[] aIz;
        double aJa;
        int aJb;
        int aJc;
        double aJd;
        double[] aJe;
        double[] aJf;
        boolean aJg;

        private b() {
            this.aIz = new double[2];
            this.aIC = new double[2];
            this.aIP = new double[2];
            this.aIT = new double[4];
            this.aIU = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
            this.aJe = new double[2];
            this.aJf = new double[2];
        }

        static /* synthetic */ void a(b bVar, b bVar2) {
            bVar.aIx = bVar2.aIx;
            bVar.aIy = bVar2.aIy;
            bVar.aIz = (double[]) bVar2.aIz.clone();
            bVar.aIA = bVar2.aIA;
            bVar.aIB = bVar2.aIB;
            bVar.aIC = (double[]) bVar2.aIC.clone();
            bVar.aID = bVar2.aID;
            bVar.aIE = bVar2.aIE;
            bVar.aIF = bVar2.aIF;
            bVar.aIG = bVar2.aIG;
            bVar.aIH = bVar2.aIH;
            bVar.aII = bVar2.aII;
            bVar.aIJ = bVar2.aIJ;
            bVar.aIK = bVar2.aIK;
            bVar.aIL = bVar2.aIL;
            bVar.aIM = bVar2.aIM;
            bVar.aIN = bVar2.aIN;
            bVar.aIO = bVar2.aIO;
            bVar.aIP = (double[]) bVar2.aIP.clone();
            bVar.aIQ = bVar2.aIQ;
            bVar.aIR = bVar2.aIR;
            bVar.aIS = bVar2.aIS;
            bVar.aIk = bVar2.aIk;
            bVar.aIT = (double[]) bVar2.aIT.clone();
            bVar.aIU[0] = (double[]) bVar2.aIU[0].clone();
            bVar.aIU[1] = (double[]) bVar2.aIU[1].clone();
            bVar.aIU[2] = (double[]) bVar2.aIU[2].clone();
            bVar.aIU[3] = (double[]) bVar2.aIU[3].clone();
            bVar.aIV = bVar2.aIV;
            bVar.aIW = bVar2.aIW;
            bVar.aIX = bVar2.aIX;
            bVar.aIY = bVar2.aIY;
            bVar.aIZ = bVar2.aIZ;
            bVar.aJa = bVar2.aJa;
            bVar.aJb = bVar2.aJb;
            bVar.aJc = bVar2.aJc;
            bVar.aJd = bVar2.aJd;
            bVar.aJe = (double[]) bVar2.aJe.clone();
            bVar.aJf = (double[]) bVar2.aJf.clone();
            bVar.aJg = bVar2.aJg;
        }
    }

    j() {
    }

    protected final void a(long j, double d, double d2, float f, boolean z, boolean z2) {
        double d3 = (double) j;
        double[] dArr = new double[]{d, d2};
        double d4 = (double) (f * f);
        double[] dArr2 = new double[]{0.0d, 0.0d};
        int i = z ? 3 : 5;
        double[] dArr3 = new double[]{d, d2};
        this.aIi.aIY = true;
        this.aIi.aJf[0] = 3.0d;
        this.aIi.aJf[1] = 1.2d;
        this.aIi.aJd = 0.5d;
        this.aIi.aIx = 1.2d;
        this.aIi.aID = 4.0d;
        this.aIi.aIE = 0;
        this.aIi.aIG = true;
        this.aIi.aIF = i;
        this.aIi.aIy = false;
        this.aIi.aIB = false;
        this.aIi.aIM = 40.0d;
        this.aIi.aIN = 0.15707963267948966d;
        this.aIi.aIO = 1.0d;
        this.aIi.aJe[0] = 400.0d;
        this.aIi.aJe[1] = 1.0d;
        this.aIi.aIR = z2;
        this.aIi.aIS = false;
        this.aIi.aIH = true;
        this.aIi.aII = 0.3333333333333333d;
        this.aIi.aIJ = 5.0d;
        this.aIi.aIK = 0.5d;
        this.aIi.aIL = 1.0d;
        this.aIi.aIZ = 0.5d;
        this.aIi.aJa = 1.0d;
        this.aIi.aJb = 0;
        this.aIi.aJc = 2;
        this.aIi.aJg = false;
        this.aIi.aIP[0] = dArr3[0];
        this.aIi.aIP[1] = dArr3[1];
        double[] dArr4 = new double[2];
        a(0, dArr, dArr4);
        this.aIi.aIk = d3;
        this.aIi.aIT[0] = dArr4[0];
        this.aIi.aIT[1] = dArr4[1];
        this.aIi.aIT[2] = dArr2[0];
        this.aIi.aIT[3] = dArr2[1];
        this.aIi.aIV = 0.0d;
        this.aIi.aIW = 1.0d;
        this.aIi.aIX = 1.005d;
        this.aIi.aIU[0][0] = d4;
        this.aIi.aIU[0][1] = 0.0d;
        this.aIi.aIU[0][2] = 0.0d;
        this.aIi.aIU[0][3] = 0.0d;
        this.aIi.aIU[1][0] = 0.0d;
        this.aIi.aIU[1][1] = d4;
        this.aIi.aIU[1][2] = 0.0d;
        this.aIi.aIU[1][3] = 0.0d;
        this.aIi.aIU[2][0] = 0.0d;
        this.aIi.aIU[2][1] = 0.0d;
        this.aIi.aIU[2][2] = 1.0d;
        this.aIi.aIU[2][3] = 0.0d;
        this.aIi.aIU[3][0] = 0.0d;
        this.aIi.aIU[3][1] = 0.0d;
        this.aIi.aIU[3][2] = 0.0d;
        this.aIi.aIU[3][3] = 1.0d;
        af(z);
    }

    protected final void af(boolean z) {
        boolean z2;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (this.aIi.aIY != z2) {
            this.aIi.aIY = z2;
            if (z2) {
                this.aIi.aIx = this.aIi.aJf[1];
                this.aIi.aIO = this.aIi.aJe[1];
                a(this.aIi.aIk, true);
                return;
            }
            this.aIi.aIx = this.aIi.aJf[0];
            this.aIi.aIO = this.aIi.aJe[0];
            a(this.aIi.aIk, true);
        }
    }

    protected final void a(a aVar) {
        if (aVar.aIp > 0.0d) {
            double d;
            if (this.aIi.aIy) {
                d = aVar.aIk - this.aIi.aIA;
                if (d < -10.0d) {
                    return;
                }
                if (d <= 0.0d) {
                    aVar.aIk = this.aIi.aIA + 0.5d;
                }
            }
            r12 = new double[2];
            a(0, new double[]{aVar.aIl, aVar.aIm}, r12);
            aVar.aIn[0] = r12[0];
            aVar.aIn[1] = r12[1];
            double[][] dArr;
            double[] dArr2;
            double d2;
            double sqrt;
            double d3;
            Object obj;
            int i;
            int i2;
            if (this.aIi.aIY) {
                if (aVar.mType != 3 || this.aIi.aIy) {
                    double d4;
                    double d5;
                    double[] dArr3;
                    if (aVar.mType == 3) {
                        d4 = aVar.aIk - this.aIi.aIA;
                        if (d4 > 0.0d) {
                            dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
                            dArr2 = new double[2];
                            d5 = r12[0] - this.aIi.aIz[0];
                            d2 = r12[1] - this.aIi.aIz[1];
                            if (this.aIi.aIR) {
                                d5 = (d5 * Math.cos(this.aIi.aIV)) - (Math.sin(this.aIi.aIV) * d2);
                                d2 = (d2 * Math.cos(this.aIi.aIV)) + (Math.sin(this.aIi.aIV) * d5);
                            }
                            sqrt = Math.sqrt((d5 * d5) + (d2 * d2));
                            d3 = sqrt / this.aIi.aIM;
                            d3 *= d3;
                            if (d3 <= 0.0625d) {
                                d3 = 0.0625d;
                            }
                            sqrt *= this.aIi.aIN;
                            sqrt *= sqrt;
                            if (sqrt <= 0.0625d) {
                                sqrt = 0.0625d;
                            }
                            d3 = (d3 + sqrt) / d4;
                            a(new double[]{this.aIi.aIU[2][2], this.aIi.aIU[2][3], this.aIi.aIU[3][2], this.aIi.aIU[3][3]}, this.aIh);
                            dArr[0][0] = this.aIh[0];
                            dArr[0][1] = this.aIh[1];
                            dArr[1][0] = this.aIh[2];
                            dArr[1][1] = this.aIh[3];
                            sqrt = (d5 / d4) - this.aIi.aIT[2];
                            double d6 = (d2 / d4) - this.aIi.aIT[3];
                            if (Math.sqrt((((sqrt * d6) * dArr[1][0]) + (((sqrt * sqrt) * dArr[0][0]) + ((sqrt * d6) * dArr[0][1]))) + ((d6 * d6) * dArr[1][1])) > 2.0d) {
                                this.aIi.aIU[2][2] = this.aIi.aIO;
                                this.aIi.aIU[2][3] = 0.0d;
                                this.aIi.aIU[3][2] = 0.0d;
                                this.aIi.aIU[3][3] = this.aIi.aIO;
                                dArr[0][0] = 1.0d / this.aIi.aIO;
                                dArr[0][1] = 0.0d;
                                dArr[1][0] = 0.0d;
                                dArr[1][1] = 1.0d / this.aIi.aIO;
                            }
                            dArr2[0] = (dArr[0][0] * this.aIi.aIT[2]) + (dArr[0][1] * this.aIi.aIT[3]);
                            dArr2[1] = (dArr[1][0] * this.aIi.aIT[2]) + (dArr[1][1] * this.aIi.aIT[3]);
                            dArr3 = dArr[0];
                            dArr3[0] = dArr3[0] + (1.0d / d3);
                            dArr3 = dArr[1];
                            dArr3[1] = dArr3[1] + (1.0d / d3);
                            dArr2[0] = (d5 / (d4 * d3)) + dArr2[0];
                            dArr2[1] = (d2 / (d3 * d4)) + dArr2[1];
                            a(new double[]{dArr[0][0], dArr[0][1], dArr[1][0], dArr[1][1]}, this.aIh);
                            this.aIi.aIU[2][2] = this.aIh[0];
                            this.aIi.aIU[2][3] = this.aIh[1];
                            this.aIi.aIU[3][2] = this.aIh[2];
                            this.aIi.aIU[3][3] = this.aIh[3];
                            this.aIi.aIT[2] = (this.aIi.aIU[2][2] * dArr2[0]) + (this.aIi.aIU[2][3] * dArr2[1]);
                            this.aIi.aIT[3] = (this.aIi.aIU[3][2] * dArr2[0]) + (this.aIi.aIU[3][3] * dArr2[1]);
                            a(aVar.aIk, false);
                        }
                    } else {
                        dArr3 = new double[2];
                        double[] dArr4 = new double[2];
                        a(aVar.aIk, false);
                        if (this.aIi.aIH) {
                            Object obj2;
                            if (this.aIi.aIB) {
                                dArr3[0] = this.aIi.aIT[0] - this.aIi.aIC[0];
                                dArr3[1] = this.aIi.aIT[1] - this.aIi.aIC[1];
                                dArr4[0] = r12[0] - this.aIi.aIC[0];
                                dArr4[1] = r12[1] - this.aIi.aIC[1];
                                d5 = Math.sqrt((dArr3[0] * dArr3[0]) + (dArr3[1] * dArr3[1]));
                                d3 = Math.sqrt((dArr4[0] * dArr4[0]) + (dArr4[1] * dArr4[1]));
                                if (d3 > this.aIi.aIJ && d5 > this.aIi.aIJ) {
                                    d2 = d3 / d5;
                                    d = d3 - d5;
                                    d4 = Math.sqrt(this.aIi.aIU[0][0] + this.aIi.aIU[1][1]);
                                    if (d5 > 3.0d * this.aIi.aIJ) {
                                        if (d < 0.0d) {
                                            d = -d;
                                        }
                                        d2 = d / d4;
                                        d = Math.atan2(dArr4[1], dArr4[0]) - Math.atan2(dArr3[1], dArr3[0]);
                                        if (d > 3.141592653589793d) {
                                            d -= 6.283185307179586d;
                                        } else if (d < -3.141592653589793d) {
                                            d += 6.283185307179586d;
                                        }
                                        if (d < 0.0d) {
                                            d = -d;
                                        }
                                        d /= Math.sqrt(this.aIi.aIW);
                                        d = Math.sqrt((d * d) + (d2 * d2));
                                        if (d < this.aIi.aID) {
                                            this.aIi.aJb = 0;
                                        } else if (d2 < this.aIi.aID) {
                                            b bVar = this.aIi;
                                            int i3 = bVar.aJb + 1;
                                            bVar.aJb = i3;
                                            if (i3 >= this.aIi.aJc) {
                                                this.aIi.aJb = 0;
                                                d = d2;
                                            }
                                        }
                                        if (d > this.aIi.aID) {
                                            obj2 = null;
                                            obj = null;
                                        } else {
                                            i = 1;
                                            i2 = 1;
                                        }
                                    } else if (d2 < this.aIi.aII || 1.0d / d2 < this.aIi.aII) {
                                        obj2 = null;
                                        obj = null;
                                    } else {
                                        obj2 = null;
                                        i2 = 1;
                                    }
                                } else if ((d3 >= this.aIi.aIJ || aVar.mType != 2) && (d3 >= this.aIi.aIJ * 0.5d || aVar.mType != 1)) {
                                    obj2 = null;
                                    i2 = 1;
                                } else {
                                    obj2 = null;
                                    obj = null;
                                }
                            } else {
                                d3 = 0.0d;
                                d5 = 0.0d;
                                obj2 = 1;
                                obj = 1;
                            }
                            if (obj != null) {
                                if (this.aIi.aIB) {
                                    if (d3 < d5) {
                                        d = this.aIi.aIK;
                                    } else {
                                        d = this.aIi.aIL;
                                    }
                                    d += (d5 / d3) * (1.0d - d);
                                    r12[0] = this.aIi.aIC[0] + (dArr4[0] * d);
                                    r12[1] = (d * dArr4[1]) + this.aIi.aIC[1];
                                }
                                if (obj2 != null) {
                                    a(r12);
                                } else {
                                    this.aIi.aIC[0] = r12[0];
                                    this.aIi.aIC[1] = r12[1];
                                }
                                this.aIi.aIT[0] = r12[0];
                                this.aIi.aIT[1] = r12[1];
                                this.aIi.aIU[0][0] = aVar.aIp * aVar.aIp;
                                this.aIi.aIU[0][1] = 0.0d;
                                this.aIi.aIU[1][0] = 0.0d;
                                this.aIi.aIU[1][1] = aVar.aIp * aVar.aIp;
                            }
                        } else {
                            b.a(this.aIj, this.aIi);
                            b(aVar.aIk, false);
                            if (!this.aIj.aIG) {
                                d2 = r12[0] - this.aIj.aIT[0];
                                d5 = r12[1] - this.aIj.aIT[1];
                                dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
                                d3 = 1.0d / ((this.aIj.aIU[0][0] * this.aIj.aIU[1][1]) - (this.aIj.aIU[0][1] * this.aIj.aIU[1][0]));
                                dArr[0][0] = this.aIj.aIU[1][1] * d3;
                                dArr[1][1] = this.aIj.aIU[0][0] * d3;
                                dArr[0][1] = (-this.aIj.aIU[0][1]) * d3;
                                dArr[1][0] = d3 * (-this.aIj.aIU[1][0]);
                                d = Math.sqrt((dArr[1][1] * (d5 * d5)) + ((((d2 * 2.0d) * d5) * dArr[1][0]) + ((d2 * d2) * dArr[0][0])));
                            } else if (this.aIi.aIB) {
                                d = this.aIi.aIC[0] - this.aIj.aIT[0];
                                d2 = this.aIi.aIC[1] - this.aIj.aIT[1];
                                d5 = this.aIi.aIC[0] - r12[0];
                                d3 = this.aIi.aIC[1] - r12[1];
                                d = Math.sqrt((d * d) + (d2 * d2)) - Math.sqrt((d5 * d5) + (d3 * d3));
                                d = Math.abs(d) / Math.sqrt((this.aIi.aIU[0][0] * this.aIi.aIU[0][0]) + (this.aIi.aIU[1][1] * this.aIi.aIU[1][1]));
                            } else {
                                d = 0.0d;
                            }
                            if (d > this.aIi.aID) {
                                b.a(this.aIj, this.aIi);
                                b(aVar.aIk, true);
                                if (this.aIi.aIG) {
                                    d = this.aIi.aIC[0] - this.aIj.aIT[0];
                                    d2 = this.aIi.aIC[1] - this.aIj.aIT[1];
                                    d5 = this.aIi.aIC[0] - r12[0];
                                    d3 = this.aIi.aIC[1] - r12[1];
                                    d = Math.sqrt((d * d) + (d2 * d2)) - Math.sqrt((d5 * d5) + (d3 * d3));
                                    d = Math.abs(d) / Math.sqrt((this.aIj.aIU[0][0] * this.aIj.aIU[0][0]) + (this.aIj.aIU[1][1] * this.aIj.aIU[1][1]));
                                } else {
                                    d2 = r12[0] - this.aIj.aIT[0];
                                    d5 = r12[1] - this.aIj.aIT[1];
                                    dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
                                    d3 = 1.0d / ((this.aIj.aIU[0][0] * this.aIj.aIU[1][1]) - (this.aIj.aIU[0][1] * this.aIj.aIU[1][0]));
                                    dArr[0][0] = this.aIj.aIU[1][1] * d3;
                                    dArr[1][1] = this.aIj.aIU[0][0] * d3;
                                    dArr[0][1] = (-this.aIj.aIU[0][1]) * d3;
                                    dArr[1][0] = d3 * (-this.aIj.aIU[1][0]);
                                    d = Math.sqrt((dArr[1][1] * (d5 * d5)) + ((((d2 * 2.0d) * d5) * dArr[1][0]) + ((d2 * d2) * dArr[0][0])));
                                }
                                if (d <= this.aIj.aID) {
                                    b.a(this.aIi, this.aIj);
                                    this.aIi.aIE = 0;
                                    a(r12);
                                } else if (this.aIi.aIE < this.aIi.aIF) {
                                    this.aIi.aIE++;
                                } else {
                                    b.a(this.aIi, this.aIj);
                                    this.aIi.aIE = 0;
                                }
                            } else {
                                b.a(this.aIi, this.aIj);
                                this.aIi.aIE = 0;
                                a(r12);
                            }
                            this.aIi.aIT[0] = r12[0];
                            this.aIi.aIT[1] = r12[1];
                            this.aIi.aIU[0][0] = aVar.aIp * aVar.aIp;
                            this.aIi.aIU[0][1] = 0.0d;
                            this.aIi.aIU[1][0] = 0.0d;
                            this.aIi.aIU[1][1] = aVar.aIp * aVar.aIp;
                        }
                    }
                }
                if (aVar.mType == 3) {
                    this.aIi.aIz[0] = r12[0];
                    this.aIi.aIz[1] = r12[1];
                    this.aIi.aIA = aVar.aIk;
                    this.aIi.aIy = true;
                }
            } else if (aVar.mType != 3) {
                Object obj3;
                double[] dArr5 = new double[2];
                double[] dArr6 = new double[2];
                double[] dArr7 = new double[2];
                a(aVar.aIk, false);
                if (this.aIi.aIB) {
                    dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{2, 2});
                    dArr5[0] = aVar.aIn[0] - this.aIi.aIT[0];
                    dArr5[1] = aVar.aIn[1] - this.aIi.aIT[1];
                    a(new double[]{this.aIi.aIU[0][0], this.aIi.aIU[0][1], this.aIi.aIU[1][0], this.aIi.aIU[1][1]}, this.aIh);
                    dArr[0][0] = this.aIh[0];
                    dArr[0][1] = this.aIh[1];
                    dArr[1][0] = this.aIh[2];
                    dArr[1][1] = this.aIh[3];
                    if (Math.sqrt((((dArr5[0] * dArr5[0]) * dArr[0][0]) + (((2.0d * dArr5[0]) * dArr5[1]) * dArr[1][0])) + ((dArr5[1] * dArr5[1]) * dArr[1][1])) > this.aIi.aID) {
                        b bVar2 = this.aIi;
                        i = bVar2.aIE + 1;
                        bVar2.aIE = i;
                        if (i >= this.aIi.aIF) {
                            obj3 = 1;
                            obj = null;
                            this.aIi.aIE = 0;
                        } else {
                            obj3 = null;
                            obj = null;
                        }
                    } else {
                        this.aIi.aIE = 0;
                        obj3 = 1;
                        obj = 1;
                    }
                } else {
                    obj3 = 1;
                    obj = null;
                    this.aIi.aIE = 0;
                }
                if (obj3 == null) {
                    return;
                }
                if (obj == null) {
                    this.aIi.aIT[0] = aVar.aIn[0];
                    this.aIi.aIT[1] = aVar.aIn[1];
                    this.aIi.aIT[2] = 0.0d;
                    this.aIi.aIT[3] = 0.0d;
                    this.aIi.aIU[0][0] = aVar.aIp * aVar.aIp;
                    this.aIi.aIU[0][1] = 0.0d;
                    this.aIi.aIU[0][2] = 0.0d;
                    this.aIi.aIU[0][3] = 0.0d;
                    this.aIi.aIU[1][0] = 0.0d;
                    this.aIi.aIU[1][1] = this.aIi.aIU[0][0];
                    this.aIi.aIU[1][2] = 0.0d;
                    this.aIi.aIU[1][2] = 0.0d;
                    this.aIi.aIU[2][0] = 0.0d;
                    this.aIi.aIU[2][1] = 0.0d;
                    this.aIi.aIU[2][2] = this.aIi.aIO;
                    this.aIi.aIU[2][3] = 0.0d;
                    this.aIi.aIU[3][0] = 0.0d;
                    this.aIi.aIU[3][1] = 0.0d;
                    this.aIi.aIU[3][2] = 0.0d;
                    this.aIi.aIU[3][3] = this.aIi.aIO;
                    this.aIi.aIC[0] = aVar.aIn[0];
                    this.aIi.aIC[1] = aVar.aIn[1];
                    this.aIi.aIB = true;
                    return;
                }
                dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
                double[] dArr8 = new double[]{this.aIi.aIT[0] - this.aIi.aIC[0], this.aIi.aIT[1] - this.aIi.aIC[1]};
                dArr7[0] = aVar.aIn[0] - this.aIi.aIC[0];
                dArr7[1] = aVar.aIn[1] - this.aIi.aIC[1];
                d3 = Math.sqrt((dArr7[0] * dArr7[0]) + (dArr7[1] * dArr7[1]));
                sqrt = Math.sqrt((dArr6[1] * dArr6[1]) + (dArr6[0] * dArr6[0]));
                if (d3 < sqrt) {
                    d2 = this.aIi.aIZ;
                } else {
                    d2 = this.aIi.aJa;
                }
                if (a(this.aIi.aIU, dArr)) {
                    int i4;
                    double d7 = 1.0d / (aVar.aIp * aVar.aIp);
                    double[] dArr9 = new double[4];
                    if (this.aIi.aJg) {
                        d2 += (sqrt / d3) * (1.0d - d2);
                        dArr8[0] = this.aIi.aIC[0] + (dArr7[0] * d2);
                        dArr8[1] = (d2 * dArr7[1]) + this.aIi.aIC[1];
                    } else {
                        dArr8[0] = (this.aIi.aIT[0] * (1.0d - d2)) + (aVar.aIn[0] * d2);
                        dArr8[1] = (d2 * aVar.aIn[1]) + (this.aIi.aIT[1] * (1.0d - d2));
                    }
                    for (i = 0; i < 4; i++) {
                        dArr9[i] = 0.0d;
                        for (i4 = 0; i4 < 4; i4++) {
                            dArr9[i] = dArr9[i] + (dArr[i][i4] * this.aIi.aIT[i4]);
                        }
                    }
                    dArr2 = dArr[0];
                    dArr2[0] = dArr2[0] + d7;
                    dArr2 = dArr[1];
                    dArr2[1] = dArr2[1] + d7;
                    if (a(dArr, this.aIi.aIU)) {
                        dArr9[0] = dArr9[0] + (dArr8[0] * d7);
                        dArr9[1] = dArr9[1] + (dArr8[1] * d7);
                        for (i4 = 0; i4 < 4; i4++) {
                            this.aIi.aIT[i4] = 0.0d;
                            for (i2 = 0; i2 < 4; i2++) {
                                dArr5 = this.aIi.aIT;
                                dArr5[i4] = dArr5[i4] + (this.aIi.aIU[i4][i2] * dArr9[i2]);
                            }
                        }
                        this.aIi.aIC[0] = dArr8[0];
                        this.aIi.aIC[1] = dArr8[1];
                    }
                }
            }
        }
    }

    private void a(double d, boolean z) {
        double d2;
        double d3;
        double d4 = d - this.aIi.aIk;
        double d5 = d4 * d4;
        if (z) {
            this.aIi.aIU[2][2] = this.aIi.aIO;
            this.aIi.aIU[2][3] = 0.0d;
            this.aIi.aIU[3][2] = 0.0d;
            this.aIi.aIU[3][3] = this.aIi.aIO;
        } else {
            d2 = 1.0d;
            if (d4 > 0.5d) {
                d3 = 0.0d;
                while (d3 < d4) {
                    d3 = 1.0d + d3;
                    d2 = this.aIi.aIx * d2;
                }
            }
            double[] dArr = this.aIi.aIU[2];
            dArr[2] = dArr[2] * d2;
            dArr = this.aIi.aIU[2];
            dArr[3] = dArr[3] * d2;
            dArr = this.aIi.aIU[3];
            dArr[2] = dArr[2] * d2;
            dArr = this.aIi.aIU[3];
            dArr[3] = d2 * dArr[3];
        }
        if (d4 > 0.5d) {
            d3 = 1.0d;
            for (d2 = 0.0d; d2 < d4; d2 += 1.0d) {
                d3 *= this.aIi.aIX;
            }
            b bVar = this.aIi;
            bVar.aIW = d3 * bVar.aIW;
        }
        this.aIi.aIT[0] = this.aIi.aIT[0] + (this.aIi.aIT[2] * d4);
        this.aIi.aIT[1] = this.aIi.aIT[1] + (this.aIi.aIT[3] * d4);
        if (this.aIi.aIY) {
            this.aIi.aIU[0][0] = this.aIi.aIU[0][0] + (this.aIi.aIU[2][2] * d5);
            this.aIi.aIU[0][1] = this.aIi.aIU[0][1] + (this.aIi.aIU[2][3] * d5);
            this.aIi.aIU[1][0] = this.aIi.aIU[1][0] + (this.aIi.aIU[3][2] * d5);
            this.aIi.aIU[1][1] = this.aIi.aIU[1][1] + (this.aIi.aIU[3][3] * d5);
        } else {
            this.aIi.aIU[0][0] = (this.aIi.aIU[0][0] + ((this.aIi.aIU[0][2] + this.aIi.aIU[2][0]) * d4)) + (this.aIi.aIU[2][2] * d5);
            this.aIi.aIU[1][1] = (this.aIi.aIU[1][1] + ((this.aIi.aIU[1][3] + this.aIi.aIU[3][1]) * d4)) + (this.aIi.aIU[3][3] * d5);
            this.aIi.aIU[0][2] = this.aIi.aIU[0][2] + (this.aIi.aIU[2][2] * d4);
            this.aIi.aIU[2][0] = this.aIi.aIU[2][0] + (this.aIi.aIU[2][2] * d4);
            this.aIi.aIU[1][3] = this.aIi.aIU[1][3] + (this.aIi.aIU[3][3] * d4);
            this.aIi.aIU[3][1] = this.aIi.aIU[3][1] + (this.aIi.aIU[3][3] * d4);
        }
        this.aIi.aIk = d;
    }

    private void b(double d, boolean z) {
        double d2;
        double d3;
        double d4 = d - this.aIj.aIk;
        double d5 = d4 * d4;
        if (z) {
            this.aIj.aIU[2][2] = this.aIj.aIO;
            this.aIj.aIU[2][3] = 0.0d;
            this.aIj.aIU[3][2] = 0.0d;
            this.aIj.aIU[3][3] = this.aIj.aIO;
        } else {
            d2 = 1.0d;
            if (d4 > 0.5d) {
                d3 = 0.0d;
                while (d3 < d4) {
                    d3 = 1.0d + d3;
                    d2 = this.aIj.aIx * d2;
                }
            }
            double[] dArr = this.aIj.aIU[2];
            dArr[2] = dArr[2] * d2;
            dArr = this.aIj.aIU[2];
            dArr[3] = dArr[3] * d2;
            dArr = this.aIj.aIU[3];
            dArr[2] = dArr[2] * d2;
            dArr = this.aIj.aIU[3];
            dArr[3] = d2 * dArr[3];
        }
        if (d4 > 0.5d) {
            d3 = 1.0d;
            for (d2 = 0.0d; d2 < d4; d2 += 1.0d) {
                d3 *= this.aIj.aIX;
            }
            b bVar = this.aIj;
            bVar.aIW = d3 * bVar.aIW;
        }
        this.aIj.aIT[0] = this.aIj.aIT[0] + (this.aIj.aIT[2] * d4);
        this.aIj.aIT[1] = this.aIj.aIT[1] + (this.aIj.aIT[3] * d4);
        if (this.aIj.aIY) {
            this.aIj.aIU[0][0] = this.aIj.aIU[0][0] + (this.aIj.aIU[2][2] * d5);
            this.aIj.aIU[0][1] = this.aIj.aIU[0][1] + (this.aIj.aIU[2][3] * d5);
            this.aIj.aIU[1][0] = this.aIj.aIU[1][0] + (this.aIj.aIU[3][2] * d5);
            this.aIj.aIU[1][1] = this.aIj.aIU[1][1] + (this.aIj.aIU[3][3] * d5);
        } else {
            this.aIj.aIU[0][0] = (this.aIj.aIU[0][0] + ((this.aIj.aIU[0][2] + this.aIj.aIU[2][0]) * d4)) + (this.aIj.aIU[2][2] * d5);
            this.aIj.aIU[1][1] = (this.aIj.aIU[1][1] + ((this.aIj.aIU[1][3] + this.aIj.aIU[3][1]) * d4)) + (this.aIj.aIU[3][3] * d5);
            this.aIj.aIU[0][2] = this.aIj.aIU[0][2] + (this.aIj.aIU[2][2] * d4);
            this.aIj.aIU[2][0] = this.aIj.aIU[2][0] + (this.aIj.aIU[2][2] * d4);
            this.aIj.aIU[1][3] = this.aIj.aIU[1][3] + (this.aIj.aIU[3][3] * d4);
            this.aIj.aIU[3][1] = this.aIj.aIU[3][1] + (this.aIj.aIU[3][3] * d4);
        }
        this.aIj.aIk = d;
    }

    private void a(double[] dArr) {
        if (this.aIi.aIR && this.aIi.aIB) {
            double[] dArr2 = new double[2];
            r1 = new double[2];
            double d = this.aIi.aJd;
            dArr2[0] = this.aIi.aIT[0] - this.aIi.aIC[0];
            dArr2[1] = this.aIi.aIT[1] - this.aIi.aIC[1];
            r1[0] = dArr[0] - this.aIi.aIC[0];
            r1[1] = dArr[1] - this.aIi.aIC[1];
            double sqrt = Math.sqrt((dArr2[0] * dArr2[0]) + (dArr2[1] * dArr2[1]));
            double sqrt2 = Math.sqrt((r1[0] * r1[0]) + (r1[1] * r1[1]));
            if (sqrt > this.aIi.aIJ && sqrt2 > this.aIi.aIJ) {
                Object obj;
                double atan2 = Math.atan2(r1[1], r1[0]) - Math.atan2(dArr2[1], dArr2[0]);
                if (atan2 > 3.141592653589793d) {
                    atan2 -= 6.283185307179586d;
                } else if (atan2 < -3.141592653589793d) {
                    atan2 += 6.283185307179586d;
                }
                b bVar = this.aIi;
                bVar.aIV = (d * atan2) + bVar.aIV;
                if (atan2 * atan2 > 4.0d * this.aIi.aIW) {
                    obj = 1;
                } else {
                    obj = null;
                }
                d = Math.sqrt(this.aIi.aIU[0][0] + this.aIi.aIU[1][1]);
                if (sqrt >= sqrt2) {
                    sqrt = sqrt2;
                }
                sqrt = d / sqrt;
                if (obj != null) {
                    this.aIi.aIW = sqrt * sqrt;
                } else {
                    this.aIi.aIW = 1.0d / ((1.0d / (sqrt * sqrt)) + (1.0d / this.aIi.aIW));
                }
            }
        }
        this.aIi.aIC[0] = dArr[0];
        this.aIi.aIC[1] = dArr[1];
        this.aIi.aIB = true;
    }

    void a(int i, double[] dArr, double[] dArr2) {
        switch (i) {
            case 0:
                dArr2[0] = ((dArr[1] - this.aIi.aIP[1]) * 6378137.0d) * Math.cos(this.aIi.aIP[0]);
                dArr2[1] = (dArr[0] - this.aIi.aIP[0]) * 6378137.0d;
                return;
            case 1:
                dArr2[0] = (dArr[1] / 6378137.0d) + this.aIi.aIP[0];
                dArr2[1] = (dArr[0] / (Math.cos(this.aIi.aIP[0]) * 6378137.0d)) + this.aIi.aIP[1];
                return;
            default:
                return;
        }
    }

    private static void a(double[] dArr, double[] dArr2) {
        double d = 1.0d / ((dArr[0] * dArr[3]) - (dArr[1] * dArr[2]));
        dArr2[0] = dArr[3] * d;
        dArr2[3] = dArr[0] * d;
        dArr2[1] = (-dArr[1]) * d;
        dArr2[2] = d * (-dArr[2]);
    }

    private static boolean a(double[][] dArr, double[][] dArr2) {
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{4, 4});
        dArr3[0][0] = ((((((dArr[1][1] * dArr[2][2]) * dArr[3][3]) - ((dArr[1][1] * dArr[2][3]) * dArr[3][2])) - ((dArr[2][1] * dArr[1][2]) * dArr[3][3])) + ((dArr[2][1] * dArr[1][3]) * dArr[3][2])) + ((dArr[3][1] * dArr[1][2]) * dArr[2][3])) - ((dArr[3][1] * dArr[1][3]) * dArr[2][2]);
        dArr3[1][0] = (((((((-dArr[1][0]) * dArr[2][2]) * dArr[3][3]) + ((dArr[1][0] * dArr[2][3]) * dArr[3][2])) + ((dArr[2][0] * dArr[1][2]) * dArr[3][3])) - ((dArr[2][0] * dArr[1][3]) * dArr[3][2])) - ((dArr[3][0] * dArr[1][2]) * dArr[2][3])) + ((dArr[3][0] * dArr[1][3]) * dArr[2][2]);
        dArr3[2][0] = ((((((dArr[1][0] * dArr[2][1]) * dArr[3][3]) - ((dArr[1][0] * dArr[2][3]) * dArr[3][1])) - ((dArr[2][0] * dArr[1][1]) * dArr[3][3])) + ((dArr[2][0] * dArr[1][3]) * dArr[3][1])) + ((dArr[3][0] * dArr[1][1]) * dArr[2][3])) - ((dArr[3][0] * dArr[1][3]) * dArr[2][1]);
        dArr3[3][0] = (((((((-dArr[1][0]) * dArr[2][1]) * dArr[3][2]) + ((dArr[1][0] * dArr[2][2]) * dArr[3][1])) + ((dArr[2][0] * dArr[1][1]) * dArr[3][2])) - ((dArr[2][0] * dArr[1][2]) * dArr[3][1])) - ((dArr[3][0] * dArr[1][1]) * dArr[2][2])) + ((dArr[3][0] * dArr[1][2]) * dArr[2][1]);
        dArr3[0][1] = (((((((-dArr[0][1]) * dArr[2][2]) * dArr[3][3]) + ((dArr[0][1] * dArr[2][3]) * dArr[3][2])) + ((dArr[2][1] * dArr[0][2]) * dArr[3][3])) - ((dArr[2][1] * dArr[0][3]) * dArr[3][2])) - ((dArr[3][1] * dArr[0][2]) * dArr[2][3])) + ((dArr[3][1] * dArr[0][3]) * dArr[2][2]);
        dArr3[1][1] = ((((((dArr[0][0] * dArr[2][2]) * dArr[3][3]) - ((dArr[0][0] * dArr[2][3]) * dArr[3][2])) - ((dArr[2][0] * dArr[0][2]) * dArr[3][3])) + ((dArr[2][0] * dArr[0][3]) * dArr[3][2])) + ((dArr[3][0] * dArr[0][2]) * dArr[2][3])) - ((dArr[3][0] * dArr[0][3]) * dArr[2][2]);
        dArr3[2][1] = (((((((-dArr[0][0]) * dArr[2][1]) * dArr[3][3]) + ((dArr[0][0] * dArr[2][3]) * dArr[3][1])) + ((dArr[2][0] * dArr[0][1]) * dArr[3][3])) - ((dArr[2][0] * dArr[0][3]) * dArr[3][1])) - ((dArr[3][0] * dArr[0][1]) * dArr[2][3])) + ((dArr[3][0] * dArr[0][3]) * dArr[2][1]);
        dArr3[3][1] = ((((((dArr[0][0] * dArr[2][1]) * dArr[3][2]) - ((dArr[0][0] * dArr[2][2]) * dArr[3][1])) - ((dArr[2][0] * dArr[0][1]) * dArr[3][2])) + ((dArr[2][0] * dArr[0][2]) * dArr[3][1])) + ((dArr[3][0] * dArr[0][1]) * dArr[2][2])) - ((dArr[3][0] * dArr[0][2]) * dArr[2][1]);
        dArr3[0][2] = ((((((dArr[0][1] * dArr[1][2]) * dArr[3][3]) - ((dArr[0][1] * dArr[1][3]) * dArr[3][2])) - ((dArr[1][1] * dArr[0][2]) * dArr[3][3])) + ((dArr[1][1] * dArr[0][3]) * dArr[3][2])) + ((dArr[3][1] * dArr[0][2]) * dArr[1][3])) - ((dArr[3][1] * dArr[0][3]) * dArr[1][2]);
        dArr3[1][2] = (((((((-dArr[0][0]) * dArr[1][2]) * dArr[3][3]) + ((dArr[0][0] * dArr[1][3]) * dArr[3][2])) + ((dArr[1][0] * dArr[0][2]) * dArr[3][3])) - ((dArr[1][0] * dArr[0][3]) * dArr[3][2])) - ((dArr[3][0] * dArr[0][2]) * dArr[1][3])) + ((dArr[3][0] * dArr[0][3]) * dArr[1][2]);
        dArr3[2][2] = ((((((dArr[0][0] * dArr[1][1]) * dArr[3][3]) - ((dArr[0][0] * dArr[1][3]) * dArr[3][1])) - ((dArr[1][0] * dArr[0][1]) * dArr[3][3])) + ((dArr[1][0] * dArr[0][3]) * dArr[3][1])) + ((dArr[3][0] * dArr[0][1]) * dArr[1][3])) - ((dArr[3][0] * dArr[0][3]) * dArr[1][1]);
        dArr3[3][2] = (((((((-dArr[0][0]) * dArr[1][1]) * dArr[3][2]) + ((dArr[0][0] * dArr[1][2]) * dArr[3][1])) + ((dArr[1][0] * dArr[0][1]) * dArr[3][2])) - ((dArr[1][0] * dArr[0][2]) * dArr[3][1])) - ((dArr[3][0] * dArr[0][1]) * dArr[1][2])) + ((dArr[3][0] * dArr[0][2]) * dArr[1][1]);
        dArr3[0][3] = (((((((-dArr[0][1]) * dArr[1][2]) * dArr[2][3]) + ((dArr[0][1] * dArr[1][3]) * dArr[2][2])) + ((dArr[1][1] * dArr[0][2]) * dArr[2][3])) - ((dArr[1][1] * dArr[0][3]) * dArr[2][2])) - ((dArr[2][1] * dArr[0][2]) * dArr[1][3])) + ((dArr[2][1] * dArr[0][3]) * dArr[1][2]);
        dArr3[1][3] = ((((((dArr[0][0] * dArr[1][2]) * dArr[2][3]) - ((dArr[0][0] * dArr[1][3]) * dArr[2][2])) - ((dArr[1][0] * dArr[0][2]) * dArr[2][3])) + ((dArr[1][0] * dArr[0][3]) * dArr[2][2])) + ((dArr[2][0] * dArr[0][2]) * dArr[1][3])) - ((dArr[2][0] * dArr[0][3]) * dArr[1][2]);
        dArr3[2][3] = (((((((-dArr[0][0]) * dArr[1][1]) * dArr[2][3]) + ((dArr[0][0] * dArr[1][3]) * dArr[2][1])) + ((dArr[1][0] * dArr[0][1]) * dArr[2][3])) - ((dArr[1][0] * dArr[0][3]) * dArr[2][1])) - ((dArr[2][0] * dArr[0][1]) * dArr[1][3])) + ((dArr[2][0] * dArr[0][3]) * dArr[1][1]);
        dArr3[3][3] = ((((((dArr[0][0] * dArr[1][1]) * dArr[2][2]) - ((dArr[0][0] * dArr[1][2]) * dArr[2][1])) - ((dArr[1][0] * dArr[0][1]) * dArr[2][2])) + ((dArr[1][0] * dArr[0][2]) * dArr[2][1])) + ((dArr[2][0] * dArr[0][1]) * dArr[1][2])) - ((dArr[2][0] * dArr[0][2]) * dArr[1][1]);
        double d = (((dArr[0][0] * dArr3[0][0]) + (dArr[0][1] * dArr3[1][0])) + (dArr[0][2] * dArr3[2][0])) + (dArr[0][3] * dArr3[3][0]);
        if (d == 0.0d) {
            return false;
        }
        double d2 = 1.0d / d;
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 4; i2++) {
                dArr2[i][i2] = dArr3[i][i2] * d2;
            }
        }
        return true;
    }
}
