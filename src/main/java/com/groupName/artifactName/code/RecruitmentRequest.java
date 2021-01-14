package com.groupName.artifactName.code;

public class RecruitmentRequest {
    String family;
    Integer soldierId;

    public RecruitmentRequest(String family, Integer soldierId) {
        this.family = family;
        this.soldierId = soldierId;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Integer getSoldierId() {
        return soldierId;
    }

    public void setSoldierId(Integer soldierId) {
        this.soldierId = soldierId;
    }
}
