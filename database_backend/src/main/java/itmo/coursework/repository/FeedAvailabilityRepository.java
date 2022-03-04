package itmo.coursework.repository;

import itmo.coursework.entity.FeedAvailability;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedAvailabilityRepository extends CrudRepository<FeedAvailability, Integer> {
}
