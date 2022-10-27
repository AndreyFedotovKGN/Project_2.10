package pro.sky.course2.project_2_10.employeeService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.course2.project_2_10.exeption.FirstNameInputError;
import pro.sky.course2.project_2_10.exeption.LastNameInputError;

@Service
public class ValidatorService {

    public String validateFirstName(String firstName) {
        if (!StringUtils.isAlpha(firstName)) {
            throw new FirstNameInputError();
        }
        return StringUtils.capitalize(firstName.toLowerCase());
    }

    public String validateLastName(String lastName) {
        String[] lastNames = lastName.split("-");
        for (int i = 0; i < lastNames.length; i++) {
            String surName = lastNames[i];
            if (!StringUtils.isAlpha(surName)) {
                throw new LastNameInputError();
            }
            lastNames[i] = StringUtils.capitalize(surName.toLowerCase());
        }
        return String.join("-", lastNames);
    }
}
