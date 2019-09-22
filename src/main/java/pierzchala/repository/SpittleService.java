package pierzchala.repository;

import org.springframework.stereotype.Service;
import pierzchala.model.Spittle;

import java.util.List;

@Service
public class SpittleService implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }
}
