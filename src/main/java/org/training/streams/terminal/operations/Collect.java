package org.training.streams.terminal.operations;

import java.util.stream.Stream;

public class Collect {

    public static void main(String[] args){
        new Collect().collectWord();
    }

    public void collectWord(){
        StringBuilder word = Stream.of("ad", "jud", "i","cate")
                .collect(() -> new StringBuilder(),   // StringBuilder::new
                        (sb, str) -> sb.append(str),  // StringBuilder::append
                        (sb1, sb2) -> sb1.append(sb2)); // StringBuilder::append
        System.out.println(word); // adjudicate
    }
}
