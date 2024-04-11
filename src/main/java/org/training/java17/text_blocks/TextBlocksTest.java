package org.training.java17.text_blocks;

public class TextBlocksTest {

    public static void textBlocks(){
        // 1. A text block is a String object (immutable and interned)
//        String sName = "Luis Enrique";
//        String tbName = """
//                Luis Enrique"""; // no newline embedded at end
//        System.out.println(sName.equals(tbName));
//        System.out.println(sName == tbName);

        // 2. String method can be applied to text blocks
        //System.out.println(tbName.substring(5)); // Enrique

        // 3. Text blocks start with """ followed by a line terminator
        //String tb1 = """abc""";
        //String tb2 = """abc
        //        """;
        /*String tb3 = """
                abc
                """;
        System.out.println(tb3);*/

        // 4. Embedded double quotes are not required in text blocks
        String sQuote = "Hamlet: \"Thre is nothing either good or bad, " +
                "but thinking makes it so\""; // on one line

        // 5. Depending on where you place the closing delimiter, determines wheter or not have a closing "\n".
        String sBookTittle1 = "Java\nMemory\nManagement\n"; // newline at end
        String tbBookTittle1 = """
                Java
                Memory
                Management
                """; // same as "Java\nMemory\Management\n"; // newline at end
        System.out.println(sBookTittle1);
        System.out.println(123);
        System.out.println(tbBookTittle1);
        System.out.println(123);

        String sBookTittle2 = "Java\nMemory\nManagement"; // No newline at end
        String tbBookTittle2 = """
                Java
                Memory
                Management"""; // same as "Java\nMemory\nManagement"; // No newline at end
        System.out.println(sBookTittle2);
        System.out.println(123);
        System.out.println(tbBookTittle2);
        System.out.println(sBookTittle2);
    }

    public static void jsonTraditionalStyle(){
        String text = "{\n" +
                "  \"name\": \"Jane Doe\",\n" +
                "  \"age\": 23,\n" +
                "  \"address\": \"Main Street, Dublin\"\n" +
                "}";
        System.out.println(text);
        System.out.println(123);
    }

    public static void jsonTextBlock(){
        String text = """
            {
              "name": "Luis Enrique",
              "age": 23,
              "address": "Main Street, Dublin"
            }"""; // to remove incidental spaces, put delimiter on its own line
        System.out.println(text);
    }

    public static void main(String[] args){
        textBlocks();
        jsonTraditionalStyle();
        jsonTextBlock();
    }
}
