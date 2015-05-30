package lt.pap.dao;

import lt.pap.model.WPart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WPartRepository extends JpaRepository<WPart, Integer>
{
    
}
