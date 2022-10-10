package addressbooksystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class AddressBook {
	 // class variables
    //patterns for differnt fields
    static String firstNamePattern = "^[a-zA-Z][a-zA-Z ]*$";
    static String lastNamePattern = "^[a-zA-Z][a-zA-Z ]*$";
    static String addressPattern = "^[a-zA-Z0-9-,. ]+$";
    static String cityPattern = "^[a-zA-Z][a-zA-Z ]*$";
    static String statePattern = "^[a-zA-Z][a-zA-Z ]*$";
    static String zipPattern = "^\\d{6}$";
    static String phoneNumberPattern = "^\\d{10}$";

    //scanner variable is declared as static to use throughout the program
    static final Scanner scanner = new Scanner(System.in);
    //contains set of contacts which are empty(contact created and no details added)
    static Set<String> emptyContacts = new HashSet<>();
    //contains set of contacts which are non empty(contact created and details added)
    static Set<String> nonEmptyContacts = new HashSet<>();
    
    static Set<String> contracts = new HashSet<>();

    // instance methods
    //creates empty contact
    void createNewContact() throws Exception 
    {
        System.out.print("Enter name of the contact:");
        String contactName = scanner.nextLine();
        File file = new File(contactName);
        if (file.exists()) 
        {
            System.out.println("contact " + file.getName() + " already exists!");
        } 
        else 
        {
            if (file.createNewFile()) 
            {
                System.out.println("new contact " + file.getName() + " is created successfully");
                emptyContacts.add(file.getName());
            } 
            else 
            {
                System.out.println("file creation failed!");
            }
        }

    }
    //writes given content into given file
    void writeFile(String fileName,String content)throws Exception
    {
        FileWriter fw = new FileWriter(fileName);
        fw.write(content);
        fw.close();
        nonEmptyContacts.add(fileName);
    }
   
    Boolean validate(String name, String regex) 
    {
        return Pattern.matches(regex, name);
    }

    String takeInput(String field, String pattern) 
    {
        String input;
        do 
        {
            System.out.print("enter " + field + ":");
            input = scanner.nextLine();
        } while (!validate(input, pattern));
        return input;
    }

    //given fields are added into contact
    void fillContactDetails()throws Exception
    {
        System.out.print("enter empty contact name which is going to be filed:");
        String contactName = scanner.nextLine();
        if (emptyContacts.contains(contactName)) 
        {
            String details = "";
            details += takeInput("first name", firstNamePattern) + "\n";
            details += takeInput("last name", lastNamePattern) + "\n";
            details += takeInput("address", addressPattern) + "\n";
            details += takeInput("city", cityPattern) + "\n";
            details += takeInput("state", statePattern) + "\n";
            details += takeInput("zip code", zipPattern) + "\n";
            details += takeInput("phone number", phoneNumberPattern) + "\n";
            writeFile(contactName, details);
            emptyContacts.remove(contactName);
            System.out.println("the given fields are successfully added in " + contactName);
        }
        else 
        {
            System.out.println(contactName + " is not empty contact or it is not created");
            System.out.println("use other option c to create new contact or option e to edit already created one");
        }

    }
    //displays list of empty contacts and non empty contacts
    void displayAllContacts() 
    {
        boolean flag = false;
        if (emptyContacts.size() != 0) 
        {
            System.out.println("the empty contacts are:");
            for (String contact : emptyContacts) 
            {
                System.out.println(contact);
            }
            flag=true;
        }
        if (nonEmptyContacts.size() != 0) 
        {
            System.out.println("the non empty contacts are:");
            for (String contact : nonEmptyContacts) 
            {
                System.out.println(contact);
            }
            flag=true;
        } 
        if(!flag)
        {
            System.out.println("no contacts are created yet");
        }

    }
    //prints the given file content
    void readFile(String fileName)throws Exception
    {
        FileReader fileReader = new FileReader(fileName);
        int character;
        while ((character = fileReader.read()) != -1) 
        {
            System.out.print((char) character);
        }
        fileReader.close();
    }
    //displays all fields in the given contact
    void viewContactInfo()throws Exception
    {
        System.out.print("enter name of the contact to view:");
        String contactName = scanner.nextLine();
        if(emptyContacts.contains(contactName))
        {
            System.out.println("pleast fill the contact "+ contactName+ " before viewing it");
            return;
        }
        else if(!nonEmptyContacts.contains(contactName))
        {
            System.out.println("please create the contact "+contactName+" before viewing it");
            return;
        }
        System.out.println("the content of " + contactName + " is:");
        readFile(contactName);
    }
    void editContactInfo()throws Exception
    {
        System.out.print("enter name of the contact to edit:");
        String contactName = scanner.nextLine();
        //if given file is empty
        if(emptyContacts.contains(contactName))
        {
            System.out.println(contactName + " is empty!");
            System.out.println("pleast fill the contact "+ contactName + " before editing it");
            return;
        }
        //if given file is non empty
        else if(!nonEmptyContacts.contains(contactName))
        {
            System.out.println(contactName + " does not exits!");
            System.out.println("please create the contact "+ contactName +" before editing it");
            return;
        }
        System.out.println("The content of " + contactName + " at present is:");
        //array to store lines in a file
        ArrayList<String> arrayList = new ArrayList<>();
        //each line is printed and added to the array list
        try (BufferedReader reader = new BufferedReader(new FileReader(contactName))) 
        {
            while (reader.ready()) 
            {
                String line = reader.readLine();
                System.out.println(line);
                arrayList.add(line);
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        System.out.println("select a field to edit");
        System.out.println("f for first name");
        System.out.println("l for last name");
        System.out.println("a for Address");
        System.out.println("c for city");
        System.out.println("s for state");
        System.out.println("z for zip");
        System.out.println("p for phonenumber");
        System.out.print("enter field to edit:");
        String choice = scanner.nextLine().trim().toLowerCase();
        int field = 0;
        String pattern;
        switch (choice) 
        {
            case "f":
                field = 0;
                pattern = firstNamePattern;
                break;
            case "l":
                field = 1;
                pattern = lastNamePattern;
                break;
            case "a":
                field = 2;
                pattern = addressPattern;
                break;
            case "c":
                field = 3;
                pattern = cityPattern;
                break;
            case "s":
                field = 4;
                pattern = statePattern;
                break;
            case "z":
                field = 4;
                pattern = zipPattern;
                break;
            case "p":
                field = 6;
                pattern = phoneNumberPattern;
                break;
            default:
                System.out.println("please enter field correctly");
                pattern = "";
                break;
        }
        String newData = takeInput("new data of the field", pattern);
        String newContent = "";
        for (int i = 0; i < arrayList.size(); i++) 
        {
            if (i == field) 
            {
                arrayList.add(i, newData);
            }
            newContent += arrayList.get(i) + "\n";
        }
        String option;
        do 
        {
            System.out.println("enter... S for SAVE     SA for SAVE AS      C for CANCEL");
            option = scanner.nextLine().trim().toLowerCase();

        } while (!(option.equals("s") || option.equals("sa")) || option.equals("c"));

        switch (option) 
        {
            // the field is updated in the same file
            case "s":
                writeFile(contactName, newContent);
                System.out.println(contactName + " is edited successfully");
                break;
            // the field is updated in givenfilenamewithoutextension.csv file
            case "sa":
                String extension = ".csv";
                String newContactName = contactName.replaceFirst("[.][^.]+$", "") + extension;
                writeFile(newContactName, newContent);
                nonEmptyContacts.add(newContactName);
                System.out.println("changes are saved successfully in " + newContactName + " file");
                break;
            case "c":
                System.out.println("changes are not saved");
                return;
            default:
                System.out.println("please select either S or SA or C");
                break;
        }
    }
    void deleteContact()
    {
        System.out.print("enter contact name to delete:");
        String contactName = scanner.nextLine().trim();
        File file = new File(contactName);
        if(file.exists())
        {
            if(file.delete())
            {
                if(emptyContacts.contains(contactName))
                {
                    emptyContacts.remove(contactName);
                }
                else
                {
                    nonEmptyContacts.remove(contactName);
                }
                System.out.println(contactName + " is deleted succesfully");
            }
            else
            {
                System.out.println("file deletion failed");
            }

        }
        else
        {
            System.out.println(contactName + "doesn't exists");
        }
    }

}


	 
	    