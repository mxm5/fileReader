import Model.Person;
import Service.PersonValidator;
import excptions.PersonIdInvalidException;
import excptions.PersonNameTooShortExcpetion;
import excptions.PersonPhoneInvalidException;
import excptions.PersonShouldNotBeUnderEighteenException;
import org.apache.commons.csv.*;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        try (Reader in = new FileReader("src/main/resources/persons.csv")) {

            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            List<Person> people = new ArrayList<>();
            PersonValidator personValidatior = new PersonValidator();

            for (CSVRecord record : records) {

                Person personRed = Person.fromRecord(record);

                try {
                    personValidatior.isValid(personRed);
                    people.add(personRed);
                } catch (PersonIdInvalidException e) {
                    System.out.println((e.getClass().getName()) + " : person id should be valid");

                } catch (PersonNameTooShortExcpetion e) {
                    System.out.println((e.getClass().getName()) + " : person name should not be to short");

                } catch (PersonPhoneInvalidException e) {
                    System.out.println((e.getClass().getName()) + " : person phone should be valid");

                } catch (PersonShouldNotBeUnderEighteenException e) {
                    System.out.println((e.getClass().getName()) + " : person should not be under 18");
                }
            }

            // Now 'people' contains the data from the CSV file

            people.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
