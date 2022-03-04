package itmo.coursework.repository;

import itmo.coursework.entity.FeedTypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedTypesRepository extends CrudRepository<FeedTypes, Integer> {
}
