package kea.unicode.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Unicode {

    @Id
    private int unicodeId;
    private char bogstav;
    private String beskrivelse;

    public Unicode(int unicodeId, char bogstav, String beskrivelse) {
        this.unicodeId = unicodeId;
        this.bogstav = bogstav;
        this.beskrivelse = beskrivelse;
    }

    public Unicode() {
    }

    public int getUnicodeId() {
        return unicodeId;
    }

    public void setUnicodeId(int unicodeId) {
        this.unicodeId = unicodeId;
    }

    public char getBogstav() {
        return bogstav;
    }

    public void setBogstav(char bogstav) {
        this.bogstav = bogstav;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
}
