import org.apache.commons.csv.*;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static void main(String[] args) {
        try (Reader in = new FileReader("src/main/resources/persons.csv")) {

            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            List<Person> people = new ArrayList<>();
            PersonValidator personValidatior = new PersonValidator();

            for (CSVRecord record : records) {
                int id = Integer.parseInt(record.get("id"));
                String name = record.get("name");
                int age = Integer.parseInt(record.get("age"));
                String phone = record.get("phone");
                Person personRed = new Person(id, name, age,phone);
                personValidatior.isValid(personRed);
                people.add(personRed);
            }

            // Now 'people' contains the data from the CSV file

            people.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
