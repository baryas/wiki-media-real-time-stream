package org.eservice.repository;

import org.eservice.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KafkaConsumerRepository extends
        JpaRepository<WikimediaData,Long> {

}
