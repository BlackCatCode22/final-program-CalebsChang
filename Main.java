 // JavaFinalProgramDemo01.java
// dH 10 Apr 23
//
// Sample code for Java Spring '23 final program
//
// Notes: This is a good  starting place for your final program, but a unique ID must be generated which starts with a
// two-character representation of species, e.g. Hy01, Li02, Ti01. Names must be found for your newly created animal
// from the animalNames.txt file (you may add names to the list). You must also create birthDate and location. Note the
// hardcoded values for these just to get this demo working with two class files, Animal.class and
// JavaFinalProgramDemo01.class.
//
//
import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

    public class Main {
        public static void main(String[] args) {
            // Create linked lists for each habitat
            String hyenaNames[] = {"Shenzi", "Banzai", "Ed", "Zig", "Bud", "Lou",
                    "Kamari", "Wema", "Nne", "Madoa", "Prince Nevarah"};
            String lionNames [] = {"Scar", "Mufasa", "Simba", "Kiara", "King",
                    "Drooper", "Kimba", "Nala", "Leo", "Samson", "Elsa", "Cecil"};
            String bearNames [] = {"Yogi", "Smokey", "Paddington", "Lippy", "Bungle",
                    "Baloo", "Rupert", "Winnie the Pooh", "Snuggles", "Bert"};
            String tigerNames[] = {"Tony", "Tigger","Amber","Cosimia","Cuddles",
                    "Dave", "Jiba", "Rajah", "Rayas", "Ryker"};

            LinkedList<Animal> hyenaHabitat = new LinkedList<>();
            LinkedList<Animal> lionHabitat = new LinkedList<>();
            LinkedList<Animal> tigerHabitat = new LinkedList<>();
            LinkedList<Animal> bearHabitat = new LinkedList<>();

            // Read input files and add animals to their respective habitats
            try {
                Scanner scanner = new Scanner(new File("arrivingAnimals.txt"));

                int numAnimals = 0;
                while (scanner.hasNextLine()) {
                    String[] line = scanner.nextLine().split(", ");
                    System.out.println("\n\n line = " + line);
                    //   int age = Integer.parseInt(line[0].split(" ")[0]);
                    int age = 99;
                    String species = line[0].split(" ")[4];
                    // output species
                    System.out.println("\n Species = " + species);
                    String birthSeason = line[1];
                    String color = line[2];
                    String gender = line[3];
                    //    int weight = Integer.parseInt(line[4].split(" ")[0]);
                    int weight = 9999;
                    String location = line[5];
                    String location02 = location + "02";
                    // Create a simple ID in the formal "An9"
                    String id = "An" + numAnimals;
                    String name = "unnamed";
                    String birthDate = birthSeason;
                    String origin = "0000";
                    String arrivalDate = "2003-01-05";
                    // Create a unique ID starting with a two-character representation of the species
                    String speciesCode = species.substring(0, 2).toLowerCase();
                    id = speciesCode + String.format("%02d", numAnimals);

                    switch (speciesCode) {
                        case "hy":
                            name = hyenaNames[numAnimals % hyenaNames.length];
                            break;
                        case "li":
                            name = lionNames[numAnimals % lionNames.length];
                            break;
                        case "ti":
                            name = tigerNames[numAnimals % tigerNames.length];
                            break;
                        case "be":
                            name = bearNames[numAnimals % bearNames.length];
                            break;
                    }


                    // Animal Constructor looks like this:
                    // public Animal(String id, String species, String name, int age, String birthDate, String color,
                    //  String gender, int weight, String origin, String arrivalDate


                    Animal animal = new Animal(id, species, name, age, birthDate, color, gender, weight, origin, arrivalDate);
                    switch (species)
                    {
                        case "hyena":
                            hyenaHabitat.add(animal);
                            break;
                        case "lion":
                            lionHabitat.add(animal);
                            break;
                        case "tiger":
                            tigerHabitat.add(animal);
                            break;
                        case "bear":
                            bearHabitat.add(animal);
                            break;
                    }
                    // Output the new animal...
                    System.out.println("\n new animal is: " + animal.toString());
                    System.out.println("\n" + animal.getId());
                    System.out.println("\n" + animal.getSpecies());
                    numAnimals++;
                }

                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Input file not found.");
            }

            // Output the hyena habitat.
            System.out.println("Hyena Habitat:\n");
            for (Animal animal : hyenaHabitat) {
                System.out.println(animal.toString());
                System.out.println("number of animals is: " + animal.getNumOfAnimals());
            }
            System.out.println("Lion Habitat:\n");
            for (Animal animal : lionHabitat)
            {
                System.out.println(animal.toString());
                System.out.println("number of animals is: " + animal.getNumOfAnimals());
            }
            System.out.println("Tiger Habitat:\n");
            for (Animal animal : tigerHabitat)
            {
                System.out.println(animal.toString());
                System.out.println("number of animals is: " + animal.getNumOfAnimals());
            }
            System.out.println("Bear Habitat:\n");
            for (Animal animal : bearHabitat)
            {
                System.out.println(animal.toString());
                System.out.println("number of animals is: " + animal.getNumOfAnimals());
            }


            // Create output file and write animal info for each habitat
            // Note the method "toString" -- you must override this in your Animal class or else you will see the object's
            //   name that looks something like: @1d56ce6a.
            try {
                PrintWriter writer = new PrintWriter(new File("habitatAnimalsFinalJava.txt"));

                // Hyena Habitat
                writer.println("Hyena Habitat:\n");
                for (Animal animal : hyenaHabitat) {
                    writer.println(animal.toString());
                }
                writer.println();

                // Lion Habitat
                writer.println("Lion Habitat:\n");
                for (Animal animal : lionHabitat) {
                    writer.println(animal.toString());
                }
                writer.println();

                // Tiger Habitat
                writer.println("Tiger Habitat:\n");
                for (Animal animal : tigerHabitat) {
                    writer.println(animal.toString());
                }
                writer.println();

                // Bear Habitat
                writer.println("Bear Habitat:\n");
                for (Animal animal : bearHabitat) {
                    writer.println(animal.toString());
                }
                writer.println();

                writer.close();
            } catch (FileNotFoundException e) {
                System.out.println("Output file not found.");
            }
        }
    }
