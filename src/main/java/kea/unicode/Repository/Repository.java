package kea.unicode.Repository;

import kea.unicode.Model.Unicode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface Repository extends JpaRepository<Unicode, Integer> {

}
