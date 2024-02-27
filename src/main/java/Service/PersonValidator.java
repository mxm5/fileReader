package Service;

import Model.Person;
import excptions.PersonIdInvalidException;
import excptions.PersonNameTooShortExcpetion;
import excptions.PersonPhoneInvalidException;
import excptions.PersonShouldNotBeUnderEighteenException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonValidator {


    private final String phoneValidationRegex = "^\\+989\\d{9}$";
    private final Pattern phoneValidationPattern = Pattern.compile(phoneValidationRegex);


    public void isValid(Person personRed) throws RuntimeException {


        checkPersonIsUnderEighteen(personRed);

        checkPersonNameIsTooShort(personRed);

        checkPersonIdNumberIsValid(personRed);

        checkPersonPhoneNumberIsValid(personRed);

    }

    private void checkPersonPhoneNumberIsValid(Person personRed) throws PersonPhoneInvalidException {
        Matcher matcher = phoneValidationPattern.matcher(personRed.getPhone());
        boolean matches = matcher.matches();
        if (!matches) throw new PersonPhoneInvalidException();

    }

    private void checkPersonIdNumberIsValid(Person personRed) throws PersonIdInvalidException {
        if (personRed.getId() < 0) throw new PersonIdInvalidException();
    }

    private void checkPersonNameIsTooShort(Person personRed) throws PersonNameTooShortExcpetion {
        if (personRed.getName().length() < 2) throw new PersonNameTooShortExcpetion();
    }

    private void checkPersonIsUnderEighteen(Person personRed) throws PersonShouldNotBeUnderEighteenException {
        if (personRed.getAge() < 18) throw new PersonShouldNotBeUnderEighteenException();
    }


}
