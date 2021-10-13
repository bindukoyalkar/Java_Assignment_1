package PathOfRegexFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;
public class PathOfFiles {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String regularExpression=sc.nextLine();
        Path path=Paths.get("/home/binduk");
        try(Stream<Path> subpath= Files.walk(path)){
            List<String> result=subpath.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());
            result.stream().filter(s->Pattern.matches(regularExpression , s)).forEach(System.out::println);
           // result.stream().filter(s->s.endsWith(".java")).forEach(System.out::println);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
