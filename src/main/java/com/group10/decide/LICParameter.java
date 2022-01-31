package com.group10.decide;

/**
 * Class for the LIC parameters
 */
public class LICParameter {
    public final double LENGTH_1;
    public final double RADIUS_1;
    public final double EPSILON;
    public final double AREA_1;
    public final double DIST;
    public final double LENGTH_2;
    public final double RADIUS_2;
    public final double AREA_2;
    public final int Q_PTS;
    public final int QUADS;
    public final int N_PTS;
    public final int K_PTS;
    public final int A_PTS;
    public final int B_PTS;
    public final int C_PTS;
    public final int D_PTS;
    public final int E_PTS;
    public final int F_PTS;
    public final int G_PTS;

    /**
     * Initializes a new instance of the LICParameter object from input.
     * @param length1   Length in LIC 0, 7, 12
     * @param radius1   Radius in LIC 1, 8, 13
     * @param epsilon   Deviation from PI in LIC 2, 9
     * @param area1     Area in LIC 3, 10, 14
     * @param dist      Distance in LIC 6
     * @param length2   Maximum length in LIC 12
     * @param radius2   Maximum radius in LIC 13
     * @param area2     Maximum area in LIC 14
     * @param qPts      No. of consecutive points in LIC 4
     * @param quads     No. of quadrants in LIC 4
     * @param nPts      No. of consective pts. in LIC 6
     * @param kPts      No. of int. pts. in LIC 7, 12
     * @param aPts      No. of int. pts. in LIC 8, 13
     * @param bPts      No. of int. pts. in LIC 8, 13
     * @param cPts      No. of int. pts. in LIC 9
     * @param dPts      No. of int. pts. in LIC 9
     * @param ePts      No. of int. pts. in LIC 10, 14
     * @param fPts      No. of int. pts. in LIC 10, 14
     * @param gPts      No. of int. pts. in LIC 11
     */
    public LICParameter(double length1, double radius1, double epsilon, double area1,
                        double dist, double length2, double radius2, double area2, int qPts,
                        int quads,int nPts, int kPts, int aPts, int bPts, int cPts, int dPts, int ePts, int fPts,
                        int gPts){
        this.LENGTH_1 = length1;
        this.LENGTH_2 = length2;
        this.RADIUS_1 = radius1;
        this.RADIUS_2 = radius2;
        this.AREA_1 = area1;
        this.AREA_2 = area2;
        this.EPSILON = epsilon;
        this.DIST = dist;
        this.QUADS = quads;
        this.Q_PTS = qPts;
        this.N_PTS = nPts;
        this.K_PTS = kPts;
        this.A_PTS = aPts;
        this.B_PTS = bPts;
        this.C_PTS = cPts;
        this.D_PTS = dPts;
        this.E_PTS = ePts;
        this.F_PTS = fPts;
        this.G_PTS = gPts;
    }
}