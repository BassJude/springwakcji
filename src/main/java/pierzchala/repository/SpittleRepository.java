package pierzchala.repository;

import org.springframework.stereotype.Component;
import pierzchala.model.Spittle;

import java.util.List;

@Component
public interface SpittleRepository {

    List<Spittle> findSpittles(long max, int count);
}
