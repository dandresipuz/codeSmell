package com.IngSoft.codeSmell.infrastructure.controller;

import com.IngSoft.codeSmell.application.usecase.SkillServiceUseCase;
import com.IngSoft.codeSmell.domain.model.Skill;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/skill")
@Tag(name = "Developer Checker", description = "API para verificar si un candidato es Developer")
public class CheckDeveloperController {

    private final SkillServiceUseCase skillServiceUseCase;

    public CheckDeveloperController(SkillServiceUseCase skillServiceUseCase) {
        this.skillServiceUseCase = skillServiceUseCase;
    }

    /**
     * Valida si un candidato cumple los requisitos de Developer.
     * @param skills Lista de strings representando la matriz de habilidades.
     * @return true si el candidato es Developer, false en caso contrario.
     */
    @PostMapping("/validate")
    @Operation(summary = "Validar candidato", description = "Determina si un candidato es Developer basado en su matriz de habilidades")
    public boolean validateCandidate(@RequestBody List<String> skills) {
        Skill matrix = new Skill(skills);
        return skillServiceUseCase.isDeveloper(matrix);
    }
}
