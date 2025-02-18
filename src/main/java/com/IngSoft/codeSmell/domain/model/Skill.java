package com.IngSoft.codeSmell.domain.model;

import java.util.List;

public class Skill {
    private List<String> skills;

    public Skill(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getSkills() {
        return skills;
    }
}
