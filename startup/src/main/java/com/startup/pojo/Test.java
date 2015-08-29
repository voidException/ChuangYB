package com.startup.pojo;

public class Test {
    private Integer testid;

    private String itemmain;

    private String optiona;

    private String optionb;

    private String optionc;

    private String optiond;

    private Integer answer;

    private String whyso;
    

    public Integer getTestid() {
        return testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
    }

    public String getItemmain() {
        return itemmain;
    }

    public void setItemmain(String itemmain) {
        this.itemmain = itemmain == null ? null : itemmain.trim();
    }

    public String getOptiona() {
        return optiona;
    }

    public void setOptiona(String optiona) {
        this.optiona = optiona == null ? null : optiona.trim();
    }

    public String getOptionb() {
        return optionb;
    }

    public void setOptionb(String optionb) {
        this.optionb = optionb == null ? null : optionb.trim();
    }

    public String getOptionc() {
        return optionc;
    }

    public void setOptionc(String optionc) {
        this.optionc = optionc == null ? null : optionc.trim();
    }

    public String getOptiond() {
        return optiond;
    }

    public void setOptiond(String optiond) {
        this.optiond = optiond == null ? null : optiond.trim();
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public String getWhyso() {
        return whyso;
    }

    public void setWhyso(String whyso) {
        this.whyso = whyso == null ? null : whyso.trim();
    }
}