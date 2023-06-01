import java.util.*;

public class Uzd3_1 {
    private Map<String, String> phoneBook;
    private String output;

    public Uzd3_1() {
        phoneBook = new HashMap<>();
        output = "";
    }

    public void processQueries() {
        Scanner scanner = new Scanner(System.in);
        int numQueries = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numQueries; i++) {
            String query = scanner.nextLine();
            String[] tokens = query.split("\\s+"); // atdala ievaditos datus pec atstarpes

            String command = tokens[0];
            String phoneNumber = tokens[1];

            if (command.equals("add")) {
                String name = tokens[2];  
                phoneBook.put(phoneNumber, name); // ieliekam vārdnīcā ierakstu
            } else if (command.equals("del")) {
                phoneBook.remove(phoneNumber); // izņēmam no vardnīcas numuru
            } else if (command.equals("find")) {
                String name = phoneBook.getOrDefault(phoneNumber, "not found"); // ja nesatrod numuru tad "not found"
                output += name + "\n"; // saglabājam rezultātu ar pārnesumu uz jauno rindu
            }
        }
        System.out.println();
        System.out.print(output);

        scanner.close();
    }

    public static void main(String[] args) {
        Uzd3_1 phoneBook = new Uzd3_1();
        phoneBook.processQueries();
    }
}
