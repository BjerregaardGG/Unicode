package kea.unicode.Init;

import kea.unicode.Model.Unicode;
import kea.unicode.Repository.Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UnicodeInit implements CommandLineRunner {

    Repository repository;

    public UnicodeInit(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        // set til at holde styr på unikke char-værdier
        Set<Character> charValues = new HashSet<>();

        //ittererer over unicode værdier for små bogstaver og finde de respektive char værdier og gemmer i et set
        for(int i = 97 ; i <= 122 ; i++ ){
            char c = (char) i;
            charValues.add(c);
        }

        //ittererer over settet og finder unicode værdierne og gemmer i et objekt til databasen
        for(Character c : charValues){
            int i = (int) c;
            Unicode unicode = new Unicode(i, c, "x");
            repository.save(unicode);
        }

    }
}
