package kea.unicode.Controller;

import kea.unicode.Model.Unicode;
import kea.unicode.Repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    Repository repository;

    public RestController(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/unicode/{i}")
    public String unicodeToChar(@PathVariable int i) {
        char c = (char) i;
        return "unicode=" + i + " char=" + c;
    }

    @GetMapping("/char/{c}")
    public String charToUnicode(@PathVariable char c) {
        int i = (int) c;
        return "char=" + c + " unicode=" + i;
    }

    @GetMapping("/getAll")
    public List<Unicode> getAll() {
        return repository.findAll();
    }

    @PostMapping("/description/{unicodeId}")
    public void editDescription(@PathVariable Integer unicodeId, @RequestBody Unicode unicode ) {
        Unicode uni = repository.findById(unicodeId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        uni.setBeskrivelse(unicode.getBeskrivelse());
        repository.save(unicode);
    }

}
