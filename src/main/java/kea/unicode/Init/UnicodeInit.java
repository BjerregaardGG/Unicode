package kea.unicode.Init;

import kea.unicode.Model.Unicode;
import kea.unicode.Repository.Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.stream.events.Characters;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UnicodeInit implements CommandLineRunner {

    Repository repository;

    public UnicodeInit(Repository repository) {
        this.repository = repository;
    }

    // metode hvis man allerede har et foruddefineret Set med Char værdier (ellers løsning nedenfor)
    public void addUnicodeCharacters(Set<Character> characters) {
        for (Character c : characters) {
            int i = (int) c;
            Unicode unicode = new Unicode(i, c, "x");
            repository.save(unicode);
        }
    }

    @Override
    public void run(String... args) throws Exception {

        // set til at holde styr på unikke char-værdier
        Set<Character> charValues = new HashSet<>();

        //ittererer over unicode værdier og finder de respektive char værdier og gemmer i et set
        for(int i = 1 ; i <= 65000 ; i++ ){
            char c = (char) i;
            charValues.add(c);
        }

        // kunne også lave en @Transactional så den adder alt på en gang i stedet for et commit af gangen
        // ittererer over settet og finder unicode værdierne og gemmer i et objekt til databasen
        for(Character c : charValues){
            int i = (int) c;
            Unicode unicode = new Unicode(i, c, "x");
            repository.save(unicode);

            /* brug af map i stedet for for loop 
            List<Unicode> unicodeList = charValues.stream()
                    .map(c -> new Unicode((int) c, c, "x")) // Mapper Character til Unicode-objekt
                    .collect(Collectors.toList());
                    repository.saveAll(unicodeList);
             */
        }
    }
}
