package com.apptivate.OptIn.Repos;

import com.apptivate.OptIn.Entities.trial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrialDao extends JpaRepository<trial,Long> {
}
