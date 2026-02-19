package algoTemplates;

public class StringManipulationDemo {
    public static void main(String[] args) {
        // StringBuilder or StringBuffer for String Concatenation
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        String result = sb.toString();
        System.out.println("Concatenated String: " + result); // Output: Concatenated String: Hello World

        // Enhanced for Loop or StringBuilder for String Iteration
        String str = "Hello";
        System.out.print("Individual Characters: ");
        for (char c : str.toCharArray()) {
            System.out.print(c + " "); // Output: Individual Characters: H e l l o
        }
        System.out.println();

        // String Formatting
        String name = "Alice";
        int age = 30;
        String message = String.format("My name is %s and I'm %d years old.", name, age);
        System.out.println("Formatted Message: " + message); // Output: Formatted Message: My name is Alice and I'm 30 years old.

        // String Comparison using equals() method
        String str1 = "Hello";
        String str2 = "hello";
        if (str1.equalsIgnoreCase(str2)) {
            System.out.println("Strings are equal.");
        } else {
            System.out.println("Strings are not equal.");
        }

        // StringBuilder for String Modification
        StringBuilder modifiedStr = new StringBuilder("Hello World");
        modifiedStr.append("!");
        modifiedStr.insert(5, ",");
        modifiedStr.delete(5, 7);
        String modifiedResult = modifiedStr.toString();
        System.out.println("Modified String: " + modifiedResult); // Output: Modified String: Hello, World!

        // Remove Leading and Trailing Whitespaces
        String strWithWhitespaces = "   Hello World   ";
        String trimmedStr = strWithWhitespaces.trim();
        System.out.println("Trimmed String: " + trimmedStr); // Output: Trimmed String: Hello World

        // Split Strings
        String strToSplit = "Java is awesome";
        String[] parts = strToSplit.split(" ");
        System.out.println("Split Strings:");
        for (String part : parts) {
            System.out.println(part);
        }
        // Output:
        // Split Strings:
        // Java
        // is
        // awesome

        // Convert String to Upper or Lower Case
        String strToConvert = "Hello World";
        String upperCaseStr = strToConvert.toUpperCase();
        String lowerCaseStr = strToConvert.toLowerCase();
        System.out.println("Uppercase String: " + upperCaseStr); // Output: Uppercase String: HELLO WORLD
        System.out.println("Lowercase String: " + lowerCaseStr); // Output: Lowercase String: hello world

        // Check for Substring Existence
        String strToCheck = "Hello World";
        if (strToCheck.contains("World")) {
            System.out.println("Substring 'World' exists in the string.");
        } else {
            System.out.println("Substring 'World' does not exist in the string.");
        }

        // Replace Substrings
        String strToReplace = "Hello World";
        String replacedStr = strToReplace.replace("World", "Universe");
        System.out.println("Replaced String: " + replacedStr); // Output: Replaced String: Hello Universe

        // Compare Strings
        String str3 = "apple";
        String str4 = "banana";
        int comparisonResult = str3.compareTo(str4);
        if (comparisonResult < 0) {
            System.out.println("str3 is less than str4.");
        } else if (comparisonResult > 0) {
            System.out.println("str3 is greater than str4.");
        } else {
            System.out.println("str3 is equal to str4.");
        }

        // Convert Other Data Types to Strings
        int number = 42;
        String strNumber = String.valueOf(number);
        System.out.println("Converted Number to String: " + strNumber); // Output: Converted Number to String: 42
    }
}
