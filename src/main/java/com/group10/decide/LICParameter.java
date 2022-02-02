package com.group10.decide;

/**
 * Class that stores all the LIC parameters
 *
 * @author Amanda Krohn
 */
public class LICParameter {
    private final double LENGTH_1;
    private final double RADIUS_1;
    private final double EPSILON;
    private final double AREA_1;
    private final double DIST;
    private final double LENGTH_2;
    private final double RADIUS_2;
    private final double AREA_2;
    private final int Q_PTS;
    private final int QUADS;
    private final int N_PTS;
    private final int K_PTS;
    private final int A_PTS;
    private final int B_PTS;
    private final int C_PTS;
    private final int D_PTS;
    private final int E_PTS;
    private final int F_PTS;
    private final int G_PTS;

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
                        int quads,int nPts, int kPts, int aPts, int bPts, int cPts, int dPts,
                        int ePts, int fPts, int gPts){
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

    /**
     * @return the parameter LENGTH_1 needed in the LIC's
     * */
    public double getLength1(){
        return this.LENGTH_1;
    }

    /**
     * @return the parameter LENGTH_2 needed in the LIC's
     * */
    public double getLength2(){
        return this.LENGTH_2;
    }

    /**
     * @return the parameter RADIUS_1 needed in the LIC's
     * */
    public double getRadius1(){
        return this.RADIUS_1;
    }

    /**
     * @return the parameter RADIUS_2 needed in the LIC's
     * */
    public double getRadius2(){
        return this.RADIUS_2;
    }

    /**
     * @return the parameter AREA_1 needed in the LIC's
     * */
    public double getArea1(){
        return this.AREA_1;
    }

    /**
     * @return the parameter AREA_2 needed in the LIC's
     * */
    public double getArea2(){
        return this.AREA_2;
    }

    /**
     * @return the parameter DIST needed in the LIC's
     * */
    public double getDist(){
        return this.DIST;
    }

    /**
     * @return the parameter EPSILON needed in the LIC's
     * */
    public double getEpsilon(){
        return this.EPSILON;
    }

    /**
     * @return the parameter QUADS needed in the LIC's
     * */
    public int getQuads(){
        return this.QUADS;
    }

    /**
     * @return the parameter Q_PTS needed in the LIC's
     * */
    public int getQPts(){
        return this.Q_PTS;
    }

    /**
     * @return the parameter N_PTS needed in the LIC's
     * */
    public int getNPts(){
        return this.N_PTS;
    }

    /**
     * @return the parameter K_PTS needed in the LIC's
     * */
    public int getKPts(){
        return this.K_PTS;
    }

    /**
     * @return the parameter A_PTS needed in the LIC's
     * */
    public int getAPts(){
        return this.A_PTS;
    }

    /**
     * @return the parameter B_PTS needed in the LIC's
     * */
    public int getBPts(){
        return this.B_PTS;
    }

    /**
     * @return the parameter C_PTS needed in the LIC's
     * */
    public int getCPts(){
        return this.C_PTS;
    }

    /**
     * @return the parameter D_PTS needed in the LIC's
     * */
    public int getDPts(){
        return this.D_PTS;
    }

    /**
     * @return the parameter E_PTS needed in the LIC's
     * */
    public int getEPts(){
        return this.E_PTS;
    }

    /**
     * @return the parameter F_PTS needed in the LIC's
     * */
    public int getFPts(){
        return this.F_PTS;
    }

    /**
     * @return the parameter G_PTS needed in the LIC's
     * */
    public int getGPts(){
        return this.G_PTS;
    }
}