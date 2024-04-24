package com.dev.passwordgen.core.service;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.dev.passwordgen.core.dto.PasswordGeneratedDTO;

@Service
public class GenerateRulesService {
    PasswordGeneratedDTO passwordDto = new PasswordGeneratedDTO();

    public PasswordGeneratedDTO generatePassword(){
        passwordDto.setPassword(handleGenerate());
        return this.passwordDto;
    }

    public String handleGenerate(){
        String generatedString = 
        shuffle(
            getRandomSpecialCharacter() +
            getRandomSpecialCharacter() +
            alphaNumericGenerator(16) + 
            getRandomSpecialCharacter() +
            getRandomSpecialCharacter()
            );
        return generatedString;
    }

    public String alphaNumericGenerator(Integer charSize){
        String randomChar = RandomStringUtils.randomAlphanumeric(charSize);
        return randomChar;
    }
    
    public String getRandomSpecialCharacter() {
        String specialChars = ")(*&¨%$#@!";
        Random random = new Random();
        int randomIndex = random.nextInt(specialChars.length());
        return String.valueOf(specialChars.charAt(randomIndex));
    }

    public static String shuffle(String str) {
        // Converte a string para um array de caracteres
        char[] chars = str.toCharArray();
        
        // Embaralha o array de caracteres
        Random rand = new Random();
        for (int i = chars.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // Troca os caracteres nas posições i e j
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        
        // Converte o array de caracteres de volta para uma string
        return new String(chars);
    }
}
