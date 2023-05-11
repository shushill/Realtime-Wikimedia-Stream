package sushil.kafka.consumer.repository;

import sushil.kafka.consumer.entity.WikiDatabase;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiRepository extends JpaRepository<WikiDatabase, Long> {
}
