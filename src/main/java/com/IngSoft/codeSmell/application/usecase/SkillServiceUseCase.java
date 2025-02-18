package com.IngSoft.codeSmell.application.usecase;

import com.IngSoft.codeSmell.domain.SkillValidator;
import com.IngSoft.codeSmell.domain.model.Skill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceUseCase implements SkillValidator {

    private static final int SEQUENCE_LENGTH = 4;

    @Override
    public boolean isDeveloper(Skill skill) {
        return checkSequences(skill);
    }

    private boolean checkSequences(Skill skill) {
        char[][] grid = convertToGrid(skill);
        return checkHorizontal(grid) || checkVertical(grid) || checkDiagonal(grid);
    }

    private char[][] convertToGrid(Skill skill) {
        List<String> skills = skill.getSkills();
        char[][] grid = new char[skills.size()][skills.get(0).length()];
        for (int i = 0; i < skills.size(); i++) {
            grid[i] = skills.get(i).toCharArray();
        }
        return grid;
    }

    private boolean checkHorizontal(char[][] grid) {
        for (char[] row : grid) {
            if (hasSequence(row)) return true;
        }
        return false;
    }

    private boolean checkVertical(char[][] grid) {
        for (int col = 0; col < grid[0].length; col++) {
            char[] column = new char[grid.length];
            for (int row = 0; row < grid.length; row++) {
                column[row] = grid[row][col];
            }
            if (hasSequence(column)) return true;
        }
        return false;
    }

    private boolean checkDiagonal(char[][] grid) {
        int n = grid.length;
        for (int row = 0; row <= n - SEQUENCE_LENGTH; row++) {
            for (int col = 0; col <= n - SEQUENCE_LENGTH; col++) {
                if (checkDiagonalMatch(grid, row, col, 1, 1) || checkDiagonalMatch(grid, row, col + SEQUENCE_LENGTH - 1, 1, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonalMatch(char[][] grid, int row, int col, int rowStep, int colStep) {
        char first = grid[row][col];
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (grid[row + i * rowStep][col + i * colStep] != first) {
                return false;
            }
        }
        return true;
    }

    private boolean hasSequence(char[] array) {
        for (int i = 0; i <= array.length - SEQUENCE_LENGTH; i++) {
            char first = array[i];
            if (first != ' ' && array[i + 1] == first && array[i + 2] == first && array[i + 3] == first) {
                return true;
            }
        }
        return false;
    }
}
