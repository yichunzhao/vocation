package dk.trifork.vocation.dao;

import dk.trifork.vocation.entities.Vocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VocationRepository extends JpaRepository<Vocation, UUID> {
}
