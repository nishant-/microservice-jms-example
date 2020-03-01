package activemq.consumer.repository;

import activemq.consumer.model.MyPersistentMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDBRepository extends MongoRepository<MyPersistentMessage, String> {

}
