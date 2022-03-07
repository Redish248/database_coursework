package itmo.coursework.repository;

import itmo.coursework.entity.Feed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedRepository extends CrudRepository<Feed, Long> {
    Feed findFeedByUid(long uid);

    //TODO: may be regex
    List<Feed> findFeedsByName(String name);
}
