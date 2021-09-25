package com.example.systemquiz;

public class ansClass {
    private int opA,opB,opC,opD,quesi,ansi;

    public ansClass(int quesii, int opa, int opb, int opc, int opd, int ansii)
    {
        quesi= quesii;
        opA= opa;
        opB= opb;
        opC= opc;
        opD= opd;
        ansi= ansii;

    }

    public int getOpA() {
        return opA;
    }

    public int getOpB() {
        return opB;
    }

    public int getOpC() {
        return opC;
    }

    public int getOpD() {
        return opD;
    }

    public int getQuesi() {
        return quesi;
    }

    public int getAnsi() {
        return ansi;
    }
}
